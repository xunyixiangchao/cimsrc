package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public final class d
{
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    return paramCompoundButton.getButtonDrawable();
  }
  
  public static ColorStateList b(CompoundButton paramCompoundButton)
  {
    return paramCompoundButton.getButtonTintList();
  }
  
  public static void c(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    paramCompoundButton.setButtonTintList(paramColorStateList);
  }
  
  public static void d(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    paramCompoundButton.setButtonTintMode(paramMode);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.d
 * JD-Core Version:    0.7.0.1
 */