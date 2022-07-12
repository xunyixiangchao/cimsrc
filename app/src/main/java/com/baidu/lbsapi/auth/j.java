package com.baidu.lbsapi.auth;

import java.util.Hashtable;

class j
  implements Runnable
{
  j(LBSAuthManager paramLBSAuthManager, int paramInt, boolean paramBoolean, String paramString1, String paramString2, Hashtable paramHashtable) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("status = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("; forced = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("checkAK = ");
    ((StringBuilder)localObject).append(LBSAuthManager.a(this.f, this.c));
    a.a(((StringBuilder)localObject).toString());
    int i = this.a;
    if ((i != 601) && (!this.b) && (i != -1) && (!LBSAuthManager.a(this.f, this.c)))
    {
      if (602 == this.a)
      {
        a.a("authenticate wait ");
        if (LBSAuthManager.d() != null) {
          LBSAuthManager.d().b();
        }
      }
      else
      {
        a.a("authenticate else");
      }
      LBSAuthManager.a(this.f, null, this.c);
      return;
    }
    a.a("authenticate sendAuthRequest");
    if (LBSAuthManager.b() != null) {
      localObject = LBSAuthManager.b();
    } else {
      localObject = b.b(LBSAuthManager.c());
    }
    if ((localObject != null) && (localObject.length > 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("authStrings.length:");
      localStringBuilder.append(localObject.length);
      a.a(localStringBuilder.toString());
      a.a("more sha1 auth");
      LBSAuthManager.a(this.f, this.b, this.d, this.e, (String[])localObject, this.c);
      return;
    }
    LBSAuthManager.a(this.f, this.b, this.d, this.e, this.c);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */