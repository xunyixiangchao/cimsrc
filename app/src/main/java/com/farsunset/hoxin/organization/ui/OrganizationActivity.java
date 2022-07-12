package com.farsunset.hoxin.organization.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.UserDetailedActivity;
import com.farsunset.hoxin.organization.entity.Department;
import com.farsunset.hoxin.organization.entity.Organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import p6.b;
import p6.c;
import s3.a0;
import s3.p;

public class OrganizationActivity
        extends BaseActivity
        implements a0, p<Friend> {
    private l6.a e;
    private GlobalEmptyView f;
    private Department g;
    private Organization h;
    private final List<Object> i = new ArrayList();

    public int H0() {
        return 2131427398;
    }

    public void M0() {
        Object localObject1 = c.c();
        this.h = ((Organization) localObject1);
        S0(((Organization) localObject1).name);
        localObject1 = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject1).setItemAnimator(new e());
        ((RecyclerView) localObject1).setLayoutManager(new LinearLayoutManager(this));
        this.f = ((GlobalEmptyView) findViewById(2131230981));
        Object localObject2 = new l6.a(this.h);
        this.e = ((l6.a) localObject2);
        ((l6.a) localObject2).O(this);
        this.e.N(new r6.a(this));
        localObject2 = (ToolbarSearchView) findViewById(2131231417);
        ((ToolbarSearchView) localObject2).setOnTextChangedListener(this);
        ((ToolbarSearchView) localObject2).setHint(2131689554);
        this.i.addAll(p6.a.i(this.h.id.longValue()));
        this.e.I(((ToolbarSearchView) localObject2).getText(), this.i);
        ((RecyclerView) localObject1).setAdapter(this.e);
        this.f.a(this.e);
    }

    public void c1(Department paramDepartment) {
        this.g = paramDepartment;
        R0(paramDepartment.name);
        this.i.clear();
        this.i.addAll(p6.a.e(this.g.id.longValue()));
        this.i.addAll(b.d(this.h.id.longValue(), this.g.id.longValue()));
        this.e.I(null, this.i);
        this.f.a(this.e);
    }

    public void d1(Friend paramFriend, View paramView) {
        paramView = new Intent(this, UserDetailedActivity.class);
        paramView.putExtra(Friend.class.getName(), paramFriend);
        startActivity(paramView);
    }

    public void h0(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            this.e.I(paramString, this.i);
        } else {
            LinkedList localLinkedList = new LinkedList(p6.a.f(paramString));
            localLinkedList.addAll(i4.a.h(paramString, true, b.g(this.h.id.longValue())));
            this.e.I(paramString, localLinkedList);
        }
        this.f.a(this.e);
    }

    public void onGotoParent(View paramView) {
        paramView = this.g;
        if (paramView == null) {
            return;
        }
        paramView = paramView.parentId;
        if (paramView == null) {
            R0(null);
            this.i.clear();
            this.i.addAll(p6.a.i(this.h.id.longValue()));
            this.e.I(null, this.i);
            this.f.a(this.e);
            return;
        }
        c1(p6.a.h(paramView.longValue()));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.organization.ui.OrganizationActivity

 * JD-Core Version:    0.7.0.1

 */