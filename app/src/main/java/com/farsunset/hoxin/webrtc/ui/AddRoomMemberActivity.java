package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.ContactSelectorActivity;
import com.farsunset.hoxin.webrtc.api.request.RoomAddRequest;
import com.farsunset.hoxin.webrtc.model.AvRoom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddRoomMemberActivity
        extends ContactSelectorActivity {
    private AvRoom m;
    private int n;

    public boolean B(MessageSource paramMessageSource) {
        int i = this.e.L();
        int j = this.n;
        if (i > j) {
            Y0(getString(2131690013, new Object[]{Integer.valueOf(j)}));
            return false;
        }
        super.B(paramMessageSource);
        this.f.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
        return true;
    }

    public int I0() {
        return 2131690136;
    }

    protected void M0() {
        this.m = ((AvRoom) getIntent().getSerializableExtra(AvRoom.class.getName()));
        super.M0();
    }

    public void U(MessageSource paramMessageSource) {
        super.U(paramMessageSource);
        this.f.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
    }

    protected List<Friend> d1() {
        long[] arrayOfLong = this.m.getIdArray();
        int i = 9 - arrayOfLong.length;
        this.n = i;
        R0(getString(2131690002, new Object[]{Integer.valueOf(i)}));
        return i4.a.j(arrayOfLong, false);
    }

    public void e1() {
        if (this.e.L() < 1) {
            Y0(getString(2131690014, new Object[]{Integer.valueOf(1)}));
            return;
        }
        RoomAddRequest localRoomAddRequest = new RoomAddRequest();
        localRoomAddRequest.setTag(this.m.getTag());
        localRoomAddRequest.setType(this.m.getType());
        localRoomAddRequest.setMember(this.m.getMember());
        Object localObject = this.e.M().iterator();
        while (((Iterator) localObject).hasNext()) {
            Friend localFriend = (Friend) ((Iterator) localObject).next();
            localRoomAddRequest.addNew(localFriend.id, localFriend.name);
        }
        u6.a.c(localRoomAddRequest);
        localObject = new Intent();
        ((Intent) localObject).putExtra(RoomAddRequest.class.getName(), localRoomAddRequest);
        setResult(-1, (Intent) localObject);
        finish();
    }

    protected void f1(Button paramButton) {
        if (this.e.L() > 0) {
            paramButton.setText(getString(2131689668, new Object[]{Integer.valueOf(this.e.L())}));
            paramButton.setEnabled(true);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.AddRoomMemberActivity

 * JD-Core Version:    0.7.0.1

 */