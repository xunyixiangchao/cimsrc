package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.content.Intent;

import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.GroupMessageTargetActivity;
import com.farsunset.hoxin.message.ui.MessageSearchActivity;

public class GroupMessageSearchActivity
        extends MessageSearchActivity {
    public void L(Message paramMessage) {
        Intent localIntent = new Intent(this, GroupMessageTargetActivity.class);
        localIntent.putExtra("MESSAGE", paramMessage);
        localIntent.putExtra("ATTR_CHAT_SESSION", this.e);
        startActivity(localIntent);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.GroupMessageSearchActivity

 * JD-Core Version:    0.7.0.1

 */