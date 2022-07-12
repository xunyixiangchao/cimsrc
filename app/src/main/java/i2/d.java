package i2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import b2.a;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class d<DataT>
  implements n<Uri, DataT>
{
  private final Context a;
  private final n<File, DataT> b;
  private final n<Uri, DataT> c;
  private final Class<DataT> d;
  
  d(Context paramContext, n<File, DataT> paramn, n<Uri, DataT> paramn1, Class<DataT> paramClass)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramn;
    this.c = paramn1;
    this.d = paramClass;
  }
  
  public n.a<DataT> c(Uri paramUri, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new w2.b(paramUri), new d(this.a, this.b, this.c, paramUri, paramInt1, paramInt2, paramh, this.d));
  }
  
  public boolean d(Uri paramUri)
  {
    return (Build.VERSION.SDK_INT >= 29) && (c2.b.b(paramUri));
  }
  
  private static abstract class a<DataT>
    implements o<Uri, DataT>
  {
    private final Context a;
    private final Class<DataT> b;
    
    a(Context paramContext, Class<DataT> paramClass)
    {
      this.a = paramContext;
      this.b = paramClass;
    }
    
    public final n<Uri, DataT> b(r paramr)
    {
      return new d(this.a, paramr.d(File.class, this.b), paramr.d(Uri.class, this.b), this.b);
    }
    
    public final void c() {}
  }
  
  public static final class b
    extends d.a<ParcelFileDescriptor>
  {
    public b(Context paramContext)
    {
      super(ParcelFileDescriptor.class);
    }
  }
  
  public static final class c
    extends d.a<InputStream>
  {
    public c(Context paramContext)
    {
      super(InputStream.class);
    }
  }
  
  private static final class d<DataT>
    implements com.bumptech.glide.load.data.d<DataT>
  {
    private static final String[] k = { "_data" };
    private final Context a;
    private final n<File, DataT> b;
    private final n<Uri, DataT> c;
    private final Uri d;
    private final int e;
    private final int f;
    private final b2.h g;
    private final Class<DataT> h;
    private volatile boolean i;
    private volatile com.bumptech.glide.load.data.d<DataT> j;
    
    d(Context paramContext, n<File, DataT> paramn, n<Uri, DataT> paramn1, Uri paramUri, int paramInt1, int paramInt2, b2.h paramh, Class<DataT> paramClass)
    {
      this.a = paramContext.getApplicationContext();
      this.b = paramn;
      this.c = paramn1;
      this.d = paramUri;
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = paramh;
      this.h = paramClass;
    }
    
    private n.a<DataT> c()
    {
      if (Environment.isExternalStorageLegacy()) {
        return this.b.b(h(this.d), this.e, this.f, this.g);
      }
      Uri localUri;
      if (g()) {
        localUri = MediaStore.setRequireOriginal(this.d);
      } else {
        localUri = this.d;
      }
      return this.c.b(localUri, this.e, this.f, this.g);
    }
    
    private com.bumptech.glide.load.data.d<DataT> d()
    {
      n.a locala = c();
      if (locala != null) {
        return locala.c;
      }
      return null;
    }
    
    private boolean g()
    {
      return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
    }
    
    private File h(Uri paramUri)
    {
      Object localObject1 = null;
      try
      {
        Cursor localCursor = this.a.getContentResolver().query(paramUri, k, null, null, null);
        if (localCursor != null)
        {
          localObject1 = localCursor;
          if (localCursor.moveToFirst())
          {
            localObject1 = localCursor;
            localObject2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
            localObject1 = localCursor;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localCursor;
              paramUri = new File((String)localObject2);
              localCursor.close();
              return paramUri;
            }
            localObject1 = localCursor;
            localObject2 = new StringBuilder();
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append("File path was empty in media store for: ");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(paramUri);
            localObject1 = localCursor;
            throw new FileNotFoundException(((StringBuilder)localObject2).toString());
          }
        }
        localObject1 = localCursor;
        Object localObject2 = new StringBuilder();
        localObject1 = localCursor;
        ((StringBuilder)localObject2).append("Failed to media store entry for: ");
        localObject1 = localCursor;
        ((StringBuilder)localObject2).append(paramUri);
        localObject1 = localCursor;
        throw new FileNotFoundException(((StringBuilder)localObject2).toString());
      }
      finally
      {
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    
    public Class<DataT> a()
    {
      return this.h;
    }
    
    public void b()
    {
      com.bumptech.glide.load.data.d locald = this.j;
      if (locald != null) {
        locald.b();
      }
    }
    
    public void cancel()
    {
      this.i = true;
      com.bumptech.glide.load.data.d locald = this.j;
      if (locald != null) {
        locald.cancel();
      }
    }
    
    public a e()
    {
      return a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, com.bumptech.glide.load.data.d.a<? super DataT> parama)
    {
      try
      {
        com.bumptech.glide.load.data.d locald = d();
        if (locald == null)
        {
          paramh = new StringBuilder();
          paramh.append("Failed to build fetcher for: ");
          paramh.append(this.d);
          parama.c(new IllegalArgumentException(paramh.toString()));
          return;
        }
        this.j = locald;
        if (this.i)
        {
          cancel();
          return;
        }
        locald.f(paramh, parama);
        return;
      }
      catch (FileNotFoundException paramh)
      {
        parama.c(paramh);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i2.d
 * JD-Core Version:    0.7.0.1
 */