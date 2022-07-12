package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public class WalkingRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new a();
  private List<WalkingRouteLine> a;
  private TaxiInfo b;
  private SuggestAddrInfo c;
  
  public WalkingRouteResult() {}
  
  protected WalkingRouteResult(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    paramParcel.readList(localArrayList, WalkingRouteLine.class.getClassLoader());
    this.b = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
    this.c = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<WalkingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }
  
  public TaxiInfo getTaxiInfo()
  {
    return this.b;
  }
  
  public void setRouteLines(List<WalkingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public void setSuggestAddrInfo(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }
  
  public void setTaxiInfo(TaxiInfo paramTaxiInfo)
  {
    this.b = paramTaxiInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeParcelable(this.b, 1);
    paramParcel.writeParcelable(this.c, 1);
  }
  
  class a
    implements Parcelable.Creator<WalkingRouteResult>
  {
    public WalkingRouteResult a(Parcel paramParcel)
    {
      return new WalkingRouteResult(paramParcel);
    }
    
    public WalkingRouteResult[] a(int paramInt)
    {
      return new WalkingRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRouteResult
 * JD-Core Version:    0.7.0.1
 */