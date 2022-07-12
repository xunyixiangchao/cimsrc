package e3;

import com.farsunset.hoxin.common.api.response.BaseResult;
import ea.b;
import ga.c;
import ga.e;
import ga.n;

public abstract interface a
{
  @e
  @n("user/password")
  public abstract b<BaseResult> a(@c("oldPassword") String paramString1, @c("newPassword") String paramString2);
  
  @e
  @n("user/name")
  public abstract b<BaseResult> b(@c("name") String paramString);
  
  @n("user/logo")
  public abstract b<BaseResult> c();
  
  @e
  @n("user/motto")
  public abstract b<BaseResult> d(@c("motto") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e3.a
 * JD-Core Version:    0.7.0.1
 */