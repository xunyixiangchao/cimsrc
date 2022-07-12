package com.yalantis.ucrop.callback;

import android.net.Uri;

public abstract interface BitmapCropCallback
{
  public abstract void onBitmapCropped(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onCropFailure(Throwable paramThrowable);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.callback.BitmapCropCallback
 * JD-Core Version:    0.7.0.1
 */