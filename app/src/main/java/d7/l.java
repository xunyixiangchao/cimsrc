package d7;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class l
{
  static void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat2 < paramFloat3) {
        return;
      }
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
    throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
  }
  
  static int b(int paramInt)
  {
    return (paramInt & 0xFF00) >> 8;
  }
  
  static boolean c(ImageView paramImageView)
  {
    return paramImageView.getDrawable() != null;
  }
  
  static boolean d(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    if (a.a[paramScaleType.ordinal()] != 1) {
      return true;
    }
    throw new IllegalStateException("Matrix scale type is not supported");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d7.l
 * JD-Core Version:    0.7.0.1
 */