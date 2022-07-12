package z1;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public abstract interface a
{
  public abstract int a();
  
  public abstract void b();
  
  public abstract int c();
  
  public abstract void clear();
  
  public abstract int d();
  
  public abstract int e();
  
  public abstract void f(Bitmap.Config paramConfig);
  
  public abstract void g();
  
  public abstract ByteBuffer getData();
  
  public abstract Bitmap getNextFrame();
  
  public static abstract interface a
  {
    public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
    
    public abstract void b(byte[] paramArrayOfByte);
    
    public abstract byte[] c(int paramInt);
    
    public abstract void d(int[] paramArrayOfInt);
    
    public abstract int[] e(int paramInt);
    
    public abstract void f(Bitmap paramBitmap);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z1.a
 * JD-Core Version:    0.7.0.1
 */