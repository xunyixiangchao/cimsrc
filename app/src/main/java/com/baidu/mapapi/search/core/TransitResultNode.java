package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class TransitResultNode
  implements Parcelable
{
  public static final Parcelable.Creator<TransitResultNode> CREATOR = new a();
  private int a;
  private String b;
  private LatLng c;
  private String d;
  
  public TransitResultNode(int paramInt, String paramString1, LatLng paramLatLng, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramLatLng;
    this.d = paramString2;
  }
  
  protected TransitResultNode(Parcel paramParcel)
  {
    this.b = null;
    this.c = null;
    this.d = null;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCityId()
  {
    return this.a;
  }
  
  public String getCityName()
  {
    return this.b;
  }
  
  public LatLng getLocation()
  {
    return this.c;
  }
  
  public String getSearchWord()
  {
    return this.d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeString(this.d);
  }
  
  class a
    implements Parcelable.Creator<TransitResultNode>
  {
    public TransitResultNode a(Parcel paramParcel)
    {
      return new TransitResultNode(paramParcel);
    }
    
    public TransitResultNode[] a(int paramInt)
    {
      return new TransitResultNode[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.TransitResultNode
 * JD-Core Version:    0.7.0.1
 */