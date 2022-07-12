package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import n.b;
import n.d;
import n.g;

final class y2
  extends l2.a
{
  private final List<l2.a> a;
  
  y2(List<l2.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    localArrayList.addAll(paramList);
  }
  
  static l2.a v(l2.a... paramVarArgs)
  {
    return new y2(Arrays.asList(paramVarArgs));
  }
  
  public void n(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).n(paraml2);
    }
  }
  
  public void o(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).o(paraml2);
    }
  }
  
  public void p(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).p(paraml2);
    }
  }
  
  public void q(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).q(paraml2);
    }
  }
  
  public void r(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).r(paraml2);
    }
  }
  
  public void s(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).s(paraml2);
    }
  }
  
  void t(l2 paraml2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).t(paraml2);
    }
  }
  
  public void u(l2 paraml2, Surface paramSurface)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l2.a)localIterator.next()).u(paraml2, paramSurface);
    }
  }
  
  static class a
    extends l2.a
  {
    private final CameraCaptureSession.StateCallback a;
    
    a(CameraCaptureSession.StateCallback paramStateCallback)
    {
      this.a = paramStateCallback;
    }
    
    a(List<CameraCaptureSession.StateCallback> paramList)
    {
      this(h1.a(paramList));
    }
    
    public void n(l2 paraml2)
    {
      this.a.onActive(paraml2.j().c());
    }
    
    public void o(l2 paraml2)
    {
      d.b(this.a, paraml2.j().c());
    }
    
    public void p(l2 paraml2)
    {
      this.a.onClosed(paraml2.j().c());
    }
    
    public void q(l2 paraml2)
    {
      this.a.onConfigureFailed(paraml2.j().c());
    }
    
    public void r(l2 paraml2)
    {
      this.a.onConfigured(paraml2.j().c());
    }
    
    public void s(l2 paraml2)
    {
      this.a.onReady(paraml2.j().c());
    }
    
    void t(l2 paraml2) {}
    
    public void u(l2 paraml2, Surface paramSurface)
    {
      b.a(this.a, paraml2.j().c(), paramSurface);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.y2
 * JD-Core Version:    0.7.0.1
 */