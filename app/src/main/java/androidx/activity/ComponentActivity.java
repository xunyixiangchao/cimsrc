package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.w;
import androidx.lifecycle.y.b;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.b;
import b.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements a0, androidx.savedstate.b, c, androidx.activity.result.c
{
  private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
  private final ActivityResultRegistry mActivityResultRegistry = new b();
  private int mContentLayoutId;
  final a.a mContextAwareHelper = new a.a();
  private y.b mDefaultFactory;
  private final m mLifecycleRegistry = new m(this);
  private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
  final androidx.savedstate.a mSavedStateRegistryController = androidx.savedstate.a.a(this);
  private z mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() != null)
    {
      int i = Build.VERSION.SDK_INT;
      getLifecycle().a(new j()
      {
        public void d(l paramAnonymousl, h.b paramAnonymousb)
        {
          if (paramAnonymousb == h.b.ON_STOP)
          {
            paramAnonymousl = ComponentActivity.this.getWindow();
            if (paramAnonymousl != null) {
              paramAnonymousl = paramAnonymousl.peekDecorView();
            } else {
              paramAnonymousl = null;
            }
            if (paramAnonymousl != null) {
              paramAnonymousl.cancelPendingInputEvents();
            }
          }
        }
      });
      getLifecycle().a(new j()
      {
        public void d(l paramAnonymousl, h.b paramAnonymousb)
        {
          if (paramAnonymousb == h.b.ON_DESTROY)
          {
            ComponentActivity.this.mContextAwareHelper.b();
            if (!ComponentActivity.this.isChangingConfigurations()) {
              ComponentActivity.this.getViewModelStore().a();
            }
          }
        }
      });
      getLifecycle().a(new j()
      {
        public void d(l paramAnonymousl, h.b paramAnonymousb)
        {
          ComponentActivity.this.ensureViewModelStore();
          ComponentActivity.this.getLifecycle().c(this);
        }
      });
      if (i <= 23) {
        getLifecycle().a(new ImmLeaksCleaner(this));
      }
      getSavedStateRegistry().d("android:support:activity-result", new c());
      addOnContextAvailableListener(new d());
      return;
    }
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  public ComponentActivity(int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private void initViewTreeOwners()
  {
    b0.a(getWindow().getDecorView(), this);
    c0.a(getWindow().getDecorView(), this);
    androidx.savedstate.c.a(getWindow().getDecorView(), this);
  }
  
  public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.addContentView(paramView, paramLayoutParams);
  }
  
  public final void addOnContextAvailableListener(a.b paramb)
  {
    this.mContextAwareHelper.a(paramb);
  }
  
  void ensureViewModelStore()
  {
    if (this.mViewModelStore == null)
    {
      e locale = (e)getLastNonConfigurationInstance();
      if (locale != null) {
        this.mViewModelStore = locale.b;
      }
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new z();
      }
    }
  }
  
  public final ActivityResultRegistry getActivityResultRegistry()
  {
    return this.mActivityResultRegistry;
  }
  
  public y.b getDefaultViewModelProviderFactory()
  {
    if (getApplication() != null)
    {
      if (this.mDefaultFactory == null)
      {
        Application localApplication = getApplication();
        Bundle localBundle;
        if (getIntent() != null) {
          localBundle = getIntent().getExtras();
        } else {
          localBundle = null;
        }
        this.mDefaultFactory = new w(localApplication, this, localBundle);
      }
      return this.mDefaultFactory;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  public Object getLastCustomNonConfigurationInstance()
  {
    e locale = (e)getLastNonConfigurationInstance();
    if (locale != null) {
      return locale.a;
    }
    return null;
  }
  
  public h getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.mOnBackPressedDispatcher;
  }
  
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.b();
  }
  
  public z getViewModelStore()
  {
    if (getApplication() != null)
    {
      ensureViewModelStore();
      return this.mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.mActivityResultRegistry.b(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    this.mOnBackPressedDispatcher.c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mSavedStateRegistryController.c(paramBundle);
    this.mContextAwareHelper.c(this);
    super.onCreate(paramBundle);
    ReportFragment.g(this);
    int i = this.mContentLayoutId;
    if (i != 0) {
      setContentView(i);
    }
  }
  
  @Deprecated
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.mActivityResultRegistry.b(paramInt, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", paramArrayOfInt))) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  @Deprecated
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject3 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mViewModelStore;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      e locale = (e)getLastNonConfigurationInstance();
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.b;
      }
    }
    if ((localObject1 == null) && (localObject3 == null)) {
      return null;
    }
    localObject2 = new e();
    ((e)localObject2).a = localObject3;
    ((e)localObject2).b = ((z)localObject1);
    return localObject2;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    h localh = getLifecycle();
    if ((localh instanceof m)) {
      ((m)localh).o(h.c.c);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.d(paramBundle);
  }
  
  public Context peekAvailableContext()
  {
    return this.mContextAwareHelper.d();
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> parama, ActivityResultRegistry paramActivityResultRegistry, androidx.activity.result.a<O> parama1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity_rq#");
    localStringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
    return paramActivityResultRegistry.i(localStringBuilder.toString(), this, parama, parama1);
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> parama, androidx.activity.result.a<O> parama1)
  {
    return registerForActivityResult(parama, this.mActivityResultRegistry, parama1);
  }
  
  public final void removeOnContextAvailableListener(a.b paramb)
  {
    this.mContextAwareHelper.e(paramb);
  }
  
  public void reportFullyDrawn()
  {
    try
    {
      if (s1.a.d())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportFullyDrawn() for ");
        localStringBuilder.append(getComponentName());
        s1.a.a(localStringBuilder.toString());
      }
      super.reportFullyDrawn();
      return;
    }
    finally
    {
      s1.a.b();
    }
  }
  
  public void setContentView(int paramInt)
  {
    initViewTreeOwners();
    super.setContentView(paramInt);
  }
  
  public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView)
  {
    initViewTreeOwners();
    super.setContentView(paramView);
  }
  
  public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.setContentView(paramView, paramLayoutParams);
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  @Deprecated
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      try
      {
        ComponentActivity.this.onBackPressed();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (TextUtils.equals(localIllegalStateException.getMessage(), "Can not perform this action after onSaveInstanceState")) {
          return;
        }
        throw localIllegalStateException;
      }
    }
  }
  
  class b
    extends ActivityResultRegistry
  {
    b() {}
    
    public <I, O> void f(final int paramInt, final b.a<I, O> parama, I paramI, androidx.core.app.b paramb)
    {
      ComponentActivity localComponentActivity = ComponentActivity.this;
      final a.a locala = parama.b(localComponentActivity, paramI);
      if (locala != null)
      {
        new Handler(Looper.getMainLooper()).post(new a(paramInt, locala));
        return;
      }
      paramI = parama.a(localComponentActivity, paramI);
      parama = null;
      if ((paramI.getExtras() != null) && (paramI.getExtras().getClassLoader() == null)) {
        paramI.setExtrasClassLoader(localComponentActivity.getClassLoader());
      }
      if (paramI.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE"))
      {
        parama = paramI.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        paramI.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
      }
      else if (paramb != null)
      {
        parama = paramb.b();
      }
      if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(paramI.getAction()))
      {
        paramI = paramI.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        parama = paramI;
        if (paramI == null) {
          parama = new String[0];
        }
        androidx.core.app.a.o(localComponentActivity, parama, paramInt);
        return;
      }
      if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(paramI.getAction()))
      {
        paramI = (IntentSenderRequest)paramI.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try
        {
          androidx.core.app.a.t(localComponentActivity, paramI.m(), paramInt, paramI.g(), paramI.h(), paramI.i(), 0, parama);
          return;
        }
        catch (IntentSender.SendIntentException parama)
        {
          new Handler(Looper.getMainLooper()).post(new b(paramInt, parama));
          return;
        }
      }
      androidx.core.app.a.s(localComponentActivity, paramI, paramInt, parama);
    }
    
    class a
      implements Runnable
    {
      a(int paramInt, a.a parama) {}
      
      public void run()
      {
        ComponentActivity.b.this.c(paramInt, locala.a());
      }
    }
    
    class b
      implements Runnable
    {
      b(int paramInt, IntentSender.SendIntentException paramSendIntentException) {}
      
      public void run()
      {
        ComponentActivity.b.this.b(paramInt, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", parama));
      }
    }
  }
  
  class c
    implements SavedStateRegistry.b
  {
    c() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public Bundle a()
    {
      Bundle localBundle = new Bundle();
      ComponentActivity.this.mActivityResultRegistry.h(localBundle);
      return localBundle;
    }
  }
  
  class d
    implements a.b
  {
    d() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void a(Context paramContext)
    {
      paramContext = ComponentActivity.this.getSavedStateRegistry().a("android:support:activity-result");
      if (paramContext != null) {
        ComponentActivity.this.mActivityResultRegistry.g(paramContext);
      }
    }
  }
  
  static final class e
  {
    Object a;
    z b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */