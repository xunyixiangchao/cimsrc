package com.yalantis.ucrop.model;

import android.graphics.RectF;

public class ImageState
{
  private RectF mCropRect;
  private float mCurrentAngle;
  private RectF mCurrentImageRect;
  private float mCurrentScale;
  
  public ImageState(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.mCropRect = paramRectF1;
    this.mCurrentImageRect = paramRectF2;
    this.mCurrentScale = paramFloat1;
    this.mCurrentAngle = paramFloat2;
  }
  
  public RectF getCropRect()
  {
    return this.mCropRect;
  }
  
  public float getCurrentAngle()
  {
    return this.mCurrentAngle;
  }
  
  public RectF getCurrentImageRect()
  {
    return this.mCurrentImageRect;
  }
  
  public float getCurrentScale()
  {
    return this.mCurrentScale;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */