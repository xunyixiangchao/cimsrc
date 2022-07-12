package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Process;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.k;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.account.api.response.LoginResult;
import com.farsunset.hoxin.account.widget.RainbowBallView;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.common.database.base.PrivateRoomDatabase;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.home.ui.SplashActivity;

import java.util.Random;

import s3.h0;
import u3.b0;

public class LoginActivity
        extends BaseActivity
        implements TextWatcher, s3.c, s3.e<LoginResult>, TextView.OnEditorActionListener {
    private EditText e;
    private EditText f;
    private WebImageView g;
    private RainbowBallView h;
    private Country i = Country.NORMAL;

    private void b1() {
        k.e(this).d();
    }

    private boolean c1() {
        if (this.e.getText().toString().length() == 0) {
        }
        for (int j = 2131690067; ; j = 2131690066) {
            X0(j);
            return false;
            if (this.f.getText().toString().length() != 0) {
                break;
            }
        }
        return true;
    }

    private void d1(User paramUser, String paramString) {
        i3.e.a(paramUser, paramString);
        PrivateRoomDatabase.N(paramUser.id);
        i3.e.c(paramUser.id);
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(2130771980, 2130771983);
        i3.a.a(SplashActivity.class);
        finish();
    }

    private void e1() {
        ((TextView) findViewById(2131230920)).setText(this.i.name);
        ((TextView) findViewById(2131230919)).setText(this.i.code);
        ((ImageView) findViewById(2131231057)).setImageResource(this.i.icon);
    }

    public int H0() {
        return 2131427383;
    }

    public void M0() {
        super.setStatusBarColor(0);
        b1();
        P0(false);
        this.h = ((RainbowBallView) findViewById(2131230824));
        this.g = ((WebImageView) findViewById(2131231053));
        this.e = ((EditText) findViewById(2131231523));
        this.f = ((EditText) findViewById(2131231348));
        this.e.setHint(Html.fromHtml(getString(2131689600)));
        this.f.setHint(Html.fromHtml(getString(2131689599)));
        Object localObject;
        if (i3.e.p()) {
            this.g.r(b0.l(i3.e.o().longValue()), this);
            localObject = i3.e.n();
            Country localCountry = g3.a.a().c((String) localObject);
            this.i = localCountry;
            this.e.setText(localCountry.format((String) localObject));
            localObject = this.f;
        } else {
            localObject = this.e;
        }
        ((EditText) localObject).requestFocus();
        this.f.setOnEditorActionListener(this);
        this.e.addTextChangedListener(this);
        x1.c.b(this, (v1.b) findViewById(2131231085), null);
        f1();
        e1();
    }

    protected boolean O0() {
        return true;
    }

    public void afterTextChanged(Editable paramEditable) {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void f1() {
        if (!"com.farsunset.hoxin.ACTION_FROM_SPLASH_ACTIVITY".equals(getIntent().getAction())) {
            return;
        }
        if (!c3.a.b.booleanValue()) {
            return;
        }
        long l = new Random().nextInt(92);
        this.e.setText(String.valueOf(l + 13500000172L));
        this.f.setText("000000");
        EditText localEditText = this.f;
        localEditText.setSelection(localEditText.getText().length());
    }

    public void g1(LoginResult paramLoginResult) {
        J0();
        if (paramLoginResult.isSuccess()) {
            this.h.a();
            i3.e.s();
            d1(paramLoginResult.data, paramLoginResult.token);
            return;
        }
        if (403 == paramLoginResult.code) {
            X0(2131690006);
        }
        if (404 == paramLoginResult.code) {
            X0(2131690005);
        }
        if (423 == paramLoginResult.code) {
            X0(2131690004);
        }
    }

    public void l0(Object paramObject, ImageView paramImageView) {
        this.g.setImageBitmap(null);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 19)) {
            this.i = ((Country) paramIntent.getSerializableExtra(Country.class.getName()));
            e1();
        }
    }

    public void onBackPressed() {
        if (getIntent().getAction() == null) {
            h.f(this);
            Process.killProcess(Process.myPid());
        }
        finish();
    }

    public void onClearButtonClicked(View paramView) {
        this.e.setText(null);
    }

    public void onCountryClicked(View paramView) {
        startActivityForResult(new Intent(this, CountrySelectorActivity.class), 19);
    }

    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent) {
        onLoginButtonClicked(null);
        return false;
    }

    public void onForgotPasswordClicked(View paramView) {
        startActivityForResult(new Intent(this, ForgotPasswordActivity.class), 19);
    }

    public void onHttpException(Exception paramException) {
        J0();
        X0(2131690028);
    }

    public void onLoginButtonClicked(View paramView) {
        if (!c1()) {
            return;
        }
        paramView = PhoneNumberUtils.formatNumberToE164(this.e.getText().toString().trim(), this.i.id);
        if (TextUtils.isEmpty(paramView)) {
            X0(2131690129);
            return;
        }
        U0(getString(2131690077, new Object[]{getString(2131689731)}));
        d3.b.d(paramView, this.f.getText().toString().trim(), this);
    }

    public void onLookButtonClicked(View paramView) {
        EditText localEditText;
        Object localObject;
        if (paramView.isSelected()) {
            localEditText = this.f;
            localObject = PasswordTransformationMethod.getInstance();
        } else {
            localEditText = this.f;
            localObject = HideReturnsTransformationMethod.getInstance();
        }
        localEditText.setTransformationMethod((TransformationMethod) localObject);
        paramView.setSelected(paramView.isSelected() ^ true);
        paramView = this.f;
        paramView.setSelection(paramView.getText().length());
    }

    public void onRegisterButtonClicked(View paramView) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        paramCharSequence = this.e.getText().toString().trim();
        String str = PhoneNumberUtils.formatNumberToE164(this.e.getText().toString().trim(), this.i.id);
        if ((paramCharSequence.length() != 0) && (!TextUtils.isEmpty(str))) {
            d3.b.b(str, new a());
            return;
        }
        this.g.setImageResource(2131165495);
    }

    public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable) {
        this.g.startAnimation(AnimationUtils.loadAnimation(this, 2130771986));
    }

    class a
            extends h0<LongResult> {
        a() {
        }

        public void a(LongResult paramLongResult) {
            if (paramLongResult.code == 200) {
                LoginActivity.a1(LoginActivity.this).q(b0.l(paramLongResult.data.longValue()), 2131165495, LoginActivity.this);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.LoginActivity

 * JD-Core Version:    0.7.0.1

 */