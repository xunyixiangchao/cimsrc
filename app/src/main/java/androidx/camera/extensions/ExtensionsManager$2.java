package androidx.camera.extensions;

import androidx.camera.extensions.impl.InitializerImpl.OnExtensionsDeinitializedCallback;
import androidx.concurrent.futures.c.a;

class ExtensionsManager$2
  implements InitializerImpl.OnExtensionsDeinitializedCallback
{
  ExtensionsManager$2(ExtensionsManager paramExtensionsManager, c.a parama) {}
  
  public void onFailure(int paramInt)
  {
    this.val$completer.f(new Exception("Failed to deinitialize extensions."));
  }
  
  public void onSuccess()
  {
    this.val$completer.c(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.extensions.ExtensionsManager.2
 * JD-Core Version:    0.7.0.1
 */