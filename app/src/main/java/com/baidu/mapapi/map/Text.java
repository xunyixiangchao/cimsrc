package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import vi.com.gdi.bgl.android.java.EnvDrawText;

public final class Text
  extends Overlay
{
  String e;
  LatLng f;
  int g;
  int h;
  int i;
  Typeface j;
  int k;
  int l;
  float m;
  int n;
  
  Text()
  {
    this.type = e.e;
  }
  
  Bundle a()
  {
    Typeface localTypeface = this.j;
    if (localTypeface != null) {
      EnvDrawText.removeFontCache(localTypeface.hashCode());
    }
    return super.a();
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.f != null)
    {
      paramBundle.putString("text", this.e);
      Object localObject = CoordUtil.ll2mc(this.f);
      paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
      int i1 = this.h;
      paramBundle.putInt("font_color", Color.argb(i1 >>> 24, i1 & 0xFF, i1 >> 8 & 0xFF, i1 >> 16 & 0xFF));
      i1 = this.g;
      paramBundle.putInt("bg_color", Color.argb(i1 >>> 24, i1 & 0xFF, i1 >> 8 & 0xFF, i1 >> 16 & 0xFF));
      paramBundle.putInt("font_size", this.i);
      localObject = this.j;
      if (localObject != null)
      {
        EnvDrawText.registFontCache(((Typeface)localObject).hashCode(), this.j);
        paramBundle.putInt("type_face", this.j.hashCode());
      }
      i1 = this.k;
      float f2 = 0.5F;
      float f1;
      if (i1 != 1)
      {
        if (i1 != 2) {
          f1 = 0.5F;
        } else {
          f1 = 1.0F;
        }
      }
      else {
        f1 = 0.0F;
      }
      paramBundle.putFloat("align_x", f1);
      i1 = this.l;
      if (i1 != 8)
      {
        if (i1 != 16) {
          f1 = f2;
        } else {
          f1 = 1.0F;
        }
      }
      else {
        f1 = 0.0F;
      }
      paramBundle.putFloat("align_y", f1);
      paramBundle.putFloat("rotate", this.m);
      paramBundle.putInt("update", this.n);
      return paramBundle;
    }
    throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
  }
  
  public float getAlignX()
  {
    return this.k;
  }
  
  public float getAlignY()
  {
    return this.l;
  }
  
  public int getBgColor()
  {
    return this.g;
  }
  
  public int getFontColor()
  {
    return this.h;
  }
  
  public int getFontSize()
  {
    return this.i;
  }
  
  public LatLng getPosition()
  {
    return this.f;
  }
  
  public float getRotate()
  {
    return this.m;
  }
  
  public String getText()
  {
    return this.e;
  }
  
  public Typeface getTypeface()
  {
    return this.j;
  }
  
  public void setAlign(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.n = 1;
    this.listener.c(this);
  }
  
  public void setBgColor(int paramInt)
  {
    this.g = paramInt;
    this.n = 1;
    this.listener.c(this);
  }
  
  public void setFontColor(int paramInt)
  {
    this.h = paramInt;
    this.n = 1;
    this.listener.c(this);
  }
  
  public void setFontSize(int paramInt)
  {
    this.i = paramInt;
    this.n = 1;
    this.listener.c(this);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.f = paramLatLng;
      this.n = 1;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: position can not be null");
  }
  
  public void setRotate(float paramFloat)
  {
    this.m = paramFloat;
    this.n = 1;
    this.listener.c(this);
  }
  
  public void setText(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.e = paramString;
      this.n = 1;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.j = paramTypeface;
    this.n = 1;
    this.listener.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Text
 * JD-Core Version:    0.7.0.1
 */