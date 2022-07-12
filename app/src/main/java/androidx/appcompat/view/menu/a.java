package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class a
  implements j
{
  protected Context a;
  protected Context b;
  protected e c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  private j.a f;
  private int g;
  private int h;
  protected k i;
  private int j;
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    j.a locala = this.f;
    if (locala != null) {
      locala.b(parame, paramBoolean);
    }
  }
  
  protected void c(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.i).addView(paramView, paramInt);
  }
  
  public void d(Context paramContext, e parame)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(paramContext);
    this.c = parame;
  }
  
  public boolean f(m paramm)
  {
    j.a locala = this.f;
    if (locala != null)
    {
      if (paramm == null) {
        paramm = this.c;
      }
      return locala.c(paramm);
    }
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.i;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = this.c;
    int k = 0;
    if (localObject != null)
    {
      ((e)localObject).t();
      ArrayList localArrayList = this.c.G();
      int i1 = localArrayList.size();
      int m = 0;
      int n;
      for (k = m; m < i1; k = n)
      {
        g localg = (g)localArrayList.get(m);
        n = k;
        if (t(k, localg))
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof k.a)) {
            localObject = ((k.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = q(localg, localView1, localViewGroup);
          if (localg != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1) {
            c(localView2, k);
          }
          n = k + 1;
        }
        m += 1;
      }
    }
    while (k < localViewGroup.getChildCount()) {
      if (!o(localViewGroup, k)) {
        k += 1;
      }
    }
  }
  
  public int getId()
  {
    return this.j;
  }
  
  public abstract void h(g paramg, k.a parama);
  
  public boolean k(e parame, g paramg)
  {
    return false;
  }
  
  public boolean l(e parame, g paramg)
  {
    return false;
  }
  
  public void m(j.a parama)
  {
    this.f = parama;
  }
  
  public k.a n(ViewGroup paramViewGroup)
  {
    return (k.a)this.d.inflate(this.h, paramViewGroup, false);
  }
  
  protected boolean o(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public j.a p()
  {
    return this.f;
  }
  
  public View q(g paramg, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof k.a)) {
      paramView = (k.a)paramView;
    } else {
      paramView = n(paramViewGroup);
    }
    h(paramg, paramView);
    return (View)paramView;
  }
  
  public k r(ViewGroup paramViewGroup)
  {
    if (this.i == null)
    {
      paramViewGroup = (k)this.d.inflate(this.g, paramViewGroup, false);
      this.i = paramViewGroup;
      paramViewGroup.b(this.c);
      g(true);
    }
    return this.i;
  }
  
  public void s(int paramInt)
  {
    this.j = paramInt;
  }
  
  public abstract boolean t(int paramInt, g paramg);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.a
 * JD-Core Version:    0.7.0.1
 */