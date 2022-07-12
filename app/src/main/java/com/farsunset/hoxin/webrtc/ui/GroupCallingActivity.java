package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.webrtc.api.request.RoomAcceptRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAddRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomRecallRequest;
import com.farsunset.hoxin.webrtc.model.AvRoom;

import java.util.Iterator;
import java.util.List;

import s6.b;

public class GroupCallingActivity
        extends RoomCallActivity
        implements s3.e<LongResult>, s3.l {
    private boolean v = false;
    private z6.a w;
    private Menu x;
    private MediaPlayer y;

    protected int H0() {
        return 2131427377;
    }

    public void M0() {
        super.M0();
        super.v1(true);
        setTitle(2131690156);
        u1(this.j);
        h.t(this, this.i.getTag());
        i3.e.x(1);
        Object localObject = MediaPlayer.create(this, 2131623937);
        this.y = ((MediaPlayer) localObject);
        ((MediaPlayer) localObject).setAudioStreamType(3);
        this.y.setLooping(true);
        this.y.start();
        localObject = new z6.a(this);
        this.w = ((z6.a) localObject);
        ((z6.a) localObject).o(this);
        u6.a.e(this.i, this);
    }

    public void S() {
        u6.a.i(this.i.getTag());
        finish();
    }

    public void i1(long paramLong, RoomAcceptRequest paramRoomAcceptRequest) {
        super.i1(paramLong, paramRoomAcceptRequest);
        u3.l.o(this.y);
        this.v = true;
        this.x.findItem(2131231224).setVisible(true);
    }

    public void m() {
        u6.a.h(this.i.getTag());
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt2 == -1) {
            super.j1(((RoomAddRequest) paramIntent.getSerializableExtra(RoomAddRequest.class.getName())).getNewMember());
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492887, paramMenu);
        this.x = paramMenu;
        paramMenu.findItem(2131231236).setVisible(false);
        paramMenu.findItem(2131231224).setVisible(false);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        u3.l.o(this.y);
    }

    public void onHangUpClicked(View paramView) {
        if (this.v) {
            this.w.show();
            return;
        }
        u6.a.f(this.i.getTag());
        this.r.state = 1;
        finish();
    }

    public void onHttpException(Exception paramException) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231202) {
            p1();
            X0(2131690117);
            u6.a.g(this.i.getTag());
            this.x.findItem(2131231236).setVisible(true);
            this.x.findItem(2131231202).setVisible(false);
        }
        if (paramMenuItem.getItemId() == 2131231236) {
            this.x.findItem(2131231236).setVisible(false);
            this.x.findItem(2131231202).setVisible(true);
            X0(2131690119);
            u6.a.l(this.i.getTag());
        }
        if (paramMenuItem.getItemId() == 2131231185) {
            Intent localIntent = new Intent(this, AddRoomMemberActivity.class);
            localIntent.putExtra(AvRoom.class.getName(), this.i);
            startActivityForResult(localIntent, 0);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void p1() {
        Iterator localIterator = this.i.getIdList().iterator();
        while (localIterator.hasNext()) {
            Long localLong = (Long) localIterator.next();
            if (localLong.longValue() != this.i.getUid()) {
                this.j.J(localLong.longValue());
            }
        }
    }

    public void q1() {
    }

    public void x(long paramLong) {
        RoomRecallRequest localRoomRecallRequest = new RoomRecallRequest();
        localRoomRecallRequest.setType(this.i.getType());
        localRoomRecallRequest.setTag(this.i.getTag());
        localRoomRecallRequest.setMember(this.i.getMember());
        localRoomRecallRequest.setUid(paramLong);
        u6.a.j(localRoomRecallRequest);
    }

    public void x1(LongResult paramLongResult) {
        this.i.setTimestamp(paramLongResult.data.longValue());
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.GroupCallingActivity

 * JD-Core Version:    0.7.0.1

 */