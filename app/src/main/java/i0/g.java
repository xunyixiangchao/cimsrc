package i0;

import java.lang.reflect.Array;
import java.util.Arrays;

public class g
  extends b
{
  private double[] a;
  private double[][] b;
  private double[][] c;
  private boolean d = true;
  double[] e;
  
  public g(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    int i1 = paramArrayOfDouble.length;
    int m = paramArrayOfDouble1[0].length;
    this.e = new double[m];
    int n = i1 - 1;
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { n, m });
    double[][] arrayOfDouble2 = (double[][])Array.newInstance(Double.TYPE, new int[] { i1, m });
    int i = 0;
    int j;
    int k;
    double d1;
    double d2;
    while (i < m)
    {
      for (j = 0; j < n; j = k)
      {
        k = j + 1;
        d1 = paramArrayOfDouble[k];
        d2 = paramArrayOfDouble[j];
        arrayOfDouble1[j][i] = ((paramArrayOfDouble1[k][i] - paramArrayOfDouble1[j][i]) / (d1 - d2));
        if (j == 0) {
          arrayOfDouble2[j][i] = arrayOfDouble1[j][i];
        } else {
          arrayOfDouble2[j][i] = ((arrayOfDouble1[(j - 1)][i] + arrayOfDouble1[j][i]) * 0.5D);
        }
      }
      arrayOfDouble2[n][i] = arrayOfDouble1[(i1 - 2)][i];
      i += 1;
    }
    i = 0;
    while (i < n)
    {
      j = 0;
      while (j < m)
      {
        if (arrayOfDouble1[i][j] == 0.0D)
        {
          arrayOfDouble2[i][j] = 0L;
          arrayOfDouble2[(i + 1)][j] = 0L;
        }
        else
        {
          d1 = arrayOfDouble2[i][j] / arrayOfDouble1[i][j];
          k = i + 1;
          d2 = arrayOfDouble2[k][j] / arrayOfDouble1[i][j];
          double d3 = Math.hypot(d1, d2);
          if (d3 > 9.0D)
          {
            d3 = 3.0D / d3;
            arrayOfDouble2[i][j] = (d1 * d3 * arrayOfDouble1[i][j]);
            arrayOfDouble2[k][j] = (d3 * d2 * arrayOfDouble1[i][j]);
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.a = paramArrayOfDouble;
    this.b = paramArrayOfDouble1;
    this.c = arrayOfDouble2;
  }
  
  public static g i(String paramString)
  {
    double[] arrayOfDouble = new double[paramString.length() / 2];
    int j = paramString.indexOf('(') + 1;
    int k = paramString.indexOf(',', j);
    int i = 0;
    while (k != -1)
    {
      arrayOfDouble[i] = Double.parseDouble(paramString.substring(j, k).trim());
      j = k + 1;
      k = paramString.indexOf(',', j);
      i += 1;
    }
    arrayOfDouble[i] = Double.parseDouble(paramString.substring(j, paramString.indexOf(41, j)).trim());
    return j(Arrays.copyOf(arrayOfDouble, i + 1));
  }
  
  private static g j(double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length * 3 - 2;
    int j = paramArrayOfDouble.length - 1;
    double d1 = 1.0D / j;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i, 1 });
    double[] arrayOfDouble1 = new double[i];
    i = 0;
    while (i < paramArrayOfDouble.length)
    {
      double d2 = paramArrayOfDouble[i];
      int k = i + j;
      arrayOfDouble[k][0] = d2;
      double d3 = i * d1;
      arrayOfDouble1[k] = d3;
      if (i > 0)
      {
        k = j * 2 + i;
        arrayOfDouble[k][0] = (d2 + 1.0D);
        arrayOfDouble1[k] = (d3 + 1.0D);
        k = i - 1;
        arrayOfDouble[k][0] = (d2 - 1.0D - d1);
        arrayOfDouble1[k] = (d3 - 1.0D - d1);
      }
      i += 1;
    }
    return new g(arrayOfDouble1, arrayOfDouble);
  }
  
  private static double k(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble2 * paramDouble2;
    double d2 = paramDouble2 * 6.0D;
    double d3 = 3.0D * paramDouble1;
    return -6.0D * d1 * paramDouble4 + d2 * paramDouble4 + 6.0D * d1 * paramDouble3 - d2 * paramDouble3 + d3 * paramDouble6 * d1 + d3 * paramDouble5 * d1 - 2.0D * paramDouble1 * paramDouble6 * paramDouble2 - 4.0D * paramDouble1 * paramDouble5 * paramDouble2 + paramDouble1 * paramDouble5;
  }
  
  private static double l(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble2 * paramDouble2;
    double d2 = d1 * paramDouble2;
    double d3 = 3.0D * d1;
    paramDouble6 = paramDouble1 * paramDouble6;
    double d4 = paramDouble1 * paramDouble5;
    return -2.0D * d2 * paramDouble4 + d3 * paramDouble4 + d2 * 2.0D * paramDouble3 - d3 * paramDouble3 + paramDouble3 + paramDouble6 * d2 + d2 * d4 - paramDouble6 * d1 - paramDouble1 * 2.0D * paramDouble5 * d1 + d4 * paramDouble2;
  }
  
  public double c(double paramDouble, int paramInt)
  {
    Object localObject = this.a;
    int k = localObject.length;
    boolean bool = this.d;
    int i = 0;
    int j;
    if (bool)
    {
      if (paramDouble <= localObject[0]) {
        return this.b[0][paramInt] + (paramDouble - localObject[0]) * f(localObject[0], paramInt);
      }
      j = k - 1;
      if (paramDouble >= localObject[j]) {
        return this.b[j][paramInt] + (paramDouble - localObject[j]) * f(localObject[j], paramInt);
      }
    }
    else
    {
      if (paramDouble <= localObject[0]) {
        return this.b[0][paramInt];
      }
      j = k - 1;
      if (paramDouble >= localObject[j]) {
        return this.b[j][paramInt];
      }
    }
    while (i < k - 1)
    {
      localObject = this.a;
      if (paramDouble == localObject[i]) {
        return this.b[i][paramInt];
      }
      j = i + 1;
      if (paramDouble < localObject[j])
      {
        double d1 = localObject[j] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        localObject = this.b;
        double d2 = localObject[i][paramInt];
        double d3 = localObject[j][paramInt];
        localObject = this.c;
        return l(d1, paramDouble, d2, d3, localObject[i][paramInt], localObject[j][paramInt]);
      }
      i = j;
    }
    return 0.0D;
  }
  
  public void d(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.a;
    int i1 = localObject.length;
    double[][] arrayOfDouble = this.b;
    int j = 0;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    int m;
    if (this.d)
    {
      if (paramDouble <= localObject[0])
      {
        g(localObject[0], this.e);
        i = 0;
        while (i < n)
        {
          paramArrayOfDouble[i] = (this.b[0][i] + (paramDouble - this.a[0]) * this.e[i]);
          i += 1;
        }
        return;
      }
      j = i1 - 1;
      if (paramDouble >= localObject[j])
      {
        g(localObject[j], this.e);
        while (i < n)
        {
          paramArrayOfDouble[i] = (this.b[j][i] + (paramDouble - this.a[j]) * this.e[i]);
          i += 1;
        }
      }
    }
    else
    {
      if (paramDouble <= localObject[0])
      {
        i = 0;
        while (i < n)
        {
          paramArrayOfDouble[i] = this.b[0][i];
          i += 1;
        }
        return;
      }
      m = i1 - 1;
      if (paramDouble >= localObject[m])
      {
        i = j;
        while (i < n)
        {
          paramArrayOfDouble[i] = this.b[m][i];
          i += 1;
        }
        return;
      }
    }
    for (i = 0; i < i1 - 1; i = m)
    {
      if (paramDouble == this.a[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfDouble[j] = this.b[i][j];
          j += 1;
        }
      }
      localObject = this.a;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        j = k;
        while (j < n)
        {
          localObject = this.b;
          double d2 = localObject[i][j];
          double d3 = localObject[m][j];
          localObject = this.c;
          paramArrayOfDouble[j] = l(d1, paramDouble, d2, d3, localObject[i][j], localObject[m][j]);
          j += 1;
        }
        return;
      }
    }
  }
  
  public void e(double paramDouble, float[] paramArrayOfFloat)
  {
    Object localObject = this.a;
    int i1 = localObject.length;
    double[][] arrayOfDouble = this.b;
    int j = 0;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    int m;
    if (this.d)
    {
      if (paramDouble <= localObject[0])
      {
        g(localObject[0], this.e);
        i = 0;
        while (i < n)
        {
          paramArrayOfFloat[i] = ((float)(this.b[0][i] + (paramDouble - this.a[0]) * this.e[i]));
          i += 1;
        }
        return;
      }
      j = i1 - 1;
      if (paramDouble >= localObject[j])
      {
        g(localObject[j], this.e);
        while (i < n)
        {
          paramArrayOfFloat[i] = ((float)(this.b[j][i] + (paramDouble - this.a[j]) * this.e[i]));
          i += 1;
        }
      }
    }
    else
    {
      if (paramDouble <= localObject[0])
      {
        i = 0;
        while (i < n)
        {
          paramArrayOfFloat[i] = ((float)this.b[0][i]);
          i += 1;
        }
        return;
      }
      m = i1 - 1;
      if (paramDouble >= localObject[m])
      {
        i = j;
        while (i < n)
        {
          paramArrayOfFloat[i] = ((float)this.b[m][i]);
          i += 1;
        }
        return;
      }
    }
    for (i = 0; i < i1 - 1; i = m)
    {
      if (paramDouble == this.a[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfFloat[j] = ((float)this.b[i][j]);
          j += 1;
        }
      }
      localObject = this.a;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        j = k;
        while (j < n)
        {
          localObject = this.b;
          double d2 = localObject[i][j];
          double d3 = localObject[m][j];
          localObject = this.c;
          paramArrayOfFloat[j] = ((float)l(d1, paramDouble, d2, d3, localObject[i][j], localObject[m][j]));
          j += 1;
        }
        return;
      }
    }
  }
  
  public double f(double paramDouble, int paramInt)
  {
    Object localObject = this.a;
    int k = localObject.length;
    int i = 0;
    int j;
    if (paramDouble < localObject[0])
    {
      paramDouble = localObject[0];
    }
    else
    {
      j = k - 1;
      if (paramDouble >= localObject[j]) {
        paramDouble = localObject[j];
      }
    }
    while (i < k - 1)
    {
      localObject = this.a;
      j = i + 1;
      if (paramDouble <= localObject[j])
      {
        double d1 = localObject[j] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        localObject = this.b;
        double d2 = localObject[i][paramInt];
        double d3 = localObject[j][paramInt];
        localObject = this.c;
        return k(d1, paramDouble, d2, d3, localObject[i][paramInt], localObject[j][paramInt]) / d1;
      }
      i = j;
    }
    return 0.0D;
  }
  
  public void g(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.a;
    int n = localObject.length;
    double[][] arrayOfDouble = this.b;
    int j = 0;
    int m = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      paramDouble = localObject[0];
    }
    else
    {
      i = n - 1;
      if (paramDouble >= localObject[i]) {
        paramDouble = localObject[i];
      }
    }
    int k;
    for (int i = 0; i < n - 1; i = k)
    {
      localObject = this.a;
      k = i + 1;
      if (paramDouble <= localObject[k])
      {
        double d1 = localObject[k] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        while (j < m)
        {
          localObject = this.b;
          double d2 = localObject[i][j];
          double d3 = localObject[k][j];
          localObject = this.c;
          paramArrayOfDouble[j] = (k(d1, paramDouble, d2, d3, localObject[i][j], localObject[k][j]) / d1);
          j += 1;
        }
      }
    }
  }
  
  public double[] h()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.g
 * JD-Core Version:    0.7.0.1
 */