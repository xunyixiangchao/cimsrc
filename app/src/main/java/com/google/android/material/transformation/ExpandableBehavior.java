package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.x;
import java.util.List;
import k7.a;

@Deprecated
public abstract class ExpandableBehavior
  extends CoordinatorLayout.Behavior<View>
{
  private int a = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean F(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      int i = this.a;
      if (i != 0)
      {
        paramBoolean = bool1;
        if (i != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramBoolean = bool2;
    if (this.a == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  protected a G(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    List localList = paramCoordinatorLayout.v(paramView);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if (e(paramCoordinatorLayout, paramView, localView)) {
        return (a)localView;
      }
      i += 1;
    }
    return null;
  }
  
  protected abstract boolean H(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean e(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  public boolean h(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (a)paramView2;
    if (F(paramCoordinatorLayout.a()))
    {
      int i;
      if (paramCoordinatorLayout.a()) {
        i = 1;
      } else {
        i = 2;
      }
      this.a = i;
      return H((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.a(), true);
    }
    return false;
  }
  
  public boolean l(final CoordinatorLayout paramCoordinatorLayout, final View paramView, final int paramInt)
  {
    if (!x.U(paramView))
    {
      paramCoordinatorLayout = G(paramCoordinatorLayout, paramView);
      if ((paramCoordinatorLayout != null) && (F(paramCoordinatorLayout.a())))
      {
        if (paramCoordinatorLayout.a()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        this.a = paramInt;
        paramView.getViewTreeObserver().addOnPreDrawListener(new a(paramView, paramInt, paramCoordinatorLayout));
      }
    }
    return false;
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(View paramView, int paramInt, a parama) {}
    
    public boolean onPreDraw()
    {
      paramView.getViewTreeObserver().removeOnPreDrawListener(this);
      if (ExpandableBehavior.E(ExpandableBehavior.this) == paramInt)
      {
        ExpandableBehavior localExpandableBehavior = ExpandableBehavior.this;
        a locala = paramCoordinatorLayout;
        localExpandableBehavior.H((View)locala, paramView, locala.a(), false);
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior
 * JD-Core Version:    0.7.0.1
 */