package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class DateValidatorPointForward
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();
  private final long a;
  
  private DateValidatorPointForward(long paramLong)
  {
    this.a = paramLong;
  }
  
  public static DateValidatorPointForward g(long paramLong)
  {
    return new DateValidatorPointForward(paramLong);
  }
  
  public boolean c(long paramLong)
  {
    return paramLong >= this.a;
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
    if (!(paramObject instanceof DateValidatorPointForward)) {
      return false;
    }
    paramObject = (DateValidatorPointForward)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
  }
  
  class a
    implements Parcelable.Creator<DateValidatorPointForward>
  {
    public DateValidatorPointForward a(Parcel paramParcel)
    {
      return new DateValidatorPointForward(paramParcel.readLong(), null);
    }
    
    public DateValidatorPointForward[] b(int paramInt)
    {
      return new DateValidatorPointForward[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.DateValidatorPointForward
 * JD-Core Version:    0.7.0.1
 */