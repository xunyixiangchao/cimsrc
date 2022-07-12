package com.farsunset.hoxin.webrtc.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import androidx.core.app.h;

import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.webrtc.model.AvRoom;

import u3.r;
import u3.s;

public class GroupRealtimeCallService
        extends IntentService {
    public GroupRealtimeCallService() {
        super(GroupRealtimeCallService.class.getName());
    }

    public void a(Friend paramFriend, byte paramByte, Class paramClass) {
        paramClass = new Intent(this, paramClass);
        paramClass.addFlags(268435456);
        paramClass = PendingIntent.getActivity(this, 1, paramClass, 201326592);
        h localh = new h(this, "REALTIME_CALL_NOTIFICATION");
        localh.e(false);
        localh.k(true);
        localh.q(System.currentTimeMillis());
        localh.n(2131165623);
        if (11 == paramByte) {
            paramByte = 2131689620;
        } else {
            paramByte = 2131689609;
        }
        String str = getString(paramByte);
        localh.g(str);
        localh.o(str);
        localh.h(paramFriend.getName());
        localh.f(paramClass);
        paramClass = s.a().n(paramFriend.getWebIcon());
        paramFriend = paramClass;
        if (paramClass == null) {
            paramFriend = BitmapFactory.decodeResource(getResources(), 2131165623);
        }
        localh.j(paramFriend);
        ((NotificationManager) getSystemService("notification")).notify(46434342, localh.a());
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    protected void onHandleIntent(Intent paramIntent) {
        AvRoom localAvRoom = (AvRoom) paramIntent.getSerializableExtra(AvRoom.class.getName());
        Friend localFriend = new Friend();
        localFriend.id = localAvRoom.getUid();
        localFriend.name = localAvRoom.getName(localAvRoom.getUid());
        a(localFriend, localAvRoom.getType(), (Class) paramIntent.getSerializableExtra("ATTR_TARGET_CLASS"));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.service.GroupRealtimeCallService

 * JD-Core Version:    0.7.0.1

 */