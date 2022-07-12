package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

public class BikingRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<BikingRouteResult> CREATOR = new a();
  private List<BikingRouteLine> a;
  private SuggestAddrInfo b;
  
  public BikingRouteResult() {}
  
  protected BikingRouteResult(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    paramParcel.readList(localArrayList, BikingRouteLine.class.getClassLoader());
    this.b = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<BikingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.b;
  }
  
  public void setRouteLines(List<BikingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public void setSuggestAddrInfo(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.b = paramSuggestAddrInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeParcelable(this.b, 1);
  }
  
  class a
    implements Parcelable.Creator<BikingRouteResult>
  {
    public BikingRouteResult a(Parcel paramParcel)
    {
      return new BikingRouteResult(paramParcel);
    }
    
    public BikingRouteResult[] a(int paramInt)
    {
      return new BikingRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.BikingRouteResult
 * JD-Core Version:    0.7.0.1
 */