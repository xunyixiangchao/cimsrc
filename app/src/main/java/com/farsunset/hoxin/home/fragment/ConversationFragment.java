package com.farsunset.hoxin.home.fragment;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import b5.d;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import com.farsunset.hoxin.message.ui.GroupChatActivity;
import com.farsunset.hoxin.message.ui.SystemMessageActivity;
import com.farsunset.hoxin.micro.ui.MicroServerWindowActivity;

import java.util.Collections;
import java.util.List;

import n3.c;
import s3.h;
import s3.l;

public class ConversationFragment
        extends t3.a
        implements l, z4.a, h<ChatSession> {
    private l5.a<ChatSession> a;
    private d b;
    private RecyclerView c;
    private View d;
    private r3.b e;
    private ChatBroadcastReceiver f;
    private HomeActivity g;

    private void q(ChatSession paramChatSession) {
        j5.a.b(paramChatSession);
        this.b.K(paramChatSession);
    }

    private void r() {
        this.b.I(j5.a.h());
        w();
    }

    private void s(ChatSession paramChatSession) {
        paramChatSession.badge = 0;
        j5.a.t(paramChatSession.id, 0);
        this.b.K(paramChatSession);
        this.g.e1(2131231501, j5.a.o());
    }

    private void t(ChatSession paramChatSession) {
        paramChatSession.badge = 1;
        j5.a.t(paramChatSession.id, 1);
        this.b.K(paramChatSession);
        this.g.e1(2131231501, j5.a.o());
    }

    private void u(ChatSession paramChatSession) {
        j5.a.s(paramChatSession);
        this.b.K(paramChatSession);
    }

    private void w() {
        View localView = this.d;
        int i;
        if (this.b.J()) {
            i = 0;
        } else {
            i = 8;
        }
        localView.setVisibility(i);
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (paramChatSession == null) {
            return;
        }
        this.b.K(paramChatSession);
        this.c.s1(0);
        w();
        this.g.e1(2131231501, j5.a.o());
    }

    public void S() {
        this.e.dismiss();
    }

    public void d(ChatSession paramChatSession) {
        View localView = this.c.findViewWithTag(paramChatSession).findViewWithTag(Integer.valueOf(2131230721));
        com.google.android.material.badge.a locala = (com.google.android.material.badge.a) localView.getTag(2131230820);
        l5.a locala1 = this.a;
        long l = paramChatSession.priority;
        boolean bool2 = true;
        boolean bool1;
        if (l > 0L) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        if ((locala == null) || (!locala.isVisible())) {
            bool2 = false;
        }
        locala1.b(bool1, bool2);
        this.a.e(paramChatSession, (View) localView.getParent());
    }

    public void k(ChatSession paramChatSession) {
        Intent localIntent = new Intent();
        localIntent.putExtra("ATTR_CHAT_SESSION", paramChatSession);
        if (paramChatSession.sourceType == 2) {
            localIntent.setClass(getContext(), GroupChatActivity.class);
        }
        if (paramChatSession.sourceType == 1) {
            localIntent.setClass(getContext(), FriendChatActivity.class);
        }
        if (paramChatSession.sourceType == 4) {
            localIntent.setClass(getContext(), MicroServerWindowActivity.class);
        }
        if (paramChatSession.sourceType == 3) {
            localIntent.setClass(getContext(), SystemMessageActivity.class);
        }
        startActivity(localIntent);
    }

    public void m() {
        this.e.dismiss();
        ChatSession localChatSession = (ChatSession) this.e.e();
        this.b.M(localChatSession);
        j5.a.c(localChatSession.id);
        j5.b.h(localChatSession.id);
        w();
        this.g.e1(2131231501, j5.a.o());
    }

    public void onAttach(Context paramContext) {
        super.onAttach(paramContext);
        paramContext = new ChatBroadcastReceiver();
        this.f = paramContext;
        HoxinApplication.p(paramContext, paramContext.a());
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.g = ((HomeActivity) getActivity());
        return paramLayoutInflater.inflate(2131427442, paramViewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
        HoxinApplication.D(this.f);
    }

    public void onResume() {
        super.onResume();
        this.g.e1(2131231501, j5.a.o());
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        paramView = (RecyclerView) e(2131230914);
        this.c = paramView;
        paramView.setItemAnimator(new androidx.recyclerview.widget.e());
        this.c.setLayoutManager(new LinearLayoutManager(getActivity()));
        paramView = new d();
        this.b = paramView;
        this.c.setAdapter(paramView);
        this.b.P(this);
        paramView = new r3.b(getActivity());
        this.e = paramView;
        paramView.n(this);
        this.e.k(2131690036);
        paramView = new l5.a(getActivity());
        this.a = paramView;
        paramView.d(this);
        this.d = e(2131230981);
        r();
    }

    public List<String> r0() {
        return Collections.singletonList("108");
    }

    public void v(int paramInt, ChatSession paramChatSession) {
        if (paramInt == 2131231201) {
            this.e.o(paramChatSession);
            this.e.show();
        }
        if (paramInt == 2131231218) {
            t(paramChatSession);
        }
        if (paramInt == 2131231217) {
            s(paramChatSession);
        }
        if (paramInt == 2131231196) {
            u(paramChatSession);
        }
        if (paramInt == 2131231195) {
            q(paramChatSession);
        }
    }

    public class ChatBroadcastReceiver
            extends BroadcastReceiver {
        public ChatBroadcastReceiver() {
        }

        IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_REFRESH_LIST");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_ENABLE_LISTENER");
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_RECENT_DISABLE_LISTENER");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            if ("com.farsunset.hoxin.ACTION_RECENT_REFRESH_LIST".equals(paramIntent.getAction())) {
                ConversationFragment.l(ConversationFragment.this);
                ConversationFragment.n(ConversationFragment.this).e1(2131231501, j5.a.o());
                return;
            }
            if ("com.farsunset.hoxin.ACTION_RECENT_ENABLE_LISTENER".equals(paramIntent.getAction())) {
                c.h(ConversationFragment.this);
                return;
            }
            if ("com.farsunset.hoxin.ACTION_RECENT_DISABLE_LISTENER".equals(paramIntent.getAction())) {
                c.i(ConversationFragment.this);
                return;
            }
            if ((!"com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT".equals(paramIntent.getAction())) && (!"com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT".equals(paramIntent.getAction()))) {
                if ("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT".equals(paramIntent.getAction())) {
                    ConversationFragment.o(ConversationFragment.this).M((ChatSession) paramIntent.getSerializableExtra("ATTR_CHAT_SESSION"));
                    ConversationFragment.n(ConversationFragment.this).e1(2131231501, j5.a.o());
                    ConversationFragment.p(ConversationFragment.this);
                    return;
                }
                if ("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE".equals(paramIntent.getAction())) {
                    ConversationFragment.o(ConversationFragment.this).L((ChatSession) paramIntent.getSerializableExtra("ATTR_CHAT_SESSION"));
                }
                return;
            }
            ConversationFragment.o(ConversationFragment.this).K((ChatSession) paramIntent.getSerializableExtra("ATTR_CHAT_SESSION"));
            ConversationFragment.n(ConversationFragment.this).e1(2131231501, j5.a.o());
            ConversationFragment.p(ConversationFragment.this);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.fragment.ConversationFragment

 * JD-Core Version:    0.7.0.1

 */