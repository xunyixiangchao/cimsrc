package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PriceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PriceInfo> CREATOR = new a();
  private int a;
  private double b;
  
  public PriceInfo() {}
  
  protected PriceInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double getTicketPrice()
  {
    return this.b;
  }
  
  public int getTicketType()
  {
    return this.a;
  }
  
  public void setTicketPrice(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void setTicketType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeDouble(this.b);
  }
  
  class a
    implements Parcelable.Creator<PriceInfo>
  {
    public PriceInfo a(Parcel paramParcel)
    {
      return new PriceInfo(paramParcel);
    }
    
    public PriceInfo[] a(int paramInt)
    {
      return new PriceInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.PriceInfo
 * JD-Core Version:    0.7.0.1
 */