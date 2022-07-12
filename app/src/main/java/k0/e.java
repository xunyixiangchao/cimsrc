package k0;

import h0.i;
import j0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import l0.l;
import l0.n;
import l0.p;

public class e
{
  public static float U0 = 0.5F;
  public int A = 0;
  int A0;
  public float B = 1.0F;
  int B0;
  public int C = 0;
  boolean C0;
  public int D = 0;
  boolean D0;
  public float E = 1.0F;
  boolean E0;
  public boolean F;
  boolean F0;
  public boolean G;
  boolean G0;
  int H = -1;
  boolean H0;
  float I = 1.0F;
  boolean I0;
  private int[] J = { 2147483647, 2147483647 };
  int J0;
  private float K = 0.0F;
  int K0;
  private boolean L = false;
  boolean L0;
  private boolean M;
  boolean M0;
  private boolean N = false;
  public float[] N0;
  private int O = 0;
  protected e[] O0;
  private int P = 0;
  protected e[] P0;
  public d Q = new d(this, d.b.b);
  e Q0;
  public d R = new d(this, d.b.c);
  e R0;
  public d S = new d(this, d.b.d);
  public int S0;
  public d T = new d(this, d.b.e);
  public int T0;
  public d U = new d(this, d.b.f);
  d V = new d(this, d.b.h);
  d W = new d(this, d.b.i);
  public d X;
  public d[] Y;
  protected ArrayList<d> Z;
  public boolean a = false;
  private boolean[] a0;
  public p[] b = new p[2];
  public b[] b0;
  public l0.c c;
  public e c0;
  public l0.c d;
  int d0;
  public l e = null;
  int e0;
  public n f = null;
  public float f0;
  public boolean[] g = { 1, 1 };
  protected int g0;
  boolean h = false;
  protected int h0;
  private boolean i = true;
  protected int i0;
  private boolean j = false;
  int j0;
  private boolean k = true;
  int k0;
  private int l = -1;
  protected int l0;
  private int m = -1;
  protected int m0;
  public a n = new a(this);
  int n0;
  public String o;
  protected int o0;
  private boolean p = false;
  protected int p0;
  private boolean q = false;
  float q0;
  private boolean r = false;
  float r0;
  private boolean s = false;
  private Object s0;
  public int t = -1;
  private int t0;
  public int u = -1;
  private int u0;
  private int v = 0;
  private boolean v0;
  public int w = 0;
  private String w0;
  public int x = 0;
  private String x0;
  public int[] y = new int[2];
  int y0;
  public int z = 0;
  int z0;
  
  public e()
  {
    Object localObject = new d(this, d.b.g);
    this.X = ((d)localObject);
    this.Y = new d[] { this.Q, this.S, this.R, this.T, this.U, localObject };
    this.Z = new ArrayList();
    this.a0 = new boolean[2];
    localObject = b.a;
    this.b0 = new b[] { localObject, localObject };
    this.c0 = null;
    this.d0 = 0;
    this.e0 = 0;
    this.f0 = 0.0F;
    this.g0 = -1;
    this.h0 = 0;
    this.i0 = 0;
    this.j0 = 0;
    this.k0 = 0;
    this.l0 = 0;
    this.m0 = 0;
    this.n0 = 0;
    float f1 = U0;
    this.q0 = f1;
    this.r0 = f1;
    this.t0 = 0;
    this.u0 = 0;
    this.v0 = false;
    this.w0 = null;
    this.x0 = null;
    this.I0 = false;
    this.J0 = 0;
    this.K0 = 0;
    this.N0 = new float[] { -1.0F, -1.0F };
    this.O0 = new e[] { null, null };
    this.P0 = new e[] { null, null };
    this.Q0 = null;
    this.R0 = null;
    this.S0 = -1;
    this.T0 = -1;
    d();
  }
  
