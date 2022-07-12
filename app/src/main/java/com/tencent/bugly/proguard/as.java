package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class as
  extends j
  implements Cloneable
{
  private static ArrayList<ar> f;
  private static Map<String, String> g;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public ArrayList<ar> d = null;
  public Map<String, String> e = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    Object localObject;
    if (f == null)
    {
      f = new ArrayList();
      localObject = new ar();
      f.add(localObject);
    }
    this.d = ((ArrayList)paramh.a(f, 3, false));
    if (g == null)
    {
      localObject = new HashMap();
      g = (Map)localObject;
      ((Map)localObject).put("", "");
    }
    this.e = ((Map)paramh.a(g, 4, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      parami.a((String)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      parami.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      parami.a((Collection)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((Map)localObject, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.as
 * JD-Core Version:    0.7.0.1
 */