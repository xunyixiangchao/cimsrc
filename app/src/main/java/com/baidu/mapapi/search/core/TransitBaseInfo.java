package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransitBaseInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new a();
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public TransitBaseInfo() {}
  
  protected TransitBaseInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getArriveStation()
  {
    return this.c;
  }
  
  public String getArriveTime()
  {
    return this.e;
  }
  
  public String getDepartureStation()
  {
    return this.b;
  }
  
  public String getDepartureTime()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void setArriveStation(String paramString)
  {
    this.c = paramString;
  }
  
  public void setArriveTime(String paramString)
  {
    this.e = paramString;
  }
  
  public void setDepartureStation(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDepartureTime(String paramString)
  {
    this.d = paramString;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
  
  class a
    implements Parcelable.Creator<TransitBaseInfo>
  {
    public TransitBaseInfo a(Parcel paramParcel)
    {
      return new TransitBaseInfo(paramParcel);
    }
    
    public TransitBaseInfo[] a(int paramInt)
    {
      return new TransitBaseInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.TransitBaseInfo
 * JD-Core Version:    0.7.0.1
 */