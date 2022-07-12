package org.webrtc;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class VideoCodecInfo
{
  public static final String H264_CONSTRAINED_BASELINE_3_1 = "42e01f";
  public static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
  public static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
  public static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
  public static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
  public static final String H264_LEVEL_3_1 = "1f";
  public static final String H264_PROFILE_CONSTRAINED_BASELINE = "42e0";
  public static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";
  public final String name;
  public final Map<String, String> params;
  @Deprecated
  public final int payload;
  
  @Deprecated
  public VideoCodecInfo(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.payload = paramInt;
    this.name = paramString;
    this.params = paramMap;
  }
  
  @CalledByNative
  public VideoCodecInfo(String paramString, Map<String, String> paramMap)
  {
    this.payload = 0;
    this.name = paramString;
    this.params = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof VideoCodecInfo)) {
      return false;
    }
    paramObject = (VideoCodecInfo)paramObject;
    boolean bool1 = bool2;
    if (this.name.equalsIgnoreCase(paramObject.name))
    {
      bool1 = bool2;
      if (this.params.equals(paramObject.params)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @CalledByNative
  String getName()
  {
    return this.name;
  }
  
  @CalledByNative
  Map getParams()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.name.toUpperCase(Locale.ROOT), this.params });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoCodecInfo
 * JD-Core Version:    0.7.0.1
 */