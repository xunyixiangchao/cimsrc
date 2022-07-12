package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.ContactSelectorActivity;
import com.farsunset.hoxin.group.entity.GroupMember;
import com.farsunset.hoxin.webrtc.model.AvRoom;

import e4.a;
import i3.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import p4.b;
import u3.l;

public class CreateRoomActivity
        extends ContactSelectorActivity {
    public boolean B(MessageSource paramMessageSource) {
        if (this.e.L() > 8) {
            Y0(getString(2131690013, new Object[]{Integer.valueOf(8)}));
            return false;
        }
        super.B(paramMessageSource);
        this.f.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
        return true;
    }

    public int I0() {
        return 2131690147;
    }

    protected void M0() {
        super.M0();
        R0(getString(2131690013, new Object[]{Integer.valueOf(8)}));
    }

    public void U(MessageSource paramMessageSource) {
        super.U(paramMessageSource);
        this.f.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
    }

    protected List<Friend> d1() {
        long l = getIntent().getLongExtra("ATTR_GROUP_ID", 0L);
        if (l == 0L) {
            return super.d1();
        }
        Object localObject = b.j(Long.valueOf(l), Collections.singletonList(e.o()));
        LinkedList localLinkedList = new LinkedList();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            GroupMember localGroupMember = (GroupMember) ((Iterator) localObject).next();
            Friend localFriend = new Friend();
            localFriend.name = localGroupMember.name;
            localFriend.id = localGroupMember.uid;
            localLinkedList.add(localFriend);
        }
        return localLinkedList;
    }

    public void e1() {
        if (this.e.L() < 1) {
            Y0(getString(2131690014, new Object[]{Integer.valueOf(1)}));
            return;
        }
        Object localObject = e.g();
        AvRoom localAvRoom = new AvRoom();
        localAvRoom.setTag(l.K());
        localAvRoom.add(((Friend) localObject).id, ((Friend) localObject).name);
        localAvRoom.setUid(((Friend) localObject).id);
        if ("com.farsunset.hoxin.ACTION_VOICE_CALL_ROOM".equals(getIntent().getAction())) {
            localAvRoom.setType((byte) 10);
        }
        if ("com.farsunset.hoxin.ACTION_VIDEO_CALL_ROOM".equals(getIntent().getAction())) {
            localAvRoom.setType((byte) 11);
        }
        localObject = this.e.M().iterator();
        while (((Iterator) localObject).hasNext()) {
            Friend localFriend = (Friend) ((Iterator) localObject).next();
            localAvRoom.add(localFriend.id, localFriend.name);
        }
        HoxinApplication.h().A(localAvRoom);
    }

    protected void f1(Button paramButton) {
        if (this.e.L() > 0) {
            paramButton.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
            paramButton.setEnabled(true);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.CreateRoomActivity

 * JD-Core Version:    0.7.0.1

 */