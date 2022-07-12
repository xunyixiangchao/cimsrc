package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import b2.a;
import com.bumptech.glide.h;
import java.io.IOException;

public abstract class b<T>
  implements d<T>
{
  private final String a;
  private final AssetManager b;
  private T c;
  
  public b(AssetManager paramAssetManager, String paramString)
  {
    this.b = paramAssetManager;
    this.a = paramString;
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    try
    {
      c(localObject);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected abstract void c(T paramT);
  
  public void cancel() {}
  
  protected abstract T d(AssetManager paramAssetManager, String paramString);
  
  public a e()
  {
    return a.a;
  }
  
  public void f(h paramh, d.a<? super T> parama)
  {
    try
    {
      paramh = d(this.b, this.a);
      this.c = paramh;
      parama.d(paramh);
      return;
    }
    catch (IOException paramh)
    {
      if (Log.isLoggable("AssetPathFetcher", 3)) {
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", paramh);
      }
      parama.c(paramh);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.b
 * JD-Core Version:    0.7.0.1
 */