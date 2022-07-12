package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class IndoorRouteResult
  extends SearchResult
{
  public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new a();
  private List<IndoorRouteLine> a;
  
  public IndoorRouteResult() {}
  
  protected IndoorRouteResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(IndoorRouteLine.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<IndoorRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public void setRouteLines(List<IndoorRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
  
  class a
    implements Parcelable.Creator<IndoorRouteResult>
  {
    public IndoorRouteResult a(Parcel paramParcel)
    {
      return new IndoorRouteResult(paramParcel);
    }
    
    public IndoorRouteResult[] a(int paramInt)
    {
      return new IndoorRouteResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.IndoorRouteResult
 * JD-Core Version:    0.7.0.1
 */