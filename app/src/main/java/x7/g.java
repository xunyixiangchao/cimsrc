package x7;

import java.math.BigDecimal;

public final class g
  extends Number
{
  private final String a;
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.a);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof g))
    {
      Object localObject = (g)paramObject;
      paramObject = this.a;
      localObject = ((g)localObject).a;
      if (paramObject != localObject)
      {
        if (paramObject.equals(localObject)) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label10:
      long l;
      label21:
      break label10;
    }
    try
    {
      l = Long.parseLong(this.a);
      return (int)l;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label21;
    }
    return new BigDecimal(this.a).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
    return new BigDecimal(this.a).longValue();
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.g
 * JD-Core Version:    0.7.0.1
 */