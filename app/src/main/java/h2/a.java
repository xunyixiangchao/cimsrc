package h2;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.m;
import java.io.InputStream;
import java.util.List;
import w2.b;

public class a<Data>
  implements n<Uri, Data>
{
  private static final int c = 22;
  private final AssetManager a;
  private final a<Data> b;
  
  public a(AssetManager paramAssetManager, a<Data> parama)
  {
    this.a = paramAssetManager;
    this.b = parama;
  }
  
  public n.a<Data> c(Uri paramUri, int paramInt1, int paramInt2, b2.h paramh)
  {
    paramh = paramUri.toString().substring(c);
    return new n.a(new b(paramUri), this.b.a(this.a, paramh));
  }
  
  public boolean d(Uri paramUri)
  {
    boolean bool3 = "file".equals(paramUri.getScheme());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!paramUri.getPathSegments().isEmpty())
      {
        bool1 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static abstract interface a<Data>
  {
    public abstract d<Data> a(AssetManager paramAssetManager, String paramString);
  }
  
  public static class b
    implements o<Uri, AssetFileDescriptor>, a.a<AssetFileDescriptor>
  {
    private final AssetManager a;
    
    public b(AssetManager paramAssetManager)
    {
      this.a = paramAssetManager;
    }
    
    public d<AssetFileDescriptor> a(AssetManager paramAssetManager, String paramString)
    {
      return new com.bumptech.glide.load.data.h(paramAssetManager, paramString);
    }
    
    public n<Uri, AssetFileDescriptor> b(r paramr)
    {
      return new a(this.a, this);
    }
    
    public void c() {}
  }
  
  public static class c
    implements o<Uri, InputStream>, a.a<InputStream>
  {
    private final AssetManager a;
    
    public c(AssetManager paramAssetManager)
    {
      this.a = paramAssetManager;
    }
    
    public d<InputStream> a(AssetManager paramAssetManager, String paramString)
    {
      return new m(paramAssetManager, paramString);
    }
    
    public n<Uri, InputStream> b(r paramr)
    {
      return new a(this.a, this);
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.a
 * JD-Core Version:    0.7.0.1
 */