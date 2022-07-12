package com.baidu.location.c;

import java.util.Locale;

public class e
{
  public int a = 0;
  public String b = null;
  public String c = null;
  public int d = 0;
  public long e = 0L;
  public int f = 2147483647;
  public int g = 2147483647;
  
  public String toString()
  {
    return String.format(Locale.CHINA, "%d,%s,%s,%d,%d,%d", new Object[] { Integer.valueOf(this.a), this.b, this.c, Integer.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f) });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.e
 * JD-Core Version:    0.7.0.1
 */