package e3;

import com.farsunset.hoxin.account.api.request.RegisterRequest;
import com.farsunset.hoxin.account.api.request.ResetPasswordRequest;
import com.farsunset.hoxin.account.api.response.BaseDataResult;
import com.farsunset.hoxin.account.api.response.LoginResult;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import ga.a;
import ga.c;
import ga.e;
import ga.f;
import ga.o;
import ga.s;

public abstract interface b
{
  @f("base/data")
  public abstract ea.b<BaseDataResult> a();
  
  @f("user/id/{telephone}")
  public abstract ea.b<LongResult> b(@s("telephone") String paramString);
  
  @f("user/logout")
  public abstract ea.b<BaseResult> c();
  
  @o("user/forgot")
  public abstract ea.b<BaseResult> d(@a ResetPasswordRequest paramResetPasswordRequest);
  
  @o("user/register")
  public abstract ea.b<LoginResult> e(@a RegisterRequest paramRegisterRequest);
  
  @e
  @o("user/login")
  public abstract ea.b<LoginResult> f(@c("telephone") String paramString1, @c("password") String paramString2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e3.b
 * JD-Core Version:    0.7.0.1
 */