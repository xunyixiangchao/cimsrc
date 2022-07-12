package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DefaultVideoEncoderFactory
  implements VideoEncoderFactory
{
  private final VideoEncoderFactory hardwareVideoEncoderFactory;
  private final VideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();
  
  public DefaultVideoEncoderFactory(EglBase.Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.hardwareVideoEncoderFactory = new HardwareVideoEncoderFactory(paramContext, paramBoolean1, paramBoolean2);
  }
  
  DefaultVideoEncoderFactory(VideoEncoderFactory paramVideoEncoderFactory)
  {
    this.hardwareVideoEncoderFactory = paramVideoEncoderFactory;
  }
  
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoEncoder localVideoEncoder1 = this.softwareVideoEncoderFactory.createEncoder(paramVideoCodecInfo);
    VideoEncoder localVideoEncoder2 = this.hardwareVideoEncoderFactory.createEncoder(paramVideoCodecInfo);
    if ((localVideoEncoder2 != null) && (localVideoEncoder1 != null)) {
      return new VideoEncoderFallback(localVideoEncoder1, localVideoEncoder2);
    }
    paramVideoCodecInfo = localVideoEncoder1;
    if (localVideoEncoder2 != null) {
      paramVideoCodecInfo = localVideoEncoder2;
    }
    return paramVideoCodecInfo;
  }
  
  public VideoCodecInfo[] getSupportedCodecs()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(Arrays.asList(this.softwareVideoEncoderFactory.getSupportedCodecs()));
    localLinkedHashSet.addAll(Arrays.asList(this.hardwareVideoEncoderFactory.getSupportedCodecs()));
    return (VideoCodecInfo[])localLinkedHashSet.toArray(new VideoCodecInfo[localLinkedHashSet.size()]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.DefaultVideoEncoderFactory
 * JD-Core Version:    0.7.0.1
 */