package com.farsunset.hoxin.webrtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationBarView.c;
import com.google.gson.reflect.a;

import i3.e;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import s6.c;
import u3.l;

public class GroupCallInfoActivity
        extends BaseActivity
        implements NavigationBarView.c {
    private AvRoom e;

    private void a1() {
        ((BottomNavigationView) findViewById(2131231302)).setOnItemSelectedListener(this);
    }

    private void b1(GroupCallLog paramGroupCallLog) {
        int i = (int) (paramGroupCallLog.duration.longValue() / 60L);
        int j = (int) (paramGroupCallLog.duration.longValue() % 60L);
        ((TextView) findViewById(2131230838)).setText(l.x(paramGroupCallLog.timestamp.longValue()));
        ((TextView) findViewById(2131230984)).setText(l.x(paramGroupCallLog.timestamp.longValue() + paramGroupCallLog.duration.longValue() * 1000L));
        ((TextView) findViewById(2131230969)).setText(getString(2131689659, new Object[]{Integer.valueOf(i), Integer.valueOf(j)}));
    }

    private void c1() {
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231032);
        localRecyclerView.setItemAnimator(null);
        localRecyclerView.h(new f(this, 1));
        localRecyclerView.h(new f(this, 0));
        int i = 3;
        if (!Arrays.asList(new Integer[]{Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9)}).contains(Integer.valueOf(this.e.getMember().size()))) {
            i = 2;
        }
        localRecyclerView.setLayoutManager(new GridLayoutManager(this, i, 1, false));
        localRecyclerView.setAdapter(new c(this.e));
    }

    protected int H0() {
        return 2131427376;
    }

    protected int I0() {
        return 2131690155;
    }

    public void M0() {
        GroupCallLog localGroupCallLog = (GroupCallLog) getIntent().getSerializableExtra(GroupCallLog.class.getName());
        Map localMap = (Map) l.t0(localGroupCallLog.content, new a().getType());
        AvRoom localAvRoom = new AvRoom();
        this.e = localAvRoom;
        localAvRoom.setType((byte) localGroupCallLog.type);
        this.e.setUid(localGroupCallLog.uid);
        this.e.setMember(localMap);
        c1();
        a1();
        b1(localGroupCallLog);
    }

    public boolean c(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231504) {
            Intent localIntent = new Intent(this, CreateRoomActivity.class);
            localIntent.putExtra("ATTR_SELECTED_UID_LIST", this.e.getIdArray());
            String str;
            if (this.e.getType() == 11) {
                str = "com.farsunset.hoxin.ACTION_VIDEO_CALL_ROOM";
            } else {
                str = "com.farsunset.hoxin.ACTION_VOICE_CALL_ROOM";
            }
            localIntent.setAction(str);
            startActivity(localIntent);
        }
        if (paramMenuItem.getItemId() == 2131231508) {
            this.e.setTag(l.K());
            this.e.setType((byte) 10);
            this.e.setUid(e.o().longValue());
            HoxinApplication.h().A(this.e);
        }
        if (paramMenuItem.getItemId() == 2131231507) {
            this.e.setTag(l.K());
            this.e.setType((byte) 11);
            this.e.setUid(e.o().longValue());
            HoxinApplication.h().A(this.e);
        }
        return false;
    }

    class a
            extends a<Map<Long, String>> {
        a() {
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.ui.GroupCallInfoActivity

 * JD-Core Version:    0.7.0.1

 */