package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class aj
  extends j
  implements Cloneable
{
  private static ArrayList<String> c;
  private String a = "";
  private ArrayList<String> b = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    if (c == null)
    {
      ArrayList localArrayList = new ArrayList();
      c = localArrayList;
      localArrayList.add("");
    }
    this.b = ((ArrayList)paramh.a(c, 1, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      parami.a(localArrayList, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.aj
 * JD-Core Version:    0.7.0.1
 */