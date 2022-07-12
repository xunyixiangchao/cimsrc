package p0;

class a
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;
  
  a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.g = paramFloat7;
    this.h = paramFloat8;
    this.i = paramFloat9;
  }
  
  private static a b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f5 = 1000.0F;
    float f1 = 0.0F;
    Object localObject1 = null;
    float f2 = 100.0F;
    float f3 = 1000.0F;
    while (Math.abs(f1 - f2) > 0.01F)
    {
      float f6 = (f2 - f1) / 2.0F + f1;
      int j = e(f6, paramFloat2, paramFloat1).p();
      float f10 = b.b(j);
      float f9 = Math.abs(paramFloat3 - f10);
      float f7 = f5;
      float f4 = f3;
      Object localObject2 = localObject1;
      if (f9 < 0.2F)
      {
        a locala = c(j);
        float f8 = locala.a(e(locala.k(), locala.i(), paramFloat1));
        f7 = f5;
        f4 = f3;
        localObject2 = localObject1;
        if (f8 <= 1.0F)
        {
          localObject2 = locala;
          f7 = f9;
          f4 = f8;
        }
      }
      if ((f7 == 0.0F) && (f4 == 0.0F)) {
        return localObject2;
      }
      if (f10 < paramFloat3)
      {
        f1 = f6;
        f5 = f7;
        f3 = f4;
        localObject1 = localObject2;
      }
      else
      {
        f2 = f6;
        f5 = f7;
        f3 = f4;
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  static a c(int paramInt)
  {
    return d(paramInt, j.k);
  }
  
  static a d(int paramInt, j paramj)
  {
    float[] arrayOfFloat = b.f(paramInt);
    float[][] arrayOfFloat1 = b.a;
    float f13 = arrayOfFloat[0];
    float f14 = arrayOfFloat1[0][0];
    float f15 = arrayOfFloat[1];
    float f16 = arrayOfFloat1[0][1];
    float f17 = arrayOfFloat[2];
    float f18 = arrayOfFloat1[0][2];
    float f7 = arrayOfFloat[0];
    float f8 = arrayOfFloat1[1][0];
    float f9 = arrayOfFloat[1];
    float f10 = arrayOfFloat1[1][1];
    float f11 = arrayOfFloat[2];
    float f12 = arrayOfFloat1[1][2];
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat1[2][0];
    float f3 = arrayOfFloat[1];
    float f4 = arrayOfFloat1[2][1];
    float f5 = arrayOfFloat[2];
    float f6 = arrayOfFloat1[2][2];
    f13 = paramj.i()[0] * (f13 * f14 + f15 * f16 + f17 * f18);
    f7 = paramj.i()[1] * (f7 * f8 + f9 * f10 + f11 * f12);
    f2 = paramj.i()[2] * (f1 * f2 + f3 * f4 + f5 * f6);
    f1 = (float)Math.pow(paramj.c() * Math.abs(f13) / 100.0D, 0.42D);
    f4 = (float)Math.pow(paramj.c() * Math.abs(f7) / 100.0D, 0.42D);
    f3 = (float)Math.pow(paramj.c() * Math.abs(f2) / 100.0D, 0.42D);
    f1 = Math.signum(f13) * 400.0F * f1 / (f1 + 27.129999F);
    f5 = Math.signum(f7) * 400.0F * f4 / (f4 + 27.129999F);
    f2 = Math.signum(f2) * 400.0F * f3 / (f3 + 27.129999F);
    double d1 = f1;
    double d2 = f5;
    double d3 = f2;
    f3 = (float)(d1 * 11.0D + d2 * -12.0D + d3) / 11.0F;
    f4 = (float)(f1 + f5 - d3 * 2.0D) / 9.0F;
    f5 *= 20.0F;
    f6 = (f1 * 20.0F + f5 + 21.0F * f2) / 20.0F;
    f7 = (f1 * 40.0F + f5 + f2) / 20.0F;
    f2 = (float)Math.atan2(f4, f3) * 180.0F / 3.141593F;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    for (;;)
    {
      break;
      f1 = f2;
      if (f2 >= 360.0F) {
        f1 = f2 - 360.0F;
      }
    }
    f5 = 3.141593F * f1 / 180.0F;
    f7 = (float)Math.pow(f7 * paramj.f() / paramj.a(), paramj.b() * paramj.j()) * 100.0F;
    f8 = 4.0F / paramj.b();
    f9 = (float)Math.sqrt(f7 / 100.0F);
    f10 = paramj.a();
    f11 = paramj.d();
    if (f1 < 20.140000000000001D) {
      f2 = 360.0F + f1;
    } else {
      f2 = f1;
    }
    f2 = (float)(Math.cos(f2 * 3.141592653589793D / 180.0D + 2.0D) + 3.8D) * 0.25F * 3846.1538F * paramj.g() * paramj.h() * (float)Math.sqrt(f3 * f3 + f4 * f4) / (f6 + 0.305F);
    f4 = (float)Math.pow(1.64D - Math.pow(0.29D, paramj.e()), 0.73D) * (float)Math.pow(f2, 0.9D);
    f2 = f4 * (float)Math.sqrt(f7 / 100.0D);
    f3 = f2 * paramj.d();
    f4 = (float)Math.sqrt(f4 * paramj.b() / (paramj.a() + 4.0F));
    f6 = 1.7F * f7 / (0.007F * f7 + 1.0F);
    f12 = (float)Math.log(0.0228F * f3 + 1.0F) * 43.85965F;
    d1 = f5;
    return new a(f1, f2, f7, f11 * (f8 * f9 * (f10 + 4.0F)), f3, f4 * 50.0F, f6, f12 * (float)Math.cos(d1), f12 * (float)Math.sin(d1));
  }
  
  private static a e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return f(paramFloat1, paramFloat2, paramFloat3, j.k);
  }
  
  private static a f(float paramFloat1, float paramFloat2, float paramFloat3, j paramj)
  {
    float f1 = 4.0F / paramj.b();
    double d1 = paramFloat1 / 100.0D;
    float f2 = (float)Math.sqrt(d1);
    float f3 = paramj.a();
    float f4 = paramj.d();
    float f5 = paramFloat2 * paramj.d();
    float f6 = (float)Math.sqrt(paramFloat2 / (float)Math.sqrt(d1) * paramj.b() / (paramj.a() + 4.0F));
    float f7 = 3.141593F * paramFloat3 / 180.0F;
    float f8 = 1.7F * paramFloat1 / (0.007F * paramFloat1 + 1.0F);
    float f9 = (float)Math.log(f5 * 0.0228D + 1.0D) * 43.85965F;
    d1 = f7;
    return new a(paramFloat3, paramFloat2, paramFloat1, f1 * f2 * (f3 + 4.0F) * f4, f5, f6 * 50.0F, f8, f9 * (float)Math.cos(d1), f9 * (float)Math.sin(d1));
  }
  
  static int m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return n(paramFloat1, paramFloat2, paramFloat3, j.k);
  }
  
  static int n(float paramFloat1, float paramFloat2, float paramFloat3, j paramj)
  {
    if ((paramFloat2 >= 1.0D) && (Math.round(paramFloat3) > 0.0D) && (Math.round(paramFloat3) < 100.0D))
    {
      float f1;
      if (paramFloat1 < 0.0F) {
        f1 = 0.0F;
      } else {
        f1 = Math.min(360.0F, paramFloat1);
      }
      Object localObject = null;
      int j = 1;
      float f2 = 0.0F;
      paramFloat1 = paramFloat2;
      if (Math.abs(f2 - paramFloat2) >= 0.4F)
      {
        a locala = b(f1, paramFloat1, paramFloat3);
        if (j != 0)
        {
          if (locala != null) {
            return locala.o(paramj);
          }
          j = 0;
        }
        for (;;)
        {
          paramFloat1 = (paramFloat2 - f2) / 2.0F + f2;
          break;
          if (locala == null)
          {
            paramFloat2 = paramFloat1;
          }
          else
          {
            localObject = locala;
            f2 = paramFloat1;
          }
        }
      }
      if (localObject == null) {
        return b.a(paramFloat3);
      }
      return localObject.o(paramj);
    }
    return b.a(paramFloat3);
  }
  
  float a(a parama)
  {
    float f1 = l() - parama.l();
    float f2 = g() - parama.g();
    float f3 = h() - parama.h();
    return (float)(Math.pow(Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3), 0.63D) * 1.41D);
  }
  
  float g()
  {
    return this.h;
  }
  
  float h()
  {
    return this.i;
  }
  
  float i()
  {
    return this.b;
  }
  
  float j()
  {
    return this.a;
  }
  
  float k()
  {
    return this.c;
  }
  
  float l()
  {
    return this.g;
  }
  
  int o(j paramj)
  {
    if ((i() != 0.0D) && (k() != 0.0D)) {
      f1 = i() / (float)Math.sqrt(k() / 100.0D);
    } else {
      f1 = 0.0F;
    }
    float f2 = (float)Math.pow(f1 / Math.pow(1.64D - Math.pow(0.29D, paramj.e()), 0.73D), 1.111111111111111D);
    double d1 = j() * 3.141593F / 180.0F;
    float f3 = (float)(Math.cos(2.0D + d1) + 3.8D);
    float f1 = paramj.a();
    float f6 = (float)Math.pow(k() / 100.0D, 1.0D / paramj.b() / paramj.j());
    float f4 = paramj.g();
    float f5 = paramj.h();
    f1 = f1 * f6 / paramj.f();
    f6 = (float)Math.sin(d1);
    float f7 = (float)Math.cos(d1);
    f3 = (0.305F + f1) * 23.0F * f2 / (f3 * 0.25F * 3846.1538F * f4 * f5 * 23.0F + 11.0F * f2 * f7 + f2 * 108.0F * f6);
    f2 = f7 * f3;
    f3 *= f6;
    f5 = f1 * 460.0F;
    f1 = (451.0F * f2 + f5 + 288.0F * f3) / 1403.0F;
    f4 = (f5 - 891.0F * f2 - 261.0F * f3) / 1403.0F;
    f6 = (f5 - f2 * 220.0F - f3 * 6300.0F) / 1403.0F;
    f3 = (float)Math.max(0.0D, Math.abs(f1) * 27.129999999999999D / (400.0D - Math.abs(f1)));
    f1 = Math.signum(f1);
    f2 = 100.0F / paramj.c();
    f3 = (float)Math.pow(f3, 2.380952380952381D);
    f7 = (float)Math.max(0.0D, Math.abs(f4) * 27.129999999999999D / (400.0D - Math.abs(f4)));
    f4 = Math.signum(f4);
    f5 = 100.0F / paramj.c();
    f7 = (float)Math.pow(f7, 2.380952380952381D);
    float f9 = (float)Math.max(0.0D, Math.abs(f6) * 27.129999999999999D / (400.0D - Math.abs(f6)));
    f6 = Math.signum(f6);
    float f8 = 100.0F / paramj.c();
    f9 = (float)Math.pow(f9, 2.380952380952381D);
    f1 = f1 * f2 * f3 / paramj.i()[0];
    f2 = f4 * f5 * f7 / paramj.i()[1];
    f3 = f6 * f8 * f9 / paramj.i()[2];
    paramj = b.b;
    f4 = paramj[0][0];
    f5 = paramj[0][1];
    f6 = paramj[0][2];
    f7 = paramj[1][0];
    f8 = paramj[1][1];
    f9 = paramj[1][2];
    float f10 = paramj[2][0];
    float f11 = paramj[2][1];
    float f12 = paramj[2][2];
    return q0.a.c(f4 * f1 + f5 * f2 + f6 * f3, f7 * f1 + f8 * f2 + f9 * f3, f1 * f10 + f2 * f11 + f3 * f12);
  }
  
  int p()
  {
    return o(j.k);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.a
 * JD-Core Version:    0.7.0.1
 */