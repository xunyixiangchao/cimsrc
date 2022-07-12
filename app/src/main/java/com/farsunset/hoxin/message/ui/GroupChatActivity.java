package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.SimpleInputPanelView;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.entity.GroupMember;
import com.farsunset.hoxin.group.ui.GroupDetailedActivity;
import com.farsunset.hoxin.group.ui.GroupMemberSelectorActivity;
import com.farsunset.hoxin.group.ui.GroupMessageSearchActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.widget.ChatRecordListView;
import com.farsunset.hoxin.webrtc.ui.CreateRoomActivity;

import g0.g;

import java.util.Iterator;
import java.util.Set;

import n5.b;
import u3.d;
import u3.l;

public class GroupChatActivity
        extends FriendChatActivity {
    private long o;
    private final g0.a<String, Long> p = new g0.a();
    private AtMemberReceiver q;

    private void t1(GroupMember paramGroupMember) {
        Object localObject = new StringBuilder(this.i.getInputText());
        ((StringBuilder) localObject).append('@');
        ((StringBuilder) localObject).append(paramGroupMember.name);
        ((StringBuilder) localObject).append(" ");
        this.i.e(((StringBuilder) localObject).toString());
        this.k.a(Long.valueOf(paramGroupMember.uid));
        localObject = this.p;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("@");
        localStringBuilder.append(paramGroupMember.name);
        ((g) localObject).put(localStringBuilder.toString(), Long.valueOf(paramGroupMember.uid));
    }

    private void u1() {
        if (p4.a.j(Long.valueOf(this.o))) {
        }
        while ((p4.a.i(Long.valueOf(this.o))) && (!p4.a.k(this.o))) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        K0();
        if (d.s(Long.valueOf(this.o))) {
            W0(2131165429);
        }
        if (p4.a.i(Long.valueOf(this.o))) {
            W0(2131165547);
        }
    }

    private void v1() {
        StringBuilder localStringBuilder = new StringBuilder(this.i.getInputText());
        if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == '@')) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            this.i.e(localStringBuilder.toString());
        }
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
        if (("3".equals(paramMessage.action)) && (this.j.equals(paramChatSession))) {
            this.g.J(paramMessage);
            this.h.I1();
            paramMessage.state = Byte.valueOf((byte) 11);
            b.c(paramMessage);
        }
        if ("310".equals(paramMessage.action)) {
            this.g.P(Long.parseLong(paramMessage.content));
        }
    }

    public int H0() {
        return 2131427360;
    }

    public void M0() {
        super.M0();
        this.o = this.j.sourceId;
        AtMemberReceiver localAtMemberReceiver = new AtMemberReceiver();
        this.q = localAtMemberReceiver;
        HoxinApplication.q(localAtMemberReceiver, "com.farsunset.hoxin.ACTION_ICON_LONG_CLICKED");
        u1();
    }

    public String d1() {
        return "3";
    }

    protected void h1() {
        S0(this.j.name);
    }

    public void j0() {
        Intent localIntent = new Intent(this, GroupMemberSelectorActivity.class);
        localIntent.putExtra("ATTR_GROUP_ID", this.o);
        startActivityForResult(localIntent, 123);
    }

    protected void j1(Menu paramMenu) {
        getMenuInflater().inflate(2131492873, paramMenu);
        if (p4.a.j(Long.valueOf(this.o))) {
            paramMenu.findItem(2131231211).setVisible(false);
        }
    }

    protected void k1() {
        Intent localIntent = new Intent(this, GroupMessageSearchActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("ATTR_CHAT_SESSION", this.j);
        startActivity(localIntent);
    }

    public void o() {
        Intent localIntent = new Intent(this, CreateRoomActivity.class);
        localIntent.putExtra("ATTR_GROUP_ID", this.j.sourceId);
        localIntent.setAction("com.farsunset.hoxin.ACTION_VIDEO_CALL_ROOM");
        startActivity(localIntent);
    }

    public void o1() {
        Intent localIntent = new Intent(this, GroupDetailedActivity.class);
        localIntent.putExtra(Group.NAME, p4.a.h(Long.valueOf(this.o)));
        startActivity(localIntent);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt1 == 123) && (paramInt2 == -1)) {
            paramIntent = (GroupMember) paramIntent.getSerializableExtra(GroupMember.class.getName());
            v1();
            t1(paramIntent);
        }
        if ((paramInt1 == 123) && (paramInt2 == 0)) {
            v1();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d.c(this.o);
        d.d(this.o);
        HoxinApplication.D(this.q);
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        this.o = this.j.sourceId;
    }

    public void onResume() {
        super.onResume();
        u1();
    }

    public void q0(String paramString) {
    }

    public void r1(String paramString1, String paramString2, byte paramByte) {
        paramString2 = this.p.keySet().iterator();
        while (paramString2.hasNext()) {
            String str = (String) paramString2.next();
            if (!paramString1.contains(str)) {
                this.k.h((Long) this.p.get(str));
            }
        }
        super.r1(paramString1, this.k.toString(), paramByte);
        this.p.clear();
        this.k.b();
    }

    public void u() {
        Intent localIntent = new Intent(this, CreateRoomActivity.class);
        localIntent.putExtra("ATTR_GROUP_ID", this.j.sourceId);
        localIntent.setAction("com.farsunset.hoxin.ACTION_VOICE_CALL_ROOM");
        startActivity(localIntent);
    }

    public class AtMemberReceiver
            extends BroadcastReceiver {
        public AtMemberReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            paramContext = (GroupMember) paramIntent.getSerializableExtra(GroupMember.class.getName());
            GroupChatActivity.s1(GroupChatActivity.this, paramContext);
            l.J0(20);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.GroupChatActivity

 * JD-Core Version:    0.7.0.1

 */