package i0;

public class k
  implements m
{
  double a = 0.5D;
  private boolean b = false;
  private double c;
  private double d;
  private double e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private int k = 0;
  
  private void c(double paramDouble)
  {
    double d1 = this.c;
    double d2 = this.a;
    int n = (int)(9.0D / (Math.sqrt(d1 / this.i) * paramDouble * 4.0D) + 1.0D);
    double d3 = paramDouble / n;
    int m = 0;
    paramDouble = d2;
    while (m < n)
    {
      float f1 = this.g;
      double d4 = f1;
      d2 = this.d;
      double d5 = -d1;
      float f2 = this.h;
      double d6 = f2;
      float f3 = this.i;
      d4 = (d5 * (d4 - d2) - d6 * paramDouble) / f3;
      d4 = f2 + d4 * d3 / 2.0D;
      d2 = (-(f1 + d3 * d4 / 2.0D - d2) * d1 - d4 * paramDouble) / f3 * d3;
      d4 = f2;
      d5 = d2 / 2.0D;
      f2 = (float)(f2 + d2);
      this.h = f2;
      f1 = (float)(f1 + (d4 + d5) * d3);
      this.g = f1;
      int i1 = this.k;
      if (i1 > 0)
      {
        if ((f1 < 0.0F) && ((i1 & 0x1) == 1))
        {
          this.g = (-f1);
          this.h = (-f2);
        }
        f1 = this.g;
        if ((f1 > 1.0F) && ((i1 & 0x2) == 2))
        {
          this.g = (2.0F - f1);
          this.h = (-this.h);
        }
      }
      m += 1;
    }
  }
  
  public boolean a()
  {
    double d1 = this.g - this.d;
    double d2 = this.c;
    double d3 = this.h;
    return Math.sqrt((d3 * d3 * this.i + d2 * d1 * d1) / d2) <= this.j;
  }
  
  public float b()
  {
    return 0.0F;
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt)
  {
    this.d = paramFloat2;
    this.a = paramFloat6;
    this.b = false;
    this.g = paramFloat1;
    this.e = paramFloat3;
    this.c = paramFloat5;
    this.i = paramFloat4;
    this.j = paramFloat7;
    this.k = paramInt;
    this.f = 0.0F;
  }
  
  public float getInterpolation(float paramFloat)
  {
    c(paramFloat - this.f);
    this.f = paramFloat;
    return this.g;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.k
 * JD-Core Version:    0.7.0.1
 */