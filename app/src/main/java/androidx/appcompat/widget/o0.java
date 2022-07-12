package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.x;
import androidx.core.view.z;

class o0
  implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener
{
  private static o0 j;
  private static o0 k;
  private final View a;
  private final CharSequence b;
  private final int c;
  private final Runnable d = new a();
  private final Runnable e = new b();
  private int f;
  private int g;
  private p0 h;
  private boolean i;
  
  private o0(View paramView, CharSequence paramCharSequence)
  {
    this.a = paramView;
    this.b = paramCharSequence;
    this.c = z.c(ViewConfiguration.get(paramView.getContext()));
    b();
    paramView.setOnLongClickListener(this);
    paramView.setOnHoverListener(this);
  }
  
  private void a()
  {
    this.a.removeCallbacks(this.d);
  }
  
  private void b()
  {
    this.f = 2147483647;
    this.g = 2147483647;
  }
  
  private void d()
  {
    this.a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
  }
  
  private static void e(o0 paramo0)
  {
    o0 localo0 = j;
    if (localo0 != null) {
      localo0.a();
    }
    j = paramo0;
    if (paramo0 != null) {
      paramo0.d();
    }
  }
  
  public static void f(View paramView, CharSequence paramCharSequence)
  {
    o0 localo0 = j;
    if ((localo0 != null) && (localo0.a == paramView)) {
      e(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = k;
      if ((paramCharSequence != null) && (paramCharSequence.a == paramView)) {
        paramCharSequence.c();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new o0(paramView, paramCharSequence);
  }
  
  private boolean h(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    if ((Math.abs(m - this.f) <= this.c) && (Math.abs(n - this.g) <= this.c)) {
      return false;
    }
    this.f = m;
    this.g = n;
    return true;
  }
  
  void c()
  {
    if (k == this)
    {
      k = null;
      p0 localp0 = this.h;
      if (localp0 != null)
      {
        localp0.c();
        this.h = null;
        b();
        this.a.removeOnAttachStateChangeListener(this);
      }
      else
      {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      }
    }
    if (j == this) {
      e(null);
    }
    this.a.removeCallbacks(this.e);
  }
  
  void g(boolean paramBoolean)
  {
    if (!x.T(this.a)) {
      return;
    }
    e(null);
    Object localObject = k;
    if (localObject != null) {
      ((o0)localObject).c();
    }
    k = this;
    this.i = paramBoolean;
    localObject = new p0(this.a.getContext());
    this.h = ((p0)localObject);
    ((p0)localObject).e(this.a, this.f, this.g, this.i, this.b);
    this.a.addOnAttachStateChangeListener(this);
    long l;
    if (this.i)
    {
      l = 2500L;
    }
    else
    {
      if ((x.M(this.a) & 0x1) == 1) {
        l = 3000L;
      } else {
        l = 15000L;
      }
      l -= ViewConfiguration.getLongPressTimeout();
    }
    this.a.removeCallbacks(this.e);
    this.a.postDelayed(this.e, l);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.h != null) && (this.i)) {
      return false;
    }
    paramView = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int m = paramMotionEvent.getAction();
    if (m != 7)
    {
      if (m != 10) {
        return false;
      }
      b();
      c();
      return false;
    }
    if ((this.a.isEnabled()) && (this.h == null) && (h(paramMotionEvent))) {
      e(this);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    this.f = (paramView.getWidth() / 2);
    this.g = (paramView.getHeight() / 2);
    g(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    c();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      o0.this.g(false);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      o0.this.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.o0
 * JD-Core Version:    0.7.0.1
 */