package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ao
  extends j
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public long d = 0L;
  public String e = "";
  private String f = "";
  private String g = "";
  private Map<String, String> h = null;
  
  static
  {
    Object localObject = new byte[1];
    i = (byte[])localObject;
    localObject[0] = 0;
    localObject = new HashMap();
    j = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.c(2, false);
    this.f = paramh.b(3, false);
    this.d = paramh.a(this.d, 4, false);
    this.g = paramh.b(5, false);
    this.e = paramh.b(6, false);
    this.h = ((Map)paramh.a(j, 7, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      parami.a((byte[])localObject, 2);
    }
    localObject = this.f;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    parami.a(this.d, 4);
    localObject = this.g;
    if (localObject != null) {
      parami.a((String)localObject, 5);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      parami.a((Map)localObject, 7);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ao
 * JD-Core Version:    0.7.0.1
 */