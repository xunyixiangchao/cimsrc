package org.webrtc;

import java.util.List;

public abstract interface CameraEnumerator
{
  public abstract CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler);
  
  public abstract String[] getDeviceNames();
  
  public abstract List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString);
  
  public abstract boolean isBackFacing(String paramString);
  
  public abstract boolean isFrontFacing(String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CameraEnumerator
 * JD-Core Version:    0.7.0.1
 */