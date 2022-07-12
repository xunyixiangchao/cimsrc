package k2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import b2.h;
import b2.j;
import d2.v;
import java.io.InputStream;
import x2.a;

public final class t
  implements j<InputStream, Bitmap>
{
  private final d a = new d();
  
  public v<Bitmap> c(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
  {
    paramInputStream = ImageDecoder.createSource(a.b(paramInputStream));
    return this.a.c(paramInputStream, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(InputStream paramInputStream, h paramh)
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.t
 * JD-Core Version:    0.7.0.1
 */