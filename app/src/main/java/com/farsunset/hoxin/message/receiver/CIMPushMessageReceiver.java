package com.farsunset.hoxin.message.receiver;

import android.content.Intent;

import com.farsunset.cim.sdk.android.CIMEventBroadcastReceiver;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.cim.sdk.android.model.Message;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.HoxinApplication;

import f5.a;
import i3.e;
import m5.k;
import n3.c;
import u3.d;
import u3.l;
import u3.t;

public final class CIMPushMessageReceiver
        extends CIMEventBroadcastReceiver {
    private static final String b = CIMPushMessageReceiver.class.getSimpleName();

    private void p() {
        if (e.r(e.o().longValue())) {
            a.c();
        }
    }

    public void c() {
    }

    public void d(boolean paramBoolean) {
        c.b(paramBoolean);
        if (d.r()) {
            h.u(HoxinApplication.h(), 2131165623, l.I(2131690167), l.I(2131690166));
        }
        if (!paramBoolean) {
            h.b(HoxinApplication.h(), e.o().longValue());
        }
    }

    public void e() {
    }

    public void k(Message paramMessage, Intent paramIntent) {
        t.c(b, paramMessage.toString());
        k.a(paramIntent.getExtras(), paramMessage);
    }

    public void l() {
        c.e(h.i(this.a));
    }

    public void m(ReplyBody paramReplyBody) {
        c.f(paramReplyBody);
        if ((paramReplyBody.getKey().equals("client_bind")) && (paramReplyBody.getCode().equals(String.valueOf(200)))) {
            p();
        }
        if ((paramReplyBody.getKey().equals("client_bind")) && (paramReplyBody.getCode().equals(String.valueOf(500)))) {
            t.a(b, paramReplyBody.getMessage());
        }
    }

    public void n(SentBody paramSentBody) {
        c.g(paramSentBody);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.receiver.CIMPushMessageReceiver

 * JD-Core Version:    0.7.0.1

 */