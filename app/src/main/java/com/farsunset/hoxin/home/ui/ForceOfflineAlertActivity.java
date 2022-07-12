package com.farsunset.hoxin.home.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.k;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;

import u3.l;

public class ForceOfflineAlertActivity
        extends AppCompatActivity
        implements View.OnClickListener {
    private void H0() {
        k.e(this).d();
    }

    public void onBackPressed() {
    }

    public void onClick(View paramView) {
        finish();
        HoxinApplication.h().r();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2131427357);
        findViewById(2131230850).setOnClickListener(this);
        ((ImageView) findViewById(2131231053)).setImageResource(2131165505);
        ((TextView) findViewById(2131231256)).setText(getIntent().getStringExtra("MESSAGE"));
        H0();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (l.d0(this, paramMotionEvent)) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.ForceOfflineAlertActivity

 * JD-Core Version:    0.7.0.1

 */