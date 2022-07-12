package androidx.core.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.Objects;

public final class u
  implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener
{
  private final View a;
  private ViewTreeObserver b;
  private final Runnable c;
  
  private u(View paramView, Runnable paramRunnable)
  {
    this.a = paramView;
    this.b = paramView.getViewTreeObserver();
    this.c = paramRunnable;
  }
  
  public static u a(View paramView, Runnable paramRunnable)
  {
    Objects.requireNonNull(paramView, "view == null");
    Objects.requireNonNull(paramRunnable, "runnable == null");
    paramRunnable = new u(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  public void b()
  {
    ViewTreeObserver localViewTreeObserver;
    if (this.b.isAlive()) {
      localViewTreeObserver = this.b;
    } else {
      localViewTreeObserver = this.a.getViewTreeObserver();
    }
    localViewTreeObserver.removeOnPreDrawListener(this);
    this.a.removeOnAttachStateChangeListener(this);
  }
  
  public boolean onPreDraw()
  {
    b();
    this.c.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    this.b = paramView.getViewTreeObserver();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.u
 * JD-Core Version:    0.7.0.1
 */