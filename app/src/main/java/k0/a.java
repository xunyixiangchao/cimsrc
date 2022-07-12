package k0;

import h0.i;
import java.util.HashMap;

public class a
  extends j
{
  private int X0 = 0;
  private boolean Y0 = true;
  private int Z0 = 0;
  boolean a1 = false;
  
  public int A1()
  {
    return this.Z0;
  }
  
  public int B1()
  {
    int i = this.X0;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3)) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
  
  protected void C1()
  {
    int i = 0;
    while (i < this.W0)
    {
      e locale = this.V0[i];
      if ((this.Y0) || (locale.h()))
      {
        int j = this.X0;
        if ((j != 0) && (j != 1))
        {
          if ((j == 2) || (j == 3)) {
            locale.W0(1, true);
          }
        }
        else {
          locale.W0(0, true);
        }
      }
      i += 1;
    }
  }
  
  public void D1(boolean paramBoolean)
  {
    this.Y0 = paramBoolean;
  }
  
  public void E1(int paramInt)
  {
    this.X0 = paramInt;
  }
  
  public void F1(int paramInt)
  {
    this.Z0 = paramInt;
  }
  
  public void g(h0.d paramd, boolean paramBoolean)
  {
    Object localObject1 = this.Y;
    localObject1[0] = this.Q;
    localObject1[2] = this.R;
    localObject1[1] = this.S;
    localObject1[3] = this.T;
    int i = 0;
    for (;;)
    {
      localObject1 = this.Y;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i].i = paramd.q(localObject1[i]);
      i += 1;
    }
    i = this.X0;
    if ((i >= 0) && (i < 4))
    {
      localObject1 = localObject1[i];
      if (!this.a1) {
        x1();
      }
      if (this.a1)
      {
        this.a1 = false;
        i = this.X0;
        if ((i != 0) && (i != 1))
        {
          if ((i != 2) && (i != 3)) {
            break label214;
          }
          paramd.f(this.R.i, this.i0);
          localObject1 = this.T.i;
          i = this.i0;
        }
        else
        {
          paramd.f(this.Q.i, this.h0);
          localObject1 = this.S.i;
          i = this.h0;
        }
        paramd.f((i)localObject1, i);
        label214:
        return;
      }
      i = 0;
      Object localObject2;
      while (i < this.W0)
      {
        localObject2 = this.V0[i];
        if ((this.Y0) || (((e)localObject2).h()))
        {
          j = this.X0;
          if (((j == 0) || (j == 1)) && (((e)localObject2).C() == e.b.c) && (((e)localObject2).Q.f != null) && (((e)localObject2).S.f != null)) {}
          do
          {
            paramBoolean = true;
            break;
            j = this.X0;
          } while (((j == 2) || (j == 3)) && (((e)localObject2).V() == e.b.c) && (((e)localObject2).R.f != null) && (((e)localObject2).T.f != null));
        }
        i += 1;
      }
      paramBoolean = false;
      if ((!this.Q.l()) && (!this.S.l())) {
        i = 0;
      } else {
        i = 1;
      }
      if ((!this.R.l()) && (!this.T.l())) {
        j = 0;
      } else {
        j = 1;
      }
      int k;
      if (!paramBoolean)
      {
        k = this.X0;
        if (((k == 0) && (i != 0)) || ((k == 2) && (j != 0)) || ((k == 1) && (i != 0)) || ((k == 3) && (j != 0)))
        {
          j = 1;
          break label491;
        }
      }
      int j = 0;
      label491:
      i = 5;
      if (j == 0) {
        i = 4;
      }
      j = 0;
      while (j < this.W0)
      {
        Object localObject3 = this.V0[j];
        if ((this.Y0) || (((e)localObject3).h()))
        {
          localObject2 = paramd.q(localObject3.Y[this.X0]);
          localObject3 = ((e)localObject3).Y;
          int m = this.X0;
          localObject3[m].i = ((i)localObject2);
          if ((localObject3[m].f != null) && (localObject3[m].f.d == this)) {
            k = localObject3[m].g + 0;
          } else {
            k = 0;
          }
          if ((m != 0) && (m != 2)) {
            paramd.g(((d)localObject1).i, (i)localObject2, this.Z0 + k, paramBoolean);
          } else {
            paramd.i(((d)localObject1).i, (i)localObject2, this.Z0 - k, paramBoolean);
          }
          paramd.e(((d)localObject1).i, (i)localObject2, this.Z0 + k, i);
        }
        j += 1;
      }
      i = this.X0;
      if (i == 0)
      {
        paramd.e(this.S.i, this.Q.i, 0, 8);
        paramd.e(this.Q.i, this.c0.S.i, 0, 4);
        localObject2 = this.Q.i;
        localObject1 = this.c0.Q;
      }
      for (;;)
      {
        paramd.e((i)localObject2, ((d)localObject1).i, 0, 0);
        return;
        if (i == 1)
        {
          paramd.e(this.Q.i, this.S.i, 0, 8);
          paramd.e(this.Q.i, this.c0.Q.i, 0, 4);
          localObject2 = this.Q.i;
          localObject1 = this.c0.S;
        }
        else if (i == 2)
        {
          paramd.e(this.T.i, this.R.i, 0, 8);
          paramd.e(this.R.i, this.c0.T.i, 0, 4);
          localObject2 = this.R.i;
          localObject1 = this.c0.R;
        }
        else
        {
          if (i != 3) {
            break;
          }
          paramd.e(this.R.i, this.T.i, 0, 8);
          paramd.e(this.R.i, this.c0.R.i, 0, 4);
          localObject2 = this.R.i;
          localObject1 = this.c0.T;
        }
      }
    }
  }
  
  public boolean h()
  {
    return true;
  }
  
  public void n(e parame, HashMap<e, e> paramHashMap)
  {
    super.n(parame, paramHashMap);
    parame = (a)parame;
    this.X0 = parame.X0;
    this.Y0 = parame.Y0;
    this.Z0 = parame.Z0;
  }
  
  public boolean p0()
  {
    return this.a1;
  }
  
  public boolean q0()
  {
    return this.a1;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Barrier] ");
    ((StringBuilder)localObject1).append(v());
    ((StringBuilder)localObject1).append(" {");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < this.W0)
    {
      e locale = this.V0[i];
      localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(locale.v());
      localObject1 = ((StringBuilder)localObject1).toString();
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}");
    return ((StringBuilder)localObject2).toString();
  }
  
  public boolean x1()
  {
    int n = 0;
    int i = 0;
    int k;
    Object localObject;
    int m;
    for (int j = 1;; j = k)
    {
      k = this.W0;
      if (i >= k) {
        break;
      }
      localObject = this.V0[i];
      if ((!this.Y0) && (!((e)localObject).h()))
      {
        k = j;
      }
      else
      {
        k = this.X0;
        if (((k == 0) || (k == 1)) && (!((e)localObject).p0())) {}
        do
        {
          k = 0;
          break;
          m = this.X0;
          if (m != 2)
          {
            k = j;
            if (m != 3) {
              break;
            }
          }
          k = j;
        } while (!((e)localObject).q0());
      }
      i += 1;
    }
    if ((j != 0) && (k > 0))
    {
      i = 0;
      k = i;
      while (n < this.W0)
      {
        e locale = this.V0[n];
        if ((this.Y0) || (locale.h()))
        {
          m = i;
          j = k;
          if (k == 0)
          {
            j = this.X0;
            if (j == 0) {
              localObject = d.b.b;
            }
            for (;;)
            {
              i = locale.q((d.b)localObject).e();
              break;
              if (j == 1)
              {
                localObject = d.b.d;
              }
              else if (j == 2)
              {
                localObject = d.b.c;
              }
              else
              {
                if (j != 3) {
                  break;
                }
                localObject = d.b.e;
              }
            }
            j = 1;
            m = i;
          }
          int i1 = this.X0;
          if (i1 == 0)
          {
            localObject = d.b.b;
            i = Math.min(m, locale.q((d.b)localObject).e());
            k = j;
          }
          else
          {
            if (i1 == 1) {}
            for (localObject = d.b.d;; localObject = d.b.e)
            {
              i = Math.max(m, locale.q((d.b)localObject).e());
              k = j;
              break label345;
              if (i1 == 2)
              {
                localObject = d.b.c;
                break;
              }
              i = m;
              k = j;
              if (i1 != 3) {
                break label345;
              }
            }
          }
        }
        label345:
        n += 1;
      }
      i += this.Z0;
      j = this.X0;
      if ((j != 0) && (j != 1)) {
        M0(i, i);
      } else {
        J0(i, i);
      }
      this.a1 = true;
      return true;
    }
    return false;
  }
  
  public boolean y1()
  {
    return this.Y0;
  }
  
  public int z1()
  {
    return this.X0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.a
 * JD-Core Version:    0.7.0.1
 */