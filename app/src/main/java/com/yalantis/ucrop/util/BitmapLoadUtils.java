package com.yalantis.ucrop.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;

public class BitmapLoadUtils
{
  private static final String TAG = "BitmapLoadUtils";
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int j = 1;
    int k = 1;
    int i = k;
    if (m <= paramInt2)
    {
      if (n <= paramInt1) {
        break label58;
      }
      i = k;
    }
    for (;;)
    {
      if (m / i <= paramInt2)
      {
        j = i;
        if (n / i <= paramInt1) {
          label58:
          return j;
        }
      }
      i *= 2;
    }
  }
  
  public static int calculateMaxBitmapSize(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    if (paramContext != null) {
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    int i = localPoint.x;
    int j = localPoint.y;
    j = (int)Math.sqrt(Math.pow(i, 2.0D) + Math.pow(j, 2.0D));
    paramContext = new Canvas();
    int k = Math.min(paramContext.getMaximumBitmapWidth(), paramContext.getMaximumBitmapHeight());
    i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    k = EglUtils.getMaxTextureSize();
    j = i;
    if (k > 0) {
      j = Math.min(i, k);
    }
    paramContext = new StringBuilder();
    paramContext.append("maxBitmapSize: ");
    paramContext.append(j);
    Log.d("BitmapLoadUtils", paramContext.toString());
    return j;
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void decodeBitmapInBackground(Context paramContext, Uri paramUri1, Uri paramUri2, int paramInt1, int paramInt2, BitmapLoadCallback paramBitmapLoadCallback)
  {
    new BitmapLoadTask(paramContext, paramUri1, paramUri2, paramInt1, paramInt2, paramBitmapLoadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public static int exifToDegrees(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
    case 8: 
      return 270;
    case 5: 
    case 6: 
      return 90;
    }
    return 180;
  }
  
  public static int exifToTranslation(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 7) && (paramInt != 4) && (paramInt != 5)) {
      return 1;
    }
    return -1;
  }
  
  public static int getExifOrientation(Context paramContext, Uri paramUri)
  {
    int j = 0;
    int i = j;
    try
    {
      paramContext = paramContext.getContentResolver().openInputStream(paramUri);
      if (paramContext == null) {
        return 0;
      }
      i = j;
      j = new ImageHeaderParser(paramContext).getOrientation();
      i = j;
      close(paramContext);
      return j;
    }
    catch (IOException paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExifOrientation: ");
      localStringBuilder.append(paramUri.toString());
      Log.e("BitmapLoadUtils", localStringBuilder.toString(), paramContext);
    }
    return i;
  }
  
  public static Bitmap transformBitmap(Bitmap paramBitmap, Matrix paramMatrix)
  {
    try
    {
      paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
      boolean bool = paramBitmap.sameAs(paramMatrix);
      if (!bool) {
        return paramMatrix;
      }
    }
    catch (OutOfMemoryError paramMatrix)
    {
      Log.e("BitmapLoadUtils", "transformBitmap: ", paramMatrix);
    }
    return paramBitmap;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.BitmapLoadUtils
 * JD-Core Version:    0.7.0.1
 */