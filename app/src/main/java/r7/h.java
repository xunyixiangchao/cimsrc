package r7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.R.attr;
import java.util.BitSet;

public class h
  extends Drawable
  implements p
{
  private static final String x = h.class.getSimpleName();
  private static final Paint y;
  private c a;
  private final o.g[] b = new o.g[4];
  private final o.g[] c = new o.g[4];
  private final BitSet d = new BitSet(8);
  private boolean e;
  private final Matrix f = new Matrix();
  private final Path g = new Path();
  private final Path h = new Path();
  private final RectF i = new RectF();
  private final RectF j = new RectF();
  private final Region k = new Region();
  private final Region l = new Region();
  private m m;
  private final Paint n;
  private final Paint o;
  private final q7.a p;
  private final n.b q;
  private final n r;
  private PorterDuffColorFilter s;
  private PorterDuffColorFilter t;
  private int u;
  private final RectF v;
  private boolean w;
  
  static
  {
    Paint localPaint = new Paint(1);
    y = localPaint;
    localPaint.setColor(-1);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  public h()
  {
    this(new m());
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(m.e(paramContext, paramAttributeSet, paramInt1, paramInt2).m());
  }
  
  private h(c paramc)
  {
    Paint localPaint1 = new Paint(1);
    this.n = localPaint1;
    Paint localPaint2 = new Paint(1);
    this.o = localPaint2;
    this.p = new q7.a();
    n localn;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      localn = n.k();
    } else {
      localn = new n();
    }
    this.r = localn;
    this.v = new RectF();
    this.w = true;
    this.a = paramc;
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint1.setStyle(Paint.Style.FILL);
    o0();
    n0(getState());
    this.q = new a();
  }
  
  public h(m paramm)
  {
    this(new c(paramm, null));
  }
  
  private float G()
  {
    if (P()) {
      return this.o.getStrokeWidth() / 2.0F;
    }
    return 0.0F;
  }
  
  private boolean N()
  {
    c localc = this.a;
    int i1 = localc.q;
    boolean bool = true;
    if ((i1 != 1) && (localc.r > 0))
    {
      if (i1 == 2) {
        return bool;
      }
      if (X()) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean O()
  {
    Paint.Style localStyle = this.a.v;
    return (localStyle == Paint.Style.FILL_AND_STROKE) || (localStyle == Paint.Style.FILL);
  }
  
  private boolean P()
  {
    Paint.Style localStyle = this.a.v;
    return ((localStyle == Paint.Style.FILL_AND_STROKE) || (localStyle == Paint.Style.STROKE)) && (this.o.getStrokeWidth() > 0.0F);
  }
  
  private void R()
  {
    super.invalidateSelf();
  }
  
  private void U(Canvas paramCanvas)
  {
    if (!N()) {
      return;
    }
    paramCanvas.save();
    W(paramCanvas);
    if (!this.w) {
      n(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      int i1 = (int)(this.v.width() - getBounds().width());
      int i2 = (int)(this.v.height() - getBounds().height());
      if ((i1 < 0) || (i2 < 0)) {
        break;
      }
      Bitmap localBitmap = Bitmap.createBitmap((int)this.v.width() + this.a.r * 2 + i1, (int)this.v.height() + this.a.r * 2 + i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = getBounds().left - this.a.r - i1;
      float f2 = getBounds().top - this.a.r - i2;
      localCanvas.translate(-f1, -f2);
      n(localCanvas);
      paramCanvas.drawBitmap(localBitmap, f1, f2, null);
      localBitmap.recycle();
    }
    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
  }
  
  private static int V(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }
  
  private void W(Canvas paramCanvas)
  {
    int i1 = B();
    int i2 = C();
    paramCanvas.translate(i1, i2);
  }
  
  private PorterDuffColorFilter f(Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i1 = paramPaint.getColor();
      int i2 = l(i1);
      this.u = i2;
      if (i2 != i1) {
        return new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN);
      }
    }
    return null;
  }
  
  private void g(RectF paramRectF, Path paramPath)
  {
    h(paramRectF, paramPath);
    if (this.a.j != 1.0F)
    {
      this.f.reset();
      Matrix localMatrix = this.f;
      float f1 = this.a.j;
      localMatrix.setScale(f1, f1, paramRectF.width() / 2.0F, paramRectF.height() / 2.0F);
      paramPath.transform(this.f);
    }
    paramPath.computeBounds(this.v, true);
  }
  
  private void i()
  {
    final float f1 = -G();
    m localm = E().y(new b(f1));
    this.m = localm;
    this.r.d(localm, this.a.k, v(), this.h);
  }
  
  private PorterDuffColorFilter j(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, boolean paramBoolean)
  {
    int i2 = paramColorStateList.getColorForState(getState(), 0);
    int i1 = i2;
    if (paramBoolean) {
      i1 = l(i2);
    }
    this.u = i1;
    return new PorterDuffColorFilter(i1, paramMode);
  }
  
  private PorterDuffColorFilter k(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, Paint paramPaint, boolean paramBoolean)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return j(paramColorStateList, paramMode, paramBoolean);
    }
    return f(paramPaint, paramBoolean);
  }
  
  public static h m(Context paramContext, float paramFloat)
  {
    int i1 = g7.a.c(paramContext, R.attr.colorSurface, h.class.getSimpleName());
    h localh = new h();
    localh.Q(paramContext);
    localh.b0(ColorStateList.valueOf(i1));
    localh.a0(paramFloat);
    return localh;
  }
  
  private void n(Canvas paramCanvas)
  {
    if (this.d.cardinality() > 0) {
      Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    }
    if (this.a.s != 0) {
      paramCanvas.drawPath(this.g, this.p.c());
    }
    int i1 = 0;
    while (i1 < 4)
    {
      this.b[i1].b(this.p, this.a.r, paramCanvas);
      this.c[i1].b(this.p, this.a.r, paramCanvas);
      i1 += 1;
    }
    if (this.w)
    {
      i1 = B();
      int i2 = C();
      paramCanvas.translate(-i1, -i2);
      paramCanvas.drawPath(this.g, y);
      paramCanvas.translate(i1, i2);
    }
  }
  
  private boolean n0(int[] paramArrayOfInt)
  {
    int i1;
    int i2;
    if (this.a.d != null)
    {
      i1 = this.n.getColor();
      i2 = this.a.d.getColorForState(paramArrayOfInt, i1);
      if (i1 != i2)
      {
        this.n.setColor(i2);
        bool = true;
        break label53;
      }
    }
    boolean bool = false;
    label53:
    if (this.a.e != null)
    {
      i1 = this.o.getColor();
      i2 = this.a.e.getColorForState(paramArrayOfInt, i1);
      if (i1 != i2)
      {
        this.o.setColor(i2);
        return true;
      }
    }
    return bool;
  }
  
  private void o(Canvas paramCanvas)
  {
    q(paramCanvas, this.n, this.g, this.a.a, u());
  }
  
  private boolean o0()
  {
    PorterDuffColorFilter localPorterDuffColorFilter1 = this.s;
    PorterDuffColorFilter localPorterDuffColorFilter2 = this.t;
    Object localObject2 = this.a;
    Object localObject1 = ((c)localObject2).g;
    localObject2 = ((c)localObject2).h;
    Paint localPaint = this.n;
    boolean bool = true;
    this.s = k((ColorStateList)localObject1, (PorterDuff.Mode)localObject2, localPaint, true);
    localObject1 = this.a;
    this.t = k(((c)localObject1).f, ((c)localObject1).h, this.o, false);
    localObject1 = this.a;
    if (((c)localObject1).u) {
      this.p.d(((c)localObject1).g.getColorForState(getState(), 0));
    }
    if (x0.c.a(localPorterDuffColorFilter1, this.s))
    {
      if (!x0.c.a(localPorterDuffColorFilter2, this.t)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void p0()
  {
    float f1 = M();
    this.a.r = ((int)Math.ceil(0.75F * f1));
    this.a.s = ((int)Math.ceil(f1 * 0.25F));
    o0();
    R();
  }
  
  private void q(Canvas paramCanvas, Paint paramPaint, Path paramPath, m paramm, RectF paramRectF)
  {
    if (paramm.u(paramRectF))
    {
      float f1 = paramm.t().a(paramRectF) * this.a.k;
      paramCanvas.drawRoundRect(paramRectF, f1, f1, paramPaint);
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private RectF v()
  {
    this.j.set(u());
    float f1 = G();
    this.j.inset(f1, f1);
    return this.j;
  }
  
  public int A()
  {
    return this.u;
  }
  
  public int B()
  {
    c localc = this.a;
    return (int)(localc.s * Math.sin(Math.toRadians(localc.t)));
  }
  
  public int C()
  {
    c localc = this.a;
    return (int)(localc.s * Math.cos(Math.toRadians(localc.t)));
  }
  
  public int D()
  {
    return this.a.r;
  }
  
  public m E()
  {
    return this.a.a;
  }
  
  public ColorStateList F()
  {
    return this.a.e;
  }
  
  public float H()
  {
    return this.a.l;
  }
  
  public ColorStateList I()
  {
    return this.a.g;
  }
  
  public float J()
  {
    return this.a.a.r().a(u());
  }
  
  public float K()
  {
    return this.a.a.t().a(u());
  }
  
  public float L()
  {
    return this.a.p;
  }
  
  public float M()
  {
    return w() + L();
  }
  
  public void Q(Context paramContext)
  {
    this.a.b = new j7.a(paramContext);
    p0();
  }
  
  public boolean S()
  {
    j7.a locala = this.a.b;
    return (locala != null) && (locala.e());
  }
  
  public boolean T()
  {
    return this.a.a.u(u());
  }
  
  public boolean X()
  {
    int i1 = Build.VERSION.SDK_INT;
    return (!T()) && (!this.g.isConvex()) && (i1 < 29);
  }
  
  public void Y(float paramFloat)
  {
    setShapeAppearanceModel(this.a.a.w(paramFloat));
  }
  
  public void Z(c paramc)
  {
    setShapeAppearanceModel(this.a.a.x(paramc));
  }
  
  public void a0(float paramFloat)
  {
    c localc = this.a;
    if (localc.o != paramFloat)
    {
      localc.o = paramFloat;
      p0();
    }
  }
  
  public void b0(ColorStateList paramColorStateList)
  {
    c localc = this.a;
    if (localc.d != paramColorStateList)
    {
      localc.d = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void c0(float paramFloat)
  {
    c localc = this.a;
    if (localc.k != paramFloat)
    {
      localc.k = paramFloat;
      this.e = true;
      invalidateSelf();
    }
  }
  
  public void d0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c localc = this.a;
    if (localc.i == null) {
      localc.i = new Rect();
    }
    this.a.i.set(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.n.setColorFilter(this.s);
    int i1 = this.n.getAlpha();
    this.n.setAlpha(V(i1, this.a.m));
    this.o.setColorFilter(this.t);
    this.o.setStrokeWidth(this.a.l);
    int i2 = this.o.getAlpha();
    this.o.setAlpha(V(i2, this.a.m));
    if (this.e)
    {
      i();
      g(u(), this.g);
      this.e = false;
    }
    U(paramCanvas);
    if (O()) {
      o(paramCanvas);
    }
    if (P()) {
      r(paramCanvas);
    }
    this.n.setAlpha(i1);
    this.o.setAlpha(i2);
  }
  
  public void e0(Paint.Style paramStyle)
  {
    this.a.v = paramStyle;
    R();
  }
  
  public void f0(float paramFloat)
  {
    c localc = this.a;
    if (localc.n != paramFloat)
    {
      localc.n = paramFloat;
      p0();
    }
  }
  
  public void g0(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public int getAlpha()
  {
    return this.a.m;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(Outline paramOutline)
  {
    if (this.a.q == 2) {
      return;
    }
    if (T())
    {
      float f1 = J();
      float f2 = this.a.k;
      paramOutline.setRoundRect(getBounds(), f1 * f2);
      return;
    }
    g(u(), this.g);
    if ((this.g.isConvex()) || (Build.VERSION.SDK_INT >= 29)) {}
    try
    {
      paramOutline.setConvexPath(this.g);
      return;
    }
    catch (IllegalArgumentException paramOutline) {}
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Rect localRect = this.a.i;
    if (localRect != null)
    {
      paramRect.set(localRect);
      return true;
    }
    return super.getPadding(paramRect);
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.k.set(localRect);
    g(u(), this.g);
    this.l.setPath(this.g, this.k);
    this.k.op(this.l, Region.Op.DIFFERENCE);
    return this.k;
  }
  
  protected final void h(RectF paramRectF, Path paramPath)
  {
    n localn = this.r;
    c localc = this.a;
    localn.e(localc.a, localc.k, paramRectF, this.q, paramPath);
  }
  
  public void h0(int paramInt)
  {
    this.p.d(paramInt);
    this.a.u = false;
    R();
  }
  
  public void i0(int paramInt)
  {
    c localc = this.a;
    if (localc.q != paramInt)
    {
      localc.q = paramInt;
      R();
    }
  }
  
  public void invalidateSelf()
  {
    this.e = true;
    super.invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (!super.isStateful())
    {
      ColorStateList localColorStateList = this.a.g;
      if ((localColorStateList == null) || (!localColorStateList.isStateful()))
      {
        localColorStateList = this.a.f;
        if ((localColorStateList == null) || (!localColorStateList.isStateful()))
        {
          localColorStateList = this.a.e;
          if ((localColorStateList == null) || (!localColorStateList.isStateful()))
          {
            localColorStateList = this.a.d;
            if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
  
  public void j0(float paramFloat, int paramInt)
  {
    m0(paramFloat);
    l0(ColorStateList.valueOf(paramInt));
  }
  
  public void k0(float paramFloat, ColorStateList paramColorStateList)
  {
    m0(paramFloat);
    l0(paramColorStateList);
  }
  
  protected int l(int paramInt)
  {
    float f1 = M();
    float f2 = z();
    j7.a locala = this.a.b;
    int i1 = paramInt;
    if (locala != null) {
      i1 = locala.c(paramInt, f1 + f2);
    }
    return i1;
  }
  
  public void l0(ColorStateList paramColorStateList)
  {
    c localc = this.a;
    if (localc.e != paramColorStateList)
    {
      localc.e = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void m0(float paramFloat)
  {
    this.a.l = paramFloat;
    invalidateSelf();
  }
  
  public Drawable mutate()
  {
    this.a = new c(this.a);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.e = true;
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = n0(paramArrayOfInt);
    boolean bool2 = o0();
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  protected void p(Canvas paramCanvas, Paint paramPaint, Path paramPath, RectF paramRectF)
  {
    q(paramCanvas, paramPaint, paramPath, this.a.a, paramRectF);
  }
  
  protected void r(Canvas paramCanvas)
  {
    q(paramCanvas, this.o, this.h, this.m, v());
  }
  
  public float s()
  {
    return this.a.a.j().a(u());
  }
  
  public void setAlpha(int paramInt)
  {
    c localc = this.a;
    if (localc.m != paramInt)
    {
      localc.m = paramInt;
      R();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.c = paramColorFilter;
    R();
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    this.a.a = paramm;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.a.g = paramColorStateList;
    o0();
    R();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    c localc = this.a;
    if (localc.h != paramMode)
    {
      localc.h = paramMode;
      o0();
      R();
    }
  }
  
  public float t()
  {
    return this.a.a.l().a(u());
  }
  
  protected RectF u()
  {
    this.i.set(getBounds());
    return this.i;
  }
  
  public float w()
  {
    return this.a.o;
  }
  
  public ColorStateList x()
  {
    return this.a.d;
  }
  
  public float y()
  {
    return this.a.k;
  }
  
  public float z()
  {
    return this.a.n;
  }
  
  class a
    implements n.b
  {
    a() {}
    
    public void a(o paramo, Matrix paramMatrix, int paramInt)
    {
      h.b(h.this).set(paramInt, paramo.e());
      h.c(h.this)[paramInt] = paramo.f(paramMatrix);
    }
    
    public void b(o paramo, Matrix paramMatrix, int paramInt)
    {
      h.b(h.this).set(paramInt + 4, paramo.e());
      h.d(h.this)[paramInt] = paramo.f(paramMatrix);
    }
  }
  
  class b
    implements m.c
  {
    b(float paramFloat) {}
    
    public c a(c paramc)
    {
      if ((paramc instanceof k)) {
        return paramc;
      }
      return new b(f1, paramc);
    }
  }
  
  static final class c
    extends Drawable.ConstantState
  {
    public m a;
    public j7.a b;
    public ColorFilter c;
    public ColorStateList d = null;
    public ColorStateList e = null;
    public ColorStateList f = null;
    public ColorStateList g = null;
    public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public Rect i = null;
    public float j = 1.0F;
    public float k = 1.0F;
    public float l;
    public int m = 255;
    public float n = 0.0F;
    public float o = 0.0F;
    public float p = 0.0F;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public Paint.Style v = Paint.Style.FILL_AND_STROKE;
    
    public c(c paramc)
    {
      this.a = paramc.a;
      this.b = paramc.b;
      this.l = paramc.l;
      this.c = paramc.c;
      this.d = paramc.d;
      this.e = paramc.e;
      this.h = paramc.h;
      this.g = paramc.g;
      this.m = paramc.m;
      this.j = paramc.j;
      this.s = paramc.s;
      this.q = paramc.q;
      this.u = paramc.u;
      this.k = paramc.k;
      this.n = paramc.n;
      this.o = paramc.o;
      this.p = paramc.p;
      this.r = paramc.r;
      this.t = paramc.t;
      this.f = paramc.f;
      this.v = paramc.v;
      if (paramc.i != null) {
        this.i = new Rect(paramc.i);
      }
    }
    
    public c(m paramm, j7.a parama)
    {
      this.a = paramm;
      this.b = parama;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      h localh = new h(this, null);
      h.e(localh, true);
      return localh;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.h
 * JD-Core Version:    0.7.0.1
 */