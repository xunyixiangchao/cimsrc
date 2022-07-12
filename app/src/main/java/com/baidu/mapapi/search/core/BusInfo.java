package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BusInfo
  extends TransitBaseInfo
{
  public static final Parcelable.Creator<BusInfo> CREATOR = new a();
  private int f;
  private int g;
  
  public BusInfo() {}
  
  protected BusInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getStopNum()
  {
    return this.g;
  }
  
  public int getType()
  {
    return this.f;
  }
  
  public void setStopNum(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
  }
  
  class a
    implements Parcelable.Creator<BusInfo>
  {
    public BusInfo a(Parcel paramParcel)
    {
      return new BusInfo(paramParcel);
    }
    
    public BusInfo[] a(int paramInt)
    {
      return new BusInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.BusInfo
 * JD-Core Version:    0.7.0.1
 */