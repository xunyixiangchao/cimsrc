package m2;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import b2.h;
import b2.j;
import d2.v;
import java.util.List;

public class e
  implements j<Uri, Drawable>
{
  private final Context a;
  
  public e(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private Context d(Uri paramUri, String paramString)
  {
    if (paramString.equals(this.a.getPackageName())) {
      return this.a;
    }
    try
    {
      Context localContext = this.a.createPackageContext(paramString, 0);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (paramString.contains(this.a.getPackageName())) {
        return this.a;
      }
      paramString = new StringBuilder();
      paramString.append("Failed to obtain context or unrecognized Uri format for: ");
      paramString.append(paramUri);
      throw new IllegalArgumentException(paramString.toString(), localNameNotFoundException);
    }
  }
  
  private int e(Uri paramUri)
  {
    List localList = paramUri.getPathSegments();
    try
    {
      int i = Integer.parseInt((String)localList.get(0));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unrecognized Uri format: ");
      localStringBuilder.append(paramUri);
      throw new IllegalArgumentException(localStringBuilder.toString(), localNumberFormatException);
    }
  }
  
  private int f(Context paramContext, Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    String str1 = paramUri.getAuthority();
    String str2 = (String)((List)localObject).get(0);
    localObject = (String)((List)localObject).get(1);
    int j = paramContext.getResources().getIdentifier((String)localObject, str2, str1);
    int i = j;
    if (j == 0) {
      i = Resources.getSystem().getIdentifier((String)localObject, str2, "android");
    }
    if (i != 0) {
      return i;
    }
    paramContext = new StringBuilder();
    paramContext.append("Failed to find resource id for: ");
    paramContext.append(paramUri);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  private int g(Context paramContext, Uri paramUri)
  {
    List localList = paramUri.getPathSegments();
    if (localList.size() == 2) {
      return f(paramContext, paramUri);
    }
    if (localList.size() == 1) {
      return e(paramUri);
    }
    paramContext = new StringBuilder();
    paramContext.append("Unrecognized Uri format: ");
    paramContext.append(paramUri);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public v<Drawable> c(Uri paramUri, int paramInt1, int paramInt2, h paramh)
  {
    paramh = d(paramUri, paramUri.getAuthority());
    paramInt1 = g(paramh, paramUri);
    return d.f(b.b(this.a, paramh, paramInt1));
  }
  
  public boolean h(Uri paramUri, h paramh)
  {
    return paramUri.getScheme().equals("android.resource");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m2.e
 * JD-Core Version:    0.7.0.1
 */