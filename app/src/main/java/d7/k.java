package d7;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;

public class k
  implements View.OnTouchListener, View.OnLayoutChangeListener
{
  private static float G = 3.0F;
  private static float H = 1.75F;
  private static float I = 1.0F;
  private static int J = 200;
  private static int K = 1;
  private int A = 2;
  private float B;
  private boolean C = true;
  private ImageView.ScaleType E = ImageView.ScaleType.FIT_CENTER;
  private c F = new a();
  private Interpolator a = new AccelerateDecelerateInterpolator();
  private int b = J;
  private float c = I;
  private float d = H;
  private float e = G;
  private boolean f = true;
  private boolean g = false;
  private ImageView h;
  private GestureDetector i;
  private b j;
  private final Matrix k = new Matrix();
  private final Matrix l = new Matrix();
  private final Matrix m = new Matrix();
  private final RectF n = new RectF();
  private final float[] o = new float[9];
  private d p;
  private f q;
  private e r;
  private j s;
  private View.OnClickListener t;
  private View.OnLongClickListener u;
  private g v;
  private h w;
  private i x;
  private f y;
  private int z = 2;
  
  public k(ImageView paramImageView)
  {
    this.h = paramImageView;
    paramImageView.setOnTouchListener(this);
    paramImageView.addOnLayoutChangeListener(this);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.B = 0.0F;
    this.j = new b(paramImageView.getContext(), this.F);
    paramImageView = new GestureDetector(paramImageView.getContext(), new b());
    this.i = paramImageView;
    paramImageView.setOnDoubleTapListener(new c());
  }
  
  private void A()
  {
    f localf = this.y;
    if (localf != null)
    {
      localf.a();
      this.y = null;
    }
  }
  
  private void B()
  {
    if (C()) {
      R(F());
    }
  }
  
  private boolean C()
  {
    RectF localRectF = E(F());
    if (localRectF == null) {
      return false;
    }
    float f3 = localRectF.height();
    float f4 = localRectF.width();
    float f1 = H(this.h);
    float f2 = 0.0F;
    int i1;
    if (f3 <= f1)
    {
      i1 = d.a[this.E.ordinal()];
      if (i1 != 2)
      {
        f3 = f1 - f3;
        f1 = f3;
        if (i1 != 3) {
          f1 = f3 / 2.0F;
        }
        f1 -= localRectF.top;
      }
      else
      {
        f1 = -localRectF.top;
      }
      this.A = 2;
    }
    else
    {
      f3 = localRectF.top;
      if (f3 > 0.0F)
      {
        this.A = 0;
        f1 = -f3;
      }
      else
      {
        f3 = localRectF.bottom;
        if (f3 < f1)
        {
          this.A = 1;
          f1 -= f3;
        }
        else
        {
          this.A = -1;
          f1 = 0.0F;
        }
      }
    }
    f3 = I(this.h);
    if (f4 <= f3)
    {
      i1 = d.a[this.E.ordinal()];
      if (i1 != 2)
      {
        f3 -= f4;
        f2 = f3;
        if (i1 != 3) {
          f2 = f3 / 2.0F;
        }
        f2 -= localRectF.left;
      }
      else
      {
        f2 = -localRectF.left;
      }
      this.z = 2;
    }
    else
    {
      f4 = localRectF.left;
      if (f4 > 0.0F)
      {
        this.z = 0;
        f2 = -f4;
      }
      else
      {
        f4 = localRectF.right;
        if (f4 < f3)
        {
          f2 = f3 - f4;
          this.z = 1;
        }
        else
        {
          this.z = -1;
        }
      }
    }
    this.m.postTranslate(f2, f1);
    return true;
  }
  
  private RectF E(Matrix paramMatrix)
  {
    Drawable localDrawable = this.h.getDrawable();
    if (localDrawable != null)
    {
      this.n.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.n);
      return this.n;
    }
    return null;
  }
  
  private Matrix F()
  {
    this.l.set(this.k);
    this.l.postConcat(this.m);
    return this.l;
  }
  
  private int H(ImageView paramImageView)
  {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private int I(ImageView paramImageView)
  {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private float O(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.o);
    return this.o[paramInt];
  }
  
  private void P()
  {
    this.m.reset();
    f0(this.B);
    R(F());
    C();
  }
  
  private void R(Matrix paramMatrix)
  {
    this.h.setImageMatrix(paramMatrix);
    if (this.p != null)
    {
      paramMatrix = E(paramMatrix);
      if (paramMatrix != null) {
        this.p.a(paramMatrix);
      }
    }
  }
  
  private void o0(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    float f2 = I(this.h);
    float f3 = H(this.h);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.k.reset();
    float f4 = i1;
    float f1 = f2 / f4;
    float f5 = i2;
    float f6 = f3 / f5;
    paramDrawable = this.E;
    if (paramDrawable == ImageView.ScaleType.CENTER)
    {
      this.k.postTranslate((f2 - f4) / 2.0F, (f3 - f5) / 2.0F);
    }
    else
    {
      if (paramDrawable == ImageView.ScaleType.CENTER_CROP) {}
      for (f1 = Math.max(f1, f6);; f1 = Math.min(1.0F, Math.min(f1, f6)))
      {
        this.k.postScale(f1, f1);
        this.k.postTranslate((f2 - f4 * f1) / 2.0F, (f3 - f5 * f1) / 2.0F);
        break label332;
        if (paramDrawable != ImageView.ScaleType.CENTER_INSIDE) {
          break;
        }
      }
      RectF localRectF1 = new RectF(0.0F, 0.0F, f4, f5);
      RectF localRectF2 = new RectF(0.0F, 0.0F, f2, f3);
      if ((int)this.B % 180 != 0) {
        localRectF1 = new RectF(0.0F, 0.0F, f5, f4);
      }
      i1 = d.a[this.E.ordinal()];
      Matrix localMatrix;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              break label332;
            }
            localMatrix = this.k;
            paramDrawable = Matrix.ScaleToFit.FILL;
          }
          else
          {
            localMatrix = this.k;
            paramDrawable = Matrix.ScaleToFit.END;
          }
        }
        else
        {
          localMatrix = this.k;
          paramDrawable = Matrix.ScaleToFit.START;
        }
      }
      else
      {
        localMatrix = this.k;
        paramDrawable = Matrix.ScaleToFit.CENTER;
      }
      localMatrix.setRectToRect(localRectF1, localRectF2, paramDrawable);
    }
    label332:
    P();
  }
  
  public RectF D()
  {
    C();
    return E(F());
  }
  
  public Matrix G()
  {
    return this.l;
  }
  
  public float J()
  {
    return this.e;
  }
  
  public float K()
  {
    return this.d;
  }
  
  public float L()
  {
    return this.c;
  }
  
  public float M()
  {
    return (float)Math.sqrt((float)Math.pow(O(this.m, 0), 2.0D) + (float)Math.pow(O(this.m, 3), 2.0D));
  }
  
  public ImageView.ScaleType N()
  {
    return this.E;
  }
  
  public void Q(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void S(float paramFloat)
  {
    l.a(this.c, this.d, paramFloat);
    this.e = paramFloat;
  }
  
  public void T(float paramFloat)
  {
    l.a(this.c, paramFloat, this.e);
    this.d = paramFloat;
  }
  
  public void U(float paramFloat)
  {
    l.a(paramFloat, this.d, this.e);
    this.c = paramFloat;
  }
  
  public void V(View.OnClickListener paramOnClickListener)
  {
    this.t = paramOnClickListener;
  }
  
  public void W(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.i.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void X(View.OnLongClickListener paramOnLongClickListener)
  {
    this.u = paramOnLongClickListener;
  }
  
  public void Y(d paramd)
  {
    this.p = paramd;
  }
  
  public void Z(e parame)
  {
    this.r = parame;
  }
  
  public void a0(f paramf)
  {
    this.q = paramf;
  }
  
  public void b0(g paramg)
  {
    this.v = paramg;
  }
  
  public void c0(h paramh)
  {
    this.w = paramh;
  }
  
  public void d0(i parami)
  {
    this.x = parami;
  }
  
  public void e0(j paramj)
  {
    this.s = paramj;
  }
  
  public void f0(float paramFloat)
  {
    this.m.postRotate(paramFloat % 360.0F);
    B();
  }
  
  public void g0(float paramFloat)
  {
    this.m.setRotate(paramFloat % 360.0F);
    B();
  }
  
  public void h0(float paramFloat)
  {
    j0(paramFloat, false);
  }
  
  public void i0(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 >= this.c) && (paramFloat1 <= this.e))
    {
      if (paramBoolean)
      {
        this.h.post(new e(M(), paramFloat1, paramFloat2, paramFloat3));
        return;
      }
      this.m.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      B();
      return;
    }
    throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
  }
  
  public void j0(float paramFloat, boolean paramBoolean)
  {
    i0(paramFloat, this.h.getRight() / 2, this.h.getBottom() / 2, paramBoolean);
  }
  
  public void k0(ImageView.ScaleType paramScaleType)
  {
    if ((l.d(paramScaleType)) && (paramScaleType != this.E))
    {
      this.E = paramScaleType;
      n0();
    }
  }
  
  public void l0(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void m0(boolean paramBoolean)
  {
    this.C = paramBoolean;
    n0();
  }
  
  public void n0()
  {
    if (this.C)
    {
      o0(this.h.getDrawable());
      return;
    }
    P();
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      o0(this.h.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.C;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      bool1 = bool3;
      if (l.c((ImageView)paramView))
      {
        int i1 = paramMotionEvent.getAction();
        if (i1 != 0)
        {
          if ((i1 == 1) || (i1 == 3))
          {
            Object localObject;
            if (M() < this.c)
            {
              localObject = D();
              if (localObject == null) {
                break label195;
              }
              localObject = new e(M(), this.c, ((RectF)localObject).centerX(), ((RectF)localObject).centerY());
            }
            else
            {
              if (M() <= this.e) {
                break label195;
              }
              localObject = D();
              if (localObject == null) {
                break label195;
              }
              localObject = new e(M(), this.e, ((RectF)localObject).centerX(), ((RectF)localObject).centerY());
            }
            paramView.post((Runnable)localObject);
            bool1 = true;
            break label198;
          }
        }
        else
        {
          paramView = paramView.getParent();
          if (paramView != null) {
            paramView.requestDisallowInterceptTouchEvent(true);
          }
          A();
        }
        label195:
        bool1 = false;
        label198:
        paramView = this.j;
        if (paramView != null)
        {
          bool1 = paramView.e();
          bool4 = this.j.d();
          bool3 = this.j.f(paramMotionEvent);
          if ((!bool1) && (!this.j.e())) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          int i2;
          if ((!bool4) && (!this.j.d())) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          bool1 = bool2;
          if (i1 != 0)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = true;
            }
          }
          this.g = bool1;
          bool2 = bool3;
        }
        else
        {
          bool2 = bool1;
        }
        paramView = this.i;
        bool1 = bool2;
        if (paramView != null)
        {
          bool1 = bool2;
          if (paramView.onTouchEvent(paramMotionEvent)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  class a
    implements c
  {
    a() {}
    
    public void a(float paramFloat1, float paramFloat2)
    {
      if (k.a(k.this).e()) {
        return;
      }
      if (k.b(k.this) != null) {
        k.b(k.this).a(paramFloat1, paramFloat2);
      }
      k.m(k.this).postTranslate(paramFloat1, paramFloat2);
      k.s(k.this);
      ViewParent localViewParent = k.t(k.this).getParent();
      if ((k.u(k.this)) && (!k.a(k.this).e()) && (!k.v(k.this)))
      {
        if (((k.w(k.this) == 2) || ((k.w(k.this) == 0) && (paramFloat1 >= 1.0F)) || ((k.w(k.this) == 1) && (paramFloat1 <= -1.0F)) || ((k.x(k.this) == 0) && (paramFloat2 >= 1.0F)) || ((k.x(k.this) == 1) && (paramFloat2 <= -1.0F))) && (localViewParent != null)) {
          localViewParent.requestDisallowInterceptTouchEvent(false);
        }
      }
      else if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void b(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if ((k.this.M() < k.e(k.this)) || (paramFloat1 < 1.0F))
      {
        if (k.f(k.this) != null) {
          k.f(k.this).a(paramFloat1, paramFloat2, paramFloat3);
        }
        k.m(k.this).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        k.s(k.this);
      }
    }
    
    public void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      Object localObject = k.this;
      k.z((k)localObject, new k.f((k)localObject, k.t((k)localObject).getContext()));
      localObject = k.y(k.this);
      k localk = k.this;
      int i = k.c(localk, k.t(localk));
      localk = k.this;
      ((k.f)localObject).b(i, k.d(localk, k.t(localk)), (int)paramFloat3, (int)paramFloat4);
      k.t(k.this).post(k.y(k.this));
    }
  }
  
  class b
    extends GestureDetector.SimpleOnGestureListener
  {
    b() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (k.h(k.this) != null)
      {
        if (k.this.M() > k.i()) {
          return false;
        }
        if (paramMotionEvent1.getPointerCount() <= k.j())
        {
          if (paramMotionEvent2.getPointerCount() > k.j()) {
            return false;
          }
          return k.h(k.this).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
      }
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (k.g(k.this) != null) {
        k.g(k.this).onLongClick(k.t(k.this));
      }
    }
  }
  
  class c
    implements GestureDetector.OnDoubleTapListener
  {
    c() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      try
      {
        float f1 = k.this.M();
        float f2 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        if (f1 < k.this.K())
        {
          paramMotionEvent = k.this;
          f1 = paramMotionEvent.K();
        }
        for (;;)
        {
          paramMotionEvent.i0(f1, f2, f3, true);
          return true;
          if ((f1 >= k.this.K()) && (f1 < k.this.J()))
          {
            paramMotionEvent = k.this;
            f1 = paramMotionEvent.J();
          }
          else
          {
            paramMotionEvent = k.this;
            f1 = paramMotionEvent.L();
          }
        }
        return true;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (k.k(k.this) != null) {
        k.k(k.this).onClick(k.t(k.this));
      }
      RectF localRectF = k.this.D();
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if (k.l(k.this) != null) {
        k.l(k.this).a(k.t(k.this), f2, f1);
      }
      if (localRectF != null)
      {
        if (localRectF.contains(f2, f1))
        {
          f2 = (f2 - localRectF.left) / localRectF.width();
          f1 = (f1 - localRectF.top) / localRectF.height();
          if (k.n(k.this) != null) {
            k.n(k.this).G(k.t(k.this), f2, f1);
          }
          return true;
        }
        if (k.o(k.this) != null) {
          k.o(k.this).a(k.t(k.this));
        }
      }
      return false;
    }
  }
  
  private class e
    implements Runnable
  {
    private final float a;
    private final float b;
    private final long c;
    private final float d;
    private final float e;
    
    public e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = paramFloat3;
      this.b = paramFloat4;
      this.c = System.currentTimeMillis();
      this.d = paramFloat1;
      this.e = paramFloat2;
    }
    
    private float a()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.c) * 1.0F / k.q(k.this));
      return k.r(k.this).getInterpolation(f1);
    }
    
    public void run()
    {
      float f1 = a();
      float f2 = this.d;
      f2 = (f2 + (this.e - f2) * f1) / k.this.M();
      k.p(k.this).b(f2, this.a, this.b);
      if (f1 < 1.0F) {
        a.a(k.t(k.this), this);
      }
    }
  }
  
  private class f
    implements Runnable
  {
    private final OverScroller a;
    private int b;
    private int c;
    
    public f(Context paramContext)
    {
      this.a = new OverScroller(paramContext);
    }
    
    public void a()
    {
      this.a.forceFinished(true);
    }
    
    public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RectF localRectF = k.this.D();
      if (localRectF == null) {
        return;
      }
      int k = Math.round(-localRectF.left);
      float f = paramInt1;
      int j;
      int i;
      if (f < localRectF.width())
      {
        j = Math.round(localRectF.width() - f);
        i = 0;
      }
      else
      {
        paramInt1 = k;
        j = paramInt1;
        i = paramInt1;
      }
      int m = Math.round(-localRectF.top);
      f = paramInt2;
      if (f < localRectF.height())
      {
        paramInt2 = Math.round(localRectF.height() - f);
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = m;
        paramInt2 = paramInt1;
      }
      this.b = k;
      this.c = m;
      if ((k != j) || (m != paramInt2)) {
        this.a.fling(k, m, paramInt3, paramInt4, i, j, paramInt1, paramInt2, 0, 0);
      }
    }
    
    public void run()
    {
      if (this.a.isFinished()) {
        return;
      }
      if (this.a.computeScrollOffset())
      {
        int i = this.a.getCurrX();
        int j = this.a.getCurrY();
        k.m(k.this).postTranslate(this.b - i, this.c - j);
        k.s(k.this);
        this.b = i;
        this.c = j;
        a.a(k.t(k.this), this);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d7.k
 * JD-Core Version:    0.7.0.1
 */