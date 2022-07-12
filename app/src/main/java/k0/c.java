package k0;

import java.util.ArrayList;

public class c
{
  protected e a;
  protected e b;
  protected e c;
  protected e d;
  protected e e;
  protected e f;
  protected e g;
  protected ArrayList<e> h;
  protected int i;
  protected int j;
  protected float k = 0.0F;
  int l;
  int m;
  int n;
  boolean o;
  private int p;
  private boolean q;
  protected boolean r;
  protected boolean s;
  protected boolean t;
  protected boolean u;
  private boolean v;
  
  public c(e parame, int paramInt, boolean paramBoolean)
  {
    this.a = parame;
    this.p = paramInt;
    this.q = paramBoolean;
  }
  
  private void b()
  {
    int i2 = this.p * 2;
    Object localObject1 = this.a;
    boolean bool = true;
    this.o = true;
    Object localObject2 = localObject1;
    int i1 = 0;
    while (i1 == 0)
    {
      this.i += 1;
      Object localObject4 = ((e)localObject1).P0;
      int i3 = this.p;
      Object localObject3 = null;
      localObject4[i3] = null;
      ((e)localObject1).O0[i3] = null;
      Object localObject5;
      if (((e)localObject1).X() != 8)
      {
        this.l += 1;
        localObject5 = ((e)localObject1).w(this.p);
        localObject4 = e.b.c;
        if (localObject5 != localObject4) {
          this.m += ((e)localObject1).G(this.p);
        }
        int i4 = this.m + localObject1.Y[i2].f();
        this.m = i4;
        localObject5 = ((e)localObject1).Y;
        i3 = i2 + 1;
        this.m = (i4 + localObject5[i3].f());
        i4 = this.n + localObject1.Y[i2].f();
        this.n = i4;
        this.n = (i4 + localObject1.Y[i3].f());
        if (this.b == null) {
          this.b = ((e)localObject1);
        }
        this.d = ((e)localObject1);
        localObject5 = ((e)localObject1).b0;
        i3 = this.p;
        if (localObject5[i3] == localObject4)
        {
          localObject4 = ((e)localObject1).y;
          if ((localObject4[i3] == 0) || (localObject4[i3] == 3) || (localObject4[i3] == 2))
          {
            this.j += 1;
            localObject4 = ((e)localObject1).N0;
            float f1 = localObject4[i3];
            if (f1 > 0.0F) {
              this.k += localObject4[i3];
            }
            if (c((e)localObject1, i3))
            {
              if (f1 < 0.0F) {
                this.r = true;
              } else {
                this.s = true;
              }
              if (this.h == null) {
                this.h = new ArrayList();
              }
              this.h.add(localObject1);
            }
            if (this.f == null) {
              this.f = ((e)localObject1);
            }
            localObject4 = this.g;
            if (localObject4 != null) {
              ((e)localObject4).O0[this.p] = localObject1;
            }
            this.g = ((e)localObject1);
          }
          if (this.p == 0)
          {
            if ((((e)localObject1).w == 0) && (((e)localObject1).z == 0)) {
              if (((e)localObject1).A == 0) {
                break label513;
              }
            }
          }
          else {
            if (((e)localObject1).x == 0) {
              break label494;
            }
          }
          label494:
          while ((((e)localObject1).C != 0) || (((e)localObject1).D != 0))
          {
            this.o = false;
            break;
          }
          label513:
          if (((e)localObject1).f0 != 0.0F)
          {
            this.o = false;
            this.u = true;
          }
        }
      }
      if (localObject2 != localObject1) {
        ((e)localObject2).P0[this.p] = localObject1;
      }
      localObject4 = localObject1.Y[(i2 + 1)].f;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((d)localObject4).d;
        localObject5 = ((e)localObject4).Y;
        localObject2 = localObject3;
        if (localObject5[i2].f != null) {
          if (localObject5[i2].f.d != localObject1) {
            localObject2 = localObject3;
          } else {
            localObject2 = localObject4;
          }
        }
      }
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        i1 = 1;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    localObject2 = this.b;
    if (localObject2 != null) {
      this.m -= localObject2.Y[i2].f();
    }
    localObject2 = this.d;
    if (localObject2 != null) {
      this.m -= localObject2.Y[(i2 + 1)].f();
    }
    this.c = ((e)localObject1);
    if ((this.p == 0) && (this.q)) {
      this.e = ((e)localObject1);
    } else {
      this.e = this.a;
    }
    if ((!this.s) || (!this.r)) {
      bool = false;
    }
    this.t = bool;
  }
  
  private static boolean c(e parame, int paramInt)
  {
    if ((parame.X() != 8) && (parame.b0[paramInt] == e.b.c))
    {
      parame = parame.y;
      if ((parame[paramInt] == 0) || (parame[paramInt] == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (!this.v) {
      b();
    }
    this.v = true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.c
 * JD-Core Version:    0.7.0.1
 */