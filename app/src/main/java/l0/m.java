package l0;

import java.util.ArrayList;
import java.util.List;
import k0.e;

class m
{
  public static int h;
  public int a = 0;
  public boolean b = false;
  p c = null;
  p d = null;
  ArrayList<p> e = new ArrayList();
  int f;
  int g;
  
  public m(p paramp, int paramInt)
  {
    int i = h;
    this.f = i;
    h = i + 1;
    this.c = paramp;
    this.d = paramp;
    this.g = paramInt;
  }
  
  private long c(f paramf, long paramLong)
  {
    p localp = paramf.d;
    if ((localp instanceof k)) {
      return paramLong;
    }
    int j = paramf.k.size();
    int i = 0;
    for (long l1 = paramLong; i < j; l1 = l2)
    {
      Object localObject = (d)paramf.k.get(i);
      l2 = l1;
      if ((localObject instanceof f))
      {
        localObject = (f)localObject;
        if (((f)localObject).d == localp) {
          l2 = l1;
        } else {
          l2 = Math.min(l1, c((f)localObject, ((f)localObject).f + paramLong));
        }
      }
      i += 1;
    }
    long l2 = l1;
    if (paramf == localp.i)
    {
      l2 = localp.j();
      paramf = localp.h;
      paramLong -= l2;
      l2 = Math.min(Math.min(l1, c(paramf, paramLong)), paramLong - localp.h.f);
    }
    return l2;
  }
  
  private long d(f paramf, long paramLong)
  {
    p localp = paramf.d;
    if ((localp instanceof k)) {
      return paramLong;
    }
    int j = paramf.k.size();
    int i = 0;
    for (long l1 = paramLong; i < j; l1 = l2)
    {
      Object localObject = (d)paramf.k.get(i);
      l2 = l1;
      if ((localObject instanceof f))
      {
        localObject = (f)localObject;
        if (((f)localObject).d == localp) {
          l2 = l1;
        } else {
          l2 = Math.max(l1, d((f)localObject, ((f)localObject).f + paramLong));
        }
      }
      i += 1;
    }
    long l2 = l1;
    if (paramf == localp.h)
    {
      l2 = localp.j();
      paramf = localp.i;
      paramLong += l2;
      l2 = Math.max(Math.max(l1, d(paramf, paramLong)), paramLong - localp.i.f);
    }
    return l2;
  }
  
  public void a(p paramp)
  {
    this.e.add(paramp);
    this.d = paramp;
  }
  
  public long b(k0.f paramf, int paramInt)
  {
    p localp = this.c;
    boolean bool1 = localp instanceof c;
    long l3 = 0L;
    if (bool1)
    {
      if (((c)localp).f != paramInt) {
        return 0L;
      }
    }
    else if (paramInt == 0)
    {
      if (!(localp instanceof l)) {
        return 0L;
      }
    }
    else if (!(localp instanceof n)) {
      return 0L;
    }
    if (paramInt == 0) {
      localObject = paramf.e;
    } else {
      localObject = paramf.f;
    }
    Object localObject = ((p)localObject).h;
    if (paramInt == 0) {
      paramf = paramf.e;
    } else {
      paramf = paramf.f;
    }
    paramf = paramf.i;
    bool1 = localp.h.l.contains(localObject);
    boolean bool2 = this.c.i.l.contains(paramf);
    long l5 = this.c.j();
    long l1;
    long l2;
    if ((bool1) && (bool2))
    {
      l1 = d(this.c.h, 0L);
      long l4 = c(this.c.i, 0L);
      l2 = l1 - l5;
      paramf = this.c;
      int i = paramf.i.f;
      l1 = l2;
      if (l2 >= -i) {
        l1 = l2 + i;
      }
      l2 = -l4;
      i = paramf.h.f;
      l4 = l2 - l5 - i;
      l2 = l4;
      if (l4 >= i) {
        l2 = l4 - i;
      }
      float f1 = paramf.b.s(paramInt);
      if (f1 > 0.0F) {
        l3 = ((float)l2 / f1 + (float)l1 / (1.0F - f1));
      }
      float f2 = (float)l3;
      l1 = (f2 * f1 + 0.5F);
      l2 = (f2 * (1.0F - f1) + 0.5F);
      paramf = this.c;
      l1 = paramf.h.f + (l1 + l5 + l2);
    }
    else
    {
      if (bool1)
      {
        paramf = this.c.h;
        l2 = d(paramf, paramf.f);
        l1 = this.c.h.f + l5;
      }
      for (;;)
      {
        return Math.max(l2, l1);
        if (!bool2) {
          break;
        }
        paramf = this.c.i;
        l2 = c(paramf, paramf.f);
        l1 = -this.c.i.f + l5;
        l2 = -l2;
      }
      paramf = this.c;
      l1 = paramf.h.f + paramf.j();
      paramf = this.c;
    }
    return l1 - paramf.i.f;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.m
 * JD-Core Version:    0.7.0.1
 */