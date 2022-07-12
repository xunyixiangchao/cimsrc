package com.farsunset.hoxin.home.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.CIMMonitorActivity;
import com.farsunset.hoxin.friend.ui.FindFriendActivity;
import com.farsunset.hoxin.group.ui.CreateGroupActivity;
import com.farsunset.hoxin.home.fragment.ContactsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationBarView.c;

import u3.m0;

public class HomeActivity
        extends CIMMonitorActivity
        implements NavigationBarView.c {
    private TabHost e;
    private BottomNavigationView f;
    private float g;

    public int H0() {
        return 2131427382;
    }

    public int I0() {
        return 2131689541;
    }

    public void M0() {
        P0(false);
        Object localObject = (BottomNavigationView) findViewById(2131231302);
        this.f = ((BottomNavigationView) localObject);
        ((NavigationBarView) localObject).setOnItemSelectedListener(this);
        localObject = (TabHost) findViewById(16908306);
        this.e = ((TabHost) localObject);
        ((TabHost) localObject).setup();
        this.a.setOnClickListener(this);
        this.g = this.a.getElevation();
        localObject = this.e;
        ((TabHost) localObject).addTab(((TabHost) localObject).newTabSpec(getString(2131689541)).setIndicator(new TextView(this)).setContent(2131230913));
        localObject = this.e;
        ((TabHost) localObject).addTab(((TabHost) localObject).newTabSpec(getString(2131689524)).setIndicator(new TextView(this)).setContent(2131230904));
        localObject = this.e;
        ((TabHost) localObject).addTab(((TabHost) localObject).newTabSpec(getString(2131689560)).setIndicator(new TextView(this)).setContent(2131231590));
        localObject = this.e;
        ((TabHost) localObject).addTab(((TabHost) localObject).newTabSpec(getString(2131689543)).setIndicator(new TextView(this)).setContent(2131231434));
        HoxinApplication.h().d();
        HoxinApplication.h().j(this);
        HoxinApplication.h().y();
        HoxinApplication.h().b();
        this.f.g(2131231501);
        this.f.g(2131231499);
        this.f.g(2131231500);
        this.f.g(2131231502);
        m0.b(new a5.a(this));
    }

    public void b1(int paramInt) {
        this.f.g(paramInt);
    }

    public boolean c(MenuItem paramMenuItem) {
        this.e.setCurrentTabByTag(paramMenuItem.getTitle().toString());
        setTitle(paramMenuItem.getTitle());
        Toolbar localToolbar = this.a;
        int i;
        if (paramMenuItem.getItemId() == 2131231502) {
            i = 8;
        } else {
            i = 0;
        }
        localToolbar.setVisibility(i);
        localToolbar = this.a;
        float f1;
        if (paramMenuItem.getItemId() == 2131231499) {
            f1 = 0.0F;
        } else {
            f1 = this.g;
        }
        localToolbar.setElevation(f1);
        return true;
    }

    public void d1(int paramInt) {
        com.google.android.material.badge.a locala = this.f.e(paramInt);
        locala.D(true);
        locala.x(b.b(this, 17170454));
    }

    public void e1(int paramInt1, int paramInt2) {
        if (paramInt2 <= 0) {
            b1(paramInt1);
            return;
        }
        com.google.android.material.badge.a locala = this.f.e(paramInt1);
        locala.x(b.b(this, 17170454));
        locala.y(b.b(this, 17170443));
        locala.z(3);
        locala.A(paramInt2);
        locala.D(true);
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onClick(View paramView) {
        if ((paramView == this.a) && (this.e.getCurrentTab() == 1)) {
            ((ContactsFragment) getSupportFragmentManager().i0(2131230904)).o();
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492879, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        if ("com.farsunset.hoxin.ACTION_FROM_NOTIFICATION".equals(paramIntent.getAction())) {
            this.f.setSelectedItemId(2131231501);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231240) {
            startActivity(new Intent(this, AppSearchActivity.class));
        }
        if (paramMenuItem.getItemId() == 2131231187) {
            startActivity(new Intent(this, CreateGroupActivity.class));
        }
        if (paramMenuItem.getItemId() == 2131231186) {
            startActivity(new Intent(this, FindFriendActivity.class));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        h.o(this);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.ui.HomeActivity

 * JD-Core Version:    0.7.0.1

 */