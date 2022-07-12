package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public class GradientLine
  extends Overlay
{
  List<LatLng> e;
  int[] f;
  int[] g;
  int h = 5;
  GradientLineOptions.LineDirectionCross180 i = GradientLineOptions.LineDirectionCross180.NONE;
  
  public GradientLine()
  {
    this.type = e.n;
  }
  
  private static void a(List<LatLng> paramList, GradientLineOptions.LineDirectionCross180 paramLineDirectionCross180, Bundle paramBundle)
  {
    int k = paramList.size();
    double[] arrayOfDouble1 = new double[k];
    double[] arrayOfDouble2 = new double[k];
    int j = 0;
    while (j < k)
    {
      Object localObject = (LatLng)paramList.get(j);
      GradientLineOptions.LineDirectionCross180 localLineDirectionCross180 = GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST;
      double d;
      if (paramLineDirectionCross180 == localLineDirectionCross180)
      {
        d = ((LatLng)localObject).longitude;
        if (d < 0.0D)
        {
          localObject = new LatLng(((LatLng)localObject).latitude, d + 360.0D);
          paramBundle.putInt("lineDirectionCross180", localLineDirectionCross180.ordinal());
          break label167;
        }
      }
      localLineDirectionCross180 = GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST;
      if (paramLineDirectionCross180 == localLineDirectionCross180)
      {
        d = ((LatLng)localObject).longitude;
        if (d > 0.0D)
        {
          localObject = new LatLng(((LatLng)localObject).latitude, d - 360.0D);
          paramBundle.putInt("lineDirectionCross180", localLineDirectionCross180.ordinal());
          break label167;
        }
      }
      paramBundle.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.NONE.ordinal());
      label167:
      localObject = CoordUtil.ll2mc((LatLng)localObject);
      arrayOfDouble1[j] = ((GeoPoint)localObject).getLongitudeE6();
      arrayOfDouble2[j] = ((GeoPoint)localObject).getLatitudeE6();
      j += 1;
    }
    paramBundle.putDoubleArray("x_array", arrayOfDouble1);
    paramBundle.putDoubleArray("y_array", arrayOfDouble2);
  }
  
  private static void a(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramBundle.putIntArray("color_indexs", paramArrayOfInt);
    }
  }
  
  private static void b(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramBundle.putIntArray("color_array", paramArrayOfInt);
    }
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() >= 2))
    {
      localObject = CoordUtil.ll2mc((LatLng)this.e.get(0));
      paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
      paramBundle.putInt("width", this.h);
      localObject = this.f;
      if (localObject != null)
      {
        if (localObject.length != 0)
        {
          a(this.e, this.i, paramBundle);
          a(this.f, paramBundle);
          localObject = this.g;
          if (localObject != null)
          {
            if (localObject.length != 0)
            {
              b((int[])localObject, paramBundle);
              return paramBundle;
            }
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
          }
          throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: Indexs array size can not be Equal to zero");
      }
      throw new IllegalStateException("BDMapSDKException: Indexs array can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
  }
  
  public int[] getColors()
  {
    return this.g;
  }
  
  public int[] getIndexs()
  {
    return this.f;
  }
  
  public GradientLineOptions.LineDirectionCross180 getLineDirectionCross180()
  {
    return this.i;
  }
  
  public List<LatLng> getPoints()
  {
    return this.e;
  }
  
  public float getWidth()
  {
    return this.h;
  }
  
  public void lineDirectionCross180(GradientLineOptions.LineDirectionCross180 paramLineDirectionCross180)
  {
    this.i = paramLineDirectionCross180;
  }
  
  public void setColorIndex(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      this.f = paramArrayOfInt;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
  }
  
  public void setColorList(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      this.g = paramArrayOfInt;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2)
      {
        if (!paramList.contains(null))
        {
          this.e = paramList;
          this.listener.c(this);
          return;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public void setWidth(int paramInt)
  {
    if (paramInt > 0)
    {
      this.h = paramInt;
      this.listener.c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.GradientLine
 * JD-Core Version:    0.7.0.1
 */