package w;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;

final class b
{
  static ImageWriter a(Surface paramSurface, int paramInt)
  {
    return ImageWriter.newInstance(paramSurface, paramInt);
  }
  
  static void b(ImageWriter paramImageWriter, Image paramImage)
  {
    paramImageWriter.queueInputImage(paramImage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w.b
 * JD-Core Version:    0.7.0.1
 */