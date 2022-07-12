package m3;

import com.farsunset.hoxin.friend.api.response.FriendListResult;
import com.farsunset.hoxin.friend.api.response.FriendResult;
import ea.b;
import ga.f;
import ga.s;
import ga.t;

public abstract interface c
{
  @f("user/{id}")
  public abstract b<FriendResult> a(@s("id") long paramLong);
  
  @f("user/list")
  public abstract b<FriendListResult> b(@t("id") Long[] paramArrayOfLong);
  
  @f("user/find/{telephone}")
  public abstract b<FriendResult> c(@s("telephone") String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m3.c
 * JD-Core Version:    0.7.0.1
 */