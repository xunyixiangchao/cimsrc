package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiResult
  extends SearchResult
{
  public static final Parcelable.Creator<PoiResult> CREATOR = new a();
  private int a;
  private int b;
  private int c;
  private int d;
  private List<PoiInfo> e;
  private boolean f;
  private List<PoiAddrInfo> g;
  private List<CityInfo> h;
  
  public PoiResult()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.f = false;
  }
  
  protected PoiResult(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool = false;
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.f = false;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.createTypedArrayList(PoiInfo.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.f = bool;
    this.h = paramParcel.createTypedArrayList(CityInfo.CREATOR);
  }
  
  public PoiResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.f = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<PoiAddrInfo> getAllAddr()
  {
    return this.g;
  }
  
  public List<PoiInfo> getAllPoi()
  {
    return this.e;
  }
  
  public int getCurrentPageCapacity()
  {
    return this.c;
  }
  
  public int getCurrentPageNum()
  {
    return this.a;
  }
  
  public List<CityInfo> getSuggestCityList()
  {
    return this.h;
  }
  
  public int getTotalPageNum()
  {
    return this.b;
  }
  
  public int getTotalPoiNum()
  {
    return this.d;
  }
  
  public boolean isHasAddrInfo()
  {
    return this.f;
  }
  
  public void setAddrInfo(List<PoiAddrInfo> paramList)
  {
    this.g = paramList;
  }
  
  public void setCurrentPageCapacity(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCurrentPageNum(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setHasAddrInfo(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setPoiInfo(List<PoiInfo> paramList)
  {
    this.e = paramList;
  }
  
  public void setSuggestCityList(List<CityInfo> paramList)
  {
    this.h = paramList;
  }
  
  public void setTotalPageNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTotalPoiNum(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeTypedList(this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeTypedList(this.h);
  }
  
  class a
    implements Parcelable.Creator<PoiResult>
  {
    public PoiResult a(Parcel paramParcel)
    {
      return new PoiResult(paramParcel);
    }
    
    public PoiResult[] a(int paramInt)
    {
      return new PoiResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiResult
 * JD-Core Version:    0.7.0.1
 */