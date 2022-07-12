package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.widget.k0;
import androidx.core.view.h0;
import androidx.core.view.h0.m;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import com.google.android.material.internal.t.e;
import com.google.android.material.internal.t.f;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationRailView
  extends NavigationBarView
{
  private final int h = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
  private View i;
  private Boolean j = null;
  private Boolean k = null;
  
  public NavigationRailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.navigationRailStyle);
  }
  
  public NavigationRailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, R.style.Widget_MaterialComponents_NavigationRailView);
  }
  
  public NavigationRailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext = p.i(getContext(), paramAttributeSet, R.styleable.NavigationRailView, paramInt1, paramInt2, new int[0]);
    paramInt1 = paramContext.n(R.styleable.NavigationRailView_headerLayout, 0);
    if (paramInt1 != 0) {
      k(paramInt1);
    }
    setMenuGravity(paramContext.k(R.styleable.NavigationRailView_menuGravity, 49));
    paramInt1 = R.styleable.NavigationRailView_itemMinHeight;
    if (paramContext.s(paramInt1)) {
      setItemMinimumHeight(paramContext.f(paramInt1, -1));
    }
    paramInt1 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
    if (paramContext.s(paramInt1)) {
      this.j = Boolean.valueOf(paramContext.a(paramInt1, false));
    }
    paramInt1 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
    if (paramContext.s(paramInt1)) {
      this.k = Boolean.valueOf(paramContext.a(paramInt1, false));
    }
    paramContext.w();
    m();
  }
  
  private b getNavigationRailMenuView()
  {
    return (b)getMenuView();
  }
  
  private void m()
  {
    t.b(this, new a());
  }
  
  private boolean o()
  {
    View localView = this.i;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  private int p(int paramInt)
  {
    int n = getSuggestedMinimumWidth();
    int m = paramInt;
    if (View.MeasureSpec.getMode(paramInt) != 1073741824)
    {
      m = paramInt;
      if (n > 0)
      {
        m = getPaddingLeft();
        int i1 = getPaddingRight();
        m = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt), n + (m + i1)), 1073741824);
      }
    }
    return m;
  }
  
  private boolean r(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      return paramBoolean.booleanValue();
    }
    return x.y(this);
  }
  
  public View getHeaderView()
  {
    return this.i;
  }
  
  public int getItemMinimumHeight()
  {
    return ((b)getMenuView()).getItemMinimumHeight();
  }
  
  public int getMaxItemCount()
  {
    return 7;
  }
  
  public int getMenuGravity()
  {
    return getNavigationRailMenuView().getMenuGravity();
  }
  
  public void k(int paramInt)
  {
    l(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
  }
  
  public void l(View paramView)
  {
    q();
    this.i = paramView;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    localLayoutParams.topMargin = this.h;
    addView(paramView, 0, localLayoutParams);
  }
  
  protected b n(Context paramContext)
  {
    return new b(paramContext);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = getNavigationRailMenuView();
    paramBoolean = o();
    paramInt1 = 0;
    if (paramBoolean)
    {
      paramInt2 = this.i.getBottom() + this.h;
      paramInt3 = localb.getTop();
      if (paramInt3 < paramInt2) {
        paramInt1 = paramInt2 - paramInt3;
      }
    }
    else if (localb.r())
    {
      paramInt1 = this.h;
    }
    if (paramInt1 > 0) {
      localb.layout(localb.getLeft(), localb.getTop() + paramInt1, localb.getRight(), localb.getBottom() + paramInt1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = p(paramInt1);
    super.onMeasure(paramInt1, paramInt2);
    if (o())
    {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - this.i.getMeasuredHeight() - this.h, -2147483648);
      measureChild(getNavigationRailMenuView(), paramInt1, paramInt2);
    }
  }
  
  public void q()
  {
    View localView = this.i;
    if (localView != null)
    {
      removeView(localView);
      this.i = null;
    }
  }
  
  public void setItemMinimumHeight(int paramInt)
  {
    ((b)getMenuView()).setItemMinimumHeight(paramInt);
  }
  
  public void setMenuGravity(int paramInt)
  {
    getNavigationRailMenuView().setMenuGravity(paramInt);
  }
  
  class a
    implements t.e
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0, t.f paramf)
    {
      NavigationRailView localNavigationRailView = NavigationRailView.this;
      if (NavigationRailView.i(localNavigationRailView, NavigationRailView.h(localNavigationRailView))) {
        paramf.b += paramh0.f(h0.m.c()).b;
      }
      localNavigationRailView = NavigationRailView.this;
      if (NavigationRailView.i(localNavigationRailView, NavigationRailView.j(localNavigationRailView))) {
        paramf.d += paramh0.f(h0.m.c()).d;
      }
      int j = x.B(paramView);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      j = paramh0.j();
      int k = paramh0.k();
      int m = paramf.a;
      if (i != 0) {
        j = k;
      }
      paramf.a = (m + j);
      paramf.a(paramView);
      return paramh0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigationrail.NavigationRailView
 * JD-Core Version:    0.7.0.1
 */