package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import androidx.lifecycle.y.b;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, l, a0, androidx.savedstate.b
{
  static final int ACTIVITY_CREATED = 4;
  static final int ATTACHED = 0;
  static final int AWAITING_ENTER_EFFECTS = 6;
  static final int AWAITING_EXIT_EFFECTS = 3;
  static final int CREATED = 1;
  static final int INITIALIZING = -1;
  static final int RESUMED = 7;
  static final int STARTED = 5;
  static final Object USE_DEFAULT_TRANSITION = new Object();
  static final int VIEW_CREATED = 2;
  boolean mAdded;
  i mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  private boolean mCalled;
  FragmentManager mChildFragmentManager = new k();
  ViewGroup mContainer;
  int mContainerId;
  private int mContentLayoutId;
  y.b mDefaultFactory;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManager mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  h<?> mHost;
  boolean mInLayout;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  private Boolean mIsPrimaryNavigationFragment = null;
  LayoutInflater mLayoutInflater;
  m mLifecycleRegistry;
  h.c mMaxState = h.c.e;
  boolean mMenuVisible = true;
  private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
  private final ArrayList<k> mOnPreAttachedListeners = new ArrayList();
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  Runnable mPostponedDurationRunnable = new a();
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetainInstanceChangedWhileDetached;
  Bundle mSavedFragmentState;
  androidx.savedstate.a mSavedStateRegistryController;
  Boolean mSavedUserVisibleHint;
  Bundle mSavedViewRegistryState;
  SparseArray<Parcelable> mSavedViewState;
  int mState = -1;
  String mTag;
  Fragment mTarget;
  int mTargetRequestCode;
  String mTargetWho = null;
  boolean mUserVisibleHint = true;
  View mView;
  u mViewLifecycleOwner;
  r<l> mViewLifecycleOwnerLiveData = new r();
  String mWho = UUID.randomUUID().toString();
  
  public Fragment()
  {
    initLifecycle();
  }
  
  public Fragment(int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private i ensureAnimationInfo()
  {
    if (this.mAnimationInfo == null) {
      this.mAnimationInfo = new i();
    }
    return this.mAnimationInfo;
  }
  
  private int getMinimumMaxLifecycleState()
  {
    h.c localc = this.mMaxState;
    if ((localc != h.c.b) && (this.mParentFragment != null)) {
      return Math.min(localc.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }
    return localc.ordinal();
  }
  
  private void initLifecycle()
  {
    this.mLifecycleRegistry = new m(this);
    this.mSavedStateRegistryController = androidx.savedstate.a.a(this);
    this.mDefaultFactory = null;
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      paramContext = (Fragment)g.d(paramContext.getClassLoader(), paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": calling Fragment constructor caused an exception");
      throw new j(paramBundle.toString(), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": could not find Fragment constructor");
      throw new j(paramBundle.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new j(paramBundle.toString(), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new j(paramBundle.toString(), paramContext);
    }
  }
  
  private <I, O> androidx.activity.result.b<I> prepareCallInternal(final b.a<I, O> parama, final k.a<Void, ActivityResultRegistry> parama1, final androidx.activity.result.a<O> parama2)
  {
    if (this.mState <= 1)
    {
      final AtomicReference localAtomicReference = new AtomicReference();
      registerOnPreAttachListener(new g(parama1, localAtomicReference, parama, parama2));
      return new h(localAtomicReference, parama);
    }
    parama = new StringBuilder();
    parama.append("Fragment ");
    parama.append(this);
    parama.append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    throw new IllegalStateException(parama.toString());
  }
  
  private void registerOnPreAttachListener(k paramk)
  {
    if (this.mState >= 0)
    {
      paramk.a();
      return;
    }
    this.mOnPreAttachedListeners.add(paramk);
  }
  
  private void restoreViewState()
  {
    if (FragmentManager.G0(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveto RESTORE_VIEW_STATE: ");
      localStringBuilder.append(this);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    if (this.mView != null) {
      restoreViewState(this.mSavedFragmentState);
    }
    this.mSavedFragmentState = null;
  }
  
  void callStartTransitionListener(boolean paramBoolean)
  {
    Object localObject2 = this.mAnimationInfo;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      ((i)localObject2).w = false;
      localObject1 = ((i)localObject2).x;
      ((i)localObject2).x = null;
    }
    if (localObject1 != null)
    {
      ((l)localObject1).a();
      return;
    }
    if ((FragmentManager.P) && (this.mView != null))
    {
      localObject1 = this.mContainer;
      if (localObject1 != null)
      {
        localObject2 = this.mFragmentManager;
        if (localObject2 != null)
        {
          localObject1 = w.n((ViewGroup)localObject1, (FragmentManager)localObject2);
          ((w)localObject1).p();
          if (paramBoolean)
          {
            this.mHost.g().post(new c((w)localObject1));
            return;
          }
          ((w)localObject1).g();
        }
      }
    }
  }
  
  e createFragmentContainer()
  {
    return new d();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    if (this.mSavedViewRegistryState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewRegistryState=");
      paramPrintWriter.println(this.mSavedViewRegistryState);
    }
    Object localObject = getTargetFragment();
    if (localObject != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(localObject);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mPopDirection=");
    paramPrintWriter.println(getPopDirection());
    if (getEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getEnterAnim=");
      paramPrintWriter.println(getEnterAnim());
    }
    if (getExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getExitAnim=");
      paramPrintWriter.println(getExitAnim());
    }
    if (getPopEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopEnterAnim=");
      paramPrintWriter.println(getPopEnterAnim());
    }
    if (getPopExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopExitAnim=");
      paramPrintWriter.println(getPopExitAnim());
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
    }
    if (getContext() != null) {
      androidx.loader.app.a.c(this).b(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    paramPrintWriter.print(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Child ");
    ((StringBuilder)localObject).append(this.mChildFragmentManager);
    ((StringBuilder)localObject).append(":");
    paramPrintWriter.println(((StringBuilder)localObject).toString());
    localObject = this.mChildFragmentManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("  ");
    ((FragmentManager)localObject).X(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(this.mWho)) {
      return this;
    }
    return this.mChildFragmentManager.k0(paramString);
  }
  
  String generateActivityResultKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fragment_");
    localStringBuilder.append(this.mWho);
    localStringBuilder.append("_rq#");
    localStringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
    return localStringBuilder.toString();
  }
  
  public final FragmentActivity getActivity()
  {
    h localh = this.mHost;
    if (localh == null) {
      return null;
    }
    return (FragmentActivity)localh.e();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    Object localObject = this.mAnimationInfo;
    if (localObject != null)
    {
      localObject = ((i)localObject).r;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    Object localObject = this.mAnimationInfo;
    if (localObject != null)
    {
      localObject = ((i)localObject).q;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  View getAnimatingAway()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.a;
  }
  
  Animator getAnimator()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.b;
  }
  
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  public final FragmentManager getChildFragmentManager()
  {
    if (this.mHost != null) {
      return this.mChildFragmentManager;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" has not been attached yet.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Context getContext()
  {
    h localh = this.mHost;
    if (localh == null) {
      return null;
    }
    return localh.f();
  }
  
  public y.b getDefaultViewModelProviderFactory()
  {
    if (this.mFragmentManager != null)
    {
      if (this.mDefaultFactory == null)
      {
        Object localObject3 = null;
        Object localObject1;
        for (Object localObject2 = requireContext().getApplicationContext();; localObject2 = ((ContextWrapper)localObject2).getBaseContext())
        {
          localObject1 = localObject3;
          if (!(localObject2 instanceof ContextWrapper)) {
            break;
          }
          if ((localObject2 instanceof Application))
          {
            localObject1 = (Application)localObject2;
            break;
          }
        }
        if ((localObject1 == null) && (FragmentManager.G0(3)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Could not find Application instance from Context ");
          ((StringBuilder)localObject2).append(requireContext().getApplicationContext());
          ((StringBuilder)localObject2).append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
          Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        this.mDefaultFactory = new androidx.lifecycle.w((Application)localObject1, this, getArguments());
      }
      return this.mDefaultFactory;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  int getEnterAnim()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 0;
    }
    return locali.d;
  }
  
  public Object getEnterTransition()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.k;
  }
  
  n getEnterTransitionCallback()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.s;
  }
  
  int getExitAnim()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 0;
    }
    return locali.e;
  }
  
  public Object getExitTransition()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.m;
  }
  
  n getExitTransitionCallback()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.t;
  }
  
  View getFocusedView()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.v;
  }
  
  @Deprecated
  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public final Object getHost()
  {
    h localh = this.mHost;
    if (localh == null) {
      return null;
    }
    return localh.h();
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    LayoutInflater localLayoutInflater2 = this.mLayoutInflater;
    LayoutInflater localLayoutInflater1 = localLayoutInflater2;
    if (localLayoutInflater2 == null) {
      localLayoutInflater1 = performGetLayoutInflater(null);
    }
    return localLayoutInflater1;
  }
  
  @Deprecated
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    paramBundle = this.mHost;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.i();
      androidx.core.view.g.a(paramBundle, this.mChildFragmentManager.v0());
      return paramBundle;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public androidx.lifecycle.h getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @Deprecated
  public androidx.loader.app.a getLoaderManager()
  {
    return androidx.loader.app.a.c(this);
  }
  
  int getNextTransition()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 0;
    }
    return locali.h;
  }
  
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  public final FragmentManager getParentFragmentManager()
  {
    Object localObject = this.mFragmentManager;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not associated with a fragment manager.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  boolean getPopDirection()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return false;
    }
    return locali.c;
  }
  
  int getPopEnterAnim()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 0;
    }
    return locali.f;
  }
  
  int getPopExitAnim()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 0;
    }
    return locali.g;
  }
  
  float getPostOnViewCreatedAlpha()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return 1.0F;
    }
    return locali.u;
  }
  
  public Object getReenterTransition()
  {
    Object localObject1 = this.mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((i)localObject1).n;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getExitTransition();
    }
    return localObject1;
  }
  
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  @Deprecated
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    Object localObject1 = this.mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((i)localObject1).l;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getEnterTransition();
    }
    return localObject1;
  }
  
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.b();
  }
  
  public Object getSharedElementEnterTransition()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return null;
    }
    return locali.o;
  }
  
  public Object getSharedElementReturnTransition()
  {
    Object localObject1 = this.mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((i)localObject1).p;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getSharedElementEnterTransition();
    }
    return localObject1;
  }
  
  ArrayList<String> getSharedElementSourceNames()
  {
    Object localObject = this.mAnimationInfo;
    if (localObject != null)
    {
      localObject = ((i)localObject).i;
      if (localObject != null) {
        return localObject;
      }
    }
    return new ArrayList();
  }
  
  ArrayList<String> getSharedElementTargetNames()
  {
    Object localObject = this.mAnimationInfo;
    if (localObject != null)
    {
      localObject = ((i)localObject).j;
      if (localObject != null) {
        return localObject;
      }
    }
    return new ArrayList();
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return this.mTag;
  }
  
  @Deprecated
  public final Fragment getTargetFragment()
  {
    Object localObject = this.mTarget;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mFragmentManager;
    if (localObject != null)
    {
      String str = this.mTargetWho;
      if (str != null) {
        return ((FragmentManager)localObject).h0(str);
      }
    }
    return null;
  }
  
  @Deprecated
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  @Deprecated
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public l getViewLifecycleOwner()
  {
    u localu = this.mViewLifecycleOwner;
    if (localu != null) {
      return localu;
    }
    throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
  }
  
  public LiveData<l> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }
  
  public z getViewModelStore()
  {
    if (this.mFragmentManager != null)
    {
      if (getMinimumMaxLifecycleState() != h.c.b.ordinal()) {
        return this.mFragmentManager.B0(this);
      }
      throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  @SuppressLint({"KotlinPropertyAccess"})
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  void initState()
  {
    initLifecycle();
    this.mWho = UUID.randomUUID().toString();
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = new k();
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
  }
  
  public final boolean isAdded()
  {
    return (this.mHost != null) && (this.mAdded);
  }
  
  public final boolean isDetached()
  {
    return this.mDetached;
  }
  
  public final boolean isHidden()
  {
    return this.mHidden;
  }
  
  boolean isHideReplaced()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return false;
    }
    return locali.y;
  }
  
  final boolean isInBackStack()
  {
    return this.mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return this.mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    if (this.mMenuVisible)
    {
      FragmentManager localFragmentManager = this.mFragmentManager;
      if ((localFragmentManager == null) || (localFragmentManager.I0(this.mParentFragment))) {
        return true;
      }
    }
    return false;
  }
  
  boolean isPostponed()
  {
    i locali = this.mAnimationInfo;
    if (locali == null) {
      return false;
    }
    return locali.w;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  final boolean isRemovingParent()
  {
    Fragment localFragment = getParentFragment();
    return (localFragment != null) && ((localFragment.isRemoving()) || (localFragment.isRemovingParent()));
  }
  
  public final boolean isResumed()
  {
    return this.mState >= 7;
  }
  
  public final boolean isStateSaved()
  {
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (localFragmentManager == null) {
      return false;
    }
    return localFragmentManager.L0();
  }
  
  public final boolean isVisible()
  {
    if ((isAdded()) && (!isHidden()))
    {
      View localView = this.mView;
      if ((localView != null) && (localView.getWindowToken() != null) && (this.mView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  void noteStateNotSaved()
  {
    this.mChildFragmentManager.U0();
  }
  
  @Deprecated
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(this);
      localStringBuilder.append(" received the following in onActivityResult(): requestCode: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" resultCode: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramIntent);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    this.mCalled = true;
    paramContext = this.mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.e();
    }
    if (paramContext != null)
    {
      this.mCalled = false;
      onAttach(paramContext);
    }
  }
  
  @Deprecated
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (!this.mChildFragmentManager.K0(1)) {
      this.mChildFragmentManager.D();
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    requireActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = this.mContentLayoutId;
    if (i != 0) {
      return paramLayoutInflater.inflate(i, paramViewGroup, false);
    }
    return null;
  }
  
  public void onDestroy()
  {
    this.mCalled = true;
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    this.mCalled = true;
  }
  
  public void onDetach()
  {
    this.mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
    paramContext = this.mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.e();
    }
    if (paramContext != null)
    {
      this.mCalled = false;
      onInflate(paramContext, paramAttributeSet, paramBundle);
    }
  }
  
  public void onLowMemory()
  {
    this.mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    this.mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume()
  {
    this.mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mCalled = true;
  }
  
  public void onStop()
  {
    this.mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    this.mChildFragmentManager.U0();
    this.mState = 3;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (this.mCalled)
    {
      restoreViewState();
      this.mChildFragmentManager.z();
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onActivityCreated()");
    throw new y(paramBundle.toString());
  }
  
  void performAttach()
  {
    Object localObject = this.mOnPreAttachedListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((k)((Iterator)localObject).next()).a();
    }
    this.mOnPreAttachedListeners.clear();
    this.mChildFragmentManager.k(this.mHost, createFragmentContainer(), this);
    this.mState = 0;
    this.mCalled = false;
    onAttach(this.mHost.f());
    if (this.mCalled)
    {
      this.mFragmentManager.J(this);
      this.mChildFragmentManager.A();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onAttach()");
    throw new y(((StringBuilder)localObject).toString());
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    this.mChildFragmentManager.B(paramConfiguration);
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {
        return true;
      }
      return this.mChildFragmentManager.C(paramMenuItem);
    }
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    this.mChildFragmentManager.U0();
    this.mState = 1;
    this.mCalled = false;
    this.mLifecycleRegistry.a(new j()
    {
      public void d(l paramAnonymousl, h.b paramAnonymousb)
      {
        if (paramAnonymousb == h.b.ON_STOP)
        {
          paramAnonymousl = Fragment.this.mView;
          if (paramAnonymousl != null) {
            paramAnonymousl.cancelPendingInputEvents();
          }
        }
      }
    });
    this.mSavedStateRegistryController.c(paramBundle);
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (this.mCalled)
    {
      this.mLifecycleRegistry.h(h.b.ON_CREATE);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onCreate()");
    throw new y(paramBundle.toString());
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = this.mHidden;
    boolean bool1 = false;
    int j = 0;
    if (!bool2)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool1 = i | this.mChildFragmentManager.E(paramMenu, paramMenuInflater);
    }
    return bool1;
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mChildFragmentManager.U0();
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new u(this, getViewModelStore());
    paramLayoutInflater = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mView = paramLayoutInflater;
    if (paramLayoutInflater != null)
    {
      this.mViewLifecycleOwner.b();
      b0.a(this.mView, this.mViewLifecycleOwner);
      c0.a(this.mView, this.mViewLifecycleOwner);
      androidx.savedstate.c.a(this.mView, this.mViewLifecycleOwner);
      this.mViewLifecycleOwnerLiveData.o(this.mViewLifecycleOwner);
      return;
    }
    if (!this.mViewLifecycleOwner.c())
    {
      this.mViewLifecycleOwner = null;
      return;
    }
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  void performDestroy()
  {
    this.mChildFragmentManager.F();
    this.mLifecycleRegistry.h(h.b.ON_DESTROY);
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (this.mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroy()");
    throw new y(localStringBuilder.toString());
  }
  
  void performDestroyView()
  {
    this.mChildFragmentManager.G();
    if ((this.mView != null) && (this.mViewLifecycleOwner.getLifecycle().b().a(h.c.c))) {
      this.mViewLifecycleOwner.a(h.b.ON_DESTROY);
    }
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (this.mCalled)
    {
      androidx.loader.app.a.c(this).e();
      this.mPerformedCreateView = false;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroyView()");
    throw new y(localStringBuilder.toString());
  }
  
  void performDetach()
  {
    this.mState = -1;
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    if (this.mCalled)
    {
      if (!this.mChildFragmentManager.F0())
      {
        this.mChildFragmentManager.F();
        this.mChildFragmentManager = new k();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDetach()");
    throw new y(localStringBuilder.toString());
  }
  
  LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    paramBundle = onGetLayoutInflater(paramBundle);
    this.mLayoutInflater = paramBundle;
    return paramBundle;
  }
  
  void performLowMemory()
  {
    onLowMemory();
    this.mChildFragmentManager.H();
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    this.mChildFragmentManager.I(paramBoolean);
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      return this.mChildFragmentManager.K(paramMenuItem);
    }
    return false;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      this.mChildFragmentManager.L(paramMenu);
    }
  }
  
  void performPause()
  {
    this.mChildFragmentManager.N();
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(h.b.ON_PAUSE);
    }
    this.mLifecycleRegistry.h(h.b.ON_PAUSE);
    this.mState = 6;
    this.mCalled = false;
    onPause();
    if (this.mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onPause()");
    throw new y(localStringBuilder.toString());
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    this.mChildFragmentManager.O(paramBoolean);
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = this.mHidden;
    boolean bool1 = false;
    int j = 0;
    if (!bool2)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool1 = i | this.mChildFragmentManager.P(paramMenu);
    }
    return bool1;
  }
  
  void performPrimaryNavigationFragmentChanged()
  {
    boolean bool = this.mFragmentManager.J0(this);
    Boolean localBoolean = this.mIsPrimaryNavigationFragment;
    if ((localBoolean == null) || (localBoolean.booleanValue() != bool))
    {
      this.mIsPrimaryNavigationFragment = Boolean.valueOf(bool);
      onPrimaryNavigationFragmentChanged(bool);
      this.mChildFragmentManager.Q();
    }
  }
  
  void performResume()
  {
    this.mChildFragmentManager.U0();
    this.mChildFragmentManager.b0(true);
    this.mState = 7;
    this.mCalled = false;
    onResume();
    if (this.mCalled)
    {
      localObject = this.mLifecycleRegistry;
      h.b localb = h.b.ON_RESUME;
      ((m)localObject).h(localb);
      if (this.mView != null) {
        this.mViewLifecycleOwner.a(localb);
      }
      this.mChildFragmentManager.R();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onResume()");
    throw new y(((StringBuilder)localObject).toString());
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.d(paramBundle);
    Parcelable localParcelable = this.mChildFragmentManager.j1();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  void performStart()
  {
    this.mChildFragmentManager.U0();
    this.mChildFragmentManager.b0(true);
    this.mState = 5;
    this.mCalled = false;
    onStart();
    if (this.mCalled)
    {
      localObject = this.mLifecycleRegistry;
      h.b localb = h.b.ON_START;
      ((m)localObject).h(localb);
      if (this.mView != null) {
        this.mViewLifecycleOwner.a(localb);
      }
      this.mChildFragmentManager.S();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onStart()");
    throw new y(((StringBuilder)localObject).toString());
  }
  
  void performStop()
  {
    this.mChildFragmentManager.U();
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(h.b.ON_STOP);
    }
    this.mLifecycleRegistry.h(h.b.ON_STOP);
    this.mState = 4;
    this.mCalled = false;
    onStop();
    if (this.mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onStop()");
    throw new y(localStringBuilder.toString());
  }
  
  void performViewCreated()
  {
    onViewCreated(this.mView, this.mSavedFragmentState);
    this.mChildFragmentManager.V();
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfo().w = true;
  }
  
  public final void postponeEnterTransition(long paramLong, TimeUnit paramTimeUnit)
  {
    ensureAnimationInfo().w = true;
    Object localObject = this.mFragmentManager;
    if (localObject != null) {
      localObject = ((FragmentManager)localObject).u0().g();
    } else {
      localObject = new Handler(Looper.getMainLooper());
    }
    ((Handler)localObject).removeCallbacks(this.mPostponedDurationRunnable);
    ((Handler)localObject).postDelayed(this.mPostponedDurationRunnable, paramTimeUnit.toMillis(paramLong));
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> parama, final ActivityResultRegistry paramActivityResultRegistry, androidx.activity.result.a<O> parama1)
  {
    return prepareCallInternal(parama, new f(paramActivityResultRegistry), parama1);
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> parama, androidx.activity.result.a<O> parama1)
  {
    return prepareCallInternal(parama, new e(), parama1);
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  @Deprecated
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    if (this.mHost != null)
    {
      getParentFragmentManager().M0(this, paramArrayOfString, paramInt);
      return;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Fragment ");
    paramArrayOfString.append(this);
    paramArrayOfString.append(" not attached to Activity");
    throw new IllegalStateException(paramArrayOfString.toString());
  }
  
  public final FragmentActivity requireActivity()
  {
    Object localObject = getActivity();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to an activity.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Bundle requireArguments()
  {
    Object localObject = getArguments();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have any arguments.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Context requireContext()
  {
    Object localObject = getContext();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a context.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @Deprecated
  public final FragmentManager requireFragmentManager()
  {
    return getParentFragmentManager();
  }
  
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a host.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Fragment requireParentFragment()
  {
    Object localObject = getParentFragment();
    if (localObject == null)
    {
      if (getContext() == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Fragment ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" is not attached to any Fragment or host");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" is not a child Fragment, it is directly attached to ");
      ((StringBuilder)localObject).append(getContext());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  public final View requireView()
  {
    Object localObject = getView();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not return a View from onCreateView() or this was called before onCreateView().");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  void restoreChildFragmentState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        this.mChildFragmentManager.h1(paramBundle);
        this.mChildFragmentManager.D();
      }
    }
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    SparseArray localSparseArray = this.mSavedViewState;
    if (localSparseArray != null)
    {
      this.mView.restoreHierarchyState(localSparseArray);
      this.mSavedViewState = null;
    }
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
      this.mSavedViewRegistryState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (this.mCalled)
    {
      if (this.mView != null) {
        this.mViewLifecycleOwner.a(h.b.ON_CREATE);
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onViewStateRestored()");
    throw new y(paramBundle.toString());
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().r = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().q = Boolean.valueOf(paramBoolean);
  }
  
  void setAnimatingAway(View paramView)
  {
    ensureAnimationInfo().a = paramView;
  }
  
  void setAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
      return;
    }
    ensureAnimationInfo().d = paramInt1;
    ensureAnimationInfo().e = paramInt2;
    ensureAnimationInfo().f = paramInt3;
    ensureAnimationInfo().g = paramInt4;
  }
  
  void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfo().b = paramAnimator;
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if ((this.mFragmentManager != null) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already added and state has been saved");
    }
    this.mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(n paramn)
  {
    ensureAnimationInfo().s = paramn;
  }
  
  public void setEnterTransition(Object paramObject)
  {
    ensureAnimationInfo().k = paramObject;
  }
  
  public void setExitSharedElementCallback(n paramn)
  {
    ensureAnimationInfo().t = paramn;
  }
  
  public void setExitTransition(Object paramObject)
  {
    ensureAnimationInfo().m = paramObject;
  }
  
  void setFocusedView(View paramView)
  {
    ensureAnimationInfo().v = paramView;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mHost.o();
      }
    }
  }
  
  void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfo().y = paramBoolean;
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    if (this.mFragmentManager == null)
    {
      if (paramSavedState != null)
      {
        paramSavedState = paramSavedState.a;
        if (paramSavedState != null) {}
      }
      else
      {
        paramSavedState = null;
      }
      this.mSavedFragmentState = paramSavedState;
      return;
    }
    throw new IllegalStateException("Fragment already added");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mHost.o();
      }
    }
  }
  
  void setNextTransition(int paramInt)
  {
    if ((this.mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo();
    this.mAnimationInfo.h = paramInt;
  }
  
  void setOnStartEnterTransitionListener(l paraml)
  {
    ensureAnimationInfo();
    i locali = this.mAnimationInfo;
    l locall = locali.x;
    if (paraml == locall) {
      return;
    }
    if ((paraml != null) && (locall != null))
    {
      paraml = new StringBuilder();
      paraml.append("Trying to set a replacement startPostponedEnterTransition on ");
      paraml.append(this);
      throw new IllegalStateException(paraml.toString());
    }
    if (locali.w) {
      locali.x = paraml;
    }
    if (paraml != null) {
      paraml.b();
    }
  }
  
  void setPopDirection(boolean paramBoolean)
  {
    if (this.mAnimationInfo == null) {
      return;
    }
    ensureAnimationInfo().c = paramBoolean;
  }
  
  void setPostOnViewCreatedAlpha(float paramFloat)
  {
    ensureAnimationInfo().u = paramFloat;
  }
  
  public void setReenterTransition(Object paramObject)
  {
    ensureAnimationInfo().n = paramObject;
  }
  
  @Deprecated
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mRetainInstance = paramBoolean;
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (localFragmentManager != null)
    {
      if (paramBoolean)
      {
        localFragmentManager.i(this);
        return;
      }
      localFragmentManager.f1(this);
      return;
    }
    this.mRetainInstanceChangedWhileDetached = true;
  }
  
  public void setReturnTransition(Object paramObject)
  {
    ensureAnimationInfo().l = paramObject;
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    ensureAnimationInfo().o = paramObject;
  }
  
  void setSharedElementNames(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    ensureAnimationInfo();
    i locali = this.mAnimationInfo;
    locali.i = paramArrayList1;
    locali.j = paramArrayList2;
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    ensureAnimationInfo().p = paramObject;
  }
  
  @Deprecated
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (paramFragment != null) {
      localObject = paramFragment.mFragmentManager;
    } else {
      localObject = null;
    }
    if ((localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" must share the same FragmentManager to be set as a target fragment");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = paramFragment;
    while (localObject != null) {
      if (!((Fragment)localObject).equals(this))
      {
        localObject = ((Fragment)localObject).getTargetFragment();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" as the target of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" would create a target cycle");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    if (paramFragment == null) {}
    for (this.mTargetWho = null;; this.mTargetWho = paramFragment.mWho)
    {
      this.mTarget = null;
      break label210;
      if ((this.mFragmentManager == null) || (paramFragment.mFragmentManager == null)) {
        break;
      }
    }
    this.mTargetWho = null;
    this.mTarget = paramFragment;
    label210:
    this.mTargetRequestCode = paramInt;
  }
  
  @Deprecated
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 5) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated))
    {
      FragmentManager localFragmentManager = this.mFragmentManager;
      localFragmentManager.W0(localFragmentManager.w(this));
    }
    this.mUserVisibleHint = paramBoolean;
    boolean bool;
    if ((this.mState < 5) && (!paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    this.mDeferStart = bool;
    if (this.mSavedFragmentState != null) {
      this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    h localh = this.mHost;
    if (localh != null) {
      return localh.l(paramString);
    }
    return false;
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent, Bundle paramBundle)
  {
    h localh = this.mHost;
    if (localh != null)
    {
      localh.m(this, paramIntent, -1, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.mHost != null)
    {
      getParentFragmentManager().N0(this, paramIntent, paramInt, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  @Deprecated
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (this.mHost != null)
    {
      if (FragmentManager.G0(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Fragment ");
        localStringBuilder.append(this);
        localStringBuilder.append(" received the following in startIntentSenderForResult() requestCode: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" IntentSender: ");
        localStringBuilder.append(paramIntentSender);
        localStringBuilder.append(" fillInIntent: ");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" options: ");
        localStringBuilder.append(paramBundle);
        Log.v("FragmentManager", localStringBuilder.toString());
      }
      getParentFragmentManager().O0(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramIntentSender = new StringBuilder();
    paramIntentSender.append("Fragment ");
    paramIntentSender.append(this);
    paramIntentSender.append(" not attached to Activity");
    throw new IllegalStateException(paramIntentSender.toString());
  }
  
  public void startPostponedEnterTransition()
  {
    if (this.mAnimationInfo != null)
    {
      if (!ensureAnimationInfo().w) {
        return;
      }
      if (this.mHost == null)
      {
        ensureAnimationInfo().w = false;
        return;
      }
      if (Looper.myLooper() != this.mHost.g().getLooper())
      {
        this.mHost.g().postAtFrontOfQueue(new b());
        return;
      }
      callStartTransitionListener(true);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("}");
    localStringBuilder.append(" (");
    localStringBuilder.append(this.mWho);
    if (this.mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
  
  @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    final Bundle a;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      paramParcel = paramParcel.readBundle();
      this.a = paramParcel;
      if ((paramClassLoader != null) && (paramParcel != null)) {
        paramParcel.setClassLoader(paramClassLoader);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.a);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<Fragment.SavedState>
    {
      public Fragment.SavedState a(Parcel paramParcel)
      {
        return new Fragment.SavedState(paramParcel, null);
      }
      
      public Fragment.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new Fragment.SavedState(paramParcel, paramClassLoader);
      }
      
      public Fragment.SavedState[] c(int paramInt)
      {
        return new Fragment.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      Fragment.this.startPostponedEnterTransition();
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      Fragment.this.callStartTransitionListener(false);
    }
  }
  
  class c
    implements Runnable
  {
    c(w paramw) {}
    
    public void run()
    {
      this.a.g();
    }
  }
  
  class d
    extends e
  {
    d() {}
    
    public View c(int paramInt)
    {
      Object localObject = Fragment.this.mView;
      if (localObject != null) {
        return ((View)localObject).findViewById(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(Fragment.this);
      ((StringBuilder)localObject).append(" does not have a view");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    public boolean d()
    {
      return Fragment.this.mView != null;
    }
  }
  
  class e
    implements k.a<Void, ActivityResultRegistry>
  {
    e() {}
    
    public ActivityResultRegistry b(Void paramVoid)
    {
      paramVoid = Fragment.this;
      h localh = paramVoid.mHost;
      if ((localh instanceof androidx.activity.result.c)) {
        return ((androidx.activity.result.c)localh).getActivityResultRegistry();
      }
      return paramVoid.requireActivity().getActivityResultRegistry();
    }
  }
  
  class f
    implements k.a<Void, ActivityResultRegistry>
  {
    f(ActivityResultRegistry paramActivityResultRegistry) {}
    
    public ActivityResultRegistry b(Void paramVoid)
    {
      return paramActivityResultRegistry;
    }
  }
  
  class g
    extends Fragment.k
  {
    g(k.a parama, AtomicReference paramAtomicReference, b.a parama1, androidx.activity.result.a parama2)
    {
      super();
    }
    
    void a()
    {
      String str = Fragment.this.generateActivityResultKey();
      ActivityResultRegistry localActivityResultRegistry = (ActivityResultRegistry)parama1.a(null);
      localAtomicReference.set(localActivityResultRegistry.i(str, Fragment.this, parama, parama2));
    }
  }
  
  class h
    extends androidx.activity.result.b<I>
  {
    h(AtomicReference paramAtomicReference, b.a parama) {}
    
    public void b(I paramI, androidx.core.app.b paramb)
    {
      androidx.activity.result.b localb = (androidx.activity.result.b)localAtomicReference.get();
      if (localb != null)
      {
        localb.b(paramI, paramb);
        return;
      }
      throw new IllegalStateException("Operation cannot be started before fragment is in created state");
    }
    
    public void c()
    {
      androidx.activity.result.b localb = (androidx.activity.result.b)localAtomicReference.getAndSet(null);
      if (localb != null) {
        localb.c();
      }
    }
  }
  
  static class i
  {
    View a;
    Animator b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    int h;
    ArrayList<String> i;
    ArrayList<String> j;
    Object k = null;
    Object l;
    Object m;
    Object n;
    Object o;
    Object p;
    Boolean q;
    Boolean r;
    n s;
    n t;
    float u;
    View v;
    boolean w;
    Fragment.l x;
    boolean y;
    
    i()
    {
      Object localObject = Fragment.USE_DEFAULT_TRANSITION;
      this.l = localObject;
      this.m = null;
      this.n = localObject;
      this.o = null;
      this.p = localObject;
      this.s = null;
      this.t = null;
      this.u = 1.0F;
      this.v = null;
    }
  }
  
  public static class j
    extends RuntimeException
  {
    public j(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  private static abstract class k
  {
    abstract void a();
  }
  
  static abstract interface l
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.Fragment
 * JD-Core Version:    0.7.0.1
 */