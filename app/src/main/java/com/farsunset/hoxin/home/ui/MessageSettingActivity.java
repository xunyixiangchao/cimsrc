package com.farsunset.hoxin.home.ui;

import a5.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.k;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;

import u3.d;

public class MessageSettingActivity
        extends BaseActivity
        implements CompoundButton.OnCheckedChangeListener {
    private void b1() {
        CompoundButton localCompoundButton = (CompoundButton) findViewById(2131231328);
        localCompoundButton.setChecked(k.e(this).a());
        localCompoundButton.setOnCheckedChangeListener(b.a);
    }

    public int H0() {
        return 2131427388;
    }

    public int I0() {
        return 2131689851;
    }

    public void M0() {
        CompoundButton localCompoundButton = (CompoundButton) findViewById(2131231494);
        localCompoundButton.setChecked(d.h(localCompoundButton.getTag().toString(), true));
        localCompoundButton.setOnCheckedChangeListener(this);
        if (Build.VERSION.SDK_INT < 26) {
            findViewById(2131231227).setVisibility(8);
        }
        b1();
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
        d.y(paramCompoundButton.getTag().toString(), paramBoolean);
    }

    public void onNotifyChannelClicked(View paramView) {
        paramView = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        paramView.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        paramView.putExtra("android.provider.extra.CHANNEL_ID", "NEW_MESSAGE_NOTIFICATION");
        paramView.setFlags(268435456);
        HoxinApplication.h().startActivity(paramView);
    }

    public void onResume() {
        super.onResume();
        b1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.MessageSettingActivity

 * JD-Core Version:    0.7.0.1

 */