package h4;

import com.farsunset.hoxin.common.api.response.BaseResult;
import ga.c;
import ga.e;
import ga.o;
import ga.s;

public abstract interface a
{
  @ga.b("friend/{id}")
  public abstract ea.b<BaseResult> a(@s("id") Long paramLong);
  
  @e
  @o("friend/apply/{id}")
  public abstract ea.b<BaseResult> b(@s("id") Long paramLong, @c("message") String paramString);
  
  @o("friend/agree/{id}")
  public abstract ea.b<BaseResult> c(@s("id") Long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h4.a
 * JD-Core Version:    0.7.0.1
 */