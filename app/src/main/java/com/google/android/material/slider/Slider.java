package com.google.android.material.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.R.attr;
import java.util.List;

public class Slider
  extends BaseSlider<Slider, Object, Object>
{
  public Slider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public Slider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842788 });
    if (paramContext.hasValue(0)) {
      setValue(paramContext.getFloat(0, 0.0F));
    }
    paramContext.recycle();
  }
  
  protected boolean W()
  {
    if (getActiveThumbIndex() != -1) {
      return true;
    }
    setActiveThumbIndex(0);
    return true;
  }
  
  public float getValue()
  {
    return ((Float)getValues().get(0)).floatValue();
  }
  
  public void setCustomThumbDrawable(int paramInt)
  {
    super.setCustomThumbDrawable(paramInt);
  }
  
  public void setCustomThumbDrawable(Drawable paramDrawable)
  {
    super.setCustomThumbDrawable(paramDrawable);
  }
  
  public void setValue(float paramFloat)
  {
    setValues(new Float[] { Float.valueOf(paramFloat) });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.slider.Slider
 * JD-Core Version:    0.7.0.1
 */