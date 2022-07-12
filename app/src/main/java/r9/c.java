package r9;

import a9.f;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
{
  private static final a a = new a();
  private static final String[] b;
  private static final DateFormat[] c;
  
  static
  {
    String[] arrayOfString = new String[15];
    arrayOfString[0] = "EEE, dd MMM yyyy HH:mm:ss zzz";
    arrayOfString[1] = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    arrayOfString[2] = "EEE MMM d HH:mm:ss yyyy";
    arrayOfString[3] = "EEE, dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[4] = "EEE, dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[5] = "EEE, dd MMM yy HH:mm:ss z";
    arrayOfString[6] = "EEE dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[7] = "EEE dd MMM yyyy HH:mm:ss z";
    arrayOfString[8] = "EEE dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[9] = "EEE dd-MMM-yy HH:mm:ss z";
    arrayOfString[10] = "EEE dd MMM yy HH:mm:ss z";
    arrayOfString[11] = "EEE,dd-MMM-yy HH:mm:ss z";
    arrayOfString[12] = "EEE,dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[13] = "EEE, dd-MM-yyyy HH:mm:ss z";
    arrayOfString[14] = "EEE MMM d yyyy HH:mm:ss z";
    b = arrayOfString;
    c = new DateFormat[arrayOfString.length];
  }
  
  public static final Date a(String paramString)
  {
    f.f(paramString, "<this>");
    int i;
    if (paramString.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = ((DateFormat)a.get()).parse(paramString, localParsePosition);
    if (localParsePosition.getIndex() == paramString.length()) {
      return localObject;
    }
    synchronized (b)
    {
      int j = ???.length;
      i = 0;
      while (i < j)
      {
        DateFormat[] arrayOfDateFormat = c;
        DateFormat localDateFormat = arrayOfDateFormat[i];
        localObject = localDateFormat;
        if (localDateFormat == null)
        {
          localObject = new SimpleDateFormat(b[i], Locale.US);
          ((SimpleDateFormat)localObject).setTimeZone(m9.o.d);
          arrayOfDateFormat[i] = localObject;
        }
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        int k = localParsePosition.getIndex();
        if (k != 0) {
          return localObject;
        }
        i += 1;
      }
      paramString = o8.o.a;
      return null;
    }
  }
  
  public static final String b(Date paramDate)
  {
    f.f(paramDate, "<this>");
    paramDate = ((DateFormat)a.get()).format(paramDate);
    f.e(paramDate, "STANDARD_DATE_FORMAT.get().format(this)");
    return paramDate;
  }
  
  public static final class a
    extends ThreadLocal<DateFormat>
  {
    protected DateFormat a()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setLenient(false);
      localSimpleDateFormat.setTimeZone(m9.o.d);
      return localSimpleDateFormat;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.c
 * JD-Core Version:    0.7.0.1
 */