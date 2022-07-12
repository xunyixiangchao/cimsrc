package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

class j
{
  private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
  private final FragmentManager b;
  
  j(FragmentManager paramFragmentManager)
  {
    this.b = paramFragmentManager;
  }
  
  void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Fragment localFragment = this.b.x0();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().w0().a(paramFragment, paramBundle, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (a)paramFragment.next();
      if ((!paramBoolean) || (paramBundle.a))
      {
        Objects.requireNonNull(paramBundle);
        throw null;
      }
    }
  }
  
  void b(Fragment paramFragment, boolean paramBoolean)
  {
    this.b.u0().f();
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().b(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Fragment localFragment = this.b.x0();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().w0().c(paramFragment, paramBundle, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (a)paramFragment.next();
      if ((!paramBoolean) || (paramBundle.a))
      {
        Objects.requireNonNull(paramBundle);
        throw null;
      }
    }
  }
  
  void d(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().d(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void e(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().e(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void f(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().f(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void g(Fragment paramFragment, boolean paramBoolean)
  {
    this.b.u0().f();
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().g(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void h(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Fragment localFragment = this.b.x0();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().w0().h(paramFragment, paramBundle, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (a)paramFragment.next();
      if ((!paramBoolean) || (paramBundle.a))
      {
        Objects.requireNonNull(paramBundle);
        throw null;
      }
    }
  }
  
  void i(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().i(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void j(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Fragment localFragment = this.b.x0();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().w0().j(paramFragment, paramBundle, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (a)paramFragment.next();
      if ((!paramBoolean) || (paramBundle.a))
      {
        Objects.requireNonNull(paramBundle);
        throw null;
      }
    }
  }
  
  void k(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().k(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void l(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().l(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  void m(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    Fragment localFragment = this.b.x0();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().w0().m(paramFragment, paramView, paramBundle, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      paramView = (a)paramFragment.next();
      if ((!paramBoolean) || (paramView.a))
      {
        Objects.requireNonNull(paramView);
        throw null;
      }
    }
  }
  
  void n(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.b.x0();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().w0().n(paramFragment, true);
    }
    paramFragment = this.a.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (a)paramFragment.next();
      if ((!paramBoolean) || (((a)localObject).a))
      {
        Objects.requireNonNull(localObject);
        throw null;
      }
    }
  }
  
  private static final class a
  {
    final boolean a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.j
 * JD-Core Version:    0.7.0.1
 */