package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.x;
import com.google.android.material.R.id;
import com.google.android.material.circularreveal.c.d;
import com.google.android.material.circularreveal.c.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e7.d;
import e7.e;
import e7.h;
import e7.i;
import e7.j;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  private final Rect c = new Rect();
  private final RectF d = new RectF();
  private final RectF e = new RectF();
  private final int[] f = new int[2];
  private float g;
  private float h;
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ViewGroup K(View paramView)
  {
    View localView = paramView.findViewById(R.id.mtrl_child_content_container);
    if (localView != null) {
      return f0(localView);
    }
    if ((!(paramView instanceof TransformationChildLayout)) && (!(paramView instanceof TransformationChildCard))) {
      return f0(paramView);
    }
    return f0(((ViewGroup)paramView).getChildAt(0));
  }
  
  private void L(View paramView, e parame, i parami1, i parami2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, RectF paramRectF)
  {
    paramFloat1 = S(parame, parami1, paramFloat1, paramFloat3);
    paramFloat2 = S(parame, parami2, paramFloat2, paramFloat4);
    parami1 = this.c;
    paramView.getWindowVisibleDisplayFrame(parami1);
    parame = this.d;
    parame.set(parami1);
    parami1 = this.e;
    T(paramView, parami1);
    parami1.offset(paramFloat1, paramFloat2);
    parami1.intersect(parame);
    paramRectF.set(parami1);
  }
  
  private void M(View paramView, RectF paramRectF)
  {
    T(paramView, paramRectF);
    paramRectF.offset(this.g, this.h);
  }
  
  private Pair<i, i> N(float paramFloat1, float paramFloat2, boolean paramBoolean, e parame)
  {
    if (paramFloat1 != 0.0F)
    {
      boolean bool = paramFloat2 < 0.0F;
      if (bool)
      {
        if (((paramBoolean) && (paramFloat2 < 0.0F)) || ((!paramBoolean) && (bool)))
        {
          localObject1 = parame.a.h("translationXCurveUpwards");
          localObject2 = parame.a;
          str = "translationYCurveUpwards";
          parame = (e)localObject1;
          localObject1 = localObject2;
          break label133;
        }
        localObject1 = parame.a.h("translationXCurveDownwards");
        localObject2 = parame.a;
        str = "translationYCurveDownwards";
        parame = (e)localObject1;
        localObject1 = localObject2;
        break label133;
      }
    }
    Object localObject2 = parame.a.h("translationXLinear");
    Object localObject1 = parame.a;
    String str = "translationYLinear";
    parame = (e)localObject2;
    label133:
    return new Pair(parame, ((h)localObject1).h(str));
  }
  
  private float O(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.d;
    RectF localRectF2 = this.e;
    M(paramView1, localRectF1);
    T(paramView2, localRectF2);
    localRectF2.offset(-Q(paramView1, paramView2, paramj), 0.0F);
    return localRectF1.centerX() - localRectF2.left;
  }
  
  private float P(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.d;
    RectF localRectF2 = this.e;
    M(paramView1, localRectF1);
    T(paramView2, localRectF2);
    localRectF2.offset(0.0F, -R(paramView1, paramView2, paramj));
    return localRectF1.centerY() - localRectF2.top;
  }
  
  private float Q(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.d;
    RectF localRectF2 = this.e;
    M(paramView1, localRectF1);
    T(paramView2, localRectF2);
    int i = paramj.a & 0x7;
    float f1;
    float f2;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          f1 = 0.0F;
          break label114;
        }
        f1 = localRectF2.right;
        f2 = localRectF1.right;
      }
      else
      {
        f1 = localRectF2.left;
        f2 = localRectF1.left;
      }
    }
    else
    {
      f1 = localRectF2.centerX();
      f2 = localRectF1.centerX();
    }
    f1 -= f2;
    label114:
    return f1 + paramj.b;
  }
  
  private float R(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.d;
    RectF localRectF2 = this.e;
    M(paramView1, localRectF1);
    T(paramView2, localRectF2);
    int i = paramj.a & 0x70;
    float f1;
    float f2;
    if (i != 16)
    {
      if (i != 48)
      {
        if (i != 80)
        {
          f1 = 0.0F;
          break label117;
        }
        f1 = localRectF2.bottom;
        f2 = localRectF1.bottom;
      }
      else
      {
        f1 = localRectF2.top;
        f2 = localRectF1.top;
      }
    }
    else
    {
      f1 = localRectF2.centerY();
      f2 = localRectF1.centerY();
    }
    f1 -= f2;
    label117:
    return f1 + paramj.c;
  }
  
  private float S(e parame, i parami, float paramFloat1, float paramFloat2)
  {
    long l1 = parami.c();
    long l2 = parami.d();
    parame = parame.a.h("expansion");
    float f1 = (float)(parame.c() + parame.d() + 17L - l1) / (float)l2;
    return e7.a.a(paramFloat1, paramFloat2, parami.e().getInterpolation(f1));
  }
  
  private void T(View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.f;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private void U(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof ViewGroup)) {
      return;
    }
    if (((paramView2 instanceof com.google.android.material.circularreveal.c)) && (com.google.android.material.circularreveal.b.j == 0)) {
      return;
    }
    paramView1 = K(paramView2);
    if (paramView1 == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        d.a.set(paramView1, Float.valueOf(0.0F));
      }
      paramView1 = ObjectAnimator.ofFloat(paramView1, d.a, new float[] { 1.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView1, d.a, new float[] { 0.0F });
    }
    parame.a.h("contentFade").a(paramView1);
    paramList.add(paramView1);
  }
  
  private void V(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof com.google.android.material.circularreveal.c)) {
      return;
    }
    paramView2 = (com.google.android.material.circularreveal.c)paramView2;
    int i = d0(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setCircularRevealScrimColor(i);
      }
      paramView1 = ObjectAnimator.ofInt(paramView2, c.d.a, new int[] { 0xFFFFFF & i });
    }
    else
    {
      paramView1 = ObjectAnimator.ofInt(paramView2, c.d.a, new int[] { i });
    }
    paramView1.setEvaluator(e7.c.b());
    parame.a.h("color").a(paramView1);
    paramList.add(paramView1);
  }
  
  private void W(View paramView1, View paramView2, boolean paramBoolean, e parame, List<Animator> paramList)
  {
    float f1 = Q(paramView1, paramView2, parame.b);
    float f2 = R(paramView1, paramView2, parame.b);
    parame = N(f1, f2, paramBoolean, parame);
    paramView2 = (i)parame.first;
    parame = (i)parame.second;
    Object localObject = View.TRANSLATION_X;
    if (!paramBoolean) {
      f1 = this.g;
    }
    localObject = ObjectAnimator.ofFloat(paramView1, (Property)localObject, new float[] { f1 });
    Property localProperty = View.TRANSLATION_Y;
    if (paramBoolean) {
      f1 = f2;
    } else {
      f1 = this.h;
    }
    paramView1 = ObjectAnimator.ofFloat(paramView1, localProperty, new float[] { f1 });
    paramView2.a((Animator)localObject);
    parame.a(paramView1);
    paramList.add(localObject);
    paramList.add(paramView1);
  }
  
  @TargetApi(21)
  private void X(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    float f1 = x.w(paramView2) - x.w(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setTranslationZ(-f1);
      }
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f1 });
    }
    parame.a.h("elevation").a(paramView1);
    paramList.add(paramView1);
  }
  
  private void Y(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, float paramFloat1, float paramFloat2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof com.google.android.material.circularreveal.c)) {
      return;
    }
    final com.google.android.material.circularreveal.c localc = (com.google.android.material.circularreveal.c)paramView2;
    float f2 = O(paramView1, paramView2, parame.b);
    float f3 = P(paramView1, paramView2, parame.b);
    ((FloatingActionButton)paramView1).i(this.c);
    float f1 = this.c.width() / 2.0F;
    i locali = parame.a.h("expansion");
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        localc.setRevealInfo(new c.e(f2, f3, f1));
      }
      if (paramBoolean2) {
        f1 = localc.getRevealInfo().c;
      }
      paramView1 = com.google.android.material.circularreveal.a.a(localc, f2, f3, l7.a.b(f2, f3, 0.0F, 0.0F, paramFloat1, paramFloat2));
      paramView1.addListener(new d(localc));
      b0(paramView2, locali.c(), (int)f2, (int)f3, f1, paramList);
    }
    else
    {
      paramFloat1 = localc.getRevealInfo().c;
      paramView1 = com.google.android.material.circularreveal.a.a(localc, f2, f3, f1);
      long l = locali.c();
      int i = (int)f2;
      int j = (int)f3;
      b0(paramView2, l, i, j, paramFloat1, paramList);
      a0(paramView2, locali.c(), locali.d(), parame.a.i(), i, j, f1, paramList);
    }
    locali.a(paramView1);
    paramList.add(paramView1);
    paramList1.add(com.google.android.material.circularreveal.a.b(localc));
  }
  
  private void Z(View paramView1, final View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if ((paramView2 instanceof com.google.android.material.circularreveal.c))
    {
      if (!(paramView1 instanceof ImageView)) {
        return;
      }
      final com.google.android.material.circularreveal.c localc = (com.google.android.material.circularreveal.c)paramView2;
      final Drawable localDrawable = ((ImageView)paramView1).getDrawable();
      if (localDrawable == null) {
        return;
      }
      localDrawable.mutate();
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          localDrawable.setAlpha(255);
        }
        paramView1 = ObjectAnimator.ofInt(localDrawable, e.b, new int[] { 0 });
      }
      else
      {
        paramView1 = ObjectAnimator.ofInt(localDrawable, e.b, new int[] { 255 });
      }
      paramView1.addUpdateListener(new b(paramView2));
      parame.a.h("iconFade").a(paramView1);
      paramList.add(paramView1);
      paramList1.add(new c(localc, localDrawable));
    }
  }
  
  private void a0(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    paramLong1 += paramLong2;
    if (paramLong1 < paramLong3)
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      paramView.setStartDelay(paramLong1);
      paramView.setDuration(paramLong3 - paramLong1);
      paramList.add(paramView);
    }
  }
  
  private void b0(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if (paramLong > 0L)
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      paramView.setStartDelay(0L);
      paramView.setDuration(paramLong);
      paramList.add(paramView);
    }
  }
  
  private void c0(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, e parame, List<Animator> paramList, List<Animator.AnimatorListener> paramList1, RectF paramRectF)
  {
    float f1 = Q(paramView1, paramView2, parame.b);
    float f2 = R(paramView1, paramView2, parame.b);
    paramView1 = N(f1, f2, paramBoolean1, parame);
    i locali1 = (i)paramView1.first;
    i locali2 = (i)paramView1.second;
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      }
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      paramList1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      L(paramView2, parame, locali1, locali2, -f1, -f2, 0.0F, 0.0F, paramRectF);
      paramView2 = paramList1;
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f1 });
      paramView2 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f2 });
    }
    locali1.a(paramView1);
    locali2.a(paramView2);
    paramList.add(paramView1);
    paramList.add(paramView2);
  }
  
  private int d0(View paramView)
  {
    ColorStateList localColorStateList = x.s(paramView);
    if (localColorStateList != null) {
      return localColorStateList.getColorForState(paramView.getDrawableState(), localColorStateList.getDefaultColor());
    }
    return 0;
  }
  
  private ViewGroup f0(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  protected AnimatorSet J(final View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = e0(paramView2.getContext(), paramBoolean1);
    if (paramBoolean1)
    {
      this.g = paramView1.getTranslationX();
      this.h = paramView1.getTranslationY();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    X(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, localArrayList1, localArrayList2);
    RectF localRectF = this.d;
    c0(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, localArrayList1, localArrayList2, localRectF);
    float f1 = localRectF.width();
    float f2 = localRectF.height();
    W(paramView1, paramView2, paramBoolean1, (e)localObject, localArrayList1);
    Z(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, localArrayList1, localArrayList2);
    Y(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, f1, f2, localArrayList1, localArrayList2);
    V(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, localArrayList1, localArrayList2);
    U(paramView1, paramView2, paramBoolean1, paramBoolean2, (e)localObject, localArrayList1, localArrayList2);
    localObject = new AnimatorSet();
    e7.b.a((AnimatorSet)localObject, localArrayList1);
    ((AnimatorSet)localObject).addListener(new a(paramBoolean1, paramView2, paramView1));
    int i = 0;
    int j = localArrayList2.size();
    while (i < j)
    {
      ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)localArrayList2.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public boolean e(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    if (paramView1.getVisibility() != 8)
    {
      boolean bool3 = paramView2 instanceof FloatingActionButton;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if (i != 0)
        {
          bool1 = bool2;
          if (i != paramView1.getId()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
  }
  
  protected abstract e e0(Context paramContext, boolean paramBoolean);
  
  public void g(CoordinatorLayout.e parame)
  {
    if (parame.h == 0) {
      parame.h = 80;
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(boolean paramBoolean, View paramView1, View paramView2) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!paramBoolean1)
      {
        paramView2.setVisibility(4);
        paramView1.setAlpha(1.0F);
        paramView1.setVisibility(0);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (paramBoolean1)
      {
        paramView2.setVisibility(0);
        paramView1.setAlpha(0.0F);
        paramView1.setVisibility(4);
      }
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramView2.invalidate();
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c(com.google.android.material.circularreveal.c paramc, Drawable paramDrawable) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      localc.setCircularRevealOverlayDrawable(null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      localc.setCircularRevealOverlayDrawable(localDrawable);
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d(com.google.android.material.circularreveal.c paramc) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = localc.getRevealInfo();
      paramAnimator.c = 3.4028235E+38F;
      localc.setRevealInfo(paramAnimator);
    }
  }
  
  protected static class e
  {
    public h a;
    public j b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */