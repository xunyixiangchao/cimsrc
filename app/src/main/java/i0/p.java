package i0;

public class p
{
  float a;
  float b;
  float c;
  float d;
  float e;
  float f;
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    paramFloat1 = (paramFloat1 - 0.5F) * 2.0F;
    paramFloat2 = (paramFloat2 - 0.5F) * 2.0F;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.a;
    float f6 = this.b;
    float f8 = (float)Math.toRadians(this.f);
    float f7 = (float)Math.toRadians(this.e);
    double d1 = -paramInt1 * paramFloat1;
    double d2 = f8;
    double d3 = Math.sin(d2);
    double d4 = paramInt2 * paramFloat2;
    f8 = (float)(d1 * d3 - Math.cos(d2) * d4);
    float f9 = (float)(paramInt1 * paramFloat1 * Math.cos(d2) - d4 * Math.sin(d2));
    paramArrayOfFloat[0] = (f1 + f3 + f5 * paramFloat1 + f8 * f7);
    paramArrayOfFloat[1] = (f2 + f4 + f6 * paramFloat2 + f7 * f9);
  }
  
  public void b()
  {
    this.e = 0.0F;
    this.d = 0.0F;
    this.c = 0.0F;
    this.b = 0.0F;
    this.a = 0.0F;
  }
  
  public void c(e parame, float paramFloat)
  {
    if (parame != null) {
      this.e = parame.b(paramFloat);
    }
  }
  
  public void d(j paramj, float paramFloat)
  {
    if (paramj != null)
    {
      this.e = paramj.b(paramFloat);
      this.f = paramj.a(paramFloat);
    }
  }
  
  public void e(e parame1, e parame2, float paramFloat)
  {
    if (parame1 != null) {
      this.a = parame1.b(paramFloat);
    }
    if (parame2 != null) {
      this.b = parame2.b(paramFloat);
    }
  }
  
  public void f(j paramj1, j paramj2, float paramFloat)
  {
    if (paramj1 != null) {
      this.a = paramj1.b(paramFloat);
    }
    if (paramj2 != null) {
      this.b = paramj2.b(paramFloat);
    }
  }
  
  public void g(e parame1, e parame2, float paramFloat)
  {
    if (parame1 != null) {
      this.c = parame1.b(paramFloat);
    }
    if (parame2 != null) {
      this.d = parame2.b(paramFloat);
    }
  }
  
  public void h(j paramj1, j paramj2, float paramFloat)
  {
    if (paramj1 != null) {
      this.c = paramj1.b(paramFloat);
    }
    if (paramj2 != null) {
      this.d = paramj2.b(paramFloat);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.p
 * JD-Core Version:    0.7.0.1
 */