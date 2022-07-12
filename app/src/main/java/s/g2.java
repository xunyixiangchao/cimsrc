package s;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.params.InputConfiguration;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v.i;
import y.c;

public final class g2
{
  private final List<e> a;
  private final List<CameraDevice.StateCallback> b;
  private final List<CameraCaptureSession.StateCallback> c;
  private final List<k> d;
  private final List<c> e;
  private final n0 f;
  private InputConfiguration g;
  
  g2(List<e> paramList, List<CameraDevice.StateCallback> paramList1, List<CameraCaptureSession.StateCallback> paramList2, List<k> paramList3, List<c> paramList4, n0 paramn0, InputConfiguration paramInputConfiguration)
  {
    this.a = paramList;
    this.b = Collections.unmodifiableList(paramList1);
    this.c = Collections.unmodifiableList(paramList2);
    this.d = Collections.unmodifiableList(paramList3);
    this.e = Collections.unmodifiableList(paramList4);
    this.f = paramn0;
    this.g = paramInputConfiguration;
  }
  
  public static g2 a()
  {
    return new g2(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new n0.a().h(), null);
  }
  
  public List<CameraDevice.StateCallback> b()
  {
    return this.b;
  }
  
  public List<c> c()
  {
    return this.e;
  }
  
  public s0 d()
  {
    return this.f.d();
  }
  
  public InputConfiguration e()
  {
    return this.g;
  }
  
  public List<e> f()
  {
    return this.a;
  }
  
  public List<k> g()
  {
    return this.f.b();
  }
  
  public n0 h()
  {
    return this.f;
  }
  
  public List<CameraCaptureSession.StateCallback> i()
  {
    return this.c;
  }
  
  public List<k> j()
  {
    return this.d;
  }
  
  public List<v0> k()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (e)localIterator.next();
      localArrayList.add(((e)localObject).d());
      localObject = ((e)localObject).c().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((v0)((Iterator)localObject).next());
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int l()
  {
    return this.f.g();
  }
  
  static class a
  {
    final Set<g2.e> a = new LinkedHashSet();
    final n0.a b = new n0.a();
    final List<CameraDevice.StateCallback> c = new ArrayList();
    final List<CameraCaptureSession.StateCallback> d = new ArrayList();
    final List<g2.c> e = new ArrayList();
    final List<k> f = new ArrayList();
    InputConfiguration g;
  }
  
