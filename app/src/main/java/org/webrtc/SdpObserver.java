package org.webrtc;

public abstract interface SdpObserver
{
  @CalledByNative
  public abstract void onCreateFailure(String paramString);
  
  @CalledByNative
  public abstract void onCreateSuccess(SessionDescription paramSessionDescription);
  
  @CalledByNative
  public abstract void onSetFailure(String paramString);
  
  @CalledByNative
  public abstract void onSetSuccess();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SdpObserver
 * JD-Core Version:    0.7.0.1
 */