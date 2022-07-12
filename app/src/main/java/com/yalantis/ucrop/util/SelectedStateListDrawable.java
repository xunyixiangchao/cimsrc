package com.yalantis.ucrop.util;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class SelectedStateListDrawable
  extends StateListDrawable
{
  private int mSelectionColor;
  
  public SelectedStateListDrawable(Drawable paramDrawable, int paramInt)
  {
    this.mSelectionColor = paramInt;
    addState(new int[] { 16842913 }, paramDrawable);
    addState(new int[0], paramDrawable);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (paramArrayOfInt[i] == 16842913) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0) {
      super.setColorFilter(this.mSelectionColor, PorterDuff.Mode.SRC_ATOP);
    } else {
      super.clearColorFilter();
    }
    return super.onStateChange(paramArrayOfInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.SelectedStateListDrawable
 * JD-Core Version:    0.7.0.1
 */