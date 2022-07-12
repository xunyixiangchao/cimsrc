package i0;

import java.io.PrintStream;
import java.util.Arrays;

public class c
{
  static c b = new c();
  public static String[] c = { "standard", "accelerate", "decelerate", "linear" };
  String a = "identity";
  
  public static c c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("cubic")) {
      return new a(paramString);
    }
    if (paramString.startsWith("spline")) {
      return new l(paramString);
    }
    if (paramString.startsWith("Schlick")) {
      return new i(paramString);
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1312628413: 
      if (paramString.equals("standard")) {
        i = 5;
      }
      break;
    case -749065269: 
      if (paramString.equals("overshoot")) {
        i = 4;
      }
      break;
    case -1102672091: 
      if (paramString.equals("linear")) {
        i = 3;
      }
      break;
    case -1197605014: 
      if (paramString.equals("anticipate")) {
        i = 2;
      }
      break;
    case -1263948740: 
      if (paramString.equals("decelerate")) {
        i = 1;
      }
      break;
    case -1354466595: 
      if (paramString.equals("accelerate")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramString = System.err;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
      localStringBuilder.append(Arrays.toString(c));
      paramString.println(localStringBuilder.toString());
      return b;
    case 5: 
      return new a("cubic(0.4, 0.0, 0.2, 1)");
    case 4: 
      return new a("cubic(0.34, 1.56, 0.64, 1)");
    case 3: 
      return new a("cubic(1, 1, 0, 0)");
    case 2: 
      return new a("cubic(0.36, 0, 0.66, -0.56)");
    case 1: 
      return new a("cubic(0.0, 0.0, 0.2, 0.95)");
    }
    return new a("cubic(0.4, 0.05, 0.8, 0.7)");
  }
  
  public double a(double paramDouble)
  {
    return paramDouble;
  }
  
  public double b(double paramDouble)
  {
    return 1.0D;
  }
  
  public String toString()
  {
    return this.a;
  }
  
  static class a
    extends c
  {
    private static double h = 0.01D;
    private static double i = 0.0001D;
    double d;
    double e;
    double f;
    double g;
    
    a(String paramString)
    {
      this.a = paramString;
      int j = paramString.indexOf('(');
      int k = paramString.indexOf(',', j);
      this.d = Double.parseDouble(paramString.substring(j + 1, k).trim());
      j = k + 1;
      k = paramString.indexOf(',', j);
      this.e = Double.parseDouble(paramString.substring(j, k).trim());
      j = k + 1;
      k = paramString.indexOf(',', j);
      this.f = Double.parseDouble(paramString.substring(j, k).trim());
      j = k + 1;
      this.g = Double.parseDouble(paramString.substring(j, paramString.indexOf(')', j)).trim());
    }
    
    private double d(double paramDouble)
    {
      double d1 = 1.0D - paramDouble;
      double d2 = 3.0D * d1;
      return this.d * (d1 * d2 * paramDouble) + this.f * (d2 * paramDouble * paramDouble) + paramDouble * paramDouble * paramDouble;
    }
    
    private double e(double paramDouble)
    {
      double d1 = 1.0D - paramDouble;
      double d2 = 3.0D * d1;
      return this.e * (d1 * d2 * paramDouble) + this.g * (d2 * paramDouble * paramDouble) + paramDouble * paramDouble * paramDouble;
    }
    
    public double a(double paramDouble)
    {
      if (paramDouble <= 0.0D) {
        return 0.0D;
      }
      if (paramDouble >= 1.0D) {
        return 1.0D;
      }
      double d2 = 0.5D;
      double d1 = d2;
      while (d2 > h)
      {
        d3 = d(d1);
        d2 *= 0.5D;
        if (d3 < paramDouble) {
          d1 += d2;
        } else {
          d1 -= d2;
        }
      }
      double d4 = d1 - d2;
      double d3 = d(d4);
      d1 += d2;
      d2 = d(d1);
      d4 = e(d4);
      return (e(d1) - d4) * (paramDouble - d3) / (d2 - d3) + d4;
    }
    
    public double b(double paramDouble)
    {
      double d2 = 0.5D;
      double d1 = d2;
      while (d2 > i)
      {
        d3 = d(d1);
        d2 *= 0.5D;
        if (d3 < paramDouble) {
          d1 += d2;
        } else {
          d1 -= d2;
        }
      }
      double d3 = d1 - d2;
      paramDouble = d(d3);
      d1 += d2;
      d2 = d(d1);
      d3 = e(d3);
      return (e(d1) - d3) / (d2 - paramDouble);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.c
 * JD-Core Version:    0.7.0.1
 */