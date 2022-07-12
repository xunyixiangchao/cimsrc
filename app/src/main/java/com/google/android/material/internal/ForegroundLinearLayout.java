package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R.styleable;

public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  private Drawable p;
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private int s = 119;
  protected boolean t = true;
  boolean u = false;
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.s = paramContext.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.s);
    paramAttributeSet = paramContext.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.t = paramContext.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
    paramContext.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = this.p;
    if (localDrawable != null)
    {
      if (this.u)
      {
        this.u = false;
        Rect localRect1 = this.q;
        Rect localRect2 = this.r;
        int i = getRight() - getLeft();
        int j = getBottom() - getTop();
        if (this.t) {
          localRect1.set(0, 0, i, j);
        } else {
          localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
        }
        Gravity.apply(this.s, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
        localDrawable.setBounds(localRect2);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    Drawable localDrawable = this.p;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.p;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.p.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return this.p;
  }
  
  public int getForegroundGravity()
  {
    return this.s;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.p;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.u = (paramBoolean | this.u);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.u = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.p;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.p);
      }
      this.p = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
        if (this.s == 119) {
          paramDrawable.getPadding(new Rect());
        }
      }
      else
      {
        setWillNotDraw(true);
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.s != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      this.s = paramInt;
      if ((paramInt == 119) && (this.p != null))
      {
        Rect localRect = new Rect();
        this.p.getPadding(localRect);
      }
      requestLayout();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.p);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */