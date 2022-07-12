package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LatLng
  implements Parcelable
{
  public static final Parcelable.Creator<LatLng> CREATOR = new a();
  public final double latitude;
  public final double latitudeE6;
  public final double longitude;
  public final double longitudeE6;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    if ((!Double.isNaN(paramDouble1)) && (!Double.isNaN(paramDouble2)) && (!Double.isInfinite(paramDouble1)) && (!Double.isInfinite(paramDouble2)))
    {
      paramDouble1 *= 1000000.0D;
      paramDouble2 *= 1000000.0D;
      this.latitudeE6 = paramDouble1;
      this.longitudeE6 = paramDouble2;
      this.latitude = (paramDouble1 / 1000000.0D);
      this.longitude = (paramDouble2 / 1000000.0D);
      return;
    }
    this.latitudeE6 = 0.0D;
    this.longitudeE6 = 0.0D;
    this.latitude = 0.0D;
    this.longitude = 0.0D;
  }
  
  protected LatLng(Parcel paramParcel)
  {
    this.latitude = paramParcel.readDouble();
    this.longitude = paramParcel.readDouble();
    this.latitudeE6 = paramParcel.readDouble();
    this.longitudeE6 = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str = new String("latitude: ");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.latitude);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(", longitude: ");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.longitude);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.latitudeE6);
    paramParcel.writeDouble(this.longitudeE6);
  }
  
  static final class a
    implements Parcelable.Creator<LatLng>
  {
    public LatLng a(Parcel paramParcel)
    {
      return new LatLng(paramParcel);
    }
    
    public LatLng[] a(int paramInt)
    {
      return new LatLng[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.model.LatLng
 * JD-Core Version:    0.7.0.1
 */