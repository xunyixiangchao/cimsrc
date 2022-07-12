package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;
import x0.h;

class d
  extends c
{
  d(int paramInt, Surface paramSurface)
  {
    this(new a(new OutputConfiguration(paramInt, paramSurface)));
  }
  
  d(Object paramObject)
  {
    super(paramObject);
  }
  
  static d h(OutputConfiguration paramOutputConfiguration)
  {
    return new d(new a(paramOutputConfiguration));
  }
  
  public String a()
  {
    return ((a)this.a).b;
  }
  
  public void b(Surface paramSurface)
  {
    ((OutputConfiguration)d()).addSurface(paramSurface);
  }
  
  public void c()
  {
    ((OutputConfiguration)d()).enableSurfaceSharing();
  }
  
  public Object d()
  {
    h.a(this.a instanceof a);
    return ((a)this.a).a;
  }
  
  public void e(String paramString)
  {
    ((a)this.a).b = paramString;
  }
  
  final boolean f()
  {
    throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
  }
  
  private static final class a
  {
    final OutputConfiguration a;
    String b;
    
    a(OutputConfiguration paramOutputConfiguration)
    {
      this.a = paramOutputConfiguration;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (Objects.equals(this.a, paramObject.a))
      {
        bool1 = bool2;
        if (Objects.equals(this.b, paramObject.b)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int j = this.a.hashCode() ^ 0x1F;
      String str = this.b;
      int i;
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
 * Qualified Name:     o.d
 * JD-Core Version:    0.7.0.1
 */