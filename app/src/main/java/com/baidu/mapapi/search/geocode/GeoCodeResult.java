package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

public class GeoCodeResult
  extends SearchResult
{
  public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();
  private LatLng a;
  private String b;
  private int c;
  private int d;
  private String e;
  
  public GeoCodeResult() {}
  
  protected GeoCodeResult(Parcel paramParcel)
  {
    this.a = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public String getAddress()
  {
    return this.b;
  }
  
  public int getConfidence()
  {
    return this.d;
  }
  
  public String getLevel()
  {
    return this.e;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public int getPrecise()
  {
    return this.c;
  }
  
  @Deprecated
  public void setAddress(String paramString)
  {
    this.b = paramString;
  }
  
  public void setConfidence(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setLevel(String paramString)
  {
    this.e = paramString;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public void setPrecise(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("GeoCodeResult: \n");
    localStringBuffer.append("location = ");
    localStringBuffer.append(this.a);
    localStringBuffer.append("; precise = ");
    localStringBuffer.append(this.c);
    localStringBuffer.append("; confidence = ");
    localStringBuffer.append(this.d);
    localStringBuffer.append("; level = ");
    localStringBuffer.append(this.e);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
  }
  
  class a
    implements Parcelable.Creator<GeoCodeResult>
  {
    public GeoCodeResult a(Parcel paramParcel)
    {
      return new GeoCodeResult(paramParcel);
    }
    
    public GeoCodeResult[] a(int paramInt)
    {
      return new GeoCodeResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCodeResult
 * JD-Core Version:    0.7.0.1
 */