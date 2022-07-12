package com.farsunset.hoxin.common.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.widget.CustomWebView;
import com.farsunset.hoxin.message.model.ChatLink;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.farsunset.hoxin.moment.ui.MomentPublishActivity;
import com.google.android.material.snackbar.Snackbar;

import i3.e;

import java.io.Serializable;

import s3.a;
import s3.i0;
import s3.p;
import u3.l;

public class WebViewActivity
        extends BaseActivity
        implements p<Integer>, i0 {
    private CustomWebView e;
    private ProgressBar f;
    private Handler g = new a();
    private z5.b h;

    public int H0() {
        return 2131427414;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void M0() {
        Object localObject = (CustomWebView) findViewById(2131231626);
        this.e = ((CustomWebView) localObject);
        ((CustomWebView) localObject).setWebViewListener(this);
        this.e.setScrollable(true);
        localObject = (TextView) findViewById(2131231372);
        this.e.loadUrl(getIntent().getData().toString());
        this.f = ((ProgressBar) findViewById(2131231144));
        this.h = new z5.b(this, this);
        ((TextView) localObject).setText(getString(2131689898, new Object[]{l.B(this.e.getUrl())}));
    }

    public void Q(int paramInt) {
        this.f.setProgress(paramInt);
        this.f.setVisibility(0);
        if (paramInt == 100) {
            this.g.sendEmptyMessage(0);
        }
        if (paramInt > 50) {
            findViewById(2131230819).setVisibility(8);
        }
    }

    public void b1(Integer paramInteger, View paramView) {
        this.e.setTextZoom(paramInteger.intValue());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == 321)) {
            this.e.e(paramIntent.getData());
        }
        if ((paramInt2 != -1) && (paramInt1 == 321)) {
            this.e.d();
        }
    }

    public void onBackPressed() {
        if (this.e.canGoBack()) {
            this.e.goBack();
            return;
        }
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492896, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.e.destroy();
        this.g.removeCallbacksAndMessages(null);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        Object localObject1;
        Object localObject2;
        switch (paramMenuItem.getItemId()) {
            default:
                break;
            case 2131231248:
                this.h.showAtLocation(this.e, 80, 0, 0);
                break;
            case 2131231244:
                localObject1 = new Link();
                ((Link) localObject1).title = this.e.getTitle();
                ((Link) localObject1).link = this.e.getUrl();
                localObject2 = new Intent(this, MomentPublishActivity.class);
                ((Intent) localObject2).putExtra(Link.NAME, (Serializable) localObject1);
                startActivity((Intent) localObject2);
                break;
            case 2131231243:
                localObject1 = new Intent(this, MessageForwardActivity.class);
                localObject2 = new com.farsunset.hoxin.message.entity.Message();
                ((com.farsunset.hoxin.message.entity.Message) localObject2).sender = e.o();
                ((com.farsunset.hoxin.message.entity.Message) localObject2).format = 6;
                ChatLink localChatLink = new ChatLink();
                localChatLink.title = this.e.getTitle();
                localChatLink.url = this.e.getUrl();
                ((com.farsunset.hoxin.message.entity.Message) localObject2).content = l.H0(localChatLink);
                ((Intent) localObject1).putExtra(com.farsunset.hoxin.message.entity.Message.NAME, (Serializable) localObject2);
                startActivity((Intent) localObject1);
                break;
            case 2131231228:
                localObject1 = new Intent("android.intent.action.VIEW");
                ((Intent) localObject1).setData(Uri.parse(this.e.getUrl()));
                HoxinApplication.h().startActivity((Intent) localObject1);
                break;
            case 2131231198:
                ((ClipboardManager) androidx.core.content.b.h(this, ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText(null, this.e.getUrl()));
                Snackbar.b0(this.e, 2131690029, -1).P();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void t(String paramString) {
        S0(paramString);
    }

    class a
            extends Handler {
        a() {
        }

        public void handleMessage(android.os.Message paramMessage) {
            paramMessage = AnimationUtils.loadAnimation(WebViewActivity.this, 2130772003);
            paramMessage.setAnimationListener(new a());
            WebViewActivity.a1(WebViewActivity.this).startAnimation(paramMessage);
        }

        class a
                extends a {
            a() {
            }

            public void onAnimationEnd(Animation paramAnimation) {
                WebViewActivity.a1(WebViewActivity.this).setVisibility(8);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.WebViewActivity

 * JD-Core Version:    0.7.0.1

 */