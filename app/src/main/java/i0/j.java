package i0;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class j
{
  protected b a;
  protected int[] b = new int[10];
  protected float[] c = new float[10];
  private int d;
  private String e;
  
  public float a(float paramFloat)
  {
    return (float)this.a.c(paramFloat, 0);
  }
  
  public float b(float paramFloat)
  {
    return (float)this.a.f(paramFloat, 0);
  }
  
  public void c(int paramInt, float paramFloat)
  {
    Object localObject = this.b;
    if (localObject.length < this.d + 1)
    {
      this.b = Arrays.copyOf((int[])localObject, localObject.length * 2);
      localObject = this.c;
      this.c = Arrays.copyOf((float[])localObject, localObject.length * 2);
    }
    localObject = this.b;
    int i = this.d;
    localObject[i] = paramInt;
    this.c[i] = paramFloat;
    this.d = (i + 1);
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public void e(int paramInt)
  {
    int i = this.d;
    if (i == 0) {
      return;
    }
    a.a(this.b, this.c, 0, i - 1);
    i = 1;
    int k;
    for (int j = i; i < this.d; j = k)
    {
      localObject = this.b;
      k = j;
      if (localObject[(i - 1)] != localObject[i]) {
        k = j + 1;
      }
      i += 1;
    }
    Object localObject = new double[j];
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 1 });
    i = 0;
    j = i;
    while (i < this.d)
    {
      if (i > 0)
      {
        int[] arrayOfInt = this.b;
        if (arrayOfInt[i] == arrayOfInt[(i - 1)]) {}
      }
      else
      {
        localObject[j] = (this.b[i] * 0.01D);
        arrayOfDouble[j][0] = this.c[i];
        j += 1;
      }
      i += 1;
    }
    this.a = b.a(paramInt, (double[])localObject, arrayOfDouble);
  }
  
  public String toString()
  {
    String str = this.e;
    DecimalFormat localDecimalFormat = new DecimalFormat("##.##");
    int i = 0;
    while (i < this.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("[");
      localStringBuilder.append(this.b[i]);
      localStringBuilder.append(" , ");
      localStringBuilder.append(localDecimalFormat.format(this.c[i]));
      localStringBuilder.append("] ");
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  private static class a
  {
    static void a(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = new int[paramArrayOfInt.length + 10];
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      paramInt1 = 2;
      while (paramInt1 > 0)
      {
        paramInt1 -= 1;
        int i = arrayOfInt[paramInt1];
        paramInt2 = paramInt1 - 1;
        int j = arrayOfInt[paramInt2];
        paramInt1 = paramInt2;
        if (i < j)
        {
          int k = b(paramArrayOfInt, paramArrayOfFloat, i, j);
          paramInt1 = paramInt2 + 1;
          arrayOfInt[paramInt2] = (k - 1);
          paramInt2 = paramInt1 + 1;
          arrayOfInt[paramInt1] = i;
          i = paramInt2 + 1;
          arrayOfInt[paramInt2] = j;
          paramInt1 = i + 1;
          arrayOfInt[i] = (k + 1);
        }
      }
    }
    
    private static int b(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      int k = paramArrayOfInt[paramInt2];
      int j;
      for (int i = paramInt1; paramInt1 < paramInt2; i = j)
      {
        j = i;
        if (paramArrayOfInt[paramInt1] <= k)
        {
          c(paramArrayOfInt, paramArrayOfFloat, i, paramInt1);
          j = i + 1;
        }
        paramInt1 += 1;
      }
      c(paramArrayOfInt, paramArrayOfFloat, i, paramInt2);
      return i;
    }
    
    private static void c(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
      paramArrayOfInt[paramInt2] = i;
      float f = paramArrayOfFloat[paramInt1];
      paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
      paramArrayOfFloat[paramInt2] = f;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.j
 * JD-Core Version:    0.7.0.1
 */