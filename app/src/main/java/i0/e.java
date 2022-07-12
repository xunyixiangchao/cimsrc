package i0;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class e
{
  private b a;
  private b b;
  private String c;
  private int d = 0;
  private String e = null;
  public int f = 0;
  ArrayList<c> g = new ArrayList();
  
  public float a(float paramFloat)
  {
    return (float)this.b.b(paramFloat);
  }
  
  public float b(float paramFloat)
  {
    return (float)this.b.a(paramFloat);
  }
  
  protected void c(Object paramObject) {}
  
  public void d(int paramInt1, int paramInt2, String paramString, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.g.add(new c(paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    if (paramInt3 != -1) {
      this.f = paramInt3;
    }
    this.d = paramInt2;
    this.e = paramString;
  }
  
  public void e(int paramInt1, int paramInt2, String paramString, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Object paramObject)
  {
    this.g.add(new c(paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    if (paramInt3 != -1) {
      this.f = paramInt3;
    }
    this.d = paramInt2;
    c(paramObject);
    this.e = paramString;
  }
  
  public void f(String paramString)
  {
    this.c = paramString;
  }
  
  public void g(float paramFloat)
  {
    int i = this.g.size();
    if (i == 0) {
      return;
    }
    Collections.sort(this.g, new a());
    double[] arrayOfDouble1 = new double[i];
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i, 3 });
    this.b = new b(this.d, this.e, this.f, i);
    Iterator localIterator = this.g.iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      float f1 = localc.d;
      arrayOfDouble1[i] = (f1 * 0.01D);
      double[] arrayOfDouble2 = arrayOfDouble[i];
      float f2 = localc.b;
      arrayOfDouble2[0] = f2;
      arrayOfDouble2 = arrayOfDouble[i];
      float f3 = localc.c;
      arrayOfDouble2[1] = f3;
      arrayOfDouble2 = arrayOfDouble[i];
      float f4 = localc.e;
      arrayOfDouble2[2] = f4;
      this.b.c(i, localc.a, f1, f3, f4, f2);
      i += 1;
    }
    this.b.d(paramFloat);
    this.a = b.a(0, arrayOfDouble1, arrayOfDouble);
  }
  
  public boolean h()
  {
    return this.f == 1;
  }
  
  public String toString()
  {
    String str = this.c;
    DecimalFormat localDecimalFormat = new DecimalFormat("##.##");
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("[");
      localStringBuilder.append(localc.a);
      localStringBuilder.append(" , ");
      localStringBuilder.append(localDecimalFormat.format(localc.b));
      localStringBuilder.append("] ");
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  class a
    implements Comparator<e.c>
  {
    a() {}
    
    public int a(e.c paramc1, e.c paramc2)
    {
      return Integer.compare(paramc1.a, paramc2.a);
    }
  }
  
  static class b
  {
    private final int a;
    h b;
    private final int c;
    private final int d;
    private final int e;
    float[] f;
    double[] g;
    float[] h;
    float[] i;
    float[] j;
    float[] k;
    int l;
    b m;
    double[] n;
    double[] o;
    float p;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      h localh = new h();
      this.b = localh;
      this.c = 0;
      this.d = 1;
      this.e = 2;
      this.l = paramInt1;
      this.a = paramInt2;
      localh.g(paramInt1, paramString);
      this.f = new float[paramInt3];
      this.g = new double[paramInt3];
      this.h = new float[paramInt3];
      this.i = new float[paramInt3];
      this.j = new float[paramInt3];
      this.k = new float[paramInt3];
    }
    
    public double a(float paramFloat)
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        d1 = paramFloat;
        ((b)localObject).g(d1, this.o);
        this.m.d(d1, this.n);
      }
      else
      {
        localObject = this.o;
        localObject[0] = 0.0D;
        localObject[1] = 0.0D;
        localObject[2] = 0.0D;
      }
      localObject = this.b;
      double d2 = paramFloat;
      double d1 = ((h)localObject).e(d2, this.n[1]);
      d2 = this.b.d(d2, this.n[1], this.o[1]);
      localObject = this.o;
      return localObject[0] + d1 * localObject[2] + d2 * this.n[2];
    }
    
    public double b(float paramFloat)
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        ((b)localObject).d(paramFloat, this.n);
      }
      else
      {
        localObject = this.n;
        localObject[0] = this.i[0];
        localObject[1] = this.j[0];
        localObject[2] = this.f[0];
      }
      localObject = this.n;
      double d1 = localObject[0];
      double d2 = localObject[1];
      return d1 + this.b.e(paramFloat, d2) * this.n[2];
    }
    
    public void c(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.g[paramInt1] = (paramInt2 / 100.0D);
      this.h[paramInt1] = paramFloat1;
      this.i[paramInt1] = paramFloat2;
      this.j[paramInt1] = paramFloat3;
      this.f[paramInt1] = paramFloat4;
    }
    
    public void d(float paramFloat)
    {
      this.p = paramFloat;
      Object localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { this.g.length, 3 });
      Object localObject2 = this.f;
      this.n = new double[localObject2.length + 2];
      this.o = new double[localObject2.length + 2];
      if (this.g[0] > 0.0D) {
        this.b.a(0.0D, this.h[0]);
      }
      localObject2 = this.g;
      int i1 = localObject2.length - 1;
      if (localObject2[i1] < 1.0D) {
        this.b.a(1.0D, this.h[i1]);
      }
      i1 = 0;
      while (i1 < localObject1.length)
      {
        localObject1[i1][0] = this.i[i1];
        localObject1[i1][1] = this.j[i1];
        localObject1[i1][2] = this.f[i1];
        this.b.a(this.g[i1], this.h[i1]);
        i1 += 1;
      }
      this.b.f();
      localObject2 = this.g;
      if (localObject2.length > 1) {
        localObject1 = b.a(0, (double[])localObject2, (double[][])localObject1);
      } else {
        localObject1 = null;
      }
      this.m = ((b)localObject1);
    }
  }
  
  static class c
  {
    int a;
    float b;
    float c;
    float d;
    float e;
    
    public c(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = paramInt;
      this.b = paramFloat4;
      this.c = paramFloat2;
      this.d = paramFloat1;
      this.e = paramFloat3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.e
 * JD-Core Version:    0.7.0.1
 */