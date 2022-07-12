package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

abstract class b
  implements f
{
  private final Context a;
  private final ExtendedFloatingActionButton b;
  private final ArrayList<Animator.AnimatorListener> c = new ArrayList();
  private final a d;
  private e7.h e;
  private e7.h f;
  
  b(ExtendedFloatingActionButton paramExtendedFloatingActionButton, a parama)
  {
    this.b = paramExtendedFloatingActionButton;
    this.a = paramExtendedFloatingActionButton.getContext();
    this.d = parama;
  }
  
  public e7.h c()
  {
    return this.f;
  }
  
  public AnimatorSet d()
  {
    return j(k());
  }
  
  public final List<Animator.AnimatorListener> e()
  {
    return this.c;
  }
  
  public final void h(e7.h paramh)
  {
    this.f = paramh;
  }
  
  AnimatorSet j(e7.h paramh)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramh.j("opacity")) {
      localArrayList.add(paramh.f("opacity", this.b, View.ALPHA));
    }
    if (paramh.j("scale"))
    {
      localArrayList.add(paramh.f("scale", this.b, View.SCALE_Y));
      localArrayList.add(paramh.f("scale", this.b, View.SCALE_X));
    }
    if (paramh.j("width")) {
      localArrayList.add(paramh.f("width", this.b, ExtendedFloatingActionButton.J));
    }
    if (paramh.j("height")) {
      localArrayList.add(paramh.f("height", this.b, ExtendedFloatingActionButton.K));
    }
    if (paramh.j("paddingStart")) {
      localArrayList.add(paramh.f("paddingStart", this.b, ExtendedFloatingActionButton.L));
    }
    if (paramh.j("paddingEnd")) {
      localArrayList.add(paramh.f("paddingEnd", this.b, ExtendedFloatingActionButton.M));
    }
    if (paramh.j("labelOpacity")) {
      localArrayList.add(paramh.f("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
    }
    paramh = new AnimatorSet();
    e7.b.a(paramh, localArrayList);
    return paramh;
  }
  
  public final e7.h k()
  {
    e7.h localh = this.f;
    if (localh != null) {
      return localh;
    }
    if (this.e == null) {
      this.e = e7.h.d(this.a, a());
    }
    return (e7.h)x0.h.g(this.e);
  }
  
  public void onAnimationCancel()
  {
    this.d.b();
  }
  
  public void onAnimationEnd()
  {
    this.d.b();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.d.c(paramAnimator);
  }
  
  class a
    extends Property<ExtendedFloatingActionButton, Float>
  {
    a(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Float a(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      int i = Color.alpha(paramExtendedFloatingActionButton.H.getColorForState(paramExtendedFloatingActionButton.getDrawableState(), b.i(b.this).H.getDefaultColor()));
      return Float.valueOf(e7.a.a(0.0F, 1.0F, Color.alpha(paramExtendedFloatingActionButton.getCurrentTextColor()) / 255.0F / i));
    }
    
    public void b(ExtendedFloatingActionButton paramExtendedFloatingActionButton, Float paramFloat)
    {
      int i = paramExtendedFloatingActionButton.H.getColorForState(paramExtendedFloatingActionButton.getDrawableState(), b.i(b.this).H.getDefaultColor());
      ColorStateList localColorStateList = ColorStateList.valueOf(Color.argb((int)(e7.a.a(0.0F, Color.alpha(i) / 255.0F, paramFloat.floatValue()) * 255.0F), Color.red(i), Color.green(i), Color.blue(i)));
      if (paramFloat.floatValue() == 1.0F)
      {
        paramExtendedFloatingActionButton.B(paramExtendedFloatingActionButton.H);
        return;
      }
      paramExtendedFloatingActionButton.B(localColorStateList);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.b
 * JD-Core Version:    0.7.0.1
 */