package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.LoadMoreRecyclerView;
import com.farsunset.hoxin.common.widget.UserBannerHeaderView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.api.response.MomentListResult;
import com.farsunset.hoxin.moment.entity.Moment;
import com.google.android.material.appbar.AppBarLayout;
import com.yalantis.ucrop.UCrop;

import java.util.List;
import java.util.Map;

import s3.s;
import u3.b0;
import u3.c0;
import u3.l;

public class MineMomentActivity
        extends BaseActivity
        implements s, s3.e<MomentListResult>, s3.g, s3.b {
    private d e;
    private LoadMoreRecyclerView f;
    private int g = 0;
    private InnerMomentReceiver h;
    private String i;
    private UserBannerHeaderView j;
    private User k;
    private final n l = new a();

    private void f1() {
        View localView;
        int m;
        if (this.e.N()) {
            localView = findViewById(2131230981);
            m = 0;
        } else {
            localView = findViewById(2131230981);
            m = 8;
        }
        localView.setVisibility(m);
    }

    public int H0() {
        return 2131427374;
    }

    public void M0() {
        super.setStatusBarColor(17170445);
        Object localObject = (LoadMoreRecyclerView) findViewById(2131231261);
        this.f = ((LoadMoreRecyclerView) localObject);
        ((LoadMoreRecyclerView) localObject).setOnLoadEventListener(this);
        localObject = new d();
        this.e = ((d) localObject);
        ((b6.g) localObject).J(g6.b.l(i3.e.o()));
        localObject = new k(this);
        c localc = new c(new RecyclerView.h[]{this.e, localObject});
        this.f.setAdapter(localc);
        this.f.setFooterView(((k) localObject).I());
        this.f.J1();
        d6.b.h(this.g, this);
        localObject = new InnerMomentReceiver();
        this.h = ((InnerMomentReceiver) localObject);
        HoxinApplication.q((BroadcastReceiver) localObject, "com.farsunset.hoxin.ACTION_DELETE_MOMENT");
        setExitSharedElementCallback(this.l);
        this.j = ((UserBannerHeaderView) findViewById(2131230826));
        this.k = i3.e.g();
        this.j.setAppbarLayoutEventListener(this);
        this.j.H(this.k.id);
        this.j.G(b0.i(this.k.id));
        this.j.setMotto(this.k.motto);
        this.j.setTitle(getString(2131689775));
    }

    public void N(FileResource paramFileResource) {
        J0();
        paramFileResource = b0.i(i3.e.o().longValue());
        p3.b.a(paramFileResource);
        this.j.G(paramFileResource);
        HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MOMENT_WALLPAPER_CHANGED"));
        d6.b.l();
    }

    protected boolean O0() {
        return true;
    }

    public void X(String paramString, float paramFloat) {
        U0(getString(2131690048, new Object[]{Integer.valueOf((int) paramFloat)}));
    }

    public void e() {
        int m = this.g + 1;
        this.g = m;
        d6.b.h(m, this);
    }

    public void e1(MomentListResult paramMomentListResult) {
        this.f.I1(paramMomentListResult.page);
        if ((paramMomentListResult.isNotEmpty()) && (this.g == 0) && (!this.e.O(paramMomentListResult.data))) {
            this.e.R(paramMomentListResult.data);
            g6.b.b(paramMomentListResult.data);
        }
        if ((paramMomentListResult.isNotEmpty()) && (this.g > 0)) {
            this.e.J(paramMomentListResult.data);
        }
        if (!paramMomentListResult.isNotEmpty()) {
            int m = this.g;
            if (m > 0) {
                this.g = (m - 1);
            }
        }
        f1();
    }

    public void onActivityReenter(int paramInt, Intent paramIntent) {
        super.onActivityReenter(paramInt, paramIntent);
        this.i = paramIntent.getStringExtra("ATTR_URL");
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 9)) {
            l.F0(this, paramIntent.getData());
        }
        if ((paramInt2 == -1) && (paramInt1 == 69)) {
            paramIntent = UCrop.getOutput(paramIntent);
            c0.c(FileResource.of(o3.b.h, i3.e.o().toString(), paramIntent), this);
            U0(getString(2131690048, new Object[]{Integer.valueOf(0)}));
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492886, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        HoxinApplication.D(this.h);
    }

    public void onHttpException(Exception paramException) {
        this.f.I1(null);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231219) {
            startActivity(new Intent(this, MomentMessageActivity.class));
        }
        if (paramMenuItem.getItemId() == 2131231255) {
            l.q0(this);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void u0(AppBarLayout paramAppBarLayout) {
        this.j.setTitle(null);
    }

    public void y() {
    }

    public void y0(AppBarLayout paramAppBarLayout) {
        this.j.setTitle(getString(2131689775));
    }

    public void z(FileResource paramFileResource, Exception paramException) {
        X0(2131690135);
        J0();
    }

    public class InnerMomentReceiver
            extends BroadcastReceiver {
        public InnerMomentReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            paramContext = (Moment) paramIntent.getSerializableExtra(Moment.class.getName());
            MineMomentActivity.a1(MineMomentActivity.this).Q(paramContext);
            MineMomentActivity.b1(MineMomentActivity.this).K1(MineMomentActivity.a1(MineMomentActivity.this));
        }
    }

    class a
            extends n {
        a() {
        }

        public void d(List<String> paramList, Map<String, View> paramMap) {
            if (MineMomentActivity.c1(MineMomentActivity.this) != null) {
                View localView = MineMomentActivity.b1(MineMomentActivity.this).findViewWithTag(MineMomentActivity.c1(MineMomentActivity.this));
                String str = MineMomentActivity.c1(MineMomentActivity.this);
                paramList = localView;
                if (localView == null) {
                    paramList = MineMomentActivity.this.findViewById(2131230805);
                }
                paramMap.put(str, paramList);
                MineMomentActivity.d1(MineMomentActivity.this, null);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.MineMomentActivity

 * JD-Core Version:    0.7.0.1

 */