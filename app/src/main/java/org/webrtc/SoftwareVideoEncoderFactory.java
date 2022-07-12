package org.webrtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoftwareVideoEncoderFactory
  implements VideoEncoderFactory
{
  static VideoCodecInfo[] supportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
    if (LibvpxVp9Encoder.nativeIsSupported()) {
      localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
    }
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }
  
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    if (paramVideoCodecInfo.name.equalsIgnoreCase("VP8")) {
      return new LibvpxVp8Encoder();
    }
    if ((paramVideoCodecInfo.name.equalsIgnoreCase("VP9")) && (LibvpxVp9Encoder.nativeIsSupported())) {
      return new LibvpxVp9Encoder();
    }
    return null;
  }
  
  public VideoCodecInfo[] getSupportedCodecs()
  {
    return supportedCodecs();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SoftwareVideoEncoderFactory
 * JD-Core Version:    0.7.0.1
 */