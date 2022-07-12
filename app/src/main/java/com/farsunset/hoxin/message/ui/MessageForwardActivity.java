package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.c;

import b5.f;
import b5.g;
import b5.i;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import j5.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import s3.a0;
import s3.p;
import s3.y;
import v3.h;

public class MessageForwardActivity
        extends BaseActivity
        implements y, a0, s3.l, p<ChatSession> {
    public static final int[] o = {2, 1};
    private g e;
    private f f;
    protected l5.b g;
    protected Message h;
    protected final ArrayList<ChatSession> i = new ArrayList();
    private RecyclerView j;
    private Button k;
    private RecyclerView l;
    private i m;
    private EventReceiver n;

    public int H0() {
        return 2131427386;
    }

    public int I0() {
        return 2131690163;
    }

    protected void M0() {
        Object localObject = a1();
        this.h = ((Message) localObject);
        ((Message) localObject).sender = i3.e.o();
        localObject = (RecyclerView) findViewById(2131231391);
        this.j = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        this.j.setItemAnimator(new androidx.recyclerview.widget.e());
        localObject = new g();
        this.e = ((g) localObject);
        ((g) localObject).I(a.i(o), null);
        this.e.O(this);
        localObject = new f();
        this.f = ((f) localObject);
        localObject = new c(new RecyclerView.h[]{localObject, this.e});
        this.j.setAdapter((RecyclerView.h) localObject);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        ((ToolbarSearchView) localObject).setHint(2131689624);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        localObject = (RecyclerView) findViewById(2131231430);
        this.l = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.l.h(new h(u3.l.p(5.0F)));
        this.l.setItemAnimator(new androidx.recyclerview.widget.e());
        localObject = this.l;
        i locali = new i();
        this.m = locali;
        ((RecyclerView) localObject).setAdapter(locali);
        this.m.M(this);
        localObject = new l5.b(this);
        this.g = ((l5.b) localObject);
        ((l5.b) localObject).h(this);
        localObject = new EventReceiver();
        this.n = ((EventReceiver) localObject);
        HoxinApplication.p((BroadcastReceiver) localObject, ((EventReceiver) localObject).a());
    }

    public void S() {
        this.g.dismiss();
    }

    protected Message a1() {
        Message localMessage = (Message) getIntent().getSerializableExtra(Message.NAME);
        this.h = localMessage;
        return localMessage;
    }

    protected void b1() {
        J0();
        X0(2131690082);
        finish();
    }

    protected void c1() {
        J0();
        X0(2131690081);
        finish();
    }

    public void d1(ChatSession paramChatSession, View paramView) {
        u3.l.y0(this.j.findViewWithTag(paramChatSession), false);
        this.e.J(paramChatSession);
        f0(paramChatSession);
    }

    public void f0(ChatSession paramChatSession) {
        this.m.L(paramChatSession);
        int i1;
        if (this.e.K().isEmpty()) {
            paramChatSession = this.k;
            i1 = 2131689556;
        } else {
            paramChatSession = this.k;
            i1 = 2131689555;
        }
        paramChatSession.setTag(Integer.valueOf(i1));
        this.k.setText(i1);
    }

    public void h0(String paramString) {
        List localList;
        if (TextUtils.isEmpty(paramString.trim())) {
            localList = a.i(o);
        } else {
            localList = a.j(o, paramString);
        }
        this.f.I(localList.isEmpty() ^ true);
        this.e.I(localList, paramString);
    }

    public void k(ChatSession paramChatSession) {
        this.i.clear();
        this.i.add(paramChatSession);
        this.g.g(this.h);
        this.g.i(paramChatSession);
    }

    public void m() {
        this.g.dismiss();
        U0(getString(2131690077, new Object[]{getString(2131689555)}));
        p5.b.a(this.h, this.i);
    }

    public boolean n(ChatSession paramChatSession) {
        this.m.I(paramChatSession);
        this.k.setEnabled(true);
        this.l.s1(this.m.d());
        this.k.setTag(Integer.valueOf(2131689555));
        this.k.setText(2131689555);
        return true;
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt2 != -1) {
            return;
        }
        Object localObject = (List) paramIntent.getSerializableExtra("ATTR_LIST");
        if (localObject != null) {
            if (((List) localObject).isEmpty()) {
                return;
            }
            paramIntent = new LinkedList();
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                paramIntent.add(ChatSession.of((MessageSource) ((Iterator) localObject).next()));
            }
            paramIntent.removeAll(this.e.K());
            this.e.K().addAll(paramIntent);
            this.e.j();
            paramIntent = paramIntent.iterator();
            while (paramIntent.hasNext()) {
                n((ChatSession) paramIntent.next());
            }
        }
    }

    public void onClick(View paramView) {
        Button localButton = this.k;
        if ((paramView == localButton) && (localButton.getTag().equals(Integer.valueOf(2131689555)))) {
            this.i.clear();
            this.i.addAll(this.e.K());
            this.g.g(this.h);
            this.g.j(this.e.K());
            return;
        }
        localButton = this.k;
        if ((paramView == localButton) && (localButton.getTag().equals(Integer.valueOf(2131689542)))) {
            this.e.N(true);
            this.e.j();
            this.k.setTag(Integer.valueOf(2131689556));
            this.k.setText(2131689556);
            return;
        }
        localButton = this.k;
        if ((paramView == localButton) && (localButton.getTag().equals(Integer.valueOf(2131689556)))) {
            this.e.N(false);
            this.e.j();
            this.k.setTag(Integer.valueOf(2131689542));
            this.k.setText(2131689542);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        this.k = localButton;
        localButton.setOnClickListener(this);
        this.k.setText(2131689542);
        this.k.setTag(Integer.valueOf(2131689542));
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        HoxinApplication.D(this.n);
    }

    public class EventReceiver
            extends BroadcastReceiver {
        public EventReceiver() {
        }

        IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_MESSAGE_FORWARD_ERROR");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_MESSAGE_FORWARD_FINISH");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_MESSAGE_FORWARD_ERROR")) {
                MessageForwardActivity.this.b1();
                return;
            }
            MessageForwardActivity.this.c1();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.MessageForwardActivity

 * JD-Core Version:    0.7.0.1

 */