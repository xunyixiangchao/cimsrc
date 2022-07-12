package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.Image;
import java.nio.ByteBuffer;

public abstract interface e1
  extends AutoCloseable
{
  public abstract Rect C();
  
  public abstract Image J();
  
  public abstract void close();
  
  public abstract int getFormat();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  @SuppressLint({"ArrayReturn"})
  public abstract a[] j();
  
  public abstract void n(Rect paramRect);
  
  public abstract d1 q();
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract ByteBuffer b();
    
    public abstract int c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.e1
 * JD-Core Version:    0.7.0.1
 */