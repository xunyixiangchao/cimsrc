package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherSearchRealTime
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherSearchRealTime> CREATOR = new a();
  private int a;
  private int b;
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private int h;
  private float i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private float q;
  
  public WeatherSearchRealTime() {}
  
  protected WeatherSearchRealTime(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAirQualityIndex()
  {
    return this.o;
  }
  
  public float getCO()
  {
    return this.q;
  }
  
  public int getClouds()
  {
    return this.h;
  }
  
  public float getHourlyPrecipitation()
  {
    return this.i;
  }
  
  public int getNO2()
  {
    return this.m;
  }
  
  public int getO3()
  {
    return this.k;
  }
  
  public int getPM10()
  {
    return this.p;
  }
  
  public int getPM2_5()
  {
    return this.l;
  }
  
  public String getPhenomenon()
  {
    return this.c;
  }
  
  public int getRelativeHumidity()
  {
    return this.a;
  }
  
  public int getSO2()
  {
    return this.n;
  }
  
  public int getSensoryTemp()
  {
    return this.b;
  }
  
  public int getTemperature()
  {
    return this.f;
  }
  
  public String getUpdateTime()
  {
    return this.e;
  }
  
  public int getVisibility()
  {
    return this.j;
  }
  
  public String getWindDirection()
  {
    return this.d;
  }
  
  public String getWindPower()
  {
    return this.g;
  }
  
  public void setAirQualityIndex(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setCO(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void setClouds(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setHourlyPrecipitation(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setNO2(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setO3(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setPM10(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setPM2_5(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setPhenomenon(String paramString)
  {
    this.c = paramString;
  }
  
  public void setRelativeHumidity(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setSO2(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setSensoryTemp(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTemperature(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setUpdateTime(String paramString)
  {
    this.e = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setWindDirection(String paramString)
  {
    this.d = paramString;
  }
  
  public void setWindPower(String paramString)
  {
    this.g = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
  
  class a
    implements Parcelable.Creator<WeatherSearchRealTime>
  {
    public WeatherSearchRealTime a(Parcel paramParcel)
    {
      return new WeatherSearchRealTime(paramParcel);
    }
    
    public WeatherSearchRealTime[] a(int paramInt)
    {
      return new WeatherSearchRealTime[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchRealTime
 * JD-Core Version:    0.7.0.1
 */