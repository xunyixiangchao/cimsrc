package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

class j
{
  private static boolean a = true;
  
  static void a(ImageView paramImageView, Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramImageView.animateTransform(paramMatrix);
      return;
    }
    if (paramMatrix == null)
    {
      paramMatrix = paramImageView.getDrawable();
      if (paramMatrix != null)
      {
        paramMatrix.setBounds(0, 0, paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight(), paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom());
        paramImageView.invalidate();
      }
    }
    else
    {
      b(paramImageView, paramMatrix);
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void b(ImageView paramImageView, Matrix paramMatrix)
  {
    if (a) {}
    try
    {
      paramImageView.animateTransform(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramImageView)
    {
      label12:
      break label12;
    }
    a = false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.j
 * JD-Core Version:    0.7.0.1
 */