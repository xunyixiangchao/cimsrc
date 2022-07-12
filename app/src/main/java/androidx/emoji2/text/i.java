package androidx.emoji2.text;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import v0.d;
import v0.f.a;
import v0.f.b;
import x0.h;

public class i
  extends d.c
{
  private static final a j = new a();
  
  public i(Context paramContext, d paramd)
  {
    super(new b(paramContext, paramd, j));
  }
  
  public i c(Executor paramExecutor)
  {
    ((b)a()).f(paramExecutor);
    return this;
  }
  
  public static class a
  {
    public Typeface a(Context paramContext, f.b paramb)
    {
      return v0.f.a(paramContext, null, new f.b[] { paramb });
    }
    
    public f.a b(Context paramContext, d paramd)
    {
      return v0.f.b(paramContext, null, paramd);
    }
    
    public void c(Context paramContext, ContentObserver paramContentObserver)
    {
      paramContext.getContentResolver().unregisterContentObserver(paramContentObserver);
    }
  }
  
  private static class b
    implements d.g
  {
    private final Context a;
    private final d b;
    private final i.a c;
    private final Object d = new Object();
    private Handler e;
    private Executor f;
    private ThreadPoolExecutor g;
    d.h h;
    private ContentObserver i;
    private Runnable j;
    
    b(Context paramContext, d paramd, i.a parama)
    {
      h.h(paramContext, "Context cannot be null");
      h.h(paramd, "FontRequest cannot be null");
      this.a = paramContext.getApplicationContext();
      this.b = paramd;
      this.c = parama;
    }
    
    private void b()
    {
      synchronized (this.d)
      {
        this.h = null;
        Object localObject2 = this.i;
        if (localObject2 != null)
        {
          this.c.c(this.a, (ContentObserver)localObject2);
          this.i = null;
        }
        localObject2 = this.e;
        if (localObject2 != null) {
          ((Handler)localObject2).removeCallbacks(this.j);
        }
        this.e = null;
        localObject2 = this.g;
        if (localObject2 != null) {
          ((ThreadPoolExecutor)localObject2).shutdown();
        }
        this.f = null;
        this.g = null;
        return;
      }
    }
    
    private f.b e()
    {
      try
      {
        Object localObject = this.c.b(this.a, this.b);
        if (((f.a)localObject).c() == 0)
        {
          localObject = ((f.a)localObject).b();
          if ((localObject != null) && (localObject.length != 0)) {
            return localObject[0];
          }
          throw new RuntimeException("fetchFonts failed (empty result)");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchFonts failed (");
        localStringBuilder.append(((f.a)localObject).c());
        localStringBuilder.append(")");
        throw new RuntimeException(localStringBuilder.toString());
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        throw new RuntimeException("provider not found", localNameNotFoundException);
      }
    }
    
    public void a(d.h paramh)
    {
      h.h(paramh, "LoaderCallback cannot be null");
      synchronized (this.d)
      {
        this.h = paramh;
        d();
        return;
      }
    }
    
    void c()
    {
      synchronized (this.d)
      {
        if (this.h == null) {
          return;
        }
        try
        {
          ??? = e();
          int k = ((f.b)???).b();
          if (k == 2) {
            for (;;)
            {
              synchronized (this.d) {}
              localb = finally;
            }
          }
          if (k == 0) {
            try
            {
              u0.f.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
              ??? = this.c.a(this.a, localb);
              ??? = q0.l.f(this.a, null, localb.d());
              if ((??? != null) && (??? != null))
              {
                ??? = l.b((Typeface)???, (ByteBuffer)???);
                u0.f.b();
                synchronized (this.d)
                {
                  localh = this.h;
                  if (localh != null) {
                    localh.b((l)???);
                  }
                  b();
                  return;
                }
              }
              throw new RuntimeException("Unable to open file.");
            }
            finally
            {
              u0.f.b();
            }
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("fetchFonts result is not OK. (");
          ((StringBuilder)???).append(k);
          ((StringBuilder)???).append(")");
          throw new RuntimeException(((StringBuilder)???).toString());
        }
        finally
        {
          synchronized (this.d)
          {
            d.h localh = this.h;
            if (localh != null) {
              localh.a(localThrowable);
            }
            b();
            return;
          }
        }
      }
    }
    
    void d()
    {
      synchronized (this.d)
      {
        if (this.h == null) {
          return;
        }
        if (this.f == null)
        {
          ThreadPoolExecutor localThreadPoolExecutor = b.b("emojiCompat");
          this.g = localThreadPoolExecutor;
          this.f = localThreadPoolExecutor;
        }
        this.f.execute(new j(this));
        return;
      }
    }
    
    public void f(Executor paramExecutor)
    {
      synchronized (this.d)
      {
        this.f = paramExecutor;
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.i
 * JD-Core Version:    0.7.0.1
 */