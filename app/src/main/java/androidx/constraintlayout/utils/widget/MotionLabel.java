package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R.attr;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.R.styleable;

public class MotionLabel
  extends View
  implements c
{
  static String W = "MotionLabel";
  private float A;
  private float B;
  private float C;
  private Drawable E;
  Matrix F;
  private Bitmap G;
  private BitmapShader H;
  private Matrix I;
  private float J = (0.0F / 0.0F);
  private float K = (0.0F / 0.0F);
  private float L = 0.0F;
  private float M = 0.0F;
  Paint N = new Paint();
  private int O = 0;
  Rect P;
  Paint Q;
  float R;
  float S = (0.0F / 0.0F);
  float T = (0.0F / 0.0F);
  float U = (0.0F / 0.0F);
  float V = (0.0F / 0.0F);
  TextPaint a = new TextPaint();
  Path b = new Path();
  private int c = 65535;
  private int d = 65535;
  private boolean e = false;
  private float f = 0.0F;
  private float g = (0.0F / 0.0F);
  ViewOutlineProvider h;
  RectF i;
  private float j = 48.0F;
  private float k = (0.0F / 0.0F);
  private int l;
  private int m;
  private float n = 0.0F;
  private String o = "Hello World";
  boolean p = true;
  private Rect q = new Rect();
  private int r = 1;
  private int s = 1;
  private int t = 1;
  private int u = 1;
  private String v;
  private Layout w;
  private int x = 8388659;
  private int y = 0;
  private boolean z = false;
  
  public MotionLabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g(paramContext, paramAttributeSet);
  }
  
  public MotionLabel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g(paramContext, paramAttributeSet);
  }
  
  private void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.I == null) {
      return;
    }
    this.B = (paramFloat3 - paramFloat1);
    this.C = (paramFloat4 - paramFloat2);
    l();
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    i(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MotionLabel);
      int i2 = paramContext.getIndexCount();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramContext.getIndex(i1);
        if (i3 == R.styleable.MotionLabel_android_text)
        {
          setText(paramContext.getText(i3));
        }
        else if (i3 == R.styleable.MotionLabel_android_fontFamily)
        {
          this.v = paramContext.getString(i3);
        }
        else if (i3 == R.styleable.MotionLabel_scaleFromTextSize)
        {
          this.k = paramContext.getDimensionPixelSize(i3, (int)this.k);
        }
        else if (i3 == R.styleable.MotionLabel_android_textSize)
        {
          this.j = paramContext.getDimensionPixelSize(i3, (int)this.j);
        }
        else if (i3 == R.styleable.MotionLabel_android_textStyle)
        {
          this.l = paramContext.getInt(i3, this.l);
        }
        else if (i3 == R.styleable.MotionLabel_android_typeface)
        {
          this.m = paramContext.getInt(i3, this.m);
        }
        else if (i3 == R.styleable.MotionLabel_android_textColor)
        {
          this.c = paramContext.getColor(i3, this.c);
        }
        else
        {
          float f1;
          if (i3 == R.styleable.MotionLabel_borderRound)
          {
            f1 = paramContext.getDimension(i3, this.g);
            this.g = f1;
            setRound(f1);
          }
          else if (i3 == R.styleable.MotionLabel_borderRoundPercent)
          {
            f1 = paramContext.getFloat(i3, this.f);
            this.f = f1;
            setRoundPercent(f1);
          }
          else if (i3 == R.styleable.MotionLabel_android_gravity)
          {
            setGravity(paramContext.getInt(i3, -1));
          }
          else if (i3 == R.styleable.MotionLabel_android_autoSizeTextType)
          {
            this.y = paramContext.getInt(i3, 0);
          }
          else
          {
            if (i3 == R.styleable.MotionLabel_textOutlineColor) {
              this.d = paramContext.getInt(i3, this.d);
            }
            for (;;)
            {
              this.e = true;
              break label623;
              if (i3 == R.styleable.MotionLabel_textOutlineThickness)
              {
                this.n = paramContext.getDimension(i3, this.n);
              }
              else
              {
                if (i3 != R.styleable.MotionLabel_textBackground) {
                  break;
                }
                this.E = paramContext.getDrawable(i3);
              }
            }
            if (i3 == R.styleable.MotionLabel_textBackgroundPanX) {
              this.S = paramContext.getFloat(i3, this.S);
            } else if (i3 == R.styleable.MotionLabel_textBackgroundPanY) {
              this.T = paramContext.getFloat(i3, this.T);
            } else if (i3 == R.styleable.MotionLabel_textPanX) {
              this.L = paramContext.getFloat(i3, this.L);
            } else if (i3 == R.styleable.MotionLabel_textPanY) {
              this.M = paramContext.getFloat(i3, this.M);
            } else if (i3 == R.styleable.MotionLabel_textBackgroundRotate) {
              this.V = paramContext.getFloat(i3, this.V);
            } else if (i3 == R.styleable.MotionLabel_textBackgroundZoom) {
              this.U = paramContext.getFloat(i3, this.U);
            } else if (i3 == R.styleable.MotionLabel_textureHeight) {
              this.J = paramContext.getDimension(i3, this.J);
            } else if (i3 == R.styleable.MotionLabel_textureWidth) {
              this.K = paramContext.getDimension(i3, this.K);
            } else if (i3 == R.styleable.MotionLabel_textureEffect) {
              this.O = paramContext.getInt(i3, this.O);
            }
          }
        }
        label623:
        i1 += 1;
      }
      paramContext.recycle();
    }
    k();
    j();
  }
  
  private float getHorizontalOffset()
  {
    float f1;
    if (Float.isNaN(this.k)) {
      f1 = 1.0F;
    } else {
      f1 = this.j / this.k;
    }
    TextPaint localTextPaint = this.a;
    String str = this.o;
    float f3 = localTextPaint.measureText(str, 0, str.length());
    float f2;
    if (Float.isNaN(this.B)) {
      f2 = getMeasuredWidth();
    } else {
      f2 = this.B;
    }
    return (f2 - getPaddingLeft() - getPaddingRight() - f1 * f3) * (this.L + 1.0F) / 2.0F;
  }
  
  private float getVerticalOffset()
  {
    float f1;
    if (Float.isNaN(this.k)) {
      f1 = 1.0F;
    } else {
      f1 = this.j / this.k;
    }
    Paint.FontMetrics localFontMetrics = this.a.getFontMetrics();
    float f2;
    if (Float.isNaN(this.C)) {
      f2 = getMeasuredHeight();
    } else {
      f2 = this.C;
    }
    float f3 = getPaddingTop();
    float f4 = getPaddingBottom();
    float f5 = localFontMetrics.descent;
    float f6 = localFontMetrics.ascent;
    return (f2 - f3 - f4 - (f5 - f6) * f1) * (1.0F - this.M) / 2.0F - f1 * f6;
  }
  
  private void h(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      Typeface localTypeface = Typeface.create(paramString, paramInt2);
      paramString = localTypeface;
      if (localTypeface != null) {
        setTypeface(localTypeface);
      }
    }
    else
    {
      paramString = null;
    }
    boolean bool = true;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          paramString = Typeface.MONOSPACE;
        }
      }
      else {
        paramString = Typeface.SERIF;
      }
    }
    else {
      paramString = Typeface.SANS_SERIF;
    }
    float f1 = 0.0F;
    if (paramInt2 > 0)
    {
      if (paramString == null) {
        paramString = Typeface.defaultFromStyle(paramInt2);
      } else {
        paramString = Typeface.create(paramString, paramInt2);
      }
      setTypeface(paramString);
      if (paramString != null) {
        paramInt1 = paramString.getStyle();
      } else {
        paramInt1 = 0;
      }
      paramInt1 &= paramInt2;
      paramString = this.a;
      if ((paramInt1 & 0x1) == 0) {
        bool = false;
      }
      paramString.setFakeBoldText(bool);
      paramString = this.a;
      if ((paramInt1 & 0x2) != 0) {
        f1 = -0.25F;
      }
      paramString.setTextSkewX(f1);
      return;
    }
    this.a.setFakeBoldText(false);
    this.a.setTextSkewX(0.0F);
    setTypeface(paramString);
  }
  
  private void i(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.colorPrimary, paramAttributeSet, true);
    paramContext = this.a;
    int i1 = paramAttributeSet.data;
    this.c = i1;
    paramContext.setColor(i1);
  }
  
  private void k()
  {
    if (this.E != null)
    {
      this.I = new Matrix();
      int i2 = this.E.getIntrinsicWidth();
      int i4 = this.E.getIntrinsicHeight();
      int i3 = 128;
      int i1 = i2;
      if (i2 <= 0)
      {
        i2 = getWidth();
        i1 = i2;
        if (i2 == 0) {
          if (Float.isNaN(this.K)) {
            i1 = 128;
          } else {
            i1 = (int)this.K;
          }
        }
      }
      i2 = i4;
      if (i4 <= 0)
      {
        i4 = getHeight();
        i2 = i4;
        if (i4 == 0) {
          if (Float.isNaN(this.J)) {
            i2 = i3;
          } else {
            i2 = (int)this.J;
          }
        }
      }
      i4 = i1;
      i3 = i2;
      if (this.O != 0)
      {
        i4 = i1 / 2;
        i3 = i2 / 2;
      }
      this.G = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
      Object localObject = new Canvas(this.G);
      this.E.setBounds(0, 0, ((Canvas)localObject).getWidth(), ((Canvas)localObject).getHeight());
      this.E.setFilterBitmap(true);
      this.E.draw((Canvas)localObject);
      if (this.O != 0) {
        this.G = e(this.G, 4);
      }
      localObject = this.G;
      Shader.TileMode localTileMode = Shader.TileMode.REPEAT;
      this.H = new BitmapShader((Bitmap)localObject, localTileMode, localTileMode);
    }
  }
  
  private void l()
  {
    boolean bool = Float.isNaN(this.S);
    float f3 = 0.0F;
    float f1;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = this.S;
    }
    float f2;
    if (Float.isNaN(this.T)) {
      f2 = 0.0F;
    } else {
      f2 = this.T;
    }
    if (Float.isNaN(this.U)) {
      f6 = 1.0F;
    } else {
      f6 = this.U;
    }
    if (!Float.isNaN(this.V)) {
      f3 = this.V;
    }
    this.I.reset();
    float f9 = this.G.getWidth();
    float f8 = this.G.getHeight();
    float f4;
    if (Float.isNaN(this.K)) {
      f4 = this.B;
    } else {
      f4 = this.K;
    }
    float f5;
    if (Float.isNaN(this.J)) {
      f5 = this.C;
    } else {
      f5 = this.J;
    }
    if (f9 * f5 < f8 * f4) {
      f7 = f4 / f9;
    } else {
      f7 = f5 / f8;
    }
    f6 *= f7;
    this.I.postScale(f6, f6);
    f9 *= f6;
    float f7 = f4 - f9;
    f8 = f6 * f8;
    float f6 = f5 - f8;
    if (!Float.isNaN(this.J)) {
      f6 = this.J / 2.0F;
    }
    if (!Float.isNaN(this.K)) {
      f7 = this.K / 2.0F;
    }
    this.I.postTranslate((f1 * f7 + f4 - f9) * 0.5F, (f2 * f6 + f5 - f8) * 0.5F);
    this.I.postRotate(f3, f4 / 2.0F, f5 / 2.0F);
    this.H.setLocalMatrix(this.I);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i1 = (int)(paramFloat1 + 0.5F);
    this.A = (paramFloat1 - i1);
    int i2 = (int)(paramFloat3 + 0.5F);
    int i3 = i2 - i1;
    int i4 = (int)(paramFloat4 + 0.5F);
    int i5 = (int)(0.5F + paramFloat2);
    int i6 = i4 - i5;
    float f2 = paramFloat3 - paramFloat1;
    this.B = f2;
    float f1 = paramFloat4 - paramFloat2;
    this.C = f1;
    d(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    if ((getMeasuredHeight() != i6) || (getMeasuredWidth() != i3)) {
      measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
    }
    super.layout(i1, i5, i2, i4);
    if (this.z)
    {
      if (this.P == null)
      {
        this.Q = new Paint();
        this.P = new Rect();
        this.Q.set(this.a);
        this.R = this.Q.getTextSize();
      }
      this.B = f2;
      this.C = f1;
      Paint localPaint = this.Q;
      String str = this.o;
      localPaint.getTextBounds(str, 0, str.length(), this.P);
      i1 = this.P.width();
      paramFloat1 = this.P.height() * 1.3F;
      paramFloat2 = f2 - this.s - this.r;
      paramFloat3 = f1 - this.u - this.t;
      paramFloat4 = i1;
      if (paramFloat4 * paramFloat3 > paramFloat1 * paramFloat2) {
        this.a.setTextSize(this.R * paramFloat2 / paramFloat4);
      } else {
        this.a.setTextSize(this.R * paramFloat3 / paramFloat1);
      }
      if ((this.e) || (!Float.isNaN(this.k)))
      {
        if (Float.isNaN(this.k)) {
          paramFloat1 = 1.0F;
        } else {
          paramFloat1 = this.j / this.k;
        }
        f(paramFloat1);
      }
    }
  }
  
  Bitmap e(Bitmap paramBitmap, int paramInt)
  {
    System.nanoTime();
    int i2 = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    int i3 = i2 / 2;
    i2 = i1 / 2;
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i3, i2, true);
    i1 = 0;
    while ((i1 < paramInt) && (i3 >= 32))
    {
      if (i2 < 32) {
        return paramBitmap;
      }
      i3 /= 2;
      i2 /= 2;
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i3, i2, true);
      i1 += 1;
    }
    return paramBitmap;
  }
  
  void f(float paramFloat)
  {
    if ((!this.e) && (paramFloat == 1.0F)) {
      return;
    }
    this.b.reset();
    Object localObject = this.o;
    int i1 = ((String)localObject).length();
    this.a.getTextBounds((String)localObject, 0, i1, this.q);
    this.a.getTextPath((String)localObject, 0, i1, 0.0F, 0.0F, this.b);
    if (paramFloat != 1.0F)
    {
      localObject = W;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a.a());
      localStringBuilder.append(" scale ");
      localStringBuilder.append(paramFloat);
      Log.v((String)localObject, localStringBuilder.toString());
      localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      this.b.transform((Matrix)localObject);
    }
    localObject = this.q;
    ((Rect)localObject).right -= 1;
    ((Rect)localObject).left += 1;
    ((Rect)localObject).bottom += 1;
    ((Rect)localObject).top -= 1;
    localObject = new RectF();
    ((RectF)localObject).bottom = getHeight();
    ((RectF)localObject).right = getWidth();
    this.p = false;
  }
  
  public float getRound()
  {
    return this.g;
  }
  
  public float getRoundPercent()
  {
    return this.f;
  }
  
  public float getScaleFromTextSize()
  {
    return this.k;
  }
  
  public float getTextBackgroundPanX()
  {
    return this.S;
  }
  
  public float getTextBackgroundPanY()
  {
    return this.T;
  }
  
  public float getTextBackgroundRotate()
  {
    return this.V;
  }
  
  public float getTextBackgroundZoom()
  {
    return this.U;
  }
  
  public int getTextOutlineColor()
  {
    return this.d;
  }
  
  public float getTextPanX()
  {
    return this.L;
  }
  
  public float getTextPanY()
  {
    return this.M;
  }
  
  public float getTextureHeight()
  {
    return this.J;
  }
  
  public float getTextureWidth()
  {
    return this.K;
  }
  
  public Typeface getTypeface()
  {
    return this.a.getTypeface();
  }
  
  void j()
  {
    this.r = getPaddingLeft();
    this.s = getPaddingRight();
    this.t = getPaddingTop();
    this.u = getPaddingBottom();
    h(this.v, this.m, this.l);
    this.a.setColor(this.c);
    this.a.setStrokeWidth(this.n);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setFlags(128);
    setTextSize(this.j);
    this.a.setAntiAlias(true);
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    boolean bool = Float.isNaN(this.k);
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = this.j / this.k;
    }
    this.B = (paramInt3 - paramInt1);
    this.C = (paramInt4 - paramInt2);
    float f2 = f1;
    if (this.z)
    {
      if (this.P == null)
      {
        this.Q = new Paint();
        this.P = new Rect();
        this.Q.set(this.a);
        this.R = this.Q.getTextSize();
      }
      Paint localPaint = this.Q;
      String str = this.o;
      localPaint.getTextBounds(str, 0, str.length(), this.P);
      int i1 = this.P.width();
      int i2 = (int)(this.P.height() * 1.3F);
      f2 = this.B - this.s - this.r;
      float f3 = this.C - this.u - this.t;
      float f4;
      if (bool)
      {
        f4 = i1;
        float f5 = i2;
        if (f4 * f3 > f5 * f2)
        {
          this.a.setTextSize(this.R * f2 / f4);
          f2 = f1;
        }
        else
        {
          this.a.setTextSize(this.R * f3 / f5);
          f2 = f1;
        }
      }
      else
      {
        f1 = i1;
        f4 = i2;
        if (f1 * f3 > f4 * f2) {
          f2 /= f1;
        } else {
          f2 = f3 / f4;
        }
      }
    }
    if ((this.e) || (!bool))
    {
      d(paramInt1, paramInt2, paramInt3, paramInt4);
      f(f2);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (Float.isNaN(this.k)) {
      f1 = 1.0F;
    } else {
      f1 = this.j / this.k;
    }
    super.onDraw(paramCanvas);
    float f3;
    if ((!this.e) && (f1 == 1.0F))
    {
      f1 = this.r;
      f2 = getHorizontalOffset();
      f3 = this.t;
      float f4 = getVerticalOffset();
      paramCanvas.drawText(this.o, this.A + (f1 + f2), f3 + f4, this.a);
      return;
    }
    if (this.p) {
      f(f1);
    }
    if (this.F == null) {
      this.F = new Matrix();
    }
    if (this.e)
    {
      this.N.set(this.a);
      this.F.reset();
      f2 = this.r + getHorizontalOffset();
      f3 = this.t + getVerticalOffset();
      this.F.postTranslate(f2, f3);
      this.F.preScale(f1, f1);
      this.b.transform(this.F);
      if (this.H != null)
      {
        this.a.setFilterBitmap(true);
        this.a.setShader(this.H);
      }
      else
      {
        this.a.setColor(this.c);
      }
      this.a.setStyle(Paint.Style.FILL);
      this.a.setStrokeWidth(this.n);
      paramCanvas.drawPath(this.b, this.a);
      if (this.H != null) {
        this.a.setShader(null);
      }
      this.a.setColor(this.d);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setStrokeWidth(this.n);
      paramCanvas.drawPath(this.b, this.a);
      this.F.reset();
      this.F.postTranslate(-f2, -f3);
      this.b.transform(this.F);
      this.a.set(this.N);
      return;
    }
    float f1 = this.r + getHorizontalOffset();
    float f2 = this.t + getVerticalOffset();
    this.F.reset();
    this.F.preTranslate(f1, f2);
    this.b.transform(this.F);
    this.a.setColor(this.c);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setStrokeWidth(this.n);
    paramCanvas.drawPath(this.b, this.a);
    this.F.reset();
    this.F.preTranslate(-f1, -f2);
    this.b.transform(this.F);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.z = false;
    this.r = getPaddingLeft();
    this.s = getPaddingRight();
    this.t = getPaddingTop();
    this.u = getPaddingBottom();
    if ((i1 == 1073741824) && (i4 == 1073741824))
    {
      paramInt2 = paramInt1;
      i1 = i2;
      if (this.y != 0)
      {
        this.z = true;
        paramInt2 = paramInt1;
        i1 = i2;
      }
    }
    else
    {
      TextPaint localTextPaint = this.a;
      String str = this.o;
      localTextPaint.getTextBounds(str, 0, str.length(), this.q);
      if (i1 != 1073741824) {
        paramInt1 = (int)(this.q.width() + 0.99999F);
      }
      int i3 = paramInt1 + (this.r + this.s);
      paramInt2 = i3;
      i1 = i2;
      if (i4 != 1073741824)
      {
        paramInt2 = (int)(this.a.getFontMetricsInt(null) + 0.99999F);
        paramInt1 = paramInt2;
        if (i4 == -2147483648) {
          paramInt1 = Math.min(i2, paramInt2);
        }
        i1 = this.t + this.u + paramInt1;
        paramInt2 = i3;
      }
    }
    setMeasuredDimension(paramInt2, i1);
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void setGravity(int paramInt)
  {
    int i1 = paramInt;
    if ((paramInt & 0x800007) == 0) {
      i1 = paramInt | 0x800003;
    }
    paramInt = i1;
    if ((i1 & 0x70) == 0) {
      paramInt = i1 | 0x30;
    }
    if (paramInt != this.x) {
      invalidate();
    }
    this.x = paramInt;
    i1 = paramInt & 0x70;
    if (i1 != 48)
    {
      if (i1 != 80) {
        this.M = 0.0F;
      } else {
        this.M = 1.0F;
      }
    }
    else {
      this.M = -1.0F;
    }
    paramInt &= 0x800007;
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt == 8388611) {
          break label129;
        }
        if (paramInt != 8388613)
        {
          this.L = 0.0F;
          return;
        }
      }
      this.L = 1.0F;
      return;
    }
    label129:
    this.L = -1.0F;
  }
  
  public void setRound(float paramFloat)
  {
    if (Float.isNaN(paramFloat))
    {
      this.g = paramFloat;
      paramFloat = this.f;
      this.f = -1.0F;
      setRoundPercent(paramFloat);
      return;
    }
    int i1;
    if (this.g != paramFloat) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.g = paramFloat;
    if (paramFloat != 0.0F)
    {
      if (this.b == null) {
        this.b = new Path();
      }
      if (this.i == null) {
        this.i = new RectF();
      }
      if (this.h == null)
      {
        localObject = new b();
        this.h = ((ViewOutlineProvider)localObject);
        setOutlineProvider((ViewOutlineProvider)localObject);
      }
      setClipToOutline(true);
      int i2 = getWidth();
      int i3 = getHeight();
      this.i.set(0.0F, 0.0F, i2, i3);
      this.b.reset();
      Object localObject = this.b;
      RectF localRectF = this.i;
      paramFloat = this.g;
      ((Path)localObject).addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    }
    else
    {
      setClipToOutline(false);
    }
    if (i1 != 0) {
      invalidateOutline();
    }
  }
  
  public void setRoundPercent(float paramFloat)
  {
    int i1;
    if (this.f != paramFloat) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.f = paramFloat;
    if (paramFloat != 0.0F)
    {
      if (this.b == null) {
        this.b = new Path();
      }
      if (this.i == null) {
        this.i = new RectF();
      }
      if (this.h == null)
      {
        a locala = new a();
        this.h = locala;
        setOutlineProvider(locala);
      }
      setClipToOutline(true);
      int i2 = getWidth();
      int i3 = getHeight();
      paramFloat = Math.min(i2, i3) * this.f / 2.0F;
      this.i.set(0.0F, 0.0F, i2, i3);
      this.b.reset();
      this.b.addRoundRect(this.i, paramFloat, paramFloat, Path.Direction.CW);
    }
    else
    {
      setClipToOutline(false);
    }
    if (i1 != 0) {
      invalidateOutline();
    }
  }
  
  public void setScaleFromTextSize(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.o = paramCharSequence.toString();
    invalidate();
  }
  
  public void setTextBackgroundPanX(float paramFloat)
  {
    this.S = paramFloat;
    l();
    invalidate();
  }
  
  public void setTextBackgroundPanY(float paramFloat)
  {
    this.T = paramFloat;
    l();
    invalidate();
  }
  
  public void setTextBackgroundRotate(float paramFloat)
  {
    this.V = paramFloat;
    l();
    invalidate();
  }
  
  public void setTextBackgroundZoom(float paramFloat)
  {
    this.U = paramFloat;
    l();
    invalidate();
  }
  
  public void setTextFillColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setTextOutlineColor(int paramInt)
  {
    this.d = paramInt;
    this.e = true;
    invalidate();
  }
  
  public void setTextOutlineThickness(float paramFloat)
  {
    this.n = paramFloat;
    this.e = true;
    if (Float.isNaN(paramFloat))
    {
      this.n = 1.0F;
      this.e = false;
    }
    invalidate();
  }
  
  public void setTextPanX(float paramFloat)
  {
    this.L = paramFloat;
    invalidate();
  }
  
  public void setTextPanY(float paramFloat)
  {
    this.M = paramFloat;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.j = paramFloat;
    Object localObject = W;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.a());
    localStringBuilder.append("  ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(" / ");
    localStringBuilder.append(this.k);
    Log.v((String)localObject, localStringBuilder.toString());
    localObject = this.a;
    if (!Float.isNaN(this.k)) {
      paramFloat = this.k;
    }
    ((TextPaint)localObject).setTextSize(paramFloat);
    if (Float.isNaN(this.k)) {
      paramFloat = 1.0F;
    } else {
      paramFloat = this.j / this.k;
    }
    f(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setTextureHeight(float paramFloat)
  {
    this.J = paramFloat;
    l();
    invalidate();
  }
  
  public void setTextureWidth(float paramFloat)
  {
    this.K = paramFloat;
    l();
    invalidate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.a.getTypeface() != paramTypeface)
    {
      this.a.setTypeface(paramTypeface);
      if (this.w != null)
      {
        this.w = null;
        requestLayout();
        invalidate();
      }
    }
  }
  
  class a
    extends ViewOutlineProvider
  {
    a() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      int i = MotionLabel.this.getWidth();
      int j = MotionLabel.this.getHeight();
      paramOutline.setRoundRect(0, 0, i, j, Math.min(i, j) * MotionLabel.b(MotionLabel.this) / 2.0F);
    }
  }
  
  class b
    extends ViewOutlineProvider
  {
    b() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      paramOutline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.c(MotionLabel.this));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.MotionLabel
 * JD-Core Version:    0.7.0.1
 */