package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiIndoorResult
  extends SearchResult
{
  public static final Parcelable.Creator<PoiIndoorResult> CREATOR = new a();
  private List<PoiIndoorInfo> a;
  public int pageNum;
  public int poiNum;
  
  public PoiIndoorResult() {}
  
  protected PoiIndoorResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.poiNum = paramParcel.readInt();
    this.pageNum = paramParcel.readInt();
  }
  
  public PoiIndoorResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<PoiIndoorInfo> getArrayPoiInfo()
  {
    return this.a;
  }
  
  public int getPageNum()
  {
    return this.pageNum;
  }
  
  public int getPoiNum()
  {
    return this.poiNum;
  }
  
  @Deprecated
  public List<PoiIndoorInfo> getmArrayPoiInfo()
  {
    return this.a;
  }
  
  public void setArrayPoiInfo(List<PoiIndoorInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void setPageNum(int paramInt)
  {
    this.pageNum = paramInt;
  }
  
  public void setPoiNum(int paramInt)
  {
    this.poiNum = paramInt;
  }
  
  @Deprecated
  public void setmArrayPoiInfo(List<PoiIndoorInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.poiNum);
    paramParcel.writeInt(this.pageNum);
  }
  
  class a
    implements Parcelable.Creator<PoiIndoorResult>
  {
    public PoiIndoorResult a(Parcel paramParcel)
    {
      return new PoiIndoorResult(paramParcel);
    }
    
    public PoiIndoorResult[] a(int paramInt)
    {
      return new PoiIndoorResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiIndoorResult
 * JD-Core Version:    0.7.0.1
 */