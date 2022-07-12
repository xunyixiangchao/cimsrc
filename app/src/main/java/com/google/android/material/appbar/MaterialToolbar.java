package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.q;
import r7.h;
import r7.i;

public class MaterialToolbar
  extends Toolbar
{
  private static final int a0 = R.style.Widget_MaterialComponents_Toolbar;
  private static final ImageView.ScaleType[] b0 = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  private Integer S;
  private boolean T;
  private boolean U;
  private ImageView.ScaleType V;
  private Boolean W;
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialToolbar, paramInt, i, new int[0]);
    paramInt = R.styleable.MaterialToolbar_navigationIconTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      setNavigationIconTint(paramAttributeSet.getColor(paramInt, -1));
    }
    this.T = paramAttributeSet.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
    this.U = paramAttributeSet.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
    paramInt = paramAttributeSet.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
    if (paramInt >= 0)
    {
      ImageView.ScaleType[] arrayOfScaleType = b0;
      if (paramInt < arrayOfScaleType.length) {
        this.V = arrayOfScaleType[paramInt];
      }
    }
    paramInt = R.styleable.MaterialToolbar_logoAdjustViewBounds;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.W = Boolean.valueOf(paramAttributeSet.getBoolean(paramInt, false));
    }
    paramAttributeSet.recycle();
    S(paramContext);
  }
  
  private Pair<Integer, Integer> R(TextView paramTextView1, TextView paramTextView2)
  {
    int j = getMeasuredWidth();
    int i2 = j / 2;
    int i = getPaddingLeft();
    int m = j - getPaddingRight();
    int k = 0;
    while (k < getChildCount())
    {
      View localView = getChildAt(k);
      int i1 = m;
      int n = i;
      if (localView.getVisibility() != 8)
      {
        i1 = m;
        n = i;
        if (localView != paramTextView1)
        {
          i1 = m;
          n = i;
          if (localView != paramTextView2)
          {
            j = i;
            if (localView.getRight() < i2)
            {
              j = i;
              if (localView.getRight() > i) {
                j = localView.getRight();
              }
            }
            i1 = m;
            n = j;
            if (localView.getLeft() > i2)
            {
              i1 = m;
              n = j;
              if (localView.getLeft() < m)
              {
                i1 = localView.getLeft();
                n = j;
              }
            }
          }
        }
      }
      k += 1;
      m = i1;
      i = n;
    }
    return new Pair(Integer.valueOf(i), Integer.valueOf(m));
  }
  
  private void S(Context paramContext)
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable != null) && (!(localDrawable instanceof ColorDrawable))) {
      return;
    }
    h localh = new h();
    int i;
    if (localDrawable != null) {
      i = ((ColorDrawable)localDrawable).getColor();
    } else {
      i = 0;
    }
    localh.b0(ColorStateList.valueOf(i));
    localh.Q(paramContext);
    localh.a0(x.w(this));
    x.u0(this, localh);
  }
  
  private void T(View paramView, Pair<Integer, Integer> paramPair)
  {
    int j = getMeasuredWidth();
    int i = paramView.getMeasuredWidth();
    int k = j / 2 - i / 2;
    int m = i + k;
    int n = Math.max(Math.max(((Integer)paramPair.first).intValue() - k, 0), Math.max(m - ((Integer)paramPair.second).intValue(), 0));
    j = k;
    i = m;
    if (n > 0)
    {
      j = k + n;
      i = m - n;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i - j, 1073741824), paramView.getMeasuredHeightAndState());
    }
    paramView.layout(j, paramView.getTop(), i, paramView.getBottom());
  }
  
  private void U()
  {
    if ((!this.T) && (!this.U)) {
      return;
    }
    TextView localTextView1 = q.e(this);
    TextView localTextView2 = q.c(this);
    if ((localTextView1 == null) && (localTextView2 == null)) {
      return;
    }
    Pair localPair = R(localTextView1, localTextView2);
    if ((this.T) && (localTextView1 != null)) {
      T(localTextView1, localPair);
    }
    if ((this.U) && (localTextView2 != null)) {
      T(localTextView2, localPair);
    }
  }
  
  private Drawable V(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.S != null)
      {
        localDrawable = r0.a.r(paramDrawable.mutate());
        r0.a.n(localDrawable, this.S.intValue());
      }
    }
    return localDrawable;
  }
  
  private void W()
  {
    ImageView localImageView = q.b(this);
    if (localImageView != null)
    {
      Object localObject = this.W;
      if (localObject != null) {
        localImageView.setAdjustViewBounds(((Boolean)localObject).booleanValue());
      }
      localObject = this.V;
      if (localObject != null) {
        localImageView.setScaleType((ImageView.ScaleType)localObject);
      }
    }
  }
  
  public ImageView.ScaleType getLogoScaleType()
  {
    return this.V;
  }
  
  public Integer getNavigationIconTint()
  {
    return this.S;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.e(this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    U();
    W();
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    i.d(this, paramFloat);
  }
  
  public void setLogoAdjustViewBounds(boolean paramBoolean)
  {
    Boolean localBoolean = this.W;
    if ((localBoolean == null) || (localBoolean.booleanValue() != paramBoolean))
    {
      this.W = Boolean.valueOf(paramBoolean);
      requestLayout();
    }
  }
  
  public void setLogoScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.V != paramScaleType)
    {
      this.V = paramScaleType;
      requestLayout();
    }
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    super.setNavigationIcon(V(paramDrawable));
  }
  
  public void setNavigationIconTint(int paramInt)
  {
    this.S = Integer.valueOf(paramInt);
    Drawable localDrawable = getNavigationIcon();
    if (localDrawable != null) {
      setNavigationIcon(localDrawable);
    }
  }
  
  public void setSubtitleCentered(boolean paramBoolean)
  {
    if (this.U != paramBoolean)
    {
      this.U = paramBoolean;
      requestLayout();
    }
  }
  
  public void setTitleCentered(boolean paramBoolean)
  {
    if (this.T != paramBoolean)
    {
      this.T = paramBoolean;
      requestLayout();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.MaterialToolbar
 * JD-Core Version:    0.7.0.1
 */