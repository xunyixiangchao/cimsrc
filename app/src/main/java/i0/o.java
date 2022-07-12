package i0;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class o
{
  protected static float k = 6.283186F;
  protected b a;
  protected int b = 0;
  protected int[] c = new int[10];
  protected float[][] d = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 3 });
  protected int e;
  protected String f;
  protected float[] g = new float[3];
  protected boolean h = false;
  protected long i;
  protected float j = (0.0F / 0.0F);
  
  protected float a(float paramFloat)
  {
    switch (this.b)
    {
    default: 
      return (float)Math.sin(paramFloat * k);
    case 6: 
      paramFloat = 1.0F - Math.abs(paramFloat * 4.0F % 4.0F - 2.0F);
      paramFloat *= paramFloat;
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return 1.0F - paramFloat;
        return (float)Math.cos(paramFloat * k);
        paramFloat = (paramFloat * 2.0F + 1.0F) % 2.0F;
        continue;
        return (paramFloat * 2.0F + 1.0F) % 2.0F - 1.0F;
        paramFloat = Math.abs(paramFloat);
      }
    }
    return Math.signum(paramFloat * k);
  }
  
  public void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3)
  {
    Object localObject = this.c;
    int m = this.e;
    localObject[m] = paramInt1;
    localObject = this.d;
    localObject[m][0] = paramFloat1;
    localObject[m][1] = paramFloat2;
    localObject[m][2] = paramFloat3;
    this.b = Math.max(this.b, paramInt2);
    this.e += 1;
  }
  
  protected void c(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public void e(int paramInt)
  {
    int m = this.e;
    if (m == 0)
    {
      localObject1 = System.err;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Error no points added to ");
      ((StringBuilder)localObject2).append(this.f);
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      return;
    }
    a.a(this.c, this.d, 0, m - 1);
    int n = 1;
    int i1;
    for (m = 0;; m = i1)
    {
      localObject1 = this.c;
      if (n >= localObject1.length) {
        break;
      }
      i1 = m;
      if (localObject1[n] != localObject1[(n - 1)]) {
        i1 = m + 1;
      }
      n += 1;
    }
    n = m;
    if (m == 0) {
      n = 1;
    }
    Object localObject1 = new double[n];
    Object localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { n, 3 });
    m = 0;
    n = m;
    while (m < this.e)
    {
      int[] arrayOfInt;
      if (m > 0)
      {
        arrayOfInt = this.c;
        if (arrayOfInt[m] == arrayOfInt[(m - 1)]) {}
      }
      else
      {
        localObject1[n] = (this.c[m] * 0.01D);
        arrayOfInt = localObject2[n];
        float[][] arrayOfFloat = this.d;
        arrayOfInt[0] = arrayOfFloat[m][0];
        localObject2[n][1] = arrayOfFloat[m][1];
        localObject2[n][2] = arrayOfFloat[m][2];
        n += 1;
      }
      m += 1;
    }
    this.a = b.a(paramInt, (double[])localObject1, (double[][])localObject2);
  }
  
  public String toString()
  {
    String str = this.f;
    DecimalFormat localDecimalFormat = new DecimalFormat("##.##");
    int m = 0;
    while (m < this.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("[");
      localStringBuilder.append(this.c[m]);
      localStringBuilder.append(" , ");
      localStringBuilder.append(localDecimalFormat.format(this.d[m]));
      localStringBuilder.append("] ");
      str = localStringBuilder.toString();
      m += 1;
    }
    return str;
  }
  
  protected static class a
  {
    static void a(int[] paramArrayOfInt, float[][] paramArrayOfFloat, int paramInt1, int paramInt2)
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
    
    private static int b(int[] paramArrayOfInt, float[][] paramArrayOfFloat, int paramInt1, int paramInt2)
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
    
    private static void c(int[] paramArrayOfInt, float[][] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
      paramArrayOfInt[paramInt2] = i;
      paramArrayOfInt = paramArrayOfFloat[paramInt1];
      paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
      paramArrayOfFloat[paramInt2] = paramArrayOfInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.o
 * JD-Core Version:    0.7.0.1
 */