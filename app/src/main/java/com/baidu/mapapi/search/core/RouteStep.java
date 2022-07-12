package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class RouteStep
  implements Parcelable
{
  public static final Parcelable.Creator<RouteStep> CREATOR = new a();
  int a;
  int b;
  String c;
  protected List<LatLng> mWayPoints;
  
  protected RouteStep() {}
  
  protected RouteStep(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    ArrayList localArrayList = new ArrayList();
    this.mWayPoints = localArrayList;
    paramParcel.readList(localArrayList, LatLng.class.getClassLoader());
    if (this.mWayPoints.size() == 0) {
      this.mWayPoints = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDistance()
  {
    return this.a;
  }
  
  public int getDuration()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public List<LatLng> getWayPoints()
  {
    return this.mWayPoints;
  }
  
  public void setDistance(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setWayPoints(List<LatLng> paramList)
  {
    this.mWayPoints = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeList(this.mWayPoints);
  }
  
  class a
    implements Parcelable.Creator<RouteStep>
  {
    public RouteStep a(Parcel paramParcel)
    {
      return new RouteStep(paramParcel);
    }
    
    public RouteStep[] a(int paramInt)
    {
      return new RouteStep[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.RouteStep
 * JD-Core Version:    0.7.0.1
 */