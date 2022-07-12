package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherSearchLocation
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherSearchLocation> CREATOR = new a();
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public WeatherSearchLocation() {}
  
  protected WeatherSearchLocation(Parcel paramParcel)
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
  
  public String getCity()
  {
    return this.c;
  }
  
  public String getCountry()
  {
    return this.a;
  }
  
  public String getDistrictID()
  {
    return this.e;
  }
  
  public String getDistrictName()
  {
    return this.d;
  }
  
  public String getProvince()
  {
    return this.b;
  }
  
  public void setCity(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.a = paramString;
  }
  
  public void setDistrictID(String paramString)
  {
    this.e = paramString;
  }
  
  public void setDistrictName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setProvince(String paramString)
  {
    this.b = paramString;
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
    implements Parcelable.Creator<WeatherSearchLocation>
  {
    public WeatherSearchLocation a(Parcel paramParcel)
    {
      return new WeatherSearchLocation(paramParcel);
    }
    
    public WeatherSearchLocation[] a(int paramInt)
    {
      return new WeatherSearchLocation[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchLocation
 * JD-Core Version:    0.7.0.1
 */