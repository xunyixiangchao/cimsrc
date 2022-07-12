package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import com.farsunset.hoxin.common.model.MessageSource;

public class ProfileSelectorActivity
        extends ContactSelectorActivity {
    public void C(MessageSource paramMessageSource) {
        Intent localIntent = new Intent();
        localIntent.putExtra("ATTR_FRIEND", paramMessageSource);
        setResult(-1, localIntent);
        finish();
    }

    public boolean c1() {
        return true;
    }

    protected void f1(Button paramButton) {
        paramButton.setVisibility(8);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.ProfileSelectorActivity

 * JD-Core Version:    0.7.0.1

 */