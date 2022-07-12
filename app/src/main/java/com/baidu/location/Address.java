package com.baidu.location;

public final class Address
{
  public final String adcode;
  public final String address;
  public final String city;
  public final String cityCode;
  public final String country;
  public final String countryCode;
  public final String district;
  public final String province;
  public final String street;
  public final String streetNumber;
  public final String town;
  
  private Address(Builder paramBuilder)
  {
    this.country = paramBuilder.mCountry;
    this.countryCode = paramBuilder.mCountryCode;
    this.province = paramBuilder.mProvince;
    this.city = paramBuilder.mCity;
    this.cityCode = paramBuilder.mCityCode;
    this.district = paramBuilder.mDistrict;
    this.street = paramBuilder.mStreet;
    this.streetNumber = paramBuilder.mStreetNumber;
    this.address = paramBuilder.mAddress;
    this.adcode = paramBuilder.mAdcode;
    this.town = paramBuilder.mTown;
  }
  
  public static class Builder
  {
    private static final String BEI_JING = "北京";
    private static final String CHONG_QIN = "重庆";
    private static final String SHANG_HAI = "上海";
    private static final String TIAN_JIN = "天津";
    private String mAdcode = null;
    private String mAddress = null;
    private String mCity = null;
    private String mCityCode = null;
    private String mCountry = null;
    private String mCountryCode = null;
    private String mDistrict = null;
    private String mProvince = null;
    private String mStreet = null;
    private String mStreetNumber = null;
    private String mTown = null;
    
    public Builder adcode(String paramString)
    {
      this.mAdcode = paramString;
      return this;
    }
    
    public Address build()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject = this.mCountry;
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      localObject = this.mProvince;
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      localObject = this.mProvince;
      if (localObject != null)
      {
        str1 = this.mCity;
        if ((str1 != null) && (!((String)localObject).equals(str1))) {
          localStringBuffer.append(this.mCity);
        }
      }
      String str1 = this.mDistrict;
      if (str1 != null)
      {
        String str2 = this.mCity;
        localObject = str1;
        if (str2 != null)
        {
          if (!str2.equals(str1)) {
            localObject = this.mDistrict;
          }
        }
        else {
          localStringBuffer.append((String)localObject);
        }
      }
      localObject = this.mTown;
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      localObject = this.mStreet;
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      localObject = this.mStreetNumber;
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      if (localStringBuffer.length() > 0) {
        this.mAddress = localStringBuffer.toString();
      }
      return new Address(this, null);
    }
    
    public Builder city(String paramString)
    {
      this.mCity = paramString;
      return this;
    }
    
    public Builder cityCode(String paramString)
    {
      this.mCityCode = paramString;
      return this;
    }
    
    public Builder country(String paramString)
    {
      this.mCountry = paramString;
      return this;
    }
    
    public Builder countryCode(String paramString)
    {
      this.mCountryCode = paramString;
      return this;
    }
    
    public Builder district(String paramString)
    {
      this.mDistrict = paramString;
      return this;
    }
    
    public Builder province(String paramString)
    {
      this.mProvince = paramString;
      return this;
    }
    
    public Builder street(String paramString)
    {
      this.mStreet = paramString;
      return this;
    }
    
    public Builder streetNumber(String paramString)
    {
      this.mStreetNumber = paramString;
      return this;
    }
    
    public Builder town(String paramString)
    {
      this.mTown = paramString;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.Address
 * JD-Core Version:    0.7.0.1
 */