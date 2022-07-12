package androidx.camera.extensions;

import a0.e;
import a0.g;
import a0.j;
import a0.n;
import a0.o;
import androidx.camera.core.q;
import androidx.camera.core.s;
import androidx.camera.core.t;
import androidx.camera.core.t.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import s.b1;
import s.c1;
import s.z;

final class d
{
  private final s a;
  
  d(s params)
  {
    this.a = params;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                return ":camera:camera-extensions-EXTENSION_MODE_AUTO";
              }
              throw new IllegalArgumentException("Invalid extension mode!");
            }
            return ":camera:camera-extensions-EXTENSION_MODE_FACE_RETOUCH";
          }
          return ":camera:camera-extensions-EXTENSION_MODE_NIGHT";
        }
        return ":camera:camera-extensions-EXTENSION_MODE_HDR";
      }
      return ":camera:camera-extensions-EXTENSION_MODE_BOKEH";
    }
    return ":camera:camera-extensions-EXTENSION_MODE_NONE";
  }
  
  private static q d(int paramInt)
  {
    return new a(b(paramInt), e(paramInt));
  }
  
  private static n e(int paramInt)
  {
    if (g()) {
      return new e(paramInt);
    }
    return new g(paramInt);
  }
  
  private static void f(int paramInt)
  {
    c1 localc1 = c1.a(b(paramInt));
    if (b1.b(localc1) == z.a) {
      b1.a(localc1, new c(paramInt, localc1));
    }
  }
  
  private static boolean g()
  {
    if (j.b().a(o.c) < 0) {
      return false;
    }
    return j.d();
  }
  
  t c(t paramt, int paramInt)
  {
    if (h(paramt, paramInt))
    {
      Iterator localIterator = paramt.c().iterator();
      while (localIterator.hasNext()) {
        if (((q)localIterator.next() instanceof a)) {
          throw new IllegalArgumentException("An extension is already applied to the base CameraSelector.");
        }
      }
      f(paramInt);
      paramt = t.a.c(paramt);
      paramt.a(d(paramInt));
      return paramt.b();
    }
    throw new IllegalArgumentException("No camera can be found to support the specified extensions mode! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
  }
  
  boolean h(t paramt, int paramInt)
  {
    paramt = t.a.c(paramt);
    paramt.a(d(paramInt));
    return paramt.b().b(this.a.a()).isEmpty() ^ true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.extensions.d
 * JD-Core Version:    0.7.0.1
 */