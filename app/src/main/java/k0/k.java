package k0;

public class k
{
  static boolean[] a = new boolean[3];
  
  static void a(f paramf, h0.d paramd, e parame)
  {
    parame.t = -1;
    parame.u = -1;
    Object localObject = paramf.b0[0];
    e.b localb = e.b.b;
    int i;
    int j;
    if ((localObject != localb) && (parame.b0[0] == e.b.d))
    {
      i = parame.Q.g;
      j = paramf.Y() - parame.S.g;
      localObject = parame.Q;
      ((d)localObject).i = paramd.q(localObject);
      localObject = parame.S;
      ((d)localObject).i = paramd.q(localObject);
      paramd.f(parame.Q.i, i);
      paramd.f(parame.S.i, j);
      parame.t = 2;
      parame.S0(i, j);
    }
    if ((paramf.b0[1] != localb) && (parame.b0[1] == e.b.d))
    {
      i = parame.R.g;
      j = paramf.z() - parame.T.g;
      paramf = parame.R;
      paramf.i = paramd.q(paramf);
      paramf = parame.T;
      paramf.i = paramd.q(paramf);
      paramd.f(parame.R.i, i);
      paramd.f(parame.T.i, j);
      if ((parame.n0 > 0) || (parame.X() == 8))
      {
        paramf = parame.U;
        paramf.i = paramd.q(paramf);
        paramd.f(parame.U.i, parame.n0 + i);
      }
      parame.u = 2;
      parame.j1(i, j);
    }
  }
  
  public static final boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.k
 * JD-Core Version:    0.7.0.1
 */