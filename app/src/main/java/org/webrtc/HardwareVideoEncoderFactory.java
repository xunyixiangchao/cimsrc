package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardwareVideoEncoderFactory
  implements VideoEncoderFactory
{
  private static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList(new String[] { "SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4" });
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
  private static final String TAG = "HardwareVideoEncoderFactory";
  private final Predicate<MediaCodecInfo> codecAllowedPredicate;
  private final boolean enableH264HighProfile;
  private final boolean enableIntelVp8Encoder;
  private final EglBase14.Context sharedContext;
  
  public HardwareVideoEncoderFactory(EglBase.Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public HardwareVideoEncoderFactory(EglBase.Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Predicate<MediaCodecInfo> paramPredicate)
  {
    if ((paramContext instanceof EglBase14.Context))
    {
      paramContext = (EglBase14.Context)paramContext;
    }
    else
    {
      Logging.w("HardwareVideoEncoderFactory", "No shared EglBase.Context.  Encoders will not use texture mode.");
      paramContext = null;
    }
    this.sharedContext = paramContext;
    this.enableIntelVp8Encoder = paramBoolean1;
    this.enableH264HighProfile = paramBoolean2;
    this.codecAllowedPredicate = paramPredicate;
  }
  
  @Deprecated
  public HardwareVideoEncoderFactory(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(null, paramBoolean1, paramBoolean2);
  }
  
  private BitrateAdjuster createBitrateAdjuster(VideoCodecMimeType paramVideoCodecMimeType, String paramString)
  {
    if (paramString.startsWith("OMX.Exynos."))
    {
      if (paramVideoCodecMimeType == VideoCodecMimeType.VP8) {
        return new DynamicBitrateAdjuster();
      }
      return new FramerateBitrateAdjuster();
    }
    return new BaseBitrateAdjuster();
  }
  
  private MediaCodecInfo findCodecForType(VideoCodecMimeType paramVideoCodecMimeType)
  {
    int i = 0;
    for (;;)
    {
      int j = MediaCodecList.getCodecCount();
      Object localObject = null;
      if (i >= j) {
        break;
      }
      try
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        localObject = localMediaCodecInfo;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Logging.e("HardwareVideoEncoderFactory", "Cannot retrieve encoder codec info", localIllegalArgumentException);
      }
      if ((localObject != null) && (localObject.isEncoder()) && (isSupportedCodec(localObject, paramVideoCodecMimeType))) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  private int getForcedKeyFrameIntervalMs(VideoCodecMimeType paramVideoCodecMimeType, String paramString)
  {
    if ((paramVideoCodecMimeType == VideoCodecMimeType.VP8) && (paramString.startsWith("OMX.qcom.")))
    {
      int i = Build.VERSION.SDK_INT;
      if (i == 23) {
        return 20000;
      }
      if (i > 23) {
        return 15000;
      }
    }
    return 0;
  }
  
  private int getKeyFrameIntervalSec(VideoCodecMimeType paramVideoCodecMimeType)
  {
    int i = 1.$SwitchMap$org$webrtc$VideoCodecMimeType[paramVideoCodecMimeType.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i == 3) {
        return 20;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported VideoCodecMimeType ");
      localStringBuilder.append(paramVideoCodecMimeType);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 100;
  }
  
  private boolean isH264HighProfileSupported(MediaCodecInfo paramMediaCodecInfo)
  {
    return (this.enableH264HighProfile) && (Build.VERSION.SDK_INT > 23) && (paramMediaCodecInfo.getName().startsWith("OMX.Exynos."));
  }
  
  private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo paramMediaCodecInfo, VideoCodecMimeType paramVideoCodecMimeType)
  {
    int i = 1.$SwitchMap$org$webrtc$VideoCodecMimeType[paramVideoCodecMimeType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        return isHardwareSupportedInCurrentSdkH264(paramMediaCodecInfo);
      }
      return isHardwareSupportedInCurrentSdkVp9(paramMediaCodecInfo);
    }
    return isHardwareSupportedInCurrentSdkVp8(paramMediaCodecInfo);
  }
  
  private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = H264_HW_EXCEPTION_MODELS.contains(Build.MODEL);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    if ((paramMediaCodecInfo.startsWith("OMX.qcom.")) || (paramMediaCodecInfo.startsWith("OMX.Exynos."))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo paramMediaCodecInfo)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    return (paramMediaCodecInfo.startsWith("OMX.qcom.")) || (paramMediaCodecInfo.startsWith("OMX.Exynos.")) || ((paramMediaCodecInfo.startsWith("OMX.Intel.")) && (this.enableIntelVp8Encoder));
  }
  
  private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo paramMediaCodecInfo)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    return ((paramMediaCodecInfo.startsWith("OMX.qcom.")) || (paramMediaCodecInfo.startsWith("OMX.Exynos."))) && (Build.VERSION.SDK_INT >= 24);
  }
  
  private boolean isMediaCodecAllowed(MediaCodecInfo paramMediaCodecInfo)
  {
    Predicate localPredicate = this.codecAllowedPredicate;
    if (localPredicate == null) {
      return true;
    }
    return localPredicate.test(paramMediaCodecInfo);
  }
  
  private boolean isSupportedCodec(MediaCodecInfo paramMediaCodecInfo, VideoCodecMimeType paramVideoCodecMimeType)
  {
    boolean bool1 = MediaCodecUtils.codecSupportsType(paramMediaCodecInfo, paramVideoCodecMimeType);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, paramMediaCodecInfo.getCapabilitiesForType(paramVideoCodecMimeType.mimeType())) == null) {
      return false;
    }
    bool1 = bool2;
    if (isHardwareSupportedInCurrentSdk(paramMediaCodecInfo, paramVideoCodecMimeType))
    {
      bool1 = bool2;
      if (isMediaCodecAllowed(paramMediaCodecInfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoCodecMimeType localVideoCodecMimeType = VideoCodecMimeType.valueOf(paramVideoCodecInfo.name);
    MediaCodecInfo localMediaCodecInfo = findCodecForType(localVideoCodecMimeType);
    if (localMediaCodecInfo == null) {
      return null;
    }
    String str = localMediaCodecInfo.getName();
    Object localObject = localVideoCodecMimeType.mimeType();
    Integer localInteger = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, localMediaCodecInfo.getCapabilitiesForType((String)localObject));
    localObject = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, localMediaCodecInfo.getCapabilitiesForType((String)localObject));
    if (localVideoCodecMimeType == VideoCodecMimeType.H264)
    {
      boolean bool1 = H264Utils.isSameH264Profile(paramVideoCodecInfo.params, MediaCodecUtils.getCodecProperties(localVideoCodecMimeType, true));
      boolean bool2 = H264Utils.isSameH264Profile(paramVideoCodecInfo.params, MediaCodecUtils.getCodecProperties(localVideoCodecMimeType, false));
      if ((!bool1) && (!bool2)) {
        return null;
      }
      if ((bool1) && (!isH264HighProfileSupported(localMediaCodecInfo))) {
        return null;
      }
    }
    return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), str, localVideoCodecMimeType, localInteger, (Integer)localObject, paramVideoCodecInfo.params, getKeyFrameIntervalSec(localVideoCodecMimeType), getForcedKeyFrameIntervalMs(localVideoCodecMimeType, str), createBitrateAdjuster(localVideoCodecMimeType, str), this.sharedContext);
  }
  
  public VideoCodecInfo[] getSupportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    VideoCodecMimeType localVideoCodecMimeType1 = VideoCodecMimeType.VP8;
    VideoCodecMimeType localVideoCodecMimeType2 = VideoCodecMimeType.VP9;
    VideoCodecMimeType localVideoCodecMimeType3 = VideoCodecMimeType.H264;
    int i = 0;
    while (i < 3)
    {
      VideoCodecMimeType localVideoCodecMimeType4 = new VideoCodecMimeType[] { localVideoCodecMimeType1, localVideoCodecMimeType2, localVideoCodecMimeType3 }[i];
      MediaCodecInfo localMediaCodecInfo = findCodecForType(localVideoCodecMimeType4);
      if (localMediaCodecInfo != null)
      {
        String str = localVideoCodecMimeType4.name();
        if ((localVideoCodecMimeType4 == VideoCodecMimeType.H264) && (isH264HighProfileSupported(localMediaCodecInfo))) {
          localArrayList.add(new VideoCodecInfo(str, MediaCodecUtils.getCodecProperties(localVideoCodecMimeType4, true)));
        }
        localArrayList.add(new VideoCodecInfo(str, MediaCodecUtils.getCodecProperties(localVideoCodecMimeType4, false)));
      }
      i += 1;
    }
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.HardwareVideoEncoderFactory
 * JD-Core Version:    0.7.0.1
 */