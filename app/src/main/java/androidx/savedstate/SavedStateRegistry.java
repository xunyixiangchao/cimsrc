package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.Iterator;
import java.util.Map.Entry;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry
{
  private j.b<String, b> a = new j.b();
  private Bundle b;
  private boolean c;
  private Recreator.a d;
  boolean e = true;
  
  public Bundle a(String paramString)
  {
    if (this.c)
    {
      Bundle localBundle = this.b;
      if (localBundle != null)
      {
        localBundle = localBundle.getBundle(paramString);
        this.b.remove(paramString);
        if (this.b.isEmpty()) {
          this.b = null;
        }
        return localBundle;
      }
      return null;
    }
    throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
  }
  
  void b(h paramh, Bundle paramBundle)
  {
    if (!this.c)
    {
      if (paramBundle != null) {
        this.b = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
      }
      paramh.a(new j()
      {
        public void d(l paramAnonymousl, h.b paramAnonymousb)
        {
          if (paramAnonymousb == h.b.ON_START) {
            paramAnonymousl = SavedStateRegistry.this;
          }
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousl.e = bool;
            return;
            if (paramAnonymousb != h.b.ON_STOP) {
              break;
            }
            paramAnonymousl = SavedStateRegistry.this;
          }
        }
      });
      this.c = true;
      return;
    }
    throw new IllegalStateException("SavedStateRegistry was already restored.");
  }
  
  void c(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Object localObject = this.b;
    if (localObject != null) {
      localBundle.putAll((Bundle)localObject);
    }
    localObject = this.a.d();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localBundle.putBundle((String)localEntry.getKey(), ((b)localEntry.getValue()).a());
    }
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
  }
  
  public void d(String paramString, b paramb)
  {
    if ((b)this.a.g(paramString, paramb) == null) {
      return;
    }
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
  }
  
  public void e(Class<? extends a> paramClass)
  {
    if (this.e)
    {
      if (this.d == null) {
        this.d = new Recreator.a(this);
      }
      try
      {
        paramClass.getDeclaredConstructor(new Class[0]);
        this.d.b(paramClass.getName());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Class");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(localStringBuilder.toString(), localNoSuchMethodException);
      }
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
  
  public static abstract interface b
  {
    public abstract Bundle a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.savedstate.SavedStateRegistry
 * JD-Core Version:    0.7.0.1
 */