package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.ui.BaseActivity;

import j3.c;
import s3.p;

public class CountrySelectorActivity
        extends BaseActivity
        implements p<Country> {
    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131690146;
    }

    public void M0() {
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231391);
        c localc = new c();
        localc.L(this);
        localRecyclerView.setAdapter(localc);
    }

    public void a1(Country paramCountry, View paramView) {
        paramView = new Intent();
        paramView.putExtra(Country.class.getName(), paramCountry);
        setResult(-1, paramView);
        finish();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.CountrySelectorActivity

 * JD-Core Version:    0.7.0.1

 */