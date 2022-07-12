package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import n1.b;
import p1.h.c;
import p1.k;

public abstract class f0
{
  @Deprecated
  protected volatile p1.g a;
  private Executor b;
  private Executor c;
  private p1.h d;
  private final n e = h();
  private boolean f;
  boolean g;
  @Deprecated
  protected List<b> h;
  protected Map<Class<? extends n1.a>, n1.a> i = new HashMap();
  private final ReentrantReadWriteLock j = new ReentrantReadWriteLock();
  private a k;
  private final ThreadLocal<Integer> l = new ThreadLocal();
  private final Map<String, Object> m = Collections.synchronizedMap(new HashMap());
  private final Map<Class<?>, Object> n = new HashMap();
  
  private <T> T C(Class<T> paramClass, p1.h paramh)
  {
    if (paramClass.isInstance(paramh)) {
      return paramh;
    }
    if ((paramh instanceof i)) {
      return C(paramClass, ((i)paramh).a());
    }
    return null;
  }
  
  private void s()
  {
    c();
    p1.g localg = this.d.X();
    this.e.q(localg);
    if (localg.M())
    {
      localg.R();
      return;
    }
    localg.f();
  }
  
  private void t()
  {
    this.d.X().e();
    if (!q()) {
      this.e.h();
    }
  }
  
  private static boolean v()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public Cursor A(p1.j paramj, CancellationSignal paramCancellationSignal)
  {
    c();
    d();
    if (paramCancellationSignal != null) {
      return this.d.X().Q(paramj, paramCancellationSignal);
    }
    return this.d.X().x(paramj);
  }
  
  @Deprecated
  public void B()
  {
    this.d.X().P();
  }
  
  public void c()
  {
    if (this.f) {
      return;
    }
    if (!v()) {
      return;
    }
    throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
  }
  
  public void d()
  {
    if (!q())
    {
      if (this.l.get() == null) {
        return;
      }
      throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }
  }
  
  @Deprecated
  public void e()
  {
    c();
    a locala = this.k;
    if (locala == null)
    {
      s();
      return;
    }
    locala.c(new m1.i(this));
  }
  
  public void f()
  {
    if (w())
    {
      ReentrantReadWriteLock.WriteLock localWriteLock = this.j.writeLock();
      localWriteLock.lock();
      try
      {
        this.e.n();
        this.d.close();
        return;
      }
      finally
      {
        localWriteLock.unlock();
      }
    }
  }
  
  public k g(String paramString)
  {
    c();
    d();
    return this.d.X().v(paramString);
  }
  
  protected abstract n h();
  
  protected abstract p1.h i(h paramh);
  
  @Deprecated
  public void j()
  {
    a locala = this.k;
    if (locala == null)
    {
      t();
      return;
    }
    locala.c(new m1.j(this));
  }
  
  public List<b> k(Map<Class<? extends n1.a>, n1.a> paramMap)
  {
    return Collections.emptyList();
  }
  
  Lock l()
  {
    return this.j.readLock();
  }
  
  public p1.h m()
  {
    return this.d;
  }
  
  public Executor n()
  {
    return this.b;
  }
  
  public Set<Class<? extends n1.a>> o()
  {
    return Collections.emptySet();
  }
  
  protected Map<Class<?>, List<Class<?>>> p()
  {
    return Collections.emptyMap();
  }
  
  public boolean q()
  {
    return this.d.X().I();
  }
  
