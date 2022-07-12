package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public final class Polyline
  extends Overlay
{
  int e;
  List<LatLng> f;
  int[] g;
  int[] h;
  int i = 5;
  boolean j = false;
  boolean k = false;
  boolean l = true;
  boolean m = true;
  BitmapDescriptor n;
  List<BitmapDescriptor> o;
  int p = 0;
  boolean q = true;
  boolean r = false;
  boolean s = false;
  PolylineOptions.LineCapType t = PolylineOptions.LineCapType.LineCapButt;
  PolylineOptions.LineJoinType u = PolylineOptions.LineJoinType.LineJoinRound;
  PolylineOptions.LineDirectionCross180 v = PolylineOptions.LineDirectionCross180.NONE;
  
  Polyline()
  {
    this.type = e.i;
  }
  
  private Bundle a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      String str;
      if (this.p == 1) {
        str = "CircleDashTexture.png";
      } else {
        str = "lineDashTexture.png";
      }
      if (paramString == null) {
        paramString = str;
      }
      paramString = BitmapDescriptorFactory.fromAsset(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return this.n.a();
  }
  
  private static void a(List<LatLng> paramList, PolylineOptions.LineDirectionCross180 paramLineDirectionCross180, Bundle paramBundle)
  {
    int i2 = paramList.size();
    double[] arrayOfDouble1 = new double[i2];
    double[] arrayOfDouble2 = new double[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      LatLng localLatLng = (LatLng)paramList.get(i1);
      double d;
      if (paramLineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST)
      {
        d = localLatLng.longitude;
        if (d >= 0.0D) {}
      }
      for (Object localObject = new LatLng(localLatLng.latitude, d + 360.0D);; localObject = new LatLng(localLatLng.latitude, d - 360.0D))
      {
        break;
        localObject = localLatLng;
        if (paramLineDirectionCross180 != PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST) {
          break;
        }
        d = localLatLng.longitude;
        localObject = localLatLng;
        if (d <= 0.0D) {
          break;
        }
      }
      localObject = CoordUtil.ll2mc((LatLng)localObject);
      arrayOfDouble1[i1] = ((GeoPoint)localObject).getLongitudeE6();
      arrayOfDouble2[i1] = ((GeoPoint)localObject).getLatitudeE6();
      i1 += 1;
    }
    paramBundle.putDoubleArray("x_array", arrayOfDouble1);
    paramBundle.putDoubleArray("y_array", arrayOfDouble2);
  }
  
  private static void a(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      paramBundle.putIntArray("color_array", paramArrayOfInt);
      paramBundle.putInt("total", 1);
    }
  }
  
  private Bundle b(Bundle paramBundle)
  {
    int[] arrayOfInt1 = this.h;
    if (arrayOfInt1 != null)
    {
      if (arrayOfInt1.length != 0)
      {
        b(arrayOfInt1, paramBundle);
        a(this.f, this.v, paramBundle);
        int i2 = this.h.length;
        arrayOfInt1 = new int[i2];
        int i1 = 0;
        while (i1 < i2)
        {
          arrayOfInt1[i1] = i1;
          i1 += 1;
        }
        i1 = this.f.size();
        int[] arrayOfInt2 = this.h;
        if (i1 == arrayOfInt2.length) {
          arrayOfInt1[(arrayOfInt2.length - 1)] = (arrayOfInt2.length - 2);
        }
        c(arrayOfInt1, paramBundle);
        return paramBundle;
      }
      throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
    }
    throw new IllegalStateException("BDMapSDKException: colors array can not be null");
  }
  
  private Bundle b(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("total", 1);
      if (this.p == 1) {
        localObject = "CircleDashTexture.png";
      } else {
        localObject = "lineDashTexture.png";
      }
      if (paramString == null) {
        paramString = (String)localObject;
      }
      paramString = BitmapDescriptorFactory.fromAsset(paramString);
      if (paramString != null) {
        localBundle.putBundle("texture_0", paramString.a());
      }
      return localBundle;
    }
    paramString = new Bundle();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.o.size(); i2 = i3)
    {
      i3 = i2;
      if (this.o.get(i1) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("texture_");
        ((StringBuilder)localObject).append(String.valueOf(i2));
        paramString.putBundle(((StringBuilder)localObject).toString(), ((BitmapDescriptor)this.o.get(i1)).a());
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    paramString.putInt("total", i2);
    return paramString;
  }
  
  private static void b(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramBundle.putIntArray("color_array", paramArrayOfInt);
    }
  }
  
  private static void c(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramBundle.putIntArray("color_indexs", paramArrayOfInt);
    }
  }
  
  private static void d(int[] paramArrayOfInt, Bundle paramBundle)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramBundle.putIntArray("traffic_array", paramArrayOfInt);
    }
  }
  
  Bundle a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int getColor()
  {
    return this.e;
  }
  
  public int[] getColorList()
  {
    return this.h;
  }
  
  public int getDottedLineType()
  {
    return this.p;
  }
  
  public PolylineOptions.LineCapType getLineCapType()
  {
    return this.t;
  }
  
  public PolylineOptions.LineDirectionCross180 getLineDirectionCross180()
  {
    return this.v;
  }
  
  public PolylineOptions.LineJoinType getLineJoinType()
  {
    return this.u;
  }
  
  public List<LatLng> getPoints()
  {
    return this.f;
  }
  
  public BitmapDescriptor getTexture()
  {
    return this.n;
  }
  
  public int getWidth()
  {
    return this.i;
  }
  
  public boolean isClickable()
  {
    return this.m;
  }
  
  public boolean isDottedLine()
  {
    return this.j;
  }
  
  public boolean isFocus()
  {
    return this.k;
  }
  
  public boolean isGeodesic()
  {
    return this.r;
  }
  
  public boolean isGradient()
  {
    return this.s;
  }
  
  public boolean isIsKeepScale()
  {
    return this.l;
  }
  
  public boolean isThined()
  {
    return this.q;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.listener.c(this);
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
    this.listener.c(this);
  }
  
  public void setColorList(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      this.h = paramArrayOfInt;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
  }
  
  public void setDottedLine(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.listener.c(this);
  }
  
  public void setDottedLineType(PolylineDottedLineType paramPolylineDottedLineType)
  {
    this.p = paramPolylineDottedLineType.ordinal();
    this.listener.c(this);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.listener.c(this);
  }
  
  public void setGeodesic(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.listener.c(this);
  }
  
  public void setGradient(boolean paramBoolean)
  {
    this.s = paramBoolean;
    this.listener.c(this);
  }
  
  public void setIndexs(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      this.g = paramArrayOfInt;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
  }
  
  public void setIsKeepScale(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setLineCapType(PolylineOptions.LineCapType paramLineCapType)
  {
    this.t = paramLineCapType;
    this.listener.c(this);
  }
  
  public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 paramLineDirectionCross180)
  {
    this.v = paramLineDirectionCross180;
  }
  
  public void setLineJoinType(PolylineOptions.LineJoinType paramLineJoinType)
  {
    this.u = paramLineJoinType;
    this.listener.c(this);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2)
      {
        if (!paramList.contains(null))
        {
          this.f = paramList;
          this.listener.c(this);
          return;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public void setTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.n = paramBitmapDescriptor;
    this.listener.c(this);
  }
  
  public void setTextureList(List<BitmapDescriptor> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.o = paramList;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
  }
  
  public void setThined(boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.listener.c(this);
  }
  
  public void setWidth(int paramInt)
  {
    if (paramInt > 0)
    {
      this.i = paramInt;
      this.listener.c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Polyline
 * JD-Core Version:    0.7.0.1
 */