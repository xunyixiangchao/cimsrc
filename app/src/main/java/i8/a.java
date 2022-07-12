package i8;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import c8.e;
import d8.i;
import d8.l;
import d8.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l8.c;

class a
  implements d, e, com.yanzhenjie.permission.bridge.a.a
{
  private static final l g = new s();
  private static final l h = new i();
  private c a;
  private String[] b;
  private c8.d<List<String>> c = new a();
  private c8.a<List<String>> d;
  private c8.a<List<String>> e;
  private String[] f;
  
  a(c paramc)
  {
    this.a = paramc;
  }
  
  private void l(List<String> paramList)
  {
    c8.a locala = this.e;
    if (locala != null) {
      locala.a(paramList);
    }
  }
  
  private void m()
  {
    if (this.d != null)
    {
      List localList = Arrays.asList(this.b);
      try
      {
        this.d.a(localList);
        return;
      }
      catch (Exception localException)
      {
        Log.e("AndPermission", "Please check the onGranted() method body for bugs.", localException);
        c8.a locala = this.e;
        if (locala != null) {
          locala.a(localList);
        }
      }
    }
  }
  
  private static List<String> n(l paraml, c paramc, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(1);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!paraml.a(paramc.c(), new String[] { str })) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<String> o(c paramc, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(1);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (paramc.g(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public d a(String... paramVarArgs)
  {
    this.b = paramVarArgs;
    return this;
  }
  
  public void b()
  {
    new b().execute(new Void[0]);
  }
  
  public d c(c8.a<List<String>> parama)
  {
    this.e = parama;
    return this;
  }
  
  public d d(c8.a<List<String>> parama)
  {
    this.d = parama;
    return this;
  }
  
  public void g()
  {
    com.yanzhenjie.permission.bridge.a locala = new com.yanzhenjie.permission.bridge.a(this.a);
    locala.g(2);
    locala.f(this.f);
    locala.e(this);
    com.yanzhenjie.permission.bridge.d.b().a(locala);
  }
  
  public void start()
  {
    Object localObject = n(g, this.a, this.b);
    localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    this.f = ((String[])localObject);
    if (localObject.length > 0)
    {
      localObject = o(this.a, (String[])localObject);
      if (((List)localObject).size() > 0)
      {
        this.c.a(this.a.c(), localObject, this);
        return;
      }
      g();
      return;
    }
    b();
  }
  
  class a
    implements c8.d<List<String>>
  {
    a() {}
    
    public void b(Context paramContext, List<String> paramList, e parame)
    {
      parame.g();
    }
  }
  
  class b
    extends AsyncTask<Void, Void, List<String>>
  {
    b() {}
    
    protected List<String> a(Void... paramVarArgs)
    {
      return a.i(a.e(), a.f(a.this), a.h(a.this));
    }
    
    protected void b(List<String> paramList)
    {
      if (paramList.isEmpty())
      {
        a.j(a.this);
        return;
      }
      a.k(a.this, paramList);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i8.a
 * JD-Core Version:    0.7.0.1
 */