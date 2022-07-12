package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.farsunset.hoxin.common.GlobalGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl
  extends GeneratedAppGlideModule
{
  private final GlobalGlideModule a = new GlobalGlideModule();
  
  public GeneratedAppGlideModuleImpl(Context paramContext)
  {
    if (Log.isLoggable("Glide", 3))
    {
      Log.d("Glide", "Discovered AppGlideModule from annotation: com.farsunset.hoxin.common.GlobalGlideModule");
      Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
    }
  }
  
  public void a(Context paramContext, c paramc, i parami)
  {
    new com.bumptech.glide.integration.okhttp3.a().a(paramContext, paramc, parami);
    this.a.a(paramContext, paramc, parami);
  }
  
  public void b(Context paramContext, d paramd)
  {
    this.a.b(paramContext, paramd);
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  public Set<Class<?>> d()
  {
    return Collections.emptySet();
  }
  
  a f()
  {
    return new a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.GeneratedAppGlideModuleImpl
 * JD-Core Version:    0.7.0.1
 */