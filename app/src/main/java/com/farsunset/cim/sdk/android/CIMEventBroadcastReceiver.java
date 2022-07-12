package com.farsunset.cim.sdk.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;

import com.farsunset.cim.sdk.android.model.Message;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;

import z2.b;

public abstract class CIMEventBroadcastReceiver
        extends BroadcastReceiver {
    protected Context a;

    private void a(long paramLong) {
        Intent localIntent = new Intent(this.a, CIMPushService.class);
        localIntent.putExtra("KEY_DELAYED_TIME", paramLong);
        localIntent.setAction("ACTION_CREATE_CIM_CONNECTION");
        h.v(this.a, localIntent);
    }

    private boolean b(String paramString) {
        return "999".equals(paramString);
    }

    private void f() {
        if (h.m(this.a)) {
            a(0L);
        }
        l();
    }

    private void g(long paramLong) {
        if (h.m(this.a)) {
            c();
            a(paramLong);
        }
    }

    private void h() {
        a.e(this.a, "KEY_CIM_CONNECTION_STATE", true);
        d(h.a(this.a));
    }

    private void i() {
        a.e(this.a, "KEY_CIM_CONNECTION_STATE", false);
        if (h.m(this.a)) {
            a(0L);
        }
        e();
    }

    private void j(Message paramMessage, Intent paramIntent) {
        if (b(paramMessage.getAction())) {
            h.w(this.a);
        }
        k(paramMessage, paramIntent);
    }

    private void o() {
        Intent localIntent = new Intent(this.a, CIMPushService.class);
        localIntent.setAction("ACTION_ACTIVATE_PUSH_SERVICE");
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.startForegroundService(localIntent);
            return;
        }
        this.a.startService(localIntent);
    }

    public void c() {
    }

    public void d(boolean paramBoolean) {
        b.b(paramBoolean);
    }

    public void e() {
    }

    public abstract void k(Message paramMessage, Intent paramIntent);

    public void l() {
        b.d(h.i(this.a));
    }

    public void m(ReplyBody paramReplyBody) {
        b.e(paramReplyBody);
    }

    public void n(SentBody paramSentBody) {
        b.f(paramSentBody);
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        this.a = paramContext;
        paramContext = paramIntent.getAction();
        if (("android.intent.action.USER_PRESENT".equals(paramContext)) || ("android.intent.action.ACTION_POWER_CONNECTED".equals(paramContext)) || ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(paramContext))) {
            o();
        }
        if (("com.farsunset.cim.NETWORK_CHANGED".equals(paramContext)) || ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))) {
            f();
        }
        if ("com.farsunset.cim.CONNECTION_CLOSED".equals(paramContext)) {
            i();
        }
        if ("com.farsunset.cim.CONNECT_FAILED".equals(paramContext)) {
            g(paramIntent.getLongExtra("interval", 5000L));
        }
        if ("com.farsunset.cim.CONNECT_FINISHED".equals(paramContext)) {
            h();
        }
        if ("com.farsunset.cim.MESSAGE_RECEIVED".equals(paramContext)) {
            j((Message) paramIntent.getSerializableExtra(Message.class.getName()), paramIntent);
        }
        if ("com.farsunset.cim.REPLY_RECEIVED".equals(paramContext)) {
            m((ReplyBody) paramIntent.getSerializableExtra(ReplyBody.class.getName()));
        }
        if ("com.farsunset.cim.SEND_FINISHED".equals(paramContext)) {
            n((SentBody) paramIntent.getSerializableExtra(SentBody.class.getName()));
        }
        if ("com.farsunset.cim.CONNECTION_RECOVERY".equals(paramContext)) {
            a(0L);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.cim.sdk.android.CIMEventBroadcastReceiver

 * JD-Core Version:    0.7.0.1

 */