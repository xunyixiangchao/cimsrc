package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.cardview.R.attr;
import androidx.cardview.R.color;
import androidx.cardview.R.style;
import androidx.cardview.R.styleable;

public class CardView
  extends FrameLayout
{
  private static final int[] h = { 16842801 };
  private static final c i;
  private boolean a;
  private boolean b;
  int c;
  int d;
  final Rect e;
  final Rect f;
  private final b g;
  
  static
  {
    a locala = new a();
    i = locala;
    locala.g();
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.cardViewStyle);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Rect localRect = new Rect();
    this.e = localRect;
    this.f = new Rect();
    a locala = new a();
    this.g = locala;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt, R.style.CardView);
    paramInt = R.styleable.CardView_cardBackgroundColor;
    if (localTypedArray.hasValue(paramInt)) {}
    for (paramAttributeSet = localTypedArray.getColorStateList(paramInt);; paramAttributeSet = ColorStateList.valueOf(paramAttributeSet.getColor(paramInt)))
    {
      break;
      paramAttributeSet = getContext().obtainStyledAttributes(h);
      paramInt = paramAttributeSet.getColor(0, 0);
      paramAttributeSet.recycle();
      paramAttributeSet = new float[3];
      Color.colorToHSV(paramInt, paramAttributeSet);
      if (paramAttributeSet[2] > 0.5F)
      {
        paramAttributeSet = getResources();
        paramInt = R.color.cardview_light_background;
      }
      else
      {
        paramAttributeSet = getResources();
        paramInt = R.color.cardview_dark_background;
      }
    }
    float f3 = localTypedArray.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
    float f2 = localTypedArray.getDimension(R.styleable.CardView_cardElevation, 0.0F);
    float f1 = localTypedArray.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
    this.a = localTypedArray.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
    this.b = localTypedArray.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
    localRect.left = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, paramInt);
    localRect.top = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, paramInt);
    localRect.right = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, paramInt);
    localRect.bottom = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, paramInt);
    if (f2 > f1) {
      f1 = f2;
    }
    this.c = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
    this.d = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
    localTypedArray.recycle();
    i.c(locala, paramContext, paramAttributeSet, f3, f2, f1);
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.set(paramInt1, paramInt2, paramInt3, paramInt4);
    i.f(this.g);
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return i.b(this.g);
  }
  
  public float getCardElevation()
  {
    return i.e(this.g);
  }
  
  public int getContentPaddingBottom()
  {
    return this.e.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.e.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.e.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.e.top;
  }
  
  public float getMaxCardElevation()
  {
    return i.a(this.g);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.b;
  }
  
  public float getRadius()
  {
    return i.h(this.g);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c localc = i;
    int k = paramInt1;
    int j = paramInt2;
    if (!(localc instanceof a))
    {
      j = View.MeasureSpec.getMode(paramInt1);
      if ((j == -2147483648) || (j == 1073741824)) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(localc.j(this.g)), View.MeasureSpec.getSize(paramInt1)), j);
      }
      j = View.MeasureSpec.getMode(paramInt2);
      if ((j != -2147483648) && (j != 1073741824))
      {
        k = paramInt1;
        j = paramInt2;
      }
      else
      {
        j = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(localc.i(this.g)), View.MeasureSpec.getSize(paramInt2)), j);
        k = paramInt1;
      }
    }
    super.onMeasure(k, j);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    i.n(this.g, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    i.n(this.g, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    i.l(this.g, paramFloat);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    i.o(this.g, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.d = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.c = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.b)
    {
      this.b = paramBoolean;
      i.m(this.g);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    i.d(this.g, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      i.k(this.g);
    }
  }
  
  class a
    implements b
  {
    private Drawable a;
    
    a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      CardView.this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
      CardView localCardView = CardView.this;
      Rect localRect = localCardView.e;
      CardView.c(localCardView, paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 + localRect.right, paramInt4 + localRect.bottom);
    }
    
    public View b()
    {
      return CardView.this;
    }
    
    public void c(Drawable paramDrawable)
    {
      this.a = paramDrawable;
      CardView.this.setBackgroundDrawable(paramDrawable);
    }
    
    public boolean d()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public boolean e()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public Drawable f()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.cardview.widget.CardView
 * JD-Core Version:    0.7.0.1
 */