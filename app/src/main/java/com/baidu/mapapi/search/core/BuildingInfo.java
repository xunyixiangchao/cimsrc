package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BuildingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BuildingInfo> CREATOR = new a();
  private int accuracy;
  private String center;
  private String geom;
  private float height;
  
  public BuildingInfo() {}
  
  protected BuildingInfo(Parcel paramParcel)
  {
    this.height = paramParcel.readFloat();
    this.accuracy = paramParcel.readInt();
    this.geom = paramParcel.readString();
    this.center = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAccuracy()
  {
    return this.accuracy;
  }
  
  public String getCenter()
  {
    return this.center;
  }
  
  public String getGeom()
  {
    return this.geom;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public void setAccuracy(int paramInt)
  {
    this.accuracy = paramInt;
  }
  
  public void setCenter(String paramString)
  {
    this.center = paramString;
  }
  
  public void setGeom(String paramString)
  {
    this.geom = paramString;
  }
  
  public void setHeight(float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BuidingInfo: \n");
    localStringBuffer.append("; height = ");
    localStringBuffer.append(this.height);
    localStringBuffer.append("; accuracy = ");
    localStringBuffer.append(this.accuracy);
    localStringBuffer.append("; geom = ");
    localStringBuffer.append(this.geom);
    localStringBuffer.append("; center = ");
    localStringBuffer.append(this.center);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeString(this.geom);
    paramParcel.writeString(this.center);
  }
  
  static final class a
    implements Parcelable.Creator<BuildingInfo>
  {
    public BuildingInfo a(Parcel paramParcel)
    {
      return new BuildingInfo(paramParcel);
    }
    
    public BuildingInfo[] a(int paramInt)
    {
      return new BuildingInfo[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.BuildingInfo
 * JD-Core Version:    0.7.0.1
 */