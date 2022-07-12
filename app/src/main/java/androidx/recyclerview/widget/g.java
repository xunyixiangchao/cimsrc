package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.view.x;

class g
  extends RecyclerView.o
  implements RecyclerView.s
{
  private static final int[] D = { 16842919 };
  private static final int[] E = new int[0];
  int A;
  private final Runnable B;
  private final RecyclerView.t C;
  private final int a;
  private final int b;
  final StateListDrawable c;
  final Drawable d;
  private final int e;
  private final int f;
  private final StateListDrawable g;
  private final Drawable h;
  private final int i;
  private final int j;
  int k;
  int l;
  float m;
  int n;
  int o;
  float p;
  private int q = 0;
  private int r = 0;
  private RecyclerView s;
  private boolean t = false;
  private boolean u = false;
  private int v = 0;
  private int w = 0;
  private final int[] x = new int[2];
  private final int[] y = new int[2];
  final ValueAnimator z;
  
  g(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.z = localValueAnimator;
    this.A = 0;
    this.B = new a();
    this.C = new b();
    this.c = paramStateListDrawable1;
    this.d = paramDrawable1;
    this.g = paramStateListDrawable2;
    this.h = paramDrawable2;
    this.e = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.f = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.i = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.j = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.a = paramInt2;
    this.b = paramInt3;
    paramStateListDrawable1.setAlpha(255);
    paramDrawable1.setAlpha(255);
    localValueAnimator.addListener(new c());
    localValueAnimator.addUpdateListener(new d());
    j(paramRecyclerView);
  }
  
  private void C(float paramFloat)
  {
    int[] arrayOfInt = p();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.l - paramFloat) < 2.0F) {
      return;
    }
    int i1 = x(this.m, paramFloat, arrayOfInt, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
    if (i1 != 0) {
      this.s.scrollBy(0, i1);
    }
    this.m = paramFloat;
  }
  
  private void k()
  {
    this.s.removeCallbacks(this.B);
  }
  
  private void l()
  {
    this.s.Z0(this);
    this.s.a1(this);
    this.s.b1(this.C);
    k();
  }
  
  private void m(Canvas paramCanvas)
  {
    int i2 = this.r;
    int i1 = this.i;
    i2 -= i1;
    int i4 = this.o;
    int i3 = this.n;
    i4 -= i3 / 2;
    this.g.setBounds(0, 0, i3, i1);
    this.h.setBounds(0, 0, this.q, this.j);
    paramCanvas.translate(0.0F, i2);
    this.h.draw(paramCanvas);
    paramCanvas.translate(i4, 0.0F);
    this.g.draw(paramCanvas);
    paramCanvas.translate(-i4, -i2);
  }
  
  private void n(Canvas paramCanvas)
  {
    int i1 = this.q;
    int i2 = this.e;
    i1 -= i2;
    int i3 = this.l;
    int i4 = this.k;
    i3 -= i4 / 2;
    this.c.setBounds(0, 0, i2, i4);
    this.d.setBounds(0, 0, this.f, this.r);
    if (s())
    {
      this.d.draw(paramCanvas);
      paramCanvas.translate(this.e, i3);
      paramCanvas.scale(-1.0F, 1.0F);
      this.c.draw(paramCanvas);
      paramCanvas.scale(-1.0F, 1.0F);
      i1 = this.e;
    }
    else
    {
      paramCanvas.translate(i1, 0.0F);
      this.d.draw(paramCanvas);
      paramCanvas.translate(0.0F, i3);
      this.c.draw(paramCanvas);
    }
    paramCanvas.translate(-i1, -i3);
  }
  
  private int[] o()
  {
    int[] arrayOfInt = this.y;
    int i1 = this.b;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = (this.q - i1);
    return arrayOfInt;
  }
  
  private int[] p()
  {
    int[] arrayOfInt = this.x;
    int i1 = this.b;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = (this.r - i1);
    return arrayOfInt;
  }
  
  private void r(float paramFloat)
  {
    int[] arrayOfInt = o();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.o - paramFloat) < 2.0F) {
      return;
    }
    int i1 = x(this.p, paramFloat, arrayOfInt, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
    if (i1 != 0) {
      this.s.scrollBy(i1, 0);
    }
    this.p = paramFloat;
  }
  
  private boolean s()
  {
    return x.B(this.s) == 1;
  }
  
  private void w(int paramInt)
  {
    k();
    this.s.postDelayed(this.B, paramInt);
  }
  
  private int x(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i1 == 0) {
      return 0;
    }
    paramFloat1 = (paramFloat2 - paramFloat1) / i1;
    paramInt1 -= paramInt3;
    paramInt3 = (int)(paramFloat1 * paramInt1);
    paramInt2 += paramInt3;
    if ((paramInt2 < paramInt1) && (paramInt2 >= 0)) {
      return paramInt3;
    }
    return 0;
  }
  
  private void z()
  {
    this.s.h(this);
    this.s.k(this);
    this.s.l(this.C);
  }
  
  public void A()
  {
    int i1 = this.A;
    if (i1 != 0)
    {
      if (i1 != 3) {
        return;
      }
      this.z.cancel();
    }
    this.A = 1;
    ValueAnimator localValueAnimator = this.z;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
    this.z.setDuration(500L);
    this.z.setStartDelay(0L);
    this.z.start();
  }
  
  void B(int paramInt1, int paramInt2)
  {
    int i1 = this.s.computeVerticalScrollRange();
    int i2 = this.r;
    boolean bool1;
    if ((i1 - i2 > 0) && (i2 >= this.a)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.t = bool1;
    int i3 = this.s.computeHorizontalScrollRange();
    int i4 = this.q;
    if ((i3 - i4 > 0) && (i4 >= this.a)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.u = bool1;
    boolean bool2 = this.t;
    if ((!bool2) && (!bool1))
    {
      if (this.v != 0) {
        y(0);
      }
      return;
    }
    float f1;
    float f2;
    if (bool2)
    {
      f1 = paramInt2;
      f2 = i2;
      this.l = ((int)(f2 * (f1 + f2 / 2.0F) / i1));
      this.k = Math.min(i2, i2 * i2 / i1);
    }
    if (this.u)
    {
      f1 = paramInt1;
      f2 = i4;
      this.o = ((int)(f2 * (f1 + f2 / 2.0F) / i3));
      this.n = Math.min(i4, i4 * i4 / i3);
    }
    paramInt1 = this.v;
    if ((paramInt1 == 0) || (paramInt1 == 1)) {
      y(1);
    }
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i1 = this.v;
    boolean bool2 = false;
    if (i1 == 1)
    {
      boolean bool3 = u(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool4 = t(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool1 = bool2;
      if (paramMotionEvent.getAction() != 0) {
        break label129;
      }
      if (!bool3)
      {
        bool1 = bool2;
        if (!bool4) {
          break label129;
        }
      }
      if (bool4)
      {
        this.w = 1;
        this.p = ((int)paramMotionEvent.getX());
      }
      else if (bool3)
      {
        this.w = 2;
        this.m = ((int)paramMotionEvent.getY());
      }
      y(2);
    }
    else
    {
      bool1 = bool2;
      if (i1 != 2) {
        break label129;
      }
    }
    boolean bool1 = true;
    label129:
    return bool1;
  }
  
  public void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (this.v == 0) {
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = u(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = t(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (bool2)
        {
          this.w = 1;
          this.p = ((int)paramMotionEvent.getX());
        }
        else if (bool1)
        {
          this.w = 2;
          this.m = ((int)paramMotionEvent.getY());
        }
        y(2);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 1) && (this.v == 2))
      {
        this.m = 0.0F;
        this.p = 0.0F;
        y(1);
        this.w = 0;
        return;
      }
      if ((paramMotionEvent.getAction() == 2) && (this.v == 2))
      {
        A();
        if (this.w == 1) {
          r(paramMotionEvent.getX());
        }
        if (this.w == 2) {
          C(paramMotionEvent.getY());
        }
      }
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void i(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    if ((this.q == this.s.getWidth()) && (this.r == this.s.getHeight()))
    {
      if (this.A != 0)
      {
        if (this.t) {
          n(paramCanvas);
        }
        if (this.u) {
          m(paramCanvas);
        }
      }
      return;
    }
    this.q = this.s.getWidth();
    this.r = this.s.getHeight();
    y(0);
  }
  
  public void j(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.s;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      l();
    }
    this.s = paramRecyclerView;
    if (paramRecyclerView != null) {
      z();
    }
  }
  
  void q(int paramInt)
  {
    int i1 = this.A;
    if (i1 != 1)
    {
      if (i1 == 2) {}
    }
    else {
      this.z.cancel();
    }
    this.A = 3;
    ValueAnimator localValueAnimator = this.z;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    this.z.setDuration(paramInt);
    this.z.start();
  }
  
  boolean t(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= this.r - this.i)
    {
      int i1 = this.o;
      int i2 = this.n;
      if ((paramFloat1 >= i1 - i2 / 2) && (paramFloat1 <= i1 + i2 / 2)) {
        return true;
      }
    }
    return false;
  }
  
  boolean u(float paramFloat1, float paramFloat2)
  {
    if (s() ? paramFloat1 <= this.e : paramFloat1 >= this.q - this.e)
    {
      int i1 = this.l;
      int i2 = this.k;
      if ((paramFloat2 >= i1 - i2 / 2) && (paramFloat2 <= i1 + i2 / 2)) {
        return true;
      }
    }
    return false;
  }
  
  void v()
  {
    this.s.invalidate();
  }
  
  void y(int paramInt)
  {
    if ((paramInt == 2) && (this.v != 2))
    {
      this.c.setState(D);
      k();
    }
    if (paramInt == 0) {
      v();
    } else {
      A();
    }
    int i1;
    if ((this.v == 2) && (paramInt != 2))
    {
      this.c.setState(E);
      i1 = 1200;
    }
    else
    {
      if (paramInt != 1) {
        break label88;
      }
      i1 = 1500;
    }
    w(i1);
    label88:
    this.v = paramInt;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      g.this.q(500);
    }
  }
  
  class b
    extends RecyclerView.t
  {
    b() {}
    
    public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      g.this.B(paramRecyclerView.computeHorizontalScrollOffset(), paramRecyclerView.computeVerticalScrollOffset());
    }
  }
  
  private class c
    extends AnimatorListenerAdapter
  {
    private boolean a = false;
    
    c() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.a)
      {
        this.a = false;
        return;
      }
      if (((Float)g.this.z.getAnimatedValue()).floatValue() == 0.0F)
      {
        paramAnimator = g.this;
        paramAnimator.A = 0;
        paramAnimator.y(0);
        return;
      }
      paramAnimator = g.this;
      paramAnimator.A = 2;
      paramAnimator.v();
    }
  }
  
  private class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      g.this.c.setAlpha(i);
      g.this.d.setAlpha(i);
      g.this.v();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.g
 * JD-Core Version:    0.7.0.1
 */