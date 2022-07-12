package v6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.webrtc.api.request.CreateRoomRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAcceptRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAddRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAnswerRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomIceRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomOfferRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomRecallRequest;
import ea.b;
import ga.c;
import ga.e;
import ga.o;

public abstract interface a
{
  @e
  @o("webrtc/group/cancel")
  public abstract b<BaseResult> a(@c("tag") String paramString);
  
  @o("webrtc/group/transmit/answer")
  public abstract b<BaseResult> b(@ga.a RoomAnswerRequest paramRoomAnswerRequest);
  
  @o("webrtc/group/transmit/ice")
  public abstract b<BaseResult> c(@ga.a RoomIceRequest paramRoomIceRequest);
  
  @o("webrtc/group/accept")
  public abstract b<BaseResult> d(@ga.a RoomAcceptRequest paramRoomAcceptRequest);
  
  @o("webrtc/group/add")
  public abstract b<BaseResult> e(@ga.a RoomAddRequest paramRoomAddRequest);
  
  @e
  @o("webrtc/group/reject")
  public abstract b<BaseResult> f(@c("tag") String paramString);
  
  @o("webrtc/group/transmit/offer")
  public abstract b<BaseResult> g(@ga.a RoomOfferRequest paramRoomOfferRequest);
  
  @e
  @o("webrtc/group/microphone/switch")
  public abstract b<BaseResult> h(@c("tag") String paramString, @c("value") boolean paramBoolean);
  
  @e
  @o("webrtc/group/microphone/resume")
  public abstract b<BaseResult> i(@c("tag") String paramString);
  
  @e
  @o("webrtc/group/timeout")
  public abstract b<BaseResult> j(@c("tag") String paramString);
  
  @o("webrtc/group/voice")
  public abstract b<LongResult> k(@ga.a CreateRoomRequest paramCreateRoomRequest);
  
  @e
  @o("webrtc/group/microphone/disable")
  public abstract b<BaseResult> l(@c("tag") String paramString);
  
  @e
  @o("webrtc/group/finish")
  public abstract b<BaseResult> m(@c("tag") String paramString);
  
  @e
  @o("webrtc/group/busy")
  public abstract b<BaseResult> n(@c("tag") String paramString);
  
  @o("webrtc/group/recall")
  public abstract b<BaseResult> o(@ga.a RoomRecallRequest paramRoomRecallRequest);
  
  @e
  @o("webrtc/group/camera/switch")
  public abstract b<BaseResult> p(@c("tag") String paramString, @c("value") boolean paramBoolean);
  
  @o("webrtc/group/video")
  public abstract b<LongResult> q(@ga.a CreateRoomRequest paramCreateRoomRequest);
  
  @e
  @o("webrtc/group/quit")
  public abstract b<BaseResult> r(@c("tag") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v6.a
 * JD-Core Version:    0.7.0.1
 */