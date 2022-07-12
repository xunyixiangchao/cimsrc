package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class OverlayItem
{
  public static final int ALIGN_BOTTON = 2;
  public static final int ALIGN_TOP = 3;
  public static final int ALING_CENTER = 1;
  private int a;
  private int b;
  private int c;
  protected GeoPoint d;
  protected String e;
  protected String f;
  private Drawable g;
  private String h;
  private CoordType i = CoordType.CoordType_BD09;
  private float j;
  private float k;
  private ArrayList<Bundle> l;
  private Bundle m;
  private Bundle n;
  private float o;
  private byte[] p;
  private float q;
  private int r;
  private int s;
  
  public OverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    this.d = paramGeoPoint;
    this.e = paramString1;
    this.f = paramString2;
    this.g = null;
    this.r = 0;
    this.a = 2;
    this.h = "";
    this.j = 0.5F;
    this.k = 1.0F;
    this.l = new ArrayList();
  }
  
  public void addClickRect(Bundle paramBundle)
  {
    if (this.l == null) {
      this.l = new ArrayList();
    }
    this.l.add(paramBundle);
  }
  
  public float getAnchorX()
  {
    return this.j;
  }
  
  public float getAnchorY()
  {
    return this.k;
  }
  
  public Bundle getAnimate()
  {
    return this.m;
  }
  
  public int getBound()
  {
    return this.a;
  }
  
  public ArrayList<Bundle> getClickRect()
  {
    return this.l;
  }
  
  public CoordType getCoordType()
  {
    return this.i;
  }
  
  public Bundle getDelay()
  {
    return this.n;
  }
  
  public float getGeoZ()
  {
    return this.o;
  }
  
  public byte[] getGifData()
  {
    return this.p;
  }
  
  public String getId()
  {
    return this.h;
  }
  
  public int getIndoorPoi()
  {
    return this.s;
  }
  
  public int getLevel()
  {
    return this.b;
  }
  
  public final Drawable getMarker()
  {
    return this.g;
  }
  
  public int getMask()
  {
    return this.c;
  }
  
  public float getMultiplyDpi()
  {
    return this.r;
  }
  
  public GeoPoint getPoint()
  {
    return this.d;
  }
  
  public int getResId()
  {
    if (getMarker() == null) {
      return -1;
    }
    return getMarker().hashCode();
  }
  
  public float getScale()
  {
    return this.q;
  }
  
  public String getSnippet()
  {
    return this.f;
  }
  
  public String getTitle()
  {
    return this.e;
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    this.j = paramFloat1;
    this.k = paramFloat2;
  }
  
  public void setAnchor(int paramInt)
  {
    if (paramInt != 1)
    {
      float f1;
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        f1 = 0.0F;
      }
      else
      {
        f1 = 1.0F;
      }
      setAnchor(0.5F, f1);
      return;
    }
    setAnchor(0.5F, 0.5F);
  }
  
  public void setAnimate(Bundle paramBundle)
  {
    this.m = paramBundle;
  }
  
  public void setAnimateDuration(int paramInt)
  {
    if (this.m == null) {
      this.m = new Bundle();
    }
    this.m.putInt("dur", paramInt);
  }
  
  public void setAnimateEffect(AnimEffect paramAnimEffect)
  {
    if (this.m == null) {
      this.m = new Bundle();
    }
    int i1;
    switch (a.a[paramAnimEffect.ordinal()])
    {
    default: 
      paramAnimEffect = this.m;
      i1 = 0;
      break;
    case 11: 
      paramAnimEffect = this.m;
      i1 = 11;
      break;
    case 10: 
      paramAnimEffect = this.m;
      i1 = 10;
      break;
    case 9: 
      paramAnimEffect = this.m;
      i1 = 9;
      break;
    case 8: 
      paramAnimEffect = this.m;
      i1 = 8;
      break;
    case 7: 
      paramAnimEffect = this.m;
      i1 = 7;
      break;
    case 6: 
      paramAnimEffect = this.m;
      i1 = 6;
      break;
    case 5: 
      paramAnimEffect = this.m;
      i1 = 5;
      break;
    case 4: 
      paramAnimEffect = this.m;
      i1 = 4;
      break;
    case 3: 
      paramAnimEffect = this.m;
      i1 = 3;
      break;
    case 2: 
      paramAnimEffect = this.m;
      i1 = 2;
      break;
    case 1: 
      paramAnimEffect = this.m;
      i1 = 1;
    }
    paramAnimEffect.putInt("type", i1);
  }
  
  public void setAnimateEndSize(int paramInt1, int paramInt2)
  {
    if (this.m == null) {
      this.m = new Bundle();
    }
    this.m.putInt("en_w", paramInt1);
    this.m.putInt("en_h", paramInt2);
  }
  
  public void setAnimateStartSize(int paramInt1, int paramInt2)
  {
    if (this.m == null) {
      this.m = new Bundle();
    }
    this.m.putInt("st_w", paramInt1);
    this.m.putInt("st_h", paramInt2);
  }
  
  public void setBound(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setClickRect(ArrayList<Bundle> paramArrayList)
  {
    this.l = paramArrayList;
  }
  
  public void setCoordType(CoordType paramCoordType)
  {
    this.i = paramCoordType;
  }
  
  public void setDelay(Bundle paramBundle)
  {
    this.n = paramBundle;
  }
  
  public void setGeoPoint(GeoPoint paramGeoPoint)
  {
    this.d = paramGeoPoint;
  }
  
  public void setGeoZ(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void setGifData(byte[] paramArrayOfByte)
  {
    this.p = paramArrayOfByte;
  }
  
  public void setId(String paramString)
  {
    this.h = paramString;
  }
  
  public void setIndoorPoi(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setMarker(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  public void setMask(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMultiplyDpi(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setScale(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void setSnippet(String paramString)
  {
    this.f = paramString;
  }
  
  public void setSubAnimateEffect(AnimationSubType paramAnimationSubType)
  {
    if (this.m == null) {
      this.m = new Bundle();
    }
    int i2 = a.b[paramAnimationSubType.ordinal()];
    int i1 = 1;
    if (i2 != 1)
    {
      paramAnimationSubType = this.m;
      i1 = 0;
    }
    else
    {
      paramAnimationSubType = this.m;
    }
    paramAnimationSubType.putInt("sub_type", i1);
  }
  
  public void setTitle(String paramString)
  {
    this.e = paramString;
  }
  
  public static enum AnimEffect
  {
    static
    {
      AnimEffect localAnimEffect1 = new AnimEffect("NONE", 0);
      NONE = localAnimEffect1;
      AnimEffect localAnimEffect2 = new AnimEffect("GROWTH", 1);
      GROWTH = localAnimEffect2;
      AnimEffect localAnimEffect3 = new AnimEffect("WAVE", 2);
      WAVE = localAnimEffect3;
      AnimEffect localAnimEffect4 = new AnimEffect("SHRINK", 3);
      SHRINK = localAnimEffect4;
      AnimEffect localAnimEffect5 = new AnimEffect("FADE_OUT", 4);
      FADE_OUT = localAnimEffect5;
      AnimEffect localAnimEffect6 = new AnimEffect("FADE_IN", 5);
      FADE_IN = localAnimEffect6;
      AnimEffect localAnimEffect7 = new AnimEffect("GROWTH_FADE_IN", 6);
      GROWTH_FADE_IN = localAnimEffect7;
      AnimEffect localAnimEffect8 = new AnimEffect("SHRINK_FADE_OUT", 7);
      SHRINK_FADE_OUT = localAnimEffect8;
      AnimEffect localAnimEffect9 = new AnimEffect("GROWTH_REBOUND", 8);
      GROWTH_REBOUND = localAnimEffect9;
      AnimEffect localAnimEffect10 = new AnimEffect("ALPHA", 9);
      ALPHA = localAnimEffect10;
      AnimEffect localAnimEffect11 = new AnimEffect("ANCHOR_GROUTH", 10);
      ANCHOR_GROUTH = localAnimEffect11;
      AnimEffect localAnimEffect12 = new AnimEffect("ROTATE", 11);
      ROTATE = localAnimEffect12;
      $VALUES = new AnimEffect[] { localAnimEffect1, localAnimEffect2, localAnimEffect3, localAnimEffect4, localAnimEffect5, localAnimEffect6, localAnimEffect7, localAnimEffect8, localAnimEffect9, localAnimEffect10, localAnimEffect11, localAnimEffect12 };
    }
    
    private AnimEffect() {}
  }
  
  public static enum AnimationSubType
  {
    static
    {
      AnimationSubType localAnimationSubType1 = new AnimationSubType("NONE", 0);
      NONE = localAnimationSubType1;
      AnimationSubType localAnimationSubType2 = new AnimationSubType("RADAR", 1);
      RADAR = localAnimationSubType2;
      $VALUES = new AnimationSubType[] { localAnimationSubType1, localAnimationSubType2 };
    }
    
    private AnimationSubType() {}
  }
  
  public static enum CoordType
  {
    static
    {
      CoordType localCoordType1 = new CoordType("CoordType_BD09LL", 0);
      CoordType_BD09LL = localCoordType1;
      CoordType localCoordType2 = new CoordType("CoordType_BD09", 1);
      CoordType_BD09 = localCoordType2;
      $VALUES = new CoordType[] { localCoordType1, localCoordType2 };
    }
    
    private CoordType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.OverlayItem
 * JD-Core Version:    0.7.0.1
 */