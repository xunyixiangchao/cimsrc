package com.tencent.bugly.proguard;

public final class ap
  extends j
  implements Cloneable
{
  public String a = "";
  private String b = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, true);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ap
 * JD-Core Version:    0.7.0.1
 */