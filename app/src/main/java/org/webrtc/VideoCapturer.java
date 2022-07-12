package org.webrtc;

import android.content.Context;

public abstract interface VideoCapturer
{
  public abstract void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void dispose();
  
  public abstract void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver);
  
  public abstract boolean isScreencast();
  
  public abstract void startCapture(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void stopCapture();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoCapturer
 * JD-Core Version:    0.7.0.1
 */