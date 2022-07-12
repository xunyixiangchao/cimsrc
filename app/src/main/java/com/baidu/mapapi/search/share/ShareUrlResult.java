package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;

public class ShareUrlResult
  extends SearchResult
{
  public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();
  private String a;
  private int b;
  
  public ShareUrlResult() {}
  
  protected ShareUrlResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public void setType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
  
  class a
    implements Parcelable.Creator<ShareUrlResult>
  {
    public ShareUrlResult a(Parcel paramParcel)
    {
      return new ShareUrlResult(paramParcel);
    }
    
    public ShareUrlResult[] a(int paramInt)
    {
      return new ShareUrlResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.share.ShareUrlResult
 * JD-Core Version:    0.7.0.1
 */