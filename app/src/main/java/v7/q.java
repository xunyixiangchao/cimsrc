package v7;

import java.math.BigInteger;
import x7.a;
import x7.g;

public final class q
  extends l
{
  private static final Class<?>[] b = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object a;
  
  public q(Boolean paramBoolean)
  {
    t(paramBoolean);
  }
  
  public q(Number paramNumber)
  {
    t(paramNumber);
  }
  
  public q(String paramString)
  {
    t(paramString);
  }
  
  private static boolean p(q paramq)
  {
    paramq = paramq.a;
    boolean bool3 = paramq instanceof Number;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramq = (Number)paramq;
      if ((!(paramq instanceof BigInteger)) && (!(paramq instanceof Long)) && (!(paramq instanceof Integer)) && (!(paramq instanceof Short)))
      {
        bool1 = bool2;
        if (!(paramq instanceof Byte)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean r(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom(paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (q.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (q)paramObject;
      if (this.a == null) {
        return paramObject.a == null;
      }
      if ((p(this)) && (p(paramObject))) {
        return m().longValue() == paramObject.m().longValue();
      }
      Object localObject = this.a;
      if (((localObject instanceof Number)) && ((paramObject.a instanceof Number)))
      {
        double d1 = m().doubleValue();
        double d2 = paramObject.m().doubleValue();
        if (d1 != d2)
        {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return localObject.equals(paramObject.a);
    }
    return false;
  }
  
  public boolean h()
  {
    if (o()) {
      return i().booleanValue();
    }
    return Boolean.parseBoolean(n());
  }
  
  public int hashCode()
  {
    if (this.a == null) {
      return 31;
    }
    if (p(this)) {}
    Object localObject;
    for (long l = m().longValue();; l = Double.doubleToLongBits(m().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = this.a;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
  
  Boolean i()
  {
    return (Boolean)this.a;
  }
  
  public double j()
  {
    if (q()) {
      return m().doubleValue();
    }
    return Double.parseDouble(n());
  }
  
  public int k()
  {
    if (q()) {
      return m().intValue();
    }
    return Integer.parseInt(n());
  }
  
  public long l()
  {
    if (q()) {
      return m().longValue();
    }
    return Long.parseLong(n());
  }
  
  public Number m()
  {
    Object localObject = this.a;
    if ((localObject instanceof String)) {
      return new g((String)localObject);
    }
    return (Number)localObject;
  }
  
  public String n()
  {
    if (q()) {
      return m().toString();
    }
    if (o()) {
      return i().toString();
    }
    return (String)this.a;
  }
  
  public boolean o()
  {
    return this.a instanceof Boolean;
  }
  
  public boolean q()
  {
    return this.a instanceof Number;
  }
  
  public boolean s()
  {
    return this.a instanceof String;
  }
  
  void t(Object paramObject)
  {
    if ((paramObject instanceof Character)) {
      paramObject = String.valueOf(((Character)paramObject).charValue());
    }
    for (;;)
    {
      this.a = paramObject;
      return;
      boolean bool;
      if ((!(paramObject instanceof Number)) && (!r(paramObject))) {
        bool = false;
      } else {
        bool = true;
      }
      a.a(bool);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.q
 * JD-Core Version:    0.7.0.1
 */