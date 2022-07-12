package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class FastBitmapDrawable
  extends Drawable
{
  private int mAlpha = 255;
  private Bitmap mBitmap;
  private int mHeight;
  private final Paint mPaint = new Paint(2);
  private int mWidth;
  
  public FastBitmapDrawable(Bitmap paramBitmap)
  {
    setBitmap(paramBitmap);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.mBitmap, null, getBounds(), this.mPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getMinimumHeight()
  {
    return this.mHeight;
  }
  
  public int getMinimumWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = this.mBitmap.getHeight();
      return;
    }
    this.mHeight = 0;
    this.mWidth = 0;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.FastBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */