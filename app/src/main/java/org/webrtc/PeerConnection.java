package org.webrtc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PeerConnection
{
  private final List<MediaStream> localStreams = new ArrayList();
  private final long nativePeerConnection;
  private List<RtpReceiver> receivers = new ArrayList();
  private List<RtpSender> senders = new ArrayList();
  private List<RtpTransceiver> transceivers = new ArrayList();
  
  PeerConnection(long paramLong)
  {
    this.nativePeerConnection = paramLong;
  }
  
  public PeerConnection(NativePeerConnectionFactory paramNativePeerConnectionFactory)
  {
    this(paramNativePeerConnectionFactory.createNativePeerConnection());
  }
  
  public static long createNativePeerConnectionObserver(Observer paramObserver)
  {
    return nativeCreatePeerConnectionObserver(paramObserver);
  }
  
  private native boolean nativeAddIceCandidate(String paramString1, int paramInt, String paramString2);
  
  private native boolean nativeAddLocalStream(long paramLong);
  
  private native RtpSender nativeAddTrack(long paramLong, List<String> paramList);
  
  private native RtpTransceiver nativeAddTransceiverOfType(MediaStreamTrack.MediaType paramMediaType, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit);
  
  private native RtpTransceiver nativeAddTransceiverWithTrack(long paramLong, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit);
  
  private native void nativeClose();
  
  private native PeerConnectionState nativeConnectionState();
  
  private native void nativeCreateAnswer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);
  
  private native DataChannel nativeCreateDataChannel(String paramString, DataChannel.Init paramInit);
  
  private native void nativeCreateOffer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);
  
  private static native long nativeCreatePeerConnectionObserver(Observer paramObserver);
  
  private native RtpSender nativeCreateSender(String paramString1, String paramString2);
  
  private static native void nativeFreeOwnedPeerConnection(long paramLong);
  
  private native RtcCertificatePem nativeGetCertificate();
  
  private native SessionDescription nativeGetLocalDescription();
  
  private native long nativeGetNativePeerConnection();
  
  private native List<RtpReceiver> nativeGetReceivers();
  
  private native SessionDescription nativeGetRemoteDescription();
  
  private native List<RtpSender> nativeGetSenders();
  
  private native List<RtpTransceiver> nativeGetTransceivers();
  
  private native IceConnectionState nativeIceConnectionState();
  
  private native IceGatheringState nativeIceGatheringState();
  
  private native void nativeNewGetStats(RTCStatsCollectorCallback paramRTCStatsCollectorCallback);
  
  private native boolean nativeOldGetStats(StatsObserver paramStatsObserver, long paramLong);
  
  private native boolean nativeRemoveIceCandidates(IceCandidate[] paramArrayOfIceCandidate);
  
  private native void nativeRemoveLocalStream(long paramLong);
  
  private native boolean nativeRemoveTrack(long paramLong);
  
  private native void nativeSetAudioPlayout(boolean paramBoolean);
  
  private native void nativeSetAudioRecording(boolean paramBoolean);
  
  private native boolean nativeSetBitrate(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  private native boolean nativeSetConfiguration(RTCConfiguration paramRTCConfiguration);
  
  private native void nativeSetLocalDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);
  
  private native void nativeSetRemoteDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);
  
  private native SignalingState nativeSignalingState();
  
  private native boolean nativeStartRtcEventLog(int paramInt1, int paramInt2);
  
  private native void nativeStopRtcEventLog();
  
  public boolean addIceCandidate(IceCandidate paramIceCandidate)
  {
    return nativeAddIceCandidate(paramIceCandidate.sdpMid, paramIceCandidate.sdpMLineIndex, paramIceCandidate.sdp);
  }
  
  public boolean addStream(MediaStream paramMediaStream)
  {
    if (!nativeAddLocalStream(paramMediaStream.getNativeMediaStream())) {
      return false;
    }
    this.localStreams.add(paramMediaStream);
    return true;
  }
  
  public RtpSender addTrack(MediaStreamTrack paramMediaStreamTrack)
  {
    return addTrack(paramMediaStreamTrack, Collections.emptyList());
  }
  
  public RtpSender addTrack(MediaStreamTrack paramMediaStreamTrack, List<String> paramList)
  {
    if ((paramMediaStreamTrack != null) && (paramList != null))
    {
      paramMediaStreamTrack = nativeAddTrack(paramMediaStreamTrack.getNativeMediaStreamTrack(), paramList);
      if (paramMediaStreamTrack != null)
      {
        this.senders.add(paramMediaStreamTrack);
        return paramMediaStreamTrack;
      }
      throw new IllegalStateException("C++ addTrack failed.");
    }
    throw new NullPointerException("No MediaStreamTrack specified in addTrack.");
  }
  
  public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType paramMediaType)
  {
    return addTransceiver(paramMediaType, new RtpTransceiver.RtpTransceiverInit());
  }
  
  public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType paramMediaType, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit)
  {
    Objects.requireNonNull(paramMediaType, "No MediaType specified for addTransceiver.");
    RtpTransceiver.RtpTransceiverInit localRtpTransceiverInit = paramRtpTransceiverInit;
    if (paramRtpTransceiverInit == null) {
      localRtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
    }
    paramMediaType = nativeAddTransceiverOfType(paramMediaType, localRtpTransceiverInit);
    if (paramMediaType != null)
    {
      this.transceivers.add(paramMediaType);
      return paramMediaType;
    }
    throw new IllegalStateException("C++ addTransceiver failed.");
  }
  
  public RtpTransceiver addTransceiver(MediaStreamTrack paramMediaStreamTrack)
  {
    return addTransceiver(paramMediaStreamTrack, new RtpTransceiver.RtpTransceiverInit());
  }
  
  public RtpTransceiver addTransceiver(MediaStreamTrack paramMediaStreamTrack, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit)
  {
    Objects.requireNonNull(paramMediaStreamTrack, "No MediaStreamTrack specified for addTransceiver.");
    RtpTransceiver.RtpTransceiverInit localRtpTransceiverInit = paramRtpTransceiverInit;
    if (paramRtpTransceiverInit == null) {
      localRtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
    }
    paramMediaStreamTrack = nativeAddTransceiverWithTrack(paramMediaStreamTrack.getNativeMediaStreamTrack(), localRtpTransceiverInit);
    if (paramMediaStreamTrack != null)
    {
      this.transceivers.add(paramMediaStreamTrack);
      return paramMediaStreamTrack;
    }
    throw new IllegalStateException("C++ addTransceiver failed.");
  }
  
  public void close()
  {
    nativeClose();
  }
  
  public PeerConnectionState connectionState()
  {
    return nativeConnectionState();
  }
  
  public void createAnswer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints)
  {
    nativeCreateAnswer(paramSdpObserver, paramMediaConstraints);
  }
  
  public DataChannel createDataChannel(String paramString, DataChannel.Init paramInit)
  {
    return nativeCreateDataChannel(paramString, paramInit);
  }
  
  public void createOffer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints)
  {
    nativeCreateOffer(paramSdpObserver, paramMediaConstraints);
  }
  
  public RtpSender createSender(String paramString1, String paramString2)
  {
    paramString1 = nativeCreateSender(paramString1, paramString2);
    if (paramString1 != null) {
      this.senders.add(paramString1);
    }
    return paramString1;
  }
  
  public void dispose()
  {
    close();
    Iterator localIterator = this.localStreams.iterator();
    while (localIterator.hasNext())
    {
      MediaStream localMediaStream = (MediaStream)localIterator.next();
      nativeRemoveLocalStream(localMediaStream.getNativeMediaStream());
      localMediaStream.dispose();
    }
    this.localStreams.clear();
    localIterator = this.senders.iterator();
    while (localIterator.hasNext()) {
      ((RtpSender)localIterator.next()).dispose();
    }
    this.senders.clear();
    localIterator = this.receivers.iterator();
    while (localIterator.hasNext()) {
      ((RtpReceiver)localIterator.next()).dispose();
    }
    localIterator = this.transceivers.iterator();
    while (localIterator.hasNext()) {
      ((RtpTransceiver)localIterator.next()).dispose();
    }
    this.transceivers.clear();
    this.receivers.clear();
    nativeFreeOwnedPeerConnection(this.nativePeerConnection);
  }
  
  public RtcCertificatePem getCertificate()
  {
    return nativeGetCertificate();
  }
  
  public SessionDescription getLocalDescription()
  {
    return nativeGetLocalDescription();
  }
  
  @CalledByNative
  long getNativeOwnedPeerConnection()
  {
    return this.nativePeerConnection;
  }
  
  public long getNativePeerConnection()
  {
    return nativeGetNativePeerConnection();
  }
  
  public List<RtpReceiver> getReceivers()
  {
    Object localObject = this.receivers.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RtpReceiver)((Iterator)localObject).next()).dispose();
    }
    localObject = nativeGetReceivers();
    this.receivers = ((List)localObject);
    return Collections.unmodifiableList((List)localObject);
  }
  
  public SessionDescription getRemoteDescription()
  {
    return nativeGetRemoteDescription();
  }
  
  public List<RtpSender> getSenders()
  {
    Object localObject = this.senders.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RtpSender)((Iterator)localObject).next()).dispose();
    }
    localObject = nativeGetSenders();
    this.senders = ((List)localObject);
    return Collections.unmodifiableList((List)localObject);
  }
  
  public void getStats(RTCStatsCollectorCallback paramRTCStatsCollectorCallback)
  {
    nativeNewGetStats(paramRTCStatsCollectorCallback);
  }
  
  @Deprecated
  public boolean getStats(StatsObserver paramStatsObserver, MediaStreamTrack paramMediaStreamTrack)
  {
    long l;
    if (paramMediaStreamTrack == null) {
      l = 0L;
    } else {
      l = paramMediaStreamTrack.getNativeMediaStreamTrack();
    }
    return nativeOldGetStats(paramStatsObserver, l);
  }
  
  public List<RtpTransceiver> getTransceivers()
  {
    Object localObject = this.transceivers.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RtpTransceiver)((Iterator)localObject).next()).dispose();
    }
    localObject = nativeGetTransceivers();
    this.transceivers = ((List)localObject);
    return Collections.unmodifiableList((List)localObject);
  }
  
  public IceConnectionState iceConnectionState()
  {
    return nativeIceConnectionState();
  }
  
  public IceGatheringState iceGatheringState()
  {
    return nativeIceGatheringState();
  }
  
  public boolean removeIceCandidates(IceCandidate[] paramArrayOfIceCandidate)
  {
    return nativeRemoveIceCandidates(paramArrayOfIceCandidate);
  }
  
  public void removeStream(MediaStream paramMediaStream)
  {
    nativeRemoveLocalStream(paramMediaStream.getNativeMediaStream());
    this.localStreams.remove(paramMediaStream);
  }
  
  public boolean removeTrack(RtpSender paramRtpSender)
  {
    Objects.requireNonNull(paramRtpSender, "No RtpSender specified for removeTrack.");
    return nativeRemoveTrack(paramRtpSender.getNativeRtpSender());
  }
  
  public void setAudioPlayout(boolean paramBoolean)
  {
    nativeSetAudioPlayout(paramBoolean);
  }
  
  public void setAudioRecording(boolean paramBoolean)
  {
    nativeSetAudioRecording(paramBoolean);
  }
  
  public boolean setBitrate(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return nativeSetBitrate(paramInteger1, paramInteger2, paramInteger3);
  }
  
  public boolean setConfiguration(RTCConfiguration paramRTCConfiguration)
  {
    return nativeSetConfiguration(paramRTCConfiguration);
  }
  
  public void setLocalDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription)
  {
    nativeSetLocalDescription(paramSdpObserver, paramSessionDescription);
  }
  
  public void setRemoteDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription)
  {
    nativeSetRemoteDescription(paramSdpObserver, paramSessionDescription);
  }
  
  public SignalingState signalingState()
  {
    return nativeSignalingState();
  }
  
  public boolean startRtcEventLog(int paramInt1, int paramInt2)
  {
    return nativeStartRtcEventLog(paramInt1, paramInt2);
  }
  
  public void stopRtcEventLog()
  {
    nativeStopRtcEventLog();
  }
  
  public static enum AdapterType
  {
    private static final Map<Integer, AdapterType> BY_BITMASK;
    public final Integer bitMask;
    
    static
    {
      int i = 0;
      Object localObject = new AdapterType("UNKNOWN", 0, Integer.valueOf(0));
      UNKNOWN = (AdapterType)localObject;
      AdapterType localAdapterType1 = new AdapterType("ETHERNET", 1, Integer.valueOf(1));
      ETHERNET = localAdapterType1;
      AdapterType localAdapterType2 = new AdapterType("WIFI", 2, Integer.valueOf(2));
      WIFI = localAdapterType2;
      AdapterType localAdapterType3 = new AdapterType("CELLULAR", 3, Integer.valueOf(4));
      CELLULAR = localAdapterType3;
      AdapterType localAdapterType4 = new AdapterType("VPN", 4, Integer.valueOf(8));
      VPN = localAdapterType4;
      AdapterType localAdapterType5 = new AdapterType("LOOPBACK", 5, Integer.valueOf(16));
      LOOPBACK = localAdapterType5;
      AdapterType localAdapterType6 = new AdapterType("ADAPTER_TYPE_ANY", 6, Integer.valueOf(32));
      ADAPTER_TYPE_ANY = localAdapterType6;
      AdapterType localAdapterType7 = new AdapterType("CELLULAR_2G", 7, Integer.valueOf(64));
      CELLULAR_2G = localAdapterType7;
      AdapterType localAdapterType8 = new AdapterType("CELLULAR_3G", 8, Integer.valueOf(128));
      CELLULAR_3G = localAdapterType8;
      AdapterType localAdapterType9 = new AdapterType("CELLULAR_4G", 9, Integer.valueOf(256));
      CELLULAR_4G = localAdapterType9;
      AdapterType localAdapterType10 = new AdapterType("CELLULAR_5G", 10, Integer.valueOf(512));
      CELLULAR_5G = localAdapterType10;
      $VALUES = new AdapterType[] { localObject, localAdapterType1, localAdapterType2, localAdapterType3, localAdapterType4, localAdapterType5, localAdapterType6, localAdapterType7, localAdapterType8, localAdapterType9, localAdapterType10 };
      BY_BITMASK = new HashMap();
      localObject = values();
      int j = localObject.length;
      while (i < j)
      {
        localAdapterType1 = localObject[i];
        BY_BITMASK.put(localAdapterType1.bitMask, localAdapterType1);
        i += 1;
      }
    }
    
    private AdapterType(Integer paramInteger)
    {
      this.bitMask = paramInteger;
    }
    
    @CalledByNative("AdapterType")
    static AdapterType fromNativeIndex(int paramInt)
    {
      return (AdapterType)BY_BITMASK.get(Integer.valueOf(paramInt));
    }
  }
  
  public static enum BundlePolicy
  {
    static
    {
      BundlePolicy localBundlePolicy1 = new BundlePolicy("BALANCED", 0);
      BALANCED = localBundlePolicy1;
      BundlePolicy localBundlePolicy2 = new BundlePolicy("MAXBUNDLE", 1);
      MAXBUNDLE = localBundlePolicy2;
      BundlePolicy localBundlePolicy3 = new BundlePolicy("MAXCOMPAT", 2);
      MAXCOMPAT = localBundlePolicy3;
      $VALUES = new BundlePolicy[] { localBundlePolicy1, localBundlePolicy2, localBundlePolicy3 };
    }
    
    private BundlePolicy() {}
  }
  
  public static enum CandidateNetworkPolicy
  {
    static
    {
      CandidateNetworkPolicy localCandidateNetworkPolicy1 = new CandidateNetworkPolicy("ALL", 0);
      ALL = localCandidateNetworkPolicy1;
      CandidateNetworkPolicy localCandidateNetworkPolicy2 = new CandidateNetworkPolicy("LOW_COST", 1);
      LOW_COST = localCandidateNetworkPolicy2;
      $VALUES = new CandidateNetworkPolicy[] { localCandidateNetworkPolicy1, localCandidateNetworkPolicy2 };
    }
    
    private CandidateNetworkPolicy() {}
  }
  
  public static enum ContinualGatheringPolicy
  {
    static
    {
      ContinualGatheringPolicy localContinualGatheringPolicy1 = new ContinualGatheringPolicy("GATHER_ONCE", 0);
      GATHER_ONCE = localContinualGatheringPolicy1;
      ContinualGatheringPolicy localContinualGatheringPolicy2 = new ContinualGatheringPolicy("GATHER_CONTINUALLY", 1);
      GATHER_CONTINUALLY = localContinualGatheringPolicy2;
      $VALUES = new ContinualGatheringPolicy[] { localContinualGatheringPolicy1, localContinualGatheringPolicy2 };
    }
    
    private ContinualGatheringPolicy() {}
  }
  
  public static enum IceConnectionState
  {
    static
    {
      IceConnectionState localIceConnectionState1 = new IceConnectionState("NEW", 0);
      NEW = localIceConnectionState1;
      IceConnectionState localIceConnectionState2 = new IceConnectionState("CHECKING", 1);
      CHECKING = localIceConnectionState2;
      IceConnectionState localIceConnectionState3 = new IceConnectionState("CONNECTED", 2);
      CONNECTED = localIceConnectionState3;
      IceConnectionState localIceConnectionState4 = new IceConnectionState("COMPLETED", 3);
      COMPLETED = localIceConnectionState4;
      IceConnectionState localIceConnectionState5 = new IceConnectionState("FAILED", 4);
      FAILED = localIceConnectionState5;
      IceConnectionState localIceConnectionState6 = new IceConnectionState("DISCONNECTED", 5);
      DISCONNECTED = localIceConnectionState6;
      IceConnectionState localIceConnectionState7 = new IceConnectionState("CLOSED", 6);
      CLOSED = localIceConnectionState7;
      $VALUES = new IceConnectionState[] { localIceConnectionState1, localIceConnectionState2, localIceConnectionState3, localIceConnectionState4, localIceConnectionState5, localIceConnectionState6, localIceConnectionState7 };
    }
    
    private IceConnectionState() {}
    
    @CalledByNative("IceConnectionState")
    static IceConnectionState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
  
  public static enum IceGatheringState
  {
    static
    {
      IceGatheringState localIceGatheringState1 = new IceGatheringState("NEW", 0);
      NEW = localIceGatheringState1;
      IceGatheringState localIceGatheringState2 = new IceGatheringState("GATHERING", 1);
      GATHERING = localIceGatheringState2;
      IceGatheringState localIceGatheringState3 = new IceGatheringState("COMPLETE", 2);
      COMPLETE = localIceGatheringState3;
      $VALUES = new IceGatheringState[] { localIceGatheringState1, localIceGatheringState2, localIceGatheringState3 };
    }
    
    private IceGatheringState() {}
    
    @CalledByNative("IceGatheringState")
    static IceGatheringState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
  
  public static class IceServer
  {
    public final String hostname;
    public final String password;
    public final List<String> tlsAlpnProtocols;
    public final PeerConnection.TlsCertPolicy tlsCertPolicy;
    public final List<String> tlsEllipticCurves;
    @Deprecated
    public final String uri;
    public final List<String> urls;
    public final String username;
    
    @Deprecated
    public IceServer(String paramString)
    {
      this(paramString, "", "");
    }
    
    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3)
    {
      this(paramString1, paramString2, paramString3, PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_SECURE);
    }
    
    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy)
    {
      this(paramString1, paramString2, paramString3, paramTlsCertPolicy, "");
    }
    
    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy, String paramString4)
    {
      this(paramString1, Collections.singletonList(paramString1), paramString2, paramString3, paramTlsCertPolicy, paramString4, null, null);
    }
    
    private IceServer(String paramString1, List<String> paramList1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy, String paramString4, List<String> paramList2, List<String> paramList3)
    {
      if ((paramString1 != null) && (paramList1 != null) && (!paramList1.isEmpty()))
      {
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext()) {
          if ((String)localIterator.next() == null)
          {
            paramString1 = new StringBuilder();
            paramString1.append("urls element is null: ");
            paramString1.append(paramList1);
            throw new IllegalArgumentException(paramString1.toString());
          }
        }
        if (paramString2 != null)
        {
          if (paramString3 != null)
          {
            if (paramString4 != null)
            {
              this.uri = paramString1;
              this.urls = paramList1;
              this.username = paramString2;
              this.password = paramString3;
              this.tlsCertPolicy = paramTlsCertPolicy;
              this.hostname = paramString4;
              this.tlsAlpnProtocols = paramList2;
              this.tlsEllipticCurves = paramList3;
              return;
            }
            throw new IllegalArgumentException("hostname == null");
          }
          throw new IllegalArgumentException("password == null");
        }
        throw new IllegalArgumentException("username == null");
      }
      throw new IllegalArgumentException("uri == null || urls == null || urls.isEmpty()");
    }
    
    public static Builder builder(String paramString)
    {
      return new Builder(Collections.singletonList(paramString), null);
    }
    
    public static Builder builder(List<String> paramList)
    {
      return new Builder(paramList, null);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      if (paramObject == null) {
        return false;
      }
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof IceServer)) {
        return false;
      }
      paramObject = (IceServer)paramObject;
      boolean bool1 = bool2;
      if (this.uri.equals(paramObject.uri))
      {
        bool1 = bool2;
        if (this.urls.equals(paramObject.urls))
        {
          bool1 = bool2;
          if (this.username.equals(paramObject.username))
          {
            bool1 = bool2;
            if (this.password.equals(paramObject.password))
            {
              bool1 = bool2;
              if (this.tlsCertPolicy.equals(paramObject.tlsCertPolicy))
              {
                bool1 = bool2;
                if (this.hostname.equals(paramObject.hostname))
                {
                  bool1 = bool2;
                  if (this.tlsAlpnProtocols.equals(paramObject.tlsAlpnProtocols))
                  {
                    bool1 = bool2;
                    if (this.tlsEllipticCurves.equals(paramObject.tlsEllipticCurves)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    
    @CalledByNative("IceServer")
    String getHostname()
    {
      return this.hostname;
    }
    
    @CalledByNative("IceServer")
    String getPassword()
    {
      return this.password;
    }
    
    @CalledByNative("IceServer")
    List<String> getTlsAlpnProtocols()
    {
      return this.tlsAlpnProtocols;
    }
    
    @CalledByNative("IceServer")
    PeerConnection.TlsCertPolicy getTlsCertPolicy()
    {
      return this.tlsCertPolicy;
    }
    
    @CalledByNative("IceServer")
    List<String> getTlsEllipticCurves()
    {
      return this.tlsEllipticCurves;
    }
    
    @CalledByNative("IceServer")
    List<String> getUrls()
    {
      return this.urls;
    }
    
    @CalledByNative("IceServer")
    String getUsername()
    {
      return this.username;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Object[] { this.uri, this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.urls);
      localStringBuilder.append(" [");
      localStringBuilder.append(this.username);
      localStringBuilder.append(":");
      localStringBuilder.append(this.password);
      localStringBuilder.append("] [");
      localStringBuilder.append(this.tlsCertPolicy);
      localStringBuilder.append("] [");
      localStringBuilder.append(this.hostname);
      localStringBuilder.append("] [");
      localStringBuilder.append(this.tlsAlpnProtocols);
      localStringBuilder.append("] [");
      localStringBuilder.append(this.tlsEllipticCurves);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    
    public static class Builder
    {
      private String hostname = "";
      private String password = "";
      private List<String> tlsAlpnProtocols;
      private PeerConnection.TlsCertPolicy tlsCertPolicy = PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_SECURE;
      private List<String> tlsEllipticCurves;
      private final List<String> urls;
      private String username = "";
      
      private Builder(List<String> paramList)
      {
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          this.urls = paramList;
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("urls == null || urls.isEmpty(): ");
        localStringBuilder.append(paramList);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      
      public PeerConnection.IceServer createIceServer()
      {
        return new PeerConnection.IceServer((String)this.urls.get(0), this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves, null);
      }
      
      public Builder setHostname(String paramString)
      {
        this.hostname = paramString;
        return this;
      }
      
      public Builder setPassword(String paramString)
      {
        this.password = paramString;
        return this;
      }
      
      public Builder setTlsAlpnProtocols(List<String> paramList)
      {
        this.tlsAlpnProtocols = paramList;
        return this;
      }
      
      public Builder setTlsCertPolicy(PeerConnection.TlsCertPolicy paramTlsCertPolicy)
      {
        this.tlsCertPolicy = paramTlsCertPolicy;
        return this;
      }
      
      public Builder setTlsEllipticCurves(List<String> paramList)
      {
        this.tlsEllipticCurves = paramList;
        return this;
      }
      
      public Builder setUsername(String paramString)
      {
        this.username = paramString;
        return this;
      }
    }
  }
  
  public static enum IceTransportsType
  {
    static
    {
      IceTransportsType localIceTransportsType1 = new IceTransportsType("NONE", 0);
      NONE = localIceTransportsType1;
      IceTransportsType localIceTransportsType2 = new IceTransportsType("RELAY", 1);
      RELAY = localIceTransportsType2;
      IceTransportsType localIceTransportsType3 = new IceTransportsType("NOHOST", 2);
      NOHOST = localIceTransportsType3;
      IceTransportsType localIceTransportsType4 = new IceTransportsType("ALL", 3);
      ALL = localIceTransportsType4;
      $VALUES = new IceTransportsType[] { localIceTransportsType1, localIceTransportsType2, localIceTransportsType3, localIceTransportsType4 };
    }
    
    private IceTransportsType() {}
  }
  
  public static enum KeyType
  {
    static
    {
      KeyType localKeyType1 = new KeyType("RSA", 0);
      RSA = localKeyType1;
      KeyType localKeyType2 = new KeyType("ECDSA", 1);
      ECDSA = localKeyType2;
      $VALUES = new KeyType[] { localKeyType1, localKeyType2 };
    }
    
    private KeyType() {}
  }
  
  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onAddStream(MediaStream paramMediaStream);
    
    @CalledByNative("Observer")
    public abstract void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream);
    
    @CalledByNative("Observer")
    public abstract void onConnectionChange(PeerConnection.PeerConnectionState paramPeerConnectionState);
    
    @CalledByNative("Observer")
    public abstract void onDataChannel(DataChannel paramDataChannel);
    
    @CalledByNative("Observer")
    public abstract void onIceCandidate(IceCandidate paramIceCandidate);
    
    @CalledByNative("Observer")
    public abstract void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate);
    
    @CalledByNative("Observer")
    public abstract void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState);
    
    @CalledByNative("Observer")
    public abstract void onIceConnectionReceivingChange(boolean paramBoolean);
    
    @CalledByNative("Observer")
    public abstract void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState);
    
    @CalledByNative("Observer")
    public abstract void onRemoveStream(MediaStream paramMediaStream);
    
    @CalledByNative("Observer")
    public abstract void onRenegotiationNeeded();
    
    @CalledByNative("Observer")
    public abstract void onSelectedCandidatePairChanged(CandidatePairChangeEvent paramCandidatePairChangeEvent);
    
    @CalledByNative("Observer")
    public abstract void onSignalingChange(PeerConnection.SignalingState paramSignalingState);
    
    @CalledByNative("Observer")
    public abstract void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState);
    
    @CalledByNative("Observer")
    public abstract void onTrack(RtpTransceiver paramRtpTransceiver);
  }
  
  public static enum PeerConnectionState
  {
    static
    {
      PeerConnectionState localPeerConnectionState1 = new PeerConnectionState("NEW", 0);
      NEW = localPeerConnectionState1;
      PeerConnectionState localPeerConnectionState2 = new PeerConnectionState("CONNECTING", 1);
      CONNECTING = localPeerConnectionState2;
      PeerConnectionState localPeerConnectionState3 = new PeerConnectionState("CONNECTED", 2);
      CONNECTED = localPeerConnectionState3;
      PeerConnectionState localPeerConnectionState4 = new PeerConnectionState("DISCONNECTED", 3);
      DISCONNECTED = localPeerConnectionState4;
      PeerConnectionState localPeerConnectionState5 = new PeerConnectionState("FAILED", 4);
      FAILED = localPeerConnectionState5;
      PeerConnectionState localPeerConnectionState6 = new PeerConnectionState("CLOSED", 5);
      CLOSED = localPeerConnectionState6;
      $VALUES = new PeerConnectionState[] { localPeerConnectionState1, localPeerConnectionState2, localPeerConnectionState3, localPeerConnectionState4, localPeerConnectionState5, localPeerConnectionState6 };
    }
    
    private PeerConnectionState() {}
    
    @CalledByNative("PeerConnectionState")
    static PeerConnectionState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
  
  public static enum PortPrunePolicy
  {
    static
    {
      PortPrunePolicy localPortPrunePolicy1 = new PortPrunePolicy("NO_PRUNE", 0);
      NO_PRUNE = localPortPrunePolicy1;
      PortPrunePolicy localPortPrunePolicy2 = new PortPrunePolicy("PRUNE_BASED_ON_PRIORITY", 1);
      PRUNE_BASED_ON_PRIORITY = localPortPrunePolicy2;
      PortPrunePolicy localPortPrunePolicy3 = new PortPrunePolicy("KEEP_FIRST_READY", 2);
      KEEP_FIRST_READY = localPortPrunePolicy3;
      $VALUES = new PortPrunePolicy[] { localPortPrunePolicy1, localPortPrunePolicy2, localPortPrunePolicy3 };
    }
    
    private PortPrunePolicy() {}
  }
  
  public static class RTCConfiguration
  {
    public boolean activeResetSrtpParams;
    public Boolean allowCodecSwitching;
    public boolean audioJitterBufferFastAccelerate;
    public int audioJitterBufferMaxPackets;
    public PeerConnection.BundlePolicy bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
    public PeerConnection.CandidateNetworkPolicy candidateNetworkPolicy = PeerConnection.CandidateNetworkPolicy.ALL;
    public RtcCertificatePem certificate;
    public Boolean combinedAudioVideoBwe;
    public PeerConnection.ContinualGatheringPolicy continualGatheringPolicy;
    public CryptoOptions cryptoOptions;
    public boolean disableIPv6OnWifi;
    public boolean disableIpv6;
    public boolean enableCpuOveruseDetection;
    public boolean enableDscp;
    public Boolean enableDtlsSrtp;
    public boolean enableRtpDataChannel;
    public int iceBackupCandidatePairPingInterval;
    public int iceCandidatePoolSize;
    public Integer iceCheckIntervalStrongConnectivityMs;
    public Integer iceCheckIntervalWeakConnectivityMs;
    public Integer iceCheckMinInterval;
    public int iceConnectionReceivingTimeout;
    public List<PeerConnection.IceServer> iceServers;
    public PeerConnection.IceTransportsType iceTransportsType = PeerConnection.IceTransportsType.ALL;
    public Integer iceUnwritableMinChecks;
    public Integer iceUnwritableTimeMs;
    public PeerConnection.KeyType keyType;
    public int maxIPv6Networks;
    public PeerConnection.AdapterType networkPreference;
    public boolean presumeWritableWhenFullyRelayed;
    @Deprecated
    public boolean pruneTurnPorts;
    public PeerConnection.RtcpMuxPolicy rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
    public Integer screencastMinBitrate;
    public PeerConnection.SdpSemantics sdpSemantics;
    public Integer stunCandidateKeepaliveIntervalMs;
    public boolean surfaceIceCandidatesOnIceTransportTypeChanged;
    public boolean suspendBelowMinBitrate;
    public PeerConnection.TcpCandidatePolicy tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.ENABLED;
    public TurnCustomizer turnCustomizer;
    public String turnLoggingId;
    public PeerConnection.PortPrunePolicy turnPortPrunePolicy;
    
    public RTCConfiguration(List<PeerConnection.IceServer> paramList)
    {
      this.iceServers = paramList;
      this.audioJitterBufferMaxPackets = 50;
      this.audioJitterBufferFastAccelerate = false;
      this.iceConnectionReceivingTimeout = -1;
      this.iceBackupCandidatePairPingInterval = -1;
      this.keyType = PeerConnection.KeyType.ECDSA;
      this.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_ONCE;
      this.iceCandidatePoolSize = 0;
      this.pruneTurnPorts = false;
      this.turnPortPrunePolicy = PeerConnection.PortPrunePolicy.NO_PRUNE;
      this.presumeWritableWhenFullyRelayed = false;
      this.surfaceIceCandidatesOnIceTransportTypeChanged = false;
      this.iceCheckIntervalStrongConnectivityMs = null;
      this.iceCheckIntervalWeakConnectivityMs = null;
      this.iceCheckMinInterval = null;
      this.iceUnwritableTimeMs = null;
      this.iceUnwritableMinChecks = null;
      this.stunCandidateKeepaliveIntervalMs = null;
      this.disableIPv6OnWifi = false;
      this.maxIPv6Networks = 5;
      this.disableIpv6 = false;
      this.enableDscp = false;
      this.enableCpuOveruseDetection = true;
      this.enableRtpDataChannel = false;
      this.suspendBelowMinBitrate = false;
      this.screencastMinBitrate = null;
      this.combinedAudioVideoBwe = null;
      this.enableDtlsSrtp = null;
      this.networkPreference = PeerConnection.AdapterType.UNKNOWN;
      this.sdpSemantics = PeerConnection.SdpSemantics.PLAN_B;
      this.activeResetSrtpParams = false;
      this.cryptoOptions = null;
      this.turnLoggingId = null;
      this.allowCodecSwitching = null;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getActiveResetSrtpParams()
    {
      return this.activeResetSrtpParams;
    }
    
    @CalledByNative("RTCConfiguration")
    Boolean getAllowCodecSwitching()
    {
      return this.allowCodecSwitching;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getAudioJitterBufferFastAccelerate()
    {
      return this.audioJitterBufferFastAccelerate;
    }
    
    @CalledByNative("RTCConfiguration")
    int getAudioJitterBufferMaxPackets()
    {
      return this.audioJitterBufferMaxPackets;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.BundlePolicy getBundlePolicy()
    {
      return this.bundlePolicy;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.CandidateNetworkPolicy getCandidateNetworkPolicy()
    {
      return this.candidateNetworkPolicy;
    }
    
    @CalledByNative("RTCConfiguration")
    RtcCertificatePem getCertificate()
    {
      return this.certificate;
    }
    
    @CalledByNative("RTCConfiguration")
    Boolean getCombinedAudioVideoBwe()
    {
      return this.combinedAudioVideoBwe;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.ContinualGatheringPolicy getContinualGatheringPolicy()
    {
      return this.continualGatheringPolicy;
    }
    
    @CalledByNative("RTCConfiguration")
    CryptoOptions getCryptoOptions()
    {
      return this.cryptoOptions;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getDisableIPv6OnWifi()
    {
      return this.disableIPv6OnWifi;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getDisableIpv6()
    {
      return this.disableIpv6;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getEnableCpuOveruseDetection()
    {
      return this.enableCpuOveruseDetection;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getEnableDscp()
    {
      return this.enableDscp;
    }
    
    @CalledByNative("RTCConfiguration")
    Boolean getEnableDtlsSrtp()
    {
      return this.enableDtlsSrtp;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getEnableRtpDataChannel()
    {
      return this.enableRtpDataChannel;
    }
    
    @CalledByNative("RTCConfiguration")
    int getIceBackupCandidatePairPingInterval()
    {
      return this.iceBackupCandidatePairPingInterval;
    }
    
    @CalledByNative("RTCConfiguration")
    int getIceCandidatePoolSize()
    {
      return this.iceCandidatePoolSize;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckIntervalStrongConnectivity()
    {
      return this.iceCheckIntervalStrongConnectivityMs;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckIntervalWeakConnectivity()
    {
      return this.iceCheckIntervalWeakConnectivityMs;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckMinInterval()
    {
      return this.iceCheckMinInterval;
    }
    
    @CalledByNative("RTCConfiguration")
    int getIceConnectionReceivingTimeout()
    {
      return this.iceConnectionReceivingTimeout;
    }
    
    @CalledByNative("RTCConfiguration")
    List<PeerConnection.IceServer> getIceServers()
    {
      return this.iceServers;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.IceTransportsType getIceTransportsType()
    {
      return this.iceTransportsType;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getIceUnwritableMinChecks()
    {
      return this.iceUnwritableMinChecks;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getIceUnwritableTimeout()
    {
      return this.iceUnwritableTimeMs;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.KeyType getKeyType()
    {
      return this.keyType;
    }
    
    @CalledByNative("RTCConfiguration")
    int getMaxIPv6Networks()
    {
      return this.maxIPv6Networks;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.AdapterType getNetworkPreference()
    {
      return this.networkPreference;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getPresumeWritableWhenFullyRelayed()
    {
      return this.presumeWritableWhenFullyRelayed;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getPruneTurnPorts()
    {
      return this.pruneTurnPorts;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.RtcpMuxPolicy getRtcpMuxPolicy()
    {
      return this.rtcpMuxPolicy;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getScreencastMinBitrate()
    {
      return this.screencastMinBitrate;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.SdpSemantics getSdpSemantics()
    {
      return this.sdpSemantics;
    }
    
    @CalledByNative("RTCConfiguration")
    Integer getStunCandidateKeepaliveInterval()
    {
      return this.stunCandidateKeepaliveIntervalMs;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getSurfaceIceCandidatesOnIceTransportTypeChanged()
    {
      return this.surfaceIceCandidatesOnIceTransportTypeChanged;
    }
    
    @CalledByNative("RTCConfiguration")
    boolean getSuspendBelowMinBitrate()
    {
      return this.suspendBelowMinBitrate;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.TcpCandidatePolicy getTcpCandidatePolicy()
    {
      return this.tcpCandidatePolicy;
    }
    
    @CalledByNative("RTCConfiguration")
    TurnCustomizer getTurnCustomizer()
    {
      return this.turnCustomizer;
    }
    
    @CalledByNative("RTCConfiguration")
    String getTurnLoggingId()
    {
      return this.turnLoggingId;
    }
    
    @CalledByNative("RTCConfiguration")
    PeerConnection.PortPrunePolicy getTurnPortPrunePolicy()
    {
      return this.turnPortPrunePolicy;
    }
  }
  
  public static enum RtcpMuxPolicy
  {
    static
    {
      RtcpMuxPolicy localRtcpMuxPolicy1 = new RtcpMuxPolicy("NEGOTIATE", 0);
      NEGOTIATE = localRtcpMuxPolicy1;
      RtcpMuxPolicy localRtcpMuxPolicy2 = new RtcpMuxPolicy("REQUIRE", 1);
      REQUIRE = localRtcpMuxPolicy2;
      $VALUES = new RtcpMuxPolicy[] { localRtcpMuxPolicy1, localRtcpMuxPolicy2 };
    }
    
    private RtcpMuxPolicy() {}
  }
  
  public static enum SdpSemantics
  {
    static
    {
      SdpSemantics localSdpSemantics1 = new SdpSemantics("PLAN_B", 0);
      PLAN_B = localSdpSemantics1;
      SdpSemantics localSdpSemantics2 = new SdpSemantics("UNIFIED_PLAN", 1);
      UNIFIED_PLAN = localSdpSemantics2;
      $VALUES = new SdpSemantics[] { localSdpSemantics1, localSdpSemantics2 };
    }
    
    private SdpSemantics() {}
  }
  
  public static enum SignalingState
  {
    static
    {
      SignalingState localSignalingState1 = new SignalingState("STABLE", 0);
      STABLE = localSignalingState1;
      SignalingState localSignalingState2 = new SignalingState("HAVE_LOCAL_OFFER", 1);
      HAVE_LOCAL_OFFER = localSignalingState2;
      SignalingState localSignalingState3 = new SignalingState("HAVE_LOCAL_PRANSWER", 2);
      HAVE_LOCAL_PRANSWER = localSignalingState3;
      SignalingState localSignalingState4 = new SignalingState("HAVE_REMOTE_OFFER", 3);
      HAVE_REMOTE_OFFER = localSignalingState4;
      SignalingState localSignalingState5 = new SignalingState("HAVE_REMOTE_PRANSWER", 4);
      HAVE_REMOTE_PRANSWER = localSignalingState5;
      SignalingState localSignalingState6 = new SignalingState("CLOSED", 5);
      CLOSED = localSignalingState6;
      $VALUES = new SignalingState[] { localSignalingState1, localSignalingState2, localSignalingState3, localSignalingState4, localSignalingState5, localSignalingState6 };
    }
    
    private SignalingState() {}
    
    @CalledByNative("SignalingState")
    static SignalingState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
  
  public static enum TcpCandidatePolicy
  {
    static
    {
      TcpCandidatePolicy localTcpCandidatePolicy1 = new TcpCandidatePolicy("ENABLED", 0);
      ENABLED = localTcpCandidatePolicy1;
      TcpCandidatePolicy localTcpCandidatePolicy2 = new TcpCandidatePolicy("DISABLED", 1);
      DISABLED = localTcpCandidatePolicy2;
      $VALUES = new TcpCandidatePolicy[] { localTcpCandidatePolicy1, localTcpCandidatePolicy2 };
    }
    
    private TcpCandidatePolicy() {}
  }
  
  public static enum TlsCertPolicy
  {
    static
    {
      TlsCertPolicy localTlsCertPolicy1 = new TlsCertPolicy("TLS_CERT_POLICY_SECURE", 0);
      TLS_CERT_POLICY_SECURE = localTlsCertPolicy1;
      TlsCertPolicy localTlsCertPolicy2 = new TlsCertPolicy("TLS_CERT_POLICY_INSECURE_NO_CHECK", 1);
      TLS_CERT_POLICY_INSECURE_NO_CHECK = localTlsCertPolicy2;
      $VALUES = new TlsCertPolicy[] { localTlsCertPolicy1, localTlsCertPolicy2 };
    }
    
    private TlsCertPolicy() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.PeerConnection
 * JD-Core Version:    0.7.0.1
 */