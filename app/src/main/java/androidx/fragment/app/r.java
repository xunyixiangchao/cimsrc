package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.n;
import androidx.core.view.u;
import androidx.core.view.x;
import androidx.transition.d;
import g0.g;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import u0.b;

class r
{
  private static final int[] a = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10 };
  static final t b = new s();
  static final t c = x();
  
  private static void A(t paramt, Object paramObject1, Object paramObject2, g0.a<String, View> parama, boolean paramBoolean, a parama1)
  {
    ArrayList localArrayList = parama1.p;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (paramBoolean) {
        parama1 = parama1.q;
      } else {
        parama1 = parama1.p;
      }
      parama = (View)parama.get((String)parama1.get(0));
      paramt.v(paramObject1, parama);
      if (paramObject2 != null) {
        paramt.v(paramObject2, parama);
      }
    }
  }
  
  static void B(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
  }
  
  static void C(Context paramContext, e parame, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean, g paramg)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    Object localObject;
    while (i < paramInt2)
    {
      localObject = (a)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        e((a)localObject, localSparseArray, paramBoolean);
      } else {
        c((a)localObject, localSparseArray, paramBoolean);
      }
      i += 1;
    }
    if (localSparseArray.size() != 0)
    {
      paramContext = new View(paramContext);
      int j = localSparseArray.size();
      i = 0;
      while (i < j)
      {
        int k = localSparseArray.keyAt(i);
        localObject = d(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        h localh = (h)localSparseArray.valueAt(i);
        if (parame.d())
        {
          ViewGroup localViewGroup = (ViewGroup)parame.c(k);
          if (localViewGroup != null) {
            if (paramBoolean) {
              o(localViewGroup, localh, paramContext, (g0.a)localObject, paramg);
            } else {
              n(localViewGroup, localh, paramContext, (g0.a)localObject, paramg);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, g0.a<String, View> parama, Collection<String> paramCollection)
  {
    int i = parama.size() - 1;
    while (i >= 0)
    {
      View localView = (View)parama.m(i);
      if (paramCollection.contains(x.K(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static void b(a parama, q.a parama1, SparseArray<h> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = parama1.b;
    if (localFragment == null) {
      return;
    }
    int n = localFragment.mContainerId;
    if (n == 0) {
      return;
    }
    if (paramBoolean1) {
      i = a[parama1.a];
    } else {
      i = parama1.a;
    }
    boolean bool1 = false;
    int m = 1;
    if (i != 1)
    {
      if (i != 3) {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i == 7) {
                break label284;
              }
              k = 0;
              i = k;
              j = i;
              break label335;
            }
          }
          else
          {
            if (paramBoolean2)
            {
              if ((!localFragment.mHiddenChanged) || (localFragment.mHidden) || (!localFragment.mAdded)) {
                break label321;
              }
              break label315;
            }
            bool1 = localFragment.mHidden;
            break label324;
          }
        }
        else
        {
          if (paramBoolean2) {
            if ((!localFragment.mHiddenChanged) || (!localFragment.mAdded) || (!localFragment.mHidden)) {
              break label249;
            }
          }
          for (;;)
          {
            break;
            if ((!localFragment.mAdded) || (localFragment.mHidden)) {
              break label249;
            }
          }
        }
      }
      boolean bool2 = localFragment.mAdded;
      if (paramBoolean2) {
        if (!bool2)
        {
          parama1 = localFragment.mView;
          if ((parama1 == null) || (parama1.getVisibility() != 0) || (localFragment.mPostponedAlpha < 0.0F)) {}
        }
      }
      for (;;)
      {
        i = 1;
        break;
        label249:
        do
        {
          i = 0;
          break;
        } while ((!bool2) || (localFragment.mHidden));
      }
      j = i;
      k = 1;
      i = 0;
      break label335;
    }
    label284:
    if (paramBoolean2) {
      bool1 = localFragment.mIsNewlyAdded;
    } else if ((!localFragment.mAdded) && (!localFragment.mHidden)) {
      label315:
      bool1 = true;
    } else {
      label321:
      bool1 = false;
    }
    label324:
    int j = 0;
    int k = j;
    int i = m;
    label335:
    Object localObject = (h)paramSparseArray.get(n);
    parama1 = (q.a)localObject;
    if (bool1)
    {
      parama1 = p((h)localObject, paramSparseArray, n);
      parama1.a = localFragment;
      parama1.b = paramBoolean1;
      parama1.c = parama;
    }
    if ((!paramBoolean2) && (i != 0))
    {
      if ((parama1 != null) && (parama1.d == localFragment)) {
        parama1.d = null;
      }
      if (!parama.r)
      {
        localObject = parama.t;
        o localo = ((FragmentManager)localObject).w(localFragment);
        ((FragmentManager)localObject).s0().p(localo);
        ((FragmentManager)localObject).S0(localFragment);
      }
    }
    localObject = parama1;
    if (j != 0) {
      if (parama1 != null)
      {
        localObject = parama1;
        if (parama1.d != null) {}
      }
      else
      {
        localObject = p(parama1, paramSparseArray, n);
        ((h)localObject).d = localFragment;
        ((h)localObject).e = paramBoolean1;
        ((h)localObject).f = parama;
      }
    }
    if ((!paramBoolean2) && (k != 0) && (localObject != null) && (((h)localObject).a == localFragment)) {
      ((h)localObject).a = null;
    }
  }
  
  public static void c(a parama, SparseArray<h> paramSparseArray, boolean paramBoolean)
  {
    int j = parama.c.size();
    int i = 0;
    while (i < j)
    {
      b(parama, (q.a)parama.c.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static g0.a<String, String> d(int paramInt1, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    g0.a locala = new g0.a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (a)paramArrayList.get(paramInt3);
      if (((a)localObject).z(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        ArrayList localArrayList1 = ((q)localObject).p;
        if (localArrayList1 != null)
        {
          int j = localArrayList1.size();
          ArrayList localArrayList2;
          if (bool)
          {
            localArrayList2 = ((q)localObject).p;
            localArrayList1 = ((q)localObject).q;
          }
          else
          {
            localArrayList1 = ((q)localObject).p;
            localArrayList2 = ((q)localObject).q;
          }
          int i = 0;
          while (i < j)
          {
            localObject = (String)localArrayList1.get(i);
            String str1 = (String)localArrayList2.get(i);
            String str2 = (String)locala.remove(str1);
            if (str2 != null) {
              locala.put(localObject, str2);
            } else {
              locala.put(localObject, str1);
            }
            i += 1;
          }
        }
      }
      paramInt3 -= 1;
    }
    return locala;
  }
  
  public static void e(a parama, SparseArray<h> paramSparseArray, boolean paramBoolean)
  {
    if (!parama.t.p0().d()) {
      return;
    }
    int i = parama.c.size() - 1;
    while (i >= 0)
    {
      b(parama, (q.a)parama.c.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
  }
  
  static void f(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, g0.a<String, View> parama, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
    } else {
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
    }
    if (paramFragment1 != null)
    {
      paramFragment2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i;
      if (parama == null) {
        i = 0;
      } else {
        i = parama.size();
      }
      while (j < i)
      {
        localArrayList.add(parama.i(j));
        paramFragment2.add(parama.m(j));
        j += 1;
      }
      if (paramBoolean2)
      {
        paramFragment1.g(localArrayList, paramFragment2, null);
        return;
      }
      paramFragment1.f(localArrayList, paramFragment2, null);
    }
  }
  
  private static boolean g(t paramt, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramt.e(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static g0.a<String, View> h(t paramt, g0.a<String, String> parama, Object paramObject, h paramh)
  {
    Fragment localFragment = paramh.a;
    View localView = localFragment.getView();
    if ((!parama.isEmpty()) && (paramObject != null) && (localView != null))
    {
      g0.a locala = new g0.a();
      paramt.j(locala, localView);
      paramt = paramh.c;
      if (paramh.b)
      {
        paramObject = localFragment.getExitTransitionCallback();
        paramt = paramt.p;
      }
      else
      {
        paramObject = localFragment.getEnterTransitionCallback();
        paramt = paramt.q;
      }
      if (paramt != null)
      {
        locala.o(paramt);
        locala.o(parama.values());
      }
      if (paramObject != null)
      {
        paramObject.d(paramt, locala);
        int i = paramt.size() - 1;
        while (i >= 0)
        {
          paramh = (String)paramt.get(i);
          paramObject = (View)locala.get(paramh);
          if (paramObject == null)
          {
            paramObject = q(parama, paramh);
            if (paramObject != null) {
              parama.remove(paramObject);
            }
          }
          else if (!paramh.equals(x.K(paramObject)))
          {
            paramh = q(parama, paramh);
            if (paramh != null) {
              parama.put(paramh, x.K(paramObject));
            }
          }
          i -= 1;
        }
      }
      y(parama, locala);
      return locala;
    }
    parama.clear();
    return null;
  }
  
  private static g0.a<String, View> i(t paramt, g0.a<String, String> parama, Object paramObject, h paramh)
  {
    if ((!parama.isEmpty()) && (paramObject != null))
    {
      paramObject = paramh.d;
      g0.a locala = new g0.a();
      paramt.j(locala, paramObject.requireView());
      paramt = paramh.f;
      if (paramh.e)
      {
        paramObject = paramObject.getEnterTransitionCallback();
        paramt = paramt.q;
      }
      else
      {
        paramObject = paramObject.getExitTransitionCallback();
        paramt = paramt.p;
      }
      if (paramt != null) {
        locala.o(paramt);
      }
      if (paramObject != null)
      {
        paramObject.d(paramt, locala);
        int i = paramt.size() - 1;
        while (i >= 0)
        {
          paramh = (String)paramt.get(i);
          paramObject = (View)locala.get(paramh);
          if (paramObject == null)
          {
            parama.remove(paramh);
          }
          else if (!paramh.equals(x.K(paramObject)))
          {
            paramh = (String)parama.remove(paramh);
            parama.put(x.K(paramObject), paramh);
          }
          i -= 1;
        }
      }
      parama.o(locala.keySet());
      return locala;
    }
    parama.clear();
    return null;
  }
  
  private static t j(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.getExitTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.getReturnTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.getSharedElementReturnTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.getEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getReenterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getSharedElementEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramFragment1 = b;
    if ((paramFragment1 != null) && (g(paramFragment1, localArrayList))) {
      return paramFragment1;
    }
    paramFragment2 = c;
    if ((paramFragment2 != null) && (g(paramFragment2, localArrayList))) {
      return paramFragment2;
    }
    if ((paramFragment1 == null) && (paramFragment2 == null)) {
      return null;
    }
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  static ArrayList<View> k(t paramt, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramt.f(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramt.b(paramObject, localArrayList);
        return localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  private static Object l(t paramt, ViewGroup paramViewGroup, final View paramView, final g0.a<String, String> parama, final h paramh, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final Object paramObject1, final Object paramObject2)
  {
    final Fragment localFragment1 = paramh.a;
    final Fragment localFragment2 = paramh.d;
    if (localFragment1 != null)
    {
      if (localFragment2 == null) {
        return null;
      }
      final boolean bool = paramh.b;
      final Object localObject;
      if (parama.isEmpty()) {
        localObject = null;
      } else {
        localObject = u(paramt, localFragment1, localFragment2, bool);
      }
      g0.a locala = i(paramt, parama, localObject, paramh);
      if (parama.isEmpty()) {
        localObject = null;
      } else {
        paramArrayList1.addAll(locala.values());
      }
      if ((paramObject1 == null) && (paramObject2 == null) && (localObject == null)) {
        return null;
      }
      f(localFragment1, localFragment2, bool, locala, true);
      if (localObject != null)
      {
        Rect localRect = new Rect();
        paramt.z(localObject, paramView, paramArrayList1);
        A(paramt, localObject, paramObject2, locala, paramh.e, paramh.f);
        paramObject2 = localRect;
        if (paramObject1 != null)
        {
          paramt.u(paramObject1, localRect);
          paramObject2 = localRect;
        }
      }
      else
      {
        paramObject2 = null;
      }
      u.a(paramViewGroup, new f(parama, localObject, paramh, paramArrayList2, paramView, localFragment1, localFragment2, bool, paramArrayList1, paramObject1, paramObject2));
      return localObject;
    }
    return null;
  }
  
  private static Object m(final t paramt, ViewGroup paramViewGroup, View paramView, g0.a<String, String> parama, final h paramh, final ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Fragment localFragment1 = paramh.a;
    final Fragment localFragment2 = paramh.d;
    if (localFragment1 != null) {
      localFragment1.requireView().setVisibility(0);
    }
    if (localFragment1 != null)
    {
      if (localFragment2 == null) {
        return null;
      }
      final boolean bool = paramh.b;
      Object localObject;
      if (parama.isEmpty()) {
        localObject = null;
      } else {
        localObject = u(paramt, localFragment1, localFragment2, bool);
      }
      g0.a locala2 = i(paramt, parama, localObject, paramh);
      final g0.a locala1 = h(paramt, parama, localObject, paramh);
      if (parama.isEmpty())
      {
        if (locala2 != null) {
          locala2.clear();
        }
        if (locala1 != null) {
          locala1.clear();
        }
        parama = null;
      }
      else
      {
        a(paramArrayList1, locala2, parama.keySet());
        a(paramArrayList2, locala1, parama.values());
        parama = localObject;
      }
      if ((paramObject1 == null) && (paramObject2 == null) && (parama == null)) {
        return null;
      }
      f(localFragment1, localFragment2, bool, locala2, true);
      if (parama != null)
      {
        paramArrayList2.add(paramView);
        paramt.z(parama, paramView, paramArrayList1);
        A(paramt, parama, paramObject2, locala2, paramh.e, paramh.f);
        paramView = new Rect();
        paramh = t(locala1, paramh, paramObject1, bool);
        if (paramh != null) {
          paramt.u(paramObject1, paramView);
        }
        paramArrayList1 = paramView;
      }
      else
      {
        paramView = null;
        paramArrayList1 = paramView;
        paramh = paramView;
      }
      u.a(paramViewGroup, new e(localFragment1, localFragment2, bool, locala1, paramh, paramt, paramArrayList1));
      return parama;
    }
    return null;
  }
  
  private static void n(ViewGroup paramViewGroup, h paramh, View paramView, g0.a<String, String> parama, g paramg)
  {
    Fragment localFragment1 = paramh.a;
    final Fragment localFragment2 = paramh.d;
    t localt = j(localFragment2, localFragment1);
    if (localt == null) {
      return;
    }
    boolean bool1 = paramh.b;
    boolean bool2 = paramh.e;
    Object localObject2 = r(localt, localFragment1, bool1);
    Object localObject1 = s(localt, localFragment2, bool2);
    Object localObject4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = l(localt, paramViewGroup, paramView, parama, paramh, (ArrayList)localObject4, localArrayList1, localObject2, localObject1);
    if ((localObject2 == null) && (localObject3 == null) && (localObject1 == null)) {
      return;
    }
    ArrayList localArrayList2 = k(localt, localObject1, localFragment2, (ArrayList)localObject4, paramView);
    if ((localArrayList2 == null) || (localArrayList2.isEmpty())) {
      localObject1 = null;
    }
    localt.a(localObject2, paramView);
    paramh = v(localt, localObject2, localObject1, localObject3, localFragment1, paramh.b);
    if ((localFragment2 != null) && (localArrayList2 != null) && ((localArrayList2.size() > 0) || (((ArrayList)localObject4).size() > 0)))
    {
      localObject4 = new b();
      paramg.a(localFragment2, (b)localObject4);
      localt.w(localFragment2, paramh, (b)localObject4, new c(paramg, localFragment2, (b)localObject4));
    }
    if (paramh != null)
    {
      paramg = new ArrayList();
      localt.t(paramh, localObject2, paramg, localObject1, localArrayList2, localObject3, localArrayList1);
      z(localt, paramViewGroup, localFragment1, paramView, localArrayList1, localObject2, paramg, localObject1, localArrayList2);
      localt.x(paramViewGroup, localArrayList1, parama);
      localt.c(paramViewGroup, paramh);
      localt.s(paramViewGroup, localArrayList1, parama);
    }
  }
  
  private static void o(ViewGroup paramViewGroup, h paramh, View paramView, g0.a<String, String> parama, g paramg)
  {
    Object localObject4 = paramh.a;
    final Fragment localFragment = paramh.d;
    t localt = j(localFragment, (Fragment)localObject4);
    if (localt == null) {
      return;
    }
    boolean bool1 = paramh.b;
    boolean bool2 = paramh.e;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = r(localt, (Fragment)localObject4, bool1);
    Object localObject1 = s(localt, localFragment, bool2);
    Object localObject3 = m(localt, paramViewGroup, paramView, parama, paramh, localArrayList2, localArrayList1, localObject2, localObject1);
    if ((localObject2 == null) && (localObject3 == null) && (localObject1 == null)) {
      return;
    }
    paramh = (h)localObject1;
    localObject1 = k(localt, paramh, localFragment, localArrayList2, paramView);
    paramView = k(localt, localObject2, (Fragment)localObject4, localArrayList1, paramView);
    B(paramView, 4);
    localObject4 = v(localt, localObject2, paramh, localObject3, (Fragment)localObject4, bool1);
    if ((localFragment != null) && (localObject1 != null) && ((((ArrayList)localObject1).size() > 0) || (localArrayList2.size() > 0)))
    {
      final b localb = new b();
      paramg.a(localFragment, localb);
      localt.w(localFragment, localObject4, localb, new a(paramg, localFragment, localb));
    }
    if (localObject4 != null)
    {
      w(localt, paramh, localFragment, (ArrayList)localObject1);
      paramg = localt.o(localArrayList1);
      localt.t(localObject4, localObject2, paramView, paramh, (ArrayList)localObject1, localObject3, localArrayList1);
      localt.c(paramViewGroup, localObject4);
      localt.y(paramViewGroup, localArrayList2, localArrayList1, paramg, parama);
      B(paramView, 0);
      localt.A(localObject3, localArrayList2, localArrayList1);
    }
  }
  
  private static h p(h paramh, SparseArray<h> paramSparseArray, int paramInt)
  {
    h localh = paramh;
    if (paramh == null)
    {
      localh = new h();
      paramSparseArray.put(paramInt, localh);
    }
    return localh;
  }
  
  static String q(g0.a<String, String> parama, String paramString)
  {
    int j = parama.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(parama.m(i))) {
        return (String)parama.i(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static Object r(t paramt, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReenterTransition();
    } else {
      paramFragment = paramFragment.getEnterTransition();
    }
    return paramt.g(paramFragment);
  }
  
  private static Object s(t paramt, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReturnTransition();
    } else {
      paramFragment = paramFragment.getExitTransition();
    }
    return paramt.g(paramFragment);
  }
  
  static View t(g0.a<String, View> parama, h paramh, Object paramObject, boolean paramBoolean)
  {
    paramh = paramh.c;
    if ((paramObject != null) && (parama != null))
    {
      paramObject = paramh.p;
      if ((paramObject != null) && (!paramObject.isEmpty()))
      {
        if (paramBoolean) {
          paramh = paramh.p;
        } else {
          paramh = paramh.q;
        }
        return (View)parama.get((String)paramh.get(0));
      }
    }
    return null;
  }
  
  private static Object u(t paramt, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.getSharedElementReturnTransition();
      } else {
        paramFragment1 = paramFragment1.getSharedElementEnterTransition();
      }
      return paramt.B(paramt.g(paramFragment1));
    }
    return null;
  }
  
  private static Object v(t paramt, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null))
    {
      if (paramBoolean) {
        paramBoolean = paramFragment.getAllowReturnTransitionOverlap();
      } else {
        paramBoolean = paramFragment.getAllowEnterTransitionOverlap();
      }
    }
    else {
      paramBoolean = true;
    }
    if (paramBoolean) {
      return paramt.n(paramObject2, paramObject1, paramObject3);
    }
    return paramt.m(paramObject2, paramObject1, paramObject3);
  }
  
  private static void w(t paramt, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList)
  {
    if ((paramFragment != null) && (paramObject != null) && (paramFragment.mAdded) && (paramFragment.mHidden) && (paramFragment.mHiddenChanged))
    {
      paramFragment.setHideReplaced(true);
      paramt.r(paramObject, paramFragment.getView(), paramArrayList);
      u.a(paramFragment.mContainer, new b(paramArrayList));
    }
  }
  
  private static t x()
  {
    try
    {
      t localt = (t)d.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localt;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return null;
  }
  
  static void y(g0.a<String, String> parama, g0.a<String, View> parama1)
  {
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!parama1.containsKey((String)parama.m(i))) {
        parama.k(i);
      }
      i -= 1;
    }
  }
  
  private static void z(final t paramt, ViewGroup paramViewGroup, final Fragment paramFragment, final View paramView, final ArrayList<View> paramArrayList1, Object paramObject1, final ArrayList<View> paramArrayList2, final Object paramObject2, final ArrayList<View> paramArrayList3)
  {
    u.a(paramViewGroup, new d(paramObject1, paramt, paramView, paramFragment, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2));
  }
  
  class a
    implements Runnable
  {
    a(Fragment paramFragment, b paramb) {}
    
    public void run()
    {
      r.this.b(localFragment, localb);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      r.B(r.this, 4);
    }
  }
  
  class c
    implements Runnable
  {
    c(Fragment paramFragment, b paramb) {}
    
    public void run()
    {
      r.this.b(localFragment2, this.c);
    }
  }
  
  class d
    implements Runnable
  {
    d(t paramt, View paramView, Fragment paramFragment, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Object paramObject) {}
    
    public void run()
    {
      Object localObject = r.this;
      if (localObject != null)
      {
        paramt.p(localObject, paramView);
        localObject = r.k(paramt, r.this, paramFragment, paramArrayList1, paramView);
        paramArrayList2.addAll((Collection)localObject);
      }
      if (paramArrayList3 != null)
      {
        if (paramObject2 != null)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramView);
          paramt.q(paramObject2, paramArrayList3, (ArrayList)localObject);
        }
        paramArrayList3.clear();
        paramArrayList3.add(paramView);
      }
    }
  }
  
  class e
    implements Runnable
  {
    e(Fragment paramFragment, boolean paramBoolean, g0.a parama, View paramView, t paramt, Rect paramRect) {}
    
    public void run()
    {
      r.f(r.this, localFragment2, bool, locala1, false);
      View localView = paramh;
      if (localView != null) {
        paramt.k(localView, paramArrayList1);
      }
    }
  }
  
  class f
    implements Runnable
  {
    f(g0.a parama, Object paramObject1, r.h paramh, ArrayList paramArrayList1, View paramView, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList2, Object paramObject2, Rect paramRect) {}
    
    public void run()
    {
      Object localObject1 = r.h(r.this, parama, localObject, paramh);
      if (localObject1 != null)
      {
        paramArrayList2.addAll(((g0.a)localObject1).values());
        paramArrayList2.add(paramView);
      }
      r.f(localFragment1, localFragment2, bool, (g0.a)localObject1, false);
      Object localObject2 = localObject;
      if (localObject2 != null)
      {
        r.this.A(localObject2, paramArrayList1, paramArrayList2);
        localObject1 = r.t((g0.a)localObject1, paramh, paramObject1, bool);
        if (localObject1 != null) {
          r.this.k((View)localObject1, paramObject2);
        }
      }
    }
  }
  
  static abstract interface g
  {
    public abstract void a(Fragment paramFragment, b paramb);
    
    public abstract void b(Fragment paramFragment, b paramb);
  }
  
  static class h
  {
    public Fragment a;
    public boolean b;
    public a c;
    public Fragment d;
    public boolean e;
    public a f;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.r
 * JD-Core Version:    0.7.0.1
 */