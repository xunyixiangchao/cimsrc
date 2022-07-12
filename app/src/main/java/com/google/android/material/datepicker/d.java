package com.google.android.material.datepicker;

import android.os.Build.VERSION;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class d
{
  static x0.d<String, String> a(Long paramLong1, Long paramLong2)
  {
    return b(paramLong1, paramLong2, null);
  }
  
  static x0.d<String, String> b(Long paramLong1, Long paramLong2, SimpleDateFormat paramSimpleDateFormat)
  {
    if ((paramLong1 == null) && (paramLong2 == null)) {
      return x0.d.a(null, null);
    }
    if (paramLong1 == null) {
      return x0.d.a(null, d(paramLong2.longValue(), paramSimpleDateFormat));
    }
    if (paramLong2 == null) {
      return x0.d.a(d(paramLong1.longValue(), paramSimpleDateFormat), null);
    }
    Calendar localCalendar1 = p.o();
    Calendar localCalendar2 = p.q();
    localCalendar2.setTimeInMillis(paramLong1.longValue());
    Calendar localCalendar3 = p.q();
    localCalendar3.setTimeInMillis(paramLong2.longValue());
    if (paramSimpleDateFormat != null)
    {
      paramLong1 = new Date(paramLong1.longValue());
      paramLong2 = new Date(paramLong2.longValue());
      return x0.d.a(paramSimpleDateFormat.format(paramLong1), paramSimpleDateFormat.format(paramLong2));
    }
    if (localCalendar2.get(1) == localCalendar3.get(1))
    {
      if (localCalendar2.get(1) == localCalendar1.get(1)) {
        return x0.d.a(f(paramLong1.longValue(), Locale.getDefault()), f(paramLong2.longValue(), Locale.getDefault()));
      }
      return x0.d.a(f(paramLong1.longValue(), Locale.getDefault()), k(paramLong2.longValue(), Locale.getDefault()));
    }
    return x0.d.a(k(paramLong1.longValue(), Locale.getDefault()), k(paramLong2.longValue(), Locale.getDefault()));
  }
  
  static String c(long paramLong)
  {
    return d(paramLong, null);
  }
  
  static String d(long paramLong, SimpleDateFormat paramSimpleDateFormat)
  {
    Calendar localCalendar1 = p.o();
    Calendar localCalendar2 = p.q();
    localCalendar2.setTimeInMillis(paramLong);
    if (paramSimpleDateFormat != null) {
      return paramSimpleDateFormat.format(new Date(paramLong));
    }
    if (localCalendar1.get(1) == localCalendar2.get(1)) {
      return e(paramLong);
    }
    return j(paramLong);
  }
  
  static String e(long paramLong)
  {
    return f(paramLong, Locale.getDefault());
  }
  
  static String f(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return p.c(paramLocale).format(new Date(paramLong));
    }
    return p.j(paramLocale).format(new Date(paramLong));
  }
  
  static String g(long paramLong)
  {
    return h(paramLong, Locale.getDefault());
  }
  
  static String h(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return p.d(paramLocale).format(new Date(paramLong));
    }
    return p.h(paramLocale).format(new Date(paramLong));
  }
  
  static String i(long paramLong)
  {
    return DateUtils.formatDateTime(null, paramLong, 8228);
  }
  
  static String j(long paramLong)
  {
    return k(paramLong, Locale.getDefault());
  }
  
  static String k(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return p.s(paramLocale).format(new Date(paramLong));
    }
    return p.i(paramLocale).format(new Date(paramLong));
  }
  
  static String l(long paramLong)
  {
    return m(paramLong, Locale.getDefault());
  }
  
  static String m(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return p.t(paramLocale).format(new Date(paramLong));
    }
    return p.h(paramLocale).format(new Date(paramLong));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.d
 * JD-Core Version:    0.7.0.1
 */