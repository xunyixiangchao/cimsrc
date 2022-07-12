package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import n3.b;
import n3.c;

public abstract class CIMMonitorActivity
        extends BaseActivity
        implements b {
    public void H(ChatSession paramChatSession, Message paramMessage) {
    }

    public void a() {
    }

    public void b(SentBody paramSentBody) {
    }

    public void f(NetworkInfo paramNetworkInfo) {
    }

    public void g(ReplyBody paramReplyBody) {
    }

    public void h(boolean paramBoolean) {
    }

    public void i() {
    }

    public void onCreate(Bundle paramBundle) {
        c.h(this);
        super.onCreate(paramBundle);
    }

    public void onDestroy() {
        super.onDestroy();
        c.i(this);
    }

    public void onRestart() {
        super.onRestart();
        c.h(this);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.CIMMonitorActivity

 * JD-Core Version:    0.7.0.1

 */