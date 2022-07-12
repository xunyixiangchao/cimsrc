package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BitmapDescriptor
{
  Bitmap a;
  private Bundle b;
  
  BitmapDescriptor(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.a = a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  Bundle a()
  {
    if (this.a != null)
    {
      if (this.b == null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("image_width", this.a.getWidth());
        localBundle.putInt("image_height", this.a.getHeight());
        byte[] arrayOfByte = b();
        localBundle.putByteArray("image_data", arrayOfByte);
        Object localObject = null;
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          localObject = localMessageDigest;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localNoSuchAlgorithmException.printStackTrace();
        }
        if (localObject != null)
        {
          int j = arrayOfByte.length;
          int i = 0;
          ((MessageDigest)localObject).update(arrayOfByte, 0, j);
          localObject = ((MessageDigest)localObject).digest();
          StringBuilder localStringBuilder = new StringBuilder("");
          while (i < localObject.length)
          {
            localStringBuilder.append(Integer.toString((localObject[i] & 0xFF) + 256, 16).substring(1));
            i += 1;
          }
          localBundle.putString("image_hashcode", localStringBuilder.toString());
        }
        this.b = localBundle;
      }
      return this.b;
    }
    throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
  }
  
  byte[] b()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(this.a.getWidth() * this.a.getHeight() * 4);
    this.a.copyPixelsToBuffer(localByteBuffer);
    return localByteBuffer.array();
  }
  
  public void clearCache()
  {
    Bundle localBundle = this.b;
    if (localBundle != null)
    {
      localBundle.clear();
      this.b = null;
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.a;
  }
  
  public void recycle()
  {
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */