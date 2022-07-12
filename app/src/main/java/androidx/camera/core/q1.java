package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import s.k;
import s.l1;
import s.l1.a;
import s.t;
import v.b;
import x0.h;

public class q1
  implements l1, j0.a
{
  private final Object a = new Object();
  private k b = new a();
  private l1.a c = new p1(this);
  private boolean d = false;
  private final l1 e;
  l1.a f;
  private Executor g;
  private final LongSparseArray<d1> h = new LongSparseArray();
  private final LongSparseArray<e1> i = new LongSparseArray();
  private int j;
  private final List<e1> k;
  private final List<e1> l = new ArrayList();
  
  public q1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(j(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  q1(l1 paraml1)
  {
    this.e = paraml1;
    this.j = 0;
    this.k = new ArrayList(f());
  }
  
  private static l1 j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new d(ImageReader.newInstance(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private void k(e1 parame1)
  {
    synchronized (this.a)
    {
      int m = this.k.indexOf(parame1);
      if (m >= 0)
      {
        this.k.remove(m);
        int n = this.j;
        if (m <= n) {
          this.j = (n - 1);
        }
      }
      this.l.remove(parame1);
      return;
    }
  }
  
  private void l(j2 paramj2)
  {
    synchronized (this.a)
    {
      int m = this.k.size();
      int n = f();
      Object localObject1 = null;
      Executor localExecutor;
      if (m < n)
      {
        paramj2.a(this);
        this.k.add(paramj2);
        paramj2 = this.f;
        localExecutor = this.g;
      }
      else
      {
        n1.a("TAG", "Maximum image number reached.");
        paramj2.close();
        localExecutor = null;
        paramj2 = localObject1;
      }
      if (paramj2 != null)
      {
        if (localExecutor != null)
        {
          localExecutor.execute(new o1(this, paramj2));
          return;
        }
        paramj2.a(this);
      }
      return;
    }
  }
  
  private void q()
  {
    for (;;)
    {
      int m;
      synchronized (this.a)
      {
        m = this.h.size() - 1;
        if (m >= 0)
        {
          d1 locald1 = (d1)this.h.valueAt(m);
          long l1 = locald1.getTimestamp();
          e1 locale1 = (e1)this.i.get(l1);
          if (locale1 != null)
          {
            this.i.remove(l1);
            this.h.removeAt(m);
            l(new j2(locale1, locald1));
          }
        }
        else
        {
          r();
          return;
        }
      }
      m -= 1;
    }
  }
  
  private void r()
  {
    for (;;)
    {
      int m;
      synchronized (this.a)
      {
        if ((this.i.size() != 0) && (this.h.size() != 0))
        {
          Object localObject2 = this.i;
          boolean bool = false;
          localObject2 = Long.valueOf(((LongSparseArray)localObject2).keyAt(0));
          Long localLong = Long.valueOf(this.h.keyAt(0));
          if (!localLong.equals(localObject2)) {
            bool = true;
          }
          h.a(bool);
          if (localLong.longValue() > ((Long)localObject2).longValue())
          {
            m = this.i.size() - 1;
            if (m >= 0)
            {
              if (this.i.keyAt(m) >= localLong.longValue()) {
                break label205;
              }
              ((e1)this.i.valueAt(m)).close();
              this.i.removeAt(m);
              break label205;
            }
          }
          else
          {
            m = this.h.size() - 1;
            if (m >= 0)
            {
              if (this.h.keyAt(m) >= ((Long)localObject2).longValue()) {
                break label212;
              }
              this.h.removeAt(m);
              break label212;
            }
          }
        }
        else
        {
          return;
        }
      }
      label205:
      m -= 1;
      continue;
      label212:
      m -= 1;
    }
  }
  
  public void a(e1 parame1)
  {
    synchronized (this.a)
    {
      k(parame1);
      return;
    }
  }
  
  public e1 b()
  {
    for (;;)
    {
      int m;
      synchronized (this.a)
      {
        if (this.k.isEmpty()) {
          return null;
        }
        if (this.j < this.k.size())
        {
          Object localObject2 = new ArrayList();
          m = 0;
          if (m < this.k.size() - 1)
          {
            if (!this.l.contains(this.k.get(m))) {
              ((List)localObject2).add((e1)this.k.get(m));
            }
          }
          else
          {
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              ((e1)((Iterator)localObject2).next()).close();
              continue;
            }
            m = this.k.size() - 1;
            localObject2 = this.k;
            this.j = (m + 1);
            localObject2 = (e1)((List)localObject2).get(m);
            this.l.add(localObject2);
            return localObject2;
          }
        }
        else
        {
          throw new IllegalStateException("Maximum image number reached.");
        }
      }
      m += 1;
    }
  }
  
  public int c()
  {
    synchronized (this.a)
    {
      int m = this.e.c();
      return m;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      Iterator localIterator = new ArrayList(this.k).iterator();
      while (localIterator.hasNext()) {
        ((e1)localIterator.next()).close();
      }
      this.k.clear();
      this.e.close();
      this.d = true;
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      this.f = null;
      this.g = null;
      return;
    }
  }
  
  public void e(l1.a parama, Executor paramExecutor)
  {
    synchronized (this.a)
    {
      this.f = ((l1.a)h.g(parama));
      this.g = ((Executor)h.g(paramExecutor));
      this.e.e(this.c, paramExecutor);
      return;
    }
  }
  
  public int f()
  {
    synchronized (this.a)
    {
      int m = this.e.f();
      return m;
    }
  }
  
  public e1 g()
  {
    synchronized (this.a)
    {
      if (this.k.isEmpty()) {
        return null;
      }
      if (this.j < this.k.size())
      {
        Object localObject2 = this.k;
        int m = this.j;
        this.j = (m + 1);
        localObject2 = (e1)((List)localObject2).get(m);
        this.l.add(localObject2);
        return localObject2;
      }
      throw new IllegalStateException("Maximum image number reached.");
    }
  }
  
  public int getHeight()
  {
    synchronized (this.a)
    {
      int m = this.e.getHeight();
      return m;
    }
  }
  
  public Surface getSurface()
  {
    synchronized (this.a)
    {
      Surface localSurface = this.e.getSurface();
      return localSurface;
    }
  }
  
  public int getWidth()
  {
    synchronized (this.a)
    {
      int m = this.e.getWidth();
      return m;
    }
  }
  
  public k m()
  {
    return this.b;
  }
  
  /* Error */
  void n(l1 paraml1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	androidx/camera/core/q1:a	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 60	androidx/camera/core/q1:d	Z
    //   13: ifeq +7 -> 20
    //   16: aload 6
    //   18: monitorexit
    //   19: return
    //   20: iconst_0
    //   21: istore_2
    //   22: aconst_null
    //   23: astore 4
    //   25: aload_1
    //   26: invokeinterface 278 1 0
    //   31: astore 5
    //   33: iload_2
    //   34: istore_3
    //   35: aload 5
    //   37: astore 4
    //   39: aload 5
    //   41: ifnull +58 -> 99
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: istore_3
    //   48: aload_0
    //   49: getfield 67	androidx/camera/core/q1:i	Landroid/util/LongSparseArray;
    //   52: aload 5
    //   54: invokeinterface 281 1 0
    //   59: invokeinterface 174 1 0
    //   64: aload 5
    //   66: invokevirtual 285	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   69: aload_0
    //   70: invokespecial 287	androidx/camera/core/q1:q	()V
    //   73: aload 5
    //   75: astore 4
    //   77: goto +22 -> 99
    //   80: astore_1
    //   81: goto +39 -> 120
    //   84: astore 5
    //   86: ldc_w 289
    //   89: ldc_w 291
    //   92: aload 5
    //   94: invokestatic 294	androidx/camera/core/n1:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: iload_2
    //   98: istore_3
    //   99: aload 4
    //   101: ifnull +15 -> 116
    //   104: iload_3
    //   105: istore_2
    //   106: iload_3
    //   107: aload_1
    //   108: invokeinterface 264 1 0
    //   113: if_icmplt -91 -> 22
    //   116: aload 6
    //   118: monitorexit
    //   119: return
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload 6
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	q1
    //   0	128	1	paraml1	l1
    //   21	85	2	m	int
    //   34	80	3	n	int
    //   23	77	4	localObject1	Object
    //   31	43	5	locale1	e1
    //   84	9	5	localIllegalStateException	IllegalStateException
    //   4	120	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	33	80	finally
    //   86	97	80	finally
    //   25	33	84	java/lang/IllegalStateException
    //   9	19	122	finally
    //   48	73	122	finally
    //   106	116	122	finally
    //   116	119	122	finally
    //   120	122	122	finally
    //   123	126	122	finally
  }
  
  void s(t paramt)
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      this.h.put(paramt.getTimestamp(), new b(paramt));
      q();
      return;
    }
  }
  
  class a
    extends k
  {
    a() {}
    
    public void b(t paramt)
    {
      super.b(paramt);
      q1.this.s(paramt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.q1
 * JD-Core Version:    0.7.0.1
 */