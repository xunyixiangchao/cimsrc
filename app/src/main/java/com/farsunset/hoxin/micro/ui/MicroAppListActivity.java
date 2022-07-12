package com.farsunset.hoxin.micro.ui;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.micro.api.response.MicroAppListResult;

import s3.e;
import s5.b;
import v5.a;

public class MicroAppListActivity
        extends BaseActivity
        implements e<MicroAppListResult> {
    private b e;
    private GlobalEmptyView f;

    private void b1() {
        U0(getString(2131690076));
        a.b(this);
    }

    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131690160;
    }

    public void M0() {
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231391);
        localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        b localb = new b();
        this.e = localb;
        localRecyclerView.setAdapter(localb);
        this.f = ((GlobalEmptyView) findViewById(2131230981));
        b1();
    }

    public void a1(MicroAppListResult paramMicroAppListResult) {
        J0();
        if (paramMicroAppListResult.isNotEmpty()) {
            this.e.I(paramMicroAppListResult.data);
        }
        this.f.a(this.e);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.MicroAppListActivity

 * JD-Core Version:    0.7.0.1

 */