package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.account.api.request.RegisterRequest;
import com.farsunset.hoxin.account.api.response.LoginResult;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.StringResult;
import com.farsunset.hoxin.common.database.base.PrivateRoomDatabase;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.home.ui.SplashActivity;
import com.yalantis.ucrop.UCrop;

import d3.c;
import s3.h0;
import u3.c0;
import u3.k0;
import u3.l;

public class RegisterActivity
        extends BaseActivity
        implements s3.e<LoginResult> {
    private EditText e;
    private EditText f;
    private EditText g;
    private EditText h;
    private Button i;
    private WebImageView j;
    private FileResource k;
    private Country l = Country.NORMAL;
    private final CountDownTimer m = new a(60000L, 1000L);

    private void d1() {
        ((TextView) findViewById(2131230919)).setText(this.l.code);
        ((ImageView) findViewById(2131231057)).setImageResource(this.l.icon);
    }

    public int H0() {
        return 2131427401;
    }

    public int I0() {
        return 2131690169;
    }

    public void M0() {
        this.e = ((EditText) findViewById(2131231523));
        this.f = ((EditText) findViewById(2131231348));
        this.g = ((EditText) findViewById(2131230893));
        this.h = ((EditText) findViewById(2131231301));
        this.e.setHint(Html.fromHtml(getString(2131689605)));
        this.f.setHint(Html.fromHtml(getString(2131689604)));
        this.g.setHint(Html.fromHtml(getString(2131689606)));
        this.h.setHint(Html.fromHtml(getString(2131689603)));
        this.i = ((Button) findViewById(2131230894));
        this.j = ((WebImageView) findViewById(2131231150));
        d1();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = "android.permission.READ_EXTERNAL_STORAGE";
        arrayOfString[1] = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (!c8.b.h(this, arrayOfString)) {
            androidx.core.app.a.o(this, arrayOfString, 0);
        }
    }

    public void e1(LoginResult paramLoginResult) {
        J0();
        int n = paramLoginResult.code;
        if (n == 403) {
            Y0(getString(2131690080));
            return;
        }
        if (n == 409) {
            Y0(getString(2131690111));
            return;
        }
        PrivateRoomDatabase.N(paramLoginResult.data.id);
        i3.e.s();
        i3.e.a(paramLoginResult.data, paramLoginResult.token);
        FileResource localFileResource = this.k;
        if (localFileResource != null) {
            localFileResource.name = String.valueOf(paramLoginResult.data.id);
            c0.b(this.k);
        }
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(2130771980, 2130771983);
        i3.a.a(SplashActivity.class);
        i3.a.a(LoginActivity.class);
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 9)) {
            l.D0(this, paramIntent.getData());
        }
        if ((paramInt2 == -1) && (paramInt1 == 69)) {
            Uri localUri = UCrop.getOutput(paramIntent);
            this.k = FileResource.of(o3.b.b, null, localUri);
            this.j.k(localUri, 0);
        }
        if ((paramInt2 == -1) && (paramInt1 == 19)) {
            this.l = ((Country) paramIntent.getSerializableExtra(Country.class.getName()));
            d1();
        }
    }

    public void onClearButtonClicked(View paramView) {
        this.e.setText(null);
    }

    public void onCodeButtonClicked(View paramView) {
        paramView = this.e.getText().toString().trim();
        if (paramView.length() == 0) {
            X0(2131690071);
            return;
        }
        paramView = PhoneNumberUtils.formatNumberToE164(paramView, this.l.id);
        if (TextUtils.isEmpty(paramView)) {
            X0(2131690129);
            return;
        }
        c.c(paramView, new b());
    }

    public void onCountryClicked(View paramView) {
        startActivityForResult(new Intent(this, CountrySelectorActivity.class), 19);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    public void onLogoClicked(View paramView) {
        l.q0(this);
    }

    public void onRegisterButtonClicked(View paramView) {
        if (TextUtils.isEmpty(this.h.getText().toString().trim())) {
            X0(2131690069);
            return;
        }
        if (TextUtils.isEmpty(this.e.getText().toString().trim())) {
            X0(2131690071);
            return;
        }
        paramView = PhoneNumberUtils.formatNumberToE164(this.e.getText().toString().trim(), this.l.id);
        if (TextUtils.isEmpty(paramView)) {
            X0(2131690129);
            return;
        }
        if (this.g.getText().length() < 6) {
            X0(2131690068);
            return;
        }
        if (this.f.getText().length() < 6) {
            X0(2131690070);
            return;
        }
        RegisterRequest localRegisterRequest = new RegisterRequest();
        localRegisterRequest.setCode(this.g.getText().toString().trim());
        localRegisterRequest.setName(this.h.getText().toString().trim());
        localRegisterRequest.setTelephone(paramView);
        localRegisterRequest.setPassword(k0.a(this.f.getText().toString().trim()));
        U0(getString(2131690107));
        d3.b.f(localRegisterRequest, this);
    }

    class a
            extends CountDownTimer {
        a(long paramLong1, long paramLong2) {
            super(paramLong2);
        }

        public void onFinish() {
            RegisterActivity.a1(RegisterActivity.this).setEnabled(true);
            RegisterActivity.a1(RegisterActivity.this).setText(2131689710);
        }

        public void onTick(long paramLong) {
            RegisterActivity.a1(RegisterActivity.this).setText(RegisterActivity.this.getString(2131689689, new Object[]{Long.valueOf(paramLong / 1000L)}));
        }
    }

    class b
            extends h0<StringResult> {
        b() {
        }

        public void a(StringResult paramStringResult) {
            RegisterActivity.b1(RegisterActivity.this).start();
            RegisterActivity.a1(RegisterActivity.this).setEnabled(false);
            RegisterActivity.c1(RegisterActivity.this).setText(paramStringResult.data);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.RegisterActivity

 * JD-Core Version:    0.7.0.1

 */