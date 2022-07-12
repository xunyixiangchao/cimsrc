package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.ImageView;
import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener;

public class GestureCropImageView
  extends CropImageView
{
  private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
  private int mDoubleTapScaleSteps = 5;
  private GestureDetector mGestureDetector;
  private boolean mIsGestureEnabled = true;
  private boolean mIsRotateEnabled = true;
  private boolean mIsScaleEnabled = true;
  private float mMidPntX;
  private float mMidPntY;
  private RotationGestureDetector mRotateDetector;
  private ScaleGestureDetector mScaleDetector;
  
  public GestureCropImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setupGestureListeners()
  {
    this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(null), null, true);
    this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener(null));
    this.mRotateDetector = new RotationGestureDetector(new RotateListener(null));
  }
  
  public int getDoubleTapScaleSteps()
  {
    return this.mDoubleTapScaleSteps;
  }
  
  protected float getDoubleTapTargetScale()
  {
    return getCurrentScale() * (float)Math.pow(getMaxScale() / getMinScale(), 1.0F / this.mDoubleTapScaleSteps);
  }
  
  protected void init()
  {
    super.init();
    setupGestureListeners();
  }
  
  public boolean isGestureEnabled()
  {
    return this.mIsGestureEnabled;
  }
  
  public boolean isRotateEnabled()
  {
    return this.mIsRotateEnabled;
  }
  
  public boolean isScaleEnabled()
  {
    return this.mIsScaleEnabled;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      cancelAllAnimations();
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.mMidPntX = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      this.mMidPntY = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    if (this.mIsGestureEnabled) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    if (this.mIsScaleEnabled) {
      this.mScaleDetector.onTouchEvent(paramMotionEvent);
    }
    if (this.mIsRotateEnabled) {
      this.mRotateDetector.onTouchEvent(paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1) {
      setImageToWrapCropBounds();
    }
    return true;
  }
  
  public void setDoubleTapScaleSteps(int paramInt)
  {
    this.mDoubleTapScaleSteps = paramInt;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.mIsGestureEnabled = paramBoolean;
  }
  
  public void setRotateEnabled(boolean paramBoolean)
  {
    this.mIsRotateEnabled = paramBoolean;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.mIsScaleEnabled = paramBoolean;
  }
  
  private class GestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private GestureListener() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      GestureCropImageView localGestureCropImageView = GestureCropImageView.this;
      localGestureCropImageView.zoomImageToPosition(localGestureCropImageView.getDoubleTapTargetScale(), paramMotionEvent.getX(), paramMotionEvent.getY(), 200L);
      return super.onDoubleTap(paramMotionEvent);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      GestureCropImageView.this.postTranslate(-paramFloat1, -paramFloat2);
      return true;
    }
  }
  
  private class RotateListener
    extends RotationGestureDetector.SimpleOnRotationGestureListener
  {
    private RotateListener() {}
    
    public boolean onRotation(RotationGestureDetector paramRotationGestureDetector)
    {
      GestureCropImageView.this.postRotate(paramRotationGestureDetector.getAngle(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
      return true;
    }
  }
  
  private class ScaleListener
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private ScaleListener() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      GestureCropImageView.this.postScale(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.GestureCropImageView
 * JD-Core Version:    0.7.0.1
 */