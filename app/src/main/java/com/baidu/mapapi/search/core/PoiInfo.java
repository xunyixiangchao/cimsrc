package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiInfo> CREATOR = new a();
  public String address;
  public String area;
  public String city;
  public int detail;
  public String direction;
  public int distance;
  public boolean hasCaterDetails;
  public boolean isPano;
  public LatLng location;
  public String name;
  public ParentPoiInfo parentPoiInfo;
  public String phoneNum;
  public PoiDetailInfo poiDetailInfo;
  public String postCode;
  public String province;
  public String street_id;
  public String tag;
  public POITYPE type;
  public String uid;
  
  public PoiInfo() {}
  
  protected PoiInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.uid = paramParcel.readString();
    this.tag = paramParcel.readString();
    this.address = paramParcel.readString();
    this.province = paramParcel.readString();
    this.city = paramParcel.readString();
    this.area = paramParcel.readString();
    this.street_id = paramParcel.readString();
    this.phoneNum = paramParcel.readString();
    this.postCode = paramParcel.readString();
    this.detail = ((Integer)paramParcel.readValue(Integer.class.getClassLoader())).intValue();
    this.type = ((POITYPE)paramParcel.readValue(POITYPE.class.getClassLoader()));
    this.location = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.hasCaterDetails = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    this.isPano = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    this.poiDetailInfo = ((PoiDetailInfo)paramParcel.readParcelable(PoiDetailInfo.class.getClassLoader()));
    this.direction = paramParcel.readString();
    this.distance = paramParcel.readInt();
    this.parentPoiInfo = ((ParentPoiInfo)paramParcel.readParcelable(ParentPoiInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getArea()
  {
    return this.area;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public int getDetail()
  {
    return this.detail;
  }
  
  public String getDirection()
  {
    return this.direction;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public LatLng getLocation()
  {
    return this.location;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public ParentPoiInfo getParentPoi()
  {
    return this.parentPoiInfo;
  }
  
  public String getPhoneNum()
  {
    return this.phoneNum;
  }
  
  public PoiDetailInfo getPoiDetailInfo()
  {
    return this.poiDetailInfo;
  }
  
  public String getPostCode()
  {
    return this.postCode;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public String getStreetId()
  {
    return this.street_id;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public POITYPE getType()
  {
    return this.type;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public boolean isHasCaterDetails()
  {
    return this.hasCaterDetails;
  }
  
  public boolean isPano()
  {
    return this.isPano;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setArea(String paramString)
  {
    this.area = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setDetail(int paramInt)
  {
    this.detail = paramInt;
  }
  
  public void setDirection(String paramString)
  {
    this.direction = paramString;
  }
  
  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }
  
  public void setHasCaterDetails(boolean paramBoolean)
  {
    this.hasCaterDetails = paramBoolean;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.location = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPano(boolean paramBoolean)
  {
    this.isPano = paramBoolean;
  }
  
  public void setParentPoi(ParentPoiInfo paramParentPoiInfo)
  {
    this.parentPoiInfo = paramParentPoiInfo;
  }
  
  public void setPhoneNum(String paramString)
  {
    this.phoneNum = paramString;
  }
  
  public void setPoiDetailInfo(PoiDetailInfo paramPoiDetailInfo)
  {
    this.poiDetailInfo = paramPoiDetailInfo;
  }
  
  public void setPostCode(String paramString)
  {
    this.postCode = paramString;
  }
  
  public void setProvince(String paramString)
  {
    this.province = paramString;
  }
  
  public void setStreetId(String paramString)
  {
    this.street_id = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setType(POITYPE paramPOITYPE)
  {
    this.type = paramPOITYPE;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PoiInfo: ");
    localStringBuffer.append("name = ");
    localStringBuffer.append(this.name);
    localStringBuffer.append("; uid = ");
    localStringBuffer.append(this.uid);
    localStringBuffer.append("; address = ");
    localStringBuffer.append(this.address);
    localStringBuffer.append("; province = ");
    localStringBuffer.append(this.province);
    localStringBuffer.append("; city = ");
    localStringBuffer.append(this.city);
    localStringBuffer.append("; area = ");
    localStringBuffer.append(this.area);
    localStringBuffer.append("; street_id = ");
    localStringBuffer.append(this.street_id);
    localStringBuffer.append("; phoneNum = ");
    localStringBuffer.append(this.phoneNum);
    localStringBuffer.append("; postCode = ");
    localStringBuffer.append(this.postCode);
    localStringBuffer.append("; detail = ");
    localStringBuffer.append(this.detail);
    localStringBuffer.append("; location = ");
    Object localObject = this.location;
    if (localObject != null) {
      localStringBuffer.append(((LatLng)localObject).toString());
    } else {
      localStringBuffer.append("null");
    }
    localStringBuffer.append("; hasCaterDetails = ");
    localStringBuffer.append(this.hasCaterDetails);
    localStringBuffer.append("; isPano = ");
    localStringBuffer.append(this.isPano);
    localStringBuffer.append("; tag = ");
    localStringBuffer.append(this.tag);
    localStringBuffer.append("; poiDetailInfo = ");
    localObject = this.poiDetailInfo;
    if (localObject != null) {
      localStringBuffer.append(((PoiDetailInfo)localObject).toString());
    } else {
      localStringBuffer.append("null");
    }
    localStringBuffer.append("; direction = ");
    localStringBuffer.append(this.direction);
    localStringBuffer.append("; distance = ");
    localStringBuffer.append(this.distance);
    if (this.parentPoiInfo != null)
    {
      localStringBuffer.append("; parentPoiAddress = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiAddress());
      localStringBuffer.append("; parentPoiDirection = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiDirection());
      localStringBuffer.append("; parentPoiDistance = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiDistance());
      localStringBuffer.append("; parentPoiName = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiName());
      localStringBuffer.append("; parentPoiTag = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiTag());
      localStringBuffer.append("; parentPoiUid = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiUid());
      localStringBuffer.append("; parentPoiLocation = ");
      localStringBuffer.append(this.parentPoiInfo.getParentPoiLocation());
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.tag);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.province);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.area);
    paramParcel.writeString(this.street_id);
    paramParcel.writeString(this.phoneNum);
    paramParcel.writeString(this.postCode);
    paramParcel.writeValue(Integer.valueOf(this.detail));
    paramParcel.writeValue(this.type);
    paramParcel.writeParcelable(this.location, 1);
    paramParcel.writeValue(Boolean.valueOf(this.hasCaterDetails));
    paramParcel.writeValue(Boolean.valueOf(this.isPano));
    paramParcel.writeParcelable(this.poiDetailInfo, 1);
    paramParcel.writeString(this.direction);
    paramParcel.writeInt(this.distance);
    paramParcel.writeParcelable(this.parentPoiInfo, 1);
  }
  
  public static enum POITYPE
  {
    private int a;
    
    static
    {
      POITYPE localPOITYPE1 = new POITYPE("POINT", 0, 0);
      POINT = localPOITYPE1;
      POITYPE localPOITYPE2 = new POITYPE("BUS_STATION", 1, 1);
      BUS_STATION = localPOITYPE2;
      POITYPE localPOITYPE3 = new POITYPE("BUS_LINE", 2, 2);
      BUS_LINE = localPOITYPE3;
      POITYPE localPOITYPE4 = new POITYPE("SUBWAY_STATION", 3, 3);
      SUBWAY_STATION = localPOITYPE4;
      POITYPE localPOITYPE5 = new POITYPE("SUBWAY_LINE", 4, 4);
      SUBWAY_LINE = localPOITYPE5;
      $VALUES = new POITYPE[] { localPOITYPE1, localPOITYPE2, localPOITYPE3, localPOITYPE4, localPOITYPE5 };
    }
    
    private POITYPE(int paramInt)
    {
      this.a = paramInt;
    }
    
    public static POITYPE fromInt(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                return null;
              }
              return SUBWAY_LINE;
            }
            return SUBWAY_STATION;
          }
          return BUS_LINE;
        }
        return BUS_STATION;
      }
      return POINT;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
  
  public static class ParentPoiInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ParentPoiInfo> CREATOR = new a();
    public String parentPoiAddress;
    public String parentPoiDirection;
    public int parentPoiDistance;
    public LatLng parentPoiLocation;
    public String parentPoiName;
    public String parentPoiTag;
    public String parentPoiUid;
    
    public ParentPoiInfo() {}
    
    protected ParentPoiInfo(Parcel paramParcel)
    {
      this.parentPoiName = paramParcel.readString();
      this.parentPoiTag = paramParcel.readString();
      this.parentPoiAddress = paramParcel.readString();
      this.parentPoiLocation = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
      this.parentPoiDirection = paramParcel.readString();
      this.parentPoiDistance = paramParcel.readInt();
      this.parentPoiUid = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getParentPoiAddress()
    {
      return this.parentPoiAddress;
    }
    
    public String getParentPoiDirection()
    {
      return this.parentPoiDirection;
    }
    
    public int getParentPoiDistance()
    {
      return this.parentPoiDistance;
    }
    
    public LatLng getParentPoiLocation()
    {
      return this.parentPoiLocation;
    }
    
    public String getParentPoiName()
    {
      return this.parentPoiName;
    }
    
    public String getParentPoiTag()
    {
      return this.parentPoiTag;
    }
    
    public String getParentPoiUid()
    {
      return this.parentPoiUid;
    }
    
    public void setParentPoiAddress(String paramString)
    {
      this.parentPoiAddress = paramString;
    }
    
    public void setParentPoiDirection(String paramString)
    {
      this.parentPoiDirection = paramString;
    }
    
    public void setParentPoiDistance(int paramInt)
    {
      this.parentPoiDistance = paramInt;
    }
    
    public void setParentPoiLocation(LatLng paramLatLng)
    {
      this.parentPoiLocation = paramLatLng;
    }
    
    public void setParentPoiName(String paramString)
    {
      this.parentPoiName = paramString;
    }
    
    public void setParentPoiTag(String paramString)
    {
      this.parentPoiTag = paramString;
    }
    
    public void setParentPoiUid(String paramString)
    {
      this.parentPoiUid = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.parentPoiName);
      paramParcel.writeString(this.parentPoiTag);
      paramParcel.writeString(this.parentPoiAddress);
      paramParcel.writeParcelable(this.parentPoiLocation, paramInt);
      paramParcel.writeString(this.parentPoiDirection);
      paramParcel.writeInt(this.parentPoiDistance);
      paramParcel.writeString(this.parentPoiUid);
    }
    
    class a
      implements Parcelable.Creator<PoiInfo.ParentPoiInfo>
    {
      public PoiInfo.ParentPoiInfo a(Parcel paramParcel)
      {
        return new PoiInfo.ParentPoiInfo(paramParcel);
      }
      
      public PoiInfo.ParentPoiInfo[] a(int paramInt)
      {
        return new PoiInfo.ParentPoiInfo[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<PoiInfo>
  {
    public PoiInfo a(Parcel paramParcel)
    {
      return new PoiInfo(paramParcel);
    }
    
    public PoiInfo[] a(int paramInt)
    {
      return new PoiInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.PoiInfo
 * JD-Core Version:    0.7.0.1
 */