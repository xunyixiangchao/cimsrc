package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CityInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CityInfo> CREATOR = new a();
  public String city;
  public int num;
  
  public CityInfo() {}
  
  protected CityInfo(Parcel paramParcel)
  {
    this.city = paramParcel.readString();
    this.num = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.city);
    paramParcel.writeInt(this.num);
  }
  
  class a
    implements Parcelable.Creator<CityInfo>
  {
    public CityInfo a(Parcel paramParcel)
    {
      return new CityInfo(paramParcel);
    }
    
    public CityInfo[] a(int paramInt)
    {
      return new CityInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.CityInfo
 * JD-Core Version:    0.7.0.1
 */