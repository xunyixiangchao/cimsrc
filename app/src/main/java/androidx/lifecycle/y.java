package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class y
{
  private final b a;
  private final z b;
  
  public y(z paramz, b paramb)
  {
    this.a = paramb;
    this.b = paramz;
  }
  
  public <T extends x> T a(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return b(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public <T extends x> T b(String paramString, Class<T> paramClass)
  {
    Object localObject = this.b.b(paramString);
    if (paramClass.isInstance(localObject))
    {
      paramString = this.a;
      if ((paramString instanceof e)) {
        ((e)paramString).b((x)localObject);
      }
      return localObject;
    }
    localObject = this.a;
    if ((localObject instanceof c)) {
      paramClass = ((c)localObject).c(paramString, paramClass);
    } else {
      paramClass = ((b)localObject).a(paramClass);
    }
    this.b.d(paramString, paramClass);
    return paramClass;
  }
  
  public static class a
    extends y.d
  {
    private static a c;
    private Application b;
    
    public a(Application paramApplication)
    {
      this.b = paramApplication;
    }
    
    public static a c(Application paramApplication)
    {
      if (c == null) {
        c = new a(paramApplication);
      }
      return c;
    }
    
    public <T extends x> T a(Class<T> paramClass)
    {
      if (a.class.isAssignableFrom(paramClass)) {
        try
        {
          x localx = (x)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.b });
          return localx;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException);
        }
        catch (InstantiationException localInstantiationException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localNoSuchMethodException);
        }
      }
      return super.a(paramClass);
    }
  }
  
  public static abstract interface b
  {
    public abstract <T extends x> T a(Class<T> paramClass);
  }
  
  static abstract class c
    extends y.e
    implements y.b
  {
    public <T extends x> T a(Class<T> paramClass)
    {
      throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }
    
    public abstract <T extends x> T c(String paramString, Class<T> paramClass);
  }
  
  public static class d
    implements y.b
  {
    private static d a;
    
    static d b()
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
    
    public <T extends x> T a(Class<T> paramClass)
    {
      try
      {
        x localx = (x)paramClass.newInstance();
        return localx;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
      }
    }
  }
  
  static class e
  {
    void b(x paramx) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.y
 * JD-Core Version:    0.7.0.1
 */