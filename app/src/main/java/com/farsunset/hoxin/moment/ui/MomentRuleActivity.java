package com.farsunset.hoxin.moment.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.entity.MomentRule;

import d6.b;
import g6.c;
import s3.h0;

public class MomentRuleActivity
        extends BaseActivity
        implements CompoundButton.OnCheckedChangeListener {
    private Friend e;

    private void a1(boolean paramBoolean, byte paramByte) {
        final MomentRule localMomentRule = new MomentRule();
        localMomentRule.type = paramByte;
        long l = this.e.id;
        localMomentRule.targetId = l;
        if (paramBoolean) {
            b.b(l, paramByte, new a(localMomentRule));
            return;
        }
        b.k(l, paramByte, new b(localMomentRule));
    }

    public int H0() {
        return 2131427396;
    }

    public int I0() {
        return 2131690165;
    }

    public void M0() {
        Friend localFriend = (Friend) getIntent().getSerializableExtra(MessageSource.NAME);
        this.e = localFriend;
        if (c.b(Long.valueOf(localFriend.id), (byte) 0)) {
            ((CompoundButton) findViewById(2131231262)).setChecked(true);
        }
        if (c.b(Long.valueOf(this.e.id), (byte) 1)) {
            ((CompoundButton) findViewById(2131231260)).setChecked(true);
        }
        ((CompoundButton) findViewById(2131231260)).setOnCheckedChangeListener(this);
        ((CompoundButton) findViewById(2131231262)).setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
        if (paramCompoundButton.getId() == 2131231262) {
            a1(paramBoolean, (byte) 0);
        }
        if (paramCompoundButton.getId() == 2131231260) {
            a1(paramBoolean, (byte) 1);
        }
    }

    public void onDestroy() {
        setResult(-1);
        super.onDestroy();
    }

    class a
            extends h0<BaseResult> {
        a(MomentRule paramMomentRule) {
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            c.a(localMomentRule);
        }
    }

    class b
            extends h0<BaseResult> {
        b(MomentRule paramMomentRule) {
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            c.d(localMomentRule);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.moment.ui.MomentRuleActivity

 * JD-Core Version:    0.7.0.1

 */