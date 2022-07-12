package u6;

import a7.d;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.webrtc.api.request.CreateRoomRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAcceptRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAddRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomAnswerRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomIceRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomOfferRequest;
import com.farsunset.hoxin.webrtc.api.request.RoomRecallRequest;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import l3.b.c;
import l3.b.d;
import org.webrtc.IceCandidate;
import s3.e;
import u3.l;

public class a
  extends l3.b
{
  public static void b(RoomAcceptRequest paramRoomAcceptRequest)
  {
    ((v6.a)l3.b.a(v6.a.class)).d(paramRoomAcceptRequest).B(l3.b.a);
  }
  
  public static void c(RoomAddRequest paramRoomAddRequest)
  {
    ((v6.a)l3.b.a(v6.a.class)).e(paramRoomAddRequest).B(l3.b.a);
  }
  
  public static void d(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).n(paramString).B(l3.b.a);
  }
  
  public static void e(AvRoom paramAvRoom, e<LongResult> parame)
  {
    CreateRoomRequest localCreateRoomRequest = new CreateRoomRequest();
    localCreateRoomRequest.setTag(paramAvRoom.getTag());
    localCreateRoomRequest.setMember(paramAvRoom.getMember());
    v6.a locala = (v6.a)l3.b.a(v6.a.class);
    if (paramAvRoom.getType() == 10) {
      locala.k(localCreateRoomRequest).B(new b.d(parame));
    }
    if (paramAvRoom.getType() == 11) {
      locala.q(localCreateRoomRequest).B(new b.d(parame));
    }
  }
  
  public static void f(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).a(paramString).B(l3.b.a);
  }
  
  public static void g(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).l(paramString).B(l3.b.a);
  }
  
  public static void h(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).m(paramString).B(l3.b.a);
  }
  
  public static void i(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).r(paramString).B(l3.b.a);
  }
  
  public static void j(RoomRecallRequest paramRoomRecallRequest)
  {
    ((v6.a)l3.b.a(v6.a.class)).o(paramRoomRecallRequest).B(l3.b.a);
  }
  
  public static void k(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).f(paramString).B(l3.b.a);
  }
  
  public static void l(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).i(paramString).B(l3.b.a);
  }
  
  public static void m(String paramString, boolean paramBoolean)
  {
    ((v6.a)l3.b.a(v6.a.class)).p(paramString, paramBoolean).B(l3.b.a);
  }
  
  public static void n(String paramString, boolean paramBoolean)
  {
    ((v6.a)l3.b.a(v6.a.class)).h(paramString, paramBoolean).B(l3.b.a);
  }
  
  public static void o(String paramString)
  {
    ((v6.a)l3.b.a(v6.a.class)).j(paramString).B(l3.b.a);
  }
  
  public static void p(RoomAnswerRequest paramRoomAnswerRequest)
  {
    ((v6.a)l3.b.a(v6.a.class)).b(paramRoomAnswerRequest).B(l3.b.a);
  }
  
  public static void q(String paramString, long paramLong, IceCandidate paramIceCandidate)
  {
    RoomIceRequest localRoomIceRequest = new RoomIceRequest();
    localRoomIceRequest.setTag(paramString);
    localRoomIceRequest.setUid(Long.valueOf(paramLong));
    localRoomIceRequest.setContent(l.H0(paramIceCandidate));
    ((v6.a)l3.b.a(v6.a.class)).c(localRoomIceRequest).B(l3.b.a);
  }
  
  public static void r(final RoomOfferRequest paramRoomOfferRequest, d paramd)
  {
    ((v6.a)l3.b.a(v6.a.class)).g(paramRoomOfferRequest).B(new b.c(new a(paramd, paramRoomOfferRequest)));
  }
  
  class a
    implements e<BaseResult>
  {
    a(RoomOfferRequest paramRoomOfferRequest) {}
    
    public void onHttpException(Exception paramException) {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      if (paramBaseResult.code == 403) {
        a.this.a0(paramRoomOfferRequest.getUid().longValue());
      }
      if (paramBaseResult.code == 404) {
        a.this.B0(paramRoomOfferRequest.getUid().longValue());
      }
      if (paramBaseResult.code == 423) {
        a.this.r(paramRoomOfferRequest.getUid().longValue());
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u6.a
 * JD-Core Version:    0.7.0.1
 */