package org.webrtc;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoCodecType
{
  public static final int VIDEO_CODEC_AV1 = 3;
  public static final int VIDEO_CODEC_GENERIC = 0;
  public static final int VIDEO_CODEC_H264 = 4;
  public static final int VIDEO_CODEC_MULTIPLEX = 5;
  public static final int VIDEO_CODEC_VP8 = 1;
  public static final int VIDEO_CODEC_VP9 = 2;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoCodecType
 * JD-Core Version:    0.7.0.1
 */