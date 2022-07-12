package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.s.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class MapStatus
  implements Parcelable
{
  public static final Parcelable.Creator<MapStatus> CREATOR = new a();
  private double a;
  private double b;
  public final LatLngBounds bound;
  s c;
  public final float overlook;
  public final float rotate;
  public final LatLng target;
  public final android.graphics.Point targetScreen;
  public WinRound winRound;
  public final float zoom;
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, double paramDouble1, double paramDouble2, LatLngBounds paramLatLngBounds)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.bound = paramLatLngBounds;
  }
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, LatLngBounds paramLatLngBounds)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    if (paramLatLng != null)
    {
      this.a = CoordUtil.ll2mc(paramLatLng).getLongitudeE6();
      this.b = CoordUtil.ll2mc(paramLatLng).getLatitudeE6();
    }
    this.bound = paramLatLngBounds;
  }
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, s params, double paramDouble1, double paramDouble2, LatLngBounds paramLatLngBounds, WinRound paramWinRound)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    this.c = params;
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.bound = paramLatLngBounds;
    this.winRound = paramWinRound;
  }
  
  protected MapStatus(Parcel paramParcel)
  {
    this.rotate = paramParcel.readFloat();
    this.target = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.overlook = paramParcel.readFloat();
    this.zoom = paramParcel.readFloat();
    this.targetScreen = ((android.graphics.Point)paramParcel.readParcelable(android.graphics.Point.class.getClassLoader()));
    this.bound = ((LatLngBounds)paramParcel.readParcelable(LatLngBounds.class.getClassLoader()));
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  static MapStatus a(s params)
  {
    if (params == null) {
      return null;
    }
    float f1 = params.b;
    double d1 = params.e;
    double d2 = params.d;
    LatLng localLatLng1 = CoordUtil.mc2ll(new GeoPoint(d1, d2));
    float f2 = params.c;
    float f3 = params.a;
    android.graphics.Point localPoint = new android.graphics.Point(params.f, params.g);
    Object localObject = CoordUtil.mc2ll(new GeoPoint(params.k.e.getDoubleY(), params.k.e.getDoubleX()));
    LatLng localLatLng2 = CoordUtil.mc2ll(new GeoPoint(params.k.f.getDoubleY(), params.k.f.getDoubleX()));
    LatLng localLatLng3 = CoordUtil.mc2ll(new GeoPoint(params.k.h.getDoubleY(), params.k.h.getDoubleX()));
    LatLng localLatLng4 = CoordUtil.mc2ll(new GeoPoint(params.k.g.getDoubleY(), params.k.g.getDoubleX()));
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include((LatLng)localObject);
    localBuilder.include(localLatLng2);
    localBuilder.include(localLatLng3);
    localBuilder.include(localLatLng4);
    localObject = params.j;
    return new MapStatus(f1, localLatLng1, f2, f3, localPoint, params, d2, d1, localBuilder.build(), (WinRound)localObject);
  }
  
  s a()
  {
    return b(new s());
  }
  
  double b()
  {
    return this.a;
  }
  
  s b(s params)
  {
    if (params == null) {
      return null;
    }
    float f = this.rotate;
    if (f != -2.147484E+009F) {
      params.b = ((int)f);
    }
    f = this.zoom;
    if (f != -2.147484E+009F) {
      params.a = f;
    }
    f = this.overlook;
    if (f != -2.147484E+009F) {
      params.c = ((int)f);
    }
    if (this.target != null)
    {
      params.d = this.a;
      params.e = this.b;
    }
    android.graphics.Point localPoint = this.targetScreen;
    if (localPoint != null)
    {
      params.f = localPoint.x;
      params.g = localPoint.y;
    }
    return params;
  }
  
  double c()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (this.target != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("target lat: ");
      localStringBuilder2.append(this.target.latitude);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("target lng: ");
      localStringBuilder2.append(this.target.longitude);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.targetScreen != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("target screen x: ");
      localStringBuilder2.append(this.targetScreen.x);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("target screen y: ");
      localStringBuilder2.append(this.targetScreen.y);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("zoom: ");
    localStringBuilder2.append(this.zoom);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("rotate: ");
    localStringBuilder2.append(this.rotate);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("overlook: ");
    localStringBuilder2.append(this.overlook);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.rotate);
    paramParcel.writeParcelable(this.target, paramInt);
    paramParcel.writeFloat(this.overlook);
    paramParcel.writeFloat(this.zoom);
    paramParcel.writeParcelable(this.targetScreen, paramInt);
    paramParcel.writeParcelable(this.bound, paramInt);
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
  
  public static final class Builder
  {
    private float a = -2.147484E+009F;
    private LatLng b = null;
    private float c = -2.147484E+009F;
    private float d = -2.147484E+009F;
    private android.graphics.Point e = null;
    private LatLngBounds f = null;
    
    public Builder() {}
    
    public Builder(MapStatus paramMapStatus)
    {
      this.a = paramMapStatus.rotate;
      this.b = paramMapStatus.target;
      this.c = paramMapStatus.overlook;
      this.d = paramMapStatus.zoom;
      this.e = paramMapStatus.targetScreen;
      paramMapStatus.b();
      paramMapStatus.c();
    }
    
    private float a(float paramFloat)
    {
      float f1 = paramFloat;
      if (15.0F == paramFloat) {
        f1 = 15.5F;
      }
      return f1;
    }
    
    public MapStatus build()
    {
      return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    public Builder overlook(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public Builder rotate(float paramFloat)
    {
      this.a = paramFloat;
      return this;
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.b = paramLatLng;
      return this;
    }
    
    public Builder targetScreen(android.graphics.Point paramPoint)
    {
      this.e = paramPoint;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.d = a(paramFloat);
      return this;
    }
  }
  
  static final class a
    implements Parcelable.Creator<MapStatus>
  {
    public MapStatus a(Parcel paramParcel)
    {
      return new MapStatus(paramParcel);
    }
    
    public MapStatus[] a(int paramInt)
    {
      return new MapStatus[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapStatus
 * JD-Core Version:    0.7.0.1
 */