package org.webrtc;

import android.content.Context;

public class Camera1Capturer
  extends CameraCapturer
{
  private final boolean captureToTexture;
  
  public Camera1Capturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler, boolean paramBoolean)
  {
    super(paramString, paramCameraEventsHandler, new Camera1Enumerator(paramBoolean));
    this.captureToTexture = paramBoolean;
  }
  
  protected void createCameraSession(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Camera1Session.create(paramCreateSessionCallback, paramEvents, this.captureToTexture, paramContext, paramSurfaceTextureHelper, Camera1Enumerator.getCameraIndex(paramString), paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Camera1Capturer
 * JD-Core Version:    0.7.0.1
 */