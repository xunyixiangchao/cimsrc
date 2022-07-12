package k0;

import h0.i;
import java.util.ArrayList;
import java.util.HashMap;

public class h
  extends e
{
  protected float V0 = -1.0F;
  protected int W0 = -1;
  protected int X0 = -1;
  protected boolean Y0 = true;
  private d Z0 = this.R;
  private int a1;
  private int b1;
  private boolean c1;
  
  public h()
  {
    int i = 0;
    this.a1 = 0;
    this.b1 = 0;
    this.Z.clear();
    this.Z.add(this.Z0);
    int j = this.Y.length;
    while (i < j)
    {
      this.Y[i] = this.Z0;
      i += 1;
    }
  }
  
  public void A1(int paramInt)
  {
    this.Z0.t(paramInt);
    this.c1 = true;
  }
  
  public void B1(int paramInt)
  {
    if (paramInt > -1)
    {
      this.V0 = -1.0F;
      this.W0 = paramInt;
      this.X0 = -1;
    }
  }
  
  public void C1(int paramInt)
  {
    if (paramInt > -1)
    {
      this.V0 = -1.0F;
      this.W0 = -1;
      this.X0 = paramInt;
    }
  }
  
  public void D1(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.V0 = paramFloat;
      this.W0 = -1;
      this.X0 = -1;
    }
  }
  
  public void E1(int paramInt)
  {
    if (this.a1 == paramInt) {
      return;
    }
    this.a1 = paramInt;
    this.Z.clear();
    d locald;
    if (this.a1 == 1) {
      locald = this.Q;
    } else {
      locald = this.R;
    }
    this.Z0 = locald;
    this.Z.add(this.Z0);
    int i = this.Y.length;
    paramInt = 0;
    while (paramInt < i)
    {
      this.Y[paramInt] = this.Z0;
      paramInt += 1;
    }
  }
  
  public void g(h0.d paramd, boolean paramBoolean)
  {
    Object localObject2 = (f)M();
    if (localObject2 == null) {
      return;
    }
    d locald = ((e)localObject2).q(d.b.b);
    Object localObject1 = ((e)localObject2).q(d.b.d);
    e locale = this.c0;
    int j = 1;
    int i;
    if ((locale != null) && (locale.b0[0] == e.b.b)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.a1 == 0)
    {
      locald = ((e)localObject2).q(d.b.c);
      localObject1 = ((e)localObject2).q(d.b.e);
      localObject2 = this.c0;
      if ((localObject2 != null) && (localObject2.b0[1] == e.b.b)) {
        i = j;
      } else {
        i = 0;
      }
    }
    if ((this.c1) && (this.Z0.n()))
    {
      localObject2 = paramd.q(this.Z0);
      paramd.f((i)localObject2, this.Z0.e());
      if (this.W0 != -1)
      {
        if (i != 0) {
          paramd.h(paramd.q(localObject1), (i)localObject2, 0, 5);
        }
      }
      else if ((this.X0 != -1) && (i != 0))
      {
        localObject1 = paramd.q(localObject1);
        paramd.h((i)localObject2, paramd.q(locald), 0, 5);
        paramd.h((i)localObject1, (i)localObject2, 0, 5);
      }
      this.c1 = false;
      return;
    }
    if (this.W0 != -1)
    {
      localObject2 = paramd.q(this.Z0);
      paramd.e((i)localObject2, paramd.q(locald), this.W0, 8);
      if (i != 0) {
        paramd.h(paramd.q(localObject1), (i)localObject2, 0, 5);
      }
    }
    else if (this.X0 != -1)
    {
      localObject2 = paramd.q(this.Z0);
      localObject1 = paramd.q(localObject1);
      paramd.e((i)localObject2, (i)localObject1, -this.X0, 8);
      if (i != 0)
      {
        paramd.h((i)localObject2, paramd.q(locald), 0, 5);
        paramd.h((i)localObject1, (i)localObject2, 0, 5);
      }
    }
    else if (this.V0 != -1.0F)
    {
      paramd.d(h0.d.s(paramd, paramd.q(this.Z0), paramd.q(localObject1), this.V0));
    }
  }
  
  public boolean h()
  {
    return true;
  }
  
  public void n(e parame, HashMap<e, e> paramHashMap)
  {
    super.n(parame, paramHashMap);
    parame = (h)parame;
    this.V0 = parame.V0;
    this.W0 = parame.W0;
    this.X0 = parame.X0;
    this.Y0 = parame.Y0;
    E1(parame.a1);
  }
  
  public boolean p0()
  {
    return this.c1;
  }
  
  public d q(d.b paramb)
  {
    int i = a.a[paramb.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (((i == 3) || (i == 4)) && (this.a1 == 0)) {
        return this.Z0;
      }
    }
    else if (this.a1 == 1) {
      return this.Z0;
    }
    return null;
  }
  
  public boolean q0()
  {
    return this.c1;
  }
  
  public void u1(h0.d paramd, boolean paramBoolean)
  {
    if (M() == null) {
      return;
    }
    int i = paramd.x(this.Z0);
    if (this.a1 == 1)
    {
      q1(i);
      r1(0);
      P0(M().z());
      o1(0);
      return;
    }
    q1(0);
    r1(i);
    o1(M().Y());
    P0(0);
  }
  
  public d v1()
  {
    return this.Z0;
  }
  
  public int w1()
  {
    return this.a1;
  }
  
  public int x1()
  {
    return this.W0;
  }
  
  public int y1()
  {
    return this.X0;
  }
  
  public float z1()
  {
    return this.V0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.h
 * JD-Core Version:    0.7.0.1
 */