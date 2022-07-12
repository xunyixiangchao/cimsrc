package q0;

import android.graphics.Color;

public final class a
{
  private static final ThreadLocal<double[]> a = new ThreadLocal();
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    float f1 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f5 = paramInt3 / 255.0F;
    float f6 = Math.max(f1, Math.max(f3, f5));
    float f7 = Math.min(f1, Math.min(f3, f5));
    float f2 = f6 - f7;
    float f4 = (f6 + f7) / 2.0F;
    if (f6 == f7)
    {
      f2 = 0.0F;
      f1 = f2;
    }
    else
    {
      if (f6 == f1) {
        f1 = (f3 - f5) / f2 % 6.0F;
      } else if (f6 == f3) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = 4.0F + (f1 - f3) / f2;
      }
      f3 = f2 / (1.0F - Math.abs(2.0F * f4 - 1.0F));
      f2 = f1;
      f1 = f3;
    }
    f3 = f2 * 60.0F % 360.0F;
    f2 = f3;
    if (f3 < 0.0F) {
      f2 = f3 + 360.0F;
    }
    paramArrayOfFloat[0] = l(f2, 0.0F, 360.0F);
    paramArrayOfFloat[1] = l(f1, 0.0F, 1.0F);
    paramArrayOfFloat[2] = l(f4, 0.0F, 1.0F);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 3)
    {
      double d1 = paramInt1 / 255.0D;
      if (d1 < 0.04045D) {
        d1 /= 12.92D;
      } else {
        d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      }
      double d2 = paramInt2 / 255.0D;
      if (d2 < 0.04045D) {
        d2 /= 12.92D;
      } else {
        d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      }
      double d3 = paramInt3 / 255.0D;
      if (d3 < 0.04045D) {
        d3 /= 12.92D;
      } else {
        d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D);
      }
      paramArrayOfDouble[0] = ((0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3) * 100.0D);
      paramArrayOfDouble[1] = ((0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3) * 100.0D);
      paramArrayOfDouble[2] = ((d1 * 0.0193D + d2 * 0.1192D + d3 * 0.9505D) * 100.0D);
      return;
    }
    throw new IllegalArgumentException("outXyz must have a length of 3.");
  }
  
  public static int c(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d2 = (3.2406D * paramDouble1 + -1.5372D * paramDouble2 + -0.4986D * paramDouble3) / 100.0D;
    double d1 = (-0.9689D * paramDouble1 + 1.8758D * paramDouble2 + 0.0415D * paramDouble3) / 100.0D;
    paramDouble3 = (0.0557D * paramDouble1 + -0.204D * paramDouble2 + 1.057D * paramDouble3) / 100.0D;
    if (d2 > 0.0031308D) {
      paramDouble1 = Math.pow(d2, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble1 = d2 * 12.92D;
    }
    if (d1 > 0.0031308D) {
      paramDouble2 = Math.pow(d1, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble2 = d1 * 12.92D;
    }
    if (paramDouble3 > 0.0031308D) {
      paramDouble3 = Math.pow(paramDouble3, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble3 *= 12.92D;
    }
    return Color.rgb(m((int)Math.round(paramDouble1 * 255.0D), 0, 255), m((int)Math.round(paramDouble2 * 255.0D), 0, 255), m((int)Math.round(paramDouble3 * 255.0D), 0, 255));
  }
  
  public static double d(int paramInt1, int paramInt2)
  {
    if (Color.alpha(paramInt2) == 255)
    {
      int i = paramInt1;
      if (Color.alpha(paramInt1) < 255) {
        i = j(paramInt1, paramInt2);
      }
      double d1 = e(i) + 0.05D;
      double d2 = e(paramInt2) + 0.05D;
      return Math.max(d1, d2) / Math.min(d1, d2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("background can not be translucent: #");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static double e(int paramInt)
  {
    double[] arrayOfDouble = n();
    h(paramInt, arrayOfDouble);
    return arrayOfDouble[1] / 100.0D;
  }
  
  public static int f(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = Color.alpha(paramInt2);
    int j = 255;
    if (i == 255)
    {
      double d1 = d(o(paramInt1, 255), paramInt2);
      double d2 = paramFloat;
      if (d1 < d2) {
        return -1;
      }
      i = 0;
      int k = 0;
      while ((i <= 10) && (j - k > 1))
      {
        int m = (k + j) / 2;
        if (d(o(paramInt1, m), paramInt2) < d2) {
          k = m;
        } else {
          j = m;
        }
        i += 1;
      }
      return j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("background can not be translucent: #");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static void g(int paramInt, float[] paramArrayOfFloat)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
  }
  
  public static void h(int paramInt, double[] paramArrayOfDouble)
  {
    b(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
  }
  
  private static int i(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt2) * (255 - paramInt1) / 255;
  }
  
  public static int j(int paramInt1, int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = i(j, i);
    return Color.argb(k, k(Color.red(paramInt1), j, Color.red(paramInt2), i, k), k(Color.green(paramInt1), j, Color.green(paramInt2), i, k), k(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  private static int k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  private static float l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > paramFloat3) {
      paramFloat2 = paramFloat3;
    }
    return paramFloat2;
  }
  
  private static int m(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > paramInt3) {
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  private static double[] n()
  {
    ThreadLocal localThreadLocal = a;
    double[] arrayOfDouble2 = (double[])localThreadLocal.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      localThreadLocal.set(arrayOfDouble1);
    }
    return arrayOfDouble1;
  }
  
  public static int o(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 255)) {
      return paramInt1 & 0xFFFFFF | paramInt2 << 24;
    }
    throw new IllegalArgumentException("alpha must be between 0 and 255.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.a
 * JD-Core Version:    0.7.0.1
 */