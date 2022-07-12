package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.x;
import androidx.fragment.R.id;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import java.util.Iterator;
import java.util.List;

class o
{
  private final j a;
  private final p b;
  private final Fragment c;
  private boolean d = false;
  private int e = -1;
  
  o(j paramj, p paramp, Fragment paramFragment)
  {
    this.a = paramj;
    this.b = paramp;
    this.c = paramFragment;
  }
  
  o(j paramj, p paramp, Fragment paramFragment, FragmentState paramFragmentState)
  {
    this.a = paramj;
    this.b = paramp;
    this.c = paramFragment;
    paramFragment.mSavedViewState = null;
    paramFragment.mSavedViewRegistryState = null;
    paramFragment.mBackStackNesting = 0;
    paramFragment.mInLayout = false;
    paramFragment.mAdded = false;
    paramj = paramFragment.mTarget;
    if (paramj != null) {
      paramj = paramj.mWho;
    } else {
      paramj = null;
    }
    paramFragment.mTargetWho = paramj;
    paramFragment.mTarget = null;
    paramj = paramFragmentState.m;
    if (paramj == null) {
      paramj = new Bundle();
    }
    paramFragment.mSavedFragmentState = paramj;
  }
  
  o(j paramj, p paramp, ClassLoader paramClassLoader, g paramg, FragmentState paramFragmentState)
  {
    this.a = paramj;
    this.b = paramp;
    paramp = paramg.a(paramClassLoader, paramFragmentState.a);
    this.c = paramp;
    paramj = paramFragmentState.j;
    if (paramj != null) {
      paramj.setClassLoader(paramClassLoader);
    }
    paramp.setArguments(paramFragmentState.j);
    paramp.mWho = paramFragmentState.b;
    paramp.mFromLayout = paramFragmentState.c;
    paramp.mRestored = true;
    paramp.mFragmentId = paramFragmentState.d;
    paramp.mContainerId = paramFragmentState.e;
    paramp.mTag = paramFragmentState.f;
    paramp.mRetainInstance = paramFragmentState.g;
    paramp.mRemoving = paramFragmentState.h;
    paramp.mDetached = paramFragmentState.i;
    paramp.mHidden = paramFragmentState.k;
    paramp.mMaxState = androidx.lifecycle.h.c.values()[paramFragmentState.l];
    paramj = paramFragmentState.m;
    if (paramj == null) {
      paramj = new Bundle();
    }
    paramp.mSavedFragmentState = paramj;
    if (FragmentManager.G0(2))
    {
      paramj = new StringBuilder();
      paramj.append("Instantiated fragment ");
      paramj.append(paramp);
      Log.v("FragmentManager", paramj.toString());
    }
  }
  
  private boolean l(View paramView)
  {
    if (paramView == this.c.mView) {
      return true;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if (paramView == this.c.mView) {
        return true;
      }
    }
    return false;
  }
  
  private Bundle q()
  {
    Object localObject2 = new Bundle();
    this.c.performSaveInstanceState((Bundle)localObject2);
    this.a.j(this.c, (Bundle)localObject2, false);
    Object localObject1 = localObject2;
    if (((Bundle)localObject2).isEmpty()) {
      localObject1 = null;
    }
    if (this.c.mView != null) {
      s();
    }
    localObject2 = localObject1;
    if (this.c.mSavedViewState != null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putSparseParcelableArray("android:view_state", this.c.mSavedViewState);
    }
    localObject1 = localObject2;
    if (this.c.mSavedViewRegistryState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putBundle("android:view_registry_state", this.c.mSavedViewRegistryState);
    }
    localObject2 = localObject1;
    if (!this.c.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", this.c.mUserVisibleHint);
    }
    return localObject2;
  }
  
