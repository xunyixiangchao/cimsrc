package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PlaneInfo
  extends TransitBaseInfo
{
  public static final Parcelable.Creator<PlaneInfo> CREATOR = new a();
  private double f;
  private String g;
  private double h;
  private String i;
  
  public PlaneInfo() {}
  
  protected PlaneInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.f = paramParcel.readDouble();
    this.g = paramParcel.readString();
    this.h = paramParcel.readDouble();
    this.i = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAirlines()
  {
    return this.g;
  }
  
  public String getBooking()
  {
    return this.i;
  }
  
  public double getDiscount()
  {
    return this.f;
  }
  
  public double getPrice()
  {
    return this.h;
  }
  
  public void setAirlines(String paramString)
  {
    this.g = paramString;
  }
  
  public void setBooking(String paramString)
  {
    this.i = paramString;
  }
  
  public void setDiscount(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void setPrice(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeDouble(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeDouble(this.h);
    paramParcel.writeString(this.i);
  }
  
  class a
    implements Parcelable.Creator<PlaneInfo>
  {
    public PlaneInfo a(Parcel paramParcel)
    {
      return new PlaneInfo(paramParcel);
    }
    
    public PlaneInfo[] a(int paramInt)
    {
      return new PlaneInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.PlaneInfo
 * JD-Core Version:    0.7.0.1
 */