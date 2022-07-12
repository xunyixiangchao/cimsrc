package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;

public class PoiDetailResult
  extends SearchResult
{
  public static final Parcelable.Creator<PoiDetailResult> CREATOR = new a();
  public String address;
  public int checkinNum;
  public int commentNum;
  public String detailUrl;
  public int discountNum;
  public double environmentRating;
  public double facilityRating;
  public int favoriteNum;
  public int grouponNum;
  public double hygieneRating;
  public int imageNum;
  public LatLng location;
  public String name;
  public double overallRating;
  public double price;
  public double serviceRating;
  public String shopHours;
  public String tag;
  public double tasteRating;
  public double technologyRating;
  public String telephone;
  public String type;
  public String uid;
  
  public PoiDetailResult() {}
  
  protected PoiDetailResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.name = paramParcel.readString();
    this.location = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.address = paramParcel.readString();
    this.telephone = paramParcel.readString();
    this.uid = paramParcel.readString();
    this.tag = paramParcel.readString();
    this.detailUrl = paramParcel.readString();
    this.type = paramParcel.readString();
    this.price = paramParcel.readDouble();
    this.overallRating = paramParcel.readDouble();
    this.tasteRating = paramParcel.readDouble();
    this.serviceRating = paramParcel.readDouble();
    this.environmentRating = paramParcel.readDouble();
    this.facilityRating = paramParcel.readDouble();
    this.hygieneRating = paramParcel.readDouble();
    this.technologyRating = paramParcel.readDouble();
    this.imageNum = paramParcel.readInt();
    this.grouponNum = paramParcel.readInt();
    this.commentNum = paramParcel.readInt();
    this.discountNum = paramParcel.readInt();
    this.favoriteNum = paramParcel.readInt();
    this.checkinNum = paramParcel.readInt();
    this.shopHours = paramParcel.readString();
  }
  
  public PoiDetailResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public int getCheckinNum()
  {
    return this.checkinNum;
  }
  
  public int getCommentNum()
  {
    return this.commentNum;
  }
  
  public String getDetailUrl()
  {
    return this.detailUrl;
  }
  
  public int getDiscountNum()
  {
    return this.discountNum;
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
    return this.location;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public double getOverallRating()
  {
    return this.overallRating;
  }
  
  public double getPrice()
  {
    return this.price;
  }
  
  public double getServiceRating()
  {
    return this.serviceRating;
  }
  
  public String getShopHours()
  {
    return this.shopHours;
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
    return this.telephone;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCheckinNum(int paramInt)
  {
    this.checkinNum = paramInt;
  }
  
  public void setCommentNum(int paramInt)
  {
    this.commentNum = paramInt;
  }
  
  public void setDetailUrl(String paramString)
  {
    this.detailUrl = paramString;
  }
  
  public void setDiscountNum(int paramInt)
  {
    this.discountNum = paramInt;
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
    this.location = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOverallRating(double paramDouble)
  {
    this.overallRating = paramDouble;
  }
  
  public void setPrice(double paramDouble)
  {
    this.price = paramDouble;
  }
  
  public void setServiceRating(double paramDouble)
  {
    this.serviceRating = paramDouble;
  }
  
  public void setShopHours(String paramString)
  {
    this.shopHours = paramString;
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
    this.telephone = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.name);
    paramParcel.writeParcelable(this.location, paramInt);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.telephone);
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.tag);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeString(this.type);
    paramParcel.writeDouble(this.price);
    paramParcel.writeDouble(this.overallRating);
    paramParcel.writeDouble(this.tasteRating);
    paramParcel.writeDouble(this.serviceRating);
    paramParcel.writeDouble(this.environmentRating);
    paramParcel.writeDouble(this.facilityRating);
    paramParcel.writeDouble(this.hygieneRating);
    paramParcel.writeDouble(this.technologyRating);
    paramParcel.writeInt(this.imageNum);
    paramParcel.writeInt(this.grouponNum);
    paramParcel.writeInt(this.commentNum);
    paramParcel.writeInt(this.discountNum);
    paramParcel.writeInt(this.favoriteNum);
    paramParcel.writeInt(this.checkinNum);
    paramParcel.writeString(this.shopHours);
  }
  
  class a
    implements Parcelable.Creator<PoiDetailResult>
  {
    public PoiDetailResult a(Parcel paramParcel)
    {
      return new PoiDetailResult(paramParcel);
    }
    
    public PoiDetailResult[] a(int paramInt)
    {
      return new PoiDetailResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiDetailResult
 * JD-Core Version:    0.7.0.1
 */