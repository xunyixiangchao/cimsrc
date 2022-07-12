package o4;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.group.api.request.DeleteMemberRequest;
import ga.o;
import ga.s;

public abstract interface a
{
  @ga.b("group/member/quit/{id}")
  public abstract ea.b<BaseResult> a(@s("id") long paramLong);
  
  @o("group/member/delete")
  public abstract ea.b<BaseResult> b(@ga.a DeleteMemberRequest paramDeleteMemberRequest);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o4.a
 * JD-Core Version:    0.7.0.1
 */