package com.yalantis.ucrop.util;

public final class CubicEasing
{
  public static float easeIn(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 /= paramFloat4;
    return paramFloat3 * paramFloat1 * paramFloat1 * paramFloat1 + paramFloat2;
  }
  
  public static float easeInOut(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 /= paramFloat4 / 2.0F;
    paramFloat3 /= 2.0F;
    if (paramFloat1 < 1.0F)
    {
      paramFloat1 = paramFloat3 * paramFloat1 * paramFloat1 * paramFloat1;
    }
    else
    {
      paramFloat1 -= 2.0F;
      paramFloat1 = paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 2.0F);
    }
    return paramFloat1 + paramFloat2;
  }
  
  public static float easeOut(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 1.0F) + paramFloat2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.CubicEasing
 * JD-Core Version:    0.7.0.1
 */