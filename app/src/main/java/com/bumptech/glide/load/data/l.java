package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import b2.a;
import com.bumptech.glide.h;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T>
  implements d<T>
{
  private final Uri a;
  private final ContentResolver b;
  private T c;
  
  public l(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.b = paramContentResolver;
    this.a = paramUri;
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {}
    try
    {
      c(localObject);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected abstract void c(T paramT);
  
  public void cancel() {}
  
  protected abstract T d(Uri paramUri, ContentResolver paramContentResolver);
  
  public a e()
  {
    return a.a;
  }
  
  public final void f(h paramh, d.a<? super T> parama)
  {
    try
    {
      paramh = d(this.a, this.b);
      this.c = paramh;
      parama.d(paramh);
      return;
    }
    catch (FileNotFoundException paramh)
    {
      if (Log.isLoggable("LocalUriFetcher", 3)) {
        Log.d("LocalUriFetcher", "Failed to open Uri", paramh);
      }
      parama.c(paramh);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.l
 * JD-Core Version:    0.7.0.1
 */