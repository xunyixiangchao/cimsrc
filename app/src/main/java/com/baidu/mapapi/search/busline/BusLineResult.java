package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.Date;
import java.util.List;

public class BusLineResult
  extends SearchResult
{
  public static final Parcelable.Creator<BusLineResult> CREATOR = new a();
  private String a = null;
  private String b = null;
  private boolean c;
  private Date d;
  private Date e;
  private String f;
  private List<BusStation> g = null;
  private List<BusStep> h = null;
  private float i;
  private float j;
  private String k = null;
  
  public BusLineResult() {}
  
  BusLineResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    this.d = ((Date)paramParcel.readValue(Date.class.getClassLoader()));
    this.e = ((Date)paramParcel.readValue(Date.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readArrayList(BusStation.class.getClassLoader());
    this.h = paramParcel.readArrayList(RouteStep.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getBasePrice()
  {
    return this.i;
  }
  
  public String getBusCompany()
  {
    return this.a;
  }
  
  public String getBusLineName()
  {
    return this.b;
  }
  
  public Date getEndTime()
  {
    return this.e;
  }
  
  public String getLineDirection()
  {
    return this.k;
  }
  
  public float getMaxPrice()
  {
    return this.j;
  }
  
  public Date getStartTime()
  {
    return this.d;
  }
  
  public List<BusStation> getStations()
  {
    return this.g;
  }
  
  public List<BusStep> getSteps()
  {
    return this.h;
  }
  
  public String getUid()
  {
    return this.f;
  }
  
  public boolean isMonthTicket()
  {
    return this.c;
  }
  
  public void setBasePrice(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setBusLineName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setEndTime(Date paramDate)
  {
    this.e = paramDate;
  }
  
  public void setLineDirection(String paramString)
  {
    this.k = paramString;
  }
  
  public void setMaxPrice(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void setMonthTicket(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setStartTime(Date paramDate)
  {
    this.d = paramDate;
  }
  
  public void setStations(List<BusStation> paramList)
  {
    this.g = paramList;
  }
  
  public void setSteps(List<BusStep> paramList)
  {
    this.h = paramList;
  }
  
  public void setUid(String paramString)
  {
    this.f = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(Boolean.valueOf(this.c));
    paramParcel.writeValue(this.d);
    paramParcel.writeValue(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeList(this.g);
    paramParcel.writeList(this.h);
  }
  
  public static class BusStation
    extends RouteNode
  {}
  
  public static class BusStep
    extends RouteStep
  {}
  
  class a
    implements Parcelable.Creator<BusLineResult>
  {
    public BusLineResult a(Parcel paramParcel)
    {
      return new BusLineResult(paramParcel);
    }
    
    public BusLineResult[] a(int paramInt)
    {
      return new BusLineResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineResult
 * JD-Core Version:    0.7.0.1
 */