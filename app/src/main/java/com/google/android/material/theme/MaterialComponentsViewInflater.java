package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater
  extends f
{
  protected AppCompatAutoCompleteTextView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatButton d(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatCheckBox e(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialCheckBox(paramContext, paramAttributeSet);
  }
  
  protected AppCompatRadioButton k(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialRadioButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatTextView o(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialTextView(paramContext, paramAttributeSet);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.7.0.1
 */