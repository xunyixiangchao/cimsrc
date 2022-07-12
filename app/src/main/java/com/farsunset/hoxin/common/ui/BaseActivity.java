package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import r3.c;
import u3.l;

public abstract class BaseActivity
        extends AppCompatActivity
        implements View.OnClickListener {
    protected Toolbar a;
    private ImageView b;
    private c c;
    private boolean d;

    private void N0() {
        Toolbar localToolbar = (Toolbar) findViewById(2131231572);
        this.a = localToolbar;
        if (localToolbar != null) {
            this.b = ((ImageView) localToolbar.findViewById(2131231574));
            setSupportActionBar(this.a);
            getSupportActionBar().u(false);
            P0(true);
        }
        if (I0() > 0) {
            setTitle(I0());
        }
    }

    private void V0(String paramString, boolean paramBoolean) {
        c localc = this.c;
        if ((localc != null) && (localc.isShowing())) {
            this.c.f(paramString);
            this.c.setCancelable(paramBoolean);
            return;
        }
        localc = new c(this);
        this.c = localc;
        localc.f(paramString);
        this.c.setCancelable(paramBoolean);
        this.c.show();
    }

    protected abstract int H0();

    protected int I0() {
        return 0;
    }

    public void J0() {
        c localc = this.c;
        if ((localc != null) && (localc.isShowing())) {
            this.c.dismiss();
        }
    }

    public void K0() {
        ImageView localImageView = this.b;
        if (localImageView == null) {
            return;
        }
        localImageView.setVisibility(8);
    }

    public void L0() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().l();
        }
    }

    protected abstract void M0();

    protected boolean O0() {
        return false;
    }

    protected void P0(boolean paramBoolean) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().t(paramBoolean);
        }
    }

    public void Q0(int paramInt) {
        Toolbar localToolbar = this.a;
        if (localToolbar != null) {
            localToolbar.setSubtitle(paramInt);
        }
    }

    public void R0(String paramString) {
        Toolbar localToolbar = this.a;
        if (localToolbar != null) {
            localToolbar.setSubtitle(paramString);
        }
    }

    public void S0(String paramString) {
        Toolbar localToolbar = this.a;
        if (localToolbar != null) {
            localToolbar.setTitle(paramString);
        }
    }

    public void T0(int paramInt) {
        V0(getString(paramInt), false);
    }

    public void U0(String paramString) {
        V0(paramString, false);
    }

    public void W0(int paramInt) {
        ImageView localImageView = this.b;
        if (localImageView == null) {
            return;
        }
        localImageView.setImageResource(paramInt);
        this.b.setVisibility(0);
    }

    public void X0(int paramInt) {
        Y0(getString(paramInt));
    }

    public void Y0(String paramString) {
        l.A0(this, paramString);
    }

    public void Z0() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().x();
        }
    }

    public boolean isDestroyed() {
        return this.d;
    }

    public void onBackPressed() {
        finish();
    }

    public void onClick(View paramView) {
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(H0());
        N0();
        M0();
    }

    public void onDestroy() {
        super.onDestroy();
        this.d = true;
        J0();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        if ((paramBoolean) && (O0())) {
            getWindow().getDecorView().setSystemUiVisibility(5890);
        }
    }

    public void setStatusBarColor(int paramInt) {
        Window localWindow = getWindow();
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(paramInt);
    }

    public void setTitle(int paramInt) {
        S0(getString(paramInt));
    }

    public void setTitle(CharSequence paramCharSequence) {
        Toolbar localToolbar = this.a;
        if (localToolbar != null) {
            localToolbar.setTitle(paramCharSequence);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.BaseActivity

 * JD-Core Version:    0.7.0.1

 */