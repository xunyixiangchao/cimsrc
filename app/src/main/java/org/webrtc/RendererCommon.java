package org.webrtc;

import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;

public class RendererCommon
{
  private static float BALANCED_VISIBLE_FRACTION = 0.5625F;
  
  private static void adjustOrigin(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[12] -= (paramArrayOfFloat[0] + paramArrayOfFloat[4]) * 0.5F;
    paramArrayOfFloat[13] -= (paramArrayOfFloat[1] + paramArrayOfFloat[5]) * 0.5F;
    paramArrayOfFloat[12] += 0.5F;
    paramArrayOfFloat[13] += 0.5F;
  }
  
  public static float[] convertMatrixFromAndroidGraphicsMatrix(android.graphics.Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    return new float[] { arrayOfFloat[0], arrayOfFloat[3], 0.0F, arrayOfFloat[6], arrayOfFloat[1], arrayOfFloat[4], 0.0F, arrayOfFloat[7], 0.0F, 0.0F, 1.0F, 0.0F, arrayOfFloat[2], arrayOfFloat[5], 0.0F, arrayOfFloat[8] };
  }
  
  public static android.graphics.Matrix convertMatrixToAndroidGraphicsMatrix(float[] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[4];
    float f3 = paramArrayOfFloat[12];
    float f4 = paramArrayOfFloat[1];
    float f5 = paramArrayOfFloat[5];
    float f6 = paramArrayOfFloat[13];
    float f7 = paramArrayOfFloat[3];
    float f8 = paramArrayOfFloat[7];
    float f9 = paramArrayOfFloat[15];
    paramArrayOfFloat = new android.graphics.Matrix();
    paramArrayOfFloat.setValues(new float[] { f1, f2, f3, f4, f5, f6, f7, f8, f9 });
    return paramArrayOfFloat;
  }
  
  private static float convertScalingTypeToVisibleFraction(ScalingType paramScalingType)
  {
    int i = 1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[paramScalingType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return BALANCED_VISIBLE_FRACTION;
        }
        throw new IllegalArgumentException();
      }
      return 0.0F;
    }
    return 1.0F;
  }
  
  public static Point getDisplaySize(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      return new Point(Math.min(paramInt1, Math.round(paramInt2 / paramFloat1 * paramFloat2)), Math.min(paramInt2, Math.round(paramInt1 / paramFloat1 / paramFloat2)));
    }
    return new Point(paramInt1, paramInt2);
  }
  
  public static Point getDisplaySize(ScalingType paramScalingType, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDisplaySize(convertScalingTypeToVisibleFraction(paramScalingType), paramFloat, paramInt1, paramInt2);
  }
  
  public static float[] getLayoutMatrix(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > paramFloat1)
    {
      paramFloat2 = paramFloat1 / paramFloat2;
      paramFloat1 = 1.0F;
    }
    else
    {
      paramFloat1 = paramFloat2 / paramFloat1;
      paramFloat2 = 1.0F;
    }
    float f = paramFloat1;
    if (paramBoolean) {
      f = paramFloat1 * -1.0F;
    }
    float[] arrayOfFloat = new float[16];
    android.opengl.Matrix.setIdentityM(arrayOfFloat, 0);
    android.opengl.Matrix.scaleM(arrayOfFloat, 0, f, paramFloat2, 1.0F);
    adjustOrigin(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface GlDrawer
  {
    public abstract void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
    
    public abstract void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
    
    public abstract void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
    
    public abstract void release();
  }
  
  public static abstract interface RendererEvents
  {
    public abstract void onFirstFrameRendered();
    
    public abstract void onFrameResolutionChanged(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static enum ScalingType
  {
    static
    {
      ScalingType localScalingType1 = new ScalingType("SCALE_ASPECT_FIT", 0);
      SCALE_ASPECT_FIT = localScalingType1;
      ScalingType localScalingType2 = new ScalingType("SCALE_ASPECT_FILL", 1);
      SCALE_ASPECT_FILL = localScalingType2;
      ScalingType localScalingType3 = new ScalingType("SCALE_ASPECT_BALANCED", 2);
      SCALE_ASPECT_BALANCED = localScalingType3;
      $VALUES = new ScalingType[] { localScalingType1, localScalingType2, localScalingType3 };
    }
    
    private ScalingType() {}
  }
  
  public static class VideoLayoutMeasure
  {
    private float visibleFractionMatchOrientation;
    private float visibleFractionMismatchOrientation;
    
    public VideoLayoutMeasure()
    {
      RendererCommon.ScalingType localScalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
      this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(localScalingType);
      this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(localScalingType);
    }
    
    public Point measure(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = View.getDefaultSize(2147483647, paramInt1);
      int j = View.getDefaultSize(2147483647, paramInt2);
      if ((paramInt3 != 0) && (paramInt4 != 0) && (i != 0) && (j != 0))
      {
        float f2 = paramInt3 / paramInt4;
        float f1 = i / j;
        paramInt4 = 1;
        if (f2 > 1.0F) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        }
        if (f1 <= 1.0F) {
          paramInt4 = 0;
        }
        if (paramInt3 == paramInt4) {
          f1 = this.visibleFractionMatchOrientation;
        } else {
          f1 = this.visibleFractionMismatchOrientation;
        }
        Point localPoint = RendererCommon.getDisplaySize(f1, f2, i, j);
        if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
          localPoint.x = i;
        }
        if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
          localPoint.y = j;
        }
        return localPoint;
      }
      return new Point(i, j);
    }
    
    public void setScalingType(RendererCommon.ScalingType paramScalingType)
    {
      setScalingType(paramScalingType, paramScalingType);
    }
    
    public void setScalingType(RendererCommon.ScalingType paramScalingType1, RendererCommon.ScalingType paramScalingType2)
    {
      this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(paramScalingType1);
      this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(paramScalingType2);
    }
    
    public void setVisibleFraction(float paramFloat1, float paramFloat2)
    {
      this.visibleFractionMatchOrientation = paramFloat1;
      this.visibleFractionMismatchOrientation = paramFloat2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RendererCommon
 * JD-Core Version:    0.7.0.1
 */