package com.tencent.bugly.crashreport.crash.anr;

public final class c
{
  private String a = "";
  private long b;
  private String c = "";
  private boolean d = false;
  
  public c(String paramString, long paramLong)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.c = paramString;
    this.b = paramLong;
    this.d = false;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final void a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.a = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final long c()
  {
    return this.b;
  }
  
  public final boolean d()
  {
    return this.d;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.c
 * JD-Core Version:    0.7.0.1
 */