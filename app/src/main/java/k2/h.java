package k2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import b2.j;
import d2.v;
import java.nio.ByteBuffer;

public final class h
  implements j<ByteBuffer, Bitmap>
{
  private final d a = new d();
  
  public v<Bitmap> c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, b2.h paramh)
  {
    paramByteBuffer = ImageDecoder.createSource(paramByteBuffer);
    return this.a.c(paramByteBuffer, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(ByteBuffer paramByteBuffer, b2.h paramh)
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.h
 * JD-Core Version:    0.7.0.1
 */