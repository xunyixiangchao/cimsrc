package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

class i
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  static void a(Context paramContext)
  {
    if (a.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
  }
  
  static class a
    extends e
  {
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      ReportFragment.g(paramActivity);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.i
 * JD-Core Version:    0.7.0.1
 */