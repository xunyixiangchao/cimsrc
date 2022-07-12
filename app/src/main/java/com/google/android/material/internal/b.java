package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import androidx.core.view.x;
import o7.a.a;
import o7.g;
import w0.c;
import x0.h;

public final class b
{
  private static final boolean t0 = false;
  private static final Paint u0 = null;
  private Typeface A;
  private Typeface B;
  private Typeface C;
  private Typeface D;
  private o7.a E;
  private o7.a F;
  private CharSequence G;
  private CharSequence H;
  private boolean I;
  private boolean J = true;
  private boolean K;
  private Bitmap L;
  private Paint M;
  private float N;
  private float O;
  private float P;
  private float Q;
  private float R;
  private int S;
  private int[] T;
  private boolean U;
  private final TextPaint V;
  private final TextPaint W;
  private TimeInterpolator X;
  private TimeInterpolator Y;
  private float Z;
  private final View a;
  private float a0;
  private boolean b;
  private float b0;
  private float c;
  private ColorStateList c0;
  private boolean d;
  private float d0;
  private float e;
  private float e0;
  private float f;
  private float f0;
  private int g;
  private ColorStateList g0;
  private final Rect h;
  private float h0;
  private final Rect i;
  private float i0;
  private final RectF j;
  private float j0;
  private int k = 16;
  private StaticLayout k0;
  private int l = 16;
  private float l0;
  private float m = 15.0F;
  private float m0;
  private float n = 15.0F;
  private float n0;
  private ColorStateList o;
  private CharSequence o0;
  private ColorStateList p;
  private int p0 = 1;
  private int q;
  private float q0 = 0.0F;
  private float r;
  private float r0 = 1.0F;
  private float s;
  private int s0 = l.n;
  private float t;
  private float u;
  private float v;
  private float w;
  private Typeface x;
  private Typeface y;
  private Typeface z;
  
  public b(View paramView)
  {
    this.a = paramView;
    TextPaint localTextPaint = new TextPaint(129);
    this.V = localTextPaint;
    this.W = new TextPaint(localTextPaint);
    this.i = new Rect();
    this.h = new Rect();
    this.j = new RectF();
    this.f = e();
    V(paramView.getContext().getResources().getConfiguration());
  }
  
  private boolean I0()
  {
    return (this.p0 > 1) && ((!this.I) || (this.d)) && (!this.K);
  }
  
  private Layout.Alignment K()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void N(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.n);
    paramTextPaint.setTypeface(this.x);
    paramTextPaint.setLetterSpacing(this.h0);
  }
  
  private void O(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.m);
    paramTextPaint.setTypeface(this.A);
    paramTextPaint.setLetterSpacing(this.i0);
  }
  
  private void P(float paramFloat)
  {
    if (this.d)
    {
      RectF localRectF = this.j;
      Rect localRect;
      if (paramFloat < this.f) {
        localRect = this.h;
      } else {
        localRect = this.i;
      }
      localRectF.set(localRect);
      return;
    }
    this.j.left = U(this.h.left, this.i.left, paramFloat, this.X);
    this.j.top = U(this.r, this.s, paramFloat, this.X);
    this.j.right = U(this.h.right, this.i.right, paramFloat, this.X);
    this.j.bottom = U(this.h.bottom, this.i.bottom, paramFloat, this.X);
  }
  
  private static boolean Q(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-005F;
  }
  
  private boolean R()
  {
    return x.B(this.a) == 1;
  }
  
  private boolean T(CharSequence paramCharSequence, boolean paramBoolean)
  {
    c localc;
    if (paramBoolean) {
      localc = w0.d.d;
    } else {
      localc = w0.d.c;
    }
    return localc.a(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private static float U(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramFloat3;
    if (paramTimeInterpolator != null) {
      f1 = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return e7.a.a(paramFloat1, paramFloat2, f1);
  }
  
  private float W(TextPaint paramTextPaint, CharSequence paramCharSequence)
  {
    return paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb(Math.round(f2 * f1 + f3 * paramFloat), Math.round(f4 * f1 + f5 * paramFloat), Math.round(f6 * f1 + f7 * paramFloat), Math.round(f8 * f1 + f9 * paramFloat));
  }
  
  private static boolean a0(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c()
  {
    g(this.c);
  }
  
  private float d(float paramFloat)
  {
    float f1 = this.f;
    if (paramFloat <= f1) {
      return e7.a.b(1.0F, 0.0F, this.e, f1, paramFloat);
    }
    return e7.a.b(0.0F, 1.0F, f1, 1.0F, paramFloat);
  }
  
  private float e()
  {
    float f1 = this.e;
    return f1 + (1.0F - f1) * 0.5F;
  }
  
  private void e0(float paramFloat)
  {
    this.m0 = paramFloat;
    x.h0(this.a);
  }
  
  private boolean f(CharSequence paramCharSequence)
  {
    boolean bool2 = R();
    boolean bool1 = bool2;
    if (this.J) {
      bool1 = T(paramCharSequence, bool2);
    }
    return bool1;
  }
  
  private void g(float paramFloat)
  {
    P(paramFloat);
    if (this.d)
    {
      if (paramFloat < this.f)
      {
        this.v = this.t;
        this.w = this.r;
        y0(0.0F);
        f1 = 0.0F;
      }
      else
      {
        this.v = this.u;
        this.w = (this.s - Math.max(0, this.g));
        y0(1.0F);
        f1 = 1.0F;
      }
    }
    else
    {
      this.v = U(this.t, this.u, paramFloat, this.X);
      this.w = U(this.r, this.s, paramFloat, this.X);
      y0(paramFloat);
      f1 = paramFloat;
    }
    TimeInterpolator localTimeInterpolator = e7.a.b;
    e0(1.0F - U(0.0F, 1.0F, 1.0F - paramFloat, localTimeInterpolator));
    o0(U(1.0F, 0.0F, paramFloat, localTimeInterpolator));
    if (this.p != this.o) {
      this.V.setColor(a(x(), v(), f1));
    } else {
      this.V.setColor(v());
    }
    float f1 = this.h0;
    float f2 = this.i0;
    if (f1 != f2) {
      this.V.setLetterSpacing(U(f2, f1, paramFloat, localTimeInterpolator));
    } else {
      this.V.setLetterSpacing(f1);
    }
    this.P = U(this.d0, this.Z, paramFloat, null);
    this.Q = U(this.e0, this.a0, paramFloat, null);
    this.R = U(this.f0, this.b0, paramFloat, null);
    int i1 = a(w(this.g0), w(this.c0), paramFloat);
    this.S = i1;
    this.V.setShadowLayer(this.P, this.Q, this.R, i1);
    if (this.d)
    {
      i1 = this.V.getAlpha();
      i1 = (int)(d(paramFloat) * i1);
      this.V.setAlpha(i1);
    }
    x.h0(this.a);
  }
  
  private void h(float paramFloat)
  {
    i(paramFloat, false);
  }
  
  private void i(float paramFloat, boolean paramBoolean)
  {
    if (this.G == null) {
      return;
    }
    float f3 = this.i.width();
    float f4 = this.h.width();
    boolean bool2 = Q(paramFloat, 1.0F);
    boolean bool1 = false;
    int i4 = 1;
    float f1;
    float f2;
    Object localObject;
    Typeface localTypeface;
    int i1;
    if (bool2)
    {
      f1 = this.n;
      f2 = this.h0;
      this.N = 1.0F;
      localObject = this.D;
      localTypeface = this.x;
      if (localObject != localTypeface)
      {
        this.D = localTypeface;
        i1 = 1;
        paramFloat = f3;
      }
      else
      {
        i1 = 0;
        paramFloat = f3;
      }
    }
    else
    {
      f1 = this.m;
      f2 = this.i0;
      localObject = this.D;
      localTypeface = this.A;
      if (localObject != localTypeface)
      {
        this.D = localTypeface;
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (Q(paramFloat, 0.0F)) {
        this.N = 1.0F;
      } else {
        this.N = (U(this.m, this.n, paramFloat, this.Y) / this.m);
      }
      paramFloat = this.n / this.m;
      if (paramBoolean) {}
      for (;;)
      {
        for (paramFloat = f4;; paramFloat = Math.min(f3 / paramFloat, f4))
        {
          break label234;
          if (f4 * paramFloat <= f3) {
            break;
          }
        }
      }
    }
    label234:
    int i2 = i1;
    if (paramFloat > 0.0F)
    {
      if (this.O != f1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      int i3;
      if (this.j0 != f2) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if ((i2 == 0) && (i3 == 0) && (!this.U) && (i1 == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      this.O = f1;
      this.j0 = f2;
      this.U = false;
      i2 = i1;
    }
    if ((this.H == null) || (i2 != 0))
    {
      this.V.setTextSize(this.O);
      this.V.setTypeface(this.D);
      this.V.setLetterSpacing(this.j0);
      localObject = this.V;
      paramBoolean = bool1;
      if (this.N != 1.0F) {
        paramBoolean = true;
      }
      ((TextPaint)localObject).setLinearText(paramBoolean);
      this.I = f(this.G);
      i1 = i4;
      if (I0()) {
        i1 = this.p0;
      }
      localObject = k(i1, paramFloat, this.I);
      this.k0 = ((StaticLayout)localObject);
      this.H = ((StaticLayout)localObject).getText();
    }
  }
  
  private boolean i0(Typeface paramTypeface)
  {
    Object localObject = this.F;
    if (localObject != null) {
      ((o7.a)localObject).c();
    }
    if (this.z != paramTypeface)
    {
      this.z = paramTypeface;
      localObject = g.b(this.a.getContext().getResources().getConfiguration(), paramTypeface);
      this.y = ((Typeface)localObject);
      paramTypeface = (Typeface)localObject;
      if (localObject == null) {
        paramTypeface = this.z;
      }
      this.x = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void j()
  {
    Bitmap localBitmap = this.L;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.L = null;
    }
  }
  
  private StaticLayout k(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt == 1) {}
    label19:
    Object localObject2;
    try
    {
      Object localObject1 = Layout.Alignment.ALIGN_NORMAL;
      break label19;
      localObject1 = K();
      localObject1 = l.b(this.G, this.V, (int)paramFloat).d(TextUtils.TruncateAt.END).g(paramBoolean).c((Layout.Alignment)localObject1).f(false).i(paramInt).h(this.q0, this.r0).e(this.s0).a();
    }
    catch (l.a locala)
    {
      Log.e("CollapsingTextHelper", locala.getCause().getMessage(), locala);
      localObject2 = null;
    }
    return (StaticLayout)h.g(localObject2);
  }
  
  private void m(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i1 = this.V.getAlpha();
    paramCanvas.translate(paramFloat1, paramFloat2);
    Object localObject = this.V;
    paramFloat1 = this.n0;
    paramFloat2 = i1;
    ((TextPaint)localObject).setAlpha((int)(paramFloat1 * paramFloat2));
    int i2 = Build.VERSION.SDK_INT;
    if (i2 >= 31)
    {
      localObject = this.V;
      ((TextPaint)localObject).setShadowLayer(this.P, this.Q, this.R, g7.a.a(this.S, ((TextPaint)localObject).getAlpha()));
    }
    this.k0.draw(paramCanvas);
    this.V.setAlpha((int)(this.m0 * paramFloat2));
    if (i2 >= 31)
    {
      localObject = this.V;
      ((TextPaint)localObject).setShadowLayer(this.P, this.Q, this.R, g7.a.a(this.S, ((TextPaint)localObject).getAlpha()));
    }
    int i3 = this.k0.getLineBaseline(0);
    localObject = this.o0;
    int i4 = ((CharSequence)localObject).length();
    paramFloat1 = i3;
    paramCanvas.drawText((CharSequence)localObject, 0, i4, 0.0F, paramFloat1, this.V);
    if (i2 >= 31) {
      this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
    }
    if (!this.d)
    {
      String str = this.o0.toString().trim();
      localObject = str;
      if (str.endsWith("…")) {
        localObject = str.substring(0, str.length() - 1);
      }
      this.V.setAlpha(i1);
      paramCanvas.drawText((String)localObject, 0, Math.min(this.k0.getLineEnd(0), ((String)localObject).length()), 0.0F, paramFloat1, this.V);
    }
  }
  
  private void n()
  {
    if ((this.L == null) && (!this.h.isEmpty()))
    {
      if (TextUtils.isEmpty(this.H)) {
        return;
      }
      g(0.0F);
      int i1 = this.k0.getWidth();
      int i2 = this.k0.getHeight();
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        this.L = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.L);
        this.k0.draw(localCanvas);
        if (this.M == null) {
          this.M = new Paint(3);
        }
      }
    }
  }
  
  private void o0(float paramFloat)
  {
    this.n0 = paramFloat;
    x.h0(this.a);
  }
  
  private float s(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.I) {
          return this.i.right - this.l0;
        }
        return this.i.left;
      }
      if (this.I) {
        return this.i.left;
      }
      return this.i.right - this.l0;
    }
    return paramInt1 / 2.0F - this.l0 / 2.0F;
  }
  
  private float t(RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.I) {
          return this.i.right;
        }
        return paramRectF.left + this.l0;
      }
      if (this.I) {
        return paramRectF.left + this.l0;
      }
      return this.i.right;
    }
    return paramInt1 / 2.0F + this.l0 / 2.0F;
  }
  
  private boolean t0(Typeface paramTypeface)
  {
    Object localObject = this.E;
    if (localObject != null) {
      ((o7.a)localObject).c();
    }
    if (this.C != paramTypeface)
    {
      this.C = paramTypeface;
      localObject = g.b(this.a.getContext().getResources().getConfiguration(), paramTypeface);
      this.B = ((Typeface)localObject);
      paramTypeface = (Typeface)localObject;
      if (localObject == null) {
        paramTypeface = this.C;
      }
      this.A = paramTypeface;
      return true;
    }
    return false;
  }
  
  private int w(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return 0;
    }
    int[] arrayOfInt = this.T;
    if (arrayOfInt != null) {
      return paramColorStateList.getColorForState(arrayOfInt, 0);
    }
    return paramColorStateList.getDefaultColor();
  }
  
  private int x()
  {
    return w(this.o);
  }
  
  private void y0(float paramFloat)
  {
    h(paramFloat);
    boolean bool;
    if ((t0) && (this.N != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.K = bool;
    if (bool) {
      n();
    }
    x.h0(this.a);
  }
  
  public int A()
  {
    return this.k;
  }
  
  public void A0(float paramFloat)
  {
    this.r0 = paramFloat;
  }
  
  public float B()
  {
    O(this.W);
    return -this.W.ascent();
  }
  
  public void B0(int paramInt)
  {
    if (paramInt != this.p0)
    {
      this.p0 = paramInt;
      j();
      Y();
    }
  }
  
  public Typeface C()
  {
    Typeface localTypeface = this.A;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public void C0(TimeInterpolator paramTimeInterpolator)
  {
    this.X = paramTimeInterpolator;
    Y();
  }
  
  public float D()
  {
    return this.c;
  }
  
  public void D0(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public float E()
  {
    return this.f;
  }
  
  public final boolean E0(int[] paramArrayOfInt)
  {
    this.T = paramArrayOfInt;
    if (S())
    {
      Y();
      return true;
    }
    return false;
  }
  
  public int F()
  {
    return this.s0;
  }
  
  public void F0(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!TextUtils.equals(this.G, paramCharSequence)))
    {
      this.G = paramCharSequence;
      this.H = null;
      j();
      Y();
    }
  }
  
  public int G()
  {
    StaticLayout localStaticLayout = this.k0;
    if (localStaticLayout != null) {
      return localStaticLayout.getLineCount();
    }
    return 0;
  }
  
  public void G0(TimeInterpolator paramTimeInterpolator)
  {
    this.Y = paramTimeInterpolator;
    Y();
  }
  
  public float H()
  {
    return this.k0.getSpacingAdd();
  }
  
  public void H0(Typeface paramTypeface)
  {
    boolean bool1 = i0(paramTypeface);
    boolean bool2 = t0(paramTypeface);
    if ((bool1) || (bool2)) {
      Y();
    }
  }
  
  public float I()
  {
    return this.k0.getSpacingMultiplier();
  }
  
  public int J()
  {
    return this.p0;
  }
  
  public TimeInterpolator L()
  {
    return this.X;
  }
  
  public CharSequence M()
  {
    return this.G;
  }
  
  public final boolean S()
  {
    ColorStateList localColorStateList = this.p;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = this.o;
    }
    return (localColorStateList != null) && (localColorStateList.isStateful());
  }
  
  public void V(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 31)
    {
      Typeface localTypeface = this.z;
      if (localTypeface != null) {
        this.y = g.b(paramConfiguration, localTypeface);
      }
      localTypeface = this.C;
      if (localTypeface != null) {
        this.B = g.b(paramConfiguration, localTypeface);
      }
      paramConfiguration = this.y;
      if (paramConfiguration == null) {
        paramConfiguration = this.z;
      }
      this.x = paramConfiguration;
      paramConfiguration = this.B;
      if (paramConfiguration == null) {
        paramConfiguration = this.C;
      }
      this.A = paramConfiguration;
      Z(true);
    }
  }
  
  void X()
  {
    boolean bool;
    if ((this.i.width() > 0) && (this.i.height() > 0) && (this.h.width() > 0) && (this.h.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
  }
  
  public void Y()
  {
    Z(false);
  }
  
  public void Z(boolean paramBoolean)
  {
    if (((this.a.getHeight() > 0) && (this.a.getWidth() > 0)) || (paramBoolean))
    {
      b(paramBoolean);
      c();
    }
  }
  
  public void b0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a0(this.i, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.i.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.U = true;
      X();
    }
  }
  
  public void c0(Rect paramRect)
  {
    b0(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void d0(int paramInt)
  {
    o7.d locald = new o7.d(this.a.getContext(), paramInt);
    if (locald.i() != null) {
      this.p = locald.i();
    }
    if (locald.j() != 0.0F) {
      this.n = locald.j();
    }
    Object localObject = locald.c;
    if (localObject != null) {
      this.c0 = ((ColorStateList)localObject);
    }
    this.a0 = locald.h;
    this.b0 = locald.i;
    this.Z = locald.j;
    this.h0 = locald.l;
    localObject = this.F;
    if (localObject != null) {
      ((o7.a)localObject).c();
    }
    this.F = new o7.a(new a(), locald.e());
    locald.h(this.a.getContext(), this.F);
    Y();
  }
  
  public void f0(ColorStateList paramColorStateList)
  {
    if (this.p != paramColorStateList)
    {
      this.p = paramColorStateList;
      Y();
    }
  }
  
  public void g0(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      Y();
    }
  }
  
  public void h0(Typeface paramTypeface)
  {
    if (i0(paramTypeface)) {
      Y();
    }
  }
  
  public void j0(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void k0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a0(this.h, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.h.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.U = true;
      X();
    }
  }
  
  public void l(Canvas paramCanvas)
  {
    int i2 = paramCanvas.save();
    if ((this.H != null) && (this.b))
    {
      this.V.setTextSize(this.O);
      float f1 = this.v;
      float f2 = this.w;
      int i1;
      if ((this.K) && (this.L != null)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      float f3 = this.N;
      if ((f3 != 1.0F) && (!this.d)) {
        paramCanvas.scale(f3, f3, f1, f2);
      }
      if (i1 != 0)
      {
        paramCanvas.drawBitmap(this.L, f1, f2, this.M);
        paramCanvas.restoreToCount(i2);
        return;
      }
      if ((I0()) && ((!this.d) || (this.c > this.f)))
      {
        m(paramCanvas, this.v - this.k0.getLineStart(0), f2);
      }
      else
      {
        paramCanvas.translate(f1, f2);
        this.k0.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i2);
    }
  }
  
  public void l0(Rect paramRect)
  {
    k0(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void m0(float paramFloat)
  {
    if (this.i0 != paramFloat)
    {
      this.i0 = paramFloat;
      Y();
    }
  }
  
  public void n0(int paramInt)
  {
    o7.d locald = new o7.d(this.a.getContext(), paramInt);
    if (locald.i() != null) {
      this.o = locald.i();
    }
    if (locald.j() != 0.0F) {
      this.m = locald.j();
    }
    Object localObject = locald.c;
    if (localObject != null) {
      this.g0 = ((ColorStateList)localObject);
    }
    this.e0 = locald.h;
    this.f0 = locald.i;
    this.d0 = locald.j;
    this.i0 = locald.l;
    localObject = this.E;
    if (localObject != null) {
      ((o7.a)localObject).c();
    }
    this.E = new o7.a(new b(), locald.e());
    locald.h(this.a.getContext(), this.E);
    Y();
  }
  
  public void o(RectF paramRectF, int paramInt1, int paramInt2)
  {
    this.I = f(this.G);
    paramRectF.left = s(paramInt1, paramInt2);
    paramRectF.top = this.i.top;
    paramRectF.right = t(paramRectF, paramInt1, paramInt2);
    paramRectF.bottom = (this.i.top + r());
  }
  
  public ColorStateList p()
  {
    return this.p;
  }
  
  public void p0(ColorStateList paramColorStateList)
  {
    if (this.o != paramColorStateList)
    {
      this.o = paramColorStateList;
      Y();
    }
  }
  
  public int q()
  {
    return this.l;
  }
  
  public void q0(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      Y();
    }
  }
  
  public float r()
  {
    N(this.W);
    return -this.W.ascent();
  }
  
  public void r0(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      this.m = paramFloat;
      Y();
    }
  }
  
  public void s0(Typeface paramTypeface)
  {
    if (t0(paramTypeface)) {
      Y();
    }
  }
  
  public Typeface u()
  {
    Typeface localTypeface = this.x;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public void u0(float paramFloat)
  {
    paramFloat = t0.a.a(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.c)
    {
      this.c = paramFloat;
      c();
    }
  }
  
  public int v()
  {
    return w(this.p);
  }
  
  public void v0(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void w0(float paramFloat)
  {
    this.e = paramFloat;
    this.f = e();
  }
  
  public void x0(int paramInt)
  {
    this.s0 = paramInt;
  }
  
  public int y()
  {
    return this.q;
  }
  
  public float z()
  {
    O(this.W);
    return -this.W.ascent() + this.W.descent();
  }
  
  public void z0(float paramFloat)
  {
    this.q0 = paramFloat;
  }
  
  class a
    implements a.a
  {
    a() {}
    
    public void a(Typeface paramTypeface)
    {
      b.this.h0(paramTypeface);
    }
  }
  
  class b
    implements a.a
  {
    b() {}
    
    public void a(Typeface paramTypeface)
    {
      b.this.s0(paramTypeface);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.b
 * JD-Core Version:    0.7.0.1
 */