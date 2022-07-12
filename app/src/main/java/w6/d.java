package w6;

import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.RtpReceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import u3.m0;
import u3.t;

public class d
  implements PeerConnection.Observer, SdpObserver
{
  private final long a;
  private PeerConnection b;
  private final e c;
  
  public d(long paramLong, e parame)
  {
    this.a = paramLong;
    this.c = parame;
  }
  
  public void c(IceCandidate paramIceCandidate)
  {
    this.b.addIceCandidate(paramIceCandidate);
  }
  
  public void d(MediaStreamTrack paramMediaStreamTrack)
  {
    if (paramMediaStreamTrack != null) {
      this.b.addTrack(paramMediaStreamTrack, a.d);
    }
  }
  
  public void e()
  {
    this.b.createAnswer(this, a.c);
  }
  
  public void f()
  {
    this.b.createOffer(this, a.c);
  }
  
  public void g()
  {
    this.b.close();
    this.b.dispose();
  }
  
  public void j(PeerConnection paramPeerConnection)
  {
    this.b = paramPeerConnection;
  }
  
  public void k(SessionDescription paramSessionDescription)
  {
    this.b.setRemoteDescription(this, paramSessionDescription);
  }
  
  public void onAddStream(MediaStream paramMediaStream)
  {
    m0.b(new c(this, paramMediaStream));
  }
  
  public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream) {}
  
  public void onCreateFailure(String paramString) {}
  
  public void onCreateSuccess(SessionDescription paramSessionDescription)
  {
    this.b.setLocalDescription(this, paramSessionDescription);
    if (paramSessionDescription.type == SessionDescription.Type.OFFER) {
      this.c.e0(this.a, paramSessionDescription);
    }
    if (paramSessionDescription.type == SessionDescription.Type.ANSWER) {
      this.c.x0(this.a, paramSessionDescription);
    }
  }
  
  public void onDataChannel(DataChannel paramDataChannel)
  {
    t.c("GroupConnection", paramDataChannel.toString());
  }
  
  public void onIceCandidate(IceCandidate paramIceCandidate)
  {
    this.c.Y(this.a, paramIceCandidate);
  }
  
  public void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate)
  {
    t.c("GroupConnection", paramArrayOfIceCandidate.toString());
  }
  
  public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState) {}
  
  public void onIceConnectionReceivingChange(boolean paramBoolean) {}
  
  public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
  {
    t.c("onIceGatheringChange", paramIceGatheringState.toString());
  }
  
  public void onRemoveStream(MediaStream paramMediaStream)
  {
    m0.b(new b(this, paramMediaStream));
  }
  
  public void onRenegotiationNeeded() {}
  
  public void onSetFailure(String paramString) {}
  
  public void onSetSuccess() {}
  
  public void onSignalingChange(PeerConnection.SignalingState paramSignalingState)
  {
    t.c("onSignalingChange", paramSignalingState.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w6.d
 * JD-Core Version:    0.7.0.1
 */