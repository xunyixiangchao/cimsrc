package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

public class OverlayLocationData
{
  private String a;
  private Bitmap b;
  private int c;
  private int d;
  private int e;
  
  public Bitmap getImage()
  {
    return this.b;
  }
  
  public int getImgHeight()
  {
    return this.d;
  }
  
  public String getImgName()
  {
    return this.a;
  }
  
  public int getImgWidth()
  {
    return this.c;
  }
  
  public int isRotation()
  {
    return this.e;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }
  
  public void setImgHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setImgName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setImgWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRotation(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.OverlayLocationData
 * JD-Core Version:    0.7.0.1
 */