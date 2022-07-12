package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class i
  extends Fragment
{
  private final a a;
  private final q2.h b = new a();
  private final Set<i> c = new HashSet();
  private i d;
  private k e;
  private Fragment f;
  
  public i()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  public i(a parama)
  {
    this.a = parama;
  }
  
  private void e(i parami)
  {
    this.c.add(parami);
  }
  
  private Fragment n()
  {
    Fragment localFragment = getParentFragment();
    if (localFragment != null) {
      return localFragment;
    }
    return this.f;
  }
  
  private static FragmentManager q(Fragment paramFragment)
  {
    while (paramFragment.getParentFragment() != null) {
      paramFragment = paramFragment.getParentFragment();
    }
    return paramFragment.getFragmentManager();
  }
  
  private boolean r(Fragment paramFragment)
  {
    Fragment localFragment1 = n();
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
  
  private void s(Context paramContext, FragmentManager paramFragmentManager)
  {
    w();
    paramContext = c.c(paramContext).k().k(paramFragmentManager);
    this.d = paramContext;
    if (!equals(paramContext)) {
      this.d.e(this);
    }
  }
  
  private void t(i parami)
  {
    this.c.remove(parami);
  }
  
  private void w()
  {
    i locali = this.d;
    if (locali != null)
    {
      locali.t(this);
      this.d = null;
    }
  }
  
  Set<i> j()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return Collections.emptySet();
    }
    if (equals(localObject)) {
      return Collections.unmodifiableSet(this.c);
    }
    localObject = new HashSet();
    Iterator localIterator = this.d.j().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (r(locali.n())) {
        ((Set)localObject).add(locali);
      }
    }
    return Collections.unmodifiableSet((Set)localObject);
  }
  
  a l()
  {
    return this.a;
  }
  
  public k o()
  {
    return this.e;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = q(this);
    if (paramContext == null)
    {
      if (Log.isLoggable("SupportRMFragment", 5)) {
        Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
      }
      return;
    }
    try
    {
      s(getContext(), paramContext);
      return;
    }
    catch (IllegalStateException paramContext)
    {
      if (Log.isLoggable("SupportRMFragment", 5)) {
        Log.w("SupportRMFragment", "Unable to register fragment with root", paramContext);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
    w();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.f = null;
    w();
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
  
  public q2.h p()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{parent=");
    localStringBuilder.append(n());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  void u(Fragment paramFragment)
  {
    this.f = paramFragment;
    if (paramFragment != null)
    {
      if (paramFragment.getContext() == null) {
        return;
      }
      FragmentManager localFragmentManager = q(paramFragment);
      if (localFragmentManager == null) {
        return;
      }
      s(paramFragment.getContext(), localFragmentManager);
    }
  }
  
  public void v(k paramk)
  {
    this.e = paramk;
  }
  
  private class a
    implements q2.h
  {
    a() {}
    
    public Set<k> a()
    {
      Object localObject = i.this.j();
      HashSet localHashSet = new HashSet(((Set)localObject).size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        if (locali.o() != null) {
          localHashSet.add(locali.o());
        }
      }
      return localHashSet;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("{fragment=");
      localStringBuilder.append(i.this);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.manager.i
 * JD-Core Version:    0.7.0.1
 */