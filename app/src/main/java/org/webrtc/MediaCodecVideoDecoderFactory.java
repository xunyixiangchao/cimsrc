package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.List;

class MediaCodecVideoDecoderFactory
  implements VideoDecoderFactory
{
  private static final String TAG = "MediaCodecVideoDecoderFactory";
  private final Predicate<MediaCodecInfo> codecAllowedPredicate;
  private final EglBase.Context sharedContext;
  
  public MediaCodecVideoDecoderFactory(EglBase.Context paramContext, Predicate<MediaCodecInfo> paramPredicate)
  {
    this.sharedContext = paramContext;
    this.codecAllowedPredicate = paramPredicate;
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
        Logging.e("MediaCodecVideoDecoderFactory", "Cannot retrieve decoder codec info", localIllegalArgumentException);
      }
      if ((localObject != null) && (!localObject.isEncoder()) && (isSupportedCodec(localObject, paramVideoCodecMimeType))) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean isCodecAllowed(MediaCodecInfo paramMediaCodecInfo)
  {
    Predicate localPredicate = this.codecAllowedPredicate;
    if (localPredicate == null) {
      return true;
    }
    return localPredicate.test(paramMediaCodecInfo);
  }
  
  private boolean isH264HighProfileSupported(MediaCodecInfo paramMediaCodecInfo)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    if (paramMediaCodecInfo.startsWith("OMX.qcom.")) {
      return true;
    }
    return paramMediaCodecInfo.startsWith("OMX.Exynos.");
  }
  
  private boolean isSupportedCodec(MediaCodecInfo paramMediaCodecInfo, VideoCodecMimeType paramVideoCodecMimeType)
  {
    paramMediaCodecInfo.getName();
    if (!MediaCodecUtils.codecSupportsType(paramMediaCodecInfo, paramVideoCodecMimeType)) {
      return false;
    }
    if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, paramMediaCodecInfo.getCapabilitiesForType(paramVideoCodecMimeType.mimeType())) == null) {
      return false;
    }
    return isCodecAllowed(paramMediaCodecInfo);
  }
  
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    paramVideoCodecInfo = VideoCodecMimeType.valueOf(paramVideoCodecInfo.getName());
    MediaCodecInfo localMediaCodecInfo = findCodecForType(paramVideoCodecInfo);
    if (localMediaCodecInfo == null) {
      return null;
    }
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(paramVideoCodecInfo.mimeType());
    return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), localMediaCodecInfo.getName(), paramVideoCodecInfo, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, localCodecCapabilities).intValue(), this.sharedContext);
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
 * Qualified Name:     org.webrtc.MediaCodecVideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */