package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.account.ui.CountrySelectorActivity;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.api.response.FriendResult;
import com.farsunset.hoxin.friend.entity.Friend;

import l3.h;
import s3.a0;
import s3.e;
import s3.x;
import u3.b0;
import u3.j0;

public class FindFriendActivity
        extends BaseActivity
        implements e<FriendResult>, x, a0 {
    private TextView e;
    private WebImageView f;
    private Friend g;
    private Country h = Country.NORMAL;
    private ToolbarSearchView i;

    private void a1() {
        ((TextView) findViewById(2131230919)).setText(this.h.code);
        ((ImageView) findViewById(2131231057)).setImageResource(this.h.icon);
    }

    public int H0() {
        return 2131427370;
    }

    public int I0() {
        return 2131690152;
    }

    public void M0() {
        this.e = ((TextView) findViewById(2131231301));
        this.f = ((WebImageView) findViewById(2131231053));
        ToolbarSearchView localToolbarSearchView = (ToolbarSearchView) findViewById(2131231417);
        this.i = localToolbarSearchView;
        localToolbarSearchView.setOnSearchActionListener(this);
        this.i.setHint(Html.fromHtml(getString(2131689595)));
        this.i.setOnTextChangedListener(this);
        this.i.d();
        a1();
    }

    public void b0(String paramString) {
        paramString = PhoneNumberUtils.formatNumberToE164(paramString, this.h.id);
        if (TextUtils.isEmpty(paramString)) {
            X0(2131690129);
            return;
        }
        U0(getString(2131690077, new Object[]{getString(2131689549)}));
        h.g(paramString, this);
    }

    public void b1(FriendResult paramFriendResult) {
        J0();
        paramFriendResult = paramFriendResult.data;
        if (paramFriendResult == null) {
            findViewById(2131231603).setVisibility(8);
            X0(2131690123);
            return;
        }
        this.g = paramFriendResult;
        findViewById(2131231603).setVisibility(0);
        this.e.setText(this.g.name);
        this.f.p(b0.l(this.g.id), 2131165495);
    }

    public void h0(String paramString) {
        this.i.setBoldText(TextUtils.isEmpty(paramString) ^ true);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 19)) {
            this.h = ((Country) paramIntent.getSerializableExtra(Country.class.getName()));
            a1();
        }
    }

    public void onCountryClicked(View paramView) {
        startActivityForResult(new Intent(this, CountrySelectorActivity.class), 19);
    }

    public void onHttpException(Exception paramException) {
        J0();
        X0(2131690123);
    }

    public void onUserItemClicked(View paramView) {
        j0.b(this, this.g);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.FindFriendActivity

 * JD-Core Version:    0.7.0.1

 */