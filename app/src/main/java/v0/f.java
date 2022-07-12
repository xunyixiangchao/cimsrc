package v0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import x0.h;

public class f
{
  public static Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b[] paramArrayOfb)
  {
    return q0.e.b(paramContext, paramCancellationSignal, paramArrayOfb, 0);
  }
  
  public static a b(Context paramContext, CancellationSignal paramCancellationSignal, d paramd)
  {
    return c.d(paramContext, paramd, paramCancellationSignal);
  }
  
  public static Typeface c(Context paramContext, d paramd, int paramInt1, boolean paramBoolean, int paramInt2, Handler paramHandler, c paramc)
  {
    paramHandler = new a(paramc, paramHandler);
    if (paramBoolean) {
      return e.e(paramContext, paramd, paramHandler, paramInt1, paramInt2);
    }
    return e.d(paramContext, paramd, paramInt1, null, paramHandler);
  }
  
  public static class a
  {
    private final int a;
    private final f.b[] b;
    
    @Deprecated
    public a(int paramInt, f.b[] paramArrayOfb)
    {
      this.a = paramInt;
      this.b = paramArrayOfb;
    }
    
    static a a(int paramInt, f.b[] paramArrayOfb)
    {
      return new a(paramInt, paramArrayOfb);
    }
    
    public f.b[] b()
    {
      return this.b;
    }
    
    public int c()
    {
      return this.a;
    }
  }
  
  public static class b
  {
    private final Uri a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;
    
    @Deprecated
    public b(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.a = ((Uri)h.g(paramUri));
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramBoolean;
      this.e = paramInt3;
    }
    
    static b a(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return new b(paramUri, paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public int b()
    {
      return this.e;
    }
    
    public int c()
    {
      return this.b;
    }
    
    public Uri d()
    {
      return this.a;
    }
    
    public int e()
    {
      return this.c;
    }
    
    public boolean f()
    {
      return this.d;
    }
  }
  
  public static class c
  {
    public void a(int paramInt)
    {
      throw null;
    }
    
    public void b(Typeface paramTypeface)
    {
      throw null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.f
 * JD-Core Version:    0.7.0.1
 */