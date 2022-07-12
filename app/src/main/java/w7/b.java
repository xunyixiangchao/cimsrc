package w7;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD})
public @interface b
{
  boolean nullSafe() default true;
  
  Class<?> value();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w7.b
 * JD-Core Version:    0.7.0.1
 */