package com.farsunset.hoxin.emoticon.ui;

import a4.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;

import u3.b0;
import u3.r;
import u3.s;

public class EmoticonViewActivity
        extends BaseActivity {
    private Emoticon e;

    public int H0() {
        return 2131427367;
    }

    public int I0() {
        return 2131690151;
    }

    public void M0() {
        Object localObject = (EmoticonItem) getIntent().getSerializableExtra(EmoticonItem.class.getName());
        ((TextView) findViewById(2131231301)).setText(((EmoticonItem) localObject).name);
        ImageView localImageView = (ImageView) findViewById(2131231072);
        if (((EmoticonItem) localObject).isDynamic()) {
            s.a().f(localImageView, b0.d(((EmoticonItem) localObject).id.longValue()));
        }
        if (((EmoticonItem) localObject).isStatic()) {
            s.a().l(localImageView, b0.d(((EmoticonItem) localObject).id.longValue()));
        }
        localObject = a.h(((EmoticonItem) localObject).emoticonId.longValue());
        this.e = ((Emoticon) localObject);
        if (localObject == null) {
            findViewById(2131231114).setVisibility(8);
        }
        ((WebImageView) findViewById(2131231053)).o(b0.e(this.e.id.longValue()));
        ((TextView) findViewById(2131231341)).setText(this.e.name);
    }

    public void onLookMenuClicked(View paramView) {
        paramView = new Intent(this, EmoticonPackageActivity.class);
        paramView.putExtra(Emoticon.class.getName(), this.e);
        startActivity(paramView);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.emoticon.ui.EmoticonViewActivity

 * JD-Core Version:    0.7.0.1

 */