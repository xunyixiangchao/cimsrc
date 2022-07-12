package com.baidu.mapsdkplatform.comapi.util;

import android.os.Bundle;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  static double[] a = { 12890594.859999999D, 8362377.8700000001D, 5591021.0D, 3481989.8300000001D, 1678043.1200000001D, 0.0D };
  static double[] b = { 75000000.0D, 60000000.0D, 45000000.0D, 30000000.0D, 15000000.0D, 0.0D };
  static double[][] c;
  static double[][] d;
  
  static
  {
    double[] arrayOfDouble1 = { -7.435856389565537E-009D, 8.983055097726239E-006D, -0.78625201886289D, 96.326875997598464D, -1.85204757529826D, -59.369359054858769D, 47.400335492967372D, -16.50741931063887D, 2.28786674699375D, 10260144.859999999D };
    double[] arrayOfDouble2 = { -3.030883460898826E-008D, 8.98305509983578E-006D, 0.30071316287616D, 59.742936184422767D, 7.357984074871D, -25.383710026647449D, 13.45380521110908D, -3.29883767235584D, 0.32710905363475D, 6856817.3700000001D };
    double[] arrayOfDouble3 = { 3.09191371068437E-009D, 8.983055096812155E-006D, 6.995724061999999E-005D, 23.109343041449009D, -0.00023663490511D, -0.6321817810242D, -0.00663494467273D, 0.03430082397953D, -0.00466043876332D, 2555164.3999999999D };
    double[] arrayOfDouble4 = { 2.890871144776878E-009D, 8.983055095805407E-006D, -3.068298E-008D, 7.47137025468032D, -3.53937994E-006D, -0.02145144861037D, -1.234426596E-005D, 0.00010322952773D, -3.23890364E-006D, 826088.5D };
    c = new double[][] { { 1.410526172116255E-008D, 8.98305509648872E-006D, -1.9939833816331D, 200.98243831067961D, -187.2403703815547D, 91.608751666984304D, -23.38765649603339D, 2.57121317296198D, -0.03801003308653D, 17337981.199999999D }, arrayOfDouble1, arrayOfDouble2, { -1.981981304930552E-008D, 8.983055099779535E-006D, 0.03278182852591D, 40.316785277057441D, 0.65659298677277D, -4.44255534477492D, 0.85341911805263D, 0.12923347998204D, -0.04625736007561D, 4482777.0599999996D }, arrayOfDouble3, arrayOfDouble4 };
    arrayOfDouble1 = new double[] { 0.000827782451617253D, 111320.70204635779D, 647795574.66716075D, -4082003173.6413159D, 10774905663.511419D, -15171875531.515591D, 12053065338.62167D, -5124939663.5774717D, 913311935.95120323D, 67.5D };
    arrayOfDouble2 = new double[] { 0.00220636496208D, 111320.70202091279D, 51751.861128411307D, 3796837.7494702451D, 992013.73977910134D, -1221952.21711287D, 1340652.697009075D, -620943.69909843116D, 144416.92938062409D, 37.5D };
    arrayOfDouble3 = new double[] { -0.0003218135878613132D, 111320.7020701615D, 0.00369383431289D, 823725.64027957176D, 0.46104986909093D, 2351.3431413312919D, 1.58060784298199D, 8.77738589078284D, 0.37238884252424D, 7.45D };
    d = new double[][] { { -0.0015702102444D, 111320.7020616939D, 1704480524535203.0D, -10338987376042340.0D, 26112667856603880.0D, -35149669176653700.0D, 26595700718403920.0D, -10725012454188240.0D, 1800819912950474.0D, 82.5D }, arrayOfDouble1, { 0.00337398766765D, 111320.70202021619D, 4481351.0458903648D, -23393751.199316621D, 79682215.471864551D, -115964993.2797253D, 97236711.156021446D, -43661946.337528206D, 8477230.5011352338D, 52.5D }, arrayOfDouble2, { -0.0003441963504368392D, 111320.7020576856D, 278.23539807727519D, 2485758.6900353939D, 6070.7509632433776D, 54821.183453521182D, 9540.6066333042363D, -2710.5532674664501D, 1405.483844121726D, 22.5D }, arrayOfDouble3 };
  }
  
  public static int a(LatLng paramLatLng, int paramInt)
  {
    Object localObject = new LatLng(paramLatLng.latitude + paramInt / 111000.0D, paramLatLng.longitude);
    paramLatLng = a(paramLatLng);
    localObject = a((LatLng)localObject);
    return (int)Math.sqrt(Math.pow(paramLatLng.getLatitudeE6() - ((GeoPoint)localObject).getLatitudeE6(), 2.0D) + Math.pow(paramLatLng.getLongitudeE6() - ((GeoPoint)localObject).getLongitudeE6(), 2.0D));
  }
  
  public static LatLng a(float paramFloat1, float paramFloat2, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ((!paramString.equals("")) && (!paramString.equals("bd09ll")))
    {
      if ((!paramString.equals("bd09ll")) && (!paramString.equals("bd09mc")) && (!paramString.equals("gcj02")) && (!paramString.equals("wgs84"))) {
        return null;
      }
      Bundle localBundle = new Bundle();
      JNITools.CoordinateEncryptEx(paramFloat1, paramFloat2, paramString, localBundle);
      if (!localBundle.isEmpty()) {
        return new LatLng(localBundle.getDouble("y"), localBundle.getDouble("x"));
      }
      return null;
    }
    return new LatLng(paramFloat1, paramFloat2);
  }
  
  public static LatLng a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    Object localObject = new a();
    ((a)localObject).a = paramGeoPoint.getLongitudeE6();
    double d2 = paramGeoPoint.getLatitudeE6();
    ((a)localObject).b = d2;
    a locala = new a();
    double d1 = ((a)localObject).a;
    locala.a = d1;
    if (d1 > 20037508.342D) {}
    for (d1 = d1 - 20037508.342D - 20037508.342D;; d1 = 20037508.342D - (-20037508.342D - d1))
    {
      locala.a = d1;
      break;
      if (d1 >= -20037508.342D) {
        break;
      }
    }
    locala.b = d2;
    d1 = 1.0E-006D;
    if ((d2 < 1.0E-006D) && (d2 >= 0.0D)) {}
    do
    {
      locala.b = d1;
      break label193;
      if (d2 >= 0.0D) {
        break;
      }
      d1 = -1.0E-006D;
    } while (d2 > -1.0E-006D);
    if (d2 > 20037508.342D) {
      locala.b = 20037508.342D;
    } else if (d2 < -20037508.342D) {
      locala.b = -20037508.342D;
    }
    label193:
    localObject = new double[10];
    int i = 0;
    for (;;)
    {
      paramGeoPoint = (GeoPoint)localObject;
      if (i >= 6) {
        break;
      }
      if (Math.abs(locala.b) > a[i])
      {
        paramGeoPoint = c[i];
        break;
      }
      i += 1;
    }
    paramGeoPoint = a(locala, paramGeoPoint);
    return new LatLng(paramGeoPoint.b, paramGeoPoint.a);
  }
  
  public static LatLng a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("strkey", paramString);
      JNITools.TransGeoStr2Pt(localBundle);
      paramString = new GeoPoint(0, 0);
      paramString.setLongitudeE6(localBundle.getInt("ptx"));
      paramString.setLatitudeE6(localBundle.getInt("pty"));
      return a(paramString);
    }
    return null;
  }
  
  static a a(a parama, double[] paramArrayOfDouble)
  {
    a locala = new a();
    double d1 = paramArrayOfDouble[0];
    int j = 1;
    locala.a = (d1 + paramArrayOfDouble[1] * Math.abs(parama.a));
    d1 = Math.abs(parama.b) / paramArrayOfDouble[9];
    d1 = paramArrayOfDouble[2] + paramArrayOfDouble[3] * d1 + paramArrayOfDouble[4] * d1 * d1 + paramArrayOfDouble[5] * d1 * d1 * d1 + paramArrayOfDouble[6] * d1 * d1 * d1 * d1 + paramArrayOfDouble[7] * d1 * d1 * d1 * d1 * d1 + paramArrayOfDouble[8] * d1 * d1 * d1 * d1 * d1 * d1;
    locala.b = d1;
    double d2 = locala.a;
    if (parama.a < 0.0D) {
      i = -1;
    } else {
      i = 1;
    }
    locala.a = (d2 * i);
    int i = j;
    if (parama.b < 0.0D) {
      i = -1;
    }
    locala.b = (d1 * i);
    return locala;
  }
  
  public static GeoPoint a(LatLng paramLatLng)
  {
    a locala = new a();
    double[] arrayOfDouble2 = new double[10];
    double d1 = Math.abs(paramLatLng.latitude * 1000000.0D);
    locala.b = d1;
    if (d1 < 0.1D) {
      locala.b = 0.1D;
    }
    int i = 0;
    double[] arrayOfDouble1;
    for (;;)
    {
      double[] arrayOfDouble3 = b;
      arrayOfDouble1 = arrayOfDouble2;
      if (i >= arrayOfDouble3.length) {
        break;
      }
      if (locala.b > arrayOfDouble3[i])
      {
        arrayOfDouble1 = d[i];
        break;
      }
      i += 1;
    }
    locala.a = paramLatLng.longitude;
    locala.b = paramLatLng.latitude;
    paramLatLng = a(locala, arrayOfDouble1);
    return new GeoPoint(paramLatLng.b, paramLatLng.a);
  }
  
  public static Point b(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    JNITools.CoordinateEncryptMc((float)paramLatLng.longitude, (float)paramLatLng.latitude, localBundle);
    paramLatLng = new Point(0, 0);
    paramLatLng.setIntX((int)localBundle.getDouble("x"));
    paramLatLng.setIntY((int)localBundle.getDouble("y"));
    return paramLatLng;
  }
  
  public static List<LatLng> b(String paramString)
  {
    paramString = com.baidu.mapsdkplatform.comjni.tools.a.a(paramString);
    ArrayList localArrayList1 = new ArrayList();
    if (paramString != null)
    {
      paramString = paramString.d;
      if (paramString != null)
      {
        if (paramString.size() > 0)
        {
          int i = 0;
          ArrayList localArrayList2 = (ArrayList)paramString.get(0);
          while (i < localArrayList2.size())
          {
            paramString = (Point)localArrayList2.get(i);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
              paramString = CoordTrans.baiduToGcj(a(new GeoPoint(paramString.getDoubleY() / 100.0D, paramString.getDoubleX() / 100.0D)));
            } else {
              paramString = a(new GeoPoint(paramString.getDoubleY() / 100.0D, paramString.getDoubleX() / 100.0D));
            }
            localArrayList1.add(paramString);
            i += 1;
          }
        }
        return localArrayList1;
      }
    }
    return null;
  }
  
  public static List<List<LatLng>> c(String paramString)
  {
    paramString = com.baidu.mapsdkplatform.comjni.tools.a.a(paramString);
    if (paramString != null)
    {
      paramString = paramString.d;
      if (paramString != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator1 = paramString.iterator();
        while (localIterator1.hasNext())
        {
          paramString = (ArrayList)localIterator1.next();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator2 = paramString.iterator();
          while (localIterator2.hasNext())
          {
            paramString = (Point)localIterator2.next();
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
              paramString = CoordTrans.baiduToGcj(a(new GeoPoint(paramString.getDoubleY() / 100.0D, paramString.getDoubleX() / 100.0D)));
            } else {
              paramString = a(new GeoPoint(paramString.getDoubleY() / 100.0D, paramString.getDoubleX() / 100.0D));
            }
            localArrayList2.add(paramString);
          }
          localArrayList1.add(localArrayList2);
        }
        return localArrayList1;
      }
    }
    return null;
  }
  
  public static LatLng d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("strkey", paramString);
      JNITools.TransNodeStr2Pt(localBundle);
      return a(new GeoPoint(localBundle.getDouble("pty"), localBundle.getDouble("ptx")));
    }
    return null;
  }
  
  static class a
  {
    double a;
    double b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.b
 * JD-Core Version:    0.7.0.1
 */