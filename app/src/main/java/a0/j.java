package a0;

import androidx.camera.core.n1;
import androidx.camera.extensions.impl.ExtensionVersionImpl;

public abstract class j
{
  private static volatile j a;
  
  private static j a()
  {
    if (a != null) {
      return a;
    }
    label34:
    try
    {
      j localj = a;
      if (localj != null) {}
    }
    finally {}
    try
    {
      a = new b();
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      break label34;
    }
    n1.a("ExtenderVersion", "No versioning extender found. Falling back to default.");
    a = new a();
    return a;
  }
  
  public static o b()
  {
    return a().c();
  }
  
  public static boolean d()
  {
    return a().e();
  }
  
  abstract o c();
  
  abstract boolean e();
  
  private static class a
    extends j
  {
    o c()
    {
      return null;
    }
    
    boolean e()
    {
      return false;
    }
  }
  
  private static class b
    extends j
  {
    private static ExtensionVersionImpl c;
    private o b;
    
    b()
    {
      if (c == null) {
        c = new ExtensionVersionImpl();
      }
      Object localObject = o.h(c.checkApiVersion(p.a().c()));
      if ((localObject != null) && (p.a().b().e() == ((o)localObject).e())) {
        this.b = ((o)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Selected vendor runtime: ");
      ((StringBuilder)localObject).append(this.b);
      n1.a("ExtenderVersion", ((StringBuilder)localObject).toString());
    }
    
    o c()
    {
      return this.b;
    }
    
    boolean e()
    {
      try
      {
        boolean bool = c.isAdvancedExtenderImplemented();
        return bool;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        label9:
        break label9;
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.j
 * JD-Core Version:    0.7.0.1
 */