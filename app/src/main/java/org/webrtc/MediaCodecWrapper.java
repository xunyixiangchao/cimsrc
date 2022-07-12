package org.webrtc;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

abstract interface MediaCodecWrapper
{
  public abstract void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract Surface createInputSurface();
  
  public abstract int dequeueInputBuffer(long paramLong);
  
  public abstract int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong);
  
  public abstract void flush();
  
  public abstract ByteBuffer[] getInputBuffers();
  
  public abstract ByteBuffer[] getOutputBuffers();
  
  public abstract MediaFormat getOutputFormat();
  
  public abstract void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void setParameters(Bundle paramBundle);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */