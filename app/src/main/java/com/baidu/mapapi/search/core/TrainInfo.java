package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class TrainInfo
  extends TransitBaseInfo
{
  public static final Parcelable.Creator<TrainInfo> CREATOR = new a();
  private double f;
  private String g;
  
  public TrainInfo() {}
  
  protected TrainInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.f = paramParcel.readDouble();
    this.g = paramParcel.readString();
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
  
  public void setBooking(String paramString)
  {
    this.g = paramString;
  }
  
  public void setPrice(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeDouble(this.f);
    paramParcel.writeString(this.g);
  }
  
  class a
    implements Parcelable.Creator<TrainInfo>
  {
    public TrainInfo a(Parcel paramParcel)
    {
      return new TrainInfo(paramParcel);
    }
    
    public TrainInfo[] a(int paramInt)
    {
      return new TrainInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.TrainInfo
 * JD-Core Version:    0.7.0.1
 */