package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowInsetsController.OnControllableInsetsChangedListener;
import g0.g;

public final class i0
{
  private final e a;
  
  public i0(Window paramWindow, View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 30)
    {
      this.a = new d(paramWindow, this);
      return;
    }
    if (i >= 26) {}
    for (paramWindow = new c(paramWindow, paramView);; paramWindow = new b(paramWindow, paramView))
    {
      this.a = paramWindow;
      return;
    }
  }
  
  private i0(WindowInsetsController paramWindowInsetsController)
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      this.a = new d(paramWindowInsetsController, this);
      return;
    }
    this.a = new e();
  }
  
  public static i0 c(WindowInsetsController paramWindowInsetsController)
  {
    return new i0(paramWindowInsetsController);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  private static class a
    extends i0.e
  {
    protected final Window a;
    private final View b;
    
    a(Window paramWindow, View paramView)
    {
      this.a = paramWindow;
      this.b = paramView;
    }
    
    protected void c(int paramInt)
    {
      View localView = this.a.getDecorView();
      localView.setSystemUiVisibility(paramInt | localView.getSystemUiVisibility());
    }
    
    protected void d(int paramInt)
    {
      this.a.addFlags(paramInt);
    }
    
    protected void e(int paramInt)
    {
      View localView = this.a.getDecorView();
      localView.setSystemUiVisibility(paramInt & localView.getSystemUiVisibility());
    }
    
    protected void f(int paramInt)
    {
      this.a.clearFlags(paramInt);
    }
  }
  
  private static class b
    extends i0.a
  {
    b(Window paramWindow, View paramView)
    {
      super(paramView);
    }
    
    public void b(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        f(67108864);
        d(-2147483648);
        c(8192);
        return;
      }
      e(8192);
    }
  }
  
  private static class c
    extends i0.b
  {
    c(Window paramWindow, View paramView)
    {
      super(paramView);
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        f(134217728);
        d(-2147483648);
        c(16);
        return;
      }
      e(16);
    }
  }
  
  private static class d
    extends i0.e
  {
    final i0 a;
    final WindowInsetsController b;
    private final g<Object, WindowInsetsController.OnControllableInsetsChangedListener> c = new g();
    protected Window d;
    
    d(Window paramWindow, i0 parami0)
    {
      this(paramWindow.getInsetsController(), parami0);
      this.d = paramWindow;
    }
    
    d(WindowInsetsController paramWindowInsetsController, i0 parami0)
    {
      this.b = paramWindowInsetsController;
      this.a = parami0;
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.b.setSystemBarsAppearance(16, 16);
        return;
      }
      this.b.setSystemBarsAppearance(0, 16);
    }
    
    public void b(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (this.d != null) {
          c(8192);
        }
        this.b.setSystemBarsAppearance(8, 8);
        return;
      }
      this.b.setSystemBarsAppearance(0, 8);
    }
    
    protected void c(int paramInt)
    {
      View localView = this.d.getDecorView();
      localView.setSystemUiVisibility(paramInt & localView.getSystemUiVisibility());
    }
  }
  
  private static class e
  {
    public void a(boolean paramBoolean) {}
    
    public void b(boolean paramBoolean) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.i0
 * JD-Core Version:    0.7.0.1
 */