package p0;

final class j
{
  static final j k = k(b.c, (float)(b.h(50.0F) * 63.661977236758133D / 100.0D), 50.0F, 2.0F, false);
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float[] g;
  private final float h;
  private final float i;
  private final float j;
  
  private j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float[] paramArrayOfFloat, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.f = paramFloat1;
    this.a = paramFloat2;
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.g = paramArrayOfFloat;
    this.h = paramFloat7;
    this.i = paramFloat8;
    this.j = paramFloat9;
  }
  
  static j k(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    Object localObject = b.a;
    float f2 = paramArrayOfFloat[0] * localObject[0][0] + paramArrayOfFloat[1] * localObject[0][1] + paramArrayOfFloat[2] * localObject[0][2];
    float f3 = paramArrayOfFloat[0] * localObject[1][0] + paramArrayOfFloat[1] * localObject[1][1] + paramArrayOfFloat[2] * localObject[1][2];
    float f4 = paramArrayOfFloat[0] * localObject[2][0] + paramArrayOfFloat[1] * localObject[2][1] + paramArrayOfFloat[2] * localObject[2][2];
    float f5 = paramFloat3 / 10.0F + 0.8F;
    float f1;
    if (f5 >= 0.9D) {
      f1 = b.d(0.59F, 0.69F, (f5 - 0.9F) * 10.0F);
    } else {
      f1 = b.d(0.525F, 0.59F, (f5 - 0.8F) * 10.0F);
    }
    if (paramBoolean) {
      paramFloat3 = 1.0F;
    } else {
      paramFloat3 = (1.0F - (float)Math.exp((-paramFloat1 - 42.0F) / 92.0F) * 0.2777778F) * f5;
    }
    double d1 = paramFloat3;
    if (d1 > 1.0D) {
      paramFloat3 = 1.0F;
    } else if (d1 < 0.0D) {
      paramFloat3 = 0.0F;
    }
    localObject = new float[3];
    localObject[0] = (100.0F / f2 * paramFloat3 + 1.0F - paramFloat3);
    localObject[1] = (100.0F / f3 * paramFloat3 + 1.0F - paramFloat3);
    localObject[2] = (100.0F / f4 * paramFloat3 + 1.0F - paramFloat3);
    paramFloat3 = 1.0F / (5.0F * paramFloat1 + 1.0F);
    paramFloat3 = paramFloat3 * paramFloat3 * paramFloat3 * paramFloat3;
    float f6 = 1.0F - paramFloat3;
    paramFloat1 = paramFloat3 * paramFloat1 + 0.1F * f6 * f6 * (float)Math.cbrt(paramFloat1 * 5.0D);
    paramFloat2 = b.h(paramFloat2) / paramArrayOfFloat[1];
    d1 = paramFloat2;
    paramFloat3 = (float)Math.sqrt(d1);
    f6 = 0.725F / (float)Math.pow(d1, 0.2D);
    paramArrayOfFloat = new float[3];
    paramArrayOfFloat[0] = ((float)Math.pow(localObject[0] * paramFloat1 * f2 / 100.0D, 0.42D));
    paramArrayOfFloat[1] = ((float)Math.pow(localObject[1] * paramFloat1 * f3 / 100.0D, 0.42D));
    paramArrayOfFloat[2] = ((float)Math.pow(localObject[2] * paramFloat1 * f4 / 100.0D, 0.42D));
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = (paramArrayOfFloat[0] * 400.0F / (paramArrayOfFloat[0] + 27.129999F));
    arrayOfFloat[1] = (paramArrayOfFloat[1] * 400.0F / (paramArrayOfFloat[1] + 27.129999F));
    arrayOfFloat[2] = (paramArrayOfFloat[2] * 400.0F / (paramArrayOfFloat[2] + 27.129999F));
    return new j(paramFloat2, (arrayOfFloat[0] * 2.0F + arrayOfFloat[1] + arrayOfFloat[2] * 0.05F) * f6, f6, f6, f1, f5, (float[])localObject, paramFloat1, (float)Math.pow(paramFloat1, 0.25D), paramFloat3 + 1.48F);
  }
  
  float a()
  {
    return this.a;
  }
  
  float b()
  {
    return this.d;
  }
  
  float c()
  {
    return this.h;
  }
  
  float d()
  {
    return this.i;
  }
  
  float e()
  {
    return this.f;
  }
  
  float f()
  {
    return this.b;
  }
  
  float g()
  {
    return this.e;
  }
  
  float h()
  {
    return this.c;
  }
  
  float[] i()
  {
    return this.g;
  }
  
  float j()
  {
    return this.j;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.j
 * JD-Core Version:    0.7.0.1
 */