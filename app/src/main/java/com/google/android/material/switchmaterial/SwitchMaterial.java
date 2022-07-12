package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;

public class SwitchMaterial
  extends SwitchCompat
{
  private static final int b0 = R.style.Widget_MaterialComponents_CompoundButton_Switch;
  private static final int[][] c0 = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  private final j7.a U;
  private ColorStateList V;
  private ColorStateList W;
  private boolean a0;
  
  public SwitchMaterial(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchMaterial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.U = new j7.a(paramContext);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.SwitchMaterial, paramInt, i, new int[0]);
    this.a0 = paramContext.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
    paramContext.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsThumbTintList()
  {
    if (this.V == null)
    {
      int i = g7.a.d(this, R.attr.colorSurface);
      int j = g7.a.d(this, R.attr.colorControlActivated);
      float f2 = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
      float f1 = f2;
      if (this.U.e()) {
        f1 = f2 + t.h(this);
      }
      int k = this.U.c(i, f1);
      int[][] arrayOfInt = c0;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      arrayOfInt1[0] = g7.a.h(i, j, 1.0F);
      arrayOfInt1[1] = k;
      arrayOfInt1[2] = g7.a.h(i, j, 0.38F);
      arrayOfInt1[3] = k;
      this.V = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.V;
  }
  
  private ColorStateList getMaterialThemeColorsTrackTintList()
  {
    if (this.W == null)
    {
      int[][] arrayOfInt = c0;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      int i = g7.a.d(this, R.attr.colorSurface);
      int j = g7.a.d(this, R.attr.colorControlActivated);
      int k = g7.a.d(this, R.attr.colorOnSurface);
      arrayOfInt1[0] = g7.a.h(i, j, 0.54F);
      arrayOfInt1[1] = g7.a.h(i, k, 0.32F);
      arrayOfInt1[2] = g7.a.h(i, j, 0.12F);
      arrayOfInt1[3] = g7.a.h(i, k, 0.12F);
      this.W = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.W;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.a0) && (getThumbTintList() == null)) {
      setThumbTintList(getMaterialThemeColorsThumbTintList());
    }
    if ((this.a0) && (getTrackTintList() == null)) {
      setTrackTintList(getMaterialThemeColorsTrackTintList());
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.a0 = paramBoolean;
    ColorStateList localColorStateList;
    if (paramBoolean)
    {
      setThumbTintList(getMaterialThemeColorsThumbTintList());
      localColorStateList = getMaterialThemeColorsTrackTintList();
    }
    else
    {
      localColorStateList = null;
      setThumbTintList(null);
    }
    setTrackTintList(localColorStateList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.switchmaterial.SwitchMaterial
 * JD-Core Version:    0.7.0.1
 */