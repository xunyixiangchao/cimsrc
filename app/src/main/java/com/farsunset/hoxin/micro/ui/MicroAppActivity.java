package com.farsunset.hoxin.micro.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.CustomWebView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.micro.entity.MicroApp;
import com.google.android.material.appbar.AppBarLayout;

import i3.e;
import s3.d;
import s3.i0;
import u3.b0;
import u3.l;
import u3.r;
import u3.s;

public class MicroAppActivity
        extends BaseActivity
        implements d, i0 {
    private CustomWebView e;
    private MicroApp f;
    private View g;

    private void a1() {
        s.a().g(b0.a(Long.valueOf(this.f.id)), this);
        S0(this.f.name);
        AppBarLayout localAppBarLayout = (AppBarLayout) findViewById(2131230810);
        if (TextUtils.isEmpty(this.f.color)) {
            return;
        }
        try {
            int i = Color.parseColor(this.f.color);
            localAppBarLayout.setBackgroundColor(i);
            setStatusBarColor(i);
            return;
        } catch (Exception localException) {
        }
    }

    private void b1() {
        View localView = findViewById(2131231145);
        this.g = localView;
        ((WebImageView) localView.findViewById(2131231053)).p(b0.a(Long.valueOf(this.f.id)), 2131165527);
        ((TextView) this.g.findViewById(2131231301)).setText(this.f.name);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c1() {
        CustomWebView localCustomWebView = (CustomWebView) findViewById(2131231626);
        this.e = localCustomWebView;
        localCustomWebView.setWebViewListener(this);
        this.e.c(new a());
        this.e.loadUrl(this.f.url);
    }

    public void D0(Object paramObject, Bitmap paramBitmap) {
        setTaskDescription(new ActivityManager.TaskDescription(this.f.name, paramBitmap));
    }

    protected int H0() {
        return 2131427389;
    }

    protected void M0() {
        this.f = ((MicroApp) getIntent().getSerializableExtra(MicroApp.class.getSimpleName()));
        a1();
        b1();
        c1();
    }

    public void Q(int paramInt) {
        if (paramInt == 100) {
            this.g.setVisibility(8);
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 321)) {
            this.e.e(paramIntent.getData());
        }
        if ((paramInt2 != -1) && (paramInt1 == 321)) {
            this.e.d();
        }
    }

    public void onBackPressed() {
        finishAndRemoveTask();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165572);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.e.destroy();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            moveTaskToBack(true);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void setStatusBarColor(int paramInt) {
        Window localWindow = getWindow();
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(paramInt);
    }

    public void t(String paramString) {
    }

    public void v(Object paramObject) {
        setTaskDescription(new ActivityManager.TaskDescription(this.f.name));
    }

    static class a {
        @JavascriptInterface
        public String getToken() {
            return e.e();
        }

        @JavascriptInterface
        public String getUser() {
            return l.H0(e.g());
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.MicroAppActivity

 * JD-Core Version:    0.7.0.1

 */