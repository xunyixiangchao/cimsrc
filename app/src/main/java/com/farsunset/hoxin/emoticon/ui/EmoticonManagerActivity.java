package com.farsunset.hoxin.emoticon.ui;

import a4.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;

import w3.b;

public class EmoticonManagerActivity
        extends BaseActivity {
    public int H0() {
        return 2131427361;
    }

    public int I0() {
        return 2131690150;
    }

    public void M0() {
        RecyclerView localRecyclerView = (RecyclerView) findViewById(2131231391);
        localRecyclerView.setItemAnimator(new e());
        localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        b localb = new b(a.f());
        localRecyclerView.setAdapter(localb);
        ((GlobalEmptyView) findViewById(2131230981)).a(localb);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.emoticon.ui.EmoticonManagerActivity

 * JD-Core Version:    0.7.0.1

 */