package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.x;

public abstract class a
  implements View.OnTouchListener
{
  private static final int r = ;
  final a a = new a();
  private final Interpolator b = new AccelerateInterpolator();
  final View c;
  private Runnable d;
  private float[] e = { 0.0F, 0.0F };
  private float[] f = { 3.4028235E+38F, 3.4028235E+38F };
  private int g;
  private int h;
  private float[] i = { 0.0F, 0.0F };
  private float[] j = { 0.0F, 0.0F };
  private float[] k = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean l;
  boolean m;
  boolean n;
  boolean o;
  private boolean p;
  private boolean q;
  
  public a(View paramView)
  {
    this.c = paramView;
    float f1 = Resources.getSystem().getDisplayMetrics().density;
    int i1 = (int)(1575.0F * f1 + 0.5F);
    int i2 = (int)(f1 * 315.0F + 0.5F);
    f1 = i1;
    o(f1, f1);
    f1 = i2;
    p(f1, f1);
    l(1);
    n(3.4028235E+38F, 3.4028235E+38F);
    s(0.2F, 0.2F);
    t(1.0F, 1.0F);
    k(r);
    r(500);
    q(500);
  }
  
  private float d(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = h(this.e[paramInt], paramFloat2, this.f[paramInt], paramFloat1);
    boolean bool = paramFloat1 < 0.0F;
    if (!bool) {
      return 0.0F;
    }
    float f2 = this.i[paramInt];
    paramFloat2 = this.j[paramInt];
    float f1 = this.k[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (bool) {
      return e(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -e(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private float g(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {
      return 0.0F;
    }
    int i1 = this.g;
    if ((i1 != 0) && (i1 != 1))
    {
      if (i1 != 2) {
        return 0.0F;
      }
      if (paramFloat1 < 0.0F) {
        return paramFloat1 / -paramFloat2;
      }
    }
    else if (paramFloat1 < paramFloat2)
    {
      if (paramFloat1 >= 0.0F) {
        return 1.0F - paramFloat1 / paramFloat2;
      }
      if ((this.o) && (i1 == 1)) {
        return 1.0F;
      }
    }
    return 0.0F;
  }
  
  private float h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = e(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = g(paramFloat4, paramFloat1);
    paramFloat1 = g(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat1 < 0.0F)
    {
      paramFloat1 = -this.b.getInterpolation(-paramFloat1);
    }
    else
    {
      if (paramFloat1 <= 0.0F) {
        break label76;
      }
      paramFloat1 = this.b.getInterpolation(paramFloat1);
    }
    return e(paramFloat1, -1.0F, 1.0F);
    label76:
    return 0.0F;
  }
  
  private void i()
  {
    if (this.m)
    {
      this.o = false;
      return;
    }
    this.a.i();
  }
  
  private void v()
  {
    if (this.d == null) {
      this.d = new b();
    }
    this.o = true;
    this.m = true;
    if (!this.l)
    {
      int i1 = this.h;
      if (i1 > 0)
      {
        x.j0(this.c, this.d, i1);
        break label70;
      }
    }
    this.d.run();
    label70:
    this.l = true;
  }
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean b(int paramInt);
  
  void c()
  {
    long l1 = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
    this.c.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public abstract void j(int paramInt1, int paramInt2);
  
  public a k(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public a l(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public a m(boolean paramBoolean)
  {
    if ((this.p) && (!paramBoolean)) {
      i();
    }
    this.p = paramBoolean;
    return this;
  }
  
  public a n(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.f;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public a o(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.k;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.p;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          if (i1 != 3) {
            break label140;
          }
        }
      }
      else
      {
        i();
        break label140;
      }
    }
    else
    {
      this.n = true;
      this.l = false;
    }
    float f1 = d(0, paramMotionEvent.getX(), paramView.getWidth(), this.c.getWidth());
    float f2 = d(1, paramMotionEvent.getY(), paramView.getHeight(), this.c.getHeight());
    this.a.l(f1, f2);
    if ((!this.o) && (u())) {
      v();
    }
    label140:
    bool1 = bool2;
    if (this.q)
    {
      bool1 = bool2;
      if (this.o) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public a p(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.j;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public a q(int paramInt)
  {
    this.a.j(paramInt);
    return this;
  }
  
  public a r(int paramInt)
  {
    this.a.k(paramInt);
    return this;
  }
  
  public a s(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.e;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public a t(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  boolean u()
  {
    a locala = this.a;
    int i1 = locala.f();
    int i2 = locala.d();
    return ((i1 != 0) && (b(i1))) || ((i2 != 0) && (a(i2)));
  }
  
  private static class a
  {
    private int a;
    private int b;
    private float c;
    private float d;
    private long e = -9223372036854775808L;
    private long f = 0L;
    private int g = 0;
    private int h = 0;
    private long i = -1L;
    private float j;
    private int k;
    
    private float e(long paramLong)
    {
      long l1 = this.e;
      if (paramLong < l1) {
        return 0.0F;
      }
      long l2 = this.i;
      if ((l2 >= 0L) && (paramLong >= l2))
      {
        float f1 = this.j;
        return 1.0F - f1 + f1 * a.e((float)(paramLong - l2) / this.k, 0.0F, 1.0F);
      }
      return a.e((float)(paramLong - l1) / this.a, 0.0F, 1.0F) * 0.5F;
    }
    
    private float g(float paramFloat)
    {
      return -4.0F * paramFloat * paramFloat + paramFloat * 4.0F;
    }
    
    public void a()
    {
      if (this.f != 0L)
      {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        float f1 = g(e(l1));
        long l2 = this.f;
        this.f = l1;
        f1 = (float)(l1 - l2) * f1;
        this.g = ((int)(this.c * f1));
        this.h = ((int)(f1 * this.d));
        return;
      }
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    
    public int b()
    {
      return this.g;
    }
    
    public int c()
    {
      return this.h;
    }
    
    public int d()
    {
      float f1 = this.c;
      return (int)(f1 / Math.abs(f1));
    }
    
    public int f()
    {
      float f1 = this.d;
      return (int)(f1 / Math.abs(f1));
    }
    
    public boolean h()
    {
      return (this.i > 0L) && (AnimationUtils.currentAnimationTimeMillis() > this.i + this.k);
    }
    
    public void i()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.k = a.f((int)(l - this.e), 0, this.b);
      this.j = e(l);
      this.i = l;
    }
    
    public void j(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void k(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void l(float paramFloat1, float paramFloat2)
    {
      this.c = paramFloat1;
      this.d = paramFloat2;
    }
    
    public void m()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.e = l;
      this.i = -1L;
      this.f = l;
      this.j = 0.5F;
      this.g = 0;
      this.h = 0;
    }
  }
  
  private class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      Object localObject = a.this;
      if (!((a)localObject).o) {
        return;
      }
      if (((a)localObject).m)
      {
        ((a)localObject).m = false;
        ((a)localObject).a.m();
      }
      localObject = a.this.a;
      if ((!((a.a)localObject).h()) && (a.this.u()))
      {
        a locala = a.this;
        if (locala.n)
        {
          locala.n = false;
          locala.c();
        }
        ((a.a)localObject).a();
        int i = ((a.a)localObject).b();
        int j = ((a.a)localObject).c();
        a.this.j(i, j);
        x.i0(a.this.c, this);
        return;
      }
      a.this.o = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.a
 * JD-Core Version:    0.7.0.1
 */