package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.media.Image.Plane;
import java.nio.ByteBuffer;
import s.n2;

final class a
  implements e1
{
  private final Image a;
  private final a[] b;
  private final d1 c;
  
  a(Image paramImage)
  {
    this.a = paramImage;
    Image.Plane[] arrayOfPlane = paramImage.getPlanes();
    if (arrayOfPlane != null)
    {
      this.b = new a[arrayOfPlane.length];
      int i = 0;
      while (i < arrayOfPlane.length)
      {
        this.b[i] = new a(arrayOfPlane[i]);
        i += 1;
      }
    }
    this.b = new a[0];
    this.c = l1.e(n2.a(), paramImage.getTimestamp(), 0, new Matrix());
  }
  
  public Rect C()
  {
    try
    {
      Rect localRect = this.a.getCropRect();
      return localRect;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Image J()
  {
    try
    {
      Image localImage = this.a;
      return localImage;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getFormat()
  {
    try
    {
      int i = this.a.getFormat();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getHeight()
  {
    try
    {
      int i = this.a.getHeight();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getWidth()
  {
    try
    {
      int i = this.a.getWidth();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public e1.a[] j()
  {
    try
    {
      a[] arrayOfa = this.b;
      return arrayOfa;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void n(Rect paramRect)
  {
    try
    {
      this.a.setCropRect(paramRect);
      return;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  public d1 q()
  {
    return this.c;
  }
  
  private static final class a
    implements e1.a
  {
    private final Image.Plane a;
    
    a(Image.Plane paramPlane)
    {
      this.a = paramPlane;
    }
    
    public int a()
    {
      try
      {
        int i = this.a.getRowStride();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public ByteBuffer b()
    {
      try
      {
        ByteBuffer localByteBuffer = this.a.getBuffer();
        return localByteBuffer;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public int c()
    {
      try
      {
        int i = this.a.getPixelStride();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.a
 * JD-Core Version:    0.7.0.1
 */