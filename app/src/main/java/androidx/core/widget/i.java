package androidx.core.widget;

import android.view.View;
import android.widget.ListView;

public class i
  extends a
{
  private final ListView s;
  
  public i(ListView paramListView)
  {
    super(paramListView);
    this.s = paramListView;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    ListView localListView = this.s;
    int i = localListView.getCount();
    if (i == 0) {
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight())) {
        return false;
      }
    }
    else
    {
      if (paramInt >= 0) {
        break label89;
      }
      if ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0)) {
        return false;
      }
    }
    return true;
    label89:
    return false;
  }
  
  public void j(int paramInt1, int paramInt2)
  {
    j.b(this.s, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.i
 * JD-Core Version:    0.7.0.1
 */