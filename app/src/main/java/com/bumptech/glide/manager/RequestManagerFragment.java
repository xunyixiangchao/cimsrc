package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Deprecated
public class RequestManagerFragment
  extends Fragment
{
  private final a a;
  private final q2.h b = new a();
  private final Set<RequestManagerFragment> c = new HashSet();
  private k d;
  private RequestManagerFragment e;
  private Fragment f;
  
  public RequestManagerFragment()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  RequestManagerFragment(a parama)
  {
    this.a = parama;
  }
  
  private void a(RequestManagerFragment paramRequestManagerFragment)
  {
    this.c.add(paramRequestManagerFragment);
  }
  
  @TargetApi(17)
  private Fragment d()
  {
    Fragment localFragment = getParentFragment();
    if (localFragment != null) {
      return localFragment;
    }
    return this.f;
  }
  
  @TargetApi(17)
  private boolean g(Fragment paramFragment)
  {
    Fragment localFragment1 = getParentFragment();
    for (;;)
    {
      Fragment localFragment2 = paramFragment.getParentFragment();
      if (localFragment2 == null) {
        break;
      }
      if (localFragment2.equals(localFragment1)) {
        return true;
      }
      paramFragment = paramFragment.getParentFragment();
    }
    return false;
  }
  
  private void h(Activity paramActivity)
  {
    l();
    paramActivity = c.c(paramActivity).k().i(paramActivity);
    this.e = paramActivity;
    if (!equals(paramActivity)) {
      this.e.a(this);
    }
  }
  
  private void i(RequestManagerFragment paramRequestManagerFragment)
  {
    this.c.remove(paramRequestManagerFragment);
  }
  
  private void l()
  {
    RequestManagerFragment localRequestManagerFragment = this.e;
    if (localRequestManagerFragment != null)
    {
      localRequestManagerFragment.i(this);
      this.e = null;
    }
  }
  
  @TargetApi(17)
  Set<RequestManagerFragment> b()
  {
    if (equals(this.e)) {
      return Collections.unmodifiableSet(this.c);
    }
    if (this.e != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.e.b().iterator();
      while (localIterator.hasNext())
      {
        RequestManagerFragment localRequestManagerFragment = (RequestManagerFragment)localIterator.next();
        if (g(localRequestManagerFragment.getParentFragment())) {
          localHashSet.add(localRequestManagerFragment);
        }
      }
      return Collections.unmodifiableSet(localHashSet);
    }
    return Collections.emptySet();
  }
  
  a c()
  {
    return this.a;
  }
  
  public k e()
  {
    return this.d;
  }
  
  public q2.h f()
  {
    return this.b;
  }
  
  void j(Fragment paramFragment)
  {
    this.f = paramFragment;
    if ((paramFragment != null) && (paramFragment.getActivity() != null)) {
      h(paramFragment.getActivity());
    }
  }
  
  public void k(k paramk)
  {
    this.d = paramk;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      h(paramActivity);
      return;
    }
    catch (IllegalStateException paramActivity)
    {
      if (Log.isLoggable("RMFragment", 5)) {
        Log.w("RMFragment", "Unable to register fragment with root", paramActivity);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
    l();
  }
  
  public void onDetach()
  {
    super.onDetach();
    l();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.d();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.e();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{parent=");
    localStringBuilder.append(d());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private class a
    implements q2.h
  {
    a() {}
    
    public Set<k> a()
    {
      Object localObject = RequestManagerFragment.this.b();
      HashSet localHashSet = new HashSet(((Set)localObject).size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RequestManagerFragment localRequestManagerFragment = (RequestManagerFragment)((Iterator)localObject).next();
        if (localRequestManagerFragment.e() != null) {
          localHashSet.add(localRequestManagerFragment.e());
        }
      }
      return localHashSet;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("{fragment=");
      localStringBuilder.append(RequestManagerFragment.this);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.manager.RequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */