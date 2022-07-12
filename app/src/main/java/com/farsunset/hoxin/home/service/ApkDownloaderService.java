package com.farsunset.hoxin.home.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;

import androidx.core.app.h;

import com.farsunset.hoxin.common.api.response.AppVersionResult;
import com.farsunset.hoxin.home.model.AppVersion;
import com.farsunset.hoxin.home.ui.AppNewVersionActivity;

import java.io.File;
import java.util.Objects;

import s3.e;
import s3.f;
import u3.l;
import u3.z;

public class ApkDownloaderService
        extends Service
        implements f, e<AppVersionResult> {
    private final int a = 2462;
    private NotificationManager b;
    private String c;
    private h d;
    private String e;

    private String a() {
        if (Build.VERSION.SDK_INT < 26) {
            return "APP_DOWNLOAD_NOTIFICATION";
        }
        if (this.b.getNotificationChannel("APP_DOWNLOAD_NOTIFICATION") != null) {
            return "APP_DOWNLOAD_NOTIFICATION";
        }
        NotificationChannel localNotificationChannel = new NotificationChannel("APP_DOWNLOAD_NOTIFICATION", o3.a.c, 3);
        localNotificationChannel.setSound(null, null);
        this.b.createNotificationChannel(localNotificationChannel);
        return localNotificationChannel.getId();
    }

    private void b(File paramFile) {
        this.b.cancel(2462);
        c8.b.k(this).a().a(paramFile).start();
    }

    public void O(File paramFile, String paramString) {
        paramString = new Intent(this, getClass());
        paramString.setAction("ACTION_DOWNLOAD_APK_FILE");
        paramString.putExtra("ATTR_URL", this.c);
        paramString.putExtra("ATTR_FILE", paramFile);
        paramFile = PendingIntent.getService(this, 1, paramString, 201326592);
        this.d.o(getString(2131690139));
        this.d.g(getString(2131690139));
        this.d.f(paramFile);
        this.b.notify(2462, this.d.a());
    }

    public void c(AppVersionResult paramAppVersionResult) {
        paramAppVersionResult = paramAppVersionResult.data;
        if (((paramAppVersionResult == null) || (paramAppVersionResult.versionCode <= 330)) && (Objects.equals(this.e, "ACTION_CHECK_APP_VERSION"))) {
            l.z0(getApplicationContext(), 2131689809);
        }
        if ((paramAppVersionResult != null) && (paramAppVersionResult.versionCode > 330)) {
            Intent localIntent = new Intent(this, AppNewVersionActivity.class);
            localIntent.putExtra(AppVersion.class.getName(), paramAppVersionResult);
            localIntent.addFlags(268435456);
            startActivity(localIntent);
        }
    }

    public void o0(File paramFile, String paramString) {
        b(paramFile);
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.b = ((NotificationManager) androidx.core.content.b.h(this, NotificationManager.class));
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.cancel(2462);
    }

    public void onHttpException(Exception paramException) {
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        if ("ACTION_DOWNLOAD_APK_FILE".equals(paramIntent.getAction())) {
            this.c = paramIntent.getStringExtra("ATTR_URL");
            File localFile = (File) paramIntent.getSerializableExtra("ATTR_FILE");
            PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 1, new Intent(), 201326592);
            if (this.d == null) {
                h localh = new h(this, a());
                this.d = localh;
                localh.e(false);
                this.d.k(true);
                this.d.n(2131165623);
                this.d.f(localPendingIntent);
                this.d.m(100, 0, false);
                this.d.l(1);
            }
            this.d.h(getString(2131690140));
            this.d.g(getString(2131690141, new Object[]{Integer.valueOf(0)}));
            this.d.o(getString(2131690137));
            z.f(localFile, this.c, this);
            this.b.notify(2462, this.d.a());
        }
        if (("ACTION_CHECK_APP_VERSION".equals(paramIntent.getAction())) || ("ACTION_CHECK_APP_VERSION_QUIETLY".equals(paramIntent.getAction()))) {
            this.e = paramIntent.getAction();
            l3.a.b(this);
        }
        return 3;
    }

    public void z0(String paramString, float paramFloat) {
        paramString = this.d;
        int i = (int) paramFloat;
        paramString.m(100, i, false);
        this.d.g(getString(2131690141, new Object[]{Integer.valueOf(i)}));
        this.b.notify(2462, this.d.a());
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.service.ApkDownloaderService

 * JD-Core Version:    0.7.0.1

 */