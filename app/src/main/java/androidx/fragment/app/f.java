package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.a0;

public class f
{
  private final h<?> a;
  
  private f(h<?> paramh)
  {
    this.a = paramh;
  }
  
  public static f b(h<?> paramh)
  {
    return new f((h)x0.h.h(paramh, "callbacks == null"));
  }
  
  public void a(Fragment paramFragment)
  {
    h localh = this.a;
    localh.e.k(localh, localh, paramFragment);
  }
  
  public void c()
  {
    this.a.e.z();
  }
  
  public void d(Configuration paramConfiguration)
  {
    this.a.e.B(paramConfiguration);
  }
  
  public boolean e(MenuItem paramMenuItem)
  {
    return this.a.e.C(paramMenuItem);
  }
  
  public void f()
  {
    this.a.e.D();
  }
  
  public boolean g(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.a.e.E(paramMenu, paramMenuInflater);
  }
  
  public void h()
  {
    this.a.e.F();
  }
  
  public void i()
  {
    this.a.e.H();
  }
  
  public void j(boolean paramBoolean)
  {
    this.a.e.I(paramBoolean);
  }
  
  public boolean k(MenuItem paramMenuItem)
  {
    return this.a.e.K(paramMenuItem);
  }
  
  public void l(Menu paramMenu)
  {
    this.a.e.L(paramMenu);
  }
  
  public void m()
  {
    this.a.e.N();
  }
  
  public void n(boolean paramBoolean)
  {
    this.a.e.O(paramBoolean);
  }
  
  public boolean o(Menu paramMenu)
  {
    return this.a.e.P(paramMenu);
  }
  
  public void p()
  {
    this.a.e.R();
  }
  
  public void q()
  {
    this.a.e.S();
  }
  
  public void r()
  {
    this.a.e.U();
  }
  
  public boolean s()
  {
    return this.a.e.b0(true);
  }
  
  public FragmentManager t()
  {
    return this.a.e;
  }
  
  public void u()
  {
    this.a.e.U0();
  }
  
  public View v(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.e.v0().onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void w(Parcelable paramParcelable)
  {
    h localh = this.a;
    if ((localh instanceof a0))
    {
      localh.e.h1(paramParcelable);
      return;
    }
    throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
  }
  
  public Parcelable x()
  {
    return this.a.e.j1();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.f
 * JD-Core Version:    0.7.0.1
 */