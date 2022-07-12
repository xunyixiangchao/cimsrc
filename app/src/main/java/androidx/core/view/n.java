package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class n
{
  private ViewParent a;
  private ViewParent b;
  private final View c;
  private boolean d;
  private int[] e;
  
  public n(View paramView)
  {
    this.c = paramView;
  }
  
  private boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    if (l())
    {
      ViewParent localViewParent = h(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
      {
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1[0] = 0;
          paramArrayOfInt1[1] = 0;
          return false;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt1 != null)
        {
          this.c.getLocationInWindow(paramArrayOfInt1);
          i = paramArrayOfInt1[0];
          j = paramArrayOfInt1[1];
        }
        else
        {
          i = 0;
          j = i;
        }
        if (paramArrayOfInt2 == null)
        {
          paramArrayOfInt2 = i();
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        b0.d(localViewParent, this.c, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt2);
        if (paramArrayOfInt1 != null)
        {
          this.c.getLocationInWindow(paramArrayOfInt1);
          paramArrayOfInt1[0] -= i;
          paramArrayOfInt1[1] -= j;
        }
        return true;
      }
    }
    return false;
  }
  
  private ViewParent h(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return this.b;
    }
    return this.a;
  }
  
  private int[] i()
  {
    if (this.e == null) {
      this.e = new int[2];
    }
    return this.e;
  }
  
  private void n(int paramInt, ViewParent paramViewParent)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.b = paramViewParent;
      return;
    }
    this.a = paramViewParent;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (l())
    {
      ViewParent localViewParent = h(0);
      if (localViewParent != null) {
        return b0.a(localViewParent, this.c, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return false;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    if (l())
    {
      ViewParent localViewParent = h(0);
      if (localViewParent != null) {
        return b0.b(localViewParent, this.c, paramFloat1, paramFloat2);
      }
    }
    return false;
  }
  
  public boolean c(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return d(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean d(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    boolean bool3 = l();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      ViewParent localViewParent = h(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool1 = bool2;
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
          return false;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt2 != null)
        {
          this.c.getLocationInWindow(paramArrayOfInt2);
          i = paramArrayOfInt2[0];
          j = paramArrayOfInt2[1];
        }
        else
        {
          i = 0;
          j = i;
        }
        int[] arrayOfInt = paramArrayOfInt1;
        if (paramArrayOfInt1 == null) {
          arrayOfInt = i();
        }
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        b0.c(localViewParent, this.c, paramInt1, paramInt2, arrayOfInt, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.c.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= i;
          paramArrayOfInt2[1] -= j;
        }
        if (arrayOfInt[0] == 0)
        {
          bool1 = bool2;
          if (arrayOfInt[1] == 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    g(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return g(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0, null);
  }
  
  public boolean j()
  {
    return k(0);
  }
  
  public boolean k(int paramInt)
  {
    return h(paramInt) != null;
  }
  
  public boolean l()
  {
    return this.d;
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.d) {
      x.P0(this.c);
    }
    this.d = paramBoolean;
  }
  
  public boolean o(int paramInt)
  {
    return p(paramInt, 0);
  }
  
  public boolean p(int paramInt1, int paramInt2)
  {
    if (k(paramInt2)) {
      return true;
    }
    if (l())
    {
      ViewParent localViewParent = this.c.getParent();
      View localView = this.c;
      while (localViewParent != null)
      {
        if (b0.f(localViewParent, localView, this.c, paramInt1, paramInt2))
        {
          n(paramInt2, localViewParent);
          b0.e(localViewParent, localView, this.c, paramInt1, paramInt2);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public void q()
  {
    r(0);
  }
  
  public void r(int paramInt)
  {
    ViewParent localViewParent = h(paramInt);
    if (localViewParent != null)
    {
      b0.g(localViewParent, this.c, paramInt);
      n(paramInt, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.n
 * JD-Core Version:    0.7.0.1
 */