package w;

import android.media.ImageWriter;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import x0.h;

final class c
{
  private static Method a;
  
  static
  {
    try
    {
      Class localClass = Integer.TYPE;
      a = ImageWriter.class.getMethod("newInstance", new Class[] { Surface.class, localClass, localClass });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("ImageWriterCompatApi26", "Unable to initialize via reflection.", localNoSuchMethodException);
    }
  }
  
  static ImageWriter a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    Surface localSurface = null;
    if (i >= 26)
    {
      try
      {
        paramSurface = (ImageWriter)h.g(a.invoke(null, new Object[] { paramSurface, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return paramSurface;
      }
      catch (InvocationTargetException paramSurface) {}catch (IllegalAccessException paramSurface) {}
      localSurface = paramSurface;
    }
    throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", localSurface);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w.c
 * JD-Core Version:    0.7.0.1
 */