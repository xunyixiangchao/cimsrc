package com.farsunset.hoxin.micro.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.micro.entity.MicroServer;

import s3.p;
import s5.c;
import x5.a;

public class MicroServerListActivity
        extends BaseActivity
        implements p<MicroServer> {
    private c e;
    private GlobalEmptyView f;

    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131689685;
    }

    public void M0() {
        Object localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        c localc = new c();
        this.e = localc;
        ((RecyclerView) localObject).setAdapter(localc);
        this.e.L(this);
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.f = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131690093);
    }

    public void a1(MicroServer paramMicroServer, View paramView) {
        paramView = new Intent(this, MicroServerWindowActivity.class);
        paramView.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramMicroServer));
        startActivity(paramView);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165222);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            startActivity(new Intent(this, FindMicroServerActivity.class));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        this.e.I(a.d());
        this.f.a(this.e);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.MicroServerListActivity

 * JD-Core Version:    0.7.0.1

 */