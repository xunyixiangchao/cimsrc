package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R.attr;

public class b
  extends e
{
  final AlertController c = new AlertController(getContext(), this, getWindow());
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, f(paramContext, paramInt));
  }
  
  static int f(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) >= 1) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public ListView e()
  {
    return this.c.d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c.e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.c.f(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.c.g(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.c.p(paramCharSequence);
  }
  
  public static class a
  {
    private final AlertController.b a;
    private final int b;
    
    public a(Context paramContext)
    {
      this(paramContext, b.f(paramContext, 0));
    }
    
    public a(Context paramContext, int paramInt)
    {
      this.a = new AlertController.b(new ContextThemeWrapper(paramContext, b.f(paramContext, paramInt)));
      this.b = paramInt;
    }
    
    public b a()
    {
      b localb = new b(this.a.a, this.b);
      this.a.a(localb.c);
      localb.setCancelable(this.a.r);
      if (this.a.r) {
        localb.setCanceledOnTouchOutside(true);
      }
      localb.setOnCancelListener(this.a.s);
      localb.setOnDismissListener(this.a.t);
      DialogInterface.OnKeyListener localOnKeyListener = this.a.u;
      if (localOnKeyListener != null) {
        localb.setOnKeyListener(localOnKeyListener);
      }
      return localb;
    }
    
    public Context b()
    {
      return this.a.a;
    }
    
    public a c(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.b localb = this.a;
      localb.w = paramListAdapter;
      localb.x = paramOnClickListener;
      return this;
    }
    
    public a d(View paramView)
    {
      this.a.g = paramView;
      return this;
    }
    
    public a e(Drawable paramDrawable)
    {
      this.a.d = paramDrawable;
      return this;
    }
    
    public a f(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      this.a.u = paramOnKeyListener;
      return this;
    }
    
    public a g(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.b localb = this.a;
      localb.w = paramListAdapter;
      localb.x = paramOnClickListener;
      localb.I = paramInt;
      localb.H = true;
      return this;
    }
    
    public a h(CharSequence paramCharSequence)
    {
      this.a.f = paramCharSequence;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.b
 * JD-Core Version:    0.7.0.1
 */