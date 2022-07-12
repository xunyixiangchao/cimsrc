package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import java.nio.ByteBuffer;

public class VideoFrameDrawer
{
  public static final String TAG = "VideoFrameDrawer";
  static final float[] srcPoints = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F };
  private final float[] dstPoints = new float[6];
  private VideoFrame lastI420Frame;
  private int renderHeight;
  private final Matrix renderMatrix = new Matrix();
  private final Point renderSize = new Point();
  private int renderWidth;
  private final YuvUploader yuvUploader = new YuvUploader(null);
  
  private void calculateTransformedRenderSize(int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    if (paramMatrix == null)
    {
      this.renderWidth = paramInt1;
      this.renderHeight = paramInt2;
      return;
    }
    paramMatrix.mapPoints(this.dstPoints, srcPoints);
    int i = 0;
    while (i < 3)
    {
      paramMatrix = this.dstPoints;
      int j = i * 2;
      int k = j + 0;
      paramMatrix[k] *= paramInt1;
      j += 1;
      paramMatrix[j] *= paramInt2;
      i += 1;
    }
    paramMatrix = this.dstPoints;
    this.renderWidth = distance(paramMatrix[0], paramMatrix[1], paramMatrix[2], paramMatrix[3]);
    paramMatrix = this.dstPoints;
    this.renderHeight = distance(paramMatrix[0], paramMatrix[1], paramMatrix[4], paramMatrix[5]);
  }
  
  private static int distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)Math.round(Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2));
  }
  
  public static void drawTexture(RendererCommon.GlDrawer paramGlDrawer, VideoFrame.TextureBuffer paramTextureBuffer, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Matrix localMatrix = new Matrix(paramTextureBuffer.getTransformMatrix());
    localMatrix.preConcat(paramMatrix);
    paramMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(localMatrix);
    int i = 1.$SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[paramTextureBuffer.getType().ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        paramGlDrawer.drawRgb(paramTextureBuffer.getTextureId(), paramMatrix, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
        return;
      }
      throw new RuntimeException("Unknown texture type.");
    }
    paramGlDrawer.drawOes(paramTextureBuffer.getTextureId(), paramMatrix, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer)
  {
    drawFrame(paramVideoFrame, paramGlDrawer, null);
  }
  
  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer, Matrix paramMatrix)
  {
    drawFrame(paramVideoFrame, paramGlDrawer, paramMatrix, 0, 0, paramVideoFrame.getRotatedWidth(), paramVideoFrame.getRotatedHeight());
  }
  
  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    calculateTransformedRenderSize(paramVideoFrame.getRotatedWidth(), paramVideoFrame.getRotatedHeight(), paramMatrix);
    if ((this.renderWidth > 0) && (this.renderHeight > 0))
    {
      boolean bool = paramVideoFrame.getBuffer() instanceof VideoFrame.TextureBuffer;
      this.renderMatrix.reset();
      this.renderMatrix.preTranslate(0.5F, 0.5F);
      if (!bool) {
        this.renderMatrix.preScale(1.0F, -1.0F);
      }
      this.renderMatrix.preRotate(paramVideoFrame.getRotation());
      this.renderMatrix.preTranslate(-0.5F, -0.5F);
      if (paramMatrix != null) {
        this.renderMatrix.preConcat(paramMatrix);
      }
      if (bool)
      {
        this.lastI420Frame = null;
        drawTexture(paramGlDrawer, (VideoFrame.TextureBuffer)paramVideoFrame.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      if (paramVideoFrame != this.lastI420Frame)
      {
        this.lastI420Frame = paramVideoFrame;
        paramVideoFrame = paramVideoFrame.getBuffer().toI420();
        this.yuvUploader.uploadFromBuffer(paramVideoFrame);
        paramVideoFrame.release();
      }
      paramGlDrawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramVideoFrame = new StringBuilder();
    paramVideoFrame.append("Illegal frame size: ");
    paramVideoFrame.append(this.renderWidth);
    paramVideoFrame.append("x");
    paramVideoFrame.append(this.renderHeight);
    Logging.w("VideoFrameDrawer", paramVideoFrame.toString());
  }
  
  public VideoFrame.Buffer prepareBufferForViewportSize(VideoFrame.Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    paramBuffer.retain();
    return paramBuffer;
  }
  
  public void release()
  {
    this.yuvUploader.release();
    this.lastI420Frame = null;
  }
  
  private static class YuvUploader
  {
    private ByteBuffer copyBuffer;
    private int[] yuvTextures;
    
    public int[] getYuvTextures()
    {
      return this.yuvTextures;
    }
    
    public void release()
    {
      this.copyBuffer = null;
      int[] arrayOfInt = this.yuvTextures;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteTextures(3, arrayOfInt, 0);
        this.yuvTextures = null;
      }
    }
    
    public int[] uploadFromBuffer(VideoFrame.I420Buffer paramI420Buffer)
    {
      int i = paramI420Buffer.getStrideY();
      int j = paramI420Buffer.getStrideU();
      int k = paramI420Buffer.getStrideV();
      ByteBuffer localByteBuffer1 = paramI420Buffer.getDataY();
      ByteBuffer localByteBuffer2 = paramI420Buffer.getDataU();
      ByteBuffer localByteBuffer3 = paramI420Buffer.getDataV();
      return uploadYuvData(paramI420Buffer.getWidth(), paramI420Buffer.getHeight(), new int[] { i, j, k }, new ByteBuffer[] { localByteBuffer1, localByteBuffer2, localByteBuffer3 });
    }
    
    public int[] uploadYuvData(int paramInt1, int paramInt2, int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer)
    {
      int[] arrayOfInt1 = new int[3];
      int j = 0;
      arrayOfInt1[0] = paramInt1;
      paramInt1 /= 2;
      arrayOfInt1[1] = paramInt1;
      arrayOfInt1[2] = paramInt1;
      int[] arrayOfInt2 = new int[3];
      arrayOfInt2[0] = paramInt2;
      paramInt1 = paramInt2 / 2;
      arrayOfInt2[1] = paramInt1;
      arrayOfInt2[2] = paramInt1;
      paramInt1 = 0;
      int i;
      for (paramInt2 = paramInt1; paramInt1 < 3; paramInt2 = i)
      {
        i = paramInt2;
        if (paramArrayOfInt[paramInt1] > arrayOfInt1[paramInt1]) {
          i = Math.max(paramInt2, arrayOfInt1[paramInt1] * arrayOfInt2[paramInt1]);
        }
        paramInt1 += 1;
      }
      ByteBuffer localByteBuffer;
      if (paramInt2 > 0)
      {
        localByteBuffer = this.copyBuffer;
        if ((localByteBuffer == null) || (localByteBuffer.capacity() < paramInt2)) {
          this.copyBuffer = ByteBuffer.allocateDirect(paramInt2);
        }
      }
      paramInt2 = j;
      if (this.yuvTextures == null)
      {
        this.yuvTextures = new int[3];
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = j;
          if (paramInt1 >= 3) {
            break;
          }
          this.yuvTextures[paramInt1] = GlUtil.generateTexture(3553);
          paramInt1 += 1;
        }
      }
      while (paramInt2 < 3)
      {
        GLES20.glActiveTexture(33984 + paramInt2);
        GLES20.glBindTexture(3553, this.yuvTextures[paramInt2]);
        if (paramArrayOfInt[paramInt2] == arrayOfInt1[paramInt2])
        {
          localByteBuffer = paramArrayOfByteBuffer[paramInt2];
        }
        else
        {
          YuvHelper.copyPlane(paramArrayOfByteBuffer[paramInt2], paramArrayOfInt[paramInt2], this.copyBuffer, arrayOfInt1[paramInt2], arrayOfInt1[paramInt2], arrayOfInt2[paramInt2]);
          localByteBuffer = this.copyBuffer;
        }
        GLES20.glTexImage2D(3553, 0, 6409, arrayOfInt1[paramInt2], arrayOfInt2[paramInt2], 0, 6409, 5121, localByteBuffer);
        paramInt2 += 1;
      }
      return this.yuvTextures;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoFrameDrawer
 * JD-Core Version:    0.7.0.1
 */