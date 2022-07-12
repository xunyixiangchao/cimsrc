package ea;

import ga.w;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l9.e0;
import l9.g0;
import o8.o;

final class a
  extends f.a
{
  private boolean a = true;
  
  @Nullable
  public f<?, e0> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, u paramu)
  {
    if (e0.class.isAssignableFrom(y.h(paramType))) {
      return b.a;
    }
    return null;
  }
  
  @Nullable
  public f<g0, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
  {
    if (paramType == g0.class)
    {
      if (y.l(paramArrayOfAnnotation, w.class)) {
        return c.a;
      }
      return a.a;
    }
    if (paramType == Void.class) {
      return f.a;
    }
    if ((this.a) && (paramType == o.class)) {}
    try
    {
      paramType = e.a;
      return paramType;
    }
    catch (NoClassDefFoundError paramType)
    {
      label52:
      break label52;
    }
    this.a = false;
    return null;
  }
  
  static final class a
    implements f<g0, g0>
  {
    static final a a = new a();
    
    public g0 a(g0 paramg0)
    {
      try
      {
        g0 localg0 = y.a(paramg0);
        return localg0;
      }
      finally
      {
        paramg0.close();
      }
    }
  }
  
  static final class b
    implements f<e0, e0>
  {
    static final b a = new b();
    
    public e0 a(e0 parame0)
    {
      return parame0;
    }
  }
  
  static final class c
    implements f<g0, g0>
  {
    static final c a = new c();
    
    public g0 a(g0 paramg0)
    {
      return paramg0;
    }
  }
  
  static final class d
    implements f<Object, String>
  {
    static final d a = new d();
    
    public String a(Object paramObject)
    {
      return paramObject.toString();
    }
  }
  
  static final class e
    implements f<g0, o>
  {
    static final e a = new e();
    
    public o a(g0 paramg0)
    {
      paramg0.close();
      return o.a;
    }
  }
  
  static final class f
    implements f<g0, Void>
  {
    static final f a = new f();
    
    public Void a(g0 paramg0)
    {
      paramg0.close();
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.a
 * JD-Core Version:    0.7.0.1
 */