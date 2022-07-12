package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlugInBean
  implements Parcelable
{
  public static final Parcelable.Creator<PlugInBean> CREATOR = new a();
  public final String a;
  public final String b;
  public final String c;
  
  public PlugInBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public PlugInBean(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("plid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" plV:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" plUUID:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
  
  static final class a
    implements Parcelable.Creator<PlugInBean>
  {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.PlugInBean
 * JD-Core Version:    0.7.0.1
 */