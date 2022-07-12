package org.webrtc;

import android.opengl.GLES20;

public class GlTextureFrameBuffer
{
  private int frameBufferId;
  private int height;
  private final int pixelFormat;
  private int textureId;
  private int width;
  
  public GlTextureFrameBuffer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid pixel format: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.pixelFormat = paramInt;
    this.width = 0;
    this.height = 0;
  }
  
  public int getFrameBufferId()
  {
    return this.frameBufferId;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getTextureId()
  {
    return this.textureId;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void release()
  {
    GLES20.glDeleteTextures(1, new int[] { this.textureId }, 0);
    this.textureId = 0;
    GLES20.glDeleteFramebuffers(1, new int[] { this.frameBufferId }, 0);
    this.frameBufferId = 0;
    this.width = 0;
    this.height = 0;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if ((paramInt1 == this.width) && (paramInt2 == this.height)) {
        return;
      }
      this.width = paramInt1;
      this.height = paramInt2;
      if (this.textureId == 0) {
        this.textureId = GlUtil.generateTexture(3553);
      }
      if (this.frameBufferId == 0)
      {
        localObject = new int[1];
        GLES20.glGenFramebuffers(1, (int[])localObject, 0);
        this.frameBufferId = localObject[0];
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.textureId);
      int i = this.pixelFormat;
      GLES20.glTexImage2D(3553, 0, i, paramInt1, paramInt2, 0, i, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
      GLES20.glBindFramebuffer(36160, this.frameBufferId);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
      paramInt1 = GLES20.glCheckFramebufferStatus(36160);
      if (paramInt1 == 36053)
      {
        GLES20.glBindFramebuffer(36160, 0);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Framebuffer not complete, status: ");
      ((StringBuilder)localObject).append(paramInt1);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid size: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.GlTextureFrameBuffer
 * JD-Core Version:    0.7.0.1
 */