  void a()
  {
    if (FragmentManager.G0(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto ACTIVITY_CREATED: ");
      ((StringBuilder)localObject).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    ((Fragment)localObject).performActivityCreated(((Fragment)localObject).mSavedFragmentState);
    localObject = this.a;
    Fragment localFragment = this.c;
    ((j)localObject).a(localFragment, localFragment.mSavedFragmentState, false);
  }
  
  void b()
  {
    int i = this.b.j(this.c);
    Fragment localFragment = this.c;
    localFragment.mContainer.addView(localFragment.mView, i);
  }
  
  void c()
  {
    if (FragmentManager.G0(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveto ATTACHED: ");
      ((StringBuilder)localObject1).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.c;
    Fragment localFragment = ((Fragment)localObject2).mTarget;
    Object localObject1 = null;
    if (localFragment != null)
    {
      localObject1 = this.b.m(localFragment.mWho);
      if (localObject1 != null)
      {
        localObject2 = this.c;
        ((Fragment)localObject2).mTargetWho = ((Fragment)localObject2).mTarget.mWho;
        ((Fragment)localObject2).mTarget = null;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Fragment ");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" declared target fragment ");
        ((StringBuilder)localObject1).append(this.c.mTarget);
        ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject2 = ((Fragment)localObject2).mTargetWho;
      if (localObject2 != null)
      {
        localObject1 = this.b.m((String)localObject2);
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Fragment ");
          ((StringBuilder)localObject1).append(this.c);
          ((StringBuilder)localObject1).append(" declared target fragment ");
          ((StringBuilder)localObject1).append(this.c.mTargetWho);
          ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
    }
    if ((localObject1 != null) && ((FragmentManager.P) || (((o)localObject1).k().mState < 1))) {
      ((o)localObject1).m();
    }
    localObject1 = this.c;
    ((Fragment)localObject1).mHost = ((Fragment)localObject1).mFragmentManager.u0();
    localObject1 = this.c;
    ((Fragment)localObject1).mParentFragment = ((Fragment)localObject1).mFragmentManager.x0();
    this.a.g(this.c, false);
    this.c.performAttach();
    this.a.b(this.c, false);
  }
  
  int d()
  {
    Object localObject1 = this.c;
    if (((Fragment)localObject1).mFragmentManager == null) {
      return ((Fragment)localObject1).mState;
    }
    int j = this.e;
    int k = b.a[localObject1.mMaxState.ordinal()];
    int i = j;
    if (k != 1) {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            i = Math.min(j, -1);
          } else {
            i = Math.min(j, 0);
          }
        }
        else {
          i = Math.min(j, 1);
        }
      }
      else {
        i = Math.min(j, 5);
      }
    }
    localObject1 = this.c;
    j = i;
    if (((Fragment)localObject1).mFromLayout) {
      if (((Fragment)localObject1).mInLayout)
      {
        i = Math.max(this.e, 2);
        localObject1 = this.c.mView;
        j = i;
        if (localObject1 != null)
        {
          j = i;
          if (((View)localObject1).getParent() == null) {
            j = Math.min(i, 2);
          }
        }
      }
      else if (this.e < 4)
      {
        j = Math.min(i, ((Fragment)localObject1).mState);
      }
      else
      {
        j = Math.min(i, 1);
      }
    }
    k = j;
    if (!this.c.mAdded) {
      k = Math.min(j, 1);
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (FragmentManager.P)
    {
      Fragment localFragment = this.c;
      ViewGroup localViewGroup = localFragment.mContainer;
      localObject1 = localObject2;
      if (localViewGroup != null) {
        localObject1 = w.n(localViewGroup, localFragment.getParentFragmentManager()).l(this);
      }
    }
    if (localObject1 == w.e.b.b)
    {
      i = Math.min(k, 6);
    }
    else if (localObject1 == w.e.b.c)
    {
      i = Math.max(k, 3);
    }
    else
    {
      localObject1 = this.c;
      i = k;
      if (((Fragment)localObject1).mRemoving) {
        if (((Fragment)localObject1).isInBackStack()) {
          i = Math.min(k, 1);
        } else {
          i = Math.min(k, -1);
        }
      }
    }
    localObject1 = this.c;
    j = i;
    if (((Fragment)localObject1).mDeferStart)
    {
      j = i;
      if (((Fragment)localObject1).mState < 5) {
        j = Math.min(i, 4);
      }
    }
    if (FragmentManager.G0(2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("computeExpectedState() of ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" for ");
      ((StringBuilder)localObject1).append(this.c);
      Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    return j;
  }
  
  void e()
  {
    if (FragmentManager.G0(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto CREATED: ");
      ((StringBuilder)localObject).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (!((Fragment)localObject).mIsCreated)
    {
      this.a.h((Fragment)localObject, ((Fragment)localObject).mSavedFragmentState, false);
      localObject = this.c;
      ((Fragment)localObject).performCreate(((Fragment)localObject).mSavedFragmentState);
      localObject = this.a;
      Fragment localFragment = this.c;
      ((j)localObject).c(localFragment, localFragment.mSavedFragmentState, false);
      return;
    }
    ((Fragment)localObject).restoreChildFragmentState(((Fragment)localObject).mSavedFragmentState);
    this.c.mState = 1;
  }
  
  void f()
  {
    if (this.c.mFromLayout) {
      return;
    }
    if (FragmentManager.G0(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveto CREATE_VIEW: ");
      ((StringBuilder)localObject1).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.c;
    LayoutInflater localLayoutInflater = ((Fragment)localObject1).performGetLayoutInflater(((Fragment)localObject1).mSavedFragmentState);
    localObject1 = null;
    Fragment localFragment = this.c;
    Object localObject2 = localFragment.mContainer;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
    }
    else
    {
      i = localFragment.mContainerId;
      if (i != 0) {
        if (i != -1)
        {
          localObject2 = (ViewGroup)localFragment.mFragmentManager.p0().c(this.c.mContainerId);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label329;
          }
          localObject1 = this.c;
          if (((Fragment)localObject1).mRestored)
          {
            localObject1 = localObject2;
            break label329;
          }
        }
      }
    }
    try
    {
      localObject1 = ((Fragment)localObject1).getResources().getResourceName(this.c.mContainerId);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label191:
      boolean bool2;
      float f;
      boolean bool1;
      break label191;
    }
    localObject1 = "unknown";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("No view found for id 0x");
    ((StringBuilder)localObject2).append(Integer.toHexString(this.c.mContainerId));
    ((StringBuilder)localObject2).append(" (");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(") for fragment ");
    ((StringBuilder)localObject2).append(this.c);
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot create fragment ");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(" for a container view with no id");
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    label329:
    localObject2 = this.c;
    ((Fragment)localObject2).mContainer = ((ViewGroup)localObject1);
    ((Fragment)localObject2).performCreateView(localLayoutInflater, (ViewGroup)localObject1, ((Fragment)localObject2).mSavedFragmentState);
    localObject2 = this.c.mView;
    if (localObject2 != null)
    {
      bool2 = false;
      ((View)localObject2).setSaveFromParentEnabled(false);
      localObject2 = this.c;
      ((Fragment)localObject2).mView.setTag(R.id.fragment_container_view_tag, localObject2);
      if (localObject1 != null) {
        b();
      }
      localObject1 = this.c;
      if (((Fragment)localObject1).mHidden) {
        ((Fragment)localObject1).mView.setVisibility(8);
      }
      if (x.T(this.c.mView))
      {
        x.n0(this.c.mView);
      }
      else
      {
        localObject1 = this.c.mView;
        ((View)localObject1).addOnAttachStateChangeListener(new a((View)localObject1));
      }
      this.c.performViewCreated();
      localObject1 = this.a;
      localObject2 = this.c;
      ((j)localObject1).m((Fragment)localObject2, ((Fragment)localObject2).mView, ((Fragment)localObject2).mSavedFragmentState, false);
      i = this.c.mView.getVisibility();
      f = this.c.mView.getAlpha();
      if (FragmentManager.P)
      {
        this.c.setPostOnViewCreatedAlpha(f);
        localObject1 = this.c;
        if ((((Fragment)localObject1).mContainer != null) && (i == 0))
        {
          localObject1 = ((Fragment)localObject1).mView.findFocus();
          if (localObject1 != null)
          {
            this.c.setFocusedView((View)localObject1);
            if (FragmentManager.G0(2))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("requestFocus: Saved focused view ");
              ((StringBuilder)localObject2).append(localObject1);
              ((StringBuilder)localObject2).append(" for Fragment ");
              ((StringBuilder)localObject2).append(this.c);
              Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
            }
          }
          this.c.mView.setAlpha(0.0F);
        }
      }
      else
      {
        localObject1 = this.c;
        bool1 = bool2;
        if (i == 0)
        {
          bool1 = bool2;
          if (((Fragment)localObject1).mContainer != null) {
            bool1 = true;
          }
        }
        ((Fragment)localObject1).mIsNewlyAdded = bool1;
      }
    }
    this.c.mState = 2;
  }
  
  void g()
  {
    if (FragmentManager.G0(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("movefrom CREATED: ");
      ((StringBuilder)localObject1).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.c;
    boolean bool2 = ((Fragment)localObject1).mRemoving;
    boolean bool1 = true;
    int i;
    if ((bool2) && (!((Fragment)localObject1).isInBackStack())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i == 0) && (!this.b.o().p(this.c))) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      localObject1 = this.c.mHost;
      if ((localObject1 instanceof a0)) {
        bool1 = this.b.o().m();
      } else if ((((h)localObject1).f() instanceof Activity)) {
        bool1 = true ^ ((Activity)((h)localObject1).f()).isChangingConfigurations();
      }
      if ((i != 0) || (bool1)) {
        this.b.o().g(this.c);
      }
      this.c.performDestroy();
      this.a.d(this.c, false);
      localObject1 = this.b.k().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).k();
          if (this.c.mWho.equals(((Fragment)localObject2).mTargetWho))
          {
            ((Fragment)localObject2).mTarget = this.c;
            ((Fragment)localObject2).mTargetWho = null;
          }
        }
      }
      localObject1 = this.c;
      Object localObject2 = ((Fragment)localObject1).mTargetWho;
      if (localObject2 != null) {
        ((Fragment)localObject1).mTarget = this.b.f((String)localObject2);
      }
      this.b.q(this);
      return;
    }
    localObject1 = this.c.mTargetWho;
    if (localObject1 != null)
    {
      localObject1 = this.b.f((String)localObject1);
      if ((localObject1 != null) && (((Fragment)localObject1).mRetainInstance)) {
        this.c.mTarget = ((Fragment)localObject1);
      }
    }
    this.c.mState = 0;
  }
  
  void h()
  {
    if (FragmentManager.G0(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("movefrom CREATE_VIEW: ");
      ((StringBuilder)localObject1).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.c;
    Object localObject1 = ((Fragment)localObject2).mContainer;
    if (localObject1 != null)
    {
      localObject2 = ((Fragment)localObject2).mView;
      if (localObject2 != null) {
        ((ViewGroup)localObject1).removeView((View)localObject2);
      }
    }
    this.c.performDestroyView();
    this.a.n(this.c, false);
    localObject1 = this.c;
    ((Fragment)localObject1).mContainer = null;
    ((Fragment)localObject1).mView = null;
    ((Fragment)localObject1).mViewLifecycleOwner = null;
    ((Fragment)localObject1).mViewLifecycleOwnerLiveData.o(null);
    this.c.mInLayout = false;
  }
  
  void i()
  {
    if (FragmentManager.G0(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("movefrom ATTACHED: ");
      ((StringBuilder)localObject).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    this.c.performDetach();
    Object localObject = this.a;
    Fragment localFragment = this.c;
    int j = 0;
    ((j)localObject).e(localFragment, false);
    localObject = this.c;
    ((Fragment)localObject).mState = -1;
    ((Fragment)localObject).mHost = null;
    ((Fragment)localObject).mParentFragment = null;
    ((Fragment)localObject).mFragmentManager = null;
    int i = j;
    if (((Fragment)localObject).mRemoving)
    {
      i = j;
      if (!((Fragment)localObject).isInBackStack()) {
        i = 1;
      }
    }
    if ((i != 0) || (this.b.o().p(this.c)))
    {
      if (FragmentManager.G0(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initState called for fragment: ");
        ((StringBuilder)localObject).append(this.c);
        Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      this.c.initState();
    }
  }
  
  void j()
  {
    Object localObject = this.c;
    if ((((Fragment)localObject).mFromLayout) && (((Fragment)localObject).mInLayout) && (!((Fragment)localObject).mPerformedCreateView))
    {
      if (FragmentManager.G0(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveto CREATE_VIEW: ");
        ((StringBuilder)localObject).append(this.c);
        Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      ((Fragment)localObject).performCreateView(((Fragment)localObject).performGetLayoutInflater(((Fragment)localObject).mSavedFragmentState), null, this.c.mSavedFragmentState);
      localObject = this.c.mView;
      if (localObject != null)
      {
        ((View)localObject).setSaveFromParentEnabled(false);
        localObject = this.c;
        ((Fragment)localObject).mView.setTag(R.id.fragment_container_view_tag, localObject);
        localObject = this.c;
        if (((Fragment)localObject).mHidden) {
          ((Fragment)localObject).mView.setVisibility(8);
        }
        this.c.performViewCreated();
        localObject = this.a;
        Fragment localFragment = this.c;
        ((j)localObject).m(localFragment, localFragment.mView, localFragment.mSavedFragmentState, false);
        this.c.mState = 2;
      }
    }
  }
  
  Fragment k()
  {
    return this.c;
  }
  
  void m()
  {
    Object localObject1;
    if (this.d)
    {
      if (FragmentManager.G0(2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Ignoring re-entrant call to moveToExpectedState() for ");
        ((StringBuilder)localObject1).append(k());
        Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
      }
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        this.d = true;
        int i = d();
        localObject1 = this.c;
        j = ((Fragment)localObject1).mState;
        if (i != j) {
          if (i <= j) {
            break label535;
          }
        }
        Object localObject3;
        switch (j + 1)
        {
        case 7: 
          p();
          break;
        case 6: 
          ((Fragment)localObject1).mState = 6;
          break;
        case 5: 
          u();
          break;
        case 4: 
          if (((Fragment)localObject1).mView != null)
          {
            localObject3 = ((Fragment)localObject1).mContainer;
            if (localObject3 != null) {
              w.n((ViewGroup)localObject3, ((Fragment)localObject1).getParentFragmentManager()).b(w.e.c.b(this.c.mView.getVisibility()), this);
            }
          }
          this.c.mState = 4;
          break;
        case 3: 
          a();
          break;
        case 2: 
          j();
          f();
          break;
        case 1: 
          e();
          break;
        case 0: 
          c();
          continue;
          n();
          continue;
          ((Fragment)localObject1).mState = 5;
          continue;
          v();
          continue;
          if (FragmentManager.G0(3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("movefrom ACTIVITY_CREATED: ");
            ((StringBuilder)localObject1).append(this.c);
            Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.c;
          if ((((Fragment)localObject1).mView != null) && (((Fragment)localObject1).mSavedViewState == null)) {
            s();
          }
          localObject1 = this.c;
          if (((Fragment)localObject1).mView != null)
          {
            localObject3 = ((Fragment)localObject1).mContainer;
            if (localObject3 != null) {
              w.n((ViewGroup)localObject3, ((Fragment)localObject1).getParentFragmentManager()).d(this);
            }
          }
          this.c.mState = 3;
          continue;
          ((Fragment)localObject1).mInLayout = false;
          ((Fragment)localObject1).mState = 2;
          continue;
          h();
          this.c.mState = 1;
          continue;
          g();
          continue;
          i();
          continue;
          if ((FragmentManager.P) && (((Fragment)localObject1).mHiddenChanged))
          {
            if (((Fragment)localObject1).mView != null)
            {
              localObject3 = ((Fragment)localObject1).mContainer;
              if (localObject3 != null)
              {
                localObject1 = w.n((ViewGroup)localObject3, ((Fragment)localObject1).getParentFragmentManager());
                if (this.c.mHidden) {
                  ((w)localObject1).c(this);
                } else {
                  ((w)localObject1).e(this);
                }
              }
            }
            localObject1 = this.c;
            localObject3 = ((Fragment)localObject1).mFragmentManager;
            if (localObject3 != null) {
              ((FragmentManager)localObject3).E0((Fragment)localObject1);
            }
            localObject1 = this.c;
            ((Fragment)localObject1).mHiddenChanged = false;
            ((Fragment)localObject1).onHiddenChanged(((Fragment)localObject1).mHidden);
          }
          return;
        }
      }
      finally
      {
        this.d = false;
      }
      continue;
      label535:
      switch (j - 1)
      {
      }
    }
  }
  
  void n()
  {
    if (FragmentManager.G0(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom RESUMED: ");
      localStringBuilder.append(this.c);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.c.performPause();
    this.a.f(this.c, false);
  }
  
  void o(ClassLoader paramClassLoader)
  {
    Object localObject = this.c.mSavedFragmentState;
    if (localObject == null) {
      return;
    }
    ((Bundle)localObject).setClassLoader(paramClassLoader);
    paramClassLoader = this.c;
    paramClassLoader.mSavedViewState = paramClassLoader.mSavedFragmentState.getSparseParcelableArray("android:view_state");
    paramClassLoader = this.c;
    paramClassLoader.mSavedViewRegistryState = paramClassLoader.mSavedFragmentState.getBundle("android:view_registry_state");
    paramClassLoader = this.c;
    paramClassLoader.mTargetWho = paramClassLoader.mSavedFragmentState.getString("android:target_state");
    paramClassLoader = this.c;
    if (paramClassLoader.mTargetWho != null) {
      paramClassLoader.mTargetRequestCode = paramClassLoader.mSavedFragmentState.getInt("android:target_req_state", 0);
    }
    paramClassLoader = this.c;
    localObject = paramClassLoader.mSavedUserVisibleHint;
    if (localObject != null)
    {
      paramClassLoader.mUserVisibleHint = ((Boolean)localObject).booleanValue();
      this.c.mSavedUserVisibleHint = null;
    }
    else
    {
      paramClassLoader.mUserVisibleHint = paramClassLoader.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
    }
    paramClassLoader = this.c;
    if (!paramClassLoader.mUserVisibleHint) {
      paramClassLoader.mDeferStart = true;
    }
  }
  
  void p()
  {
    if (FragmentManager.G0(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto RESUMED: ");
      ((StringBuilder)localObject).append(this.c);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c.getFocusedView();
    if ((localObject != null) && (l((View)localObject)))
    {
      boolean bool = ((View)localObject).requestFocus();
      if (FragmentManager.G0(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestFocus: Restoring focused view ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" ");
        if (bool) {
          localObject = "succeeded";
        } else {
          localObject = "failed";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" on Fragment ");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" resulting in focused view ");
        localStringBuilder.append(this.c.mView.findFocus());
        Log.v("FragmentManager", localStringBuilder.toString());
      }
    }
    this.c.setFocusedView(null);
    this.c.performResume();
    this.a.i(this.c, false);
    localObject = this.c;
    ((Fragment)localObject).mSavedFragmentState = null;
    ((Fragment)localObject).mSavedViewState = null;
    ((Fragment)localObject).mSavedViewRegistryState = null;
  }
  
  FragmentState r()
  {
    FragmentState localFragmentState = new FragmentState(this.c);
    Object localObject = this.c;
    if ((((Fragment)localObject).mState > -1) && (localFragmentState.m == null))
    {
      localObject = q();
      localFragmentState.m = ((Bundle)localObject);
      if (this.c.mTargetWho != null)
      {
        if (localObject == null) {
          localFragmentState.m = new Bundle();
        }
        localFragmentState.m.putString("android:target_state", this.c.mTargetWho);
        int i = this.c.mTargetRequestCode;
        if (i != 0)
        {
          localFragmentState.m.putInt("android:target_req_state", i);
          return localFragmentState;
        }
      }
    }
    else
    {
      localFragmentState.m = ((Fragment)localObject).mSavedFragmentState;
    }
    return localFragmentState;
  }
  
  void s()
  {
    if (this.c.mView == null) {
      return;
    }
    Object localObject = new SparseArray();
    this.c.mView.saveHierarchyState((SparseArray)localObject);
    if (((SparseArray)localObject).size() > 0) {
      this.c.mSavedViewState = ((SparseArray)localObject);
    }
    localObject = new Bundle();
    this.c.mViewLifecycleOwner.e((Bundle)localObject);
    if (!((Bundle)localObject).isEmpty()) {
      this.c.mSavedViewRegistryState = ((Bundle)localObject);
    }
  }
  
  void t(int paramInt)
  {
    this.e = paramInt;
  }
  
  void u()
  {
    if (FragmentManager.G0(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveto STARTED: ");
      localStringBuilder.append(this.c);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.c.performStart();
    this.a.k(this.c, false);
  }
  
  void v()
  {
    if (FragmentManager.G0(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom STARTED: ");
      localStringBuilder.append(this.c);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.c.performStop();
    this.a.l(this.c, false);
  }
  
  class a
    implements View.OnAttachStateChangeListener
  {
    a(View paramView) {}
    
    public void onViewAttachedToWindow(View paramView)
    {
      this.a.removeOnAttachStateChangeListener(this);
      x.n0(this.a);
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.o
 * JD-Core Version:    0.7.0.1
 */