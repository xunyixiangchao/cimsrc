package org.webrtc;

import android.opengl.EGLContext;

public abstract interface EglBase14
  extends EglBase
{
  public static abstract interface Context
    extends EglBase.Context
  {
    public abstract EGLContext getRawContext();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglBase14
 * JD-Core Version:    0.7.0.1
 */