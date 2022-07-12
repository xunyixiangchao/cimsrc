package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.R.attr;
import androidx.core.view.f;
import androidx.core.view.f.a;
import g.b;
import g.b.a;

public class e
  extends Dialog
  implements c
{
  private d a;
  private final f.a b = new a();
  
  public e(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext, b(paramContext, paramInt));
    d locald = a();
    locald.J(b(paramContext, paramInt));
    locald.t(null);
  }
  
  private static int b(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(R.attr.dialogTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
    }
    return i;
  }
  
  public d a()
  {
    if (this.a == null) {
      this.a = d.j(this, this);
    }
    return this.a;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().d(paramView, paramLayoutParams);
  }
  
  boolean c(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean d(int paramInt)
  {
    return a().C(paramInt);
  }
  
  public void dismiss()
  {
    super.dismiss();
    a().u();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return f.e(this.b, localView, this, paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return a().k(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().r();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a().q();
    super.onCreate(paramBundle);
    a().t(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    a().z();
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    a().E(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().F(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().G(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().K(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().K(paramCharSequence);
  }
  
  class a
    implements f.a
  {
    a() {}
    
    public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return e.this.c(paramKeyEvent);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.e
 * JD-Core Version:    0.7.0.1
 */