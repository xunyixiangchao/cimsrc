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

public class EditMottoActivity
        extends BaseActivity
        implements s3.e<BaseResult> {
    private EditText e;

    public int H0() {
        return 2131427392;
    }

    public int I0() {
        return 2131689849;
    }

    public void M0() {
        EditText localEditText = (EditText) findViewById(2131231273);
        this.e = localEditText;
        localEditText.setText(i3.e.i());
        findViewById(2131231273).requestFocus();
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131230850) {
            T0(2131690121);
            a.c(this.e.getText().toString().trim(), this);
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
        X0(2131690132);
        i3.e.v(this.e.getText().toString());
        finish();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.ui.EditMottoActivity

 * JD-Core Version:    0.7.0.1

 */