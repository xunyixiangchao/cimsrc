package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.integer;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.k;
import e7.f;
import e7.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r7.m;
import r7.p;

class d
{
  static final TimeInterpolator D = e7.a.c;
  static final int[] E = { 16842919, 16842910 };
  static final int[] F = { 16843623, 16842908, 16842910 };
  static final int[] G = { 16842908, 16842910 };
  static final int[] H = { 16843623, 16842910 };
  static final int[] I = { 16842910 };
  static final int[] J = new int[0];
  private final RectF A = new RectF();
  private final Matrix B = new Matrix();
  private ViewTreeObserver.OnPreDrawListener C;
  m a;
  r7.h b;
  Drawable c;
  c d;
  Drawable e;
  boolean f;
  boolean g = true;
  float h;
  float i;
  float j;
  int k;
  private final k l;
  private Animator m;
  private e7.h n;
  private e7.h o;
  private float p;
  private float q = 1.0F;
  private int r;
  private int s = 0;
  private ArrayList<Animator.AnimatorListener> t;
  private ArrayList<Animator.AnimatorListener> u;
  private ArrayList<j> v;
  final FloatingActionButton w;
  final q7.b x;
  private final Rect y = new Rect();
  private final RectF z = new RectF();
  
  d(FloatingActionButton paramFloatingActionButton, q7.b paramb)
  {
    this.w = paramFloatingActionButton;
    this.x = paramb;
    paramb = new k();
    this.l = paramb;
    paramb.a(E, k(new i()));
    paramb.a(F, k(new h()));
    paramb.a(G, k(new h()));
    paramb.a(H, k(new h()));
    paramb.a(I, k(new l()));
    paramb.a(J, k(new g()));
    this.p = paramFloatingActionButton.getRotation();
  }
  
  private boolean Z()
  {
    return (x.U(this.w)) && (!this.w.isInEditMode());
  }
  
