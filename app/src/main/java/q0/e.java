package q0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import p0.e.b;
import p0.e.d;
import p0.h.d;
import v0.f.b;
import v0.f.c;

public class e
{
  private static final k a;
  private static final g0.e<String, Typeface> b = new g0.e(16);
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i >= 29) {
      localObject = new j();
    }
    for (;;)
    {
      a = (k)localObject;
      break;
      if (i >= 28) {
        localObject = new i();
      } else if (i >= 26) {
        localObject = new h();
      } else if ((i >= 24) && (g.i())) {
        localObject = new g();
      } else {
        localObject = new f();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Typeface paramTypeface, int paramInt)
  {
    if (paramContext != null) {
      return Typeface.create(paramTypeface, paramInt);
    }
    throw new IllegalArgumentException("Context cannot be null");
  }
  
  public static Typeface b(Context paramContext, CancellationSignal paramCancellationSignal, f.b[] paramArrayOfb, int paramInt)
  {
    return a.b(paramContext, paramCancellationSignal, paramArrayOfb, paramInt);
  }
  
  public static Typeface c(Context paramContext, p0.e.a parama, Resources paramResources, int paramInt1, int paramInt2, h.d paramd, Handler paramHandler, boolean paramBoolean)
  {
    if ((parama instanceof e.d))
    {
      parama = (e.d)parama;
      Typeface localTypeface = g(parama.c());
      if (localTypeface != null)
      {
        if (paramd != null) {
          paramd.b(localTypeface, paramHandler);
        }
        return localTypeface;
      }
      boolean bool;
      if (paramBoolean ? parama.a() == 0 : paramd == null) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      if (paramBoolean) {
        i = parama.d();
      } else {
        i = -1;
      }
      paramHandler = h.d.c(paramHandler);
      paramd = new a(paramd);
      paramContext = v0.f.c(paramContext, parama.b(), paramInt2, bool, i, paramHandler, paramd);
    }
    else
    {
      parama = a.a(paramContext, (e.b)parama, paramResources, paramInt2);
      paramContext = parama;
      if (paramd != null) {
        if (parama != null)
        {
          paramd.b(parama, paramHandler);
          paramContext = parama;
        }
        else
        {
          paramd.a(-3, paramHandler);
          paramContext = parama;
        }
      }
    }
    if (paramContext != null) {
      b.d(e(paramResources, paramInt1, paramInt2), paramContext);
    }
    return paramContext;
  }
  
  public static Typeface d(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a.d(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = e(paramResources, paramInt1, paramInt2);
      b.d(paramResources, paramContext);
    }
    return paramContext;
  }
  
  private static String e(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static Typeface f(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)b.c(e(paramResources, paramInt1, paramInt2));
  }
  
  private static Typeface g(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return null;
      }
      paramString = Typeface.create(paramString, 0);
      Typeface localTypeface = Typeface.create(Typeface.DEFAULT, 0);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (!paramString.equals(localTypeface)) {
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
  }
  
  public static class a
    extends f.c
  {
    private h.d a;
    
    public a(h.d paramd)
    {
      this.a = paramd;
    }
    
    public void a(int paramInt)
    {
      h.d locald = this.a;
      if (locald != null) {
        locald.d(paramInt);
      }
    }
    
    public void b(Typeface paramTypeface)
    {
      h.d locald = this.a;
      if (locald != null) {
        locald.e(paramTypeface);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.e
 * JD-Core Version:    0.7.0.1
 */