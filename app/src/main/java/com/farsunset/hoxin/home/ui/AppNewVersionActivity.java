package com.farsunset.hoxin.home.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.home.model.AppVersion;

import u3.a0;
import u3.l;

public class AppNewVersionActivity
        extends AppCompatActivity
        implements View.OnClickListener {
    private AppVersion a;

    public void onBackPressed() {
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131231128) {
            finish();
            return;
        }
        if (paramView.getId() == 2131231396) {
            l.z0(this, 2131690138);
            paramView = new StringBuilder();
            paramView.append(HoxinApplication.h().getPackageName());
            paramView.append("-");
            paramView.append(this.a.versionName);
            paramView.append(".apk");
            paramView = a0.f(paramView.toString());
            HoxinApplication.h().w(this.a.url, paramView);
            if (!this.a.force) {
                finish();
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2131427397);
        this.a = ((AppVersion) getIntent().getSerializableExtra(AppVersion.class.getName()));
        findViewById(2131231128).setOnClickListener(this);
        findViewById(2131231396).setOnClickListener(this);
        if (this.a.force) {
            findViewById(2131231128).setVisibility(8);
        }
        paramBundle = getString(2131689808, new Object[]{l.X(this.a.versionName)});
        ((TextView) findViewById(2131231486)).setText(Html.fromHtml(paramBundle));
        ((TextView) findViewById(2131231256)).setText(l.X(this.a.description));
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if ((paramMotionEvent.getAction() == 0) && (l.d0(this, paramMotionEvent))) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.AppNewVersionActivity

 * JD-Core Version:    0.7.0.1

 */