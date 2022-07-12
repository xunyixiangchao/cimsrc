package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.content.b;

public abstract class h<E>
  extends e
{
  private final Activity a;
  private final Context b;
  private final Handler c;
  private final int d;
  final FragmentManager e = new k();
  
  h(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.a = paramActivity;
    this.b = ((Context)x0.h.h(paramContext, "context == null"));
    this.c = ((Handler)x0.h.h(paramHandler, "handler == null"));
    this.d = paramInt;
  }
  
  h(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, new Handler(), 0);
  }
  
  public View c(int paramInt)
  {
    return null;
  }
  
  public boolean d()
  {
    return true;
  }
  
  Activity e()
  {
    return this.a;
  }
  
  Context f()
  {
    return this.b;
  }
  
  Handler g()
  {
    return this.c;
  }
  
  public abstract E h();
  
  public LayoutInflater i()
  {
    return LayoutInflater.from(this.b);
  }
  
  @Deprecated
  public void j(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public boolean k(Fragment paramFragment)
  {
    return true;
  }
  
  public boolean l(String paramString)
  {
    return false;
  }
  
  public void m(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      b.j(this.b, paramIntent, paramBundle);
      return;
    }
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  @Deprecated
  public void n(Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      a.t(this.a, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
  }
  
  public void o() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.h
 * JD-Core Version:    0.7.0.1
 */