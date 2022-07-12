package org.webrtc;

import android.media.MediaCodecInfo;

public class PlatformSoftwareVideoDecoderFactory
  extends MediaCodecVideoDecoderFactory
{
  private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate()
  {
    public boolean test(MediaCodecInfo paramAnonymousMediaCodecInfo)
    {
      return MediaCodecUtils.isSoftwareOnly(paramAnonymousMediaCodecInfo);
    }
  };
  
  public PlatformSoftwareVideoDecoderFactory(EglBase.Context paramContext)
  {
    super(paramContext, defaultAllowedPredicate);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.PlatformSoftwareVideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */