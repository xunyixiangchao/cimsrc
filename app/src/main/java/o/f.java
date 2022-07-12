package o;

import android.annotation.SuppressLint;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.n1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import x0.h;

class f
  implements b.a
{
  final Object a;
  
  f(Surface paramSurface)
  {
    this.a = new a(paramSurface);
  }
  
  f(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public String a()
  {
    return ((a)this.a).e;
  }
  
  public void b(Surface paramSurface)
  {
    h.h(paramSurface, "Surface must not be null");
    if (getSurface() != paramSurface)
    {
      if (!f()) {
        throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
      }
      throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }
    throw new IllegalStateException("Surface is already added!");
  }
  
  public void c()
  {
    ((a)this.a).f = true;
  }
  
  public Object d()
  {
    return null;
  }
  
  public void e(String paramString)
  {
    ((a)this.a).e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    return Objects.equals(this.a, ((f)paramObject).a);
  }
  
  boolean f()
  {
    return ((a)this.a).f;
  }
  
  public Surface getSurface()
  {
    List localList = ((a)this.a).a;
    if (localList.size() == 0) {
      return null;
    }
    return (Surface)localList.get(0);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  private static final class a
  {
    final List<Surface> a;
    final Size b;
    final int c;
    final int d;
    String e;
    boolean f = false;
    
    a(Surface paramSurface)
    {
      h.h(paramSurface, "Surface must not be null");
      this.a = Collections.singletonList(paramSurface);
      this.b = c(paramSurface);
      this.c = a(paramSurface);
      this.d = b(paramSurface);
    }
    
    @SuppressLint({"BlockedPrivateApi"})
    private static int a(Surface paramSurface)
    {
      try
      {
        int i = ((Integer)Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", new Class[] { Surface.class }).invoke(null, new Object[] { paramSurface })).intValue();
        return i;
      }
      catch (InvocationTargetException paramSurface) {}catch (IllegalAccessException paramSurface) {}catch (NoSuchMethodException paramSurface) {}catch (ClassNotFoundException paramSurface) {}
      n1.d("OutputConfigCompat", "Unable to retrieve surface format.", paramSurface);
      return 0;
    }
    
    @SuppressLint({"SoonBlockedPrivateApi"})
    private static int b(Surface paramSurface)
    {
      try
      {
        int i = ((Integer)Surface.class.getDeclaredMethod("getGenerationId", new Class[0]).invoke(paramSurface, new Object[0])).intValue();
        return i;
      }
      catch (InvocationTargetException paramSurface) {}catch (IllegalAccessException paramSurface) {}catch (NoSuchMethodException paramSurface) {}
      n1.d("OutputConfigCompat", "Unable to retrieve surface generation id.", paramSurface);
      return -1;
    }
    
    @SuppressLint({"BlockedPrivateApi"})
    private static Size c(Surface paramSurface)
    {
      try
      {
        Method localMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", new Class[] { Surface.class });
        localMethod.setAccessible(true);
        paramSurface = (Size)localMethod.invoke(null, new Object[] { paramSurface });
        return paramSurface;
      }
      catch (InvocationTargetException paramSurface) {}catch (IllegalAccessException paramSurface) {}catch (NoSuchMethodException paramSurface) {}catch (ClassNotFoundException paramSurface) {}
      n1.d("OutputConfigCompat", "Unable to retrieve surface size.", paramSurface);
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.b.equals(paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.f == paramObject.f))
      {
        if (!Objects.equals(this.e, paramObject.e)) {
          return false;
        }
        int j = Math.min(this.a.size(), paramObject.a.size());
        int i = 0;
        while (i < j)
        {
          if (this.a.get(i) != paramObject.a.get(i)) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode() ^ 0x1F;
      i = this.d ^ (i << 5) - i;
      i = this.b.hashCode() ^ (i << 5) - i;
      i = this.c ^ (i << 5) - i;
      int j = this.f ^ (i << 5) - i;
      String str = this.e;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      }
      return i ^ (j << 5) - j;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o.f
 * JD-Core Version:    0.7.0.1
 */