package v7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import x7.a;

public final class c
{
  private final Field a;
  
  public c(Field paramField)
  {
    a.b(paramField);
    this.a = paramField;
  }
  
  public <T extends Annotation> T a(Class<T> paramClass)
  {
    return this.a.getAnnotation(paramClass);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.c
 * JD-Core Version:    0.7.0.1
 */