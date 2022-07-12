package com.farsunset.hoxin.group.ui;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.GlobalEmptyView;
import com.farsunset.hoxin.group.entity.Group;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupListActivity
        extends BaseActivity
        implements Comparator<Group> {
    private GlobalEmptyView e;
    private l4.a f;
    private long g;

    private void d1() {
        List localList = p4.a.f();
        Collections.sort(localList, this);
        this.f.J();
        this.f.I(localList);
        this.e.a(this.f);
    }

    public int H0() {
        return 2131427380;
    }

    public int I0() {
        return 2131689544;
    }

    public void M0() {
        Object localObject = (RecyclerView) findViewById(2131231035);
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        l4.a locala = new l4.a();
        this.f = locala;
        ((RecyclerView) localObject).setAdapter(locala);
        localObject = (GlobalEmptyView) findViewById(2131230981);
        this.e = ((GlobalEmptyView) localObject);
        ((GlobalEmptyView) localObject).setTips(2131690042);
        this.g = i3.e.o().longValue();
        d1();
    }

    public int b1(Group paramGroup1, Group paramGroup2) {
        long l1 = paramGroup2.uid;
        long l2 = this.g;
        int j = 1;
        int i;
        if (l1 == l2) {
            i = 1;
        } else {
            i = 0;
        }
        if (paramGroup1.uid != l2) {
            j = 0;
        }
        return Integer.compare(i, j);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        localButton.setOnClickListener(new s4.a(this));
        localButton.setText(2131689526);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onResume() {
        super.onResume();
        d1();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.group.ui.GroupListActivity

 * JD-Core Version:    0.7.0.1

 */