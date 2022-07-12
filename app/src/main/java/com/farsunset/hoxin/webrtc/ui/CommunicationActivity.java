package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;

import s3.p;

public class CommunicationActivity
        extends BaseActivity
        implements p<GroupCallLog> {
    private s6.a e;
    private GlobalEmptyView f;

    public int H0() {
        return 2131427364;
    }

    public int I0() {
        return 2131690143;
    }

    public void M0() {
        this.f = ((GlobalEmptyView) findViewById(2131230981));
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231391);
        localRecyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(localRecyclerView);
        s6.a locala = new s6.a(this);
        this.e = locala;
        localRecyclerView.setAdapter(locala);
    }

    public void a1(GroupCallLog paramGroupCallLog, View paramView) {
        paramView = new Intent(this, GroupCallInfoActivity.class);
        paramView.putExtra(GroupCallLog.class.getName(), paramGroupCallLog);
        startActivity(paramView);
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131230934) {
            paramMenuItem = this.e.J();
            this.e.M(paramMenuItem);
            x6.a.b(paramMenuItem.id);
            this.f.a(this.e);
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        paramContextMenu.add(1, 2131230934, 1, getString(2131689528));
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public void onDestroy() {
        super.onDestroy();
        i3.e.d();
        HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_UPDATE_CALL_BADGE"));
    }

    public void onResume() {
        super.onResume();
        this.e.I(x6.a.c());
        this.f.a(this.e);
    }

    public void onVideoClicked(View paramView) {
        paramView = new Intent(this, CreateRoomActivity.class);
        paramView.setAction("com.farsunset.hoxin.ACTION_VIDEO_CALL_ROOM");
        startActivity(paramView);
    }

    public void onVoiceClicked(View paramView) {
        paramView = new Intent(this, CreateRoomActivity.class);
        paramView.setAction("com.farsunset.hoxin.ACTION_VOICE_CALL_ROOM");
        startActivity(paramView);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.CommunicationActivity

 * JD-Core Version:    0.7.0.1

 */