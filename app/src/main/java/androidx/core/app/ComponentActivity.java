package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.f;
import androidx.core.view.f.a;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.h;
import androidx.lifecycle.h.c;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import g0.g;

public class ComponentActivity
  extends Activity
  implements l, f.a
{
  private g<Class<? extends a>, a> mExtraDataMap = new g();
  private m mLifecycleRegistry = new m(this);
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.d(localView, paramKeyEvent))) {
      return true;
    }
    return f.e(this, localView, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.d(localView, paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  @Deprecated
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)this.mExtraDataMap.get(paramClass);
  }
  
  public h getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @SuppressLint({"RestrictedApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReportFragment.g(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.j(h.c.c);
    super.onSaveInstanceState(paramBundle);
  }
  
  @Deprecated
  public void putExtraData(a parama)
  {
    this.mExtraDataMap.put(parama.getClass(), parama);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @Deprecated
  public static class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */