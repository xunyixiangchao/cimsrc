package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiDetailSearchResult
  extends SearchResult
{
  public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new a();
  private List<PoiDetailInfo> a;
  
  public PoiDetailSearchResult() {}
  
  protected PoiDetailSearchResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(PoiDetailInfo.CREATOR);
  }
  
  public PoiDetailSearchResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<PoiDetailInfo> getPoiDetailInfoList()
  {
    return this.a;
  }
  
  public void setPoiDetailInfoList(List<PoiDetailInfo> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      StringBuffer localStringBuffer = new StringBuffer("PoiDetailSearchResult:");
      int i = 0;
      while (i < this.a.size())
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(i);
        localStringBuffer.append(" ");
        localObject = (PoiDetailInfo)this.a.get(i);
        if (localObject != null) {
          localObject = ((PoiDetailInfo)localObject).toString();
        } else {
          localObject = "null";
        }
        localStringBuffer.append((String)localObject);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return "PoiDetailSearchResult is null";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
  
  class a
    implements Parcelable.Creator<PoiDetailSearchResult>
  {
    public PoiDetailSearchResult a(Parcel paramParcel)
    {
      return new PoiDetailSearchResult(paramParcel);
    }
    
    public PoiDetailSearchResult[] a(int paramInt)
    {
      return new PoiDetailSearchResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiDetailSearchResult
 * JD-Core Version:    0.7.0.1
 */