package c2;

import android.net.Uri;
import java.util.List;

public final class b
{
  public static boolean a(Uri paramUri)
  {
    return (b(paramUri)) && (!e(paramUri));
  }
  
  public static boolean b(Uri paramUri)
  {
    return (paramUri != null) && ("content".equals(paramUri.getScheme())) && ("media".equals(paramUri.getAuthority()));
  }
  
  public static boolean c(Uri paramUri)
  {
    return (b(paramUri)) && (e(paramUri));
  }
  
  public static boolean d(int paramInt1, int paramInt2)
  {
    return (paramInt1 != -2147483648) && (paramInt2 != -2147483648) && (paramInt1 <= 512) && (paramInt2 <= 384);
  }
  
  private static boolean e(Uri paramUri)
  {
    return paramUri.getPathSegments().contains("video");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c2.b
 * JD-Core Version:    0.7.0.1
 */