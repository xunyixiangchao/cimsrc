package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.x;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable a;
  Rect b;
  private Rect c = new Rect();
  private boolean d = true;
  private boolean e = true;
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.a = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    x.E0(this, new a());
  }
  
  protected void a(h0 paramh0) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.b != null) && (this.a != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      if (this.d)
      {
        this.c.set(0, 0, i, this.b.top);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      }
      if (this.e)
      {
        this.c.set(0, j - this.b.bottom, i, j);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      }
      Rect localRect1 = this.c;
      Rect localRect2 = this.b;
      localRect1.set(0, localRect2.top, localRect2.left, j - localRect2.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      localRect1 = this.c;
      localRect2 = this.b;
      localRect1.set(i - localRect2.right, localRect2.top, i, j - localRect2.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
  }
  
  public void setDrawBottomInsetForeground(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setDrawTopInsetForeground(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setScrimInsetForeground(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
  
  class a
    implements r
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      paramView = ScrimInsetsFrameLayout.this;
      if (paramView.b == null) {
        paramView.b = new Rect();
      }
      ScrimInsetsFrameLayout.this.b.set(paramh0.j(), paramh0.l(), paramh0.k(), paramh0.i());
      ScrimInsetsFrameLayout.this.a(paramh0);
      paramView = ScrimInsetsFrameLayout.this;
      boolean bool;
      if ((paramh0.m()) && (ScrimInsetsFrameLayout.this.a != null)) {
        bool = false;
      } else {
        bool = true;
      }
      paramView.setWillNotDraw(bool);
      x.h0(ScrimInsetsFrameLayout.this);
      return paramh0.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */