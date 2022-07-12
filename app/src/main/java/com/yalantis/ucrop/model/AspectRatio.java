package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AspectRatio
  implements Parcelable
{
  public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator()
  {
    public AspectRatio createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AspectRatio(paramAnonymousParcel);
    }
    
    public AspectRatio[] newArray(int paramAnonymousInt)
    {
      return new AspectRatio[paramAnonymousInt];
    }
  };
  private final String mAspectRatioTitle;
  private final float mAspectRatioX;
  private final float mAspectRatioY;
  
  protected AspectRatio(Parcel paramParcel)
  {
    this.mAspectRatioTitle = paramParcel.readString();
    this.mAspectRatioX = paramParcel.readFloat();
    this.mAspectRatioY = paramParcel.readFloat();
  }
  
  public AspectRatio(String paramString, float paramFloat1, float paramFloat2)
  {
    this.mAspectRatioTitle = paramString;
    this.mAspectRatioX = paramFloat1;
    this.mAspectRatioY = paramFloat2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAspectRatioTitle()
  {
    return this.mAspectRatioTitle;
  }
  
  public float getAspectRatioX()
  {
    return this.mAspectRatioX;
  }
  
  public float getAspectRatioY()
  {
    return this.mAspectRatioY;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAspectRatioTitle);
    paramParcel.writeFloat(this.mAspectRatioX);
    paramParcel.writeFloat(this.mAspectRatioY);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.model.AspectRatio
 * JD-Core Version:    0.7.0.1
 */