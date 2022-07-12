package i0;

import java.util.Arrays;

public class h
{
  float[] a = new float[0];
  double[] b = new double[0];
  double[] c;
  String d;
  g e;
  int f;
  double g = 6.283185307179586D;
  private boolean h = false;
  
  public void a(double paramDouble, float paramFloat)
  {
    int k = this.a.length + 1;
    int j = Arrays.binarySearch(this.b, paramDouble);
    int i = j;
    if (j < 0) {
      i = -j - 1;
    }
    this.b = Arrays.copyOf(this.b, k);
    this.a = Arrays.copyOf(this.a, k);
    this.c = new double[k];
    double[] arrayOfDouble = this.b;
    System.arraycopy(arrayOfDouble, i, arrayOfDouble, i + 1, k - i - 1);
    this.b[i] = paramDouble;
    this.a[i] = paramFloat;
    this.h = false;
  }
  
  double b(double paramDouble)
  {
    double d2 = 0.0D;
    double d1;
    if (paramDouble <= 0.0D)
    {
      d1 = 1.E-005D;
    }
    else
    {
      d1 = paramDouble;
      if (paramDouble >= 1.0D) {
        d1 = 0.999999D;
      }
    }
    int i = Arrays.binarySearch(this.b, d1);
    if (i > 0) {
      return 0.0D;
    }
    paramDouble = d2;
    if (i != 0)
    {
      i = -i - 1;
      float[] arrayOfFloat = this.a;
      float f1 = arrayOfFloat[i];
      int j = i - 1;
      paramDouble = f1 - arrayOfFloat[j];
      double[] arrayOfDouble = this.b;
      paramDouble /= (arrayOfDouble[i] - arrayOfDouble[j]);
      paramDouble = arrayOfFloat[j] - paramDouble * arrayOfDouble[j] + d1 * paramDouble;
    }
    return paramDouble;
  }
  
  double c(double paramDouble)
  {
    double d2 = 0.0D;
    double d1;
    if (paramDouble < 0.0D)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = paramDouble;
      if (paramDouble > 1.0D) {
        d1 = 1.0D;
      }
    }
    int i = Arrays.binarySearch(this.b, d1);
    if (i > 0) {
      return 1.0D;
    }
    paramDouble = d2;
    if (i != 0)
    {
      i = -i - 1;
      float[] arrayOfFloat = this.a;
      float f1 = arrayOfFloat[i];
      int j = i - 1;
      paramDouble = f1 - arrayOfFloat[j];
      double[] arrayOfDouble = this.b;
      paramDouble /= (arrayOfDouble[i] - arrayOfDouble[j]);
      paramDouble = this.c[j] + (arrayOfFloat[j] - arrayOfDouble[j] * paramDouble) * (d1 - arrayOfDouble[j]) + paramDouble * (d1 * d1 - arrayOfDouble[j] * arrayOfDouble[j]) / 2.0D;
    }
    return paramDouble;
  }
  
  public double d(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramDouble2 += c(paramDouble1);
    paramDouble1 = b(paramDouble1) + paramDouble3;
    switch (this.f)
    {
    default: 
      paramDouble3 = this.g;
      return paramDouble1 * paramDouble3 * Math.cos(paramDouble3 * paramDouble2);
    case 7: 
      return this.e.f(paramDouble2 % 1.0D, 0);
    case 6: 
      return paramDouble1 * 4.0D * ((paramDouble2 * 4.0D + 2.0D) % 4.0D - 2.0D);
    case 5: 
      paramDouble3 = this.g;
      return -paramDouble3 * paramDouble1 * Math.sin(paramDouble3 * paramDouble2);
    case 4: 
      return -paramDouble1 * 2.0D;
    case 3: 
      return paramDouble1 * 2.0D;
    case 2: 
      return paramDouble1 * 4.0D * Math.signum((paramDouble2 * 4.0D + 3.0D) % 4.0D - 2.0D);
    }
    return 0.0D;
  }
  
  public double e(double paramDouble1, double paramDouble2)
  {
    paramDouble1 = c(paramDouble1) + paramDouble2;
    switch (this.f)
    {
    default: 
      return Math.sin(this.g * paramDouble1);
    case 7: 
      return this.e.c(paramDouble1 % 1.0D, 0);
    case 6: 
      paramDouble1 = 1.0D - Math.abs(paramDouble1 * 4.0D % 4.0D - 2.0D);
      paramDouble1 *= paramDouble1;
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return 1.0D - paramDouble1;
        return Math.cos(this.g * (paramDouble2 + paramDouble1));
        paramDouble1 = (paramDouble1 * 2.0D + 1.0D) % 2.0D;
        continue;
        return (paramDouble1 * 2.0D + 1.0D) % 2.0D - 1.0D;
        paramDouble1 = Math.abs((paramDouble1 * 4.0D + 1.0D) % 4.0D - 2.0D);
      }
    }
    return Math.signum(0.5D - paramDouble1 % 1.0D);
  }
  
  public void f()
  {
    int i = 0;
    double d1 = 0.0D;
    Object localObject;
    for (;;)
    {
      localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      d1 += localObject[i];
      i += 1;
    }
    double d2 = 0.0D;
    i = 1;
    int j;
    float f1;
    for (;;)
    {
      localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      j = i - 1;
      f1 = (localObject[j] + localObject[i]) / 2.0F;
      localObject = this.b;
      d2 += (localObject[i] - localObject[j]) * f1;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = ((float)(localObject[i] * (d1 / d2)));
      i += 1;
    }
    this.c[0] = 0.0D;
    i = 1;
    for (;;)
    {
      localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      j = i - 1;
      f1 = (localObject[j] + localObject[i]) / 2.0F;
      localObject = this.b;
      d1 = localObject[i];
      d2 = localObject[j];
      localObject = this.c;
      localObject[j] += (d1 - d2) * f1;
      i += 1;
    }
    this.h = true;
  }
  
  public void g(int paramInt, String paramString)
  {
    this.f = paramInt;
    this.d = paramString;
    if (paramString != null) {
      this.e = g.i(paramString);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pos =");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(" period=");
    localStringBuilder.append(Arrays.toString(this.a));
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.h
 * JD-Core Version:    0.7.0.1
 */