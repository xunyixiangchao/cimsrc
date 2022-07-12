package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import s.k;
import s.l1;
import s.l1.a;
import s.m0;
import s.p0;
import s.q0;
import u.f;
import x0.h;

class a2
  implements l1
{
  final Object a = new Object();
  private l1.a b = new a();
  private l1.a c = new b();
  private u.c<List<e1>> d = new c();
  boolean e = false;
  boolean f = false;
  final l1 g;
  final l1 h;
  l1.a i;
  Executor j;
  c.a<Void> k;
  private u7.a<Void> l;
  final Executor m;
  final p0 n;
  private final u7.a<Void> o;
  private String p = new String();
  k2 q = new k2(Collections.emptyList(), this.p);
  private final List<Integer> r = new ArrayList();
  private u7.a<List<e1>> s = f.h(new ArrayList());
  f t;
  Executor u;
  
  a2(e parame)
  {
    if (parame.a.f() >= parame.b.c().size())
    {
      l1 locall1 = parame.a;
      this.g = locall1;
      int i3 = locall1.getWidth();
      int i4 = locall1.getHeight();
      int i5 = parame.d;
      int i2 = i3;
      int i1 = i4;
      if (i5 == 256)
      {
        i2 = (int)(i3 * i4 * 1.5F) + 64000;
        i1 = 1;
      }
      d locald = new d(ImageReader.newInstance(i2, i1, i5, locall1.f()));
      this.h = locald;
      this.m = parame.e;
      p0 localp0 = parame.c;
      this.n = localp0;
      localp0.c(locald.getSurface(), parame.d);
      localp0.a(new Size(locall1.getWidth(), locall1.getHeight()));
      this.o = localp0.d();
      s(parame.b);
      return;
    }
    throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
  }
  
  private void j()
  {
    synchronized (this.a)
    {
      if (!this.s.isDone()) {
        this.s.cancel(true);
      }
      this.q.e();
      return;
    }
  }
  
  public e1 b()
  {
    synchronized (this.a)
    {
      e1 locale1 = this.h.b();
      return locale1;
    }
  }
  
  public int c()
  {
    synchronized (this.a)
    {
      int i1 = this.h.c();
      return i1;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
      this.g.d();
      this.h.d();
      this.e = true;
      this.n.close();
      k();
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      this.i = null;
      this.j = null;
      this.g.d();
      this.h.d();
      if (!this.f) {
        this.q.d();
      }
      return;
    }
  }
  
  public void e(l1.a parama, Executor paramExecutor)
  {
    synchronized (this.a)
    {
      this.i = ((l1.a)h.g(parama));
      this.j = ((Executor)h.g(paramExecutor));
      this.g.e(this.b, paramExecutor);
      this.h.e(this.c, paramExecutor);
      return;
    }
  }
  
  public int f()
  {
    synchronized (this.a)
    {
      int i1 = this.g.f();
      return i1;
    }
  }
  
  public e1 g()
  {
    synchronized (this.a)
    {
      e1 locale1 = this.h.g();
      return locale1;
    }
  }
  
  public int getHeight()
  {
    synchronized (this.a)
    {
      int i1 = this.g.getHeight();
      return i1;
    }
  }
  
  public Surface getSurface()
  {
    synchronized (this.a)
    {
      Surface localSurface = this.g.getSurface();
      return localSurface;
    }
  }
  
  public int getWidth()
  {
    synchronized (this.a)
    {
      int i1 = this.g.getWidth();
      return i1;
    }
  }
  
  void k()
  {
    synchronized (this.a)
    {
      boolean bool1 = this.e;
      boolean bool2 = this.f;
      c.a locala = this.k;
      if ((bool1) && (!bool2))
      {
        this.g.close();
        this.q.d();
        this.h.close();
      }
      if ((bool1) && (!bool2)) {
        this.o.h(new y1(this, locala), t.a.a());
      }
      return;
    }
  }
  
  k l()
  {
    synchronized (this.a)
    {
      Object localObject2 = this.g;
      if ((localObject2 instanceof q1))
      {
        localObject2 = ((q1)localObject2).m();
        return localObject2;
      }
      localObject2 = new d();
      return localObject2;
    }
  }
  
  u7.a<Void> m()
  {
    synchronized (this.a)
    {
      u7.a locala;
      if ((this.e) && (!this.f))
      {
        locala = f.o(this.o, z1.a, t.a.a());
      }
      else
      {
        if (this.l == null) {
          this.l = androidx.concurrent.futures.c.a(new x1(this));
        }
        locala = f.j(this.l);
      }
      return locala;
    }
  }
  
  public String n()
  {
    return this.p;
  }
  
  /* Error */
  void o(l1 paraml1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	androidx/camera/core/a2:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 77	androidx/camera/core/a2:e	Z
    //   11: ifeq +6 -> 17
    //   14: aload_2
    //   15: monitorexit
    //   16: return
    //   17: aload_1
    //   18: invokeinterface 258 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +109 -> 134
    //   28: aload_1
    //   29: invokeinterface 311 1 0
    //   34: invokeinterface 316 1 0
    //   39: aload_0
    //   40: getfield 84	androidx/camera/core/a2:p	Ljava/lang/String;
    //   43: invokevirtual 321	s/n2:c	(Ljava/lang/String;)Ljava/lang/Object;
    //   46: checkcast 323	java/lang/Integer
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 102	androidx/camera/core/a2:r	Ljava/util/List;
    //   54: aload_3
    //   55: invokeinterface 326 2 0
    //   60: ifne +48 -> 108
    //   63: new 328	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   70: astore 4
    //   72: aload 4
    //   74: ldc_w 331
    //   77: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc_w 340
    //   91: aload 4
    //   93: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 348	androidx/camera/core/n1:k	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_1
    //   100: invokeinterface 349 1 0
    //   105: goto +29 -> 134
    //   108: aload_0
    //   109: getfield 97	androidx/camera/core/a2:q	Landroidx/camera/core/k2;
    //   112: aload_1
    //   113: invokevirtual 352	androidx/camera/core/k2:c	(Landroidx/camera/core/e1;)V
    //   116: goto +18 -> 134
    //   119: astore_1
    //   120: goto +17 -> 137
    //   123: astore_1
    //   124: ldc_w 340
    //   127: ldc_w 354
    //   130: aload_1
    //   131: invokestatic 357	androidx/camera/core/n1:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_2
    //   135: monitorexit
    //   136: return
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	a2
    //   0	144	1	paraml1	l1
    //   4	137	2	localObject	Object
    //   49	35	3	localInteger	Integer
    //   70	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	24	119	finally
    //   124	134	119	finally
    //   17	24	123	java/lang/IllegalStateException
    //   7	16	139	finally
    //   28	105	139	finally
    //   108	116	139	finally
    //   134	136	139	finally
    //   137	139	139	finally
    //   140	142	139	finally
  }
  
  public void s(m0 paramm0)
  {
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
      j();
      if (paramm0.c() != null)
      {
        if (this.g.f() >= paramm0.c().size())
        {
          this.r.clear();
          Iterator localIterator = paramm0.c().iterator();
          while (localIterator.hasNext())
          {
            q0 localq0 = (q0)localIterator.next();
            if (localq0 != null) {
              this.r.add(Integer.valueOf(localq0.getId()));
            }
          }
        }
        throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
      }
      paramm0 = Integer.toString(paramm0.hashCode());
      this.p = paramm0;
      this.q = new k2(this.r, paramm0);
      u();
      return;
    }
  }
  
  public void t(Executor paramExecutor, f paramf)
  {
    synchronized (this.a)
    {
      this.u = paramExecutor;
      this.t = paramf;
      return;
    }
  }
  
  void u()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add(this.q.a(localInteger.intValue()));
    }
    this.s = f.c(localArrayList);
    f.b(f.c(localArrayList), this.d, this.m);
  }
  
  class a
    implements l1.a
  {
    a() {}
    
    public void a(l1 paraml1)
    {
      a2.this.o(paraml1);
    }
  }
  
  class b
    implements l1.a
  {
    b() {}
    
    public void a(l1 arg1)
    {
      synchronized (a2.this.a)
      {
        a2 locala2 = a2.this;
        l1.a locala = locala2.i;
        Executor localExecutor = locala2.j;
        locala2.q.e();
        a2.this.u();
        if (locala != null)
        {
          if (localExecutor != null)
          {
            localExecutor.execute(new b2(this, locala));
            return;
          }
          locala.a(a2.this);
        }
        return;
      }
    }
  }
  
  class c
    implements u.c<List<e1>>
  {
    c() {}
    
    public void a(Throwable paramThrowable) {}
    
    public void e(List<e1> arg1)
    {
      synchronized (a2.this.a)
      {
        a2 locala2 = a2.this;
        if (locala2.e) {
          return;
        }
        locala2.f = true;
        k2 localk2 = locala2.q;
        ??? = locala2.t;
        Object localObject1 = locala2.u;
        try
        {
          locala2.n.b(localk2);
        }
        catch (Exception localException) {}
        synchronized (a2.this.a)
        {
          a2.this.q.e();
          if ((??? != null) && (localObject1 != null)) {
            ((Executor)localObject1).execute(new c2(???, localException));
          }
          synchronized (a2.this.a)
          {
            localObject1 = a2.this;
            ((a2)localObject1).f = false;
            ((a2)localObject1).k();
            return;
          }
        }
      }
    }
  }
  
  class d
    extends k
  {
    d() {}
  }
  
  static final class e
  {
    protected final l1 a;
    protected final m0 b;
    protected final p0 c;
    protected int d;
    protected Executor e = Executors.newSingleThreadExecutor();
    
    e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, m0 paramm0, p0 paramp0)
    {
      this(new q1(paramInt1, paramInt2, paramInt3, paramInt4), paramm0, paramp0);
    }
    
    e(l1 paraml1, m0 paramm0, p0 paramp0)
    {
      this.a = paraml1;
      this.b = paramm0;
      this.c = paramp0;
      this.d = paraml1.c();
    }
    
    a2 a()
    {
      return new a2(this);
    }
    
    e b(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    e c(Executor paramExecutor)
    {
      this.e = paramExecutor;
      return this;
    }
  }
  
  static abstract interface f
  {
    public abstract void a(String paramString, Throwable paramThrowable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.a2
 * JD-Core Version:    0.7.0.1
 */