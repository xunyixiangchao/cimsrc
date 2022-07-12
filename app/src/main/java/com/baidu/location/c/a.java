package com.baidu.location.c;

import java.util.Locale;

public class a
{
  public int a;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public long g;
  public int h;
  public char i;
  public int j;
  public int k;
  public int l;
  public String m;
  public String n;
  public String o;
  private boolean p;
  
  public a()
  {
    this.a = -1;
    this.b = -1L;
    this.c = -1;
    this.d = -1;
    this.e = 2147483647;
    this.f = 2147483647;
    this.g = 0L;
    this.h = -1;
    this.i = '0';
    this.j = 2147483647;
    this.k = 0;
    this.l = 0;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = false;
    this.g = System.currentTimeMillis();
  }
  
  public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, char paramChar, int paramInt5)
  {
    this.e = 2147483647;
    this.f = 2147483647;
    this.g = 0L;
    this.j = 2147483647;
    this.k = 0;
    this.l = 0;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = false;
    this.a = paramInt1;
    this.b = paramLong;
    this.c = paramInt2;
    this.d = paramInt3;
    this.h = paramInt4;
    this.i = paramChar;
    this.g = System.currentTimeMillis();
    this.j = paramInt5;
  }
  
  public a(a parama)
  {
    this(parama.a, parama.b, parama.c, parama.d, parama.h, parama.i, parama.j);
    this.g = parama.g;
    this.m = parama.m;
    this.k = parama.k;
    this.o = parama.o;
    this.l = parama.l;
    this.n = parama.n;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.g;
    return (l1 - l2 > 0L) && (l1 - l2 < 3000L);
  }
  
  public boolean a(a parama)
  {
    if ((this.a == parama.a) && (this.b == parama.b) && (this.d == parama.d) && (this.c == parama.c))
    {
      String str = this.n;
      if (((str != null) && (str.equals(parama.n))) || ((this.n == null) && (parama.n == null))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.a > -1) && (this.b > 0L);
  }
  
  public boolean c()
  {
    return (this.a == -1) && (this.b == -1L) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean d()
  {
    return (this.a > -1) && (this.b > -1L) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean e()
  {
    return (this.a > -1) && (this.b > -1L) && (this.d > -1) && (this.c > -1);
  }
  
  public void f()
  {
    this.p = true;
  }
  
  public String g()
  {
    return String.format(Locale.CHINA, "%d|%d|%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b) });
  }
  
  public String h()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d&clp=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k) }));
    localStringBuffer.append("&cl_t=");
    localStringBuffer.append(this.g);
    if (this.j != 2147483647)
    {
      localStringBuffer.append("&cl_cs=");
      localStringBuffer.append(this.j);
    }
    if (this.p) {
      localStringBuffer.append("&newcl=1");
    }
    localStringBuffer.append("&cl_api=");
    localStringBuffer.append(this.l);
    if (this.o != null)
    {
      localStringBuffer.append("&clnrs=");
      localStringBuffer.append(this.o);
    }
    localStringBuffer.append("&cl_list=");
    localStringBuffer.append(b.i());
    return localStringBuffer.toString();
  }
  
  public String i()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw2=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k), Long.valueOf(this.g) }));
    if (this.j != 2147483647)
    {
      localStringBuffer.append("&cl_cs2=");
      localStringBuffer.append(this.j);
    }
    if (this.o != null)
    {
      localStringBuffer.append("&clnrs2=");
      localStringBuffer.append(this.o);
    }
    return localStringBuffer.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.a
 * JD-Core Version:    0.7.0.1
 */