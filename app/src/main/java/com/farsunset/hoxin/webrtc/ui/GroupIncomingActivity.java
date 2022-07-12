package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.service.CallIncomingService;
import com.farsunset.hoxin.webrtc.widget.RoomBottomMenuView;

import java.util.Iterator;
import java.util.List;

import org.webrtc.MediaStreamTrack;

import s6.c;

public class GroupIncomingActivity
        extends RoomCallActivity {
    private ViewGroup v;
    Handler w = new a();

    protected int H0() {
        return 2131427379;
    }

    public void M0() {
        super.M0();
        x1();
        Object localObject = this.i;
        S0(getString(2131690158, new Object[]{((AvRoom) localObject).getName(((AvRoom) localObject).getUid())}));
        this.v = ((ViewGroup) findViewById(2131230853));
        if (this.i.getType() == 10) {
            localObject = this.v;
            ((ViewGroup) localObject).removeView(((ViewGroup) localObject).findViewById(2131231254));
        }
        u1(new c(this.i));
        this.w.sendEmptyMessageDelayed(0, 30000L);
    }

    public void h1(long paramLong, String paramString) {
        this.r.state = 1;
        X0(2131689581);
        finish();
    }

    public void onAcceptVideoClicked(View paramView) {
        paramView = new String[1];
        paramView[0] = "android.permission.CAMERA";
        if (!c8.b.h(this, paramView)) {
            androidx.core.app.a.o(this, paramView, 0);
            return;
        }
        paramView = new String[1];
        paramView[0] = "android.permission.RECORD_AUDIO";
        if (!c8.b.h(this, paramView)) {
            androidx.core.app.a.o(this, paramView, 0);
            return;
        }
        y1(true);
    }

    public void onAcceptVoiceClicked(View paramView) {
        paramView = new String[1];
        paramView[0] = "android.permission.RECORD_AUDIO";
        if (!c8.b.h(this, paramView)) {
            androidx.core.app.a.o(this, paramView, 0);
            return;
        }
        y1(false);
    }

    public void onBackPressed() {
    }

    public void onDestroy() {
        super.onDestroy();
        this.r.state = 4;
        this.w.removeMessages(0);
        ((NotificationManager) getSystemService("notification")).cancel(46434342);
        stopService(new Intent(this, CallIncomingService.class));
    }

    public void onHangUpClicked(View paramView) {
        u6.a.i(this.i.getTag());
        finish();
    }

    public void onRejectMenuClicked(View paramView) {
        this.r.state = 2;
        u6.a.k(this.i.getTag());
        finish();
    }

    public void p1() {
        X0(2131690116);
        this.t.b();
        this.t.a();
        Object localObject = this.p;
        if (localObject != null) {
            ((MediaStreamTrack) localObject).setEnabled(false);
        }
        localObject = this.i.getIdList().iterator();
        while (((Iterator) localObject).hasNext()) {
            Long localLong = (Long) ((Iterator) localObject).next();
            if (localLong.longValue() != this.i.getUid()) {
                this.j.J(localLong.longValue());
            }
        }
    }

    public void q1() {
        X0(2131690118);
        this.t.e();
    }

    public void x(long paramLong) {
    }

    protected void x1() {
        ((NotificationManager) getSystemService("notification")).cancel(46434342);
        stopService(new Intent(this, CallIncomingService.class));
    }

    public void y1(boolean paramBoolean) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(Message paramMessage) {
            u6.a.o(GroupIncomingActivity.this.i.getTag());
            GroupIncomingActivity.this.finish();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.GroupIncomingActivity

 * JD-Core Version:    0.7.0.1

 */