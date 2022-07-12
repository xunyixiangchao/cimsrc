package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherSearchForecasts
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherSearchForecasts> CREATOR = new a();
  private String a;
  private String b;
  private int c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private int k;
  
  public WeatherSearchForecasts() {}
  
  protected WeatherSearchForecasts(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAirQualityIndex()
  {
    return this.k;
  }
  
  public String getDate()
  {
    return this.a;
  }
  
  public int getHighestTemp()
  {
    return this.d;
  }
  
  public int getLowestTemp()
  {
    return this.c;
  }
  
  public String getPhenomenonDay()
  {
    return this.i;
  }
  
  public String getPhenomenonNight()
  {
    return this.j;
  }
  
  public String getWeek()
  {
    return this.b;
  }
  
  public String getWindDirectionDay()
  {
    return this.g;
  }
  
  public String getWindDirectionNight()
  {
    return this.h;
  }
  
  public String getWindPowerDay()
  {
    return this.e;
  }
  
  public String getWindPowerNight()
  {
    return this.f;
  }
  
  public void setAirQualityIndex(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setDate(String paramString)
  {
    this.a = paramString;
  }
  
  public void setHighestTemp(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setLowestTemp(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPhenomenonDay(String paramString)
  {
    this.i = paramString;
  }
  
  public void setPhenomenonNight(String paramString)
  {
    this.j = paramString;
  }
  
  public void setWeek(String paramString)
  {
    this.b = paramString;
  }
  
  public void setWindDirectionDay(String paramString)
  {
    this.g = paramString;
  }
  
  public void setWindDirectionNight(String paramString)
  {
    this.h = paramString;
  }
  
  public void setWindPowerDay(String paramString)
  {
    this.e = paramString;
  }
  
  public void setWindPowerNight(String paramString)
  {
    this.f = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
  }
  
  class a
    implements Parcelable.Creator<WeatherSearchForecasts>
  {
    public WeatherSearchForecasts a(Parcel paramParcel)
    {
      return new WeatherSearchForecasts(paramParcel);
    }
    
    public WeatherSearchForecasts[] a(int paramInt)
    {
      return new WeatherSearchForecasts[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchForecasts
 * JD-Core Version:    0.7.0.1
 */