package com.tencent.bugly.proguard;

import java.io.Serializable;

public abstract class j
  implements Serializable
{
  public abstract void a(h paramh);
  
  public abstract void a(i parami);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.j
 * JD-Core Version:    0.7.0.1
 */