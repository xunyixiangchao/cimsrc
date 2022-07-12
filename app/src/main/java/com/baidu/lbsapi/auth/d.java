package com.baidu.lbsapi.auth;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("postWithHttps start Thread id = ");
    ((StringBuilder)localObject).append(String.valueOf(Thread.currentThread().getId()));
    a.a(((StringBuilder)localObject).toString());
    localObject = new g(c.a(this.a)).a(c.b(this.a));
    c.a(this.a, (String)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */