package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class CoachInfo
  extends TransitBaseInfo
{
  public static final Parcelable.Creator<CoachInfo> CREATOR = new a();
  private double f;
  private String g;
  private String h;
  private String i;
  
  public CoachInfo() {}
  
  protected CoachInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.f = paramParcel.readDouble();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBooking()
  {
    return this.g;
  }
  
  public double getPrice()
  {
    return this.f;
  }
  
  public String getProviderName()
  {
    return this.h;
  }
  
  public String getProviderUrl()
  {
    return this.i;
  }
  
  public void setBooking(String paramString)
  {
    this.g = paramString;
  }
  
  public void setPrice(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void setProviderName(String paramString)
  {
    this.h = paramString;
  }
  
  public void setProviderUrl(String paramString)
  {
    this.i = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeDouble(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
  
  class a
    implements Parcelable.Creator<CoachInfo>
  {
    public CoachInfo a(Parcel paramParcel)
    {
      return new CoachInfo(paramParcel);
    }
    
    public CoachInfo[] a(int paramInt)
    {
      return new CoachInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.CoachInfo
 * JD-Core Version:    0.7.0.1
 */