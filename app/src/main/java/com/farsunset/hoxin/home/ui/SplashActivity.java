package com.farsunset.hoxin.home.ui;

import a5.e;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.account.ui.LoginActivity;
import com.farsunset.hoxin.common.ui.BaseActivity;

import u3.l;
import u3.m0;

public class SplashActivity
        extends BaseActivity {
    public int H0() {
        return 2131427405;
    }

    public void M0() {
        View localView = findViewById(2131231627);
        P0(false);
        m0.c(new e(this, localView), 800L);
        l.Y();
    }

    protected boolean O0() {
        return true;
    }

    public void onBackPressed() {
        h.f(this);
        super.onBackPressed();
    }

    public void onLoginButtonClicked(View paramView) {
        paramView = new Intent(this, LoginActivity.class);
        paramView.setAction("com.farsunset.hoxin.ACTION_FROM_SPLASH_ACTIVITY");
        startActivity(paramView);
    }

    public void onResume() {
        super.onResume();
        if ((getIntent().getFlags() & 0x400000) != 0) {
            finish();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.SplashActivity

 * JD-Core Version:    0.7.0.1

 */