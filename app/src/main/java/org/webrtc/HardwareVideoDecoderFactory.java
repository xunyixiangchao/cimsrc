package org.webrtc;

import android.media.MediaCodecInfo;

public class HardwareVideoDecoderFactory
  extends MediaCodecVideoDecoderFactory
{
  private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate()
  {
    public boolean test(MediaCodecInfo paramAnonymousMediaCodecInfo)
    {
      return MediaCodecUtils.isHardwareAccelerated(paramAnonymousMediaCodecInfo);
    }
  };
  
  @Deprecated
  public HardwareVideoDecoderFactory()
  {
    this(null);
  }
  
  public HardwareVideoDecoderFactory(EglBase.Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HardwareVideoDecoderFactory(EglBase.Context paramContext, Predicate<MediaCodecInfo> paramPredicate)
  {
    super(paramContext, paramPredicate);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.HardwareVideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */