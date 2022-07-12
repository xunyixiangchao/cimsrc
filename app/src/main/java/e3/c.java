package e3;

import com.farsunset.hoxin.common.api.response.StringResult;
import ea.b;
import ga.f;
import ga.s;

public abstract interface c
{
  @f("code/forgot/{telephone}")
  public abstract b<StringResult> a(@s("telephone") String paramString);
  
  @f("code/register/{telephone}")
  public abstract b<StringResult> b(@s("telephone") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e3.c
 * JD-Core Version:    0.7.0.1
 */