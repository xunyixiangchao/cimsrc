package com.farsunset.hoxin.webrtc.ui;

import a7.c;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.webrtc.api.request.RoomAcceptRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAnswerRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomOfferRequest;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.service.GroupRealtimeCallService;
import com.farsunset.hoxin.webrtc.widget.RoomBottomMenuView;
import com.farsunset.hoxin.webrtc.widget.RoomVideoBottomMenuView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.RendererCommon;
import org.webrtc.RendererCommon.ScalingType;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.voiceengine.WebRtcAudioUtils;

import u3.l;
import v3.g;

public abstract class RoomCallActivity
        extends CIMMonitorActivity
        implements AudioManager.OnAudioFocusChangeListener, a7.a, a7.d, w6.e, c {
    private final Map<Long, w6.d> e = new HashMap();
    private final Map<Long, VideoTrack> f = new HashMap();
    private final Map<Long, Boolean> g = new HashMap();
    private final Map<Long, Boolean> h = new HashMap();
    protected AvRoom i;
    protected s6.b j;
    protected User k;
    protected CameraVideoCapturer l;
    private AudioManager m;
    private RecyclerView n;
    private long o;
    protected AudioTrack p;
    protected VideoTrack q;
    protected GroupCallLog r = new GroupCallLog();
    private SurfaceViewRenderer s;
    protected RoomBottomMenuView t;
    Handler u = new b();

    private void f1() {
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231032);
        this.n = localRecyclerView;
        localRecyclerView.setItemAnimator(null);
        this.n.h(g.l(this, 2.0F));
        this.n.h(g.m(this, 2.0F));
        this.n.setLayoutManager(new GridLayoutManager(this, 3, 1, false));
        this.j = new s6.b(this.i, this);
    }

    private void g1(SurfaceViewRenderer paramSurfaceViewRenderer, boolean paramBoolean) {
        Boolean localBoolean = (Boolean) paramSurfaceViewRenderer.getTag(2131231084);
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
            paramSurfaceViewRenderer.init(w6.a.h().g(), null);
            paramSurfaceViewRenderer.setMirror(false);
            paramSurfaceViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
            paramSurfaceViewRenderer.setZOrderMediaOverlay(paramBoolean);
            paramSurfaceViewRenderer.setKeepScreenOn(true);
            paramSurfaceViewRenderer.setEnableHardwareScaler(true);
            paramSurfaceViewRenderer.setTag(2131231084, Boolean.TRUE);
        }
    }

    private void n1(long paramLong, boolean paramBoolean) {
        w1(paramLong, (VideoTrack) this.f.get(Long.valueOf(paramLong)), paramBoolean);
    }

    public void B0(long paramLong) {
        this.j.M(paramLong, 5);
    }

    public void F(boolean paramBoolean) {
        CameraVideoCapturer localCameraVideoCapturer = this.l;
        if (localCameraVideoCapturer != null) {
            localCameraVideoCapturer.switchCamera(null);
        }
    }

    public void F0(long paramLong, MediaStream paramMediaStream) {
        this.j.O(paramLong, false);
    }

    public void G0(boolean paramBoolean) {
        SurfaceViewRenderer localSurfaceViewRenderer = (SurfaceViewRenderer) this.n.findViewWithTag(Long.valueOf(this.k.id));
        if (paramBoolean) {
            g1(localSurfaceViewRenderer, false);
            this.q.addSink(localSurfaceViewRenderer);
            this.l.startCapture(720, 1280, 30);
        } else {
            l.G0(this.l);
            this.q.removeSink(localSurfaceViewRenderer);
            localSurfaceViewRenderer.release();
            localSurfaceViewRenderer.setTag(2131231084, Boolean.FALSE);
        }
        this.q.setEnabled(paramBoolean);
        this.j.N(this.k.id, paramBoolean);
        this.j.P(this.k.id, paramBoolean);
        u6.a.m(this.i.getTag(), paramBoolean);
    }

    public void H(ChatSession paramChatSession, com.farsunset.hoxin.message.entity.Message paramMessage) {
        if ("912".equals(paramMessage.action)) {
            i1(paramMessage.sender.longValue(), (RoomAcceptRequest) l.s0(paramMessage.content, RoomAcceptRequest.class));
        }
        if ("913".equals(paramMessage.action)) {
            m1(paramMessage.sender.longValue());
        }
        if ("923".equals(paramMessage.action)) {
            o1(paramMessage.sender.longValue());
        }
        if ("914".equals(paramMessage.action)) {
            k1(paramMessage.sender.longValue());
        }
        if ("915".equals(paramMessage.action)) {
            this.j.O(paramMessage.sender.longValue(), Boolean.parseBoolean(paramMessage.content));
        }
        if ("916".equals(paramMessage.action)) {
            n1(paramMessage.sender.longValue(), Boolean.parseBoolean(paramMessage.content));
        }
        if ("917".equals(paramMessage.action)) {
            j1((Map) l.t0(paramMessage.content, new a().getType()));
        }
        if ("918".equals(paramMessage.action)) {
            l1(paramMessage.sender.longValue());
        }
        if ("919".equals(paramMessage.action)) {
            h1(paramMessage.sender.longValue(), paramMessage.content);
        }
        if ("920".equals(paramMessage.action)) {
            t1(paramMessage);
        }
        if ("921".equals(paramMessage.action)) {
            s1(paramMessage);
        }
        if ("922".equals(paramMessage.action)) {
            b1(paramMessage.sender.longValue()).c((IceCandidate) l.s0(paramMessage.content, IceCandidate.class));
        }
        if ("924".equals(paramMessage.action)) {
            X0(2131690115);
            finish();
        }
        if ("925".equals(paramMessage.action)) {
            p1();
        }
        if ("926".equals(paramMessage.action)) {
            q1();
        }
        if ("927".equals(paramMessage.action)) {
            long l1 = Long.parseLong(paramMessage.content);
            this.j.M(l1, 0);
        }
    }

    public void M0() {
        getWindow().addFlags(6815872);
        AudioManager localAudioManager = (AudioManager) androidx.core.content.b.h(getApplicationContext(), AudioManager.class);
        this.m = localAudioManager;
        localAudioManager.requestAudioFocus(this, 3, 2);
        this.i = ((AvRoom) getIntent().getSerializableExtra(AvRoom.class.getName()));
        this.k = i3.e.g();
        c1();
        f1();
        this.s = ((SurfaceViewRenderer) findViewById(2131230841));
        getWindow().setBackgroundDrawable(androidx.core.content.b.d(this, 2131165274));
    }

    public void T(long paramLong, MediaStream paramMediaStream) {
        this.j.N(paramLong, false);
        this.j.P(paramLong, false);
    }

    public void W(long paramLong, SurfaceViewRenderer paramSurfaceViewRenderer) {
        paramSurfaceViewRenderer = (VideoTrack) this.f.get(Long.valueOf(paramLong));
        if (paramSurfaceViewRenderer == null) {
            return;
        }
        g1(this.s, true);
        this.s.setVisibility(0);
        this.s.setTag(2131231522, Long.valueOf(paramLong));
        findViewById(2131231040).setVisibility(8);
        L0();
        paramSurfaceViewRenderer.addSink(this.s);
    }

    public void Y(long paramLong, IceCandidate paramIceCandidate) {
        u6.a.q(this.i.getTag(), paramLong, paramIceCandidate);
    }

    public void a0(long paramLong) {
        this.j.M(paramLong, 3);
    }

    protected w6.d b1(long paramLong) {
        if (!this.e.containsKey(Long.valueOf(paramLong))) {
            w6.d locald = w6.a.h().d(paramLong, this);
            d1(locald);
            e1(locald);
            this.e.put(Long.valueOf(paramLong), locald);
            return locald;
        }
        return (w6.d) this.e.get(Long.valueOf(paramLong));
    }

    public void c0(long paramLong, AudioTrack paramAudioTrack) {
        if (this.o == 0L) {
            this.o = System.currentTimeMillis();
            this.u.sendEmptyMessageDelayed(0, 1000L);
        }
        boolean bool;
        if (this.h.containsKey(Long.valueOf(paramLong))) {
            bool = ((Boolean) this.h.get(Long.valueOf(paramLong))).booleanValue();
        } else {
            bool = true;
        }
        this.j.O(paramLong, bool);
    }

    protected void c1() {
        Object localObject;
        if (this.i.getType() == 10) {
            localObject = (RoomBottomMenuView) findViewById(2131231622);
            this.t = ((RoomBottomMenuView) localObject);
            ((RoomBottomMenuView) localObject).setMenuListener(this);
        }
        if (this.i.getType() == 11) {
            localObject = (RoomVideoBottomMenuView) findViewById(2131231610);
            this.t = ((RoomBottomMenuView) localObject);
            ((RoomBottomMenuView) localObject).setMenuListener(this);
        }
    }

    protected void d1(w6.d paramd) {
        if (this.p == null) {
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
            Object localObject = w6.a.h().a();
            localObject = w6.a.h().b((AudioSource) localObject);
            this.p = ((AudioTrack) localObject);
            ((MediaStreamTrack) localObject).setEnabled(true);
            this.t.f();
            this.t.e();
        }
        paramd.d(this.p);
    }

    public void e0(long paramLong, SessionDescription paramSessionDescription) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    protected void e1(w6.d paramd) {
        if (this.i.getType() != 11) {
            return;
        }
        if ((this.l == null) || (this.q == null)) {
            this.l = ((CameraVideoCapturer) l.m());
            VideoSource localVideoSource = w6.a.h().e(this.l.isScreencast());
            this.l.initialize(SurfaceTextureHelper.create("CaptureThread", w6.a.h().g()), this, localVideoSource.getCapturerObserver());
            this.q = w6.a.h().f(localVideoSource);
            this.f.put(Long.valueOf(this.k.id), this.q);
            this.q.setEnabled(this.t.g());
        }
        paramd.d(this.q);
        if (this.t.g()) {
            this.l.startCapture(720, 1280, 30);
            w1(this.k.id, this.q, true);
        }
    }

    public void finish() {
        super.finishAndRemoveTask();
    }

    public void g0(boolean paramBoolean) {
        AudioTrack localAudioTrack = this.p;
        if (localAudioTrack == null) {
            return;
        }
        localAudioTrack.setEnabled(paramBoolean);
        this.j.O(this.k.id, paramBoolean);
        u6.a.n(this.i.getTag(), paramBoolean);
    }

    public void h1(long paramLong, String paramString) {
    }

    public void i1(long paramLong, RoomAcceptRequest paramRoomAcceptRequest) {
        s6.b localb = this.j;
        int i1 = paramRoomAcceptRequest.getAudio();
        boolean bool2 = true;
        boolean bool1;
        if (i1 == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        localb.O(paramLong, bool1);
        localb = this.j;
        if (paramRoomAcceptRequest.getVideo() == 1) {
            bool1 = bool2;
        } else {
            bool1 = false;
        }
        localb.N(paramLong, bool1);
        b1(paramLong).f();
        this.r.state = 0;
    }

    public void j1(Map<Long, String> paramMap) {
        this.i.addAll(paramMap);
        this.j.I(paramMap);
    }

    public void k0(boolean paramBoolean) {
        if (paramBoolean) {
            this.m.setMode(3);
            this.m.setSpeakerphoneOn(true);
        } else {
            this.m.setMode(2);
            this.m.setSpeakerphoneOn(false);
        }
        AudioManager localAudioManager = this.m;
        localAudioManager.setStreamVolume(0, localAudioManager.getStreamVolume(0), 0);
    }

    public void k1(long paramLong) {
        r(paramLong);
    }

    public void l1(long paramLong) {
        B0(paramLong);
        w6.d locald = (w6.d) this.e.get(Long.valueOf(paramLong));
        if (locald != null) {
            locald.g();
            this.e.remove(Long.valueOf(paramLong));
        }
        if (Objects.equals(this.s.getTag(2131231522), Long.valueOf(paramLong))) {
            onBigVideoRendererClicked(this.s);
        }
    }

    public void m1(long paramLong) {
        a0(paramLong);
    }

    public void o1(long paramLong) {
        this.j.M(paramLong, 2);
    }

    public void onAudioFocusChange(int paramInt) {
    }

    public void onBackPressed() {
    }

    public void onBigVideoRendererClicked(View paramView) {
        this.s.setVisibility(8);
        this.s.release();
        this.s.setTag(2131231084, Boolean.FALSE);
        long l1 = ((Long) this.s.getTag(2131231522)).longValue();
        this.s.setTag(2131231522, null);
        findViewById(2131231040).setVisibility(0);
        Z0();
        paramView = (VideoTrack) this.f.get(Long.valueOf(l1));
        if (paramView != null) {
            paramView.removeSink(this.s);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        h.p(this);
        Object localObject = this.e.entrySet().iterator();
        while (((Iterator) localObject).hasNext()) {
            ((w6.d) ((Map.Entry) ((Iterator) localObject).next()).getValue()).g();
        }
        localObject = this.l;
        if (localObject != null) {
            ((VideoCapturer) localObject).dispose();
        }
        this.e.clear();
        this.u.removeCallbacksAndMessages(null);
        i3.e.x(0);
        this.m.abandonAudioFocus(this);
        this.m.setMode(0);
        this.r.tag = this.i.getTag();
        this.r.type = this.i.getType();
        localObject = this.r;
        long l2 = this.o;
        long l1 = 0L;
        if (l2 != 0L) {
            l1 = (System.currentTimeMillis() - this.o) / 1000L;
        }
        ((GroupCallLog) localObject).duration = Long.valueOf(l1);
        this.r.uid = this.i.getUid();
        this.r.timestamp = Long.valueOf(this.i.getTimestamp());
        this.r.content = l.H0(this.i.getMember());
        x6.a.a(this.r);
        ((NotificationManager) androidx.core.content.b.h(this, NotificationManager.class)).cancel(46434342);
        l.v0(2131623936);
    }

    public void onStop() {
        super.onStop();
        if ((i3.a.b()) && (!isFinishing())) {
            r1();
        }
    }

    public boolean onSupportNavigateUp() {
        r1();
        return true;
    }

    public void p0(long paramLong, VideoTrack paramVideoTrack) {
        boolean bool;
        if (this.g.containsKey(Long.valueOf(paramLong))) {
            bool = ((Boolean) this.g.get(Long.valueOf(paramLong))).booleanValue();
        } else {
            bool = true;
        }
        this.f.put(Long.valueOf(paramLong), paramVideoTrack);
        w1(paramLong, paramVideoTrack, bool);
    }

    public abstract void p1();

    public abstract void q1();

    public void r(long paramLong) {
        this.j.M(paramLong, 4);
    }

    public void r1() {
        moveTaskToBack(true);
        if ((i3.a.b()) && (this.t.g()) && (this.l != null)) {
            this.t.setCameraEnable(false);
            this.t.c();
            G0(false);
        }
        Intent localIntent = new Intent(this, GroupRealtimeCallService.class);
        localIntent.putExtra(AvRoom.class.getName(), this.i);
        localIntent.putExtra("ATTR_TARGET_CLASS", getClass());
        startService(localIntent);
        X0(2131690012);
    }

    public void s1(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.t.d();
        b1(paramMessage.sender.longValue()).k(new SessionDescription(SessionDescription.Type.ANSWER, paramMessage.content));
        RoomAnswerRequest localRoomAnswerRequest = (RoomAnswerRequest) l.s0(paramMessage.extra, RoomAnswerRequest.class);
        Object localObject = this.j;
        long l1 = paramMessage.sender.longValue();
        int i1 = localRoomAnswerRequest.getAudio();
        boolean bool2 = false;
        if (i1 == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((s6.b) localObject).O(l1, bool1);
        localObject = this.j;
        l1 = paramMessage.sender.longValue();
        if (localRoomAnswerRequest.getVideo() == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((s6.b) localObject).N(l1, bool1);
        localObject = this.g;
        Long localLong = paramMessage.sender;
        if (localRoomAnswerRequest.getVideo() == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((Map) localObject).put(localLong, Boolean.valueOf(bool1));
        localObject = this.h;
        paramMessage = paramMessage.sender;
        boolean bool1 = bool2;
        if (localRoomAnswerRequest.getAudio() == 1) {
            bool1 = true;
        }
        ((Map) localObject).put(paramMessage, Boolean.valueOf(bool1));
    }

    public void t1(com.farsunset.hoxin.message.entity.Message paramMessage) {
        this.t.d();
        Object localObject1 = b1(paramMessage.sender.longValue());
        ((w6.d) localObject1).k(new SessionDescription(SessionDescription.Type.OFFER, paramMessage.content));
        ((w6.d) localObject1).e();
        localObject1 = (RoomOfferRequest) l.s0(paramMessage.extra, RoomOfferRequest.class);
        Object localObject2 = this.j;
        long l1 = paramMessage.sender.longValue();
        int i1 = ((RoomOfferRequest) localObject1).getAudio();
        boolean bool2 = false;
        if (i1 == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((s6.b) localObject2).O(l1, bool1);
        localObject2 = this.j;
        l1 = paramMessage.sender.longValue();
        if (((RoomOfferRequest) localObject1).getVideo() == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((s6.b) localObject2).N(l1, bool1);
        localObject2 = this.g;
        Long localLong = paramMessage.sender;
        if (((RoomOfferRequest) localObject1).getVideo() == 1) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        ((Map) localObject2).put(localLong, Boolean.valueOf(bool1));
        localObject2 = this.h;
        paramMessage = paramMessage.sender;
        boolean bool1 = bool2;
        if (((RoomOfferRequest) localObject1).getAudio() == 1) {
            bool1 = true;
        }
        ((Map) localObject2).put(paramMessage, Boolean.valueOf(bool1));
    }

    protected void u1(RecyclerView.h<?> paramh) {
        this.n.setAdapter(paramh);
    }

    protected void v1(boolean paramBoolean) {
        this.t.setVisibility(0);
        this.t.setCameraEnable(paramBoolean);
        findViewById(2131230844).setVisibility(0);
        findViewById(2131231040).setVisibility(0);
    }

    protected void w1(long paramLong, VideoTrack paramVideoTrack, boolean paramBoolean) {
        SurfaceViewRenderer localSurfaceViewRenderer = (SurfaceViewRenderer) this.n.findViewWithTag(Long.valueOf(paramLong));
        if (localSurfaceViewRenderer != null) {
            if (paramVideoTrack == null) {
                return;
            }
            if (!paramBoolean) {
                paramVideoTrack.removeSink(localSurfaceViewRenderer);
                localSurfaceViewRenderer.release();
                localSurfaceViewRenderer.setTag(2131231084, Boolean.FALSE);
            } else {
                g1(localSurfaceViewRenderer, true);
                paramVideoTrack.addSink(localSurfaceViewRenderer);
            }
            this.j.N(paramLong, paramBoolean);
            this.j.P(paramLong, paramBoolean);
        }
    }

    public void x0(long paramLong, SessionDescription paramSessionDescription) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    class a
            extends com.google.gson.reflect.a<Map<Long, String>> {
        a() {
        }
    }

    class b
            extends Handler {
        b() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            long l1 = System.currentTimeMillis();
            long l2 = RoomCallActivity.a1(RoomCallActivity.this);
            paramMessage = RoomCallActivity.this;
            paramMessage.S0(paramMessage.getString(2131690157, new Object[]{l.s(l1 - l2)}));
            RoomCallActivity.this.u.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.RoomCallActivity

 * JD-Core Version:    0.7.0.1

 */