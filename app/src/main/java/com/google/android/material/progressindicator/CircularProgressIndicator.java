package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;

public final class CircularProgressIndicator
  extends a<CircularProgressIndicatorSpec>
{
  public static final int p = R.style.Widget_MaterialComponents_CircularProgressIndicator;
  
  public CircularProgressIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.circularProgressIndicatorStyle);
  }
  
  public CircularProgressIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, p);
    s();
  }
  
  private void s()
  {
    setIndeterminateDrawable(i.s(getContext(), (CircularProgressIndicatorSpec)this.a));
    setProgressDrawable(e.u(getContext(), (CircularProgressIndicatorSpec)this.a));
  }
  
  public int getIndicatorDirection()
  {
    return ((CircularProgressIndicatorSpec)this.a).i;
  }
  
  public int getIndicatorInset()
  {
    return ((CircularProgressIndicatorSpec)this.a).h;
  }
  
  public int getIndicatorSize()
  {
    return ((CircularProgressIndicatorSpec)this.a).g;
  }
  
  CircularProgressIndicatorSpec r(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new CircularProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    ((CircularProgressIndicatorSpec)this.a).i = paramInt;
    invalidate();
  }
  
  public void setIndicatorInset(int paramInt)
  {
    b localb = this.a;
    if (((CircularProgressIndicatorSpec)localb).h != paramInt)
    {
      ((CircularProgressIndicatorSpec)localb).h = paramInt;
      invalidate();
    }
  }
  
  public void setIndicatorSize(int paramInt)
  {
    paramInt = Math.max(paramInt, getTrackThickness() * 2);
    b localb = this.a;
    if (((CircularProgressIndicatorSpec)localb).g != paramInt)
    {
      ((CircularProgressIndicatorSpec)localb).g = paramInt;
      ((CircularProgressIndicatorSpec)localb).e();
      invalidate();
    }
  }
  
  public void setTrackThickness(int paramInt)
  {
    super.setTrackThickness(paramInt);
    ((CircularProgressIndicatorSpec)this.a).e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicator
 * JD-Core Version:    0.7.0.1
 */