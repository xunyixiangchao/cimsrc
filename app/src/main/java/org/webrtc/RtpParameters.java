package org.webrtc;

import java.util.List;
import java.util.Map;

public class RtpParameters
{
  public final List<Codec> codecs;
  public DegradationPreference degradationPreference;
  public final List<Encoding> encodings;
  private final List<HeaderExtension> headerExtensions;
  private final Rtcp rtcp;
  public final String transactionId;
  
  @CalledByNative
  RtpParameters(String paramString, DegradationPreference paramDegradationPreference, Rtcp paramRtcp, List<HeaderExtension> paramList, List<Encoding> paramList1, List<Codec> paramList2)
  {
    this.transactionId = paramString;
    this.degradationPreference = paramDegradationPreference;
    this.rtcp = paramRtcp;
    this.headerExtensions = paramList;
    this.encodings = paramList1;
    this.codecs = paramList2;
  }
  
  @CalledByNative
  List<Codec> getCodecs()
  {
    return this.codecs;
  }
  
  @CalledByNative
  DegradationPreference getDegradationPreference()
  {
    return this.degradationPreference;
  }
  
  @CalledByNative
  List<Encoding> getEncodings()
  {
    return this.encodings;
  }
  
  @CalledByNative
  public List<HeaderExtension> getHeaderExtensions()
  {
    return this.headerExtensions;
  }
  
  @CalledByNative
  public Rtcp getRtcp()
  {
    return this.rtcp;
  }
  
  @CalledByNative
  String getTransactionId()
  {
    return this.transactionId;
  }
  
  public static class Codec
  {
    public Integer clockRate;
    MediaStreamTrack.MediaType kind;
    public String name;
    public Integer numChannels;
    public Map<String, String> parameters;
    public int payloadType;
    
    @CalledByNative("Codec")
    Codec(int paramInt, String paramString, MediaStreamTrack.MediaType paramMediaType, Integer paramInteger1, Integer paramInteger2, Map<String, String> paramMap)
    {
      this.payloadType = paramInt;
      this.name = paramString;
      this.kind = paramMediaType;
      this.clockRate = paramInteger1;
      this.numChannels = paramInteger2;
      this.parameters = paramMap;
    }
    
    @CalledByNative("Codec")
    Integer getClockRate()
    {
      return this.clockRate;
    }
    
    @CalledByNative("Codec")
    MediaStreamTrack.MediaType getKind()
    {
      return this.kind;
    }
    
    @CalledByNative("Codec")
    String getName()
    {
      return this.name;
    }
    
    @CalledByNative("Codec")
    Integer getNumChannels()
    {
      return this.numChannels;
    }
    
    @CalledByNative("Codec")
    Map getParameters()
    {
      return this.parameters;
    }
    
    @CalledByNative("Codec")
    int getPayloadType()
    {
      return this.payloadType;
    }
  }
  
  public static enum DegradationPreference
  {
    static
    {
      DegradationPreference localDegradationPreference1 = new DegradationPreference("DISABLED", 0);
      DISABLED = localDegradationPreference1;
      DegradationPreference localDegradationPreference2 = new DegradationPreference("MAINTAIN_FRAMERATE", 1);
      MAINTAIN_FRAMERATE = localDegradationPreference2;
      DegradationPreference localDegradationPreference3 = new DegradationPreference("MAINTAIN_RESOLUTION", 2);
      MAINTAIN_RESOLUTION = localDegradationPreference3;
      DegradationPreference localDegradationPreference4 = new DegradationPreference("BALANCED", 3);
      BALANCED = localDegradationPreference4;
      $VALUES = new DegradationPreference[] { localDegradationPreference1, localDegradationPreference2, localDegradationPreference3, localDegradationPreference4 };
    }
    
    private DegradationPreference() {}
    
    @CalledByNative("DegradationPreference")
    static DegradationPreference fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
  
  public static class Encoding
  {
    public boolean active;
    public double bitratePriority;
    public Integer maxBitrateBps;
    public Integer maxFramerate;
    public Integer minBitrateBps;
    public int networkPriority;
    public Integer numTemporalLayers;
    public String rid;
    public Double scaleResolutionDownBy;
    public Long ssrc;
    
    @CalledByNative("Encoding")
    Encoding(String paramString, boolean paramBoolean, double paramDouble, int paramInt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Double paramDouble1, Long paramLong)
    {
      this.rid = paramString;
      this.active = paramBoolean;
      this.bitratePriority = paramDouble;
      this.networkPriority = paramInt;
      this.maxBitrateBps = paramInteger1;
      this.minBitrateBps = paramInteger2;
      this.maxFramerate = paramInteger3;
      this.numTemporalLayers = paramInteger4;
      this.scaleResolutionDownBy = paramDouble1;
      this.ssrc = paramLong;
    }
    
    public Encoding(String paramString, boolean paramBoolean, Double paramDouble)
    {
      this.bitratePriority = 1.0D;
      this.networkPriority = 1;
      this.rid = paramString;
      this.active = paramBoolean;
      this.scaleResolutionDownBy = paramDouble;
    }
    
    @CalledByNative("Encoding")
    boolean getActive()
    {
      return this.active;
    }
    
    @CalledByNative("Encoding")
    double getBitratePriority()
    {
      return this.bitratePriority;
    }
    
    @CalledByNative("Encoding")
    Integer getMaxBitrateBps()
    {
      return this.maxBitrateBps;
    }
    
    @CalledByNative("Encoding")
    Integer getMaxFramerate()
    {
      return this.maxFramerate;
    }
    
    @CalledByNative("Encoding")
    Integer getMinBitrateBps()
    {
      return this.minBitrateBps;
    }
    
    @CalledByNative("Encoding")
    int getNetworkPriority()
    {
      return this.networkPriority;
    }
    
    @CalledByNative("Encoding")
    Integer getNumTemporalLayers()
    {
      return this.numTemporalLayers;
    }
    
    @CalledByNative("Encoding")
    String getRid()
    {
      return this.rid;
    }
    
    @CalledByNative("Encoding")
    Double getScaleResolutionDownBy()
    {
      return this.scaleResolutionDownBy;
    }
    
    @CalledByNative("Encoding")
    Long getSsrc()
    {
      return this.ssrc;
    }
  }
  
  public static class HeaderExtension
  {
    private final boolean encrypted;
    private final int id;
    private final String uri;
    
    @CalledByNative("HeaderExtension")
    HeaderExtension(String paramString, int paramInt, boolean paramBoolean)
    {
      this.uri = paramString;
      this.id = paramInt;
      this.encrypted = paramBoolean;
    }
    
    @CalledByNative("HeaderExtension")
    public boolean getEncrypted()
    {
      return this.encrypted;
    }
    
    @CalledByNative("HeaderExtension")
    public int getId()
    {
      return this.id;
    }
    
    @CalledByNative("HeaderExtension")
    public String getUri()
    {
      return this.uri;
    }
  }
  
  public static class Rtcp
  {
    private final String cname;
    private final boolean reducedSize;
    
    @CalledByNative("Rtcp")
    Rtcp(String paramString, boolean paramBoolean)
    {
      this.cname = paramString;
      this.reducedSize = paramBoolean;
    }
    
    @CalledByNative("Rtcp")
    public String getCname()
    {
      return this.cname;
    }
    
    @CalledByNative("Rtcp")
    public boolean getReducedSize()
    {
      return this.reducedSize;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RtpParameters
 * JD-Core Version:    0.7.0.1
 */