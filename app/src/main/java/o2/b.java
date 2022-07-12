package o2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import e2.d;
import z1.a.a;

public final class b
  implements a.a
{
  private final d a;
  private final e2.b b;
  
  public b(d paramd, e2.b paramb)
  {
    this.a = paramd;
    this.b = paramb;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return this.a.e(paramInt1, paramInt2, paramConfig);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    e2.b localb = this.b;
    if (localb == null) {
      return;
    }
    localb.d(paramArrayOfByte);
  }
  
  public byte[] c(int paramInt)
  {
    e2.b localb = this.b;
    if (localb == null) {
      return new byte[paramInt];
    }
    return (byte[])localb.e(paramInt, [B.class);
  }
  
  public void d(int[] paramArrayOfInt)
  {
    e2.b localb = this.b;
    if (localb == null) {
      return;
    }
    localb.d(paramArrayOfInt);
  }
  
  public int[] e(int paramInt)
  {
    e2.b localb = this.b;
    if (localb == null) {
      return new int[paramInt];
    }
    return (int[])localb.e(paramInt, [I.class);
  }
  
  public void f(Bitmap paramBitmap)
  {
    this.a.d(paramBitmap);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.b
 * JD-Core Version:    0.7.0.1
 */