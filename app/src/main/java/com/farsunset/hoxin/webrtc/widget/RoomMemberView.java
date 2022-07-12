package com.farsunset.hoxin.webrtc.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.webrtc.model.RoomMember;

import l1.b.b;
import l1.b.d;
import l1.b.e;

import org.webrtc.SurfaceViewRenderer;

import s3.d;
import u3.b0;
import u3.r;
import u3.s;

public class RoomMemberView
        extends RelativeLayout
        implements d, b.d {
    private WebImageView a;
    private TextView b;
    private ProgressBar c;
    private View d;
    private View e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private SurfaceViewRenderer i;
    private TextView j;
    private View k;
    private Bitmap l;
    private RoomMember m;
    private long n;
    private long o;
    Handler p = new a();

    public RoomMemberView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet, 0);
    }

    private void e() {
        String str = b0.l(this.m.uid);
        RoomMember localRoomMember = this.m;
        if (localRoomMember.state == 0) {
            this.a.s(b0.l(localRoomMember.uid), 2131165495);
            this.c.setVisibility(0);
            this.p.sendEmptyMessageDelayed(0, 30000L);
        }
        if (this.m.state == 1) {
            this.p.removeCallbacksAndMessages(null);
            this.h.setVisibility(0);
            this.g.setVisibility(0);
            this.a.p(b0.l(this.m.uid), 2131165495);
            this.c.setVisibility(8);
            s.a().d(Uri.parse(str), 4, this);
        }
        if (this.m.state == 2) {
            this.f.setText(2131689744);
        }
        if (this.m.state == 3) {
            this.f.setText(2131689743);
        }
        if (this.m.state == 5) {
            this.f.setText(2131689742);
        }
        if (this.m.state == 4) {
            this.f.setText(2131689741);
        }
        int i1 = this.m.state;
        if ((i1 == 2) || (i1 == 3) || (i1 == 5) || (i1 == 4)) {
            this.p.removeCallbacksAndMessages(null);
            setBackground(null);
            this.b.setTextColor(androidx.core.content.b.b(getContext(), 2131034731));
            this.a.p(b0.l(this.m.uid), 2131165495);
            this.c.setVisibility(8);
            this.f.setVisibility(0);
            this.c.setVisibility(8);
        }
        i1 = this.m.state;
        if (((i1 == 2) || (i1 == 3) || (i1 == 5) || (i1 == 4)) && (this.n == this.o)) {
            this.k.setVisibility(0);
            this.k.setTag(2131231522, Long.valueOf(this.m.uid));
        }
    }

    private void f() {
        if ((!this.m.videoMode) && (this.i.getVisibility() == 0)) {
            this.i.setVisibility(8);
        }
        if ((this.m.videoMode) && (this.i.getVisibility() == 8)) {
            this.a.setVisibility(4);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
        }
    }

    public void D0(Object paramObject, Bitmap paramBitmap) {
        if (this.m.state != 1) {
            return;
        }
        int i1 = paramBitmap.getWidth();
        if (paramBitmap.getHeight() != 0) {
            if (i1 == 0) {
                return;
            }
            this.l = paramBitmap;
            i1 = getMeasuredWidth();
            if (getMeasuredWidth() != 0) {
                if (i1 == 0) {
                    return;
                }
                setBackground(new BitmapDrawable(getResources(), paramBitmap));
                l1.b.b(paramBitmap).a(this);
            }
        }
    }

    public void a(l1.b paramb) {
        if (paramb == null) {
            return;
        }
        Object localObject2;
        Object localObject1;
        if (paramb.h() != null) {
            localObject2 = this.b;
            localObject1 = paramb.h();
            paramb = (l1.b) localObject2;
        }
        for (; ; ) {
            paramb.setTextColor(((b.e) localObject1).f());
            return;
            if (paramb.m() != null) {
                localObject1 = this.b;
                localObject2 = paramb.m();
                paramb = (l1.b) localObject1;
                localObject1 = localObject2;
            } else if (paramb.j() != null) {
                localObject1 = this.b;
                localObject2 = paramb.j();
                paramb = (l1.b) localObject1;
                localObject1 = localObject2;
            } else if (paramb.i() != null) {
                localObject1 = this.b;
                localObject2 = paramb.i();
                paramb = (l1.b) localObject1;
                localObject1 = localObject2;
            } else {
                if (paramb.g() == null) {
                    break;
                }
                localObject1 = this.b;
                localObject2 = paramb.g();
                paramb = (l1.b) localObject1;
                localObject1 = localObject2;
            }
        }
        if (paramb.f() != null) {
            this.b.setTextColor(paramb.f().f());
        }
    }

    public void g(long paramLong1, long paramLong2, RoomMember paramRoomMember, View.OnClickListener paramOnClickListener) {
        this.n = paramLong1;
        this.o = paramLong2;
        this.m = paramRoomMember;
        View localView = this.d;
        int i1;
        if (paramRoomMember.master) {
            i1 = 0;
        } else {
            i1 = 8;
        }
        localView.setVisibility(i1);
        localView = this.e;
        if (paramRoomMember.uid == paramLong1) {
            i1 = 0;
        } else {
            i1 = 8;
        }
        localView.setVisibility(i1);
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        this.k.setVisibility(8);
        this.k.setOnClickListener(paramOnClickListener);
        this.j.setVisibility(8);
        this.j.setText(paramRoomMember.name);
        this.a.setVisibility(0);
        this.b.setText(paramRoomMember.name);
        this.i.setOnClickListener(paramOnClickListener);
        this.i.setTag(Long.valueOf(paramRoomMember.uid));
        this.h.setSelected(paramRoomMember.microphoneEnable);
        this.g.setSelected(paramRoomMember.cameraEnable);
        e();
        f();
        if (paramRoomMember.videoMode) {
            this.a.setVisibility(4);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p.removeCallbacksAndMessages(null);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = ((WebImageView) findViewById(2131231053));
        this.d = findViewById(2131230822);
        this.e = findViewById(2131230823);
        this.b = ((TextView) findViewById(2131231301));
        this.c = ((ProgressBar) findViewById(2131231366));
        this.f = ((TextView) findViewById(2131231121));
        this.g = ((ImageView) findViewById(2131231055));
        this.h = ((ImageView) findViewById(2131231060));
        this.i = ((SurfaceViewRenderer) findViewById(2131231393));
        this.j = ((TextView) findViewById(2131230845));
        this.k = findViewById(2131231092);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if ((getMeasuredWidth() > 0) && (getMeasuredHeight() > 0)) {
            Bitmap localBitmap = this.l;
            if (localBitmap != null) {
                D0(null, localBitmap);
            }
        }
    }

    public void v(Object paramObject) {
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(Message paramMessage) {
            RoomMemberView.b(RoomMemberView.this).setText(2131689744);
            RoomMemberView.c(RoomMemberView.this).state = 2;
            RoomMemberView.d(RoomMemberView.this);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.widget.RoomMemberView

 * JD-Core Version:    0.7.0.1

 */