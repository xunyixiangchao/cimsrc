package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PoiInfo.ParentPoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class ReverseGeoCodeResult
  extends SearchResult
{
  public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new a();
  private String a;
  private String b;
  private AddressComponent c;
  private LatLng d;
  private int e;
  private List<PoiInfo> f;
  private String g;
  private List<PoiRegionsInfo> h;
  private List<RoadInfo> i;
  private int j;
  
  public ReverseGeoCodeResult() {}
  
  protected ReverseGeoCodeResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((AddressComponent)paramParcel.readParcelable(AddressComponent.class.getClassLoader()));
    this.d = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.f = paramParcel.createTypedArrayList(PoiInfo.CREATOR);
    this.g = paramParcel.readString();
    this.h = paramParcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    this.i = paramParcel.createTypedArrayList(RoadInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAdcode()
  {
    return this.j;
  }
  
  public String getAddress()
  {
    return this.b;
  }
  
  public AddressComponent getAddressDetail()
  {
    return this.c;
  }
  
  public String getBusinessCircle()
  {
    return this.a;
  }
  
  public int getCityCode()
  {
    return this.e;
  }
  
  public LatLng getLocation()
  {
    return this.d;
  }
  
  public List<PoiInfo> getPoiList()
  {
    return this.f;
  }
  
  public List<PoiRegionsInfo> getPoiRegionsInfoList()
  {
    return this.h;
  }
  
  public List<RoadInfo> getRoadInfoList()
  {
    return this.i;
  }
  
  public String getSematicDescription()
  {
    return this.g;
  }
  
  public void setAdcode(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setAddress(String paramString)
  {
    this.b = paramString;
  }
  
  public void setAddressDetail(AddressComponent paramAddressComponent)
  {
    this.c = paramAddressComponent;
  }
  
  public void setBusinessCircle(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCityCode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.d = paramLatLng;
  }
  
  public void setPoiList(List<PoiInfo> paramList)
  {
    this.f = paramList;
  }
  
  public void setPoiRegionsInfoList(List<PoiRegionsInfo> paramList)
  {
    this.h = paramList;
  }
  
  public void setRoadInfoList(List<RoadInfo> paramList)
  {
    this.i = paramList;
  }
  
  public void setSematicDescription(String paramString)
  {
    this.g = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
    localStringBuffer.append("businessCircle = ");
    localStringBuffer.append(this.a);
    localStringBuffer.append("; address = ");
    localStringBuffer.append(this.b);
    localStringBuffer.append("; location = ");
    localStringBuffer.append(this.d);
    localStringBuffer.append("; sematicDescription = ");
    localStringBuffer.append(this.g);
    if (this.c != null)
    {
      localStringBuffer.append("\n#AddressComponent Info BEGIN# \n");
      localStringBuffer.append("streetNumber = ");
      localStringBuffer.append(this.c.streetNumber);
      localStringBuffer.append("; street = ");
      localStringBuffer.append(this.c.street);
      localStringBuffer.append("; town = ");
      localStringBuffer.append(this.c.town);
      localStringBuffer.append("; district = ");
      localStringBuffer.append(this.c.district);
      localStringBuffer.append("; city = ");
      localStringBuffer.append(this.c.city);
      localStringBuffer.append("; province = ");
      localStringBuffer.append(this.c.province);
      localStringBuffer.append("; countryName = ");
      localStringBuffer.append(this.c.countryName);
      localStringBuffer.append("; countryCode = ");
      localStringBuffer.append(this.c.countryCode);
      localStringBuffer.append("; adcode = ");
      localStringBuffer.append(this.c.adcode);
      localStringBuffer.append("; direction = ");
      localStringBuffer.append(this.c.direction);
      localStringBuffer.append("; distance = ");
      localStringBuffer.append(this.c.distance);
      localStringBuffer.append("; countryCodeIso = ");
      localStringBuffer.append(this.c.countryCodeIso);
      localStringBuffer.append("; countryCodeIso2 = ");
      localStringBuffer.append(this.c.countryCodeIso2);
      localStringBuffer.append("; townCode = ");
      localStringBuffer.append(this.c.townCode);
      localStringBuffer.append("; cityLevel = ");
      localStringBuffer.append(this.c.cityLevel);
      localStringBuffer.append("\n#AddressComponent Info END# \n");
    }
    Object localObject = this.h;
    int m = 0;
    int k;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localStringBuffer.append("\n#PoiRegions Info  BEGIN#");
      k = 0;
      while (k < this.h.size())
      {
        localObject = (PoiRegionsInfo)this.h.get(k);
        if (localObject != null)
        {
          localStringBuffer.append("\ndirectionDesc = ");
          localStringBuffer.append(((PoiRegionsInfo)localObject).getDirectionDesc());
          localStringBuffer.append("; regionName = ");
          localStringBuffer.append(((PoiRegionsInfo)localObject).getRegionName());
          localStringBuffer.append("; regionTag = ");
          localStringBuffer.append(((PoiRegionsInfo)localObject).getRegionTag());
        }
        k += 1;
      }
      localStringBuffer.append("\n#PoiRegions Info  END# \n");
    }
    localObject = this.f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localStringBuffer.append("\n #PoiList Info  BEGIN#");
      k = 0;
      while (k < this.f.size())
      {
        localObject = (PoiInfo)this.f.get(k);
        if (localObject != null)
        {
          localStringBuffer.append("\n address = ");
          localStringBuffer.append(((PoiInfo)localObject).getAddress());
          localStringBuffer.append("; phoneNumber = ");
          localStringBuffer.append(((PoiInfo)localObject).getPhoneNum());
          localStringBuffer.append("; uid = ");
          localStringBuffer.append(((PoiInfo)localObject).getUid());
          localStringBuffer.append("; postCode = ");
          localStringBuffer.append(((PoiInfo)localObject).getPostCode());
          localStringBuffer.append("; name = ");
          localStringBuffer.append(((PoiInfo)localObject).getName());
          localStringBuffer.append("; location = ");
          localStringBuffer.append(((PoiInfo)localObject).getLocation());
          localStringBuffer.append("; city = ");
          localStringBuffer.append(((PoiInfo)localObject).getCity());
          localStringBuffer.append("; direction = ");
          localStringBuffer.append(((PoiInfo)localObject).getDirection());
          localStringBuffer.append("; distance = ");
          localStringBuffer.append(((PoiInfo)localObject).getDistance());
          if (((PoiInfo)localObject).getParentPoi() != null)
          {
            localStringBuffer.append("\n parentPoiAddress = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiAddress());
            localStringBuffer.append("; parentPoiDirection = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiDirection());
            localStringBuffer.append("; parentPoiDistance = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiDistance());
            localStringBuffer.append("; parentPoiName = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiName());
            localStringBuffer.append("; parentPoiTag = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiTag());
            localStringBuffer.append("; parentPoiUid = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiUid());
            localStringBuffer.append("; parentPoiLocation = ");
            localStringBuffer.append(((PoiInfo)localObject).getParentPoi().getParentPoiLocation());
          }
        }
        k += 1;
      }
      localStringBuffer.append("\n #PoiList Info  END# \n");
    }
    localObject = this.i;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localStringBuffer.append("\n #RoadInfoList Info  BEGIN#");
      k = m;
      while (k < this.i.size())
      {
        localObject = (RoadInfo)this.i.get(k);
        if (localObject != null)
        {
          localStringBuffer.append("; name = ");
          localStringBuffer.append(((RoadInfo)localObject).name);
          localStringBuffer.append("; distance = ");
          localStringBuffer.append(((RoadInfo)localObject).distance);
        }
        k += 1;
      }
      localStringBuffer.append("\n #RoadInfoList Info  END# \n");
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeValue(this.d);
    paramParcel.writeTypedList(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeTypedList(this.h);
    paramParcel.writeTypedList(this.i);
  }
  
  public static class AddressComponent
    implements Parcelable
  {
    public static final Parcelable.Creator<AddressComponent> CREATOR = new a();
    public int adcode;
    public String city;
    public int cityLevel;
    public int countryCode;
    public String countryCodeIso;
    public String countryCodeIso2;
    public String countryName;
    public String direction;
    public String distance;
    public String district;
    public String province;
    public String street;
    public String streetNumber;
    public String town;
    public String townCode;
    
    public AddressComponent() {}
    
    protected AddressComponent(Parcel paramParcel)
    {
      this.streetNumber = paramParcel.readString();
      this.street = paramParcel.readString();
      this.town = paramParcel.readString();
      this.district = paramParcel.readString();
      this.city = paramParcel.readString();
      this.province = paramParcel.readString();
      this.countryName = paramParcel.readString();
      this.countryCode = paramParcel.readInt();
      this.adcode = paramParcel.readInt();
      this.direction = paramParcel.readString();
      this.distance = paramParcel.readString();
      this.countryCodeIso = paramParcel.readString();
      this.countryCodeIso2 = paramParcel.readString();
      this.townCode = paramParcel.readString();
      this.cityLevel = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getDirection()
    {
      return this.direction;
    }
    
    public String getDistance()
    {
      return this.distance;
    }
    
    public String getTown()
    {
      return this.town;
    }
    
    public void setDirection(String paramString)
    {
      this.direction = paramString;
    }
    
    public void setDistance(String paramString)
    {
      this.distance = paramString;
    }
    
    public void setTown(String paramString)
    {
      this.town = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.streetNumber);
      paramParcel.writeString(this.street);
      paramParcel.writeString(this.town);
      paramParcel.writeString(this.district);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.province);
      paramParcel.writeString(this.countryName);
      paramParcel.writeInt(this.countryCode);
      paramParcel.writeInt(this.adcode);
      paramParcel.writeString(this.direction);
      paramParcel.writeString(this.distance);
      paramParcel.writeString(this.countryCodeIso);
      paramParcel.writeString(this.countryCodeIso2);
      paramParcel.writeString(this.townCode);
      paramParcel.writeInt(this.cityLevel);
    }
    
    class a
      implements Parcelable.Creator<ReverseGeoCodeResult.AddressComponent>
    {
      public ReverseGeoCodeResult.AddressComponent a(Parcel paramParcel)
      {
        return new ReverseGeoCodeResult.AddressComponent(paramParcel);
      }
      
      public ReverseGeoCodeResult.AddressComponent[] a(int paramInt)
      {
        return new ReverseGeoCodeResult.AddressComponent[paramInt];
      }
    }
  }
  
  public static class PoiRegionsInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new a();
    public String directionDesc;
    public String regionName;
    public String regionTag;
    
    public PoiRegionsInfo() {}
    
    protected PoiRegionsInfo(Parcel paramParcel)
    {
      this.directionDesc = paramParcel.readString();
      this.regionName = paramParcel.readString();
      this.regionTag = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getDirectionDesc()
    {
      return this.directionDesc;
    }
    
    public String getRegionName()
    {
      return this.regionName;
    }
    
    public String getRegionTag()
    {
      return this.regionTag;
    }
    
    public void setDirectionDesc(String paramString)
    {
      this.directionDesc = paramString;
    }
    
    public void setRegionName(String paramString)
    {
      this.regionName = paramString;
    }
    
    public void setRegionTag(String paramString)
    {
      this.regionTag = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.directionDesc);
      paramParcel.writeString(this.regionName);
      paramParcel.writeString(this.regionTag);
    }
    
    class a
      implements Parcelable.Creator<ReverseGeoCodeResult.PoiRegionsInfo>
    {
      public ReverseGeoCodeResult.PoiRegionsInfo a(Parcel paramParcel)
      {
        return new ReverseGeoCodeResult.PoiRegionsInfo(paramParcel);
      }
      
      public ReverseGeoCodeResult.PoiRegionsInfo[] a(int paramInt)
      {
        return new ReverseGeoCodeResult.PoiRegionsInfo[paramInt];
      }
    }
  }
  
  public static class RoadInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RoadInfo> CREATOR = new a();
    public String distance;
    public String name;
    
    public RoadInfo() {}
    
    protected RoadInfo(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.distance = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.distance);
    }
    
    class a
      implements Parcelable.Creator<ReverseGeoCodeResult.RoadInfo>
    {
      public ReverseGeoCodeResult.RoadInfo a(Parcel paramParcel)
      {
        return new ReverseGeoCodeResult.RoadInfo(paramParcel);
      }
      
      public ReverseGeoCodeResult.RoadInfo[] a(int paramInt)
      {
        return new ReverseGeoCodeResult.RoadInfo[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<ReverseGeoCodeResult>
  {
    public ReverseGeoCodeResult a(Parcel paramParcel)
    {
      return new ReverseGeoCodeResult(paramParcel);
    }
    
    public ReverseGeoCodeResult[] a(int paramInt)
    {
      return new ReverseGeoCodeResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.geocode.ReverseGeoCodeResult
 * JD-Core Version:    0.7.0.1
 */