  private void A0(StringBuilder paramStringBuilder, String paramString, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return;
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" :   ");
    paramStringBuilder.append(paramFloat1);
    paramStringBuilder.append(",\n");
  }
  
  private void B0(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" :   ");
    paramStringBuilder.append(paramInt1);
    paramStringBuilder.append(",\n");
  }
  
  private void C0(StringBuilder paramStringBuilder, String paramString, float paramFloat, int paramInt)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" :  [");
    paramStringBuilder.append(paramFloat);
    paramStringBuilder.append(",");
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append("");
    paramStringBuilder.append("],\n");
  }
  
  private void R(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" :  {\n");
    B0(paramStringBuilder, "      size", paramInt1, 0);
    B0(paramStringBuilder, "      min", paramInt2, 0);
    B0(paramStringBuilder, "      max", paramInt3, 2147483647);
    B0(paramStringBuilder, "      matchMin", paramInt5, 0);
    B0(paramStringBuilder, "      matchDef", paramInt6, 0);
    A0(paramStringBuilder, "      matchPercent", paramFloat1, 1.0F);
    paramStringBuilder.append("    },\n");
  }
  
  private void S(StringBuilder paramStringBuilder, String paramString, d paramd)
  {
    if (paramd.f == null) {
      return;
    }
    paramStringBuilder.append("    ");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" : [ '");
    paramStringBuilder.append(paramd.f);
    paramStringBuilder.append("'");
    if ((paramd.h != -2147483648) || (paramd.g != 0))
    {
      paramStringBuilder.append(",");
      paramStringBuilder.append(paramd.g);
      if (paramd.h != -2147483648)
      {
        paramStringBuilder.append(",");
        paramStringBuilder.append(paramd.h);
        paramStringBuilder.append(",");
      }
    }
    paramStringBuilder.append(" ] ,\n");
  }
  
  private void d()
  {
    this.Z.add(this.Q);
    this.Z.add(this.R);
    this.Z.add(this.S);
    this.Z.add(this.T);
    this.Z.add(this.V);
    this.Z.add(this.W);
    this.Z.add(this.X);
    this.Z.add(this.U);
  }
  
  private boolean h0(int paramInt)
  {
    paramInt *= 2;
    d[] arrayOfd = this.Y;
    if ((arrayOfd[paramInt].f != null) && (arrayOfd[paramInt].f.f != arrayOfd[paramInt]))
    {
      paramInt += 1;
      if ((arrayOfd[paramInt].f != null) && (arrayOfd[paramInt].f.f == arrayOfd[paramInt])) {
        return true;
      }
    }
    return false;
  }
  
  private void i(h0.d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, i parami1, i parami2, b paramb, boolean paramBoolean5, d paramd1, d paramd2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float paramFloat2, boolean paramBoolean11)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public float A()
  {
    return this.q0;
  }
  
  public int B()
  {
    return this.J0;
  }
  
  public b C()
  {
    return this.b0[0];
  }
  
  public int D()
  {
    d locald = this.Q;
    int i1 = 0;
    if (locald != null) {
      i1 = 0 + locald.g;
    }
    locald = this.S;
    int i2 = i1;
    if (locald != null) {
      i2 = i1 + locald.g;
    }
    return i2;
  }
  
  public void D0(boolean paramBoolean)
  {
    this.v0 = paramBoolean;
  }
  
  public int E()
  {
    return this.O;
  }
  
  public void E0(int paramInt)
  {
    this.n0 = paramInt;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.L = bool;
  }
  
  public int F()
  {
    return this.P;
  }
  
  public void F0(Object paramObject)
  {
    this.s0 = paramObject;
  }
  
  public int G(int paramInt)
  {
    if (paramInt == 0) {
      return Y();
    }
    if (paramInt == 1) {
      return z();
    }
    return 0;
  }
  
  public void G0(String paramString)
  {
    this.w0 = paramString;
  }
  
  public int H()
  {
    return this.J[1];
  }
  
  public void H0(String paramString)
  {
    int i1;
    int i2;
    String str;
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i3 = -1;
      int i5 = paramString.length();
      int i6 = paramString.indexOf(',');
      int i4 = 0;
      i1 = i3;
      i2 = i4;
      if (i6 > 0)
      {
        i1 = i3;
        i2 = i4;
        if (i6 < i5 - 1)
        {
          str = paramString.substring(0, i6);
          if (str.equalsIgnoreCase("W"))
          {
            i1 = 0;
          }
          else
          {
            i1 = i3;
            if (str.equalsIgnoreCase("H")) {
              i1 = 1;
            }
          }
          i2 = i6 + 1;
        }
      }
      i3 = paramString.indexOf(':');
      if ((i3 >= 0) && (i3 < i5 - 1))
      {
        str = paramString.substring(i2, i3);
        paramString = paramString.substring(i3 + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label241;
        }
      }
    }
    try
    {
      f1 = Float.parseFloat(str);
      float f2 = Float.parseFloat(paramString);
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        break label241;
      }
      if (i1 == 1) {
        f1 = Math.abs(f2 / f1);
      } else {
        f1 = Math.abs(f1 / f2);
      }
    }
    catch (NumberFormatException paramString)
    {
      float f1;
      break label241;
    }
    paramString = paramString.substring(i2);
    if (paramString.length() > 0) {
      f1 = Float.parseFloat(paramString);
    } else {
      label241:
      f1 = 0.0F;
    }
    if (f1 > 0.0F)
    {
      this.f0 = f1;
      this.g0 = i1;
    }
    return;
    this.f0 = 0.0F;
  }
  
  public int I()
  {
    return this.J[0];
  }
  
  public void I0(int paramInt)
  {
    if (!this.L) {
      return;
    }
    int i1 = paramInt - this.n0;
    int i2 = this.e0;
    this.i0 = i1;
    this.R.t(i1);
    this.T.t(i2 + i1);
    this.U.t(paramInt);
    this.q = true;
  }
  
  public int J()
  {
    return this.p0;
  }
  
  public void J0(int paramInt1, int paramInt2)
  {
    if (this.p) {
      return;
    }
    this.Q.t(paramInt1);
    this.S.t(paramInt2);
    this.h0 = paramInt1;
    this.d0 = (paramInt2 - paramInt1);
    this.p = true;
  }
  
  public int K()
  {
    return this.o0;
  }
  
  public void K0(int paramInt)
  {
    this.Q.t(paramInt);
    this.h0 = paramInt;
  }
  
  public e L(int paramInt)
  {
    d locald1;
    d locald2;
    if (paramInt == 0)
    {
      locald1 = this.S;
      locald2 = locald1.f;
      if ((locald2 != null) && (locald2.f == locald1)) {
        return locald2.d;
      }
    }
    else if (paramInt == 1)
    {
      locald1 = this.T;
      locald2 = locald1.f;
      if ((locald2 != null) && (locald2.f == locald1)) {
        return locald2.d;
      }
    }
    return null;
  }
  
  public void L0(int paramInt)
  {
    this.R.t(paramInt);
    this.i0 = paramInt;
  }
  
  public e M()
  {
    return this.c0;
  }
  
  public void M0(int paramInt1, int paramInt2)
  {
    if (this.q) {
      return;
    }
    this.R.t(paramInt1);
    this.T.t(paramInt2);
    this.i0 = paramInt1;
    this.e0 = (paramInt2 - paramInt1);
    if (this.L) {
      this.U.t(paramInt1 + this.n0);
    }
    this.q = true;
  }
  
  public e N(int paramInt)
  {
    d locald1;
    d locald2;
    if (paramInt == 0)
    {
      locald1 = this.Q;
      locald2 = locald1.f;
      if ((locald2 != null) && (locald2.f == locald1)) {
        return locald2.d;
      }
    }
    else if (paramInt == 1)
    {
      locald1 = this.R;
      locald2 = locald1.f;
      if ((locald2 != null) && (locald2.f == locald1)) {
        return locald2.d;
      }
    }
    return null;
  }
  
  public void N0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    this.h0 = paramInt1;
    this.i0 = paramInt2;
    if (this.u0 == 8)
    {
      this.d0 = 0;
      this.e0 = 0;
      return;
    }
    b[] arrayOfb = this.b0;
    b localb1 = arrayOfb[0];
    b localb2 = b.a;
    paramInt1 = i1;
    if (localb1 == localb2)
    {
      paramInt2 = this.d0;
      paramInt1 = i1;
      if (i1 < paramInt2) {
        paramInt1 = paramInt2;
      }
    }
    paramInt2 = paramInt3;
    if (arrayOfb[1] == localb2)
    {
      paramInt4 = this.e0;
      paramInt2 = paramInt3;
      if (paramInt3 < paramInt4) {
        paramInt2 = paramInt4;
      }
    }
    this.d0 = paramInt1;
    this.e0 = paramInt2;
    paramInt3 = this.p0;
    if (paramInt2 < paramInt3) {
      this.e0 = paramInt3;
    }
    paramInt3 = this.o0;
    if (paramInt1 < paramInt3) {
      this.d0 = paramInt3;
    }
    paramInt3 = this.A;
    if ((paramInt3 > 0) && (arrayOfb[0] == b.c)) {
      this.d0 = Math.min(this.d0, paramInt3);
    }
    paramInt3 = this.D;
    if ((paramInt3 > 0) && (this.b0[1] == b.c)) {
      this.e0 = Math.min(this.e0, paramInt3);
    }
    paramInt3 = this.d0;
    if (paramInt1 != paramInt3) {
      this.l = paramInt3;
    }
    paramInt1 = this.e0;
    if (paramInt2 != paramInt1) {
      this.m = paramInt1;
    }
  }
  
  public int O()
  {
    return Z() + this.d0;
  }
  
  public void O0(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public p P(int paramInt)
  {
    if (paramInt == 0) {
      return this.e;
    }
    if (paramInt == 1) {
      return this.f;
    }
    return null;
  }
  
  public void P0(int paramInt)
  {
    this.e0 = paramInt;
    int i1 = this.p0;
    if (paramInt < i1) {
      this.e0 = i1;
    }
  }
  
  public void Q(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(":{\n");
    paramStringBuilder.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("    actualWidth:");
    localStringBuilder.append(this.d0);
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append("\n");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("    actualHeight:");
    localStringBuilder.append(this.e0);
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append("\n");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("    actualLeft:");
    localStringBuilder.append(this.h0);
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append("\n");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("    actualTop:");
    localStringBuilder.append(this.i0);
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append("\n");
    S(paramStringBuilder, "left", this.Q);
    S(paramStringBuilder, "top", this.R);
    S(paramStringBuilder, "right", this.S);
    S(paramStringBuilder, "bottom", this.T);
    S(paramStringBuilder, "baseline", this.U);
    S(paramStringBuilder, "centerX", this.V);
    S(paramStringBuilder, "centerY", this.W);
    R(paramStringBuilder, "    width", this.d0, this.o0, this.J[0], this.l, this.z, this.w, this.B, this.N0[0]);
    R(paramStringBuilder, "    height", this.e0, this.p0, this.J[1], this.m, this.C, this.x, this.E, this.N0[1]);
    C0(paramStringBuilder, "    dimensionRatio", this.f0, this.g0);
    A0(paramStringBuilder, "    horizontalBias", this.q0, U0);
    A0(paramStringBuilder, "    verticalBias", this.r0, U0);
    B0(paramStringBuilder, "    horizontalChainStyle", this.J0, 0);
    B0(paramStringBuilder, "    verticalChainStyle", this.K0, 0);
    paramStringBuilder.append("  }");
  }
  
  public void Q0(float paramFloat)
  {
    this.q0 = paramFloat;
  }
  
  public void R0(int paramInt)
  {
    this.J0 = paramInt;
  }
  
  public void S0(int paramInt1, int paramInt2)
  {
    this.h0 = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    this.d0 = paramInt1;
    paramInt2 = this.o0;
    if (paramInt1 < paramInt2) {
      this.d0 = paramInt2;
    }
  }
  
  public float T()
  {
    return this.r0;
  }
  
  public void T0(b paramb)
  {
    this.b0[0] = paramb;
  }
  
  public int U()
  {
    return this.K0;
  }
  
  public void U0(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.w = paramInt1;
    this.z = paramInt2;
    paramInt2 = paramInt3;
    if (paramInt3 == 2147483647) {
      paramInt2 = 0;
    }
    this.A = paramInt2;
    this.B = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (paramInt1 == 0)) {
      this.w = 2;
    }
  }
  
  public b V()
  {
    return this.b0[1];
  }
  
  public void V0(float paramFloat)
  {
    this.N0[0] = paramFloat;
  }
  
  public int W()
  {
    d locald = this.Q;
    int i1 = 0;
    if (locald != null) {
      i1 = 0 + this.R.g;
    }
    int i2 = i1;
    if (this.S != null) {
      i2 = i1 + this.T.g;
    }
    return i2;
  }
  
  protected void W0(int paramInt, boolean paramBoolean)
  {
    this.a0[paramInt] = paramBoolean;
  }
  
  public int X()
  {
    return this.u0;
  }
  
  public void X0(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public int Y()
  {
    if (this.u0 == 8) {
      return 0;
    }
    return this.d0;
  }
  
  public void Y0(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public int Z()
  {
    e locale = this.c0;
    if ((locale != null) && ((locale instanceof f))) {
      return ((f)locale).c1 + this.h0;
    }
    return this.h0;
  }
  
  public void Z0(int paramInt1, int paramInt2)
  {
    this.O = paramInt1;
    this.P = paramInt2;
    c1(false);
  }
  
  public int a0()
  {
    e locale = this.c0;
    if ((locale != null) && ((locale instanceof f))) {
      return ((f)locale).d1 + this.i0;
    }
    return this.i0;
  }
  
  public void a1(int paramInt)
  {
    this.J[1] = paramInt;
  }
  
  public boolean b0()
  {
    return this.L;
  }
  
  public void b1(int paramInt)
  {
    this.J[0] = paramInt;
  }
  
  public boolean c0(int paramInt)
  {
    int i1;
    if (paramInt == 0)
    {
      if (this.Q.f != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (this.S.f != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      return paramInt + i1 < 2;
    }
    if (this.R.f != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (this.T.f != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (this.U.f != null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    return paramInt + i1 + i2 < 2;
  }
  
  public void c1(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean d0()
  {
    int i2 = this.Z.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((d)this.Z.get(i1)).m()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public void d1(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.p0 = i1;
  }
  
  public void e(f paramf, h0.d paramd, HashSet<e> paramHashSet, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!paramHashSet.contains(this)) {
        return;
      }
      k.a(paramf, paramd, this);
      paramHashSet.remove(this);
      g(paramd, paramf.X1(64));
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.Q.d();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).d.e(paramf, paramd, paramHashSet, paramInt, true);
        }
      }
      localObject = this.S.d();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).d.e(paramf, paramd, paramHashSet, paramInt, true);
        }
      }
    }
    else
    {
      localObject = this.R.d();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).d.e(paramf, paramd, paramHashSet, paramInt, true);
        }
      }
      localObject = this.T.d();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).d.e(paramf, paramd, paramHashSet, paramInt, true);
        }
      }
      localObject = this.U.d();
      if (localObject != null) {
        localObject = ((HashSet)localObject).iterator();
      }
    }
    for (;;)
    {
      e locale;
      if (((Iterator)localObject).hasNext()) {
        locale = ((d)((Iterator)localObject).next()).d;
      }
      try
      {
        locale.e(paramf, paramd, paramHashSet, paramInt, true);
      }
      finally {}
    }
  }
  
  public boolean e0()
  {
    return (this.l != -1) || (this.m != -1);
  }
  
  public void e1(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.o0 = i1;
  }
  
  boolean f()
  {
    return ((this instanceof m)) || ((this instanceof h));
  }
  
  public boolean f0(int paramInt1, int paramInt2)
  {
    d locald;
    if (paramInt1 == 0)
    {
      locald = this.Q.f;
      if ((locald != null) && (locald.n()))
      {
        locald = this.S.f;
        if ((locald != null) && (locald.n())) {
          return this.S.f.e() - this.S.f() - (this.Q.f.e() + this.Q.f()) >= paramInt2;
        }
      }
    }
    else
    {
      locald = this.R.f;
      if ((locald != null) && (locald.n()))
      {
        locald = this.T.f;
        if ((locald != null) && (locald.n())) {
          return this.T.f.e() - this.T.f() - (this.R.f.e() + this.R.f()) >= paramInt2;
        }
      }
    }
    return false;
  }
  
  public void f1(int paramInt1, int paramInt2)
  {
    this.h0 = paramInt1;
    this.i0 = paramInt2;
  }
  
  public void g(h0.d paramd, boolean paramBoolean)
  {
    Object localObject1 = paramd.q(this.Q);
    Object localObject4 = paramd.q(this.S);
    Object localObject5 = paramd.q(this.R);
    Object localObject7 = paramd.q(this.T);
    Object localObject6 = paramd.q(this.U);
    Object localObject2 = this.c0;
    if (localObject2 != null)
    {
      if ((localObject2 != null) && (localObject2.b0[0] == b.b)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((localObject2 != null) && (localObject2.b0[1] == b.b)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i1 = this.v;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            bool3 = bool2;
            bool2 = bool1;
            bool1 = bool3;
            break label185;
          }
        }
        else
        {
          bool1 = bool2;
          bool2 = false;
          break label185;
        }
      }
      else
      {
        bool3 = false;
        bool2 = bool1;
        bool1 = bool3;
        break label185;
      }
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    label185:
    if ((this.u0 == 8) && (!this.v0) && (!d0()))
    {
      localObject2 = this.a0;
      if ((localObject2[0] == 0) && (localObject2[1] == 0)) {
        return;
      }
    }
    boolean bool3 = this.p;
    if ((bool3) || (this.q))
    {
      if (bool3)
      {
        paramd.f((i)localObject1, this.h0);
        paramd.f((i)localObject4, this.h0 + this.d0);
        if (bool2)
        {
          localObject2 = this.c0;
          if (localObject2 != null) {
            if (this.k)
            {
              localObject2 = (f)localObject2;
              ((f)localObject2).D1(this.Q);
              ((f)localObject2).C1(this.S);
            }
            else
            {
              paramd.h(paramd.q(((e)localObject2).S), (i)localObject4, 0, 5);
            }
          }
        }
      }
      if (this.q)
      {
        paramd.f((i)localObject5, this.i0);
        paramd.f((i)localObject7, this.i0 + this.e0);
        if (this.U.m()) {
          paramd.f((i)localObject6, this.i0 + this.n0);
        }
        if (bool1)
        {
          localObject2 = this.c0;
          if (localObject2 != null) {
            if (this.k)
            {
              localObject2 = (f)localObject2;
              ((f)localObject2).I1(this.R);
              ((f)localObject2).H1(this.T);
            }
            else
            {
              paramd.h(paramd.q(((e)localObject2).T), (i)localObject7, 0, 5);
            }
          }
        }
      }
      if ((this.p) && (this.q))
      {
        this.p = false;
        this.q = false;
        return;
      }
    }
    bool3 = h0.d.r;
    if (paramBoolean)
    {
      localObject2 = this.e;
      if (localObject2 != null)
      {
        localObject3 = this.f;
        if (localObject3 != null)
        {
          localObject8 = ((p)localObject2).h;
          if ((((l0.f)localObject8).j) && (((p)localObject2).i.j) && (((p)localObject3).h.j) && (((p)localObject3).i.j))
          {
            paramd.f((i)localObject1, ((l0.f)localObject8).g);
            paramd.f((i)localObject4, this.e.i.g);
            paramd.f((i)localObject5, this.f.h.g);
            paramd.f((i)localObject7, this.f.i.g);
            paramd.f((i)localObject6, this.f.k.g);
            if (this.c0 != null)
            {
              if ((bool2) && (this.g[0] != 0) && (!k0())) {
                paramd.h(paramd.q(this.c0.S), (i)localObject4, 0, 8);
              }
              if ((bool1) && (this.g[1] != 0) && (!m0())) {
                paramd.h(paramd.q(this.c0.T), (i)localObject7, 0, 8);
              }
            }
            this.p = false;
            this.q = false;
            return;
          }
        }
      }
    }
    boolean bool4;
    boolean bool5;
    if (this.c0 != null)
    {
      if (h0(0))
      {
        ((f)this.c0).z1(this, 0);
        bool3 = true;
      }
      else
      {
        bool3 = k0();
      }
      if (h0(1))
      {
        ((f)this.c0).z1(this, 1);
        bool4 = true;
      }
      else
      {
        bool4 = m0();
      }
      if ((!bool3) && (bool2) && (this.u0 != 8) && (this.Q.f == null) && (this.S.f == null)) {
        paramd.h(paramd.q(this.c0.S), (i)localObject4, 0, 1);
      }
      if ((!bool4) && (bool1) && (this.u0 != 8) && (this.R.f == null) && (this.T.f == null) && (this.U == null)) {
        paramd.h(paramd.q(this.c0.T), (i)localObject7, 0, 1);
      }
      bool5 = bool3;
    }
    else
    {
      bool4 = false;
      bool5 = bool4;
    }
    int i6 = this.d0;
    int i1 = this.o0;
    if (i6 >= i1) {
      i1 = i6;
    }
    int i7 = this.e0;
    int i2 = this.p0;
    if (i7 >= i2) {
      i2 = i7;
    }
    localObject2 = this.b0;
    Object localObject3 = localObject2[0];
    b localb = b.c;
    if (localObject3 != localb) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (localObject2[1] != localb) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    int i8 = this.g0;
    this.H = i8;
    float f1 = this.f0;
    this.I = f1;
    int i4 = this.w;
    int i5 = this.x;
    int i3;
    if ((f1 > 0.0F) && (this.u0 != 8))
    {
      i3 = i4;
      if (localObject2[0] == localb)
      {
        i3 = i4;
        if (i4 == 0) {
          i3 = 3;
        }
      }
      i4 = i5;
      if (localObject2[1] == localb)
      {
        i4 = i5;
        if (i5 == 0) {
          i4 = 3;
        }
      }
      if ((localObject2[0] == localb) && (localObject2[1] == localb) && (i3 == 3) && (i4 == 3))
      {
        s1(bool2, bool1, bool3, bool6);
      }
      else
      {
        if ((localObject2[0] == localb) && (i3 == 3))
        {
          this.H = 0;
          i6 = (int)(f1 * i7);
          if (localObject2[1] != localb)
          {
            i5 = 4;
            bool3 = false;
          }
          else
          {
            bool3 = true;
            i5 = i3;
          }
          i3 = i4;
          i1 = i2;
          i2 = i6;
          i4 = i5;
          break label1410;
        }
        if ((localObject2[1] == localb) && (i4 == 3))
        {
          this.H = 1;
          if (i8 == -1) {
            this.I = (1.0F / f1);
          }
          i5 = (int)(this.I * i6);
          localObject2 = localObject2[0];
          i6 = i3;
          if (localObject2 != localb)
          {
            bool3 = false;
            i3 = 4;
            i2 = i1;
            i1 = i5;
            i4 = i6;
            break label1410;
          }
          break label1365;
        }
      }
      i5 = i2;
      label1365:
      i6 = i3;
      i3 = i4;
      bool3 = true;
      i2 = i1;
      i1 = i5;
      i4 = i6;
    }
    else
    {
      i3 = i5;
      bool3 = false;
      i5 = i1;
      i1 = i2;
      i2 = i5;
    }
    label1410:
    localObject2 = this.y;
    localObject2[0] = i4;
    localObject2[1] = i3;
    this.h = bool3;
    if (bool3)
    {
      i5 = this.H;
      if ((i5 == 0) || (i5 == -1))
      {
        bool7 = true;
        break label1465;
      }
    }
    boolean bool7 = false;
    label1465:
    if (bool3)
    {
      i5 = this.H;
      if ((i5 == 1) || (i5 == -1))
      {
        bool6 = true;
        break label1497;
      }
    }
    boolean bool6 = false;
    label1497:
    localObject2 = this.b0[0];
    Object localObject10 = b.b;
    if ((localObject2 == localObject10) && ((this instanceof f))) {
      bool8 = true;
    } else {
      bool8 = false;
    }
    if (bool8) {
      i2 = 0;
    }
    boolean bool10 = this.X.o() ^ true;
    localObject2 = this.a0;
    int i11 = localObject2[0];
    int i10 = localObject2[1];
    d locald1;
    if ((this.t != 2) && (!this.p))
    {
      if (paramBoolean)
      {
        localObject2 = this.e;
        if (localObject2 != null)
        {
          localObject3 = ((p)localObject2).h;
          if ((((l0.f)localObject3).j) && (((p)localObject2).i.j))
          {
            if (paramBoolean)
            {
              paramd.f((i)localObject1, ((l0.f)localObject3).g);
              paramd.f((i)localObject4, this.e.i.g);
              if ((this.c0 != null) && (bool2) && (this.g[0] != 0) && (!k0())) {
                paramd.h(paramd.q(this.c0.S), (i)localObject4, 0, 8);
              }
              break label1912;
            }
            break label1912;
          }
        }
      }
      localObject2 = this.c0;
      if (localObject2 != null) {
        localObject2 = paramd.q(((e)localObject2).S);
      } else {
        localObject2 = null;
      }
      localObject3 = this.c0;
      if (localObject3 != null) {
        localObject3 = paramd.q(((e)localObject3).Q);
      } else {
        localObject3 = null;
      }
      int i12 = this.g[0];
      localObject8 = this.b0;
      localObject9 = localObject8[0];
      locald1 = this.Q;
      d locald2 = this.S;
      i5 = this.h0;
      i6 = this.o0;
      i7 = this.J[0];
      f1 = this.q0;
      boolean bool9;
      if (localObject8[1] == localb) {
        bool9 = true;
      } else {
        bool9 = false;
      }
      i(paramd, true, bool2, bool1, i12, (i)localObject3, (i)localObject2, (b)localObject9, bool8, locald1, locald2, i5, i2, i6, i7, f1, bool7, bool9, bool5, bool4, i11, i4, i3, this.z, this.A, this.B, bool10);
    }
    label1912:
    localObject3 = localObject7;
    boolean bool8 = bool1;
    localObject2 = localObject4;
    if (paramBoolean)
    {
      localObject4 = this;
      localObject7 = ((e)localObject4).f;
      if (localObject7 != null)
      {
        localObject8 = ((p)localObject7).h;
        if ((((l0.f)localObject8).j) && (((p)localObject7).i.j))
        {
          i2 = ((l0.f)localObject8).g;
          localObject7 = paramd;
          ((h0.d)localObject7).f((i)localObject5, i2);
          i2 = ((e)localObject4).f.i.g;
          localObject8 = localObject3;
          ((h0.d)localObject7).f((i)localObject8, i2);
          ((h0.d)localObject7).f((i)localObject6, ((e)localObject4).f.k.g);
          localObject9 = ((e)localObject4).c0;
          if ((localObject9 != null) && (!bool4) && (bool8)) {
            if (localObject4.g[1] != 0) {
              ((h0.d)localObject7).h(((h0.d)localObject7).q(((e)localObject9).T), (i)localObject8, 0, 8);
            } else {}
          }
          i2 = 0;
          break label2102;
        }
      }
    }
    i2 = 1;
    label2102:
    localObject7 = this;
    Object localObject8 = paramd;
    localObject4 = localObject3;
    Object localObject9 = localObject6;
    if (((e)localObject7).u == 2) {
      i2 = 0;
    }
    if ((i2 != 0) && (!((e)localObject7).q))
    {
      if ((localObject7.b0[1] == localObject10) && ((localObject7 instanceof f))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (paramBoolean) {
        i1 = 0;
      }
      localObject3 = ((e)localObject7).c0;
      if (localObject3 != null) {
        localObject3 = ((h0.d)localObject8).q(((e)localObject3).T);
      } else {
        localObject3 = null;
      }
      localObject6 = ((e)localObject7).c0;
      if (localObject6 != null) {
        localObject6 = ((h0.d)localObject8).q(((e)localObject6).R);
      } else {
        localObject6 = null;
      }
      if ((((e)localObject7).n0 > 0) || (((e)localObject7).u0 == 8))
      {
        localObject10 = ((e)localObject7).U;
        if (((d)localObject10).f != null)
        {
          ((h0.d)localObject8).e((i)localObject9, (i)localObject5, r(), 8);
          ((h0.d)localObject8).e((i)localObject9, ((h0.d)localObject8).q(((e)localObject7).U.f), ((e)localObject7).U.f(), 8);
          if (bool8) {
            ((h0.d)localObject8).h((i)localObject3, ((h0.d)localObject8).q(((e)localObject7).T), 0, 5);
          }
          bool1 = false;
        }
        else
        {
          if (((e)localObject7).u0 == 8) {
            i2 = ((d)localObject10).f();
          } else {
            i2 = r();
          }
          ((h0.d)localObject8).e((i)localObject9, (i)localObject5, i2, 8);
        }
      }
      else
      {
        bool1 = bool10;
      }
      int i9 = localObject7.g[1];
      localObject8 = ((e)localObject7).b0;
      localObject9 = localObject8[1];
      localObject10 = ((e)localObject7).R;
      locald1 = ((e)localObject7).T;
      i2 = ((e)localObject7).i0;
      i5 = ((e)localObject7).p0;
      i6 = localObject7.J[1];
      f1 = ((e)localObject7).r0;
      if (localObject8[0] == localb) {
        bool7 = true;
      } else {
        bool7 = false;
      }
      i(paramd, false, bool8, bool2, i9, (i)localObject6, (i)localObject3, (b)localObject9, paramBoolean, (d)localObject10, locald1, i2, i1, i5, i6, f1, bool6, bool7, bool4, bool5, i10, i3, i4, ((e)localObject7).C, ((e)localObject7).D, ((e)localObject7).E, bool1);
    }
    localObject3 = localObject5;
    if (bool3)
    {
      localObject5 = this;
      i1 = ((e)localObject5).H;
      f1 = ((e)localObject5).I;
      if (i1 == 1)
      {
        localObject5 = localObject2;
        localObject6 = localObject1;
      }
      else
      {
        localObject6 = localObject3;
        localObject5 = localObject4;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      paramd.k((i)localObject4, (i)localObject3, (i)localObject5, (i)localObject6, f1, 8);
    }
    localObject1 = this;
    if (((e)localObject1).X.o()) {
      paramd.b((e)localObject1, ((e)localObject1).X.j().h(), (float)Math.toRadians(((e)localObject1).K + 90.0F), ((e)localObject1).X.f());
    }
    ((e)localObject1).p = false;
    ((e)localObject1).q = false;
  }
  
  public void g0(d.b paramb1, e parame, d.b paramb2, int paramInt1, int paramInt2)
  {
    q(paramb1).b(parame.q(paramb2), paramInt1, paramInt2, true);
  }
  
  public void g1(e parame)
  {
    this.c0 = parame;
  }
  
  public boolean h()
  {
    return this.u0 != 8;
  }
  
  public void h1(float paramFloat)
  {
    this.r0 = paramFloat;
  }
  
  public boolean i0()
  {
    return this.r;
  }
  
  public void i1(int paramInt)
  {
    this.K0 = paramInt;
  }
  
  public void j(d.b paramb1, e parame, d.b paramb2)
  {
    k(paramb1, parame, paramb2, 0);
  }
  
  public boolean j0(int paramInt)
  {
    return this.a0[paramInt];
  }
  
  public void j1(int paramInt1, int paramInt2)
  {
    this.i0 = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    this.e0 = paramInt1;
    paramInt2 = this.p0;
    if (paramInt1 < paramInt2) {
      this.e0 = paramInt2;
    }
  }
  
  public void k(d.b paramb1, e parame, d.b paramb2, int paramInt)
  {
    d.b localb1 = d.b.g;
    Object localObject1;
    Object localObject2;
    d.b localb2;
    if (paramb1 == localb1)
    {
      paramb1 = d.b.b;
      if (paramb2 == localb1)
      {
        paramb2 = q(paramb1);
        localObject1 = d.b.d;
        localObject2 = q((d.b)localObject1);
        localb2 = d.b.c;
        d locald1 = q(localb2);
        d.b localb3 = d.b.e;
        d locald2 = q(localb3);
        int i1 = 1;
        if (((paramb2 != null) && (paramb2.o())) || ((localObject2 != null) && (((d)localObject2).o())))
        {
          paramInt = 0;
        }
        else
        {
          k(paramb1, parame, paramb1, 0);
          k((d.b)localObject1, parame, (d.b)localObject1, 0);
          paramInt = 1;
        }
        if (((locald1 != null) && (locald1.o())) || ((locald2 != null) && (locald2.o())))
        {
          i1 = 0;
        }
        else
        {
          k(localb2, parame, localb2, 0);
          k(localb3, parame, localb3, 0);
        }
        if ((paramInt != 0) && (i1 != 0))
        {
          paramb1 = q(localb1);
          parame = parame.q(localb1);
          break label395;
        }
        if (paramInt != 0) {}
        for (paramb1 = d.b.h;; paramb1 = d.b.i)
        {
          q(paramb1).a(parame.q(paramb1), 0);
          return;
          if (i1 == 0) {
            break;
          }
        }
      }
      if ((paramb2 != paramb1) && (paramb2 != d.b.d))
      {
        paramb1 = d.b.c;
        if ((paramb2 != paramb1) && (paramb2 != d.b.e)) {
          break label810;
        }
        k(paramb1, parame, paramb2, 0);
        k(d.b.e, parame, paramb2, 0);
      }
      else
      {
        k(paramb1, parame, paramb2, 0);
        paramb1 = d.b.d;
      }
    }
    try
    {
      k(paramb1, parame, paramb2, 0);
      paramb1 = q(localb1);
      for (;;)
      {
        parame = parame.q(paramb2);
        break label395;
        localObject2 = d.b.h;
        if (paramb1 == localObject2)
        {
          localObject1 = d.b.b;
          if ((paramb2 == localObject1) || (paramb2 == d.b.d))
          {
            paramb1 = q((d.b)localObject1);
            parame = parame.q(paramb2);
            paramb2 = q(d.b.d);
            paramb1.a(parame, 0);
            paramb2.a(parame, 0);
            paramb1 = q((d.b)localObject2);
            label395:
            paramb1.a(parame, 0);
            return;
          }
        }
        localb2 = d.b.i;
        if (paramb1 == localb2)
        {
          localObject1 = d.b.c;
          if ((paramb2 == localObject1) || (paramb2 == d.b.e))
          {
            paramb1 = parame.q(paramb2);
            q((d.b)localObject1).a(paramb1, 0);
            q(d.b.e).a(paramb1, 0);
            q(localb2).a(paramb1, 0);
            return;
          }
        }
        if ((paramb1 == localObject2) && (paramb2 == localObject2))
        {
          paramb1 = d.b.b;
          q(paramb1).a(parame.q(paramb1), 0);
          paramb1 = d.b.d;
          q(paramb1).a(parame.q(paramb1), 0);
          paramb1 = q((d.b)localObject2);
        }
        else
        {
          if ((paramb1 != localb2) || (paramb2 != localb2)) {
            break;
          }
          paramb1 = d.b.c;
          q(paramb1).a(parame.q(paramb1), 0);
          paramb1 = d.b.e;
          q(paramb1).a(parame.q(paramb1), 0);
          paramb1 = q(localb2);
        }
      }
      localObject1 = q(paramb1);
      paramb2 = parame.q(paramb2);
      if (((d)localObject1).p(paramb2))
      {
        parame = d.b.f;
        if (paramb1 == parame)
        {
          parame = q(d.b.c);
          paramb1 = q(d.b.e);
          if (parame != null) {
            parame.q();
          }
          if (paramb1 == null) {
            break label801;
          }
        }
        else
        {
          if ((paramb1 == d.b.c) || (paramb1 == d.b.e)) {
            break label742;
          }
          if ((paramb1 != d.b.b) && (paramb1 != d.b.d)) {
            break label801;
          }
          parame = q(localb1);
          if (parame.j() != paramb2) {
            parame.q();
          }
          parame = q(paramb1).g();
          paramb1 = q((d.b)localObject2);
          if (!paramb1.o()) {
            break label801;
          }
        }
        label742:
        do
        {
          parame.q();
          paramb1.q();
          break;
          parame = q(parame);
          if (parame != null) {
            parame.q();
          }
          parame = q(localb1);
          if (parame.j() != paramb2) {
            parame.q();
          }
          parame = q(paramb1).g();
          paramb1 = q(localb2);
        } while (paramb1.o());
        label801:
        ((d)localObject1).a(paramb2, paramInt);
      }
      label810:
      return;
    }
    finally {}
  }
  
  public boolean k0()
  {
    d locald1 = this.Q;
    d locald2 = locald1.f;
    if ((locald2 == null) || (locald2.f != locald1))
    {
      locald1 = this.S;
      locald2 = locald1.f;
    }
    return (locald2 != null) && (locald2.f == locald1);
  }
  
  public void k1(b paramb)
  {
    this.b0[1] = paramb;
  }
  
  public void l(d paramd1, d paramd2, int paramInt)
  {
    if (paramd1.h() == this) {
      k(paramd1.k(), paramd2.h(), paramd2.k(), paramInt);
    }
  }
  
  public boolean l0()
  {
    return this.M;
  }
  
  public void l1(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.x = paramInt1;
    this.C = paramInt2;
    paramInt2 = paramInt3;
    if (paramInt3 == 2147483647) {
      paramInt2 = 0;
    }
    this.D = paramInt2;
    this.E = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (paramInt1 == 0)) {
      this.x = 2;
    }
  }
  
  public void m(e parame, float paramFloat, int paramInt)
  {
    d.b localb = d.b.g;
    g0(localb, parame, localb, paramInt, 0);
    this.K = paramFloat;
  }
  
  public boolean m0()
  {
    d locald1 = this.R;
    d locald2 = locald1.f;
    if ((locald2 == null) || (locald2.f != locald1))
    {
      locald1 = this.T;
      locald2 = locald1.f;
    }
    return (locald2 != null) && (locald2.f == locald1);
  }
  
  public void m1(float paramFloat)
  {
    this.N0[1] = paramFloat;
  }
  
  public void n(e parame, HashMap<e, e> paramHashMap)
  {
    this.t = parame.t;
    this.u = parame.u;
    this.w = parame.w;
    this.x = parame.x;
    Object localObject1 = this.y;
    int[] arrayOfInt = parame.y;
    localObject1[0] = arrayOfInt[0];
    localObject1[1] = arrayOfInt[1];
    this.z = parame.z;
    this.A = parame.A;
    this.C = parame.C;
    this.D = parame.D;
    this.E = parame.E;
    this.F = parame.F;
    this.G = parame.G;
    this.H = parame.H;
    this.I = parame.I;
    localObject1 = parame.J;
    this.J = Arrays.copyOf((int[])localObject1, localObject1.length);
    this.K = parame.K;
    this.L = parame.L;
    this.M = parame.M;
    this.Q.q();
    this.R.q();
    this.S.q();
    this.T.q();
    this.U.q();
    this.V.q();
    this.W.q();
    this.X.q();
    this.b0 = ((b[])Arrays.copyOf(this.b0, 2));
    localObject1 = this.c0;
    arrayOfInt = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (e)paramHashMap.get(parame.c0);
    }
    this.c0 = ((e)localObject1);
    this.d0 = parame.d0;
    this.e0 = parame.e0;
    this.f0 = parame.f0;
    this.g0 = parame.g0;
    this.h0 = parame.h0;
    this.i0 = parame.i0;
    this.j0 = parame.j0;
    this.k0 = parame.k0;
    this.l0 = parame.l0;
    this.m0 = parame.m0;
    this.n0 = parame.n0;
    this.o0 = parame.o0;
    this.p0 = parame.p0;
    this.q0 = parame.q0;
    this.r0 = parame.r0;
    this.s0 = parame.s0;
    this.t0 = parame.t0;
    this.u0 = parame.u0;
    this.v0 = parame.v0;
    this.w0 = parame.w0;
    this.x0 = parame.x0;
    this.y0 = parame.y0;
    this.z0 = parame.z0;
    this.A0 = parame.A0;
    this.B0 = parame.B0;
    this.C0 = parame.C0;
    this.D0 = parame.D0;
    this.E0 = parame.E0;
    this.F0 = parame.F0;
    this.G0 = parame.G0;
    this.H0 = parame.H0;
    this.J0 = parame.J0;
    this.K0 = parame.K0;
    this.L0 = parame.L0;
    this.M0 = parame.M0;
    localObject1 = this.N0;
    Object localObject2 = parame.N0;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = this.O0;
    localObject2 = parame.O0;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = this.P0;
    localObject2 = parame.P0;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = parame.Q0;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (e)paramHashMap.get(localObject1);
    }
    this.Q0 = ((e)localObject1);
    parame = parame.R0;
    if (parame == null) {
      parame = arrayOfInt;
    } else {
      parame = (e)paramHashMap.get(parame);
    }
    this.R0 = parame;
  }
  
  public boolean n0()
  {
    return this.N;
  }
  
  public void n1(int paramInt)
  {
    this.u0 = paramInt;
  }
  
  public void o(h0.d paramd)
  {
    paramd.q(this.Q);
    paramd.q(this.R);
    paramd.q(this.S);
    paramd.q(this.T);
    if (this.n0 > 0) {
      paramd.q(this.U);
    }
  }
  
  public boolean o0()
  {
    return (this.i) && (this.u0 != 8);
  }
  
  public void o1(int paramInt)
  {
    this.d0 = paramInt;
    int i1 = this.o0;
    if (paramInt < i1) {
      this.d0 = i1;
    }
  }
  
  public void p()
  {
    if (this.e == null) {
      this.e = new l(this);
    }
    if (this.f == null) {
      this.f = new n(this);
    }
  }
  
  public boolean p0()
  {
    return (this.p) || ((this.Q.n()) && (this.S.n()));
  }
  
  public void p1(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3)) {
      this.v = paramInt;
    }
  }
  
  public d q(d.b paramb)
  {
    switch (a.a[paramb.ordinal()])
    {
    default: 
      throw new AssertionError(paramb.name());
    case 9: 
      return null;
    case 8: 
      return this.W;
    case 7: 
      return this.V;
    case 6: 
      return this.X;
    case 5: 
      return this.U;
    case 4: 
      return this.T;
    case 3: 
      return this.S;
    case 2: 
      return this.R;
    }
    return this.Q;
  }
  
  public boolean q0()
  {
    return (this.q) || ((this.R.n()) && (this.T.n()));
  }
  
  public void q1(int paramInt)
  {
    this.h0 = paramInt;
  }
  
  public int r()
  {
    return this.n0;
  }
  
  public boolean r0()
  {
    return this.s;
  }
  
  public void r1(int paramInt)
  {
    this.i0 = paramInt;
  }
  
  public float s(int paramInt)
  {
    if (paramInt == 0) {
      return this.q0;
    }
    if (paramInt == 1) {
      return this.r0;
    }
    return -1.0F;
  }
  
  public void s0()
  {
    this.r = true;
  }
  
  public void s1(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.H == -1) {
      if ((paramBoolean3) && (!paramBoolean4))
      {
        this.H = 0;
      }
      else if ((!paramBoolean3) && (paramBoolean4))
      {
        this.H = 1;
        if (this.g0 == -1) {
          this.I = (1.0F / this.I);
        }
      }
    }
    if ((this.H == 0) && ((!this.R.o()) || (!this.T.o()))) {
      this.H = 1;
    } else if ((this.H == 1) && ((!this.Q.o()) || (!this.S.o()))) {
      this.H = 0;
    }
    if ((this.H == -1) && ((!this.R.o()) || (!this.T.o()) || (!this.Q.o()) || (!this.S.o()))) {
      if ((this.R.o()) && (this.T.o()))
      {
        this.H = 0;
      }
      else if ((this.Q.o()) && (this.S.o()))
      {
        this.I = (1.0F / this.I);
        this.H = 1;
      }
    }
    if (this.H == -1)
    {
      int i1 = this.z;
      if ((i1 > 0) && (this.C == 0))
      {
        this.H = 0;
        return;
      }
      if ((i1 == 0) && (this.C > 0))
      {
        this.I = (1.0F / this.I);
        this.H = 1;
      }
    }
  }
  
  public int t()
  {
    return a0() + this.e0;
  }
  
  public void t0()
  {
    this.s = true;
  }
  
  public void t1(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = paramBoolean1 & this.e.k();
    boolean bool1 = paramBoolean2 & this.f.k();
    l locall = this.e;
    int i1 = locall.h.g;
    n localn = this.f;
    int i3 = localn.h.g;
    int i4 = locall.i.g;
    int i5 = localn.i.g;
    int i2;
    if ((i4 - i1 >= 0) && (i5 - i3 >= 0) && (i1 != -2147483648) && (i1 != 2147483647) && (i3 != -2147483648) && (i3 != 2147483647) && (i4 != -2147483648) && (i4 != 2147483647) && (i5 != -2147483648))
    {
      i2 = i5;
      if (i5 != 2147483647) {}
    }
    else
    {
      i4 = 0;
      i1 = i4;
      i2 = i1;
      i3 = i2;
    }
    i4 -= i1;
    i2 -= i3;
    if (bool2) {
      this.h0 = i1;
    }
    if (bool1) {
      this.i0 = i3;
    }
    if (this.u0 == 8)
    {
      this.d0 = 0;
      this.e0 = 0;
      return;
    }
    if (bool2)
    {
      i1 = i4;
      if (this.b0[0] == b.a)
      {
        i3 = this.d0;
        i1 = i4;
        if (i4 < i3) {
          i1 = i3;
        }
      }
      this.d0 = i1;
      i3 = this.o0;
      if (i1 < i3) {
        this.d0 = i3;
      }
    }
    if (bool1)
    {
      i1 = i2;
      if (this.b0[1] == b.a)
      {
        i3 = this.e0;
        i1 = i2;
        if (i2 < i3) {
          i1 = i3;
        }
      }
      this.e0 = i1;
      i2 = this.p0;
      if (i1 < i2) {
        this.e0 = i2;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.x0;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: ");
      ((StringBuilder)localObject).append(this.x0);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (this.w0 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id: ");
      ((StringBuilder)localObject).append(this.w0);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(this.h0);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.i0);
    localStringBuilder.append(") - (");
    localStringBuilder.append(this.d0);
    localStringBuilder.append(" x ");
    localStringBuilder.append(this.e0);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public Object u()
  {
    return this.s0;
  }
  
  public boolean u0()
  {
    b[] arrayOfb = this.b0;
    boolean bool2 = false;
    b localb1 = arrayOfb[0];
    b localb2 = b.c;
    boolean bool1 = bool2;
    if (localb1 == localb2)
    {
      bool1 = bool2;
      if (arrayOfb[1] == localb2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void u1(h0.d paramd, boolean paramBoolean)
  {
    int i2 = paramd.x(this.Q);
    int i5 = paramd.x(this.R);
    int i4 = paramd.x(this.S);
    int i6 = paramd.x(this.T);
    int i3 = i2;
    int i1 = i4;
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.e;
      i3 = i2;
      i1 = i4;
      if (localObject != null)
      {
        paramd = ((p)localObject).h;
        i3 = i2;
        i1 = i4;
        if (paramd.j)
        {
          localObject = ((p)localObject).i;
          i3 = i2;
          i1 = i4;
          if (((l0.f)localObject).j)
          {
            i3 = paramd.g;
            i1 = ((l0.f)localObject).g;
          }
        }
      }
    }
    i4 = i5;
    i2 = i6;
    if (paramBoolean)
    {
      localObject = this.f;
      i4 = i5;
      i2 = i6;
      if (localObject != null)
      {
        paramd = ((p)localObject).h;
        i4 = i5;
        i2 = i6;
        if (paramd.j)
        {
          localObject = ((p)localObject).i;
          i4 = i5;
          i2 = i6;
          if (((l0.f)localObject).j)
          {
            i4 = paramd.g;
            i2 = ((l0.f)localObject).g;
          }
        }
      }
    }
    if ((i1 - i3 >= 0) && (i2 - i4 >= 0) && (i3 != -2147483648) && (i3 != 2147483647) && (i4 != -2147483648) && (i4 != 2147483647) && (i1 != -2147483648) && (i1 != 2147483647) && (i2 != -2147483648))
    {
      i5 = i3;
      i6 = i1;
      i3 = i2;
      if (i2 != 2147483647) {}
    }
    else
    {
      i3 = 0;
      i1 = i3;
      i2 = i1;
      i6 = i2;
      i4 = i2;
      i5 = i1;
    }
    N0(i5, i4, i6, i3);
  }
  
  public String v()
  {
    return this.w0;
  }
  
  public void v0()
  {
    this.Q.q();
    this.R.q();
    this.S.q();
    this.T.q();
    this.U.q();
    this.V.q();
    this.W.q();
    this.X.q();
    this.c0 = null;
    this.K = 0.0F;
    this.d0 = 0;
    this.e0 = 0;
    this.f0 = 0.0F;
    this.g0 = -1;
    this.h0 = 0;
    this.i0 = 0;
    this.l0 = 0;
    this.m0 = 0;
    this.n0 = 0;
    this.o0 = 0;
    this.p0 = 0;
    float f1 = U0;
    this.q0 = f1;
    this.r0 = f1;
    Object localObject = this.b0;
    b localb = b.a;
    localObject[0] = localb;
    localObject[1] = localb;
    this.s0 = null;
    this.t0 = 0;
    this.u0 = 0;
    this.x0 = null;
    this.G0 = false;
    this.H0 = false;
    this.J0 = 0;
    this.K0 = 0;
    this.L0 = false;
    this.M0 = false;
    localObject = this.N0;
    localObject[0] = -1.0F;
    localObject[1] = -1.0F;
    this.t = -1;
    this.u = -1;
    localObject = this.J;
    localObject[0] = 2147483647;
    localObject[1] = 2147483647;
    this.w = 0;
    this.x = 0;
    this.B = 1.0F;
    this.E = 1.0F;
    this.A = 2147483647;
    this.D = 2147483647;
    this.z = 0;
    this.C = 0;
    this.h = false;
    this.H = -1;
    this.I = 1.0F;
    this.I0 = false;
    localObject = this.g;
    localObject[0] = 1;
    localObject[1] = 1;
    this.N = false;
    localObject = this.a0;
    localObject[0] = 0;
    localObject[1] = 0;
    this.i = true;
    localObject = this.y;
    localObject[0] = 0;
    localObject[1] = 0;
    this.l = -1;
    this.m = -1;
  }
  
  public b w(int paramInt)
  {
    if (paramInt == 0) {
      return C();
    }
    if (paramInt == 1) {
      return V();
    }
    return null;
  }
  
  public void w0()
  {
    x0();
    h1(U0);
    Q0(U0);
  }
  
  public float x()
  {
    return this.f0;
  }
  
  public void x0()
  {
    e locale = M();
    if ((locale != null) && ((locale instanceof f)) && (((f)M()).P1())) {
      return;
    }
    int i1 = 0;
    int i2 = this.Z.size();
    while (i1 < i2)
    {
      ((d)this.Z.get(i1)).q();
      i1 += 1;
    }
  }
  
  public int y()
  {
    return this.g0;
  }
  
  public void y0()
  {
    int i1 = 0;
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = false;
    int i2 = this.Z.size();
    while (i1 < i2)
    {
      ((d)this.Z.get(i1)).r();
      i1 += 1;
    }
  }
  
  public int z()
  {
    if (this.u0 == 8) {
      return 0;
    }
    return this.e0;
  }
  
  public void z0(h0.c paramc)
  {
    this.Q.s(paramc);
    this.R.s(paramc);
    this.S.s(paramc);
    this.T.s(paramc);
    this.U.s(paramc);
    this.X.s(paramc);
    this.V.s(paramc);
    this.W.s(paramc);
  }
  
  public static enum b
  {
    static
    {
      b localb1 = new b("FIXED", 0);
      a = localb1;
      b localb2 = new b("WRAP_CONTENT", 1);
      b = localb2;
      b localb3 = new b("MATCH_CONSTRAINT", 2);
      c = localb3;
      b localb4 = new b("MATCH_PARENT", 3);
      d = localb4;
      e = new b[] { localb1, localb2, localb3, localb4 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.e
 * JD-Core Version:    0.7.0.1
 */