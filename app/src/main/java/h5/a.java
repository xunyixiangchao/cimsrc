package h5;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.group.api.request.GroupMessageRequest;
import com.farsunset.hoxin.message.api.request.MessageForwardRequest;
import com.farsunset.hoxin.message.api.request.MessageRequest;
import ga.c;
import ga.e;
import ga.f;
import ga.o;
import ga.s;
import ga.t;

public abstract interface a
{
  @o("message/group")
  public abstract ea.b<LongResult> a(@ga.a GroupMessageRequest paramGroupMessageRequest);
  
  @o("message/typing")
  public abstract ea.b<BaseResult> b(@t("uid") Long paramLong);
  
  @ga.b("message/revoke/{id}")
  public abstract ea.b<BaseResult> c(@s("id") long paramLong, @t("action") String paramString);
  
  @o("message/forward")
  public abstract ea.b<g5.a> d(@ga.a MessageForwardRequest paramMessageForwardRequest);
  
  @o("message/receive/all")
  public abstract ea.b<BaseResult> e();
  
  @o("message")
  public abstract ea.b<LongResult> f(@ga.a MessageRequest paramMessageRequest);
  
  @o("message/read/{id}/{sender}")
  public abstract ea.b<BaseResult> g(@s("id") Long paramLong1, @s("sender") Long paramLong2);
  
  @f("message/list/offline")
  public abstract ea.b<g5.b> h();
  
  @e
  @o("message/receive/{id}")
  public abstract ea.b<BaseResult> i(@s("id") Long paramLong, @c("action") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h5.a
 * JD-Core Version:    0.7.0.1
 */