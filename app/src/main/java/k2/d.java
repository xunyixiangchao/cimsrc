package k2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.Source;
import android.util.Log;
import b2.h;
import b2.j;
import d2.v;
import j2.a;

public final class d
  implements j<ImageDecoder.Source, Bitmap>
{
  private final e2.d a = new e2.e();
  
  public v<Bitmap> c(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, h paramh)
  {
    paramSource = ImageDecoder.decodeBitmap(paramSource, new a(paramInt1, paramInt2, paramh));
    if (Log.isLoggable("BitmapImageDecoder", 2))
    {
      paramh = new StringBuilder();
      paramh.append("Decoded [");
      paramh.append(paramSource.getWidth());
      paramh.append("x");
      paramh.append(paramSource.getHeight());
      paramh.append("] for [");
      paramh.append(paramInt1);
      paramh.append("x");
      paramh.append(paramInt2);
      paramh.append("]");
      Log.v("BitmapImageDecoder", paramh.toString());
    }
    return new e(paramSource, this.a);
  }
  
  public boolean d(ImageDecoder.Source paramSource, h paramh)
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.d
 * JD-Core Version:    0.7.0.1
 */