package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.core.app.n;
import androidx.core.view.a0;
import androidx.core.view.u;
import androidx.core.view.x;
import g0.a;
import g0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import x0.h;

class b
  extends w
{
  b(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void w(List<k> paramList, final List<w.e> paramList1, boolean paramBoolean, Map<w.e, Boolean> paramMap)
  {
    final ViewGroup localViewGroup = m();
    Context localContext = localViewGroup.getContext();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (k)paramList.next();
      if (((l)localObject2).d()) {
        label60:
        ((l)localObject2).a();
      }
      Object localObject3;
      for (;;)
      {
        break;
        localObject3 = ((k)localObject2).e(localContext);
        if (localObject3 == null) {
          break label60;
        }
        localObject3 = ((d.d)localObject3).b;
        if (localObject3 != null) {
          break label108;
        }
        ((ArrayList)localObject1).add(localObject2);
      }
      label108:
      final w.e locale = ((l)localObject2).b();
      Object localObject4 = locale.f();
      if (Boolean.TRUE.equals(paramMap.get(locale)))
      {
        if (FragmentManager.G0(2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Ignoring Animator set on ");
          ((StringBuilder)localObject3).append(localObject4);
          ((StringBuilder)localObject3).append(" as this Fragment was involved in a Transition.");
          Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
        }
        ((l)localObject2).a();
      }
      else
      {
        final boolean bool;
        if (locale.e() == w.e.c.c) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          paramList1.remove(locale);
        }
        localObject4 = ((Fragment)localObject4).mView;
        localViewGroup.startViewTransition((View)localObject4);
        ((Animator)localObject3).addListener(new c(localViewGroup, (View)localObject4, bool, locale, (k)localObject2));
        ((Animator)localObject3).setTarget(localObject4);
        ((Animator)localObject3).start();
        ((l)localObject2).c().d(new d((Animator)localObject3));
        i = 1;
      }
    }
    paramMap = ((ArrayList)localObject1).iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (k)paramMap.next();
      paramList = ((l)localObject1).b();
      paramList1 = paramList.f();
      if (paramBoolean) {
        if (FragmentManager.G0(2))
        {
          paramList = new StringBuilder();
          paramList.append("Ignoring Animation set on ");
          paramList.append(paramList1);
        }
      }
      for (paramList1 = " as Animations cannot run alongside Transitions.";; paramList1 = " as Animations cannot run alongside Animators.")
      {
        paramList.append(paramList1);
        Log.v("FragmentManager", paramList.toString());
        do
        {
          ((l)localObject1).a();
          break;
          if (i == 0) {
            break label444;
          }
        } while (!FragmentManager.G0(2));
        paramList = new StringBuilder();
        paramList.append("Ignoring Animation set on ");
        paramList.append(paramList1);
      }
      label444:
      paramList1 = paramList1.mView;
      localObject2 = (Animation)h.g(((d.d)h.g(((k)localObject1).e(localContext))).a);
      if (paramList.e() != w.e.c.a)
      {
        paramList1.startAnimation((Animation)localObject2);
        ((l)localObject1).a();
      }
      else
      {
        localViewGroup.startViewTransition(paramList1);
        paramList = new d.e((Animation)localObject2, localViewGroup, paramList1);
        paramList.setAnimationListener(new e(localViewGroup, paramList1, (k)localObject1));
        paramList1.startAnimation(paramList);
      }
      ((l)localObject1).c().d(new f(paramList1, localViewGroup, (k)localObject1));
    }
  }
  
  private Map<w.e, Boolean> x(List<m> paramList, List<w.e> paramList1, final boolean paramBoolean, final w.e parame1, final w.e parame2)
  {
    Object localObject3 = this;
    Object localObject6 = parame1;
    Object localObject5 = parame2;
    HashMap localHashMap = new HashMap();
    Object localObject4 = paramList.iterator();
    Object localObject1 = null;
    while (((Iterator)localObject4).hasNext())
    {
      localObject7 = (m)((Iterator)localObject4).next();
      if (!((l)localObject7).d())
      {
        localObject2 = ((m)localObject7).e();
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else if ((localObject2 != null) && (localObject1 != localObject2))
        {
          paramList = new StringBuilder();
          paramList.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
          paramList.append(((l)localObject7).b().f());
          paramList.append(" returned Transition ");
          paramList.append(((m)localObject7).h());
          paramList.append(" which uses a different Transition  type than other Fragments.");
          throw new IllegalArgumentException(paramList.toString());
        }
      }
    }
    if (localObject1 == null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (m)paramList.next();
        localHashMap.put(paramList1.b(), Boolean.FALSE);
        paramList1.a();
      }
      return localHashMap;
    }
    Object localObject10 = new View(m().getContext());
    final Rect localRect = new Rect();
    Object localObject7 = new ArrayList();
    localObject4 = new ArrayList();
    a locala = new a();
    Object localObject12 = paramList.iterator();
    Object localObject8 = null;
    Object localObject2 = null;
    int i = 0;
    final Object localObject9 = localObject1;
    int j;
    Object localObject14;
    for (localObject1 = localObject10;; localObject1 = localObject10)
    {
      boolean bool = paramBoolean;
      if (!((Iterator)localObject12).hasNext()) {
        break;
      }
      localObject10 = (m)((Iterator)localObject12).next();
      if ((((m)localObject10).i()) && (localObject6 != null) && (localObject5 != null))
      {
        localObject10 = localObject9.B(localObject9.g(((m)localObject10).g()));
        localObject5 = parame2.f().getSharedElementSourceNames();
        localObject8 = parame1.f().getSharedElementSourceNames();
        localObject6 = parame1.f().getSharedElementTargetNames();
        j = 0;
        while (j < ((ArrayList)localObject6).size())
        {
          k = ((ArrayList)localObject5).indexOf(((ArrayList)localObject6).get(j));
          if (k != -1) {
            ((ArrayList)localObject5).set(k, ((ArrayList)localObject8).get(j));
          }
          j += 1;
        }
        localObject11 = parame2.f().getSharedElementTargetNames();
        localObject6 = parame1.f();
        if (!bool)
        {
          localObject8 = ((Fragment)localObject6).getExitTransitionCallback();
          localObject6 = parame2.f().getEnterTransitionCallback();
        }
        else
        {
          localObject8 = ((Fragment)localObject6).getEnterTransitionCallback();
          localObject6 = parame2.f().getExitTransitionCallback();
        }
        j = ((ArrayList)localObject5).size();
        int k = 0;
        while (k < j)
        {
          locala.put((String)((ArrayList)localObject5).get(k), (String)((ArrayList)localObject11).get(k));
          k += 1;
        }
        localObject13 = new a();
        ((b)localObject3).u((Map)localObject13, parame1.f().mView);
        ((a)localObject13).o((Collection)localObject5);
        if (localObject8 != null)
        {
          ((n)localObject8).d((List)localObject5, (Map)localObject13);
          j = ((ArrayList)localObject5).size() - 1;
          while (j >= 0)
          {
            localObject14 = (String)((ArrayList)localObject5).get(j);
            localObject8 = (View)((g)localObject13).get(localObject14);
            if (localObject8 == null)
            {
              locala.remove(localObject14);
            }
            else if (!((String)localObject14).equals(x.K((View)localObject8)))
            {
              localObject14 = (String)locala.remove(localObject14);
              locala.put(x.K((View)localObject8), localObject14);
            }
            j -= 1;
          }
        }
        else
        {
          locala.o(((a)localObject13).keySet());
        }
        localObject8 = new a();
        ((b)localObject3).u((Map)localObject8, parame2.f().mView);
        ((a)localObject8).o((Collection)localObject11);
        ((a)localObject8).o(locala.values());
        if (localObject6 != null)
        {
          ((n)localObject6).d((List)localObject11, (Map)localObject8);
          j = ((ArrayList)localObject11).size() - 1;
          while (j >= 0)
          {
            localObject14 = (String)((ArrayList)localObject11).get(j);
            localObject6 = (View)((g)localObject8).get(localObject14);
            if (localObject6 == null)
            {
              localObject6 = r.q(locala, (String)localObject14);
              if (localObject6 != null) {
                locala.remove(localObject6);
              }
            }
            else if (!((String)localObject14).equals(x.K((View)localObject6)))
            {
              localObject14 = r.q(locala, (String)localObject14);
              if (localObject14 != null) {
                locala.put(localObject14, x.K((View)localObject6));
              }
            }
            j -= 1;
          }
        }
        r.y(locala, (a)localObject8);
        ((b)localObject3).v((a)localObject13, locala.keySet());
        ((b)localObject3).v((a)localObject8, locala.values());
        if (locala.isEmpty())
        {
          ((ArrayList)localObject7).clear();
          ((ArrayList)localObject4).clear();
          localObject5 = parame1;
          localObject10 = localObject1;
          localObject8 = null;
          localObject6 = parame2;
          localObject1 = localObject5;
          localObject5 = localObject3;
          localObject3 = localObject10;
        }
        else
        {
          r.f(parame2.f(), parame1.f(), bool, (a)localObject13, true);
          u.a(m(), new g(parame2, parame1, paramBoolean, (a)localObject8));
          ((ArrayList)localObject7).addAll(((a)localObject13).values());
          if (!((ArrayList)localObject5).isEmpty())
          {
            localObject2 = (View)((g)localObject13).get((String)((ArrayList)localObject5).get(0));
            localObject9.v(localObject10, (View)localObject2);
          }
          localObject3 = ((a)localObject8).values();
          localObject6 = localObject4;
          ((ArrayList)localObject6).addAll((Collection)localObject3);
          if (!((ArrayList)localObject11).isEmpty())
          {
            localObject3 = (View)((g)localObject8).get((String)((ArrayList)localObject11).get(0));
            if (localObject3 != null)
            {
              u.a(m(), new h(localObject9, (View)localObject3, localRect));
              i = 1;
            }
          }
          localObject5 = this;
          localObject9.z(localObject10, (View)localObject1, (ArrayList)localObject7);
          localObject3 = localObject1;
          localObject9.t(localObject10, null, null, null, null, localObject10, (ArrayList)localObject6);
          localObject8 = Boolean.TRUE;
          localObject1 = parame1;
          localHashMap.put(localObject1, localObject8);
          localObject6 = parame2;
          localHashMap.put(localObject6, localObject8);
          localObject8 = localObject10;
        }
      }
      else
      {
        localObject10 = localObject3;
        localObject11 = localObject6;
        localObject6 = localObject5;
        localObject3 = localObject1;
        localObject5 = localObject10;
        localObject1 = localObject11;
      }
      localObject11 = localObject7;
      localObject10 = localObject3;
      localObject7 = localObject6;
      localObject3 = localObject5;
      localObject6 = localObject1;
      localObject5 = localObject7;
      localObject7 = localObject11;
    }
    parame1 = (w.e)localObject2;
    Object localObject11 = localObject4;
    localObject2 = localObject7;
    localObject4 = localObject5;
    Object localObject13 = new ArrayList();
    localObject7 = paramList.iterator();
    localObject10 = null;
    parame2 = null;
    localObject5 = parame1;
    parame1 = (w.e)localObject10;
    localObject10 = localObject1;
    localObject1 = localObject11;
    while (((Iterator)localObject7).hasNext())
    {
      localObject14 = (m)((Iterator)localObject7).next();
      if (((l)localObject14).d())
      {
        localHashMap.put(((l)localObject14).b(), Boolean.FALSE);
        ((l)localObject14).a();
      }
      else
      {
        Object localObject15 = localObject9.g(((m)localObject14).h());
        localObject11 = ((l)localObject14).b();
        if ((localObject8 != null) && ((localObject11 == localObject6) || (localObject11 == localObject4))) {
          j = 1;
        } else {
          j = 0;
        }
        if (localObject15 == null)
        {
          if (j == 0)
          {
            localHashMap.put(localObject11, Boolean.FALSE);
            ((l)localObject14).a();
          }
        }
        else
        {
          final ArrayList localArrayList1 = new ArrayList();
          ((b)localObject3).t(localArrayList1, ((w.e)localObject11).f().mView);
          if (j != 0) {
            if (localObject11 == localObject6) {
              localArrayList1.removeAll((Collection)localObject2);
            } else {
              localArrayList1.removeAll((Collection)localObject1);
            }
          }
          if (localArrayList1.isEmpty())
          {
            localObject9.a(localObject15, (View)localObject10);
          }
          else
          {
            localObject9.b(localObject15, localArrayList1);
            localObject9.t(localObject15, localObject15, localArrayList1, null, null, null, null);
            if (((w.e)localObject11).e() == w.e.c.c)
            {
              localObject12 = localObject11;
              paramList1.remove(localObject12);
              ArrayList localArrayList2 = new ArrayList(localArrayList1);
              localArrayList2.remove(((w.e)localObject12).f().mView);
              localObject9.r(localObject15, ((w.e)localObject12).f().mView, localArrayList2);
              u.a(m(), new i((b)localObject3, localArrayList1));
            }
          }
          if (((w.e)localObject11).e() == w.e.c.b)
          {
            ((ArrayList)localObject13).addAll(localArrayList1);
            if (i != 0) {
              localObject9.u(localObject15, localRect);
            }
          }
          else
          {
            localObject9.v(localObject15, (View)localObject5);
          }
          localHashMap.put(localObject11, Boolean.TRUE);
          if (((m)localObject14).j()) {
            parame2 = localObject9.n(parame2, localObject15, null);
          } else {
            parame1 = localObject9.n(parame1, localObject15, null);
          }
        }
      }
    }
    paramList1 = localObject9.m(parame2, parame1, localObject8);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parame1 = (m)paramList.next();
      if (!parame1.d())
      {
        localObject5 = parame1.h();
        parame2 = parame1.b();
        if ((localObject8 != null) && ((parame2 == localObject6) || (parame2 == localObject4))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((localObject5 != null) || (i != 0)) {
          if (!x.U(m()))
          {
            if (FragmentManager.G0(2))
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("SpecialEffectsController: Container ");
              ((StringBuilder)localObject5).append(m());
              ((StringBuilder)localObject5).append(" has not been laid out. Completing operation ");
              ((StringBuilder)localObject5).append(parame2);
              Log.v("FragmentManager", ((StringBuilder)localObject5).toString());
            }
            parame1.a();
          }
          else
          {
            localObject9.w(parame1.b().f(), paramList1, parame1.c(), new j((b)localObject3, parame1));
          }
        }
      }
    }
    if (!x.U(m())) {
      return localHashMap;
    }
    r.B((ArrayList)localObject13, 4);
    paramList = localObject9.o((ArrayList)localObject1);
    localObject9.c(m(), paramList1);
    localObject9.y(m(), (ArrayList)localObject2, (ArrayList)localObject1, paramList, locala);
    r.B((ArrayList)localObject13, 0);
    localObject9.A(localObject8, (ArrayList)localObject2, (ArrayList)localObject1);
    return localHashMap;
  }
  
  void f(List<w.e> paramList, boolean paramBoolean)
  {
    Object localObject4 = paramList.iterator();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = (w.e)((Iterator)localObject4).next();
      localObject5 = w.e.c.c(((w.e)localObject3).f().mView);
      int i = a.a[localObject3.e().ordinal()];
      if ((i != 1) && (i != 2) && (i != 3))
      {
        if ((i == 4) && (localObject5 != w.e.c.b)) {
          localObject1 = localObject3;
        }
      }
      else if ((localObject5 == w.e.c.b) && (localObject2 == null)) {
        localObject2 = localObject3;
      }
    }
    localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject3 = new ArrayList(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      final w.e locale = (w.e)paramList.next();
      u0.b localb = new u0.b();
      locale.j(localb);
      ((List)localObject4).add(new k(locale, localb, paramBoolean));
      localb = new u0.b();
      locale.j(localb);
      boolean bool = false;
      if (paramBoolean ? locale == localObject2 : locale == localObject1) {
        bool = true;
      }
      ((List)localObject5).add(new m(locale, localb, paramBoolean, bool));
      locale.a(new b((List)localObject3, locale));
    }
    paramList = x((List)localObject5, (List)localObject3, paramBoolean, localObject2, localObject1);
    w((List)localObject4, (List)localObject3, paramList.containsValue(Boolean.TRUE), paramList);
    paramList = ((List)localObject3).iterator();
    while (paramList.hasNext()) {
      s((w.e)paramList.next());
    }
    ((List)localObject3).clear();
  }
  
  void s(w.e parame)
  {
    View localView = parame.f().mView;
    parame.e().a(localView);
  }
  
  void t(ArrayList<View> paramArrayList, View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (a0.b(localViewGroup))
      {
        if (!paramArrayList.contains(paramView)) {
          paramArrayList.add(localViewGroup);
        }
      }
      else
      {
        int j = localViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
          paramView = localViewGroup.getChildAt(i);
          if (paramView.getVisibility() == 0) {
            t(paramArrayList, paramView);
          }
          i += 1;
        }
      }
    }
    else if (!paramArrayList.contains(paramView))
    {
      paramArrayList.add(paramView);
    }
  }
  
  void u(Map<String, View> paramMap, View paramView)
  {
    Object localObject = x.K(paramView);
    if (localObject != null) {
      paramMap.put(localObject, paramView);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramView.getChildAt(i);
        if (((View)localObject).getVisibility() == 0) {
          u(paramMap, (View)localObject);
        }
        i += 1;
      }
    }
  }
  
  void v(a<String, View> parama, Collection<String> paramCollection)
  {
    parama = parama.entrySet().iterator();
    while (parama.hasNext()) {
      if (!paramCollection.contains(x.K((View)((Map.Entry)parama.next()).getValue()))) {
        parama.remove();
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(List paramList, w.e parame) {}
    
    public void run()
    {
      if (this.a.contains(locale))
      {
        this.a.remove(locale);
        b.this.s(locale);
      }
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c(ViewGroup paramViewGroup, View paramView, boolean paramBoolean, w.e parame, b.k paramk) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      localViewGroup.endViewTransition(this.b);
      if (bool) {
        locale.e().a(this.b);
      }
      this.e.a();
    }
  }
  
  class d
    implements u0.b.a
  {
    d(Animator paramAnimator) {}
    
    public void a()
    {
      this.a.end();
    }
  }
  
  class e
    implements Animation.AnimationListener
  {
    e(ViewGroup paramViewGroup, View paramView, b.k paramk) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      localViewGroup.post(new a());
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        b.e locale = b.e.this;
        locale.a.endViewTransition(locale.b);
        b.e.this.c.a();
      }
    }
  }
  
  class f
    implements u0.b.a
  {
    f(View paramView, ViewGroup paramViewGroup, b.k paramk) {}
    
    public void a()
    {
      paramList1.clearAnimation();
      localViewGroup.endViewTransition(paramList1);
      this.c.a();
    }
  }
  
  class g
    implements Runnable
  {
    g(w.e parame1, w.e parame2, boolean paramBoolean, a parama) {}
    
    public void run()
    {
      r.f(parame2.f(), parame1.f(), paramBoolean, this.d, false);
    }
  }
  
  class h
    implements Runnable
  {
    h(t paramt, View paramView, Rect paramRect) {}
    
    public void run()
    {
      localObject9.k(this.b, localRect);
    }
  }
  
  class i
    implements Runnable
  {
    i(ArrayList paramArrayList) {}
    
    public void run()
    {
      r.B(localArrayList1, 4);
    }
  }
  
  class j
    implements Runnable
  {
    j(b.m paramm) {}
    
    public void run()
    {
      parame1.a();
    }
  }
  
  private static class k
    extends b.l
  {
    private boolean c;
    private boolean d = false;
    private d.d e;
    
    k(w.e parame, u0.b paramb, boolean paramBoolean)
    {
      super(paramb);
      this.c = paramBoolean;
    }
    
    d.d e(Context paramContext)
    {
      if (this.d) {
        return this.e;
      }
      Fragment localFragment = b().f();
      boolean bool;
      if (b().e() == w.e.c.b) {
        bool = true;
      } else {
        bool = false;
      }
      paramContext = d.c(paramContext, localFragment, bool, this.c);
      this.e = paramContext;
      this.d = true;
      return paramContext;
    }
  }
  
  private static class l
  {
    private final w.e a;
    private final u0.b b;
    
    l(w.e parame, u0.b paramb)
    {
      this.a = parame;
      this.b = paramb;
    }
    
    void a()
    {
      this.a.d(this.b);
    }
    
    w.e b()
    {
      return this.a;
    }
    
    u0.b c()
    {
      return this.b;
    }
    
    boolean d()
    {
      w.e.c localc1 = w.e.c.c(this.a.f().mView);
      w.e.c localc2 = this.a.e();
      if (localc1 != localc2)
      {
        w.e.c localc3 = w.e.c.b;
        if ((localc1 == localc3) || (localc2 == localc3)) {
          return false;
        }
      }
      return true;
    }
  }
  
  private static class m
    extends b.l
  {
    private final Object c;
    private final boolean d;
    private final Object e;
    
    m(w.e parame, u0.b paramb, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramb);
      boolean bool;
      if (parame.e() == w.e.c.b)
      {
        paramb = parame.f();
        if (paramBoolean1) {
          paramb = paramb.getReenterTransition();
        } else {
          paramb = paramb.getEnterTransition();
        }
        this.c = paramb;
        paramb = parame.f();
        if (paramBoolean1) {
          bool = paramb.getAllowReturnTransitionOverlap();
        } else {
          bool = paramb.getAllowEnterTransitionOverlap();
        }
      }
      else
      {
        paramb = parame.f();
        if (paramBoolean1) {
          paramb = paramb.getReturnTransition();
        } else {
          paramb = paramb.getExitTransition();
        }
        this.c = paramb;
        bool = true;
      }
      this.d = bool;
      if (paramBoolean2)
      {
        parame = parame.f();
        if (paramBoolean1) {
          parame = parame.getSharedElementReturnTransition();
        } else {
          parame = parame.getSharedElementEnterTransition();
        }
      }
      else
      {
        parame = null;
      }
      this.e = parame;
    }
    
    private t f(Object paramObject)
    {
      if (paramObject == null) {
        return null;
      }
      Object localObject = r.b;
      if ((localObject != null) && (((t)localObject).e(paramObject))) {
        return localObject;
      }
      localObject = r.c;
      if ((localObject != null) && (((t)localObject).e(paramObject))) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Transition ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(" for fragment ");
      ((StringBuilder)localObject).append(b().f());
      ((StringBuilder)localObject).append(" is not a valid framework Transition or AndroidX Transition");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    t e()
    {
      Object localObject = f(this.c);
      t localt = f(this.e);
      if ((localObject != null) && (localt != null) && (localObject != localt))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
        ((StringBuilder)localObject).append(b().f());
        ((StringBuilder)localObject).append(" returned Transition ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" which uses a different Transition  type than its shared element transition ");
        ((StringBuilder)localObject).append(this.e);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      if (localObject != null) {
        return localObject;
      }
      return localt;
    }
    
    public Object g()
    {
      return this.e;
    }
    
    Object h()
    {
      return this.c;
    }
    
    public boolean i()
    {
      return this.e != null;
    }
    
    boolean j()
    {
      return this.d;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.b
 * JD-Core Version:    0.7.0.1
 */