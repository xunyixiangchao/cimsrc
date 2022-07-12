package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeatherSearchAlerts
  implements Parcelable
{
  public static final Parcelable.Creator<WeatherSearchAlerts> CREATOR = new a();
  private String a;
  private String b;
  private String c;
  private String d;
  
  public WeatherSearchAlerts() {}
  
  protected WeatherSearchAlerts(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDesc()
  {
    return this.d;
  }
  
  public String getLevel()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  public String getType()
  {
    return this.a;
  }
  
  public void setDesc(String paramString)
  {
    this.d = paramString;
  }
  
  public void setLevel(String paramString)
  {
    this.b = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
  
  public void setType(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
  
  class a
    implements Parcelable.Creator<WeatherSearchAlerts>
  {
    public WeatherSearchAlerts a(Parcel paramParcel)
    {
      return new WeatherSearchAlerts(paramParcel);
    }
    
    public WeatherSearchAlerts[] a(int paramInt)
    {
      return new WeatherSearchAlerts[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchAlerts
 * JD-Core Version:    0.7.0.1
 */