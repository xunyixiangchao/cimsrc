package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

class e
  extends Drawable
{
  private static final double a = Math.cos(Math.toRadians(45.0D));
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - a) * paramFloat2);
    }
    return f;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1 * 1.5F;
    paramFloat1 = f;
    if (paramBoolean) {
      paramFloat1 = (float)(f + (1.0D - a) * paramFloat2);
    }
    return paramFloat1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.cardview.widget.e
 * JD-Core Version:    0.7.0.1
 */