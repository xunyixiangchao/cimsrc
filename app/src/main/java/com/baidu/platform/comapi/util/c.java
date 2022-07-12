package com.baidu.platform.comapi.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class c
{
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((Build.VERSION.SDK_INT <= 26) && ((paramDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    for (;;)
    {
      int m;
      int j;
      try
      {
        if (!paramDrawable.getBounds().isEmpty()) {
          i = paramDrawable.getBounds().width();
        } else {
          i = paramDrawable.getIntrinsicWidth();
        }
        if (!paramDrawable.getBounds().isEmpty()) {
          k = paramDrawable.getBounds().height();
        } else {
          k = paramDrawable.getIntrinsicHeight();
        }
        m = i;
        j = k;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break label208;
        }
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
        m = i;
        j = k;
        if (localBitmap == null) {
          break label208;
        }
        if (i <= localBitmap.getWidth()) {
          i = localBitmap.getWidth();
        }
        if (k > localBitmap.getHeight())
        {
          m = i;
          j = k;
        }
        else
        {
          j = localBitmap.getHeight();
          m = i;
        }
      }
      catch (Exception paramDrawable)
      {
        Bitmap localBitmap;
        Canvas localCanvas;
        return null;
      }
      localBitmap = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      label208:
      int i = m;
      if (m <= 0) {
        i = 1;
      }
      int k = j;
      if (j <= 0) {
        k = 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.c
 * JD-Core Version:    0.7.0.1
 */