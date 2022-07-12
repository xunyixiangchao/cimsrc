package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class PoiRegion
  implements Parcelable
{
  public static final Parcelable.Creator<PoiRegion> CREATOR = new Parcelable.Creator()
  {
    public PoiRegion createFromParcel(Parcel paramAnonymousParcel)
    {
      String str = paramAnonymousParcel.readString();
      return new PoiRegion(paramAnonymousParcel.readString(), str, paramAnonymousParcel.readString());
    }
    
    public PoiRegion[] newArray(int paramAnonymousInt)
    {
      return new PoiRegion[paramAnonymousInt];
    }
  };
  private final String mDirectionDesc;
  private final String mName;
  private final String mTag;
  
  public PoiRegion(PoiRegion paramPoiRegion)
  {
    this.mName = paramPoiRegion.getName();
    this.mDirectionDesc = paramPoiRegion.getDerectionDesc();
    this.mTag = paramPoiRegion.getTags();
  }
  
  public PoiRegion(String paramString1, String paramString2, String paramString3)
  {
    this.mName = paramString2;
    this.mDirectionDesc = paramString1;
    this.mTag = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDerectionDesc()
  {
    return this.mDirectionDesc;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getTags()
  {
    return this.mTag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mDirectionDesc);
    paramParcel.writeString(this.mTag);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.PoiRegion
 * JD-Core Version:    0.7.0.1
 */