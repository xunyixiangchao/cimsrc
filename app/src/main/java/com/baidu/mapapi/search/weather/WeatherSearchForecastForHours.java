package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherSearchForecastForHours
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherSearchForecastForHours> CREATOR = new a();
  private int a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private String g;
  private int h;
  
  public WeatherSearchForecastForHours() {}
  
  protected WeatherSearchForecastForHours(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getClouds()
  {
    return this.f;
  }
  
  public String getDataTime()
  {
    return this.b;
  }
  
  public int getHourlyPrecipitation()
  {
    return this.h;
  }
  
  public String getPhenomenon()
  {
    return this.g;
  }
  
  public int getRelativeHumidity()
  {
    return this.a;
  }
  
  public int getTemperature()
  {
    return this.e;
  }
  
  public String getWindDirection()
  {
    return this.c;
  }
  
  public String getWindPower()
  {
    return this.d;
  }
  
  public void setClouds(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setDataTime(String paramString)
  {
    this.b = paramString;
  }
  
  public void setHourlyPrecipitation(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setPhenomenon(String paramString)
  {
    this.g = paramString;
  }
  
  public void setRelativeHumidity(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setTemperature(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWindDirection(String paramString)
  {
    this.c = paramString;
  }
  
  public void setWindPower(String paramString)
  {
    this.d = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
  }
  
  class a
    implements Parcelable.Creator<WeatherSearchForecastForHours>
  {
    public WeatherSearchForecastForHours a(Parcel paramParcel)
    {
      return new WeatherSearchForecastForHours(paramParcel);
    }
    
    public WeatherSearchForecastForHours[] a(int paramInt)
    {
      return new WeatherSearchForecastForHours[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchForecastForHours
 * JD-Core Version:    0.7.0.1
 */