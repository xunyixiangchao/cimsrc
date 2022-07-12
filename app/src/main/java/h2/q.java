package h2;

import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import x0.e;
import x2.k;

class q<Model, Data>
  implements n<Model, Data>
{
  private final List<n<Model, Data>> a;
  private final e<List<Throwable>> b;
  
  q(List<n<Model, Data>> paramList, e<List<Throwable>> parame)
  {
    this.a = paramList;
    this.b = parame;
  }
  
  public boolean a(Model paramModel)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((n)localIterator.next()).a(paramModel)) {
        return true;
      }
    }
    return false;
  }
  
  public n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, b2.h paramh)
  {
    int j = this.a.size();
    ArrayList localArrayList = new ArrayList(j);
    Object localObject3 = null;
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < j; localObject1 = localObject2)
    {
      Object localObject4 = (n)this.a.get(i);
      localObject2 = localObject1;
      if (((n)localObject4).a(paramModel))
      {
        localObject4 = ((n)localObject4).b(paramModel, paramInt1, paramInt2, paramh);
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = ((n.a)localObject4).a;
          localArrayList.add(((n.a)localObject4).c);
        }
      }
      i += 1;
    }
    paramModel = localObject3;
    if (!localArrayList.isEmpty())
    {
      paramModel = localObject3;
      if (localObject1 != null) {
        paramModel = new n.a(localObject1, new a(localArrayList, this.b));
      }
    }
    return paramModel;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiModelLoader{modelLoaders=");
    localStringBuilder.append(Arrays.toString(this.a.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  static class a<Data>
    implements d<Data>, d.a<Data>
  {
    private final List<d<Data>> a;
    private final e<List<Throwable>> b;
    private int c;
    private com.bumptech.glide.h d;
    private d.a<? super Data> e;
    private List<Throwable> f;
    private boolean g;
    
    a(List<d<Data>> paramList, e<List<Throwable>> parame)
    {
      this.b = parame;
      k.c(paramList);
      this.a = paramList;
      this.c = 0;
    }
    
    private void g()
    {
      if (this.g) {
        return;
      }
      if (this.c < this.a.size() - 1)
      {
        this.c += 1;
        f(this.d, this.e);
        return;
      }
      k.d(this.f);
      this.e.c(new d2.q("Fetch failed", new ArrayList(this.f)));
    }
    
    public Class<Data> a()
    {
      return ((d)this.a.get(0)).a();
    }
    
    public void b()
    {
      Object localObject = this.f;
      if (localObject != null) {
        this.b.a(localObject);
      }
      this.f = null;
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((d)((Iterator)localObject).next()).b();
      }
    }
    
    public void c(Exception paramException)
    {
      ((List)k.d(this.f)).add(paramException);
      g();
    }
    
    public void cancel()
    {
      this.g = true;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cancel();
      }
    }
    
    public void d(Data paramData)
    {
      if (paramData != null)
      {
        this.e.d(paramData);
        return;
      }
      g();
    }
    
    public a e()
    {
      return ((d)this.a.get(0)).e();
    }
    
    public void f(com.bumptech.glide.h paramh, d.a<? super Data> parama)
    {
      this.d = paramh;
      this.e = parama;
      this.f = ((List)this.b.b());
      ((d)this.a.get(this.c)).f(paramh, this);
      if (this.g) {
        cancel();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.q
 * JD-Core Version:    0.7.0.1
 */