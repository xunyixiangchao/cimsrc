package com.farsunset.hoxin.account.ui;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;

import d3.a;
import s3.e;
import u3.k0;
import u3.l;

public class PasswordActivity
        extends BaseActivity
        implements e<BaseResult> {
    private EditText e;
    private EditText f;

    private void a1() {
        U0(getString(2131690077, new Object[]{getString(2131689553)}));
        a.e(k0.a(this.e.getText().toString()), k0.a(this.f.getText().toString()), this);
    }

    public int H0() {
        return 2131427393;
    }

    public int I0() {
        return 2131689850;
    }

    public void M0() {
        this.e = ((EditText) findViewById(2131231330));
        this.f = ((EditText) findViewById(2131231316));
    }

    public void onClick(View paramView) {
        if ((paramView.getId() == 2131230850) && (l.c0(this.f.getText().toString())) && (l.c0(this.e.getText().toString()))) {
            a1();
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        localButton.setOnClickListener(this);
        localButton.setText(2131689553);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onHttpException(Exception paramException) {
        J0();
        X0(2131690131);
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        J0();
        if (paramBaseResult.isSuccess()) {
            X0(2131690120);
            finish();
            return;
        }
        if (!paramBaseResult.isSuccess()) {
            X0(2131690095);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.PasswordActivity

 * JD-Core Version:    0.7.0.1

 */