package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistrictResult
  extends SearchResult
{
  public static final Parcelable.Creator<DistrictResult> CREATOR = new a();
  public LatLng centerPt = null;
  public int cityCode;
  public String cityName = null;
  public List<List<LatLng>> polylines = null;
  
  public DistrictResult() {}
  
  protected DistrictResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.centerPt = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.polylines = new ArrayList();
      int i = 0;
      while (i < j)
      {
        this.polylines.add(paramParcel.createTypedArrayList(LatLng.CREATOR));
        i += 1;
      }
    }
    this.cityCode = paramParcel.readInt();
    this.cityName = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getCenterPt()
  {
    return this.centerPt;
  }
  
  public int getCityCode()
  {
    return this.cityCode;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public List<List<LatLng>> getPolylines()
  {
    return this.polylines;
  }
  
  public void setCenterPt(LatLng paramLatLng)
  {
    this.centerPt = paramLatLng;
  }
  
  public void setCityCode(int paramInt)
  {
    this.cityCode = paramInt;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public void setPolylines(List<List<LatLng>> paramList)
  {
    this.polylines = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.centerPt, paramInt);
    Object localObject = this.polylines;
    if (localObject == null) {
      paramInt = 0;
    } else {
      paramInt = ((List)localObject).size();
    }
    paramParcel.writeInt(paramInt);
    localObject = this.polylines.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParcel.writeTypedList((List)((Iterator)localObject).next());
    }
    paramParcel.writeInt(this.cityCode);
    paramParcel.writeString(this.cityName);
  }
  
  class a
    implements Parcelable.Creator<DistrictResult>
  {
    public DistrictResult a(Parcel paramParcel)
    {
      return new DistrictResult(paramParcel);
    }
    
    public DistrictResult[] a(int paramInt)
    {
      return new DistrictResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.district.DistrictResult
 * JD-Core Version:    0.7.0.1
 */