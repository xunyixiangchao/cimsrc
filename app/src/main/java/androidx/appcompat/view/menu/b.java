package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
  extends h
  implements View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int B = R.layout.abc_cascading_menu_item_layout;
  boolean A;
  private final Context b;
  private final int c;
  private final int d;
  private final int e;
  private final boolean f;
  final Handler g;
  private final List<e> h = new ArrayList();
  final List<d> i = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener j = new a();
  private final View.OnAttachStateChangeListener k = new b();
  private final androidx.appcompat.widget.x l = new c();
  private int m = 0;
  private int n = 0;
  private View o;
  View p;
  private int q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private boolean v;
  private boolean w;
  private j.a x;
  ViewTreeObserver y;
  private PopupWindow.OnDismissListener z;
  
  public b(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramContext;
    this.o = paramView;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramBoolean;
    this.v = false;
    this.q = F();
    paramContext = paramContext.getResources();
    this.c = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.g = new Handler();
  }
  
  private y B()
  {
    y localy = new y(this.b, null, this.d, this.e);
    localy.T(this.l);
    localy.L(this);
    localy.K(this);
    localy.D(this.o);
    localy.G(this.n);
    localy.J(true);
    localy.I(2);
    return localy;
  }
  
  private int C(e parame)
  {
    int i2 = this.i.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (parame == ((d)this.i.get(i1)).b) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private MenuItem D(e parame1, e parame2)
  {
    int i2 = parame1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = parame1.getItem(i1);
      if ((localMenuItem.hasSubMenu()) && (parame2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i1 += 1;
    }
    return null;
  }
  
  private View E(d paramd, e parame)
  {
    parame = D(paramd.b, parame);
    if (parame == null) {
      return null;
    }
    ListView localListView = paramd.a();
    paramd = localListView.getAdapter();
    boolean bool = paramd instanceof HeaderViewListAdapter;
    int i1 = 0;
    int i2;
    if (bool)
    {
      paramd = (HeaderViewListAdapter)paramd;
      i2 = paramd.getHeadersCount();
      paramd = (d)paramd.getWrappedAdapter();
    }
    else
    {
      paramd = (d)paramd;
      i2 = 0;
    }
    int i3 = paramd.getCount();
    while (i1 < i3)
    {
      if (parame == paramd.c(i1)) {
        break label104;
      }
      i1 += 1;
    }
    i1 = -1;
    label104:
    if (i1 == -1) {
      return null;
    }
    i1 = i1 + i2 - localListView.getFirstVisiblePosition();
    if (i1 >= 0)
    {
      if (i1 >= localListView.getChildCount()) {
        return null;
      }
      return localListView.getChildAt(i1);
    }
    return null;
  }
  
  private int F()
  {
    int i2 = androidx.core.view.x.B(this.o);
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    return i1;
  }
  
  private int G(int paramInt)
  {
    Object localObject = this.i;
    localObject = ((d)((List)localObject).get(((List)localObject).size() - 1)).a();
    int[] arrayOfInt = new int[2];
    ((ListView)localObject).getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.p.getWindowVisibleDisplayFrame(localRect);
    if (this.q == 1)
    {
      if (arrayOfInt[0] + ((ListView)localObject).getWidth() + paramInt > localRect.right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private void H(e parame)
  {
    Object localObject3 = LayoutInflater.from(this.b);
    Object localObject1 = new d(parame, (LayoutInflater)localObject3, this.f, B);
    if ((!c()) && (this.v)) {
      ((d)localObject1).d(true);
    } else if (c()) {
      ((d)localObject1).d(h.z(parame));
    }
    int i2 = h.q((ListAdapter)localObject1, null, this.b, this.c);
    y localy = B();
    localy.p((ListAdapter)localObject1);
    localy.F(i2);
    localy.G(this.n);
    if (this.i.size() > 0)
    {
      localObject1 = this.i;
      localObject1 = (d)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = E((d)localObject1, parame);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      localy.U(false);
      localy.R(null);
      int i1 = G(i2);
      int i3;
      if (i1 == 1) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      this.q = i1;
      int i4;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localy.D((View)localObject2);
        i1 = 0;
        i4 = i1;
      }
      else
      {
        int[] arrayOfInt1 = new int[2];
        this.o.getLocationOnScreen(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        ((View)localObject2).getLocationOnScreen(arrayOfInt2);
        if ((this.n & 0x7) == 5)
        {
          arrayOfInt1[0] += this.o.getWidth();
          arrayOfInt2[0] += ((View)localObject2).getWidth();
        }
        i4 = arrayOfInt2[0] - arrayOfInt1[0];
        i1 = arrayOfInt2[1] - arrayOfInt1[1];
      }
      if ((this.n & 0x5) == 5)
      {
        if (i3 == 0)
        {
          i2 = ((View)localObject2).getWidth();
          break label367;
        }
      }
      else
      {
        if (i3 == 0) {
          break label367;
        }
        i2 = ((View)localObject2).getWidth();
      }
      i2 = i4 + i2;
      break label372;
      label367:
      i2 = i4 - i2;
      label372:
      localy.l(i2);
      localy.M(true);
      localy.j(i1);
    }
    else
    {
      if (this.r) {
        localy.l(this.t);
      }
      if (this.s) {
        localy.j(this.u);
      }
      localy.H(p());
    }
    Object localObject2 = new d(localy, parame, this.q);
    this.i.add(localObject2);
    localy.a();
    localObject2 = localy.h();
    ((ListView)localObject2).setOnKeyListener(this);
    if ((localObject1 == null) && (this.w) && (parame.z() != null))
    {
      localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
      localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
      ((FrameLayout)localObject1).setEnabled(false);
      ((TextView)localObject3).setText(parame.z());
      ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
      localy.a();
    }
  }
  
  public void a()
  {
    if (c()) {
      return;
    }
    Object localObject = this.h.iterator();
    while (((Iterator)localObject).hasNext()) {
      H((e)((Iterator)localObject).next());
    }
    this.h.clear();
    localObject = this.o;
    this.p = ((View)localObject);
    if (localObject != null)
    {
      int i1;
      if (this.y == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = ((View)localObject).getViewTreeObserver();
      this.y = ((ViewTreeObserver)localObject);
      if (i1 != 0) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this.j);
      }
      this.p.addOnAttachStateChangeListener(this.k);
    }
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    int i1 = C(parame);
    if (i1 < 0) {
      return;
    }
    int i2 = i1 + 1;
    if (i2 < this.i.size()) {
      ((d)this.i.get(i2)).b.e(false);
    }
    Object localObject = (d)this.i.remove(i1);
    ((d)localObject).b.Q(this);
    if (this.A)
    {
      ((d)localObject).a.S(null);
      ((d)localObject).a.E(0);
    }
    ((d)localObject).a.dismiss();
    i2 = this.i.size();
    if (i2 > 0) {
      i1 = ((d)this.i.get(i2 - 1)).c;
    } else {
      i1 = F();
    }
    this.q = i1;
    if (i2 == 0)
    {
      dismiss();
      localObject = this.x;
      if (localObject != null) {
        ((j.a)localObject).b(parame, true);
      }
      parame = this.y;
      if (parame != null)
      {
        if (parame.isAlive()) {
          this.y.removeGlobalOnLayoutListener(this.j);
        }
        this.y = null;
      }
      this.p.removeOnAttachStateChangeListener(this.k);
      this.z.onDismiss();
      return;
    }
    if (paramBoolean) {
      ((d)this.i.get(0)).b.e(false);
    }
  }
  
  public boolean c()
  {
    int i1 = this.i.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
    {
      bool1 = bool2;
      if (((d)this.i.get(0)).a.c()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void dismiss()
  {
    int i1 = this.i.size();
    if (i1 > 0)
    {
      d[] arrayOfd = (d[])this.i.toArray(new d[i1]);
      i1 -= 1;
      while (i1 >= 0)
      {
        d locald = arrayOfd[i1];
        if (locald.a.c()) {
          locald.a.dismiss();
        }
        i1 -= 1;
      }
    }
  }
  
  public void e(Parcelable paramParcelable) {}
  
  public boolean f(m paramm)
  {
    Object localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if (paramm == locald.b)
      {
        locald.a().requestFocus();
        return true;
      }
    }
    if (paramm.hasVisibleItems())
    {
      n(paramm);
      localObject = this.x;
      if (localObject != null) {
        ((j.a)localObject).c(paramm);
      }
      return true;
    }
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      h.A(((d)localIterator.next()).a().getAdapter()).notifyDataSetChanged();
    }
  }
  
  public ListView h()
  {
    if (this.i.isEmpty()) {
      return null;
    }
    List localList = this.i;
    return ((d)localList.get(localList.size() - 1)).a();
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
    this.x = parama;
  }
  
  public void n(e parame)
  {
    parame.c(this, this.b);
    if (c())
    {
      H(parame);
      return;
    }
    this.h.add(parame);
  }
  
  protected boolean o()
  {
    return false;
  }
  
  public void onDismiss()
  {
    int i2 = this.i.size();
    int i1 = 0;
    while (i1 < i2)
    {
      locald = (d)this.i.get(i1);
      if (!locald.a.c()) {
        break label53;
      }
      i1 += 1;
    }
    d locald = null;
    label53:
    if (locald != null) {
      locald.b.e(false);
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
    if (this.o != paramView)
    {
      this.o = paramView;
      this.n = androidx.core.view.e.b(this.m, androidx.core.view.x.B(paramView));
    }
  }
  
  public void t(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void u(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      this.n = androidx.core.view.e.b(paramInt, androidx.core.view.x.B(this.o));
    }
  }
  
  public void v(int paramInt)
  {
    this.r = true;
    this.t = paramInt;
  }
  
  public void w(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.z = paramOnDismissListener;
  }
  
  public void x(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void y(int paramInt)
  {
    this.s = true;
    this.u = paramInt;
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      if ((b.this.c()) && (b.this.i.size() > 0) && (!((b.d)b.this.i.get(0)).a.B()))
      {
        Object localObject = b.this.p;
        if ((localObject != null) && (((View)localObject).isShown())) {
          localObject = b.this.i.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          ((b.d)((Iterator)localObject).next()).a.a();
          continue;
          b.this.dismiss();
        }
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
      Object localObject = b.this.y;
      if (localObject != null)
      {
        if (!((ViewTreeObserver)localObject).isAlive()) {
          b.this.y = paramView.getViewTreeObserver();
        }
        localObject = b.this;
        ((b)localObject).y.removeGlobalOnLayoutListener(((b)localObject).j);
      }
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
  
  class c
    implements androidx.appcompat.widget.x
  {
    c() {}
    
    public void e(final e parame, final MenuItem paramMenuItem)
    {
      Handler localHandler = b.this.g;
      final b.d locald = null;
      localHandler.removeCallbacksAndMessages(null);
      int j = b.this.i.size();
      int i = 0;
      while (i < j)
      {
        if (parame == ((b.d)b.this.i.get(i)).b) {
          break label75;
        }
        i += 1;
      }
      i = -1;
      label75:
      if (i == -1) {
        return;
      }
      i += 1;
      if (i < b.this.i.size()) {
        locald = (b.d)b.this.i.get(i);
      }
      paramMenuItem = new a(locald, paramMenuItem, parame);
      long l = SystemClock.uptimeMillis();
      b.this.g.postAtTime(paramMenuItem, parame, l + 200L);
    }
    
    public void f(e parame, MenuItem paramMenuItem)
    {
      b.this.g.removeCallbacksAndMessages(parame);
    }
    
    class a
      implements Runnable
    {
      a(b.d paramd, MenuItem paramMenuItem, e parame) {}
      
      public void run()
      {
        b.d locald = locald;
        if (locald != null)
        {
          b.this.A = true;
          locald.b.e(false);
          b.this.A = false;
        }
        if ((paramMenuItem.isEnabled()) && (paramMenuItem.hasSubMenu())) {
          parame.N(paramMenuItem, 4);
        }
      }
    }
  }
  
  private static class d
  {
    public final y a;
    public final e b;
    public final int c;
    
    public d(y paramy, e parame, int paramInt)
    {
      this.a = paramy;
      this.b = parame;
      this.c = paramInt;
    }
    
    public ListView a()
    {
      return this.a.h();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.b
 * JD-Core Version:    0.7.0.1
 */