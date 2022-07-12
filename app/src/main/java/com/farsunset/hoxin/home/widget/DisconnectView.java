package com.farsunset.hoxin.home.widget;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;

import n3.c;

public class DisconnectView
        extends AppCompatTextView
        implements View.OnClickListener, n3.b {
    private int a = 0;

    public DisconnectView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet, 0);
    }

    public void H(ChatSession paramChatSession, Message paramMessage) {
    }

    public void a() {
        int i = this.a + 1;
        this.a = i;
        if (i >= 3) {
            setVisibility(0);
        }
    }

    public void b(SentBody paramSentBody) {
    }

    public void f(NetworkInfo paramNetworkInfo) {
        int i;
        if (paramNetworkInfo == null) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
    }

    public void g(ReplyBody paramReplyBody) {
    }

    public void h(boolean paramBoolean) {
        this.a = 0;
        setVisibility(8);
    }

    public void i() {
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.h(this);
        f(((ConnectivityManager) androidx.core.content.b.h(getContext(), ConnectivityManager.class)).getActiveNetworkInfo());
    }

    public void onClick(View paramView) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.i(this);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.widget.DisconnectView

 * JD-Core Version:    0.7.0.1

 */