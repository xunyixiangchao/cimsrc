package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.widget.k0;
import androidx.core.view.h0;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import com.google.android.material.internal.t.e;
import com.google.android.material.internal.t.f;
import com.google.android.material.navigation.NavigationBarPresenter;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationBarView.b;
import com.google.android.material.navigation.NavigationBarView.c;
import com.google.android.material.navigation.c;

public class BottomNavigationView
  extends NavigationBarView
{
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, R.style.Widget_Design_BottomNavigationView);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext = getContext();
    paramAttributeSet = p.i(paramContext, paramAttributeSet, R.styleable.BottomNavigationView, paramInt1, paramInt2, new int[0]);
    setItemHorizontalTranslationEnabled(paramAttributeSet.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt1 = R.styleable.BottomNavigationView_android_minHeight;
    if (paramAttributeSet.s(paramInt1)) {
      setMinimumHeight(paramAttributeSet.f(paramInt1, 0));
    }
    paramAttributeSet.w();
    if (k()) {
      h(paramContext);
    }
    i();
  }
  
  private void h(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(androidx.core.content.b.b(paramContext, R.color.design_bottom_navigation_shadow_color));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(localView);
  }
  
  private void i()
  {
    t.b(this, new a());
  }
  
  private int j(int paramInt)
  {
    int j = getSuggestedMinimumHeight();
    int i = paramInt;
    if (View.MeasureSpec.getMode(paramInt) != 1073741824)
    {
      i = paramInt;
      if (j > 0)
      {
        i = getPaddingTop();
        int k = getPaddingBottom();
        i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt), j + (i + k)), 1073741824);
      }
    }
    return i;
  }
  
  private boolean k()
  {
    return false;
  }
  
  protected c d(Context paramContext)
  {
    return new b(paramContext);
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, j(paramInt2));
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    b localb = (b)getMenuView();
    if (localb.r() != paramBoolean)
    {
      localb.setItemHorizontalTranslationEnabled(paramBoolean);
      getPresenter().g(false);
    }
  }
  
  @Deprecated
  public void setOnNavigationItemReselectedListener(b paramb)
  {
    setOnItemReselectedListener(paramb);
  }
  
  @Deprecated
  public void setOnNavigationItemSelectedListener(c paramc)
  {
    setOnItemSelectedListener(paramc);
  }
  
  class a
    implements t.e
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0, t.f paramf)
    {
      paramf.d += paramh0.i();
      int j = x.B(paramView);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      j = paramh0.j();
      int k = paramh0.k();
      int n = paramf.a;
      if (i != 0) {
        m = k;
      } else {
        m = j;
      }
      paramf.a = (n + m);
      int m = paramf.c;
      if (i == 0) {
        j = k;
      }
      paramf.c = (m + j);
      paramf.a(paramView);
      return paramh0;
    }
  }
  
  @Deprecated
  public static abstract interface b
    extends NavigationBarView.b
  {}
  
  @Deprecated
  public static abstract interface c
    extends NavigationBarView.c
  {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */