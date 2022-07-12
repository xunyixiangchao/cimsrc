package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

public final class MarkerOptions
  extends OverlayOptions
{
  boolean A = true;
  Bundle B;
  private LatLng a;
  private BitmapDescriptor b;
  private float c = 0.5F;
  private float d = 1.0F;
  private boolean e = true;
  private boolean f = false;
  private float g;
  private String h;
  private int i;
  private boolean j = false;
  private ArrayList<BitmapDescriptor> k;
  private int l = 20;
  private float m = 1.0F;
  private float n = 1.0F;
  private float o = 1.0F;
  private int p = MarkerAnimateType.none.ordinal();
  private boolean q = false;
  private Point r;
  private boolean s = true;
  private InfoWindow t;
  private int u = 2147483647;
  private boolean v = false;
  private int w = 4;
  private int x = 22;
  private boolean y = false;
  int z;
  
  Overlay a()
  {
    Marker localMarker = new Marker();
    localMarker.c = this.A;
    localMarker.b = this.z;
    localMarker.d = this.B;
    Object localObject = this.a;
    if (localObject != null)
    {
      localMarker.e = ((LatLng)localObject);
      localObject = this.b;
      if ((localObject == null) && (this.k == null)) {
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
      }
      localMarker.f = ((BitmapDescriptor)localObject);
      localMarker.g = this.c;
      localMarker.h = this.d;
      localMarker.i = this.e;
      localMarker.j = this.f;
      localMarker.k = this.g;
      localMarker.l = this.h;
      localMarker.m = this.i;
      localMarker.n = this.j;
      localMarker.v = this.k;
      localMarker.w = this.l;
      localMarker.p = this.o;
      localMarker.y = this.m;
      localMarker.z = this.n;
      localMarker.q = this.p;
      localMarker.r = this.q;
      localMarker.C = this.t;
      localMarker.s = this.s;
      localMarker.F = this.u;
      localMarker.u = this.v;
      localMarker.G = this.w;
      localMarker.H = this.x;
      localMarker.t = this.y;
      localObject = this.r;
      if (localObject != null) {
        localMarker.B = ((Point)localObject);
      }
      return localMarker;
    }
    throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.o = paramFloat;
      return this;
    }
    this.o = 1.0F;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat1 > 1.0F) {
        return this;
      }
      if (paramFloat2 >= 0.0F)
      {
        if (paramFloat2 > 1.0F) {
          return this;
        }
        this.c = paramFloat1;
        this.d = paramFloat2;
      }
    }
    return this;
  }
  
  public MarkerOptions animateType(MarkerAnimateType paramMarkerAnimateType)
  {
    MarkerAnimateType localMarkerAnimateType = paramMarkerAnimateType;
    if (paramMarkerAnimateType == null) {
      localMarkerAnimateType = MarkerAnimateType.none;
    }
    this.p = localMarkerAnimateType.ordinal();
    return this;
  }
  
  public MarkerOptions clickable(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public MarkerOptions endLevel(int paramInt)
  {
    this.x = paramInt;
    return this;
  }
  
  public MarkerOptions extraInfo(Bundle paramBundle)
  {
    this.B = paramBundle;
    return this;
  }
  
  public MarkerOptions fixedScreenPosition(Point paramPoint)
  {
    this.r = paramPoint;
    this.q = true;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.o;
  }
  
  public float getAnchorX()
  {
    return this.c;
  }
  
  public float getAnchorY()
  {
    return this.d;
  }
  
  public MarkerAnimateType getAnimateType()
  {
    int i1 = this.p;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return MarkerAnimateType.none;
        }
        return MarkerAnimateType.jump;
      }
      return MarkerAnimateType.grow;
    }
    return MarkerAnimateType.drop;
  }
  
  public int getEndLevel()
  {
    return this.x;
  }
  
  public Bundle getExtraInfo()
  {
    return this.B;
  }
  
  public boolean getForceDisPlay()
  {
    return this.v;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.b;
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    return this.k;
  }
  
  public boolean getJoinCollision()
  {
    return this.y;
  }
  
  public int getPeriod()
  {
    return this.l;
  }
  
  public LatLng getPosition()
  {
    return this.a;
  }
  
  public int getPriority()
  {
    return this.u;
  }
  
  public float getRotate()
  {
    return this.g;
  }
  
  public int getStartLevel()
  {
    return this.w;
  }
  
  @Deprecated
  public String getTitle()
  {
    return this.h;
  }
  
  public int getZIndex()
  {
    return this.z;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      this.b = paramBitmapDescriptor;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
  }
  
  public MarkerOptions icons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return this;
      }
      int i1 = 0;
      while (i1 < paramArrayList.size()) {
        if (paramArrayList.get(i1) != null)
        {
          if (((BitmapDescriptor)paramArrayList.get(i1)).a == null) {
            return this;
          }
          i1 += 1;
        }
        else
        {
          return this;
        }
      }
      this.k = paramArrayList;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
  }
  
  public MarkerOptions infoWindow(InfoWindow paramInfoWindow)
  {
    this.t = paramInfoWindow;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.f;
  }
  
  public boolean isFlat()
  {
    return this.j;
  }
  
  public MarkerOptions isForceDisPlay(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }
  
  public MarkerOptions isJoinCollision(boolean paramBoolean)
  {
    this.y = paramBoolean;
    return this;
  }
  
  public boolean isPerspective()
  {
    return this.e;
  }
  
  public boolean isVisible()
  {
    return this.A;
  }
  
  public MarkerOptions period(int paramInt)
  {
    if (paramInt > 0)
    {
      this.l = paramInt;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
  }
  
  public MarkerOptions perspective(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.a = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
  }
  
  public MarkerOptions priority(int paramInt)
  {
    this.u = paramInt;
    return this;
  }
  
  public MarkerOptions rotate(float paramFloat)
  {
    while (paramFloat < 0.0F) {
      paramFloat += 360.0F;
    }
    this.g = (paramFloat % 360.0F);
    return this;
  }
  
  public MarkerOptions scaleX(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return this;
    }
    this.m = paramFloat;
    return this;
  }
  
  public MarkerOptions scaleY(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return this;
    }
    this.n = paramFloat;
    return this;
  }
  
  public MarkerOptions startLevel(int paramInt)
  {
    this.w = paramInt;
    return this;
  }
  
  @Deprecated
  public MarkerOptions title(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.A = paramBoolean;
    return this;
  }
  
  public MarkerOptions yOffset(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public MarkerOptions zIndex(int paramInt)
  {
    this.z = paramInt;
    return this;
  }
  
  public static enum MarkerAnimateType
  {
    static
    {
      MarkerAnimateType localMarkerAnimateType1 = new MarkerAnimateType("none", 0);
      none = localMarkerAnimateType1;
      MarkerAnimateType localMarkerAnimateType2 = new MarkerAnimateType("drop", 1);
      drop = localMarkerAnimateType2;
      MarkerAnimateType localMarkerAnimateType3 = new MarkerAnimateType("grow", 2);
      grow = localMarkerAnimateType3;
      MarkerAnimateType localMarkerAnimateType4 = new MarkerAnimateType("jump", 3);
      jump = localMarkerAnimateType4;
      a = new MarkerAnimateType[] { localMarkerAnimateType1, localMarkerAnimateType2, localMarkerAnimateType3, localMarkerAnimateType4 };
    }
    
    private MarkerAnimateType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */