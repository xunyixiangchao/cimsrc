package com.bumptech.glide;

import v2.a;
import v2.c;

public abstract class l<CHILD extends l<CHILD, TranscodeType>, TranscodeType>
  implements Cloneable
{
  private c<? super TranscodeType> a = a.b();
  
  public final CHILD a()
  {
    try
    {
      l locall = (l)super.clone();
      return locall;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  final c<? super TranscodeType> b()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.l
 * JD-Core Version:    0.7.0.1
 */