package com.farsunset.hoxin.emoticon.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.CustomSwipeRefreshLayout;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.LoadMoreRecyclerView;
import com.farsunset.hoxin.emoticon.api.response.EmoticonPageResult;
import com.farsunset.hoxin.emoticon.entity.Emoticon;

import s3.r;
import s3.s;
import w3.d;
import y3.a;

public class EmoticonMallActivity
        extends BaseActivity
        implements r, s3.e<EmoticonPageResult>, s {
    private d e;
    private GlobalEmptyView f;
    private LoadMoreRecyclerView g;
    private CustomSwipeRefreshLayout h;
    private int i = 0;

    public int H0() {
        return 2131427362;
    }

    public int I0() {
        return 2131690149;
    }

    public void M0() {
        Object localObject = (CustomSwipeRefreshLayout) findViewById(2131231489);
        this.h = ((CustomSwipeRefreshLayout) localObject);
        ((CustomSwipeRefreshLayout) localObject).setOnRefreshListener(this);
        this.h.setLimited(true);
        localObject = (LoadMoreRecyclerView) findViewById(2131231391);
        this.g = ((LoadMoreRecyclerView) localObject);
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        this.g.setLayoutManager(new LinearLayoutManager(this));
        this.g.setOnLoadEventListener(this);
        localObject = new d(this);
        this.e = ((d) localObject);
        this.g.setAdapter((RecyclerView.h) localObject);
        this.g.setFooterView(this.e.L());
        this.f = ((GlobalEmptyView) findViewById(2131230981));
        this.h.y();
    }

    public void a1(EmoticonPageResult paramEmoticonPageResult) {
        this.h.x();
        this.g.I1(paramEmoticonPageResult.page);
        if ((paramEmoticonPageResult.isNotEmpty()) && (this.i == 0)) {
            this.e.I(paramEmoticonPageResult.data);
        }
        if ((paramEmoticonPageResult.isNotEmpty()) && (this.i > 0)) {
            this.e.J(paramEmoticonPageResult.data);
        }
        if ((paramEmoticonPageResult.isEmpty()) && (this.i == 0)) {
            this.e.K();
            this.g.G1();
        }
        int j;
        if (paramEmoticonPageResult.isEmpty()) {
            j = this.i;
            if (j > 0) {
                this.i = (j - 1);
            }
        }
        paramEmoticonPageResult = this.f;
        if (this.e.d() > 1) {
            j = 8;
        } else {
            j = 0;
        }
        paramEmoticonPageResult.setVisibility(j);
    }

    public void e() {
        if (this.h.h()) {
            this.g.I1(null);
            return;
        }
        int j = this.i + 1;
        this.i = j;
        a.g(j, this);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        paramIntent = (Emoticon) paramIntent.getSerializableExtra(Emoticon.class.getName());
        this.e.M(paramIntent);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165556);
        paramMenu.findItem(2131231210).setTitle(2131690150);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            startActivity(new Intent(this, EmoticonManagerActivity.class));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void s0() {
        this.i = 0;
        a.g(0, this);
    }

    public void y() {
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.emoticon.ui.EmoticonMallActivity

 * JD-Core Version:    0.7.0.1

 */