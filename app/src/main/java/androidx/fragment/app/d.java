package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.u;
import androidx.fragment.R.animator;
import androidx.fragment.R.id;
import u0.b;
import u0.b.a;

class d
{
  static void a(final Fragment paramFragment, d paramd, final r.g paramg)
  {
    final View localView = paramFragment.mView;
    ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    final b localb = new b();
    localb.d(new a());
    paramg.a(paramFragment, localb);
    if (paramd.a != null)
    {
      paramd = new e(paramd.a, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      paramd.setAnimationListener(new b(localViewGroup, paramFragment, paramg, localb));
      paramFragment.mView.startAnimation(paramd);
      return;
    }
    paramd = paramd.b;
    paramFragment.setAnimator(paramd);
    paramd.addListener(new c(localViewGroup, localView, paramFragment, paramg, localb));
    paramd.setTarget(paramFragment.mView);
    paramd.start();
  }
  
  private static int b(Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return paramFragment.getPopEnterAnim();
      }
      return paramFragment.getPopExitAnim();
    }
    if (paramBoolean1) {
      return paramFragment.getEnterAnim();
    }
    return paramFragment.getExitAnim();
  }
  
  static d c(Context paramContext, Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = paramFragment.getNextTransition();
    j = b(paramFragment, paramBoolean1, paramBoolean2);
    k = 0;
    paramFragment.setAnimations(0, 0, 0, 0);
    Object localObject = paramFragment.mContainer;
    if (localObject != null)
    {
      i = R.id.visible_removing_fragment_view_tag;
      if (((ViewGroup)localObject).getTag(i) != null) {
        paramFragment.mContainer.setTag(i, null);
      }
    }
    localObject = paramFragment.mContainer;
    if ((localObject != null) && (((ViewGroup)localObject).getLayoutTransition() != null)) {
      return null;
    }
    localObject = paramFragment.onCreateAnimation(m, paramBoolean1, j);
    if (localObject != null) {
      return new d((Animation)localObject);
    }
    paramFragment = paramFragment.onCreateAnimator(m, paramBoolean1, j);
    if (paramFragment != null) {
      return new d(paramFragment);
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (m != 0) {
        i = d(m, paramBoolean1);
      }
    }
    if (i != 0)
    {
      paramBoolean1 = "anim".equals(paramContext.getResources().getResourceTypeName(i));
      j = k;
      if (!paramBoolean1) {}
    }
    try
    {
      try
      {
        paramFragment = AnimationUtils.loadAnimation(paramContext, i);
        if (paramFragment != null)
        {
          paramFragment = new d(paramFragment);
          return paramFragment;
        }
        j = 1;
      }
      catch (Resources.NotFoundException paramContext)
      {
        throw paramContext;
      }
    }
    catch (RuntimeException paramFragment)
    {
      for (;;)
      {
        j = k;
      }
    }
    if (j == 0) {
      try
      {
        paramFragment = AnimatorInflater.loadAnimator(paramContext, i);
        if (paramFragment != null)
        {
          paramFragment = new d(paramFragment);
          return paramFragment;
        }
      }
      catch (RuntimeException paramFragment)
      {
        if (!paramBoolean1)
        {
          paramContext = AnimationUtils.loadAnimation(paramContext, i);
          if (paramContext != null) {
            return new d(paramContext);
          }
        }
        else
        {
          throw paramFragment;
        }
      }
    }
    return null;
  }
  
  private static int d(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return -1;
        }
        if (paramBoolean) {
          return R.animator.fragment_close_enter;
        }
        return R.animator.fragment_close_exit;
      }
      if (paramBoolean) {
        return R.animator.fragment_fade_enter;
      }
      return R.animator.fragment_fade_exit;
    }
    if (paramBoolean) {
      return R.animator.fragment_open_enter;
    }
    return R.animator.fragment_open_exit;
  }
  
  class a
    implements b.a
  {
    a() {}
    
    public void a()
    {
      if (d.this.getAnimatingAway() != null)
      {
        View localView = d.this.getAnimatingAway();
        d.this.setAnimatingAway(null);
        localView.clearAnimation();
      }
      d.this.setAnimator(null);
    }
  }
  
  class b
    implements Animation.AnimationListener
  {
    b(Fragment paramFragment, r.g paramg, b paramb) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      d.this.post(new a());
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        if (d.b.this.b.getAnimatingAway() != null)
        {
          d.b.this.b.setAnimatingAway(null);
          d.b localb = d.b.this;
          localb.c.b(localb.b, localb.d);
        }
      }
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c(View paramView, Fragment paramFragment, r.g paramg, b paramb) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      d.this.endViewTransition(localView);
      paramAnimator = paramFragment.getAnimator();
      paramFragment.setAnimator(null);
      if ((paramAnimator != null) && (d.this.indexOfChild(localView) < 0)) {
        paramg.b(paramFragment, localb);
      }
    }
  }
  
  static class d
  {
    public final Animation a;
    public final Animator b;
    
    d(Animator paramAnimator)
    {
      this.a = null;
      this.b = paramAnimator;
      if (paramAnimator != null) {
        return;
      }
      throw new IllegalStateException("Animator cannot be null");
    }
    
    d(Animation paramAnimation)
    {
      this.a = paramAnimation;
      this.b = null;
      if (paramAnimation != null) {
        return;
      }
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  static class e
    extends AnimationSet
    implements Runnable
  {
    private final ViewGroup a;
    private final View b;
    private boolean c;
    private boolean d;
    private boolean e = true;
    
    e(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      this.a = paramViewGroup;
      this.b = paramView;
      addAnimation(paramAnimation);
      paramViewGroup.post(this);
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      this.e = true;
      if (this.c) {
        return this.d ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        this.c = true;
        u.a(this.a, this);
      }
      return true;
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      this.e = true;
      if (this.c) {
        return this.d ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        this.c = true;
        u.a(this.a, this);
      }
      return true;
    }
    
    public void run()
    {
      if ((!this.c) && (this.e))
      {
        this.e = false;
        this.a.post(this);
        return;
      }
      this.a.endViewTransition(this.b);
      this.d = true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.d
 * JD-Core Version:    0.7.0.1
 */