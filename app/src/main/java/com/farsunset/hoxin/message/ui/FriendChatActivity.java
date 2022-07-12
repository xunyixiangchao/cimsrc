package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.k;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.widget.CustomSwipeRefreshLayout;
import com.farsunset.hoxin.common.widget.SimpleInputPanelView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.message.model.ChatVoice;
import com.farsunset.hoxin.message.widget.ChatRecordListView;
import com.farsunset.hoxin.message.widget.ChattingInputPanelView;
import com.farsunset.hoxin.message.widget.RecordingButton;

import i3.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import r5.g;
import r5.h;
import s3.b0;
import s3.z;
import u3.i0;
import u3.j0;
import u3.l;

public class FriendChatActivity
        extends CIMMonitorActivity
        implements s3.n, b0, SwipeRefreshLayout.j, z<ChatVoice>, r5.c, g, r5.a, h, r5.b, a7.b {
    private User e;
    private CustomSwipeRefreshLayout f;
    protected b5.c g;
    protected ChatRecordListView h;
    protected ChattingInputPanelView i;
    protected ChatSession j;
    protected final q5.a k = new q5.a();
    private String l;
    private final androidx.core.app.n m = new a();
    Handler n = new b();

    private void e1() {
        ChattingInputPanelView localChattingInputPanelView = (ChattingInputPanelView) ((ViewStub) findViewById(2131231089)).inflate();
        this.i = localChattingInputPanelView;
        localChattingInputPanelView.setOnInputPanelEventListener(this);
        this.i.setTag(2131231522, this.j);
        this.i.setOnEmoticonClickedListener(this);
        this.i.setOnCallMenuClickListener(this);
        ((RecordingButton) this.i.findViewById(2131231620)).setOnRecordCompletedListener(this);
    }

    private void f1() {
        this.h.setOnQuoteMessageListener(this);
        this.h.setOnQuoteMessageListener(this);
        this.h.setOnTouchDownListener(this);
        this.h.setOnAddMessageListener(this);
        this.h.setOnRedoMessageListener(this);
        this.h.setOnClickMessageListener(this);
    }

    private void g1(Intent paramIntent) {
        this.k.b();
        this.k.i(null);
        paramIntent = (ChatSession) paramIntent.getSerializableExtra("ATTR_CHAT_SESSION");
        this.j = paramIntent;
        if (paramIntent.id == 0L) {
            paramIntent.id = j5.a.e(paramIntent.sourceId, paramIntent.sourceType);
        }
        k.e(this).b((int) this.j.id);
    }

    private void m1(Intent paramIntent) {
        if ("com.farsunset.hoxin.ACTION_TAKE_PHOTO".equals(paramIntent.getAction())) {
            CloudImage localCloudImage = (CloudImage) paramIntent.getSerializableExtra(CloudImage.class.getName());
            localCloudImage.bucket = o3.b.f.a();
            q1(l.H0(localCloudImage), (byte) 1);
        }
        if ("com.farsunset.hoxin.ACTION_TAKE_VIDEO".equals(paramIntent.getAction())) {
            paramIntent = (CloudVideo) paramIntent.getSerializableExtra(CloudVideo.class.getName());
            paramIntent.bucket = o3.b.f.a();
            q1(l.H0(paramIntent), (byte) 3);
        }
    }

    private void p1(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.g.J(paramMessage);
        n5.b.a(paramMessage, false);
        this.h.H1();
        int i1 = paramMessage.format;
        if ((1 == i1) || (4 == i1) || (5 == i1) || (3 == i1)) {
            this.i.m();
        }
    }

    private void q1(String paramString, byte paramByte) {
        Object localObject = this.i.getQuoteMessage();
        if (localObject != null) {
            this.k.i(Long.valueOf(((com.farsunset.hoxin.message.entity.Message) localObject).id));
            localObject = this.k.toString();
        } else {
            localObject = null;
        }
        r1(paramString, (String) localObject, paramByte);
    }

    public void E(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.g.J(paramMessage);
        this.h.H1();
    }

    public void H(ChatSession paramChatSession, com.farsunset.hoxin.message.entity.Message paramMessage) {
        if (!this.j.equals(paramChatSession)) {
            return;
        }
        if (paramMessage.isSingleChatMessage()) {
            this.n.sendEmptyMessage(0);
            this.g.J(paramMessage);
            this.h.I1();
        }
        if ("100".equals(paramMessage.action)) {
            this.g.U(Long.parseLong(paramMessage.content));
        }
        if ("101".equals(paramMessage.action)) {
            this.g.P(Long.parseLong(paramMessage.content));
        }
        if ("108".equals(paramMessage.action)) {
            this.n.removeCallbacksAndMessages(null);
            this.n.sendEmptyMessageDelayed(0, 3000L);
            Q0(2131690001);
        }
    }

    public int H0() {
        return 2131427359;
    }

    public void L(com.farsunset.hoxin.message.entity.Message paramMessage) {
        ArrayList localArrayList = new ArrayList();
        List localList = this.g.Q();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add((CloudImage) l.s0(((com.farsunset.hoxin.message.entity.Message) localIterator.next()).content, CloudImage.class));
        }
        int i1 = localList.indexOf(paramMessage);
        paramMessage = l.w((CloudImage) l.s0(paramMessage.content, CloudImage.class));
        paramMessage = this.h.findViewWithTag(paramMessage);
        if (paramMessage != null) {
            HoxinApplication.h().x(this, localArrayList, i1, paramMessage);
        }
    }

    protected void M0() {
        g1(getIntent());
        h1();
        this.e = e.g();
        e1();
        Object localObject = (ChatRecordListView) findViewById(2131230874);
        this.h = ((ChatRecordListView) localObject);
        b5.c localc = new b5.c(this.j);
        this.g = localc;
        ((RecyclerView) localObject).setAdapter(localc);
        f1();
        i1();
        localObject = (CustomSwipeRefreshLayout) findViewById(2131231489);
        this.f = ((CustomSwipeRefreshLayout) localObject);
        ((SwipeRefreshLayout) localObject).setOnRefreshListener(this);
        setExitSharedElementCallback(this.m);
    }

    public void R() {
        this.f.x();
        l1();
    }

    public void V() {
        this.i.h();
    }

    protected void c1(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.h.F1(this.g.M(paramMessage));
    }

    public void d0(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.i.setInputText(paramMessage.content);
    }

    String d1() {
        return "0";
    }

    protected void h1() {
        S0(this.j.name);
        Friend localFriend = i4.a.l(this.j.sourceId);
        int i1 = localFriend.type;
        if ((i1 == 1) || (i1 == 2)) {
            R0(p6.c.e(localFriend.id));
        }
    }

    protected void i1() {
        List localList = j5.b.r(Long.valueOf(this.j.id), this.g.L(), 10L);
        if (localList.isEmpty()) {
            return;
        }
        int i1 = this.g.d();
        this.g.I(localList);
        if (i1 != 0) {
            this.h.k1(this.g.d() - i1 - 1);
        }
    }

    public void j(EmoticonItem paramEmoticonItem) {
        ChatEmoticon localChatEmoticon = new ChatEmoticon();
        localChatEmoticon.id = paramEmoticonItem.emoticonId.longValue();
        localChatEmoticon.itemId = paramEmoticonItem.id.longValue();
        localChatEmoticon.name = paramEmoticonItem.name;
        localChatEmoticon.type = paramEmoticonItem.type;
        q1(l.H0(localChatEmoticon), (byte) 15);
    }

    public void j0() {
    }

    protected void j1(Menu paramMenu) {
        getMenuInflater().inflate(2131492871, paramMenu);
    }

    protected void k1() {
        Intent localIntent = new Intent(this, MessageSearchActivity.class);
        localIntent.putExtra("ATTR_CHAT_SESSION", this.j);
        startActivity(localIntent);
    }

    public void l(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.i.w(paramMessage);
    }

    protected void l1() {
        i1();
    }

    public void n0(String paramString) {
        q1(paramString, (byte) 0);
        this.i.f();
        this.i.x();
    }

    public void n1(ChatVoice paramChatVoice) {
        q1(l.H0(paramChatVoice), (byte) 2);
    }

    public void o() {
        HoxinApplication.h().v(this.j);
    }

    protected void o1() {
        j0.a(this, this.j.sourceId);
    }

    public void onActivityReenter(int paramInt, Intent paramIntent) {
        super.onActivityReenter(paramInt, paramIntent);
        this.l = paramIntent.getStringExtra("ATTR_URL");
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 1)) {
            m1(paramIntent);
        }
        if ((paramInt2 == -1) && (paramInt1 == 2) && (l.f0(paramIntent.getType()))) {
            q1(l.H0(l.o0(paramIntent.getData(), o3.b.f)), (byte) 3);
        }
        Object localObject;
        if ((paramInt2 == -1) && (paramInt1 == 2) && (l.b0(paramIntent.getType()))) {
            localObject = new CloudImage();
            ((CloudImage) localObject).uri = paramIntent.getData().toString();
            ((CloudImage) localObject).bucket = o3.b.f.a();
            q1(l.H0(localObject), (byte) 1);
        }
        if ((paramInt2 == -1) && (paramInt1 == 3)) {
            q1(l.H0((ChatFile) paramIntent.getSerializableExtra(ChatFile.class.getName())), (byte) 4);
        }
        if ((paramInt2 == -1) && (paramInt1 == 4)) {
            q1(l.H0((ChatMap) paramIntent.getSerializableExtra(ChatMap.class.getName())), (byte) 5);
        }
        if ((paramInt2 == -1) && (paramInt1 == 8155)) {
            paramIntent = (Friend) paramIntent.getSerializableExtra("ATTR_FRIEND");
            localObject = new ChatProfile();
            ((ChatProfile) localObject).id = Long.valueOf(paramIntent.id);
            ((ChatProfile) localObject).name = paramIntent.name;
            q1(l.H0(localObject), (byte) 14);
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        j1(paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        i0.a().e();
        j5.a.t(this.j.id, 0);
        Object localObject = this.j;
        this.j = j5.a.l(((ChatSession) localObject).sourceId, ((ChatSession) localObject).sourceType);
        localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
        ((Intent) localObject).putExtra("ATTR_CHAT_SESSION", this.j);
        HoxinApplication.t((Intent) localObject);
        this.n.removeCallbacksAndMessages(null);
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        g1(paramIntent);
        h1();
        paramIntent = this.h;
        b5.c localc = new b5.c(this.j);
        this.g = localc;
        paramIntent.setAdapter(localc);
        i1();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231211) {
            o1();
        }
        if (paramMenuItem.getItemId() == 2131231240) {
            k1();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPause() {
        super.onPause();
        i0.a().e();
    }

    public void q(boolean paramBoolean) {
        if (paramBoolean) {
            this.h.H1();
        }
    }

    public void q0(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            f5.a.h(this.j.sourceId);
        }
    }

    protected void r1(String paramString1, String paramString2, byte paramByte) {
        com.farsunset.hoxin.message.entity.Message localMessage = new com.farsunset.hoxin.message.entity.Message();
        localMessage.id = System.currentTimeMillis();
        localMessage.sender = Long.valueOf(this.e.id);
        localMessage.receiver = Long.valueOf(this.j.sourceId);
        localMessage.action = d1();
        localMessage.createTime = Long.valueOf(System.currentTimeMillis());
        localMessage.state = Byte.valueOf((byte) 0);
        localMessage.content = paramString1;
        localMessage.format = paramByte;
        localMessage.title = paramString2;
        localMessage.direction = 1;
        p1(localMessage);
    }

    public void u() {
        HoxinApplication.h().u(this.j);
    }

    class a
            extends androidx.core.app.n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            if (FriendChatActivity.a1(FriendChatActivity.this) != null) {
                paramList = FriendChatActivity.this;
                View localView = paramList.h.findViewWithTag(FriendChatActivity.a1(paramList));
                String str = FriendChatActivity.a1(FriendChatActivity.this);
                paramList = localView;
                if (localView == null) {
                    paramList = FriendChatActivity.this.findViewById(2131230805);
                }
                paramMap.put(str, paramList);
                FriendChatActivity.b1(FriendChatActivity.this, null);
            }
        }
    }

    class b
            extends Handler {
        b() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            paramMessage = FriendChatActivity.this;
            paramMessage.R0(p6.c.e(paramMessage.j.sourceId));
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.FriendChatActivity

 * JD-Core Version:    0.7.0.1

 */