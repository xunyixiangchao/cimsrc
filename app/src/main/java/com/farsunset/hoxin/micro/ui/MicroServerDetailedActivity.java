package com.farsunset.hoxin.micro.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.farsunset.hoxin.micro.api.response.MicroServerMenuListResult;
import com.farsunset.hoxin.micro.entity.MicroServer;

import m5.k;
import u3.b0;
import u3.l;

public class MicroServerDetailedActivity
        extends BaseActivity {
    private MicroServer e;

    private void c1() {
        Message localMessage = new Message();
        localMessage.sender = i3.e.o();
        localMessage.format = 18;
        Object localObject = new ChatProfile();
        ((ChatProfile) localObject).id = Long.valueOf(this.e.id);
        ((ChatProfile) localObject).name = this.e.name;
        localMessage.content = l.H0(localObject);
        localObject = new Intent(this, MessageForwardActivity.class);
        ((Intent) localObject).putExtra(Message.NAME, localMessage);
        ((Intent) localObject).setFlags(268435456);
        HoxinApplication.h().startActivity((Intent) localObject);
    }

    private void d1() {
        v5.b.b(this.e.id, new c());
    }

    private void e1() {
        U0(getString(2131690077, new Object[]{getString(2131689535)}));
        v5.b.h(this.e.id, new b());
    }

    public int H0() {
        return 2131427390;
    }

    public void M0() {
        this.e = ((MicroServer) getIntent().getSerializableExtra(MessageSource.NAME));
        WebImageView localWebImageView = (WebImageView) findViewById(2131231053);
        ((TextView) findViewById(2131231257)).setText(getString(2131689772, new Object[]{this.e.account}));
        ((TextView) findViewById(2131231301)).setText(this.e.name);
        ((TextView) findViewById(2131231487)).setText(this.e.description);
        localWebImageView.p(b0.j(this.e.id), this.e.getDefaultIconRID());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        MicroServer localMicroServer = x5.a.f(this.e.id);
        if (localMicroServer == null) {
            findViewById(2131231485).setVisibility(0);
            findViewById(2131230987).setVisibility(8);
            localMicroServer = this.e;
        } else {
            findViewById(2131231485).setVisibility(8);
            findViewById(2131230987).setVisibility(0);
            getMenuInflater().inflate(2131492885, paramMenu);
        }
        S0(localMicroServer.name);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onEnterClicked(View paramView) {
        paramView = new Intent(this, MicroServerWindowActivity.class);
        paramView.putExtra("ATTR_CHAT_SESSION", ChatSession.of(this.e));
        startActivity(paramView);
    }

    public void onHomepageClicked(View paramView) {
        if (!TextUtils.isEmpty(this.e.website)) {
            paramView = new Intent(this, WebViewActivity.class);
            paramView.setData(Uri.parse(this.e.website));
            startActivity(paramView);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131230832) {
            e1();
        }
        if (paramMenuItem.getItemId() == 2131230831) {
            c1();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onSubscribeClicked(View paramView) {
        U0(getString(2131690077, new Object[]{getString(2131689535)}));
        v5.b.g(this.e.id, new a());
    }

    class a
            implements s3.e<BaseResult> {
        a() {
        }

        public void onHttpException(Exception paramException) {
            MicroServerDetailedActivity.this.J0();
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            MicroServerDetailedActivity.a1(MicroServerDetailedActivity.this);
        }
    }

    class b
            implements s3.e<BaseResult> {
        b() {
        }

        public void onHttpException(Exception paramException) {
            MicroServerDetailedActivity.this.J0();
        }

        public void onHttpResponse(BaseResult paramBaseResult) {
            x5.a.c(Long.valueOf(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this).id));
            x5.b.b(Long.valueOf(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this).id));
            long l = j5.a.f(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this));
            if (l > 0L) {
                j5.a.c(l);
                j5.b.h(l);
                paramBaseResult = new Intent("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
                paramBaseResult.putExtra("ATTR_CHAT_SESSION", ChatSession.of(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this)));
                HoxinApplication.t(paramBaseResult);
            }
            i3.a.a(MicroServerWindowActivity.class);
            MicroServerDetailedActivity.this.J0();
            MicroServerDetailedActivity.this.finish();
        }
    }

    class c
            implements s3.e<MicroServerMenuListResult> {
        c() {
        }

        public void a(MicroServerMenuListResult paramMicroServerMenuListResult) {
            MicroServerDetailedActivity.this.J0();
            x5.a.a(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this));
            x5.b.a(paramMicroServerMenuListResult.data);
            MicroServerDetailedActivity.this.finish();
            if (!TextUtils.isEmpty(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this).greet)) {
                paramMicroServerMenuListResult = new Message();
                paramMicroServerMenuListResult.createTime = Long.valueOf(System.currentTimeMillis());
                paramMicroServerMenuListResult.id = System.currentTimeMillis();
                paramMicroServerMenuListResult.action = "200";
                paramMicroServerMenuListResult.sender = Long.valueOf(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this).id);
                paramMicroServerMenuListResult.receiver = i3.e.o();
                paramMicroServerMenuListResult.format = 0;
                paramMicroServerMenuListResult.content = MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this).greet;
                paramMicroServerMenuListResult.state = Byte.valueOf((byte) 11);
                k.c(paramMicroServerMenuListResult);
            }
            paramMicroServerMenuListResult = new Intent(MicroServerDetailedActivity.this.getApplicationContext(), MicroServerWindowActivity.class);
            paramMicroServerMenuListResult.putExtra("ATTR_CHAT_SESSION", ChatSession.of(MicroServerDetailedActivity.b1(MicroServerDetailedActivity.this)));
            MicroServerDetailedActivity.this.startActivity(paramMicroServerMenuListResult);
        }

        public void onHttpException(Exception paramException) {
            MicroServerDetailedActivity.this.J0();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.micro.ui.MicroServerDetailedActivity

 * JD-Core Version:    0.7.0.1

 */