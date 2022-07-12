package v6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import ga.c;
import ga.e;
import ga.o;

public abstract interface b
{
  @e
  @o("webrtc/accept")
  public abstract ea.b<BaseResult> a(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/voice")
  public abstract ea.b<BaseResult> b(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/transmit/ice")
  public abstract ea.b<BaseResult> c(@c("targetId") Long paramLong, @c("content") String paramString);
  
  @e
  @o("webrtc/transmit/offer")
  public abstract ea.b<BaseResult> d(@c("targetId") Long paramLong, @c("content") String paramString);
  
  @e
  @o("webrtc/cancel")
  public abstract ea.b<BaseResult> e(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/transmit/answer")
  public abstract ea.b<BaseResult> f(@c("targetId") Long paramLong, @c("content") String paramString);
  
  @e
  @o("webrtc/busy")
  public abstract ea.b<BaseResult> g(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/reject")
  public abstract ea.b<BaseResult> h(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/hangup")
  public abstract ea.b<BaseResult> i(@c("targetId") Long paramLong);
  
  @e
  @o("webrtc/video")
  public abstract ea.b<BaseResult> j(@c("targetId") Long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v6.b
 * JD-Core Version:    0.7.0.1
 */