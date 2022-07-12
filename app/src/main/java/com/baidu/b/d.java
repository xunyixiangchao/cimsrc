package com.baidu.b;

import java.util.Comparator;

class d
  implements Comparator
{
  d(c paramc) {}
  
  public int a(b paramb1, b paramb2)
  {
    int i = paramb2.b - paramb1.b;
    if (i == 0)
    {
      boolean bool = paramb1.d;
      if ((bool) && (paramb2.d)) {
        return 0;
      }
      if (bool) {
        return -1;
      }
      if (paramb2.d) {
        return 1;
      }
    }
    return i;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.d
 * JD-Core Version:    0.7.0.1
 */