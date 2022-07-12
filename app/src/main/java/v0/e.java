package v0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class e
{
  static final g0.e<String, Typeface> a = new g0.e(16);
  private static final ExecutorService b = g.a("fonts-androidx", 10, 10000);
  static final Object c = new Object();
  static final g0.g<String, ArrayList<x0.a<e>>> d = new g0.g();
  
  private static String a(d paramd, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramd.d());
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"WrongConstant"})
  private static int b(f.a parama)
  {
    int i = parama.c();
    int j = 1;
    if (i != 0)
    {
      if (parama.c() != 1) {
        return -3;
      }
      return -2;
    }
    parama = parama.b();
    if (parama != null)
    {
      if (parama.length == 0) {
        return 1;
      }
      int m = parama.length;
      int k = 0;
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        j = parama[i].b();
        if (j != 0)
        {
          if (j < 0) {
            return -3;
          }
          return j;
        }
        i += 1;
      }
    }
    return j;
  }
  
  static e c(String paramString, Context paramContext, d paramd, int paramInt)
  {
    g0.e locale = a;
    Typeface localTypeface = (Typeface)locale.c(paramString);
    if (localTypeface != null) {
      return new e(localTypeface);
    }
    try
    {
      paramd = c.d(paramContext, paramd, null);
      int i = b(paramd);
      if (i != 0) {
        return new e(i);
      }
      paramContext = q0.e.b(paramContext, null, paramd.b(), paramInt);
      if (paramContext != null)
      {
        locale.d(paramString, paramContext);
        return new e(paramContext);
      }
      return new e(-3);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label101:
      break label101;
    }
    return new e(-1);
  }
  
  static Typeface d(final Context paramContext, final d paramd, final int paramInt, Executor paramExecutor, a arg4)
  {
    String str = a(paramd, paramInt);
    Object localObject = (Typeface)a.c(str);
    if (localObject != null)
    {
      ???.b(new e((Typeface)localObject));
      return localObject;
    }
    localObject = new b(???);
    synchronized (c)
    {
      g0.g localg = d;
      ArrayList localArrayList = (ArrayList)localg.get(str);
      if (localArrayList != null)
      {
        localArrayList.add(localObject);
        return null;
      }
      localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localg.put(str, localArrayList);
      paramd = new c(str, paramContext, paramd, paramInt);
      paramContext = paramExecutor;
      if (paramExecutor == null) {
        paramContext = b;
      }
      g.b(paramContext, paramd, new d(str));
      return null;
    }
  }
  
  static Typeface e(final Context paramContext, final d paramd, a parama, final int paramInt1, int paramInt2)
  {
    String str = a(paramd, paramInt1);
    Typeface localTypeface = (Typeface)a.c(str);
    if (localTypeface != null)
    {
      parama.b(new e(localTypeface));
      return localTypeface;
    }
    if (paramInt2 == -1)
    {
      paramContext = c(str, paramContext, paramd, paramInt1);
      parama.b(paramContext);
      return paramContext.a;
    }
    paramContext = new a(str, paramContext, paramd, paramInt1);
    try
    {
      paramContext = (e)g.c(b, paramContext, paramInt2);
      parama.b(paramContext);
      paramContext = paramContext.a;
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      label104:
      break label104;
    }
    parama.b(new e(-3));
    return null;
  }
  
  class a
    implements Callable<e.e>
  {
    a(Context paramContext, d paramd, int paramInt) {}
    
    public e.e a()
    {
      return e.c(e.this, paramContext, paramd, paramInt1);
    }
  }
  
  class b
    implements x0.a<e.e>
  {
    b() {}
    
    public void b(e.e parame)
    {
      e.e locale = parame;
      if (parame == null) {
        locale = new e.e(-3);
      }
      e.this.b(locale);
    }
  }
  
  class c
    implements Callable<e.e>
  {
    c(Context paramContext, d paramd, int paramInt) {}
    
    public e.e a()
    {
      try
      {
        e.e locale = e.c(e.this, paramContext, paramd, paramInt);
        return locale;
      }
      finally
      {
        label22:
        break label22;
      }
      return new e.e(-3);
    }
  }
  
  class d
    implements x0.a<e.e>
  {
    d() {}
    
    public void b(e.e parame)
    {
      synchronized (e.c)
      {
        g0.g localg = e.d;
        ArrayList localArrayList = (ArrayList)localg.get(e.this);
        if (localArrayList == null) {
          return;
        }
        localg.remove(e.this);
        int i = 0;
        while (i < localArrayList.size())
        {
          ((x0.a)localArrayList.get(i)).a(parame);
          i += 1;
        }
        return;
      }
    }
  }
  
  static final class e
  {
    final Typeface a;
    final int b;
    
    e(int paramInt)
    {
      this.a = null;
      this.b = paramInt;
    }
    
    @SuppressLint({"WrongConstant"})
    e(Typeface paramTypeface)
    {
      this.a = paramTypeface;
      this.b = 0;
    }
    
    @SuppressLint({"WrongConstant"})
    boolean a()
    {
      return this.b == 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.e
 * JD-Core Version:    0.7.0.1
 */