  private void g0(ObjectAnimator paramObjectAnimator)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    paramObjectAnimator.setEvaluator(new e());
  }
  
  private void h(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.w.getDrawable();
    if ((localDrawable != null) && (this.r != 0))
    {
      RectF localRectF1 = this.z;
      RectF localRectF2 = this.A;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      int i1 = this.r;
      localRectF2.set(0.0F, 0.0F, i1, i1);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      i1 = this.r;
      paramMatrix.postScale(paramFloat, paramFloat, i1 / 2.0F, i1 / 2.0F);
    }
  }
  
  private AnimatorSet i(e7.h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.w, View.ALPHA, new float[] { paramFloat1 });
    paramh.h("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.w, View.SCALE_X, new float[] { paramFloat2 });
    paramh.h("scale").a(localObjectAnimator);
    g0(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.w, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.h("scale").a(localObjectAnimator);
    g0(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    h(paramFloat3, this.B);
    localObjectAnimator = ObjectAnimator.ofObject(this.w, new f(), new c(), new Matrix[] { new Matrix(this.B) });
    paramh.h("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    e7.b.a(paramh, localArrayList);
    return paramh;
  }
  
  private AnimatorSet j(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new d(this.w.getAlpha(), paramFloat1, this.w.getScaleX(), paramFloat2, this.w.getScaleY(), this.q, paramFloat3, new Matrix(this.B)));
    localArrayList.add(localValueAnimator);
    e7.b.a(localAnimatorSet, localArrayList);
    localAnimatorSet.setDuration(m7.a.d(this.w.getContext(), R.attr.motionDurationLong1, this.w.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
    localAnimatorSet.setInterpolator(m7.a.e(this.w.getContext(), R.attr.motionEasingStandard, e7.a.b));
    return localAnimatorSet;
  }
  
  private ValueAnimator k(m paramm)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(D);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramm);
    localValueAnimator.addUpdateListener(paramm);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private ViewTreeObserver.OnPreDrawListener q()
  {
    if (this.C == null) {
      this.C = new f();
    }
    return this.C;
  }
  
  void A()
  {
    r7.h localh = this.b;
    if (localh != null) {
      r7.i.f(this.w, localh);
    }
    if (J()) {
      this.w.getViewTreeObserver().addOnPreDrawListener(q());
    }
  }
  
  void B()
  {
    throw null;
  }
  
  void C()
  {
    ViewTreeObserver localViewTreeObserver = this.w.getViewTreeObserver();
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = this.C;
    if (localOnPreDrawListener != null)
    {
      localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      this.C = null;
    }
  }
  
  void D(int[] paramArrayOfInt)
  {
    throw null;
  }
  
  void E(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    throw null;
  }
  
  void F(Rect paramRect)
  {
    x0.h.h(this.e, "Didn't initialize content background");
    q7.b localb;
    if (Y())
    {
      paramRect = new InsetDrawable(this.e, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      localb = this.x;
    }
    else
    {
      localb = this.x;
      paramRect = this.e;
    }
    localb.b(paramRect);
  }
  
  void G()
  {
    float f1 = this.w.getRotation();
    if (this.p != f1)
    {
      this.p = f1;
      c0();
    }
  }
  
  void H()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).b();
      }
    }
  }
  
  void I()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).a();
      }
    }
  }
  
  boolean J()
  {
    throw null;
  }
  
  void K(ColorStateList paramColorStateList)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((r7.h)localObject).setTintList(paramColorStateList);
    }
    localObject = this.d;
    if (localObject != null) {
      ((c)localObject).c(paramColorStateList);
    }
  }
  
  void L(PorterDuff.Mode paramMode)
  {
    r7.h localh = this.b;
    if (localh != null) {
      localh.setTintMode(paramMode);
    }
  }
  
  final void M(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      E(paramFloat, this.i, this.j);
    }
  }
  
  void N(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  final void O(e7.h paramh)
  {
    this.o = paramh;
  }
  
  final void P(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      this.i = paramFloat;
      E(this.h, paramFloat, this.j);
    }
  }
  
  final void Q(float paramFloat)
  {
    this.q = paramFloat;
    Matrix localMatrix = this.B;
    h(paramFloat, localMatrix);
    this.w.setImageMatrix(localMatrix);
  }
  
  final void R(int paramInt)
  {
    if (this.r != paramInt)
    {
      this.r = paramInt;
      d0();
    }
  }
  
  void S(int paramInt)
  {
    this.k = paramInt;
  }
  
  final void T(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      this.j = paramFloat;
      E(this.h, this.i, paramFloat);
    }
  }
  
  void U(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      r0.a.o(localDrawable, p7.b.d(paramColorStateList));
    }
  }
  
  void V(boolean paramBoolean)
  {
    this.g = paramBoolean;
    e0();
  }
  
  final void W(m paramm)
  {
    this.a = paramm;
    Object localObject = this.b;
    if (localObject != null) {
      ((r7.h)localObject).setShapeAppearanceModel(paramm);
    }
    localObject = this.c;
    if ((localObject instanceof p)) {
      ((p)localObject).setShapeAppearanceModel(paramm);
    }
    localObject = this.d;
    if (localObject != null) {
      ((c)localObject).f(paramm);
    }
  }
  
  final void X(e7.h paramh)
  {
    this.n = paramh;
  }
  
  boolean Y()
  {
    throw null;
  }
  
  final boolean a0()
  {
    return (!this.f) || (this.w.getSizeDimension() >= this.k);
  }
  
  void b0(final k paramk, final boolean paramBoolean)
  {
    if (y()) {
      return;
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    int i1;
    if (this.n == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (Z())
    {
      if (this.w.getVisibility() != 0)
      {
        localObject = this.w;
        float f2 = 0.0F;
        ((ImageButton)localObject).setAlpha(0.0F);
        localObject = this.w;
        if (i1 != 0) {
          f1 = 0.4F;
        } else {
          f1 = 0.0F;
        }
        ((FloatingActionButton)localObject).setScaleY(f1);
        localObject = this.w;
        if (i1 != 0) {
          f1 = 0.4F;
        } else {
          f1 = 0.0F;
        }
        ((FloatingActionButton)localObject).setScaleX(f1);
        float f1 = f2;
        if (i1 != 0) {
          f1 = 0.4F;
        }
        Q(f1);
      }
      localObject = this.n;
      if (localObject != null) {
        localObject = i((e7.h)localObject, 1.0F, 1.0F, 1.0F);
      } else {
        localObject = j(1.0F, 1.0F, 1.0F);
      }
      ((AnimatorSet)localObject).addListener(new b(paramBoolean, paramk));
      paramk = this.t;
      if (paramk != null)
      {
        paramk = paramk.iterator();
        while (paramk.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramk.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    this.w.b(0, paramBoolean);
    this.w.setAlpha(1.0F);
    this.w.setScaleY(1.0F);
    this.w.setScaleX(1.0F);
    Q(1.0F);
    if (paramk != null) {
      paramk.a();
    }
  }
  
  void c0()
  {
    throw null;
  }
  
  final void d0()
  {
    Q(this.q);
  }
  
  public void e(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    this.u.add(paramAnimatorListener);
  }
  
  final void e0()
  {
    Rect localRect = this.y;
    r(localRect);
    F(localRect);
    this.x.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  void f(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.t == null) {
      this.t = new ArrayList();
    }
    this.t.add(paramAnimatorListener);
  }
  
  void f0(float paramFloat)
  {
    r7.h localh = this.b;
    if (localh != null) {
      localh.a0(paramFloat);
    }
  }
  
  void g(j paramj)
  {
    if (this.v == null) {
      this.v = new ArrayList();
    }
    this.v.add(paramj);
  }
  
  final Drawable l()
  {
    return this.e;
  }
  
  float m()
  {
    throw null;
  }
  
  boolean n()
  {
    return this.f;
  }
  
  final e7.h o()
  {
    return this.o;
  }
  
  float p()
  {
    return this.i;
  }
  
  void r(Rect paramRect)
  {
    if (this.f) {
      i1 = (this.k - this.w.getSizeDimension()) / 2;
    } else {
      i1 = 0;
    }
    float f1;
    if (this.g) {
      f1 = m() + this.j;
    } else {
      f1 = 0.0F;
    }
    int i2 = Math.max(i1, (int)Math.ceil(f1));
    int i1 = Math.max(i1, (int)Math.ceil(f1 * 1.5F));
    paramRect.set(i2, i1, i2, i1);
  }
  
  float s()
  {
    return this.j;
  }
  
  final m t()
  {
    return this.a;
  }
  
  final e7.h u()
  {
    return this.n;
  }
  
  void v(final k paramk, final boolean paramBoolean)
  {
    if (x()) {
      return;
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (Z())
    {
      localObject = this.o;
      if (localObject != null) {
        localObject = i((e7.h)localObject, 0.0F, 0.0F, 0.0F);
      } else {
        localObject = j(0.0F, 0.4F, 0.4F);
      }
      ((AnimatorSet)localObject).addListener(new a(paramBoolean, paramk));
      paramk = this.u;
      if (paramk != null)
      {
        paramk = paramk.iterator();
        while (paramk.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramk.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    localObject = this.w;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 4;
    }
    ((VisibilityAwareImageButton)localObject).b(i1, paramBoolean);
    if (paramk != null) {
      paramk.b();
    }
  }
  
  void w(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    throw null;
  }
  
  boolean x()
  {
    int i1 = this.w.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == 0)
    {
      if (this.s == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.s != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean y()
  {
    int i1 = this.w.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 != 0)
    {
      if (this.s == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.s != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  void z()
  {
    throw null;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    private boolean a;
    
    a(boolean paramBoolean, d.k paramk) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      d.a(d.this, 0);
      d.b(d.this, null);
      if (!this.a)
      {
        paramAnimator = d.this.w;
        boolean bool = paramBoolean;
        int i;
        if (bool) {
          i = 8;
        } else {
          i = 4;
        }
        paramAnimator.b(i, bool);
        paramAnimator = paramk;
        if (paramAnimator != null) {
          paramAnimator.b();
        }
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      d.this.w.b(0, paramBoolean);
      d.a(d.this, 1);
      d.b(d.this, paramAnimator);
      this.a = false;
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b(boolean paramBoolean, d.k paramk) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      d.a(d.this, 0);
      d.b(d.this, null);
      paramAnimator = paramk;
      if (paramAnimator != null) {
        paramAnimator.a();
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      d.this.w.b(0, paramBoolean);
      d.a(d.this, 2);
      d.b(d.this, paramAnimator);
    }
  }
  
  class c
    extends g
  {
    c() {}
    
    public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      d.c(d.this, paramFloat);
      return super.a(paramFloat, paramMatrix1, paramMatrix2);
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, Matrix paramMatrix) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      d.this.w.setAlpha(e7.a.b(this.a, paramFloat1, 0.0F, 0.2F, f1));
      d.this.w.setScaleX(e7.a.a(this.c, paramFloat2, f1));
      d.this.w.setScaleY(e7.a.a(this.e, paramFloat2, f1));
      d.c(d.this, e7.a.a(this.f, paramFloat3, f1));
      d.d(d.this, e7.a.a(this.f, paramFloat3, f1), this.h);
      d.this.w.setImageMatrix(this.h);
    }
  }
  
  class e
    implements TypeEvaluator<Float>
  {
    FloatEvaluator a = new FloatEvaluator();
    
    e() {}
    
    public Float a(float paramFloat, Float paramFloat1, Float paramFloat2)
    {
      float f = this.a.evaluate(paramFloat, paramFloat1, paramFloat2).floatValue();
      paramFloat = f;
      if (f < 0.1F) {
        paramFloat = 0.0F;
      }
      return Float.valueOf(paramFloat);
    }
  }
  
  class f
    implements ViewTreeObserver.OnPreDrawListener
  {
    f() {}
    
    public boolean onPreDraw()
    {
      d.this.G();
      return true;
    }
  }
  
  private class g
    extends d.m
  {
    g()
    {
      super(null);
    }
    
    protected float a()
    {
      return 0.0F;
    }
  }
  
  private class h
    extends d.m
  {
    h()
    {
      super(null);
    }
    
    protected float a()
    {
      d locald = d.this;
      return locald.h + locald.i;
    }
  }
  
  private class i
    extends d.m
  {
    i()
    {
      super(null);
    }
    
    protected float a()
    {
      d locald = d.this;
      return locald.h + locald.j;
    }
  }
  
  static abstract interface j
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  static abstract interface k
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  private class l
    extends d.m
  {
    l()
    {
      super(null);
    }
    
    protected float a()
    {
      return d.this.h;
    }
  }
  
  private abstract class m
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean a;
    private float b;
    private float c;
    
    private m() {}
    
    protected abstract float a();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      d.this.f0((int)this.c);
      this.a = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.a)
      {
        localObject = d.this.b;
        if (localObject == null) {
          f = 0.0F;
        } else {
          f = ((r7.h)localObject).w();
        }
        this.b = f;
        this.c = a();
        this.a = true;
      }
      Object localObject = d.this;
      float f = this.b;
      ((d)localObject).f0((int)(f + (this.c - f) * paramValueAnimator.getAnimatedFraction()));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.d
 * JD-Core Version:    0.7.0.1
 */