package org.webrtc;

import javax.microedition.khronos.egl.EGLContext;

public abstract interface EglBase10
  extends EglBase
{
  public static abstract interface Context
    extends EglBase.Context
  {
    public abstract EGLContext getRawContext();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglBase10
 * JD-Core Version:    0.7.0.1
 */