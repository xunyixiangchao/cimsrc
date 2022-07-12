package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import o7.c;
import r7.h;
import r7.m;
import r7.m.b;
import r7.n;
import r7.p;

public class ShapeableImageView
  extends AppCompatImageView
  implements p
{
  private static final int s = R.style.Widget_MaterialComponents_ShapeableImageView;
  private final n a = n.k();
  private final RectF b;
  private final RectF c;
  private final Paint d;
  private final Paint e;
  private final Path f = new Path();
  private ColorStateList g;
  private h h;
  private m i;
  private float j;
  private Path k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private boolean r = false;
  
  public ShapeableImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ShapeableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShapeableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    paramContext = getContext();
    Object localObject = new Paint();
    this.e = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.b = new RectF();
    this.c = new RectF();
    this.k = new Path();
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeableImageView, paramInt, i1);
    this.g = c.a(paramContext, (TypedArray)localObject, R.styleable.ShapeableImageView_strokeColor);
    this.j = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
    int i2 = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
    this.l = i2;
    this.m = i2;
    this.n = i2;
    this.o = i2;
    this.l = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, i2);
    this.m = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, i2);
    this.n = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, i2);
    this.o = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, i2);
    this.p = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, -2147483648);
    this.q = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, -2147483648);
    ((TypedArray)localObject).recycle();
    localObject = new Paint();
    this.d = ((Paint)localObject);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setAntiAlias(true);
    this.i = m.e(paramContext, paramAttributeSet, paramInt, i1).m();
    setOutlineProvider(new a());
  }
  
  private void g(Canvas paramCanvas)
  {
    if (this.g == null) {
      return;
    }
    this.d.setStrokeWidth(this.j);
    int i1 = this.g.getColorForState(getDrawableState(), this.g.getDefaultColor());
    if ((this.j > 0.0F) && (i1 != 0))
    {
      this.d.setColor(i1);
      paramCanvas.drawPath(this.f, this.d);
    }
  }
  
  private boolean h()
  {
    return (this.p != -2147483648) || (this.q != -2147483648);
  }
  
  private boolean i()
  {
    return getLayoutDirection() == 1;
  }
  
  private void j(int paramInt1, int paramInt2)
  {
    this.b.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    this.a.d(this.i, 1.0F, this.b, this.f);
    this.k.rewind();
    this.k.addPath(this.f);
    this.c.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.k.addRect(this.c, Path.Direction.CCW);
  }
  
  public int getContentPaddingBottom()
  {
    return this.o;
  }
  
  public final int getContentPaddingEnd()
  {
    int i1 = this.q;
    if (i1 != -2147483648) {
      return i1;
    }
    if (i()) {
      return this.l;
    }
    return this.n;
  }
  
  public int getContentPaddingLeft()
  {
    if (h())
    {
      int i1;
      if (i())
      {
        i1 = this.q;
        if (i1 != -2147483648) {
          return i1;
        }
      }
      if (!i())
      {
        i1 = this.p;
        if (i1 != -2147483648) {
          return i1;
        }
      }
    }
    return this.l;
  }
  
  public int getContentPaddingRight()
  {
    if (h())
    {
      int i1;
      if (i())
      {
        i1 = this.p;
        if (i1 != -2147483648) {
          return i1;
        }
      }
      if (!i())
      {
        i1 = this.q;
        if (i1 != -2147483648) {
          return i1;
        }
      }
    }
    return this.n;
  }
  
  public final int getContentPaddingStart()
  {
    int i1 = this.p;
    if (i1 != -2147483648) {
      return i1;
    }
    if (i()) {
      return this.n;
    }
    return this.l;
  }
  
  public int getContentPaddingTop()
  {
    return this.m;
  }
  
  public int getPaddingBottom()
  {
    return super.getPaddingBottom() - getContentPaddingBottom();
  }
  
  public int getPaddingEnd()
  {
    return super.getPaddingEnd() - getContentPaddingEnd();
  }
  
  public int getPaddingLeft()
  {
    return super.getPaddingLeft() - getContentPaddingLeft();
  }
  
  public int getPaddingRight()
  {
    return super.getPaddingRight() - getContentPaddingRight();
  }
  
  public int getPaddingStart()
  {
    return super.getPaddingStart() - getContentPaddingStart();
  }
  
  public int getPaddingTop()
  {
    return super.getPaddingTop() - getContentPaddingTop();
  }
  
  public m getShapeAppearanceModel()
  {
    return this.i;
  }
  
  public ColorStateList getStrokeColor()
  {
    return this.g;
  }
  
  public float getStrokeWidth()
  {
    return this.j;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    setLayerType(0, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(this.k, this.e);
    g(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.r) {
      return;
    }
    if (!isLayoutDirectionResolved()) {
      return;
    }
    this.r = true;
    if ((!isPaddingRelative()) && (!h()))
    {
      setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
      return;
    }
    setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    j(paramInt1, paramInt2);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1 + getContentPaddingLeft(), paramInt2 + getContentPaddingTop(), paramInt3 + getContentPaddingRight(), paramInt4 + getContentPaddingBottom());
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1 + getContentPaddingStart(), paramInt2 + getContentPaddingTop(), paramInt3 + getContentPaddingEnd(), paramInt4 + getContentPaddingBottom());
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    this.i = paramm;
    h localh = this.h;
    if (localh != null) {
      localh.setShapeAppearanceModel(paramm);
    }
    j(getWidth(), getHeight());
    invalidate();
    invalidateOutline();
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    invalidate();
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    setStrokeColor(c.a.a(getContext(), paramInt));
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      this.j = paramFloat;
      invalidate();
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  @TargetApi(21)
  class a
    extends ViewOutlineProvider
  {
    private final Rect a = new Rect();
    
    a() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      if (ShapeableImageView.a(ShapeableImageView.this) == null) {
        return;
      }
      if (ShapeableImageView.b(ShapeableImageView.this) == null) {
        ShapeableImageView.d(ShapeableImageView.this, new h(ShapeableImageView.a(ShapeableImageView.this)));
      }
      ShapeableImageView.f(ShapeableImageView.this).round(this.a);
      ShapeableImageView.b(ShapeableImageView.this).setBounds(this.a);
      ShapeableImageView.b(ShapeableImageView.this).getOutline(paramOutline);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.imageview.ShapeableImageView
 * JD-Core Version:    0.7.0.1
 */