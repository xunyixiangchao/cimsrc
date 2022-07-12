package com.bumptech.glide;

import b2.j;
import b2.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e.a;
import d2.t;
import d2.v;
import h2.n;
import h2.o;
import h2.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s2.b;
import s2.c;

public class i
{
  private final p a;
  private final s2.a b;
  private final s2.e c;
  private final s2.f d;
  private final com.bumptech.glide.load.data.f e;
  private final p2.f f;
  private final b g;
  private final s2.d h = new s2.d();
  private final c i = new c();
  private final x0.e<List<Throwable>> j;
  
  public i()
  {
    x0.e locale = y2.a.e();
    this.j = locale;
    this.a = new p(locale);
    this.b = new s2.a();
    this.c = new s2.e();
    this.d = new s2.f();
    this.e = new com.bumptech.glide.load.data.f();
    this.f = new p2.f();
    this.g = new b();
    s(Arrays.asList(new String[] { "Animation", "Bitmap", "BitmapDrawable" }));
  }
  
  private <Data, TResource, Transcode> List<d2.i<Data, TResource, Transcode>> f(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass1 = this.c.d(paramClass, paramClass1).iterator();
    while (paramClass1.hasNext())
    {
      Class localClass1 = (Class)paramClass1.next();
      Iterator localIterator = this.f.b(localClass1, paramClass2).iterator();
      while (localIterator.hasNext())
      {
        Class localClass2 = (Class)localIterator.next();
        localArrayList.add(new d2.i(paramClass, localClass1, localClass2, this.c.b(paramClass, localClass1), this.f.a(localClass1, localClass2), this.j));
      }
    }
    return localArrayList;
  }
  
  public <Data> i a(Class<Data> paramClass, b2.d<Data> paramd)
  {
    this.b.a(paramClass, paramd);
    return this;
  }
  
  public <TResource> i b(Class<TResource> paramClass, k<TResource> paramk)
  {
    this.d.a(paramClass, paramk);
    return this;
  }
  
  public <Data, TResource> i c(Class<Data> paramClass, Class<TResource> paramClass1, j<Data, TResource> paramj)
  {
    e("legacy_append", paramClass, paramClass1, paramj);
    return this;
  }
  
  public <Model, Data> i d(Class<Model> paramClass, Class<Data> paramClass1, o<Model, Data> paramo)
  {
    this.a.a(paramClass, paramClass1, paramo);
    return this;
  }
  
  public <Data, TResource> i e(String paramString, Class<Data> paramClass, Class<TResource> paramClass1, j<Data, TResource> paramj)
  {
    this.c.a(paramString, paramj, paramClass, paramClass1);
    return this;
  }
  
  public List<ImageHeaderParser> g()
  {
    List localList = this.g.b();
    if (!localList.isEmpty()) {
      return localList;
    }
    throw new b();
  }
  
  public <Data, TResource, Transcode> t<Data, TResource, Transcode> h(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    t localt = this.i.a(paramClass, paramClass1, paramClass2);
    if (this.i.c(localt)) {
      return null;
    }
    Object localObject = localt;
    if (localt == null)
    {
      localObject = f(paramClass, paramClass1, paramClass2);
      if (((List)localObject).isEmpty()) {
        localObject = null;
      } else {
        localObject = new t(paramClass, paramClass1, paramClass2, (List)localObject, this.j);
      }
      this.i.d(paramClass, paramClass1, paramClass2, (t)localObject);
    }
    return localObject;
  }
  
  public <Model> List<n<Model, ?>> i(Model paramModel)
  {
    return this.a.d(paramModel);
  }
  
  public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    Object localObject2 = this.h.a(paramClass, paramClass1, paramClass2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.a.c(paramClass).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Class)((Iterator)localObject2).next();
        localObject3 = this.c.d((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.f.b(localClass, paramClass2).isEmpty()) && (!((List)localObject1).contains(localClass))) {
            ((List)localObject1).add(localClass);
          }
        }
      }
      this.h.b(paramClass, paramClass1, paramClass2, Collections.unmodifiableList((List)localObject1));
    }
    return localObject1;
  }
  
  public <X> k<X> k(v<X> paramv)
  {
    k localk = this.d.b(paramv.d());
    if (localk != null) {
      return localk;
    }
    throw new d(paramv.d());
  }
  
  public <X> com.bumptech.glide.load.data.e<X> l(X paramX)
  {
    return this.e.a(paramX);
  }
  
  public <X> b2.d<X> m(X paramX)
  {
    b2.d locald = this.b.b(paramX.getClass());
    if (locald != null) {
      return locald;
    }
    throw new e(paramX.getClass());
  }
  
  public boolean n(v<?> paramv)
  {
    return this.d.b(paramv.d()) != null;
  }
  
  public i o(ImageHeaderParser paramImageHeaderParser)
  {
    this.g.a(paramImageHeaderParser);
    return this;
  }
  
  public i p(e.a<?> parama)
  {
    this.e.b(parama);
    return this;
  }
  
  public <TResource, Transcode> i q(Class<TResource> paramClass, Class<Transcode> paramClass1, p2.e<TResource, Transcode> parame)
  {
    this.f.c(paramClass, paramClass1, parame);
    return this;
  }
  
  public <Model, Data> i r(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    this.a.f(paramClass, paramClass1, paramo);
    return this;
  }
  
  public final i s(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.add("legacy_prepend_all");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((String)paramList.next());
    }
    localArrayList.add("legacy_append");
    this.c.e(localArrayList);
    return this;
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static final class b
    extends i.a
  {
    public b()
    {
      super();
    }
  }
  
  public static class c
    extends i.a
  {
    public c(Class<?> paramClass1, Class<?> paramClass2)
    {
      super();
    }
    
    public c(Object paramObject)
    {
      super();
    }
    
    public <M> c(M paramM, List<n<M, ?>> paramList)
    {
      super();
    }
  }
  
  public static class d
    extends i.a
  {
    public d(Class<?> paramClass)
    {
      super();
    }
  }
  
  public static class e
    extends i.a
  {
    public e(Class<?> paramClass)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.i
 * JD-Core Version:    0.7.0.1
 */