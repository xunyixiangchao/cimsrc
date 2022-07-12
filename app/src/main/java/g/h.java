package g;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.e0;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  final ArrayList<c0> a = new ArrayList();
  private long b = -1L;
  private Interpolator c;
  d0 d;
  private boolean e;
  private final e0 f = new a();
  
  public void a()
  {
    if (!this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((c0)localIterator.next()).b();
    }
    this.e = false;
  }
  
  void b()
  {
    this.e = false;
  }
  
  public h c(c0 paramc0)
  {
    if (!this.e) {
      this.a.add(paramc0);
    }
    return this;
  }
  
  public h d(c0 paramc01, c0 paramc02)
  {
    this.a.add(paramc01);
    paramc02.h(paramc01.c());
    this.a.add(paramc02);
    return this;
  }
  
  public h e(long paramLong)
  {
    if (!this.e) {
      this.b = paramLong;
    }
    return this;
  }
  
  public h f(Interpolator paramInterpolator)
  {
    if (!this.e) {
      this.c = paramInterpolator;
    }
    return this;
  }
  
  public h g(d0 paramd0)
  {
    if (!this.e) {
      this.d = paramd0;
    }
    return this;
  }
  
  public void h()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      c0 localc0 = (c0)localIterator.next();
      long l = this.b;
      if (l >= 0L) {
        localc0.d(l);
      }
      Interpolator localInterpolator = this.c;
      if (localInterpolator != null) {
        localc0.e(localInterpolator);
      }
      if (this.d != null) {
        localc0.f(this.f);
      }
      localc0.j();
    }
    this.e = true;
  }
  
  class a
    extends e0
  {
    private boolean a = false;
    private int b = 0;
    
    a() {}
    
    public void b(View paramView)
    {
      int i = this.b + 1;
      this.b = i;
      if (i == h.this.a.size())
      {
        paramView = h.this.d;
        if (paramView != null) {
          paramView.b(null);
        }
        d();
      }
    }
    
    public void c(View paramView)
    {
      if (this.a) {
        return;
      }
      this.a = true;
      paramView = h.this.d;
      if (paramView != null) {
        paramView.c(null);
      }
    }
    
    void d()
    {
      this.b = 0;
      this.a = false;
      h.this.b();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.h
 * JD-Core Version:    0.7.0.1
 */