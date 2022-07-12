package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class PoiChildrenInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new a();
  private String a;
  private String b;
  private String c;
  private String d;
  private LatLng e;
  private String f;
  
  public PoiChildrenInfo() {}
  
  protected PoiChildrenInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.f;
  }
  
  public LatLng getLocation()
  {
    return this.e;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getShowName()
  {
    return this.c;
  }
  
  public String getTag()
  {
    return this.d;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public void setAddress(String paramString)
  {
    this.f = paramString;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.e = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setShowName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PoiChildrenInfo: ");
    localStringBuffer.append("uid = ");
    localStringBuffer.append(this.a);
    localStringBuffer.append("; name = ");
    localStringBuffer.append(this.b);
    localStringBuffer.append("; showName = ");
    localStringBuffer.append(this.c);
    localStringBuffer.append("; tag = ");
    localStringBuffer.append(this.d);
    localStringBuffer.append("; location = ");
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((LatLng)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("; address = ");
    localStringBuffer.append(this.f);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
  }
  
  class a
    implements Parcelable.Creator<PoiChildrenInfo>
  {
    public PoiChildrenInfo a(Parcel paramParcel)
    {
      return new PoiChildrenInfo(paramParcel);
    }
    
    public PoiChildrenInfo[] a(int paramInt)
    {
      return new PoiChildrenInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.PoiChildrenInfo
 * JD-Core Version:    0.7.0.1
 */