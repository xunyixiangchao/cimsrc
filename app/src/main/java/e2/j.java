package e2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class j
  implements d
{
  private static final Bitmap.Config k = Bitmap.Config.ARGB_8888;
  private final k a;
  private final Set<Bitmap.Config> b;
  private final long c;
  private final a d;
  private long e;
  private long f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public j(long paramLong)
  {
    this(paramLong, l(), k());
  }
  
  j(long paramLong, k paramk, Set<Bitmap.Config> paramSet)
  {
    this.c = paramLong;
    this.e = paramLong;
    this.a = paramk;
    this.b = paramSet;
    this.d = new b();
  }
  
  @TargetApi(26)
  private static void f(Bitmap.Config paramConfig)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    if (paramConfig != Bitmap.Config.HARDWARE) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create a mutable Bitmap with config: ");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static Bitmap g(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (paramConfig == null) {
      paramConfig = k;
    }
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  private void h()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      i();
    }
  }
  
  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hits=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", misses=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", puts=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", evictions=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", currentSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", maxSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\nStrategy=");
    localStringBuilder.append(this.a);
    Log.v("LruBitmapPool", localStringBuilder.toString());
  }
  
  private void j()
  {
    q(this.e);
  }
  
  @TargetApi(26)
  private static Set<Bitmap.Config> k()
  {
    HashSet localHashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
    int m = Build.VERSION.SDK_INT;
    localHashSet.add(null);
    if (m >= 26) {
      localHashSet.remove(Bitmap.Config.HARDWARE);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  private static k l()
  {
    return new m();
  }
  
  private Bitmap m(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      f(paramConfig);
      Object localObject2 = this.a;
      if (paramConfig != null) {
        localObject1 = paramConfig;
      } else {
        localObject1 = k;
      }
      Object localObject1 = ((k)localObject2).c(paramInt1, paramInt2, (Bitmap.Config)localObject1);
      if (localObject1 == null)
      {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Missing bitmap=");
          ((StringBuilder)localObject2).append(this.a.a(paramInt1, paramInt2, paramConfig));
          Log.d("LruBitmapPool", ((StringBuilder)localObject2).toString());
        }
        this.h += 1;
      }
      else
      {
        this.g += 1;
        this.f -= this.a.b((Bitmap)localObject1);
        this.d.a((Bitmap)localObject1);
        p((Bitmap)localObject1);
      }
      if (Log.isLoggable("LruBitmapPool", 2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Get bitmap=");
        ((StringBuilder)localObject2).append(this.a.a(paramInt1, paramInt2, paramConfig));
        Log.v("LruBitmapPool", ((StringBuilder)localObject2).toString());
      }
      h();
      return localObject1;
    }
    finally {}
  }
  
  @TargetApi(19)
  private static void o(Bitmap paramBitmap)
  {
    paramBitmap.setPremultiplied(true);
  }
  
  private static void p(Bitmap paramBitmap)
  {
    paramBitmap.setHasAlpha(true);
    o(paramBitmap);
  }
  
  private void q(long paramLong)
  {
    try
    {
      while (this.f > paramLong)
      {
        Bitmap localBitmap = this.a.e();
        if (localBitmap == null)
        {
          if (Log.isLoggable("LruBitmapPool", 5))
          {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            i();
          }
          this.f = 0L;
          return;
        }
        this.d.a(localBitmap);
        this.f -= this.a.b(localBitmap);
        this.j += 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Evicting bitmap=");
          localStringBuilder.append(this.a.f(localBitmap));
          Log.d("LruBitmapPool", localStringBuilder.toString());
        }
        h();
        localBitmap.recycle();
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    q(0L);
  }
  
  @SuppressLint({"InlinedApi"})
  public void b(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimMemory, level=");
      localStringBuilder.append(paramInt);
      Log.d("LruBitmapPool", localStringBuilder.toString());
    }
    if ((paramInt < 40) && (paramInt < 20))
    {
      if ((paramInt >= 20) || (paramInt == 15)) {
        q(n() / 2L);
      }
    }
    else {
      a();
    }
  }
  
  public Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap = m(paramInt1, paramInt2, paramConfig);
    if (localBitmap != null)
    {
      localBitmap.eraseColor(0);
      return localBitmap;
    }
    return g(paramInt1, paramInt2, paramConfig);
  }
  
  public void d(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        StringBuilder localStringBuilder;
        if ((paramBitmap.isMutable()) && (this.a.b(paramBitmap) <= this.e) && (this.b.contains(paramBitmap.getConfig())))
        {
          int m = this.a.b(paramBitmap);
          this.a.d(paramBitmap);
          this.d.b(paramBitmap);
          this.i += 1;
          this.f += m;
          if (Log.isLoggable("LruBitmapPool", 2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Put bitmap in pool=");
            localStringBuilder.append(this.a.f(paramBitmap));
            Log.v("LruBitmapPool", localStringBuilder.toString());
          }
          h();
          j();
          return;
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Reject bitmap from pool, bitmap: ");
          localStringBuilder.append(this.a.f(paramBitmap));
          localStringBuilder.append(", is mutable: ");
          localStringBuilder.append(paramBitmap.isMutable());
          localStringBuilder.append(", is allowed config: ");
          localStringBuilder.append(this.b.contains(paramBitmap.getConfig()));
          Log.v("LruBitmapPool", localStringBuilder.toString());
        }
        paramBitmap.recycle();
        return;
      }
      throw new IllegalStateException("Cannot pool recycled bitmap");
    }
    finally
    {
      label293:
      break label293;
    }
    throw new NullPointerException("Bitmap must not be null");
    throw paramBitmap;
  }
  
  public Bitmap e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap2 = m(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = g(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap1;
  }
  
  public long n()
  {
    return this.e;
  }
  
  private static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
    
    public abstract void b(Bitmap paramBitmap);
  }
  
  private static final class b
    implements j.a
  {
    public void a(Bitmap paramBitmap) {}
    
    public void b(Bitmap paramBitmap) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.j
 * JD-Core Version:    0.7.0.1
 */