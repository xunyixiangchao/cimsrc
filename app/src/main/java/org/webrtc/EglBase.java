package org.webrtc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.ArrayList;

public abstract interface EglBase
{
  public static final int[] CONFIG_PIXEL_BUFFER = g.a().setSupportsPixelBuffer(true).createConfigAttributes();
  public static final int[] CONFIG_PIXEL_RGBA_BUFFER = g.a().setHasAlphaChannel(true).setSupportsPixelBuffer(true).createConfigAttributes();
  public static final int[] CONFIG_PLAIN;
  public static final int[] CONFIG_RECORDABLE = g.a().setIsRecordable(true).createConfigAttributes();
  public static final int[] CONFIG_RGBA;
  public static final int EGL_OPENGL_ES2_BIT = 4;
  public static final int EGL_OPENGL_ES3_BIT = 64;
  public static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final Object lock = new Object();
  
  static
  {
    CONFIG_PLAIN = g.a().createConfigAttributes();
    CONFIG_RGBA = g.a().setHasAlphaChannel(true).createConfigAttributes();
  }
  
  public abstract void createDummyPbufferSurface();
  
  public abstract void createPbufferSurface(int paramInt1, int paramInt2);
  
  public abstract void createSurface(SurfaceTexture paramSurfaceTexture);
  
  public abstract void createSurface(Surface paramSurface);
  
  public abstract void detachCurrent();
  
  public abstract Context getEglBaseContext();
  
  public abstract boolean hasSurface();
  
  public abstract void makeCurrent();
  
  public abstract void release();
  
  public abstract void releaseSurface();
  
  public abstract int surfaceHeight();
  
  public abstract int surfaceWidth();
  
  public abstract void swapBuffers();
  
  public abstract void swapBuffers(long paramLong);
  
  public static class ConfigBuilder
  {
    private boolean hasAlphaChannel;
    private boolean isRecordable;
    private int openGlesVersion = 2;
    private boolean supportsPixelBuffer;
    
    public int[] createConfigAttributes()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(12324));
      Object localObject = Integer.valueOf(8);
      localArrayList.add(localObject);
      localArrayList.add(Integer.valueOf(12323));
      localArrayList.add(localObject);
      localArrayList.add(Integer.valueOf(12322));
      localArrayList.add(localObject);
      if (this.hasAlphaChannel)
      {
        localArrayList.add(Integer.valueOf(12321));
        localArrayList.add(localObject);
      }
      int i = this.openGlesVersion;
      if ((i == 2) || (i == 3))
      {
        localArrayList.add(Integer.valueOf(12352));
        if (this.openGlesVersion == 3) {
          i = 64;
        } else {
          i = 4;
        }
        localArrayList.add(Integer.valueOf(i));
      }
      if (this.supportsPixelBuffer)
      {
        localArrayList.add(Integer.valueOf(12339));
        localArrayList.add(Integer.valueOf(1));
      }
      if (this.isRecordable)
      {
        localArrayList.add(Integer.valueOf(12610));
        localArrayList.add(Integer.valueOf(1));
      }
      localArrayList.add(Integer.valueOf(12344));
      localObject = new int[localArrayList.size()];
      i = 0;
      while (i < localArrayList.size())
      {
        localObject[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      return localObject;
    }
    
    public ConfigBuilder setHasAlphaChannel(boolean paramBoolean)
    {
      this.hasAlphaChannel = paramBoolean;
      return this;
    }
    
    public ConfigBuilder setIsRecordable(boolean paramBoolean)
    {
      this.isRecordable = paramBoolean;
      return this;
    }
    
    public ConfigBuilder setOpenGlesVersion(int paramInt)
    {
      if ((paramInt >= 1) && (paramInt <= 3))
      {
        this.openGlesVersion = paramInt;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OpenGL ES version ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" not supported");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public ConfigBuilder setSupportsPixelBuffer(boolean paramBoolean)
    {
      this.supportsPixelBuffer = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface Context
  {
    public static final long NO_CONTEXT = 0L;
    
    public abstract long getNativeEglContext();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglBase
 * JD-Core Version:    0.7.0.1
 */