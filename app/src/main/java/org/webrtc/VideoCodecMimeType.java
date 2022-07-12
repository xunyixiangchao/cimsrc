package org.webrtc;

 enum VideoCodecMimeType
{
  private final String mimeType;
  
  static
  {
    VideoCodecMimeType localVideoCodecMimeType1 = new VideoCodecMimeType("VP8", 0, "video/x-vnd.on2.vp8");
    VP8 = localVideoCodecMimeType1;
    VideoCodecMimeType localVideoCodecMimeType2 = new VideoCodecMimeType("VP9", 1, "video/x-vnd.on2.vp9");
    VP9 = localVideoCodecMimeType2;
    VideoCodecMimeType localVideoCodecMimeType3 = new VideoCodecMimeType("H264", 2, "video/avc");
    H264 = localVideoCodecMimeType3;
    $VALUES = new VideoCodecMimeType[] { localVideoCodecMimeType1, localVideoCodecMimeType2, localVideoCodecMimeType3 };
  }
  
  private VideoCodecMimeType(String paramString)
  {
    this.mimeType = paramString;
  }
  
  String mimeType()
  {
    return this.mimeType;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoCodecMimeType
 * JD-Core Version:    0.7.0.1
 */