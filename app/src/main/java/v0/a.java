package v0;

import android.graphics.Typeface;
import android.os.Handler;

class a
{
  private final f.c a;
  private final Handler b;
  
  a(f.c paramc, Handler paramHandler)
  {
    this.a = paramc;
    this.b = paramHandler;
  }
  
  private void a(final int paramInt)
  {
    final f.c localc = this.a;
    this.b.post(new b(localc, paramInt));
  }
  
  private void c(final Typeface paramTypeface)
  {
    final f.c localc = this.a;
    this.b.post(new a(localc, paramTypeface));
  }
  
  void b(e.e parame)
  {
    if (parame.a())
    {
      c(parame.a);
      return;
    }
    a(parame.b);
  }
  
  class a
    implements Runnable
  {
    a(f.c paramc, Typeface paramTypeface) {}
    
    public void run()
    {
      localc.b(paramTypeface);
    }
  }
  
  class b
    implements Runnable
  {
    b(f.c paramc, int paramInt) {}
    
    public void run()
    {
      localc.a(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.a
 * JD-Core Version:    0.7.0.1
 */