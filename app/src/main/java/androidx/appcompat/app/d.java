package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q0;
import g.b.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class d
{
  private static int a = -100;
  private static final g0.b<WeakReference<d>> b = new g0.b();
  private static final Object c = new Object();
  
  static void A(d paramd)
  {
    synchronized (c)
    {
      B(paramd);
      return;
    }
  }
  
  private static void B(d paramd)
  {
    synchronized (c)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)((WeakReference)localIterator.next()).get();
        if ((locald == paramd) || (locald == null)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
  
  public static void D(boolean paramBoolean)
  {
    q0.c(paramBoolean);
  }
  
  public static void H(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
      return;
    }
    if (a != paramInt)
    {
      a = paramInt;
      f();
    }
  }
  
  static void c(d paramd)
  {
    synchronized (c)
    {
      B(paramd);
      b.add(new WeakReference(paramd));
      return;
    }
  }
  
  private static void f()
  {
    synchronized (c)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)((WeakReference)localIterator.next()).get();
        if (locald != null) {
          locald.e();
        }
      }
      return;
    }
  }
  
  public static d i(Activity paramActivity, c paramc)
  {
    return new AppCompatDelegateImpl(paramActivity, paramc);
  }
  
  public static d j(Dialog paramDialog, c paramc)
  {
    return new AppCompatDelegateImpl(paramDialog, paramc);
  }
  
  public static int l()
  {
    return a;
  }
  
  public abstract boolean C(int paramInt);
  
  public abstract void E(int paramInt);
  
  public abstract void F(View paramView);
  
  public abstract void G(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void I(Toolbar paramToolbar);
  
  public void J(int paramInt) {}
  
  public abstract void K(CharSequence paramCharSequence);
  
  public abstract g.b L(b.a parama);
  
  public abstract void d(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract boolean e();
  
  @Deprecated
  public void g(Context paramContext) {}
  
  public Context h(Context paramContext)
  {
    g(paramContext);
    return paramContext;
  }
  
  public abstract <T extends View> T k(int paramInt);
  
  public abstract a m();
  
  public int n()
  {
    return -100;
  }
  
  public abstract MenuInflater o();
  
  public abstract ActionBar p();
  
  public abstract void q();
  
  public abstract void r();
  
  public abstract void s(Configuration paramConfiguration);
  
  public abstract void t(Bundle paramBundle);
  
  public abstract void u();
  
  public abstract void v(Bundle paramBundle);
  
  public abstract void w();
  
  public abstract void x(Bundle paramBundle);
  
  public abstract void y();
  
  public abstract void z();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.d
 * JD-Core Version:    0.7.0.1
 */