package org.webrtc;

public enum VideoCodecStatus
{
  private final int number;
  
  static
  {
    VideoCodecStatus localVideoCodecStatus1 = new VideoCodecStatus("REQUEST_SLI", 0, 2);
    REQUEST_SLI = localVideoCodecStatus1;
    VideoCodecStatus localVideoCodecStatus2 = new VideoCodecStatus("NO_OUTPUT", 1, 1);
    NO_OUTPUT = localVideoCodecStatus2;
    VideoCodecStatus localVideoCodecStatus3 = new VideoCodecStatus("OK", 2, 0);
    OK = localVideoCodecStatus3;
    VideoCodecStatus localVideoCodecStatus4 = new VideoCodecStatus("ERROR", 3, -1);
    ERROR = localVideoCodecStatus4;
    VideoCodecStatus localVideoCodecStatus5 = new VideoCodecStatus("LEVEL_EXCEEDED", 4, -2);
    LEVEL_EXCEEDED = localVideoCodecStatus5;
    VideoCodecStatus localVideoCodecStatus6 = new VideoCodecStatus("MEMORY", 5, -3);
    MEMORY = localVideoCodecStatus6;
    VideoCodecStatus localVideoCodecStatus7 = new VideoCodecStatus("ERR_PARAMETER", 6, -4);
    ERR_PARAMETER = localVideoCodecStatus7;
    VideoCodecStatus localVideoCodecStatus8 = new VideoCodecStatus("ERR_SIZE", 7, -5);
    ERR_SIZE = localVideoCodecStatus8;
    VideoCodecStatus localVideoCodecStatus9 = new VideoCodecStatus("TIMEOUT", 8, -6);
    TIMEOUT = localVideoCodecStatus9;
    VideoCodecStatus localVideoCodecStatus10 = new VideoCodecStatus("UNINITIALIZED", 9, -7);
    UNINITIALIZED = localVideoCodecStatus10;
    VideoCodecStatus localVideoCodecStatus11 = new VideoCodecStatus("ERR_REQUEST_SLI", 10, -12);
    ERR_REQUEST_SLI = localVideoCodecStatus11;
    VideoCodecStatus localVideoCodecStatus12 = new VideoCodecStatus("FALLBACK_SOFTWARE", 11, -13);
    FALLBACK_SOFTWARE = localVideoCodecStatus12;
    VideoCodecStatus localVideoCodecStatus13 = new VideoCodecStatus("TARGET_BITRATE_OVERSHOOT", 12, -14);
    TARGET_BITRATE_OVERSHOOT = localVideoCodecStatus13;
    $VALUES = new VideoCodecStatus[] { localVideoCodecStatus1, localVideoCodecStatus2, localVideoCodecStatus3, localVideoCodecStatus4, localVideoCodecStatus5, localVideoCodecStatus6, localVideoCodecStatus7, localVideoCodecStatus8, localVideoCodecStatus9, localVideoCodecStatus10, localVideoCodecStatus11, localVideoCodecStatus12, localVideoCodecStatus13 };
  }
  
  private VideoCodecStatus(int paramInt)
  {
    this.number = paramInt;
  }
  
  @CalledByNative
  public int getNumber()
  {
    return this.number;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoCodecStatus
 * JD-Core Version:    0.7.0.1
 */