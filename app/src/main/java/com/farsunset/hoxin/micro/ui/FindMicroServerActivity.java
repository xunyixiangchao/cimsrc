package com.farsunset.hoxin.micro.ui;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.LoadMoreRecyclerView;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.micro.api.response.MicroServerListResult;

import s3.e;
import s3.s;
import s3.x;
import s5.a;
import v5.b;

public class FindMicroServerActivity
        extends BaseActivity
        implements e<MicroServerListResult>, x, s {
    private LoadMoreRecyclerView e;
    private a f;
    private int g = 0;
    private ToolbarSearchView h;

    public int H0() {
        return 2131427371;
    }

    public int I0() {
        return 2131690153;
    }

    public void M0() {
        Object localObject = (ToolbarSearchView) findViewById(2131231417);
        this.h = ((ToolbarSearchView) localObject);
        ((ToolbarSearchView) localObject).setOnSearchActionListener(this);
        this.h.setInputType(1);
        this.h.setMaxLength(20);
        this.h.setHint(2131689594);
        this.f = new a(this);
        localObject = (LoadMoreRecyclerView) findViewById(2131231391);
        this.e = ((LoadMoreRecyclerView) localObject);
        ((RecyclerView) localObject).setAdapter(this.f);
        this.e.setOnLoadEventListener(this);
        this.e.setFooterView(this.f.J());
    }

    public void a1(MicroServerListResult paramMicroServerListResult) {
        J0();
        this.e.I1(paramMicroServerListResult.page);
        if (paramMicroServerListResult.data == null) {
            X0(2131690123);
            return;
        }
        if ((paramMicroServerListResult.isNotEmpty()) && (this.g == 0)) {
            this.f.L(paramMicroServerListResult.data);
            return;
        }
        if ((paramMicroServerListResult.isNotEmpty()) && (this.g > 0)) {
            this.f.I(paramMicroServerListResult.data);
            return;
        }
        if (!paramMicroServerListResult.isNotEmpty()) {
            int i = this.g;
            if (i > 0) {
                this.g = (i - 1);
            }
        }
    }

    public void b0(String paramString) {
        this.g = 0;
        U0(getString(2131690077, new Object[]{getString(2131689549)}));
        b.f(0L, this.g, paramString, this);
    }

    public void e() {
        this.g += 1;
        b.f(this.f.K(), this.g, this.h.getText(), this);
    }

    public void onHttpException(Exception paramException) {
        J0();
        X0(2131690123);
    }

    public void y() {
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.FindMicroServerActivity

 * JD-Core Version:    0.7.0.1

 */