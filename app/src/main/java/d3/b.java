package d3;

import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.account.api.request.RegisterRequest;
import com.farsunset.hoxin.account.api.request.ResetPasswordRequest;
import com.farsunset.hoxin.account.api.response.BaseDataResult;
import com.farsunset.hoxin.account.api.response.LoginResult;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import l3.b.c;
import l3.b.d;
import s3.h0;
import u3.k0;

public class b
  extends l3.b
{
  public static void b(String paramString, s3.e<LongResult> parame)
  {
    ((e3.b)l3.b.a(e3.b.class)).b(paramString).B(new b.c(parame));
  }
  
  public static void c()
  {
    if (i3.e.r(i3.e.o().longValue()))
    {
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
      return;
    }
    ((e3.b)l3.b.a(e3.b.class)).a().B(new b.d(new a()));
  }
  
  public static void d(String paramString1, String paramString2, s3.e<LoginResult> parame)
  {
    ((e3.b)l3.b.a(e3.b.class)).f(paramString1, k0.a(paramString2)).B(new b.c(parame));
  }
  
  public static void e()
  {
    ((e3.b)l3.b.a(e3.b.class)).c().B(l3.b.a);
  }
  
  public static void f(RegisterRequest paramRegisterRequest, s3.e<LoginResult> parame)
  {
    ((e3.b)l3.b.a(e3.b.class)).e(paramRegisterRequest).B(new b.c(parame));
  }
  
  public static void g(ResetPasswordRequest paramResetPasswordRequest, s3.e<BaseResult> parame)
  {
    ((e3.b)l3.b.a(e3.b.class)).d(paramResetPasswordRequest).B(new b.c(parame));
  }
  
  class a
    extends h0<BaseDataResult>
  {
    public void a(BaseDataResult paramBaseDataResult)
    {
      p6.c.a(paramBaseDataResult.organization);
      p4.a.b(paramBaseDataResult.groupList);
      x5.a.b(paramBaseDataResult.microServerList);
      i4.a.b(paramBaseDataResult.friendList, (byte)0);
      i4.a.b(paramBaseDataResult.contactList, (byte)1);
      i4.a.b(paramBaseDataResult.bothList, (byte)2);
      g6.c.e(paramBaseDataResult.momentRuleList);
      a4.a.b(paramBaseDataResult.emoticonList);
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
      i3.e.u(i3.e.o().longValue());
      f5.a.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d3.b
 * JD-Core Version:    0.7.0.1
 */