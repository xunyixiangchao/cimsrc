package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Overlay
{
  String a;
  int b;
  boolean c;
  Bundle d;
  protected a listener;
  public e type;
  
  protected Overlay()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
  }
  
  static void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("red", (paramInt >> 16 & 0xFF) / 255.0F);
    localBundle.putFloat("green", (paramInt >> 8 & 0xFF) / 255.0F);
    localBundle.putFloat("blue", (paramInt & 0xFF) / 255.0F);
    localBundle.putFloat("alpha", (paramInt >>> 24) / 255.0F);
    paramBundle.putBundle("color", localBundle);
  }
  
  private static boolean a(List<CircleHoleOptions> paramList, Bundle paramBundle)
  {
    int j = paramList.size();
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      Object localObject = ((CircleHoleOptions)paramList.get(i)).getHoleCenter();
      int k = ((CircleHoleOptions)paramList.get(i)).getHoleRadius();
      if (localObject != null)
      {
        if (k <= 0) {
          return false;
        }
        localObject = CoordUtil.ll2mc((LatLng)localObject);
        arrayOfDouble1[i] = ((GeoPoint)localObject).getLongitudeE6();
        arrayOfDouble2[i] = ((GeoPoint)localObject).getLatitudeE6();
        arrayOfInt[i] = k;
        i += 1;
      }
      else
      {
        return false;
      }
    }
    paramBundle.putDoubleArray("circle_hole_x_array", arrayOfDouble1);
    paramBundle.putDoubleArray("circle_hole_y_array", arrayOfDouble2);
    paramBundle.putIntArray("circle_hole_radius_array", arrayOfInt);
    return true;
  }
  
  static void b(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("red", (paramInt >> 16 & 0xFF) / 255.0F);
    localBundle.putFloat("green", (paramInt >> 8 & 0xFF) / 255.0F);
    localBundle.putFloat("blue", (paramInt & 0xFF) / 255.0F);
    localBundle.putFloat("alpha", (paramInt >>> 24) / 255.0F);
    paramBundle.putBundle("m_sideFaceColor", localBundle);
  }
  
  static boolean b(List<HoleOptions> paramList, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static void c(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("red", (paramInt >> 16 & 0xFF) / 255.0F);
    localBundle.putFloat("green", (paramInt >> 8 & 0xFF) / 255.0F);
    localBundle.putFloat("blue", (paramInt & 0xFF) / 255.0F);
    localBundle.putFloat("alpha", (paramInt >>> 24) / 255.0F);
    paramBundle.putBundle("m_topFaceColor", localBundle);
  }
  
  static void c(List<LatLng> paramList, Bundle paramBundle)
  {
    int j = paramList.size();
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    int i = 0;
    while (i < j)
    {
      GeoPoint localGeoPoint = CoordUtil.ll2mc((LatLng)paramList.get(i));
      arrayOfDouble1[i] = localGeoPoint.getLongitudeE6();
      arrayOfDouble2[i] = localGeoPoint.getLatitudeE6();
      i += 1;
    }
    paramBundle.putDoubleArray("x_array", arrayOfDouble1);
    paramBundle.putDoubleArray("y_array", arrayOfDouble2);
  }
  
  private static boolean d(List<PolygonHoleOptions> paramList, Bundle paramBundle)
  {
    int k = paramList.size();
    Object localObject1 = new int[k];
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = ((PolygonHoleOptions)paramList.get(i)).getHolePoints();
      if (localObject2 == null) {
        return false;
      }
      localArrayList.addAll((Collection)localObject2);
      localObject1[i] = ((List)localObject2).size();
      i += 1;
    }
    k = localArrayList.size();
    if (k == 0) {
      return false;
    }
    paramBundle.putIntArray("polygon_hole_count_array", (int[])localObject1);
    paramList = new double[k];
    localObject1 = new double[k];
    i = j;
    while (i < k)
    {
      localObject2 = CoordUtil.ll2mc((LatLng)localArrayList.get(i));
      paramList[i] = ((GeoPoint)localObject2).getLongitudeE6();
      localObject1[i] = ((GeoPoint)localObject2).getLatitudeE6();
      i += 1;
    }
    paramBundle.putDoubleArray("polygon_hole_x_array", paramList);
    paramBundle.putDoubleArray("polygon_hole_y_array", (double[])localObject1);
    return true;
  }
  
  Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", this.a);
    localBundle.putInt("type", this.type.ordinal());
    return localBundle;
  }
  
  Bundle a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Bundle getExtraInfo()
  {
    return this.d;
  }
  
  public int getZIndex()
  {
    return this.b;
  }
  
  public boolean isRemoved()
  {
    return this.listener.b(this);
  }
  
  public boolean isVisible()
  {
    return this.c;
  }
  
  public void remove()
  {
    this.listener.a(this);
  }
  
  public void setExtraInfo(Bundle paramBundle)
  {
    this.d = paramBundle;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.c = paramBoolean;
    this.listener.c(this);
  }
  
  public void setZIndex(int paramInt)
  {
    this.b = paramInt;
    this.listener.c(this);
  }
  
  static abstract interface a
  {
    public abstract void a(Overlay paramOverlay);
    
    public abstract boolean b(Overlay paramOverlay);
    
    public abstract void c(Overlay paramOverlay);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Overlay
 * JD-Core Version:    0.7.0.1
 */