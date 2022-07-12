package com.farsunset.cim.sdk.android;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.farsunset.cim.sdk.android.model.Pong;
import com.farsunset.cim.sdk.android.model.SentBody;

import java.util.concurrent.atomic.AtomicBoolean;

public class CIMPushService
        extends Service {
    private g a;
    private d b;
    private ConnectivityManager c;
    private NotificationManager d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final ConnectivityManager.NetworkCallback f = new a();
    private final Handler g = new b();
    private final Handler h = new c();

    private void d() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (this.d.getNotificationChannel("CIM_PUSH_TRANSIENT_NTC_ID") == null) {
            NotificationChannel localNotificationChannel = new NotificationChannel("CIM_PUSH_TRANSIENT_NTC_ID", getClass().getSimpleName(), 2);
            localNotificationChannel.enableLights(false);
            localNotificationChannel.enableVibration(false);
            localNotificationChannel.setSound(null, null);
            this.d.createNotificationChannel(localNotificationChannel);
        }
        startForeground(2147483647, new Notification.Builder(this, "CIM_PUSH_TRANSIENT_NTC_ID").setContentTitle(CIMPushService.class.getSimpleName()).build());
    }

    private void e(String paramString1, String paramString2, int paramInt) {
        int i = Build.VERSION.SDK_INT;
        Object localObject;
        if ((i >= 26) && (this.d.getNotificationChannel("CIM_PUSH_PERSIST_NTC_ID") == null)) {
            localObject = new NotificationChannel("CIM_PUSH_PERSIST_NTC_ID", paramString1, 3);
            ((NotificationChannel) localObject).enableLights(false);
            ((NotificationChannel) localObject).setShowBadge(false);
            ((NotificationChannel) localObject).enableVibration(false);
            ((NotificationChannel) localObject).setSound(null, null);
            this.d.createNotificationChannel((NotificationChannel) localObject);
        }
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addFlags(4194304);
        localIntent.setPackage(getPackageName());
        if (i >= 26) {
            localObject = new Notification.Builder(this, "CIM_PUSH_PERSIST_NTC_ID");
        } else {
            localObject = new Notification.Builder(this);
        }
        ((Notification.Builder) localObject).setAutoCancel(false).setOngoing(false).setSmallIcon(paramInt).setWhen(System.currentTimeMillis()).setContentIntent(PendingIntent.getActivity(this, 0, localIntent, 67108864)).setContentTitle(paramString1).setContentText(paramString2);
        startForeground(-2147483648, ((Notification.Builder) localObject).build());
    }

    private void f() {
        b3.a.d().b(true, h.n(this), h.l(this));
        if (this.a.o()) {
            this.a.z();
            return;
        }
        g();
    }

    private void g() {
        if (!h.l(this)) {
            if (h.n(this)) {
                return;
            }
            String str1 = a.d(this, "KEY_CIM_SERVER_HOST");
            int i = a.c(this, "KEY_CIM_SERVER_PORT");
            if ((str1 != null) && (str1.trim().length() != 0) && (i > 0)) {
                this.a.i(str1, i);
                return;
            }
            String str2 = getClass().getSimpleName();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Invalid hostname or port. host:");
            localStringBuilder.append(str1);
            localStringBuilder.append(" port:");
            localStringBuilder.append(i);
            Log.e(str2, localStringBuilder.toString());
        }
    }

    private void h(long paramLong) {
        if (paramLong <= 0L) {
            g();
            return;
        }
        this.g.removeMessages(0);
        this.g.sendEmptyMessageDelayed(0, paramLong);
    }

    private void i() {
        this.g.removeMessages(0);
        stopForeground(true);
        this.e.set(false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            unregisterReceiver(this.b);
        }
        if (i >= 24) {
            this.c.unregisterNetworkCallback(this.f);
        }
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onCreate() {
        this.a = g.j(getApplicationContext());
        this.d = ((NotificationManager) getSystemService("notification"));
        int i = Build.VERSION.SDK_INT;
        Object localObject;
        if (i >= 26) {
            localObject = new d(null);
            this.b = ((d) localObject);
            registerReceiver((BroadcastReceiver) localObject, ((d) localObject).a());
        }
        if (i >= 24) {
            localObject = (ConnectivityManager) getSystemService(ConnectivityManager.class);
            this.c = ((ConnectivityManager) localObject);
            ((ConnectivityManager) localObject).registerDefaultNetworkCallback(this.f);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        i();
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        String str;
        if (paramIntent == null) {
            str = "ACTION_ACTIVATE_PUSH_SERVICE";
        } else {
            str = paramIntent.getAction();
        }
        if (!this.e.get()) {
            d();
        }
        if ("ACTION_CREATE_CIM_CONNECTION".equals(str)) {
            h(paramIntent.getLongExtra("KEY_DELAYED_TIME", 0L));
        }
        if ("ACTION_SEND_REQUEST_BODY".equals(str)) {
            this.a.y((SentBody) paramIntent.getSerializableExtra("KEY_SEND_BODY"));
        }
        if ("ACTION_CLOSE_CIM_CONNECTION".equals(str)) {
            this.a.g();
        }
        if ("ACTION_ACTIVATE_PUSH_SERVICE".equals(str)) {
            f();
        }
        if ("ACTION_DESTROY_CIM_SERVICE".equals(str)) {
            this.a.g();
            stopSelf();
        }
        if ("ACTION_CIM_CONNECTION_PONG".equals(str)) {
            this.a.y(Pong.getInstance());
        }
        if ("ACTION_SET_LOGGER_EATABLE".equals(str)) {
            boolean bool = paramIntent.getBooleanExtra("KEY_LOGGER_ENABLE", true);
            b3.a.d().c(bool);
        }
        if ("ACTION_SHOW_PERSIST_NOTIFICATION".equals(str)) {
            e(paramIntent.getStringExtra("KEY_NOTIFICATION_CHANNEL"), paramIntent.getStringExtra("KEY_NOTIFICATION_MESSAGE"), paramIntent.getIntExtra("KEY_NOTIFICATION_ICON", 0));
            this.e.set(true);
        }
        if ("ACTION_HIDE_PERSIST_NOTIFICATION".equals(str)) {
            stopForeground(true);
            this.e.set(false);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.h.sendEmptyMessageDelayed(0, 200L);
        }
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }

    class a
            extends ConnectivityManager.NetworkCallback {
        a() {
        }

        public void onAvailable(Network paramNetwork) {
            paramNetwork = new Intent();
            paramNetwork.setPackage(CIMPushService.this.getPackageName());
            paramNetwork.setAction("com.farsunset.cim.NETWORK_CHANGED");
            CIMPushService.this.sendBroadcast(paramNetwork);
        }

        public void onLost(Network paramNetwork) {
            paramNetwork = new Intent();
            paramNetwork.setPackage(CIMPushService.this.getPackageName());
            paramNetwork.setAction("com.farsunset.cim.NETWORK_CHANGED");
            CIMPushService.this.sendBroadcast(paramNetwork);
        }
    }

    class b
            extends Handler {
        b() {
        }

        public void handleMessage(Message paramMessage) {
            CIMPushService.a(CIMPushService.this);
        }
    }

    class c
            extends Handler {
        c() {
        }

        public void handleMessage(Message paramMessage) {
            if (CIMPushService.b(CIMPushService.this).get()) {
                return;
            }
            CIMPushService.this.stopForeground(true);
        }
    }

    private class d
            extends BroadcastReceiver {
        private d() {
        }

        public IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            localIntentFilter.addAction("android.intent.action.USER_PRESENT");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            CIMPushService.c(CIMPushService.this);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.cim.sdk.android.CIMPushService

 * JD-Core Version:    0.7.0.1

 */