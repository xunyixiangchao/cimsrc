package v3;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.z;

public class f
  extends RecyclerView.o
{
  private final int a;
  
  public f(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    int i = paramRecyclerView.e0(paramView);
    if (i == 0) {
      i = this.a;
    }
    for (paramRect.top = i;; paramRect.top = (i / 2))
    {
      paramRect.bottom = (i / 2);
      return;
      if ((i <= 0) || (i >= paramRecyclerView.getAdapter().d() - 1)) {
        break;
      }
      i = this.a;
    }
    if (i == paramRecyclerView.getAdapter().d() - 1)
    {
      i = this.a;
      paramRect.top = (i / 2);
      paramRect.bottom = i;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v3.f
 * JD-Core Version:    0.7.0.1
 */