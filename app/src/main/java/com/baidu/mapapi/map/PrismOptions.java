package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import java.util.List;

public class PrismOptions
  extends OverlayOptions
{
  private float a;
  private List<LatLng> b;
  private int c = -16777216;
  private int d = -16777216;
  private BuildingInfo e;
  private BitmapDescriptor f;
  boolean g = true;
  
  Overlay a()
  {
    Prism localPrism = new Prism();
    localPrism.c = this.g;
    localPrism.j = this.f;
    localPrism.e = this.a;
    if (this.e == null)
    {
      List localList = this.b;
      if ((localList == null) || (localList.size() <= 3)) {
        throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
      }
    }
    localPrism.f = this.b;
    localPrism.h = this.d;
    localPrism.g = this.c;
    localPrism.i = this.e;
    return localPrism;
  }
  
  public PrismOptions customSideImage(BitmapDescriptor paramBitmapDescriptor)
  {
    this.f = paramBitmapDescriptor;
    return this;
  }
  
  public BuildingInfo getBuildingInfo()
  {
    return this.e;
  }
  
  public BitmapDescriptor getCustomSideImage()
  {
    return this.f;
  }
  
  public float getHeight()
  {
    return this.a;
  }
  
  public List<LatLng> getPoints()
  {
    return this.b;
  }
  
  public int getSideFaceColor()
  {
    return this.d;
  }
  
  public int getTopFaceColor()
  {
    return this.c;
  }
  
  public boolean isVisible()
  {
    return this.g;
  }
  
  public PrismOptions setBuildingInfo(BuildingInfo paramBuildingInfo)
  {
    this.e = paramBuildingInfo;
    return this;
  }
  
  public PrismOptions setHeight(float paramFloat)
  {
    this.a = paramFloat;
    return this;
  }
  
  public PrismOptions setPoints(List<LatLng> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public PrismOptions setSideFaceColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public PrismOptions setTopFaceColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PrismOptions visible(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.PrismOptions
 * JD-Core Version:    0.7.0.1
 */