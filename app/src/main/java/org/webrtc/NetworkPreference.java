package org.webrtc;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface NetworkPreference
{
  public static final int NEUTRAL = 0;
  public static final int NOT_PREFERRED = -1;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NetworkPreference
 * JD-Core Version:    0.7.0.1
 */