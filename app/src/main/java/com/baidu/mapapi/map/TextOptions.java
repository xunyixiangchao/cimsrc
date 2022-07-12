package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

public final class TextOptions
  extends OverlayOptions
{
  public static final int ALIGN_BOTTOM = 16;
  public static final int ALIGN_CENTER_HORIZONTAL = 4;
  public static final int ALIGN_CENTER_VERTICAL = 32;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  public static final int ALIGN_TOP = 8;
  private String a;
  private LatLng b;
  private int c;
  private int d = -16777216;
  private int e = 12;
  private Typeface f;
  private int g = 4;
  private int h = 32;
  private float i;
  int j;
  boolean k = true;
  Bundle l;
  
  Overlay a()
  {
    Text localText = new Text();
    localText.c = this.k;
    localText.b = this.j;
    localText.d = this.l;
    localText.e = this.a;
    localText.f = this.b;
    localText.g = this.c;
    localText.h = this.d;
    localText.i = this.e;
    localText.j = this.f;
    localText.k = this.g;
    localText.l = this.h;
    localText.m = this.i;
    return localText;
  }
  
  public TextOptions align(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    return this;
  }
  
  public TextOptions bgColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public TextOptions extraInfo(Bundle paramBundle)
  {
    this.l = paramBundle;
    return this;
  }
  
  public TextOptions fontColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public TextOptions fontSize(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public float getAlignX()
  {
    return this.g;
  }
  
  public float getAlignY()
  {
    return this.h;
  }
  
  public int getBgColor()
  {
    return this.c;
  }
  
  public Bundle getExtraInfo()
  {
    return this.l;
  }
  
  public int getFontColor()
  {
    return this.d;
  }
  
  public int getFontSize()
  {
    return this.e;
  }
  
  public LatLng getPosition()
  {
    return this.b;
  }
  
  public float getRotate()
  {
    return this.i;
  }
  
  public String getText()
  {
    return this.a;
  }
  
  public Typeface getTypeface()
  {
    return this.f;
  }
  
  public int getZIndex()
  {
    return this.j;
  }
  
  public boolean isVisible()
  {
    return this.k;
  }
  
  public TextOptions position(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.b = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: position can not be null");
  }
  
  public TextOptions rotate(float paramFloat)
  {
    this.i = paramFloat;
    return this;
  }
  
  public TextOptions text(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.a = paramString;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
  }
  
  public TextOptions typeface(Typeface paramTypeface)
  {
    this.f = paramTypeface;
    return this;
  }
  
  public TextOptions visible(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public TextOptions zIndex(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.TextOptions
 * JD-Core Version:    0.7.0.1
 */