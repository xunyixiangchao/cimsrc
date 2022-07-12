package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;

public class SuggestionResult
  extends SearchResult
{
  public static final Parcelable.Creator<SuggestionResult> CREATOR = new a();
  private ArrayList<SuggestionInfo> a;
  
  public SuggestionResult() {}
  
  protected SuggestionResult(Parcel paramParcel)
  {
    this.a = paramParcel.readArrayList(SuggestionInfo.class.getClassLoader());
  }
  
  public SuggestionResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<SuggestionInfo> getAllSuggestions()
  {
    return this.a;
  }
  
  public void setSuggestionInfo(ArrayList<SuggestionInfo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
  
  public static class SuggestionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SuggestionInfo> CREATOR = new a();
    public String address;
    public String city;
    public String district;
    public String key;
    public List<PoiChildrenInfo> poiChildrenInfoList;
    public LatLng pt;
    public String tag;
    public String uid;
    
    public SuggestionInfo() {}
    
    protected SuggestionInfo(Parcel paramParcel)
    {
      this.key = paramParcel.readString();
      this.city = paramParcel.readString();
      this.district = paramParcel.readString();
      this.pt = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
      this.uid = paramParcel.readString();
      this.tag = paramParcel.readString();
      this.address = paramParcel.readString();
      this.poiChildrenInfoList = paramParcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAddress()
    {
      return this.address;
    }
    
    public String getCity()
    {
      return this.city;
    }
    
    public String getDistrict()
    {
      return this.district;
    }
    
    public String getKey()
    {
      return this.key;
    }
    
    public List<PoiChildrenInfo> getPoiChildrenInfoList()
    {
      return this.poiChildrenInfoList;
    }
    
    public LatLng getPt()
    {
      return this.pt;
    }
    
    public String getTag()
    {
      return this.tag;
    }
    
    public String getUid()
    {
      return this.uid;
    }
    
    public void setAddress(String paramString)
    {
      this.address = paramString;
    }
    
    public void setCity(String paramString)
    {
      this.city = paramString;
    }
    
    public void setDistrict(String paramString)
    {
      this.district = paramString;
    }
    
    public void setKey(String paramString)
    {
      this.key = paramString;
    }
    
    public void setPoiChildrenInfoList(List<PoiChildrenInfo> paramList)
    {
      this.poiChildrenInfoList = paramList;
    }
    
    public void setPt(LatLng paramLatLng)
    {
      this.pt = paramLatLng;
    }
    
    public void setTag(String paramString)
    {
      this.tag = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("SuggestionInfo: ");
      localStringBuffer.append("key = ");
      localStringBuffer.append(this.key);
      localStringBuffer.append("; city = ");
      localStringBuffer.append(this.city);
      localStringBuffer.append("; district = ");
      localStringBuffer.append(this.district);
      localStringBuffer.append("; pt = ");
      Object localObject = this.pt;
      if (localObject != null) {
        localStringBuffer.append(((LatLng)localObject).toString());
      } else {
        localStringBuffer.append("null");
      }
      localStringBuffer.append("; uid = ");
      localStringBuffer.append(this.uid);
      localStringBuffer.append("; tag = ");
      localStringBuffer.append(this.tag);
      localStringBuffer.append("; address = ");
      localStringBuffer.append(this.address);
      localStringBuffer.append("; childrenInfo = ");
      localObject = this.poiChildrenInfoList;
      int i;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        i = 0;
      }
      while (i < this.poiChildrenInfoList.size())
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(i);
        localStringBuffer.append(" ");
        localObject = (PoiChildrenInfo)this.poiChildrenInfoList.get(i);
        if (localObject == null) {
          localStringBuffer.append("null");
        } else {
          localStringBuffer.append(((PoiChildrenInfo)localObject).toString());
        }
        i += 1;
        continue;
        localStringBuffer.append("null");
      }
      return localStringBuffer.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.district);
      paramParcel.writeParcelable(this.pt, paramInt);
      paramParcel.writeString(this.uid);
      paramParcel.writeString(this.tag);
      paramParcel.writeString(this.address);
      paramParcel.writeTypedList(this.poiChildrenInfoList);
    }
    
    class a
      implements Parcelable.Creator<SuggestionResult.SuggestionInfo>
    {
      public SuggestionResult.SuggestionInfo a(Parcel paramParcel)
      {
        return new SuggestionResult.SuggestionInfo(paramParcel);
      }
      
      public SuggestionResult.SuggestionInfo[] a(int paramInt)
      {
        return new SuggestionResult.SuggestionInfo[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<SuggestionResult>
  {
    public SuggestionResult a(Parcel paramParcel)
    {
      return new SuggestionResult(paramParcel);
    }
    
    public SuggestionResult[] a(int paramInt)
    {
      return new SuggestionResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionResult
 * JD-Core Version:    0.7.0.1
 */