package com.google.android.material.slider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider
  extends BaseSlider<RangeSlider, Object, Object>
{
  private float h0;
  private int i0;
  
  public RangeSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public RangeSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.RangeSlider, paramInt, BaseSlider.g0, new int[0]);
    paramInt = R.styleable.RangeSlider_values;
    if (paramContext.hasValue(paramInt))
    {
      paramInt = paramContext.getResourceId(paramInt, 0);
      setValues(t0(paramContext.getResources().obtainTypedArray(paramInt)));
    }
    this.h0 = paramContext.getDimension(R.styleable.RangeSlider_minSeparation, 0.0F);
    paramContext.recycle();
  }
  
  private static List<Float> t0(TypedArray paramTypedArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramTypedArray.length())
    {
      localArrayList.add(Float.valueOf(paramTypedArray.getFloat(i, -1.0F)));
      i += 1;
    }
    return localArrayList;
  }
  
  public float getMinSeparation()
  {
    return this.h0;
  }
  
  public List<Float> getValues()
  {
    return super.getValues();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (RangeSliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.h0 = RangeSliderState.g(paramParcelable);
    int i = RangeSliderState.i(paramParcelable);
    this.i0 = i;
    setSeparationUnit(i);
  }
  
  public Parcelable onSaveInstanceState()
  {
    RangeSliderState localRangeSliderState = new RangeSliderState(super.onSaveInstanceState());
    RangeSliderState.h(localRangeSliderState, this.h0);
    RangeSliderState.m(localRangeSliderState, this.i0);
    return localRangeSliderState;
  }
  
  public void setCustomThumbDrawable(int paramInt)
  {
    super.setCustomThumbDrawable(paramInt);
  }
  
  public void setCustomThumbDrawable(Drawable paramDrawable)
  {
    super.setCustomThumbDrawable(paramDrawable);
  }
  
  public void setCustomThumbDrawablesForValues(int... paramVarArgs)
  {
    super.setCustomThumbDrawablesForValues(paramVarArgs);
  }
  
  public void setCustomThumbDrawablesForValues(Drawable... paramVarArgs)
  {
    super.setCustomThumbDrawablesForValues(paramVarArgs);
  }
  
  public void setMinSeparation(float paramFloat)
  {
    this.h0 = paramFloat;
    this.i0 = 0;
    setSeparationUnit(0);
  }
  
  public void setMinSeparationValue(float paramFloat)
  {
    this.h0 = paramFloat;
    this.i0 = 1;
    setSeparationUnit(1);
  }
  
  public void setValues(List<Float> paramList)
  {
    super.setValues(paramList);
  }
  
  public void setValues(Float... paramVarArgs)
  {
    super.setValues(paramVarArgs);
  }
  
  static class RangeSliderState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<RangeSliderState> CREATOR = new a();
    private float a;
    private int b;
    
    private RangeSliderState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readFloat();
      this.b = paramParcel.readInt();
    }
    
    RangeSliderState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.a);
      paramParcel.writeInt(this.b);
    }
    
    class a
      implements Parcelable.Creator<RangeSlider.RangeSliderState>
    {
      public RangeSlider.RangeSliderState a(Parcel paramParcel)
      {
        return new RangeSlider.RangeSliderState(paramParcel, null);
      }
      
      public RangeSlider.RangeSliderState[] b(int paramInt)
      {
        return new RangeSlider.RangeSliderState[paramInt];
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.slider.RangeSlider
 * JD-Core Version:    0.7.0.1
 */