package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class i
{
  private final Runnable a;
  private final CopyOnWriteArrayList<k> b = new CopyOnWriteArrayList();
  private final Map<k, Object> c = new HashMap();
  
  public i(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).b(paramMenu, paramMenuInflater);
    }
  }
  
  public boolean b(MenuItem paramMenuItem)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((k)localIterator.next()).a(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.i
 * JD-Core Version:    0.7.0.1
 */