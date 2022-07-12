package com.farsunset.hoxin.webrtc.ui;

import android.view.SurfaceView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import org.webrtc.CameraVideoCapturer;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;

import s3.e;
import u6.b;

public class VideoCallingActivity
        extends RealtimeCallActivity
        implements e<BaseResult> {
    private SurfaceViewRenderer v;
    private SurfaceViewRenderer w;
    private View x;
    private boolean y = true;

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

    public void F1() {
        O1();
        J1(2131690020);
    }

    public int H0() {
        return 2131427409;
    }

    public void M0() {
        super.M0();
        this.h.type = 1;
        View localView = findViewById(2131231194);
        this.x = localView;
        localView.setSelected(true);
        this.v = ((SurfaceViewRenderer) findViewById(2131231146));
        this.w = ((SurfaceViewRenderer) findViewById(2131231392));
        R1();
    }

    public void R1() {
        H1();
        q1(this.v, true);
        q1(this.w, false);
        b.d(this.j.sourceId, this);
    }

    public void n1() {
        super.n1();
        Message localMessage = this.i;
        localMessage.format = 16;
        localMessage.state = Byte.valueOf((byte) 5);
    }

    public void onCallCancelClicked(View paramView) {
        this.h.state = 1;
        X0(2131690016);
        I1();
        b.f(this.j.sourceId);
    }

    public void onDestroy() {
        super.onDestroy();
        this.w.release();
        this.v.release();
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

    public void onSwitchRenderClicked(View paramView) {
        paramView = this.p;
        if (paramView == null) {
            return;
        }
        if (this.y) {
            paramView.removeSink(this.w);
            this.p.addSink(this.v);
            this.o.removeSink(this.v);
            this.o.addSink(this.w);
        }
        for (boolean bool = false; ; bool = true) {
            this.y = bool;
            return;
            paramView.removeSink(this.v);
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

    public void x1() {
        super.x1();
        if ((this.x.isSelected()) && (this.g != null)) {
            onToggleCameraClicked(this.x);
            X0(2131690134);
        }
    }

    public void y1() {
        O1();
        g1();
        L1();
        p1(this.v);
        K1();
        j1();
        super.f1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.VideoCallingActivity

 * JD-Core Version:    0.7.0.1

 */