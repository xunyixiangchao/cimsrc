package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.x;

class a
{
  private final View a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f = true;
  private boolean g = true;
  
  public a(View paramView)
  {
    this.a = paramView;
  }
  
  void a()
  {
    View localView = this.a;
    x.b0(localView, this.d - (localView.getTop() - this.b));
    localView = this.a;
    x.a0(localView, this.e - (localView.getLeft() - this.c));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.d;
  }
  
  void d()
  {
    this.b = this.a.getTop();
    this.c = this.a.getLeft();
  }
  
  public boolean e(int paramInt)
  {
    if ((this.g) && (this.e != paramInt))
    {
      this.e = paramInt;
      a();
      return true;
    }
    return false;
  }
  
  public boolean f(int paramInt)
  {
    if ((this.f) && (this.d != paramInt))
    {
      this.d = paramInt;
      a();
      return true;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.a
 * JD-Core Version:    0.7.0.1
 */