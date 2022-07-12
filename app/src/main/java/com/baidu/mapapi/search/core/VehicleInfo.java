package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VehicleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VehicleInfo> CREATOR = new a();
  private String a;
  private int b;
  private String c;
  private int d;
  private int e;
  
  public VehicleInfo() {}
  
  protected VehicleInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getPassStationNum()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  public int getTotalPrice()
  {
    return this.e;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public int getZonePrice()
  {
    return this.d;
  }
  
  public void setPassStationNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTotalPrice(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setZonePrice(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
  
  class a
    implements Parcelable.Creator<VehicleInfo>
  {
    public VehicleInfo a(Parcel paramParcel)
    {
      return new VehicleInfo(paramParcel);
    }
    
    public VehicleInfo[] a(int paramInt)
    {
      return new VehicleInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.VehicleInfo
 * JD-Core Version:    0.7.0.1
 */