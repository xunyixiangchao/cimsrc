package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public class PoiDetailInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiDetailInfo> CREATOR = new a();
  private String a;
  private LatLng b;
  private String c;
  public int checkinNum;
  public int commentNum;
  private String d;
  public String detailUrl;
  public int discountNum;
  public int distance;
  private String e;
  public double environmentRating;
  private String f;
  public double facilityRating;
  public int favoriteNum;
  private String g;
  public int grouponNum;
  private String h;
  public double hygieneRating;
  private String i;
  public int imageNum;
  private int j;
  private List<PoiChildrenInfo> k;
  public LatLng naviLocation;
  public double overallRating;
  public double price;
  public double serviceRating;
  public String shopHours;
  public String tag;
  public double tasteRating;
  public double technologyRating;
  public String type;
  
  public PoiDetailInfo() {}
  
  protected PoiDetailInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readInt();
    this.distance = paramParcel.readInt();
    this.type = paramParcel.readString();
    this.tag = paramParcel.readString();
    this.naviLocation = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.detailUrl = paramParcel.readString();
    this.price = paramParcel.readDouble();
    this.shopHours = paramParcel.readString();
    this.overallRating = paramParcel.readDouble();
    this.tasteRating = paramParcel.readDouble();
    this.serviceRating = paramParcel.readDouble();
    this.environmentRating = paramParcel.readDouble();
    this.facilityRating = paramParcel.readDouble();
    this.hygieneRating = paramParcel.readDouble();
    this.technologyRating = paramParcel.readDouble();
    this.imageNum = paramParcel.readInt();
    this.grouponNum = paramParcel.readInt();
    this.discountNum = paramParcel.readInt();
    this.commentNum = paramParcel.readInt();
    this.favoriteNum = paramParcel.readInt();
    this.checkinNum = paramParcel.readInt();
    this.k = paramParcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.c;
  }
  
  public String getArea()
  {
    return this.f;
  }
  
  public int getCheckinNum()
  {
    return this.checkinNum;
  }
  
  public String getCity()
  {
    return this.e;
  }
  
  public int getCommentNum()
  {
    return this.commentNum;
  }
  
  public int getDetail()
  {
    return this.j;
  }
  
  public String getDetailUrl()
  {
    return this.detailUrl;
  }
  
  public int getDiscountNum()
  {
    return this.discountNum;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public double getEnvironmentRating()
  {
    return this.environmentRating;
  }
  
  public double getFacilityRating()
  {
    return this.facilityRating;
  }
  
  public int getFavoriteNum()
  {
    return this.favoriteNum;
  }
  
  public int getGrouponNum()
  {
    return this.grouponNum;
  }
  
  public double getHygieneRating()
  {
    return this.hygieneRating;
  }
  
  public int getImageNum()
  {
    return this.imageNum;
  }
  
  public LatLng getLocation()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public LatLng getNaviLocation()
  {
    return this.naviLocation;
  }
  
  public double getOverallRating()
  {
    return this.overallRating;
  }
  
  public List<PoiChildrenInfo> getPoiChildrenInfoList()
  {
    return this.k;
  }
  
  public double getPrice()
  {
    return this.price;
  }
  
  public String getProvince()
  {
    return this.d;
  }
  
  public double getServiceRating()
  {
    return this.serviceRating;
  }
  
  public String getShopHours()
  {
    return this.shopHours;
  }
  
  public String getStreetId()
  {
    return this.i;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public double getTasteRating()
  {
    return this.tasteRating;
  }
  
  public double getTechnologyRating()
  {
    return this.technologyRating;
  }
  
  public String getTelephone()
  {
    return this.g;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUid()
  {
    return this.h;
  }
  
  public void setAddress(String paramString)
  {
    this.c = paramString;
  }
  
  public void setArea(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCheckinNum(int paramInt)
  {
    this.checkinNum = paramInt;
  }
  
  public void setCity(String paramString)
  {
    this.e = paramString;
  }
  
  public void setCommentNum(int paramInt)
  {
    this.commentNum = paramInt;
  }
  
  public void setDetail(String paramString)
  {
    try
    {
      this.j = Integer.parseInt(paramString);
      return;
    }
    catch (NumberFormatException paramString)
    {
      label9:
      break label9;
    }
    this.j = 0;
  }
  
  public void setDetailUrl(String paramString)
  {
    this.detailUrl = paramString;
  }
  
  public void setDiscountNum(int paramInt)
  {
    this.discountNum = paramInt;
  }
  
  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }
  
  public void setEnvironmentRating(double paramDouble)
  {
    this.environmentRating = paramDouble;
  }
  
  public void setFacilityRating(double paramDouble)
  {
    this.facilityRating = paramDouble;
  }
  
  public void setFavoriteNum(int paramInt)
  {
    this.favoriteNum = paramInt;
  }
  
  public void setGrouponNum(int paramInt)
  {
    this.grouponNum = paramInt;
  }
  
  public void setHygieneRating(double paramDouble)
  {
    this.hygieneRating = paramDouble;
  }
  
  public void setImageNum(int paramInt)
  {
    this.imageNum = paramInt;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.b = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setNaviLocation(LatLng paramLatLng)
  {
    this.naviLocation = paramLatLng;
  }
  
  public void setOverallRating(double paramDouble)
  {
    this.overallRating = paramDouble;
  }
  
  public void setPoiChildrenInfoList(List<PoiChildrenInfo> paramList)
  {
    this.k = paramList;
  }
  
  public void setPrice(double paramDouble)
  {
    this.price = paramDouble;
  }
  
  public void setProvince(String paramString)
  {
    this.d = paramString;
  }
  
  public void setServiceRating(double paramDouble)
  {
    this.serviceRating = paramDouble;
  }
  
  public void setShopHours(String paramString)
  {
    this.shopHours = paramString;
  }
  
  public void setStreetId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setTasteRating(double paramDouble)
  {
    this.tasteRating = paramDouble;
  }
  
  public void setTechnologyRating(double paramDouble)
  {
    this.technologyRating = paramDouble;
  }
  
  public void setTelephone(String paramString)
  {
    this.g = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.h = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PoiDetailInfo: ");
    localStringBuffer.append("name = ");
    localStringBuffer.append(this.a);
    localStringBuffer.append("; location = ");
    Object localObject = this.b;
    if (localObject != null) {
      localStringBuffer.append(((LatLng)localObject).toString());
    } else {
      localStringBuffer.append("null");
    }
    localStringBuffer.append("; address = ");
    localStringBuffer.append(this.c);
    localStringBuffer.append("; province = ");
    localStringBuffer.append(this.d);
    localStringBuffer.append("; city = ");
    localStringBuffer.append(this.e);
    localStringBuffer.append("; area = ");
    localStringBuffer.append(this.f);
    localStringBuffer.append("; telephone = ");
    localStringBuffer.append(this.g);
    localStringBuffer.append("; uid = ");
    localStringBuffer.append(this.h);
    localStringBuffer.append("; detail = ");
    localStringBuffer.append(this.j);
    localStringBuffer.append("; distance = ");
    localStringBuffer.append(this.distance);
    localStringBuffer.append("; type = ");
    localStringBuffer.append(this.type);
    localStringBuffer.append("; tag = ");
    localStringBuffer.append(this.tag);
    localStringBuffer.append("; naviLocation = ");
    localObject = this.naviLocation;
    if (localObject != null) {
      localStringBuffer.append(((LatLng)localObject).toString());
    } else {
      localStringBuffer.append("null");
    }
    localStringBuffer.append("; detailUrl = ");
    localStringBuffer.append(this.detailUrl);
    localStringBuffer.append("; price = ");
    localStringBuffer.append(this.price);
    localStringBuffer.append("; shopHours = ");
    localStringBuffer.append(this.shopHours);
    localStringBuffer.append("; overallRating = ");
    localStringBuffer.append(this.overallRating);
    localStringBuffer.append("; tasteRating = ");
    localStringBuffer.append(this.tasteRating);
    localStringBuffer.append("; serviceRating = ");
    localStringBuffer.append(this.serviceRating);
    localStringBuffer.append("; environmentRating = ");
    localStringBuffer.append(this.environmentRating);
    localStringBuffer.append("; facilityRating = ");
    localStringBuffer.append(this.facilityRating);
    localStringBuffer.append("; hygieneRating = ");
    localStringBuffer.append(this.hygieneRating);
    localStringBuffer.append("; technologyRating = ");
    localStringBuffer.append(this.technologyRating);
    localStringBuffer.append("; imageNum = ");
    localStringBuffer.append(this.imageNum);
    localStringBuffer.append("; grouponNum = ");
    localStringBuffer.append(this.grouponNum);
    localStringBuffer.append("; discountNum = ");
    localStringBuffer.append(this.discountNum);
    localStringBuffer.append("; commentNum = ");
    localStringBuffer.append(this.commentNum);
    localStringBuffer.append("; favoriteNum = ");
    localStringBuffer.append(this.favoriteNum);
    localStringBuffer.append("; checkinNum = ");
    localStringBuffer.append(this.checkinNum);
    localObject = this.k;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int m = 0;
      while (m < this.k.size())
      {
        localStringBuffer.append("; The ");
        localStringBuffer.append(m);
        localStringBuffer.append(" poiChildrenInfo is: ");
        localObject = (PoiChildrenInfo)this.k.get(m);
        if (localObject != null) {
          localStringBuffer.append(((PoiChildrenInfo)localObject).toString());
        } else {
          localStringBuffer.append("null");
        }
        m += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.distance);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.tag);
    paramParcel.writeParcelable(this.naviLocation, paramInt);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeDouble(this.price);
    paramParcel.writeString(this.shopHours);
    paramParcel.writeDouble(this.overallRating);
    paramParcel.writeDouble(this.tasteRating);
    paramParcel.writeDouble(this.serviceRating);
    paramParcel.writeDouble(this.environmentRating);
    paramParcel.writeDouble(this.facilityRating);
    paramParcel.writeDouble(this.hygieneRating);
    paramParcel.writeDouble(this.technologyRating);
    paramParcel.writeInt(this.imageNum);
    paramParcel.writeInt(this.grouponNum);
    paramParcel.writeInt(this.discountNum);
    paramParcel.writeInt(this.commentNum);
    paramParcel.writeInt(this.favoriteNum);
    paramParcel.writeInt(this.checkinNum);
    paramParcel.writeTypedList(this.k);
  }
  
  class a
    implements Parcelable.Creator<PoiDetailInfo>
  {
    public PoiDetailInfo a(Parcel paramParcel)
    {
      return new PoiDetailInfo(paramParcel);
    }
    
    public PoiDetailInfo[] a(int paramInt)
    {
      return new PoiDetailInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.PoiDetailInfo
 * JD-Core Version:    0.7.0.1
 */