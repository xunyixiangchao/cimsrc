package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.IntentSenderRequest.b;
import androidx.fragment.R.id;
import androidx.lifecycle.a0;
import androidx.lifecycle.h.c;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
{
  private static boolean O = false;
  static boolean P = true;
  private androidx.activity.result.b<IntentSenderRequest> A;
  private androidx.activity.result.b<String[]> B;
  ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque();
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private ArrayList<a> I;
  private ArrayList<Boolean> J;
  private ArrayList<Fragment> K;
  private ArrayList<o> L;
  private l M;
  private Runnable N = new g();
  private final ArrayList<m> a = new ArrayList();
  private boolean b;
  private final p c = new p();
  ArrayList<a> d;
  private ArrayList<Fragment> e;
  private final i f = new i(this);
  private OnBackPressedDispatcher g;
  private final androidx.activity.b h = new c(false);
  private final AtomicInteger i = new AtomicInteger();
  private final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
  private final Map<String, Object> k = Collections.synchronizedMap(new HashMap());
  private ArrayList<l> l;
  private Map<Fragment, HashSet<u0.b>> m = Collections.synchronizedMap(new HashMap());
  private final r.g n = new d();
  private final j o = new j(this);
  private final CopyOnWriteArrayList<m> p = new CopyOnWriteArrayList();
  int q = -1;
  private h<?> r;
  private e s;
  private Fragment t;
  Fragment u;
  private g v = null;
  private g w = new e();
  private x x = null;
  private x y = new f();
  private androidx.activity.result.b<Intent> z;
  
  static Fragment A0(View paramView)
  {
    paramView = paramView.getTag(R.id.fragment_container_view_tag);
    if ((paramView instanceof Fragment)) {
      return (Fragment)paramView;
    }
    return null;
  }
  
  static boolean G0(int paramInt)
  {
    return (O) || (Log.isLoggable("FragmentManager", paramInt));
  }
  
  private boolean H0(Fragment paramFragment)
  {
    return ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) || (paramFragment.mChildFragmentManager.o());
  }
  
  private void M(Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.equals(h0(paramFragment.mWho)))) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  private void P0(g0.b<Fragment> paramb)
  {
    int i2 = paramb.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Fragment localFragment = (Fragment)paramb.h(i1);
      if (!localFragment.mAdded)
      {
        View localView = localFragment.requireView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i1 += 1;
    }
  }
  
  private void T(int paramInt)
  {
    try
    {
      this.b = true;
      this.c.d(paramInt);
      R0(paramInt, false);
      if (P)
      {
        Iterator localIterator = s().iterator();
        while (localIterator.hasNext()) {
          ((w)localIterator.next()).j();
        }
      }
      this.b = false;
      b0(true);
      return;
    }
    finally
    {
      this.b = false;
    }
  }
  
  private void W()
  {
    if (this.H)
    {
      this.H = false;
      q1();
    }
  }
  
  private void Y()
  {
    Iterator localIterator;
    if (P)
    {
      localIterator = s().iterator();
      while (localIterator.hasNext()) {
        ((w)localIterator.next()).j();
      }
    }
    if (!this.m.isEmpty())
    {
      localIterator = this.m.keySet().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        n(localFragment);
        S0(localFragment);
      }
    }
  }
  
  private boolean Z0(String paramString, int paramInt1, int paramInt2)
  {
    b0(false);
    a0(true);
    Fragment localFragment = this.u;
    if ((localFragment != null) && (paramInt1 < 0) && (paramString == null) && (localFragment.getChildFragmentManager().Y0())) {
      return true;
    }
    boolean bool = a1(this.I, this.J, paramString, paramInt1, paramInt2);
    if (bool) {
      this.b = true;
    }
    try
    {
      e1(this.I, this.J);
      q();
    }
    finally
    {
      q();
    }
    W();
    this.c.b();
    return bool;
  }
  
  private void a0(boolean paramBoolean)
  {
    if (!this.b)
    {
      if (this.r == null)
      {
        if (this.G) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      if (Looper.myLooper() == this.r.g().getLooper())
      {
        if (!paramBoolean) {
          p();
        }
        if (this.I == null)
        {
          this.I = new ArrayList();
          this.J = new ArrayList();
        }
        this.b = true;
        try
        {
          g0(null, null);
          return;
        }
        finally
        {
          this.b = false;
        }
      }
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private int b1(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, g0.b<Fragment> paramb)
  {
    int i1 = paramInt2 - 1;
    int i3;
    for (int i2 = paramInt2; i1 >= paramInt1; i2 = i3)
    {
      a locala = (a)paramArrayList.get(i1);
      boolean bool = ((Boolean)paramArrayList1.get(i1)).booleanValue();
      int i4;
      if ((locala.C()) && (!locala.A(paramArrayList, i1 + 1, paramInt2))) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      i3 = i2;
      if (i4 != 0)
      {
        if (this.L == null) {
          this.L = new ArrayList();
        }
        o localo = new o(locala, bool);
        this.L.add(localo);
        locala.E(localo);
        if (bool) {
          locala.v();
        } else {
          locala.w(false);
        }
        i3 = i2 - 1;
        if (i1 != i3)
        {
          paramArrayList.remove(i1);
          paramArrayList.add(i3, locala);
        }
        d(paramb);
      }
      i1 -= 1;
    }
    return i2;
  }
  
  private void d(g0.b<Fragment> paramb)
  {
    int i1 = this.q;
    if (i1 < 1) {
      return;
    }
    i1 = Math.min(i1, 5);
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment.mState < i1)
      {
        T0(localFragment, i1);
        if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
          paramb.add(localFragment);
        }
      }
    }
  }
  
  private static void d0(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      a locala = (a)paramArrayList.get(paramInt1);
      boolean bool2 = ((Boolean)paramArrayList1.get(paramInt1)).booleanValue();
      boolean bool1 = true;
      if (bool2)
      {
        locala.r(-1);
        if (paramInt1 != paramInt2 - 1) {
          bool1 = false;
        }
        locala.w(bool1);
      }
      else
      {
        locala.r(1);
        locala.v();
      }
      paramInt1 += 1;
    }
  }
  
  private void e0(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e1(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    if (paramArrayList.size() == paramArrayList1.size())
    {
      g0(paramArrayList, paramArrayList1);
      int i5 = paramArrayList.size();
      int i1 = 0;
      int i2;
      for (int i3 = 0; i1 < i5; i3 = i2)
      {
        int i4 = i1;
        i2 = i3;
        if (!((a)paramArrayList.get(i1)).r)
        {
          if (i3 != i1) {
            e0(paramArrayList, paramArrayList1, i3, i1);
          }
          i3 = i1 + 1;
          i2 = i3;
          if (((Boolean)paramArrayList1.get(i1)).booleanValue()) {
            for (;;)
            {
              i2 = i3;
              if (i3 >= i5) {
                break;
              }
              i2 = i3;
              if (!((Boolean)paramArrayList1.get(i3)).booleanValue()) {
                break;
              }
              i2 = i3;
              if (((a)paramArrayList.get(i3)).r) {
                break;
              }
              i3 += 1;
            }
          }
          e0(paramArrayList, paramArrayList1, i1, i2);
          i4 = i2 - 1;
        }
        i1 = i4 + 1;
      }
      if (i3 != i5) {
        e0(paramArrayList, paramArrayList1, i3, i5);
      }
      return;
    }
    throw new IllegalStateException("Internal error with the back stack records");
  }
  
  private void g0(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    Object localObject = this.L;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((ArrayList)localObject).size();
    }
    int i1 = 0;
    for (int i4 = i2; i1 < i4; i4 = i2)
    {
      localObject = (o)this.L.get(i1);
      int i3;
      if ((paramArrayList != null) && (!((o)localObject).a))
      {
        i2 = paramArrayList.indexOf(((o)localObject).b);
        if ((i2 != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i2)).booleanValue()))
        {
          this.L.remove(i1);
          i3 = i1 - 1;
          i2 = i4 - 1;
        }
      }
      do
      {
        ((o)localObject).c();
        break label241;
        if (!((o)localObject).e())
        {
          i2 = i4;
          i3 = i1;
          if (paramArrayList == null) {
            break label241;
          }
          i2 = i4;
          i3 = i1;
          if (!((o)localObject).b.A(paramArrayList, 0, paramArrayList.size())) {
            break label241;
          }
        }
        this.L.remove(i1);
        i3 = i1 - 1;
        i2 = i4 - 1;
        if ((paramArrayList == null) || (((o)localObject).a)) {
          break;
        }
        i1 = paramArrayList.indexOf(((o)localObject).b);
      } while ((i1 != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i1)).booleanValue()));
      ((o)localObject).d();
      label241:
      i1 = i3 + 1;
    }
  }
  
  private void g1()
  {
    if (this.l != null)
    {
      int i1 = 0;
      while (i1 < this.l.size())
      {
        ((l)this.l.get(i1)).a();
        i1 += 1;
      }
    }
  }
  
  static int i1(int paramInt)
  {
    int i1 = 8194;
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return 0;
        }
        return 4097;
      }
      i1 = 4099;
    }
    return i1;
  }
  
  private void l0()
  {
    if (P)
    {
      Iterator localIterator = s().iterator();
      while (localIterator.hasNext()) {
        ((w)localIterator.next()).k();
      }
    }
    if (this.L != null) {
      while (!this.L.isEmpty()) {
        ((o)this.L.remove(0)).d();
      }
    }
  }
  
  private boolean m0(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    synchronized (this.a)
    {
      boolean bool = this.a.isEmpty();
      int i1 = 0;
      if (bool) {
        return false;
      }
      int i2 = this.a.size();
      bool = false;
      while (i1 < i2)
      {
        bool |= ((m)this.a.get(i1)).a(paramArrayList, paramArrayList1);
        i1 += 1;
      }
      this.a.clear();
      this.r.g().removeCallbacks(this.N);
      return bool;
    }
  }
  
  private void n(Fragment paramFragment)
  {
    HashSet localHashSet = (HashSet)this.m.get(paramFragment);
    if (localHashSet != null)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        ((u0.b)localIterator.next()).a();
      }
      localHashSet.clear();
      x(paramFragment);
      this.m.remove(paramFragment);
    }
  }
  
  private l o0(Fragment paramFragment)
  {
    return this.M.i(paramFragment);
  }
  
  private void o1(Fragment paramFragment)
  {
    ViewGroup localViewGroup = q0(paramFragment);
    if ((localViewGroup != null) && (paramFragment.getEnterAnim() + paramFragment.getExitAnim() + paramFragment.getPopEnterAnim() + paramFragment.getPopExitAnim() > 0))
    {
      int i1 = R.id.visible_removing_fragment_view_tag;
      if (localViewGroup.getTag(i1) == null) {
        localViewGroup.setTag(i1, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(i1)).setPopDirection(paramFragment.getPopDirection());
    }
  }
  
  private void p()
  {
    if (!L0()) {
      return;
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void q()
  {
    this.b = false;
    this.J.clear();
    this.I.clear();
  }
  
  private ViewGroup q0(Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    if (localViewGroup != null) {
      return localViewGroup;
    }
    if (paramFragment.mContainerId <= 0) {
      return null;
    }
    if (this.s.d())
    {
      paramFragment = this.s.c(paramFragment.mContainerId);
      if ((paramFragment instanceof ViewGroup)) {
        return (ViewGroup)paramFragment;
      }
    }
    return null;
  }
  
  private void q1()
  {
    Iterator localIterator = this.c.k().iterator();
    while (localIterator.hasNext()) {
      W0((o)localIterator.next());
    }
  }
  
  private void r1()
  {
    synchronized (this.a)
    {
      boolean bool2 = this.a.isEmpty();
      boolean bool1 = true;
      if (!bool2)
      {
        this.h.f(true);
        return;
      }
      ??? = this.h;
      if ((n0() <= 0) || (!J0(this.t))) {
        bool1 = false;
      }
      ((androidx.activity.b)???).f(bool1);
      return;
    }
  }
  
  private Set<w> s()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.c.k().iterator();
    while (localIterator.hasNext())
    {
      ViewGroup localViewGroup = ((o)localIterator.next()).k().mContainer;
      if (localViewGroup != null) {
        localHashSet.add(w.o(localViewGroup, z0()));
      }
    }
    return localHashSet;
  }
  
  private Set<w> t(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    HashSet localHashSet = new HashSet();
    while (paramInt1 < paramInt2)
    {
      Iterator localIterator = ((a)paramArrayList.get(paramInt1)).c.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((q.a)localIterator.next()).b;
        if (localObject != null)
        {
          localObject = ((Fragment)localObject).mContainer;
          if (localObject != null) {
            localHashSet.add(w.n((ViewGroup)localObject, this));
          }
        }
      }
      paramInt1 += 1;
    }
    return localHashSet;
  }
  
  private void v(final Fragment paramFragment)
  {
    if (paramFragment.mView != null)
    {
      d.d locald = d.c(this.r.f(), paramFragment, paramFragment.mHidden ^ true, paramFragment.getPopDirection());
      if (locald != null)
      {
        Object localObject = locald.b;
        if (localObject != null)
        {
          ((Animator)localObject).setTarget(paramFragment.mView);
          if (paramFragment.mHidden)
          {
            if (paramFragment.isHideReplaced())
            {
              paramFragment.setHideReplaced(false);
            }
            else
            {
              localObject = paramFragment.mContainer;
              final View localView = paramFragment.mView;
              ((ViewGroup)localObject).startViewTransition(localView);
              locald.b.addListener(new h((ViewGroup)localObject, localView, paramFragment));
            }
          }
          else {
            paramFragment.mView.setVisibility(0);
          }
          locald.b.start();
          break label199;
        }
      }
      if (locald != null)
      {
        paramFragment.mView.startAnimation(locald.a);
        locald.a.start();
      }
      int i1;
      if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      paramFragment.mView.setVisibility(i1);
      if (paramFragment.isHideReplaced()) {
        paramFragment.setHideReplaced(false);
      }
    }
    label199:
    E0(paramFragment);
    paramFragment.mHiddenChanged = false;
    paramFragment.onHiddenChanged(paramFragment.mHidden);
  }
  
  private void x(Fragment paramFragment)
  {
    paramFragment.performDestroyView();
    this.o.n(paramFragment, false);
    paramFragment.mContainer = null;
    paramFragment.mView = null;
    paramFragment.mViewLifecycleOwner = null;
    paramFragment.mViewLifecycleOwnerLiveData.o(null);
    paramFragment.mInLayout = false;
  }
  
  void A()
  {
    this.E = false;
    this.F = false;
    this.M.o(false);
    T(0);
  }
  
  void B(Configuration paramConfiguration)
  {
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  z B0(Fragment paramFragment)
  {
    return this.M.l(paramFragment);
  }
  
  boolean C(MenuItem paramMenuItem)
  {
    if (this.q < 1) {
      return false;
    }
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void C0()
  {
    b0(true);
    if (this.h.c())
    {
      Y0();
      return;
    }
    this.g.c();
  }
  
  void D()
  {
    this.E = false;
    this.F = false;
    this.M.o(false);
    T(1);
  }
  
  void D0(Fragment paramFragment)
  {
    if (G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      paramFragment.mHiddenChanged = (true ^ paramFragment.mHiddenChanged);
      o1(paramFragment);
    }
  }
  
  boolean E(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i2 = this.q;
    int i1 = 0;
    if (i2 < 1) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = this.c.n().iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (I0(localFragment)) && (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool = true;
        localObject1 = localObject2;
      }
    }
    if (this.e != null) {
      while (i1 < this.e.size())
      {
        paramMenu = (Fragment)this.e.get(i1);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i1 += 1;
      }
    }
    this.e = localObject1;
    return bool;
  }
  
  void E0(Fragment paramFragment)
  {
    if ((paramFragment.mAdded) && (H0(paramFragment))) {
      this.D = true;
    }
  }
  
  void F()
  {
    this.G = true;
    b0(true);
    Y();
    T(-1);
    this.r = null;
    this.s = null;
    this.t = null;
    if (this.g != null)
    {
      this.h.d();
      this.g = null;
    }
    androidx.activity.result.b localb = this.z;
    if (localb != null)
    {
      localb.c();
      this.A.c();
      this.B.c();
    }
  }
  
  public boolean F0()
  {
    return this.G;
  }
  
  void G()
  {
    T(1);
  }
  
  void H()
  {
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  void I(boolean paramBoolean)
  {
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
    }
  }
  
  boolean I0(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    return paramFragment.isMenuVisible();
  }
  
  void J(Fragment paramFragment)
  {
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).a(this, paramFragment);
    }
  }
  
  boolean J0(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    FragmentManager localFragmentManager = paramFragment.mFragmentManager;
    return (paramFragment.equals(localFragmentManager.y0())) && (J0(localFragmentManager.t));
  }
  
  boolean K(MenuItem paramMenuItem)
  {
    if (this.q < 1) {
      return false;
    }
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  boolean K0(int paramInt)
  {
    return this.q >= paramInt;
  }
  
  void L(Menu paramMenu)
  {
    if (this.q < 1) {
      return;
    }
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  public boolean L0()
  {
    return (this.E) || (this.F);
  }
  
  void M0(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (this.B != null)
    {
      paramFragment = new LaunchedFragmentInfo(paramFragment.mWho, paramInt);
      this.C.addLast(paramFragment);
      this.B.a(paramArrayOfString);
      return;
    }
    this.r.j(paramFragment, paramArrayOfString, paramInt);
  }
  
  void N()
  {
    T(5);
  }
  
  void N0(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.z != null)
    {
      paramFragment = new LaunchedFragmentInfo(paramFragment.mWho, paramInt);
      this.C.addLast(paramFragment);
      if ((paramIntent != null) && (paramBundle != null)) {
        paramIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      this.z.a(paramIntent);
      return;
    }
    this.r.m(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  void O(boolean paramBoolean)
  {
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
    }
  }
  
  void O0(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (this.A != null)
    {
      if (paramBundle != null)
      {
        if (paramIntent == null)
        {
          paramIntent = new Intent();
          paramIntent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
        }
        if (G0(2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ActivityOptions ");
          localStringBuilder.append(paramBundle);
          localStringBuilder.append(" were added to fillInIntent ");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append(" for fragment ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        paramIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      paramIntentSender = new IntentSenderRequest.b(paramIntentSender).b(paramIntent).c(paramInt3, paramInt2).a();
      paramIntent = new LaunchedFragmentInfo(paramFragment.mWho, paramInt1);
      this.C.addLast(paramIntent);
      if (G0(2))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Fragment ");
        paramIntent.append(paramFragment);
        paramIntent.append("is launching an IntentSender for result ");
        Log.v("FragmentManager", paramIntent.toString());
      }
      this.A.a(paramIntentSender);
      return;
    }
    this.r.n(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  boolean P(Menu paramMenu)
  {
    int i1 = this.q;
    boolean bool = false;
    if (i1 < 1) {
      return false;
    }
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (I0(localFragment)) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
        bool = true;
      }
    }
    return bool;
  }
  
  void Q()
  {
    r1();
    M(this.u);
  }
  
  void Q0(Fragment paramFragment)
  {
    if (!this.c.c(paramFragment.mWho))
    {
      if (G0(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Ignoring moving ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" to state ");
        ((StringBuilder)localObject).append(this.q);
        ((StringBuilder)localObject).append("since it is not added to ");
        ((StringBuilder)localObject).append(this);
        Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      return;
    }
    S0(paramFragment);
    Object localObject = paramFragment.mView;
    if ((localObject != null) && (paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
    {
      float f1 = paramFragment.mPostponedAlpha;
      if (f1 > 0.0F) {
        ((View)localObject).setAlpha(f1);
      }
      paramFragment.mPostponedAlpha = 0.0F;
      paramFragment.mIsNewlyAdded = false;
      localObject = d.c(this.r.f(), paramFragment, true, paramFragment.getPopDirection());
      if (localObject != null)
      {
        Animation localAnimation = ((d.d)localObject).a;
        if (localAnimation != null)
        {
          paramFragment.mView.startAnimation(localAnimation);
        }
        else
        {
          ((d.d)localObject).b.setTarget(paramFragment.mView);
          ((d.d)localObject).b.start();
        }
      }
    }
    if (paramFragment.mHiddenChanged) {
      v(paramFragment);
    }
  }
  
  void R()
  {
    this.E = false;
    this.F = false;
    this.M.o(false);
    T(7);
  }
  
  void R0(int paramInt, boolean paramBoolean)
  {
    if ((this.r == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.q)) {
      return;
    }
    this.q = paramInt;
    Object localObject;
    if (P)
    {
      this.c.r();
    }
    else
    {
      localObject = this.c.n().iterator();
      while (((Iterator)localObject).hasNext()) {
        Q0((Fragment)((Iterator)localObject).next());
      }
      localObject = this.c.k().iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        Fragment localFragment = localo.k();
        if (!localFragment.mIsNewlyAdded) {
          Q0(localFragment);
        }
        if ((localFragment.mRemoving) && (!localFragment.isInBackStack())) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0) {
          this.c.q(localo);
        }
      }
    }
    q1();
    if (this.D)
    {
      localObject = this.r;
      if ((localObject != null) && (this.q == 7))
      {
        ((h)localObject).o();
        this.D = false;
      }
    }
  }
  
  void S()
  {
    this.E = false;
    this.F = false;
    this.M.o(false);
    T(5);
  }
  
  void S0(Fragment paramFragment)
  {
    T0(paramFragment, this.q);
  }
  
  void T0(Fragment paramFragment, int paramInt)
  {
    Object localObject2 = this.c.m(paramFragment.mWho);
    int i2 = 1;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new o(this.o, this.c, paramFragment);
      ((o)localObject1).t(1);
    }
    int i1 = paramInt;
    if (paramFragment.mFromLayout)
    {
      i1 = paramInt;
      if (paramFragment.mInLayout)
      {
        i1 = paramInt;
        if (paramFragment.mState == 2) {
          i1 = Math.max(paramInt, 2);
        }
      }
    }
    paramInt = Math.min(i1, ((o)localObject1).d());
    int i3 = paramFragment.mState;
    if (i3 <= paramInt)
    {
      if ((i3 < paramInt) && (!this.m.isEmpty())) {
        n(paramFragment);
      }
      i1 = paramFragment.mState;
      if (i1 != -1)
      {
        if (i1 != 0)
        {
          if (i1 == 1) {
            break label186;
          }
          if (i1 == 2) {
            break label206;
          }
          if (i1 == 4) {
            break label216;
          }
          if (i1 == 5) {
            break label226;
          }
          i1 = paramInt;
          break label694;
        }
      }
      else if (paramInt > -1) {
        ((o)localObject1).c();
      }
      if (paramInt > 0) {
        ((o)localObject1).e();
      }
      label186:
      if (paramInt > -1) {
        ((o)localObject1).j();
      }
      if (paramInt > 1) {
        ((o)localObject1).f();
      }
      label206:
      if (paramInt > 2) {
        ((o)localObject1).a();
      }
      label216:
      if (paramInt > 4) {
        ((o)localObject1).u();
      }
      label226:
      i1 = paramInt;
      if (paramInt > 5)
      {
        ((o)localObject1).p();
        i1 = paramInt;
      }
    }
    else
    {
      i1 = paramInt;
      if (i3 > paramInt)
      {
        if (i3 != 0)
        {
          if (i3 != 1)
          {
            if (i3 != 2)
            {
              if (i3 != 4)
              {
                if (i3 != 5)
                {
                  if (i3 != 7)
                  {
                    i1 = paramInt;
                    break label694;
                  }
                  if (paramInt < 7) {
                    ((o)localObject1).n();
                  }
                }
                if (paramInt < 5) {
                  ((o)localObject1).v();
                }
              }
              if (paramInt < 4)
              {
                if (G0(3))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("movefrom ACTIVITY_CREATED: ");
                  ((StringBuilder)localObject2).append(paramFragment);
                  Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
                }
                if ((paramFragment.mView != null) && (this.r.k(paramFragment)) && (paramFragment.mSavedViewState == null)) {
                  ((o)localObject1).s();
                }
              }
            }
            if (paramInt < 2)
            {
              ViewGroup localViewGroup = null;
              localObject2 = paramFragment.mView;
              if (localObject2 != null)
              {
                Object localObject3 = paramFragment.mContainer;
                if (localObject3 != null)
                {
                  ((ViewGroup)localObject3).endViewTransition((View)localObject2);
                  paramFragment.mView.clearAnimation();
                  if (!paramFragment.isRemovingParent())
                  {
                    localObject2 = localViewGroup;
                    if (this.q > -1)
                    {
                      localObject2 = localViewGroup;
                      if (!this.G)
                      {
                        localObject2 = localViewGroup;
                        if (paramFragment.mView.getVisibility() == 0)
                        {
                          localObject2 = localViewGroup;
                          if (paramFragment.mPostponedAlpha >= 0.0F) {
                            localObject2 = d.c(this.r.f(), paramFragment, false, paramFragment.getPopDirection());
                          }
                        }
                      }
                    }
                    paramFragment.mPostponedAlpha = 0.0F;
                    localViewGroup = paramFragment.mContainer;
                    localObject3 = paramFragment.mView;
                    if (localObject2 != null) {
                      d.a(paramFragment, (d.d)localObject2, this.n);
                    }
                    localViewGroup.removeView((View)localObject3);
                    if (G0(2))
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("Removing view ");
                      ((StringBuilder)localObject2).append(localObject3);
                      ((StringBuilder)localObject2).append(" for fragment ");
                      ((StringBuilder)localObject2).append(paramFragment);
                      ((StringBuilder)localObject2).append(" from container ");
                      ((StringBuilder)localObject2).append(localViewGroup);
                      Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
                    }
                    if (localViewGroup != paramFragment.mContainer) {
                      return;
                    }
                  }
                }
              }
              if (this.m.get(paramFragment) == null) {
                ((o)localObject1).h();
              }
            }
          }
          if (paramInt < 1) {
            if (this.m.get(paramFragment) != null) {
              paramInt = i2;
            } else {
              ((o)localObject1).g();
            }
          }
        }
        if (paramInt < 0) {
          ((o)localObject1).i();
        }
        i1 = paramInt;
      }
    }
    label694:
    if (paramFragment.mState != i1)
    {
      if (G0(3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("moveToState: Fragment state for ");
        ((StringBuilder)localObject1).append(paramFragment);
        ((StringBuilder)localObject1).append(" not updated inline; expected state ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(" found ");
        ((StringBuilder)localObject1).append(paramFragment.mState);
        Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
      }
      paramFragment.mState = i1;
    }
  }
  
  void U()
  {
    this.F = true;
    this.M.o(true);
    T(4);
  }
  
  void U0()
  {
    if (this.r == null) {
      return;
    }
    this.E = false;
    this.F = false;
    this.M.o(false);
    Iterator localIterator = this.c.n().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
    }
  }
  
  void V()
  {
    T(2);
  }
  
  void V0(FragmentContainerView paramFragmentContainerView)
  {
    Iterator localIterator = this.c.k().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      Fragment localFragment = localo.k();
      if (localFragment.mContainerId == paramFragmentContainerView.getId())
      {
        View localView = localFragment.mView;
        if ((localView != null) && (localView.getParent() == null))
        {
          localFragment.mContainer = paramFragmentContainerView;
          localo.b();
        }
      }
    }
  }
  
  void W0(o paramo)
  {
    Fragment localFragment = paramo.k();
    if (localFragment.mDeferStart)
    {
      if (this.b)
      {
        this.H = true;
        return;
      }
      localFragment.mDeferStart = false;
      if (P)
      {
        paramo.m();
        return;
      }
      S0(localFragment);
    }
  }
  
  public void X(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("    ");
    localObject = ((StringBuilder)localObject).toString();
    this.c.e(paramString, ???, paramPrintWriter, paramArrayOfString);
    ??? = this.e;
    int i2 = 0;
    int i3;
    int i1;
    if (??? != null)
    {
      i3 = ???.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i1 = 0;
        while (i1 < i3)
        {
          ??? = (Fragment)this.e.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          i1 += 1;
        }
      }
    }
    ??? = this.d;
    if (??? != null)
    {
      i3 = ???.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i1 = 0;
        while (i1 < i3)
        {
          ??? = (a)this.d.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          ???.t((String)localObject, paramPrintWriter);
          i1 += 1;
        }
      }
    }
    paramPrintWriter.print(paramString);
    ??? = new StringBuilder();
    ???.append("Back Stack Index: ");
    ???.append(this.i.get());
    paramPrintWriter.println(???.toString());
    synchronized (this.a)
    {
      i3 = this.a.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Actions:");
        i1 = i2;
        while (i1 < i3)
        {
          paramArrayOfString = (m)this.a.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramArrayOfString);
          i1 += 1;
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(this.r);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(this.s);
      if (this.t != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(this.t);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(this.q);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(this.E);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(this.F);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.G);
      if (this.D)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(this.D);
      }
      return;
    }
  }
  
  public void X0(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Z(new n(null, paramInt1, paramInt2), false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad id: ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean Y0()
  {
    return Z0(null, -1, 0);
  }
  
  void Z(m paramm, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.r == null)
      {
        if (this.G) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      p();
    }
    synchronized (this.a)
    {
      if (this.r == null)
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
      this.a.add(paramm);
      k1();
      return;
    }
  }
  
  boolean a1(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = ((ArrayList)localObject).size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.d.remove(paramInt1));
      paramArrayList1.add(Boolean.TRUE);
      return true;
    }
    if ((paramString == null) && (paramInt1 < 0))
    {
      paramInt1 = -1;
    }
    else
    {
      int i1 = ((ArrayList)localObject).size() - 1;
      while (i1 >= 0)
      {
        localObject = (a)this.d.get(i1);
        if (((paramString != null) && (paramString.equals(((a)localObject).y()))) || ((paramInt1 >= 0) && (paramInt1 == ((a)localObject).v))) {
          break;
        }
        i1 -= 1;
      }
      if (i1 < 0) {
        return false;
      }
      int i2 = i1;
      if ((paramInt2 & 0x1) != 0) {
        for (;;)
        {
          paramInt2 = i1 - 1;
          i2 = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject = (a)this.d.get(paramInt2);
          if (paramString != null)
          {
            i1 = paramInt2;
            if (paramString.equals(((a)localObject).y())) {}
          }
          else
          {
            i2 = paramInt2;
            if (paramInt1 < 0) {
              break;
            }
            i2 = paramInt2;
            if (paramInt1 != ((a)localObject).v) {
              break;
            }
            i1 = paramInt2;
          }
        }
      }
      paramInt1 = i2;
    }
    if (paramInt1 == this.d.size() - 1) {
      return false;
    }
    paramInt2 = this.d.size() - 1;
    while (paramInt2 > paramInt1)
    {
      paramArrayList.add(this.d.remove(paramInt2));
      paramArrayList1.add(Boolean.TRUE);
      paramInt2 -= 1;
    }
    return true;
  }
  
  boolean b0(boolean paramBoolean)
  {
    a0(paramBoolean);
    paramBoolean = false;
    for (;;)
    {
      if (m0(this.I, this.J)) {
        this.b = true;
      }
      try
      {
        e1(this.I, this.J);
        q();
        paramBoolean = true;
      }
      finally
      {
        q();
      }
    }
    W();
    this.c.b();
    return paramBoolean;
  }
  
  void c0(m paramm, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.r == null) || (this.G))) {
      return;
    }
    a0(paramBoolean);
    if (paramm.a(this.I, this.J)) {
      this.b = true;
    }
    try
    {
      e1(this.I, this.J);
      q();
    }
    finally
    {
      q();
    }
    W();
    this.c.b();
  }
  
  void c1(Fragment paramFragment, u0.b paramb)
  {
    HashSet localHashSet = (HashSet)this.m.get(paramFragment);
    if ((localHashSet != null) && (localHashSet.remove(paramb)) && (localHashSet.isEmpty()))
    {
      this.m.remove(paramFragment);
      if (paramFragment.mState < 5)
      {
        x(paramFragment);
        S0(paramFragment);
      }
    }
  }
  
  void d1(Fragment paramFragment)
  {
    if (G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove: ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" nesting=");
      localStringBuilder.append(paramFragment.mBackStackNesting);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    boolean bool = paramFragment.isInBackStack();
    if ((!paramFragment.mDetached) || ((bool ^ true)))
    {
      this.c.s(paramFragment);
      if (H0(paramFragment)) {
        this.D = true;
      }
      paramFragment.mRemoving = true;
      o1(paramFragment);
    }
  }
  
  void e(a parama)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(parama);
  }
  
  void f(Fragment paramFragment, u0.b paramb)
  {
    if (this.m.get(paramFragment) == null) {
      this.m.put(paramFragment, new HashSet());
    }
    ((HashSet)this.m.get(paramFragment)).add(paramb);
  }
  
  public boolean f0()
  {
    boolean bool = b0(true);
    l0();
    return bool;
  }
  
  void f1(Fragment paramFragment)
  {
    this.M.n(paramFragment);
  }
  
  o g(Fragment paramFragment)
  {
    if (G0(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add: ");
      ((StringBuilder)localObject).append(paramFragment);
      Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = w(paramFragment);
    paramFragment.mFragmentManager = this;
    this.c.p((o)localObject);
    if (!paramFragment.mDetached)
    {
      this.c.a(paramFragment);
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if (H0(paramFragment)) {
        this.D = true;
      }
    }
    return localObject;
  }
  
  public void h(m paramm)
  {
    this.p.add(paramm);
  }
  
  Fragment h0(String paramString)
  {
    return this.c.f(paramString);
  }
  
  void h1(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return;
    }
    FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
    if (localFragmentManagerState.a == null) {
      return;
    }
    this.c.t();
    Object localObject1 = localFragmentManagerState.a.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      paramParcelable = (FragmentState)((Iterator)localObject1).next();
      if (paramParcelable != null)
      {
        localObject2 = this.M.h(paramParcelable.b);
        StringBuilder localStringBuilder;
        if (localObject2 != null)
        {
          if (G0(2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: re-attaching retained ");
            localStringBuilder.append(localObject2);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          paramParcelable = new o(this.o, this.c, (Fragment)localObject2, paramParcelable);
        }
        else
        {
          paramParcelable = new o(this.o, this.c, this.r.f().getClassLoader(), r0(), paramParcelable);
        }
        localObject2 = paramParcelable.k();
        ((Fragment)localObject2).mFragmentManager = this;
        if (G0(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("restoreSaveState: active (");
          localStringBuilder.append(((Fragment)localObject2).mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localObject2);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        paramParcelable.o(this.r.f().getClassLoader());
        this.c.p(paramParcelable);
        paramParcelable.t(this.q);
      }
    }
    paramParcelable = this.M.k().iterator();
    while (paramParcelable.hasNext())
    {
      localObject1 = (Fragment)paramParcelable.next();
      if (!this.c.c(((Fragment)localObject1).mWho))
      {
        if (G0(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Discarding retained Fragment ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" that was not found in the set of active Fragments ");
          ((StringBuilder)localObject2).append(localFragmentManagerState.a);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        this.M.n((Fragment)localObject1);
        ((Fragment)localObject1).mFragmentManager = this;
        localObject2 = new o(this.o, this.c, (Fragment)localObject1);
        ((o)localObject2).t(1);
        ((o)localObject2).m();
        ((Fragment)localObject1).mRemoving = true;
        ((o)localObject2).m();
      }
    }
    this.c.u(localFragmentManagerState.b);
    paramParcelable = localFragmentManagerState.c;
    int i2 = 0;
    int i1;
    if (paramParcelable != null)
    {
      this.d = new ArrayList(localFragmentManagerState.c.length);
      i1 = 0;
      for (;;)
      {
        paramParcelable = localFragmentManagerState.c;
        if (i1 >= paramParcelable.length) {
          break;
        }
        paramParcelable = paramParcelable[i1].g(this);
        if (G0(2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("restoreAllState: back stack #");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(" (index ");
          ((StringBuilder)localObject1).append(paramParcelable.v);
          ((StringBuilder)localObject1).append("): ");
          ((StringBuilder)localObject1).append(paramParcelable);
          Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          localObject1 = new PrintWriter(new v("FragmentManager"));
          paramParcelable.u("  ", (PrintWriter)localObject1, false);
          ((PrintWriter)localObject1).close();
        }
        this.d.add(paramParcelable);
        i1 += 1;
      }
    }
    this.d = null;
    this.i.set(localFragmentManagerState.d);
    paramParcelable = localFragmentManagerState.e;
    if (paramParcelable != null)
    {
      paramParcelable = h0(paramParcelable);
      this.u = paramParcelable;
      M(paramParcelable);
    }
    paramParcelable = localFragmentManagerState.f;
    if (paramParcelable != null)
    {
      i1 = i2;
      while (i1 < paramParcelable.size())
      {
        localObject1 = (Bundle)localFragmentManagerState.g.get(i1);
        ((Bundle)localObject1).setClassLoader(this.r.f().getClassLoader());
        this.j.put(paramParcelable.get(i1), localObject1);
        i1 += 1;
      }
    }
    this.C = new ArrayDeque(localFragmentManagerState.h);
  }
  
  void i(Fragment paramFragment)
  {
    this.M.f(paramFragment);
  }
  
  public Fragment i0(int paramInt)
  {
    return this.c.g(paramInt);
  }
  
  int j()
  {
    return this.i.getAndIncrement();
  }
  
  public Fragment j0(String paramString)
  {
    return this.c.h(paramString);
  }
  
  Parcelable j1()
  {
    l0();
    Y();
    b0(true);
    this.E = true;
    this.M.o(true);
    ArrayList localArrayList1 = this.c.v();
    boolean bool = localArrayList1.isEmpty();
    Object localObject2 = null;
    if (bool)
    {
      if (G0(2)) {
        Log.v("FragmentManager", "saveAllState: no fragments!");
      }
      return null;
    }
    ArrayList localArrayList2 = this.c.w();
    ArrayList localArrayList3 = this.d;
    Object localObject1 = localObject2;
    if (localArrayList3 != null)
    {
      int i2 = localArrayList3.size();
      localObject1 = localObject2;
      if (i2 > 0)
      {
        localObject2 = new BackStackState[i2];
        int i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          localObject2[i1] = new BackStackState((a)this.d.get(i1));
          if (G0(2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("saveAllState: adding back stack #");
            ((StringBuilder)localObject1).append(i1);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append(this.d.get(i1));
            Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          }
          i1 += 1;
        }
      }
    }
    localObject2 = new FragmentManagerState();
    ((FragmentManagerState)localObject2).a = localArrayList1;
    ((FragmentManagerState)localObject2).b = localArrayList2;
    ((FragmentManagerState)localObject2).c = ((BackStackState[])localObject1);
    ((FragmentManagerState)localObject2).d = this.i.get();
    localObject1 = this.u;
    if (localObject1 != null) {
      ((FragmentManagerState)localObject2).e = ((Fragment)localObject1).mWho;
    }
    ((FragmentManagerState)localObject2).f.addAll(this.j.keySet());
    ((FragmentManagerState)localObject2).g.addAll(this.j.values());
    ((FragmentManagerState)localObject2).h = new ArrayList(this.C);
    return localObject2;
  }
  
  @SuppressLint({"SyntheticAccessor"})
  void k(h<?> paramh, e parame, final Fragment paramFragment)
  {
    if (this.r == null)
    {
      this.r = paramh;
      this.s = parame;
      this.t = paramFragment;
      if (paramFragment != null) {}
      for (parame = new i(paramFragment);; parame = (m)paramh)
      {
        h(parame);
        break;
        if (!(paramh instanceof m)) {
          break;
        }
      }
      if (this.t != null) {
        r1();
      }
      if ((paramh instanceof androidx.activity.c))
      {
        parame = (androidx.activity.c)paramh;
        OnBackPressedDispatcher localOnBackPressedDispatcher = parame.getOnBackPressedDispatcher();
        this.g = localOnBackPressedDispatcher;
        if (paramFragment != null) {
          parame = paramFragment;
        }
        localOnBackPressedDispatcher.a(parame, this.h);
      }
      if (paramFragment != null) {
        paramh = paramFragment.mFragmentManager.o0(paramFragment);
      }
      for (;;)
      {
        this.M = paramh;
        break;
        if ((paramh instanceof a0)) {
          paramh = l.j(((a0)paramh).getViewModelStore());
        } else {
          paramh = new l(false);
        }
      }
      this.M.o(L0());
      this.c.x(this.M);
      paramh = this.r;
      if ((paramh instanceof androidx.activity.result.c))
      {
        parame = ((androidx.activity.result.c)paramh).getActivityResultRegistry();
        if (paramFragment != null)
        {
          paramh = new StringBuilder();
          paramh.append(paramFragment.mWho);
          paramh.append(":");
          paramh = paramh.toString();
        }
        else
        {
          paramh = "";
        }
        paramFragment = new StringBuilder();
        paramFragment.append("FragmentManager:");
        paramFragment.append(paramh);
        paramh = paramFragment.toString();
        paramFragment = new StringBuilder();
        paramFragment.append(paramh);
        paramFragment.append("StartActivityForResult");
        this.z = parame.j(paramFragment.toString(), new b.c(), new j());
        paramFragment = new StringBuilder();
        paramFragment.append(paramh);
        paramFragment.append("StartIntentSenderForResult");
        this.A = parame.j(paramFragment.toString(), new k(), new a());
        paramFragment = new StringBuilder();
        paramFragment.append(paramh);
        paramFragment.append("RequestPermissions");
        this.B = parame.j(paramFragment.toString(), new b.b(), new b());
      }
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  Fragment k0(String paramString)
  {
    return this.c.i(paramString);
  }
  
  void k1()
  {
    for (;;)
    {
      int i2;
      synchronized (this.a)
      {
        ArrayList localArrayList2 = this.L;
        i2 = 0;
        if ((localArrayList2 != null) && (!localArrayList2.isEmpty()))
        {
          i1 = 1;
          if (this.a.size() != 1) {
            break label97;
          }
          i2 = 1;
          break label97;
          this.r.g().removeCallbacks(this.N);
          this.r.g().post(this.N);
          r1();
          return;
        }
      }
      int i1 = 0;
      continue;
      label97:
      if (i1 == 0) {
        if (i2 == 0) {}
      }
    }
  }
  
  void l(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (G0(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        this.c.a(paramFragment);
        if (G0(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("add from attach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        if (H0(paramFragment)) {
          this.D = true;
        }
      }
    }
  }
  
  void l1(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = q0(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof FragmentContainerView))) {
      ((FragmentContainerView)paramFragment).setDrawDisappearingViewsLast(paramBoolean ^ true);
    }
  }
  
  public q m()
  {
    return new a(this);
  }
  
  void m1(Fragment paramFragment, h.c paramc)
  {
    if ((paramFragment.equals(h0(paramFragment.mWho))) && ((paramFragment.mHost == null) || (paramFragment.mFragmentManager == this)))
    {
      paramFragment.mMaxState = paramc;
      return;
    }
    paramc = new StringBuilder();
    paramc.append("Fragment ");
    paramc.append(paramFragment);
    paramc.append(" is not an active fragment of FragmentManager ");
    paramc.append(this);
    throw new IllegalArgumentException(paramc.toString());
  }
  
  public int n0()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  void n1(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(h0(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" is not an active fragment of FragmentManager ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = this.u;
    this.u = paramFragment;
    M((Fragment)localObject);
    M(this.u);
  }
  
  boolean o()
  {
    Iterator localIterator = this.c.l().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      boolean bool2 = bool1;
      if (localFragment != null) {
        bool2 = H0(localFragment);
      }
      bool1 = bool2;
      if (bool2) {
        return true;
      }
    }
    return false;
  }
  
  e p0()
  {
    return this.s;
  }
  
  void p1(Fragment paramFragment)
  {
    if (G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      paramFragment.mHiddenChanged ^= true;
    }
  }
  
  public final void r(String paramString)
  {
    this.j.remove(paramString);
  }
  
  public g r0()
  {
    Object localObject = this.v;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.t;
    if (localObject != null) {
      return ((Fragment)localObject).mFragmentManager.r0();
    }
    return this.w;
  }
  
  p s0()
  {
    return this.c;
  }
  
  public List<Fragment> t0()
  {
    return this.c.n();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Object localObject = this.t;
    if (localObject != null)
    {
      localStringBuilder.append(localObject.getClass().getSimpleName());
      localStringBuilder.append("{");
    }
    for (localObject = this.t;; localObject = this.r)
    {
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(localObject)));
      localStringBuilder.append("}");
      break label141;
      localObject = this.r;
      if (localObject == null) {
        break;
      }
      localStringBuilder.append(localObject.getClass().getSimpleName());
      localStringBuilder.append("{");
    }
    localStringBuilder.append("null");
    label141:
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void u(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      parama.w(paramBoolean3);
    } else {
      parama.v();
    }
    Object localObject1 = new ArrayList(1);
    Object localObject2 = new ArrayList(1);
    ((ArrayList)localObject1).add(parama);
    ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
    if ((paramBoolean2) && (this.q >= 1)) {
      r.C(this.r.f(), this.s, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true, this.n);
    }
    if (paramBoolean3) {
      R0(this.q, true);
    }
    localObject1 = this.c.l().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Fragment)localObject2).mView != null) && (((Fragment)localObject2).mIsNewlyAdded) && (parama.z(((Fragment)localObject2).mContainerId)))
      {
        float f1 = ((Fragment)localObject2).mPostponedAlpha;
        if (f1 > 0.0F) {
          ((Fragment)localObject2).mView.setAlpha(f1);
        }
        if (paramBoolean3)
        {
          ((Fragment)localObject2).mPostponedAlpha = 0.0F;
        }
        else
        {
          ((Fragment)localObject2).mPostponedAlpha = -1.0F;
          ((Fragment)localObject2).mIsNewlyAdded = false;
        }
      }
    }
  }
  
  h<?> u0()
  {
    return this.r;
  }
  
  LayoutInflater.Factory2 v0()
  {
    return this.f;
  }
  
  o w(Fragment paramFragment)
  {
    o localo = this.c.m(paramFragment.mWho);
    if (localo != null) {
      return localo;
    }
    paramFragment = new o(this.o, this.c, paramFragment);
    paramFragment.o(this.r.f().getClassLoader());
    paramFragment.t(this.q);
    return paramFragment;
  }
  
  j w0()
  {
    return this.o;
  }
  
  Fragment x0()
  {
    return this.t;
  }
  
  void y(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (G0(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (G0(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove from detach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        this.c.s(paramFragment);
        if (H0(paramFragment)) {
          this.D = true;
        }
        o1(paramFragment);
      }
    }
  }
  
  public Fragment y0()
  {
    return this.u;
  }
  
  void z()
  {
    this.E = false;
    this.F = false;
    this.M.o(false);
    T(4);
  }
  
  x z0()
  {
    Object localObject = this.x;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.t;
    if (localObject != null) {
      return ((Fragment)localObject).mFragmentManager.z0();
    }
    return this.y;
  }
  
  @SuppressLint({"BanParcelableUsage"})
  static class LaunchedFragmentInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
    String a;
    int b;
    
    LaunchedFragmentInfo(Parcel paramParcel)
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readInt();
    }
    
    LaunchedFragmentInfo(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a);
      paramParcel.writeInt(this.b);
    }
    
    class a
      implements Parcelable.Creator<FragmentManager.LaunchedFragmentInfo>
    {
      public FragmentManager.LaunchedFragmentInfo a(Parcel paramParcel)
      {
        return new FragmentManager.LaunchedFragmentInfo(paramParcel);
      }
      
      public FragmentManager.LaunchedFragmentInfo[] b(int paramInt)
      {
        return new FragmentManager.LaunchedFragmentInfo[paramInt];
      }
    }
  }
  
  class a
    implements androidx.activity.result.a<ActivityResult>
  {
    a() {}
    
    public void b(ActivityResult paramActivityResult)
    {
      Object localObject = (FragmentManager.LaunchedFragmentInfo)FragmentManager.this.C.pollFirst();
      if (localObject == null)
      {
        paramActivityResult = new StringBuilder();
        paramActivityResult.append("No IntentSenders were started for ");
        paramActivityResult.append(this);
        Log.w("FragmentManager", paramActivityResult.toString());
        return;
      }
      String str = ((FragmentManager.LaunchedFragmentInfo)localObject).a;
      int i = ((FragmentManager.LaunchedFragmentInfo)localObject).b;
      localObject = FragmentManager.c(FragmentManager.this).i(str);
      if (localObject == null)
      {
        paramActivityResult = new StringBuilder();
        paramActivityResult.append("Intent Sender result delivered for unknown Fragment ");
        paramActivityResult.append(str);
        Log.w("FragmentManager", paramActivityResult.toString());
        return;
      }
      ((Fragment)localObject).onActivityResult(i, paramActivityResult.h(), paramActivityResult.g());
    }
  }
  
  class b
    implements androidx.activity.result.a<Map<String, Boolean>>
  {
    b() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void b(Map<String, Boolean> paramMap)
    {
      String[] arrayOfString = (String[])paramMap.keySet().toArray(new String[0]);
      Object localObject1 = new ArrayList(paramMap.values());
      paramMap = new int[((ArrayList)localObject1).size()];
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        int j;
        if (((Boolean)((ArrayList)localObject1).get(i)).booleanValue()) {
          j = 0;
        } else {
          j = -1;
        }
        paramMap[i] = j;
        i += 1;
      }
      Object localObject2 = (FragmentManager.LaunchedFragmentInfo)FragmentManager.this.C.pollFirst();
      if (localObject2 == null)
      {
        paramMap = new StringBuilder();
        paramMap.append("No permissions were requested for ");
        paramMap.append(this);
      }
      for (;;)
      {
        Log.w("FragmentManager", paramMap.toString());
        return;
        localObject1 = ((FragmentManager.LaunchedFragmentInfo)localObject2).a;
        i = ((FragmentManager.LaunchedFragmentInfo)localObject2).b;
        localObject2 = FragmentManager.c(FragmentManager.this).i((String)localObject1);
        if (localObject2 != null) {
          break;
        }
        paramMap = new StringBuilder();
        paramMap.append("Permission request result delivered for unknown Fragment ");
        paramMap.append((String)localObject1);
      }
      ((Fragment)localObject2).onRequestPermissionsResult(i, arrayOfString, paramMap);
    }
  }
  
  class c
    extends androidx.activity.b
  {
    c(boolean paramBoolean)
    {
      super();
    }
    
    public void b()
    {
      FragmentManager.this.C0();
    }
  }
  
  class d
    implements r.g
  {
    d() {}
    
    public void a(Fragment paramFragment, u0.b paramb)
    {
      FragmentManager.this.f(paramFragment, paramb);
    }
    
    public void b(Fragment paramFragment, u0.b paramb)
    {
      if (!paramb.c()) {
        FragmentManager.this.c1(paramFragment, paramb);
      }
    }
  }
  
  class e
    extends g
  {
    e() {}
    
    public Fragment a(ClassLoader paramClassLoader, String paramString)
    {
      return FragmentManager.this.u0().b(FragmentManager.this.u0().f(), paramString, null);
    }
  }
  
  class f
    implements x
  {
    f() {}
    
    public w a(ViewGroup paramViewGroup)
    {
      return new b(paramViewGroup);
    }
  }
  
  class g
    implements Runnable
  {
    g() {}
    
    public void run()
    {
      FragmentManager.this.b0(true);
    }
  }
  
  class h
    extends AnimatorListenerAdapter
  {
    h(ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.a.endViewTransition(localView);
      paramAnimator.removeListener(this);
      paramAnimator = paramFragment;
      View localView = paramAnimator.mView;
      if ((localView != null) && (paramAnimator.mHidden)) {
        localView.setVisibility(8);
      }
    }
  }
  
  class i
    implements m
  {
    i(Fragment paramFragment) {}
    
    public void a(FragmentManager paramFragmentManager, Fragment paramFragment)
    {
      paramFragment.onAttachFragment(paramFragment);
    }
  }
  
  class j
    implements androidx.activity.result.a<ActivityResult>
  {
    j() {}
    
    public void b(ActivityResult paramActivityResult)
    {
      Object localObject = (FragmentManager.LaunchedFragmentInfo)FragmentManager.this.C.pollFirst();
      if (localObject == null)
      {
        paramActivityResult = new StringBuilder();
        paramActivityResult.append("No Activities were started for result for ");
        paramActivityResult.append(this);
        Log.w("FragmentManager", paramActivityResult.toString());
        return;
      }
      String str = ((FragmentManager.LaunchedFragmentInfo)localObject).a;
      int i = ((FragmentManager.LaunchedFragmentInfo)localObject).b;
      localObject = FragmentManager.c(FragmentManager.this).i(str);
      if (localObject == null)
      {
        paramActivityResult = new StringBuilder();
        paramActivityResult.append("Activity result delivered for unknown Fragment ");
        paramActivityResult.append(str);
        Log.w("FragmentManager", paramActivityResult.toString());
        return;
      }
      ((Fragment)localObject).onActivityResult(i, paramActivityResult.h(), paramActivityResult.g());
    }
  }
  
  static class k
    extends b.a<IntentSenderRequest, ActivityResult>
  {
    public Intent d(Context paramContext, IntentSenderRequest paramIntentSenderRequest)
    {
      Intent localIntent1 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
      Intent localIntent2 = paramIntentSenderRequest.g();
      paramContext = paramIntentSenderRequest;
      if (localIntent2 != null)
      {
        Bundle localBundle = localIntent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        paramContext = paramIntentSenderRequest;
        if (localBundle != null)
        {
          localIntent1.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", localBundle);
          localIntent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
          paramContext = paramIntentSenderRequest;
          if (localIntent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
            paramContext = new IntentSenderRequest.b(paramIntentSenderRequest.m()).b(null).c(paramIntentSenderRequest.i(), paramIntentSenderRequest.h()).a();
          }
        }
      }
      localIntent1.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", paramContext);
      if (FragmentManager.G0(2))
      {
        paramContext = new StringBuilder();
        paramContext.append("CreateIntent created the following intent: ");
        paramContext.append(localIntent1);
        Log.v("FragmentManager", paramContext.toString());
      }
      return localIntent1;
    }
    
    public ActivityResult e(int paramInt, Intent paramIntent)
    {
      return new ActivityResult(paramInt, paramIntent);
    }
  }
  
  public static abstract interface l
  {
    public abstract void a();
  }
  
  static abstract interface m
  {
    public abstract boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  private class n
    implements FragmentManager.m
  {
    final String a;
    final int b;
    final int c;
    
    n(String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      Fragment localFragment = FragmentManager.this.u;
      if ((localFragment != null) && (this.b < 0) && (this.a == null) && (localFragment.getChildFragmentManager().Y0())) {
        return false;
      }
      return FragmentManager.this.a1(paramArrayList, paramArrayList1, this.a, this.b, this.c);
    }
  }
  
  static class o
    implements Fragment.l
  {
    final boolean a;
    final a b;
    private int c;
    
    o(a parama, boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.b = parama;
    }
    
    public void a()
    {
      int i = this.c - 1;
      this.c = i;
      if (i != 0) {
        return;
      }
      this.b.t.k1();
    }
    
    public void b()
    {
      this.c += 1;
    }
    
    void c()
    {
      a locala = this.b;
      locala.t.u(locala, this.a, false, false);
    }
    
    void d()
    {
      int i;
      if (this.c > 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject = this.b.t.t0().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        localFragment.setOnStartEnterTransitionListener(null);
        if ((i != 0) && (localFragment.isPostponed())) {
          localFragment.startPostponedEnterTransition();
        }
      }
      localObject = this.b;
      ((a)localObject).t.u((a)localObject, this.a, i ^ 0x1, true);
    }
    
    public boolean e()
    {
      return this.c == 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */