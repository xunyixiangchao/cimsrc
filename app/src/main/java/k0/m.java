package k0;

import java.util.HashSet;
import l0.b.a;
import l0.b.b;

public class m
  extends j
{
  private int X0 = 0;
  private int Y0 = 0;
  private int Z0 = 0;
  private int a1 = 0;
  private int b1 = 0;
  private int c1 = 0;
  private int d1 = 0;
  private int e1 = 0;
  private boolean f1 = false;
  private int g1 = 0;
  private int h1 = 0;
  protected b.a i1 = new b.a();
  b.b j1 = null;
  
  public int A1()
  {
    return this.h1;
  }
  
  public int B1()
  {
    return this.g1;
  }
  
  public int C1()
  {
    return this.Y0;
  }
  
  public int D1()
  {
    return this.d1;
  }
  
  public int E1()
  {
    return this.e1;
  }
  
  public int F1()
  {
    return this.X0;
  }
  
  public void G1(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void H1(e parame, e.b paramb1, int paramInt1, e.b paramb2, int paramInt2)
  {
    while ((this.j1 == null) && (M() != null)) {
      this.j1 = ((f)M()).M1();
    }
    b.a locala = this.i1;
    locala.a = paramb1;
    locala.b = paramb2;
    locala.c = paramInt1;
    locala.d = paramInt2;
    this.j1.b(parame, locala);
    parame.o1(this.i1.e);
    parame.P0(this.i1.f);
    parame.O0(this.i1.h);
    parame.E0(this.i1.g);
  }
  
  protected boolean I1()
  {
    Object localObject1 = this.c0;
    if (localObject1 != null) {
      localObject1 = ((f)localObject1).M1();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      int k = this.W0;
      int j = 1;
      if (i >= k) {
        break;
      }
      e locale = this.V0[i];
      if ((locale != null) && (!(locale instanceof h)))
      {
        Object localObject3 = locale.w(0);
        Object localObject4 = locale.w(1);
        e.b localb = e.b.c;
        if ((localObject3 != localb) || (locale.w == 1) || (localObject4 != localb) || (locale.x == 1)) {
          j = 0;
        }
        if (j == 0)
        {
          Object localObject2 = localObject3;
          if (localObject3 == localb) {
            localObject2 = e.b.b;
          }
          localObject3 = localObject4;
          if (localObject4 == localb) {
            localObject3 = e.b.b;
          }
          localObject4 = this.i1;
          ((b.a)localObject4).a = ((e.b)localObject2);
          ((b.a)localObject4).b = ((e.b)localObject3);
          ((b.a)localObject4).c = locale.Y();
          this.i1.d = locale.z();
          ((b.b)localObject1).b(locale, this.i1);
          locale.o1(this.i1.e);
          locale.P0(this.i1.f);
          locale.E0(this.i1.g);
        }
      }
      i += 1;
    }
    return true;
  }
  
  public boolean J1()
  {
    return this.f1;
  }
  
  protected void K1(boolean paramBoolean)
  {
    this.f1 = paramBoolean;
  }
  
  public void L1(int paramInt1, int paramInt2)
  {
    this.g1 = paramInt1;
    this.h1 = paramInt2;
  }
  
  public void M1(int paramInt)
  {
    this.Z0 = paramInt;
    this.X0 = paramInt;
    this.a1 = paramInt;
    this.Y0 = paramInt;
    this.b1 = paramInt;
    this.c1 = paramInt;
  }
  
  public void N1(int paramInt)
  {
    this.Y0 = paramInt;
  }
  
  public void O1(int paramInt)
  {
    this.c1 = paramInt;
  }
  
  public void P1(int paramInt)
  {
    this.Z0 = paramInt;
    this.d1 = paramInt;
  }
  
  public void Q1(int paramInt)
  {
    this.a1 = paramInt;
    this.e1 = paramInt;
  }
  
  public void R1(int paramInt)
  {
    this.b1 = paramInt;
    this.d1 = paramInt;
    this.e1 = paramInt;
  }
  
  public void S1(int paramInt)
  {
    this.X0 = paramInt;
  }
  
  public void b(f paramf)
  {
    y1();
  }
  
  public void x1(boolean paramBoolean)
  {
    int i = this.b1;
    if ((i > 0) || (this.c1 > 0))
    {
      if (paramBoolean)
      {
        this.d1 = this.c1;
        this.e1 = i;
        return;
      }
      this.d1 = i;
      this.e1 = this.c1;
    }
  }
  
  public void y1()
  {
    int i = 0;
    while (i < this.W0)
    {
      e locale = this.V0[i];
      if (locale != null) {
        locale.Y0(true);
      }
      i += 1;
    }
  }
  
  public boolean z1(HashSet<e> paramHashSet)
  {
    int i = 0;
    while (i < this.W0)
    {
      if (paramHashSet.contains(this.V0[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.m
 * JD-Core Version:    0.7.0.1
 */