  public void r(h paramh)
  {
    this.d = i(paramh);
    Object localObject2 = o();
    Object localObject1 = new BitSet();
    Iterator localIterator1 = ((Set)localObject2).iterator();
    boolean bool1;
    for (;;)
    {
      bool1 = localIterator1.hasNext();
      int i3 = -1;
      if (!bool1) {
        break label198;
      }
      localObject2 = (Class)localIterator1.next();
      i1 = paramh.g.size() - 1;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 < 0) {
          break;
        }
        if (((Class)localObject2).isAssignableFrom(paramh.g.get(i1).getClass()))
        {
          ((BitSet)localObject1).set(i1);
          i2 = i1;
          break;
        }
        i1 -= 1;
      }
      if (i2 < 0) {
        break;
      }
      this.i.put(localObject2, (n1.a)paramh.g.get(i2));
    }
    paramh = new StringBuilder();
    paramh.append("A required auto migration spec (");
    paramh.append(((Class)localObject2).getCanonicalName());
    paramh.append(") is missing in the database configuration.");
    throw new IllegalArgumentException(paramh.toString());
    label198:
    int i1 = paramh.g.size() - 1;
    while (i1 >= 0) {
      if (((BitSet)localObject1).get(i1)) {
        i1 -= 1;
      } else {
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
      }
    }
    localObject1 = k(this.i).iterator();
    for (;;)
    {
      boolean bool2 = ((Iterator)localObject1).hasNext();
      bool1 = false;
      if (!bool2) {
        break;
      }
      localObject2 = (b)((Iterator)localObject1).next();
      if (!paramh.d.e().containsKey(Integer.valueOf(((b)localObject2).a))) {
        paramh.d.b(new b[] { localObject2 });
      }
    }
    localObject1 = (h0)C(h0.class, this.d);
    if (localObject1 != null) {
      ((h0)localObject1).i(paramh);
    }
    localObject1 = (e)C(e.class, this.d);
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).g();
      this.k = ((a)localObject1);
      this.e.k((a)localObject1);
    }
    if (paramh.i == c.c) {
      bool1 = true;
    }
    this.d.setWriteAheadLoggingEnabled(bool1);
    this.h = paramh.e;
    this.b = paramh.j;
    this.c = new j0(paramh.k);
    this.f = paramh.h;
    this.g = bool1;
    localObject1 = paramh.m;
    if (localObject1 != null) {
      this.e.l(paramh.b, paramh.c, (Intent)localObject1);
    }
    localObject2 = p();
    localObject1 = new BitSet();
    localIterator1 = ((Map)localObject2).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject3 = (Map.Entry)localIterator1.next();
      localObject2 = (Class)((Map.Entry)localObject3).getKey();
      Iterator localIterator2 = ((List)((Map.Entry)localObject3).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (Class)localIterator2.next();
        i1 = paramh.f.size() - 1;
        while (i1 >= 0)
        {
          if (((Class)localObject3).isAssignableFrom(paramh.f.get(i1).getClass()))
          {
            ((BitSet)localObject1).set(i1);
            break label651;
          }
          i1 -= 1;
        }
        i1 = -1;
        label651:
        if (i1 < 0) {
          break label680;
        }
        this.n.put(localObject3, paramh.f.get(i1));
      }
      continue;
      label680:
      paramh = new StringBuilder();
      paramh.append("A required type converter (");
      paramh.append(localObject3);
      paramh.append(") for ");
      paramh.append(((Class)localObject2).getCanonicalName());
      paramh.append(" is missing in the database configuration.");
      throw new IllegalArgumentException(paramh.toString());
    }
    i1 = paramh.f.size() - 1;
    while (i1 >= 0) {
      if (((BitSet)localObject1).get(i1))
      {
        i1 -= 1;
      }
      else
      {
        paramh = paramh.f.get(i1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unexpected type converter ");
        ((StringBuilder)localObject1).append(paramh);
        ((StringBuilder)localObject1).append(". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected void u(p1.g paramg)
  {
    this.e.e(paramg);
  }
  
  public boolean w()
  {
    Object localObject = this.k;
    if (localObject != null) {
      return ((a)localObject).g();
    }
    localObject = this.a;
    return (localObject != null) && (((p1.g)localObject).isOpen());
  }
  
  public Cursor z(p1.j paramj)
  {
    return A(paramj, null);
  }
  
  public static class a<T extends f0>
  {
    private final Class<T> a;
    private final String b;
    private final Context c;
    private ArrayList<f0.b> d;
    private f0.f e;
    private Executor f;
    private List<Object> g;
    private List<n1.a> h;
    private Executor i;
    private Executor j;
    private h.c k;
    private boolean l;
    private f0.c m;
    private Intent n;
    private boolean o;
    private boolean p;
    private long q = -1L;
    private TimeUnit r;
    private final f0.d s;
    private Set<Integer> t;
    private Set<Integer> u;
    private String v;
    private File w;
    private Callable<InputStream> x;
    
    a(Context paramContext, Class<T> paramClass, String paramString)
    {
      this.c = paramContext;
      this.a = paramClass;
      this.b = paramString;
      this.m = f0.c.a;
      this.o = true;
      this.s = new f0.d();
    }
    
    public a<T> a(b... paramVarArgs)
    {
      if (this.u == null) {
        this.u = new HashSet();
      }
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        b localb = paramVarArgs[i1];
        this.u.add(Integer.valueOf(localb.a));
        this.u.add(Integer.valueOf(localb.b));
        i1 += 1;
      }
      this.s.b(paramVarArgs);
      return this;
    }
    
    public a<T> b()
    {
      this.l = true;
      return this;
    }
    
    @SuppressLint({"RestrictedApi"})
    public T c()
    {
      if (this.c != null)
      {
        if (this.a != null)
        {
          Object localObject1 = this.i;
          if ((localObject1 == null) && (this.j == null))
          {
            localObject1 = i.a.d();
            this.j = ((Executor)localObject1);
          }
          do
          {
            this.i = ((Executor)localObject1);
            break;
            if ((localObject1 != null) && (this.j == null))
            {
              this.j = ((Executor)localObject1);
              break;
            }
            if (localObject1 != null) {
              break;
            }
            localObject1 = this.j;
          } while (localObject1 != null);
          localObject1 = this.u;
          if ((localObject1 != null) && (this.t != null))
          {
            localObject2 = ((Set)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Integer)((Iterator)localObject2).next();
              if (this.t.contains(localObject1))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                ((StringBuilder)localObject2).append(localObject1);
                throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
              }
            }
          }
          localObject1 = this.k;
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new q1.c();
          }
          long l1 = this.q;
          localObject1 = localObject2;
          if (l1 > 0L) {
            if (this.b != null) {
              localObject1 = new g((h.c)localObject2, new a(l1, this.r, this.j));
            } else {
              throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
            }
          }
          String str = this.v;
          if ((str == null) && (this.w == null))
          {
            localObject2 = localObject1;
            if (this.x == null) {}
          }
          else
          {
            if (this.b == null) {
              break label553;
            }
            int i3 = 0;
            int i1;
            if (str == null) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            localObject2 = this.w;
            int i2;
            if (localObject2 == null) {
              i2 = 0;
            } else {
              i2 = 1;
            }
            Callable localCallable = this.x;
            if (localCallable != null) {
              i3 = 1;
            }
            if (i1 + i2 + i3 != 1) {
              break label543;
            }
            localObject2 = new i0(str, (File)localObject2, localCallable, (h.c)localObject1);
          }
          localObject1 = this.e;
          if (localObject1 != null) {
            localObject1 = new z((h.c)localObject2, (f0.f)localObject1, this.f);
          } else {
            localObject1 = localObject2;
          }
          localObject2 = this.c;
          localObject1 = new h((Context)localObject2, this.b, (h.c)localObject1, this.s, this.d, this.l, this.m.b((Context)localObject2), this.i, this.j, this.n, this.o, this.p, this.t, this.v, this.w, this.x, null, this.g, this.h);
          localObject2 = (f0)e0.b(this.a, "_Impl");
          ((f0)localObject2).r((h)localObject1);
          return localObject2;
          label543:
          throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
          label553:
          throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        }
        throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
      }
      throw new IllegalArgumentException("Cannot provide null context for the database.");
    }
  }
  
  public static abstract class b
  {
    public void a(p1.g paramg) {}
    
    public void b(p1.g paramg) {}
    
    public void c(p1.g paramg) {}
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("AUTOMATIC", 0);
      a = localc1;
      c localc2 = new c("TRUNCATE", 1);
      b = localc2;
      c localc3 = new c("WRITE_AHEAD_LOGGING", 2);
      c = localc3;
      d = new c[] { localc1, localc2, localc3 };
    }
    
    private c() {}
    
    private static boolean a(ActivityManager paramActivityManager)
    {
      return p1.c.b(paramActivityManager);
    }
    
    c b(Context paramContext)
    {
      if (this != a) {
        return this;
      }
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext != null) && (!a(paramContext))) {
        return c;
      }
      return b;
    }
  }
  
  public static class d
  {
    private HashMap<Integer, TreeMap<Integer, b>> a = new HashMap();
    
    private void a(b paramb)
    {
      int i = paramb.a;
      int j = paramb.b;
      Object localObject2 = (TreeMap)this.a.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TreeMap();
        this.a.put(Integer.valueOf(i), localObject1);
      }
      localObject2 = (b)((TreeMap)localObject1).get(Integer.valueOf(j));
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Overriding migration ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" with ");
        localStringBuilder.append(paramb);
        Log.w("ROOM", localStringBuilder.toString());
      }
      ((TreeMap)localObject1).put(Integer.valueOf(j), paramb);
    }
    
    private List<b> d(List<b> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      while (paramBoolean ? paramInt1 < paramInt2 : paramInt1 > paramInt2)
      {
        TreeMap localTreeMap = (TreeMap)this.a.get(Integer.valueOf(paramInt1));
        if (localTreeMap == null) {
          return null;
        }
        if (paramBoolean) {
          localObject = localTreeMap.descendingKeySet();
        } else {
          localObject = localTreeMap.keySet();
        }
        Object localObject = ((Set)localObject).iterator();
        int j;
        int k;
        do
        {
          boolean bool = ((Iterator)localObject).hasNext();
          j = 1;
          int m = 0;
          if (!bool) {
            break;
          }
          k = ((Integer)((Iterator)localObject).next()).intValue();
          if (paramBoolean)
          {
            i = m;
            if (k <= paramInt2)
            {
              i = m;
              if (k <= paramInt1) {}
            }
          }
          else
          {
            do
            {
              i = 1;
              break;
              i = m;
              if (k < paramInt2) {
                break;
              }
              i = m;
            } while (k < paramInt1);
          }
        } while (i == 0);
        paramList.add((b)localTreeMap.get(Integer.valueOf(k)));
        paramInt1 = k;
        int i = j;
        break label200;
        i = 0;
        label200:
        if (i == 0) {
          return null;
        }
      }
      return paramList;
    }
    
    public void b(b... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        a(paramVarArgs[i]);
        i += 1;
      }
    }
    
    public List<b> c(int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      boolean bool;
      if (paramInt2 > paramInt1) {
        bool = true;
      } else {
        bool = false;
      }
      return d(new ArrayList(), bool, paramInt1, paramInt2);
    }
    
    public Map<Integer, Map<Integer, b>> e()
    {
      return Collections.unmodifiableMap(this.a);
    }
  }
  
  public static abstract class e {}
  
  public static abstract interface f
  {
    public abstract void a(String paramString, List<Object> paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.f0
 * JD-Core Version:    0.7.0.1
 */