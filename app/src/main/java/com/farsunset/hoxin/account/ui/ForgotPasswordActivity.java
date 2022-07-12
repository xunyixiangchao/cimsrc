package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.content.Intent;
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

import com.farsunset.hoxin.account.api.request.ResetPasswordRequest;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.common.api.response.StringResult;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.ui.BaseActivity;

import d3.b;
import d3.c;
import s3.e;
import s3.h0;
import u3.k0;

public class ForgotPasswordActivity
        extends BaseActivity
        implements e<BaseResult> {
    private EditText e;
    private EditText f;
    private EditText g;
    private Button h;
    private Country i = Country.NORMAL;
    private final CountDownTimer j = new a(60000L, 1000L);

    private void d1() {
        ((TextView) findViewById(2131230920)).setText(this.i.name);
        ((TextView) findViewById(2131230919)).setText(this.i.code);
        ((ImageView) findViewById(2131231057)).setImageResource(this.i.icon);
    }

    public int H0() {
        return 2131427372;
    }

    protected int I0() {
        return 2131690171;
    }

    public void M0() {
        this.e = ((EditText) findViewById(2131231523));
        this.f = ((EditText) findViewById(2131231348));
        this.g = ((EditText) findViewById(2131230893));
        this.e.setHint(Html.fromHtml(getString(2131689605)));
        this.f.setHint(Html.fromHtml(getString(2131689601)));
        this.g.setHint(Html.fromHtml(getString(2131689606)));
        this.h = ((Button) findViewById(2131230894));
        d1();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 19)) {
            this.i = ((Country) paramIntent.getSerializableExtra(Country.class.getName()));
            d1();
        }
    }

    public void onClearButtonClicked(View paramView) {
        this.e.setText(null);
    }

    public void onCodeButtonClicked(final View paramView) {
        paramView = this.e.getText().toString().trim();
        if (paramView.length() == 0) {
            X0(2131690071);
            return;
        }
        paramView = PhoneNumberUtils.formatNumberToE164(paramView, this.i.id);
        if (TextUtils.isEmpty(paramView)) {
            X0(2131690129);
            return;
        }
        b.b(paramView, new b(paramView));
    }

    public void onCountryClicked(View paramView) {
        startActivityForResult(new Intent(this, CountrySelectorActivity.class), 19);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        J0();
        if (paramBaseResult.code == 403) {
            Y0(getString(2131690080));
            return;
        }
        Y0(getString(2131690114));
        finish();
    }

    public void onResetButtonClicked(View paramView) {
        if (TextUtils.isEmpty(this.e.getText().toString().trim())) {
            X0(2131690071);
            return;
        }
        paramView = PhoneNumberUtils.formatNumberToE164(this.e.getText().toString().trim(), this.i.id);
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
        ResetPasswordRequest localResetPasswordRequest = new ResetPasswordRequest();
        localResetPasswordRequest.setCode(this.g.getText().toString().trim());
        localResetPasswordRequest.setTelephone(paramView);
        localResetPasswordRequest.setPassword(k0.a(this.f.getText().toString().trim()));
        U0(getString(2131690108));
        b.g(localResetPasswordRequest, this);
    }

    class a
            extends CountDownTimer {
        a(long paramLong1, long paramLong2) {
            super(paramLong2);
        }

        public void onFinish() {
            ForgotPasswordActivity.a1(ForgotPasswordActivity.this).setEnabled(true);
            ForgotPasswordActivity.a1(ForgotPasswordActivity.this).setText(2131689710);
        }

        public void onTick(long paramLong) {
            ForgotPasswordActivity.a1(ForgotPasswordActivity.this).setText(ForgotPasswordActivity.this.getString(2131689689, new Object[]{Long.valueOf(paramLong / 1000L)}));
        }
    }

    class b
            extends h0<LongResult> {
        b(String paramString) {
        }

        public void a(LongResult paramLongResult) {
            if (paramLongResult.code == 404) {
                paramLongResult = ForgotPasswordActivity.this;
                paramLongResult.Y0(paramLongResult.getString(2131690130));
                return;
            }
            c.b(paramView, new a());
        }

        class a
                extends h0<StringResult> {
            a() {
            }

            public void a(StringResult paramStringResult) {
                ForgotPasswordActivity.b1(ForgotPasswordActivity.this).start();
                ForgotPasswordActivity.a1(ForgotPasswordActivity.this).setEnabled(false);
                ForgotPasswordActivity.c1(ForgotPasswordActivity.this).setText(paramStringResult.data);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.ForgotPasswordActivity

 * JD-Core Version:    0.7.0.1

 */