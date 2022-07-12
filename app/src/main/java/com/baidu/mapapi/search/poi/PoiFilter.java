package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class PoiFilter
  implements Parcelable
{
  public static final Parcelable.Creator<PoiFilter> CREATOR = new a();
  private static Map<SortName, String> f = new HashMap();
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  protected PoiFilter(Parcel paramParcel)
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.e = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  PoiFilter(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.e = paramString4;
    this.d = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.a))
    {
      localStringBuilder.append("industry_type:");
      localStringBuilder.append(this.a);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localStringBuilder.append("sort_name:");
      localStringBuilder.append(this.b);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.c))
    {
      localStringBuilder.append("sort_rule:");
      localStringBuilder.append(this.c);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localStringBuilder.append("discount:");
      localStringBuilder.append(this.e);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuilder.append("groupon:");
      localStringBuilder.append(this.d);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(localStringBuilder.toString())) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.d);
  }
  
  public static final class Builder
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    
    public Builder()
    {
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.DEFAULT, "default");
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.HOTEL_LEVEL, "level");
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.HOTEL_PRICE, "price");
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.HOTEL_DISTANCE, "distance");
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
      PoiFilter.a().put(PoiFilter.SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.DEFAULT, "default");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.CATER_DISTANCE, "distance");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.CATER_PRICE, "price");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
      PoiFilter.a().put(PoiFilter.SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
      PoiFilter.a().put(PoiFilter.SortName.LifeSortName.DEFAULT, "default");
      PoiFilter.a().put(PoiFilter.SortName.LifeSortName.PRICE, "price");
      PoiFilter.a().put(PoiFilter.SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
      PoiFilter.a().put(PoiFilter.SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
      PoiFilter.a().put(PoiFilter.SortName.LifeSortName.DISTANCE, "distance");
    }
    
    public PoiFilter build()
    {
      return new PoiFilter(this.a, this.b, this.c, this.e, this.d);
    }
    
    public Builder industryType(PoiFilter.IndustryType paramIndustryType)
    {
      int i = PoiFilter.b.a[paramIndustryType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramIndustryType = "";
          } else {
            paramIndustryType = "life";
          }
        }
        else {
          paramIndustryType = "cater";
        }
      }
      else {
        paramIndustryType = "hotel";
      }
      this.a = paramIndustryType;
      return this;
    }
    
    public Builder isDiscount(boolean paramBoolean)
    {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
      this.e = str;
      return this;
    }
    
    public Builder isGroupon(boolean paramBoolean)
    {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
      this.d = str;
      return this;
    }
    
    public Builder sortName(PoiFilter.SortName paramSortName)
    {
      if (TextUtils.isEmpty(this.a)) {
        return this;
      }
      if (paramSortName != null) {
        this.b = ((String)PoiFilter.a().get(paramSortName));
      }
      return this;
    }
    
    public Builder sortRule(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      this.c = localStringBuilder.toString();
      return this;
    }
  }
  
  public static enum IndustryType
  {
    static
    {
      IndustryType localIndustryType1 = new IndustryType("HOTEL", 0);
      HOTEL = localIndustryType1;
      IndustryType localIndustryType2 = new IndustryType("CATER", 1);
      CATER = localIndustryType2;
      IndustryType localIndustryType3 = new IndustryType("LIFE", 2);
      LIFE = localIndustryType3;
      a = new IndustryType[] { localIndustryType1, localIndustryType2, localIndustryType3 };
    }
    
    private IndustryType() {}
  }
  
  public static abstract interface SortName
  {
    public static enum CaterSortName
      implements PoiFilter.SortName
    {
      static
      {
        CaterSortName localCaterSortName1 = new CaterSortName("DEFAULT", 0);
        DEFAULT = localCaterSortName1;
        CaterSortName localCaterSortName2 = new CaterSortName("CATER_PRICE", 1);
        CATER_PRICE = localCaterSortName2;
        CaterSortName localCaterSortName3 = new CaterSortName("CATER_DISTANCE", 2);
        CATER_DISTANCE = localCaterSortName3;
        CaterSortName localCaterSortName4 = new CaterSortName("CATER_TASTE_RATING", 3);
        CATER_TASTE_RATING = localCaterSortName4;
        CaterSortName localCaterSortName5 = new CaterSortName("CATER_OVERALL_RATING", 4);
        CATER_OVERALL_RATING = localCaterSortName5;
        CaterSortName localCaterSortName6 = new CaterSortName("CATER_SERVICE_RATING", 5);
        CATER_SERVICE_RATING = localCaterSortName6;
        a = new CaterSortName[] { localCaterSortName1, localCaterSortName2, localCaterSortName3, localCaterSortName4, localCaterSortName5, localCaterSortName6 };
      }
      
      private CaterSortName() {}
    }
    
    public static enum HotelSortName
      implements PoiFilter.SortName
    {
      static
      {
        HotelSortName localHotelSortName1 = new HotelSortName("DEFAULT", 0);
        DEFAULT = localHotelSortName1;
        HotelSortName localHotelSortName2 = new HotelSortName("HOTEL_PRICE", 1);
        HOTEL_PRICE = localHotelSortName2;
        HotelSortName localHotelSortName3 = new HotelSortName("HOTEL_DISTANCE", 2);
        HOTEL_DISTANCE = localHotelSortName3;
        HotelSortName localHotelSortName4 = new HotelSortName("HOTEL_TOTAL_SCORE", 3);
        HOTEL_TOTAL_SCORE = localHotelSortName4;
        HotelSortName localHotelSortName5 = new HotelSortName("HOTEL_LEVEL", 4);
        HOTEL_LEVEL = localHotelSortName5;
        HotelSortName localHotelSortName6 = new HotelSortName("HOTEL_HEALTH_SCORE", 5);
        HOTEL_HEALTH_SCORE = localHotelSortName6;
        a = new HotelSortName[] { localHotelSortName1, localHotelSortName2, localHotelSortName3, localHotelSortName4, localHotelSortName5, localHotelSortName6 };
      }
      
      private HotelSortName() {}
    }
    
    public static enum LifeSortName
      implements PoiFilter.SortName
    {
      static
      {
        LifeSortName localLifeSortName1 = new LifeSortName("DEFAULT", 0);
        DEFAULT = localLifeSortName1;
        LifeSortName localLifeSortName2 = new LifeSortName("PRICE", 1);
        PRICE = localLifeSortName2;
        LifeSortName localLifeSortName3 = new LifeSortName("DISTANCE", 2);
        DISTANCE = localLifeSortName3;
        LifeSortName localLifeSortName4 = new LifeSortName("LIFE_OVERALL_RATING", 3);
        LIFE_OVERALL_RATING = localLifeSortName4;
        LifeSortName localLifeSortName5 = new LifeSortName("LIFE_COMMENT_RATING", 4);
        LIFE_COMMENT_RATING = localLifeSortName5;
        a = new LifeSortName[] { localLifeSortName1, localLifeSortName2, localLifeSortName3, localLifeSortName4, localLifeSortName5 };
      }
      
      private LifeSortName() {}
    }
  }
  
  class a
    implements Parcelable.Creator<PoiFilter>
  {
    public PoiFilter a(Parcel paramParcel)
    {
      return new PoiFilter(paramParcel);
    }
    
    public PoiFilter[] a(int paramInt)
    {
      return new PoiFilter[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiFilter
 * JD-Core Version:    0.7.0.1
 */