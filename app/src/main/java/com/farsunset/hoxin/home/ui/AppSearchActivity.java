package com.farsunset.hoxin.home.ui;

import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.common.widget.LinearBadgeMenuView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;

import java.util.List;

import s3.a0;
import s3.p;
import t4.f;
import t4.g;
import t4.h;
import t4.i;

public class AppSearchActivity
        extends BaseActivity
        implements a0, p<Object> {
    private RecyclerView e;
    private ToolbarSearchView f;
    private GlobalEmptyView g;
    private final t4.e h = new t4.e();
    private final f i = new f();
    private final h j = new h();
    private final g k = new g();
    private final i l = new i();
    private LinearBadgeMenuView m;
    private final Object n = Integer.valueOf(0);
    private final Object o = Integer.valueOf(1);
    private final Object p = Integer.valueOf(2);
    private final Object q = Integer.valueOf(3);
    private final Object r = Integer.valueOf(4);

    private void a1(String paramString) {
        List localList = i4.a.q(paramString);
        this.h.I(localList, paramString);
        this.e.setAdapter(this.h);
        this.g.a(this.h);
    }

    private void b1(String paramString) {
        List localList = p4.a.g(paramString);
        this.i.I(localList, paramString);
        this.e.setAdapter(this.i);
        this.g.a(this.i);
    }

    private void c1(String paramString) {
        List localList = j5.b.z(new String[]{"0", "3"}, (byte) 0, paramString);
        this.k.I(localList, paramString);
        this.e.setAdapter(this.k);
        this.g.a(this.k);
    }

    private void d1(String paramString) {
        List localList = x5.a.e(paramString);
        this.j.I(localList, paramString);
        this.e.setAdapter(this.j);
        this.g.a(this.j);
    }

    private void e1(String paramString) {
        List localList = g6.b.f(paramString);
        this.l.I(localList, paramString);
        this.e.setAdapter(this.l);
        this.g.a(this.l);
    }

    public void C0(Object paramObject, View paramView) {
        if (paramObject == this.n) {
            this.f.setHint(2131689575);
            a1(this.f.getText());
        }
        if (paramObject == this.p) {
            this.f.setHint(2131689576);
            b1(this.f.getText());
        }
        if (paramObject == this.r) {
            this.f.setHint(2131689578);
            d1(this.f.getText());
        }
        if (paramObject == this.o) {
            this.f.setHint(2131689577);
            c1(this.f.getText());
        }
        if (paramObject == this.q) {
            this.f.setHint(2131689579);
            e1(this.f.getText());
        }
    }

    protected int H0() {
        return 2131427358;
    }

    public int I0() {
        return 2131690142;
    }

    public void M0() {
        Object localObject = (GlobalEmptyView) findViewById(2131230981);
        this.g = ((GlobalEmptyView) localObject);
        ((FrameLayout) localObject).setVisibility(0);
        this.g.setTips(2131690010);
        localObject = (RecyclerView) findViewById(2131231391);
        this.e = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        this.e.setItemAnimator(new androidx.recyclerview.widget.e());
        this.e.setHasFixedSize(true);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        this.f = ((ToolbarSearchView) localObject);
        ((ToolbarSearchView) localObject).setOnTextChangedListener(this);
        this.f.setHint(2131689575);
        this.f.d();
        localObject = (LinearBadgeMenuView) findViewById(2131230821);
        this.m = ((LinearBadgeMenuView) localObject);
        ((LinearBadgeMenuView) localObject).setOnItemClickedListener(this);
        this.m.a(this.n, 2131689836);
        this.m.a(this.o, 2131689838);
        this.m.a(this.p, 2131689837);
        this.m.a(this.r, 2131689839);
        this.m.a(this.q, 2131689840);
        this.m.setSelected(this.n);
    }

    public void h0(String paramString) {
        if (this.m.c(this.n)) {
            a1(paramString);
        }
        if (this.m.c(this.p)) {
            b1(paramString);
        }
        if (this.m.c(this.r)) {
            d1(paramString);
        }
        if (this.m.c(this.q)) {
            e1(paramString);
        }
        if (this.m.c(this.o)) {
            c1(paramString);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.AppSearchActivity

 * JD-Core Version:    0.7.0.1

 */