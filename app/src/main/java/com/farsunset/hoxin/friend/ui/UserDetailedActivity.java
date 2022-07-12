package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.UserBannerHeaderView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.api.response.FriendResult;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import com.farsunset.hoxin.moment.ui.FriendMomentActivity;
import com.farsunset.hoxin.organization.entity.Department;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import com.farsunset.hoxin.organization.entity.Organization;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationBarView.c;

import java.util.Iterator;
import java.util.List;

import l3.h;
import p6.c;
import s3.t;
import u3.b0;
import u3.l;

public class UserDetailedActivity
        extends BaseActivity
        implements s3.e<FriendResult>, NavigationBarView.c, t, s3.b {
    private Friend e;
    private UserBannerHeaderView f;

    public int H0() {
        return 2131427408;
    }

    public void M0() {
        super.setStatusBarColor(17170445);
        Friend localFriend = (Friend) getIntent().getSerializableExtra(Friend.class.getName());
        this.e = localFriend;
        if (!i4.a.e(localFriend.id)) {
            h.f(this.e.id, this);
        }
        e1();
        d1();
        b1();
        a1();
        c1();
    }

    protected boolean O0() {
        return true;
    }

    void a1() {
        UserBannerHeaderView localUserBannerHeaderView = (UserBannerHeaderView) findViewById(2131230826);
        this.f = localUserBannerHeaderView;
        localUserBannerHeaderView.setBannerResource(2131165774);
        this.f.H(this.e.id);
        this.f.setTitle(this.e.name);
        this.f.setMotto(this.e.motto);
        this.f.F(this.e.id);
        this.f.setOnLogoClickedListener(this);
        this.f.setAppbarLayoutEventListener(this);
    }

    void b1() {
        BottomNavigationView localBottomNavigationView = (BottomNavigationView) findViewById(2131231302);
        long l1 = i3.e.o().longValue();
        long l2 = this.e.id;
        if (l1 == l2) {
            ((ViewGroup) localBottomNavigationView.getParent()).removeView(localBottomNavigationView);
            return;
        }
        if (i4.a.o(l2)) {
            localBottomNavigationView.getMenu().findItem(2131231498).setVisible(false);
            localBottomNavigationView.getMenu().findItem(2131231508).setVisible(true);
            localBottomNavigationView.getMenu().findItem(2131231507).setVisible(true);
            localBottomNavigationView.getMenu().findItem(2131231506).setVisible(true);
        }
        if (i4.a.n(this.e.id)) {
            localBottomNavigationView.getMenu().findItem(2131231498).setVisible(true);
        }
        localBottomNavigationView.setOnItemSelectedListener(this);
    }

    public boolean c(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231498) {
            new k4.a(this).e(this.e);
        }
        Object localObject;
        if (paramMenuItem.getItemId() == 2131231506) {
            localObject = new Intent(this, FriendChatActivity.class);
            ((Intent) localObject).putExtra("ATTR_CHAT_SESSION", ChatSession.of(this.e));
            startActivity((Intent) localObject);
        }
        if (paramMenuItem.getItemId() == 2131231508) {
            localObject = j5.a.m(this.e);
            HoxinApplication.h().u((ChatSession) localObject);
        }
        if (paramMenuItem.getItemId() == 2131231507) {
            paramMenuItem = j5.a.m(this.e);
            HoxinApplication.h().v(paramMenuItem);
        }
        return false;
    }

    void c1() {
        Object localObject = g6.b.h(this.e.id);
        if (((List) localObject).isEmpty()) {
            return;
        }
        LinearLayout localLinearLayout = (LinearLayout) findViewById(2131231263);
        int i = l.p(3.0F);
        int j = l.p(60.0F);
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            String str = (String) ((Iterator) localObject).next();
            WebImageView localWebImageView = new WebImageView(this);
            localWebImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localWebImageView.setPadding(i, i, i, i);
            localWebImageView.p(str, 2131165334);
            localLinearLayout.addView(localWebImageView, new LinearLayout.LayoutParams(j, j));
        }
    }

    void d1() {
        Object localObject = c.c();
        if (localObject == null) {
            return;
        }
        DepartmentMember localDepartmentMember = p6.b.f(((Organization) localObject).id.longValue(), this.e.id);
        if (localDepartmentMember == null) {
            return;
        }
        findViewById(2131231337).setVisibility(0);
        ((TextView) findViewById(2131231336)).setText(((Organization) localObject).name);
        ((TextView) findViewById(2131231181)).setText(localDepartmentMember.title);
        localObject = p6.a.h(localDepartmentMember.departmentId.longValue());
        if (localObject != null) {
            ((TextView) findViewById(2131230936)).setText(((Department) localObject).name);
        }
    }

    void e1() {
        ((TextView) findViewById(2131231301)).setText(this.e.name);
        ((TextView) findViewById(2131230978)).setText(this.e.email);
        ((TextView) findViewById(2131231523)).setText(this.e.telephone);
    }

    public void f1(FriendResult paramFriendResult) {
        this.e = paramFriendResult.data;
        e1();
    }

    public void m0() {
        CloudImage localCloudImage = new CloudImage();
        localCloudImage.bucket = o3.b.b.a();
        localCloudImage.uri = b0.l(this.e.id);
        HoxinApplication.h().z(this, localCloudImage, this.f.getLogoView());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492872, paramMenu);
        long l1 = i3.e.o().longValue();
        long l2 = this.e.id;
        if ((l1 == l2) || (i4.a.n(l2))) {
            paramMenu.findItem(2131231224).setVisible(false);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onHttpException(Exception paramException) {
    }

    public void onMomentZoneClicked(View paramView) {
        paramView = new Intent(this, FriendMomentActivity.class);
        paramView.putExtra(Friend.class.getName(), this.e);
        startActivity(paramView);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231224) {
            new k4.b(this, this.e).show();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void u0(AppBarLayout paramAppBarLayout) {
        this.f.setTitle(null);
    }

    public void y0(AppBarLayout paramAppBarLayout) {
        this.f.setTitle(this.e.name);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.UserDetailedActivity

 * JD-Core Version:    0.7.0.1

 */