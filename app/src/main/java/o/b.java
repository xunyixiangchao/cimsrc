package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build.VERSION;
import android.view.Surface;

public final class b
{
  private final a a;
  
  public b(int paramInt, Surface paramSurface)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      paramSurface = new e(paramInt, paramSurface);
    }
    for (;;)
    {
      this.a = paramSurface;
      return;
      if (i >= 26)
      {
        paramSurface = new d(paramInt, paramSurface);
      }
      else
      {
        if (i < 24) {
          break;
        }
        paramSurface = new c(paramInt, paramSurface);
      }
    }
    this.a = new f(paramSurface);
  }
  
  private b(a parama)
  {
    this.a = parama;
  }
  
  public static b g(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      paramObject = e.i((OutputConfiguration)paramObject);
    } else if (i >= 26) {
      paramObject = d.h((OutputConfiguration)paramObject);
    } else if (i >= 24) {
      paramObject = c.g((OutputConfiguration)paramObject);
    } else {
      paramObject = null;
    }
    if (paramObject == null) {
      return null;
    }
    return new b(paramObject);
  }
  
  public void a(Surface paramSurface)
  {
    this.a.b(paramSurface);
  }
  
  public void b()
  {
    this.a.c();
  }
  
  public String c()
  {
    return this.a.a();
  }
  
  public Surface d()
  {
    return this.a.getSurface();
  }
  
  public void e(String paramString)
  {
    this.a.e(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return this.a.equals(((b)paramObject).a);
  }
  
  public Object f()
  {
    return this.a.d();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  static abstract interface a
  {
    public abstract String a();
    
    public abstract void b(Surface paramSurface);
    
    public abstract void c();
    
    public abstract Object d();
    
    public abstract void e(String paramString);
    
    public abstract Surface getSurface();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o.b
 * JD-Core Version:    0.7.0.1
 */