package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.group.entity.GroupMember;

import java.util.ArrayList;
import java.util.List;

import l4.c;
import p4.b;
import s3.a0;
import s3.p;

public class GroupMemberSelectorActivity
        extends BaseActivity
        implements a0, p<GroupMember> {
    private c e;
    private GlobalEmptyView f;
    private long g;
    private final List<Long> h = new ArrayList(1);

    public int H0() {
        return 2131427363;
    }

    protected int I0() {
        return 2131690173;
    }

    public void M0() {
        this.g = getIntent().getLongExtra("ATTR_GROUP_ID", 0L);
        this.h.add(i3.e.o());
        Object localObject = (GlobalEmptyView) findViewById(2131230981);
        this.f = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131689545);
        localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setNestedScrollingEnabled(false);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        c localc = new c();
        this.e = localc;
        ((RecyclerView) localObject).setAdapter(localc);
        this.e.L(this);
        this.e.I(b.j(Long.valueOf(this.g), this.h), null);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        ((ToolbarSearchView) localObject).setHint(2131689554);
    }

    public void a1(GroupMember paramGroupMember, View paramView) {
        paramView = new Intent();
        paramView.putExtra(GroupMember.class.getName(), paramGroupMember);
        setResult(-1, paramView);
        finish();
    }

    public void h0(String paramString) {
        this.e.I(b.k(Long.valueOf(this.g), this.h, paramString), paramString);
        this.f.a(this.e);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.GroupMemberSelectorActivity

 * JD-Core Version:    0.7.0.1

 */