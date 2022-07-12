package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R.styleable;
import g.b;
import g.b.a;

public abstract class ActionBar
{
  public boolean g()
  {
    return false;
  }
  
  public abstract boolean h();
  
  public abstract void i(boolean paramBoolean);
  
  public abstract int j();
  
  public abstract Context k();
  
  public abstract void l();
  
  public boolean m()
  {
    return false;
  }
  
  public void n(Configuration paramConfiguration) {}
  
  void o() {}
  
  public abstract boolean p(int paramInt, KeyEvent paramKeyEvent);
  
  public boolean q(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean r()
  {
    return false;
  }
  
  public abstract void s(boolean paramBoolean);
  
  public abstract void t(boolean paramBoolean);
  
  public abstract void u(boolean paramBoolean);
  
  public abstract void v(boolean paramBoolean);
  
  public abstract void w(CharSequence paramCharSequence);
  
  public abstract void x();
  
  public b y(b.a parama)
  {
    return null;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.a = 0;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      this.a = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.a = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = 0;
      this.a = paramLayoutParams.a;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  @Deprecated
  public static abstract class b
  {
    public abstract CharSequence a();
    
    public abstract View b();
    
    public abstract Drawable c();
    
    public abstract CharSequence d();
    
    public abstract void e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */