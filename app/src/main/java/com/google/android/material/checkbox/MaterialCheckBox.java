package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.d;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import o7.c;

public class MaterialCheckBox
  extends AppCompatCheckBox
{
  private static final int h = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
  private static final int[][] i;
  private ColorStateList e;
  private boolean f;
  private boolean g;
  
  static
  {
    int[] arrayOfInt1 = { 16842910, 16842912 };
    int[] arrayOfInt2 = { -16842910, -16842912 };
    i = new int[][] { arrayOfInt1, { 16842910, -16842912 }, { -16842910, 16842912 }, arrayOfInt2 };
  }
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, j), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialCheckBox, paramInt, j, new int[0]);
    paramInt = R.styleable.MaterialCheckBox_buttonTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      d.c(this, c.a(paramContext, paramAttributeSet, paramInt));
    }
    this.f = paramAttributeSet.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
    this.g = paramAttributeSet.getBoolean(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (this.e == null)
    {
      int[][] arrayOfInt = i;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      int j = g7.a.d(this, R.attr.colorControlActivated);
      int k = g7.a.d(this, R.attr.colorSurface);
      int m = g7.a.d(this, R.attr.colorOnSurface);
      arrayOfInt1[0] = g7.a.h(k, j, 1.0F);
      arrayOfInt1[1] = g7.a.h(k, m, 0.54F);
      arrayOfInt1[2] = g7.a.h(k, m, 0.38F);
      arrayOfInt1[3] = g7.a.h(k, m, 0.38F);
      this.e = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.f) && (d.b(this) == null)) {
      setUseMaterialThemeColors(true);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.g) && (TextUtils.isEmpty(getText())))
    {
      Drawable localDrawable = d.a(this);
      if (localDrawable != null)
      {
        if (t.i(this)) {
          j = -1;
        } else {
          j = 1;
        }
        int j = (getWidth() - localDrawable.getIntrinsicWidth()) / 2 * j;
        int k = paramCanvas.save();
        paramCanvas.translate(j, 0.0F);
        super.onDraw(paramCanvas);
        paramCanvas.restoreToCount(k);
        if (getBackground() != null)
        {
          paramCanvas = localDrawable.getBounds();
          r0.a.l(getBackground(), paramCanvas.left + j, paramCanvas.top, paramCanvas.right + j, paramCanvas.bottom);
        }
        return;
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setCenterIfNoTextEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.f = paramBoolean;
    ColorStateList localColorStateList;
    if (paramBoolean) {
      localColorStateList = getMaterialThemeColorsTintList();
    } else {
      localColorStateList = null;
    }
    d.c(this, localColorStateList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.checkbox.MaterialCheckBox
 * JD-Core Version:    0.7.0.1
 */