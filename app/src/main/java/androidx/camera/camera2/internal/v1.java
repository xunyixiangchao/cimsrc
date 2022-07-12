package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

class v1
{
  final Executor a;
  final Object b = new Object();
  final Set<l2> c = new LinkedHashSet();
  final Set<l2> d = new LinkedHashSet();
  final Set<l2> e = new LinkedHashSet();
  private final CameraDevice.StateCallback f = new a();
  
  v1(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  private void a(l2 paraml2)
  {
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext())
    {
      l2 locall2 = (l2)localIterator.next();
      if (locall2 == paraml2) {
        return;
      }
      locall2.b();
    }
  }
  
  static void b(Set<l2> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      l2 locall2 = (l2)paramSet.next();
      locall2.a().p(locall2);
    }
  }
  
  CameraDevice.StateCallback c()
  {
    return this.f;
  }
  
  List<l2> d()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.c);
      return localArrayList;
    }
  }
  
  List<l2> e()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.d);
      return localArrayList;
    }
  }
  
  List<l2> f()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.e);
      return localArrayList;
    }
  }
  
  List<l2> g()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(d());
      localArrayList.addAll(f());
      return localArrayList;
    }
  }
  
  void h(l2 paraml2)
  {
    synchronized (this.b)
    {
      this.c.remove(paraml2);
      this.d.remove(paraml2);
      return;
    }
  }
  
  void i(l2 paraml2)
  {
    synchronized (this.b)
    {
      this.d.add(paraml2);
      return;
    }
  }
  
  void j(l2 paraml2)
  {
    a(paraml2);
    synchronized (this.b)
    {
      this.e.remove(paraml2);
      return;
    }
  }
  
  void k(l2 paraml2)
  {
    synchronized (this.b)
    {
      this.c.add(paraml2);
      this.e.remove(paraml2);
      a(paraml2);
      return;
    }
  }
  
  void l(l2 paraml2)
  {
    synchronized (this.b)
    {
      this.e.add(paraml2);
      return;
    }
  }
  
  class a
    extends CameraDevice.StateCallback
  {
    a() {}
    
    private void b()
    {
      synchronized (v1.this.b)
      {
        List localList = v1.this.g();
        v1.this.e.clear();
        v1.this.c.clear();
        v1.this.d.clear();
        ??? = localList.iterator();
        while (((Iterator)???).hasNext()) {
          ((l2)((Iterator)???).next()).b();
        }
        return;
      }
    }
    
    private void c()
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      synchronized (v1.this.b)
      {
        localLinkedHashSet.addAll(v1.this.e);
        localLinkedHashSet.addAll(v1.this.c);
        v1.this.a.execute(new u1(localLinkedHashSet));
        return;
      }
    }
    
    public void onClosed(CameraDevice paramCameraDevice)
    {
      b();
    }
    
    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      c();
      b();
    }
    
    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      c();
      b();
    }
    
    public void onOpened(CameraDevice paramCameraDevice) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.v1
 * JD-Core Version:    0.7.0.1
 */