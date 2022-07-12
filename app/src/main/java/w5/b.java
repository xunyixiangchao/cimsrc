package w5;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.micro.api.response.MicroServerListResult;
import com.farsunset.hoxin.micro.api.response.MicroServerMenuListResult;
import com.farsunset.hoxin.micro.api.response.MicroServerResponse;
import com.farsunset.hoxin.micro.api.response.MicroServerResult;
import com.farsunset.hoxin.micro.model.MenuEvent;
import ga.a;
import ga.f;
import ga.o;
import ga.s;
import ga.t;
import ga.y;

public abstract interface b
{
  @f("micro/server/{id}")
  public abstract ea.b<MicroServerResult> a(@s("id") long paramLong);
  
  @o
  public abstract ea.b<MicroServerResponse> b(@y String paramString, @a MenuEvent paramMenuEvent);
  
  @o("micro/server/subscribe/{id}")
  public abstract ea.b<BaseResult> c(@s("id") long paramLong);
  
  @f("micro/server/search/{index}/{page}")
  public abstract ea.b<MicroServerListResult> d(@s("index") long paramLong1, @s("page") long paramLong2, @t("name") String paramString);
  
  @f("micro/server/menu/list/{id}")
  public abstract ea.b<MicroServerMenuListResult> e(@s("id") long paramLong);
  
  @ga.b("micro/server/subscribe/{id}")
  public abstract ea.b<BaseResult> f(@s("id") long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w5.b
 * JD-Core Version:    0.7.0.1
 */