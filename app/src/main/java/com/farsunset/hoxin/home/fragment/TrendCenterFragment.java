package com.farsunset.hoxin.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.ui.MicroAppListActivity;
import com.farsunset.hoxin.moment.ui.TimelineMomentActivity;

import j5.b;

import java.util.List;

import u3.b0;

public class TrendCenterFragment
        extends t3.a
        implements View.OnClickListener {
    private TextView a;
    private View b;
    private WebImageView c;

    private void l() {
        Message localMessage = b.p();
        int i = 0;
        if (localMessage != null) {
            ((HomeActivity) getActivity()).d1(2131231500);
            this.b.setVisibility(0);
            this.c.p(b0.m(localMessage.content), 2131165495);
        } else {
            this.b.setVisibility(8);
        }
        long l = b.c(i5.a.a);
        Object localObject = this.a;
        boolean bool = l < 0L;
        if (!bool) {
            i = 8;
        }
        ((TextView) localObject).setVisibility(i);
        TextView localTextView = this.a;
        if (bool) {
            localObject = String.valueOf(l);
        } else {
            localObject = null;
        }
        localTextView.setText((CharSequence) localObject);
        if ((localMessage == null) && (!bool)) {
            ((HomeActivity) getActivity()).b1(2131231500);
        }
        if (bool) {
            ((HomeActivity) getActivity()).e1(2131231500, (int) l);
        }
    }

    public void j(Message paramMessage) {
        if (i5.a.d.contains(paramMessage.action)) {
            l();
        }
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != 2131231220) {
            if (i != 2131231222) {
                return;
            }
            startActivity(new Intent(getActivity(), TimelineMomentActivity.class));
            this.b.setVisibility(8);
            ((HomeActivity) getActivity()).b1(2131231500);
            this.a.setVisibility(8);
            this.a.setText(null);
            return;
        }
        startActivity(new Intent(getActivity(), MicroAppListActivity.class));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2131427444, paramViewGroup, false);
    }

    public void onResume() {
        super.onResume();
        l();
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        e(2131231220).setOnClickListener(this);
        e(2131231222).setOnClickListener(this);
        this.b = e(2131231314);
        this.c = ((WebImageView) e(2131231315));
        this.a = ((TextView) e(2131231318));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.fragment.TrendCenterFragment

 * JD-Core Version:    0.7.0.1

 */