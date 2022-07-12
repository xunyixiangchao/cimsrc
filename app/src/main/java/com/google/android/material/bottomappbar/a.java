package com.google.android.material.bottomappbar;

import r7.f;
import r7.o;

public class a
  extends f
  implements Cloneable
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f = -1.0F;
  
  public a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b = paramFloat1;
    this.a = paramFloat2;
    l(paramFloat3);
    this.e = 0.0F;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, o paramo)
  {
    float f4 = this.c;
    if (f4 == 0.0F)
    {
      paramo.m(paramFloat1, 0.0F);
      return;
    }
    float f3 = (this.b * 2.0F + f4) / 2.0F;
    float f6 = paramFloat3 * this.a;
    float f1 = paramFloat2 + this.e;
    paramFloat2 = this.d * paramFloat3 + (1.0F - paramFloat3) * f3;
    if (paramFloat2 / f3 >= 1.0F)
    {
      paramo.m(paramFloat1, 0.0F);
      return;
    }
    float f5 = this.f;
    float f2 = f5 * paramFloat3;
    int i;
    if ((f5 != -1.0F) && (Math.abs(f5 * 2.0F - f4) >= 0.1F)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramFloat3 = 1.75F;
      paramFloat2 = 0.0F;
    }
    else
    {
      paramFloat3 = 0.0F;
    }
    f5 = f3 + f6;
    f4 = paramFloat2 + f6;
    float f8 = (float)Math.sqrt(f5 * f5 - f4 * f4);
    f5 = f1 - f8;
    float f7 = f1 + f8;
    f8 = (float)Math.toDegrees(Math.atan(f8 / f4));
    f4 = 90.0F - f8 + paramFloat3;
    paramo.m(f5, 0.0F);
    float f9 = f6 * 2.0F;
    paramo.a(f5 - f6, 0.0F, f5 + f6, f9, 270.0F, f8);
    if (i != 0)
    {
      f2 = f1 - f3;
      paramFloat3 = -f3 - paramFloat2;
      f1 += f3;
      f5 = f3 - paramFloat2;
      f3 = 180.0F - f4;
      f4 = f4 * 2.0F - 180.0F;
      paramFloat2 = f2;
      f2 = f5;
    }
    else
    {
      paramFloat3 = this.b;
      paramFloat2 = f2 * 2.0F;
      f5 = f1 - f3;
      paramo.a(f5, -(f2 + paramFloat3), f5 + (paramFloat3 + paramFloat2), paramFloat3 + f2, 180.0F - f4, (f4 * 2.0F - 180.0F) / 2.0F);
      f1 += f3;
      paramFloat3 = this.b;
      paramo.m(f1 - (paramFloat3 / 2.0F + f2), paramFloat3 + f2);
      f3 = this.b;
      paramFloat2 = f1 - (paramFloat2 + f3);
      paramFloat3 = -(f2 + f3);
      f2 = f3 + f2;
      f3 = 90.0F;
      f4 -= 90.0F;
    }
    paramo.a(paramFloat2, paramFloat3, f1, f2, f3, f4);
    paramo.a(f7 - f6, 0.0F, f7 + f6, f9, 270.0F - f8, f8);
    paramo.m(paramFloat1, 0.0F);
  }
  
  float c()
  {
    return this.d;
  }
  
  public float d()
  {
    return this.f;
  }
  
  float e()
  {
    return this.b;
  }
  
  float f()
  {
    return this.a;
  }
  
  public float j()
  {
    return this.c;
  }
  
  public float k()
  {
    return this.e;
  }
  
  void l(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.d = paramFloat;
      return;
    }
    throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
  }
  
  public void m(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  void n(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  void o(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void p(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  void q(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomappbar.a
 * JD-Core Version:    0.7.0.1
 */