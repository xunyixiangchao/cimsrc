package com.baidu.mapapi.map;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class b<T extends a>
{
  private final a a;
  private final int b;
  private List<T> c;
  private List<b<T>> d = null;
  
  private b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
  }
  
  public b(a parama)
  {
    this(parama, 0);
  }
  
  private b(a parama, int paramInt)
  {
    this.a = parama;
    this.b = paramInt;
  }
  
  private void a()
  {
    Object localObject1 = new ArrayList(4);
    this.d = ((List)localObject1);
    Object localObject2 = this.a;
    ((List)localObject1).add(new b(((a)localObject2).a, ((a)localObject2).e, ((a)localObject2).b, ((a)localObject2).f, this.b + 1));
    localObject1 = this.d;
    localObject2 = this.a;
    ((List)localObject1).add(new b(((a)localObject2).e, ((a)localObject2).c, ((a)localObject2).b, ((a)localObject2).f, this.b + 1));
    localObject1 = this.d;
    localObject2 = this.a;
    ((List)localObject1).add(new b(((a)localObject2).a, ((a)localObject2).e, ((a)localObject2).f, ((a)localObject2).d, this.b + 1));
    localObject1 = this.d;
    localObject2 = this.a;
    ((List)localObject1).add(new b(((a)localObject2).e, ((a)localObject2).c, ((a)localObject2).f, ((a)localObject2).d, this.b + 1));
    localObject1 = this.c;
    this.c = null;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      a(((a)localObject2).a().x, ((a)localObject2).a().y, (a)localObject2);
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, T paramT)
  {
    List localList = this.d;
    if (localList != null)
    {
      a locala = this.a;
      int i;
      if (paramDouble2 < locala.f)
      {
        if (paramDouble1 < locala.e) {
          i = 0;
        } else {
          i = 1;
        }
      }
      else if (paramDouble1 < locala.e) {
        i = 2;
      } else {
        i = 3;
      }
      ((b)localList.get(i)).a(paramDouble1, paramDouble2, paramT);
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramT);
    if ((this.c.size() > 40) && (this.b < 40)) {
      a();
    }
  }
  
  private void a(a parama, Collection<T> paramCollection)
  {
    if (!this.a.b(parama)) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(parama, paramCollection);
      }
    }
    if (this.c != null)
    {
      if (parama.a(this.a))
      {
        paramCollection.addAll(this.c);
        return;
      }
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if (parama.a(locala.a())) {
          paramCollection.add(locala);
        }
      }
    }
  }
  
  public Collection<T> a(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    a(parama, localArrayList);
    return localArrayList;
  }
  
  public void a(T paramT)
  {
    Point localPoint = paramT.a();
    if (this.a.a(localPoint.x, localPoint.y)) {
      a(localPoint.x, localPoint.y, paramT);
    }
  }
  
  static abstract class a
  {
    abstract Point a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.b
 * JD-Core Version:    0.7.0.1
 */