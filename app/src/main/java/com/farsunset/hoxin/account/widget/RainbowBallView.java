package com.farsunset.hoxin.account.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import h3.a;

public class RainbowBallView
        extends FrameLayout {
    private final int a = Resources.getSystem().getDisplayMetrics().widthPixels;
    private final int b = (int) (Resources.getSystem().getDisplayMetrics().density * 25.0F);
    private a c;
    private a d;
    private a e;
    private a f;
    private a g;
    private a h;

    public RainbowBallView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void a() {
        TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, -(this.a / 2), 0.0F, 0.0F);
        localTranslateAnimation1.setRepeatCount(0);
        localTranslateAnimation1.setDuration(200L);
        localTranslateAnimation1.setFillAfter(true);
        TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, -(this.a / 2), 0.0F, 0.0F);
        localTranslateAnimation2.setRepeatCount(0);
        localTranslateAnimation2.setDuration(300L);
        localTranslateAnimation2.setFillAfter(true);
        TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, -(this.a / 2), 0.0F, 0.0F);
        localTranslateAnimation3.setRepeatCount(0);
        localTranslateAnimation3.setDuration(400L);
        localTranslateAnimation3.setFillAfter(true);
        int i = this.a;
        TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, i - i / 2, 0.0F, 0.0F);
        localTranslateAnimation4.setRepeatCount(0);
        localTranslateAnimation4.setDuration(200L);
        localTranslateAnimation4.setFillAfter(true);
        i = this.a;
        TranslateAnimation localTranslateAnimation5 = new TranslateAnimation(0.0F, i - i / 2, 0.0F, 0.0F);
        localTranslateAnimation5.setRepeatCount(0);
        localTranslateAnimation5.setDuration(300L);
        localTranslateAnimation5.setFillAfter(true);
        i = this.a;
        TranslateAnimation localTranslateAnimation6 = new TranslateAnimation(0.0F, i - i / 2, 0.0F, 0.0F);
        localTranslateAnimation6.setRepeatCount(0);
        localTranslateAnimation6.setDuration(400L);
        localTranslateAnimation6.setFillAfter(true);
        this.e.setAnimation(localTranslateAnimation1);
        this.d.setAnimation(localTranslateAnimation2);
        this.c.setAnimation(localTranslateAnimation3);
        this.h.setAnimation(localTranslateAnimation4);
        this.g.setAnimation(localTranslateAnimation5);
        this.f.setAnimation(localTranslateAnimation6);
        localTranslateAnimation1.start();
        localTranslateAnimation2.start();
        localTranslateAnimation3.start();
        localTranslateAnimation4.start();
        localTranslateAnimation5.start();
        localTranslateAnimation6.start();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        Object localObject = getContext();
        int i = (int) (-this.b * 2.1D);
        int j = this.a;
        localObject = new a((Context) localObject, i, (int) (j / 3.5D), j / 2, -9711628, true);
        this.e = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        localObject = this.e;
        i = this.b;
        ((a) localObject).b(-i - i / 5, -i - i / 5);
        this.e.a(-932458508, -9711628);
        localObject = getContext();
        i = (int) (-this.b * 1.9D);
        j = this.a;
        localObject = new a((Context) localObject, i, j / 7, j / 2, -115129, true);
        this.d = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        this.d.a(-922792925, -1960332);
        localObject = this.d;
        i = this.b;
        ((a) localObject).b(-i, -i);
        localObject = new a(getContext(), (int) (-this.b * 1.7D), 0, this.a / 2, -734976, true);
        this.c = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        this.c.a(-923481856, -734976);
        localObject = this.c;
        i = this.b;
        ((a) localObject).b(-i + i / 5, -i);
        localObject = getContext();
        i = this.a;
        localObject = new a((Context) localObject, (int) (i + this.b * 2.1D), (int) (i / 3.5D), i / 2, -9711628, true);
        this.g = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        localObject = this.g;
        i = this.b;
        i = Math.abs(-i - i / 5);
        j = this.b;
        ((a) localObject).b(i, -j - j / 5);
        this.g.a(-929290320, -6543440);
        localObject = getContext();
        i = this.a;
        localObject = new a((Context) localObject, (int) (i + this.b * 1.9D), i / 7, i / 2, -115129, true);
        this.h = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        this.h.a(-922773504, -26624);
        localObject = this.h;
        i = this.b;
        ((a) localObject).b(i, -i);
        localObject = getContext();
        i = this.a;
        localObject = new a((Context) localObject, (int) (i + this.b * 1.7D), 0, i / 2, -734976, true);
        this.f = ((a) localObject);
        addView((View) localObject, new FrameLayout.LayoutParams(-2, -2));
        this.f.a(-938960550, -6697882);
        localObject = this.f;
        i = this.b;
        ((a) localObject).b(Math.abs(-i + i / 5), -this.b);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt2 = this.a;
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int) (paramInt2 / 3.5D + paramInt2 / 2 - this.b * 2), 1073741824));
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.account.widget.RainbowBallView

 * JD-Core Version:    0.7.0.1

 */