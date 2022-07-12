package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherLifeIndexes
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherLifeIndexes> CREATOR = new a();
  private String a;
  private String b;
  private String c;
  
  public WeatherLifeIndexes() {}
  
  protected WeatherLifeIndexes(Parcel paramParcel)
  {
    setName(paramParcel.readString());
    setBrief(paramParcel.readString());
    setDetail(paramParcel.readString());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBrief()
  {
    return this.b;
  }
  
  public String getDetail()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void setBrief(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDetail(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getName());
    paramParcel.writeString(getBrief());
    paramParcel.writeString(getDetail());
  }
  
  class a
    implements Parcelable.Creator<WeatherLifeIndexes>
  {
    public WeatherLifeIndexes a(Parcel paramParcel)
    {
      return new WeatherLifeIndexes(paramParcel);
    }
    
    public WeatherLifeIndexes[] a(int paramInt)
    {
      return new WeatherLifeIndexes[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherLifeIndexes
 * JD-Core Version:    0.7.0.1
 */