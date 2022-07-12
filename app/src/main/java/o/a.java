package o;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build.VERSION;
import java.util.Objects;

public final class a
{
  private final c a;
  
  private a(c paramc)
  {
    this.a = paramc;
  }
  
  public static a b(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 31) {
      return new a(new b(paramObject));
    }
    return new a(new a(paramObject));
  }
  
  public Object a()
  {
    return this.a.b();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    return this.a.equals(((a)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  private static class a
    implements a.c
  {
    private final InputConfiguration a;
    
    a(Object paramObject)
    {
      this.a = ((InputConfiguration)paramObject);
    }
    
    public Object b()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a.c)) {
        return false;
      }
      return Objects.equals(this.a, ((a.c)paramObject).b());
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      return this.a.toString();
    }
  }
  
  private static final class b
    extends a.a
  {
    b(Object paramObject)
    {
      super();
    }
  }
  
  private static abstract interface c
  {
    public abstract Object b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o.a
 * JD-Core Version:    0.7.0.1
 */