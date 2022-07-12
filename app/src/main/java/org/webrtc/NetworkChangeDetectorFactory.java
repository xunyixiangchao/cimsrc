package org.webrtc;

import android.content.Context;

public abstract interface NetworkChangeDetectorFactory
{
  public abstract NetworkChangeDetector create(NetworkChangeDetector.Observer paramObserver, Context paramContext);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NetworkChangeDetectorFactory
 * JD-Core Version:    0.7.0.1
 */