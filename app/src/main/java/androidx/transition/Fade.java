package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.Map;
import p0.i;

public class Fade
  extends Visibility
{
  public Fade() {}
  
  public Fade(int paramInt)
  {
    s0(paramInt);
  }
  
  @SuppressLint({"RestrictedApi"})
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.f);
    s0(i.g(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, m0()));
    paramContext.recycle();
  }
  
  private Animator t0(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    b0.h(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, b0.b, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new b(paramView));
    a(new a(paramView));
    return localObjectAnimator;
  }
  
  private static float u0(t paramt, float paramFloat)
  {
    float f = paramFloat;
    if (paramt != null)
    {
      paramt = (Float)paramt.a.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramt != null) {
        f = paramt.floatValue();
      }
    }
    return f;
  }
  
  public void m(t paramt)
  {
    super.m(paramt);
    paramt.a.put("android:fade:transitionAlpha", Float.valueOf(b0.c(paramt.b)));
  }
  
  public Animator o0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    float f1 = 0.0F;
    float f2 = u0(paramt1, 0.0F);
    if (f2 != 1.0F) {
      f1 = f2;
    }
    return t0(paramView, f1, 1.0F);
  }
  
  public Animator q0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    b0.e(paramView);
    return t0(paramView, u0(paramt1, 1.0F), 0.0F);
  }
  
  class a
    extends q
  {
    a(View paramView) {}
    
    public void e(Transition paramTransition)
    {
      b0.h(paramView, 1.0F);
      b0.a(paramView);
      paramTransition.W(this);
    }
  }
  
  private static class b
    extends AnimatorListenerAdapter
  {
    private final View a;
    private boolean b = false;
    
    b(View paramView)
    {
      this.a = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      b0.h(this.a, 1.0F);
      if (this.b) {
        this.a.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((x.Q(this.a)) && (this.a.getLayerType() == 0))
      {
        this.b = true;
        this.a.setLayerType(2, null);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.Fade
 * JD-Core Version:    0.7.0.1
 */