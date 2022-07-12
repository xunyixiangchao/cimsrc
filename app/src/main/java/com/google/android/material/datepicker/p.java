package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import com.google.android.material.R.string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

class p
{
  static AtomicReference<o> a = new AtomicReference();
  
  static long a(long paramLong)
  {
    Calendar localCalendar = q();
    localCalendar.setTimeInMillis(paramLong);
    return f(localCalendar).getTimeInMillis();
  }
  
  private static int b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    while ((paramInt2 >= 0) && (paramInt2 < paramString1.length()) && (paramString2.indexOf(paramString1.charAt(paramInt2)) == -1))
    {
      int i = paramInt2;
      if (paramString1.charAt(paramInt2) == '\'') {
        do
        {
          paramInt2 += paramInt1;
          i = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          i = paramInt2;
          if (paramInt2 >= paramString1.length()) {
            break;
          }
          i = paramInt2;
        } while (paramString1.charAt(paramInt2) != '\'');
      }
      paramInt2 = i + paramInt1;
    }
    return paramInt2;
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat c(Locale paramLocale)
  {
    return e("MMMd", paramLocale);
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat d(Locale paramLocale)
  {
    return e("MMMEd", paramLocale);
  }
  
  @TargetApi(24)
  private static android.icu.text.DateFormat e(String paramString, Locale paramLocale)
  {
    paramString = android.icu.text.DateFormat.getInstanceForSkeleton(paramString, paramLocale);
    paramString.setTimeZone(p());
    return paramString;
  }
  
  static Calendar f(Calendar paramCalendar)
  {
    paramCalendar = r(paramCalendar);
    Calendar localCalendar = q();
    localCalendar.set(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    return localCalendar;
  }
  
  private static java.text.DateFormat g(int paramInt, Locale paramLocale)
  {
    paramLocale = java.text.DateFormat.getDateInstance(paramInt, paramLocale);
    paramLocale.setTimeZone(n());
    return paramLocale;
  }
  
  static java.text.DateFormat h(Locale paramLocale)
  {
    return g(0, paramLocale);
  }
  
  static java.text.DateFormat i(Locale paramLocale)
  {
    return g(2, paramLocale);
  }
  
  static java.text.DateFormat j(Locale paramLocale)
  {
    paramLocale = (SimpleDateFormat)i(paramLocale);
    paramLocale.applyPattern(u(paramLocale.toPattern()));
    return paramLocale;
  }
  
  static SimpleDateFormat k()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(((SimpleDateFormat)java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
    localSimpleDateFormat.setTimeZone(n());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat;
  }
  
  static String l(Resources paramResources, SimpleDateFormat paramSimpleDateFormat)
  {
    paramSimpleDateFormat = paramSimpleDateFormat.toPattern();
    String str1 = paramResources.getString(R.string.mtrl_picker_text_input_year_abbr);
    String str2 = paramResources.getString(R.string.mtrl_picker_text_input_month_abbr);
    String str3 = paramResources.getString(R.string.mtrl_picker_text_input_day_abbr);
    paramResources = paramSimpleDateFormat;
    if (paramSimpleDateFormat.replaceAll("[^y]", "").length() == 1) {
      paramResources = paramSimpleDateFormat.replace("y", "yyyy");
    }
    return paramResources.replace("d", str3).replace("M", str2).replace("y", str1);
  }
  
  static o m()
  {
    o localo2 = (o)a.get();
    o localo1 = localo2;
    if (localo2 == null) {
      localo1 = o.c();
    }
    return localo1;
  }
  
  private static java.util.TimeZone n()
  {
    return java.util.TimeZone.getTimeZone("UTC");
  }
  
  static Calendar o()
  {
    Calendar localCalendar = m().a();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    localCalendar.setTimeZone(n());
    return localCalendar;
  }
  
  @TargetApi(24)
  private static android.icu.util.TimeZone p()
  {
    return android.icu.util.TimeZone.getTimeZone("UTC");
  }
  
  static Calendar q()
  {
    return r(null);
  }
  
  static Calendar r(Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance(n());
    if (paramCalendar == null)
    {
      localCalendar.clear();
      return localCalendar;
    }
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    return localCalendar;
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat s(Locale paramLocale)
  {
    return e("yMMMd", paramLocale);
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat t(Locale paramLocale)
  {
    return e("yMMMEd", paramLocale);
  }
  
  private static String u(String paramString)
  {
    int i = b(paramString, "yY", 1, 0);
    if (i >= paramString.length()) {
      return paramString;
    }
    Object localObject = "EMd";
    int j = b(paramString, "EMd", 1, i);
    if (j < paramString.length())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EMd");
      ((StringBuilder)localObject).append(",");
      localObject = ((StringBuilder)localObject).toString();
    }
    return paramString.replace(paramString.substring(b(paramString, (String)localObject, -1, i) + 1, j), " ").trim();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.p
 * JD-Core Version:    0.7.0.1
 */