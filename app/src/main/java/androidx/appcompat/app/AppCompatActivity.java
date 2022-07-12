package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q0;
import androidx.core.app.e;
import androidx.core.app.o;
import androidx.core.app.o.a;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.b;
import g.b.a;

public class AppCompatActivity
  extends FragmentActivity
  implements c, o.a
{
  private static final String DELEGATE_TAG = "androidx:appcompat";
  private d mDelegate;
  private Resources mResources;
  
  public AppCompatActivity()
  {
    initDelegate();
  }
  
  public AppCompatActivity(int paramInt)
  {
    super(paramInt);
    initDelegate();
  }
  
  private void initDelegate()
  {
    getSavedStateRegistry().d("androidx:appcompat", new a());
    addOnContextAvailableListener(new b());
  }
  
  private void initViewTreeOwners()
  {
    b0.a(getWindow().getDecorView(), this);
    c0.a(getWindow().getDecorView(), this);
    androidx.savedstate.c.a(getWindow().getDecorView(), this);
  }
  
  private boolean performMenuItemShortcut(KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    getDelegate().d(paramView, paramLayoutParams);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(getDelegate().h(paramContext));
  }
  
  public void closeOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.g()))) {
      super.closeOptionsMenu();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    ActionBar localActionBar = getSupportActionBar();
    if ((i == 82) && (localActionBar != null) && (localActionBar.q(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().k(paramInt);
  }
  
  public d getDelegate()
  {
    if (this.mDelegate == null) {
      this.mDelegate = d.i(this, this);
    }
    return this.mDelegate;
  }
  
  public a getDrawerToggleDelegate()
  {
    return getDelegate().m();
  }
  
  public MenuInflater getMenuInflater()
  {
    return getDelegate().o();
  }
  
  public Resources getResources()
  {
    if ((this.mResources == null) && (q0.d())) {
      this.mResources = new q0(this, super.getResources());
    }
    Resources localResources2 = this.mResources;
    Resources localResources1 = localResources2;
    if (localResources2 == null) {
      localResources1 = super.getResources();
    }
    return localResources1;
  }
  
  public ActionBar getSupportActionBar()
  {
    return getDelegate().p();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return e.a(this);
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().r();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
    getDelegate().s(paramConfiguration);
  }
  
  public void onContentChanged()
  {
    onSupportContentChanged();
  }
  
  public void onCreateSupportNavigateUpTaskStack(o paramo)
  {
    paramo.b(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().u();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (performMenuItemShortcut(paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.j() & 0x4) != 0)) {
      return onSupportNavigateUp();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  protected void onNightModeChanged(int paramInt) {}
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().v(paramBundle);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().w();
  }
  
  public void onPrepareSupportNavigateUpTaskStack(o paramo) {}
  
  protected void onStart()
  {
    super.onStart();
    getDelegate().y();
  }
  
  protected void onStop()
  {
    super.onStop();
    getDelegate().z();
  }
  
  public void onSupportActionModeFinished(g.b paramb) {}
  
  public void onSupportActionModeStarted(g.b paramb) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null) {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = o.d(this);
        onCreateSupportNavigateUpTaskStack((o)localObject);
        onPrepareSupportNavigateUpTaskStack((o)localObject);
        ((o)localObject).e();
      }
    }
    try
    {
      androidx.core.app.a.k(this);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label43:
      break label43;
    }
    finish();
    break label55;
    supportNavigateUpTo((Intent)localObject);
    label55:
    return true;
    return false;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().K(paramCharSequence);
  }
  
  public g.b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void openOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.r()))) {
      super.openOptionsMenu();
    }
  }
  
  public void setContentView(int paramInt)
  {
    initViewTreeOwners();
    getDelegate().E(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    initViewTreeOwners();
    getDelegate().F(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    getDelegate().G(paramView, paramLayoutParams);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().I(paramToolbar);
  }
  
  @Deprecated
  public void setSupportProgress(int paramInt) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean) {}
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    getDelegate().J(paramInt);
  }
  
  public g.b startSupportActionMode(b.a parama)
  {
    return getDelegate().L(parama);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    getDelegate().r();
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    e.e(this, paramIntent);
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().C(paramInt);
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    return e.f(this, paramIntent);
  }
  
  class a
    implements SavedStateRegistry.b
  {
    a() {}
    
    public Bundle a()
    {
      Bundle localBundle = new Bundle();
      AppCompatActivity.this.getDelegate().x(localBundle);
      return localBundle;
    }
  }
  
  class b
    implements a.b
  {
    b() {}
    
    public void a(Context paramContext)
    {
      paramContext = AppCompatActivity.this.getDelegate();
      paramContext.q();
      paramContext.t(AppCompatActivity.this.getSavedStateRegistry().a("androidx:appcompat"));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.AppCompatActivity
 * JD-Core Version:    0.7.0.1
 */