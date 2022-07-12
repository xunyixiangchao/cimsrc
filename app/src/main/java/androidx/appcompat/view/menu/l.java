package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.y;
import androidx.core.view.x;

final class l
  extends h
  implements PopupWindow.OnDismissListener, View.OnKeyListener
{
  private static final int v = R.layout.abc_popup_menu_item_layout;
  private final Context b;
  private final e c;
  private final d d;
  private final boolean e;
  private final int f;
  private final int g;
  private final int h;
  final y i;
  final ViewTreeObserver.OnGlobalLayoutListener j = new a();
  private final View.OnAttachStateChangeListener k = new b();
  private PopupWindow.OnDismissListener l;
  private View m;
  View n;
  private j.a o;
  ViewTreeObserver p;
  private boolean q;
  private boolean r;
  private int s;
  private int t = 0;
  private boolean u;
  
  public l(Context paramContext, e parame, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = parame;
    this.e = paramBoolean;
    this.d = new d(parame, LayoutInflater.from(paramContext), paramBoolean, v);
    this.g = paramInt1;
    this.h = paramInt2;
    Resources localResources = paramContext.getResources();
    this.f = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.m = paramView;
    this.i = new y(paramContext, null, paramInt1, paramInt2);
    parame.c(this, paramContext);
  }
  
  private boolean B()
  {
    if (c()) {
      return true;
    }
    if (!this.q)
    {
      Object localObject1 = this.m;
      if (localObject1 == null) {
        return false;
      }
      this.n = ((View)localObject1);
      this.i.K(this);
      this.i.L(this);
      this.i.J(true);
      localObject1 = this.n;
      int i1;
      if (this.p == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      Object localObject2 = ((View)localObject1).getViewTreeObserver();
      this.p = ((ViewTreeObserver)localObject2);
      if (i1 != 0) {
        ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener(this.j);
      }
      ((View)localObject1).addOnAttachStateChangeListener(this.k);
      this.i.D((View)localObject1);
      this.i.G(this.t);
      if (!this.r)
      {
        this.s = h.q(this.d, null, this.b, this.f);
        this.r = true;
      }
      this.i.F(this.s);
      this.i.I(2);
      this.i.H(p());
      this.i.a();
      localObject1 = this.i.h();
      ((ListView)localObject1).setOnKeyListener(this);
      if ((this.u) && (this.c.z() != null))
      {
        localObject2 = (FrameLayout)LayoutInflater.from(this.b).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject1, false);
        TextView localTextView = (TextView)((FrameLayout)localObject2).findViewById(16908310);
        if (localTextView != null) {
          localTextView.setText(this.c.z());
        }
        ((FrameLayout)localObject2).setEnabled(false);
        ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
      }
      this.i.p(this.d);
      this.i.a();
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (B()) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    if (parame != this.c) {
      return;
    }
    dismiss();
    j.a locala = this.o;
    if (locala != null) {
      locala.b(parame, paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (!this.q) && (this.i.c());
  }
  
  public void dismiss()
  {
    if (c()) {
      this.i.dismiss();
    }
  }
  
  public void e(Parcelable paramParcelable) {}
  
  public boolean f(m paramm)
  {
    if (paramm.hasVisibleItems())
    {
      Object localObject = new i(this.b, paramm, this.n, this.e, this.g, this.h);
      ((i)localObject).j(this.o);
      ((i)localObject).g(h.z(paramm));
      ((i)localObject).i(this.l);
      this.l = null;
      this.c.e(false);
      int i2 = this.i.d();
      int i3 = this.i.n();
      int i1 = i2;
      if ((Gravity.getAbsoluteGravity(this.t, x.B(this.m)) & 0x7) == 5) {
        i1 = i2 + this.m.getWidth();
      }
      if (((i)localObject).n(i1, i3))
      {
        localObject = this.o;
        if (localObject != null) {
          ((j.a)localObject).c(paramm);
        }
        return true;
      }
    }
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    this.r = false;
    d locald = this.d;
    if (locald != null) {
      locald.notifyDataSetChanged();
    }
  }
  
  public ListView h()
  {
    return this.i.h();
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Parcelable j()
  {
    return null;
  }
  
  public void m(j.a parama)
  {
    this.o = parama;
  }
  
  public void n(e parame) {}
  
  public void onDismiss()
  {
    this.q = true;
    this.c.close();
    Object localObject = this.p;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.p = this.n.getViewTreeObserver();
      }
      this.p.removeGlobalOnLayoutListener(this.j);
      this.p = null;
    }
    this.n.removeOnAttachStateChangeListener(this.k);
    localObject = this.l;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void r(View paramView)
  {
    this.m = paramView;
  }
  
  public void t(boolean paramBoolean)
  {
    this.d.d(paramBoolean);
  }
  
  public void u(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void v(int paramInt)
  {
    this.i.l(paramInt);
  }
  
  public void w(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.l = paramOnDismissListener;
  }
  
  public void x(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void y(int paramInt)
  {
    this.i.j(paramInt);
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      if ((l.this.c()) && (!l.this.i.B()))
      {
        View localView = l.this.n;
        if ((localView != null) && (localView.isShown()))
        {
          l.this.i.a();
          return;
        }
        l.this.dismiss();
      }
    }
  }
  
  class b
    implements View.OnAttachStateChangeListener
  {
    b() {}
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      Object localObject = l.this.p;
      if (localObject != null)
      {
        if (!((ViewTreeObserver)localObject).isAlive()) {
          l.this.p = paramView.getViewTreeObserver();
        }
        localObject = l.this;
        ((l)localObject).p.removeGlobalOnLayoutListener(((l)localObject).j);
      }
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.l
 * JD-Core Version:    0.7.0.1
 */