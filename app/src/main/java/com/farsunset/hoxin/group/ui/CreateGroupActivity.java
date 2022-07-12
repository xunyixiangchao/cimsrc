package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.content.Intent;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.ContactSelectorActivity;
import com.farsunset.hoxin.group.api.request.GroupCreateRequest;
import com.farsunset.hoxin.group.api.response.GroupResult;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.ui.GroupChatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import n4.b;
import s3.m;

public class CreateGroupActivity
        extends ContactSelectorActivity
        implements s3.e<GroupResult>, m {
    r4.e m;

    private ArrayList<Long> h1() {
        ArrayList localArrayList = new ArrayList(this.e.M().size());
        Iterator localIterator = this.e.M().iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(Long.valueOf(((Friend) localIterator.next()).id));
        }
        return localArrayList;
    }

    public int I0() {
        return 2131689691;
    }

    protected void M0() {
        super.M0();
        r4.e locale = new r4.e(this);
        this.m = locale;
        locale.g(this);
    }

    public void P(String paramString) {
        this.m.dismiss();
        T0(2131690030);
        GroupCreateRequest localGroupCreateRequest = new GroupCreateRequest();
        localGroupCreateRequest.setName(paramString.trim());
        localGroupCreateRequest.setIdList(h1());
        b.c(localGroupCreateRequest, this);
    }

    protected List<Friend> d1() {
        return i4.a.f();
    }

    public void e1() {
        if (this.e.M().isEmpty()) {
            return;
        }
        this.m.show();
    }

    public void i1(GroupResult paramGroupResult) {
        J0();
        Intent localIntent = new Intent(this, GroupChatActivity.class);
        localIntent.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramGroupResult.data));
        startActivity(localIntent);
        finish();
    }

    public void onHttpException(Exception paramException) {
        J0();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.CreateGroupActivity

 * JD-Core Version:    0.7.0.1

 */