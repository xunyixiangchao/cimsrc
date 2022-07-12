package com.farsunset.hoxin.webrtc.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import androidx.core.app.h;

import com.farsunset.hoxin.message.entity.ChatSession;

import u3.b0;
import u3.r;
import u3.s;

public class RealtimeCallService
        extends IntentService {
    public RealtimeCallService() {
        super(RealtimeCallService.class.getSimpleName());
    }

    public void a(ChatSession paramChatSession, byte paramByte, Class paramClass) {
        paramClass = new Intent(this, paramClass);
        paramClass.addFlags(268435456);
        paramClass = PendingIntent.getActivity(this, 1, paramClass, 201326592);
        h localh = new h(this, "REALTIME_CALL_NOTIFICATION");
        localh.e(false);
        localh.k(true);
        localh.q(System.currentTimeMillis());
        localh.n(2131165623);
        localh.l(0);
        if (paramByte == 0) {
            paramByte = 2131689608;
        } else {
            paramByte = 2131689619;
        }
        localh.g(getString(paramByte));
        localh.o(getString(paramByte));
        localh.h(paramChatSession.name);
        localh.f(paramClass);
        paramClass = s.a().n(b0.l(paramChatSession.sourceId));
        paramChatSession = paramClass;
        if (paramClass == null) {
            paramChatSession = BitmapFactory.decodeResource(getResources(), 2131165623);
        }
        localh.j(paramChatSession);
        ((NotificationManager) getSystemService("notification")).notify(46434342, localh.a());
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    protected void onHandleIntent(Intent paramIntent) {
        a((ChatSession) paramIntent.getSerializableExtra("ATTR_CHAT_SESSION"), paramIntent.getByteExtra("ATTR_TYPE", (byte) 0), (Class) paramIntent.getSerializableExtra("ATTR_TARGET_CLASS"));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.service.RealtimeCallService

 * JD-Core Version:    0.7.0.1

 */