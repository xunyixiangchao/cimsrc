package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.k0;

public final class ExpandedMenuView
  extends ListView
  implements e.b, k, AdapterView.OnItemClickListener
{
  private static final int[] c = { 16842964, 16843049 };
  private e a;
  private int b;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = k0.v(paramContext, paramAttributeSet, c, paramInt, 0);
    if (paramContext.s(0)) {
      setBackgroundDrawable(paramContext.g(0));
    }
    if (paramContext.s(1)) {
      setDivider(paramContext.g(1));
    }
    paramContext.w();
  }
  
  public boolean a(g paramg)
  {
    return this.a.N(paramg, 0);
  }
  
  public void b(e parame)
  {
    this.a = parame;
  }
  
  public int getWindowAnimations()
  {
    return this.b;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((g)getAdapter().getItem(paramInt));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */