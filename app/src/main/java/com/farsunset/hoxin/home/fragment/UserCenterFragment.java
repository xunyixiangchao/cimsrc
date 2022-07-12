package com.farsunset.hoxin.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.farsunset.hoxin.account.ui.ProfileEditActivity;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.ui.EmoticonMallActivity;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.home.ui.MixedSettingActivity;
import com.farsunset.hoxin.moment.ui.MineMomentActivity;

import i3.e;
import u3.b0;

public class UserCenterFragment
        extends Fragment
        implements View.OnClickListener {
    private WebImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case 2131231242:
                paramView = new Intent(getActivity(), MixedSettingActivity.class);
                break;
            case 2131231205:
                paramView = new Intent(getActivity(), EmoticonMallActivity.class);
                break;
            case 2131231204:
            case 2131231229:
                paramView = new Intent(getActivity(), ProfileEditActivity.class);
                break;
            case 2131231188:
                paramView = new Intent(getActivity(), MineMomentActivity.class);
        }
        startActivity(paramView);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2131427443, paramViewGroup, false);
    }

    public void onResume() {
        super.onResume();
        User localUser = e.g();
        this.b.setText(localUser.name);
        this.d.setText(localUser.motto);
        this.c.setText(localUser.telephone);
        this.a.setImageResource(2131165774);
        this.a.p(b0.l(localUser.id), 2131165495);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        paramView.findViewById(2131231188).setOnClickListener(this);
        paramView.findViewById(2131231229).setOnClickListener(this);
        paramView.findViewById(2131231242).setOnClickListener(this);
        paramView.findViewById(2131231204).setOnClickListener(this);
        paramView.findViewById(2131231205).setOnClickListener(this);
        this.a = ((WebImageView) paramView.findViewById(2131231053));
        this.b = ((TextView) paramView.findViewById(2131231604));
        this.c = ((TextView) paramView.findViewById(2131231523));
        this.d = ((TextView) paramView.findViewById(2131231273));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.home.fragment.UserCenterFragment

 * JD-Core Version:    0.7.0.1

 */