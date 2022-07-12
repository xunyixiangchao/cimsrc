package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.r0;
import androidx.core.view.c0;
import androidx.core.view.e0;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.lifecycle.h.c;
import g.b.a;
import java.util.List;
import p0.h.e;

class AppCompatDelegateImpl
  extends d
  implements e.a, LayoutInflater.Factory2
{
  private static final g0.g<String, Integer> c0 = new g0.g();
  private static final boolean d0 = false;
  private static final int[] e0 = { 16842836 };
  private static final boolean f0 = "robolectric".equals(Build.FINGERPRINT) ^ true;
  private static final boolean g0 = true;
  boolean A;
  boolean B;
  boolean C;
  boolean E;
  boolean F;
  private boolean G;
  private PanelFeatureState[] H;
  private PanelFeatureState I;
  private boolean J;
  private boolean K;
  private boolean L;
  boolean M;
  private Configuration N;
  private int O = -100;
  private int P;
  private boolean Q;
  private boolean R;
  private p S;
  private p T;
  boolean U;
  int V;
  private final Runnable W = new a();
  private boolean X;
  private Rect Y;
  private Rect Z;
  private f a0;
  private g b0;
  final Object d;
  final Context e;
  Window f;
  private n g;
  final c h;
  ActionBar i;
  MenuInflater j;
  private CharSequence k;
  private androidx.appcompat.widget.r l;
  private h m;
  private t n;
  g.b o;
  ActionBarContextView p;
  PopupWindow q;
  Runnable r;
  c0 s = null;
  private boolean t = true;
  private boolean u;
  ViewGroup v;
  private TextView w;
  private View x;
  private boolean y;
  private boolean z;
  
  AppCompatDelegateImpl(Activity paramActivity, c paramc)
  {
    this(paramActivity, null, paramc, paramActivity);
  }
  
  AppCompatDelegateImpl(Dialog paramDialog, c paramc)
  {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramc, paramDialog);
  }
  
  private AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc, Object paramObject)
  {
    this.e = paramContext;
    this.h = paramc;
    this.d = paramObject;
    if ((this.O == -100) && ((paramObject instanceof Dialog)))
    {
      paramContext = N0();
      if (paramContext != null) {
        this.O = paramContext.getDelegate().n();
      }
    }
    if (this.O == -100)
    {
      paramContext = c0;
      paramc = (Integer)paramContext.get(paramObject.getClass().getName());
      if (paramc != null)
      {
        this.O = paramc.intValue();
        paramContext.remove(paramObject.getClass().getName());
      }
    }
    if (paramWindow != null) {
      O(paramWindow);
    }
    androidx.appcompat.widget.g.h();
  }
  
  private void D0(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (!paramPanelFeatureState.o)
    {
      if (this.M) {
        return;
      }
      if (paramPanelFeatureState.a == 0)
      {
        if ((this.e.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          return;
        }
      }
      Object localObject = l0();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.a, paramPanelFeatureState.j)))
      {
        U(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)this.e.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!G0(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      paramKeyEvent = paramPanelFeatureState.g;
      if ((paramKeyEvent != null) && (!paramPanelFeatureState.q))
      {
        paramKeyEvent = paramPanelFeatureState.i;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if ((paramKeyEvent != null) && (paramKeyEvent.width == -1))
          {
            i1 = -1;
            break label334;
          }
        }
      }
      else
      {
        if (paramKeyEvent == null)
        {
          if ((o0(paramPanelFeatureState)) && (paramPanelFeatureState.g != null)) {}
        }
        else if ((paramPanelFeatureState.q) && (paramKeyEvent.getChildCount() > 0)) {
          paramPanelFeatureState.g.removeAllViews();
        }
        if ((!n0(paramPanelFeatureState)) || (!paramPanelFeatureState.b())) {
          break label400;
        }
        localObject = paramPanelFeatureState.h.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i1 = paramPanelFeatureState.b;
        paramPanelFeatureState.g.setBackgroundResource(i1);
        localObject = paramPanelFeatureState.h.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(paramPanelFeatureState.h);
        }
        paramPanelFeatureState.g.addView(paramPanelFeatureState.h, paramKeyEvent);
        if (!paramPanelFeatureState.h.hasFocus()) {
          paramPanelFeatureState.h.requestFocus();
        }
      }
      int i1 = -2;
      label334:
      paramPanelFeatureState.n = false;
      paramKeyEvent = new WindowManager.LayoutParams(i1, -2, paramPanelFeatureState.d, paramPanelFeatureState.e, 1002, 8519680, -3);
      paramKeyEvent.gravity = paramPanelFeatureState.c;
      paramKeyEvent.windowAnimations = paramPanelFeatureState.f;
      localWindowManager.addView(paramPanelFeatureState.g, paramKeyEvent);
      paramPanelFeatureState.o = true;
      return;
      label400:
      paramPanelFeatureState.q = true;
    }
  }
  
  private boolean F0(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!paramPanelFeatureState.m)
    {
      bool1 = bool2;
      if (!G0(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      androidx.appcompat.view.menu.e locale = paramPanelFeatureState.j;
      bool1 = bool2;
      if (locale != null) {
        bool1 = locale.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (this.l == null)) {
      U(paramPanelFeatureState, true);
    }
    return bool1;
  }
  
  private boolean G0(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.M) {
      return false;
    }
    if (paramPanelFeatureState.m) {
      return true;
    }
    Object localObject1 = this.I;
    if ((localObject1 != null) && (localObject1 != paramPanelFeatureState)) {
      U((PanelFeatureState)localObject1, false);
    }
    localObject1 = l0();
    if (localObject1 != null) {
      paramPanelFeatureState.i = ((Window.Callback)localObject1).onCreatePanelView(paramPanelFeatureState.a);
    }
    int i1 = paramPanelFeatureState.a;
    if ((i1 != 0) && (i1 != 108)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject2;
    if (i1 != 0)
    {
      localObject2 = this.l;
      if (localObject2 != null) {
        ((androidx.appcompat.widget.r)localObject2).d();
      }
    }
    if ((paramPanelFeatureState.i == null) && ((i1 == 0) || (!(E0() instanceof i))))
    {
      localObject2 = paramPanelFeatureState.j;
      if ((localObject2 == null) || (paramPanelFeatureState.r))
      {
        if ((localObject2 == null) && ((!p0(paramPanelFeatureState)) || (paramPanelFeatureState.j == null))) {
          return false;
        }
        if ((i1 != 0) && (this.l != null))
        {
          if (this.m == null) {
            this.m = new h();
          }
          this.l.a(paramPanelFeatureState.j, this.m);
        }
        paramPanelFeatureState.j.h0();
        if (!((Window.Callback)localObject1).onCreatePanelMenu(paramPanelFeatureState.a, paramPanelFeatureState.j))
        {
          paramPanelFeatureState.c(null);
          if (i1 != 0)
          {
            paramPanelFeatureState = this.l;
            if (paramPanelFeatureState != null) {
              paramPanelFeatureState.a(null, this.m);
            }
          }
          return false;
        }
        paramPanelFeatureState.r = false;
      }
      paramPanelFeatureState.j.h0();
      localObject2 = paramPanelFeatureState.s;
      if (localObject2 != null)
      {
        paramPanelFeatureState.j.R((Bundle)localObject2);
        paramPanelFeatureState.s = null;
      }
      if (!((Window.Callback)localObject1).onPreparePanel(0, paramPanelFeatureState.i, paramPanelFeatureState.j))
      {
        if (i1 != 0)
        {
          paramKeyEvent = this.l;
          if (paramKeyEvent != null) {
            paramKeyEvent.a(null, this.m);
          }
        }
        paramPanelFeatureState.j.g0();
        return false;
      }
      if (paramKeyEvent != null) {
        i1 = paramKeyEvent.getDeviceId();
      } else {
        i1 = -1;
      }
      boolean bool;
      if (KeyCharacterMap.load(i1).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramPanelFeatureState.p = bool;
      paramPanelFeatureState.j.setQwertyMode(bool);
      paramPanelFeatureState.j.g0();
    }
    paramPanelFeatureState.m = true;
    paramPanelFeatureState.n = false;
    this.I = paramPanelFeatureState;
    return true;
  }
  
  private void H0(boolean paramBoolean)
  {
    Object localObject = this.l;
    if ((localObject != null) && (((androidx.appcompat.widget.r)localObject).h()) && ((!ViewConfiguration.get(this.e).hasPermanentMenuKey()) || (this.l.e())))
    {
      localObject = l0();
      if ((this.l.b()) && (paramBoolean))
      {
        this.l.f();
        if (!this.M) {
          ((Window.Callback)localObject).onPanelClosed(108, j0(0, true).j);
        }
      }
      else if ((localObject != null) && (!this.M))
      {
        if ((this.U) && ((this.V & 0x1) != 0))
        {
          this.f.getDecorView().removeCallbacks(this.W);
          this.W.run();
        }
        PanelFeatureState localPanelFeatureState = j0(0, true);
        androidx.appcompat.view.menu.e locale = localPanelFeatureState.j;
        if ((locale != null) && (!localPanelFeatureState.r) && (((Window.Callback)localObject).onPreparePanel(0, localPanelFeatureState.i, locale)))
        {
          ((Window.Callback)localObject).onMenuOpened(108, localPanelFeatureState.j);
          this.l.g();
        }
      }
      return;
    }
    localObject = j0(0, true);
    ((PanelFeatureState)localObject).q = true;
    U((PanelFeatureState)localObject, false);
    D0((PanelFeatureState)localObject, null);
  }
  
  private int I0(int paramInt)
  {
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    }
    int i1 = paramInt;
    if (paramInt == 9)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      i1 = 109;
    }
    return i1;
  }
  
  private boolean K0(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.f.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View))) {
        break;
      }
      if (x.T((View)paramViewParent)) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private boolean M(boolean paramBoolean)
  {
    if (this.M) {
      return false;
    }
    int i1 = P();
    paramBoolean = O0(t0(this.e, i1), paramBoolean);
    if (i1 == 0)
    {
      i0(this.e).e();
    }
    else
    {
      localp = this.S;
      if (localp != null) {
        localp.a();
      }
    }
    if (i1 == 3)
    {
      h0(this.e).e();
      return paramBoolean;
    }
    p localp = this.T;
    if (localp != null) {
      localp.a();
    }
    return paramBoolean;
  }
  
  private void M0()
  {
    if (!this.u) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  private void N()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.v.findViewById(16908290);
    Object localObject = this.f.getDecorView();
    localContentFrameLayout.a(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.e.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    int i1 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
    if (((TypedArray)localObject).hasValue(i1)) {
      ((TypedArray)localObject).getValue(i1, localContentFrameLayout.getFixedWidthMajor());
    }
    i1 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
    if (((TypedArray)localObject).hasValue(i1)) {
      ((TypedArray)localObject).getValue(i1, localContentFrameLayout.getFixedWidthMinor());
    }
    i1 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
    if (((TypedArray)localObject).hasValue(i1)) {
      ((TypedArray)localObject).getValue(i1, localContentFrameLayout.getFixedHeightMajor());
    }
    i1 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
    if (((TypedArray)localObject).hasValue(i1)) {
      ((TypedArray)localObject).getValue(i1, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private AppCompatActivity N0()
  {
    for (Context localContext = this.e; localContext != null; localContext = ((ContextWrapper)localContext).getBaseContext())
    {
      if ((localContext instanceof AppCompatActivity)) {
        return (AppCompatActivity)localContext;
      }
      if (!(localContext instanceof ContextWrapper)) {
        break;
      }
    }
    return null;
  }
  
  private void O(Window paramWindow)
  {
    if (this.f == null)
    {
      Object localObject = paramWindow.getCallback();
      if (!(localObject instanceof n))
      {
        localObject = new n((Window.Callback)localObject);
        this.g = ((n)localObject);
        paramWindow.setCallback((Window.Callback)localObject);
        localObject = k0.u(this.e, null, e0);
        Drawable localDrawable = ((k0)localObject).h(0);
        if (localDrawable != null) {
          paramWindow.setBackgroundDrawable(localDrawable);
        }
        ((k0)localObject).w();
        this.f = paramWindow;
        return;
      }
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private boolean O0(int paramInt, boolean paramBoolean)
  {
    Configuration localConfiguration2 = V(this.e, paramInt, null);
    boolean bool2 = r0();
    Configuration localConfiguration1 = this.N;
    Object localObject = localConfiguration1;
    if (localConfiguration1 == null) {
      localObject = this.e.getResources().getConfiguration();
    }
    int i1 = ((Configuration)localObject).uiMode & 0x30;
    int i2 = localConfiguration2.uiMode & 0x30;
    boolean bool1 = true;
    if ((i1 != i2) && (paramBoolean) && (!bool2) && (this.K) && ((f0) || (this.L)))
    {
      localObject = this.d;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isChild()))
      {
        androidx.core.app.a.n((Activity)this.d);
        paramBoolean = true;
        break label144;
      }
    }
    paramBoolean = false;
    label144:
    if ((!paramBoolean) && (i1 != i2))
    {
      P0(i2, bool2, null);
      paramBoolean = bool1;
    }
    if (paramBoolean)
    {
      localObject = this.d;
      if ((localObject instanceof AppCompatActivity)) {
        ((AppCompatActivity)localObject).onNightModeChanged(paramInt);
      }
    }
    return paramBoolean;
  }
  
  private int P()
  {
    int i1 = this.O;
    if (i1 != -100) {
      return i1;
    }
    return d.l();
  }
  
  private void P0(int paramInt, boolean paramBoolean, Configuration paramConfiguration)
  {
    Resources localResources = this.e.getResources();
    Configuration localConfiguration = new Configuration(localResources.getConfiguration());
    if (paramConfiguration != null) {
      localConfiguration.updateFrom(paramConfiguration);
    }
    localConfiguration.uiMode = (paramInt | localResources.getConfiguration().uiMode & 0xFFFFFFCF);
    localResources.updateConfiguration(localConfiguration, null);
    if (Build.VERSION.SDK_INT < 26) {
      h.a(localResources);
    }
    paramInt = this.P;
    if (paramInt != 0)
    {
      this.e.setTheme(paramInt);
      this.e.getTheme().applyStyle(this.P, true);
    }
    if (paramBoolean)
    {
      paramConfiguration = this.d;
      if ((paramConfiguration instanceof Activity))
      {
        paramConfiguration = (Activity)paramConfiguration;
        if ((paramConfiguration instanceof androidx.lifecycle.l) ? ((androidx.lifecycle.l)paramConfiguration).getLifecycle().b().a(h.c.c) : (this.L) && (!this.M)) {
          paramConfiguration.onConfigurationChanged(localConfiguration);
        }
      }
    }
  }
  
  private void R0(View paramView)
  {
    int i1;
    if ((x.M(paramView) & 0x2000) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Context localContext;
    if (i1 != 0)
    {
      localContext = this.e;
      i1 = R.color.abc_decor_view_status_guard_light;
    }
    else
    {
      localContext = this.e;
      i1 = R.color.abc_decor_view_status_guard;
    }
    paramView.setBackgroundColor(androidx.core.content.b.b(localContext, i1));
  }
  
  private void S()
  {
    p localp = this.S;
    if (localp != null) {
      localp.a();
    }
    localp = this.T;
    if (localp != null) {
      localp.a();
    }
  }
  
  private Configuration V(Context paramContext, int paramInt, Configuration paramConfiguration)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramInt = paramContext.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
      } else {
        paramInt = 32;
      }
    }
    else {
      paramInt = 16;
    }
    paramContext = new Configuration();
    paramContext.fontScale = 0.0F;
    if (paramConfiguration != null) {
      paramContext.setTo(paramConfiguration);
    }
    paramContext.uiMode = (paramInt | paramContext.uiMode & 0xFFFFFFCF);
    return paramContext;
  }
  
  private ViewGroup W()
  {
    Object localObject1 = this.e.obtainStyledAttributes(R.styleable.AppCompatTheme);
    int i1 = R.styleable.AppCompatTheme_windowActionBar;
    if (((TypedArray)localObject1).hasValue(i1))
    {
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
        C(1);
      } else if (((TypedArray)localObject1).getBoolean(i1, false)) {
        C(108);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        C(109);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        C(10);
      }
      this.E = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject1).recycle();
      d0();
      this.f.getDecorView();
      localObject1 = LayoutInflater.from(this.e);
      Object localObject2;
      if (!this.F)
      {
        if (this.E)
        {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
          this.B = false;
          this.A = false;
        }
        else if (this.A)
        {
          localObject1 = new TypedValue();
          this.e.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
          if (((TypedValue)localObject1).resourceId != 0) {
            localObject1 = new g.d(this.e, ((TypedValue)localObject1).resourceId);
          } else {
            localObject1 = this.e;
          }
          localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
          localObject1 = (androidx.appcompat.widget.r)((ViewGroup)localObject2).findViewById(R.id.decor_content_parent);
          this.l = ((androidx.appcompat.widget.r)localObject1);
          ((androidx.appcompat.widget.r)localObject1).setWindowCallback(l0());
          if (this.B) {
            this.l.k(109);
          }
          if (this.y) {
            this.l.k(2);
          }
          localObject1 = localObject2;
          if (this.z)
          {
            this.l.k(5);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      else
      {
        if (this.C) {
          i1 = R.layout.abc_screen_simple_overlay_action_mode;
        } else {
          i1 = R.layout.abc_screen_simple;
        }
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(i1, null);
      }
      if (localObject1 != null)
      {
        x.E0((View)localObject1, new b());
        if (this.l == null) {
          this.w = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
        }
        r0.c((View)localObject1);
        localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
        ViewGroup localViewGroup = (ViewGroup)this.f.findViewById(16908290);
        if (localViewGroup != null)
        {
          while (localViewGroup.getChildCount() > 0)
          {
            View localView = localViewGroup.getChildAt(0);
            localViewGroup.removeViewAt(0);
            ((FrameLayout)localObject2).addView(localView);
          }
          localViewGroup.setId(-1);
          ((FrameLayout)localObject2).setId(16908290);
          if ((localViewGroup instanceof FrameLayout)) {
            ((FrameLayout)localViewGroup).setForeground(null);
          }
        }
        this.f.setContentView((View)localObject1);
        ((ContentFrameLayout)localObject2).setAttachListener(new c());
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AppCompat does not support the current theme features: { windowActionBar: ");
      ((StringBuilder)localObject1).append(this.A);
      ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
      ((StringBuilder)localObject1).append(this.B);
      ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
      ((StringBuilder)localObject1).append(this.E);
      ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
      ((StringBuilder)localObject1).append(this.C);
      ((StringBuilder)localObject1).append(", windowNoTitle: ");
      ((StringBuilder)localObject1).append(this.F);
      ((StringBuilder)localObject1).append(" }");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    ((TypedArray)localObject1).recycle();
    throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
  }
  
  private void c0()
  {
    if (!this.u)
    {
      this.v = W();
      Object localObject1 = k0();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = this.l;
        if (localObject2 != null)
        {
          ((androidx.appcompat.widget.r)localObject2).setWindowTitle((CharSequence)localObject1);
        }
        else if (E0() != null)
        {
          E0().w((CharSequence)localObject1);
        }
        else
        {
          localObject2 = this.w;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
      }
      N();
      C0(this.v);
      this.u = true;
      localObject1 = j0(0, false);
      if ((!this.M) && ((localObject1 == null) || (((PanelFeatureState)localObject1).j == null))) {
        q0(108);
      }
    }
  }
  
  private void d0()
  {
    if (this.f == null)
    {
      Object localObject = this.d;
      if ((localObject instanceof Activity)) {
        O(((Activity)localObject).getWindow());
      }
    }
    if (this.f != null) {
      return;
    }
    throw new IllegalStateException("We have not been given a Window");
  }
  
  private static Configuration f0(Configuration paramConfiguration1, Configuration paramConfiguration2)
  {
    Configuration localConfiguration = new Configuration();
    localConfiguration.fontScale = 0.0F;
    if (paramConfiguration2 != null)
    {
      if (paramConfiguration1.diff(paramConfiguration2) == 0) {
        return localConfiguration;
      }
      float f1 = paramConfiguration1.fontScale;
      float f2 = paramConfiguration2.fontScale;
      if (f1 != f2) {
        localConfiguration.fontScale = f2;
      }
      int i1 = paramConfiguration1.mcc;
      int i2 = paramConfiguration2.mcc;
      if (i1 != i2) {
        localConfiguration.mcc = i2;
      }
      i1 = paramConfiguration1.mnc;
      i2 = paramConfiguration2.mnc;
      if (i1 != i2) {
        localConfiguration.mnc = i2;
      }
      i1 = Build.VERSION.SDK_INT;
      if (i1 >= 24) {
        l.a(paramConfiguration1, paramConfiguration2, localConfiguration);
      } else if (!x0.c.a(paramConfiguration1.locale, paramConfiguration2.locale)) {
        localConfiguration.locale = paramConfiguration2.locale;
      }
      i2 = paramConfiguration1.touchscreen;
      int i3 = paramConfiguration2.touchscreen;
      if (i2 != i3) {
        localConfiguration.touchscreen = i3;
      }
      i2 = paramConfiguration1.keyboard;
      i3 = paramConfiguration2.keyboard;
      if (i2 != i3) {
        localConfiguration.keyboard = i3;
      }
      i2 = paramConfiguration1.keyboardHidden;
      i3 = paramConfiguration2.keyboardHidden;
      if (i2 != i3) {
        localConfiguration.keyboardHidden = i3;
      }
      i2 = paramConfiguration1.navigation;
      i3 = paramConfiguration2.navigation;
      if (i2 != i3) {
        localConfiguration.navigation = i3;
      }
      i2 = paramConfiguration1.navigationHidden;
      i3 = paramConfiguration2.navigationHidden;
      if (i2 != i3) {
        localConfiguration.navigationHidden = i3;
      }
      i2 = paramConfiguration1.orientation;
      i3 = paramConfiguration2.orientation;
      if (i2 != i3) {
        localConfiguration.orientation = i3;
      }
      i2 = paramConfiguration1.screenLayout;
      i3 = paramConfiguration2.screenLayout;
      if ((i2 & 0xF) != (i3 & 0xF)) {
        localConfiguration.screenLayout |= i3 & 0xF;
      }
      i2 = paramConfiguration1.screenLayout;
      i3 = paramConfiguration2.screenLayout;
      if ((i2 & 0xC0) != (i3 & 0xC0)) {
        localConfiguration.screenLayout |= i3 & 0xC0;
      }
      i2 = paramConfiguration1.screenLayout;
      i3 = paramConfiguration2.screenLayout;
      if ((i2 & 0x30) != (i3 & 0x30)) {
        localConfiguration.screenLayout |= i3 & 0x30;
      }
      i2 = paramConfiguration1.screenLayout;
      i3 = paramConfiguration2.screenLayout;
      if ((i2 & 0x300) != (i3 & 0x300)) {
        localConfiguration.screenLayout |= i3 & 0x300;
      }
      if (i1 >= 26) {
        m.a(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
      i1 = paramConfiguration1.uiMode;
      i2 = paramConfiguration2.uiMode;
      if ((i1 & 0xF) != (i2 & 0xF)) {
        localConfiguration.uiMode |= i2 & 0xF;
      }
      i1 = paramConfiguration1.uiMode;
      i2 = paramConfiguration2.uiMode;
      if ((i1 & 0x30) != (i2 & 0x30)) {
        localConfiguration.uiMode |= i2 & 0x30;
      }
      i1 = paramConfiguration1.screenWidthDp;
      i2 = paramConfiguration2.screenWidthDp;
      if (i1 != i2) {
        localConfiguration.screenWidthDp = i2;
      }
      i1 = paramConfiguration1.screenHeightDp;
      i2 = paramConfiguration2.screenHeightDp;
      if (i1 != i2) {
        localConfiguration.screenHeightDp = i2;
      }
      i1 = paramConfiguration1.smallestScreenWidthDp;
      i2 = paramConfiguration2.smallestScreenWidthDp;
      if (i1 != i2) {
        localConfiguration.smallestScreenWidthDp = i2;
      }
      j.b(paramConfiguration1, paramConfiguration2, localConfiguration);
    }
    return localConfiguration;
  }
  
  private p h0(Context paramContext)
  {
    if (this.T == null) {
      this.T = new o(paramContext);
    }
    return this.T;
  }
  
  private p i0(Context paramContext)
  {
    if (this.S == null) {
      this.S = new q(k.a(paramContext));
    }
    return this.S;
  }
  
  private void m0()
  {
    c0();
    if (this.A)
    {
      if (this.i != null) {
        return;
      }
      Object localObject = this.d;
      if ((localObject instanceof Activity)) {}
      for (localObject = new l((Activity)this.d, this.B);; localObject = new l((Dialog)this.d))
      {
        this.i = ((ActionBar)localObject);
        break;
        if (!(localObject instanceof Dialog)) {
          break;
        }
      }
      localObject = this.i;
      if (localObject != null) {
        ((ActionBar)localObject).s(this.X);
      }
    }
  }
  
  private boolean n0(PanelFeatureState paramPanelFeatureState)
  {
    View localView = paramPanelFeatureState.i;
    if (localView != null)
    {
      paramPanelFeatureState.h = localView;
      return true;
    }
    if (paramPanelFeatureState.j == null) {
      return false;
    }
    if (this.n == null) {
      this.n = new t();
    }
    localView = (View)paramPanelFeatureState.a(this.n);
    paramPanelFeatureState.h = localView;
    return localView != null;
  }
  
  private boolean o0(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.d(g0());
    paramPanelFeatureState.g = new s(paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }
  
  private boolean p0(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.e;
    int i1 = paramPanelFeatureState.a;
    if (i1 != 0)
    {
      localObject1 = localContext;
      if (i1 != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (this.l != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (localTypedValue.resourceId != 0)
        {
          localObject1 = localContext.getResources().newTheme();
          ((Resources.Theme)localObject1).setTo(localTheme);
          ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
          ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new g.d(localContext, 0);
          ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new androidx.appcompat.view.menu.e((Context)localObject1);
    ((androidx.appcompat.view.menu.e)localObject1).V(this);
    paramPanelFeatureState.c((androidx.appcompat.view.menu.e)localObject1);
    return true;
  }
  
  private void q0(int paramInt)
  {
    this.V = (1 << paramInt | this.V);
    if (!this.U)
    {
      x.i0(this.f.getDecorView(), this.W);
      this.U = true;
    }
  }
  
  private boolean r0()
  {
    Object localObject;
    if ((!this.R) && ((this.d instanceof Activity)))
    {
      localObject = this.e.getPackageManager();
      if (localObject == null) {
        return false;
      }
    }
    label145:
    for (;;)
    {
      int i1;
      boolean bool;
      try
      {
        i1 = Build.VERSION.SDK_INT;
        if (i1 < 29) {
          break label127;
        }
        i1 = 269221888;
        localObject = ((PackageManager)localObject).getActivityInfo(new ComponentName(this.e, this.d.getClass()), i1);
        if ((localObject == null) || ((((ActivityInfo)localObject).configChanges & 0x200) == 0)) {
          break label145;
        }
        bool = true;
        this.Q = bool;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        this.Q = false;
      }
      this.R = true;
      return this.Q;
      label127:
      if (i1 >= 24)
      {
        i1 = 786432;
      }
      else
      {
        i1 = 0;
        continue;
        bool = false;
      }
    }
  }
  
  private boolean w0(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = j0(paramInt, true);
      if (!localPanelFeatureState.o) {
        return G0(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean z0(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.o != null) {
      return false;
    }
    boolean bool2 = true;
    PanelFeatureState localPanelFeatureState = j0(paramInt, true);
    if (paramInt == 0)
    {
      androidx.appcompat.widget.r localr = this.l;
      if ((localr != null) && (localr.h()) && (!ViewConfiguration.get(this.e).hasPermanentMenuKey()))
      {
        if (!this.l.b())
        {
          if ((this.M) || (!G0(localPanelFeatureState, paramKeyEvent))) {
            break label186;
          }
          bool1 = this.l.g();
          break label198;
        }
        bool1 = this.l.f();
        break label198;
      }
    }
    boolean bool1 = localPanelFeatureState.o;
    if ((!bool1) && (!localPanelFeatureState.n))
    {
      if (localPanelFeatureState.m)
      {
        if (localPanelFeatureState.r)
        {
          localPanelFeatureState.m = false;
          bool1 = G0(localPanelFeatureState, paramKeyEvent);
        }
        else
        {
          bool1 = true;
        }
        if (bool1)
        {
          D0(localPanelFeatureState, paramKeyEvent);
          bool1 = bool2;
          break label198;
        }
      }
      label186:
      bool1 = false;
    }
    else
    {
      U(localPanelFeatureState, true);
    }
    label198:
    if (bool1)
    {
      paramKeyEvent = (AudioManager)this.e.getApplicationContext().getSystemService("audio");
      if (paramKeyEvent != null)
      {
        paramKeyEvent.playSoundEffect(0);
        return bool1;
      }
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
    }
    return bool1;
  }
  
  void A0(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = p();
      if (localActionBar != null) {
        localActionBar.i(true);
      }
    }
  }
  
  void B0(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = p();
      if (localObject != null) {
        ((ActionBar)localObject).i(false);
      }
    }
    else if (paramInt == 0)
    {
      localObject = j0(paramInt, true);
      if (((PanelFeatureState)localObject).o) {
        U((PanelFeatureState)localObject, false);
      }
    }
  }
  
  public boolean C(int paramInt)
  {
    paramInt = I0(paramInt);
    if ((this.F) && (paramInt == 108)) {
      return false;
    }
    if ((this.A) && (paramInt == 1)) {
      this.A = false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 10)
          {
            if (paramInt != 108)
            {
              if (paramInt != 109) {
                return this.f.requestFeature(paramInt);
              }
              M0();
              this.B = true;
              return true;
            }
            M0();
            this.A = true;
            return true;
          }
          M0();
          this.C = true;
          return true;
        }
        M0();
        this.z = true;
        return true;
      }
      M0();
      this.y = true;
      return true;
    }
    M0();
    this.F = true;
    return true;
  }
  
  void C0(ViewGroup paramViewGroup) {}
  
  public void E(int paramInt)
  {
    c0();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.e).inflate(paramInt, localViewGroup);
    this.g.a().onContentChanged();
  }
  
  final ActionBar E0()
  {
    return this.i;
  }
  
  public void F(View paramView)
  {
    c0();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.g.a().onContentChanged();
  }
  
  public void G(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    c0();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.g.a().onContentChanged();
  }
  
  public void I(Toolbar paramToolbar)
  {
    if (!(this.d instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = p();
    if (!(localActionBar instanceof l))
    {
      this.j = null;
      if (localActionBar != null) {
        localActionBar.o();
      }
      this.i = null;
      if (paramToolbar != null)
      {
        paramToolbar = new i(paramToolbar, k0(), this.g);
        this.i = paramToolbar;
        this.g.b(paramToolbar.c);
      }
      else
      {
        this.g.b(null);
      }
      r();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void J(int paramInt)
  {
    this.P = paramInt;
  }
  
  final boolean J0()
  {
    if (this.u)
    {
      ViewGroup localViewGroup = this.v;
      if ((localViewGroup != null) && (x.U(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  public final void K(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    Object localObject = this.l;
    if (localObject != null)
    {
      ((androidx.appcompat.widget.r)localObject).setWindowTitle(paramCharSequence);
      return;
    }
    if (E0() != null)
    {
      E0().w(paramCharSequence);
      return;
    }
    localObject = this.w;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
  
  public g.b L(b.a parama)
  {
    if (parama != null)
    {
      Object localObject = this.o;
      if (localObject != null) {
        ((g.b)localObject).c();
      }
      parama = new i(parama);
      localObject = p();
      if (localObject != null)
      {
        localObject = ((ActionBar)localObject).y(parama);
        this.o = ((g.b)localObject);
        if (localObject != null)
        {
          c localc = this.h;
          if (localc != null) {
            localc.onSupportActionModeStarted((g.b)localObject);
          }
        }
      }
      if (this.o == null) {
        this.o = L0(parama);
      }
      return this.o;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  g.b L0(b.a parama)
  {
    b0();
    Object localObject1 = this.o;
    if (localObject1 != null) {
      ((g.b)localObject1).c();
    }
    localObject1 = parama;
    if (!(parama instanceof i)) {
      localObject1 = new i(parama);
    }
    parama = this.h;
    if ((parama != null) && (!this.M)) {}
    try
    {
      parama = parama.onWindowStartingSupportActionMode((b.a)localObject1);
    }
    catch (AbstractMethodError parama)
    {
      label69:
      boolean bool;
      Object localObject2;
      Object localObject3;
      int i1;
      break label69;
    }
    parama = null;
    if (parama != null)
    {
      this.o = parama;
    }
    else
    {
      parama = this.p;
      bool = true;
      if (parama == null) {
        if (this.E)
        {
          localObject2 = new TypedValue();
          parama = this.e.getTheme();
          parama.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            localObject3 = this.e.getResources().newTheme();
            ((Resources.Theme)localObject3).setTo(parama);
            ((Resources.Theme)localObject3).applyStyle(((TypedValue)localObject2).resourceId, true);
            parama = new g.d(this.e, 0);
            parama.getTheme().setTo((Resources.Theme)localObject3);
          }
          else
          {
            parama = this.e;
          }
          this.p = new ActionBarContextView(parama);
          localObject3 = new PopupWindow(parama, null, R.attr.actionModePopupWindowStyle);
          this.q = ((PopupWindow)localObject3);
          androidx.core.widget.k.b((PopupWindow)localObject3, 2);
          this.q.setContentView(this.p);
          this.q.setWidth(-1);
          parama.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
          i1 = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, parama.getResources().getDisplayMetrics());
          this.p.setContentHeight(i1);
          this.q.setHeight(-2);
          this.r = new d();
        }
        else
        {
          parama = (ViewStubCompat)this.v.findViewById(R.id.action_mode_bar_stub);
          if (parama != null)
          {
            parama.setLayoutInflater(LayoutInflater.from(g0()));
            this.p = ((ActionBarContextView)parama.a());
          }
        }
      }
      if (this.p != null)
      {
        b0();
        this.p.k();
        parama = this.p.getContext();
        localObject2 = this.p;
        if (this.q != null) {
          bool = false;
        }
        parama = new g.e(parama, (ActionBarContextView)localObject2, (b.a)localObject1, bool);
        if (((b.a)localObject1).b(parama, parama.e()))
        {
          parama.k();
          this.p.h(parama);
          this.o = parama;
          if (J0())
          {
            this.p.setAlpha(0.0F);
            parama = x.e(this.p).a(1.0F);
            this.s = parama;
            parama.f(new e());
          }
          else
          {
            this.p.setAlpha(1.0F);
            this.p.setVisibility(0);
            if ((this.p.getParent() instanceof View)) {
              x.n0((View)this.p.getParent());
            }
          }
          if (this.q != null) {
            this.f.getDecorView().post(this.r);
          }
        }
        else
        {
          this.o = null;
        }
      }
    }
    parama = this.o;
    if (parama != null)
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((c)localObject1).onSupportActionModeStarted(parama);
      }
    }
    return this.o;
  }
  
  void Q(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject1 = this.H;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject1.length) {
            localPanelFeatureState = localObject1[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.j;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).o)) {
      return;
    }
    if (!this.M) {
      this.g.a().onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  final int Q0(h0 paramh0, Rect paramRect)
  {
    int i6 = 0;
    int i1;
    if (paramh0 != null) {
      i1 = paramh0.l();
    } else if (paramRect != null) {
      i1 = paramRect.top;
    } else {
      i1 = 0;
    }
    Object localObject = this.p;
    int i5;
    int i4;
    if ((localObject != null) && ((((ViewGroup)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject = (ViewGroup.MarginLayoutParams)this.p.getLayoutParams();
      boolean bool = this.p.isShown();
      int i3 = 1;
      i5 = 1;
      int i2;
      if (bool)
      {
        if (this.Y == null)
        {
          this.Y = new Rect();
          this.Z = new Rect();
        }
        Rect localRect1 = this.Y;
        Rect localRect2 = this.Z;
        if (paramh0 == null) {
          localRect1.set(paramRect);
        } else {
          localRect1.set(paramh0.j(), paramh0.l(), paramh0.k(), paramh0.i());
        }
        r0.a(this.v, localRect1, localRect2);
        int i7 = localRect1.top;
        i2 = localRect1.left;
        int i8 = localRect1.right;
        paramh0 = x.I(this.v);
        if (paramh0 == null) {
          i3 = 0;
        } else {
          i3 = paramh0.j();
        }
        if (paramh0 == null) {
          i4 = 0;
        } else {
          i4 = paramh0.k();
        }
        if ((((ViewGroup.MarginLayoutParams)localObject).topMargin == i7) && (((ViewGroup.MarginLayoutParams)localObject).leftMargin == i2) && (((ViewGroup.MarginLayoutParams)localObject).rightMargin == i8))
        {
          i2 = 0;
        }
        else
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = i7;
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i2;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i8;
          i2 = 1;
        }
        if ((i7 > 0) && (this.x == null))
        {
          paramh0 = new View(this.e);
          this.x = paramh0;
          paramh0.setVisibility(8);
          paramh0 = new FrameLayout.LayoutParams(-1, ((ViewGroup.MarginLayoutParams)localObject).topMargin, 51);
          paramh0.leftMargin = i3;
          paramh0.rightMargin = i4;
          this.v.addView(this.x, -1, paramh0);
        }
        else
        {
          paramh0 = this.x;
          if (paramh0 != null)
          {
            paramh0 = (ViewGroup.MarginLayoutParams)paramh0.getLayoutParams();
            i7 = paramh0.height;
            i8 = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            if ((i7 != i8) || (paramh0.leftMargin != i3) || (paramh0.rightMargin != i4))
            {
              paramh0.height = i8;
              paramh0.leftMargin = i3;
              paramh0.rightMargin = i4;
              this.x.setLayoutParams(paramh0);
            }
          }
        }
        paramh0 = this.x;
        if (paramh0 != null) {
          i4 = i5;
        } else {
          i4 = 0;
        }
        if ((i4 != 0) && (paramh0.getVisibility() != 0)) {
          R0(this.x);
        }
        i3 = i1;
        if (!this.C)
        {
          i3 = i1;
          if (i4 != 0) {
            i3 = 0;
          }
        }
        i1 = i3;
        i3 = i2;
        i2 = i4;
      }
      else if (((ViewGroup.MarginLayoutParams)localObject).topMargin != 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        i2 = 0;
      }
      else
      {
        i2 = 0;
        i3 = i2;
      }
      i4 = i1;
      i5 = i2;
      if (i3 != 0)
      {
        this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i4 = i1;
        i5 = i2;
      }
    }
    else
    {
      i5 = 0;
      i4 = i1;
    }
    paramh0 = this.x;
    if (paramh0 != null)
    {
      if (i5 != 0) {
        i1 = i6;
      } else {
        i1 = 8;
      }
      paramh0.setVisibility(i1);
    }
    return i4;
  }
  
  void R(androidx.appcompat.view.menu.e parame)
  {
    if (this.G) {
      return;
    }
    this.G = true;
    this.l.l();
    Window.Callback localCallback = l0();
    if ((localCallback != null) && (!this.M)) {
      localCallback.onPanelClosed(108, parame);
    }
    this.G = false;
  }
  
  void T(int paramInt)
  {
    U(j0(paramInt, true), true);
  }
  
  void U(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0))
    {
      localObject = this.l;
      if ((localObject != null) && (((androidx.appcompat.widget.r)localObject).b()))
      {
        R(paramPanelFeatureState.j);
        return;
      }
    }
    Object localObject = (WindowManager)this.e.getSystemService("window");
    if ((localObject != null) && (paramPanelFeatureState.o))
    {
      ViewGroup localViewGroup = paramPanelFeatureState.g;
      if (localViewGroup != null)
      {
        ((WindowManager)localObject).removeView(localViewGroup);
        if (paramBoolean) {
          Q(paramPanelFeatureState.a, paramPanelFeatureState, null);
        }
      }
    }
    paramPanelFeatureState.m = false;
    paramPanelFeatureState.n = false;
    paramPanelFeatureState.o = false;
    paramPanelFeatureState.h = null;
    paramPanelFeatureState.q = true;
    if (this.I == paramPanelFeatureState) {
      this.I = null;
    }
  }
  
  /* Error */
  public View X(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1466	androidx/appcompat/app/AppCompatDelegateImpl:a0	Landroidx/appcompat/app/f;
    //   4: astore 9
    //   6: iconst_0
    //   7: istore 6
    //   9: aload 9
    //   11: ifnonnull +143 -> 154
    //   14: aload_0
    //   15: getfield 208	androidx/appcompat/app/AppCompatDelegateImpl:e	Landroid/content/Context;
    //   18: getstatic 617	androidx/appcompat/R$styleable:AppCompatTheme	[I
    //   21: invokevirtual 621	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   24: getstatic 1469	androidx/appcompat/R$styleable:AppCompatTheme_viewInflaterClass	I
    //   27: invokevirtual 1473	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   30: astore 9
    //   32: aload 9
    //   34: ifnonnull +21 -> 55
    //   37: new 1475	androidx/appcompat/app/f
    //   40: dup
    //   41: invokespecial 1476	androidx/appcompat/app/f:<init>	()V
    //   44: astore 9
    //   46: aload_0
    //   47: aload 9
    //   49: putfield 1466	androidx/appcompat/app/AppCompatDelegateImpl:a0	Landroidx/appcompat/app/f;
    //   52: goto +102 -> 154
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 208	androidx/appcompat/app/AppCompatDelegateImpl:e	Landroid/content/Context;
    //   60: invokevirtual 1480	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   63: aload 9
    //   65: invokevirtual 1486	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   68: iconst_0
    //   69: anewarray 233	java/lang/Class
    //   72: invokevirtual 1490	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   75: iconst_0
    //   76: anewarray 227	java/lang/Object
    //   79: invokevirtual 1496	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 1475	androidx/appcompat/app/f
    //   85: putfield 1466	androidx/appcompat/app/AppCompatDelegateImpl:a0	Landroidx/appcompat/app/f;
    //   88: goto +66 -> 154
    //   91: astore 10
    //   93: new 968	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 969	java/lang/StringBuilder:<init>	()V
    //   100: astore 11
    //   102: aload 11
    //   104: ldc_w 1498
    //   107: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 11
    //   113: aload 9
    //   115: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 11
    //   121: ldc_w 1500
    //   124: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc_w 535
    //   131: aload 11
    //   133: invokevirtual 993	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: aload 10
    //   138: invokestatic 1502	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: new 1475	androidx/appcompat/app/f
    //   145: dup
    //   146: invokespecial 1476	androidx/appcompat/app/f:<init>	()V
    //   149: astore 9
    //   151: goto -105 -> 46
    //   154: getstatic 157	androidx/appcompat/app/AppCompatDelegateImpl:d0	Z
    //   157: istore 8
    //   159: iconst_1
    //   160: istore 7
    //   162: iload 6
    //   164: istore 5
    //   166: iload 8
    //   168: ifeq +82 -> 250
    //   171: aload_0
    //   172: getfield 1504	androidx/appcompat/app/AppCompatDelegateImpl:b0	Landroidx/appcompat/app/g;
    //   175: ifnonnull +14 -> 189
    //   178: aload_0
    //   179: new 1506	androidx/appcompat/app/g
    //   182: dup
    //   183: invokespecial 1507	androidx/appcompat/app/g:<init>	()V
    //   186: putfield 1504	androidx/appcompat/app/AppCompatDelegateImpl:b0	Landroidx/appcompat/app/g;
    //   189: aload_0
    //   190: getfield 1504	androidx/appcompat/app/AppCompatDelegateImpl:b0	Landroidx/appcompat/app/g;
    //   193: aload 4
    //   195: invokevirtual 1510	androidx/appcompat/app/g:a	(Landroid/util/AttributeSet;)Z
    //   198: ifeq +9 -> 207
    //   201: iconst_1
    //   202: istore 5
    //   204: goto +46 -> 250
    //   207: aload 4
    //   209: instanceof 1512
    //   212: ifeq +28 -> 240
    //   215: iload 6
    //   217: istore 5
    //   219: aload 4
    //   221: checkcast 1512	org/xmlpull/v1/XmlPullParser
    //   224: invokeinterface 1515 1 0
    //   229: iconst_1
    //   230: if_icmple +20 -> 250
    //   233: iload 7
    //   235: istore 5
    //   237: goto +13 -> 250
    //   240: aload_0
    //   241: aload_1
    //   242: checkcast 553	android/view/ViewParent
    //   245: invokespecial 1517	androidx/appcompat/app/AppCompatDelegateImpl:K0	(Landroid/view/ViewParent;)Z
    //   248: istore 5
    //   250: aload_0
    //   251: getfield 1466	androidx/appcompat/app/AppCompatDelegateImpl:a0	Landroidx/appcompat/app/f;
    //   254: aload_1
    //   255: aload_2
    //   256: aload_3
    //   257: aload 4
    //   259: iload 5
    //   261: iload 8
    //   263: iconst_1
    //   264: invokestatic 1521	androidx/appcompat/widget/q0:d	()Z
    //   267: invokevirtual 1524	androidx/appcompat/app/f:r	(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   270: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	AppCompatDelegateImpl
    //   0	271	1	paramView	View
    //   0	271	2	paramString	String
    //   0	271	3	paramContext	Context
    //   0	271	4	paramAttributeSet	AttributeSet
    //   164	96	5	bool1	boolean
    //   7	209	6	bool2	boolean
    //   160	74	7	bool3	boolean
    //   157	105	8	bool4	boolean
    //   4	146	9	localObject	Object
    //   91	46	10	localThrowable	java.lang.Throwable
    //   100	32	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   55	88	91	finally
  }
  
  void Y()
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((androidx.appcompat.widget.r)localObject).l();
    }
    if (this.q != null)
    {
      this.f.getDecorView().removeCallbacks(this.r);
      if (!this.q.isShowing()) {}
    }
    try
    {
      this.q.dismiss();
      label54:
      this.q = null;
      b0();
      localObject = j0(0, false);
      if (localObject != null)
      {
        localObject = ((PanelFeatureState)localObject).j;
        if (localObject != null) {
          ((androidx.appcompat.view.menu.e)localObject).close();
        }
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label54;
    }
  }
  
  boolean Z(KeyEvent paramKeyEvent)
  {
    Object localObject = this.d;
    boolean bool = localObject instanceof androidx.core.view.f.a;
    int i1 = 1;
    if ((bool) || ((localObject instanceof e)))
    {
      localObject = this.f.getDecorView();
      if ((localObject != null) && (androidx.core.view.f.d((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (this.g.a().dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int i2 = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0) {
      i1 = 0;
    }
    if (i1 != 0) {
      return v0(i2, paramKeyEvent);
    }
    return y0(i2, paramKeyEvent);
  }
  
  public boolean a(androidx.appcompat.view.menu.e parame, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = l0();
    if ((localCallback != null) && (!this.M))
    {
      parame = e0(parame.F());
      if (parame != null) {
        return localCallback.onMenuItemSelected(parame.a, paramMenuItem);
      }
    }
    return false;
  }
  
  void a0(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = j0(paramInt, true);
    if (localPanelFeatureState.j != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.j.T(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.s = localBundle;
      }
      localPanelFeatureState.j.h0();
      localPanelFeatureState.j.clear();
    }
    localPanelFeatureState.r = true;
    localPanelFeatureState.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.l != null))
    {
      localPanelFeatureState = j0(0, false);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.m = false;
        G0(localPanelFeatureState, null);
      }
    }
  }
  
  public void b(androidx.appcompat.view.menu.e parame)
  {
    H0(true);
  }
  
  void b0()
  {
    c0 localc0 = this.s;
    if (localc0 != null) {
      localc0.b();
    }
  }
  
  public void d(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    c0();
    ((ViewGroup)this.v.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.g.a().onContentChanged();
  }
  
  public boolean e()
  {
    return M(true);
  }
  
  PanelFeatureState e0(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.H;
    int i2 = 0;
    int i1;
    if (arrayOfPanelFeatureState != null) {
      i1 = arrayOfPanelFeatureState.length;
    } else {
      i1 = 0;
    }
    while (i2 < i1)
    {
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[i2];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j == paramMenu)) {
        return localPanelFeatureState;
      }
      i2 += 1;
    }
    return null;
  }
  
  final Context g0()
  {
    Object localObject1 = p();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).k();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.e;
    }
    return localObject2;
  }
  
  public Context h(Context paramContext)
  {
    i1 = 1;
    this.K = true;
    i2 = t0(paramContext, P());
    boolean bool = g0;
    Object localObject = null;
    if ((bool) && ((paramContext instanceof ContextThemeWrapper))) {
      localConfiguration1 = V(paramContext, i2, null);
    }
    try
    {
      r.a((ContextThemeWrapper)paramContext, localConfiguration1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      label57:
      break label57;
    }
    if ((paramContext instanceof g.d)) {
      localConfiguration1 = V(paramContext, i2, null);
    }
    try
    {
      ((g.d)paramContext).a(localConfiguration1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      label84:
      Configuration localConfiguration2;
      break label84;
    }
    if (!f0) {
      return super.h(paramContext);
    }
    Configuration localConfiguration1 = new Configuration();
    localConfiguration1.uiMode = -1;
    localConfiguration1.fontScale = 0.0F;
    localConfiguration1 = j.a(paramContext, localConfiguration1).getResources().getConfiguration();
    localConfiguration2 = paramContext.getResources().getConfiguration();
    localConfiguration1.uiMode = localConfiguration2.uiMode;
    if (!localConfiguration1.equals(localConfiguration2)) {
      localObject = f0(localConfiguration1, localConfiguration2);
    }
    localConfiguration1 = V(paramContext, i2, (Configuration)localObject);
    localObject = new g.d(paramContext, R.style.Theme_AppCompat_Empty);
    ((g.d)localObject).a(localConfiguration1);
    i2 = 0;
    try
    {
      paramContext = paramContext.getTheme();
      if (paramContext == null) {
        i1 = 0;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    if (i1 != 0) {
      h.e.a(((g.d)localObject).getTheme());
    }
    return super.h((Context)localObject);
  }
  
  protected PanelFeatureState j0(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.H;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.H = ((PanelFeatureState[])localObject1);
    }
    Object localObject3 = localObject1[paramInt];
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return localObject2;
  }
  
  public <T extends View> T k(int paramInt)
  {
    c0();
    return this.f.findViewById(paramInt);
  }
  
  final CharSequence k0()
  {
    Object localObject = this.d;
    if ((localObject instanceof Activity)) {
      return ((Activity)localObject).getTitle();
    }
    return this.k;
  }
  
  final Window.Callback l0()
  {
    return this.f.getCallback();
  }
  
  public final a m()
  {
    return new f();
  }
  
  public int n()
  {
    return this.O;
  }
  
  public MenuInflater o()
  {
    if (this.j == null)
    {
      m0();
      Object localObject = this.i;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).k();
      } else {
        localObject = this.e;
      }
      this.j = new g.g((Context)localObject);
    }
    return this.j;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return X(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public ActionBar p()
  {
    m0();
    return this.i;
  }
  
  public void q()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.e);
    if (localLayoutInflater.getFactory() == null)
    {
      androidx.core.view.g.a(localLayoutInflater, this);
      return;
    }
    if (!(localLayoutInflater.getFactory2() instanceof AppCompatDelegateImpl)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void r()
  {
    if (E0() != null)
    {
      if (p().m()) {
        return;
      }
      q0(0);
    }
  }
  
  public void s(Configuration paramConfiguration)
  {
    if ((this.A) && (this.u))
    {
      ActionBar localActionBar = p();
      if (localActionBar != null) {
        localActionBar.n(paramConfiguration);
      }
    }
    androidx.appcompat.widget.g.b().g(this.e);
    this.N = new Configuration(this.e.getResources().getConfiguration());
    M(false);
  }
  
  public boolean s0()
  {
    return this.t;
  }
  
  public void t(Bundle paramBundle)
  {
    this.K = true;
    M(false);
    d0();
    Object localObject = this.d;
    if ((localObject instanceof Activity)) {
      paramBundle = null;
    }
    try
    {
      localObject = androidx.core.app.e.c((Activity)localObject);
      paramBundle = (Bundle)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label39:
      break label39;
    }
    if (paramBundle != null)
    {
      paramBundle = E0();
      if (paramBundle == null) {
        this.X = true;
      } else {
        paramBundle.s(true);
      }
    }
    d.c(this);
    this.N = new Configuration(this.e.getResources().getConfiguration());
    this.L = true;
  }
  
  int t0(Context paramContext, int paramInt)
  {
    if (paramInt != -100)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if ((paramInt == 1) || (paramInt == 2)) {
            break label82;
          }
          if (paramInt != 3) {}
        }
        for (paramContext = h0(paramContext);; paramContext = i0(paramContext))
        {
          return paramContext.c();
          throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
          if (((UiModeManager)paramContext.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
            return -1;
          }
        }
      }
      label82:
      return paramInt;
    }
    return -1;
  }
  
  public void u()
  {
    if ((this.d instanceof Activity)) {
      d.A(this);
    }
    if (this.U) {
      this.f.getDecorView().removeCallbacks(this.W);
    }
    this.M = true;
    if (this.O != -100)
    {
      localObject = this.d;
      if (((localObject instanceof Activity)) && (((Activity)localObject).isChangingConfigurations()))
      {
        c0.put(this.d.getClass().getName(), Integer.valueOf(this.O));
        break label116;
      }
    }
    c0.remove(this.d.getClass().getName());
    label116:
    Object localObject = this.i;
    if (localObject != null) {
      ((ActionBar)localObject).o();
    }
    S();
  }
  
  boolean u0()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((g.b)localObject).c();
      return true;
    }
    localObject = p();
    return (localObject != null) && (((ActionBar)localObject).h());
  }
  
  public void v(Bundle paramBundle)
  {
    c0();
  }
  
  boolean v0(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      w0(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) == 0) {
      bool = false;
    }
    this.J = bool;
    return false;
  }
  
  public void w()
  {
    ActionBar localActionBar = p();
    if (localActionBar != null) {
      localActionBar.v(true);
    }
  }
  
  public void x(Bundle paramBundle) {}
  
  boolean x0(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = p();
    if ((localObject != null) && (((ActionBar)localObject).p(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = this.I;
    if ((localObject != null) && (F0((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
    {
      paramKeyEvent = this.I;
      if (paramKeyEvent != null) {
        paramKeyEvent.n = true;
      }
      return true;
    }
    if (this.I == null)
    {
      localObject = j0(0, true);
      G0((PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = F0((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((PanelFeatureState)localObject).m = false;
      if (bool) {
        return true;
      }
    }
    return false;
  }
  
  public void y()
  {
    e();
  }
  
  boolean y0(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      z0(0, paramKeyEvent);
      return true;
    }
    boolean bool = this.J;
    this.J = false;
    paramKeyEvent = j0(0, false);
    if ((paramKeyEvent != null) && (paramKeyEvent.o))
    {
      if (!bool) {
        U(paramKeyEvent, true);
      }
      return true;
    }
    return u0();
  }
  
  public void z()
  {
    ActionBar localActionBar = p();
    if (localActionBar != null) {
      localActionBar.v(false);
    }
  }
  
  protected static final class PanelFeatureState
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    androidx.appcompat.view.menu.e j;
    androidx.appcompat.view.menu.c k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;
    
    PanelFeatureState(int paramInt)
    {
      this.a = paramInt;
      this.q = false;
    }
    
    androidx.appcompat.view.menu.k a(j.a parama)
    {
      if (this.j == null) {
        return null;
      }
      if (this.k == null)
      {
        androidx.appcompat.view.menu.c localc = new androidx.appcompat.view.menu.c(this.l, R.layout.abc_list_menu_item_layout);
        this.k = localc;
        localc.m(parama);
        this.j.b(this.k);
      }
      return this.k.c(this.g);
    }
    
    public boolean b()
    {
      View localView = this.h;
      boolean bool = false;
      if (localView == null) {
        return false;
      }
      if (this.i != null) {
        return true;
      }
      if (this.k.a().getCount() > 0) {
        bool = true;
      }
      return bool;
    }
    
    void c(androidx.appcompat.view.menu.e parame)
    {
      Object localObject = this.j;
      if (parame == localObject) {
        return;
      }
      if (localObject != null) {
        ((androidx.appcompat.view.menu.e)localObject).Q(this.k);
      }
      this.j = parame;
      if (parame != null)
      {
        localObject = this.k;
        if (localObject != null) {
          parame.b((j)localObject);
        }
      }
    }
    
    void d(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      int i1 = localTypedValue.resourceId;
      if (i1 != 0) {
        localTheme.applyStyle(i1, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        i1 = R.style.Theme_AppCompat_CompactMenu;
      }
      localTheme.applyStyle(i1, true);
      paramContext = new g.d(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      this.l = paramContext;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
      this.b = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      this.f = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      paramContext.recycle();
    }
    
    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new a();
      int a;
      boolean b;
      Bundle c;
      
      static SavedState g(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        SavedState localSavedState = new SavedState();
        localSavedState.a = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localSavedState.b = bool;
        if (bool) {
          localSavedState.c = paramParcel.readBundle(paramClassLoader);
        }
        return localSavedState;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      class a
        implements Parcelable.ClassLoaderCreator<AppCompatDelegateImpl.PanelFeatureState.SavedState>
      {
        public AppCompatDelegateImpl.PanelFeatureState.SavedState a(Parcel paramParcel)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.g(paramParcel, null);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.g(paramParcel, paramClassLoader);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState[] c(int paramInt)
        {
          return new AppCompatDelegateImpl.PanelFeatureState.SavedState[paramInt];
        }
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((localAppCompatDelegateImpl.V & 0x1) != 0) {
        localAppCompatDelegateImpl.a0(0);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((localAppCompatDelegateImpl.V & 0x1000) != 0) {
        localAppCompatDelegateImpl.a0(108);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      localAppCompatDelegateImpl.U = false;
      localAppCompatDelegateImpl.V = 0;
    }
  }
  
  class b
    implements androidx.core.view.r
  {
    b() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      int i = paramh0.l();
      int j = AppCompatDelegateImpl.this.Q0(paramh0, null);
      h0 localh0 = paramh0;
      if (i != j) {
        localh0 = paramh0.q(paramh0.j(), j, paramh0.k(), paramh0.i());
      }
      return x.c0(paramView, localh0);
    }
  }
  
  class c
    implements ContentFrameLayout.a
  {
    c() {}
    
    public void a() {}
    
    public void onDetachedFromWindow()
    {
      AppCompatDelegateImpl.this.Y();
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      localAppCompatDelegateImpl.q.showAtLocation(localAppCompatDelegateImpl.p, 55, 0, 0);
      AppCompatDelegateImpl.this.b0();
      if (AppCompatDelegateImpl.this.J0())
      {
        AppCompatDelegateImpl.this.p.setAlpha(0.0F);
        localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        localAppCompatDelegateImpl.s = x.e(localAppCompatDelegateImpl.p).a(1.0F);
        AppCompatDelegateImpl.this.s.f(new a());
        return;
      }
      AppCompatDelegateImpl.this.p.setAlpha(1.0F);
      AppCompatDelegateImpl.this.p.setVisibility(0);
    }
    
    class a
      extends e0
    {
      a() {}
      
      public void b(View paramView)
      {
        AppCompatDelegateImpl.this.p.setAlpha(1.0F);
        AppCompatDelegateImpl.this.s.f(null);
        AppCompatDelegateImpl.this.s = null;
      }
      
      public void c(View paramView)
      {
        AppCompatDelegateImpl.this.p.setVisibility(0);
      }
    }
  }
  
  class e
    extends e0
  {
    e() {}
    
    public void b(View paramView)
    {
      AppCompatDelegateImpl.this.p.setAlpha(1.0F);
      AppCompatDelegateImpl.this.s.f(null);
      AppCompatDelegateImpl.this.s = null;
    }
    
    public void c(View paramView)
    {
      AppCompatDelegateImpl.this.p.setVisibility(0);
      if ((AppCompatDelegateImpl.this.p.getParent() instanceof View)) {
        x.n0((View)AppCompatDelegateImpl.this.p.getParent());
      }
    }
  }
  
  private class f
    implements a
  {
    f() {}
  }
  
  static abstract interface g
  {
    public abstract boolean a(int paramInt);
    
    public abstract View onCreatePanelView(int paramInt);
  }
  
  private final class h
    implements j.a
  {
    h() {}
    
    public void b(androidx.appcompat.view.menu.e parame, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.R(parame);
    }
    
    public boolean c(androidx.appcompat.view.menu.e parame)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.l0();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, parame);
      }
      return true;
    }
  }
  
  class i
    implements b.a
  {
    private b.a a;
    
    public i(b.a parama)
    {
      this.a = parama;
    }
    
    public boolean a(g.b paramb, Menu paramMenu)
    {
      x.n0(AppCompatDelegateImpl.this.v);
      return this.a.a(paramb, paramMenu);
    }
    
    public boolean b(g.b paramb, Menu paramMenu)
    {
      return this.a.b(paramb, paramMenu);
    }
    
    public boolean c(g.b paramb, MenuItem paramMenuItem)
    {
      return this.a.c(paramb, paramMenuItem);
    }
    
    public void d(g.b paramb)
    {
      this.a.d(paramb);
      paramb = AppCompatDelegateImpl.this;
      if (paramb.q != null) {
        paramb.f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.r);
      }
      paramb = AppCompatDelegateImpl.this;
      if (paramb.p != null)
      {
        paramb.b0();
        paramb = AppCompatDelegateImpl.this;
        paramb.s = x.e(paramb.p).a(0.0F);
        AppCompatDelegateImpl.this.s.f(new a());
      }
      paramb = AppCompatDelegateImpl.this;
      c localc = paramb.h;
      if (localc != null) {
        localc.onSupportActionModeFinished(paramb.o);
      }
      paramb = AppCompatDelegateImpl.this;
      paramb.o = null;
      x.n0(paramb.v);
    }
    
    class a
      extends e0
    {
      a() {}
      
      public void b(View paramView)
      {
        AppCompatDelegateImpl.this.p.setVisibility(8);
        paramView = AppCompatDelegateImpl.this;
        PopupWindow localPopupWindow = paramView.q;
        if (localPopupWindow != null) {
          localPopupWindow.dismiss();
        } else if ((paramView.p.getParent() instanceof View)) {
          x.n0((View)AppCompatDelegateImpl.this.p.getParent());
        }
        AppCompatDelegateImpl.this.p.k();
        AppCompatDelegateImpl.this.s.f(null);
        paramView = AppCompatDelegateImpl.this;
        paramView.s = null;
        x.n0(paramView.v);
      }
    }
  }
  
  static class j
  {
    static Context a(Context paramContext, Configuration paramConfiguration)
    {
      return paramContext.createConfigurationContext(paramConfiguration);
    }
    
    static void b(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
    {
      int i = paramConfiguration1.densityDpi;
      int j = paramConfiguration2.densityDpi;
      if (i != j) {
        paramConfiguration3.densityDpi = j;
      }
    }
  }
  
  static class k
  {
    static boolean a(PowerManager paramPowerManager)
    {
      return paramPowerManager.isPowerSaveMode();
    }
  }
  
  static class l
  {
    static void a(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
    {
      paramConfiguration1 = paramConfiguration1.getLocales();
      LocaleList localLocaleList = paramConfiguration2.getLocales();
      if (!paramConfiguration1.equals(localLocaleList))
      {
        paramConfiguration3.setLocales(localLocaleList);
        paramConfiguration3.locale = paramConfiguration2.locale;
      }
    }
  }
  
  static class m
  {
    static void a(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
    {
      int i = paramConfiguration1.colorMode;
      int j = paramConfiguration2.colorMode;
      if ((i & 0x3) != (j & 0x3)) {
        paramConfiguration3.colorMode |= j & 0x3;
      }
      i = paramConfiguration1.colorMode;
      j = paramConfiguration2.colorMode;
      if ((i & 0xC) != (j & 0xC)) {
        paramConfiguration3.colorMode |= j & 0xC;
      }
    }
  }
  
  class n
    extends g.i
  {
    private AppCompatDelegateImpl.g b;
    
    n(Window.Callback paramCallback)
    {
      super();
    }
    
    void b(AppCompatDelegateImpl.g paramg)
    {
      this.b = paramg;
    }
    
    final ActionMode c(ActionMode.Callback paramCallback)
    {
      paramCallback = new g.f.a(AppCompatDelegateImpl.this.e, paramCallback);
      g.b localb = AppCompatDelegateImpl.this.L(paramCallback);
      if (localb != null) {
        return paramCallback.e(localb);
      }
      return null;
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.Z(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.x0(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof androidx.appcompat.view.menu.e))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public View onCreatePanelView(int paramInt)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((AppCompatDelegateImpl.g)localObject).onCreatePanelView(paramInt);
        if (localObject != null) {
          return localObject;
        }
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      AppCompatDelegateImpl.this.A0(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.B0(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      androidx.appcompat.view.menu.e locale;
      if ((paramMenu instanceof androidx.appcompat.view.menu.e)) {
        locale = (androidx.appcompat.view.menu.e)paramMenu;
      } else {
        locale = null;
      }
      if ((paramInt == 0) && (locale == null)) {
        return false;
      }
      boolean bool1 = true;
      if (locale != null) {
        locale.e0(true);
      }
      AppCompatDelegateImpl.g localg = this.b;
      if ((localg == null) || (!localg.a(paramInt))) {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
      }
      if (locale != null) {
        locale.e0(false);
      }
      return bool2;
    }
    
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      Object localObject = AppCompatDelegateImpl.this.j0(0, true);
      if (localObject != null)
      {
        localObject = ((AppCompatDelegateImpl.PanelFeatureState)localObject).j;
        if (localObject != null)
        {
          super.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
          return;
        }
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if ((AppCompatDelegateImpl.this.s0()) && (paramInt == 0)) {
        return c(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback, paramInt);
    }
  }
  
  private class o
    extends AppCompatDelegateImpl.p
  {
    private final PowerManager c;
    
    o(Context paramContext)
    {
      super();
      this.c = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    }
    
    IntentFilter b()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
      return localIntentFilter;
    }
    
    public int c()
    {
      if (AppCompatDelegateImpl.k.a(this.c)) {
        return 2;
      }
      return 1;
    }
    
    public void d()
    {
      AppCompatDelegateImpl.this.e();
    }
  }
  
  abstract class p
  {
    private BroadcastReceiver a;
    
    p() {}
    
    void a()
    {
      BroadcastReceiver localBroadcastReceiver = this.a;
      if (localBroadcastReceiver != null) {}
      try
      {
        AppCompatDelegateImpl.this.e.unregisterReceiver(localBroadcastReceiver);
        label20:
        this.a = null;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label20;
      }
    }
    
    abstract IntentFilter b();
    
    abstract int c();
    
    abstract void d();
    
    void e()
    {
      a();
      IntentFilter localIntentFilter = b();
      if (localIntentFilter != null)
      {
        if (localIntentFilter.countActions() == 0) {
          return;
        }
        if (this.a == null) {
          this.a = new a();
        }
        AppCompatDelegateImpl.this.e.registerReceiver(this.a, localIntentFilter);
      }
    }
    
    class a
      extends BroadcastReceiver
    {
      a() {}
      
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        AppCompatDelegateImpl.p.this.d();
      }
    }
  }
  
  private class q
    extends AppCompatDelegateImpl.p
  {
    private final k c;
    
    q(k paramk)
    {
      super();
      this.c = paramk;
    }
    
    IntentFilter b()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIME_TICK");
      return localIntentFilter;
    }
    
    public int c()
    {
      if (this.c.d()) {
        return 2;
      }
      return 1;
    }
    
    public void d()
    {
      AppCompatDelegateImpl.this.e();
    }
  }
  
  private static class r
  {
    static void a(ContextThemeWrapper paramContextThemeWrapper, Configuration paramConfiguration)
    {
      paramContextThemeWrapper.applyOverrideConfiguration(paramConfiguration);
    }
  }
  
  private class s
    extends ContentFrameLayout
  {
    public s(Context paramContext)
    {
      super();
    }
    
    private boolean b(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.Z(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        AppCompatDelegateImpl.this.T(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(c.a.b(getContext(), paramInt));
    }
  }
  
  private final class t
    implements j.a
  {
    t() {}
    
    public void b(androidx.appcompat.view.menu.e parame, boolean paramBoolean)
    {
      androidx.appcompat.view.menu.e locale = parame.F();
      int i;
      if (locale != parame) {
        i = 1;
      } else {
        i = 0;
      }
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if (i != 0) {
        parame = locale;
      }
      parame = localAppCompatDelegateImpl.e0(parame);
      if (parame != null)
      {
        if (i != 0)
        {
          AppCompatDelegateImpl.this.Q(parame.a, parame, locale);
          AppCompatDelegateImpl.this.U(parame, true);
          return;
        }
        AppCompatDelegateImpl.this.U(parame, paramBoolean);
      }
    }
    
    public boolean c(androidx.appcompat.view.menu.e parame)
    {
      if (parame == parame.F())
      {
        Object localObject = AppCompatDelegateImpl.this;
        if (((AppCompatDelegateImpl)localObject).A)
        {
          localObject = ((AppCompatDelegateImpl)localObject).l0();
          if ((localObject != null) && (!AppCompatDelegateImpl.this.M)) {
            ((Window.Callback)localObject).onMenuOpened(108, parame);
          }
        }
      }
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */