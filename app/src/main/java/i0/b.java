package i0;

public abstract class b
{
  public static b a(int paramInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    if (paramArrayOfDouble.length == 1) {
      paramInt = 2;
    }
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return new f(paramArrayOfDouble, paramArrayOfDouble1);
      }
      return new a(paramArrayOfDouble[0], paramArrayOfDouble1[0]);
    }
    return new g(paramArrayOfDouble, paramArrayOfDouble1);
  }
  
  public static b b(int[] paramArrayOfInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    return new a(paramArrayOfInt, paramArrayOfDouble, paramArrayOfDouble1);
  }
  
  public abstract double c(double paramDouble, int paramInt);
  
  public abstract void d(double paramDouble, double[] paramArrayOfDouble);
  
  public abstract void e(double paramDouble, float[] paramArrayOfFloat);
  
  public abstract double f(double paramDouble, int paramInt);
  
  public abstract void g(double paramDouble, double[] paramArrayOfDouble);
  
  public abstract double[] h();
  
  static class a
    extends b
  {
    double a;
    double[] b;
    
    a(double paramDouble, double[] paramArrayOfDouble)
    {
      this.a = paramDouble;
      this.b = paramArrayOfDouble;
    }
    
    public double c(double paramDouble, int paramInt)
    {
      return this.b[paramInt];
    }
    
    public void d(double paramDouble, double[] paramArrayOfDouble)
    {
      double[] arrayOfDouble = this.b;
      System.arraycopy(arrayOfDouble, 0, paramArrayOfDouble, 0, arrayOfDouble.length);
    }
    
    public void e(double paramDouble, float[] paramArrayOfFloat)
    {
      int i = 0;
      for (;;)
      {
        double[] arrayOfDouble = this.b;
        if (i >= arrayOfDouble.length) {
          break;
        }
        paramArrayOfFloat[i] = ((float)arrayOfDouble[i]);
        i += 1;
      }
    }
    
    public double f(double paramDouble, int paramInt)
    {
      return 0.0D;
    }
    
    public void g(double paramDouble, double[] paramArrayOfDouble)
    {
      int i = 0;
      while (i < this.b.length)
      {
        paramArrayOfDouble[i] = 0.0D;
        i += 1;
      }
    }
    
    public double[] h()
    {
      return new double[] { this.a };
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.b
 * JD-Core Version:    0.7.0.1
 */