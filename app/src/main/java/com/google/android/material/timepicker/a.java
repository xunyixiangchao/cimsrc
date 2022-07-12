package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class a
  implements InputFilter
{
  private int a;
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    try
    {
      paramSpanned = new StringBuilder(paramSpanned);
      paramSpanned.replace(paramInt3, paramInt4, paramCharSequence.subSequence(paramInt1, paramInt2).toString());
      paramInt1 = Integer.parseInt(paramSpanned.toString());
      paramInt2 = this.a;
      if (paramInt1 <= paramInt2) {
        return null;
      }
    }
    catch (NumberFormatException paramCharSequence)
    {
      label55:
      break label55;
    }
    return "";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.a
 * JD-Core Version:    0.7.0.1
 */