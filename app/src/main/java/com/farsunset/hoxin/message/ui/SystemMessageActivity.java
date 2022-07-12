package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;

import b5.j;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import j5.a;

import java.util.List;

import s3.l;

public class SystemMessageActivity
        extends CIMMonitorActivity
        implements l {
    private RecyclerView e;
    private j f;
    private r3.b g;
    private ChatSession h;
    private GlobalEmptyView i;

    private void a1() {
        List localList = j5.b.q(Long.valueOf(this.h.id));
        if ((localList != null) && (!localList.isEmpty())) {
            this.f.I(localList);
            this.e.s1(0);
        }
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if ((paramMessage.sender.equals(Long.valueOf(0L))) && (!paramMessage.isNoNeedShow())) {
            this.f.J(paramMessage);
            this.e.s1(0);
            j5.b.C(paramMessage.id, Byte.valueOf((byte) 11));
        }
    }

    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131689557;
    }

    public void M0() {
        this.h = ((ChatSession) getIntent().getSerializableExtra("ATTR_CHAT_SESSION"));
        Object localObject = (RecyclerView) findViewById(2131231391);
        this.e = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        this.e.setItemAnimator(new androidx.recyclerview.widget.e());
        registerForContextMenu(this.e);
        localObject = new j();
        this.f = ((j) localObject);
        this.e.setAdapter((RecyclerView.h) localObject);
        a1();
        localObject = new r3.b(this);
        this.g = ((r3.b) localObject);
        ((r3.b) localObject).n(this);
        this.g.l(getString(2131690038));
        this.g.i(2131689520, 2131689522);
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.i = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).a(this.f);
        k.e(this).b((int) this.h.id);
    }

    public void S() {
        this.g.dismiss();
    }

    public void m() {
        a.c(this.h.id);
        j5.b.h(this.h.id);
        this.g.dismiss();
        finish();
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131230934) {
            paramMenuItem = this.f.K();
            this.f.L(paramMenuItem);
            j5.b.d(paramMenuItem.id);
            if (this.f.d() == 0) {
                a.c(this.h.id);
                j5.b.h(this.h.id);
            }
            this.i.a(this.f);
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        paramContextMenu.add(1, 2131230934, 1, getString(2131689528));
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165662);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        a.t(this.h.id, 0);
        this.h = a.l(0L, 3);
        Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
        localIntent.putExtra("ATTR_CHAT_SESSION", this.h);
        HoxinApplication.t(localIntent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            this.g.show();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.SystemMessageActivity

 * JD-Core Version:    0.7.0.1

 */