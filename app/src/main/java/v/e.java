package v;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.i3;
import androidx.camera.core.k;
import androidx.camera.core.m;
import androidx.camera.core.n1;
import androidx.camera.core.r;
import androidx.camera.core.v2;
import androidx.camera.core.w1;
import androidx.camera.core.w1.b;
import androidx.camera.core.z0;
import androidx.camera.core.z0.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import s.a;
import s.a0;
import s.b0;
import s.c0;
import s.e0;
import s.g0;
import s.s0;
import s.t2;
import s.u2;
import s.w;
import x0.h;

public final class e
  implements k
{
  private g0 a;
  private final LinkedHashSet<g0> b;
  private final c0 c;
  private final u2 d;
  private final b e;
  private final List<v2> f = new ArrayList();
  private i3 g;
  private w h = a0.a();
  private final Object i = new Object();
  private boolean j = true;
  private s0 k = null;
  private List<v2> l = new ArrayList();
  
  public e(LinkedHashSet<g0> paramLinkedHashSet, c0 paramc0, u2 paramu2)
  {
    this.a = ((g0)paramLinkedHashSet.iterator().next());
    paramLinkedHashSet = new LinkedHashSet(paramLinkedHashSet);
    this.b = paramLinkedHashSet;
    this.e = new b(paramLinkedHashSet);
    this.c = paramc0;
    this.d = paramu2;
  }
  
  private boolean A()
  {
    for (;;)
    {
      synchronized (this.i)
      {
        int m = this.h.E();
        bool = true;
        if (m == 1) {
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private boolean B(List<v2> paramList)
  {
    paramList = paramList.iterator();
    boolean bool2 = false;
    int n = 0;
    int m = n;
    while (paramList.hasNext())
    {
      v2 localv2 = (v2)paramList.next();
      if (E(localv2)) {
        n = 1;
      } else if (D(localv2)) {
        m = 1;
      }
    }
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (m == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean C(List<v2> paramList)
  {
    paramList = paramList.iterator();
    boolean bool2 = false;
    int n = 0;
    int m = n;
    while (paramList.hasNext())
    {
      v2 localv2 = (v2)paramList.next();
      if (E(localv2)) {
        m = 1;
      } else if (D(localv2)) {
        n = 1;
      }
    }
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (m == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean D(v2 paramv2)
  {
    return paramv2 instanceof z0;
  }
  
  private boolean E(v2 paramv2)
  {
    return paramv2 instanceof w1;
  }
  
  private void I()
  {
    synchronized (this.i)
    {
      if (this.k != null) {
        this.a.m().e(this.k);
      }
      return;
    }
  }
  
  private void K(Map<v2, Size> paramMap, Collection<v2> paramCollection)
  {
    for (;;)
    {
      synchronized (this.i)
      {
        if (this.g != null)
        {
          if (this.a.i().a().intValue() != 0) {
            break label200;
          }
          bool = true;
          Map localMap = n.a(this.a.m().f(), bool, this.g.a(), this.a.i().e(this.g.c()), this.g.d(), this.g.b(), paramMap);
          paramCollection = paramCollection.iterator();
          if (paramCollection.hasNext())
          {
            v2 localv2 = (v2)paramCollection.next();
            localv2.H((Rect)h.g((Rect)localMap.get(localv2)));
            localv2.G(q(this.a.m().f(), (Size)paramMap.get(localv2)));
            continue;
          }
        }
        return;
      }
      label200:
      boolean bool = false;
    }
  }
  
  private void o()
  {
    synchronized (this.i)
    {
      b0 localb0 = this.a.m();
      this.k = localb0.b();
      localb0.d();
      return;
    }
  }
  
  private List<v2> p(List<v2> paramList1, List<v2> paramList2)
  {
    ArrayList localArrayList = new ArrayList(paramList2);
    boolean bool1 = C(paramList1);
    boolean bool2 = B(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList2 = null;
    paramList1 = null;
    while (localIterator.hasNext())
    {
      v2 localv2 = (v2)localIterator.next();
      if (E(localv2)) {
        paramList2 = localv2;
      } else if (D(localv2)) {
        paramList1 = localv2;
      }
    }
    if ((bool1) && (paramList2 == null)) {
      localArrayList.add(t());
    } else if ((!bool1) && (paramList2 != null)) {
      localArrayList.remove(paramList2);
    }
    if ((bool2) && (paramList1 == null))
    {
      localArrayList.add(s());
      return localArrayList;
    }
    if ((!bool2) && (paramList1 != null)) {
      localArrayList.remove(paramList1);
    }
    return localArrayList;
  }
  
  private static Matrix q(Rect paramRect, Size paramSize)
  {
    boolean bool;
    if ((paramRect.width() > 0) && (paramRect.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    h.b(bool, "Cannot compute viewport crop rects zero sized sensor rect.");
    paramRect = new RectF(paramRect);
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramSize.getWidth(), paramSize.getHeight()), paramRect, Matrix.ScaleToFit.CENTER);
    localMatrix.invert(localMatrix);
    return localMatrix;
  }
  
  private Map<v2, Size> r(e0 parame0, List<v2> paramList1, List<v2> paramList2, Map<v2, c> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    String str = parame0.c();
    HashMap localHashMap = new HashMap();
    paramList2 = paramList2.iterator();
    v2 localv2;
    while (paramList2.hasNext())
    {
      localv2 = (v2)paramList2.next();
      localArrayList.add(a.a(this.c.a(str, localv2.i(), localv2.c()), localv2.i(), localv2.c(), localv2.g().j(null)));
      localHashMap.put(localv2, localv2.c());
    }
    if (!paramList1.isEmpty())
    {
      paramList2 = new HashMap();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localv2 = (v2)paramList1.next();
        c localc = (c)paramMap.get(localv2);
        paramList2.put(localv2.q(parame0, localc.a, localc.b), localv2);
      }
      parame0 = this.c.b(str, localArrayList, new ArrayList(paramList2.keySet()));
      paramList1 = paramList2.entrySet().iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (Map.Entry)paramList1.next();
        localHashMap.put((v2)paramList2.getValue(), (Size)parame0.get(paramList2.getKey()));
      }
    }
    return localHashMap;
  }
  
  private z0 s()
  {
    return new z0.i().n("ImageCapture-Extra").c();
  }
  
  private w1 t()
  {
    w1 localw1 = new w1.b().m("Preview-Extra").c();
    localw1.S(c.a);
    return localw1;
  }
  
  private void u(List<v2> paramList)
  {
    synchronized (this.i)
    {
      if (!paramList.isEmpty())
      {
        this.a.g(paramList);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          v2 localv2 = (v2)localIterator.next();
          if (this.f.contains(localv2))
          {
            localv2.z(this.a);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Attempting to detach non-attached UseCase: ");
            localStringBuilder.append(localv2);
            n1.c("CameraUseCaseAdapter", localStringBuilder.toString());
          }
        }
        this.f.removeAll(paramList);
      }
      return;
    }
  }
  
  public static b w(LinkedHashSet<g0> paramLinkedHashSet)
  {
    return new b(paramLinkedHashSet);
  }
  
  private Map<v2, c> y(List<v2> paramList, u2 paramu21, u2 paramu22)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      v2 localv2 = (v2)paramList.next();
      localHashMap.put(localv2, new c(localv2.h(false, paramu21), localv2.h(true, paramu22)));
    }
    return localHashMap;
  }
  
  public void H(Collection<v2> paramCollection)
  {
    synchronized (this.i)
    {
      u(new ArrayList(paramCollection));
      if (A()) {
        this.l.removeAll(paramCollection);
      }
      try
      {
        j(Collections.emptyList());
      }
      catch (a paramCollection)
      {
        label47:
        break label47;
      }
      throw new IllegalArgumentException("Failed to add extra fake Preview or ImageCapture use case!");
      return;
    }
  }
  
  public void J(i3 parami3)
  {
    synchronized (this.i)
    {
      this.g = parami3;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public m c()
  {
    return this.a.m();
  }
  
  public r e()
  {
    return this.a.i();
  }
  
  public void h(w paramw)
  {
    Object localObject = this.i;
    w localw = paramw;
    if (paramw == null) {}
    try
    {
      localw = a0.a();
      if ((!this.f.isEmpty()) && (!this.h.s().equals(localw.s()))) {
        throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
      }
      this.h = localw;
      this.a.h(localw);
      return;
    }
    finally {}
  }
  
  public void j(Collection<v2> paramCollection)
  {
    synchronized (this.i)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramCollection.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (v2)((Iterator)localObject1).next();
        if (this.f.contains(localObject2)) {
          n1.a("CameraUseCaseAdapter", "Attempting to attach already attached UseCase");
        } else {
          localArrayList.add(localObject2);
        }
      }
      Object localObject4 = new ArrayList(this.f);
      localObject1 = Collections.emptyList();
      Object localObject2 = Collections.emptyList();
      if (A())
      {
        ((List)localObject4).removeAll(this.l);
        ((List)localObject4).addAll(localArrayList);
        localObject1 = p((List)localObject4, new ArrayList(this.l));
        localObject2 = new ArrayList((Collection)localObject1);
        ((List)localObject2).removeAll(this.l);
        localArrayList.addAll((Collection)localObject2);
        localObject2 = new ArrayList(this.l);
        ((List)localObject2).removeAll((Collection)localObject1);
      }
      localObject4 = y(localArrayList, this.h.h(), this.d);
      try
      {
        Object localObject5 = new ArrayList(this.f);
        ((List)localObject5).removeAll((Collection)localObject2);
        localObject5 = r(this.a.i(), localArrayList, (List)localObject5, (Map)localObject4);
        K((Map)localObject5, paramCollection);
        this.l = ((List)localObject1);
        u((List)localObject2);
        paramCollection = localArrayList.iterator();
        while (paramCollection.hasNext())
        {
          localObject1 = (v2)paramCollection.next();
          localObject2 = (c)((Map)localObject4).get(localObject1);
          ((v2)localObject1).w(this.a, ((c)localObject2).a, ((c)localObject2).b);
          ((v2)localObject1).J((Size)h.g((Size)((Map)localObject5).get(localObject1)));
        }
        this.f.addAll(localArrayList);
        if (this.j) {
          this.a.f(localArrayList);
        }
        paramCollection = localArrayList.iterator();
        while (paramCollection.hasNext()) {
          ((v2)paramCollection.next()).u();
        }
        return;
      }
      catch (IllegalArgumentException paramCollection)
      {
        throw new a(paramCollection.getMessage());
      }
    }
  }
  
  public void k()
  {
    synchronized (this.i)
    {
      if (!this.j)
      {
        this.a.f(this.f);
        I();
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((v2)localIterator.next()).u();
        }
        this.j = true;
      }
      return;
    }
  }
  
  public void v()
  {
    synchronized (this.i)
    {
      if (this.j)
      {
        this.a.g(new ArrayList(this.f));
        o();
        this.j = false;
      }
      return;
    }
  }
  
  public b x()
  {
    return this.e;
  }
  
  public List<v2> z()
  {
    synchronized (this.i)
    {
      ArrayList localArrayList = new ArrayList(this.f);
      return localArrayList;
    }
  }
  
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static final class b
  {
    private final List<String> a = new ArrayList();
    
    b(LinkedHashSet<g0> paramLinkedHashSet)
    {
      paramLinkedHashSet = paramLinkedHashSet.iterator();
      while (paramLinkedHashSet.hasNext())
      {
        g0 localg0 = (g0)paramLinkedHashSet.next();
        this.a.add(localg0.i().c());
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b)) {
        return this.a.equals(((b)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() * 53;
    }
  }
  
  private static class c
  {
    t2<?> a;
    t2<?> b;
    
    c(t2<?> paramt21, t2<?> paramt22)
    {
      this.a = paramt21;
      this.b = paramt22;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v.e
 * JD-Core Version:    0.7.0.1
 */