package i0;

public class i
  extends c
{
  double d;
  double e;
  
  i(String paramString)
  {
    this.a = paramString;
    int i = paramString.indexOf('(');
    int j = paramString.indexOf(',', i);
    this.d = Double.parseDouble(paramString.substring(i + 1, j).trim());
    i = j + 1;
    this.e = Double.parseDouble(paramString.substring(i, paramString.indexOf(',', i)).trim());
  }
  
  private double d(double paramDouble)
  {
    double d1 = this.e;
    if (paramDouble < d1)
    {
      d2 = this.d;
      return d2 * d1 * d1 / (((d1 - paramDouble) * d2 + paramDouble) * (d2 * (d1 - paramDouble) + paramDouble));
    }
    double d2 = this.d;
    return (d1 - 1.0D) * d2 * (d1 - 1.0D) / ((-d2 * (d1 - paramDouble) - paramDouble + 1.0D) * (-d2 * (d1 - paramDouble) - paramDouble + 1.0D));
  }
  
  private double e(double paramDouble)
  {
    double d1 = this.e;
    if (paramDouble < d1) {
      return d1 * paramDouble / (paramDouble + this.d * (d1 - paramDouble));
    }
    return (1.0D - d1) * (paramDouble - 1.0D) / (1.0D - paramDouble - this.d * (d1 - paramDouble));
  }
  
  public double a(double paramDouble)
  {
    return e(paramDouble);
  }
  
  public double b(double paramDouble)
  {
    return d(paramDouble);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.i
 * JD-Core Version:    0.7.0.1
 */