package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.bumptech.glide.d.e;
import com.bumptech.glide.k;
import java.util.HashMap;
import java.util.Map;
import k2.r;
import x2.l;

public class h
  implements Handler.Callback
{
  private static final b j = new a();
  private volatile k a;
  final Map<android.app.FragmentManager, RequestManagerFragment> b = new HashMap();
  final Map<androidx.fragment.app.FragmentManager, i> c = new HashMap();
  private final Handler d;
  private final b e;
  private final g0.a<View, androidx.fragment.app.Fragment> f = new g0.a();
  private final g0.a<View, android.app.Fragment> g = new g0.a();
  private final Bundle h = new Bundle();
  private final g i;
  
  public h(b paramb, com.bumptech.glide.f paramf)
  {
    if (paramb == null) {
      paramb = j;
    }
    this.e = paramb;
    this.d = new Handler(Looper.getMainLooper(), this);
    this.i = b(paramf);
  }
  
  @TargetApi(17)
  private static void a(Activity paramActivity)
  {
    if (!paramActivity.isDestroyed()) {
      return;
    }
    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
  }
  
  private static g b(com.bumptech.glide.f paramf)
  {
    if ((r.h) && (r.g))
    {
      if (paramf.a(d.e.class)) {
        return new e();
      }
      return new f();
    }
    return new c();
  }
  
  private static Activity c(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return c(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  @Deprecated
  private k d(Context paramContext, android.app.FragmentManager paramFragmentManager, android.app.Fragment paramFragment, boolean paramBoolean)
  {
    RequestManagerFragment localRequestManagerFragment = j(paramFragmentManager, paramFragment);
    paramFragment = localRequestManagerFragment.e();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = com.bumptech.glide.c.c(paramContext);
      paramFragmentManager = this.e.a(paramFragmentManager, localRequestManagerFragment.c(), localRequestManagerFragment.f(), paramContext);
      if (paramBoolean) {
        paramFragmentManager.a();
      }
      localRequestManagerFragment.k(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  private k h(Context paramContext)
  {
    if (this.a == null) {
      try
      {
        if (this.a == null)
        {
          com.bumptech.glide.c localc = com.bumptech.glide.c.c(paramContext.getApplicationContext());
          this.a = this.e.a(localc, new b(), new d(), paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return this.a;
  }
  
  private RequestManagerFragment j(android.app.FragmentManager paramFragmentManager, android.app.Fragment paramFragment)
  {
    RequestManagerFragment localRequestManagerFragment2 = (RequestManagerFragment)this.b.get(paramFragmentManager);
    RequestManagerFragment localRequestManagerFragment1 = localRequestManagerFragment2;
    if (localRequestManagerFragment2 == null)
    {
      localRequestManagerFragment2 = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
      localRequestManagerFragment1 = localRequestManagerFragment2;
      if (localRequestManagerFragment2 == null)
      {
        localRequestManagerFragment1 = new RequestManagerFragment();
        localRequestManagerFragment1.j(paramFragment);
        this.b.put(paramFragmentManager, localRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localRequestManagerFragment1;
  }
  
  private i l(androidx.fragment.app.FragmentManager paramFragmentManager, androidx.fragment.app.Fragment paramFragment)
  {
    i locali2 = (i)this.c.get(paramFragmentManager);
    i locali1 = locali2;
    if (locali2 == null)
    {
      locali2 = (i)paramFragmentManager.j0("com.bumptech.glide.manager");
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.u(paramFragment);
        this.c.put(paramFragmentManager, locali1);
        paramFragmentManager.m().d(locali1, "com.bumptech.glide.manager").h();
        this.d.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return locali1;
  }
  
  private static boolean m(Context paramContext)
  {
    paramContext = c(paramContext);
    return (paramContext == null) || (!paramContext.isFinishing());
  }
  
  private k n(Context paramContext, androidx.fragment.app.FragmentManager paramFragmentManager, androidx.fragment.app.Fragment paramFragment, boolean paramBoolean)
  {
    i locali = l(paramFragmentManager, paramFragment);
    paramFragment = locali.o();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = com.bumptech.glide.c.c(paramContext);
      paramFragmentManager = this.e.a(paramFragmentManager, locali.l(), locali.p(), paramContext);
      if (paramBoolean) {
        paramFragmentManager.a();
      }
      locali.v(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  private boolean o(android.app.FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    Object localObject = (RequestManagerFragment)this.b.get(paramFragmentManager);
    RequestManagerFragment localRequestManagerFragment = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    if (localRequestManagerFragment == localObject) {
      return true;
    }
    if ((localRequestManagerFragment != null) && (localRequestManagerFragment.e() != null))
    {
      paramFragmentManager = new StringBuilder();
      paramFragmentManager.append("We've added two fragments with requests! Old: ");
      paramFragmentManager.append(localRequestManagerFragment);
      paramFragmentManager.append(" New: ");
      paramFragmentManager.append(localObject);
      throw new IllegalStateException(paramFragmentManager.toString());
    }
    if ((!paramBoolean) && (!paramFragmentManager.isDestroyed()))
    {
      localObject = paramFragmentManager.beginTransaction().add((android.app.Fragment)localObject, "com.bumptech.glide.manager");
      if (localRequestManagerFragment != null) {
        ((FragmentTransaction)localObject).remove(localRequestManagerFragment);
      }
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      this.d.obtainMessage(1, 1, 0, paramFragmentManager).sendToTarget();
      if (Log.isLoggable("RMRetriever", 3)) {
        Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
      }
      return false;
    }
    if (Log.isLoggable("RMRetriever", 5))
    {
      if (paramFragmentManager.isDestroyed()) {
        paramFragmentManager = "Parent was destroyed before our Fragment could be added";
      } else {
        paramFragmentManager = "Tried adding Fragment twice and failed twice, giving up!";
      }
      Log.w("RMRetriever", paramFragmentManager);
    }
    ((RequestManagerFragment)localObject).c().c();
    return true;
  }
  
  private boolean p(androidx.fragment.app.FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    Object localObject = (i)this.c.get(paramFragmentManager);
    i locali = (i)paramFragmentManager.j0("com.bumptech.glide.manager");
    if (locali == localObject) {
      return true;
    }
    if ((locali != null) && (locali.o() != null))
    {
      paramFragmentManager = new StringBuilder();
      paramFragmentManager.append("We've added two fragments with requests! Old: ");
      paramFragmentManager.append(locali);
      paramFragmentManager.append(" New: ");
      paramFragmentManager.append(localObject);
      throw new IllegalStateException(paramFragmentManager.toString());
    }
    if ((!paramBoolean) && (!paramFragmentManager.F0()))
    {
      localObject = paramFragmentManager.m().d((androidx.fragment.app.Fragment)localObject, "com.bumptech.glide.manager");
      if (locali != null) {
        ((q)localObject).n(locali);
      }
      ((q)localObject).j();
      this.d.obtainMessage(2, 1, 0, paramFragmentManager).sendToTarget();
      if (Log.isLoggable("RMRetriever", 3)) {
        Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
      }
      return false;
    }
    if (paramFragmentManager.F0())
    {
      if (Log.isLoggable("RMRetriever", 5)) {
        Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
      }
    }
    else if (Log.isLoggable("RMRetriever", 6)) {
      Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
    }
    ((i)localObject).l().c();
    return true;
  }
  
  public k e(Activity paramActivity)
  {
    if (l.q()) {
      return f(paramActivity.getApplicationContext());
    }
    if ((paramActivity instanceof FragmentActivity)) {
      return g((FragmentActivity)paramActivity);
    }
    a(paramActivity);
    this.i.a(paramActivity);
    return d(paramActivity, paramActivity.getFragmentManager(), null, m(paramActivity));
  }
  
  public k f(Context paramContext)
  {
    if (paramContext != null)
    {
      if ((l.r()) && (!(paramContext instanceof Application)))
      {
        if ((paramContext instanceof FragmentActivity)) {
          return g((FragmentActivity)paramContext);
        }
        if ((paramContext instanceof Activity)) {
          return e((Activity)paramContext);
        }
        if ((paramContext instanceof ContextWrapper))
        {
          ContextWrapper localContextWrapper = (ContextWrapper)paramContext;
          if (localContextWrapper.getBaseContext().getApplicationContext() != null) {
            return f(localContextWrapper.getBaseContext());
          }
        }
      }
      return h(paramContext);
    }
    throw new IllegalArgumentException("You cannot start a load on a null Context");
  }
  
  public k g(FragmentActivity paramFragmentActivity)
  {
    if (l.q()) {
      return f(paramFragmentActivity.getApplicationContext());
    }
    a(paramFragmentActivity);
    this.i.a(paramFragmentActivity);
    return n(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), null, m(paramFragmentActivity));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.arg1;
    int k = 0;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2;
    if (m == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    m = paramMessage.what;
    Object localObject = null;
    if (m != 1)
    {
      if (m != 2)
      {
        bool1 = false;
        break label121;
      }
      paramMessage = (androidx.fragment.app.FragmentManager)paramMessage.obj;
      if (!p(paramMessage, bool2)) {
        break label121;
      }
      localObject = this.c;
    }
    else
    {
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      if (!o(paramMessage, bool2)) {
        break label121;
      }
      localObject = this.b;
    }
    localObject = ((Map)localObject).remove(paramMessage);
    k = 1;
    bool1 = bool3;
    break label123;
    label121:
    paramMessage = null;
    label123:
    if ((Log.isLoggable("RMRetriever", 5)) && (k != 0) && (localObject == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to remove expected request manager fragment, manager: ");
      ((StringBuilder)localObject).append(paramMessage);
      Log.w("RMRetriever", ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  @Deprecated
  RequestManagerFragment i(Activity paramActivity)
  {
    return j(paramActivity.getFragmentManager(), null);
  }
  
  i k(androidx.fragment.app.FragmentManager paramFragmentManager)
  {
    return l(paramFragmentManager, null);
  }
  
  class a
    implements h.b
  {
    public k a(com.bumptech.glide.c paramc, q2.e parame, q2.h paramh, Context paramContext)
    {
      return new k(paramc, parame, paramh, paramContext);
    }
  }
  
  public static abstract interface b
  {
    public abstract k a(com.bumptech.glide.c paramc, q2.e parame, q2.h paramh, Context paramContext);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.manager.h
 * JD-Core Version:    0.7.0.1
 */