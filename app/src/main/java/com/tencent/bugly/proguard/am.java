package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class am
  extends j
  implements Cloneable
{
  private static ArrayList<al> b;
  public ArrayList<al> a = null;
  
  public final void a(h paramh)
  {
    if (b == null)
    {
      b = new ArrayList();
      al localal = new al();
      b.add(localal);
    }
    this.a = ((ArrayList)paramh.a(b, 0, true));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.am
 * JD-Core Version:    0.7.0.1
 */