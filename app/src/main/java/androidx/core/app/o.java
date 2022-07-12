package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class o
  implements Iterable<Intent>
{
  private final ArrayList<Intent> a = new ArrayList();
  private final Context b;
  
  private o(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static o d(Context paramContext)
  {
    return new o(paramContext);
  }
  
  public o a(Intent paramIntent)
  {
    this.a.add(paramIntent);
    return this;
  }
  
  public o b(Activity paramActivity)
  {
    Object localObject1;
    if ((paramActivity instanceof a)) {
      localObject1 = ((a)paramActivity).getSupportParentActivityIntent();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = e.a(paramActivity);
    }
    if (localObject2 != null)
    {
      localObject1 = ((Intent)localObject2).getComponent();
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = ((Intent)localObject2).resolveActivity(this.b.getPackageManager());
      }
      c(paramActivity);
      a((Intent)localObject2);
    }
    return this;
  }
  
  public o c(ComponentName paramComponentName)
  {
    int i = this.a.size();
    try
    {
      Context localContext = this.b;
      Object localObject = paramComponentName;
      paramComponentName = localContext;
      for (;;)
      {
        localObject = e.b(paramComponentName, (ComponentName)localObject);
        if (localObject == null) {
          break;
        }
        this.a.add(i, localObject);
        paramComponentName = this.b;
        localObject = ((Intent)localObject).getComponent();
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  public void e()
  {
    f(null);
  }
  
  public void f(Bundle paramBundle)
  {
    if (!this.a.isEmpty())
    {
      Object localObject = this.a;
      localObject = (Intent[])((ArrayList)localObject).toArray(new Intent[((ArrayList)localObject).size()]);
      localObject[0] = new Intent(localObject[0]).addFlags(268484608);
      if (!b.i(this.b, (Intent[])localObject, paramBundle))
      {
        paramBundle = new Intent(localObject[(localObject.length - 1)]);
        paramBundle.addFlags(268435456);
        this.b.startActivity(paramBundle);
      }
      return;
    }
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  @Deprecated
  public Iterator<Intent> iterator()
  {
    return this.a.iterator();
  }
  
  public static abstract interface a
  {
    public abstract Intent getSupportParentActivityIntent();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.o
 * JD-Core Version:    0.7.0.1
 */