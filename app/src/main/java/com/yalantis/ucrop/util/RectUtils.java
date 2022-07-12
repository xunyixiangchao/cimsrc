package com.yalantis.ucrop.util;

import android.graphics.RectF;

public class RectUtils
{
  public static float[] getCenterFromRect(RectF paramRectF)
  {
    return new float[] { paramRectF.centerX(), paramRectF.centerY() };
  }
  
  public static float[] getCornersFromRect(RectF paramRectF)
  {
    float f1 = paramRectF.left;
    float f2 = paramRectF.top;
    float f3 = paramRectF.right;
    float f4 = paramRectF.bottom;
    return new float[] { f1, f2, f3, f2, f3, f4, f1, f4 };
  }
  
  public static float[] getRectSidesFromCorners(float[] paramArrayOfFloat)
  {
    return new float[] { (float)Math.sqrt(Math.pow(paramArrayOfFloat[0] - paramArrayOfFloat[2], 2.0D) + Math.pow(paramArrayOfFloat[1] - paramArrayOfFloat[3], 2.0D)), (float)Math.sqrt(Math.pow(paramArrayOfFloat[2] - paramArrayOfFloat[4], 2.0D) + Math.pow(paramArrayOfFloat[3] - paramArrayOfFloat[5], 2.0D)) };
  }
  
  public static RectF trapToRect(float[] paramArrayOfFloat)
  {
    RectF localRectF = new RectF((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      float f2 = Math.round(paramArrayOfFloat[(i - 1)] * 10.0F) / 10.0F;
      float f1 = Math.round(paramArrayOfFloat[i] * 10.0F) / 10.0F;
      float f4 = localRectF.left;
      float f3 = f4;
      if (f2 < f4) {
        f3 = f2;
      }
      localRectF.left = f3;
      f4 = localRectF.top;
      f3 = f4;
      if (f1 < f4) {
        f3 = f1;
      }
      localRectF.top = f3;
      f3 = localRectF.right;
      if (f2 <= f3) {
        f2 = f3;
      }
      localRectF.right = f2;
      f2 = localRectF.bottom;
      if (f1 <= f2) {
        f1 = f2;
      }
      localRectF.bottom = f1;
      i += 2;
    }
    localRectF.sort();
    return localRectF;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.RectUtils
 * JD-Core Version:    0.7.0.1
 */