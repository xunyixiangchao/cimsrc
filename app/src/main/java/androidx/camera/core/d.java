package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.core.impl.utils.k;
import java.util.concurrent.Executor;
import s.l1;
import s.l1.a;

class d
  implements l1
{
  private final ImageReader a;
  private final Object b = new Object();
  
  d(ImageReader paramImageReader)
  {
    this.a = paramImageReader;
  }
  
  private boolean i(RuntimeException paramRuntimeException)
  {
    return "ImageReaderContext is not initialized".equals(paramRuntimeException.getMessage());
  }
  
  public e1 b()
  {
    Object localObject2;
    try
    {
      synchronized (this.b)
      {
        Image localImage = this.a.acquireLatestImage();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (i(localRuntimeException))
      {
        localObject2 = null;
        if (localObject2 == null) {
          return null;
        }
        localObject2 = new a((Image)localObject2);
        return localObject2;
      }
      throw ((Throwable)localObject2);
    }
    throw ((Throwable)localObject2);
  }
  
  public int c()
  {
    synchronized (this.b)
    {
      int i = this.a.getImageFormat();
      return i;
    }
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      this.a.close();
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.b)
    {
      this.a.setOnImageAvailableListener(null, null);
      return;
    }
  }
  
  public void e(l1.a parama, Executor paramExecutor)
  {
    synchronized (this.b)
    {
      parama = new b(this, paramExecutor, parama);
      this.a.setOnImageAvailableListener(parama, k.a());
      return;
    }
  }
  
  public int f()
  {
    synchronized (this.b)
    {
      int i = this.a.getMaxImages();
      return i;
    }
  }
  
  public e1 g()
  {
    Object localObject2;
    try
    {
      synchronized (this.b)
      {
        Image localImage = this.a.acquireNextImage();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (i(localRuntimeException))
      {
        localObject2 = null;
        if (localObject2 == null) {
          return null;
        }
        localObject2 = new a((Image)localObject2);
        return localObject2;
      }
      throw ((Throwable)localObject2);
    }
    throw ((Throwable)localObject2);
  }
  
  public int getHeight()
  {
    synchronized (this.b)
    {
      int i = this.a.getHeight();
      return i;
    }
  }
  
  public Surface getSurface()
  {
    synchronized (this.b)
    {
      Surface localSurface = this.a.getSurface();
      return localSurface;
    }
  }
  
  public int getWidth()
  {
    synchronized (this.b)
    {
      int i = this.a.getWidth();
      return i;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.d
 * JD-Core Version:    0.7.0.1
 */