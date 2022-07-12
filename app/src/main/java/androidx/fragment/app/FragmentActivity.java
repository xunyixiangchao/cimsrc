package androidx.fragment.app;

import a.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.a.c;
import androidx.core.app.n;
import androidx.lifecycle.a0;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends ComponentActivity
  implements a.c
{
  static final String FRAGMENTS_TAG = "android:support:fragments";
  boolean mCreated;
  final androidx.lifecycle.m mFragmentLifecycleRegistry = new androidx.lifecycle.m(this);
  final f mFragments = f.b(new c());
  boolean mResumed;
  boolean mStopped = true;
  
  public FragmentActivity()
  {
    init();
  }
  
  public FragmentActivity(int paramInt)
  {
    super(paramInt);
    init();
  }
  
  private void init()
  {
    getSavedStateRegistry().d("android:support:fragments", new a());
    addOnContextAvailableListener(new b());
  }
  
  private static boolean markState(FragmentManager paramFragmentManager, h.c paramc)
  {
    paramFragmentManager = paramFragmentManager.t0().iterator();
    boolean bool1 = false;
    while (paramFragmentManager.hasNext())
    {
      Fragment localFragment = (Fragment)paramFragmentManager.next();
      if (localFragment != null)
      {
        boolean bool2 = bool1;
        if (localFragment.getHost() != null) {
          bool2 = bool1 | markState(localFragment.getChildFragmentManager(), paramc);
        }
        u localu = localFragment.mViewLifecycleOwner;
        bool1 = bool2;
        if (localu != null)
        {
          bool1 = bool2;
          if (localu.getLifecycle().b().a(h.c.d))
          {
            localFragment.mViewLifecycleOwner.f(paramc);
            bool1 = true;
          }
        }
        if (localFragment.mLifecycleRegistry.b().a(h.c.d))
        {
          localFragment.mLifecycleRegistry.o(paramc);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mFragments.v(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    if (getApplication() != null) {
      androidx.loader.app.a.c(this).b((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.t().X(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments.t();
  }
  
  @Deprecated
  public androidx.loader.app.a getSupportLoaderManager()
  {
    return androidx.loader.app.a.c(this);
  }
  
  void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), h.c.c)) {}
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.u();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Deprecated
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mFragments.u();
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.d(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mFragmentLifecycleRegistry.h(h.b.ON_CREATE);
    this.mFragments.f();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      return super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.g(paramMenu, getMenuInflater());
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mFragments.h();
    this.mFragmentLifecycleRegistry.h(h.b.ON_DESTROY);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.i();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt != 0)
    {
      if (paramInt != 6) {
        return false;
      }
      return this.mFragments.e(paramMenuItem);
    }
    return this.mFragments.k(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mFragments.j(paramBoolean);
  }
  
  protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    this.mFragments.u();
    super.onNewIntent(paramIntent);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      this.mFragments.l(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    this.mFragments.m();
    this.mFragmentLifecycleRegistry.h(h.b.ON_PAUSE);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mFragments.n(paramBoolean);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    onResumeFragments();
  }
  
  @Deprecated
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt == 0) {
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.o(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mFragments.u();
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    this.mFragments.u();
    super.onResume();
    this.mResumed = true;
    this.mFragments.s();
  }
  
  protected void onResumeFragments()
  {
    this.mFragmentLifecycleRegistry.h(h.b.ON_RESUME);
    this.mFragments.p();
  }
  
  protected void onStart()
  {
    this.mFragments.u();
    super.onStart();
    this.mStopped = false;
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.c();
    }
    this.mFragments.s();
    this.mFragmentLifecycleRegistry.h(h.b.ON_START);
    this.mFragments.q();
  }
  
  public void onStateNotSaved()
  {
    this.mFragments.u();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mFragments.r();
    this.mFragmentLifecycleRegistry.h(h.b.ON_STOP);
  }
  
  public void setEnterSharedElementCallback(n paramn)
  {
    androidx.core.app.a.p(this, paramn);
  }
  
  public void setExitSharedElementCallback(n paramn)
  {
    androidx.core.app.a.q(this, paramn);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      androidx.core.app.a.s(this, paramIntent, -1, paramBundle);
      return;
    }
    paramFragment.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  @Deprecated
  public void startIntentSenderFromFragment(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      androidx.core.app.a.t(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramFragment.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void supportFinishAfterTransition()
  {
    androidx.core.app.a.l(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    androidx.core.app.a.m(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    androidx.core.app.a.u(this);
  }
  
  @Deprecated
  public final void validateRequestPermissionsRequestCode(int paramInt) {}
  
  class a
    implements SavedStateRegistry.b
  {
    a() {}
    
    public Bundle a()
    {
      Bundle localBundle = new Bundle();
      FragmentActivity.this.markFragmentsCreated();
      FragmentActivity.this.mFragmentLifecycleRegistry.h(h.b.ON_STOP);
      Parcelable localParcelable = FragmentActivity.this.mFragments.x();
      if (localParcelable != null) {
        localBundle.putParcelable("android:support:fragments", localParcelable);
      }
      return localBundle;
    }
  }
  
  class b
    implements b
  {
    b() {}
    
    public void a(Context paramContext)
    {
      FragmentActivity.this.mFragments.a(null);
      paramContext = FragmentActivity.this.getSavedStateRegistry().a("android:support:fragments");
      if (paramContext != null)
      {
        paramContext = paramContext.getParcelable("android:support:fragments");
        FragmentActivity.this.mFragments.w(paramContext);
      }
    }
  }
  
  class c
    extends h<FragmentActivity>
    implements a0, androidx.activity.c, androidx.activity.result.c, m
  {
    public c()
    {
      super();
    }
    
    public void a(FragmentManager paramFragmentManager, Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public View c(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public boolean d()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public ActivityResultRegistry getActivityResultRegistry()
    {
      return FragmentActivity.this.getActivityResultRegistry();
    }
    
    public androidx.lifecycle.h getLifecycle()
    {
      return FragmentActivity.this.mFragmentLifecycleRegistry;
    }
    
    public OnBackPressedDispatcher getOnBackPressedDispatcher()
    {
      return FragmentActivity.this.getOnBackPressedDispatcher();
    }
    
    public z getViewModelStore()
    {
      return FragmentActivity.this.getViewModelStore();
    }
    
    public LayoutInflater i()
    {
      return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public boolean k(Fragment paramFragment)
    {
      return FragmentActivity.this.isFinishing() ^ true;
    }
    
    public boolean l(String paramString)
    {
      return androidx.core.app.a.r(FragmentActivity.this, paramString);
    }
    
    public void o()
    {
      FragmentActivity.this.supportInvalidateOptionsMenu();
    }
    
    public FragmentActivity p()
    {
      return FragmentActivity.this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */