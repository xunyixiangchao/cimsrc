package i0;

public class n
  implements m
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private int j;
  private String k;
  private boolean l = false;
  private float m;
  private float n;
  private boolean o = false;
  
  private float c(float paramFloat)
  {
    this.o = false;
    float f1 = this.d;
    float f2;
    if (paramFloat <= f1)
    {
      f2 = this.a;
      return f2 * paramFloat + (this.b - f2) * paramFloat * paramFloat / (f1 * 2.0F);
    }
    int i1 = this.j;
    if (i1 == 1) {
      return this.g;
    }
    paramFloat -= f1;
    f1 = this.e;
    float f3;
    if (paramFloat < f1)
    {
      f2 = this.g;
      f3 = this.b;
      return f2 + f3 * paramFloat + (this.c - f3) * paramFloat * paramFloat / (f1 * 2.0F);
    }
    if (i1 == 2) {
      return this.h;
    }
    paramFloat -= f1;
    f1 = this.f;
    if (paramFloat <= f1)
    {
      f2 = this.h;
      f3 = this.c;
      return f2 + f3 * paramFloat - f3 * paramFloat * paramFloat / (f1 * 2.0F);
    }
    this.o = true;
    return this.i;
  }
  
  private void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.o = false;
    float f1 = paramFloat1;
    if (paramFloat1 == 0.0F) {
      f1 = 1.0E-004F;
    }
    this.a = f1;
    paramFloat1 = f1 / paramFloat3;
    float f2 = paramFloat1 * f1 / 2.0F;
    if (f1 < 0.0F)
    {
      paramFloat1 = (float)Math.sqrt((paramFloat2 - -f1 / paramFloat3 * f1 / 2.0F) * paramFloat3);
      if (paramFloat1 < paramFloat4)
      {
        this.k = "backward accelerate, decelerate";
        this.j = 2;
        this.a = f1;
        this.b = paramFloat1;
        this.c = 0.0F;
        paramFloat4 = (paramFloat1 - f1) / paramFloat3;
        this.d = paramFloat4;
        this.e = (paramFloat1 / paramFloat3);
        this.g = ((f1 + paramFloat1) * paramFloat4 / 2.0F);
        this.h = paramFloat2;
        this.i = paramFloat2;
        return;
      }
      this.k = "backward accelerate cruse decelerate";
      this.j = 3;
      this.a = f1;
      this.b = paramFloat4;
      this.c = paramFloat4;
      paramFloat1 = (paramFloat4 - f1) / paramFloat3;
      this.d = paramFloat1;
      paramFloat3 = paramFloat4 / paramFloat3;
      this.f = paramFloat3;
      paramFloat1 = (f1 + paramFloat4) * paramFloat1 / 2.0F;
      paramFloat3 = paramFloat3 * paramFloat4 / 2.0F;
      this.e = ((paramFloat2 - paramFloat1 - paramFloat3) / paramFloat4);
      this.g = paramFloat1;
      this.h = (paramFloat2 - paramFloat3);
      this.i = paramFloat2;
      return;
    }
    if (f2 >= paramFloat2)
    {
      this.k = "hard stop";
      paramFloat1 = 2.0F * paramFloat2 / f1;
      this.j = 1;
      this.a = f1;
      this.b = 0.0F;
      this.g = paramFloat2;
      this.d = paramFloat1;
      return;
    }
    f2 = paramFloat2 - f2;
    float f3 = f2 / f1;
    if (f3 + paramFloat1 < paramFloat5)
    {
      this.k = "cruse decelerate";
      this.j = 2;
      this.a = f1;
      this.b = f1;
      this.c = 0.0F;
      this.g = f2;
      this.h = paramFloat2;
      this.d = f3;
      this.e = paramFloat1;
      return;
    }
    paramFloat1 = (float)Math.sqrt(paramFloat3 * paramFloat2 + f1 * f1 / 2.0F);
    paramFloat5 = (paramFloat1 - f1) / paramFloat3;
    this.d = paramFloat5;
    f2 = paramFloat1 / paramFloat3;
    this.e = f2;
    if (paramFloat1 < paramFloat4)
    {
      this.k = "accelerate decelerate";
      this.j = 2;
      this.a = f1;
      this.b = paramFloat1;
      this.c = 0.0F;
      this.d = paramFloat5;
      this.e = f2;
      this.g = ((f1 + paramFloat1) * paramFloat5 / 2.0F);
      this.h = paramFloat2;
      return;
    }
    this.k = "accelerate cruse decelerate";
    this.j = 3;
    this.a = f1;
    this.b = paramFloat4;
    this.c = paramFloat4;
    paramFloat1 = (paramFloat4 - f1) / paramFloat3;
    this.d = paramFloat1;
    paramFloat3 = paramFloat4 / paramFloat3;
    this.f = paramFloat3;
    paramFloat1 = (f1 + paramFloat4) * paramFloat1 / 2.0F;
    paramFloat3 = paramFloat3 * paramFloat4 / 2.0F;
    this.e = ((paramFloat2 - paramFloat1 - paramFloat3) / paramFloat4);
    this.g = paramFloat1;
    this.h = (paramFloat2 - paramFloat3);
    this.i = paramFloat2;
  }
  
  public boolean a()
  {
    return (b() < 1.0E-005F) && (Math.abs(this.i - this.n) < 1.0E-005F);
  }
  
  public float b()
  {
    if (this.l) {
      return -e(this.n);
    }
    return e(this.n);
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    boolean bool = false;
    this.o = false;
    this.m = paramFloat1;
    if (paramFloat1 > paramFloat2) {
      bool = true;
    }
    this.l = bool;
    if (bool)
    {
      paramFloat3 = -paramFloat3;
      paramFloat1 -= paramFloat2;
    }
    else
    {
      paramFloat1 = paramFloat2 - paramFloat1;
    }
    f(paramFloat3, paramFloat1, paramFloat5, paramFloat6, paramFloat4);
  }
  
  public float e(float paramFloat)
  {
    float f1 = this.d;
    float f2;
    if (paramFloat <= f1)
    {
      f2 = this.a;
      return f2 + (this.b - f2) * paramFloat / f1;
    }
    int i1 = this.j;
    if (i1 == 1) {
      return 0.0F;
    }
    paramFloat -= f1;
    f1 = this.e;
    if (paramFloat < f1)
    {
      f2 = this.b;
      return f2 + (this.c - f2) * paramFloat / f1;
    }
    if (i1 == 2) {
      return this.h;
    }
    paramFloat -= f1;
    f1 = this.f;
    if (paramFloat < f1)
    {
      f2 = this.c;
      return f2 - paramFloat * f2 / f1;
    }
    return this.i;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f1 = c(paramFloat);
    this.n = paramFloat;
    if (this.l) {
      return this.m - f1;
    }
    return this.m + f1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.n
 * JD-Core Version:    0.7.0.1
 */