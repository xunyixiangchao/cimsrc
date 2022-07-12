package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R.id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import u0.b;
import u0.b.a;

abstract class w
{
  private final ViewGroup a;
  final ArrayList<e> b = new ArrayList();
  final ArrayList<e> c = new ArrayList();
  boolean d = false;
  boolean e = false;
  
  w(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  private void a(final w.e.c paramc, w.e.b paramb, o paramo)
  {
    synchronized (this.b)
    {
      b localb = new b();
      e locale = h(paramo.k());
      if (locale != null)
      {
        locale.k(paramc, paramb);
        return;
      }
      paramc = new d(paramc, paramb, paramo, localb);
      this.b.add(paramc);
      paramc.a(new a(paramc));
      paramc.a(new b(paramc));
      return;
    }
  }
  
  private e h(Fragment paramFragment)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.f().equals(paramFragment)) && (!locale.h())) {
        return locale;
      }
    }
    return null;
  }
  
  private e i(Fragment paramFragment)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.f().equals(paramFragment)) && (!locale.h())) {
        return locale;
      }
    }
    return null;
  }
  
  static w n(ViewGroup paramViewGroup, FragmentManager paramFragmentManager)
  {
    return o(paramViewGroup, paramFragmentManager.z0());
  }
  
  static w o(ViewGroup paramViewGroup, x paramx)
  {
    int i = R.id.special_effects_controller_view_tag;
    Object localObject = paramViewGroup.getTag(i);
    if ((localObject instanceof w)) {
      return (w)localObject;
    }
    paramx = paramx.a(paramViewGroup);
    paramViewGroup.setTag(i, paramx);
    return paramx;
  }
  
  private void q()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.g() == w.e.b.b) {
        locale.k(w.e.c.b(locale.f().requireView().getVisibility()), w.e.b.a);
      }
    }
  }
  
  void b(w.e.c paramc, o paramo)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing add operation for fragment ");
      localStringBuilder.append(paramo.k());
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(paramc, w.e.b.b, paramo);
  }
  
  void c(o paramo)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
      localStringBuilder.append(paramo.k());
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(w.e.c.c, w.e.b.a, paramo);
  }
  
  void d(o paramo)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
      localStringBuilder.append(paramo.k());
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(w.e.c.a, w.e.b.c, paramo);
  }
  
  void e(o paramo)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing show operation for fragment ");
      localStringBuilder.append(paramo.k());
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(w.e.c.b, w.e.b.a, paramo);
  }
  
  abstract void f(List<e> paramList, boolean paramBoolean);
  
  void g()
  {
    if (this.e) {
      return;
    }
    if (!androidx.core.view.x.T(this.a))
    {
      j();
      this.d = false;
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.isEmpty())
      {
        Object localObject1 = new ArrayList(this.c);
        this.c.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (e)((Iterator)localObject1).next();
          if (FragmentManager.G0(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SpecialEffectsController: Cancelling operation ");
            localStringBuilder.append(localObject3);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          ((e)localObject3).b();
          if (!((e)localObject3).i()) {
            this.c.add(localObject3);
          }
        }
        q();
        localObject1 = new ArrayList(this.b);
        this.b.clear();
        this.c.addAll((Collection)localObject1);
        Object localObject3 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((e)((Iterator)localObject3).next()).l();
        }
        f((List)localObject1, this.d);
        this.d = false;
      }
      return;
    }
  }
  
  void j()
  {
    boolean bool = androidx.core.view.x.T(this.a);
    synchronized (this.b)
    {
      q();
      Object localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((e)((Iterator)localObject1).next()).l();
      }
      Iterator localIterator = new ArrayList(this.c).iterator();
      e locale;
      StringBuilder localStringBuilder;
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (FragmentManager.G0(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SpecialEffectsController: ");
          if (bool)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Container ");
            ((StringBuilder)localObject1).append(this.a);
            ((StringBuilder)localObject1).append(" is not attached to window. ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("Cancelling running operation ");
          localStringBuilder.append(locale);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        locale.b();
      }
      localIterator = new ArrayList(this.b).iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (FragmentManager.G0(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SpecialEffectsController: ");
          if (bool)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Container ");
            ((StringBuilder)localObject1).append(this.a);
            ((StringBuilder)localObject1).append(" is not attached to window. ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("Cancelling pending operation ");
          localStringBuilder.append(locale);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        locale.b();
      }
      return;
    }
  }
  
  void k()
  {
    if (this.e)
    {
      this.e = false;
      g();
    }
  }
  
  w.e.b l(o paramo)
  {
    Object localObject = h(paramo.k());
    if (localObject != null) {
      localObject = ((e)localObject).g();
    } else {
      localObject = null;
    }
    paramo = i(paramo.k());
    if ((paramo != null) && ((localObject == null) || (localObject == w.e.b.a))) {
      return paramo.g();
    }
    return localObject;
  }
  
  public ViewGroup m()
  {
    return this.a;
  }
  
  void p()
  {
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        q();
        this.e = false;
        i = this.b.size() - 1;
        if (i >= 0)
        {
          e locale = (e)this.b.get(i);
          w.e.c localc1 = w.e.c.c(locale.f().mView);
          w.e.c localc2 = locale.e();
          w.e.c localc3 = w.e.c.b;
          if ((localc2 != localc3) || (localc1 == localc3)) {
            break label101;
          }
          this.e = locale.f().isPostponed();
        }
        return;
      }
      label101:
      i -= 1;
    }
  }
  
  void r(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  class a
    implements Runnable
  {
    a(w.d paramd) {}
    
    public void run()
    {
      if (w.this.b.contains(paramc)) {
        paramc.e().a(paramc.f().mView);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(w.d paramd) {}
    
    public void run()
    {
      w.this.b.remove(paramc);
      w.this.c.remove(paramc);
    }
  }
  
  private static class d
    extends w.e
  {
    private final o h;
    
    d(w.e.c paramc, w.e.b paramb, o paramo, b paramb1)
    {
      super(paramb, paramo.k(), paramb1);
      this.h = paramo;
    }
    
    public void c()
    {
      super.c();
      this.h.m();
    }
    
    void l()
    {
      if (g() == w.e.b.b)
      {
        Fragment localFragment = this.h.k();
        View localView = localFragment.mView.findFocus();
        if (localView != null)
        {
          localFragment.setFocusedView(localView);
          if (FragmentManager.G0(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestFocus: Saved focused view ");
            localStringBuilder.append(localView);
            localStringBuilder.append(" for Fragment ");
            localStringBuilder.append(localFragment);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
        }
        localView = f().requireView();
        if (localView.getParent() == null)
        {
          this.h.b();
          localView.setAlpha(0.0F);
        }
        if ((localView.getAlpha() == 0.0F) && (localView.getVisibility() == 0)) {
          localView.setVisibility(4);
        }
        localView.setAlpha(localFragment.getPostOnViewCreatedAlpha());
      }
    }
  }
  
  static class e
  {
    private c a;
    private b b;
    private final Fragment c;
    private final List<Runnable> d = new ArrayList();
    private final HashSet<b> e = new HashSet();
    private boolean f = false;
    private boolean g = false;
    
    e(c paramc, b paramb, Fragment paramFragment, b paramb1)
    {
      this.a = paramc;
      this.b = paramb;
      this.c = paramFragment;
      paramb1.d(new a());
    }
    
    final void a(Runnable paramRunnable)
    {
      this.d.add(paramRunnable);
    }
    
    final void b()
    {
      if (h()) {
        return;
      }
      this.f = true;
      if (this.e.isEmpty())
      {
        c();
        return;
      }
      Iterator localIterator = new ArrayList(this.e).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).a();
      }
    }
    
    public void c()
    {
      if (this.g) {
        return;
      }
      if (FragmentManager.G0(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SpecialEffectsController: ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" has called complete.");
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      this.g = true;
      Object localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    
    public final void d(b paramb)
    {
      if ((this.e.remove(paramb)) && (this.e.isEmpty())) {
        c();
      }
    }
    
    public c e()
    {
      return this.a;
    }
    
    public final Fragment f()
    {
      return this.c;
    }
    
    b g()
    {
      return this.b;
    }
    
    final boolean h()
    {
      return this.f;
    }
    
    final boolean i()
    {
      return this.g;
    }
    
    public final void j(b paramb)
    {
      l();
      this.e.add(paramb);
    }
    
    final void k(c paramc, b paramb)
    {
      int i = w.c.b[paramb.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (this.a != c.a)
          {
            if (FragmentManager.G0(2))
            {
              paramb = new StringBuilder();
              paramb.append("SpecialEffectsController: For fragment ");
              paramb.append(this.c);
              paramb.append(" mFinalState = ");
              paramb.append(this.a);
              paramb.append(" -> ");
              paramb.append(paramc);
              paramb.append(". ");
              Log.v("FragmentManager", paramb.toString());
            }
            this.a = paramc;
          }
        }
        else
        {
          if (FragmentManager.G0(2))
          {
            paramc = new StringBuilder();
            paramc.append("SpecialEffectsController: For fragment ");
            paramc.append(this.c);
            paramc.append(" mFinalState = ");
            paramc.append(this.a);
            paramc.append(" -> REMOVED. mLifecycleImpact  = ");
            paramc.append(this.b);
            paramc.append(" to REMOVING.");
            Log.v("FragmentManager", paramc.toString());
          }
          this.a = c.a;
        }
      }
      else {
        for (paramc = b.c;; paramc = b.b)
        {
          this.b = paramc;
          return;
          if (this.a != c.a) {
            break;
          }
          if (FragmentManager.G0(2))
          {
            paramc = new StringBuilder();
            paramc.append("SpecialEffectsController: For fragment ");
            paramc.append(this.c);
            paramc.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
            paramc.append(this.b);
            paramc.append(" to ADDING.");
            Log.v("FragmentManager", paramc.toString());
          }
          this.a = c.b;
        }
      }
    }
    
    void l() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Operation ");
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mFinalState = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mLifecycleImpact = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mFragment = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    class a
      implements b.a
    {
      a() {}
      
      public void a()
      {
        w.e.this.b();
      }
    }
    
    static enum b
    {
      static
      {
        b localb1 = new b("NONE", 0);
        a = localb1;
        b localb2 = new b("ADDING", 1);
        b = localb2;
        b localb3 = new b("REMOVING", 2);
        c = localb3;
        d = new b[] { localb1, localb2, localb3 };
      }
      
      private b() {}
    }
    
    static enum c
    {
      static
      {
        c localc1 = new c("REMOVED", 0);
        a = localc1;
        c localc2 = new c("VISIBLE", 1);
        b = localc2;
        c localc3 = new c("GONE", 2);
        c = localc3;
        c localc4 = new c("INVISIBLE", 3);
        d = localc4;
        e = new c[] { localc1, localc2, localc3, localc4 };
      }
      
      private c() {}
      
      static c b(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 4)
          {
            if (paramInt == 8) {
              return c;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown visibility ");
            localStringBuilder.append(paramInt);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return d;
        }
        return b;
      }
      
      static c c(View paramView)
      {
        if ((paramView.getAlpha() == 0.0F) && (paramView.getVisibility() == 0)) {
          return d;
        }
        return b(paramView.getVisibility());
      }
      
      void a(View paramView)
      {
        int i = w.c.a[ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              if (FragmentManager.G0(2))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
                ((StringBuilder)localObject).append(paramView);
                ((StringBuilder)localObject).append(" to INVISIBLE");
                Log.v("FragmentManager", ((StringBuilder)localObject).toString());
              }
              paramView.setVisibility(4);
              return;
            }
            if (FragmentManager.G0(2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
              ((StringBuilder)localObject).append(paramView);
              ((StringBuilder)localObject).append(" to GONE");
              Log.v("FragmentManager", ((StringBuilder)localObject).toString());
            }
            i = 8;
          }
          else
          {
            if (FragmentManager.G0(2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
              ((StringBuilder)localObject).append(paramView);
              ((StringBuilder)localObject).append(" to VISIBLE");
              Log.v("FragmentManager", ((StringBuilder)localObject).toString());
            }
            i = 0;
          }
          paramView.setVisibility(i);
          return;
        }
        Object localObject = (ViewGroup)paramView.getParent();
        if (localObject != null)
        {
          if (FragmentManager.G0(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SpecialEffectsController: Removing view ");
            localStringBuilder.append(paramView);
            localStringBuilder.append(" from container ");
            localStringBuilder.append(localObject);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.w
 * JD-Core Version:    0.7.0.1
 */