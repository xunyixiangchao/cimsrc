package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

public class h
{
  public static ColorStateList a(ImageView paramImageView)
  {
    return paramImageView.getImageTintList();
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView)
  {
    return paramImageView.getImageTintMode();
  }
  
  public static void c(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    paramImageView.setImageTintList(paramColorStateList);
  }
  
  public static void d(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    paramImageView.setImageTintMode(paramMode);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.h
 * JD-Core Version:    0.7.0.1
 */