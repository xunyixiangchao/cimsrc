package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DefaultVideoDecoderFactory
  implements VideoDecoderFactory
{
  private final VideoDecoderFactory hardwareVideoDecoderFactory;
  private final VideoDecoderFactory platformSoftwareVideoDecoderFactory;
  private final VideoDecoderFactory softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
  
  public DefaultVideoDecoderFactory(EglBase.Context paramContext)
  {
    this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(paramContext);
    this.platformSoftwareVideoDecoderFactory = new PlatformSoftwareVideoDecoderFactory(paramContext);
  }
  
  DefaultVideoDecoderFactory(VideoDecoderFactory paramVideoDecoderFactory)
  {
    this.hardwareVideoDecoderFactory = paramVideoDecoderFactory;
    this.platformSoftwareVideoDecoderFactory = null;
  }
  
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoDecoder localVideoDecoder2 = this.softwareVideoDecoderFactory.createDecoder(paramVideoCodecInfo);
    VideoDecoder localVideoDecoder3 = this.hardwareVideoDecoderFactory.createDecoder(paramVideoCodecInfo);
    VideoDecoder localVideoDecoder1 = localVideoDecoder2;
    if (localVideoDecoder2 == null)
    {
      VideoDecoderFactory localVideoDecoderFactory = this.platformSoftwareVideoDecoderFactory;
      localVideoDecoder1 = localVideoDecoder2;
      if (localVideoDecoderFactory != null) {
        localVideoDecoder1 = localVideoDecoderFactory.createDecoder(paramVideoCodecInfo);
      }
    }
    if ((localVideoDecoder3 != null) && (localVideoDecoder1 != null)) {
      return new VideoDecoderFallback(localVideoDecoder1, localVideoDecoder3);
    }
    if (localVideoDecoder3 != null) {
      return localVideoDecoder3;
    }
    return localVideoDecoder1;
  }
  
  public VideoCodecInfo[] getSupportedCodecs()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
    localLinkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
    VideoDecoderFactory localVideoDecoderFactory = this.platformSoftwareVideoDecoderFactory;
    if (localVideoDecoderFactory != null) {
      localLinkedHashSet.addAll(Arrays.asList(localVideoDecoderFactory.getSupportedCodecs()));
    }
    return (VideoCodecInfo[])localLinkedHashSet.toArray(new VideoCodecInfo[localLinkedHashSet.size()]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.DefaultVideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */