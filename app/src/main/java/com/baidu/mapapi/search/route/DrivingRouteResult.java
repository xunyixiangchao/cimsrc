package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public final class DrivingRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new a();
  private List<DrivingRouteLine> a;
  private List<TaxiInfo> b;
  private TaxiInfo c;
  private SuggestAddrInfo d;
  
  public DrivingRouteResult() {}
  
  protected DrivingRouteResult(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    paramParcel.readTypedList(localArrayList, DrivingRouteLine.CREATOR);
    localArrayList = new ArrayList();
    this.b = localArrayList;
    paramParcel.readTypedList(localArrayList, TaxiInfo.CREATOR);
    this.d = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DrivingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.d;
  }
  
  @Deprecated
  public TaxiInfo getTaxiInfo()
  {
    return this.c;
  }
  
  public List<TaxiInfo> getTaxiInfos()
  {
    return this.b;
  }
  
  public void setRouteLines(List<DrivingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public void setSuggestAddrInfo(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.d = paramSuggestAddrInfo;
  }
  
  public void setTaxiInfos(List<TaxiInfo> paramList)
  {
    this.b = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.d, 1);
  }
  
  class a
    implements Parcelable.Creator<DrivingRouteResult>
  {
    public DrivingRouteResult a(Parcel paramParcel)
    {
      return new DrivingRouteResult(paramParcel);
    }
    
    public DrivingRouteResult[] a(int paramInt)
    {
      return new DrivingRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.DrivingRouteResult
 * JD-Core Version:    0.7.0.1
 */