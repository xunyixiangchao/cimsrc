package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  extends OverlayOptions
{
  private int a = -16777216;
  private List<LatLng> b;
  private List<Integer> c;
  private List<Integer> d;
  private int e = 5;
  private BitmapDescriptor f;
  private List<BitmapDescriptor> g;
  private boolean h = true;
  private boolean i = false;
  int j;
  boolean k = true;
  private boolean l = false;
  private boolean m = true;
  Bundle n;
  private int o = 0;
  private LineJoinType p = LineJoinType.LineJoinRound;
  private LineCapType q = LineCapType.LineCapButt;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private LineDirectionCross180 u = LineDirectionCross180.NONE;
  
  private Polyline a(Polyline paramPolyline)
  {
    paramPolyline.c = this.k;
    paramPolyline.v = this.u;
    paramPolyline.f = this.b;
    paramPolyline.s = this.t;
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new int[this.d.size()];
      int i1 = 0;
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localObject[i1] = ((Integer)localIterator.next()).intValue();
        i1 += 1;
      }
      paramPolyline.h = ((int[])localObject);
      return paramPolyline;
    }
    throw new IllegalStateException("BDMapSDKException: colors array can not be null");
  }
  
  Overlay a()
  {
    Polyline localPolyline = new Polyline();
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((List)localObject1).size() >= 2))
    {
      boolean bool = this.t;
      if (bool)
      {
        localPolyline.type = e.n;
        return a(localPolyline);
      }
      localPolyline.c = this.k;
      localPolyline.j = this.l;
      localPolyline.b = this.j;
      localPolyline.d = this.n;
      localPolyline.f = this.b;
      localPolyline.e = this.a;
      localPolyline.i = this.e;
      localPolyline.n = this.f;
      localPolyline.o = this.g;
      localPolyline.k = this.h;
      localPolyline.l = this.i;
      localPolyline.m = this.m;
      localPolyline.q = this.r;
      localPolyline.r = this.s;
      localPolyline.s = bool;
      localPolyline.p = this.o;
      localPolyline.u = this.p;
      localPolyline.t = this.q;
      localPolyline.v = this.u;
      localObject1 = this.c;
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() < this.b.size() - 1))
      {
        localObject1 = new ArrayList(this.b.size() - 1 - this.c.size());
        localObject2 = this.c;
        ((List)localObject2).addAll(((List)localObject2).size(), (Collection)localObject1);
      }
      localObject1 = this.c;
      int i2 = 0;
      int i1;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = new int[this.c.size()];
        localObject2 = this.c.iterator();
        i1 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i1] = ((Integer)((Iterator)localObject2).next()).intValue();
          i1 += 1;
        }
        localPolyline.g = ((int[])localObject1);
      }
      localObject1 = this.d;
      if ((localObject1 != null) && (((List)localObject1).size() < this.b.size() - 1))
      {
        localObject1 = new ArrayList(this.b.size() - 1 - this.d.size());
        localObject2 = this.d;
        ((List)localObject2).addAll(((List)localObject2).size(), (Collection)localObject1);
      }
      localObject1 = this.d;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = new int[this.d.size()];
        localObject2 = this.d.iterator();
        i1 = i2;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i1] = ((Integer)((Iterator)localObject2).next()).intValue();
          i1 += 1;
        }
        localPolyline.h = ((int[])localObject1);
      }
      return localPolyline;
    }
    throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
  }
  
  public PolylineOptions clickable(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public PolylineOptions colorsValues(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        this.d = paramList;
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
  }
  
  public PolylineOptions customTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.f = paramBitmapDescriptor;
    return this;
  }
  
  public PolylineOptions customTextureList(List<BitmapDescriptor> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if ((BitmapDescriptor)localIterator.next() == null) {
          Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
        }
      }
      this.g = paramList;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
  }
  
  public PolylineOptions dottedLine(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public PolylineOptions dottedLineType(PolylineDottedLineType paramPolylineDottedLineType)
  {
    this.o = paramPolylineDottedLineType.ordinal();
    return this;
  }
  
  public PolylineOptions extraInfo(Bundle paramBundle)
  {
    this.n = paramBundle;
    return this;
  }
  
  public PolylineOptions focus(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.a;
  }
  
  public BitmapDescriptor getCustomTexture()
  {
    return this.f;
  }
  
  public List<BitmapDescriptor> getCustomTextureList()
  {
    return this.g;
  }
  
  public Bundle getExtraInfo()
  {
    return this.n;
  }
  
  public List<LatLng> getPoints()
  {
    return this.b;
  }
  
  public List<Integer> getTextureIndexs()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.e;
  }
  
  public int getZIndex()
  {
    return this.j;
  }
  
  public boolean isDottedLine()
  {
    return this.l;
  }
  
  public boolean isFocus()
  {
    return this.h;
  }
  
  public PolylineOptions isGeodesic(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  public PolylineOptions isGradient(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public PolylineOptions isThined(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.k;
  }
  
  public PolylineOptions keepScale(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public PolylineOptions lineCapType(LineCapType paramLineCapType)
  {
    this.q = paramLineCapType;
    return this;
  }
  
  public PolylineOptions lineDirectionCross180(LineDirectionCross180 paramLineDirectionCross180)
  {
    this.u = paramLineDirectionCross180;
    return this;
  }
  
  public PolylineOptions lineJoinType(LineJoinType paramLineJoinType)
  {
    this.p = paramLineJoinType;
    return this;
  }
  
  public PolylineOptions points(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2)
      {
        if (!paramList.contains(null))
        {
          this.b = paramList;
          return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public PolylineOptions textureIndex(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        this.c = paramList;
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
    return this;
  }
  
  public PolylineOptions zIndex(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public static enum LineCapType
  {
    static
    {
      LineCapType localLineCapType1 = new LineCapType("LineCapButt", 0);
      LineCapButt = localLineCapType1;
      LineCapType localLineCapType2 = new LineCapType("LineCapRound", 1);
      LineCapRound = localLineCapType2;
      a = new LineCapType[] { localLineCapType1, localLineCapType2 };
    }
    
    private LineCapType() {}
  }
  
  public static enum LineDirectionCross180
  {
    static
    {
      LineDirectionCross180 localLineDirectionCross1801 = new LineDirectionCross180("NONE", 0);
      NONE = localLineDirectionCross1801;
      LineDirectionCross180 localLineDirectionCross1802 = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
      FROM_EAST_TO_WEST = localLineDirectionCross1802;
      LineDirectionCross180 localLineDirectionCross1803 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
      FROM_WEST_TO_EAST = localLineDirectionCross1803;
      a = new LineDirectionCross180[] { localLineDirectionCross1801, localLineDirectionCross1802, localLineDirectionCross1803 };
    }
    
    private LineDirectionCross180() {}
  }
  
  public static enum LineJoinType
  {
    static
    {
      LineJoinType localLineJoinType1 = new LineJoinType("LineJoinBevel", 0);
      LineJoinBevel = localLineJoinType1;
      LineJoinType localLineJoinType2 = new LineJoinType("LineJoinMiter", 1);
      LineJoinMiter = localLineJoinType2;
      LineJoinType localLineJoinType3 = new LineJoinType("LineJoinRound", 2);
      LineJoinRound = localLineJoinType3;
      LineJoinType localLineJoinType4 = new LineJoinType("LineJoinBerzier", 3);
      LineJoinBerzier = localLineJoinType4;
      a = new LineJoinType[] { localLineJoinType1, localLineJoinType2, localLineJoinType3, localLineJoinType4 };
    }
    
    private LineJoinType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */