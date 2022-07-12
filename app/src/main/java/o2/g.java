package o2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import b2.f;
import e2.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import t2.i;

class g
{
  private final z1.a a;
  private final Handler b;
  private final List<b> c = new ArrayList();
  final com.bumptech.glide.k d;
  private final d e;
  private boolean f;
  private boolean g;
  private boolean h;
  private com.bumptech.glide.j<Bitmap> i;
  private a j;
  private boolean k;
  private a l;
  private Bitmap m;
  private b2.l<Bitmap> n;
  private a o;
  private d p;
  private int q;
  private int r;
  private int s;
  
  g(com.bumptech.glide.c paramc, z1.a parama, int paramInt1, int paramInt2, b2.l<Bitmap> paraml, Bitmap paramBitmap)
  {
    this(paramc.f(), com.bumptech.glide.c.t(paramc.h()), parama, null, i(com.bumptech.glide.c.t(paramc.h()), paramInt1, paramInt2), paraml, paramBitmap);
  }
  
  g(d paramd, com.bumptech.glide.k paramk, z1.a parama, Handler paramHandler, com.bumptech.glide.j<Bitmap> paramj, b2.l<Bitmap> paraml, Bitmap paramBitmap)
  {
    this.d = paramk;
    paramk = paramHandler;
    if (paramHandler == null) {
      paramk = new Handler(Looper.getMainLooper(), new c());
    }
    this.e = paramd;
    this.b = paramk;
    this.i = paramj;
    this.a = parama;
    o(paraml, paramBitmap);
  }
  
  private static f g()
  {
    return new w2.b(Double.valueOf(Math.random()));
  }
  
  private static com.bumptech.glide.j<Bitmap> i(com.bumptech.glide.k paramk, int paramInt1, int paramInt2)
  {
    return paramk.h().p0(((i)((i)i.p0(d2.j.b).n0(true)).i0(true)).X(paramInt1, paramInt2));
  }
  
  private void l()
  {
    if (this.f)
    {
      if (this.g) {
        return;
      }
      if (this.h)
      {
        boolean bool;
        if (this.o == null) {
          bool = true;
        } else {
          bool = false;
        }
        x2.k.a(bool, "Pending target must be null when starting from the first frame");
        this.a.g();
        this.h = false;
      }
      a locala = this.o;
      if (locala != null)
      {
        this.o = null;
        m(locala);
        return;
      }
      this.g = true;
      int i1 = this.a.d();
      long l1 = SystemClock.uptimeMillis();
      long l2 = i1;
      this.a.b();
      this.l = new a(this.b, this.a.a(), l1 + l2);
      this.i.p0(i.q0(g())).C0(this.a).w0(this.l);
    }
  }
  
  private void n()
  {
    Bitmap localBitmap = this.m;
    if (localBitmap != null)
    {
      this.e.d(localBitmap);
      this.m = null;
    }
  }
  
  private void p()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    this.k = false;
    l();
  }
  
  private void q()
  {
    this.f = false;
  }
  
  void a()
  {
    this.c.clear();
    n();
    q();
    a locala = this.j;
    if (locala != null)
    {
      this.d.n(locala);
      this.j = null;
    }
    locala = this.l;
    if (locala != null)
    {
      this.d.n(locala);
      this.l = null;
    }
    locala = this.o;
    if (locala != null)
    {
      this.d.n(locala);
      this.o = null;
    }
    this.a.clear();
    this.k = true;
  }
  
  ByteBuffer b()
  {
    return this.a.getData().asReadOnlyBuffer();
  }
  
  Bitmap c()
  {
    a locala = this.j;
    if (locala != null) {
      return locala.e();
    }
    return this.m;
  }
  
  int d()
  {
    a locala = this.j;
    if (locala != null) {
      return locala.e;
    }
    return -1;
  }
  
  Bitmap e()
  {
    return this.m;
  }
  
  int f()
  {
    return this.a.c();
  }
  
  int h()
  {
    return this.s;
  }
  
  int j()
  {
    return this.a.e() + this.q;
  }
  
  int k()
  {
    return this.r;
  }
  
  void m(a parama)
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((d)localObject).a();
    }
    this.g = false;
    if (this.k)
    {
      this.b.obtainMessage(2, parama).sendToTarget();
      return;
    }
    if (!this.f)
    {
      if (this.h)
      {
        this.b.obtainMessage(2, parama).sendToTarget();
        return;
      }
      this.o = parama;
      return;
    }
    if (parama.e() != null)
    {
      n();
      localObject = this.j;
      this.j = parama;
      int i1 = this.c.size() - 1;
      while (i1 >= 0)
      {
        ((b)this.c.get(i1)).a();
        i1 -= 1;
      }
      if (localObject != null) {
        this.b.obtainMessage(2, localObject).sendToTarget();
      }
    }
    l();
  }
  
  void o(b2.l<Bitmap> paraml, Bitmap paramBitmap)
  {
    this.n = ((b2.l)x2.k.d(paraml));
    this.m = ((Bitmap)x2.k.d(paramBitmap));
    this.i = this.i.p0(new i().j0(paraml));
    this.q = x2.l.h(paramBitmap);
    this.r = paramBitmap.getWidth();
    this.s = paramBitmap.getHeight();
  }
  
  void r(b paramb)
  {
    if (!this.k)
    {
      if (!this.c.contains(paramb))
      {
        boolean bool = this.c.isEmpty();
        this.c.add(paramb);
        if (bool) {
          p();
        }
        return;
      }
      throw new IllegalStateException("Cannot subscribe twice in a row");
    }
    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
  }
  
  void s(b paramb)
  {
    this.c.remove(paramb);
    if (this.c.isEmpty()) {
      q();
    }
  }
  
  static class a
    extends u2.c<Bitmap>
  {
    private final Handler d;
    final int e;
    private final long f;
    private Bitmap g;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.d = paramHandler;
      this.e = paramInt;
      this.f = paramLong;
    }
    
    Bitmap e()
    {
      return this.g;
    }
    
    public void h(Bitmap paramBitmap, v2.b<? super Bitmap> paramb)
    {
      this.g = paramBitmap;
      paramBitmap = this.d.obtainMessage(1, this);
      this.d.sendMessageAtTime(paramBitmap, this.f);
    }
    
    public void k(Drawable paramDrawable)
    {
      this.g = null;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  private class c
    implements Handler.Callback
  {
    c() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i == 1)
      {
        paramMessage = (g.a)paramMessage.obj;
        g.this.m(paramMessage);
        return true;
      }
      if (i == 2)
      {
        paramMessage = (g.a)paramMessage.obj;
        g.this.d.n(paramMessage);
      }
      return false;
    }
  }
  
  static abstract interface d
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.g
 * JD-Core Version:    0.7.0.1
 */