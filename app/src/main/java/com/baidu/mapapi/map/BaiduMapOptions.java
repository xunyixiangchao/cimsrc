package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.q;

public final class BaiduMapOptions
  implements Parcelable
{
  public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new a();
  MapStatus a = new MapStatus(0.0F, new LatLng(39.914935D, 116.403119D), 0.0F, 12.0F, null, null);
  boolean b;
  int c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  LogoPosition j;
  Point k;
  Point l;
  
  public BaiduMapOptions()
  {
    this.b = false;
    this.c = 1;
    this.d = true;
    this.e = true;
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = true;
  }
  
  protected BaiduMapOptions(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = false;
    this.c = 1;
    this.d = true;
    this.e = true;
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = true;
    this.a = ((MapStatus)paramParcel.readParcelable(MapStatus.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    this.c = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.i = bool1;
    this.k = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
    this.l = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
  }
  
  q a()
  {
    return new q().a(this.a.a()).a(this.b).a(this.c).c(this.d).d(this.e).b(this.f).e(this.g);
  }
  
  public BaiduMapOptions compassEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BaiduMapOptions logoPosition(LogoPosition paramLogoPosition)
  {
    this.j = paramLogoPosition;
    return this;
  }
  
  public BaiduMapOptions mapStatus(MapStatus paramMapStatus)
  {
    if (paramMapStatus != null) {
      this.a = paramMapStatus;
    }
    return this;
  }
  
  public BaiduMapOptions mapType(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public BaiduMapOptions overlookingGesturesEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions scaleControlEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions scaleControlPosition(Point paramPoint)
  {
    this.k = paramPoint;
    return this;
  }
  
  public BaiduMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeParcelable(this.k, paramInt);
    paramParcel.writeParcelable(this.l, paramInt);
  }
  
  public BaiduMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions zoomControlsPosition(Point paramPoint)
  {
    this.l = paramPoint;
    return this;
  }
  
  public BaiduMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  static final class a
    implements Parcelable.Creator<BaiduMapOptions>
  {
    public BaiduMapOptions a(Parcel paramParcel)
    {
      return new BaiduMapOptions(paramParcel);
    }
    
    public BaiduMapOptions[] a(int paramInt)
    {
      return new BaiduMapOptions[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.BaiduMapOptions
 * JD-Core Version:    0.7.0.1
 */