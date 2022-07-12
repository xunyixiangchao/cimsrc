package w1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import v1.a;
import x1.d;
import x1.e;

public class c
{
  private int a = -1;
  private final View b;
  private final int c;
  private final boolean d;
  private a e;
  
  public c(View paramView)
  {
    this.b = paramView;
    this.c = d.a(paramView.getContext());
    this.d = e.c((Activity)paramView.getContext());
  }
  
  private a a(View paramView)
  {
    Object localObject = this.e;
    if (localObject != null) {
      return localObject;
    }
    if ((paramView instanceof a))
    {
      paramView = (a)paramView;
      this.e = paramView;
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      for (;;)
      {
        localObject = (ViewGroup)paramView;
        if (i >= ((ViewGroup)localObject).getChildCount()) {
          break;
        }
        localObject = a(((ViewGroup)localObject).getChildAt(i));
        if (localObject != null)
        {
          this.e = ((a)localObject);
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  @TargetApi(16)
  public void b(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.d)
    {
      i = paramInt2;
      if (this.b.getFitsSystemWindows())
      {
        localObject = new Rect();
        this.b.getWindowVisibleDisplayFrame((Rect)localObject);
        i = ((Rect)localObject).bottom - ((Rect)localObject).top;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMeasure, width: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height: ");
    ((StringBuilder)localObject).append(i);
    Log.d("KPSRootLayoutHandler", ((StringBuilder)localObject).toString());
    if (i < 0) {
      return;
    }
    paramInt1 = this.a;
    if (paramInt1 < 0)
    {
      this.a = i;
      return;
    }
    paramInt1 -= i;
    if (paramInt1 == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" == 0 break;");
      Log.d("KPSRootLayoutHandler", ((StringBuilder)localObject).toString());
      return;
    }
    if (Math.abs(paramInt1) == this.c)
    {
      Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", new Object[] { Integer.valueOf(paramInt1) }));
      return;
    }
    this.a = i;
    localObject = a(this.b);
    if (localObject == null)
    {
      Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
      return;
    }
    if (Math.abs(paramInt1) < x1.c.e(this.b.getContext()))
    {
      Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
      return;
    }
    if (paramInt1 > 0)
    {
      ((a)localObject).e();
      return;
    }
    if ((((a)localObject).b()) && (((a)localObject).isVisible())) {
      ((a)localObject).d();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w1.c
 * JD-Core Version:    0.7.0.1
 */