package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.a;
import com.bumptech.glide.manager.h.b;
import h2.a.b;
import h2.a.c;
import h2.b.d;
import h2.e.c;
import h2.f.b;
import h2.f.e;
import h2.s.a;
import h2.s.b;
import h2.s.c;
import h2.s.d;
import h2.u.a;
import h2.u.b;
import h2.u.c;
import h2.v.a;
import h2.w.a;
import h2.w.b;
import h2.w.d;
import h2.x.a;
import i2.e.a;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k2.a0;
import k2.b0;
import k2.m;
import k2.p;
import k2.v;
import k2.x;
import k2.y;

public class c
  implements ComponentCallbacks2
{
  private static volatile c l;
  private static volatile boolean m;
  private final d2.k a;
  private final e2.d b;
  private final f2.i c;
  private final e d;
  private final i e;
  private final e2.b f;
  private final com.bumptech.glide.manager.h g;
  private final q2.b h;
  private final List<k> i = new ArrayList();
  private final a j;
  private g k = g.c;
  
  c(Context paramContext, d2.k paramk, f2.i parami, e2.d paramd, e2.b paramb, com.bumptech.glide.manager.h paramh, q2.b paramb1, int paramInt, a parama, Map<Class<?>, l<?, ?>> paramMap, List<t2.h<Object>> paramList, f paramf)
  {
    this.a = paramk;
    this.b = paramd;
    this.f = paramb;
    this.c = parami;
    this.g = paramh;
    this.h = paramb1;
    this.j = parama;
    paramb1 = paramContext.getResources();
    i locali = new i();
    this.e = locali;
    locali.o(new k2.k());
    int n = Build.VERSION.SDK_INT;
    if (n >= 27) {
      locali.o(new p());
    }
    List localList = locali.g();
    o2.a locala = new o2.a(paramContext, localList, paramd, paramb);
    b2.j localj = b0.h(paramd);
    m localm = new m(locali.g(), paramb1.getDisplayMetrics(), paramd, paramb);
    if ((n >= 28) && (paramf.a(d.c.class)))
    {
      paramh = new k2.t();
      parami = new k2.h();
    }
    else
    {
      parami = new k2.g(localm);
      paramh = new y(localm, paramb);
    }
    if ((n >= 28) && (paramf.a(d.b.class)))
    {
      locali.e("Animation", InputStream.class, Drawable.class, m2.a.f(localList, paramb));
      locali.e("Animation", ByteBuffer.class, Drawable.class, m2.a.a(localList, paramb));
    }
    m2.e locale = new m2.e(paramContext);
    s.c localc = new s.c(paramb1);
    s.d locald = new s.d(paramb1);
    s.b localb = new s.b(paramb1);
    s.a locala1 = new s.a(paramb1);
    k2.c localc1 = new k2.c(paramb);
    p2.a locala2 = new p2.a();
    p2.d locald1 = new p2.d();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    locali.a(ByteBuffer.class, new h2.c()).a(InputStream.class, new h2.t(paramb)).e("Bitmap", ByteBuffer.class, Bitmap.class, parami).e("Bitmap", InputStream.class, Bitmap.class, paramh);
    if (ParcelFileDescriptorRewinder.c()) {
      locali.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new v(localm));
    }
    locali.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, localj).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, b0.c(paramd)).d(Bitmap.class, Bitmap.class, v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new a0()).b(Bitmap.class, localc1).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new k2.a(paramb1, parami)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new k2.a(paramb1, paramh)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new k2.a(paramb1, localj)).b(BitmapDrawable.class, new k2.b(paramd, localc1)).e("Animation", InputStream.class, o2.c.class, new o2.j(localList, locala, paramb)).e("Animation", ByteBuffer.class, o2.c.class, locala).b(o2.c.class, new o2.d()).d(z1.a.class, z1.a.class, v.a.a()).e("Bitmap", z1.a.class, Bitmap.class, new o2.h(paramd)).c(Uri.class, Drawable.class, locale).c(Uri.class, Bitmap.class, new x(locale, paramd)).p(new l2.a.a()).d(File.class, ByteBuffer.class, new h2.d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new n2.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.a()).p(new com.bumptech.glide.load.data.k.a(paramb));
    if (ParcelFileDescriptorRewinder.c()) {
      locali.p(new ParcelFileDescriptorRewinder.a());
    }
    parami = Integer.TYPE;
    locali.d(parami, InputStream.class, localc).d(parami, ParcelFileDescriptor.class, localb).d(Integer.class, InputStream.class, localc).d(Integer.class, ParcelFileDescriptor.class, localb).d(Integer.class, Uri.class, locald).d(parami, AssetFileDescriptor.class, locala1).d(Integer.class, AssetFileDescriptor.class, locala1).d(parami, Uri.class, locald).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(paramContext.getAssets())).d(Uri.class, AssetFileDescriptor.class, new a.b(paramContext.getAssets())).d(Uri.class, InputStream.class, new i2.b.a(paramContext)).d(Uri.class, InputStream.class, new i2.c.a(paramContext));
    if (n >= 29)
    {
      locali.d(Uri.class, InputStream.class, new i2.d.c(paramContext));
      locali.d(Uri.class, ParcelFileDescriptor.class, new i2.d.b(paramContext));
    }
    locali.d(Uri.class, InputStream.class, new w.d(localContentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(localContentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(localContentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new e.a()).d(Uri.class, File.class, new h2.k.a(paramContext)).d(h2.g.class, InputStream.class, new i2.a.a()).d([B.class, ByteBuffer.class, new h2.b.a()).d([B.class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.a()).d(Drawable.class, Drawable.class, v.a.a()).c(Drawable.class, Drawable.class, new m2.f()).q(Bitmap.class, BitmapDrawable.class, new p2.b(paramb1)).q(Bitmap.class, [B.class, locala2).q(Drawable.class, [B.class, new p2.c(paramd, locala2, locald1)).q(o2.c.class, [B.class, locald1);
    parami = b0.d(paramd);
    locali.c(ByteBuffer.class, Bitmap.class, parami);
    locali.c(ByteBuffer.class, BitmapDrawable.class, new k2.a(paramb1, parami));
    this.d = new e(paramContext, paramb, locali, new u2.f(), parama, paramMap, paramList, paramk, paramf, paramInt);
  }
  
  private static void a(Context paramContext, GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    if (!m)
    {
      m = true;
      m(paramContext, paramGeneratedAppGlideModule);
      m = false;
      return;
    }
    throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
  }
  
  public static c c(Context paramContext)
  {
    if (l == null)
    {
      GeneratedAppGlideModule localGeneratedAppGlideModule = d(paramContext.getApplicationContext());
      try
      {
        if (l == null) {
          a(paramContext, localGeneratedAppGlideModule);
        }
      }
      finally {}
    }
    return l;
  }
  
  private static GeneratedAppGlideModule d(Context paramContext)
  {
    try
    {
      try
      {
        paramContext = (GeneratedAppGlideModule)GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext.getApplicationContext() });
        return paramContext;
      }
      catch (InvocationTargetException paramContext) {}catch (NoSuchMethodException paramContext) {}catch (IllegalAccessException paramContext) {}catch (InstantiationException paramContext) {}
      q(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      label55:
      break label55;
    }
    if (Log.isLoggable("Glide", 5)) {
      Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
    }
    return null;
  }
  
  private static com.bumptech.glide.manager.h l(Context paramContext)
  {
    x2.k.e(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    return c(paramContext).k();
  }
  
  private static void m(Context paramContext, GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    n(paramContext, new d(), paramGeneratedAppGlideModule);
  }
  
  private static void n(Context paramContext, d paramd, GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    Context localContext = paramContext.getApplicationContext();
    paramContext = Collections.emptyList();
    if ((paramGeneratedAppGlideModule == null) || (paramGeneratedAppGlideModule.c())) {
      paramContext = new r2.d(localContext).a();
    }
    Object localObject2;
    Object localObject3;
    if ((paramGeneratedAppGlideModule != null) && (!paramGeneratedAppGlideModule.d().isEmpty()))
    {
      localObject1 = paramGeneratedAppGlideModule.d();
      localObject2 = paramContext.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r2.b)((Iterator)localObject2).next();
        if (((Set)localObject1).contains(localObject3.getClass()))
        {
          if (Log.isLoggable("Glide", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("AppGlideModule excludes manifest GlideModule: ");
            localStringBuilder.append(localObject3);
            Log.d("Glide", localStringBuilder.toString());
          }
          ((Iterator)localObject2).remove();
        }
      }
    }
    if (Log.isLoggable("Glide", 3))
    {
      localObject1 = paramContext.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (r2.b)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Discovered GlideModule from manifest: ");
        ((StringBuilder)localObject3).append(localObject2.getClass());
        Log.d("Glide", ((StringBuilder)localObject3).toString());
      }
    }
    if (paramGeneratedAppGlideModule != null) {
      localObject1 = paramGeneratedAppGlideModule.e();
    } else {
      localObject1 = null;
    }
    paramd.d((h.b)localObject1);
    Object localObject1 = paramContext.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((r2.b)((Iterator)localObject1).next()).a(localContext, paramd);
    }
    if (paramGeneratedAppGlideModule != null) {
      paramGeneratedAppGlideModule.b(localContext, paramd);
    }
    paramd = paramd.a(localContext);
    localObject1 = paramContext.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramContext = (r2.b)((Iterator)localObject1).next();
      try
      {
        paramContext.b(localContext, paramd, paramd.e);
      }
      catch (AbstractMethodError paramd)
      {
        paramGeneratedAppGlideModule = new StringBuilder();
        paramGeneratedAppGlideModule.append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
        paramGeneratedAppGlideModule.append(paramContext.getClass().getName());
        throw new IllegalStateException(paramGeneratedAppGlideModule.toString(), paramd);
      }
    }
    if (paramGeneratedAppGlideModule != null) {
      paramGeneratedAppGlideModule.a(localContext, paramd, paramd.e);
    }
    localContext.registerComponentCallbacks(paramd);
    l = paramd;
  }
  
  private static void q(Exception paramException)
  {
    throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", paramException);
  }
  
  public static k t(Context paramContext)
  {
    return l(paramContext).f(paramContext);
  }
  
  public void b()
  {
    x2.l.b();
    this.c.a();
    this.b.a();
    this.f.a();
  }
  
  public e2.b e()
  {
    return this.f;
  }
  
  public e2.d f()
  {
    return this.b;
  }
  
  q2.b g()
  {
    return this.h;
  }
  
  public Context h()
  {
    return this.d.getBaseContext();
  }
  
  e i()
  {
    return this.d;
  }
  
  public i j()
  {
    return this.e;
  }
  
  public com.bumptech.glide.manager.h k()
  {
    return this.g;
  }
  
  void o(k paramk)
  {
    synchronized (this.i)
    {
      if (!this.i.contains(paramk))
      {
        this.i.add(paramk);
        return;
      }
      throw new IllegalStateException("Cannot register already registered manager");
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    r(paramInt);
  }
  
  boolean p(u2.h<?> paramh)
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        if (((k)localIterator.next()).x(paramh)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void r(int paramInt)
  {
    
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).onTrimMemory(paramInt);
      }
      this.c.b(paramInt);
      this.b.b(paramInt);
      this.f.b(paramInt);
      return;
    }
  }
  
  void s(k paramk)
  {
    synchronized (this.i)
    {
      if (this.i.contains(paramk))
      {
        this.i.remove(paramk);
        return;
      }
      throw new IllegalStateException("Cannot unregister not yet registered manager");
    }
  }
  
  public static abstract interface a
  {
    public abstract t2.i build();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.c
 * JD-Core Version:    0.7.0.1
 */