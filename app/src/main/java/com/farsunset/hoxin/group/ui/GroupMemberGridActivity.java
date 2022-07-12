package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.entity.GroupMember;

import r4.a;
import s3.a0;
import s3.p;
import s3.q;
import u3.l;

public class GroupMemberGridActivity
        extends BaseActivity
        implements a0, p<GroupMember>, q<GroupMember> {
    private l4.b e;
    private GlobalEmptyView f;
    private Group g;

    public int H0() {
        return 2131427381;
    }

    public void M0() {
        this.g = ((Group) getIntent().getSerializableExtra(Group.NAME));
        Object localObject = (GlobalEmptyView) findViewById(2131230981);
        this.f = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131689545);
        localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setNestedScrollingEnabled(false);
        ((RecyclerView) localObject).setLayoutManager(new GridLayoutManager(this, 5, 1, false));
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        l4.b localb = new l4.b();
        this.e = localb;
        ((RecyclerView) localObject).setAdapter(localb);
        this.e.M(this);
        this.e.I(p4.b.g(Long.valueOf(this.g.id)), null);
        S0(getString(2131689719, new Object[]{Integer.valueOf(this.e.d())}));
        localObject = (ToolbarSearchView) findViewById(2131231417);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        ((ToolbarSearchView) localObject).setHint(2131689554);
    }

    public void a1(GroupMember paramGroupMember, View paramView) {
        if (paramGroupMember.uid == i3.e.o().longValue()) {
            return;
        }
        paramGroupMember = new a(this, this.g, paramGroupMember);
        paramGroupMember.w(this);
        paramGroupMember.show();
    }

    public void b1(GroupMember paramGroupMember) {
        this.e.L(paramGroupMember);
        l.w0(this.g.id);
    }

    public void h0(String paramString) {
        this.e.I(p4.b.i(Long.valueOf(this.g.id), paramString), paramString);
        this.f.a(this.e);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.GroupMemberGridActivity

 * JD-Core Version:    0.7.0.1

 */