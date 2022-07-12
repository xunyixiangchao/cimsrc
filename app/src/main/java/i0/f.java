package i0;

public class f
  extends b
{
  private double[] a;
  private double[][] b;
  private double c = (0.0D / 0.0D);
  private boolean d = true;
  double[] e;
  
  public f(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    int i = paramArrayOfDouble.length;
    i = paramArrayOfDouble1[0].length;
    this.e = new double[i];
    this.a = paramArrayOfDouble;
    this.b = paramArrayOfDouble1;
    if (i > 2)
    {
      i = 0;
      double d1 = 0.0D;
      double d3;
      for (double d2 = d1; i < paramArrayOfDouble.length; d2 = d3)
      {
        double d4 = paramArrayOfDouble1[i][0];
        d3 = paramArrayOfDouble1[i][0];
        if (i > 0) {
          Math.hypot(d4 - d1, d3 - d2);
        }
        i += 1;
        d1 = d4;
      }
      this.c = 0.0D;
    }
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
        double d1 = localObject[j];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        localObject = this.b;
        return localObject[i][paramInt] * (1.0D - paramDouble) + localObject[j][paramInt] * paramDouble;
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
        double d1 = localObject[m];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        j = k;
        while (j < n)
        {
          localObject = this.b;
          paramArrayOfDouble[j] = (localObject[i][j] * (1.0D - paramDouble) + localObject[m][j] * paramDouble);
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
        double d1 = localObject[m];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        j = k;
        while (j < n)
        {
          localObject = this.b;
          paramArrayOfFloat[j] = ((float)(localObject[i][j] * (1.0D - paramDouble) + localObject[m][j] * paramDouble));
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
    int j = 0;
    double d1;
    if (paramDouble < localObject[0])
    {
      d1 = localObject[0];
      i = j;
    }
    else
    {
      int m = k - 1;
      i = j;
      d1 = paramDouble;
      if (paramDouble >= localObject[m]) {
        d1 = localObject[m];
      }
    }
    for (int i = j; i < k - 1; i = j)
    {
      localObject = this.a;
      j = i + 1;
      if (d1 <= localObject[j])
      {
        paramDouble = localObject[j];
        d1 = localObject[i];
        double d2 = localObject[i];
        localObject = this.b;
        d2 = localObject[i][paramInt];
        return (localObject[j][paramInt] - d2) / (paramDouble - d1);
      }
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
    double d1;
    if (paramDouble <= localObject[0])
    {
      d1 = localObject[0];
    }
    else
    {
      i = n - 1;
      d1 = paramDouble;
      if (paramDouble >= localObject[i]) {
        d1 = localObject[i];
      }
    }
    int k;
    for (int i = 0; i < n - 1; i = k)
    {
      localObject = this.a;
      k = i + 1;
      if (d1 <= localObject[k])
      {
        paramDouble = localObject[k];
        d1 = localObject[i];
        double d2 = localObject[i];
        while (j < m)
        {
          localObject = this.b;
          d2 = localObject[i][j];
          paramArrayOfDouble[j] = ((localObject[k][j] - d2) / (paramDouble - d1));
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
 * Qualified Name:     i0.f
 * JD-Core Version:    0.7.0.1
 */