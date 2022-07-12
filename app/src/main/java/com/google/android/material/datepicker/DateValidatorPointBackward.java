package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class DateValidatorPointBackward
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();
  private final long a;
  
  private DateValidatorPointBackward(long paramLong)
  {
    this.a = paramLong;
  }
  
  public boolean c(long paramLong)
  {
    return paramLong <= this.a;
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
    if (!(paramObject instanceof DateValidatorPointBackward)) {
      return false;
    }
    paramObject = (DateValidatorPointBackward)paramObject;
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
    implements Parcelable.Creator<DateValidatorPointBackward>
  {
    public DateValidatorPointBackward a(Parcel paramParcel)
    {
      return new DateValidatorPointBackward(paramParcel.readLong(), null);
    }
    
    public DateValidatorPointBackward[] b(int paramInt)
    {
      return new DateValidatorPointBackward[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.DateValidatorPointBackward
 * JD-Core Version:    0.7.0.1
 */