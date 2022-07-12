package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

public final class c
{
  public static Drawable a(CheckedTextView paramCheckedTextView)
  {
    return a.a(paramCheckedTextView);
  }
  
  public static void b(CheckedTextView paramCheckedTextView, ColorStateList paramColorStateList)
  {
    b.a(paramCheckedTextView, paramColorStateList);
  }
  
  public static void c(CheckedTextView paramCheckedTextView, PorterDuff.Mode paramMode)
  {
    b.b(paramCheckedTextView, paramMode);
  }
  
  private static class a
  {
    static Drawable a(CheckedTextView paramCheckedTextView)
    {
      return paramCheckedTextView.getCheckMarkDrawable();
    }
  }
  
  private static class b
  {
    static void a(CheckedTextView paramCheckedTextView, ColorStateList paramColorStateList)
    {
      paramCheckedTextView.setCheckMarkTintList(paramColorStateList);
    }
    
    static void b(CheckedTextView paramCheckedTextView, PorterDuff.Mode paramMode)
    {
      paramCheckedTextView.setCheckMarkTintMode(paramMode);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.c
 * JD-Core Version:    0.7.0.1
 */