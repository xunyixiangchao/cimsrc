package com.farsunset.hoxin.home.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.core.view.b;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.webrtc.ui.CommunicationActivity;

import i3.e;
import u3.o;

public class CallBadgeActionProvider
        extends b
        implements View.OnClickListener {
    private View d;

    public CallBadgeActionProvider(Context paramContext) {
        super(paramContext);
        paramContext = new BadgeUpdateReceiver();
        HoxinApplication.p(paramContext, paramContext.a());
    }

    public View d() {
        View localView = LayoutInflater.from(a()).inflate(2131427560, null);
        this.d = localView;
        localView.setOnClickListener(this);
        m();
        return this.d;
    }

    public void m() {
        int i = e.h();
        o.d(this.d, i);
    }

    public void onClick(View paramView) {
        a().startActivity(new Intent(a(), CommunicationActivity.class));
    }

    public class BadgeUpdateReceiver
            extends BroadcastReceiver {
        public BadgeUpdateReceiver() {
        }

        IntentFilter a() {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.farsunset.hoxin.ACTION_UPDATE_CALL_BADGE");
            return localIntentFilter;
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            CallBadgeActionProvider.this.m();
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.widget.CallBadgeActionProvider

 * JD-Core Version:    0.7.0.1

 */