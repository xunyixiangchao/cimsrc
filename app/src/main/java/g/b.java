package g;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b
{
  private Object a;
  private boolean b;
  
  public abstract void c();
  
  public abstract View d();
  
  public abstract Menu e();
  
  public abstract MenuInflater f();
  
  public abstract CharSequence g();
  
  public Object h()
  {
    return this.a;
  }
  
  public abstract CharSequence i();
  
  public boolean j()
  {
    return this.b;
  }
  
  public abstract void k();
  
  public abstract boolean l();
  
  public abstract void m(View paramView);
  
  public abstract void n(int paramInt);
  
  public abstract void o(CharSequence paramCharSequence);
  
  public void p(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public abstract void q(int paramInt);
  
  public abstract void r(CharSequence paramCharSequence);
  
  public void s(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(b paramb, Menu paramMenu);
    
    public abstract boolean b(b paramb, Menu paramMenu);
    
    public abstract boolean c(b paramb, MenuItem paramMenuItem);
    
    public abstract void d(b paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.b
 * JD-Core Version:    0.7.0.1
 */