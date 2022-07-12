package com.farsunset.hoxin.emoticon.ui;

import a4.b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.api.response.EmoticonItemListResult;
import com.farsunset.hoxin.emoticon.entity.Emoticon;

import u3.b0;

public class EmoticonPackageActivity
        extends BaseActivity
        implements s3.e<EmoticonItemListResult> {
    private w3.a e;
    private Emoticon f;
    private Button g;

    public int H0() {
        return 2131427366;
    }

    public void M0() {
        Object localObject = (Emoticon) getIntent().getSerializableExtra(Emoticon.class.getName());
        this.f = ((Emoticon) localObject);
        ((Emoticon) localObject).itemList = b.b(((Emoticon) localObject).id.longValue());
        S0(this.f.name);
        localObject = (Button) findViewById(2131230857);
        this.g = ((Button) localObject);
        ((Button) localObject).setEnabled(a4.a.i(this.f.id.longValue()) ^ true);
        int i;
        if (this.g.isEnabled()) {
            localObject = this.g;
            i = 2131689638;
        } else {
            localObject = this.g;
            i = 2131689725;
        }
        ((Button) localObject).setText(i);
        ((WebImageView) findViewById(2131231053)).o(b0.e(this.f.id.longValue()));
        ((TextView) findViewById(2131230938)).setText(this.f.description);
        localObject = (TextView) findViewById(2131231592);
        if (this.f.type == 0) {
            i = 2131689866;
        } else {
            i = 2131689695;
        }
        ((TextView) localObject).setText(i);
        localObject = (RecyclerView) findViewById(2131231391);
        ((RecyclerView) localObject).setItemAnimator(new androidx.recyclerview.widget.e());
        ((RecyclerView) localObject).setLayoutManager(new GridLayoutManager(this, 5, 1, false));
        w3.a locala = new w3.a();
        this.e = locala;
        ((RecyclerView) localObject).setAdapter(locala);
        this.e.I(this.f.itemList);
        if (this.e.d() == 0) {
            y3.a.f(this.f.id.longValue(), this);
        }
    }

    public void c1(EmoticonItemListResult paramEmoticonItemListResult) {
        Emoticon localEmoticon = this.f;
        paramEmoticonItemListResult = paramEmoticonItemListResult.data;
        localEmoticon.itemList = paramEmoticonItemListResult;
        this.e.I(paramEmoticonItemListResult);
        b.a(this.f.itemList);
    }

    public void onBackPressed() {
        Intent localIntent = new Intent();
        localIntent.putExtra(Emoticon.class.getName(), this.f);
        setResult(-1, localIntent);
        super.onBackPressed();
    }

    public void onBuyButtonClicked(View paramView) {
        T0(2131690009);
        y3.a.b(this.f.id.longValue(), new a());
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    class a
            implements s3.e<BaseResult> {
        a() {
        }

        public void onHttpException(Exception paramException) {
            EmoticonPackageActivity.this.J0();
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            EmoticonPackageActivity.this.J0();
            if (paramBaseResult.isSuccess()) {
                EmoticonPackageActivity.a1(EmoticonPackageActivity.this).state = 0;
                a4.a.a(EmoticonPackageActivity.a1(EmoticonPackageActivity.this));
                EmoticonPackageActivity.b1(EmoticonPackageActivity.this).setEnabled(false);
                EmoticonPackageActivity.b1(EmoticonPackageActivity.this).setText(2131689725);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.emoticon.ui.EmoticonPackageActivity

 * JD-Core Version:    0.7.0.1

 */