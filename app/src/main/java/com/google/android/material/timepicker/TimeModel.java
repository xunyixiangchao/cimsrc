package com.google.android.material.timepicker;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class TimeModel
  implements Parcelable
{
  public static final Parcelable.Creator<TimeModel> CREATOR = new a();
  private final a a;
  private final a b;
  final int c;
  int d;
  int e;
  int f;
  int g;
  
  public TimeModel()
  {
    this(0);
  }
  
  public TimeModel(int paramInt)
  {
    this(0, 0, 10, paramInt);
  }
  
  public TimeModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.c = paramInt4;
    this.g = i(paramInt1);
    this.a = new a(59);
    if (paramInt4 == 1) {
      paramInt1 = 24;
    } else {
      paramInt1 = 12;
    }
    this.b = new a(paramInt1);
  }
  
  protected TimeModel(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public static String g(Resources paramResources, CharSequence paramCharSequence)
  {
    return h(paramResources, paramCharSequence, "%02d");
  }
  
  public static String h(Resources paramResources, CharSequence paramCharSequence, String paramString)
  {
    return String.format(paramResources.getConfiguration().locale, paramString, new Object[] { Integer.valueOf(Integer.parseInt(String.valueOf(paramCharSequence))) });
  }
  
  private static int i(int paramInt)
  {
    if (paramInt >= 12) {
      return 1;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TimeModel)) {
      return false;
    }
    paramObject = (TimeModel)paramObject;
    return (this.d == paramObject.d) && (this.e == paramObject.e) && (this.c == paramObject.c) && (this.f == paramObject.f);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.c);
  }
  
  class a
    implements Parcelable.Creator<TimeModel>
  {
    public TimeModel a(Parcel paramParcel)
    {
      return new TimeModel(paramParcel);
    }
    
    public TimeModel[] b(int paramInt)
    {
      return new TimeModel[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.TimeModel
 * JD-Core Version:    0.7.0.1
 */