package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.ContactSelectorActivity;
import com.farsunset.hoxin.group.entity.Group;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import s3.e;
import u3.l;

public class InviteGroupMemberActivity
        extends ContactSelectorActivity
        implements e<BaseResult> {
    private Group m;
    private List<Long> n;

    private ArrayList<Long> h1() {
        ArrayList localArrayList = new ArrayList(this.e.M().size());
        Iterator localIterator = this.e.M().iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(Long.valueOf(((Friend) localIterator.next()).id));
        }
        return localArrayList;
    }

    public boolean B(MessageSource paramMessageSource) {
        super.B(paramMessageSource);
        this.f.setText(getString(2131689713, new Object[]{Integer.valueOf(this.e.M().size())}));
        return true;
    }

    public int I0() {
        return 2131689712;
    }

    public void M0() {
        Group localGroup = (Group) getIntent().getSerializableExtra(Group.NAME);
        this.m = localGroup;
        this.n = p4.b.o(localGroup.id);
        super.M0();
    }

    public void U(MessageSource paramMessageSource) {
        super.U(paramMessageSource);
        this.f.setText(getString(2131689713, new Object[]{Integer.valueOf(this.e.M().size())}));
    }

    protected List<Friend> d1() {
        return i4.a.i(this.n, false);
    }

    public void e1() {
        U0(getString(2131690077, new Object[]{getString(2131689535)}));
        n4.b.f(this.m.id, h1(), this);
    }

    public void h0(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            List localList = i4.a.h(paramString, false, this.n);
            if (localList.isEmpty()) {
                this.k.setVisibility(0);
                return;
            }
            this.k.setVisibility(8);
            this.e.P(localList, paramString);
            return;
        }
        this.k.setVisibility(8);
        this.e.P(d1(), paramString);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        boolean bool = super.onCreateOptionsMenu(paramMenu);
        this.f.setText(getString(2131689713, new Object[]{Integer.valueOf(0)}));
        return bool;
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        J0();
        l.w0(this.m.id);
        finish();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.InviteGroupMemberActivity

 * JD-Core Version:    0.7.0.1

 */