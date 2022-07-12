package s;

import android.graphics.Rect;
import java.util.Collections;
import java.util.List;
import u.f;
import u7.a;

public abstract interface b0
  extends androidx.camera.core.m
{
  public static final b0 a = new a();
  
  public abstract void a(g2.b paramb);
  
  public abstract s0 b();
  
  public abstract a<List<Void>> c(List<n0> paramList, int paramInt1, int paramInt2);
  
  public abstract void d();
  
  public abstract void e(s0 params0);
  
  public abstract Rect f();
  
  public abstract void g(int paramInt);
  
  class a
    implements b0
  {
    public void a(g2.b paramb) {}
    
    public s0 b()
    {
      return null;
    }
    
    public a<List<Void>> c(List<n0> paramList, int paramInt1, int paramInt2)
    {
      return f.h(Collections.emptyList());
    }
    
    public void d() {}
    
    public void e(s0 params0) {}
    
    public Rect f()
    {
      return new Rect();
    }
    
    public void g(int paramInt) {}
    
    public a<Void> h(boolean paramBoolean)
    {
      return f.h(null);
    }
  }
  
  public static final class b
    extends Exception
  {
    private m a;
    
    public b(m paramm)
    {
      this.a = paramm;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void b(List<n0> paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.b0
 * JD-Core Version:    0.7.0.1
 */