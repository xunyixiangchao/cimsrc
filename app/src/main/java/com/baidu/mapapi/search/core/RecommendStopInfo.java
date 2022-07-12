package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class RecommendStopInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendStopInfo> CREATOR = new a();
  private String a;
  private LatLng b;
  private float c;
  private String d;
  private String e;
  
  public RecommendStopInfo() {}
  
  protected RecommendStopInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.c = paramParcel.readFloat();
    this.e = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.e;
  }
  
  public float getDistance()
  {
    return this.c;
  }
  
  public String getId()
  {
    return this.d;
  }
  
  public LatLng getLocation()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void setAddress(String paramString)
  {
    this.e = paramString;
  }
  
  public void setDistance(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setId(String paramString)
  {
    this.d = paramString;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.b = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendStopInfo{mName='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLocation=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mDistance=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAddress='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeFloat(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.d);
  }
  
  class a
    implements Parcelable.Creator<RecommendStopInfo>
  {
    public RecommendStopInfo a(Parcel paramParcel)
    {
      return new RecommendStopInfo(paramParcel);
    }
    
    public RecommendStopInfo[] a(int paramInt)
    {
      return new RecommendStopInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.RecommendStopInfo
 * JD-Core Version:    0.7.0.1
 */