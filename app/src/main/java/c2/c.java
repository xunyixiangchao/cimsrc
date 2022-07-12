package c2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import b2.a;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.g;
import e2.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c
  implements com.bumptech.glide.load.data.d<InputStream>
{
  private final Uri a;
  private final e b;
  private InputStream c;
  
  c(Uri paramUri, e parame)
  {
    this.a = paramUri;
    this.b = parame;
  }
  
  private static c c(Context paramContext, Uri paramUri, d paramd)
  {
    b localb = com.bumptech.glide.c.c(paramContext).e();
    return new c(paramUri, new e(com.bumptech.glide.c.c(paramContext).j().g(), paramd, localb, paramContext.getContentResolver()));
  }
  
  public static c d(Context paramContext, Uri paramUri)
  {
    return c(paramContext, paramUri, new a(paramContext.getContentResolver()));
  }
  
  public static c g(Context paramContext, Uri paramUri)
  {
    return c(paramContext, paramUri, new b(paramContext.getContentResolver()));
  }
  
  private InputStream h()
  {
    InputStream localInputStream = this.b.d(this.a);
    int i;
    if (localInputStream != null) {
      i = this.b.a(this.a);
    } else {
      i = -1;
    }
    Object localObject = localInputStream;
    if (i != -1) {
      localObject = new g(localInputStream, i);
    }
    return localObject;
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void b()
  {
    InputStream localInputStream = this.c;
    if (localInputStream != null) {}
    try
    {
      localInputStream.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void cancel() {}
  
  public a e()
  {
    return a.a;
  }
  
  public void f(h paramh, d.a<? super InputStream> parama)
  {
    try
    {
      paramh = h();
      this.c = paramh;
      parama.d(paramh);
      return;
    }
    catch (FileNotFoundException paramh)
    {
      if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", paramh);
      }
      parama.c(paramh);
    }
  }
  
  static class a
    implements d
  {
    private static final String[] b = { "_data" };
    private final ContentResolver a;
    
    a(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public Cursor a(Uri paramUri)
    {
      paramUri = paramUri.getLastPathSegment();
      return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[] { paramUri }, null);
    }
  }
  
  static class b
    implements d
  {
    private static final String[] b = { "_data" };
    private final ContentResolver a;
    
    b(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public Cursor a(Uri paramUri)
    {
      paramUri = paramUri.getLastPathSegment();
      return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[] { paramUri }, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c2.c
 * JD-Core Version:    0.7.0.1
 */