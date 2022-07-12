package k7;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class b
{
  private final View a;
  private boolean b = false;
  private int c = 0;
  
  public b(a parama)
  {
    this.a = ((View)parama);
  }
  
  private void a()
  {
    ViewParent localViewParent = this.a.getParent();
    if ((localViewParent instanceof CoordinatorLayout)) {
      ((CoordinatorLayout)localViewParent).p(this.a);
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d(Bundle paramBundle)
  {
    this.b = paramBundle.getBoolean("expanded", false);
    this.c = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.b) {
      a();
    }
  }
  
  public Bundle e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", this.b);
    localBundle.putInt("expandedComponentIdHint", this.c);
    return localBundle;
  }
  
  public void f(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k7.b
 * JD-Core Version:    0.7.0.1
 */