package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.PACKAGE, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
public @interface Keep {}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.annotation.Keep
 * JD-Core Version:    0.7.0.1
 */