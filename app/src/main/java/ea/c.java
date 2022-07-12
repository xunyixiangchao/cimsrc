package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract interface c<R, T>
{
  public abstract Type a();
  
  public abstract T b(b<R> paramb);
  
  public static abstract class a
  {
    protected static Type b(int paramInt, ParameterizedType paramParameterizedType)
    {
      return y.g(paramInt, paramParameterizedType);
    }
    
    protected static Class<?> c(Type paramType)
    {
      return y.h(paramType);
    }
    
    @Nullable
    public abstract c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.c
 * JD-Core Version:    0.7.0.1
 */