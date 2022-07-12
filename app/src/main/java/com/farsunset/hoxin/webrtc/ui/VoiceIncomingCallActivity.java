package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import i3.e;

import org.webrtc.CameraVideoCapturer;
import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;

import u6.b;

public class VoiceIncomingCallActivity
        extends RealtimeCallActivity {
    public void E1() {
        X0(2131690024);
        I1();
    }

    public void G1() {
        super.e1();
    }

    public int H0() {
        return 2131427413;
    }

    public void M0() {
        super.M0();
        d1();
        this.h.type = 0;
        H1();
        if (getIntent().getBooleanExtra("ATTR_CALLING_ON", false)) {
            onAcceptCallClicked(null);
        }
    }

    protected void n1() {
        super.n1();
        Message localMessage = this.i;
        localMessage.format = 17;
        localMessage.state = Byte.valueOf((byte) 11);
        this.i.receiver = e.o();
        this.i.sender = Long.valueOf(this.j.sourceId);
    }

    public void onAcceptCallClicked(View paramView) {
        J1(2131690017);
        O1();
        this.i.state = Byte.valueOf((byte) 11);
        j1();
        K1();
        g1();
        m1();
        b.b(this.j.sourceId);
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

    public void onToggleCameraClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        this.g.switchCamera(null);
    }

    public void onToggleSilentClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        this.q.setEnabled(paramView.isSelected() ^ true);
    }

    public void u1() {
        N1();
    }

    public void w1(SessionDescription paramSessionDescription) {
        b.i(this.j.sourceId, paramSessionDescription);
    }

    public void z1() {
        X0(2131689581);
        I1();
        this.i.state = Byte.valueOf((byte) 10);
        this.h.state = 1;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.VoiceIncomingCallActivity

 * JD-Core Version:    0.7.0.1

 */