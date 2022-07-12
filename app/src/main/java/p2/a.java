package p2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import b2.h;
import d2.v;
import java.io.ByteArrayOutputStream;
import l2.b;

public class a
  implements e<Bitmap, byte[]>
{
  private final Bitmap.CompressFormat a;
  private final int b;
  
  public a()
  {
    this(Bitmap.CompressFormat.JPEG, 100);
  }
  
  public a(Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  public v<byte[]> a(v<Bitmap> paramv, h paramh)
  {
    paramh = new ByteArrayOutputStream();
    ((Bitmap)paramv.get()).compress(this.a, this.b, paramh);
    paramv.a();
    return new b(paramh.toByteArray());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p2.a
 * JD-Core Version:    0.7.0.1
 */