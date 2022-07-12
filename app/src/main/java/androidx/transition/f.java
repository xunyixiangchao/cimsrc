package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class f
  extends FrameLayout
{
  private ViewGroup a;
  private boolean b;
  
  f(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    setClipChildren(false);
    this.a = paramViewGroup;
    paramViewGroup.setTag(R.id.ghost_view_holder, this);
    y.b(this.a).c(this);
    this.b = true;
  }
  
  static f b(ViewGroup paramViewGroup)
  {
    return (f)paramViewGroup.getTag(R.id.ghost_view_holder);
  }
  
  private int c(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = getChildCount() - 1;
    int j = 0;
    while (j <= i)
    {
      int k = (j + i) / 2;
      d(((h)getChildAt(k)).c, localArrayList);
      if (f(paramArrayList, localArrayList)) {
        j = k + 1;
      } else {
        i = k - 1;
      }
      localArrayList.clear();
    }
    return j;
  }
  
  private static void d(View paramView, ArrayList<View> paramArrayList)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      d((View)localViewParent, paramArrayList);
    }
    paramArrayList.add(paramView);
  }
  
  private static boolean e(View paramView1, View paramView2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
    int j = localViewGroup.getChildCount();
    float f1 = paramView1.getZ();
    float f2 = paramView2.getZ();
    boolean bool = false;
    if (f1 != f2)
    {
      if (paramView1.getZ() > paramView2.getZ()) {
        bool = true;
      }
      return bool;
    }
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(y.a(localViewGroup, i));
      if (localView == paramView1) {
        return false;
      }
      if (localView == paramView2) {
        break;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean f(ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    boolean bool3 = paramArrayList1.isEmpty();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!paramArrayList2.isEmpty())
      {
        if (paramArrayList1.get(0) != paramArrayList2.get(0)) {
          return true;
        }
        int j = Math.min(paramArrayList1.size(), paramArrayList2.size());
        int i = 1;
        while (i < j)
        {
          View localView1 = (View)paramArrayList1.get(i);
          View localView2 = (View)paramArrayList2.get(i);
          if (localView1 != localView2) {
            return e(localView1, localView2);
          }
          i += 1;
        }
        if (paramArrayList2.size() == j) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  void a(h paramh)
  {
    ArrayList localArrayList = new ArrayList();
    d(paramh.c, localArrayList);
    int i = c(localArrayList);
    if ((i >= 0) && (i < getChildCount()))
    {
      addView(paramh, i);
      return;
    }
    addView(paramh);
  }
  
  void g()
  {
    if (this.b)
    {
      y.b(this.a).d(this);
      y.b(this.a).c(this);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  public void onViewAdded(View paramView)
  {
    if (this.b)
    {
      super.onViewAdded(paramView);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (((getChildCount() == 1) && (getChildAt(0) == paramView)) || (getChildCount() == 0))
    {
      this.a.setTag(R.id.ghost_view_holder, null);
      y.b(this.a).d(this);
      this.b = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.f
 * JD-Core Version:    0.7.0.1
 */