package e1;

public final class e
{
  double a = Math.sqrt(1500.0D);
  double b = 0.5D;
  private boolean c = false;
  private double d;
  private double e;
  private double f;
  private double g;
  private double h;
  private double i = 1.7976931348623157E+308D;
  private final b.o j = new b.o();
  
  public e() {}
  
  public e(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  private void b()
  {
    if (this.c) {
      return;
    }
    if (this.i != 1.7976931348623157E+308D)
    {
      double d1 = this.b;
      if (d1 > 1.0D)
      {
        double d2 = -d1;
        double d3 = this.a;
        this.f = (d2 * d3 + d3 * Math.sqrt(d1 * d1 - 1.0D));
        d1 = this.b;
        d2 = -d1;
        d3 = this.a;
        this.g = (d2 * d3 - d3 * Math.sqrt(d1 * d1 - 1.0D));
      }
      else if ((d1 >= 0.0D) && (d1 < 1.0D))
      {
        this.h = (this.a * Math.sqrt(1.0D - d1 * d1));
      }
      this.c = true;
      return;
    }
    throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
  }
  
  public float a()
  {
    return (float)this.i;
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat2) < this.e) && (Math.abs(paramFloat1 - a()) < this.d);
  }
  
  public e d(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.b = paramFloat;
      this.c = false;
      return this;
    }
    throw new IllegalArgumentException("Damping ratio must be non-negative");
  }
  
  public e e(float paramFloat)
  {
    this.i = paramFloat;
    return this;
  }
  
  public e f(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.a = Math.sqrt(paramFloat);
      this.c = false;
      return this;
    }
    throw new IllegalArgumentException("Spring stiffness constant must be positive.");
  }
  
  void g(double paramDouble)
  {
    paramDouble = Math.abs(paramDouble);
    this.d = paramDouble;
    this.e = (paramDouble * 62.5D);
  }
  
  b.o h(double paramDouble1, double paramDouble2, long paramLong)
  {
    b();
    double d1 = paramLong / 1000.0D;
    double d2 = paramDouble1 - this.i;
    paramDouble1 = this.b;
    double d4;
    double d3;
    double d5;
    if (paramDouble1 > 1.0D)
    {
      paramDouble1 = this.g;
      d4 = this.f;
      d3 = d2 - (paramDouble1 * d2 - paramDouble2) / (paramDouble1 - d4);
      paramDouble2 = (d2 * paramDouble1 - paramDouble2) / (paramDouble1 - d4);
      paramDouble1 = Math.pow(2.718281828459045D, paramDouble1 * d1) * d3 + Math.pow(2.718281828459045D, this.f * d1) * paramDouble2;
      d2 = this.g;
      d4 = Math.pow(2.718281828459045D, d2 * d1);
      d5 = this.f;
      paramDouble2 = d3 * d2 * d4 + paramDouble2 * d5 * Math.pow(2.718281828459045D, d5 * d1);
    }
    else if (paramDouble1 == 1.0D)
    {
      paramDouble1 = this.a;
      paramDouble2 += paramDouble1 * d2;
      d2 += paramDouble2 * d1;
      paramDouble1 = Math.pow(2.718281828459045D, -paramDouble1 * d1) * d2;
      d3 = Math.pow(2.718281828459045D, -this.a * d1);
      d4 = this.a;
      d5 = -d4;
      paramDouble2 = paramDouble2 * Math.pow(2.718281828459045D, -d4 * d1) + d2 * d3 * d5;
    }
    else
    {
      d4 = 1.0D / this.h;
      d3 = this.a;
      paramDouble2 = d4 * (paramDouble1 * d3 * d2 + paramDouble2);
      paramDouble1 = Math.pow(2.718281828459045D, -paramDouble1 * d3 * d1) * (Math.cos(this.h * d1) * d2 + Math.sin(this.h * d1) * paramDouble2);
      d5 = this.a;
      d3 = -d5;
      d4 = this.b;
      d5 = Math.pow(2.718281828459045D, -d4 * d5 * d1);
      double d7 = this.h;
      double d6 = -d7;
      d7 = Math.sin(d7 * d1);
      double d8 = this.h;
      paramDouble2 = d3 * paramDouble1 * d4 + d5 * (d6 * d2 * d7 + paramDouble2 * d8 * Math.cos(d8 * d1));
    }
    b.o localo = this.j;
    localo.a = ((float)(paramDouble1 + this.i));
    localo.b = ((float)paramDouble2);
    return localo;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e1.e
 * JD-Core Version:    0.7.0.1
 */