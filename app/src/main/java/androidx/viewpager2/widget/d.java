package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.p;
import java.util.Locale;

final class d
  extends ViewPager2.i
{
  private final LinearLayoutManager a;
  private ViewPager2.k b;
  
  d(LinearLayoutManager paramLinearLayoutManager)
  {
    this.a = paramLinearLayoutManager;
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    paramFloat = -paramFloat;
    paramInt2 = 0;
    while (paramInt2 < this.a.J())
    {
      View localView = this.a.I(paramInt2);
      if (localView != null)
      {
        float f = this.a.h0(localView) - paramInt1;
        this.b.a(localView, f + paramFloat);
        paramInt2 += 1;
      }
      else
      {
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.a.J()) }));
      }
    }
  }
  
  public void c(int paramInt) {}
  
  ViewPager2.k d()
  {
    return this.b;
  }
  
  void e(ViewPager2.k paramk)
  {
    this.b = paramk;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.widget.d
 * JD-Core Version:    0.7.0.1
 */