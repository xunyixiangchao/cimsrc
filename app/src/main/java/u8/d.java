package u8;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface d
{
  String c() default "";
  
  String f() default "";
  
  int[] l() default {};
  
  String m() default "";
  
  int v() default 1;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.d
 * JD-Core Version:    0.7.0.1
 */