package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.Intent;

import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import j5.b;

public class GroupMessageTargetActivity
        extends GroupChatActivity {
    protected void i1() {
        Message localMessage = (Message) getIntent().getSerializableExtra("MESSAGE");
        if (localMessage == null) {
            super.i1();
            return;
        }
        this.g.I(b.n(Long.valueOf(this.j.id), localMessage.id));
        super.c1(localMessage);
    }

    protected void l1() {
        super.i1();
    }

    public void onDestroy() {
        super.onDestroy();
        i3.a.a(GroupChatActivity.class);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.GroupMessageTargetActivity

 * JD-Core Version:    0.7.0.1

 */