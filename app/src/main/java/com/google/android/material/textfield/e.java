package com.google.android.material.textfield;

import android.content.Context;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;

abstract class e
{
  TextInputLayout a;
  Context b;
  CheckableImageButton c;
  final int d;
  
  e(TextInputLayout paramTextInputLayout, int paramInt)
  {
    this.a = paramTextInputLayout;
    this.b = paramTextInputLayout.getContext();
    this.c = paramTextInputLayout.getEndIconView();
    this.d = paramInt;
  }
  
  abstract void a();
  
  boolean b(int paramInt)
  {
    return true;
  }
  
  void c(boolean paramBoolean) {}
  
  boolean d()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.e
 * JD-Core Version:    0.7.0.1
 */