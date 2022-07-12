package com.farsunset.hoxin.home.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.WebViewActivity;

public class MixedSettingActivity
        extends BaseActivity
        implements z4.b {
    private f3.b e;
    private y4.c f;
    private TextView g;
    CompoundButton.OnCheckedChangeListener h = a5.d.a;
    CompoundButton.OnCheckedChangeListener i = new a5.c(this);

    public int H0() {
        return 2131427402;
    }

    public int I0() {
        return 2131689682;
    }

    public void M0() {
        this.e = new f3.b(this);
        Object localObject = new y4.c(this);
        this.f = ((y4.c) localObject);
        ((y4.c) localObject).o(this);
        localObject = (CompoundButton) findViewById(2131231492);
        ((CompoundButton) localObject).setChecked(u3.d.r());
        ((CompoundButton) localObject).setOnCheckedChangeListener(this.h);
        localObject = (TextView) findViewById(2131231550);
        this.g = ((TextView) localObject);
        ((TextView) localObject).setText(u3.d.n());
        findViewById(2131231208).setVisibility(0);
        localObject = (CompoundButton) findViewById(2131231495);
        ((CompoundButton) localObject).setChecked(Settings.canDrawOverlays(this));
        ((CompoundButton) localObject).setOnCheckedChangeListener(this.i);
    }

    public void onAboutClicked(View paramView) {
        startActivity(new Intent(this, AboutActivity.class));
    }

    public void onCheckVersionClicked(View paramView) {
        HoxinApplication.h().a();
    }

    public void onCloseAppClicked(View paramView) {
        this.e.show();
    }

    public void onKeepLiveClicked(View paramView) {
        X0(2131690074);
        paramView = new Intent(this, WebViewActivity.class);
        paramView.setData(Uri.parse("https://csmobile.alipay.com/detailSolution.htm?knowledgeType=1&scene=dd_gdwt&questionId=201602063554"));
        startActivity(paramView);
    }

    public void onMessageConfigClicked(View paramView) {
        startActivity(new Intent(this, MessageSettingActivity.class));
    }

    public void onResume() {
        super.onResume();
        CompoundButton localCompoundButton = (CompoundButton) findViewById(2131231495);
        localCompoundButton.setOnCheckedChangeListener(null);
        localCompoundButton.setChecked(Settings.canDrawOverlays(this));
        localCompoundButton.setOnCheckedChangeListener(this.i);
    }

    public void onThemeModeClicked(View paramView) {
        this.f.show();
    }

    public void v0(int paramInt, String paramString) {
        u3.d.A(paramInt);
        this.g.setText(paramString);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.MixedSettingActivity

 * JD-Core Version:    0.7.0.1

 */