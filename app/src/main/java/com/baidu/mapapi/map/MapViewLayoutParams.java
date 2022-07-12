package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mapapi.model.LatLng;

public final class MapViewLayoutParams
  extends ViewGroup.LayoutParams
{
  public static final int ALIGN_BOTTOM = 16;
  public static final int ALIGN_CENTER_HORIZONTAL = 4;
  public static final int ALIGN_CENTER_VERTICAL = 32;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  public static final int ALIGN_TOP = 8;
  LatLng a;
  Point b;
  ELayoutMode c;
  float d;
  float e;
  int f;
  
  MapViewLayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, Point paramPoint, ELayoutMode paramELayoutMode, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2);
    this.a = paramLatLng;
    this.b = paramPoint;
    this.c = paramELayoutMode;
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2) {
        this.d = 0.5F;
      } else {
        this.d = 1.0F;
      }
    }
    else {
      this.d = 0.0F;
    }
    if (paramInt4 != 8)
    {
      if ((paramInt4 != 16) && (paramInt4 == 32)) {
        this.e = 0.5F;
      } else {
        this.e = 1.0F;
      }
    }
    else {
      this.e = 0.0F;
    }
    this.f = paramInt5;
  }
  
  public static final class Builder
  {
    private int a;
    private int b;
    private LatLng c;
    private Point d;
    private MapViewLayoutParams.ELayoutMode e = MapViewLayoutParams.ELayoutMode.absoluteMode;
    private int f = 4;
    private int g = 16;
    private int h;
    
    public Builder align(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 4)) {
        this.f = paramInt1;
      }
      if ((paramInt2 == 8) || (paramInt2 == 16) || (paramInt2 == 32)) {
        this.g = paramInt2;
      }
      return this;
    }
    
    public MapViewLayoutParams build()
    {
      MapViewLayoutParams.ELayoutMode localELayoutMode = this.e;
      int i;
      if (localELayoutMode == MapViewLayoutParams.ELayoutMode.mapMode ? this.c == null : (localELayoutMode == MapViewLayoutParams.ELayoutMode.absoluteMode) && (this.d == null)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return new MapViewLayoutParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      }
      throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
    }
    
    public Builder height(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public Builder layoutMode(MapViewLayoutParams.ELayoutMode paramELayoutMode)
    {
      this.e = paramELayoutMode;
      return this;
    }
    
    public Builder point(Point paramPoint)
    {
      this.d = paramPoint;
      return this;
    }
    
    public Builder position(LatLng paramLatLng)
    {
      this.c = paramLatLng;
      return this;
    }
    
    public Builder width(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public Builder yOffset(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
  }
  
  public static enum ELayoutMode
  {
    static
    {
      ELayoutMode localELayoutMode1 = new ELayoutMode("mapMode", 0);
      mapMode = localELayoutMode1;
      ELayoutMode localELayoutMode2 = new ELayoutMode("absoluteMode", 1);
      absoluteMode = localELayoutMode2;
      $VALUES = new ELayoutMode[] { localELayoutMode1, localELayoutMode2 };
    }
    
    private ELayoutMode() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapViewLayoutParams
 * JD-Core Version:    0.7.0.1
 */