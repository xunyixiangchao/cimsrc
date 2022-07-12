package l0;

import java.util.ArrayList;
import k0.a;
import k0.e;
import k0.e.b;
import k0.h;
import k0.m;
import k0.n;

public class b
{
  private final ArrayList<e> a = new ArrayList();
  private a b = new a();
  private k0.f c;
  
  public b(k0.f paramf)
  {
    this.c = paramf;
  }
  
  private boolean a(b paramb, e parame, int paramInt)
  {
    this.b.a = parame.C();
    this.b.b = parame.V();
    this.b.c = parame.Y();
    this.b.d = parame.z();
    a locala = this.b;
    locala.i = false;
    locala.j = paramInt;
    e.b localb1 = locala.a;
    e.b localb2 = e.b.c;
    int i;
    if (localb1 == localb2) {
      i = 1;
    } else {
      i = 0;
    }
    if (locala.b == localb2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (parame.f0 > 0.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt != 0) && (parame.f0 > 0.0F)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (parame.y[0] == 4)) {
      locala.a = e.b.a;
    }
    if ((paramInt != 0) && (parame.y[1] == 4)) {
      locala.b = e.b.a;
    }
    paramb.b(parame, locala);
    parame.o1(this.b.e);
    parame.P0(this.b.f);
    parame.O0(this.b.h);
    parame.E0(this.b.g);
    paramb = this.b;
    paramb.j = a.k;
    return paramb.i;
  }
  
  private void b(k0.f paramf)
  {
    int n = paramf.V0.size();
    boolean bool = paramf.X1(64);
    b localb = paramf.M1();
    int k = 0;
    while (k < n)
    {
      e locale = (e)paramf.V0.get(k);
      if ((!(locale instanceof h)) && (!(locale instanceof a)) && (!locale.n0()))
      {
        if (bool)
        {
          localObject1 = locale.e;
          if (localObject1 != null)
          {
            localObject2 = locale.f;
            if ((localObject2 != null) && (((p)localObject1).e.j) && (((p)localObject2).e.j)) {
              break label356;
            }
          }
        }
        Object localObject1 = locale.w(0);
        int m = 1;
        Object localObject2 = locale.w(1);
        e.b localb1 = e.b.c;
        int i;
        if ((localObject1 == localb1) && (locale.w != 1) && (localObject2 == localb1) && (locale.x != 1)) {
          i = 1;
        } else {
          i = 0;
        }
        int j = i;
        if (i == 0)
        {
          j = i;
          if (paramf.X1(1))
          {
            j = i;
            if (!(locale instanceof m))
            {
              j = i;
              if (localObject1 == localb1)
              {
                j = i;
                if (locale.w == 0)
                {
                  j = i;
                  if (localObject2 != localb1)
                  {
                    j = i;
                    if (!locale.k0()) {
                      j = 1;
                    }
                  }
                }
              }
              i = j;
              if (localObject2 == localb1)
              {
                i = j;
                if (locale.x == 0)
                {
                  i = j;
                  if (localObject1 != localb1)
                  {
                    i = j;
                    if (!locale.k0()) {
                      i = 1;
                    }
                  }
                }
              }
              if (localObject1 != localb1)
              {
                j = i;
                if (localObject2 != localb1) {}
              }
              else
              {
                j = i;
                if (locale.f0 > 0.0F) {
                  j = m;
                }
              }
            }
          }
        }
        if (j == 0) {
          a(localb, locale, a.k);
        }
      }
      label356:
      k += 1;
    }
    localb.a();
  }
  
  private void c(k0.f paramf, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramf.K();
    int j = paramf.J();
    paramf.e1(0);
    paramf.d1(0);
    paramf.o1(paramInt2);
    paramf.P0(paramInt3);
    paramf.e1(i);
    paramf.d1(j);
    this.c.b2(paramInt1);
    this.c.w1();
  }
  
  public long d(k0.f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void e(k0.f paramf)
  {
    this.a.clear();
    int j = paramf.V0.size();
    int i = 0;
    while (i < j)
    {
      e locale = (e)paramf.V0.get(i);
      e.b localb1 = locale.C();
      e.b localb2 = e.b.c;
      if ((localb1 == localb2) || (locale.V() == localb2)) {
        this.a.add(locale);
      }
      i += 1;
    }
    paramf.Q1();
  }
  
  public static class a
  {
    public static int k = 0;
    public static int l = 1;
    public static int m = 2;
    public e.b a;
    public e.b b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public int j;
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b(e parame, b.a parama);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.b
 * JD-Core Version:    0.7.0.1
 */