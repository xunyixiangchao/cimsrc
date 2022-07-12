package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class p
{
  private final ArrayList<Fragment> a = new ArrayList();
  private final HashMap<String, o> b = new HashMap();
  private l c;
  
  void a(Fragment paramFragment)
  {
    if (!this.a.contains(paramFragment)) {
      synchronized (this.a)
      {
        this.a.add(paramFragment);
        paramFragment.mAdded = true;
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Fragment already added: ");
    ((StringBuilder)???).append(paramFragment);
    throw new IllegalStateException(((StringBuilder)???).toString());
  }
  
  void b()
  {
    this.b.values().removeAll(Collections.singleton(null));
  }
  
  boolean c(String paramString)
  {
    return this.b.get(paramString) != null;
  }
  
  void d(int paramInt)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localo.t(paramInt);
      }
    }
  }
  
  void e(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("    ");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!this.b.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Fragments:");
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (o)localIterator.next();
        paramPrintWriter.print(paramString);
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).k();
          paramPrintWriter.println(localObject2);
          ((Fragment)localObject2).dump((String)localObject1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        else
        {
          paramPrintWriter.println("null");
        }
      }
    }
    int j = this.a.size();
    if (j > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      int i = 0;
      while (i < j)
      {
        paramFileDescriptor = (Fragment)this.a.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
  }
  
  Fragment f(String paramString)
  {
    paramString = (o)this.b.get(paramString);
    if (paramString != null) {
      return paramString.k();
    }
    return null;
  }
  
  Fragment g(int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      localObject1 = (Fragment)this.a.get(i);
      if ((localObject1 != null) && (((Fragment)localObject1).mFragmentId == paramInt)) {
        return localObject1;
      }
      i -= 1;
    }
    Object localObject1 = this.b.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (o)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((o)localObject2).k();
        if (((Fragment)localObject2).mFragmentId == paramInt) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  Fragment h(String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        localObject1 = (Fragment)this.a.get(i);
        if ((localObject1 != null) && (paramString.equals(((Fragment)localObject1).mTag))) {
          return localObject1;
        }
        i -= 1;
      }
    }
    if (paramString != null)
    {
      localObject1 = this.b.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (o)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).k();
          if (paramString.equals(((Fragment)localObject2).mTag)) {
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  Fragment i(String paramString)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if (localObject != null)
      {
        localObject = ((o)localObject).k().findFragmentByWho(paramString);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  int j(Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    if (localViewGroup == null) {
      return -1;
    }
    int k = this.a.indexOf(paramFragment);
    int i = k - 1;
    int j;
    for (;;)
    {
      j = k;
      if (i < 0) {
        break;
      }
      paramFragment = (Fragment)this.a.get(i);
      if (paramFragment.mContainer == localViewGroup)
      {
        paramFragment = paramFragment.mView;
        if (paramFragment != null) {
          return localViewGroup.indexOfChild(paramFragment) + 1;
        }
      }
      i -= 1;
    }
    for (;;)
    {
      j += 1;
      if (j >= this.a.size()) {
        break;
      }
      paramFragment = (Fragment)this.a.get(j);
      if (paramFragment.mContainer == localViewGroup)
      {
        paramFragment = paramFragment.mView;
        if (paramFragment != null) {
          return localViewGroup.indexOfChild(paramFragment);
        }
      }
    }
    return -1;
  }
  
  List<o> k()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localArrayList.add(localo);
      }
    }
    return localArrayList;
  }
  
  List<Fragment> l()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if (localObject != null) {
        localObject = ((o)localObject).k();
      } else {
        localObject = null;
      }
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  o m(String paramString)
  {
    return (o)this.b.get(paramString);
  }
  
  List<Fragment> n()
  {
    if (this.a.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList(this.a);
      return localArrayList2;
    }
  }
  
  l o()
  {
    return this.c;
  }
  
  void p(o paramo)
  {
    Fragment localFragment = paramo.k();
    if (c(localFragment.mWho)) {
      return;
    }
    this.b.put(localFragment.mWho, paramo);
    if (localFragment.mRetainInstanceChangedWhileDetached)
    {
      if (localFragment.mRetainInstance) {
        this.c.f(localFragment);
      } else {
        this.c.n(localFragment);
      }
      localFragment.mRetainInstanceChangedWhileDetached = false;
    }
    if (FragmentManager.G0(2))
    {
      paramo = new StringBuilder();
      paramo.append("Added fragment to active set ");
      paramo.append(localFragment);
      Log.v("FragmentManager", paramo.toString());
    }
  }
  
  void q(o paramo)
  {
    paramo = paramo.k();
    if (paramo.mRetainInstance) {
      this.c.n(paramo);
    }
    if ((o)this.b.put(paramo.mWho, null) == null) {
      return;
    }
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Removed fragment from active set ");
      localStringBuilder.append(paramo);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  void r()
  {
    Iterator localIterator = this.a.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      localObject = (o)this.b.get(((Fragment)localObject).mWho);
      if (localObject != null) {
        ((o)localObject).m();
      }
    }
    localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (o)localIterator.next();
      if (localObject != null)
      {
        ((o)localObject).m();
        Fragment localFragment = ((o)localObject).k();
        int i;
        if ((localFragment.mRemoving) && (!localFragment.isInBackStack())) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          q((o)localObject);
        }
      }
    }
  }
  
  void s(Fragment paramFragment)
  {
    synchronized (this.a)
    {
      this.a.remove(paramFragment);
      paramFragment.mAdded = false;
      return;
    }
  }
  
  void t()
  {
    this.b.clear();
  }
  
  void u(List<String> paramList)
  {
    this.a.clear();
    if (paramList != null)
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (String)((Iterator)localObject).next();
        Fragment localFragment = f(paramList);
        if (localFragment != null)
        {
          if (FragmentManager.G0(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: added (");
            localStringBuilder.append(paramList);
            localStringBuilder.append("): ");
            localStringBuilder.append(localFragment);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          a(localFragment);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("No instantiated fragment for (");
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append(")");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  ArrayList<FragmentState> v()
  {
    ArrayList localArrayList = new ArrayList(this.b.size());
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if (localObject != null)
      {
        Fragment localFragment = ((o)localObject).k();
        localObject = ((o)localObject).r();
        localArrayList.add(localObject);
        if (FragmentManager.G0(2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Saved state of ");
          localStringBuilder.append(localFragment);
          localStringBuilder.append(": ");
          localStringBuilder.append(((FragmentState)localObject).m);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
    }
    return localArrayList;
  }
  
  ArrayList<String> w()
  {
    synchronized (this.a)
    {
      if (this.a.isEmpty()) {
        return null;
      }
      ArrayList localArrayList2 = new ArrayList(this.a.size());
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(localFragment.mWho);
        if (FragmentManager.G0(2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveAllState: adding fragment (");
          localStringBuilder.append(localFragment.mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
      return localArrayList2;
    }
  }
  
  void x(l paraml)
  {
    this.c = paraml;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.p
 * JD-Core Version:    0.7.0.1
 */