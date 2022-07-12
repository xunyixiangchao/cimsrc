package z7;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  private static boolean a(String paramString, int paramInt, char paramChar)
  {
    return (paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar);
  }
  
  private static int b(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if (i >= 48)
      {
        if (i > 57) {
          return paramInt;
        }
        paramInt += 1;
      }
      else
      {
        return paramInt;
      }
    }
    return paramString.length();
  }
  
  public static Date c(String paramString, ParsePosition paramParsePosition)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    char c;
    label386:
    label431:
    Object localObject2;
    Object localObject3;
    try
    {
      i = paramParsePosition.getIndex();
      j = i + 4;
      i2 = d(paramString, i, j);
      i = j;
      if (a(paramString, j, '-')) {
        i = j + 1;
      }
      j = i + 2;
      i3 = d(paramString, i, j);
      i = j;
      if (a(paramString, j, '-')) {
        i = j + 1;
      }
      k = i + 2;
      i4 = d(paramString, i, k);
      boolean bool = a(paramString, k, 'T');
      if ((!bool) && (paramString.length() <= k))
      {
        localObject1 = new GregorianCalendar(i2, i3 - 1, i4);
        paramParsePosition.setIndex(k);
        return ((Calendar)localObject1).getTime();
      }
      if (!bool) {
        break label980;
      }
      i = k + 1;
      k = i + 2;
      j = d(paramString, i, k);
      i = k;
      if (a(paramString, k, ':')) {
        i = k + 1;
      }
      k = i + 2;
      m = d(paramString, i, k);
      i = k;
      if (a(paramString, k, ':')) {
        i = k + 1;
      }
      if (paramString.length() <= i) {
        break label977;
      }
      k = paramString.charAt(i);
      if ((k == 90) || (k == 43) || (k == 45)) {
        break label977;
      }
      n = i + 2;
      i = d(paramString, i, n);
      k = i;
      if (i > 59)
      {
        k = i;
        if (i < 63) {
          k = 59;
        }
      }
      if (!a(paramString, n, '.')) {
        break label968;
      }
      n += 1;
      i1 = b(paramString, n + 1);
      int i5 = Math.min(i1, n + 3);
      i = d(paramString, n, i5);
      n = i5 - n;
      if (n == 1) {
        break label954;
      }
      if (n == 2) {
        break label946;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      int i2;
      int i3;
      int i4;
      Object localObject1;
      break label763;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label763;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    if (paramString.length() > i)
    {
      c = paramString.charAt(i);
      if (c != 'Z') {
        break label998;
      }
      localObject1 = a;
      i += 1;
      break label651;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid time zone indicator '");
      ((StringBuilder)localObject1).append(c);
      ((StringBuilder)localObject1).append("'");
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
      localObject1 = paramString.substring(i);
      if (((String)localObject1).length() < 5)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("00");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      i += ((String)localObject1).length();
      if ((!"+0000".equals(localObject1)) && (!"+00:00".equals(localObject1)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GMT");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = TimeZone.getTimeZone((String)localObject2);
        localObject3 = ((TimeZone)localObject1).getID();
        if ((((String)localObject3).equals(localObject2)) || (((String)localObject3).replace(":", "").equals(localObject2))) {
          break label1013;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Mismatching time zone indicator: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" given, resolves to ");
        ((StringBuilder)localObject3).append(((TimeZone)localObject1).getID());
        throw new IndexOutOfBoundsException(((StringBuilder)localObject3).toString());
      }
      localObject1 = a;
    }
    label651:
    label946:
    label954:
    label959:
    label968:
    label977:
    label980:
    label989:
    label998:
    label1013:
    for (;;)
    {
      localObject1 = new GregorianCalendar((TimeZone)localObject1);
      ((Calendar)localObject1).setLenient(false);
      ((Calendar)localObject1).set(1, i2);
      ((Calendar)localObject1).set(2, i3 - 1);
      ((Calendar)localObject1).set(5, i4);
      ((Calendar)localObject1).set(11, j);
      ((Calendar)localObject1).set(12, m);
      ((Calendar)localObject1).set(13, k);
      ((Calendar)localObject1).set(14, n);
      paramParsePosition.setIndex(i);
      return ((Calendar)localObject1).getTime();
      throw new IllegalArgumentException("No time zone indicator");
      label763:
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append('"');
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append('"');
        paramString = ((StringBuilder)localObject2).toString();
      }
      localObject3 = localIndexOutOfBoundsException.getMessage();
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject3).isEmpty()) {}
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(localIndexOutOfBoundsException.getClass().getName());
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Failed to parse date [");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("]: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramString = new ParseException(((StringBuilder)localObject3).toString(), paramParsePosition.getIndex());
      paramString.initCause(localIndexOutOfBoundsException);
      throw paramString;
      i *= 10;
      break label959;
      i *= 100;
      n = i;
      i = i1;
      break;
      i = n;
      n = 0;
      break;
      break label989;
      j = 0;
      m = 0;
      i = k;
      n = 0;
      k = 0;
      break;
      if (c == '+') {
        break label431;
      }
      if (c != '-') {
        break label386;
      }
      break label431;
    }
  }
  
  private static int d(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramString.length()) && (paramInt1 <= paramInt2))
    {
      int i;
      int j;
      StringBuilder localStringBuilder;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0)
        {
          j = -j;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      else
      {
        j = 0;
        i = paramInt1;
      }
      while (i < paramInt2)
      {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0)
        {
          j = j * 10 - k;
          i += 1;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      return -j;
    }
    throw new NumberFormatException(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z7.a
 * JD-Core Version:    0.7.0.1
 */