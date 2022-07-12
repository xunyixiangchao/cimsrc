package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.x;
import c1.c;
import c1.c.c;
import y0.d.a;
import y0.g;
import y0.g.a;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  c a;
  c b;
  private boolean c;
  private float d = 0.0F;
  private boolean e;
  int f = 2;
  float g = 0.5F;
  float h = 0.0F;
  float i = 0.5F;
  private final c.c j = new a();
  
  static float F(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int G(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void H(ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      if (this.e) {
        paramViewGroup = c.o(paramViewGroup, this.d, this.j);
      } else {
        paramViewGroup = c.p(paramViewGroup, this.j);
      }
      this.a = paramViewGroup;
    }
  }
  
  static float I(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void N(View paramView)
  {
    x.k0(paramView, 1048576);
    if (E(paramView)) {
      x.m0(paramView, d.a.y, null, new b());
    }
  }
  
  public boolean D(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = this.a;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.G(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean E(View paramView)
  {
    return true;
  }
  
  public void J(float paramFloat)
  {
    this.i = F(0.0F, paramFloat, 1.0F);
  }
  
  public void K(c paramc)
  {
    this.b = paramc;
  }
  
  public void L(float paramFloat)
  {
    this.h = F(0.0F, paramFloat, 1.0F);
  }
  
  public void M(int paramInt)
  {
    this.f = paramInt;
  }
  
  public boolean k(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool = this.c;
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if ((k == 1) || (k == 3)) {
        this.c = false;
      }
    }
    else
    {
      bool = paramCoordinatorLayout.F(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.c = bool;
    }
    if (bool)
    {
      H(paramCoordinatorLayout);
      return this.a.Q(paramMotionEvent);
    }
    return false;
  }
  
  public boolean l(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    boolean bool = super.l(paramCoordinatorLayout, paramV, paramInt);
    if (x.z(paramV) == 0)
    {
      x.B0(paramV, 1);
      N(paramV);
    }
    return bool;
  }
  
  class a
    extends c.c
  {
    private int a;
    private int b = -1;
    
    a() {}
    
    private boolean n(View paramView, float paramFloat)
    {
      boolean bool1 = paramFloat < 0.0F;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool2 = false;
      if (bool1)
      {
        if (x.B(paramView) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        k = SwipeDismissBehavior.this.f;
        if (k == 2) {
          return true;
        }
        if (k == 0)
        {
          if (i != 0 ? paramFloat < 0.0F : bool1) {
            bool2 = true;
          }
          return bool2;
        }
        bool2 = bool3;
        if (k == 1)
        {
          if (i != 0)
          {
            bool2 = bool3;
            if (!bool1) {
              break label119;
            }
          }
          else
          {
            bool2 = bool3;
            if (paramFloat >= 0.0F) {
              break label119;
            }
          }
          bool2 = true;
        }
        label119:
        return bool2;
      }
      int i = paramView.getLeft();
      int j = this.a;
      int k = Math.round(paramView.getWidth() * SwipeDismissBehavior.this.g);
      bool2 = bool4;
      if (Math.abs(i - j) >= k) {
        bool2 = true;
      }
      return bool2;
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      if (x.B(paramView) == 1) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      int i = SwipeDismissBehavior.this.f;
      if (i == 0) {
        if (paramInt2 != 0)
        {
          i = this.a - paramView.getWidth();
          paramInt2 = this.a;
          break label105;
        }
      }
      for (;;)
      {
        i = this.a;
        paramInt2 = paramView.getWidth() + i;
        break label105;
        if (i != 1) {
          break label82;
        }
        if (paramInt2 == 0) {
          break;
        }
      }
      label82:
      i = this.a - paramView.getWidth();
      paramInt2 = this.a;
      paramInt2 = paramView.getWidth() + paramInt2;
      label105:
      return SwipeDismissBehavior.G(i, paramInt1, paramInt2);
    }
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int d(View paramView)
    {
      return paramView.getWidth();
    }
    
    public void i(View paramView, int paramInt)
    {
      this.b = paramInt;
      this.a = paramView.getLeft();
      paramView = paramView.getParent();
      if (paramView != null) {
        paramView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void j(int paramInt)
    {
      SwipeDismissBehavior.c localc = SwipeDismissBehavior.this.b;
      if (localc != null) {
        localc.b(paramInt);
      }
    }
    
    public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      float f1 = this.a + paramView.getWidth() * SwipeDismissBehavior.this.h;
      float f2 = this.a + paramView.getWidth() * SwipeDismissBehavior.this.i;
      float f3 = paramInt1;
      if (f3 <= f1)
      {
        paramView.setAlpha(1.0F);
        return;
      }
      if (f3 >= f2)
      {
        paramView.setAlpha(0.0F);
        return;
      }
      paramView.setAlpha(SwipeDismissBehavior.F(0.0F, 1.0F - SwipeDismissBehavior.I(f1, f2, f3), 1.0F));
    }
    
    public void l(View paramView, float paramFloat1, float paramFloat2)
    {
      this.b = -1;
      int i = paramView.getWidth();
      boolean bool;
      if (n(paramView, paramFloat1))
      {
        int j = paramView.getLeft();
        int k = this.a;
        if (j < k) {
          i = k - i;
        } else {
          i = k + i;
        }
        bool = true;
      }
      else
      {
        i = this.a;
        bool = false;
      }
      if (SwipeDismissBehavior.this.a.P(i, paramView.getTop()))
      {
        x.i0(paramView, new SwipeDismissBehavior.d(SwipeDismissBehavior.this, paramView, bool));
        return;
      }
      if (bool)
      {
        SwipeDismissBehavior.c localc = SwipeDismissBehavior.this.b;
        if (localc != null) {
          localc.a(paramView);
        }
      }
    }
    
    public boolean m(View paramView, int paramInt)
    {
      int i = this.b;
      return ((i == -1) || (i == paramInt)) && (SwipeDismissBehavior.this.E(paramView));
    }
  }
  
  class b
    implements g
  {
    b() {}
    
    public boolean a(View paramView, g.a parama)
    {
      boolean bool = SwipeDismissBehavior.this.E(paramView);
      int k = 0;
      if (bool)
      {
        if (x.B(paramView) == 1) {
          j = 1;
        } else {
          j = 0;
        }
        int m = SwipeDismissBehavior.this.f;
        int i;
        if ((m != 0) || (j == 0))
        {
          i = k;
          if (m == 1)
          {
            i = k;
            if (j != 0) {}
          }
        }
        else
        {
          i = 1;
        }
        k = paramView.getWidth();
        int j = k;
        if (i != 0) {
          j = -k;
        }
        x.a0(paramView, j);
        paramView.setAlpha(0.0F);
        parama = SwipeDismissBehavior.this.b;
        if (parama != null) {
          parama.a(paramView);
        }
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView);
    
    public abstract void b(int paramInt);
  }
  
  private class d
    implements Runnable
  {
    private final View a;
    private final boolean b;
    
    d(View paramView, boolean paramBoolean)
    {
      this.a = paramView;
      this.b = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = SwipeDismissBehavior.this.a;
      if ((localObject != null) && (((c)localObject).n(true)))
      {
        x.i0(this.a, this);
        return;
      }
      if (this.b)
      {
        localObject = SwipeDismissBehavior.this.b;
        if (localObject != null) {
          ((SwipeDismissBehavior.c)localObject).a(this.a);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */