package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R.dimen;
import androidx.core.view.x;

public class i
{
  private final Context a;
  private final e b;
  private final boolean c;
  private final int d;
  private final int e;
  private View f;
  private int g = 8388611;
  private boolean h;
  private j.a i;
  private h j;
  private PopupWindow.OnDismissListener k;
  private final PopupWindow.OnDismissListener l = new a();
  
  public i(Context paramContext, e parame, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, parame, paramView, paramBoolean, paramInt, 0);
  }
  
  public i(Context paramContext, e parame, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.b = parame;
    this.f = paramView;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private h a()
  {
    Object localObject = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    ((Display)localObject).getRealSize(localPoint);
    int m;
    if (Math.min(localPoint.x, localPoint.y) >= this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      localObject = new b(this.a, this.f, this.d, this.e, this.c);
    } else {
      localObject = new l(this.a, this.b, this.f, this.d, this.e, this.c);
    }
    ((h)localObject).n(this.b);
    ((h)localObject).w(this.l);
    ((h)localObject).r(this.f);
    ((j)localObject).m(this.i);
    ((h)localObject).t(this.h);
    ((h)localObject).u(this.g);
    return localObject;
  }
  
  private void l(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = c();
    localh.x(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((androidx.core.view.e.b(this.g, x.B(this.f)) & 0x7) == 5) {
        m = paramInt1 - this.f.getWidth();
      }
      localh.v(m);
      localh.y(paramInt2);
      paramInt1 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localh.s(new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1));
    }
    localh.a();
  }
  
  public void b()
  {
    if (d()) {
      this.j.dismiss();
    }
  }
  
  public h c()
  {
    if (this.j == null) {
      this.j = a();
    }
    return this.j;
  }
  
  public boolean d()
  {
    h localh = this.j;
    return (localh != null) && (localh.c());
  }
  
  protected void e()
  {
    this.j = null;
    PopupWindow.OnDismissListener localOnDismissListener = this.k;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public void f(View paramView)
  {
    this.f = paramView;
  }
  
  public void g(boolean paramBoolean)
  {
    this.h = paramBoolean;
    h localh = this.j;
    if (localh != null) {
      localh.t(paramBoolean);
    }
  }
  
  public void h(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void i(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.k = paramOnDismissListener;
  }
  
  public void j(j.a parama)
  {
    this.i = parama;
    h localh = this.j;
    if (localh != null) {
      localh.m(parama);
    }
  }
  
  public void k()
  {
    if (m()) {
      return;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean m()
  {
    if (d()) {
      return true;
    }
    if (this.f == null) {
      return false;
    }
    l(0, 0, false, false);
    return true;
  }
  
  public boolean n(int paramInt1, int paramInt2)
  {
    if (d()) {
      return true;
    }
    if (this.f == null) {
      return false;
    }
    l(paramInt1, paramInt2, true, true);
    return true;
  }
  
  class a
    implements PopupWindow.OnDismissListener
  {
    a() {}
    
    public void onDismiss()
    {
      i.this.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.i
 * JD-Core Version:    0.7.0.1
 */