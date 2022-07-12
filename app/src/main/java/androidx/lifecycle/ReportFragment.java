package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;

public class ReportFragment
  extends Fragment
{
  private a a;
  
  static void a(Activity paramActivity, h.b paramb)
  {
    if ((paramActivity instanceof n))
    {
      ((n)paramActivity).getLifecycle().h(paramb);
      return;
    }
    if ((paramActivity instanceof l))
    {
      paramActivity = ((l)paramActivity).getLifecycle();
      if ((paramActivity instanceof m)) {
        ((m)paramActivity).h(paramb);
      }
    }
  }
  
  private void b(h.b paramb)
  {
    if (Build.VERSION.SDK_INT < 29) {
      a(getActivity(), paramb);
    }
  }
  
  private void c(a parama)
  {
    if (parama != null) {
      parama.b();
    }
  }
  
  private void d(a parama)
  {
    if (parama != null) {
      parama.onResume();
    }
  }
  
  private void e(a parama)
  {
    if (parama != null) {
      parama.a();
    }
  }
  
  static ReportFragment f(Activity paramActivity)
  {
    return (ReportFragment)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public static void g(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      b.registerIn(paramActivity);
    }
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  void h(a parama)
  {
    this.a = parama;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c(this.a);
    b(h.b.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(h.b.ON_DESTROY);
    this.a = null;
  }
  
  public void onPause()
  {
    super.onPause();
    b(h.b.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    d(this.a);
    b(h.b.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    e(this.a);
    b(h.b.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    b(h.b.ON_STOP);
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void onResume();
  }
  
  static class b
    implements Application.ActivityLifecycleCallbacks
  {
    static void registerIn(Activity paramActivity)
    {
      paramActivity.registerActivityLifecycleCallbacks(new b());
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
    {
      ReportFragment.a(paramActivity, h.b.ON_CREATE);
    }
    
    public void onActivityPostResumed(Activity paramActivity)
    {
      ReportFragment.a(paramActivity, h.b.ON_RESUME);
    }
    
    public void onActivityPostStarted(Activity paramActivity)
    {
      ReportFragment.a(paramActivity, h.b.ON_START);
    }
    
    public void onActivityPreDestroyed(Activity paramActivity)
    {
      ReportFragment.a(paramActivity, h.b.ON_DESTROY);
    }
    
    public void onActivityPrePaused(Activity paramActivity)
    {
      ReportFragment.a(paramActivity, h.b.ON_PAUSE);
    }
    
    public void onActivityPreStopped(Activity paramActivity)
    {
      ReportFragment.a(paramActivity, h.b.ON_STOP);
    }
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.ReportFragment
 * JD-Core Version:    0.7.0.1
 */