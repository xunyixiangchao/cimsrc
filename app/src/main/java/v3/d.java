package v3;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.z;
import u3.l;

public class d
  extends RecyclerView.o
{
  private final int a = l.p(3.0F);
  
  public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    int i = paramRecyclerView.e0(paramView);
    if (!(paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
      return;
    }
    int j = ((GridLayoutManager)paramRecyclerView.getLayoutManager()).V2();
    int k = this.a;
    paramRect.bottom = k;
    if (i % j != 0) {
      paramRect.left = k;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v3.d
 * JD-Core Version:    0.7.0.1
 */