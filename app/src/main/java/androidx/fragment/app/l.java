package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class l
  extends x
{
  private static final y.b j = new a();
  private final HashMap<String, Fragment> c = new HashMap();
  private final HashMap<String, l> d = new HashMap();
  private final HashMap<String, z> e = new HashMap();
  private final boolean f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  l(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  static l j(z paramz)
  {
    return (l)new y(paramz, j).a(l.class);
  }
  
  protected void d()
  {
    if (FragmentManager.G0(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCleared called for ");
      localStringBuilder.append(this);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.g = true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (l.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (l)paramObject;
      return (this.c.equals(paramObject.c)) && (this.d.equals(paramObject.d)) && (this.e.equals(paramObject.e));
    }
    return false;
  }
  
  void f(Fragment paramFragment)
  {
    if (this.i)
    {
      if (FragmentManager.G0(2)) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
      return;
    }
    if (this.c.containsKey(paramFragment.mWho)) {
      return;
    }
    this.c.put(paramFragment.mWho, paramFragment);
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Updating retained Fragments: Added ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  void g(Fragment paramFragment)
  {
    if (FragmentManager.G0(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Clearing non-config state for ");
      ((StringBuilder)localObject).append(paramFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = (l)this.d.get(paramFragment.mWho);
    if (localObject != null)
    {
      ((l)localObject).d();
      this.d.remove(paramFragment.mWho);
    }
    localObject = (z)this.e.get(paramFragment.mWho);
    if (localObject != null)
    {
      ((z)localObject).a();
      this.e.remove(paramFragment.mWho);
    }
  }
  
  Fragment h(String paramString)
  {
    return (Fragment)this.c.get(paramString);
  }
  
  public int hashCode()
  {
    return (this.c.hashCode() * 31 + this.d.hashCode()) * 31 + this.e.hashCode();
  }
  
  l i(Fragment paramFragment)
  {
    l locall2 = (l)this.d.get(paramFragment.mWho);
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l(this.f);
      this.d.put(paramFragment.mWho, locall1);
    }
    return locall1;
  }
  
  Collection<Fragment> k()
  {
    return new ArrayList(this.c.values());
  }
  
  z l(Fragment paramFragment)
  {
    z localz2 = (z)this.e.get(paramFragment.mWho);
    z localz1 = localz2;
    if (localz2 == null)
    {
      localz1 = new z();
      this.e.put(paramFragment.mWho, localz1);
    }
    return localz1;
  }
  
  boolean m()
  {
    return this.g;
  }
  
  void n(Fragment paramFragment)
  {
    if (this.i)
    {
      if (FragmentManager.G0(2)) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
      return;
    }
    int k;
    if (this.c.remove(paramFragment.mWho) != null) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (FragmentManager.G0(2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Updating retained Fragments: Removed ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  void o(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  boolean p(Fragment paramFragment)
  {
    if (!this.c.containsKey(paramFragment.mWho)) {
      return true;
    }
    if (this.f) {
      return this.g;
    }
    return this.h ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FragmentManagerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} Fragments (");
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") Child Non Config (");
    localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") ViewModelStores (");
    localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  class a
    implements y.b
  {
    public <T extends x> T a(Class<T> paramClass)
    {
      return new l(true);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.l
 * JD-Core Version:    0.7.0.1
 */