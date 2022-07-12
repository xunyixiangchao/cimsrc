package com.farsunset.hoxin.home.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.widget.CharSelectorBar;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import java.util.List;

import s3.c0;
import t4.d;

public class ContactsFragment
        extends t3.a
        implements c0 {
    private RecyclerView a;
    private ContactsChangedReceiver b;
    private d c;
    private t4.c d;
    private t4.b e;
    private LinearLayoutManager f;

    private void n() {
        this.c.k(0);
        long l = j5.b.b("105");
        ((HomeActivity) getContext()).e1(2131231499, (int) l);
    }

    private void p() {
        this.d.a();
        this.c.M(i4.a.f());
        this.e.K(this.c.J());
    }

    public void E0(char paramChar) {
        int i = this.c.K(paramChar);
        if (i != -1) {
            this.f.z2(i, 0);
        }
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (i5.a.c.contains(paramMessage.action)) {
            paramChatSession = i4.a.l(paramMessage.sender.longValue());
            this.c.L(paramChatSession);
        }
        if ("105".equals(paramMessage.action)) {
            this.d.a();
            n();
        }
        if (i5.a.f.contains(paramMessage.action)) {
            p();
        }
    }

    public void o() {
        this.a.k1(0);
    }

    public void onAttach(Context paramContext) {
        super.onAttach(paramContext);
        d3.b.c();
        paramContext = new ContactsChangedReceiver();
        this.b = paramContext;
        HoxinApplication.q(paramContext, "com.farsunset.hoxin.ACTION_RELOAD_CONTACTS");
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2131427441, paramViewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
        HoxinApplication.D(this.b);
    }

    public void onResume() {
        super.onResume();
        n();
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        paramBundle = (CharSelectorBar) e(2131231441);
        paramBundle.setTextView((TextView) e(2131230944));
        paramBundle.setOnTouchMoveCharListener(this);
        paramView = (RecyclerView) paramView.findViewById(2131231391);
        this.a = paramView;
        paramBundle = new LinearLayoutManager(getContext());
        this.f = paramBundle;
        paramView.setLayoutManager(paramBundle);
        paramView = new t4.c(e(2131231041));
        this.d = paramView;
        paramView.a();
        this.c = new d();
        paramView = new t4.b();
        this.e = paramView;
        paramView = new androidx.recyclerview.widget.c(new RecyclerView.h[]{this.c, paramView});
        this.a.setAdapter(paramView);
        p();
    }

    public class ContactsChangedReceiver
            extends BroadcastReceiver {
        public ContactsChangedReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            ContactsFragment.l(ContactsFragment.this);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.fragment.ContactsFragment

 * JD-Core Version:    0.7.0.1

 */