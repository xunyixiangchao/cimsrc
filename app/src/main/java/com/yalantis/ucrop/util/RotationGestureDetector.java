package com.yalantis.ucrop.util;

import android.view.MotionEvent;

public class RotationGestureDetector
{
  private static final int INVALID_POINTER_INDEX = -1;
  private float fX;
  private float fY;
  private float mAngle;
  private boolean mIsFirstTouch;
  private OnRotationGestureListener mListener;
  private int mPointerIndex1;
  private int mPointerIndex2;
  private float sX;
  private float sY;
  
  public RotationGestureDetector(OnRotationGestureListener paramOnRotationGestureListener)
  {
    this.mListener = paramOnRotationGestureListener;
    this.mPointerIndex1 = -1;
    this.mPointerIndex2 = -1;
  }
  
  private float calculateAngleBetweenLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return calculateAngleDelta((float)Math.toDegrees((float)Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3)), (float)Math.toDegrees((float)Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7)));
  }
  
  private float calculateAngleDelta(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2 % 360.0F - paramFloat1 % 360.0F;
    this.mAngle = paramFloat1;
    if (paramFloat1 < -180.0F) {}
    for (paramFloat1 += 360.0F;; paramFloat1 -= 360.0F)
    {
      this.mAngle = paramFloat1;
      break;
      if (paramFloat1 <= 180.0F) {
        break;
      }
    }
    return this.mAngle;
  }
  
  public float getAngle()
  {
    return this.mAngle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5)
          {
            if (i != 6) {
              return true;
            }
            this.mPointerIndex2 = -1;
            return true;
          }
          this.fX = paramMotionEvent.getX();
          this.fY = paramMotionEvent.getY();
          this.mPointerIndex2 = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
        }
        else
        {
          if ((this.mPointerIndex1 == -1) || (this.mPointerIndex2 == -1) || (paramMotionEvent.getPointerCount() <= this.mPointerIndex2)) {
            break label279;
          }
          float f1 = paramMotionEvent.getX(this.mPointerIndex1);
          float f2 = paramMotionEvent.getY(this.mPointerIndex1);
          float f3 = paramMotionEvent.getX(this.mPointerIndex2);
          float f4 = paramMotionEvent.getY(this.mPointerIndex2);
          if (this.mIsFirstTouch)
          {
            this.mAngle = 0.0F;
            this.mIsFirstTouch = false;
          }
          else
          {
            calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, f3, f4, f1, f2);
          }
          paramMotionEvent = this.mListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.onRotation(this);
          }
          this.fX = f3;
          this.fY = f4;
          this.sX = f1;
          this.sY = f2;
          return true;
        }
      }
      else
      {
        this.mPointerIndex1 = -1;
        return true;
      }
    }
    else
    {
      this.sX = paramMotionEvent.getX();
      this.sY = paramMotionEvent.getY();
      this.mPointerIndex1 = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(0));
    }
    this.mAngle = 0.0F;
    this.mIsFirstTouch = true;
    label279:
    return true;
  }
  
  public static abstract interface OnRotationGestureListener
  {
    public abstract boolean onRotation(RotationGestureDetector paramRotationGestureDetector);
  }
  
  public static class SimpleOnRotationGestureListener
    implements RotationGestureDetector.OnRotationGestureListener
  {
    public boolean onRotation(RotationGestureDetector paramRotationGestureDetector)
    {
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.RotationGestureDetector
 * JD-Core Version:    0.7.0.1
 */