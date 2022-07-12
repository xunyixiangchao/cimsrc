package com.farsunset.hoxin;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.view.View;

import androidx.core.app.k;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.common.database.base.PrivateRoomDatabase;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.receiver.LocationReceiver;
import com.farsunset.hoxin.common.ui.PhotoGalleryActivity;
import com.farsunset.hoxin.common.ui.PhotoScreenActivity;
import com.farsunset.hoxin.common.ui.VideoPlayerActivity;
import com.farsunset.hoxin.home.service.ApkDownloaderService;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.ui.GroupCallingActivity;
import com.farsunset.hoxin.webrtc.ui.GroupIncomingActivity;
import com.farsunset.hoxin.webrtc.ui.VideoCallingActivity;
import com.farsunset.hoxin.webrtc.ui.VideoIncomingCallActivity;
import com.farsunset.hoxin.webrtc.ui.VoiceCallingActivity;
import com.farsunset.hoxin.webrtc.ui.VoiceIncomingCallActivity;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;

import i3.e;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import u3.a0;
import u3.l;
import u3.r;
import u3.s;

public class HoxinApplication
        extends Application
        implements Application.ActivityLifecycleCallbacks {
    private static HoxinApplication d;
    private final Stack<Activity> a = new Stack();
    private final AtomicInteger b = new AtomicInteger();
    private final LocationReceiver c = new LocationReceiver();

    private void B(Context paramContext, View paramView, Intent paramIntent) {
        if ((paramContext instanceof Activity)) {
            paramView = ActivityOptions.makeSceneTransitionAnimation((Activity) paramContext, paramView, "imageSenseView").toBundle();
        } else {
            paramView = null;
        }
        androidx.core.content.b.j(paramContext, paramIntent, paramView);
    }

    public static void D(BroadcastReceiver paramBroadcastReceiver) {
        k1.a.b(h()).e(paramBroadcastReceiver);
    }

    private void c(Context paramContext) {
        if (!k.e(this).a()) {
            y4.a.p(paramContext).show();
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager localNotificationManager = (NotificationManager) androidx.core.content.b.h(this, NotificationManager.class);
        NotificationChannel localNotificationChannel;
        AudioAttributes localAudioAttributes;
        if (localNotificationManager.getNotificationChannel("NEW_MESSAGE_NOTIFICATION") == null) {
            localNotificationChannel = new NotificationChannel("NEW_MESSAGE_NOTIFICATION", o3.a.a, 3);
            localNotificationChannel.setShowBadge(true);
            localNotificationChannel.enableLights(true);
            localAudioAttributes = new AudioAttributes.Builder().setContentType(2).build();
            localNotificationChannel.setSound(RingtoneManager.getDefaultUri(2), localAudioAttributes);
            localNotificationChannel.setLightColor(-16711936);
            localNotificationManager.createNotificationChannel(localNotificationChannel);
        }
        if (localNotificationManager.getNotificationChannel("IMPORTANCE_HIGH_NOTIFICATION") == null) {
            localNotificationChannel = new NotificationChannel("IMPORTANCE_HIGH_NOTIFICATION", o3.a.b, 4);
            localNotificationChannel.setShowBadge(true);
            localNotificationChannel.enableLights(true);
            localAudioAttributes = new AudioAttributes.Builder().setContentType(2).build();
            localNotificationChannel.setSound(RingtoneManager.getDefaultUri(2), localAudioAttributes);
            localNotificationChannel.setLightColor(-16711936);
            localNotificationManager.createNotificationChannel(localNotificationChannel);
        }
        if (localNotificationManager.getNotificationChannel("REALTIME_CALL_NOTIFICATION") == null) {
            localNotificationChannel = new NotificationChannel("REALTIME_CALL_NOTIFICATION", o3.a.d, 3);
            localNotificationChannel.setSound(null, null);
            localNotificationChannel.setShowBadge(false);
            localNotificationChannel.enableLights(false);
            localNotificationManager.createNotificationChannel(localNotificationChannel);
        }
        if (localNotificationManager.getNotificationChannel("REALTIME_CALL_INCOMING_NOTIFICATION") == null) {
            localNotificationChannel = new NotificationChannel("REALTIME_CALL_INCOMING_NOTIFICATION", o3.a.e, 4);
            localNotificationChannel.setSound(null, null);
            localNotificationChannel.setLockscreenVisibility(1);
            localNotificationChannel.setShowBadge(false);
            localNotificationChannel.enableLights(true);
            localNotificationManager.createNotificationChannel(localNotificationChannel);
        }
    }

    public static HoxinApplication h() {
        return d;
    }

    /* Error */
    private static String i(int paramInt) {
        // Byte code:
        //   0: new 176	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 177	java/lang/StringBuilder:<init>	()V
        //   7: astore_1
        //   8: aload_1
        //   9: ldc 179
        //   11: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: pop
        //   15: aload_1
        //   16: iload_0
        //   17: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   20: pop
        //   21: aload_1
        //   22: ldc 188
        //   24: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   27: pop
        //   28: new 190	java/io/BufferedReader
        //   31: dup
        //   32: new 192	java/io/FileReader
        //   35: dup
        //   36: aload_1
        //   37: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   40: invokespecial 199	java/io/FileReader:<init>	(Ljava/lang/String;)V
        //   43: invokespecial 202	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   46: astore_2
        //   47: aload_2
        //   48: invokevirtual 205	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   51: astore_3
        //   52: aload_3
        //   53: astore_1
        //   54: aload_3
        //   55: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   58: ifne +8 -> 66
        //   61: aload_3
        //   62: invokevirtual 216	java/lang/String:trim	()Ljava/lang/String;
        //   65: astore_1
        //   66: aload_2
        //   67: invokestatic 220	ca/c:d	(Ljava/io/Reader;)V
        //   70: aload_1
        //   71: areturn
        //   72: astore_3
        //   73: aload_2
        //   74: astore_1
        //   75: aload_3
        //   76: astore_2
        //   77: goto +6 -> 83
        //   80: astore_2
        //   81: aconst_null
        //   82: astore_1
        //   83: aload_2
        //   84: invokevirtual 225	java/lang/Throwable:printStackTrace	()V
        //   87: aload_1
        //   88: invokestatic 220	ca/c:d	(Ljava/io/Reader;)V
        //   91: aconst_null
        //   92: areturn
        //   93: astore_2
        //   94: aload_1
        //   95: invokestatic 220	ca/c:d	(Ljava/io/Reader;)V
        //   98: aload_2
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	paramInt	int
        //   7	88	1	localObject1	Object
        //   46	31	2	localObject2	Object
        //   80	4	2	localObject3	Object
        //   93	6	2	localObject4	Object
        //   51	11	3	str	String
        //   72	4	3	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   47	52	72	finally
        //   54	66	72	finally
        //   0	47	80	finally
        //   83	87	93	finally
    }

    private void k(boolean paramBoolean) {
        CrashReport.UserStrategy localUserStrategy = new CrashReport.UserStrategy(this);
        localUserStrategy.setUploadProcess(paramBoolean);
        CrashReport.initCrashReport(getApplicationContext(), "90eccc85e0", false, localUserStrategy);
        if (e.p()) {
            CrashReport.setUserId(e.o().toString());
        }
    }

    private void l() {
        if (e.q()) {
            PrivateRoomDatabase.N(e.o().longValue());
        }
    }

    private boolean o() {
        String str = i(Process.myPid());
        return (str == null) || (getPackageName().equals(str));
    }

    public static void p(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
        k1.a.b(h()).c(paramBroadcastReceiver, paramIntentFilter);
    }

    public static void q(BroadcastReceiver paramBroadcastReceiver, String paramString) {
        k1.a.b(h()).c(paramBroadcastReceiver, new IntentFilter(paramString));
    }

    public static void s(Intent paramIntent) {
        paramIntent.setPackage(h().getPackageName());
        h().sendBroadcast(paramIntent);
    }

    public static void t(Intent paramIntent) {
        k1.a.b(h()).d(paramIntent);
    }

    public void A(AvRoom paramAvRoom) {
        if ((!m(VideoCallingActivity.class)) && (!m(VoiceIncomingCallActivity.class)) && (!m(GroupIncomingActivity.class)) && (!m(GroupCallingActivity.class)) && (!m(VoiceCallingActivity.class)) && (!m(VideoIncomingCallActivity.class))) {
            Intent localIntent = new Intent(this, GroupCallingActivity.class);
            localIntent.addFlags(268435456);
            localIntent.putExtra(AvRoom.class.getName(), paramAvRoom);
            startActivity(localIntent);
            return;
        }
        l.z0(this, 2131690105);
    }

    public void C(Context paramContext, CloudVideo paramCloudVideo, View paramView) {
        Intent localIntent = new Intent(paramContext, VideoPlayerActivity.class);
        localIntent.putExtra(CloudVideo.class.getName(), paramCloudVideo);
        androidx.core.content.b.j(paramContext, localIntent, ActivityOptions.makeSceneTransitionAnimation((Activity) paramContext, paramView, "imageSenseView").toBundle());
    }

    public void a() {
        Intent localIntent = new Intent(this, ApkDownloaderService.class);
        localIntent.setAction("ACTION_CHECK_APP_VERSION");
        startService(localIntent);
    }

    public void b() {
        Intent localIntent = new Intent(this, ApkDownloaderService.class);
        localIntent.setAction("ACTION_CHECK_APP_VERSION_QUIETLY");
        startService(localIntent);
    }

    public void d() {
        h.e(this, "api.hoxin.farsunset.com", c3.a.a.intValue());
    }

    public void f(Class<? extends Activity> paramClass) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            Activity localActivity = (Activity) localIterator.next();
            if (localActivity.getClass() == paramClass) {
                localActivity.finish();
            }
        }
    }

    public void g() {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((Activity) localIterator.next()).finish();
        }
    }

    public void j(Context paramContext) {
        e.x(0);
        e();
        h.s(this, false);
        String[] arrayOfString = new String[5];
        arrayOfString[0] = "android.permission.CAMERA";
        arrayOfString[1] = "android.permission.ACCESS_FINE_LOCATION";
        arrayOfString[2] = "android.permission.RECORD_AUDIO";
        arrayOfString[3] = "android.permission.READ_EXTERNAL_STORAGE";
        arrayOfString[4] = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (!c8.b.i(paramContext, arrayOfString)) {
            androidx.core.app.a.o((Activity) paramContext, arrayOfString, 0);
        }
        c(paramContext);
    }

    public boolean m(Class<? extends Activity> paramClass) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            if (((Activity) localIterator.next()).getClass() == paramClass) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        return this.b.get() == 0;
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
        this.a.add(paramActivity);
    }

    public void onActivityDestroyed(Activity paramActivity) {
        this.a.remove(paramActivity);
        if (paramActivity.getClass() == HomeActivity.class) {
            D(this.c);
        }
    }

    public void onActivityPaused(Activity paramActivity) {
    }

    public void onActivityResumed(Activity paramActivity) {
        this.a.remove(paramActivity);
        this.a.add(paramActivity);
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityStarted(Activity paramActivity) {
        this.b.getAndIncrement();
    }

    public void onActivityStopped(Activity paramActivity) {
        this.b.decrementAndGet();
    }

    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        d = this;
        SDKInitializer.setAgreePrivacy(this, true);
        LocationClient.setAgreePrivacy(true);
        SDKInitializer.initialize(this);
        boolean bool = o();
        k(o());
        if (bool) {
            a0.a();
            l();
        }
        androidx.appcompat.app.d.H(u3.d.m());
    }

    public void onTrimMemory(int paramInt) {
        super.onTrimMemory(paramInt);
        if (paramInt >= 20) {
            s.a().a();
        }
    }

    public void r() {
        g();
        Intent localIntent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        localIntent.addFlags(67108864);
        startActivity(localIntent);
    }

    public void startActivity(Intent paramIntent) {
        try {
            super.startActivity(paramIntent);
            return;
        } catch (Exception paramIntent) {
            paramIntent.printStackTrace();
        }
    }

    public void u(ChatSession paramChatSession) {
        Intent localIntent = new Intent(this, VoiceCallingActivity.class);
        if (m(VideoIncomingCallActivity.class)) {
            localIntent.setClass(this, VideoIncomingCallActivity.class);
        }
        if (m(VideoCallingActivity.class)) {
            localIntent.setClass(this, VideoCallingActivity.class);
        }
        if (m(VoiceIncomingCallActivity.class)) {
            localIntent.setClass(this, VoiceIncomingCallActivity.class);
        }
        if (m(VideoIncomingCallActivity.class)) {
            localIntent.setClass(this, VideoIncomingCallActivity.class);
        }
        localIntent.addFlags(268435456);
        localIntent.putExtra("ATTR_CHAT_SESSION", paramChatSession);
        startActivity(localIntent);
    }

    public void v(ChatSession paramChatSession) {
        Intent localIntent = new Intent(this, VideoCallingActivity.class);
        if (m(VideoIncomingCallActivity.class)) {
            localIntent.setClass(this, VideoIncomingCallActivity.class);
        }
        if (m(VoiceCallingActivity.class)) {
            localIntent.setClass(this, VoiceCallingActivity.class);
        }
        if (m(VoiceIncomingCallActivity.class)) {
            localIntent.setClass(this, VoiceIncomingCallActivity.class);
        }
        if (m(VideoIncomingCallActivity.class)) {
            localIntent.setClass(this, VideoIncomingCallActivity.class);
        }
        localIntent.putExtra("ATTR_CHAT_SESSION", paramChatSession);
        localIntent.addFlags(268435456);
        startActivity(localIntent);
    }

    public void w(String paramString, File paramFile) {
        Intent localIntent = new Intent(this, ApkDownloaderService.class);
        localIntent.setAction("ACTION_DOWNLOAD_APK_FILE");
        localIntent.putExtra("ATTR_URL", paramString);
        localIntent.putExtra("ATTR_FILE", paramFile);
        startService(localIntent);
    }

    public void x(Context paramContext, List<? extends CloudImage> paramList, int paramInt, View paramView) {
        Intent localIntent = new Intent(paramContext, PhotoGalleryActivity.class);
        localIntent.putExtra(CloudImage.class.getName(), (Serializable) paramList);
        localIntent.putExtra("ATTR_INDEX", paramInt);
        if ((paramContext instanceof Activity)) {
            paramList = l.w((CloudImage) paramList.get(paramInt));
            paramList = androidx.core.app.b.a((Activity) paramContext, new x0.d[]{new x0.d(paramView, paramList)}).b();
        } else {
            paramList = null;
        }
        androidx.core.content.b.j(paramContext, localIntent, paramList);
    }

    public void y() {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.c, localIntentFilter);
    }

    public void z(Context paramContext, CloudImage paramCloudImage, View paramView) {
        Intent localIntent = new Intent(paramContext, PhotoScreenActivity.class);
        localIntent.putExtra(CloudImage.class.getName(), paramCloudImage);
        B(paramContext, paramView, localIntent);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.HoxinApplication

 * JD-Core Version:    0.7.0.1

 */