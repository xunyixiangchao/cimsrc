package l1;

public final class c
{
  public static final c e;
  public static final c f;
  public static final c g;
  public static final c h;
  public static final c i;
  public static final c j;
  final float[] a;
  final float[] b;
  final float[] c;
  boolean d;
  
  static
  {
    c localc = new c();
    e = localc;
    m(localc);
    p(localc);
    localc = new c();
    f = localc;
    o(localc);
    p(localc);
    localc = new c();
    g = localc;
    l(localc);
    p(localc);
    localc = new c();
    h = localc;
    m(localc);
    n(localc);
    localc = new c();
    i = localc;
    o(localc);
    n(localc);
    localc = new c();
    j = localc;
    l(localc);
    n(localc);
  }
  
  c()
  {
    float[] arrayOfFloat1 = new float[3];
    this.a = arrayOfFloat1;
    float[] arrayOfFloat2 = new float[3];
    this.b = arrayOfFloat2;
    this.c = new float[3];
    this.d = true;
    r(arrayOfFloat1);
    r(arrayOfFloat2);
    q();
  }
  
  private static void l(c paramc)
  {
    paramc = paramc.b;
    paramc[1] = 0.26F;
    paramc[2] = 0.45F;
  }
  
  private static void m(c paramc)
  {
    paramc = paramc.b;
    paramc[0] = 0.55F;
    paramc[1] = 0.74F;
  }
  
  private static void n(c paramc)
  {
    paramc = paramc.a;
    paramc[1] = 0.3F;
    paramc[2] = 0.4F;
  }
  
  private static void o(c paramc)
  {
    paramc = paramc.b;
    paramc[0] = 0.3F;
    paramc[1] = 0.5F;
    paramc[2] = 0.7F;
  }
  
  private static void p(c paramc)
  {
    paramc = paramc.a;
    paramc[0] = 0.35F;
    paramc[1] = 1.0F;
  }
  
  private void q()
  {
    float[] arrayOfFloat = this.c;
    arrayOfFloat[0] = 0.24F;
    arrayOfFloat[1] = 0.52F;
    arrayOfFloat[2] = 0.24F;
  }
  
  private static void r(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
  
  public float a()
  {
    return this.c[1];
  }
  
  public float b()
  {
    return this.b[2];
  }
  
  public float c()
  {
    return this.a[2];
  }
  
  public float d()
  {
    return this.b[0];
  }
  
  public float e()
  {
    return this.a[0];
  }
  
  public float f()
  {
    return this.c[2];
  }
  
  public float g()
  {
    return this.c[0];
  }
  
  public float h()
  {
    return this.b[1];
  }
  
  public float i()
  {
    return this.a[1];
  }
  
  public boolean j()
  {
    return this.d;
  }
  
  void k()
  {
    int n = this.c.length;
    int m = 0;
    int k = 0;
    float f2;
    for (float f1 = 0.0F; k < n; f1 = f2)
    {
      float f3 = this.c[k];
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = f1 + f3;
      }
      k += 1;
    }
    if (f1 != 0.0F)
    {
      n = this.c.length;
      k = m;
      while (k < n)
      {
        float[] arrayOfFloat = this.c;
        if (arrayOfFloat[k] > 0.0F) {
          arrayOfFloat[k] /= f1;
        }
        k += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l1.c
 * JD-Core Version:    0.7.0.1
 */