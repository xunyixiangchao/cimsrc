package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.e;
import androidx.core.view.h0;
import androidx.core.view.x;
import java.util.List;
import t0.a;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect d = new Rect();
  final Rect e = new Rect();
  private int f = 0;
  private int g;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int N(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388659;
    }
    return i;
  }
  
  protected void F(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = H(paramCoordinatorLayout.v(paramView));
    if (localView != null)
    {
      CoordinatorLayout.e locale = (CoordinatorLayout.e)paramView.getLayoutParams();
      Rect localRect = this.d;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + locale.leftMargin, localView.getBottom() + locale.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - locale.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - locale.bottomMargin);
      h0 localh0 = paramCoordinatorLayout.getLastWindowInsets();
      if ((localh0 != null) && (x.y(paramCoordinatorLayout)) && (!x.y(paramView)))
      {
        localRect.left += localh0.j();
        localRect.right -= localh0.k();
      }
      paramCoordinatorLayout = this.e;
      e.a(N(locale.c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = I(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      paramInt = paramCoordinatorLayout.top - localView.getBottom();
    }
    else
    {
      super.F(paramCoordinatorLayout, paramView, paramInt);
      paramInt = 0;
    }
    this.f = paramInt;
  }
  
  abstract View H(List<View> paramList);
  
  final int I(View paramView)
  {
    if (this.g == 0) {
      return 0;
    }
    float f1 = J(paramView);
    int i = this.g;
    return a.b((int)(f1 * i), 0, i);
  }
  
  float J(View paramView)
  {
    return 1.0F;
  }
  
  public final int K()
  {
    return this.g;
  }
  
  int L(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int M()
  {
    return this.f;
  }
  
  public final void O(int paramInt)
  {
    this.g = paramInt;
  }
  
  protected boolean P()
  {
    return false;
  }
  
  public boolean m(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if ((j == -1) || (j == -2))
    {
      View localView = H(paramCoordinatorLayout.v(paramView));
      if (localView != null)
      {
        int i = View.MeasureSpec.getSize(paramInt3);
        if (i > 0)
        {
          paramInt3 = i;
          if (x.y(localView))
          {
            h0 localh0 = paramCoordinatorLayout.getLastWindowInsets();
            paramInt3 = i;
            if (localh0 != null) {
              paramInt3 = i + (localh0.l() + localh0.i());
            }
          }
        }
        else
        {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        paramInt3 += L(localView);
        i = localView.getMeasuredHeight();
        if (P()) {
          paramView.setTranslationY(-i);
        } else {
          paramInt3 -= i;
        }
        if (j == -1) {
          i = 1073741824;
        } else {
          i = -2147483648;
        }
        paramCoordinatorLayout.N(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, i), paramInt4);
        return true;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */