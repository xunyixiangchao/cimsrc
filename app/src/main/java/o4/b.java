package o4;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.group.api.request.GroupCreateRequest;
import com.farsunset.hoxin.group.api.request.GroupInviteRequest;
import com.farsunset.hoxin.group.api.response.GroupResult;
import ga.a;
import ga.c;
import ga.e;
import ga.f;
import ga.n;
import ga.o;
import ga.s;

public abstract interface b
{
  @f("group/{id}")
  public abstract ea.b<GroupResult> a(@s("id") long paramLong);
  
  @e
  @n("group/{id}/name")
  public abstract ea.b<BaseResult> b(@s("id") long paramLong, @c("name") String paramString);
  
  @o("group/invite")
  public abstract ea.b<BaseResult> c(@a GroupInviteRequest paramGroupInviteRequest);
  
  @ga.b("group/block/{id}")
  public abstract ea.b<BaseResult> d(@s("id") long paramLong);
  
  @o("group/block/{id}")
  public abstract ea.b<BaseResult> e(@s("id") long paramLong);
  
  @o("group")
  public abstract ea.b<LongResult> f(@a GroupCreateRequest paramGroupCreateRequest);
  
  @ga.b("group/{id}")
  public abstract ea.b<BaseResult> g(@s("id") long paramLong);
  
  @e
  @n("group/{id}/notice")
  public abstract ea.b<BaseResult> h(@s("id") long paramLong, @c("notice") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o4.b
 * JD-Core Version:    0.7.0.1
 */