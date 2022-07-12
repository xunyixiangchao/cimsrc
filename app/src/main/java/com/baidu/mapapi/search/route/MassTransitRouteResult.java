package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;

public final class MassTransitRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new a();
  private TransitResultNode a;
  private TransitResultNode b;
  private TaxiInfo c;
  private int d;
  private List<MassTransitRouteLine> e;
  private SuggestAddrInfo f;
  
  public MassTransitRouteResult() {}
  
  MassTransitRouteResult(Parcel paramParcel)
  {
    this.a = ((TransitResultNode)paramParcel.readParcelable(TransitResultNode.class.getClassLoader()));
    this.b = ((TransitResultNode)paramParcel.readParcelable(TransitResultNode.class.getClassLoader()));
    this.c = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
    this.d = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    this.e = localArrayList;
    paramParcel.readList(localArrayList, MassTransitRouteLine.class.getClassLoader());
    this.f = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TransitResultNode getDestination()
  {
    return this.b;
  }
  
  public TransitResultNode getOrigin()
  {
    return this.a;
  }
  
  public List<MassTransitRouteLine> getRouteLines()
  {
    return this.e;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.f;
  }
  
  public TaxiInfo getTaxiInfo()
  {
    return this.c;
  }
  
  public int getTotal()
  {
    return this.d;
  }
  
  public void setDestination(TransitResultNode paramTransitResultNode)
  {
    this.b = paramTransitResultNode;
  }
  
  public void setOrigin(TransitResultNode paramTransitResultNode)
  {
    this.a = paramTransitResultNode;
  }
  
  public void setRoutelines(List<MassTransitRouteLine> paramList)
  {
    this.e = paramList;
  }
  
  public void setSuggestAddrInfo(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.f = paramSuggestAddrInfo;
  }
  
  public void setTaxiInfo(TaxiInfo paramTaxiInfo)
  {
    this.c = paramTaxiInfo;
  }
  
  public void setTotal(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 1);
    paramParcel.writeParcelable(this.b, 1);
    paramParcel.writeParcelable(this.c, 1);
    paramParcel.writeInt(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeParcelable(this.f, 1);
  }
  
  class a
    implements Parcelable.Creator<MassTransitRouteResult>
  {
    public MassTransitRouteResult a(Parcel paramParcel)
    {
      return new MassTransitRouteResult(paramParcel);
    }
    
    public MassTransitRouteResult[] a(int paramInt)
    {
      return new MassTransitRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.MassTransitRouteResult
 * JD-Core Version:    0.7.0.1
 */