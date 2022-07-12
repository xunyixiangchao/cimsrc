package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class h0
  extends ContextWrapper
{
  private static final Object c = new Object();
  private static ArrayList<WeakReference<h0>> d;
  private final Resources a;
  private final Resources.Theme b;
  
  private h0(Context paramContext)
  {
    super(paramContext);
    if (q0.d())
    {
      Object localObject = new q0(this, paramContext.getResources());
      this.a = ((Resources)localObject);
      localObject = ((Resources)localObject).newTheme();
      this.b = ((Resources.Theme)localObject);
      ((Resources.Theme)localObject).setTo(paramContext.getTheme());
      return;
    }
    this.a = new j0(this, paramContext.getResources());
    this.b = null;
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool3 = paramContext instanceof h0;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!(paramContext.getResources() instanceof j0))
      {
        if ((paramContext.getResources() instanceof q0)) {
          return false;
        }
        bool1 = bool2;
        if (q0.d()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static Context b(Context paramContext)
  {
    if (a(paramContext)) {}
    for (;;)
    {
      int i;
      synchronized (c)
      {
        localObject1 = d;
        if (localObject1 == null)
        {
          d = new ArrayList();
        }
        else
        {
          i = ((ArrayList)localObject1).size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)d.get(i);
            if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
              break label168;
            }
            d.remove(i);
            break label168;
          }
          i = d.size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)d.get(i);
            if (localObject1 == null) {
              break label175;
            }
            localObject1 = (h0)((WeakReference)localObject1).get();
            if ((localObject1 == null) || (((ContextWrapper)localObject1).getBaseContext() != paramContext)) {
              break label180;
            }
            return localObject1;
          }
        }
        paramContext = new h0(paramContext);
        d.add(new WeakReference(paramContext));
        return paramContext;
      }
      return paramContext;
      label168:
      i -= 1;
      continue;
      label175:
      Object localObject1 = null;
      continue;
      label180:
      i -= 1;
    }
  }
  
  public AssetManager getAssets()
  {
    return this.a.getAssets();
  }
  
  public Resources getResources()
  {
    return this.a;
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme2 = this.b;
    Resources.Theme localTheme1 = localTheme2;
    if (localTheme2 == null) {
      localTheme1 = super.getTheme();
    }
    return localTheme1;
  }
  
  public void setTheme(int paramInt)
  {
    Resources.Theme localTheme = this.b;
    if (localTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    localTheme.applyStyle(paramInt, true);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.h0
 * JD-Core Version:    0.7.0.1
 */