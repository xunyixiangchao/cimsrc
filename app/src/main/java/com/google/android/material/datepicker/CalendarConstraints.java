package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import x0.c;

public final class CalendarConstraints
  implements Parcelable
{
  public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
  private final Month a;
  private final Month b;
  private final DateValidator c;
  private Month d;
  private final int e;
  private final int f;
  
  private CalendarConstraints(Month paramMonth1, Month paramMonth2, DateValidator paramDateValidator, Month paramMonth3)
  {
    this.a = paramMonth1;
    this.b = paramMonth2;
    this.d = paramMonth3;
    this.c = paramDateValidator;
    if ((paramMonth3 != null) && (paramMonth1.g(paramMonth3) > 0)) {
      throw new IllegalArgumentException("start Month cannot be after current Month");
    }
    if ((paramMonth3 != null) && (paramMonth3.g(paramMonth2) > 0)) {
      throw new IllegalArgumentException("current Month cannot be after end Month");
    }
    this.f = (paramMonth1.t(paramMonth2) + 1);
    this.e = (paramMonth2.c - paramMonth1.c + 1);
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
    if (!(paramObject instanceof CalendarConstraints)) {
      return false;
    }
    paramObject = (CalendarConstraints)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (c.a(this.d, paramObject.d)) && (this.c.equals(paramObject.c));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, this.b, this.d, this.c });
  }
  
  Month n(Month paramMonth)
  {
    if (paramMonth.g(this.a) < 0) {
      return this.a;
    }
    Month localMonth = paramMonth;
    if (paramMonth.g(this.b) > 0) {
      localMonth = this.b;
    }
    return localMonth;
  }
  
  public DateValidator o()
  {
    return this.c;
  }
  
  Month p()
  {
    return this.b;
  }
  
  int q()
  {
    return this.f;
  }
  
  Month r()
  {
    return this.d;
  }
  
  Month s()
  {
    return this.a;
  }
  
  int t()
  {
    return this.e;
  }
  
  boolean u(long paramLong)
  {
    if (this.a.o(1) <= paramLong)
    {
      Month localMonth = this.b;
      if (paramLong <= localMonth.o(localMonth.e)) {
        return true;
      }
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 0);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeParcelable(this.c, 0);
  }
  
  public static abstract interface DateValidator
    extends Parcelable
  {
    public abstract boolean c(long paramLong);
  }
  
  class a
    implements Parcelable.Creator<CalendarConstraints>
  {
    public CalendarConstraints a(Parcel paramParcel)
    {
      Month localMonth1 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      Month localMonth2 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      Month localMonth3 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      return new CalendarConstraints(localMonth1, localMonth2, (CalendarConstraints.DateValidator)paramParcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()), localMonth3, null);
    }
    
    public CalendarConstraints[] b(int paramInt)
    {
      return new CalendarConstraints[paramInt];
    }
  }
  
  public static final class b
  {
    static final long e = p.a(Month.h(1900, 0).f);
    static final long f = p.a(Month.h(2100, 11).f);
    private long a = e;
    private long b = f;
    private Long c;
    private CalendarConstraints.DateValidator d = DateValidatorPointForward.g(-9223372036854775808L);
    
    b(CalendarConstraints paramCalendarConstraints)
    {
      this.a = CalendarConstraints.g(paramCalendarConstraints).f;
      this.b = CalendarConstraints.h(paramCalendarConstraints).f;
      this.c = Long.valueOf(CalendarConstraints.i(paramCalendarConstraints).f);
      this.d = CalendarConstraints.m(paramCalendarConstraints);
    }
    
    public CalendarConstraints a()
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("DEEP_COPY_VALIDATOR_KEY", this.d);
      Month localMonth1 = Month.i(this.a);
      Month localMonth2 = Month.i(this.b);
      CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)((Bundle)localObject).getParcelable("DEEP_COPY_VALIDATOR_KEY");
      localObject = this.c;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Month.i(((Long)localObject).longValue());
      }
      return new CalendarConstraints(localMonth1, localMonth2, localDateValidator, (Month)localObject, null);
    }
    
    public b b(long paramLong)
    {
      this.c = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints
 * JD-Core Version:    0.7.0.1
 */