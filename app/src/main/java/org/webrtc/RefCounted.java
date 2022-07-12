package org.webrtc;

public abstract interface RefCounted
{
  @CalledByNative
  public abstract void release();
  
  @CalledByNative
  public abstract void retain();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RefCounted
 * JD-Core Version:    0.7.0.1
 */