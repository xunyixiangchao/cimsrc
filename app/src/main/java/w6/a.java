package w6;

import com.farsunset.hoxin.HoxinApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.DefaultVideoEncoderFactory;
import org.webrtc.EglBase;
import org.webrtc.EglBase.Context;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceServer;
import org.webrtc.PeerConnection.IceServer.Builder;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.PeerConnectionFactory.Builder;
import org.webrtc.PeerConnectionFactory.InitializationOptions;
import org.webrtc.PeerConnectionFactory.InitializationOptions.Builder;
import org.webrtc.PeerConnectionFactory.Options;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.JavaAudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule.Builder;
import org.webrtc.g;

public class a
{
  public static final MediaConstraints c;
  public static final List<String> d;
  private static final MediaConstraints e;
  private static final PeerConnection.RTCConfiguration f;
  private static a g;
  private final EglBase a;
  private final PeerConnectionFactory b;
  
  static
  {
    MediaConstraints localMediaConstraints1 = new MediaConstraints();
    c = localMediaConstraints1;
    d = Collections.singletonList("ARDAMS");
    MediaConstraints localMediaConstraints2 = new MediaConstraints();
    e = localMediaConstraints2;
    Object localObject = new ArrayList();
    ((List)localObject).add(PeerConnection.IceServer.builder("stun:stun.l.google.com:19302").createIceServer());
    ((List)localObject).add(PeerConnection.IceServer.builder("turn:turn.farsunset.com:3478").setUsername("coturn").setPassword("coturnv5").createIceServer());
    localObject = new PeerConnection.RTCConfiguration((List)localObject);
    f = (PeerConnection.RTCConfiguration)localObject;
    ((PeerConnection.RTCConfiguration)localObject).enableDtlsSrtp = Boolean.TRUE;
    localMediaConstraints1.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    localMediaConstraints1.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation2", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googDAEchoCancellation", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl2", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googAudioMirroring", "false"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression2", "true"));
    localMediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("googTypingNoiseDetection", "true"));
  }
  
  private a()
  {
    EglBase localEglBase = g.b();
    this.a = localEglBase;
    PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(HoxinApplication.h()).createInitializationOptions());
    JavaAudioDeviceModule localJavaAudioDeviceModule = JavaAudioDeviceModule.builder(HoxinApplication.h()).setUseHardwareAcousticEchoCanceler(false).setUseHardwareNoiseSuppressor(false).createAudioDeviceModule();
    this.b = PeerConnectionFactory.builder().setAudioDeviceModule(localJavaAudioDeviceModule).setVideoDecoderFactory(new DefaultVideoDecoderFactory(localEglBase.getEglBaseContext())).setVideoEncoderFactory(new DefaultVideoEncoderFactory(localEglBase.getEglBaseContext(), true, true)).setOptions(new PeerConnectionFactory.Options()).createPeerConnectionFactory();
  }
  
  public static a h()
  {
    if (g == null) {
      g = new a();
    }
    return g;
  }
  
  public AudioSource a()
  {
    return this.b.createAudioSource(e);
  }
  
  public AudioTrack b(AudioSource paramAudioSource)
  {
    return this.b.createAudioTrack("ARDAMSa0", paramAudioSource);
  }
  
  public PeerConnection c(PeerConnection.Observer paramObserver)
  {
    return this.b.createPeerConnection(f, paramObserver);
  }
  
  public d d(long paramLong, e parame)
  {
    parame = new d(paramLong, parame);
    parame.j(c(parame));
    return parame;
  }
  
  public VideoSource e(boolean paramBoolean)
  {
    return this.b.createVideoSource(paramBoolean);
  }
  
  public VideoTrack f(VideoSource paramVideoSource)
  {
    return this.b.createVideoTrack("ARDAMSv0", paramVideoSource);
  }
  
  public EglBase.Context g()
  {
    return this.a.getEglBaseContext();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w6.a
 * JD-Core Version:    0.7.0.1
 */