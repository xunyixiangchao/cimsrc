package com.farsunset.hoxin.webrtc.ui;

import android.view.View;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;

import s3.e;
import u6.b;

public class VoiceCallingActivity
        extends RealtimeCallActivity
        implements e<BaseResult> {
    public void A1() {
        J1(2131690023);
        X0(2131690023);
        this.h.state = 2;
        I1();
    }

    public void B1(SessionDescription paramSessionDescription) {
        b.k(this.j.sourceId, paramSessionDescription);
    }

    public void C1() {
        this.h.state = 4;
        J1(2131689583);
        b.f(this.j.sourceId);
        I1();
    }

    public void D1() {
        this.h.state = 3;
        J1(2131690021);
        I1();
    }

    public void E1() {
        X0(2131690024);
        I1();
    }

    public int H0() {
        return 2131427412;
    }

    public void M0() {
        super.M0();
        this.h.type = 0;
        R1();
    }

    public void R1() {
        H1();
        b.e(this.j.sourceId, this);
    }

    public void n1() {
        super.n1();
        Message localMessage = this.i;
        localMessage.format = 17;
        localMessage.state = Byte.valueOf((byte) 5);
    }

    public void onCallCancelClicked(View paramView) {
        this.h.state = 1;
        X0(2131690016);
        I1();
        b.f(this.j.sourceId);
    }

    public void onHttpException(Exception paramException) {
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        if (paramBaseResult.code == 403) {
            A1();
            return;
        }
        M1();
    }

    public void onSpeakerClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        if (paramView.isSelected()) {
            Q1();
            return;
        }
        P1();
    }

    public void onToggleSilentClicked(View paramView) {
        paramView.setSelected(paramView.isSelected() ^ true);
        this.q.setEnabled(paramView.isSelected() ^ true);
    }

    public void u1() {
        N1();
    }

    public void y1() {
        J1(2131690020);
        O1();
        g1();
        m1();
        K1();
        j1();
        super.f1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.VoiceCallingActivity

 * JD-Core Version:    0.7.0.1

 */