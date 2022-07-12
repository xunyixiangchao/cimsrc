package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Map;

class MediaCodecUtils
{
  static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
  static final int[] DECODER_COLOR_FORMATS = { 19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876 };
  static final int[] ENCODER_COLOR_FORMATS = { 19, 21, 2141391872, 2141391876 };
  static final String EXYNOS_PREFIX = "OMX.Exynos.";
  static final String INTEL_PREFIX = "OMX.Intel.";
  static final String NVIDIA_PREFIX = "OMX.Nvidia.";
  static final String QCOM_PREFIX = "OMX.qcom.";
  static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = { "OMX.google.", "OMX.SEC.", "c2.android" };
  private static final String TAG = "MediaCodecUtils";
  static final int[] TEXTURE_COLOR_FORMATS = getTextureColorFormats();
  
  static boolean codecSupportsType(MediaCodecInfo paramMediaCodecInfo, VideoCodecMimeType paramVideoCodecMimeType)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getSupportedTypes();
    int j = paramMediaCodecInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramMediaCodecInfo[i];
      if (paramVideoCodecMimeType.mimeType().equals(localObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static Map<String, String> getCodecProperties(VideoCodecMimeType paramVideoCodecMimeType, boolean paramBoolean)
  {
    int i = 1.$SwitchMap$org$webrtc$VideoCodecMimeType[paramVideoCodecMimeType.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i == 3) {
        return H264Utils.getDefaultH264Params(paramBoolean);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported codec: ");
      localStringBuilder.append(paramVideoCodecMimeType);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return new HashMap();
  }
  
  private static int[] getTextureColorFormats()
  {
    return new int[] { 2130708361 };
  }
  
  static boolean isHardwareAccelerated(MediaCodecInfo paramMediaCodecInfo)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return isHardwareAcceleratedQOrHigher(paramMediaCodecInfo);
    }
    return isSoftwareOnly(paramMediaCodecInfo) ^ true;
  }
  
  @TargetApi(29)
  private static boolean isHardwareAcceleratedQOrHigher(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isHardwareAccelerated();
  }
  
  static boolean isSoftwareOnly(MediaCodecInfo paramMediaCodecInfo)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return isSoftwareOnlyQOrHigher(paramMediaCodecInfo);
    }
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    String[] arrayOfString = SOFTWARE_IMPLEMENTATION_PREFIXES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramMediaCodecInfo.startsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @TargetApi(29)
  private static boolean isSoftwareOnlyQOrHigher(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isSoftwareOnly();
  }
  
  static Integer selectColorFormat(int[] paramArrayOfInt, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      int[] arrayOfInt = paramCodecCapabilities.colorFormats;
      int n = arrayOfInt.length;
      int j = 0;
      while (j < n)
      {
        int i1 = arrayOfInt[j];
        if (i1 == m) {
          return Integer.valueOf(i1);
        }
        j += 1;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaCodecUtils
 * JD-Core Version:    0.7.0.1
 */