package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R.styleable;
import c.a;

public class ImageFilterButton
  extends AppCompatImageButton
{
  private ImageFilterView.c d = new ImageFilterView.c();
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = (0.0F / 0.0F);
  private Path h;
  ViewOutlineProvider i;
  RectF j;
  Drawable[] k = new Drawable[2];
  LayerDrawable l;
  private boolean m = true;
  private Drawable n = null;
  private Drawable o = null;
  private float p = (0.0F / 0.0F);
  private float q = (0.0F / 0.0F);
  private float r = (0.0F / 0.0F);
  private float s = (0.0F / 0.0F);
  
  public ImageFilterButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  public ImageFilterButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    setPadding(0, 0, 0, 0);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ImageFilterView);
      int i2 = paramContext.getIndexCount();
      this.n = paramContext.getDrawable(R.styleable.ImageFilterView_altSrc);
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
        } else if (i3 == R.styleable.ImageFilterView_round) {
          setRound(paramContext.getDimension(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_roundPercent) {
          setRoundPercent(paramContext.getFloat(i3, 0.0F));
        } else if (i3 == R.styleable.ImageFilterView_overlay) {
          setOverlay(paramContext.getBoolean(i3, this.m));
        } else if (i3 == R.styleable.ImageFilterView_imagePanX) {
          setImagePanX(paramContext.getFloat(i3, this.p));
        } else if (i3 == R.styleable.ImageFilterView_imagePanY) {
          setImagePanY(paramContext.getFloat(i3, this.q));
        } else if (i3 == R.styleable.ImageFilterView_imageRotate) {
          setImageRotate(paramContext.getFloat(i3, this.s));
        } else if (i3 == R.styleable.ImageFilterView_imageZoom) {
          setImageZoom(paramContext.getFloat(i3, this.r));
        }
        i1 += 1;
      }
      paramContext.recycle();
      paramContext = getDrawable();
      this.o = paramContext;
      if ((this.n != null) && (paramContext != null))
      {
        paramContext = this.k;
        paramAttributeSet = getDrawable().mutate();
        this.o = paramAttributeSet;
        paramContext[0] = paramAttributeSet;
        this.k[1] = this.n.mutate();
        paramContext = new LayerDrawable(this.k);
        this.l = paramContext;
        paramContext.getDrawable(1).setAlpha((int)(this.e * 255.0F));
        if (!this.m) {
          this.l.getDrawable(0).setAlpha((int)((1.0F - this.e) * 255.0F));
        }
        super.setImageDrawable(this.l);
        return;
      }
      paramAttributeSet = getDrawable();
      this.o = paramAttributeSet;
      if (paramAttributeSet != null)
      {
        paramContext = this.k;
        paramAttributeSet = paramAttributeSet.mutate();
        this.o = paramAttributeSet;
        paramContext[0] = paramAttributeSet;
      }
    }
  }
  
  private void d()
  {
    if ((Float.isNaN(this.p)) && (Float.isNaN(this.q)) && (Float.isNaN(this.r)) && (Float.isNaN(this.s))) {
      return;
    }
    boolean bool = Float.isNaN(this.p);
    float f3 = 0.0F;
    float f1;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = this.p;
    }
    float f2;
    if (Float.isNaN(this.q)) {
      f2 = 0.0F;
    } else {
      f2 = this.q;
    }
    float f4;
    if (Float.isNaN(this.r)) {
      f4 = 1.0F;
    } else {
      f4 = this.r;
    }
    if (!Float.isNaN(this.s)) {
      f3 = this.s;
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
  
  private void e()
  {
    if ((Float.isNaN(this.p)) && (Float.isNaN(this.q)) && (Float.isNaN(this.r)) && (Float.isNaN(this.s)))
    {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
    d();
  }
  
  private void setOverlay(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public float getContrast()
  {
    return this.d.f;
  }
  
  public float getCrossfade()
  {
    return this.e;
  }
  
  public float getImagePanX()
  {
    return this.p;
  }
  
  public float getImagePanY()
  {
    return this.q;
  }
  
  public float getImageRotate()
  {
    return this.s;
  }
  
  public float getImageZoom()
  {
    return this.r;
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
    return this.d.e;
  }
  
  public float getWarmth()
  {
    return this.d.g;
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setAltImageResource(int paramInt)
  {
    Object localObject = a.b(getContext(), paramInt).mutate();
    this.n = ((Drawable)localObject);
    Drawable[] arrayOfDrawable = this.k;
    arrayOfDrawable[0] = this.o;
    arrayOfDrawable[1] = localObject;
    localObject = new LayerDrawable(this.k);
    this.l = ((LayerDrawable)localObject);
    super.setImageDrawable((Drawable)localObject);
    setCrossfade(this.e);
  }
  
  public void setBrightness(float paramFloat)
  {
    ImageFilterView.c localc = this.d;
    localc.d = paramFloat;
    localc.c(this);
  }
  
  public void setContrast(float paramFloat)
  {
    ImageFilterView.c localc = this.d;
    localc.f = paramFloat;
    localc.c(this);
  }
  
  public void setCrossfade(float paramFloat)
  {
    this.e = paramFloat;
    if (this.k != null)
    {
      if (!this.m) {
        this.l.getDrawable(0).setAlpha((int)((1.0F - this.e) * 255.0F));
      }
      this.l.getDrawable(1).setAlpha((int)(this.e * 255.0F));
      super.setImageDrawable(this.l);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.n != null) && (paramDrawable != null))
    {
      paramDrawable = paramDrawable.mutate();
      this.o = paramDrawable;
      Drawable[] arrayOfDrawable = this.k;
      arrayOfDrawable[0] = paramDrawable;
      arrayOfDrawable[1] = this.n;
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
    this.p = paramFloat;
    e();
  }
  
  public void setImagePanY(float paramFloat)
  {
    this.q = paramFloat;
    e();
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.n != null)
    {
      Object localObject = a.b(getContext(), paramInt).mutate();
      this.o = ((Drawable)localObject);
      Drawable[] arrayOfDrawable = this.k;
      arrayOfDrawable[0] = localObject;
      arrayOfDrawable[1] = this.n;
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
    this.s = paramFloat;
    e();
  }
  
  public void setImageZoom(float paramFloat)
  {
    this.r = paramFloat;
    e();
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
    ImageFilterView.c localc = this.d;
    localc.e = paramFloat;
    localc.c(this);
  }
  
  public void setWarmth(float paramFloat)
  {
    ImageFilterView.c localc = this.d;
    localc.g = paramFloat;
    localc.c(this);
  }
  
  class a
    extends ViewOutlineProvider
  {
    a() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      int i = ImageFilterButton.this.getWidth();
      int j = ImageFilterButton.this.getHeight();
      paramOutline.setRoundRect(0, 0, i, j, Math.min(i, j) * ImageFilterButton.a(ImageFilterButton.this) / 2.0F);
    }
  }
  
  class b
    extends ViewOutlineProvider
  {
    b() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      paramOutline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.b(ImageFilterButton.this));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterButton
 * JD-Core Version:    0.7.0.1
 */