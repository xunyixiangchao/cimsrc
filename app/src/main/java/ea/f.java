package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l9.e0;
import l9.g0;

public abstract interface f<F, T>
{
  @Nullable
  public abstract T convert(F paramF);
  
  public static abstract class a
  {
    protected static Type a(int paramInt, ParameterizedType paramParameterizedType)
    {
      return y.g(paramInt, paramParameterizedType);
    }
    
    protected static Class<?> b(Type paramType)
    {
      return y.h(paramType);
    }
    
    @Nullable
    public f<?, e0> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, u paramu)
    {
      return null;
    }
    
    @Nullable
    public f<g0, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
    {
      return null;
    }
    
    @Nullable
    public f<?, String> e(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
    {
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.f
 * JD-Core Version:    0.7.0.1
 */