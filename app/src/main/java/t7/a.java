package t7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import o7.c;
import o7.d;
import r7.f;
import r7.g;
import r7.h;
import r7.j;

public class a
  extends h
  implements com.google.android.material.internal.m.b
{
  private static final int R = R.style.Widget_MaterialComponents_Tooltip;
  private static final int S = R.attr.tooltipStyle;
  private final Context A;
  private final Paint.FontMetrics B = new Paint.FontMetrics();
  private final com.google.android.material.internal.m C;
  private final View.OnLayoutChangeListener E;
  private final Rect F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private float M;
  private float N;
  private final float O;
  private float P;
  private float Q;
  private CharSequence z;
  
  private a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramAttributeSet = new com.google.android.material.internal.m(this);
    this.C = paramAttributeSet;
    this.E = new a();
    this.F = new Rect();
    this.M = 1.0F;
    this.N = 1.0F;
    this.O = 0.5F;
    this.P = 0.5F;
    this.Q = 1.0F;
    this.A = paramContext;
    paramAttributeSet.e().density = paramContext.getResources().getDisplayMetrics().density;
    paramAttributeSet.e().setTextAlign(Paint.Align.CENTER);
  }
  
  private void E0(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.L = arrayOfInt[0];
    paramView.getWindowVisibleDisplayFrame(this.F);
  }
  
  private float r0()
  {
    if (this.F.right - getBounds().right - this.L - this.J < 0) {}
    for (int i = this.F.right - getBounds().right - this.L - this.J;; i = this.F.left - getBounds().left - this.L + this.J)
    {
      return i;
      if (this.F.left - getBounds().left - this.L + this.J <= 0) {
        break;
      }
    }
    return 0.0F;
  }
  
  private float s0()
  {
    this.C.e().getFontMetrics(this.B);
    Paint.FontMetrics localFontMetrics = this.B;
    return (localFontMetrics.descent + localFontMetrics.ascent) / 2.0F;
  }
  
  private float t0(Rect paramRect)
  {
    return paramRect.centerY() - s0();
  }
  
  public static a u0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = new a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.z0(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private f v0()
  {
    float f1 = -r0();
    float f2 = (float)(getBounds().width() - this.K * Math.sqrt(2.0D)) / 2.0F;
    f1 = Math.min(Math.max(f1, -f2), f2);
    return new j(new g(this.K), f1);
  }
  
  private void x0(Canvas paramCanvas)
  {
    if (this.z == null) {
      return;
    }
    Rect localRect = getBounds();
    int i = (int)t0(localRect);
    if (this.C.d() != null)
    {
      this.C.e().drawableState = getState();
      this.C.j(this.A);
      this.C.e().setAlpha((int)(this.Q * 255.0F));
    }
    CharSequence localCharSequence = this.z;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect.centerX(), i, this.C.e());
  }
  
  private float y0()
  {
    CharSequence localCharSequence = this.z;
    if (localCharSequence == null) {
      return 0.0F;
    }
    return this.C.f(localCharSequence.toString());
  }
  
  private void z0(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = p.h(this.A, paramAttributeSet, R.styleable.Tooltip, paramInt1, paramInt2, new int[0]);
    this.K = this.A.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
    setShapeAppearanceModel(E().v().s(v0()).m());
    C0(paramAttributeSet.getText(R.styleable.Tooltip_android_text));
    d locald = c.g(this.A, paramAttributeSet, R.styleable.Tooltip_android_textAppearance);
    if (locald != null)
    {
      paramInt1 = R.styleable.Tooltip_android_textColor;
      if (paramAttributeSet.hasValue(paramInt1)) {
        locald.k(c.a(this.A, paramAttributeSet, paramInt1));
      }
    }
    D0(locald);
    paramInt1 = g7.a.c(this.A, R.attr.colorOnBackground, a.class.getCanonicalName());
    paramInt1 = g7.a.g(q0.a.o(g7.a.c(this.A, 16842801, a.class.getCanonicalName()), 229), q0.a.o(paramInt1, 153));
    b0(ColorStateList.valueOf(paramAttributeSet.getColor(R.styleable.Tooltip_backgroundTint, paramInt1)));
    l0(ColorStateList.valueOf(g7.a.c(this.A, R.attr.colorSurface, a.class.getCanonicalName())));
    this.G = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
    this.H = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
    this.I = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
    this.J = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
    paramAttributeSet.recycle();
  }
  
  public void A0(View paramView)
  {
    if (paramView == null) {
      return;
    }
    E0(paramView);
    paramView.addOnLayoutChangeListener(this.E);
  }
  
  public void B0(float paramFloat)
  {
    this.P = 1.2F;
    this.M = paramFloat;
    this.N = paramFloat;
    this.Q = e7.a.b(0.0F, 1.0F, 0.19F, 1.0F, paramFloat);
    invalidateSelf();
  }
  
  public void C0(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(this.z, paramCharSequence))
    {
      this.z = paramCharSequence;
      this.C.i(true);
      invalidateSelf();
    }
  }
  
  public void D0(d paramd)
  {
    this.C.h(paramd, this.A);
  }
  
  public void a()
  {
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    float f1 = r0();
    float f2 = (float)-(this.K * Math.sqrt(2.0D) - this.K);
    paramCanvas.scale(this.M, this.N, getBounds().left + getBounds().width() * 0.5F, getBounds().top + getBounds().height() * this.P);
    paramCanvas.translate(f1, f2);
    super.draw(paramCanvas);
    x0(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)Math.max(this.C.e().getTextSize(), this.I);
  }
  
  public int getIntrinsicWidth()
  {
    return (int)Math.max(this.G * 2 + y0(), this.H);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    setShapeAppearanceModel(E().v().s(v0()).m());
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void w0(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.removeOnLayoutChangeListener(this.E);
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    a() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      a.q0(a.this, paramView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t7.a
 * JD-Core Version:    0.7.0.1
 */