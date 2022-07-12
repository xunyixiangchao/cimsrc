package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TaxiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TaxiInfo> CREATOR = new a();
  private float a;
  private String b;
  private int c;
  private int d;
  private float e;
  private float f;
  
  public TaxiInfo() {}
  
  TaxiInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDesc()
  {
    return this.b;
  }
  
  public int getDistance()
  {
    return this.c;
  }
  
  public int getDuration()
  {
    return this.d;
  }
  
  public float getPerKMPrice()
  {
    return this.e;
  }
  
  public float getStartPrice()
  {
    return this.f;
  }
  
  public float getTotalPrice()
  {
    return this.a;
  }
  
  public void setDesc(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDistance(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setPerKMPrice(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void setStartPrice(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setTotalPrice(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
  }
  
  class a
    implements Parcelable.Creator<TaxiInfo>
  {
    public TaxiInfo a(Parcel paramParcel)
    {
      return new TaxiInfo(paramParcel);
    }
    
    public TaxiInfo[] a(int paramInt)
    {
      return new TaxiInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.TaxiInfo
 * JD-Core Version:    0.7.0.1
 */