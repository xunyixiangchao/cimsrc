package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;

public final class LinearProgressIndicator
  extends a<LinearProgressIndicatorSpec>
{
  public static final int p = R.style.Widget_MaterialComponents_LinearProgressIndicator;
  
  public LinearProgressIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.linearProgressIndicatorStyle);
  }
  
  public LinearProgressIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, p);
    s();
  }
  
  private void s()
  {
    setIndeterminateDrawable(i.t(getContext(), (LinearProgressIndicatorSpec)this.a));
    setProgressDrawable(e.v(getContext(), (LinearProgressIndicatorSpec)this.a));
  }
  
  public int getIndeterminateAnimationType()
  {
    return ((LinearProgressIndicatorSpec)this.a).g;
  }
  
  public int getIndicatorDirection()
  {
    return ((LinearProgressIndicatorSpec)this.a).h;
  }
  
  public void o(int paramInt, boolean paramBoolean)
  {
    b localb = this.a;
    if ((localb != null) && (((LinearProgressIndicatorSpec)localb).g == 0) && (isIndeterminate())) {
      return;
    }
    super.o(paramInt, paramBoolean);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = this.a;
    LinearProgressIndicatorSpec localLinearProgressIndicatorSpec = (LinearProgressIndicatorSpec)localb;
    paramInt1 = ((LinearProgressIndicatorSpec)localb).h;
    boolean bool = true;
    paramBoolean = bool;
    if (paramInt1 != 1) {
      if (x.B(this) == 1)
      {
        paramBoolean = bool;
        if (((LinearProgressIndicatorSpec)this.a).h == 2) {}
      }
      else if ((x.B(this) == 0) && (((LinearProgressIndicatorSpec)this.a).h == 3))
      {
        paramBoolean = bool;
      }
      else
      {
        paramBoolean = false;
      }
    }
    localLinearProgressIndicatorSpec.i = paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 -= getPaddingLeft() + getPaddingRight();
    paramInt2 -= getPaddingTop() + getPaddingBottom();
    Object localObject = getIndeterminateDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
    localObject = getProgressDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  LinearProgressIndicatorSpec r(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LinearProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  public void setIndeterminateAnimationType(int paramInt)
  {
    if (((LinearProgressIndicatorSpec)this.a).g == paramInt) {
      return;
    }
    if ((q()) && (isIndeterminate())) {
      throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }
    Object localObject = this.a;
    ((LinearProgressIndicatorSpec)localObject).g = paramInt;
    ((LinearProgressIndicatorSpec)localObject).e();
    i locali;
    if (paramInt == 0)
    {
      locali = getIndeterminateDrawable();
      localObject = new k((LinearProgressIndicatorSpec)this.a);
    }
    else
    {
      locali = getIndeterminateDrawable();
      localObject = new l(getContext(), (LinearProgressIndicatorSpec)this.a);
    }
    locali.w((h)localObject);
    invalidate();
  }
  
  public void setIndicatorColor(int... paramVarArgs)
  {
    super.setIndicatorColor(paramVarArgs);
    ((LinearProgressIndicatorSpec)this.a).e();
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    Object localObject = this.a;
    ((LinearProgressIndicatorSpec)localObject).h = paramInt;
    localObject = (LinearProgressIndicatorSpec)localObject;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (x.B(this) == 1)
      {
        bool1 = bool2;
        if (((LinearProgressIndicatorSpec)this.a).h == 2) {}
      }
      else if ((x.B(this) == 0) && (paramInt == 3))
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
    }
    ((LinearProgressIndicatorSpec)localObject).i = bool1;
    invalidate();
  }
  
  public void setTrackCornerRadius(int paramInt)
  {
    super.setTrackCornerRadius(paramInt);
    ((LinearProgressIndicatorSpec)this.a).e();
    invalidate();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicator
 * JD-Core Version:    0.7.0.1
 */