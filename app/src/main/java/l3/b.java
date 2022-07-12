package l3;

import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import ea.t;
import ea.u;
import ea.u.b;
import u3.l;
import u3.m0;

public class b
{
  public static final ea.d<BaseResult> a = new b();
  
  public static <T> T a(Class<T> paramClass)
  {
    v7.g localg = new v7.g().a(new a());
    return new u.b().b("http://api.hoxin.farsunset.com/").f(g.c()).a(fa.a.g(localg.c())).d().b(paramClass);
  }
  
  class a
    implements v7.b
  {
    public boolean a(Class<?> paramClass)
    {
      return false;
    }
    
    public boolean b(v7.c paramc)
    {
      paramc = (w7.a)paramc.a(w7.a.class);
      return (paramc != null) && (!paramc.serialize());
    }
  }
  
  class b
    implements ea.d<BaseResult>
  {
    public void a(ea.b paramb, Throwable paramThrowable) {}
    
    public void c(ea.b<BaseResult> paramb, t<BaseResult> paramt)
    {
      if (401 == paramt.b())
      {
        i3.e.t();
        h.w(HoxinApplication.h());
        HoxinApplication.h().r();
        return;
      }
      if ((!paramt.d()) && (paramt.a() != null)) {
        l.A0(HoxinApplication.h(), ((BaseResult)paramt.a()).message);
      }
    }
  }
  
  public static class c<T extends BaseResult>
    implements ea.d<T>
  {
    protected s3.e<T> a;
    
    public c(s3.e<T> parame)
    {
      this.a = parame;
    }
    
    public void a(ea.b<T> paramb, Throwable paramThrowable)
    {
      g(paramThrowable);
    }
    
    public void c(ea.b<T> paramb, t<T> paramt)
    {
      if (401 == paramt.b())
      {
        i3.e.t();
        h.w(HoxinApplication.h());
        HoxinApplication.h().r();
        return;
      }
      if (paramt.d())
      {
        h((BaseResult)paramt.a());
        return;
      }
      if (paramt.a() != null) {
        l.A0(HoxinApplication.h(), ((BaseResult)paramt.a()).message);
      }
      a(paramb, new IllegalAccessException());
    }
    
    public void g(Throwable paramThrowable)
    {
      m0.b(new d(this, paramThrowable));
    }
    
    public void h(T paramT)
    {
      m0.b(new c(this, paramT));
    }
  }
  
  public static class d<T extends BaseResult>
    extends b.c<T>
  {
    public d(s3.e<T> parame)
    {
      super();
    }
    
    public void g(Throwable paramThrowable)
    {
      this.a.onHttpException((Exception)paramThrowable);
    }
    
    public void h(T paramT)
    {
      this.a.onHttpResponse(paramT);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l3.b
 * JD-Core Version:    0.7.0.1
 */