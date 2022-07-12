package h0;

import java.util.ArrayList;

public class b
  implements d.a
{
  i a = null;
  float b = 0.0F;
  boolean c = false;
  ArrayList<i> d = new ArrayList();
  public a e;
  boolean f = false;
  
  public b() {}
  
  public b(c paramc)
  {
    this.e = new a(this, paramc);
  }
  
  private boolean u(i parami, d paramd)
  {
    return parami.m <= 1;
  }
  
  private i w(boolean[] paramArrayOfBoolean, i parami)
  {
    int j = this.e.e();
    Object localObject1 = null;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < j; f1 = f2)
    {
      float f3 = this.e.a(i);
      Object localObject2 = localObject1;
      f2 = f1;
      if (f3 < 0.0F)
      {
        i locali = this.e.i(i);
        if (paramArrayOfBoolean != null)
        {
          localObject2 = localObject1;
          f2 = f1;
          if (paramArrayOfBoolean[locali.c] != 0) {}
        }
        else
        {
          localObject2 = localObject1;
          f2 = f1;
          if (locali != parami)
          {
            i.a locala = locali.j;
            if (locala != i.a.c)
            {
              localObject2 = localObject1;
              f2 = f1;
              if (locala != i.a.d) {}
            }
            else
            {
              localObject2 = localObject1;
              f2 = f1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = locali;
              }
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void A(d paramd, i parami, boolean paramBoolean)
  {
    if (parami != null)
    {
      if (!parami.g) {
        return;
      }
      float f1 = this.e.b(parami);
      this.b += parami.f * f1;
      this.e.f(parami, paramBoolean);
      if (paramBoolean) {
        parami.d(this);
      }
      if ((d.t) && (this.e.e() == 0))
      {
        this.f = true;
        paramd.a = true;
      }
    }
  }
  
  public void B(d paramd, b paramb, boolean paramBoolean)
  {
    float f1 = this.e.h(paramb, paramBoolean);
    this.b += paramb.b * f1;
    if (paramBoolean) {
      paramb.a.d(this);
    }
    if ((d.t) && (this.a != null) && (this.e.e() == 0))
    {
      this.f = true;
      paramd.a = true;
    }
  }
  
  public void C(d paramd, i parami, boolean paramBoolean)
  {
    if (parami != null)
    {
      if (!parami.n) {
        return;
      }
      float f1 = this.e.b(parami);
      this.b += parami.p * f1;
      this.e.f(parami, paramBoolean);
      if (paramBoolean) {
        parami.d(this);
      }
      this.e.g(paramd.n.d[parami.o], f1, paramBoolean);
      if ((d.t) && (this.e.e() == 0))
      {
        this.f = true;
        paramd.a = true;
      }
    }
  }
  
  public void D(d paramd)
  {
    if (paramd.g.length == 0) {
      return;
    }
    int i = 0;
    while (i == 0)
    {
      int k = this.e.e();
      int j = 0;
      i locali;
      while (j < k)
      {
        locali = this.e.i(j);
        if ((locali.d != -1) || (locali.g) || (locali.n)) {
          this.d.add(locali);
        }
        j += 1;
      }
      k = this.d.size();
      if (k > 0)
      {
        j = 0;
        while (j < k)
        {
          locali = (i)this.d.get(j);
          if (locali.g) {
            A(paramd, locali, true);
          } else if (locali.n) {
            C(paramd, locali, true);
          } else {
            B(paramd, paramd.g[locali.d], true);
          }
          j += 1;
        }
        this.d.clear();
      }
      else
      {
        i = 1;
      }
    }
    if ((d.t) && (this.a != null) && (this.e.e() == 0))
    {
      this.f = true;
      paramd.a = true;
    }
  }
  
  public i a(d paramd, boolean[] paramArrayOfBoolean)
  {
    return w(paramArrayOfBoolean, null);
  }
  
  public void b(i parami)
  {
    int i = parami.e;
    float f1 = 1.0F;
    if (i != 1) {
      if (i == 2) {
        f1 = 1000.0F;
      } else if (i == 3) {
        f1 = 1000000.0F;
      } else if (i == 4) {
        f1 = 1.0E+009F;
      } else if (i == 5) {
        f1 = 1.0E+012F;
      }
    }
    this.e.c(parami, f1);
  }
  
  public void c(d.a parama)
  {
    if ((parama instanceof b))
    {
      parama = (b)parama;
      this.a = null;
      this.e.clear();
      int i = 0;
      while (i < parama.e.e())
      {
        i locali = parama.e.i(i);
        float f1 = parama.e.a(i);
        this.e.g(locali, f1, true);
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    this.e.clear();
    this.a = null;
    this.b = 0.0F;
  }
  
  public b d(d paramd, int paramInt)
  {
    this.e.c(paramd.o(paramInt, "ep"), 1.0F);
    this.e.c(paramd.o(paramInt, "em"), -1.0F);
    return this;
  }
  
  b e(i parami, int paramInt)
  {
    this.e.c(parami, paramInt);
    return this;
  }
  
  boolean f(d paramd)
  {
    paramd = g(paramd);
    boolean bool;
    if (paramd == null)
    {
      bool = true;
    }
    else
    {
      x(paramd);
      bool = false;
    }
    if (this.e.e() == 0) {
      this.f = true;
    }
    return bool;
  }
  
  i g(d paramd)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public i getKey()
  {
    return this.a;
  }
  
  b h(i parami1, i parami2, int paramInt1, float paramFloat, i parami3, i parami4, int paramInt2)
  {
    if (parami2 == parami3)
    {
      this.e.c(parami1, 1.0F);
      this.e.c(parami4, 1.0F);
      this.e.c(parami2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      this.e.c(parami1, 1.0F);
      this.e.c(parami2, -1.0F);
      this.e.c(parami3, -1.0F);
      this.e.c(parami4, 1.0F);
      if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
        return this;
      }
      paramInt1 = -paramInt1 + paramInt2;
      paramFloat = paramInt1;
    }
    else
    {
      if (paramFloat > 0.0F) {
        break label163;
      }
      this.e.c(parami1, -1.0F);
      this.e.c(parami2, 1.0F);
    }
    label163:
    float f1;
    for (paramFloat = paramInt1;; paramFloat = -paramInt1 * f1 + paramInt2 * paramFloat)
    {
      this.b = paramFloat;
      return this;
      if (paramFloat >= 1.0F)
      {
        this.e.c(parami4, -1.0F);
        this.e.c(parami3, 1.0F);
        paramInt1 = -paramInt2;
        break;
      }
      a locala = this.e;
      f1 = 1.0F - paramFloat;
      locala.c(parami1, f1 * 1.0F);
      this.e.c(parami2, f1 * -1.0F);
      this.e.c(parami3, -1.0F * paramFloat);
      this.e.c(parami4, 1.0F * paramFloat);
      if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
        return this;
      }
    }
    return this;
  }
  
  b i(i parami, int paramInt)
  {
    this.a = parami;
    float f1 = paramInt;
    parami.f = f1;
    this.b = f1;
    this.f = true;
    return this;
  }
  
  public boolean isEmpty()
  {
    return (this.a == null) && (this.b == 0.0F) && (this.e.e() == 0);
  }
  
  b j(i parami1, i parami2, float paramFloat)
  {
    this.e.c(parami1, -1.0F);
    this.e.c(parami2, paramFloat);
    return this;
  }
  
  public b k(i parami1, i parami2, i parami3, i parami4, float paramFloat)
  {
    this.e.c(parami1, -1.0F);
    this.e.c(parami2, 1.0F);
    this.e.c(parami3, paramFloat);
    this.e.c(parami4, -paramFloat);
    return this;
  }
  
  public b l(float paramFloat1, float paramFloat2, float paramFloat3, i parami1, i parami2, i parami3, i parami4)
  {
    this.b = 0.0F;
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      if (paramFloat1 == 0.0F)
      {
        this.e.c(parami1, 1.0F);
        this.e.c(parami2, -1.0F);
        return this;
      }
      if (paramFloat3 == 0.0F)
      {
        this.e.c(parami3, 1.0F);
        this.e.c(parami4, -1.0F);
        return this;
      }
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      this.e.c(parami1, 1.0F);
      this.e.c(parami2, -1.0F);
      this.e.c(parami4, paramFloat1);
      this.e.c(parami3, -paramFloat1);
      return this;
    }
    this.e.c(parami1, 1.0F);
    this.e.c(parami2, -1.0F);
    this.e.c(parami4, 1.0F);
    this.e.c(parami3, -1.0F);
    return this;
  }
  
  public b m(i parami, int paramInt)
  {
    a locala;
    float f1;
    if (paramInt < 0)
    {
      this.b = (paramInt * -1);
      locala = this.e;
      f1 = 1.0F;
    }
    else
    {
      this.b = paramInt;
      locala = this.e;
      f1 = -1.0F;
    }
    locala.c(parami, f1);
    return this;
  }
  
  public b n(i parami1, i parami2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.e.c(parami1, -1.0F);
      this.e.c(parami2, 1.0F);
      return this;
    }
    this.e.c(parami1, 1.0F);
    this.e.c(parami2, -1.0F);
    return this;
  }
  
  public b o(i parami1, i parami2, i parami3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.e.c(parami1, -1.0F);
      this.e.c(parami2, 1.0F);
      this.e.c(parami3, 1.0F);
      return this;
    }
    this.e.c(parami1, 1.0F);
    this.e.c(parami2, -1.0F);
    this.e.c(parami3, -1.0F);
    return this;
  }
  
  public b p(i parami1, i parami2, i parami3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.e.c(parami1, -1.0F);
      this.e.c(parami2, 1.0F);
      this.e.c(parami3, -1.0F);
      return this;
    }
    this.e.c(parami1, 1.0F);
    this.e.c(parami2, -1.0F);
    this.e.c(parami3, 1.0F);
    return this;
  }
  
  public b q(i parami1, i parami2, i parami3, i parami4, float paramFloat)
  {
    this.e.c(parami3, 0.5F);
    this.e.c(parami4, 0.5F);
    this.e.c(parami1, -0.5F);
    this.e.c(parami2, -0.5F);
    this.b = (-paramFloat);
    return this;
  }
  
  void r()
  {
    float f1 = this.b;
    if (f1 < 0.0F)
    {
      this.b = (f1 * -1.0F);
      this.e.k();
    }
  }
  
  boolean s()
  {
    i locali = this.a;
    return (locali != null) && ((locali.j == i.a.a) || (this.b >= 0.0F));
  }
  
  boolean t(i parami)
  {
    return this.e.d(parami);
  }
  
  public String toString()
  {
    return z();
  }
  
  public i v(i parami)
  {
    return w(null, parami);
  }
  
  void x(i parami)
  {
    i locali = this.a;
    if (locali != null)
    {
      this.e.c(locali, -1.0F);
      this.a.d = -1;
      this.a = null;
    }
    float f1 = this.e.f(parami, true) * -1.0F;
    this.a = parami;
    if (f1 == 1.0F) {
      return;
    }
    this.b /= f1;
    this.e.j(f1);
  }
  
  public void y()
  {
    this.a = null;
    this.e.clear();
    this.b = 0.0F;
    this.f = false;
  }
  
  String z()
  {
    if (this.a == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("0");
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.a);
    }
    Object localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" = ");
    localObject1 = ((StringBuilder)localObject2).toString();
    float f1 = this.b;
    int j = 0;
    int i;
    if (f1 != 0.0F)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.b);
      localObject1 = ((StringBuilder)localObject2).toString();
      i = 1;
    }
    else
    {
      i = 0;
    }
    int k = this.e.e();
    while (j < k)
    {
      localObject2 = this.e.i(j);
      if (localObject2 != null)
      {
        float f2 = this.e.a(j);
        boolean bool = f2 < 0.0F;
        if (bool)
        {
          String str = ((i)localObject2).toString();
          if (i == 0)
          {
            localObject2 = localObject1;
            f1 = f2;
            if (f2 >= 0.0F) {
              break label353;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject1 = "- ";
          }
          else
          {
            if (bool)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" + ");
              localObject2 = ((StringBuilder)localObject2).toString();
              f1 = f2;
              break label353;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject1 = " - ";
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          f1 = f2 * -1.0F;
          label353:
          if (f1 == 1.0F)
          {
            localObject1 = new StringBuilder();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(f1);
            localObject2 = " ";
          }
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(str);
          localObject1 = ((StringBuilder)localObject1).toString();
          i = 1;
        }
      }
      j += 1;
    }
    localObject2 = localObject1;
    if (i == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0.0");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public static abstract interface a
  {
    public abstract float a(int paramInt);
    
    public abstract float b(i parami);
    
    public abstract void c(i parami, float paramFloat);
    
    public abstract void clear();
    
    public abstract boolean d(i parami);
    
    public abstract int e();
    
    public abstract float f(i parami, boolean paramBoolean);
    
    public abstract void g(i parami, float paramFloat, boolean paramBoolean);
    
    public abstract float h(b paramb, boolean paramBoolean);
    
    public abstract i i(int paramInt);
    
    public abstract void j(float paramFloat);
    
    public abstract void k();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.b
 * JD-Core Version:    0.7.0.1
 */