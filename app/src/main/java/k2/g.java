package k2;

import android.graphics.Bitmap;
import b2.h;
import b2.j;
import d2.v;
import java.nio.ByteBuffer;

public class g
  implements j<ByteBuffer, Bitmap>
{
  private final m a;
  
  public g(m paramm)
  {
    this.a = paramm;
  }
  
  public v<Bitmap> c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, h paramh)
  {
    return this.a.f(paramByteBuffer, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(ByteBuffer paramByteBuffer, h paramh)
  {
    return this.a.q(paramByteBuffer);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.g
 * JD-Core Version:    0.7.0.1
 */