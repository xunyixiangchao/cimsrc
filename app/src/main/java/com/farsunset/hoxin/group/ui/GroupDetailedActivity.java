package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import java.util.List;

import s3.k;

public class GroupDetailedActivity
        extends CIMMonitorActivity
        implements CompoundButton.OnCheckedChangeListener, k<Group> {
    private Group e;
    private l4.b f;

    private void a1() {
        this.f.I(p4.b.h(Long.valueOf(this.e.id), 20L), null);
        ((TextView) findViewById(2131231152)).setText(getString(2131689716, new Object[]{Long.valueOf(p4.b.d(Long.valueOf(this.e.id)))}));
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (i5.a.b.contains(paramMessage.action)) {
            a1();
        }
    }

    public int H0() {
        return 2131427378;
    }

    public void M0() {
        findViewById(2131231152).setOnClickListener(this);
        Object localObject = (Group) getIntent().getSerializableExtra(Group.NAME);
        this.e = ((Group) localObject);
        S0(((Group) localObject).name);
        ((TextView) findViewById(2131231487)).setText(this.e.notice);
        ((CompoundButton) findViewById(2131231070)).setChecked(u3.d.s(Long.valueOf(this.e.id)));
        ((CompoundButton) findViewById(2131231070)).setOnCheckedChangeListener(this);
        localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setNestedScrollingEnabled(false);
        ((RecyclerView) localObject).setLayoutManager(new GridLayoutManager(this, 5, 1, false));
        ((RecyclerView) localObject).setItemAnimator(new e());
        l4.b localb = new l4.b();
        this.f = localb;
        ((RecyclerView) localObject).setAdapter(localb);
    }

    public void b1(Group paramGroup) {
        S0(paramGroup.name);
        ((TextView) findViewById(2131231487)).setText(paramGroup.notice);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        a1();
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
        if (2131231070 == paramCompoundButton.getId()) {
            u3.d.w(this.e.id, paramBoolean);
        }
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131231152) {
            paramView = new Intent(this, GroupMemberGridActivity.class);
            paramView.putExtra(Group.NAME, this.e);
            startActivity(paramView);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (!p4.a.j(Long.valueOf(this.e.id))) {
            getMenuInflater().inflate(2131492874, paramMenu);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        Object localObject;
        if (paramMenuItem.getItemId() == 2131231224) {
            localObject = new r4.d(this, this.e);
            ((r4.d) localObject).C(this);
            ((Dialog) localObject).show();
        }
        if (paramMenuItem.getItemId() == 2131231185) {
            localObject = new Intent(this, InviteGroupMemberActivity.class);
            ((Intent) localObject).putExtra(Group.NAME, this.e);
            startActivity((Intent) localObject);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        a1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.GroupDetailedActivity

 * JD-Core Version:    0.7.0.1

 */