package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public final class TransitRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<TransitRouteResult> CREATOR = new a();
  private TaxiInfo a;
  private List<TransitRouteLine> b;
  private SuggestAddrInfo c;
  
  public TransitRouteResult() {}
  
  protected TransitRouteResult(Parcel paramParcel)
  {
    this.a = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    paramParcel.readList(localArrayList, TransitRouteLine.class.getClassLoader());
    this.c = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<TransitRouteLine> getRouteLines()
  {
    return this.b;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }
  
  public TaxiInfo getTaxiInfo()
  {
    return this.a;
  }
  
  public void setRoutelines(List<TransitRouteLine> paramList)
  {
    this.b = paramList;
  }
  
  public void setSuggestAddrInfo(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }
  
  public void setTaxiInfo(TaxiInfo paramTaxiInfo)
  {
    this.a = paramTaxiInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 1);
    paramParcel.writeList(this.b);
    paramParcel.writeParcelable(this.c, 1);
  }
  
  class a
    implements Parcelable.Creator<TransitRouteResult>
  {
    public TransitRouteResult a(Parcel paramParcel)
    {
      return new TransitRouteResult(paramParcel);
    }
    
    public TransitRouteResult[] a(int paramInt)
    {
      return new TransitRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRouteResult
 * JD-Core Version:    0.7.0.1
 */