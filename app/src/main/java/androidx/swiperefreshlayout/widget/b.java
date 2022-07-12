package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import x0.h;

public class b
  extends Drawable
  implements Animatable
{
  private static final Interpolator g = new LinearInterpolator();
  private static final Interpolator h = new i1.b();
  private static final int[] i = { -16777216 };
  private final c a;
  private float b;
  private Resources c;
  private Animator d;
  float e;
  boolean f;
  
  public b(Context paramContext)
  {
    this.c = ((Context)h.g(paramContext)).getResources();
    paramContext = new c();
    this.a = paramContext;
    paramContext.u(i);
    k(2.5F);
    m();
  }
  
  private void a(float paramFloat, c paramc)
  {
    n(paramFloat, paramc);
    float f1 = (float)(Math.floor(paramc.j() / 0.8F) + 1.0D);
    paramc.y(paramc.k() + (paramc.i() - 0.01F - paramc.k()) * paramFloat);
    paramc.v(paramc.i());
    paramc.w(paramc.j() + (f1 - paramc.j()) * paramFloat);
  }
  
  private int c(float paramFloat, int paramInt1, int paramInt2)
  {
    int j = paramInt1 >> 24 & 0xFF;
    int k = paramInt1 >> 16 & 0xFF;
    int m = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return j + (int)(((paramInt2 >> 24 & 0xFF) - j) * paramFloat) << 24 | k + (int)(((paramInt2 >> 16 & 0xFF) - k) * paramFloat) << 16 | m + (int)(((paramInt2 >> 8 & 0xFF) - m) * paramFloat) << 8 | paramInt1 + (int)(paramFloat * ((paramInt2 & 0xFF) - paramInt1));
  }
  
  private void h(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  private void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c localc = this.a;
    float f1 = this.c.getDisplayMetrics().density;
    localc.z(paramFloat2 * f1);
    localc.q(paramFloat1 * f1);
    localc.t(0);
    localc.o(paramFloat3 * f1, paramFloat4 * f1);
  }
  
  private void m()
  {
    final c localc = this.a;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new a(localc));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(g);
    localValueAnimator.addListener(new b(localc));
    this.d = localValueAnimator;
  }
  
  void b(float paramFloat, c paramc, boolean paramBoolean)
  {
    if (this.f)
    {
      a(paramFloat, paramc);
      return;
    }
    if ((paramFloat != 1.0F) || (paramBoolean))
    {
      float f3 = paramc.j();
      float f1;
      float f2;
      if (paramFloat < 0.5F)
      {
        f1 = paramFloat / 0.5F;
        f2 = paramc.k();
        f1 = h.getInterpolation(f1) * 0.79F + 0.01F + f2;
      }
      else
      {
        f2 = (paramFloat - 0.5F) / 0.5F;
        f1 = paramc.k() + 0.79F;
        f2 = f1 - ((1.0F - h.getInterpolation(f2)) * 0.79F + 0.01F);
      }
      float f4 = this.e;
      paramc.y(f2);
      paramc.v(f1);
      paramc.w(f3 + 0.21F * paramFloat);
      h((paramFloat + f4) * 216.0F);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.x(paramBoolean);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.b, localRect.exactCenterX(), localRect.exactCenterY());
    this.a.a(paramCanvas, localRect);
    paramCanvas.restore();
  }
  
  public void e(float paramFloat)
  {
    this.a.p(paramFloat);
    invalidateSelf();
  }
  
  public void f(int... paramVarArgs)
  {
    this.a.u(paramVarArgs);
    this.a.t(0);
    invalidateSelf();
  }
  
  public void g(float paramFloat)
  {
    this.a.w(paramFloat);
    invalidateSelf();
  }
  
  public int getAlpha()
  {
    return this.a.c();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.d.isRunning();
  }
  
  public void j(float paramFloat1, float paramFloat2)
  {
    this.a.y(paramFloat1);
    this.a.v(paramFloat2);
    invalidateSelf();
  }
  
  public void k(float paramFloat)
  {
    this.a.z(paramFloat);
    invalidateSelf();
  }
  
  public void l(int paramInt)
  {
    float f4;
    float f1;
    float f2;
    float f3;
    if (paramInt == 0)
    {
      f4 = 11.0F;
      f1 = 3.0F;
      f2 = 12.0F;
      f3 = 6.0F;
    }
    else
    {
      f4 = 7.5F;
      f1 = 2.5F;
      f2 = 10.0F;
      f3 = 5.0F;
    }
    i(f4, f1, f2, f3);
    invalidateSelf();
  }
  
  void n(float paramFloat, c paramc)
  {
    int j;
    if (paramFloat > 0.75F) {
      j = c((paramFloat - 0.75F) / 0.25F, paramc.h(), paramc.e());
    } else {
      j = paramc.h();
    }
    paramc.r(j);
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.n(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.s(paramColorFilter);
    invalidateSelf();
  }
  
  public void start()
  {
    this.d.cancel();
    this.a.A();
    Animator localAnimator;
    long l;
    if (this.a.d() != this.a.g())
    {
      this.f = true;
      localAnimator = this.d;
      l = 666L;
    }
    else
    {
      this.a.t(0);
      this.a.m();
      localAnimator = this.d;
      l = 1332L;
    }
    localAnimator.setDuration(l);
    this.d.start();
  }
  
  public void stop()
  {
    this.d.cancel();
    h(0.0F);
    this.a.x(false);
    this.a.t(0);
    this.a.m();
    invalidateSelf();
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(b.c paramc) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      b.this.n(f, localc);
      b.this.b(f, localc, false);
      b.this.invalidateSelf();
    }
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b(b.c paramc) {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      b.this.b(1.0F, localc, true);
      localc.A();
      localc.l();
      b localb = b.this;
      if (localb.f)
      {
        localb.f = false;
        paramAnimator.cancel();
        paramAnimator.setDuration(1332L);
        paramAnimator.start();
        localc.x(false);
        return;
      }
      localb.e += 1.0F;
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      b.this.e = 0.0F;
    }
  }
  
  private static class c
  {
    final RectF a = new RectF();
    final Paint b;
    final Paint c;
    final Paint d;
    float e;
    float f;
    float g;
    float h;
    int[] i;
    int j;
    float k;
    float l;
    float m;
    boolean n;
    Path o;
    float p;
    float q;
    int r;
    int s;
    int t;
    int u;
    
    c()
    {
      Paint localPaint1 = new Paint();
      this.b = localPaint1;
      Paint localPaint2 = new Paint();
      this.c = localPaint2;
      Paint localPaint3 = new Paint();
      this.d = localPaint3;
      this.e = 0.0F;
      this.f = 0.0F;
      this.g = 0.0F;
      this.h = 5.0F;
      this.p = 1.0F;
      this.t = 255;
      localPaint1.setStrokeCap(Paint.Cap.SQUARE);
      localPaint1.setAntiAlias(true);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setStyle(Paint.Style.FILL);
      localPaint2.setAntiAlias(true);
      localPaint3.setColor(0);
    }
    
    void A()
    {
      this.k = this.e;
      this.l = this.f;
      this.m = this.g;
    }
    
    void a(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = this.a;
      float f2 = this.q;
      float f1 = this.h / 2.0F + f2;
      if (f2 <= 0.0F) {
        f1 = Math.min(paramRect.width(), paramRect.height()) / 2.0F - Math.max(this.r * this.p / 2.0F, this.h / 2.0F);
      }
      localRectF.set(paramRect.centerX() - f1, paramRect.centerY() - f1, paramRect.centerX() + f1, paramRect.centerY() + f1);
      f1 = this.e;
      f2 = this.g;
      f1 = (f1 + f2) * 360.0F;
      f2 = (this.f + f2) * 360.0F - f1;
      this.b.setColor(this.u);
      this.b.setAlpha(this.t);
      float f3 = this.h / 2.0F;
      localRectF.inset(f3, f3);
      paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, this.d);
      f3 = -f3;
      localRectF.inset(f3, f3);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      b(paramCanvas, f1, f2, localRectF);
    }
    
    void b(Canvas paramCanvas, float paramFloat1, float paramFloat2, RectF paramRectF)
    {
      if (this.n)
      {
        Path localPath = this.o;
        if (localPath == null)
        {
          localPath = new Path();
          this.o = localPath;
          localPath.setFillType(Path.FillType.EVEN_ODD);
        }
        else
        {
          localPath.reset();
        }
        float f1 = Math.min(paramRectF.width(), paramRectF.height()) / 2.0F;
        float f2 = this.r * this.p / 2.0F;
        this.o.moveTo(0.0F, 0.0F);
        this.o.lineTo(this.r * this.p, 0.0F);
        localPath = this.o;
        float f3 = this.r;
        float f4 = this.p;
        localPath.lineTo(f3 * f4 / 2.0F, this.s * f4);
        this.o.offset(f1 + paramRectF.centerX() - f2, paramRectF.centerY() + this.h / 2.0F);
        this.o.close();
        this.c.setColor(this.u);
        this.c.setAlpha(this.t);
        paramCanvas.save();
        paramCanvas.rotate(paramFloat1 + paramFloat2, paramRectF.centerX(), paramRectF.centerY());
        paramCanvas.drawPath(this.o, this.c);
        paramCanvas.restore();
      }
    }
    
    int c()
    {
      return this.t;
    }
    
    float d()
    {
      return this.f;
    }
    
    int e()
    {
      return this.i[f()];
    }
    
    int f()
    {
      return (this.j + 1) % this.i.length;
    }
    
    float g()
    {
      return this.e;
    }
    
    int h()
    {
      return this.i[this.j];
    }
    
    float i()
    {
      return this.l;
    }
    
    float j()
    {
      return this.m;
    }
    
    float k()
    {
      return this.k;
    }
    
    void l()
    {
      t(f());
    }
    
    void m()
    {
      this.k = 0.0F;
      this.l = 0.0F;
      this.m = 0.0F;
      y(0.0F);
      v(0.0F);
      w(0.0F);
    }
    
    void n(int paramInt)
    {
      this.t = paramInt;
    }
    
    void o(float paramFloat1, float paramFloat2)
    {
      this.r = ((int)paramFloat1);
      this.s = ((int)paramFloat2);
    }
    
    void p(float paramFloat)
    {
      if (paramFloat != this.p) {
        this.p = paramFloat;
      }
    }
    
    void q(float paramFloat)
    {
      this.q = paramFloat;
    }
    
    void r(int paramInt)
    {
      this.u = paramInt;
    }
    
    void s(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
    
    void t(int paramInt)
    {
      this.j = paramInt;
      this.u = this.i[paramInt];
    }
    
    void u(int[] paramArrayOfInt)
    {
      this.i = paramArrayOfInt;
      t(0);
    }
    
    void v(float paramFloat)
    {
      this.f = paramFloat;
    }
    
    void w(float paramFloat)
    {
      this.g = paramFloat;
    }
    
    void x(boolean paramBoolean)
    {
      if (this.n != paramBoolean) {
        this.n = paramBoolean;
      }
    }
    
    void y(float paramFloat)
    {
      this.e = paramFloat;
    }
    
    void z(float paramFloat)
    {
      this.h = paramFloat;
      this.b.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.swiperefreshlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */