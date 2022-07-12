package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R.styleable;
import c.a;

public class ImageFilterView
  extends AppCompatImageView
{
  private c a = new c();
  private boolean b = true;
  private Drawable c = null;
  private Drawable d = null;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = (0.0F / 0.0F);
  private Path h;
  ViewOutlineProvider i;
  RectF j;
  Drawable[] k = new Drawable[2];
  LayerDrawable l;
  float m = (0.0F / 0.0F);
  float n = (0.0F / 0.0F);
  float o = (0.0F / 0.0F);
  float p = (0.0F / 0.0F);
  
  public ImageFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
  }
  
  public ImageFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ImageFilterView);
      int i2 = paramContext.getIndexCount();
      this.c = paramContext.getDrawable(R.styleable.ImageFilterView_altSrc);
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramContext.getIndex(i1);
        if (i3 == R.styleable.ImageFilterView_crossfade) {
          this.e = paramContext.getFloat(i3, 0.0F);
        } else if (i3 == R.styleable.ImageFilterView_warmth) {
          setWarmth(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_saturation) {
          setSaturation(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_contrast) {
          setContrast(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_brightness) {
          setBrightness(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_round) {
          setRound(paramContext.getDimension(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_roundPercent) {
          setRoundPercent(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_overlay) {
          setOverlay(paramContext.getBoolean(i3, this.b));
        } else if (i3 == R.styleable.ImageFilterView_imagePanX) {
          setImagePanX(paramContext.getFloat(i3, this.m));
        } else if (i3 == R.styleable.ImageFilterView_imagePanY) {
          setImagePanY(paramContext.getFloat(i3, this.n));
        } else if (i3 == R.styleable.ImageFilterView_imageRotate) {
          setImageRotate(paramContext.getFloat(i3, this.p));
        } else if (i3 == R.styleable.ImageFilterView_imageZoom) {
          setImageZoom(paramContext.getFloat(i3, this.o));
        }
        i1 += 1;
      }
      paramContext.recycle();
      paramContext = getDrawable();
      this.d = paramContext;
      if ((this.c != null) && (paramContext != null))
      {
        paramContext = this.k;
        paramAttributeSet = getDrawable().mutate();
        this.d = paramAttributeSet;
        paramContext[0] = paramAttributeSet;
        this.k[1] = this.c.mutate();
        paramContext = new LayerDrawable(this.k);
        this.l = paramContext;
        paramContext.getDrawable(1).setAlpha((int)(this.e * 255.0F));
        if (!this.b) {
          this.l.getDrawable(0).setAlpha((int)((1.0F - this.e) * 255.0F));
        }
        super.setImageDrawable(this.l);
        return;
      }
      paramAttributeSet = getDrawable();
      this.d = paramAttributeSet;
      if (paramAttributeSet != null)
      {
        paramContext = this.k;
        paramAttributeSet = paramAttributeSet.mutate();
        this.d = paramAttributeSet;
        paramContext[0] = paramAttributeSet;
      }
    }
  }
  
  private void f()
  {
    if ((Float.isNaN(this.m)) && (Float.isNaN(this.n)) && (Float.isNaN(this.o)) && (Float.isNaN(this.p))) {
      return;
    }
    boolean bool = Float.isNaN(this.m);
    float f3 = 0.0F;
    float f1;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = this.m;
    }
    float f2;
    if (Float.isNaN(this.n)) {
      f2 = 0.0F;
    } else {
      f2 = this.n;
    }
    float f4;
    if (Float.isNaN(this.o)) {
      f4 = 1.0F;
    } else {
      f4 = this.o;
    }
    if (!Float.isNaN(this.p)) {
      f3 = this.p;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f9 = getDrawable().getIntrinsicWidth();
    float f8 = getDrawable().getIntrinsicHeight();
    float f6 = getWidth();
    float f7 = getHeight();
    if (f9 * f7 < f8 * f6) {
      f5 = f6 / f9;
    } else {
      f5 = f7 / f8;
    }
    f4 *= f5;
    localMatrix.postScale(f4, f4);
    float f5 = f9 * f4;
    f4 *= f8;
    localMatrix.postTranslate((f1 * (f6 - f5) + f6 - f5) * 0.5F, (f2 * (f7 - f4) + f7 - f4) * 0.5F);
    localMatrix.postRotate(f3, f6 / 2.0F, f7 / 2.0F);
    setImageMatrix(localMatrix);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void g()
  {
    if ((Float.isNaN(this.m)) && (Float.isNaN(this.n)) && (Float.isNaN(this.o)) && (Float.isNaN(this.p)))
    {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
    f();
  }
  
  private void setOverlay(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public float getBrightness()
  {
    return this.a.d;
  }
  
  public float getContrast()
  {
    return this.a.f;
  }
  
  public float getCrossfade()
  {
    return this.e;
  }
  
  public float getImagePanX()
  {
    return this.m;
  }
  
  public float getImagePanY()
  {
    return this.n;
  }
  
  public float getImageRotate()
  {
    return this.p;
  }
  
  public float getImageZoom()
  {
    return this.o;
  }
  
  public float getRound()
  {
    return this.g;
  }
  
  public float getRoundPercent()
  {
    return this.f;
  }
  
  public float getSaturation()
  {
    return this.a.e;
  }
  
  public float getWarmth()
  {
    return this.a.g;
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
  }
  
  public void setAltImageResource(int paramInt)
  {
    Object localObject = a.b(getContext(), paramInt).mutate();
    this.c = ((Drawable)localObject);
    Drawable[] arrayOfDrawable = this.k;
    arrayOfDrawable[0] = this.d;
    arrayOfDrawable[1] = localObject;
    localObject = new LayerDrawable(this.k);
    this.l = ((LayerDrawable)localObject);
    super.setImageDrawable((Drawable)localObject);
    setCrossfade(this.e);
  }
  
  public void setBrightness(float paramFloat)
  {
    c localc = this.a;
    localc.d = paramFloat;
    localc.c(this);
  }
  
  public void setContrast(float paramFloat)
  {
    c localc = this.a;
    localc.f = paramFloat;
    localc.c(this);
  }
  
  public void setCrossfade(float paramFloat)
  {
    this.e = paramFloat;
    if (this.k != null)
    {
      if (!this.b) {
        this.l.getDrawable(0).setAlpha((int)((1.0F - this.e) * 255.0F));
      }
      this.l.getDrawable(1).setAlpha((int)(this.e * 255.0F));
      super.setImageDrawable(this.l);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.c != null) && (paramDrawable != null))
    {
      paramDrawable = paramDrawable.mutate();
      this.d = paramDrawable;
      Drawable[] arrayOfDrawable = this.k;
      arrayOfDrawable[0] = paramDrawable;
      arrayOfDrawable[1] = this.c;
      paramDrawable = new LayerDrawable(this.k);
      this.l = paramDrawable;
      super.setImageDrawable(paramDrawable);
      setCrossfade(this.e);
      return;
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImagePanX(float paramFloat)
  {
    this.m = paramFloat;
    g();
  }
  
  public void setImagePanY(float paramFloat)
  {
    this.n = paramFloat;
    g();
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.c != null)
    {
      Object localObject = a.b(getContext(), paramInt).mutate();
      this.d = ((Drawable)localObject);
      Drawable[] arrayOfDrawable = this.k;
      arrayOfDrawable[0] = localObject;
      arrayOfDrawable[1] = this.c;
      localObject = new LayerDrawable(this.k);
      this.l = ((LayerDrawable)localObject);
      super.setImageDrawable((Drawable)localObject);
      setCrossfade(this.e);
      return;
    }
    super.setImageResource(paramInt);
  }
  
  public void setImageRotate(float paramFloat)
  {
    this.p = paramFloat;
    g();
  }
  
  public void setImageZoom(float paramFloat)
  {
    this.o = paramFloat;
    g();
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
      if (this.h == null) {
        this.h = new Path();
      }
      if (this.j == null) {
        this.j = new RectF();
      }
      if (this.i == null)
      {
        localObject = new b();
        this.i = ((ViewOutlineProvider)localObject);
        setOutlineProvider((ViewOutlineProvider)localObject);
      }
      setClipToOutline(true);
      int i2 = getWidth();
      int i3 = getHeight();
      this.j.set(0.0F, 0.0F, i2, i3);
      this.h.reset();
      Object localObject = this.h;
      RectF localRectF = this.j;
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
      if (this.h == null) {
        this.h = new Path();
      }
      if (this.j == null) {
        this.j = new RectF();
      }
      if (this.i == null)
      {
        a locala = new a();
        this.i = locala;
        setOutlineProvider(locala);
      }
      setClipToOutline(true);
      int i2 = getWidth();
      int i3 = getHeight();
      paramFloat = Math.min(i2, i3) * this.f / 2.0F;
      this.j.set(0.0F, 0.0F, i2, i3);
      this.h.reset();
      this.h.addRoundRect(this.j, paramFloat, paramFloat, Path.Direction.CW);
    }
    else
    {
      setClipToOutline(false);
    }
    if (i1 != 0) {
      invalidateOutline();
    }
  }
  
  public void setSaturation(float paramFloat)
  {
    c localc = this.a;
    localc.e = paramFloat;
    localc.c(this);
  }
  
  public void setWarmth(float paramFloat)
  {
    c localc = this.a;
    localc.g = paramFloat;
    localc.c(this);
  }
  
  class a
    extends ViewOutlineProvider
  {
    a() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      int i = ImageFilterView.this.getWidth();
      int j = ImageFilterView.this.getHeight();
      paramOutline.setRoundRect(0, 0, i, j, Math.min(i, j) * ImageFilterView.a(ImageFilterView.this) / 2.0F);
    }
  }
  
  class b
    extends ViewOutlineProvider
  {
    b() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      paramOutline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.b(ImageFilterView.this));
    }
  }
  
  static class c
  {
    float[] a = new float[20];
    ColorMatrix b = new ColorMatrix();
    ColorMatrix c = new ColorMatrix();
    float d = 1.0F;
    float e = 1.0F;
    float f = 1.0F;
    float g = 1.0F;
    
    private void a(float paramFloat)
    {
      float[] arrayOfFloat = this.a;
      arrayOfFloat[0] = paramFloat;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = 0.0F;
      arrayOfFloat[6] = paramFloat;
      arrayOfFloat[7] = 0.0F;
      arrayOfFloat[8] = 0.0F;
      arrayOfFloat[9] = 0.0F;
      arrayOfFloat[10] = 0.0F;
      arrayOfFloat[11] = 0.0F;
      arrayOfFloat[12] = paramFloat;
      arrayOfFloat[13] = 0.0F;
      arrayOfFloat[14] = 0.0F;
      arrayOfFloat[15] = 0.0F;
      arrayOfFloat[16] = 0.0F;
      arrayOfFloat[17] = 0.0F;
      arrayOfFloat[18] = 1.0F;
      arrayOfFloat[19] = 0.0F;
    }
    
    private void b(float paramFloat)
    {
      float f3 = 1.0F - paramFloat;
      float f1 = 0.2999F * f3;
      float f2 = 0.587F * f3;
      f3 *= 0.114F;
      float[] arrayOfFloat = this.a;
      arrayOfFloat[0] = (f1 + paramFloat);
      arrayOfFloat[1] = f2;
      arrayOfFloat[2] = f3;
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = f1;
      arrayOfFloat[6] = (f2 + paramFloat);
      arrayOfFloat[7] = f3;
      arrayOfFloat[8] = 0.0F;
      arrayOfFloat[9] = 0.0F;
      arrayOfFloat[10] = f1;
      arrayOfFloat[11] = f2;
      arrayOfFloat[12] = (f3 + paramFloat);
      arrayOfFloat[13] = 0.0F;
      arrayOfFloat[14] = 0.0F;
      arrayOfFloat[15] = 0.0F;
      arrayOfFloat[16] = 0.0F;
      arrayOfFloat[17] = 0.0F;
      arrayOfFloat[18] = 1.0F;
      arrayOfFloat[19] = 0.0F;
    }
    
    private void d(float paramFloat)
    {
      float f1 = paramFloat;
      if (paramFloat <= 0.0F) {
        f1 = 0.01F;
      }
      paramFloat = 5000.0F / f1 / 100.0F;
      if (paramFloat > 66.0F)
      {
        double d1 = paramFloat - 60.0F;
        f2 = (float)Math.pow(d1, -0.1332047581672669D) * 329.69873F;
        f1 = (float)Math.pow(d1, 0.07551484555006027D) * 288.12216F;
      }
      else
      {
        f1 = (float)Math.log(paramFloat) * 99.470802F - 161.11957F;
        f2 = 255.0F;
      }
      if (paramFloat < 66.0F)
      {
        if (paramFloat > 19.0F) {
          paramFloat = (float)Math.log(paramFloat - 10.0F) * 138.51773F - 305.0448F;
        } else {
          paramFloat = 0.0F;
        }
      }
      else {
        paramFloat = 255.0F;
      }
      float f2 = Math.min(255.0F, Math.max(f2, 0.0F));
      f1 = Math.min(255.0F, Math.max(f1, 0.0F));
      paramFloat = Math.min(255.0F, Math.max(paramFloat, 0.0F));
      float f4 = (float)Math.log(50.0F);
      float f5 = (float)Math.log(40.0F);
      float f3 = Math.min(255.0F, Math.max(255.0F, 0.0F));
      f4 = Math.min(255.0F, Math.max(f4 * 99.470802F - 161.11957F, 0.0F));
      f5 = Math.min(255.0F, Math.max(f5 * 138.51773F - 305.0448F, 0.0F));
      f2 /= f3;
      f1 /= f4;
      paramFloat /= f5;
      float[] arrayOfFloat = this.a;
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = 0.0F;
      arrayOfFloat[6] = f1;
      arrayOfFloat[7] = 0.0F;
      arrayOfFloat[8] = 0.0F;
      arrayOfFloat[9] = 0.0F;
      arrayOfFloat[10] = 0.0F;
      arrayOfFloat[11] = 0.0F;
      arrayOfFloat[12] = paramFloat;
      arrayOfFloat[13] = 0.0F;
      arrayOfFloat[14] = 0.0F;
      arrayOfFloat[15] = 0.0F;
      arrayOfFloat[16] = 0.0F;
      arrayOfFloat[17] = 0.0F;
      arrayOfFloat[18] = 1.0F;
      arrayOfFloat[19] = 0.0F;
    }
    
    void c(ImageView paramImageView)
    {
      this.b.reset();
      float f1 = this.e;
      int j = 1;
      int i;
      if (f1 != 1.0F)
      {
        b(f1);
        this.b.set(this.a);
        i = 1;
      }
      else
      {
        i = 0;
      }
      f1 = this.f;
      if (f1 != 1.0F)
      {
        this.c.setScale(f1, f1, f1, 1.0F);
        this.b.postConcat(this.c);
        i = 1;
      }
      f1 = this.g;
      if (f1 != 1.0F)
      {
        d(f1);
        this.c.set(this.a);
        this.b.postConcat(this.c);
        i = 1;
      }
      f1 = this.d;
      if (f1 != 1.0F)
      {
        a(f1);
        this.c.set(this.a);
        this.b.postConcat(this.c);
        i = j;
      }
      if (i != 0)
      {
        paramImageView.setColorFilter(new ColorMatrixColorFilter(this.b));
        return;
      }
      paramImageView.clearColorFilter();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterView
 * JD-Core Version:    0.7.0.1
 */