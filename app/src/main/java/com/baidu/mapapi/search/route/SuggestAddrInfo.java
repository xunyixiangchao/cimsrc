package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

public class SuggestAddrInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new a();
  private List<PoiInfo> a;
  private List<PoiInfo> b;
  private List<List<PoiInfo>> c;
  private List<CityInfo> d;
  private List<CityInfo> e;
  private List<List<CityInfo>> f;
  
  public SuggestAddrInfo() {}
  
  SuggestAddrInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.b = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.c = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.d = paramParcel.readArrayList(CityInfo.class.getClassLoader());
    this.e = paramParcel.readArrayList(CityInfo.class.getClassLoader());
    this.f = paramParcel.readArrayList(CityInfo.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<CityInfo> getSuggestEndCity()
  {
    return this.e;
  }
  
  public List<PoiInfo> getSuggestEndNode()
  {
    return this.b;
  }
  
  public List<CityInfo> getSuggestStartCity()
  {
    return this.d;
  }
  
  public List<PoiInfo> getSuggestStartNode()
  {
    return this.a;
  }
  
  public List<List<CityInfo>> getSuggestWpCity()
  {
    return this.f;
  }
  
  public List<List<PoiInfo>> getSuggestWpNode()
  {
    return this.c;
  }
  
  public void setSuggestEndCity(List<CityInfo> paramList)
  {
    this.e = paramList;
  }
  
  public void setSuggestEndNode(List<PoiInfo> paramList)
  {
    this.b = paramList;
  }
  
  public void setSuggestStartCity(List<CityInfo> paramList)
  {
    this.d = paramList;
  }
  
  public void setSuggestStartNode(List<PoiInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void setSuggestWpCity(List<List<CityInfo>> paramList)
  {
    this.f = paramList;
  }
  
  public void setSuggestWpNode(List<List<PoiInfo>> paramList)
  {
    this.c = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeList(this.f);
  }
  
  class a
    implements Parcelable.Creator<SuggestAddrInfo>
  {
    public SuggestAddrInfo a(Parcel paramParcel)
    {
      return new SuggestAddrInfo(paramParcel);
    }
    
    public SuggestAddrInfo[] a(int paramInt)
    {
      return new SuggestAddrInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.SuggestAddrInfo
 * JD-Core Version:    0.7.0.1
 */