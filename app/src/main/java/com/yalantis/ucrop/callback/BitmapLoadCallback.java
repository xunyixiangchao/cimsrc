package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public abstract interface BitmapLoadCallback
{
  public abstract void onBitmapLoaded(Bitmap paramBitmap, ExifInfo paramExifInfo, String paramString1, String paramString2);
  
  public abstract void onFailure(Exception paramException);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.callback.BitmapLoadCallback
 * JD-Core Version:    0.7.0.1
 */