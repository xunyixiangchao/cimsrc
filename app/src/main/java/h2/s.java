package h2;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b2.h;
import java.io.InputStream;

public class s<Data>
  implements n<Integer, Data>
{
  private final n<Uri, Data> a;
  private final Resources b;
  
  public s(Resources paramResources, n<Uri, Data> paramn)
  {
    this.b = paramResources;
    this.a = paramn;
  }
  
  private Uri d(Integer paramInteger)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.b.getResourcePackageName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceTypeName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceEntryName(paramInteger.intValue()));
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (Log.isLoggable("ResourceLoader", 5))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received invalid resource id: ");
        localStringBuilder.append(paramInteger);
        Log.w("ResourceLoader", localStringBuilder.toString(), localNotFoundException);
      }
    }
    return null;
  }
  
  public n.a<Data> c(Integer paramInteger, int paramInt1, int paramInt2, h paramh)
  {
    paramInteger = d(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return this.a.b(paramInteger, paramInt1, paramInt2, paramh);
  }
  
  public boolean e(Integer paramInteger)
  {
    return true;
  }
  
  public static final class a
    implements o<Integer, AssetFileDescriptor>
  {
    private final Resources a;
    
    public a(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public n<Integer, AssetFileDescriptor> b(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, AssetFileDescriptor.class));
    }
    
    public void c() {}
  }
  
  public static class b
    implements o<Integer, ParcelFileDescriptor>
  {
    private final Resources a;
    
    public b(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public n<Integer, ParcelFileDescriptor> b(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void c() {}
  }
  
  public static class c
    implements o<Integer, InputStream>
  {
    private final Resources a;
    
    public c(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public n<Integer, InputStream> b(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, InputStream.class));
    }
    
    public void c() {}
  }
  
  public static class d
    implements o<Integer, Uri>
  {
    private final Resources a;
    
    public d(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public n<Integer, Uri> b(r paramr)
    {
      return new s(this.a, v.c());
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.s
 * JD-Core Version:    0.7.0.1
 */