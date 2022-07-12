package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.yalantis.ucrop.R.styleable;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView
  extends TransformImageView
{
  public static final float DEFAULT_ASPECT_RATIO = 0.0F;
  public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
  public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
  public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0F;
  public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0F;
  private CropBoundsChangeListener mCropBoundsChangeListener;
  private final RectF mCropRect = new RectF();
  private long mImageToWrapCropBoundsAnimDuration = 500L;
  private int mMaxResultImageSizeX = 0;
  private int mMaxResultImageSizeY = 0;
  private float mMaxScale;
  private float mMaxScaleMultiplier = 10.0F;
  private float mMinScale;
  private float mTargetAspectRatio;
  private final Matrix mTempMatrix = new Matrix();
  private Runnable mWrapCropBoundsRunnable;
  private Runnable mZoomImageToPositionRunnable = null;
  
  public CropImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float[] calculateImageIndents()
  {
    this.mTempMatrix.reset();
    this.mTempMatrix.setRotate(-getCurrentAngle());
    Object localObject1 = this.mCurrentImageCorners;
    Object localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
    localObject1 = RectUtils.getCornersFromRect(this.mCropRect);
    this.mTempMatrix.mapPoints((float[])localObject2);
    this.mTempMatrix.mapPoints((float[])localObject1);
    localObject2 = RectUtils.trapToRect((float[])localObject2);
    localObject1 = RectUtils.trapToRect((float[])localObject1);
    float f1 = ((RectF)localObject2).left - ((RectF)localObject1).left;
    float f4 = ((RectF)localObject2).top - ((RectF)localObject1).top;
    float f3 = ((RectF)localObject2).right - ((RectF)localObject1).right;
    float f2 = ((RectF)localObject2).bottom - ((RectF)localObject1).bottom;
    localObject1 = new float[4];
    if (f1 <= 0.0F) {
      f1 = 0.0F;
    }
    localObject1[0] = f1;
    if (f4 > 0.0F) {
      f1 = f4;
    } else {
      f1 = 0.0F;
    }
    localObject1[1] = f1;
    if (f3 < 0.0F) {
      f1 = f3;
    } else {
      f1 = 0.0F;
    }
    localObject1[2] = f1;
    if (f2 < 0.0F) {
      f1 = f2;
    } else {
      f1 = 0.0F;
    }
    localObject1[3] = f1;
    this.mTempMatrix.reset();
    this.mTempMatrix.setRotate(getCurrentAngle());
    this.mTempMatrix.mapPoints((float[])localObject1);
    return localObject1;
  }
  
  private void calculateImageScaleBounds()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    calculateImageScaleBounds(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
  }
  
  private void calculateImageScaleBounds(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.min(Math.min(this.mCropRect.width() / paramFloat1, this.mCropRect.width() / paramFloat2), Math.min(this.mCropRect.height() / paramFloat2, this.mCropRect.height() / paramFloat1));
    this.mMinScale = paramFloat1;
    this.mMaxScale = (paramFloat1 * this.mMaxScaleMultiplier);
  }
  
  private void setupInitialImagePosition(float paramFloat1, float paramFloat2)
  {
    float f3 = this.mCropRect.width();
    float f2 = this.mCropRect.height();
    float f1 = Math.max(this.mCropRect.width() / paramFloat1, this.mCropRect.height() / paramFloat2);
    paramFloat1 = (f3 - paramFloat1 * f1) / 2.0F;
    RectF localRectF = this.mCropRect;
    f3 = localRectF.left;
    paramFloat2 = (f2 - paramFloat2 * f1) / 2.0F;
    f2 = localRectF.top;
    this.mCurrentImageMatrix.reset();
    this.mCurrentImageMatrix.postScale(f1, f1);
    this.mCurrentImageMatrix.postTranslate(paramFloat1 + f3, paramFloat2 + f2);
    setImageMatrix(this.mCurrentImageMatrix);
  }
  
  public void cancelAllAnimations()
  {
    removeCallbacks(this.mWrapCropBoundsRunnable);
    removeCallbacks(this.mZoomImageToPositionRunnable);
  }
  
  public void cropAndSaveImage(Bitmap.CompressFormat paramCompressFormat, int paramInt, BitmapCropCallback paramBitmapCropCallback)
  {
    cancelAllAnimations();
    setImageToWrapCropBounds(false);
    ImageState localImageState = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle());
    paramCompressFormat = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, paramCompressFormat, paramInt, getImageInputPath(), getImageOutputPath(), getExifInfo());
    new BitmapCropTask(getViewBitmap(), localImageState, paramCompressFormat, paramBitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public CropBoundsChangeListener getCropBoundsChangeListener()
  {
    return this.mCropBoundsChangeListener;
  }
  
  public float getMaxScale()
  {
    return this.mMaxScale;
  }
  
  public float getMinScale()
  {
    return this.mMinScale;
  }
  
  public float getTargetAspectRatio()
  {
    return this.mTargetAspectRatio;
  }
  
  protected boolean isImageWrapCropBounds()
  {
    return isImageWrapCropBounds(this.mCurrentImageCorners);
  }
  
  protected boolean isImageWrapCropBounds(float[] paramArrayOfFloat)
  {
    this.mTempMatrix.reset();
    this.mTempMatrix.setRotate(-getCurrentAngle());
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    this.mTempMatrix.mapPoints(paramArrayOfFloat);
    float[] arrayOfFloat = RectUtils.getCornersFromRect(this.mCropRect);
    this.mTempMatrix.mapPoints(arrayOfFloat);
    return RectUtils.trapToRect(paramArrayOfFloat).contains(RectUtils.trapToRect(arrayOfFloat));
  }
  
  protected void onImageLaidOut()
  {
    super.onImageLaidOut();
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    float f1 = ((Drawable)localObject).getIntrinsicWidth();
    float f2 = ((Drawable)localObject).getIntrinsicHeight();
    if (this.mTargetAspectRatio == 0.0F) {
      this.mTargetAspectRatio = (f1 / f2);
    }
    int i = this.mThisWidth;
    float f3 = i;
    float f4 = this.mTargetAspectRatio;
    int k = (int)(f3 / f4);
    int j = this.mThisHeight;
    if (k > j)
    {
      k = (int)(j * f4);
      i = (i - k) / 2;
      this.mCropRect.set(i, 0.0F, k + i, j);
    }
    else
    {
      j = (j - k) / 2;
      this.mCropRect.set(0.0F, j, i, k + j);
    }
    calculateImageScaleBounds(f1, f2);
    setupInitialImagePosition(f1, f2);
    localObject = this.mCropBoundsChangeListener;
    if (localObject != null) {
      ((CropBoundsChangeListener)localObject).onCropAspectRatioChanged(this.mTargetAspectRatio);
    }
    localObject = this.mTransformImageListener;
    if (localObject != null)
    {
      ((TransformImageView.TransformImageListener)localObject).onScale(getCurrentScale());
      this.mTransformImageListener.onRotate(getCurrentAngle());
    }
  }
  
  public void postRotate(float paramFloat)
  {
    postRotate(paramFloat, this.mCropRect.centerX(), this.mCropRect.centerY());
  }
  
  public void postScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 > 1.0F) && (getCurrentScale() * paramFloat1 <= getMaxScale())) {}
    while ((paramFloat1 < 1.0F) && (getCurrentScale() * paramFloat1 >= getMinScale()))
    {
      super.postScale(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
  }
  
  protected void processStyledAttributes(TypedArray paramTypedArray)
  {
    float f1 = Math.abs(paramTypedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0F));
    float f2 = Math.abs(paramTypedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0F));
    if ((f1 != 0.0F) && (f2 != 0.0F))
    {
      this.mTargetAspectRatio = (f1 / f2);
      return;
    }
    this.mTargetAspectRatio = 0.0F;
  }
  
  public void setCropBoundsChangeListener(CropBoundsChangeListener paramCropBoundsChangeListener)
  {
    this.mCropBoundsChangeListener = paramCropBoundsChangeListener;
  }
  
  public void setCropRect(RectF paramRectF)
  {
    this.mTargetAspectRatio = (paramRectF.width() / paramRectF.height());
    this.mCropRect.set(paramRectF.left - getPaddingLeft(), paramRectF.top - getPaddingTop(), paramRectF.right - getPaddingRight(), paramRectF.bottom - getPaddingBottom());
    calculateImageScaleBounds();
    setImageToWrapCropBounds();
  }
  
  public void setImageToWrapCropBounds()
  {
    setImageToWrapCropBounds(true);
  }
  
  public void setImageToWrapCropBounds(boolean paramBoolean)
  {
    if ((this.mBitmapLaidOut) && (!isImageWrapCropBounds()))
    {
      Object localObject = this.mCurrentImageCenter;
      float f4 = localObject[0];
      float f5 = localObject[1];
      float f6 = getCurrentScale();
      float f1 = this.mCropRect.centerX() - f4;
      float f2 = this.mCropRect.centerY() - f5;
      this.mTempMatrix.reset();
      this.mTempMatrix.setTranslate(f1, f2);
      localObject = this.mCurrentImageCorners;
      localObject = Arrays.copyOf((float[])localObject, localObject.length);
      this.mTempMatrix.mapPoints((float[])localObject);
      boolean bool = isImageWrapCropBounds((float[])localObject);
      float f3;
      if (bool)
      {
        localObject = calculateImageIndents();
        f1 = -(localObject[0] + localObject[2]);
        f2 = -(localObject[1] + localObject[3]);
        f3 = 0.0F;
      }
      else
      {
        localObject = new RectF(this.mCropRect);
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapRect((RectF)localObject);
        float[] arrayOfFloat = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
        f3 = Math.max(((RectF)localObject).width() / arrayOfFloat[0], ((RectF)localObject).height() / arrayOfFloat[1]);
        f3 = f3 * f6 - f6;
      }
      if (paramBoolean)
      {
        localObject = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f4, f5, f1, f2, f6, f3, bool);
        this.mWrapCropBoundsRunnable = ((Runnable)localObject);
        post((Runnable)localObject);
        return;
      }
      postTranslate(f1, f2);
      if (!bool) {
        zoomInImage(f6 + f3, this.mCropRect.centerX(), this.mCropRect.centerY());
      }
    }
  }
  
  public void setImageToWrapCropBoundsAnimDuration(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.mImageToWrapCropBoundsAnimDuration = paramLong;
      return;
    }
    throw new IllegalArgumentException("Animation duration cannot be negative value.");
  }
  
  public void setMaxResultImageSizeX(int paramInt)
  {
    this.mMaxResultImageSizeX = paramInt;
  }
  
  public void setMaxResultImageSizeY(int paramInt)
  {
    this.mMaxResultImageSizeY = paramInt;
  }
  
  public void setMaxScaleMultiplier(float paramFloat)
  {
    this.mMaxScaleMultiplier = paramFloat;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    Object localObject = getDrawable();
    if (localObject == null)
    {
      this.mTargetAspectRatio = paramFloat;
      return;
    }
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = ((Drawable)localObject).getIntrinsicWidth() / ((Drawable)localObject).getIntrinsicHeight();
    }
    this.mTargetAspectRatio = f;
    localObject = this.mCropBoundsChangeListener;
    if (localObject != null) {
      ((CropBoundsChangeListener)localObject).onCropAspectRatioChanged(this.mTargetAspectRatio);
    }
  }
  
  protected void zoomImageToPosition(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float f = paramFloat1;
    if (paramFloat1 > getMaxScale()) {
      f = getMaxScale();
    }
    paramFloat1 = getCurrentScale();
    ZoomImageToPosition localZoomImageToPosition = new ZoomImageToPosition(this, paramLong, paramFloat1, f - paramFloat1, paramFloat2, paramFloat3);
    this.mZoomImageToPositionRunnable = localZoomImageToPosition;
    post(localZoomImageToPosition);
  }
  
  public void zoomInImage(float paramFloat)
  {
    zoomInImage(paramFloat, this.mCropRect.centerX(), this.mCropRect.centerY());
  }
  
  public void zoomInImage(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= getMaxScale()) {
      postScale(paramFloat1 / getCurrentScale(), paramFloat2, paramFloat3);
    }
  }
  
  public void zoomOutImage(float paramFloat)
  {
    zoomOutImage(paramFloat, this.mCropRect.centerX(), this.mCropRect.centerY());
  }
  
  public void zoomOutImage(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= getMinScale()) {
      postScale(paramFloat1 / getCurrentScale(), paramFloat2, paramFloat3);
    }
  }
  
  private static class WrapCropBoundsRunnable
    implements Runnable
  {
    private final float mCenterDiffX;
    private final float mCenterDiffY;
    private final WeakReference<CropImageView> mCropImageView;
    private final float mDeltaScale;
    private final long mDurationMs;
    private final float mOldScale;
    private final float mOldX;
    private final float mOldY;
    private final long mStartTime;
    private final boolean mWillBeImageInBoundsAfterTranslate;
    
    public WrapCropBoundsRunnable(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.mCropImageView = new WeakReference(paramCropImageView);
      this.mDurationMs = paramLong;
      this.mStartTime = System.currentTimeMillis();
      this.mOldX = paramFloat1;
      this.mOldY = paramFloat2;
      this.mCenterDiffX = paramFloat3;
      this.mCenterDiffY = paramFloat4;
      this.mOldScale = paramFloat5;
      this.mDeltaScale = paramFloat6;
      this.mWillBeImageInBoundsAfterTranslate = paramBoolean;
    }
    
    public void run()
    {
      CropImageView localCropImageView = (CropImageView)this.mCropImageView.get();
      if (localCropImageView == null) {
        return;
      }
      long l = System.currentTimeMillis();
      float f1 = (float)Math.min(this.mDurationMs, l - this.mStartTime);
      float f2 = CubicEasing.easeOut(f1, 0.0F, this.mCenterDiffX, (float)this.mDurationMs);
      float f3 = CubicEasing.easeOut(f1, 0.0F, this.mCenterDiffY, (float)this.mDurationMs);
      float f4 = CubicEasing.easeInOut(f1, 0.0F, this.mDeltaScale, (float)this.mDurationMs);
      if (f1 < (float)this.mDurationMs)
      {
        float[] arrayOfFloat = localCropImageView.mCurrentImageCenter;
        localCropImageView.postTranslate(f2 - (arrayOfFloat[0] - this.mOldX), f3 - (arrayOfFloat[1] - this.mOldY));
        if (!this.mWillBeImageInBoundsAfterTranslate) {
          localCropImageView.zoomInImage(this.mOldScale + f4, localCropImageView.mCropRect.centerX(), localCropImageView.mCropRect.centerY());
        }
        if (!localCropImageView.isImageWrapCropBounds()) {
          localCropImageView.post(this);
        }
      }
    }
  }
  
  private static class ZoomImageToPosition
    implements Runnable
  {
    private final WeakReference<CropImageView> mCropImageView;
    private final float mDeltaScale;
    private final float mDestX;
    private final float mDestY;
    private final long mDurationMs;
    private final float mOldScale;
    private final long mStartTime;
    
    public ZoomImageToPosition(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mCropImageView = new WeakReference(paramCropImageView);
      this.mStartTime = System.currentTimeMillis();
      this.mDurationMs = paramLong;
      this.mOldScale = paramFloat1;
      this.mDeltaScale = paramFloat2;
      this.mDestX = paramFloat3;
      this.mDestY = paramFloat4;
    }
    
    public void run()
    {
      CropImageView localCropImageView = (CropImageView)this.mCropImageView.get();
      if (localCropImageView == null) {
        return;
      }
      long l = System.currentTimeMillis();
      float f1 = (float)Math.min(this.mDurationMs, l - this.mStartTime);
      float f2 = CubicEasing.easeInOut(f1, 0.0F, this.mDeltaScale, (float)this.mDurationMs);
      if (f1 < (float)this.mDurationMs)
      {
        localCropImageView.zoomInImage(this.mOldScale + f2, this.mDestX, this.mDestY);
        localCropImageView.post(this);
        return;
      }
      localCropImageView.setImageToWrapCropBounds();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.CropImageView
 * JD-Core Version:    0.7.0.1
 */