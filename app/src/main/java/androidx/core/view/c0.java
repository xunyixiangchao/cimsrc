package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class c0
{
  private WeakReference<View> a;
  Runnable b = null;
  Runnable c = null;
  int d = -1;
  
  c0(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  private void g(final View paramView, final d0 paramd0)
  {
    if (paramd0 != null)
    {
      paramView.animate().setListener(new a(paramd0, paramView));
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public c0 a(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public void b()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public long c()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      return localView.animate().getDuration();
    }
    return 0L;
  }
  
  public c0 d(long paramLong)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public c0 e(Interpolator paramInterpolator)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public c0 f(d0 paramd0)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      g(localView, paramd0);
    }
    return this;
  }
  
  public c0 h(long paramLong)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    return this;
  }
  
  public c0 i(final f0 paramf0)
  {
    final View localView = (View)this.a.get();
    if (localView != null)
    {
      b localb = null;
      if (paramf0 != null) {
        localb = new b(paramf0, localView);
      }
      localView.animate().setUpdateListener(localb);
    }
    return this;
  }
  
  public void j()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public c0 k(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(d0 paramd0, View paramView) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramd0.a(paramView);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramd0.b(paramView);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramd0.c(paramView);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(f0 paramf0, View paramView) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramf0.a(localView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.c0
 * JD-Core Version:    0.7.0.1
 */