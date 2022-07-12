package com.farsunset.hoxin.webrtc.widget;

import a7.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class RoomVideoBottomMenuView
        extends RoomBottomMenuView {
    private View d;
    private View e;

    public RoomVideoBottomMenuView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void c() {
        this.d.setEnabled(false);
        this.d.setAlpha(0.25F);
    }

    public void d() {
        this.e.setEnabled(true);
        this.e.setAlpha(1.0F);
        j();
    }

    public boolean g() {
        return this.e.isSelected();
    }

    public void i() {
        this.e.setEnabled(false);
        this.e.setAlpha(0.25F);
        c();
    }

    public void j() {
        this.d.setEnabled(true);
        this.d.setAlpha(1.0F);
    }

    public void onClick(View paramView) {
        super.onClick(paramView);
        if (paramView.getId() == 2131231490) {
            paramView.setSelected(paramView.isSelected() ^ true);
            this.a.G0(paramView.isSelected());
            if (paramView.isSelected()) {
                j();
            } else {
                c();
            }
        }
        if (paramView.getId() == 2131231563) {
            paramView.setSelected(paramView.isSelected() ^ true);
            this.a.F(paramView.isSelected());
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View localView = findViewById(2131231490);
        this.e = localView;
        localView.setOnClickListener(this);
        this.e.setSelected(false);
        localView = findViewById(2131231563);
        this.d = localView;
        localView.setOnClickListener(this);
        i();
    }

    public void setCameraEnable(boolean paramBoolean) {
        this.e.setSelected(paramBoolean);
        if (paramBoolean) {
            j();
            return;
        }
        c();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.widget.RoomVideoBottomMenuView

 * JD-Core Version:    0.7.0.1

 */