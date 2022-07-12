package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.organization.entity.Department;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import com.farsunset.hoxin.organization.entity.Organization;
import com.yalantis.ucrop.UCrop;

import p6.c;
import s3.g;
import s3.m;
import u3.b0;
import u3.c0;
import u3.l;

public class ProfileEditActivity
        extends BaseActivity
        implements g, m {
    private WebImageView e;
    private User f;
    private f3.a g;

    public int H0() {
        return 2131427400;
    }

    public int I0() {
        return 2131689853;
    }

    public void M0() {
        this.f = i3.e.g();
        findViewById(2131231103).setOnClickListener(this);
        findViewById(2131231106).setOnClickListener(this);
        findViewById(2131231107).setOnClickListener(this);
        ((TextView) findViewById(2131231301)).setText(this.f.name);
        ((TextView) findViewById(2131231523)).setText(this.f.telephone);
        Object localObject = (WebImageView) findViewById(2131231053);
        this.e = ((WebImageView) localObject);
        ((WebImageView) localObject).p(b0.l(this.f.id), 2131165495);
        localObject = new f3.a(this);
        this.g = ((f3.a) localObject);
        ((f3.a) localObject).e(this);
        a1();
        if (c3.a.b.booleanValue()) {
            X0(2131690039);
            findViewById(2131231103).setOnClickListener(null);
            findViewById(2131231106).setOnClickListener(null);
            findViewById(2131231107).setOnClickListener(null);
        }
    }

    public void N(FileResource paramFileResource) {
        J0();
        d3.a.b();
        p3.b.a(b0.l(this.f.id));
        this.e.o(b0.l(this.f.id));
        HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_LOGO_CHANGED"));
    }

    public void P(final String paramString) {
        T0(2131690121);
        d3.a.d(paramString, new a(paramString));
    }

    public void X(String paramString, float paramFloat) {
        U0(getString(2131690048, new Object[]{Integer.valueOf((int) paramFloat)}));
    }

    void a1() {
        Object localObject = c.c();
        if (localObject == null) {
            return;
        }
        findViewById(2131231337).setVisibility(0);
        ((TextView) findViewById(2131231336)).setText(((Organization) localObject).name);
        localObject = p6.b.f(((Organization) localObject).id.longValue(), this.f.id);
        if (localObject == null) {
            return;
        }
        ((TextView) findViewById(2131231181)).setText(((DepartmentMember) localObject).title);
        localObject = p6.a.h(((DepartmentMember) localObject).departmentId.longValue());
        if (localObject != null) {
            ((TextView) findViewById(2131230936)).setText(((Department) localObject).name);
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 9)) {
            l.D0(this, paramIntent.getData());
        }
        if ((paramInt2 == -1) && (paramInt1 == 69)) {
            paramIntent = UCrop.getOutput(paramIntent);
            c0.c(FileResource.of(o3.b.b, String.valueOf(this.f.id), paramIntent), this);
            U0(getString(2131690048, new Object[]{Integer.valueOf(0)}));
        }
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131231103) {
            l.q0(this);
        }
        if (paramView.getId() == 2131231106) {
            startActivity(new Intent(this, EditMottoActivity.class));
        }
        if (paramView.getId() == 2131231107) {
            this.g.show();
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (!c3.a.b.booleanValue()) {
            getMenuInflater().inflate(2131492891, paramMenu);
            paramMenu.findItem(2131231210).setIcon(2131165580);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            startActivity(new Intent(this, PasswordActivity.class));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        ((TextView) findViewById(2131231273)).setText(i3.e.i());
    }

    public void z(FileResource paramFileResource, Exception paramException) {
        J0();
        X0(2131690078);
    }

    class a
            implements s3.e<BaseResult> {
        a(String paramString) {
        }

        public void onHttpException(Exception paramException) {
            ProfileEditActivity.this.J0();
            ProfileEditActivity.this.X0(2131690131);
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            ProfileEditActivity.this.J0();
            ProfileEditActivity.this.X0(2131690132);
            i3.e.w(paramString);
            ((TextView) ProfileEditActivity.this.findViewById(2131231301)).setText(paramString);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.ProfileEditActivity

 * JD-Core Version:    0.7.0.1

 */