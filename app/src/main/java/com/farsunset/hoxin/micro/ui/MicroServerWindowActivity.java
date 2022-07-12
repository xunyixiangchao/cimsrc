package com.farsunset.hoxin.micro.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;

import b5.h;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.common.widget.CustomSwipeRefreshLayout;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.widget.ChatRecordListView;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import com.farsunset.hoxin.micro.widget.MicroServerInputPanelView;

import i3.e;

import java.util.List;

import s3.b0;
import s3.n;
import s3.u;

public class MicroServerWindowActivity
        extends CIMMonitorActivity
        implements n, b0, SwipeRefreshLayout.j, u<MicroServerMenu> {
    private User e;
    private h f;
    private ChatRecordListView g;
    private MicroServerInputPanelView h;
    private View i;
    private CustomSwipeRefreshLayout j;
    private MenuInvokedReceiver k;
    private ChatSession l;
    private MicroServer m;

    private void b1() {
        ChatSession localChatSession = (ChatSession) getIntent().getSerializableExtra("ATTR_CHAT_SESSION");
        this.l = localChatSession;
        if (localChatSession.id == 0L) {
            localChatSession.id = j5.a.e(localChatSession.sourceId, localChatSession.sourceType);
        }
        this.m = x5.a.f(this.l.sourceId);
        androidx.core.app.k.e(this).b((int) this.l.id);
    }

    private void c1() {
        List localList = j5.b.r(Long.valueOf(this.l.id), this.f.L(), 10L);
        if (localList.isEmpty()) {
            return;
        }
        int n = this.f.d();
        this.f.I(localList);
        if (n != 0) {
            this.g.k1(this.f.d() - n - 1);
        }
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (("200".equals(paramMessage.action)) && (this.l.equals(paramChatSession))) {
            this.f.J(paramMessage);
            this.g.H1();
        }
    }

    public int H0() {
        return 2131427391;
    }

    public int I0() {
        return 2131689517;
    }

    public void M0() {
        b1();
        S0(this.l.name);
        this.e = e.g();
        this.g = ((ChatRecordListView) findViewById(2131230874));
        this.i = findViewById(2131231231);
        this.g.setOnTouchDownListener(this);
        Object localObject = (MicroServerInputPanelView) findViewById(2131231088);
        this.h = ((MicroServerInputPanelView) localObject);
        ((MicroServerInputPanelView) localObject).e(x5.b.c(Long.valueOf(this.l.sourceId)));
        this.h.setOnMenuClickListener(this);
        this.h.setOnInputPanelEventListener(this);
        this.e = e.g();
        localObject = new h(this.l);
        this.f = ((h) localObject);
        this.g.setAdapter((RecyclerView.h) localObject);
        c1();
        localObject = (CustomSwipeRefreshLayout) findViewById(2131231489);
        this.j = ((CustomSwipeRefreshLayout) localObject);
        ((SwipeRefreshLayout) localObject).setOnRefreshListener(this);
        localObject = new MenuInvokedReceiver();
        this.k = ((MenuInvokedReceiver) localObject);
        HoxinApplication.q((BroadcastReceiver) localObject, "com.farsunset.hoxin.ACTION_MICRO_SERVER_INVOKED");
    }

    public void R() {
        c1();
        this.j.x();
    }

    public void V() {
        this.h.i();
    }

    public void d1(MicroServerMenu paramMicroServerMenu) {
        if (paramMicroServerMenu.isWebMenu()) {
            localObject = new Intent(this, WebViewActivity.class);
            ((Intent) localObject).setData(Uri.parse(paramMicroServerMenu.content));
            startActivity((Intent) localObject);
            return;
        }
        if (paramMicroServerMenu.isApiMenu()) {
            this.i.setVisibility(0);
            v5.b.e(this.m, paramMicroServerMenu);
            return;
        }
        Object localObject = new Message();
        ((Message) localObject).content = paramMicroServerMenu.content;
        ((Message) localObject).sender = Long.valueOf(this.l.sourceId);
        ((Message) localObject).receiver = Long.valueOf(this.e.id);
        ((Message) localObject).format = 0;
        ((Message) localObject).action = "200";
        ((Message) localObject).state = Byte.valueOf((byte) 10);
        ((Message) localObject).id = System.currentTimeMillis();
        ((Message) localObject).createTime = Long.valueOf(System.currentTimeMillis());
        ((Message) localObject).content = paramMicroServerMenu.content;
        ((Message) localObject).state = Byte.valueOf((byte) 11);
        m5.k.c((Message) localObject);
    }

    public void j0() {
    }

    public void n0(String paramString) {
        Message localMessage = new Message();
        localMessage.id = System.currentTimeMillis();
        localMessage.content = paramString;
        localMessage.sender = Long.valueOf(this.e.id);
        localMessage.receiver = Long.valueOf(this.l.sourceId);
        localMessage.format = 0;
        localMessage.action = "200";
        localMessage.createTime = Long.valueOf(System.currentTimeMillis());
        localMessage.state = Byte.valueOf((byte) 0);
        localMessage.direction = 1;
        this.f.J(localMessage);
        this.g.H1();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165663);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        HoxinApplication.D(this.k);
        j5.a.t(this.l.id, 0);
        Object localObject = this.l;
        this.l = j5.a.l(((ChatSession) localObject).sourceId, ((ChatSession) localObject).sourceType);
        localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
        ((Intent) localObject).putExtra("ATTR_CHAT_SESSION", this.l);
        HoxinApplication.t((Intent) localObject);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            Intent localIntent = new Intent(this, MicroServerDetailedActivity.class);
            localIntent.putExtra(MessageSource.NAME, x5.a.f(this.l.sourceId));
            startActivity(localIntent);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void q(boolean paramBoolean) {
        if (paramBoolean) {
            this.g.H1();
        }
    }

    public void q0(String paramString) {
    }

    public class MenuInvokedReceiver
            extends BroadcastReceiver {
        public MenuInvokedReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            MicroServerWindowActivity.a1(MicroServerWindowActivity.this).setVisibility(8);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.MicroServerWindowActivity

 * JD-Core Version:    0.7.0.1

 */