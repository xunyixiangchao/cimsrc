package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.SurfaceView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import i3.e;

import org.webrtc.CameraVideoCapturer;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;

import u6.b;

public class VideoIncomingCallActivity
        extends RealtimeCallActivity {
    private SurfaceViewRenderer v;
    private SurfaceViewRenderer w;
    private View x;
    private boolean y;

    public void E1() {
        X0(2131690024);
        I1();
    }

    public void G1() {
        super.e1();
    }

    public int H0() {
        return 2131427410;
    }

    public void M0() {
        super.M0();
        d1();
        View localView = findViewById(2131231194);
        this.x = localView;
        localView.setSelected(true);
        this.h.type = 1;
        this.v = ((SurfaceViewRenderer) findViewById(2131231146));
        this.w = ((SurfaceViewRenderer) findViewById(2131231392));
        H1();
        q1(this.v, true);
        q1(this.w, false);
        if (getIntent().getBooleanExtra("ATTR_CALLING_ON", false)) {
            onAcceptCallClicked(null);
        }
    }

    protected void n1() {
        super.n1();
        Message localMessage = this.i;
        localMessage.format = 16;
        localMessage.state = Byte.valueOf((byte) 11);
        this.i.receiver = e.o();
        this.i.sender = Long.valueOf(this.j.sourceId);
    }

    public void onAcceptCallClicked(View paramView) {
        J1(2131690017);
        L1();
        O1();
        j1();
        K1();
        this.i.state = Byte.valueOf((byte) 11);
        g1();
        L1();
        p1(this.v);
        b.b(this.j.sourceId);
    }

    public void onDestroy() {
        super.onDestroy();
        this.w.release();
        this.v.release();
    }

    public void onRejectButtonClicked(View paramView) {
        this.h.state = 2;
        X0(2131690016);
        I1();
        b.h(this.j.sourceId);
    }

    public void onSpeakerClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        if (paramView.isSelected()) {
            Q1();
            return;
        }
        P1();
    }

    public void onSwitchRenderClicked(View paramView) {
        if (this.y) {
            this.p.removeSink(this.w);
            this.p.addSink(this.v);
            this.o.removeSink(this.v);
            this.o.addSink(this.w);
        }
        for (boolean bool = false; ; bool = true) {
            this.y = bool;
            return;
            this.p.removeSink(this.v);
            this.p.addSink(this.w);
            this.o.removeSink(this.w);
            this.o.addSink(this.v);
        }
    }

    public void onToggleCameraClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        this.g.switchCamera(null);
    }

    public void v1() {
        this.w.setVisibility(0);
        this.p.addSink(this.w);
        N1();
        k1();
    }

    public void w1(SessionDescription paramSessionDescription) {
        b.i(this.j.sourceId, paramSessionDescription);
    }

    public void x1() {
        super.x1();
        if ((this.x.isSelected()) && (this.g != null)) {
            onToggleCameraClicked(this.x);
            X0(2131690134);
        }
    }

    public void z1() {
        X0(2131689581);
        this.i.state = Byte.valueOf((byte) 10);
        this.h.state = 1;
        I1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.VideoIncomingCallActivity

 * JD-Core Version:    0.7.0.1

 */