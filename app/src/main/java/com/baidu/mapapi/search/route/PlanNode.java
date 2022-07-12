package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class PlanNode
  implements Parcelable
{
  public static final Parcelable.Creator<PlanNode> CREATOR = new a();
  private LatLng a;
  private String b;
  private String c;
  
  protected PlanNode(Parcel paramParcel)
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.a = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  PlanNode(LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.a = paramLatLng;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static PlanNode withCityCodeAndPlaceName(int paramInt, String paramString)
  {
    return new PlanNode(null, String.valueOf(paramInt), paramString);
  }
  
  public static PlanNode withCityNameAndPlaceName(String paramString1, String paramString2)
  {
    return new PlanNode(null, paramString1, paramString2);
  }
  
  public static PlanNode withLocation(LatLng paramLatLng)
  {
    return new PlanNode(paramLatLng, null, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCity()
  {
    return this.b;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
  
  class a
    implements Parcelable.Creator<PlanNode>
  {
    public PlanNode a(Parcel paramParcel)
    {
      return new PlanNode(paramParcel);
    }
    
    public PlanNode[] a(int paramInt)
    {
      return new PlanNode[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.PlanNode
 * JD-Core Version:    0.7.0.1
 */