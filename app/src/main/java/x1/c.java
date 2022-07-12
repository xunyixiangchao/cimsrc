package x1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import cn.dreamtobe.kpswitch.R.dimen;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class c
{
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  
  @TargetApi(13)
  public static ViewTreeObserver.OnGlobalLayoutListener b(Activity paramActivity, v1.b paramb, b paramb1)
  {
    Object localObject = a;
    if (localObject != null) {
      return (ViewTreeObserver.OnGlobalLayoutListener)((IncrementalChange)localObject).access$dispatch("attach.(Landroid/app/Activity;Lcn/dreamtobe/kpswitch/IPanelHeightTarget;Lcn/dreamtobe/kpswitch/util/KeyboardUtil$OnKeyboardShowingListener;)Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", new Object[] { paramActivity, paramb, paramb1 });
    }
    localObject = (ViewGroup)paramActivity.findViewById(16908290);
    boolean bool1 = e.b(paramActivity);
    boolean bool2 = e.c(paramActivity);
    boolean bool3 = e.a(paramActivity);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    paramActivity.getSize(localPoint);
    paramActivity = new a(bool1, bool2, bool3, (ViewGroup)localObject, paramb, paramb1, localPoint.y);
    ((ViewGroup)localObject).getViewTreeObserver().addOnGlobalLayoutListener(paramActivity);
    return paramActivity;
  }
  
  public static int c(Context paramContext)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getKeyboardHeight.(Landroid/content/Context;)I", new Object[] { paramContext })).intValue();
    }
    if (b == 0) {
      b = b.a(paramContext, f(paramContext.getResources()));
    }
    return b;
  }
  
  public static int d(Resources paramResources)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getMaxPanelHeight.(Landroid/content/res/Resources;)I", new Object[] { paramResources })).intValue();
    }
    if (c == 0) {
      c = paramResources.getDimensionPixelSize(R.dimen.max_panel_height);
    }
    return c;
  }
  
  public static int e(Context paramContext)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getMinKeyboardHeight.(Landroid/content/Context;)I", new Object[] { paramContext })).intValue();
    }
    if (e == 0) {
      e = paramContext.getResources().getDimensionPixelSize(R.dimen.min_keyboard_height);
    }
    return e;
  }
  
  public static int f(Resources paramResources)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getMinPanelHeight.(Landroid/content/res/Resources;)I", new Object[] { paramResources })).intValue();
    }
    if (d == 0) {
      d = paramResources.getDimensionPixelSize(R.dimen.min_panel_height);
    }
    return d;
  }
  
  public static int g(Context paramContext)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getValidPanelHeight.(Landroid/content/Context;)I", new Object[] { paramContext })).intValue();
    }
    return Math.min(d(paramContext.getResources()), Math.max(f(paramContext.getResources()), c(paramContext)));
  }
  
  public static void h(View paramView)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("hideKeyboard.(Landroid/view/View;)V", new Object[] { paramView });
      return;
    }
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private static boolean i(Context paramContext, int paramInt)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null) {
      return ((Boolean)localIncrementalChange.access$dispatch("saveKeyboardHeight.(Landroid/content/Context;I)Z", new Object[] { paramContext, new Integer(paramInt) })).booleanValue();
    }
    if (b == paramInt) {
      return false;
    }
    if (paramInt < 0) {
      return false;
    }
    b = paramInt;
    Log.d("KeyBordUtil", String.format("save keyboard: %d", new Object[] { Integer.valueOf(paramInt) }));
    return b.b(paramContext, paramInt);
  }
  
  public static void j(View paramView)
  {
    IncrementalChange localIncrementalChange = a;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("showKeyboard.(Landroid/view/View;)V", new Object[] { paramView });
      return;
    }
    paramView.requestFocus();
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public static class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int a;
    private final ViewGroup b;
    private final v1.b c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private boolean h;
    private final c.b i;
    private final int j;
    private boolean k;
    private int l;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ViewGroup paramViewGroup, v1.b paramb, c.b paramb1, int paramInt)
    {
      this.a = 0;
      this.k = false;
      this.b = paramViewGroup;
      this.c = paramb;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
      this.g = d.a(paramViewGroup.getContext());
      this.i = paramb1;
      this.j = paramInt;
    }
    
    a(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
    
    private void a(int paramInt)
    {
      IncrementalChange localIncrementalChange = m;
      if (localIncrementalChange != null)
      {
        localIncrementalChange.access$dispatch("calculateKeyboardHeight.(I)V", new Object[] { this, new Integer(paramInt) });
        return;
      }
      if (this.a == 0)
      {
        this.a = paramInt;
        this.c.c(c.g(c()));
        return;
      }
      int n;
      if (a.f(this.d, this.e, this.f))
      {
        n = ((View)this.b.getParent()).getHeight() - paramInt;
        Log.d("KeyboardStatusListener", String.format("action bar over layout %d display height: %d", new Object[] { Integer.valueOf(((View)this.b.getParent()).getHeight()), Integer.valueOf(paramInt) }));
      }
      else
      {
        n = Math.abs(paramInt - this.a);
      }
      if (n <= c.e(c())) {
        return;
      }
      Log.d("KeyboardStatusListener", String.format("pre display height: %d display height: %d keyboard: %d ", new Object[] { Integer.valueOf(this.a), Integer.valueOf(paramInt), Integer.valueOf(n) }));
      if (n == this.g)
      {
        Log.w("KeyboardStatusListener", String.format("On global layout change get keyboard height just equal statusBar height %d", new Object[] { Integer.valueOf(n) }));
        return;
      }
      if (c.a(c(), n))
      {
        paramInt = c.g(c());
        if (this.c.getHeight() != paramInt) {
          this.c.c(paramInt);
        }
      }
    }
    
    private void b(int paramInt)
    {
      Object localObject = m;
      if (localObject != null)
      {
        ((IncrementalChange)localObject).access$dispatch("calculateKeyboardShowing.(I)V", new Object[] { this, new Integer(paramInt) });
        return;
      }
      localObject = (View)this.b.getParent();
      int n = ((View)localObject).getHeight() - ((View)localObject).getPaddingTop();
      boolean bool;
      if (a.f(this.d, this.e, this.f))
      {
        if ((!this.e) && (n - paramInt == this.g)) {
          bool = this.h;
        } else if (n > paramInt) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else
      {
        int i1 = this.l;
        if (i1 == 0) {
          bool = this.h;
        } else if (paramInt < i1 - c.e(c())) {
          bool = true;
        } else {
          bool = false;
        }
        this.l = Math.max(this.l, n);
      }
      if (this.h != bool)
      {
        Log.d("KeyboardStatusListener", String.format("displayHeight %d actionBarOverlayLayoutHeight %d keyboard status change: %B", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(n), Boolean.valueOf(bool) }));
        this.c.a(bool);
        localObject = this.i;
        if (localObject != null) {
          ((c.b)localObject).a(bool);
        }
      }
      this.h = bool;
    }
    
    private Context c()
    {
      IncrementalChange localIncrementalChange = m;
      if (localIncrementalChange != null) {
        return (Context)localIncrementalChange.access$dispatch("getContext.()Landroid/content/Context;", new Object[] { this });
      }
      return this.b.getContext();
    }
    
    @TargetApi(13)
    public void onGlobalLayout()
    {
      Object localObject = m;
      boolean bool = true;
      if (localObject != null)
      {
        ((IncrementalChange)localObject).access$dispatch("onGlobalLayout.()V", new Object[] { this });
        return;
      }
      localObject = this.b.getChildAt(0);
      View localView = (View)this.b.getParent();
      Rect localRect = new Rect();
      int n;
      if (this.e)
      {
        localView.getWindowVisibleDisplayFrame(localRect);
        int i1 = localRect.bottom - localRect.top;
        if (!this.k)
        {
          if (i1 != this.j) {
            bool = false;
          }
          this.k = bool;
        }
        n = i1;
        if (!this.k) {
          n = i1 + this.g;
        }
      }
      else if (localObject != null)
      {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
        n = localRect.bottom - localRect.top;
      }
      else
      {
        Log.w("KeyBordUtil", "user root view not ready so ignore global layout changed!");
        n = -1;
      }
      if (n == -1) {
        return;
      }
      a(n);
      b(n);
      this.a = n;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x1.c
 * JD-Core Version:    0.7.0.1
 */