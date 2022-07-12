package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.d;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import o7.c;

public class MaterialRadioButton
  extends AppCompatRadioButton
{
  private static final int g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
  private static final int[][] h = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  private ColorStateList e;
  private boolean f;
  
  public MaterialRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public MaterialRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialRadioButton, paramInt, i, new int[0]);
    paramInt = R.styleable.MaterialRadioButton_buttonTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      d.c(this, c.a(paramContext, paramAttributeSet, paramInt));
    }
    this.f = paramAttributeSet.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (this.e == null)
    {
      int i = g7.a.d(this, R.attr.colorControlActivated);
      int j = g7.a.d(this, R.attr.colorOnSurface);
      int k = g7.a.d(this, R.attr.colorSurface);
      int[][] arrayOfInt = h;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      arrayOfInt1[0] = g7.a.h(k, i, 1.0F);
      arrayOfInt1[1] = g7.a.h(k, j, 0.54F);
      arrayOfInt1[2] = g7.a.h(k, j, 0.38F);
      arrayOfInt1[3] = g7.a.h(k, j, 0.38F);
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
 * Qualified Name:     com.google.android.material.radiobutton.MaterialRadioButton
 * JD-Core Version:    0.7.0.1
 */