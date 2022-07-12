package x7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class j
{
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return "M/d/yy";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown DateFormat style: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return "MMM d, yyyy";
      }
      return "MMMM d, yyyy";
    }
    return "EEEE, MMMM d, yyyy";
  }
  
  private static String b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return "h:mm a";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown DateFormat style: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return "h:mm:ss a";
    }
    return "h:mm:ss a z";
  }
  
  public static DateFormat c(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt1));
    localStringBuilder.append(" ");
    localStringBuilder.append(b(paramInt2));
    return new SimpleDateFormat(localStringBuilder.toString(), Locale.US);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.j
 * JD-Core Version:    0.7.0.1
 */