package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.x;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import r0.a;

class f
{
  static void a(TextInputLayout paramTextInputLayout, CheckableImageButton paramCheckableImageButton, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable2 = paramCheckableImageButton.getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable2 = a.r(localDrawable2).mutate();
      if ((paramColorStateList != null) && (paramColorStateList.isStateful())) {
        a.o(localDrawable2, ColorStateList.valueOf(paramColorStateList.getColorForState(b(paramTextInputLayout, paramCheckableImageButton), paramColorStateList.getDefaultColor())));
      } else {
        a.o(localDrawable2, paramColorStateList);
      }
      localDrawable1 = localDrawable2;
      if (paramMode != null)
      {
        a.p(localDrawable2, paramMode);
        localDrawable1 = localDrawable2;
      }
    }
    if (paramCheckableImageButton.getDrawable() != localDrawable1) {
      paramCheckableImageButton.setImageDrawable(localDrawable1);
    }
  }
  
  private static int[] b(TextInputLayout paramTextInputLayout, CheckableImageButton paramCheckableImageButton)
  {
    paramTextInputLayout = paramTextInputLayout.getDrawableState();
    paramCheckableImageButton = paramCheckableImageButton.getDrawableState();
    int i = paramTextInputLayout.length;
    paramTextInputLayout = Arrays.copyOf(paramTextInputLayout, paramTextInputLayout.length + paramCheckableImageButton.length);
    System.arraycopy(paramCheckableImageButton, 0, paramTextInputLayout, i, paramCheckableImageButton.length);
    return paramTextInputLayout;
  }
  
  static void c(TextInputLayout paramTextInputLayout, CheckableImageButton paramCheckableImageButton, ColorStateList paramColorStateList)
  {
    Drawable localDrawable = paramCheckableImageButton.getDrawable();
    if ((paramCheckableImageButton.getDrawable() != null) && (paramColorStateList != null))
    {
      if (!paramColorStateList.isStateful()) {
        return;
      }
      int i = paramColorStateList.getColorForState(b(paramTextInputLayout, paramCheckableImageButton), paramColorStateList.getDefaultColor());
      paramTextInputLayout = a.r(localDrawable).mutate();
      a.o(paramTextInputLayout, ColorStateList.valueOf(i));
      paramCheckableImageButton.setImageDrawable(paramTextInputLayout);
    }
  }
  
  private static void d(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener)
  {
    boolean bool3 = x.P(paramCheckableImageButton);
    boolean bool2 = false;
    int i = 1;
    boolean bool1;
    if (paramOnLongClickListener != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool3) || (bool1)) {
      bool2 = true;
    }
    paramCheckableImageButton.setFocusable(bool2);
    paramCheckableImageButton.setClickable(bool3);
    paramCheckableImageButton.setPressable(bool3);
    paramCheckableImageButton.setLongClickable(bool1);
    if (!bool2) {
      i = 2;
    }
    x.B0(paramCheckableImageButton, i);
  }
  
  static void e(CheckableImageButton paramCheckableImageButton, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnClickListener(paramOnClickListener);
    d(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  static void f(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnLongClickListener(paramOnLongClickListener);
    d(paramCheckableImageButton, paramOnLongClickListener);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.f
 * JD-Core Version:    0.7.0.1
 */