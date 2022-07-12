package i0;

import java.util.Arrays;

public class a
  extends b
{
  private final double[] a;
  a[] b;
  private boolean c = true;
  
  public a(int[] paramArrayOfInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    this.a = paramArrayOfDouble;
    this.b = new a[paramArrayOfDouble.length - 1];
    int k = 1;
    int i = k;
    int m;
    for (int j = 0;; j = m)
    {
      a[] arrayOfa = this.b;
      if (j >= arrayOfa.length) {
        break;
      }
      m = paramArrayOfInt[j];
      if (m != 0)
      {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3) {
              break label114;
            }
            if (k != 1) {}
          }
          else
          {
            i = 2;
            break label96;
          }
        }
        i = 1;
        label96:
        m = i;
        k = i;
        i = m;
      }
      else
      {
        i = 3;
      }
      label114:
      double d = paramArrayOfDouble[j];
      m = j + 1;
      arrayOfa[j] = new a(i, d, paramArrayOfDouble[m], paramArrayOfDouble1[j][0], paramArrayOfDouble1[j][1], paramArrayOfDouble1[m][0], paramArrayOfDouble1[m][1]);
    }
  }
  
  public double c(double paramDouble, int paramInt)
  {
    boolean bool = this.c;
    int j = 0;
    double d1;
    int i;
    if (bool)
    {
      arrayOfa = this.b;
      double d3;
      double d2;
      if (paramDouble < arrayOfa[0].c)
      {
        d3 = arrayOfa[0].c;
        d2 = paramDouble - arrayOfa[0].c;
        if (arrayOfa[0].r) {
          if (paramInt == 0)
          {
            d1 = arrayOfa[0].f(d3);
            paramDouble = this.b[0].d(d3);
          }
        }
      }
      for (;;)
      {
        return d1 + d2 * paramDouble;
        d1 = arrayOfa[0].g(d3);
        paramDouble = this.b[0].e(d3);
        continue;
        arrayOfa[0].k(d3);
        if (paramInt == 0) {
          d1 = this.b[0].h();
        }
        for (paramDouble = this.b[0].b();; paramDouble = this.b[0].c())
        {
          return d1 + d2 * paramDouble;
          d1 = this.b[0].i();
        }
        i = j;
        d1 = paramDouble;
        if (paramDouble <= arrayOfa[(arrayOfa.length - 1)].d) {
          break;
        }
        d3 = arrayOfa[(arrayOfa.length - 1)].d;
        d2 = paramDouble - d3;
        i = arrayOfa.length - 1;
        if (paramInt == 0)
        {
          d1 = arrayOfa[i].f(d3);
          paramDouble = this.b[i].d(d3);
        }
        else
        {
          d1 = arrayOfa[i].g(d3);
          paramDouble = this.b[i].e(d3);
        }
      }
    }
    a[] arrayOfa = this.b;
    if (paramDouble < arrayOfa[0].c)
    {
      d1 = arrayOfa[0].c;
      i = j;
    }
    else
    {
      i = j;
      d1 = paramDouble;
      if (paramDouble > arrayOfa[(arrayOfa.length - 1)].d)
      {
        d1 = arrayOfa[(arrayOfa.length - 1)].d;
        i = j;
      }
    }
    for (;;)
    {
      arrayOfa = this.b;
      if (i >= arrayOfa.length) {
        break;
      }
      if (d1 <= arrayOfa[i].d)
      {
        if (arrayOfa[i].r)
        {
          if (paramInt == 0) {
            return arrayOfa[i].f(d1);
          }
          return arrayOfa[i].g(d1);
        }
        arrayOfa[i].k(d1);
        arrayOfa = this.b;
        if (paramInt == 0) {
          return arrayOfa[i].h();
        }
        return arrayOfa[i].i();
      }
      i += 1;
    }
    return (0.0D / 0.0D);
  }
  
  public void d(double paramDouble, double[] paramArrayOfDouble)
  {
    a[] arrayOfa;
    double d1;
    double d2;
    if (this.c)
    {
      arrayOfa = this.b;
      if (paramDouble < arrayOfa[0].c)
      {
        d1 = arrayOfa[0].c;
        paramDouble -= arrayOfa[0].c;
        if (arrayOfa[0].r)
        {
          paramArrayOfDouble[0] = (arrayOfa[0].f(d1) + this.b[0].d(d1) * paramDouble);
          paramArrayOfDouble[1] = (this.b[0].g(d1) + paramDouble * this.b[0].e(d1));
          return;
        }
        arrayOfa[0].k(d1);
        paramArrayOfDouble[0] = (this.b[0].h() + this.b[0].b() * paramDouble);
        paramArrayOfDouble[1] = (this.b[0].i() + paramDouble * this.b[0].c());
        return;
      }
      d2 = paramDouble;
      if (paramDouble > arrayOfa[(arrayOfa.length - 1)].d)
      {
        d1 = arrayOfa[(arrayOfa.length - 1)].d;
        d2 = paramDouble - d1;
        i = arrayOfa.length - 1;
        if (arrayOfa[i].r)
        {
          paramArrayOfDouble[0] = (arrayOfa[i].f(d1) + this.b[i].d(d1) * d2);
          paramArrayOfDouble[1] = (this.b[i].g(d1) + d2 * this.b[i].e(d1));
          return;
        }
        arrayOfa[i].k(paramDouble);
        paramArrayOfDouble[0] = (this.b[i].h() + this.b[i].b() * d2);
        paramArrayOfDouble[1] = (this.b[i].i() + d2 * this.b[i].c());
      }
    }
    else
    {
      arrayOfa = this.b;
      d1 = paramDouble;
      if (paramDouble < arrayOfa[0].c) {
        d1 = arrayOfa[0].c;
      }
      d2 = d1;
      if (d1 > arrayOfa[(arrayOfa.length - 1)].d) {
        d2 = arrayOfa[(arrayOfa.length - 1)].d;
      }
    }
    int i = 0;
    for (;;)
    {
      arrayOfa = this.b;
      if (i >= arrayOfa.length) {
        break;
      }
      if (d2 <= arrayOfa[i].d)
      {
        if (arrayOfa[i].r)
        {
          paramArrayOfDouble[0] = arrayOfa[i].f(d2);
          paramArrayOfDouble[1] = this.b[i].g(d2);
          return;
        }
        arrayOfa[i].k(d2);
        paramArrayOfDouble[0] = this.b[i].h();
        paramArrayOfDouble[1] = this.b[i].i();
        return;
      }
      i += 1;
    }
  }
  
  public void e(double paramDouble, float[] paramArrayOfFloat)
  {
    a[] arrayOfa;
    double d1;
    if (this.c)
    {
      arrayOfa = this.b;
      if (paramDouble < arrayOfa[0].c)
      {
        d1 = arrayOfa[0].c;
        paramDouble -= arrayOfa[0].c;
        if (arrayOfa[0].r)
        {
          paramArrayOfFloat[0] = ((float)(arrayOfa[0].f(d1) + this.b[0].d(d1) * paramDouble));
          paramArrayOfFloat[1] = ((float)(this.b[0].g(d1) + paramDouble * this.b[0].e(d1)));
          return;
        }
        arrayOfa[0].k(d1);
        paramArrayOfFloat[0] = ((float)(this.b[0].h() + this.b[0].b() * paramDouble));
        paramArrayOfFloat[1] = ((float)(this.b[0].i() + paramDouble * this.b[0].c()));
        return;
      }
      d1 = paramDouble;
      if (paramDouble > arrayOfa[(arrayOfa.length - 1)].d)
      {
        d1 = arrayOfa[(arrayOfa.length - 1)].d;
        double d2 = paramDouble - d1;
        i = arrayOfa.length - 1;
        if (arrayOfa[i].r)
        {
          paramArrayOfFloat[0] = ((float)(arrayOfa[i].f(d1) + this.b[i].d(d1) * d2));
          paramArrayOfFloat[1] = ((float)(this.b[i].g(d1) + d2 * this.b[i].e(d1)));
          return;
        }
        arrayOfa[i].k(paramDouble);
        paramArrayOfFloat[0] = ((float)this.b[i].h());
        paramArrayOfFloat[1] = ((float)this.b[i].i());
      }
    }
    else
    {
      arrayOfa = this.b;
      if (paramDouble < arrayOfa[0].c)
      {
        d1 = arrayOfa[0].c;
      }
      else
      {
        d1 = paramDouble;
        if (paramDouble > arrayOfa[(arrayOfa.length - 1)].d) {
          d1 = arrayOfa[(arrayOfa.length - 1)].d;
        }
      }
    }
    int i = 0;
    for (;;)
    {
      arrayOfa = this.b;
      if (i >= arrayOfa.length) {
        break;
      }
      if (d1 <= arrayOfa[i].d)
      {
        if (arrayOfa[i].r)
        {
          paramArrayOfFloat[0] = ((float)arrayOfa[i].f(d1));
          paramArrayOfFloat[1] = ((float)this.b[i].g(d1));
          return;
        }
        arrayOfa[i].k(d1);
        paramArrayOfFloat[0] = ((float)this.b[i].h());
        paramArrayOfFloat[1] = ((float)this.b[i].i());
        return;
      }
      i += 1;
    }
  }
  
  public double f(double paramDouble, int paramInt)
  {
    a[] arrayOfa = this.b;
    int j = 0;
    double d = paramDouble;
    if (paramDouble < arrayOfa[0].c) {
      d = arrayOfa[0].c;
    }
    int i = j;
    paramDouble = d;
    if (d > arrayOfa[(arrayOfa.length - 1)].d)
    {
      paramDouble = arrayOfa[(arrayOfa.length - 1)].d;
      i = j;
    }
    for (;;)
    {
      arrayOfa = this.b;
      if (i >= arrayOfa.length) {
        break;
      }
      if (paramDouble <= arrayOfa[i].d)
      {
        if (arrayOfa[i].r)
        {
          if (paramInt == 0) {
            return arrayOfa[i].d(paramDouble);
          }
          return arrayOfa[i].e(paramDouble);
        }
        arrayOfa[i].k(paramDouble);
        arrayOfa = this.b;
        if (paramInt == 0) {
          return arrayOfa[i].b();
        }
        return arrayOfa[i].c();
      }
      i += 1;
    }
    return (0.0D / 0.0D);
  }
  
  public void g(double paramDouble, double[] paramArrayOfDouble)
  {
    a[] arrayOfa = this.b;
    double d;
    if (paramDouble < arrayOfa[0].c)
    {
      d = arrayOfa[0].c;
    }
    else
    {
      d = paramDouble;
      if (paramDouble > arrayOfa[(arrayOfa.length - 1)].d) {
        d = arrayOfa[(arrayOfa.length - 1)].d;
      }
    }
    int i = 0;
    for (;;)
    {
      arrayOfa = this.b;
      if (i >= arrayOfa.length) {
        break;
      }
      if (d <= arrayOfa[i].d)
      {
        if (arrayOfa[i].r)
        {
          paramArrayOfDouble[0] = arrayOfa[i].d(d);
          paramArrayOfDouble[1] = this.b[i].e(d);
          return;
        }
        arrayOfa[i].k(d);
        paramArrayOfDouble[0] = this.b[i].b();
        paramArrayOfDouble[1] = this.b[i].c();
        return;
      }
      i += 1;
    }
  }
  
  public double[] h()
  {
    return this.a;
  }
  
  private static class a
  {
    private static double[] s = new double[91];
    double[] a;
    double b;
    double c;
    double d;
    double e;
    double f;
    double g;
    double h;
    double i;
    double j;
    double k;
    double l;
    double m;
    double n;
    double o;
    double p;
    boolean q;
    boolean r;
    
    a(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      boolean bool = false;
      this.r = false;
      int i1 = 1;
      if (paramInt == 1) {
        bool = true;
      }
      this.q = bool;
      this.c = paramDouble1;
      this.d = paramDouble2;
      this.i = (1.0D / (paramDouble2 - paramDouble1));
      if (3 == paramInt) {
        this.r = true;
      }
      paramDouble1 = paramDouble5 - paramDouble3;
      paramDouble2 = paramDouble6 - paramDouble4;
      if ((!this.r) && (Math.abs(paramDouble1) >= 0.001D) && (Math.abs(paramDouble2) >= 0.001D))
      {
        this.a = new double[101];
        bool = this.q;
        if (bool) {
          paramInt = -1;
        } else {
          paramInt = 1;
        }
        this.j = (paramDouble1 * paramInt);
        if (bool) {
          paramInt = i1;
        } else {
          paramInt = -1;
        }
        this.k = (paramDouble2 * paramInt);
        if (bool) {
          paramDouble1 = paramDouble5;
        } else {
          paramDouble1 = paramDouble3;
        }
        this.l = paramDouble1;
        if (bool) {
          paramDouble1 = paramDouble4;
        } else {
          paramDouble1 = paramDouble6;
        }
        this.m = paramDouble1;
        a(paramDouble3, paramDouble4, paramDouble5, paramDouble6);
        this.n = (this.b * this.i);
        return;
      }
      this.r = true;
      this.e = paramDouble3;
      this.f = paramDouble5;
      this.g = paramDouble4;
      this.h = paramDouble6;
      paramDouble3 = Math.hypot(paramDouble2, paramDouble1);
      this.b = paramDouble3;
      this.n = (paramDouble3 * this.i);
      paramDouble3 = this.d;
      paramDouble4 = this.c;
      this.l = (paramDouble1 / (paramDouble3 - paramDouble4));
      this.m = (paramDouble2 / (paramDouble3 - paramDouble4));
    }
    
    private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      int i1 = 0;
      double d1 = 0.0D;
      double d2 = 0.0D;
      double d3 = 0.0D;
      double[] arrayOfDouble;
      for (;;)
      {
        arrayOfDouble = s;
        if (i1 >= arrayOfDouble.length) {
          break;
        }
        double d5 = Math.toRadians(i1 * 90.0D / (arrayOfDouble.length - 1));
        double d4 = Math.sin(d5);
        d5 = Math.cos(d5);
        d4 *= (paramDouble3 - paramDouble1);
        d5 *= (paramDouble2 - paramDouble4);
        if (i1 > 0)
        {
          d1 = Math.hypot(d4 - d2, d5 - d3) + d1;
          s[i1] = d1;
        }
        i1 += 1;
        d3 = d5;
        d2 = d4;
      }
      this.b = d1;
      i1 = 0;
      for (;;)
      {
        arrayOfDouble = s;
        if (i1 >= arrayOfDouble.length) {
          break;
        }
        arrayOfDouble[i1] /= d1;
        i1 += 1;
      }
      i1 = 0;
      for (;;)
      {
        arrayOfDouble = this.a;
        if (i1 >= arrayOfDouble.length) {
          break;
        }
        paramDouble1 = i1 / (arrayOfDouble.length - 1);
        int i2 = Arrays.binarySearch(s, paramDouble1);
        if (i2 >= 0)
        {
          this.a[i1] = (i2 / (s.length - 1));
        }
        else if (i2 == -1)
        {
          this.a[i1] = 0.0D;
        }
        else
        {
          i2 = -i2;
          int i3 = i2 - 2;
          paramDouble2 = i3;
          arrayOfDouble = s;
          paramDouble1 = (paramDouble2 + (paramDouble1 - arrayOfDouble[i3]) / (arrayOfDouble[(i2 - 1)] - arrayOfDouble[i3])) / (arrayOfDouble.length - 1);
          this.a[i1] = paramDouble1;
        }
        i1 += 1;
      }
    }
    
    double b()
    {
      double d2 = this.j * this.p;
      double d1 = -this.k;
      double d3 = this.o;
      d3 = this.n / Math.hypot(d2, d1 * d3);
      d1 = d2;
      if (this.q) {
        d1 = -d2;
      }
      return d1 * d3;
    }
    
    double c()
    {
      double d2 = this.j;
      double d3 = this.p;
      double d1 = -this.k * this.o;
      d2 = this.n / Math.hypot(d2 * d3, d1);
      if (this.q) {
        return -d1 * d2;
      }
      return d1 * d2;
    }
    
    public double d(double paramDouble)
    {
      return this.l;
    }
    
    public double e(double paramDouble)
    {
      return this.m;
    }
    
    public double f(double paramDouble)
    {
      double d1 = this.c;
      double d2 = this.i;
      double d3 = this.e;
      return d3 + (paramDouble - d1) * d2 * (this.f - d3);
    }
    
    public double g(double paramDouble)
    {
      double d1 = this.c;
      double d2 = this.i;
      double d3 = this.g;
      return d3 + (paramDouble - d1) * d2 * (this.h - d3);
    }
    
    double h()
    {
      return this.l + this.j * this.o;
    }
    
    double i()
    {
      return this.m + this.k * this.p;
    }
    
    double j(double paramDouble)
    {
      if (paramDouble <= 0.0D) {
        return 0.0D;
      }
      if (paramDouble >= 1.0D) {
        return 1.0D;
      }
      double[] arrayOfDouble = this.a;
      paramDouble *= (arrayOfDouble.length - 1);
      int i1 = (int)paramDouble;
      double d1 = i1;
      return arrayOfDouble[i1] + (paramDouble - d1) * (arrayOfDouble[(i1 + 1)] - arrayOfDouble[i1]);
    }
    
    void k(double paramDouble)
    {
      if (this.q) {
        paramDouble = this.d - paramDouble;
      } else {
        paramDouble -= this.c;
      }
      paramDouble = j(paramDouble * this.i) * 1.570796326794897D;
      this.o = Math.sin(paramDouble);
      this.p = Math.cos(paramDouble);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.a
 * JD-Core Version:    0.7.0.1
 */