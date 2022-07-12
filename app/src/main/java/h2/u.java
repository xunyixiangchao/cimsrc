package h2;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import b2.h;
import java.io.File;
import java.io.InputStream;

public class u<Data>
  implements n<String, Data>
{
  private final n<Uri, Data> a;
  
  public u(n<Uri, Data> paramn)
  {
    this.a = paramn;
  }
  
  private static Uri e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.charAt(0) == '/') {}
    Uri localUri;
    do
    {
      return f(paramString);
      localUri = Uri.parse(paramString);
    } while (localUri.getScheme() == null);
    return localUri;
  }
  
  private static Uri f(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public n.a<Data> c(String paramString, int paramInt1, int paramInt2, h paramh)
  {
    paramString = e(paramString);
    if ((paramString != null) && (this.a.a(paramString))) {
      return this.a.b(paramString, paramInt1, paramInt2, paramh);
    }
    return null;
  }
  
  public boolean d(String paramString)
  {
    return true;
  }
  
  public static final class a
    implements o<String, AssetFileDescriptor>
  {
    public n<String, AssetFileDescriptor> b(r paramr)
    {
      return new u(paramr.d(Uri.class, AssetFileDescriptor.class));
    }
    
    public void c() {}
  }
  
  public static class b
    implements o<String, ParcelFileDescriptor>
  {
    public n<String, ParcelFileDescriptor> b(r paramr)
    {
      return new u(paramr.d(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void c() {}
  }
  
  public static class c
    implements o<String, InputStream>
  {
    public n<String, InputStream> b(r paramr)
    {
      return new u(paramr.d(Uri.class, InputStream.class));
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.u
 * JD-Core Version:    0.7.0.1
 */