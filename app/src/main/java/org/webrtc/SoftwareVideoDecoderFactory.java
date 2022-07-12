package org.webrtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoftwareVideoDecoderFactory
  implements VideoDecoderFactory
{
  static VideoCodecInfo[] supportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
    if (LibvpxVp9Decoder.nativeIsSupported()) {
      localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
    }
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }
  
  @Deprecated
  public VideoDecoder createDecoder(String paramString)
  {
    return createDecoder(new VideoCodecInfo(paramString, new HashMap()));
  }
  
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    if (paramVideoCodecInfo.getName().equalsIgnoreCase("VP8")) {
      return new LibvpxVp8Decoder();
    }
    if ((paramVideoCodecInfo.getName().equalsIgnoreCase("VP9")) && (LibvpxVp9Decoder.nativeIsSupported())) {
      return new LibvpxVp9Decoder();
    }
    return null;
  }
  
  public VideoCodecInfo[] getSupportedCodecs()
  {
    return supportedCodecs();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SoftwareVideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */