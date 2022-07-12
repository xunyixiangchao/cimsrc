package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;

public class TransformImageView
  extends AppCompatImageView
{
  private static final int MATRIX_VALUES_COUNT = 9;
  private static final int RECT_CENTER_POINT_COORDS = 2;
  private static final int RECT_CORNER_POINTS_COORDS = 8;
  private static final String TAG = "TransformImageView";
  protected boolean mBitmapDecoded = false;
  protected boolean mBitmapLaidOut = false;
  protected final float[] mCurrentImageCenter = new float[2];
  protected final float[] mCurrentImageCorners = new float[8];
  protected Matrix mCurrentImageMatrix = new Matrix();
  private ExifInfo mExifInfo;
  private String mImageInputPath;
  private String mImageOutputPath;
  private float[] mInitialImageCenter;
  private float[] mInitialImageCorners;
  private final float[] mMatrixValues = new float[9];
  private int mMaxBitmapSize = 0;
  protected int mThisHeight;
  protected int mThisWidth;
  protected TransformImageListener mTransformImageListener;
  
  public TransformImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void updateCurrentImagePoints()
  {
    this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
    this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
  }
  
  public float getCurrentAngle()
  {
    return getMatrixAngle(this.mCurrentImageMatrix);
  }
  
  public float getCurrentScale()
  {
    return getMatrixScale(this.mCurrentImageMatrix);
  }
  
  public ExifInfo getExifInfo()
  {
    return this.mExifInfo;
  }
  
  public String getImageInputPath()
  {
    return this.mImageInputPath;
  }
  
  public String getImageOutputPath()
  {
    return this.mImageOutputPath;
  }
  
  public float getMatrixAngle(Matrix paramMatrix)
  {
    return (float)-(Math.atan2(getMatrixValue(paramMatrix, 1), getMatrixValue(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public float getMatrixScale(Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(getMatrixValue(paramMatrix, 0), 2.0D) + Math.pow(getMatrixValue(paramMatrix, 3), 2.0D));
  }
  
  protected float getMatrixValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  public int getMaxBitmapSize()
  {
    if (this.mMaxBitmapSize <= 0) {
      this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize(getContext());
    }
    return this.mMaxBitmapSize;
  }
  
  public Bitmap getViewBitmap()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof FastBitmapDrawable))) {
      return ((FastBitmapDrawable)getDrawable()).getBitmap();
    }
    return null;
  }
  
  protected void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  protected void onImageLaidOut()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    float f1 = ((Drawable)localObject).getIntrinsicWidth();
    float f2 = ((Drawable)localObject).getIntrinsicHeight();
    Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[] { Integer.valueOf((int)f1), Integer.valueOf((int)f2) }));
    localObject = new RectF(0.0F, 0.0F, f1, f2);
    this.mInitialImageCorners = RectUtils.getCornersFromRect((RectF)localObject);
    this.mInitialImageCenter = RectUtils.getCenterFromRect((RectF)localObject);
    this.mBitmapLaidOut = true;
    localObject = this.mTransformImageListener;
    if (localObject != null) {
      ((TransformImageListener)localObject).onLoadComplete();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || ((this.mBitmapDecoded) && (!this.mBitmapLaidOut)))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.mThisWidth = (paramInt3 - paramInt4 - paramInt1);
      this.mThisHeight = (i - j - paramInt2);
      onImageLaidOut();
    }
  }
  
  public void postRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.mCurrentImageMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.mCurrentImageMatrix);
      TransformImageListener localTransformImageListener = this.mTransformImageListener;
      if (localTransformImageListener != null) {
        localTransformImageListener.onRotate(getMatrixAngle(this.mCurrentImageMatrix));
      }
    }
  }
  
  public void postScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.mCurrentImageMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.mCurrentImageMatrix);
      TransformImageListener localTransformImageListener = this.mTransformImageListener;
      if (localTransformImageListener != null) {
        localTransformImageListener.onScale(getMatrixScale(this.mCurrentImageMatrix));
      }
    }
  }
  
  public void postTranslate(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.mCurrentImageMatrix.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(this.mCurrentImageMatrix);
    }
  }
  
  protected void printMatrix(String paramString, Matrix paramMatrix)
  {
    float f1 = getMatrixValue(paramMatrix, 2);
    float f2 = getMatrixValue(paramMatrix, 5);
    float f3 = getMatrixScale(paramMatrix);
    float f4 = getMatrixAngle(paramMatrix);
    paramMatrix = new StringBuilder();
    paramMatrix.append(paramString);
    paramMatrix.append(": matrix: { x: ");
    paramMatrix.append(f1);
    paramMatrix.append(", y: ");
    paramMatrix.append(f2);
    paramMatrix.append(", scale: ");
    paramMatrix.append(f3);
    paramMatrix.append(", angle: ");
    paramMatrix.append(f4);
    paramMatrix.append(" }");
    Log.d("TransformImageView", paramMatrix.toString());
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new FastBitmapDrawable(paramBitmap));
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    this.mCurrentImageMatrix.set(paramMatrix);
    updateCurrentImagePoints();
  }
  
  public void setImageUri(Uri paramUri1, Uri paramUri2)
  {
    int i = getMaxBitmapSize();
    BitmapLoadUtils.decodeBitmapInBackground(getContext(), paramUri1, paramUri2, i, i, new BitmapLoadCallback()
    {
      public void onBitmapLoaded(Bitmap paramAnonymousBitmap, ExifInfo paramAnonymousExifInfo, String paramAnonymousString1, String paramAnonymousString2)
      {
        TransformImageView.access$002(TransformImageView.this, paramAnonymousString1);
        TransformImageView.access$102(TransformImageView.this, paramAnonymousString2);
        TransformImageView.access$202(TransformImageView.this, paramAnonymousExifInfo);
        paramAnonymousExifInfo = TransformImageView.this;
        paramAnonymousExifInfo.mBitmapDecoded = true;
        paramAnonymousExifInfo.setImageBitmap(paramAnonymousBitmap);
      }
      
      public void onFailure(Exception paramAnonymousException)
      {
        Log.e("TransformImageView", "onFailure: setImageUri", paramAnonymousException);
        TransformImageView.TransformImageListener localTransformImageListener = TransformImageView.this.mTransformImageListener;
        if (localTransformImageListener != null) {
          localTransformImageListener.onLoadFailure(paramAnonymousException);
        }
      }
    });
  }
  
  public void setMaxBitmapSize(int paramInt)
  {
    this.mMaxBitmapSize = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
  
  public void setTransformImageListener(TransformImageListener paramTransformImageListener)
  {
    this.mTransformImageListener = paramTransformImageListener;
  }
  
  public static abstract interface TransformImageListener
  {
    public abstract void onLoadComplete();
    
    public abstract void onLoadFailure(Exception paramException);
    
    public abstract void onRotate(float paramFloat);
    
    public abstract void onScale(float paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.TransformImageView
 * JD-Core Version:    0.7.0.1
 */