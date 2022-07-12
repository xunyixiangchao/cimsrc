package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.l;
import androidx.lifecycle.s;

public class c
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private Handler a;
  private Runnable b = new a();
  private DialogInterface.OnCancelListener c = new b();
  private DialogInterface.OnDismissListener d = new c();
  private int e = 0;
  private int f = 0;
  private boolean g = true;
  private boolean h = true;
  private int i = -1;
  private boolean j;
  private s<l> k = new d();
  private Dialog l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p = false;
  
  private void o(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.n) {
      return;
    }
    this.n = true;
    this.o = false;
    Object localObject = this.l;
    if (localObject != null)
    {
      ((Dialog)localObject).setOnDismissListener(null);
      this.l.dismiss();
      if (!paramBoolean2) {
        if (Looper.myLooper() == this.a.getLooper()) {
          onDismiss(this.l);
        } else {
          this.a.post(this.b);
        }
      }
    }
    this.m = true;
    if (this.i >= 0)
    {
      getParentFragmentManager().X0(this.i, 1);
      this.i = -1;
      return;
    }
    localObject = getParentFragmentManager().m();
    ((q)localObject).n(this);
    if (paramBoolean1)
    {
      ((q)localObject).h();
      return;
    }
    ((q)localObject).g();
  }
  
  private void u(Bundle paramBundle)
  {
    if (!this.h) {
      return;
    }
    if (!this.p) {
      try
      {
        this.j = true;
        paramBundle = r(paramBundle);
        this.l = paramBundle;
        if (this.h)
        {
          w(paramBundle, this.e);
          paramBundle = getContext();
          if ((paramBundle instanceof Activity)) {
            this.l.setOwnerActivity((Activity)paramBundle);
          }
          this.l.setCancelable(this.g);
          this.l.setOnCancelListener(this.c);
          this.l.setOnDismissListener(this.d);
          this.p = true;
        }
        else
        {
          this.l = null;
        }
        return;
      }
      finally
      {
        this.j = false;
      }
    }
  }
  
  e createFragmentContainer()
  {
    return new e(super.createFragmentContainer());
  }
  
  public void n()
  {
    o(false, false);
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    getViewLifecycleOwnerLiveData().j(this.k);
    if (!this.o) {
      this.n = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new Handler();
    boolean bool;
    if (this.mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    if (paramBundle != null)
    {
      this.e = paramBundle.getInt("android:style", 0);
      this.f = paramBundle.getInt("android:theme", 0);
      this.g = paramBundle.getBoolean("android:cancelable", true);
      this.h = paramBundle.getBoolean("android:showsDialog", this.h);
      this.i = paramBundle.getInt("android:backStackId", -1);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Dialog localDialog = this.l;
    if (localDialog != null)
    {
      this.m = true;
      localDialog.setOnDismissListener(null);
      this.l.dismiss();
      if (!this.n) {
        onDismiss(this.l);
      }
      this.l = null;
      this.p = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if ((!this.o) && (!this.n)) {
      this.n = true;
    }
    getViewLifecycleOwnerLiveData().n(this.k);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.m)
    {
      if (FragmentManager.G0(3))
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("onDismiss called for DialogFragment ");
        paramDialogInterface.append(this);
        Log.d("FragmentManager", paramDialogInterface.toString());
      }
      o(true, true);
    }
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    LayoutInflater localLayoutInflater = super.onGetLayoutInflater(paramBundle);
    Object localObject;
    if ((this.h) && (!this.j))
    {
      u(paramBundle);
      if (FragmentManager.G0(2))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("get layout inflater for DialogFragment ");
        paramBundle.append(this);
        paramBundle.append(" from dialog context");
        Log.d("FragmentManager", paramBundle.toString());
      }
      localObject = this.l;
      paramBundle = localLayoutInflater;
      if (localObject != null) {
        paramBundle = localLayoutInflater.cloneInContext(((Dialog)localObject).getContext());
      }
      return paramBundle;
    }
    if (FragmentManager.G0(2))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getting layout inflater for DialogFragment ");
      paramBundle.append(this);
      String str = paramBundle.toString();
      if (!this.h)
      {
        paramBundle = new StringBuilder();
        localObject = "mShowsDialog = false: ";
      }
      else
      {
        paramBundle = new StringBuilder();
        localObject = "mCreatingDialog = true: ";
      }
      paramBundle.append((String)localObject);
      paramBundle.append(str);
      Log.d("FragmentManager", paramBundle.toString());
    }
    return localLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).onSaveInstanceState();
      ((Bundle)localObject).putBoolean("android:dialogShowing", false);
      paramBundle.putBundle("android:savedDialogState", (Bundle)localObject);
    }
    int i1 = this.e;
    if (i1 != 0) {
      paramBundle.putInt("android:style", i1);
    }
    i1 = this.f;
    if (i1 != 0) {
      paramBundle.putInt("android:theme", i1);
    }
    boolean bool = this.g;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = this.h;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i1 = this.i;
    if (i1 != -1) {
      paramBundle.putInt("android:backStackId", i1);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.l;
    if (localObject != null)
    {
      this.m = false;
      ((Dialog)localObject).show();
      localObject = this.l.getWindow().getDecorView();
      b0.a((View)localObject, this);
      c0.a((View)localObject, this);
      androidx.savedstate.c.a((View)localObject, this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Dialog localDialog = this.l;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if ((this.l != null) && (paramBundle != null))
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        this.l.onRestoreInstanceState(paramBundle);
      }
    }
  }
  
  public Dialog p()
  {
    return this.l;
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.performCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((this.mView == null) && (this.l != null) && (paramBundle != null))
    {
      paramLayoutInflater = paramBundle.getBundle("android:savedDialogState");
      if (paramLayoutInflater != null) {
        this.l.onRestoreInstanceState(paramLayoutInflater);
      }
    }
  }
  
  public int q()
  {
    return this.f;
  }
  
  public Dialog r(Bundle paramBundle)
  {
    if (FragmentManager.G0(3))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateDialog called for DialogFragment ");
      paramBundle.append(this);
      Log.d("FragmentManager", paramBundle.toString());
    }
    return new Dialog(requireContext(), q());
  }
  
  View s(int paramInt)
  {
    Dialog localDialog = this.l;
    if (localDialog != null) {
      return localDialog.findViewById(paramInt);
    }
    return null;
  }
  
  boolean t()
  {
    return this.p;
  }
  
  public final Dialog v()
  {
    Object localObject = p();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DialogFragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a Dialog.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void w(Dialog paramDialog, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return;
      }
      Window localWindow = paramDialog.getWindow();
      if (localWindow != null) {
        localWindow.addFlags(24);
      }
    }
    paramDialog.requestWindowFeature(1);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void run()
    {
      c.j(c.this).onDismiss(c.e(c.this));
    }
  }
  
  class b
    implements DialogInterface.OnCancelListener
  {
    b() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void onCancel(DialogInterface paramDialogInterface)
    {
      if (c.e(c.this) != null)
      {
        paramDialogInterface = c.this;
        paramDialogInterface.onCancel(c.e(paramDialogInterface));
      }
    }
  }
  
  class c
    implements DialogInterface.OnDismissListener
  {
    c() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if (c.e(c.this) != null)
      {
        paramDialogInterface = c.this;
        paramDialogInterface.onDismiss(c.e(paramDialogInterface));
      }
    }
  }
  
  class d
    implements s<l>
  {
    d() {}
    
    @SuppressLint({"SyntheticAccessor"})
    public void b(l paraml)
    {
      if ((paraml != null) && (c.l(c.this)))
      {
        paraml = c.this.requireView();
        if (paraml.getParent() == null)
        {
          if (c.e(c.this) != null)
          {
            if (FragmentManager.G0(3))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("DialogFragment ");
              localStringBuilder.append(this);
              localStringBuilder.append(" setting the content view on ");
              localStringBuilder.append(c.e(c.this));
              Log.d("FragmentManager", localStringBuilder.toString());
            }
            c.e(c.this).setContentView(paraml);
          }
        }
        else {
          throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
      }
    }
  }
  
  class e
    extends e
  {
    e(e parame) {}
    
    public View c(int paramInt)
    {
      if (this.a.d()) {
        return this.a.c(paramInt);
      }
      return c.this.s(paramInt);
    }
    
    public boolean d()
    {
      return (this.a.d()) || (c.this.t());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.c
 * JD-Core Version:    0.7.0.1
 */