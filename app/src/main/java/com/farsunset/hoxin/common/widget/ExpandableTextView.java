package com.farsunset.hoxin.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import v3.c;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String k = ExpandableTextView.class.getSimpleName();
  protected TextView a;
  protected TextView b;
  private boolean c;
  private boolean d = true;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private SparseBooleanArray i;
  private int j;
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void e(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  private void f()
  {
    TextView localTextView = (TextView)findViewById(2131230991);
    this.a = localTextView;
    localTextView.setOnClickListener(this);
    localTextView = (TextView)findViewById(2131230990);
    this.b = localTextView;
    int m;
    if (this.d) {
      m = 2131689875;
    } else {
      m = 2131689874;
    }
    localTextView.setText(m);
    this.b.setOnClickListener(this);
  }
  
  private static int g(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + (paramTextView.getCompoundPaddingTop() + paramTextView.getCompoundPaddingBottom());
  }
  
  public CharSequence getText()
  {
    return this.a.getText();
  }
  
  public void onClick(View paramView)
  {
    if (this.b.getVisibility() != 0) {
      return;
    }
    boolean bool = this.d ^ true;
    this.d = bool;
    paramView = this.b;
    int m;
    if (bool) {
      m = 2131689875;
    } else {
      m = 2131689874;
    }
    paramView.setText(m);
    paramView = this.i;
    if (paramView != null) {
      paramView.put(this.j, this.d);
    }
    this.h = true;
    if (this.d) {
      paramView = new b(this, getHeight(), this.e);
    } else {
      paramView = new b(this, getHeight(), getHeight() + this.f - this.a.getHeight());
    }
    paramView.setFillAfter(true);
    paramView.setAnimationListener(new a());
    clearAnimation();
    startAnimation(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    f();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.h;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.c) && (getVisibility() != 8))
    {
      this.c = false;
      this.b.setVisibility(8);
      this.a.setMaxLines(2147483647);
      super.onMeasure(paramInt1, paramInt2);
      if (this.a.getLineCount() <= 8) {
        return;
      }
      this.f = g(this.a);
      if (this.d) {
        this.a.setMaxLines(8);
      }
      this.b.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
      if (this.d)
      {
        this.a.post(new c(this));
        this.e = getMeasuredHeight();
      }
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.c = true;
    this.a.setText(paramCharSequence);
    int m;
    if (TextUtils.isEmpty(paramCharSequence)) {
      m = 8;
    } else {
      m = 0;
    }
    setVisibility(m);
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      ExpandableTextView.this.clearAnimation();
      ExpandableTextView.c(ExpandableTextView.this, false);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      ExpandableTextView.b(ExpandableTextView.this.a, 0.7F);
    }
  }
  
  class b
    extends Animation
  {
    private final View a;
    private final int b;
    private final int c;
    
    b(View paramView, int paramInt1, int paramInt2)
    {
      this.a = paramView;
      this.b = paramInt1;
      this.c = paramInt2;
      setDuration(300L);
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      int i = this.c;
      int j = this.b;
      i = (int)((i - j) * paramFloat + j);
      paramTransformation = ExpandableTextView.this;
      paramTransformation.a.setMaxHeight(i - ExpandableTextView.d(paramTransformation));
      if (Float.compare(0.7F, 1.0F) != 0) {
        ExpandableTextView.b(ExpandableTextView.this.a, paramFloat * 0.3F + 0.7F);
      }
      this.a.getLayoutParams().height = i;
      this.a.requestLayout();
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.ExpandableTextView
 * JD-Core Version:    0.7.0.1
 */