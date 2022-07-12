package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Poi
  implements Parcelable
{
  public static final Parcelable.Creator<Poi> CREATOR = new Parcelable.Creator()
  {
    public Poi createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Poi(paramAnonymousParcel.readString(), paramAnonymousParcel.readString(), paramAnonymousParcel.readDouble(), paramAnonymousParcel.readString(), paramAnonymousParcel.readString());
    }
    
    public Poi[] newArray(int paramAnonymousInt)
    {
      return new Poi[paramAnonymousInt];
    }
  };
  private final String mAddr;
  private final String mId;
  private final String mName;
  private final double mRank;
  private final String mTags;
  
  public Poi(String paramString1, String paramString2, double paramDouble, String paramString3, String paramString4)
  {
    this.mId = paramString1;
    this.mName = paramString2;
    this.mRank = paramDouble;
    this.mTags = paramString3;
    this.mAddr = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddr()
  {
    return this.mAddr;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public double getRank()
  {
    return this.mRank;
  }
  
  public String getTags()
  {
    return this.mTags;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeString(this.mName);
    paramParcel.writeDouble(this.mRank);
    paramParcel.writeString(this.mTags);
    paramParcel.writeString(this.mAddr);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.Poi
 * JD-Core Version:    0.7.0.1
 */