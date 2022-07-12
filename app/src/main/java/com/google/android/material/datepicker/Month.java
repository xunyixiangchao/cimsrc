package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month
  implements Comparable<Month>, Parcelable
{
  public static final Parcelable.Creator<Month> CREATOR = new a();
  private final Calendar a;
  final int b;
  final int c;
  final int d;
  final int e;
  final long f;
  private String g;
  
  private Month(Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    paramCalendar = p.f(paramCalendar);
    this.a = paramCalendar;
    this.b = paramCalendar.get(2);
    this.c = paramCalendar.get(1);
    this.d = paramCalendar.getMaximum(7);
    this.e = paramCalendar.getActualMaximum(5);
    this.f = paramCalendar.getTimeInMillis();
  }
  
  static Month h(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = p.q();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return new Month(localCalendar);
  }
  
  static Month i(long paramLong)
  {
    Calendar localCalendar = p.q();
    localCalendar.setTimeInMillis(paramLong);
    return new Month(localCalendar);
  }
  
  static Month m()
  {
    return new Month(p.o());
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
    if (!(paramObject instanceof Month)) {
      return false;
    }
    paramObject = (Month)paramObject;
    return (this.b == paramObject.b) && (this.c == paramObject.c);
  }
  
  public int g(Month paramMonth)
  {
    return this.a.compareTo(paramMonth.a);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
  
  int n()
  {
    int j = this.a.get(7) - this.a.getFirstDayOfWeek();
    int i = j;
    if (j < 0) {
      i = j + this.d;
    }
    return i;
  }
  
  long o(int paramInt)
  {
    Calendar localCalendar = p.f(this.a);
    localCalendar.set(5, paramInt);
    return localCalendar.getTimeInMillis();
  }
  
  int p(long paramLong)
  {
    Calendar localCalendar = p.f(this.a);
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
  
  String q()
  {
    if (this.g == null) {
      this.g = d.i(this.a.getTimeInMillis());
    }
    return this.g;
  }
  
  long r()
  {
    return this.a.getTimeInMillis();
  }
  
  Month s(int paramInt)
  {
    Calendar localCalendar = p.f(this.a);
    localCalendar.add(2, paramInt);
    return new Month(localCalendar);
  }
  
  int t(Month paramMonth)
  {
    if ((this.a instanceof GregorianCalendar)) {
      return (paramMonth.c - this.c) * 12 + (paramMonth.b - this.b);
    }
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.b);
  }
  
  class a
    implements Parcelable.Creator<Month>
  {
    public Month a(Parcel paramParcel)
    {
      return Month.h(paramParcel.readInt(), paramParcel.readInt());
    }
    
    public Month[] b(int paramInt)
    {
      return new Month[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.Month
 * JD-Core Version:    0.7.0.1
 */