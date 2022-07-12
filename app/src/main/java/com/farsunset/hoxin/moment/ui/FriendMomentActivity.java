package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.n;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.c;

import b5.k;
import b6.d;
import b6.g;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.LoadMoreRecyclerView;
import com.farsunset.hoxin.common.widget.UserBannerHeaderView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.api.response.MomentListResult;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;
import java.util.Map;

import s3.e;
import s3.s;
import s3.t;
import u3.b0;
import u3.j0;

public class FriendMomentActivity
        extends BaseActivity
        implements s, e<MomentListResult>, t, s3.b {
    private d e;
    private LoadMoreRecyclerView f;
    private Friend g;
    private int h = 0;
    private String i;
    private UserBannerHeaderView j;
    private final n k = new a();

    private void e1() {
        if (this.e.N()) {
            findViewById(2131230981).setVisibility(0);
            this.f.G1();
            return;
        }
        findViewById(2131230981).setVisibility(8);
    }

    public int H0() {
        return 2131427374;
    }

    public int I0() {
        return 2131689774;
    }

    public void M0() {
        super.setStatusBarColor(17170445);
        this.g = ((Friend) getIntent().getSerializableExtra(Friend.class.getName()));
        Object localObject = (LoadMoreRecyclerView) findViewById(2131231261);
        this.f = ((LoadMoreRecyclerView) localObject);
        ((LoadMoreRecyclerView) localObject).setOnLoadEventListener(this);
        localObject = new d();
        this.e = ((d) localObject);
        ((g) localObject).J(g6.b.l(Long.valueOf(this.g.id)));
        localObject = new k(this);
        c localc = new c(new RecyclerView.h[]{this.e, localObject});
        this.f.setAdapter(localc);
        this.f.setFooterView(((k) localObject).I());
        this.f.J1();
        localObject = (UserBannerHeaderView) findViewById(2131230826);
        this.j = ((UserBannerHeaderView) localObject);
        ((UserBannerHeaderView) localObject).setOnLogoClickedListener(this);
        this.j.H(this.g.id);
        this.j.G(b0.i(this.g.id));
        this.j.setMotto(this.g.motto);
        this.j.setTitle(this.g.name);
        this.j.setAppbarLayoutEventListener(this);
        d6.b.i(this.g.id, this.h, this);
        setExitSharedElementCallback(this.k);
    }

    protected boolean O0() {
        return true;
    }

    public void d1(MomentListResult paramMomentListResult) {
        this.f.I1(paramMomentListResult.page);
        if ((paramMomentListResult.isNotEmpty()) && (this.h == 0) && (!this.e.O(paramMomentListResult.data))) {
            this.e.R(paramMomentListResult.data);
            g6.b.b(paramMomentListResult.data);
        }
        if ((paramMomentListResult.isNotEmpty()) && (this.h > 0)) {
            this.e.J(paramMomentListResult.data);
        }
        if (!paramMomentListResult.isNotEmpty()) {
            int m = this.h;
            if (m > 0) {
                this.h = (m - 1);
            }
        }
        e1();
    }

    public void e() {
        int m = this.h + 1;
        this.h = m;
        d6.b.i(this.g.id, m, this);
    }

    public void m0() {
        j0.b(this, this.g);
    }

    public void onActivityReenter(int paramInt, Intent paramIntent) {
        super.onActivityReenter(paramInt, paramIntent);
        this.i = paramIntent.getStringExtra("ATTR_URL");
    }

    public void onHttpException(Exception paramException) {
        this.f.I1(null);
    }

    public void u0(AppBarLayout paramAppBarLayout) {
        this.j.setTitle(null);
    }

    public void y() {
    }

    public void y0(AppBarLayout paramAppBarLayout) {
        this.j.setTitle(this.g.name);
    }

    class a
            extends n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            if (FriendMomentActivity.a1(FriendMomentActivity.this) != null) {
                View localView = FriendMomentActivity.c1(FriendMomentActivity.this).findViewWithTag(FriendMomentActivity.a1(FriendMomentActivity.this));
                String str = FriendMomentActivity.a1(FriendMomentActivity.this);
                paramList = localView;
                if (localView == null) {
                    paramList = FriendMomentActivity.this.findViewById(2131230805);
                }
                paramMap.put(str, paramList);
                FriendMomentActivity.b1(FriendMomentActivity.this, null);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.FriendMomentActivity

 * JD-Core Version:    0.7.0.1

 */