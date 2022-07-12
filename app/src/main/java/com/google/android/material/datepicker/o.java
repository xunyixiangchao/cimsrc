package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class o
{
  private static final o c = new o(null, null);
  private final Long a;
  private final TimeZone b;
  
  private o(Long paramLong, TimeZone paramTimeZone)
  {
    this.a = paramLong;
    this.b = paramTimeZone;
  }
  
  static o c()
  {
    return c;
  }
  
  Calendar a()
  {
    return b(this.b);
  }
  
  Calendar b(TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      paramTimeZone = Calendar.getInstance();
    } else {
      paramTimeZone = Calendar.getInstance(paramTimeZone);
    }
    Long localLong = this.a;
    if (localLong != null) {
      paramTimeZone.setTimeInMillis(localLong.longValue());
    }
    return paramTimeZone;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.o
 * JD-Core Version:    0.7.0.1
 */