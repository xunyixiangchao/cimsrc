package f6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.moment.api.response.MomentListResult;
import com.farsunset.hoxin.moment.api.response.MomentResult;
import com.farsunset.hoxin.moment.entity.Moment;
import ga.a;
import ga.f;
import ga.n;
import ga.o;
import ga.s;

public abstract interface b
{
  @f("moment/{id}")
  public abstract ea.b<MomentResult> a(@s("id") long paramLong);
  
  @ga.b("moment/{id}")
  public abstract ea.b<BaseResult> b(@s("id") long paramLong);
  
  @o("moment")
  public abstract ea.b<LongResult> f(@a Moment paramMoment);
  
  @o("moment/rule/{targetId}/{type}")
  public abstract ea.b<BaseResult> g(@s("targetId") long paramLong, @s("type") byte paramByte);
  
  @f("moment/gallery/{uid}")
  public abstract ea.b<MomentListResult> h(@s("uid") long paramLong);
  
  @f("moment/list/me/{currentPage}")
  public abstract ea.b<MomentListResult> i(@s("currentPage") int paramInt);
  
  @f("moment/list/other/{friendId}/{currentPage}")
  public abstract ea.b<MomentListResult> j(@s("friendId") long paramLong, @s("currentPage") int paramInt);
  
  @ga.b("moment/rule/{targetId}/{type}")
  public abstract ea.b<BaseResult> k(@s("targetId") long paramLong, @s("type") byte paramByte);
  
  @f("moment/timeline/{currentPage}")
  public abstract ea.b<MomentListResult> l(@s("currentPage") int paramInt);
  
  @n("moment/wallpaper")
  public abstract ea.b<BaseResult> m();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f6.b
 * JD-Core Version:    0.7.0.1
 */