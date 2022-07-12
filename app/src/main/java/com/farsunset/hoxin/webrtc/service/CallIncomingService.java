package com.farsunset.hoxin.webrtc.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;

import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.model.ChatCall;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.ui.CommunicationActivity;
import com.farsunset.hoxin.webrtc.ui.GroupIncomingActivity;
import com.farsunset.hoxin.webrtc.ui.VideoIncomingCallActivity;
import com.farsunset.hoxin.webrtc.ui.VoiceIncomingCallActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import i3.e;

import java.util.Map;

import n3.c;
import u3.b0;
import u3.l;
import u3.r;
import u3.s;

public class CallIncomingService
        extends Service
        implements n3.b {
    private static MediaPlayer j;
    private NotificationManager a;
    private WindowManager b;
    private View c;
    private final ChatCall d = new ChatCall();
    private com.farsunset.hoxin.message.entity.Message e;
    private Friend f;
    private AvRoom g;
    protected GroupCallLog h = new GroupCallLog();
    Handler i = new a();

    private void k(byte paramByte) {
        if (!Settings.canDrawOverlays(this)) {
            return;
        }
        Object localObject1 = new WindowManager.LayoutParams();
        int k;
        if (Build.VERSION.SDK_INT >= 26) {
            k = 2038;
        } else {
            k = 2002;
        }
        ((WindowManager.LayoutParams) localObject1).type = k;
        ((WindowManager.LayoutParams) localObject1).format = 1;
        ((WindowManager.LayoutParams) localObject1).gravity = 48;
        ((WindowManager.LayoutParams) localObject1).flags = 40;
        ((WindowManager.LayoutParams) localObject1).width = -1;
        ((WindowManager.LayoutParams) localObject1).height = -2;
        Object localObject2 = LayoutInflater.from(this).inflate(2131427543, null, false);
        this.c = ((View) localObject2);
        this.b.addView((View) localObject2, (ViewGroup.LayoutParams) localObject1);
        localObject2 = (FloatingActionButton) this.c.findViewById(2131230855);
        localObject1 = (FloatingActionButton) this.c.findViewById(2131230856);
        ((ImageButton) localObject2).setOnClickListener(new b7.a(this, paramByte));
        ((ImageButton) localObject1).setOnClickListener(new b7.b(this, paramByte));
        localObject2 = (WebImageView) this.c.findViewById(2131231150);
        TextView localTextView1 = (TextView) this.c.findViewById(2131231301);
        TextView localTextView2 = (TextView) this.c.findViewById(2131230938);
        ((WebImageView) localObject2).o(b0.l(this.f.id));
        localTextView1.setText(this.f.name);
        if (paramByte == 0) {
            ((FloatingActionButton) localObject1).setImageResource(2131165445);
            localTextView2.setText(getString(2131689615));
        }
        if (1 == paramByte) {
            ((FloatingActionButton) localObject1).setImageResource(2131165446);
            localTextView2.setText(getString(2131689611));
        }
        if (11 == paramByte) {
            ((FloatingActionButton) localObject1).setImageResource(2131165446);
            localTextView2.setText(getString(2131689612));
        }
        if (10 == paramByte) {
            ((FloatingActionButton) localObject1).setImageResource(2131165445);
            localTextView2.setText(getString(2131689616));
        }
    }

    private void l(Bitmap paramBitmap, byte paramByte) {
        Object localObject = PendingIntent.getActivity(this, 1, n(paramByte), 201326592);
        androidx.core.app.h localh = new androidx.core.app.h(this, "REALTIME_CALL_INCOMING_NOTIFICATION");
        localh.e(false);
        localh.k(true);
        localh.q(System.currentTimeMillis());
        localh.n(2131165623);
        localh.l(2);
        if (paramByte == 0) {
            this.e.format = 17;
            localh.o(getString(2131689615));
            localh.g(getString(2131689615));
        }
        if (1 == paramByte) {
            this.e.format = 16;
            localh.g(getString(2131689611));
            localh.o(getString(2131689611));
        }
        if (10 == paramByte) {
            localh.g(getString(2131689616));
            localh.o(getString(2131689612));
        }
        if (11 == paramByte) {
            localh.g(getString(2131689612));
            localh.o(getString(2131689612));
        }
        localh.h(this.f.getName());
        localh.f((PendingIntent) localObject);
        localObject = paramBitmap;
        if (paramBitmap == null) {
            localObject = BitmapFactory.decodeResource(getResources(), 2131165623);
        }
        localh.j((Bitmap) localObject);
        startForeground(2147483647, localh.a());
        paramBitmap = MediaPlayer.create(this, 2131623937);
        j = paramBitmap;
        paramBitmap.setAudioStreamType(3);
        j.setLooping(true);
        j.start();
    }

    private void m(byte paramByte) {
        Object localObject = PendingIntent.getActivity(this, 1, o(paramByte), 201326592);
        androidx.core.app.h localh = new androidx.core.app.h(this, "REALTIME_CALL_INCOMING_NOTIFICATION");
        localh.e(true);
        localh.k(true);
        localh.q(System.currentTimeMillis());
        localh.n(2131165623);
        localh.l(0);
        if (paramByte == 0) {
            localh.o(getString(2131689614));
            localh.g(getString(2131689614));
        }
        if (1 == paramByte) {
            localh.g(getString(2131689610));
            localh.o(getString(2131689610));
        }
        if (10 == paramByte) {
            localh.g(getString(2131689614));
            localh.o(getString(2131689614));
        }
        if (11 == paramByte) {
            localh.g(getString(2131689613));
            localh.o(getString(2131689613));
        }
        localh.h(this.f.getName());
        localh.f((PendingIntent) localObject);
        Bitmap localBitmap = s.a().n(this.f.getWebIcon());
        localObject = localBitmap;
        if (localBitmap == null) {
            localObject = BitmapFactory.decodeResource(getResources(), 2131165623);
        }
        localh.j((Bitmap) localObject);
        localObject = localh.a();
        this.a.notify((int) this.f.id, (Notification) localObject);
    }

    private Intent n(byte paramByte) {
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        if (paramByte == 0) {
            localIntent.setClass(this, VoiceIncomingCallActivity.class);
            localIntent.putExtra("ATTR_CHAT_SESSION", ChatSession.of(this.f));
        }
        if (paramByte == 1) {
            localIntent.setClass(this, VideoIncomingCallActivity.class);
            localIntent.putExtra("ATTR_CHAT_SESSION", ChatSession.of(this.f));
        }
        if ((paramByte == 11) || (paramByte == 10)) {
            localIntent.setClass(this, GroupIncomingActivity.class);
            localIntent.putExtra(AvRoom.class.getName(), this.g);
        }
        return localIntent;
    }

    private Intent o(byte paramByte) {
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        if (paramByte == 0) {
            localIntent.setClass(this, HomeActivity.class);
        }
        if (paramByte == 1) {
            localIntent.setClass(this, HomeActivity.class);
        }
        if ((paramByte == 11) || (paramByte == 10)) {
            localIntent.setClass(this, CommunicationActivity.class);
        }
        return localIntent;
    }

    private void r() {
        this.e.content = l.H0(this.d);
        this.e.createTime = Long.valueOf(System.currentTimeMillis());
        n5.b.a(this.e, true);
        Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT");
        localIntent.putExtra("ATTR_CHAT_SESSION", j5.a.m(this.f));
        HoxinApplication.t(localIntent);
        e.x(0);
        stopSelf();
    }

    private void s() {
        e.x(0);
        u6.b.h(this.f.id);
        Object localObject = this.d;
        ((ChatCall) localObject).state = 2;
        ((ChatCall) localObject).duration = (System.currentTimeMillis() - this.e.createTime.longValue());
        this.e.content = l.H0(this.d);
        j5.b.d(this.e.id);
        n5.b.a(this.e, true);
        stopSelf();
        localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT");
        ((Intent) localObject).putExtra("ATTR_CHAT_SESSION", j5.a.m(this.f));
        HoxinApplication.t((Intent) localObject);
        e.x(0);
    }

    private void t() {
        this.i.removeCallbacksAndMessages(null);
        com.farsunset.cim.sdk.android.h.p(this);
        e.x(0);
        e.b();
        HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_UPDATE_CALL_BADGE"));
        stopSelf();
    }

    private void u() {
        u6.a.k(this.g.getTag());
        e.x(0);
        stopSelf();
    }

    private void v() {
        c.i(this);
        l.o(j);
        stopForeground(true);
        this.a.cancel(74826113);
        View localView = this.c;
        if (localView != null) {
            this.b.removeView(localView);
        }
    }

    public void H(ChatSession paramChatSession, com.farsunset.hoxin.message.entity.Message paramMessage) {
        if ((this.e != null) && ("906".equals(paramMessage.action))) {
            r();
        }
        if (("924".equals(paramMessage.action)) || ("919".equals(paramMessage.action))) {
            t();
        }
        if ("917".equals(paramMessage.action)) {
            this.g.addAll((Map) l.t0(paramMessage.content, new b().getType()));
        }
    }

    public void a() {
    }

    public void b(SentBody paramSentBody) {
    }

    public void f(NetworkInfo paramNetworkInfo) {
    }

    public void g(ReplyBody paramReplyBody) {
    }

    public void h(boolean paramBoolean) {
    }

    public void i() {
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.a = ((NotificationManager) getSystemService("notification"));
        this.b = ((WindowManager) getSystemService("window"));
    }

    public void onDestroy() {
        super.onDestroy();
        v();
        this.i.removeCallbacksAndMessages(null);
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        c.h(this);
        this.f = ((Friend) paramIntent.getSerializableExtra(MessageSource.NAME));
        byte b1 = paramIntent.getByteExtra("ATTR_TYPE", (byte) 0);
        Bitmap localBitmap = (Bitmap) paramIntent.getParcelableExtra("ATTR_LOGO");
        if ((b1 == 1) || (b1 == 0)) {
            Object localObject = this.d;
            ((ChatCall) localObject).type = b1;
            ((ChatCall) localObject).state = 1;
            localObject = new com.farsunset.hoxin.message.entity.Message();
            this.e = ((com.farsunset.hoxin.message.entity.Message) localObject);
            ((com.farsunset.hoxin.message.entity.Message) localObject).id = System.currentTimeMillis();
            this.e.createTime = Long.valueOf(System.currentTimeMillis());
            localObject = this.e;
            ((com.farsunset.hoxin.message.entity.Message) localObject).action = "0";
            ((com.farsunset.hoxin.message.entity.Message) localObject).receiver = e.o();
            this.e.sender = Long.valueOf(this.f.id);
            this.e.state = Byte.valueOf((byte) 10);
        }
        if ((b1 == 10) || (b1 == 11)) {
            paramIntent = (AvRoom) paramIntent.getSerializableExtra(AvRoom.class.getName());
            this.g = paramIntent;
            com.farsunset.cim.sdk.android.h.t(this, paramIntent.getTag());
        }
        l(localBitmap, b1);
        k(b1);
        this.i.sendEmptyMessageDelayed(b1, 30000L);
        return 3;
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            if (CallIncomingService.e(CallIncomingService.this) != null) {
                u6.a.o(CallIncomingService.e(CallIncomingService.this).getTag());
                Object localObject = CallIncomingService.this;
                ((CallIncomingService) localObject).h.tag = CallIncomingService.e((CallIncomingService) localObject).getTag();
                localObject = CallIncomingService.this;
                ((CallIncomingService) localObject).h.type = CallIncomingService.e((CallIncomingService) localObject).getType();
                CallIncomingService.this.h.duration = Long.valueOf(0L);
                localObject = CallIncomingService.this;
                ((CallIncomingService) localObject).h.uid = CallIncomingService.e((CallIncomingService) localObject).getUid();
                localObject = CallIncomingService.this;
                ((CallIncomingService) localObject).h.timestamp = Long.valueOf(CallIncomingService.e((CallIncomingService) localObject).getTimestamp());
                localObject = CallIncomingService.this;
                ((CallIncomingService) localObject).h.content = l.H0(CallIncomingService.e((CallIncomingService) localObject).getMember());
                localObject = CallIncomingService.this.h;
                ((GroupCallLog) localObject).state = 4;
                x6.a.a((GroupCallLog) localObject);
                e.b();
                HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_UPDATE_CALL_BADGE"));
            }
            CallIncomingService.j(CallIncomingService.this, (byte) paramMessage.what);
            e.x(0);
            com.farsunset.cim.sdk.android.h.p(CallIncomingService.this);
            CallIncomingService.this.stopSelf();
        }
    }

    class b
            extends com.google.gson.reflect.a<Map<Long, String>> {
        b() {
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.service.CallIncomingService

 * JD-Core Version:    0.7.0.1

 */