  public static class b
    extends g2.a
  {
    public static b p(t2<?> paramt2)
    {
      Object localObject = paramt2.H(null);
      if (localObject != null)
      {
        b localb = new b();
        ((g2.d)localObject).a(paramt2, localb);
        return localb;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Implementation is missing option unpacker for ");
      ((StringBuilder)localObject).append(paramt2.B(paramt2.toString()));
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    public b a(Collection<CameraDevice.StateCallback> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        e((CameraDevice.StateCallback)paramCollection.next());
      }
      return this;
    }
    
    public b b(Collection<k> paramCollection)
    {
      this.b.a(paramCollection);
      return this;
    }
    
    public b c(List<CameraCaptureSession.StateCallback> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        k((CameraCaptureSession.StateCallback)paramList.next());
      }
      return this;
    }
    
    public b d(k paramk)
    {
      this.b.c(paramk);
      if (!this.f.contains(paramk)) {
        this.f.add(paramk);
      }
      return this;
    }
    
    public b e(CameraDevice.StateCallback paramStateCallback)
    {
      if (this.c.contains(paramStateCallback)) {
        return this;
      }
      this.c.add(paramStateCallback);
      return this;
    }
    
    public b f(g2.c paramc)
    {
      this.e.add(paramc);
      return this;
    }
    
    public b g(s0 params0)
    {
      this.b.e(params0);
      return this;
    }
    
    public b h(v0 paramv0)
    {
      paramv0 = g2.e.a(paramv0).a();
      this.a.add(paramv0);
      return this;
    }
    
    public b i(g2.e parame)
    {
      this.a.add(parame);
      this.b.f(parame.d());
      parame = parame.c().iterator();
      while (parame.hasNext())
      {
        v0 localv0 = (v0)parame.next();
        this.b.f(localv0);
      }
      return this;
    }
    
    public b j(k paramk)
    {
      this.b.c(paramk);
      return this;
    }
    
    public b k(CameraCaptureSession.StateCallback paramStateCallback)
    {
      if (this.d.contains(paramStateCallback)) {
        return this;
      }
      this.d.add(paramStateCallback);
      return this;
    }
    
    public b l(v0 paramv0)
    {
      g2.e locale = g2.e.a(paramv0).a();
      this.a.add(locale);
      this.b.f(paramv0);
      return this;
    }
    
    public b m(String paramString, Object paramObject)
    {
      this.b.g(paramString, paramObject);
      return this;
    }
    
    public g2 n()
    {
      return new g2(new ArrayList(this.a), this.c, this.d, this.f, this.e, this.b.h(), this.g);
    }
    
    public b o()
    {
      this.a.clear();
      this.b.i();
      return this;
    }
    
    public List<k> q()
    {
      return Collections.unmodifiableList(this.f);
    }
    
    public b r(s0 params0)
    {
      this.b.o(params0);
      return this;
    }
    
    public b s(InputConfiguration paramInputConfiguration)
    {
      this.g = paramInputConfiguration;
      return this;
    }
    
    public b t(int paramInt)
    {
      this.b.p(paramInt);
      return this;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(g2 paramg2, g2.f paramf);
  }
  
  public static abstract interface d
  {
    public abstract void a(t2<?> paramt2, g2.b paramb);
  }
  
  public static abstract class e
  {
    public static a a(v0 paramv0)
    {
      return new g.b().e(paramv0).c(Collections.emptyList()).b(null).d(-1);
    }
    
    public abstract String b();
    
    public abstract List<v0> c();
    
    public abstract v0 d();
    
    public abstract int e();
    
    public static abstract class a
    {
      public abstract g2.e a();
      
      public abstract a b(String paramString);
      
      public abstract a c(List<v0> paramList);
      
      public abstract a d(int paramInt);
    }
  }
  
  public static enum f
  {
    static
    {
      f localf1 = new f("SESSION_ERROR_SURFACE_NEEDS_RESET", 0);
      a = localf1;
      f localf2 = new f("SESSION_ERROR_UNKNOWN", 1);
      b = localf2;
      c = new f[] { localf1, localf2 };
    }
    
    private f() {}
  }
  
  public static final class g
    extends g2.a
  {
    private static final List<Integer> k = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(3) });
    private final c h = new c();
    private boolean i = true;
    private boolean j = false;
    
    private List<v0> d()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (g2.e)localIterator.next();
        localArrayList.add(((g2.e)localObject).d());
        localObject = ((g2.e)localObject).c().iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((v0)((Iterator)localObject).next());
        }
      }
      return localArrayList;
    }
    
    private int f(int paramInt1, int paramInt2)
    {
      List localList = k;
      if (localList.indexOf(Integer.valueOf(paramInt1)) >= localList.indexOf(Integer.valueOf(paramInt2))) {
        return paramInt1;
      }
      return paramInt2;
    }
    
    public void a(g2 paramg2)
    {
      n0 localn0 = paramg2.h();
      if (localn0.g() != -1)
      {
        this.j = true;
        this.b.p(f(localn0.g(), this.b.m()));
      }
      n2 localn2 = paramg2.h().f();
      this.b.b(localn2);
      this.c.addAll(paramg2.b());
      this.d.addAll(paramg2.i());
      this.b.a(paramg2.g());
      this.f.addAll(paramg2.j());
      this.e.addAll(paramg2.c());
      if (paramg2.e() != null) {
        this.g = paramg2.e();
      }
      this.a.addAll(paramg2.f());
      this.b.l().addAll(localn0.e());
      if (!d().containsAll(this.b.l()))
      {
        n1.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
        this.i = false;
      }
      this.b.e(localn0.d());
    }
    
    public g2 b()
    {
      if (this.i)
      {
        ArrayList localArrayList = new ArrayList(this.a);
        this.h.d(localArrayList);
        return new g2(localArrayList, this.c, this.d, this.f, this.e, this.b.h(), this.g);
      }
      throw new IllegalArgumentException("Unsupported session configuration combination");
    }
    
    public void c()
    {
      this.a.clear();
      this.b.i();
    }
    
    public boolean e()
    {
      return (this.j) && (this.i);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.g2
 * JD-Core Version:    0.7.0.1
 */