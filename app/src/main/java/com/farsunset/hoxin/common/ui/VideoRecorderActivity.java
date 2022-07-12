package com.farsunset.hoxin.common.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.c1;
import androidx.camera.core.f3;
import androidx.camera.core.f3.d;
import androidx.camera.core.f3.g;
import androidx.camera.core.f3.h;
import androidx.camera.core.f3.h.a;
import androidx.camera.core.f3.i;
import androidx.camera.core.k;
import androidx.camera.core.m;
import androidx.camera.core.t;
import androidx.camera.core.t.a;
import androidx.camera.core.v2;
import androidx.camera.core.w1;
import androidx.camera.core.w1.b;
import androidx.camera.core.z0;
import androidx.camera.core.z0.i;
import androidx.camera.core.z0.o;
import androidx.camera.core.z0.p;
import androidx.camera.core.z0.p.a;
import androidx.camera.core.z0.q;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.LinearProgressView;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import t3.f;
import u3.a0;
import u3.l;

public class VideoRecorderActivity
        extends BaseActivity
        implements View.OnTouchListener, f3.g, z0.o {
    private final int e = 10000;
    private View f;
    private PreviewView g;
    private LinearProgressView h;
    private boolean i = false;
    private final CloudVideo j = new CloudVideo();
    private final CloudImage k = new CloudImage();
    private File l;
    private File m;
    private ExecutorService n;
    private f3 o;
    private z0 p;
    private androidx.camera.lifecycle.e q;
    private ExtensionsManager r;
    private int s = 1;
    private k t;
    Handler u = new a();
    Handler v = new b();

    private int f1(int paramInt1, int paramInt2) {
        double d = Math.max(paramInt1, paramInt2) / Math.min(paramInt1, paramInt2);
        if (Math.abs(d - 1.333333333333333D) <= Math.abs(d - 1.777777777777778D)) {
            return 0;
        }
        return 1;
    }

    @SuppressLint({"RestrictedApi"})
    private void g1() {
        Object localObject1 = new DisplayMetrics();
        this.g.getDisplay().getRealMetrics((DisplayMetrics) localObject1);
        int i1 = f1(((DisplayMetrics) localObject1).widthPixels, ((DisplayMetrics) localObject1).heightPixels);
        int i2 = this.g.getDisplay().getRotation();
        localObject1 = this.q;
        if (localObject1 == null) {
            return;
        }
        Object localObject2 = new w1.b();
        t localt = i1(this.r, new t.a().d(this.s).b());
        localObject2 = ((w1.b) localObject2).k(i1).n(i2).c();
        this.p = new z0.i().g(1).l(i1).o(i2).c();
        this.o = new f3.d().q(i2).n(i1).r(24).j(3145728).c();
        ((androidx.camera.lifecycle.e) localObject1).o();
        this.t = ((androidx.camera.lifecycle.e) localObject1).f(this, localt, new v2[]{localObject2, this.p, this.o});
        ((w1) localObject2).S(this.g.getSurfaceProvider());
    }

    private boolean h1() {
        String[] arrayOfString = new String[2];
        arrayOfString[0] = "android.permission.CAMERA";
        arrayOfString[1] = "android.permission.RECORD_AUDIO";
        if (c8.b.h(this, arrayOfString)) {
            return true;
        }
        if (c8.b.d(this, arrayOfString)) {
            y4.b.q(this, 2131690099, 2768).show();
            return false;
        }
        androidx.core.app.a.o(this, arrayOfString, 2768);
        return false;
    }

    private t i1(ExtensionsManager paramExtensionsManager, t paramt) {
        AtomicReference localAtomicReference = new AtomicReference(paramt);
        if (paramExtensionsManager.f(paramt, 5)) {
            localAtomicReference.set(paramExtensionsManager.b((t) localAtomicReference.get(), 5));
        }
        if (paramExtensionsManager.f(paramt, 1)) {
            localAtomicReference.set(paramExtensionsManager.b((t) localAtomicReference.get(), 1));
        }
        if (paramExtensionsManager.f(paramt, 2)) {
            localAtomicReference.set(paramExtensionsManager.b((t) localAtomicReference.get(), 2));
        }
        if (paramExtensionsManager.f(paramt, 4)) {
            localAtomicReference.set(paramExtensionsManager.b((t) localAtomicReference.get(), 4));
        }
        if (paramExtensionsManager.f(paramt, 3)) {
            localAtomicReference.set(paramExtensionsManager.b((t) localAtomicReference.get(), 3));
        }
        return (t) localAtomicReference.get();
    }

    private int j1() {
        if (k1()) {
            return 1;
        }
        if (l1()) {
            return 0;
        }
        return -1;
    }

    private boolean k1() {
        androidx.camera.lifecycle.e locale = this.q;
        if (locale == null) {
            return false;
        }
        return locale.i(t.c);
    }

    private boolean l1() {
        androidx.camera.lifecycle.e locale = this.q;
        if (locale == null) {
            return false;
        }
        return locale.i(t.c);
    }

    private void m1() {
        u7.a locala = androidx.camera.lifecycle.e.g(this);
        locala.h(new f(this, locala), androidx.core.content.b.g(this));
    }

    private void n1() {
        u7.a locala = ExtensionsManager.c(this, this.q);
        locala.h(new t3.e(this, locala), androidx.core.content.b.g(this));
    }

    private void q1() {
        if (this.p == null) {
            return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder) localObject).append(l.K());
        ((StringBuilder) localObject).append(".jpg");
        localObject = a0.g(((StringBuilder) localObject).toString());
        this.m = ((File) localObject);
        localObject = new z0.p.a((File) localObject).a();
        this.p.z0((z0.p) localObject, this.n, this);
    }

    @SuppressLint({"RestrictedApi"})
    private void r1() {
        this.h.g();
        Object localObject = new StringBuilder();
        ((StringBuilder) localObject).append(l.K());
        ((StringBuilder) localObject).append(".mp4");
        localObject = a0.g(((StringBuilder) localObject).toString());
        this.l = ((File) localObject);
        localObject = new f3.h.a((File) localObject).a();
        if (androidx.core.content.b.a(this, "android.permission.RECORD_AUDIO") != 0) {
            return;
        }
        this.o.n0((f3.h) localObject, this.n, this);
        this.u.sendEmptyMessageDelayed(0, 10000L);
    }

    @SuppressLint({"RestrictedApi"})
    private void s1() {
        this.u.removeMessages(0);
        f3 localf3 = this.o;
        if (localf3 != null) {
            localf3.o0();
        }
        this.h.h();
    }

    public void A(int paramInt, String paramString, Throwable paramThrowable) {
    }

    public int H0() {
        return 2131427404;
    }

    public void I(f3.i parami) {
        this.j.size = this.l.length();
        this.j.duration = this.h.getDurationSecond();
        this.j.video = this.l.getName();
        byte b;
        if (getResources().getConfiguration().orientation == 2) {
            parami = this.j;
            b = 0;
        } else {
            parami = this.j;
            b = 1;
        }
        parami.mode = b;
        this.j.image = l.P(this.l).getName();
        this.j.uri = Uri.fromFile(this.l).toString();
        parami = new Intent(this, VideoPlayerActivity.class);
        parami.setAction("com.farsunset.hoxin.ACTION_FROM_RECORD_VIDEO_PREVIEW");
        parami.putExtra(CloudVideo.class.getName(), this.j);
        androidx.core.app.a.s(this, parami, 789, null);
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public void M0() {
        this.h = ((LinearProgressView) findViewById(2131231384));
        View localView = findViewById(2131231385);
        this.f = localView;
        localView.setOnTouchListener(this);
        this.h.setMaxDuration(10000);
        this.h.setMinDuration(3000);
        this.g = ((PreviewView) findViewById(2131231383));
        if (!h1()) {
            return;
        }
        this.n = Executors.newSingleThreadExecutor();
        m1();
    }

    protected boolean O0() {
        return true;
    }

    public void d(z0.q paramq) {
        this.k.uri = l.L(this.m).toString();
        paramq = new Intent(this, PhotoPreviewActivity.class);
        paramq.setAction(getIntent().getAction());
        paramq.putExtra(CloudImage.class.getName(), this.k);
        androidx.core.app.a.s(this, paramq, 678, null);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 789)) {
            paramIntent = new Intent("com.farsunset.hoxin.ACTION_TAKE_VIDEO");
            paramIntent.putExtra(CloudVideo.class.getName(), this.j);
            setResult(-1, paramIntent);
            finish();
        }
        if ((paramInt2 != -1) && (paramInt1 == 789)) {
            ca.a.k(a0.g(this.j.image));
            ca.a.k(a0.g(this.j.video));
            ca.a.k(this.l);
            this.h.f();
        }
        if ((paramInt2 == -1) && (paramInt1 == 678)) {
            paramIntent = new Intent("com.farsunset.hoxin.ACTION_TAKE_PHOTO");
            paramIntent.putExtra(CloudImage.class.getName(), this.k);
            setResult(-1, paramIntent);
            finish();
        }
        if ((paramInt2 != -1) && (paramInt1 == 678)) {
            ca.a.k(this.m);
        }
        if ((paramInt1 == 2768) && (l.R(this))) {
            m1();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        super.setStatusBarColor(0);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492895, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.u.removeMessages(0);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231250) {
            if (this.s == 0) {
                this.s = 1;
            } else {
                this.s = 0;
            }
            g1();
        }
        if (paramMenuItem.getItemId() == 2131231212) {
            this.i ^= true;
            this.t.c().h(this.i);
        }
        if (paramMenuItem.getItemId() == 2131231239) {
            if (getResources().getConfiguration().orientation == 1) {
                setRequestedOrientation(0);
            } else {
                setRequestedOrientation(1);
            }
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        if ((paramInt == 2768) && (l.R(this))) {
            m1();
        }
        if ((paramInt == 2768) && (!l.R(this))) {
            l.z0(this, 2131690100);
            finish();
        }
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 0) {
            this.v.sendEmptyMessageDelayed(0, 500L);
        }
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
            this.v.removeMessages(0);
            if (this.f.isSelected()) {
                this.f.setSelected(false);
                s1();
                return false;
            }
            q1();
        }
        return false;
    }

    public void t0(c1 paramc1) {
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(Message paramMessage) {
            VideoRecorderActivity.c1(VideoRecorderActivity.this).setSelected(false);
            VideoRecorderActivity.d1(VideoRecorderActivity.this);
        }
    }

    class b
            extends Handler {
        b() {
        }

        public void handleMessage(Message paramMessage) {
            VideoRecorderActivity.c1(VideoRecorderActivity.this).setSelected(true);
            VideoRecorderActivity.e1(VideoRecorderActivity.this);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.VideoRecorderActivity

 * JD-Core Version:    0.7.0.1

 */