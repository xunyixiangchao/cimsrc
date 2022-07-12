package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.view.x;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.styleable;
import r7.h;
import r7.k;

class RadialViewGroup
  extends ConstraintLayout
{
  private h A;
  private final Runnable y;
  private int z;
  
  public RadialViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadialViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.material_radial_view_group, this);
    x.u0(this, B());
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RadialViewGroup, paramInt, 0);
    this.z = paramContext.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
    this.y = new a();
    paramContext.recycle();
  }
  
  private Drawable B()
  {
    h localh = new h();
    this.A = localh;
    localh.Z(new k(0.5F));
    this.A.b0(ColorStateList.valueOf(-1));
    return this.A;
  }
  
  private static boolean E(View paramView)
  {
    return "skip".equals(paramView.getTag());
  }
  
  private void G()
  {
    Handler localHandler = getHandler();
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.y);
      localHandler.post(this.y);
    }
  }
  
  public int C()
  {
    return this.z;
  }
  
  public void D(int paramInt)
  {
    this.z = paramInt;
    F();
  }
  
  protected void F()
  {
    int n = getChildCount();
    int m = 0;
    int i = 1;
    int j = 0;
    int k;
    while (j < n)
    {
      k = i;
      if (E(getChildAt(j))) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    c localc = new c();
    localc.p(this);
    float f1 = 0.0F;
    j = m;
    while (j < n)
    {
      View localView = getChildAt(j);
      k = localView.getId();
      m = R.id.circle_center;
      float f2 = f1;
      if (k != m) {
        if (E(localView))
        {
          f2 = f1;
        }
        else
        {
          localc.s(localView.getId(), m, this.z, f1);
          f2 = f1 + 360.0F / (n - i);
        }
      }
      j += 1;
      f1 = f2;
    }
    localc.i(this);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (paramView.getId() == -1) {
      paramView.setId(x.k());
    }
    G();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    F();
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    G();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.A.b0(ColorStateList.valueOf(paramInt));
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      RadialViewGroup.this.F();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.RadialViewGroup
 * JD-Core Version:    0.7.0.1
 */