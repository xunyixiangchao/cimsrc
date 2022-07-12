package g;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class e
  extends b
  implements e.a
{
  private Context c;
  private ActionBarContextView d;
  private b.a e;
  private WeakReference<View> f;
  private boolean g;
  private boolean h;
  private androidx.appcompat.view.menu.e i;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.c = paramContext;
    this.d = paramActionBarContextView;
    this.e = parama;
    paramContext = new androidx.appcompat.view.menu.e(paramActionBarContextView.getContext()).W(1);
    this.i = paramContext;
    paramContext.V(this);
    this.h = paramBoolean;
  }
  
  public boolean a(androidx.appcompat.view.menu.e parame, MenuItem paramMenuItem)
  {
    return this.e.c(this, paramMenuItem);
  }
  
  public void b(androidx.appcompat.view.menu.e parame)
  {
    k();
    this.d.l();
  }
  
  public void c()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    this.e.d(this);
  }
  
  public View d()
  {
    WeakReference localWeakReference = this.f;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public Menu e()
  {
    return this.i;
  }
  
  public MenuInflater f()
  {
    return new g(this.d.getContext());
  }
  
  public CharSequence g()
  {
    return this.d.getSubtitle();
  }
  
  public CharSequence i()
  {
    return this.d.getTitle();
  }
  
  public void k()
  {
    this.e.a(this, this.i);
  }
  
  public boolean l()
  {
    return this.d.j();
  }
  
  public void m(View paramView)
  {
    this.d.setCustomView(paramView);
    if (paramView != null) {
      paramView = new WeakReference(paramView);
    } else {
      paramView = null;
    }
    this.f = paramView;
  }
  
  public void n(int paramInt)
  {
    o(this.c.getString(paramInt));
  }
  
  public void o(CharSequence paramCharSequence)
  {
    this.d.setSubtitle(paramCharSequence);
  }
  
  public void q(int paramInt)
  {
    r(this.c.getString(paramInt));
  }
  
  public void r(CharSequence paramCharSequence)
  {
    this.d.setTitle(paramCharSequence);
  }
  
  public void s(boolean paramBoolean)
  {
    super.s(paramBoolean);
    this.d.setTitleOptional(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.e
 * JD-Core Version:    0.7.0.1
 */