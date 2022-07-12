package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.List;

public final class LatLngBounds
  implements Parcelable
{
  public static final Parcelable.Creator<LatLngBounds> CREATOR = new a();
  public final LatLng northeast;
  public final LatLng southwest;
  
  protected LatLngBounds(Parcel paramParcel)
  {
    this.northeast = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.southwest = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
  }
  
  LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.northeast = paramLatLng1;
    this.southwest = paramLatLng2;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return false;
    }
    LatLng localLatLng1 = this.southwest;
    double d1 = localLatLng1.latitude;
    LatLng localLatLng2 = this.northeast;
    double d2 = localLatLng2.latitude;
    double d3 = localLatLng1.longitude;
    double d4 = localLatLng2.longitude;
    double d5 = paramLatLng.latitude;
    double d6 = paramLatLng.longitude;
    return (d5 >= d1) && (d5 <= d2) && (d6 >= d3) && (d6 <= d4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getCenter()
  {
    LatLng localLatLng1 = this.northeast;
    double d2 = localLatLng1.latitude;
    LatLng localLatLng2 = this.southwest;
    double d1 = localLatLng2.latitude;
    d2 = (d2 - d1) / 2.0D;
    double d3 = localLatLng1.longitude;
    double d4 = localLatLng2.longitude;
    return new LatLng(d2 + d1, (d3 - d4) / 2.0D + d4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("southwest: ");
    localStringBuilder.append(this.southwest.latitude);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.southwest.longitude);
    localStringBuilder.append("\n");
    localStringBuilder.append("northeast: ");
    localStringBuilder.append(this.northeast.latitude);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.northeast.longitude);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.northeast, paramInt);
    paramParcel.writeParcelable(this.southwest, paramInt);
  }
  
  public static final class Builder
  {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private boolean g = true;
    
    private void a(LatLng paramLatLng)
    {
      if (paramLatLng == null) {
        return;
      }
      double d1 = paramLatLng.latitude;
      double d2 = paramLatLng.longitude;
      if (d1 < this.a) {
        this.a = d1;
      }
      if (d1 > this.b) {
        this.b = d1;
      }
      boolean bool = d2 < 0.0D;
      if (!bool)
      {
        if (d2 < this.c) {
          this.c = d2;
        }
        if (d2 > this.d)
        {
          this.d = d2;
          if (this.c == 0.0D) {
            this.c = d2;
          }
        }
        if (bool) {
          return;
        }
      }
      else
      {
        if (d2 < this.f) {
          this.f = d2;
        }
        if (d2 <= this.e) {
          return;
        }
      }
      this.e = d2;
    }
    
    public LatLngBounds build()
    {
      double d2 = this.e;
      if ((d2 != 0.0D) || (this.f != 0.0D))
      {
        d1 = this.d;
        if ((d1 == 0.0D) && (this.c == 0.0D))
        {
          this.d = d2;
          this.c = this.f;
        }
        else
        {
          d2 = this.f + 360.0D;
          this.c = d2;
          if (d2 > d1)
          {
            this.d = d2;
            this.c = d1;
          }
        }
      }
      double d1 = this.d;
      if (d1 > 180.0D)
      {
        d1 -= 360.0D;
        this.d = d1;
        d2 = this.c;
        if (d1 < d2)
        {
          this.d = d2;
          this.c = d1;
        }
      }
      return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.a, this.c));
    }
    
    public Builder include(LatLng paramLatLng)
    {
      if (paramLatLng == null) {
        return this;
      }
      if (this.g)
      {
        this.g = false;
        double d1 = paramLatLng.longitude;
        if (d1 >= 0.0D)
        {
          this.c = d1;
          this.d = d1;
        }
        else
        {
          this.f = d1;
          this.e = d1;
        }
        d1 = paramLatLng.latitude;
        this.a = d1;
        this.b = d1;
      }
      a(paramLatLng);
      return this;
    }
    
    public Builder include(List<LatLng> paramList)
    {
      if (paramList != null)
      {
        if (paramList.size() == 0) {
          return this;
        }
        if ((paramList.get(0) != null) && (this.g))
        {
          this.g = false;
          if (((LatLng)paramList.get(0)).longitude >= 0.0D)
          {
            d1 = ((LatLng)paramList.get(0)).longitude;
            this.c = d1;
            this.d = d1;
          }
          else
          {
            d1 = ((LatLng)paramList.get(0)).longitude;
            this.f = d1;
            this.e = d1;
          }
          double d1 = ((LatLng)paramList.get(0)).latitude;
          this.a = d1;
          this.b = d1;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a((LatLng)paramList.next());
        }
      }
      return this;
    }
  }
  
  static final class a
    implements Parcelable.Creator<LatLngBounds>
  {
    public LatLngBounds a(Parcel paramParcel)
    {
      return new LatLngBounds(paramParcel);
    }
    
    public LatLngBounds[] a(int paramInt)
    {
      return new LatLngBounds[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */