package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

public class NewFriendActivity
        extends CIMMonitorActivity {
    private GlobalEmptyView e;
    private e4.b f;

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if ("105".equals(paramMessage.action)) {
            this.f.I(paramMessage);
            this.e.a(this.f);
        }
    }

    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131689686;
    }

    public void M0() {
        Object localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setItemAnimator(new e());
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu((View) localObject);
        e4.b localb = new e4.b();
        this.f = localb;
        ((RecyclerView) localObject).setAdapter(localb);
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.e = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131690043);
        this.f.J(j5.b.m("105"));
        this.e.a(this.f);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.f.J(j5.b.m("105"));
    }

    public void onBackPressed() {
        super.onBackPressed();
        j5.b.v("105");
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131230934) {
            paramMenuItem = this.f.K();
            this.f.L(paramMenuItem);
            j5.b.d(paramMenuItem.id);
            this.e.a(this.f);
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        paramContextMenu.add(1, 2131230934, 1, getString(2131689528));
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492882, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231240) {
            startActivity(new Intent(this, FindFriendActivity.class));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.NewFriendActivity

 * JD-Core Version:    0.7.0.1

 */