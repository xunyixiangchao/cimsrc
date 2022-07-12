package androidx.core.widget;

import android.widget.ListView;

public final class j
{
  public static boolean a(ListView paramListView, int paramInt)
  {
    return paramListView.canScrollList(paramInt);
  }
  
  public static void b(ListView paramListView, int paramInt)
  {
    paramListView.scrollListBy(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.j
 * JD-Core Version:    0.7.0.1
 */