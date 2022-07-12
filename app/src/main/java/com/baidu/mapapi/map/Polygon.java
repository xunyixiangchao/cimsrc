package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public final class Polygon
  extends Overlay
{
  Stroke e;
  int f;
  List<LatLng> g;
  List<HoleOptions> h;
  HoleOptions i;
  boolean j;
  int k = 0;
  
  Polygon()
  {
    this.type = e.j;
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.k == 1) {
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
    GeoPoint localGeoPoint = CoordUtil.ll2mc((LatLng)this.g.get(0));
    paramBundle.putDouble("location_x", localGeoPoint.getLongitudeE6());
    paramBundle.putDouble("location_y", localGeoPoint.getLatitudeE6());
    Overlay.c(this.g, paramBundle);
    Overlay.a(this.f, paramBundle);
    if (this.e == null)
    {
      paramBundle.putInt("has_stroke", 0);
    }
    else
    {
      paramBundle.putInt("has_stroke", 1);
      localObject = new Bundle();
      paramBundle.putBundle("stroke", this.e.a((Bundle)localObject));
    }
    Object localObject = this.h;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.h;
    }
    else
    {
      if (this.i == null) {
        break label166;
      }
      localObject = new ArrayList();
      ((List)localObject).add(this.i);
    }
    e((List)localObject, paramBundle);
    break label173;
    label166:
    paramBundle.putInt("has_holes", 0);
    label173:
    if (this.j)
    {
      paramBundle.putDouble("dotted_stroke_location_x", localGeoPoint.getLongitudeE6());
      paramBundle.putDouble("dotted_stroke_location_y", localGeoPoint.getLatitudeE6());
      paramBundle.putInt("has_dotted_stroke", 1);
      b(paramBundle);
      return paramBundle;
    }
    paramBundle.putInt("has_dotted_stroke", 0);
    return paramBundle;
  }
  
  public int getFillColor()
  {
    return this.f;
  }
  
  public HoleOptions getHoleOption()
  {
    return this.i;
  }
  
  public List<HoleOptions> getHoleOptions()
  {
    return this.h;
  }
  
  public List<LatLng> getPoints()
  {
    return this.g;
  }
  
  public Stroke getStroke()
  {
    return this.e;
  }
  
  public void setFillColor(int paramInt)
  {
    this.f = paramInt;
    this.listener.c(this);
  }
  
  public void setHoleOption(HoleOptions paramHoleOptions)
  {
    this.i = paramHoleOptions;
    this.h = null;
    this.listener.c(this);
  }
  
  public void setHoleOptions(List<HoleOptions> paramList)
  {
    this.h = paramList;
    this.i = null;
    this.listener.c(this);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() > 2)
      {
        if (!paramList.contains(null))
        {
          int n;
          for (int m = 0; m < paramList.size(); m = n)
          {
            n = m + 1;
            int i1 = n;
            while (i1 < paramList.size()) {
              if ((LatLng)paramList.get(m) != (LatLng)paramList.get(i1)) {
                i1 += 1;
              } else {
                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
              }
            }
          }
          this.g = paramList;
          this.listener.c(this);
          return;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public void setStroke(Stroke paramStroke)
  {
    this.e = paramStroke;
    this.listener.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Polygon
 * JD-Core Version:    0.7.0.1
 */