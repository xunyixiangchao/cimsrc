package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private a a;
  private int b = 0;
  private int c = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int E()
  {
    a locala = this.a;
    if (locala != null) {
      return locala.c();
    }
    return 0;
  }
  
  protected void F(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.M(paramV, paramInt);
  }
  
  public boolean G(int paramInt)
  {
    a locala = this.a;
    if (locala != null) {
      return locala.f(paramInt);
    }
    this.b = paramInt;
    return false;
  }
  
  public boolean l(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    F(paramCoordinatorLayout, paramV, paramInt);
    if (this.a == null) {
      this.a = new a(paramV);
    }
    this.a.d();
    this.a.a();
    paramInt = this.b;
    if (paramInt != 0)
    {
      this.a.f(paramInt);
      this.b = 0;
    }
    paramInt = this.c;
    if (paramInt != 0)
    {
      this.a.e(paramInt);
      this.c = 0;
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */