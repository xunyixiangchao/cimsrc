package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import d2.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import t2.a;
import t2.h;

public class e
  extends ContextWrapper
{
  static final l<?, ?> k = new b();
  private final e2.b a;
  private final i b;
  private final u2.f c;
  private final c.a d;
  private final List<h<Object>> e;
  private final Map<Class<?>, l<?, ?>> f;
  private final k g;
  private final f h;
  private final int i;
  private t2.i j;
  
  public e(Context paramContext, e2.b paramb, i parami, u2.f paramf, c.a parama, Map<Class<?>, l<?, ?>> paramMap, List<h<Object>> paramList, k paramk, f paramf1, int paramInt)
  {
    super(paramContext.getApplicationContext());
    this.a = paramb;
    this.b = parami;
    this.c = paramf;
    this.d = parama;
    this.e = paramList;
    this.f = paramMap;
    this.g = paramk;
    this.h = paramf1;
    this.i = paramInt;
  }
  
  public <X> u2.i<ImageView, X> a(ImageView paramImageView, Class<X> paramClass)
  {
    return this.c.a(paramImageView, paramClass);
  }
  
  public e2.b b()
  {
    return this.a;
  }
  
  public List<h<Object>> c()
  {
    return this.e;
  }
  
  public t2.i d()
  {
    try
    {
      if (this.j == null) {
        this.j = ((t2.i)this.d.build().R());
      }
      t2.i locali = this.j;
      return locali;
    }
    finally {}
  }
  
  public <T> l<?, T> e(Class<T> paramClass)
  {
    l locall = (l)this.f.get(paramClass);
    Object localObject = locall;
    if (locall == null)
    {
      Iterator localIterator = this.f.entrySet().iterator();
      for (;;)
      {
        localObject = locall;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass)) {
          locall = (l)((Map.Entry)localObject).getValue();
        }
      }
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null) {
      paramClass = k;
    }
    return paramClass;
  }
  
  public k f()
  {
    return this.g;
  }
  
  public f g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public i i()
  {
    return this.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.e
 * JD-Core Version:    0.7.0.1
 */