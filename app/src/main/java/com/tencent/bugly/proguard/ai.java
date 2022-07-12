package com.tencent.bugly.proguard;

public final class ai
  extends j
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  private String d = "";
  private String e = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.d = paramh.b(1, false);
    this.b = paramh.b(2, false);
    this.e = paramh.b(3, false);
    this.c = paramh.b(4, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    String str = this.d;
    if (str != null) {
      parami.a(str, 1);
    }
    str = this.b;
    if (str != null) {
      parami.a(str, 2);
    }
    str = this.e;
    if (str != null) {
      parami.a(str, 3);
    }
    str = this.c;
    if (str != null) {
      parami.a(str, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ai
 * JD-Core Version:    0.7.0.1
 */