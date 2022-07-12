package org.webrtc;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Priority
{
  public static final int HIGH = 3;
  public static final int LOW = 1;
  public static final int MEDIUM = 2;
  public static final int VERY_LOW = 0;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Priority
 * JD-Core Version:    0.7.0.1
 */