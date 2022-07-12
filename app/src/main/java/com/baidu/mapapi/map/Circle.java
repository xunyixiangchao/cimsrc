package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public final class Circle
  extends Overlay
{
  LatLng e;
  int f;
  int g;
  Stroke h;
  boolean i;
  int j = 0;
  List<HoleOptions> k;
  HoleOptions l;
  
  Circle()
  {
    this.type = e.h;
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.j == 1) {
      localObject = "CircleDashTexture.png";
    } else {
      localObject = "lineDashTexture.png";
    }
    Object localObject = BitmapDescriptorFactory.fromAsset((String)localObject);
    if (localObject != null) {
      paramBundle.putBundle("image_info", ((BitmapDescriptor)localObject).a());
    }
  }
  
  private void e(List<HoleOptions> paramList, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject = CoordUtil.ll2mc(this.e);
    paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
    paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
    if (this.i)
    {
      paramBundle.putDouble("dotted_stroke_location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("dotted_stroke_location_y", ((GeoPoint)localObject).getLatitudeE6());
      paramBundle.putInt("has_dotted_stroke", 1);
      b(paramBundle);
    }
    else
    {
      paramBundle.putInt("has_dotted_stroke", 0);
    }
    paramBundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.e, this.g));
    Overlay.a(this.f, paramBundle);
    if (this.h == null)
    {
      paramBundle.putInt("has_stroke", 0);
    }
    else
    {
      paramBundle.putInt("has_stroke", 1);
      localObject = new Bundle();
      paramBundle.putBundle("stroke", this.h.a((Bundle)localObject));
    }
    localObject = this.k;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.k;
    }
    else
    {
      if (this.l == null) {
        break label214;
      }
      localObject = new ArrayList();
      ((List)localObject).add(this.l);
    }
    e((List)localObject, paramBundle);
    return paramBundle;
    label214:
    paramBundle.putInt("has_holes", 0);
    return paramBundle;
  }
  
  public LatLng getCenter()
  {
    return this.e;
  }
  
  public int getDottedStrokeType()
  {
    return this.j;
  }
  
  public int getFillColor()
  {
    return this.f;
  }
  
  public HoleOptions getHoleOption()
  {
    return this.l;
  }
  
  public List<HoleOptions> getHoleOptions()
  {
    return this.k;
  }
  
  public int getRadius()
  {
    return this.g;
  }
  
  public Stroke getStroke()
  {
    return this.h;
  }
  
  public boolean isDottedStroke()
  {
    return this.i;
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.e = paramLatLng;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
  }
  
  public void setDottedStroke(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.listener.c(this);
  }
  
  public void setDottedStrokeType(CircleDottedStrokeType paramCircleDottedStrokeType)
  {
    this.j = paramCircleDottedStrokeType.ordinal();
    this.listener.c(this);
  }
  
  public void setFillColor(int paramInt)
  {
    this.f = paramInt;
    this.listener.c(this);
  }
  
  public void setHoleOption(HoleOptions paramHoleOptions)
  {
    this.l = paramHoleOptions;
    this.k = null;
    this.listener.c(this);
  }
  
  public void setHoleOptions(List<HoleOptions> paramList)
  {
    this.k = paramList;
    this.l = null;
    this.listener.c(this);
  }
  
  public void setRadius(int paramInt)
  {
    this.g = paramInt;
    this.listener.c(this);
  }
  
  public void setStroke(Stroke paramStroke)
  {
    this.h = paramStroke;
    this.listener.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Circle
 * JD-Core Version:    0.7.0.1
 */