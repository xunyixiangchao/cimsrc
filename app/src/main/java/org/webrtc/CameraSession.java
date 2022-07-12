package org.webrtc;

abstract interface CameraSession
{
  public abstract void stop();
  
  public static abstract interface CreateSessionCallback
  {
    public abstract void onDone(CameraSession paramCameraSession);
    
    public abstract void onFailure(CameraSession.FailureType paramFailureType, String paramString);
  }
  
  public static abstract interface Events
  {
    public abstract void onCameraClosed(CameraSession paramCameraSession);
    
    public abstract void onCameraDisconnected(CameraSession paramCameraSession);
    
    public abstract void onCameraError(CameraSession paramCameraSession, String paramString);
    
    public abstract void onCameraOpening();
    
    public abstract void onFrameCaptured(CameraSession paramCameraSession, VideoFrame paramVideoFrame);
  }
  
  public static enum FailureType
  {
    static
    {
      FailureType localFailureType1 = new FailureType("ERROR", 0);
      ERROR = localFailureType1;
      FailureType localFailureType2 = new FailureType("DISCONNECTED", 1);
      DISCONNECTED = localFailureType2;
      $VALUES = new FailureType[] { localFailureType1, localFailureType2 };
    }
    
    private FailureType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CameraSession
 * JD-Core Version:    0.7.0.1
 */