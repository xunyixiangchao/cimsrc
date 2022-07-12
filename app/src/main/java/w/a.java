package w;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build.VERSION;
import android.view.Surface;

public final class a
{
  public static ImageWriter a(Surface paramSurface, int paramInt)
  {
    return b.a(paramSurface, paramInt);
  }
  
  public static ImageWriter b(Surface paramSurface, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      return d.a(paramSurface, paramInt1, paramInt2);
    }
    if (i >= 26) {
      return c.a(paramSurface, paramInt1, paramInt2);
    }
    paramSurface = new StringBuilder();
    paramSurface.append("Unable to call newInstance(Surface, int, int) on API ");
    paramSurface.append(i);
    paramSurface.append(". Version 26 or higher required.");
    throw new RuntimeException(paramSurface.toString());
  }
  
  public static void c(ImageWriter paramImageWriter, Image paramImage)
  {
    b.b(paramImageWriter, paramImage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w.a
 * JD-Core Version:    0.7.0.1
 */