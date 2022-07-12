package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;
import x0.h;

class c
  extends f
{
  c(int paramInt, Surface paramSurface)
  {
    this(new a(new OutputConfiguration(paramInt, paramSurface)));
  }
  
  c(Object paramObject)
  {
    super(paramObject);
  }
  
  static c g(OutputConfiguration paramOutputConfiguration)
  {
    return new c(new a(paramOutputConfiguration));
  }
  
  public String a()
  {
    return ((a)this.a).b;
  }
  
  public void c()
  {
    ((a)this.a).c = true;
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
  
  boolean f()
  {
    return ((a)this.a).c;
  }
  
  public Surface getSurface()
  {
    return ((OutputConfiguration)d()).getSurface();
  }
  
  private static final class a
  {
    final OutputConfiguration a;
    String b;
    boolean c;
    
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
        if (this.c == paramObject.c)
        {
          bool1 = bool2;
          if (Objects.equals(this.b, paramObject.b)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode() ^ 0x1F;
      int j = this.c ^ (i << 5) - i;
      String str = this.b;
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
 * Qualified Name:     o.c
 * JD-Core Version:    0.7.0.1
 */