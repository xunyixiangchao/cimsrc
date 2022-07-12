package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import c7.c;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.model.ChatCall;
import com.farsunset.hoxin.webrtc.service.CallIncomingService;
import com.farsunset.hoxin.webrtc.service.RealtimeCallService;

import i3.e;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.RendererCommon.ScalingType;
import org.webrtc.RtpReceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.voiceengine.WebRtcAudioUtils;

import s3.d;
import u3.b0;
import u3.l;
import u3.m0;
import u3.r;
import u3.s;

public abstract class RealtimeCallActivity
        extends CIMMonitorActivity
        implements SdpObserver, PeerConnection.Observer, d, AudioManager.OnAudioFocusChangeListener {
    private NotificationManager e;
    protected PeerConnection f;
    protected CameraVideoCapturer g;
    protected ChatCall h = new ChatCall();
    protected com.farsunset.hoxin.message.entity.Message i;
    protected ChatSession j;
    private long k;
    private TextView l;
    private TextView m;
    private MediaPlayer n;
    protected VideoTrack o;
    protected VideoTrack p;
    protected AudioTrack q;
    private AudioManager r;
    Handler s = new a();
    Handler t = new b();
    Handler u = new c();

    private void h1() {
        getWindow().addFlags(6815872);
    }

    private void l1() {
        ChatSession localChatSession = (ChatSession) getIntent().getSerializableExtra("ATTR_CHAT_SESSION");
        this.j = localChatSession;
        if (localChatSession.id == 0L) {
            localChatSession.id = j5.a.e(localChatSession.sourceId, localChatSession.sourceType);
        }
    }

    private void o1(SurfaceViewRenderer paramSurfaceViewRenderer) {
        this.g = ((CameraVideoCapturer) l.m());
        Object localObject = w6.a.h().e(this.g.isScreencast());
        this.g.initialize(SurfaceTextureHelper.create(Thread.currentThread().getName(), w6.a.h().g()), this, ((VideoSource) localObject).getCapturerObserver());
        this.g.startCapture(1080, 1920, 30);
        localObject = w6.a.h().f((VideoSource) localObject);
        this.o = ((VideoTrack) localObject);
        ((MediaStreamTrack) localObject).setEnabled(true);
        this.o.addSink(paramSurfaceViewRenderer);
        this.f.addTrack(this.o, w6.a.d);
    }

    public void A1() {
    }

    public void B1(SessionDescription paramSessionDescription) {
    }

    public void C1() {
    }

    public void D0(Object paramObject, Bitmap paramBitmap) {
        int i1 = paramBitmap.getWidth();
        int i2 = paramBitmap.getHeight();
        if ((i2 != 0) && (i1 != 0)) {
            int i3 = Resources.getSystem().getDisplayMetrics().widthPixels * i2 / Resources.getSystem().getDisplayMetrics().heightPixels;
            paramObject = Bitmap.createBitmap(paramBitmap, new Random().nextInt(i1 - i3), 0, i3, i2);
            getWindow().setBackgroundDrawable(new BitmapDrawable(getResources(), paramObject));
            return;
        }
        v(paramObject);
    }

    public void D1() {
    }

    public abstract void E1();

    public void F1() {
    }

    public void G1() {
    }

    public void H(ChatSession paramChatSession, com.farsunset.hoxin.message.entity.Message paramMessage) {
        if ("902".equals(paramMessage.action)) {
            y1();
            return;
        }
        if ("903".equals(paramMessage.action)) {
            A1();
            return;
        }
        if ("904".equals(paramMessage.action)) {
            D1();
            return;
        }
        if ("905".equals(paramMessage.action)) {
            E1();
            return;
        }
        if ("906".equals(paramMessage.action)) {
            z1();
            return;
        }
        if (("907".equals(paramMessage.action)) && (this.f != null)) {
            paramChatSession = (IceCandidate) l.s0(paramMessage.content, IceCandidate.class);
            this.f.addIceCandidate(paramChatSession);
            return;
        }
        if ("908".equals(paramMessage.action)) {
            paramChatSession = new SessionDescription(SessionDescription.Type.OFFER, paramMessage.content);
            this.f.setRemoteDescription(this, paramChatSession);
            G1();
            return;
        }
        if ("909".equals(paramMessage.action)) {
            paramChatSession = new SessionDescription(SessionDescription.Type.ANSWER, paramMessage.content);
            this.f.setRemoteDescription(this, paramChatSession);
            F1();
        }
    }

    protected void H1() {
        MediaPlayer localMediaPlayer = MediaPlayer.create(this, 2131623937);
        this.n = localMediaPlayer;
        localMediaPlayer.setAudioStreamType(3);
        this.n.setLooping(true);
        this.n.start();
    }

    protected void I1() {
        O1();
        l.v0(2131623936);
        m0.a(new c7.a(this), 300L);
    }

    protected void J1(int paramInt) {
        this.l.setText(paramInt);
    }

    protected void K1() {
        findViewById(2131230910).setVisibility(0);
    }

    protected void L1() {
        findViewById(2131231449).setVisibility(0);
    }

    public void M0() {
        setStatusBarColor(0);
        d1();
        l1();
        this.l = ((TextView) findViewById(2131231045));
        this.m = ((TextView) findViewById(2131231553));
        ((TextView) findViewById(2131231301)).setText(this.j.name);
        ((WebImageView) findViewById(2131231150)).p(b0.l(this.j.sourceId), 2131165495);
        s.a().b(Uri.parse(b0.l(this.j.sourceId)), this);
        h1();
        n1();
    }

    public void M1() {
        this.t.sendEmptyMessageDelayed(0, 30000L);
    }

    public void N1() {
        this.t.removeMessages(0);
        this.k = System.currentTimeMillis();
        this.s.sendEmptyMessage(0);
    }

    protected boolean O0() {
        return true;
    }

    protected void O1() {
        MediaPlayer localMediaPlayer = this.n;
        if (localMediaPlayer == null) {
            return;
        }
        if (localMediaPlayer.isPlaying()) {
            this.n.stop();
        }
        this.n.release();
        this.n = null;
    }

    public void P1() {
        this.r.setMode(2);
        AudioManager localAudioManager = this.r;
        localAudioManager.setStreamVolume(0, localAudioManager.getStreamVolume(0), 0);
        this.r.setSpeakerphoneOn(false);
    }

    public void Q1() {
        this.r.setMode(3);
        AudioManager localAudioManager = this.r;
        localAudioManager.setStreamVolume(0, localAudioManager.getStreamVolume(0), 0);
        this.r.setSpeakerphoneOn(true);
    }

    protected void d1() {
        this.e.cancel(46434342);
        stopService(new Intent(this, CallIncomingService.class));
    }

    public void e1() {
        this.f.createAnswer(this, w6.a.c);
    }

    public void f1() {
        this.f.createOffer(this, w6.a.c);
    }

    protected void g1() {
        this.f = w6.a.h().c(this);
    }

    public long i1() {
        if (this.k == 0L) {
            return 0L;
        }
        return System.currentTimeMillis() - this.k;
    }

    protected void j1() {
        findViewById(2131230931).setVisibility(8);
    }

    protected void k1() {
        findViewById(2131231301).setVisibility(8);
        findViewById(2131231150).setVisibility(8);
    }

    protected void m1() {
        WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        Object localObject = w6.a.h().a();
        localObject = w6.a.h().b((AudioSource) localObject);
        this.q = ((AudioTrack) localObject);
        ((MediaStreamTrack) localObject).setEnabled(true);
        this.f.addTrack(this.q, w6.a.d);
    }

    protected void n1() {
        com.farsunset.hoxin.message.entity.Message localMessage = new com.farsunset.hoxin.message.entity.Message();
        this.i = localMessage;
        localMessage.id = System.currentTimeMillis();
        localMessage = this.i;
        localMessage.action = "0";
        localMessage.sender = e.o();
        this.i.receiver = Long.valueOf(this.j.sourceId);
    }

    public void onAcceptCallClicked(View paramView) {
    }

    public void onAddStream(MediaStream paramMediaStream) {
        this.h.state = 0;
        if (paramMediaStream.videoTracks.size() > 0) {
            this.p = ((VideoTrack) paramMediaStream.videoTracks.get(0));
        }
        l.J0(100);
        P1();
        runOnUiThread(new c(this));
    }

    public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream) {
    }

    public void onAudioFocusChange(int paramInt) {
    }

    public void onBackPressed() {
    }

    public void onCallCancelClicked(View paramView) {
    }

    public void onCreate(Bundle paramBundle) {
        AudioManager localAudioManager = (AudioManager) androidx.core.content.b.h(getApplicationContext(), AudioManager.class);
        this.r = localAudioManager;
        localAudioManager.requestAudioFocus(this, 3, 2);
        this.e = ((NotificationManager) getSystemService("notification"));
        super.onCreate(paramBundle);
    }

    public void onCreateFailure(String paramString) {
    }

    public void onCreateSuccess(SessionDescription paramSessionDescription) {
        this.f.setLocalDescription(this, paramSessionDescription);
        B1(paramSessionDescription);
        w1(paramSessionDescription);
    }

    public void onDataChannel(DataChannel paramDataChannel) {
    }

    public void onDestroy() {
        super.onDestroy();
        Object localObject = this.g;
        if (localObject != null) {
            ((VideoCapturer) localObject).dispose();
        }
        localObject = this.q;
        if (localObject != null) {
            ((MediaStreamTrack) localObject).dispose();
        }
        localObject = this.o;
        if (localObject != null) {
            ((VideoTrack) localObject).dispose();
        }
        localObject = this.f;
        if (localObject != null) {
            ((PeerConnection) localObject).close();
            this.f.dispose();
        }
        this.s.removeCallbacksAndMessages(null);
        this.t.removeCallbacksAndMessages(null);
        try {
            this.n.stop();
        } catch (Exception localException1) {
            try {
                for (; ; ) {
                    this.n.release();
                    label95:
                    e.x(0);
                    d1();
                    this.r.abandonAudioFocus(this);
                    this.r.setMode(0);
                    ((NotificationManager) androidx.core.content.b.h(this, NotificationManager.class)).cancel(46434342);
                    t1();
                    return;
                    localException1 = localException1;
                }
            } catch (Exception localException2) {
                break label95;
            }
        }
    }

    public void onHangUpClicked(View paramView) {
        X0(2131690019);
        u6.b.g(this.j.sourceId);
        I1();
    }

    public final void onIceCandidate(IceCandidate paramIceCandidate) {
        u6.b.j(this.j.sourceId, paramIceCandidate);
    }

    public void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate) {
    }

    public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState) {
        if (paramIceConnectionState == PeerConnection.IceConnectionState.FAILED) {
            runOnUiThread(new c7.b(this));
            this.u.sendEmptyMessageDelayed(0, 30000L);
            return;
        }
        if (paramIceConnectionState == PeerConnection.IceConnectionState.CONNECTED) {
            this.u.removeMessages(0);
        }
    }

    public void onIceConnectionReceivingChange(boolean paramBoolean) {
    }

    public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState) {
    }

    public void onMinimizeClicked(View paramView) {
        moveTaskToBack(true);
        paramView = new Intent(this, RealtimeCallService.class);
        paramView.putExtra("ATTR_CHAT_SESSION", this.j);
        paramView.putExtra("ATTR_TYPE", this.h.type);
        paramView.putExtra("ATTR_TARGET_CLASS", getClass());
        startService(paramView);
        X0(2131690012);
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        d1();
    }

    public void onRemoveStream(MediaStream paramMediaStream) {
    }

    public void onRenegotiationNeeded() {
    }

    public void onSetFailure(String paramString) {
    }

    public void onSetSuccess() {
    }

    public void onSignalingChange(PeerConnection.SignalingState paramSignalingState) {
    }

    public void onStop() {
        super.onStop();
        if ((i3.a.b()) && (!isFinishing())) {
            x1();
        }
    }

    protected void p1(SurfaceViewRenderer paramSurfaceViewRenderer) {
        m1();
        paramSurfaceViewRenderer.setVisibility(0);
        o1(paramSurfaceViewRenderer);
    }

    protected void q1(SurfaceViewRenderer paramSurfaceViewRenderer, boolean paramBoolean) {
        paramSurfaceViewRenderer.init(w6.a.h().g(), null);
        paramSurfaceViewRenderer.setMirror(false);
        paramSurfaceViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
        paramSurfaceViewRenderer.setZOrderMediaOverlay(paramBoolean);
        paramSurfaceViewRenderer.setKeepScreenOn(true);
        paramSurfaceViewRenderer.setEnableHardwareScaler(true);
    }

    protected void t1() {
        this.h.duration = i1();
        this.i.content = l.H0(this.h);
        this.i.createTime = Long.valueOf(System.currentTimeMillis());
        boolean bool;
        if ((!(this instanceof VoiceIncomingCallActivity)) && (!(this instanceof VideoIncomingCallActivity))) {
            bool = false;
        } else {
            bool = true;
        }
        n5.b.a(this.i, bool);
        Object localObject = new Intent("com.farsunset.hoxin.ACTION_WINDOW_ADD_MESSAGE");
        ((Intent) localObject).putExtra(com.farsunset.hoxin.message.entity.Message.NAME, this.i);
        HoxinApplication.t((Intent) localObject);
        localObject = this.j;
        localObject = j5.a.l(((ChatSession) localObject).sourceId, ((ChatSession) localObject).sourceType);
        Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT");
        localIntent.putExtra("ATTR_CHAT_SESSION", (Serializable) localObject);
        HoxinApplication.t(localIntent);
    }

    public void u1() {
    }

    public void v(Object paramObject) {
        getWindow().setBackgroundDrawableResource(17170444);
    }

    public void v1() {
    }

    public void w1(SessionDescription paramSessionDescription) {
    }

    public void x1() {
        onMinimizeClicked(null);
    }

    public void y1() {
    }

    public void z1() {
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            long l = RealtimeCallActivity.this.i1();
            RealtimeCallActivity.c1(RealtimeCallActivity.this).setText(l.s(l));
            RealtimeCallActivity.this.s.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    class b
            extends Handler {
        b() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            RealtimeCallActivity.this.C1();
        }
    }

    class c
            extends Handler {
        c() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            RealtimeCallActivity.this.E1();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.RealtimeCallActivity

 * JD-Core Version:    0.7.0.1

 */