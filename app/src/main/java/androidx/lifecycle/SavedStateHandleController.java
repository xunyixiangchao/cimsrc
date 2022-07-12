package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.a;
import androidx.savedstate.b;
import java.util.Iterator;
import java.util.Set;

final class SavedStateHandleController
  implements j
{
  private final String a;
  private boolean b = false;
  private final v c;
  
  SavedStateHandleController(String paramString, v paramv)
  {
    this.a = paramString;
    this.c = paramv;
  }
  
  static void a(x paramx, SavedStateRegistry paramSavedStateRegistry, h paramh)
  {
    paramx = (SavedStateHandleController)paramx.c("androidx.lifecycle.savedstate.vm.tag");
    if ((paramx != null) && (!paramx.g()))
    {
      paramx.c(paramSavedStateRegistry, paramh);
      h(paramSavedStateRegistry, paramh);
    }
  }
  
  static SavedStateHandleController e(SavedStateRegistry paramSavedStateRegistry, h paramh, String paramString, Bundle paramBundle)
  {
    paramString = new SavedStateHandleController(paramString, v.a(paramSavedStateRegistry.a(paramString), paramBundle));
    paramString.c(paramSavedStateRegistry, paramh);
    h(paramSavedStateRegistry, paramh);
    return paramString;
  }
  
  private static void h(final SavedStateRegistry paramSavedStateRegistry, h paramh)
  {
    h.c localc = paramh.b();
    if ((localc != h.c.b) && (!localc.a(h.c.d)))
    {
      paramh.a(new j()
      {
        public void d(l paramAnonymousl, h.b paramAnonymousb)
        {
          if (paramAnonymousb == h.b.ON_START)
          {
            SavedStateHandleController.this.c(this);
            paramSavedStateRegistry.e(SavedStateHandleController.a.class);
          }
        }
      });
      return;
    }
    paramSavedStateRegistry.e(a.class);
  }
  
  void c(SavedStateRegistry paramSavedStateRegistry, h paramh)
  {
    if (!this.b)
    {
      this.b = true;
      paramh.a(this);
      paramSavedStateRegistry.d(this.a, this.c.b());
      return;
    }
    throw new IllegalStateException("Already attached to lifecycleOwner");
  }
  
  public void d(l paraml, h.b paramb)
  {
    if (paramb == h.b.ON_DESTROY)
    {
      this.b = false;
      paraml.getLifecycle().c(this);
    }
  }
  
  v f()
  {
    return this.c;
  }
  
  boolean g()
  {
    return this.b;
  }
  
  static final class a
    implements SavedStateRegistry.a
  {
    public void a(b paramb)
    {
      if ((paramb instanceof a0))
      {
        z localz = ((a0)paramb).getViewModelStore();
        SavedStateRegistry localSavedStateRegistry = paramb.getSavedStateRegistry();
        Iterator localIterator = localz.c().iterator();
        while (localIterator.hasNext()) {
          SavedStateHandleController.a(localz.b((String)localIterator.next()), localSavedStateRegistry, paramb.getLifecycle());
        }
        if (!localz.c().isEmpty()) {
          localSavedStateRegistry.e(a.class);
        }
        return;
      }
      throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController
 * JD-Core Version:    0.7.0.1
 */