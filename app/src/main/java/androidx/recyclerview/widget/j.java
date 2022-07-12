package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class j
  extends RecyclerView.y
{
  protected final LinearInterpolator i = new LinearInterpolator();
  protected final DecelerateInterpolator j = new DecelerateInterpolator();
  protected PointF k;
  private final DisplayMetrics l;
  private boolean m = false;
  private float n;
  protected int o = 0;
  protected int p = 0;
  
  public j(Context paramContext)
  {
    this.l = paramContext.getResources().getDisplayMetrics();
  }
  
  private float A()
  {
    if (!this.m)
    {
      this.n = v(this.l);
      this.m = true;
    }
    return this.n;
  }
  
  private int y(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 - paramInt2;
    if (paramInt1 * paramInt2 <= 0) {
      return 0;
    }
    return paramInt2;
  }
  
  protected int B()
  {
    PointF localPointF = this.k;
    if (localPointF != null)
    {
      float f = localPointF.y;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    return 0;
  }
  
  protected void C(RecyclerView.y.a parama)
  {
    PointF localPointF = a(f());
    if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F)))
    {
      i(localPointF);
      this.k = localPointF;
      this.o = ((int)(localPointF.x * 10000.0F));
      this.p = ((int)(localPointF.y * 10000.0F));
      int i1 = x(10000);
      parama.d((int)(this.o * 1.2F), (int)(this.p * 1.2F), (int)(i1 * 1.2F), this.i);
      return;
    }
    parama.b(f());
    r();
  }
  
  protected void l(int paramInt1, int paramInt2, RecyclerView.z paramz, RecyclerView.y.a parama)
  {
    if (c() == 0)
    {
      r();
      return;
    }
    this.o = y(this.o, paramInt1);
    paramInt1 = y(this.p, paramInt2);
    this.p = paramInt1;
    if ((this.o == 0) && (paramInt1 == 0)) {
      C(parama);
    }
  }
  
  protected void m() {}
  
  protected void n()
  {
    this.p = 0;
    this.o = 0;
    this.k = null;
  }
  
  protected void o(View paramView, RecyclerView.z paramz, RecyclerView.y.a parama)
  {
    int i1 = t(paramView, z());
    int i2 = u(paramView, B());
    int i3 = w((int)Math.sqrt(i1 * i1 + i2 * i2));
    if (i3 > 0) {
      parama.d(-i1, -i2, i3, this.j);
    }
  }
  
  public int s(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 == 1) {
          return paramInt4 - paramInt2;
        }
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      }
      paramInt1 = paramInt3 - paramInt1;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      paramInt1 = paramInt4 - paramInt2;
      if (paramInt1 < 0) {
        return paramInt1;
      }
      return 0;
    }
    return paramInt3 - paramInt1;
  }
  
  public int t(View paramView, int paramInt)
  {
    RecyclerView.p localp = e();
    if ((localp != null) && (localp.k()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return s(localp.Q(paramView) - localLayoutParams.leftMargin, localp.T(paramView) + localLayoutParams.rightMargin, localp.e0(), localp.o0() - localp.f0(), paramInt);
    }
    return 0;
  }
  
  public int u(View paramView, int paramInt)
  {
    RecyclerView.p localp = e();
    if ((localp != null) && (localp.l()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return s(localp.U(paramView) - localLayoutParams.topMargin, localp.O(paramView) + localLayoutParams.bottomMargin, localp.g0(), localp.W() - localp.d0(), paramInt);
    }
    return 0;
  }
  
  protected float v(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int w(int paramInt)
  {
    return (int)Math.ceil(x(paramInt) / 0.3356D);
  }
  
  protected int x(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * A());
  }
  
  protected int z()
  {
    PointF localPointF = this.k;
    if (localPointF != null)
    {
      float f = localPointF.x;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.j
 * JD-Core Version:    0.7.0.1
 */