package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0.h;

public final class CompositeDateValidator
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();
  private static final d c = new a();
  private static final d d = new b();
  private final d a;
  private final List<CalendarConstraints.DateValidator> b;
  
  private CompositeDateValidator(List<CalendarConstraints.DateValidator> paramList, d paramd)
  {
    this.b = paramList;
    this.a = paramd;
  }
  
  public boolean c(long paramLong)
  {
    return this.a.a(this.b, paramLong);
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
    if (!(paramObject instanceof CompositeDateValidator)) {
      return false;
    }
    paramObject = (CompositeDateValidator)paramObject;
    return (this.b.equals(paramObject.b)) && (this.a.getId() == paramObject.a.getId());
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.b);
    paramParcel.writeInt(this.a.getId());
  }
  
  class a
    implements CompositeDateValidator.d
  {
    public boolean a(List<CalendarConstraints.DateValidator> paramList, long paramLong)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)paramList.next();
        if ((localDateValidator != null) && (localDateValidator.c(paramLong))) {
          return true;
        }
      }
      return false;
    }
    
    public int getId()
    {
      return 1;
    }
  }
  
  class b
    implements CompositeDateValidator.d
  {
    public boolean a(List<CalendarConstraints.DateValidator> paramList, long paramLong)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)paramList.next();
        if ((localDateValidator != null) && (!localDateValidator.c(paramLong))) {
          return false;
        }
      }
      return true;
    }
    
    public int getId()
    {
      return 2;
    }
  }
  
  class c
    implements Parcelable.Creator<CompositeDateValidator>
  {
    public CompositeDateValidator a(Parcel paramParcel)
    {
      ArrayList localArrayList = paramParcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
      int i = paramParcel.readInt();
      if (i == 2) {}
      while (i != 1)
      {
        paramParcel = CompositeDateValidator.g();
        break;
      }
      paramParcel = CompositeDateValidator.h();
      return new CompositeDateValidator((List)h.g(localArrayList), paramParcel, null);
    }
    
    public CompositeDateValidator[] b(int paramInt)
    {
      return new CompositeDateValidator[paramInt];
    }
  }
  
  private static abstract interface d
  {
    public abstract boolean a(List<CalendarConstraints.DateValidator> paramList, long paramLong);
    
    public abstract int getId();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.CompositeDateValidator
 * JD-Core Version:    0.7.0.1
 */