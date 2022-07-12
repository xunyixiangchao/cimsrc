package com.farsunset.hoxin.webrtc.widget;

import a7.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class RoomBottomMenuView
        extends LinearLayout
        implements View.OnClickListener {
    protected a a;
    private View b;
    private View c;

    public RoomBottomMenuView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void a() {
        this.c.setSelected(false);
    }

    public void b() {
        this.c.setEnabled(false);
        this.c.setAlpha(0.25F);
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        this.c.setAlpha(1.0F);
        this.c.setEnabled(true);
    }

    public void f() {
        this.b.setEnabled(true);
        this.b.setAlpha(1.0F);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return this.c.isSelected();
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131231493) {
            paramView.setSelected(paramView.isSelected() ^ true);
            this.a.k0(paramView.isSelected());
        }
        if (paramView.getId() == 2131231491) {
            paramView.setSelected(paramView.isSelected() ^ true);
            this.a.g0(paramView.isSelected());
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View localView = findViewById(2131231493);
        this.b = localView;
        localView.setOnClickListener(this);
        this.b.setEnabled(false);
        this.b.setAlpha(0.25F);
        localView = findViewById(2131231491);
        this.c = localView;
        localView.setOnClickListener(this);
        this.c.setSelected(true);
        this.c.setEnabled(false);
        this.c.setAlpha(0.25F);
    }

    public void setCameraEnable(boolean paramBoolean) {
    }

    public void setMenuListener(a parama) {
        this.a = parama;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.webrtc.widget.RoomBottomMenuView

 * JD-Core Version:    0.7.0.1

 */