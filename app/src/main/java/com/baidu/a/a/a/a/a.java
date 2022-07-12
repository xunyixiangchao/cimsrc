package com.baidu.a.a.a.a;

import android.content.Context;
import com.baidu.b.c;
import com.baidu.b.g;
import com.baidu.b.h;
import com.baidu.b.h.a;

public final class a
{
  public static boolean a = true;
  private static volatile a e;
  private final Context b;
  private h c;
  private g d;
  private c f;
  private h.a g;
  private h.a h;
  private long i;
  
  private a(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    this.b = paramContext;
    this.f = new c();
    this.c = new h(paramContext, new com.baidu.b.e.a(paramContext), this.f);
    this.d = new g(paramContext, this.f);
  }
  
  private h.a a()
  {
    h.a locala = this.h;
    if (locala != null) {
      return locala;
    }
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.i) > 3600000L)
    {
      this.h = b();
      this.i = l;
    }
    locala = this.h;
    if (locala != null) {
      return locala;
    }
    if (this.g == null) {
      this.h = c(null);
    }
    return this.h;
  }
  
  private h.a a(String paramString)
  {
    h.a locala2 = this.c.a();
    h.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = b(paramString);
    }
    return locala1;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = b(paramContext).a().b();
      return paramContext;
    }
    finally {}
  }
  
  static a b(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new a(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private h.a b()
  {
    try
    {
      h.a locala = a(null);
      return locala;
    }
    finally {}
  }
  
  private h.a b(String paramString)
  {
    paramString = this.d.a(paramString);
    if (paramString != null) {
      return this.c.a(paramString);
    }
    return null;
  }
  
  private h.a c(String paramString)
  {
    return this.c.b(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */