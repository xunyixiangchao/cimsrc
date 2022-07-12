package h2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import java.io.File;
import java.io.FileNotFoundException;

public final class k
  implements n<Uri, File>
{
  private final Context a;
  
  public k(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public n.a<File> c(Uri paramUri, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new w2.b(paramUri), new b(this.a, paramUri));
  }
  
  public boolean d(Uri paramUri)
  {
    return c2.b.b(paramUri);
  }
  
  public static final class a
    implements o<Uri, File>
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public n<Uri, File> b(r paramr)
    {
      return new k(this.a);
    }
    
    public void c() {}
  }
  
  private static class b
    implements d<File>
  {
    private static final String[] c = { "_data" };
    private final Context a;
    private final Uri b;
    
    b(Context paramContext, Uri paramUri)
    {
      this.a = paramContext;
      this.b = paramUri;
    }
    
    public Class<File> a()
    {
      return File.class;
    }
    
    public void b() {}
    
    public void cancel() {}
    
    public a e()
    {
      return a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, d.a<? super File> parama)
    {
      Cursor localCursor = this.a.getContentResolver().query(this.b, c, null, null, null);
      paramh = null;
      Object localObject = null;
      if (localCursor != null) {
        paramh = localObject;
      }
      try
      {
        if (localCursor.moveToFirst()) {
          paramh = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
        }
        localCursor.close();
      }
      finally
      {
        localCursor.close();
      }
      paramh = new StringBuilder();
      paramh.append("Failed to find file path for: ");
      paramh.append(this.b);
      parama.c(new FileNotFoundException(paramh.toString()));
      return;
      parama.d(new File(paramh));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.k
 * JD-Core Version:    0.7.0.1
 */