package i0;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class l
  extends c
{
  g d;
  
  l(String paramString)
  {
    this.a = paramString;
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
    this.d = d(Arrays.copyOf(arrayOfDouble, i + 1));
  }
  
  private static g d(double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length * 3 - 2;
    int j = paramArrayOfDouble.length - 1;
    double d1 = 1.0D / j;
    Object localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { i, 1 });
    Object localObject2 = new double[i];
    i = 0;
    while (i < paramArrayOfDouble.length)
    {
      double d2 = paramArrayOfDouble[i];
      int k = i + j;
      localObject1[k][0] = d2;
      double d3 = i * d1;
      localObject2[k] = d3;
      if (i > 0)
      {
        k = j * 2 + i;
        localObject1[k][0] = (d2 + 1.0D);
        localObject2[k] = (d3 + 1.0D);
        k = i - 1;
        localObject1[k][0] = (d2 - 1.0D - d1);
        localObject2[k] = (d3 - 1.0D - d1);
      }
      i += 1;
    }
    paramArrayOfDouble = new g((double[])localObject2, (double[][])localObject1);
    localObject1 = System.out;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" 0 ");
    ((StringBuilder)localObject2).append(paramArrayOfDouble.c(0.0D, 0));
    ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    localObject1 = System.out;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" 1 ");
    ((StringBuilder)localObject2).append(paramArrayOfDouble.c(1.0D, 0));
    ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    return paramArrayOfDouble;
  }
  
  public double a(double paramDouble)
  {
    return this.d.c(paramDouble, 0);
  }
  
  public double b(double paramDouble)
  {
    return this.d.f(paramDouble, 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.l
 * JD-Core Version:    0.7.0.1
 */