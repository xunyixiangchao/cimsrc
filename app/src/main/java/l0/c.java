package l0;

import java.util.ArrayList;
import java.util.Iterator;
import k0.e;
import k0.e.b;

public class c
  extends p
{
  ArrayList<p> k = new ArrayList();
  private int l;
  
  public c(e parame, int paramInt)
  {
    super(parame);
    this.f = paramInt;
    q();
  }
  
  private void q()
  {
    Object localObject2;
    for (Object localObject1 = this.b;; localObject1 = localObject2)
    {
      localObject2 = ((e)localObject1).N(this.f);
      if (localObject2 == null) {
        break;
      }
    }
    this.b = ((e)localObject1);
    this.k.add(((e)localObject1).P(this.f));
    for (localObject1 = ((e)localObject1).L(this.f); localObject1 != null; localObject1 = ((e)localObject1).L(this.f)) {
      this.k.add(((e)localObject1).P(this.f));
    }
    localObject1 = this.k.iterator();
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      i = this.f;
      if (i == 0) {
        ((p)localObject2).b.c = this;
      } else if (i == 1) {
        ((p)localObject2).b.d = this;
      }
    }
    if ((this.f == 0) && (((k0.f)this.b.M()).T1())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (this.k.size() > 1))
    {
      localObject1 = this.k;
      this.b = ((p)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).b;
    }
    if (this.f == 0) {
      i = this.b.B();
    } else {
      i = this.b.U();
    }
    this.l = i;
  }
  
  private e r()
  {
    int i = 0;
    while (i < this.k.size())
    {
      p localp = (p)this.k.get(i);
      if (localp.b.X() != 8) {
        return localp.b;
      }
      i += 1;
    }
    return null;
  }
  
  private e s()
  {
    int i = this.k.size() - 1;
    while (i >= 0)
    {
      p localp = (p)this.k.get(i);
      if (localp.b.X() != 8) {
        return localp.b;
      }
      i -= 1;
    }
    return null;
  }
  
  public void a(d paramd)
  {
    if (this.h.j)
    {
      if (!this.i.j) {
        return;
      }
      paramd = this.b.M();
      boolean bool;
      if ((paramd instanceof k0.f)) {
        bool = ((k0.f)paramd).T1();
      } else {
        bool = false;
      }
      int i12 = this.i.g - this.h.g;
      int i11 = this.k.size();
      int i = 0;
      for (;;)
      {
        j = -1;
        if (i >= i11) {
          break;
        }
        i6 = i;
        if (((p)this.k.get(i)).b.X() != 8) {
          break label129;
        }
        i += 1;
      }
      int i6 = -1;
      label129:
      int i10 = i11 - 1;
      i = i10;
      for (;;)
      {
        i7 = j;
        if (i < 0) {
          break label184;
        }
        if (((p)this.k.get(i)).b.X() != 8) {
          break;
        }
        i -= 1;
      }
      int i7 = i;
      label184:
      int i1 = 0;
      int i2;
      int i3;
      int i4;
      Object localObject;
      label422:
      label430:
      float f2;
      while (i1 < 2)
      {
        i2 = 0;
        n = 0;
        i = 0;
        j = 0;
        f1 = 0.0F;
        while (i2 < i11)
        {
          paramd = (p)this.k.get(i2);
          if (paramd.b.X() == 8)
          {
            i3 = i;
          }
          else
          {
            i4 = j + 1;
            j = n;
            if (i2 > 0)
            {
              j = n;
              if (i2 >= i6) {
                j = n + paramd.h.f;
              }
            }
            localObject = paramd.e;
            n = ((f)localObject).g;
            if (paramd.d != e.b.c) {
              m = 1;
            } else {
              m = 0;
            }
            if (m != 0)
            {
              i3 = this.f;
              if ((i3 == 0) && (!paramd.b.e.e.j)) {
                return;
              }
              if ((i3 == 1) && (!paramd.b.f.e.j)) {
                return;
              }
            }
            else
            {
              if ((paramd.a == 1) && (i1 == 0))
              {
                m = ((g)localObject).m;
                i += 1;
              }
              else
              {
                if (!((f)localObject).j) {
                  break label422;
                }
                m = n;
              }
              i3 = 1;
              break label430;
            }
            i3 = m;
            m = n;
            if (i3 == 0)
            {
              n = i + 1;
              float f3 = paramd.b.N0[this.f];
              m = j;
              i = n;
              f2 = f1;
              if (f3 >= 0.0F)
              {
                f2 = f1 + f3;
                m = j;
                i = n;
              }
            }
            else
            {
              m = j + m;
              f2 = f1;
            }
            n = m;
            i3 = i;
            j = i4;
            f1 = f2;
            if (i2 < i10)
            {
              n = m;
              i3 = i;
              j = i4;
              f1 = f2;
              if (i2 < i7)
              {
                n = m + -paramd.i.f;
                f1 = f2;
                j = i4;
                i3 = i;
              }
            }
          }
          i2 += 1;
          i = i3;
        }
        if ((n >= i12) && (i != 0))
        {
          i1 += 1;
        }
        else
        {
          m = j;
          j = i;
          break label621;
        }
      }
      int m = 0;
      int n = 0;
      int j = 0;
      float f1 = 0.0F;
      label621:
      i1 = this.h.g;
      if (bool) {
        i1 = this.i.g;
      }
      i = i1;
      if (n > i12)
      {
        i = (int)((n - i12) / 2.0F + 0.5F);
        if (bool) {
          i = i1 + i;
        } else {
          i = i1 - i;
        }
      }
      if (j > 0)
      {
        f2 = i12 - n;
        i3 = (int)(f2 / j + 0.5F);
        int i8 = 0;
        i2 = 0;
        i1 = n;
        n = i2;
        i2 = i;
        while (i8 < i11)
        {
          paramd = (p)this.k.get(i8);
          if ((paramd.b.X() != 8) && (paramd.d == e.b.c))
          {
            localObject = paramd.e;
            if (!((f)localObject).j)
            {
              if (f1 > 0.0F) {
                i = (int)(paramd.b.N0[this.f] * f2 / f1 + 0.5F);
              } else {
                i = i3;
              }
              e locale;
              if (this.f == 0)
              {
                locale = paramd.b;
                i5 = locale.A;
                i4 = locale.z;
              }
              else
              {
                locale = paramd.b;
                i5 = locale.D;
                i4 = locale.C;
              }
              if (paramd.a == 1) {
                i9 = Math.min(i, ((g)localObject).m);
              } else {
                i9 = i;
              }
              int i9 = Math.max(i4, i9);
              i4 = i9;
              if (i5 > 0) {
                i4 = Math.min(i5, i9);
              }
              i9 = i;
              int i5 = n;
              if (i4 != i)
              {
                i5 = n + 1;
                i9 = i4;
              }
              paramd.e.d(i9);
              n = i5;
            }
          }
          i8 += 1;
        }
        if (n > 0)
        {
          i3 = j - n;
          j = 0;
          i = 0;
          while (j < i11)
          {
            paramd = (p)this.k.get(j);
            if (paramd.b.X() != 8)
            {
              i1 = i;
              if (j > 0)
              {
                i1 = i;
                if (j >= i6) {
                  i1 = i + paramd.h.f;
                }
              }
              i1 += paramd.e.g;
              i = i1;
              if (j < i10)
              {
                i = i1;
                if (j < i7) {
                  i = i1 + -paramd.i.f;
                }
              }
            }
            j += 1;
          }
          j = i3;
        }
        else
        {
          i = i1;
        }
        if ((this.l == 2) && (n == 0))
        {
          this.l = 0;
          n = i;
          i1 = j;
          i = i2;
        }
        else
        {
          n = i;
          i1 = j;
          i = i2;
        }
      }
      else
      {
        i1 = j;
      }
      if (n > i12) {
        this.l = 2;
      }
      if ((m > 0) && (i1 == 0) && (i6 == i7)) {
        this.l = 2;
      }
      j = this.l;
      if (j == 1)
      {
        if (m > 1) {
          j = (i12 - n) / (m - 1);
        } else if (m == 1) {
          j = (i12 - n) / 2;
        } else {
          j = 0;
        }
        n = j;
        if (i1 > 0) {
          n = 0;
        }
        j = 0;
        for (m = i; j < i11; m = i)
        {
          if (bool) {
            i = i11 - (j + 1);
          } else {
            i = j;
          }
          localObject = (p)this.k.get(i);
          if (((p)localObject).b.X() == 8)
          {
            ((p)localObject).h.d(m);
            ((p)localObject).i.d(m);
            i = m;
          }
          else
          {
            i = m;
            if (j > 0) {
              if (bool) {
                i = m - n;
              } else {
                i = m + n;
              }
            }
            m = i;
            if (j > 0)
            {
              m = i;
              if (j >= i6)
              {
                m = ((p)localObject).h.f;
                if (bool) {
                  m = i - m;
                } else {
                  m = i + m;
                }
              }
            }
            if (bool) {
              paramd = ((p)localObject).i;
            } else {
              paramd = ((p)localObject).h;
            }
            paramd.d(m);
            paramd = ((p)localObject).e;
            i1 = paramd.g;
            i = i1;
            if (((p)localObject).d == e.b.c)
            {
              i = i1;
              if (((p)localObject).a == 1) {
                i = paramd.m;
              }
            }
            if (bool) {
              m -= i;
            } else {
              m += i;
            }
            if (bool) {
              paramd = ((p)localObject).h;
            } else {
              paramd = ((p)localObject).i;
            }
            paramd.d(m);
            ((p)localObject).g = true;
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7)
              {
                i = -((p)localObject).i.f;
                if (bool) {
                  i = m - i;
                } else {
                  i = m + i;
                }
              }
            }
          }
          j += 1;
        }
      }
      if (j == 0)
      {
        n = (i12 - n) / (m + 1);
        if (i1 > 0) {
          n = 0;
        }
        j = 0;
        while (j < i11)
        {
          if (bool) {
            m = i11 - (j + 1);
          } else {
            m = j;
          }
          localObject = (p)this.k.get(m);
          if (((p)localObject).b.X() == 8)
          {
            ((p)localObject).h.d(i);
            ((p)localObject).i.d(i);
          }
          else
          {
            if (bool) {
              m = i - n;
            } else {
              m = i + n;
            }
            i = m;
            if (j > 0)
            {
              i = m;
              if (j >= i6)
              {
                i = ((p)localObject).h.f;
                if (bool) {
                  i = m - i;
                } else {
                  i = m + i;
                }
              }
            }
            if (bool) {
              paramd = ((p)localObject).i;
            } else {
              paramd = ((p)localObject).h;
            }
            paramd.d(i);
            paramd = ((p)localObject).e;
            i1 = paramd.g;
            m = i1;
            if (((p)localObject).d == e.b.c)
            {
              m = i1;
              if (((p)localObject).a == 1) {
                m = Math.min(i1, paramd.m);
              }
            }
            if (bool) {
              m = i - m;
            } else {
              m = i + m;
            }
            if (bool) {
              paramd = ((p)localObject).h;
            } else {
              paramd = ((p)localObject).i;
            }
            paramd.d(m);
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7)
              {
                i = -((p)localObject).i.f;
                if (bool) {
                  i = m - i;
                } else {
                  i = m + i;
                }
              }
            }
          }
          j += 1;
        }
      }
      if (j == 2)
      {
        if (this.f == 0) {
          f1 = this.b.A();
        } else {
          f1 = this.b.T();
        }
        f2 = f1;
        if (bool) {
          f2 = 1.0F - f1;
        }
        j = (int)((i12 - n) * f2 + 0.5F);
        if ((j < 0) || (i1 > 0)) {
          j = 0;
        }
        if (bool) {
          i -= j;
        } else {
          i += j;
        }
        j = 0;
        while (j < i11)
        {
          if (bool) {
            m = i11 - (j + 1);
          } else {
            m = j;
          }
          localObject = (p)this.k.get(m);
          if (((p)localObject).b.X() == 8)
          {
            ((p)localObject).h.d(i);
            ((p)localObject).i.d(i);
          }
          else
          {
            m = i;
            if (j > 0)
            {
              m = i;
              if (j >= i6)
              {
                m = ((p)localObject).h.f;
                if (bool) {
                  m = i - m;
                } else {
                  m = i + m;
                }
              }
            }
            if (bool) {
              paramd = ((p)localObject).i;
            } else {
              paramd = ((p)localObject).h;
            }
            paramd.d(m);
            paramd = ((p)localObject).e;
            i = paramd.g;
            if ((((p)localObject).d == e.b.c) && (((p)localObject).a == 1)) {
              i = paramd.m;
            }
            if (bool) {
              m -= i;
            } else {
              m += i;
            }
            if (bool) {
              paramd = ((p)localObject).h;
            } else {
              paramd = ((p)localObject).i;
            }
            paramd.d(m);
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7)
              {
                i = -((p)localObject).i.f;
                if (bool) {
                  i = m - i;
                } else {
                  i = m + i;
                }
              }
            }
          }
          j += 1;
        }
      }
    }
  }
  
  void d()
  {
    Object localObject1 = this.k.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((p)((Iterator)localObject1).next()).d();
    }
    int i = this.k.size();
    if (i < 1) {
      return;
    }
    Object localObject2 = ((p)this.k.get(0)).b;
    localObject1 = ((p)this.k.get(i - 1)).b;
    Object localObject3;
    if (this.f == 0)
    {
      localObject3 = ((e)localObject2).Q;
      localObject2 = ((e)localObject1).S;
      localObject1 = i((k0.d)localObject3, 0);
      i = ((k0.d)localObject3).f();
      localObject3 = r();
      if (localObject3 != null) {
        i = ((e)localObject3).Q.f();
      }
      if (localObject1 != null) {
        b(this.h, (f)localObject1, i);
      }
      localObject1 = i((k0.d)localObject2, 0);
      i = ((k0.d)localObject2).f();
      localObject2 = s();
      if (localObject2 != null) {
        i = ((e)localObject2).S.f();
      }
      if (localObject1 == null) {
        break label283;
      }
    }
    else
    {
      localObject3 = ((e)localObject2).R;
      localObject2 = ((e)localObject1).T;
      localObject1 = i((k0.d)localObject3, 1);
      i = ((k0.d)localObject3).f();
      localObject3 = r();
      if (localObject3 != null) {
        i = ((e)localObject3).R.f();
      }
      if (localObject1 != null) {
        b(this.h, (f)localObject1, i);
      }
      localObject1 = i((k0.d)localObject2, 1);
      i = ((k0.d)localObject2).f();
      localObject2 = s();
      if (localObject2 != null) {
        i = ((e)localObject2).T.f();
      }
      if (localObject1 == null) {
        break label283;
      }
    }
    b(this.i, (f)localObject1, -i);
    label283:
    this.h.a = this;
    this.i.a = this;
  }
  
  public void e()
  {
    int i = 0;
    while (i < this.k.size())
    {
      ((p)this.k.get(i)).e();
      i += 1;
    }
  }
  
  void f()
  {
    this.c = null;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).f();
    }
  }
  
  public long j()
  {
    int j = this.k.size();
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      p localp = (p)this.k.get(i);
      l1 = l1 + localp.h.f + localp.j() + localp.i.f;
      i += 1;
    }
    return l1;
  }
  
  boolean m()
  {
    int j = this.k.size();
    int i = 0;
    while (i < j)
    {
      if (!((p)this.k.get(i)).m()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ChainRun ");
    if (this.f == 0) {
      localObject = "horizontal : ";
    } else {
      localObject = "vertical : ";
    }
    localStringBuilder.append((String)localObject);
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localp = (p)((Iterator)localObject).next();
      localStringBuilder.append("<");
      localStringBuilder.append(localp);
      localStringBuilder.append("> ");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.c
 * JD-Core Version:    0.7.0.1
 */