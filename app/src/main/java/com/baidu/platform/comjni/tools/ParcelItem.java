package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelItem> CREATOR = new a();
  private Bundle a;
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getBundle()
  {
    return this.a;
  }
  
  public void setBundle(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
  }
  
  static final class a
    implements Parcelable.Creator<ParcelItem>
  {
    public ParcelItem a(Parcel paramParcel)
    {
      ParcelItem localParcelItem = new ParcelItem();
      localParcelItem.setBundle(paramParcel.readBundle());
      return localParcelItem;
    }
    
    public ParcelItem[] a(int paramInt)
    {
      return new ParcelItem[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.tools.ParcelItem
 * JD-Core Version:    0.7.0.1
 */