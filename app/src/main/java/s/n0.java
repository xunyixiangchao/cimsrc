package s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v.i;

public final class n0
{
  public static final s0.a<Integer> h = s0.a.a("camerax.core.captureConfig.rotation", Integer.TYPE);
  public static final s0.a<Integer> i = s0.a.a("camerax.core.captureConfig.jpegQuality", Integer.class);
  final List<v0> a;
  final s0 b;
  final int c;
  final List<k> d;
  private final boolean e;
  private final n2 f;
  private final t g;
  
  n0(List<v0> paramList, s0 params0, int paramInt, List<k> paramList1, boolean paramBoolean, n2 paramn2, t paramt)
  {
    this.a = paramList;
    this.b = params0;
    this.c = paramInt;
    this.d = Collections.unmodifiableList(paramList1);
    this.e = paramBoolean;
    this.f = paramn2;
    this.g = paramt;
  }
  
  public static n0 a()
  {
    return new a().h();
  }
  
  public List<k> b()
  {
    return this.d;
  }
  
  public t c()
  {
    return this.g;
  }
  
  public s0 d()
  {
    return this.b;
  }
  
  public List<v0> e()
  {
    return Collections.unmodifiableList(this.a);
  }
  
  public n2 f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public static final class a
  {
    private final Set<v0> a;
    private t1 b;
    private int c;
    private List<k> d;
    private boolean e;
    private v1 f;
    private t g;
    
    public a()
    {
      this.a = new HashSet();
      this.b = u1.M();
      this.c = -1;
      this.d = new ArrayList();
      this.e = false;
      this.f = v1.f();
    }
    
    private a(n0 paramn0)
    {
      HashSet localHashSet = new HashSet();
      this.a = localHashSet;
      this.b = u1.M();
      this.c = -1;
      this.d = new ArrayList();
      this.e = false;
      this.f = v1.f();
      localHashSet.addAll(paramn0.a);
      this.b = u1.N(paramn0.b);
      this.c = paramn0.c;
      this.d.addAll(paramn0.b());
      this.e = paramn0.h();
      this.f = v1.g(paramn0.f());
    }
    
    public static a j(t2<?> paramt2)
    {
      Object localObject = paramt2.r(null);
      if (localObject != null)
      {
        a locala = new a();
        ((n0.b)localObject).a(paramt2, locala);
        return locala;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Implementation is missing option unpacker for ");
      ((StringBuilder)localObject).append(paramt2.B(paramt2.toString()));
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    public static a k(n0 paramn0)
    {
      return new a(paramn0);
    }
    
    public void a(Collection<k> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        c((k)paramCollection.next());
      }
    }
    
    public void b(n2 paramn2)
    {
      this.f.e(paramn2);
    }
    
    public void c(k paramk)
    {
      if (this.d.contains(paramk)) {
        return;
      }
      this.d.add(paramk);
    }
    
    public <T> void d(s0.a<T> parama, T paramT)
    {
      this.b.G(parama, paramT);
    }
    
    public void e(s0 params0)
    {
      Iterator localIterator = params0.c().iterator();
      while (localIterator.hasNext())
      {
        s0.a locala = (s0.a)localIterator.next();
        Object localObject1 = this.b.e(locala, null);
        Object localObject2 = params0.a(locala);
        if ((localObject1 instanceof s1))
        {
          ((s1)localObject1).a(((s1)localObject2).c());
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject2 instanceof s1)) {
            localObject1 = ((s1)localObject2).b();
          }
          this.b.t(locala, params0.d(locala), localObject1);
        }
      }
    }
    
    public void f(v0 paramv0)
    {
      this.a.add(paramv0);
    }
    
    public void g(String paramString, Object paramObject)
    {
      this.f.h(paramString, paramObject);
    }
    
    public n0 h()
    {
      return new n0(new ArrayList(this.a), y1.K(this.b), this.c, this.d, this.e, n2.b(this.f), this.g);
    }
    
    public void i()
    {
      this.a.clear();
    }
    
    public Set<v0> l()
    {
      return this.a;
    }
    
    public int m()
    {
      return this.c;
    }
    
    public void n(t paramt)
    {
      this.g = paramt;
    }
    
    public void o(s0 params0)
    {
      this.b = u1.N(params0);
    }
    
    public void p(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void q(boolean paramBoolean)
    {
      this.e = paramBoolean;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(t2<?> paramt2, n0.a parama);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.n0
 * JD-Core Version:    0.7.0.1
 */