package org.webrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RtpTransceiver
{
  private RtpReceiver cachedReceiver;
  private RtpSender cachedSender;
  private long nativeRtpTransceiver;
  
  @CalledByNative
  protected RtpTransceiver(long paramLong)
  {
    this.nativeRtpTransceiver = paramLong;
    this.cachedSender = nativeGetSender(paramLong);
    this.cachedReceiver = nativeGetReceiver(paramLong);
  }
  
  private void checkRtpTransceiverExists()
  {
    if (this.nativeRtpTransceiver != 0L) {
      return;
    }
    throw new IllegalStateException("RtpTransceiver has been disposed.");
  }
  
  private static native RtpTransceiverDirection nativeCurrentDirection(long paramLong);
  
  private static native RtpTransceiverDirection nativeDirection(long paramLong);
  
  private static native MediaStreamTrack.MediaType nativeGetMediaType(long paramLong);
  
  private static native String nativeGetMid(long paramLong);
  
  private static native RtpReceiver nativeGetReceiver(long paramLong);
  
  private static native RtpSender nativeGetSender(long paramLong);
  
  private static native boolean nativeSetDirection(long paramLong, RtpTransceiverDirection paramRtpTransceiverDirection);
  
  private static native void nativeStopInternal(long paramLong);
  
  private static native void nativeStopStandard(long paramLong);
  
  private static native boolean nativeStopped(long paramLong);
  
  @CalledByNative
  public void dispose()
  {
    checkRtpTransceiverExists();
    this.cachedSender.dispose();
    this.cachedReceiver.dispose();
    JniCommon.nativeReleaseRef(this.nativeRtpTransceiver);
    this.nativeRtpTransceiver = 0L;
  }
  
  public RtpTransceiverDirection getCurrentDirection()
  {
    checkRtpTransceiverExists();
    return nativeCurrentDirection(this.nativeRtpTransceiver);
  }
  
  public RtpTransceiverDirection getDirection()
  {
    checkRtpTransceiverExists();
    return nativeDirection(this.nativeRtpTransceiver);
  }
  
  public MediaStreamTrack.MediaType getMediaType()
  {
    checkRtpTransceiverExists();
    return nativeGetMediaType(this.nativeRtpTransceiver);
  }
  
  public String getMid()
  {
    checkRtpTransceiverExists();
    return nativeGetMid(this.nativeRtpTransceiver);
  }
  
  public RtpReceiver getReceiver()
  {
    return this.cachedReceiver;
  }
  
  public RtpSender getSender()
  {
    return this.cachedSender;
  }
  
  public boolean isStopped()
  {
    checkRtpTransceiverExists();
    return nativeStopped(this.nativeRtpTransceiver);
  }
  
  public boolean setDirection(RtpTransceiverDirection paramRtpTransceiverDirection)
  {
    checkRtpTransceiverExists();
    return nativeSetDirection(this.nativeRtpTransceiver, paramRtpTransceiverDirection);
  }
  
  public void stop()
  {
    checkRtpTransceiverExists();
    nativeStopInternal(this.nativeRtpTransceiver);
  }
  
  public void stopInternal()
  {
    checkRtpTransceiverExists();
    nativeStopInternal(this.nativeRtpTransceiver);
  }
  
  public void stopStandard()
  {
    checkRtpTransceiverExists();
    nativeStopStandard(this.nativeRtpTransceiver);
  }
  
  public static enum RtpTransceiverDirection
  {
    private final int nativeIndex;
    
    static
    {
      RtpTransceiverDirection localRtpTransceiverDirection1 = new RtpTransceiverDirection("SEND_RECV", 0, 0);
      SEND_RECV = localRtpTransceiverDirection1;
      RtpTransceiverDirection localRtpTransceiverDirection2 = new RtpTransceiverDirection("SEND_ONLY", 1, 1);
      SEND_ONLY = localRtpTransceiverDirection2;
      RtpTransceiverDirection localRtpTransceiverDirection3 = new RtpTransceiverDirection("RECV_ONLY", 2, 2);
      RECV_ONLY = localRtpTransceiverDirection3;
      RtpTransceiverDirection localRtpTransceiverDirection4 = new RtpTransceiverDirection("INACTIVE", 3, 3);
      INACTIVE = localRtpTransceiverDirection4;
      $VALUES = new RtpTransceiverDirection[] { localRtpTransceiverDirection1, localRtpTransceiverDirection2, localRtpTransceiverDirection3, localRtpTransceiverDirection4 };
    }
    
    private RtpTransceiverDirection(int paramInt)
    {
      this.nativeIndex = paramInt;
    }
    
    @CalledByNative("RtpTransceiverDirection")
    static RtpTransceiverDirection fromNativeIndex(int paramInt)
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        RtpTransceiverDirection localRtpTransceiverDirection = localObject[i];
        if (localRtpTransceiverDirection.getNativeIndex() == paramInt) {
          return localRtpTransceiverDirection;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Uknown native RtpTransceiverDirection type");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    @CalledByNative("RtpTransceiverDirection")
    int getNativeIndex()
    {
      return this.nativeIndex;
    }
  }
  
  public static final class RtpTransceiverInit
  {
    private final RtpTransceiver.RtpTransceiverDirection direction;
    private final List<RtpParameters.Encoding> sendEncodings;
    private final List<String> streamIds;
    
    public RtpTransceiverInit()
    {
      this(RtpTransceiver.RtpTransceiverDirection.SEND_RECV);
    }
    
    public RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection paramRtpTransceiverDirection)
    {
      this(paramRtpTransceiverDirection, Collections.emptyList(), Collections.emptyList());
    }
    
    public RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection paramRtpTransceiverDirection, List<String> paramList)
    {
      this(paramRtpTransceiverDirection, paramList, Collections.emptyList());
    }
    
    public RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection paramRtpTransceiverDirection, List<String> paramList, List<RtpParameters.Encoding> paramList1)
    {
      this.direction = paramRtpTransceiverDirection;
      this.streamIds = new ArrayList(paramList);
      this.sendEncodings = new ArrayList(paramList1);
    }
    
    @CalledByNative("RtpTransceiverInit")
    int getDirectionNativeIndex()
    {
      return this.direction.getNativeIndex();
    }
    
    @CalledByNative("RtpTransceiverInit")
    List<RtpParameters.Encoding> getSendEncodings()
    {
      return new ArrayList(this.sendEncodings);
    }
    
    @CalledByNative("RtpTransceiverInit")
    List<String> getStreamIds()
    {
      return new ArrayList(this.streamIds);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RtpTransceiver
 * JD-Core Version:    0.7.0.1
 */