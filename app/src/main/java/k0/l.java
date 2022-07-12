package k0;

import h0.d;

public class l
  extends m
{
  public void G1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = D1();
    int m = E1();
    int i = F1();
    int j = C1();
    boolean bool = false;
    k = k + m + 0;
    m = i + j + 0;
    j = k;
    i = m;
    if (this.W0 > 0)
    {
      j = k + this.V0[0].Y();
      i = m + this.V0[0].z();
    }
    j = Math.max(K(), j);
    i = Math.max(J(), i);
    if (paramInt1 != 1073741824) {
      if (paramInt1 == -2147483648) {
        paramInt2 = Math.min(j, paramInt2);
      } else if (paramInt1 == 0) {
        paramInt2 = j;
      } else {
        paramInt2 = 0;
      }
    }
    if (paramInt3 != 1073741824) {
      if (paramInt3 == -2147483648) {
        paramInt4 = Math.min(i, paramInt4);
      } else if (paramInt3 == 0) {
        paramInt4 = i;
      } else {
        paramInt4 = 0;
      }
    }
    L1(paramInt2, paramInt4);
    o1(paramInt2);
    P0(paramInt4);
    if (this.W0 > 0) {
      bool = true;
    }
    K1(bool);
  }
  
  public void g(d paramd, boolean paramBoolean)
  {
    super.g(paramd, paramBoolean);
    if (this.W0 > 0)
    {
      paramd = this.V0[0];
      paramd.w0();
      d.b localb = d.b.b;
      paramd.j(localb, this, localb);
      localb = d.b.d;
      paramd.j(localb, this, localb);
      localb = d.b.c;
      paramd.j(localb, this, localb);
      localb = d.b.e;
      paramd.j(localb, this, localb);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.l
 * JD-Core Version:    0.7.0.1
 */