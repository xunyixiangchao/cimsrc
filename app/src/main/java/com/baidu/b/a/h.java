package com.baidu.b.a;

import java.lang.reflect.Method;

final class h
  extends g
{
  private a f;
  
  public h(int paramInt1, int paramInt2)
  {
    this.a = 1099511627775L;
    this.b = 4;
    this.c = 32;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = new a(null);
  }
  
  public b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = a.a(this.f);
      a.a(this.f, localObject, paramArrayOfByte, paramInt1, paramInt2);
      l = a.a(this.f, localObject);
    }
    catch (Exception paramArrayOfByte)
    {
      long l;
      label35:
      break label35;
    }
    l = 4294967295L;
    return b.a(new long[] { l });
  }
  
  private static class a
  {
    private Class a;
    private Method b;
    private Method c;
    
    private a()
    {
      a();
    }
    
    private long a(Object paramObject)
    {
      try
      {
        long l = ((Long)this.c.invoke(paramObject, new Object[0])).longValue();
        return l;
      }
      catch (Exception paramObject)
      {
        label21:
        break label21;
      }
      throw new e.a("");
    }
    
    private void a()
    {
      try
      {
        this.a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
        String str = e.a(d.b());
        Class localClass1 = this.a;
        Class localClass2 = Integer.TYPE;
        this.b = e.a(localClass1, str, new Class[] { [B.class, localClass2, localClass2 });
        str = e.a(d.c());
        this.c = e.a(this.a, str, null);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    private void a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        this.b.invoke(paramObject, new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
      catch (Exception paramObject)
      {
        label33:
        break label33;
      }
      throw new e.a("");
    }
    
    private Object b()
    {
      return this.a.newInstance();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.h
 * JD-Core Version:    0.7.0.1
 */