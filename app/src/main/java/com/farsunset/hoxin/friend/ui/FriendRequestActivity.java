package com.farsunset.hoxin.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.UrlListResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.ui.FriendMomentActivity;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Iterator;
import java.util.List;

import s3.e;
import s3.h0;
import u3.b0;
import u3.l;
import u3.l0;

public class FriendRequestActivity
        extends BaseActivity
        implements e<BaseResult> {
    private Message e;
    private Friend f;

    private void a1() {
        final LinearLayout localLinearLayout = (LinearLayout) findViewById(2131231263);
        final int i = l.p(3.0F);
        final int j = l.p(60.0F);
        d6.b.d(this.f.id, new a(i, localLinearLayout, j));
    }

    public int H0() {
        return 2131427373;
    }

    public int I0() {
        return 2131690154;
    }

    public void M0() {
        Message localMessage = (Message) getIntent().getSerializableExtra(Message.class.getName());
        this.e = localMessage;
        this.f = i4.a.l(localMessage.sender.longValue());
        ((WebImageView) findViewById(2131231053)).o(b0.l(this.f.id));
        ((TextView) findViewById(2131231523)).setText(String.valueOf(this.f.telephone));
        ((TextView) findViewById(2131231273)).setText(this.f.motto);
        ((TextView) findViewById(2131231301)).setText(String.valueOf(this.f.name));
        a1();
    }

    public void onAddButtonClicked(View paramView) {
        T0(2131690065);
        g4.a.b(this.f.id, this);
    }

    public void onHttpException(Exception paramException) {
        J0();
    }

    public void onHttpResponse(BaseResult paramBaseResult) {
        J0();
        j5.b.D(this.e.sender.longValue(), "105", Byte.valueOf((byte) 14));
        paramBaseResult = l0.a(this.e);
        paramBaseResult.id = System.currentTimeMillis();
        paramBaseResult.createTime = Long.valueOf(System.currentTimeMillis());
        paramBaseResult.action = "0";
        paramBaseResult.format = 0;
        if (TextUtils.isEmpty(paramBaseResult.content)) {
            paramBaseResult.content = getString(2131689573, new Object[]{i4.a.k(paramBaseResult.sender.longValue())});
        }
        paramBaseResult.state = Byte.valueOf((byte) 11);
        n5.b.a(paramBaseResult, true);
        i4.a.a(this.f, (byte) 0);
        paramBaseResult = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
        paramBaseResult.putExtra("ATTR_CHAT_SESSION", j5.a.l(this.f.id, 1));
        HoxinApplication.t(paramBaseResult);
        HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
        finish();
    }

    public void onMomentZoneClicked(View paramView) {
        paramView = new Intent(this, FriendMomentActivity.class);
        paramView.putExtra(Friend.class.getName(), this.f);
        startActivity(paramView);
    }

    class a
            extends h0<UrlListResult> {
        a(int paramInt1, LinearLayout paramLinearLayout, int paramInt2) {
        }

        public void a(UrlListResult paramUrlListResult) {
            paramUrlListResult = paramUrlListResult.data.iterator();
            while (paramUrlListResult.hasNext()) {
                Object localObject = (String) paramUrlListResult.next();
                WebImageView localWebImageView = new WebImageView(FriendRequestActivity.this);
                localWebImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i = i;
                localWebImageView.setPadding(i, i, i, i);
                localWebImageView.p((String) localObject, 2131165334);
                localObject = localLinearLayout;
                i = j;
                ((LinearLayout) localObject).addView(localWebImageView, new LinearLayout.LayoutParams(i, i));
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.friend.ui.FriendRequestActivity

 * JD-Core Version:    0.7.0.1

 */