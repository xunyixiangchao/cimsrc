package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.Method;

public class y
  extends ListPopupWindow
  implements x
{
  private static Method L;
  private x K;
  
  static
  {
    try
    {
      if (Build.VERSION.SDK_INT > 28) {
        break label37;
      }
      L = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label29:
      label37:
      break label29;
    }
    Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void R(Object paramObject)
  {
    this.G.setEnterTransition((Transition)paramObject);
  }
  
  public void S(Object paramObject)
  {
    this.G.setExitTransition((Transition)paramObject);
  }
  
  public void T(x paramx)
  {
    this.K = paramx;
  }
  
  public void U(boolean paramBoolean)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT <= 28)
    {
      localMethod = L;
      if (localMethod == null) {
        break label54;
      }
    }
    try
    {
      localMethod.invoke(this.G, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
    return;
    this.G.setTouchModal(paramBoolean);
    label54:
  }
  
  public void e(e parame, MenuItem paramMenuItem)
  {
    x localx = this.K;
    if (localx != null) {
      localx.e(parame, paramMenuItem);
    }
  }
  
  public void f(e parame, MenuItem paramMenuItem)
  {
    x localx = this.K;
    if (localx != null) {
      localx.f(parame, paramMenuItem);
    }
  }
  
  u s(Context paramContext, boolean paramBoolean)
  {
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public static class a
    extends u
  {
    final int o;
    final int p;
    private x q;
    private MenuItem r;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      if (1 == paramContext.getResources().getConfiguration().getLayoutDirection())
      {
        this.o = 21;
        this.p = 22;
        return;
      }
      this.o = 22;
      this.p = 21;
    }
    
    public boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      if (this.q != null)
      {
        Object localObject1 = getAdapter();
        int i;
        if ((localObject1 instanceof HeaderViewListAdapter))
        {
          localObject1 = (HeaderViewListAdapter)localObject1;
          i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
          localObject1 = ((HeaderViewListAdapter)localObject1).getWrappedAdapter();
        }
        else
        {
          i = 0;
        }
        Object localObject2 = (d)localObject1;
        MenuItem localMenuItem = null;
        localObject1 = localMenuItem;
        if (paramMotionEvent.getAction() != 10)
        {
          int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          localObject1 = localMenuItem;
          if (j != -1)
          {
            i = j - i;
            localObject1 = localMenuItem;
            if (i >= 0)
            {
              localObject1 = localMenuItem;
              if (i < ((d)localObject2).getCount()) {
                localObject1 = ((d)localObject2).c(i);
              }
            }
          }
        }
        localMenuItem = this.r;
        if (localMenuItem != localObject1)
        {
          localObject2 = ((d)localObject2).b();
          if (localMenuItem != null) {
            this.q.f((e)localObject2, localMenuItem);
          }
          this.r = ((MenuItem)localObject1);
          if (localObject1 != null) {
            this.q.e((e)localObject2, (MenuItem)localObject1);
          }
        }
      }
      return super.onHoverEvent(paramMotionEvent);
    }
    
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      Object localObject = (ListMenuItemView)getSelectedView();
      if ((localObject != null) && (paramInt == this.o))
      {
        if ((((LinearLayout)localObject).isEnabled()) && (((ListMenuItemView)localObject).getItemData().hasSubMenu())) {
          performItemClick((View)localObject, getSelectedItemPosition(), getSelectedItemId());
        }
        return true;
      }
      if ((localObject != null) && (paramInt == this.p))
      {
        setSelection(-1);
        localObject = getAdapter();
        paramKeyEvent = (KeyEvent)localObject;
        if ((localObject instanceof HeaderViewListAdapter)) {
          paramKeyEvent = ((HeaderViewListAdapter)localObject).getWrappedAdapter();
        }
        ((d)paramKeyEvent).b().e(false);
        return true;
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    
    public void setHoverListener(x paramx)
    {
      this.q = paramx;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.y
 * JD-Core Version:    0.7.0.1
 */