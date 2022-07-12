package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import h1.a;
import java.io.File;

public class BitmapCropTask
  extends AsyncTask<Void, Void, Throwable>
{
  private static final String TAG = "BitmapCropTask";
  private int cropOffsetX;
  private int cropOffsetY;
  private final Bitmap.CompressFormat mCompressFormat;
  private final int mCompressQuality;
  private final BitmapCropCallback mCropCallback;
  private final RectF mCropRect;
  private int mCroppedImageHeight;
  private int mCroppedImageWidth;
  private float mCurrentAngle;
  private final RectF mCurrentImageRect;
  private float mCurrentScale;
  private final ExifInfo mExifInfo;
  private final String mImageInputPath;
  private final String mImageOutputPath;
  private final int mMaxResultImageSizeX;
  private final int mMaxResultImageSizeY;
  private Bitmap mViewBitmap;
  
  static
  {
    System.loadLibrary("ucrop");
  }
  
  public BitmapCropTask(Bitmap paramBitmap, ImageState paramImageState, CropParameters paramCropParameters, BitmapCropCallback paramBitmapCropCallback)
  {
    this.mViewBitmap = paramBitmap;
    this.mCropRect = paramImageState.getCropRect();
    this.mCurrentImageRect = paramImageState.getCurrentImageRect();
    this.mCurrentScale = paramImageState.getCurrentScale();
    this.mCurrentAngle = paramImageState.getCurrentAngle();
    this.mMaxResultImageSizeX = paramCropParameters.getMaxResultImageSizeX();
    this.mMaxResultImageSizeY = paramCropParameters.getMaxResultImageSizeY();
    this.mCompressFormat = paramCropParameters.getCompressFormat();
    this.mCompressQuality = paramCropParameters.getCompressQuality();
    this.mImageInputPath = paramCropParameters.getImageInputPath();
    this.mImageOutputPath = paramCropParameters.getImageOutputPath();
    this.mExifInfo = paramCropParameters.getExifInfo();
    this.mCropCallback = paramBitmapCropCallback;
  }
  
  private boolean crop(float paramFloat)
  {
    a locala = new a(this.mImageInputPath);
    this.cropOffsetX = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
    this.cropOffsetY = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
    this.mCroppedImageWidth = Math.round(this.mCropRect.width() / this.mCurrentScale);
    int i = Math.round(this.mCropRect.height() / this.mCurrentScale);
    this.mCroppedImageHeight = i;
    boolean bool = shouldCrop(this.mCroppedImageWidth, i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Should crop: ");
    localStringBuilder.append(bool);
    Log.i("BitmapCropTask", localStringBuilder.toString());
    if (bool)
    {
      bool = cropCImg(this.mImageInputPath, this.mImageOutputPath, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mCurrentAngle, paramFloat, this.mCompressFormat.ordinal(), this.mCompressQuality, this.mExifInfo.getExifDegrees(), this.mExifInfo.getExifTranslation());
      if ((bool) && (this.mCompressFormat.equals(Bitmap.CompressFormat.JPEG))) {
        ImageHeaderParser.copyExif(locala, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
      }
      return bool;
    }
    FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
    return false;
  }
  
  public static native boolean cropCImg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  private float resize()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int j = 1;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(this.mImageInputPath, localOptions);
    int i = j;
    if (this.mExifInfo.getExifDegrees() != 90) {
      if (this.mExifInfo.getExifDegrees() == 270) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      j = localOptions.outHeight;
    } else {
      j = localOptions.outWidth;
    }
    float f1 = j / this.mViewBitmap.getWidth();
    if (i != 0) {
      i = localOptions.outWidth;
    } else {
      i = localOptions.outHeight;
    }
    f1 = Math.min(f1, i / this.mViewBitmap.getHeight());
    this.mCurrentScale /= f1;
    float f2 = 1.0F;
    f1 = f2;
    if (this.mMaxResultImageSizeX > 0)
    {
      f1 = f2;
      if (this.mMaxResultImageSizeY > 0)
      {
        float f3 = this.mCropRect.width() / this.mCurrentScale;
        float f4 = this.mCropRect.height() / this.mCurrentScale;
        i = this.mMaxResultImageSizeX;
        if (f3 <= i)
        {
          f1 = f2;
          if (f4 <= this.mMaxResultImageSizeY) {}
        }
        else
        {
          f1 = Math.min(i / f3, this.mMaxResultImageSizeY / f4);
          this.mCurrentScale /= f1;
        }
      }
    }
    return f1;
  }
  
  private boolean shouldCrop(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.round(Math.max(paramInt1, paramInt2) / 1000.0F);
    boolean bool2 = true;
    boolean bool1;
    if (this.mMaxResultImageSizeX > 0)
    {
      bool1 = bool2;
      if (this.mMaxResultImageSizeY > 0) {}
    }
    else
    {
      float f1 = Math.abs(this.mCropRect.left - this.mCurrentImageRect.left);
      float f2 = paramInt1 + 1;
      bool1 = bool2;
      if (f1 <= f2)
      {
        bool1 = bool2;
        if (Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) <= f2)
        {
          bool1 = bool2;
          if (Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) <= f2)
          {
            bool1 = bool2;
            if (Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) <= f2)
            {
              if (this.mCurrentAngle != 0.0F) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected Throwable doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = this.mViewBitmap;
    if (paramVarArgs == null) {
      return new NullPointerException("ViewBitmap is null");
    }
    if (paramVarArgs.isRecycled()) {
      return new NullPointerException("ViewBitmap is recycled");
    }
    if (this.mCurrentImageRect.isEmpty()) {
      return new NullPointerException("CurrentImageRect is empty");
    }
    float f = resize();
    try
    {
      crop(f);
      this.mViewBitmap = null;
      return null;
    }
    finally {}
    return paramVarArgs;
  }
  
  protected void onPostExecute(Throwable paramThrowable)
  {
    BitmapCropCallback localBitmapCropCallback = this.mCropCallback;
    if (localBitmapCropCallback != null)
    {
      if (paramThrowable == null)
      {
        paramThrowable = Uri.fromFile(new File(this.mImageOutputPath));
        this.mCropCallback.onBitmapCropped(paramThrowable, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
        return;
      }
      localBitmapCropCallback.onCropFailure(paramThrowable);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.task.BitmapCropTask
 * JD-Core Version:    0.7.0.1
 */