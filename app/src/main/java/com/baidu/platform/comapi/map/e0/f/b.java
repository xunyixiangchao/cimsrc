package com.baidu.platform.comapi.map.e0.f;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.e0.a.a;
import com.baidu.platform.comapi.map.e0.a.d;
import com.baidu.platform.comapi.map.e0.e.b.a;
import java.util.Iterator;
import java.util.LinkedList;

public class b
  implements b.a
{
  private LinkedList<a.a> a = new LinkedList();
  private com.baidu.platform.comapi.map.e0.d b;
  private MapController c;
  private boolean d;
  private a e;
  private int f;
  
  public b(MapController paramMapController)
  {
    com.baidu.platform.comapi.map.e0.d locald = new com.baidu.platform.comapi.map.e0.d();
    this.b = locald;
    this.d = false;
    this.c = paramMapController;
    this.f = (locald.c / 3);
  }
  
  private boolean a()
  {
    this.d = true;
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject2 = Double.valueOf(a.d.a(com.baidu.platform.comapi.map.e0.a.a.c(), ((a.a)localObject2).c()));
      if ((Math.abs(((Double)localObject2).doubleValue()) > 45.0D) && (Math.abs(((Double)localObject2).doubleValue()) < 135.0D)) {
        return false;
      }
    }
    Object localObject2 = this.b.c();
    localObject1 = (a.d)((Pair)localObject2).first;
    localObject2 = (a.d)((Pair)localObject2).second;
    int i;
    if ((Math.abs(((a.d)localObject1).b) > this.f) && (Math.abs(((a.d)localObject2).b) > this.f)) {
      i = 1;
    } else {
      i = 0;
    }
    a.a locala1 = (a.a)this.a.getFirst();
    a.a locala3 = (a.a)this.a.getLast();
    a.a locala2 = new a.a(locala3.a, locala1.a);
    locala1 = new a.a(locala3.b, locala1.b);
    if ((((a.d)localObject1).b > 0.0D) && (((a.d)localObject2).b > 0.0D))
    {
      localObject1 = locala2.c();
      localObject2 = com.baidu.platform.comapi.map.e0.a.c;
    }
    else
    {
      localObject1 = locala2.c();
      localObject2 = com.baidu.platform.comapi.map.e0.a.b;
    }
    int j = (int)a.d.a((a.d)localObject1, ((a.a)localObject2).c());
    int k = (int)a.d.a(locala1.c(), ((a.a)localObject2).c());
    if ((Math.abs(j) < 40) && (Math.abs(k) < 40)) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
  
  private void d(com.baidu.platform.comapi.map.e0.e.b paramb)
  {
    if (this.c.isOverlookGestureEnable())
    {
      this.e.a(paramb, null);
      c localc = new c(this.c);
      this.e = localc;
      localc.a(paramb);
    }
  }
  
  private void e(com.baidu.platform.comapi.map.e0.e.b paramb)
  {
    if (this.a.size() < 5)
    {
      this.a.addLast(paramb.c);
      this.b.a(paramb.d);
      return;
    }
    if ((!this.d) && (this.a.size() == 5) && (a())) {
      d(paramb);
    }
  }
  
  public boolean a(com.baidu.platform.comapi.map.e0.e.b paramb)
  {
    Pair localPair = this.b.c();
    this.b.a();
    this.e.a(paramb, localPair);
    return true;
  }
  
  public boolean b(com.baidu.platform.comapi.map.e0.e.b paramb)
  {
    this.a.clear();
    this.b.b();
    this.e = new d(this.c);
    this.d = false;
    return true;
  }
  
  public boolean c(com.baidu.platform.comapi.map.e0.e.b paramb)
  {
    e(paramb);
    if (this.a.size() == 1) {
      this.e.a(paramb);
    }
    this.e.b(paramb);
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.f.b
 * JD-Core Version:    0.7.0.1
 */