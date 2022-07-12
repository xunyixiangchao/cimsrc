package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class h
  implements h.e, j, AdapterView.OnItemClickListener
{
  private Rect a;
  
  protected static d A(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (d)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (d)paramListAdapter;
  }
  
  protected static int q(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i = 0;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = paramListAdapter.getCount();
    int j = 0;
    int m = j;
    Object localObject2 = null;
    Object localObject1 = paramViewGroup;
    paramViewGroup = (ViewGroup)localObject2;
    while (i < i3)
    {
      int n = paramListAdapter.getItemViewType(i);
      int k = m;
      if (n != m)
      {
        paramViewGroup = null;
        k = n;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FrameLayout(paramContext);
      }
      paramViewGroup = paramListAdapter.getView(i, paramViewGroup, (ViewGroup)localObject2);
      paramViewGroup.measure(i1, i2);
      n = paramViewGroup.getMeasuredWidth();
      if (n >= paramInt) {
        return paramInt;
      }
      m = j;
      if (n > j) {
        m = n;
      }
      i += 1;
      j = m;
      m = k;
      localObject1 = localObject2;
    }
    return j;
  }
  
  protected static boolean z(e parame)
  {
    int j = parame.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = parame.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void d(Context paramContext, e parame) {}
  
  public int getId()
  {
    return 0;
  }
  
  public boolean k(e parame, g paramg)
  {
    return false;
  }
  
  public boolean l(e parame, g paramg)
  {
    return false;
  }
  
  public abstract void n(e parame);
  
  protected boolean o()
  {
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = A(paramView).a;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (o()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramAdapterView.O(paramView, this, paramInt);
  }
  
  public Rect p()
  {
    return this.a;
  }
  
  public abstract void r(View paramView);
  
  public void s(Rect paramRect)
  {
    this.a = paramRect;
  }
  
  public abstract void t(boolean paramBoolean);
  
  public abstract void u(int paramInt);
  
  public abstract void v(int paramInt);
  
  public abstract void w(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void x(boolean paramBoolean);
  
  public abstract void y(int paramInt);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.h
 * JD-Core Version:    0.7.0.1
 */