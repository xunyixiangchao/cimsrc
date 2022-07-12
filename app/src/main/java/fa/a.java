package fa;

import ea.f.a;
import ea.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import l9.e0;
import l9.g0;

public final class a
  extends f.a
{
  private final v7.f a;
  
  private a(v7.f paramf)
  {
    this.a = paramf;
  }
  
  public static a f()
  {
    return g(new v7.f());
  }
  
  public static a g(v7.f paramf)
  {
    Objects.requireNonNull(paramf, "gson == null");
    return new a(paramf);
  }
  
  public ea.f<?, e0> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, u paramu)
  {
    paramType = this.a.k(com.google.gson.reflect.a.get(paramType));
    return new b(this.a, paramType);
  }
  
  public ea.f<g0, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
  {
    paramType = this.a.k(com.google.gson.reflect.a.get(paramType));
    return new c(this.a, paramType);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     fa.a
 * JD-Core Version:    0.7.0.1
 */