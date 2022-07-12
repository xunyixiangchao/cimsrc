package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.p;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class a
{
  private static final ViewGroup.MarginLayoutParams b;
  private LinearLayoutManager a;
  
  static
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
    b = localMarginLayoutParams;
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
  }
  
  a(LinearLayoutManager paramLinearLayoutManager)
  {
    this.a = paramLinearLayoutManager;
  }
  
  private boolean a()
  {
    int n = this.a.J();
    if (n == 0) {
      return true;
    }
    if (this.a.l2() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
    int j = 0;
    while (j < n)
    {
      View localView = this.a.I(j);
      if (localView != null)
      {
        Object localObject = localView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
        } else {
          localObject = b;
        }
        int[] arrayOfInt1 = arrayOfInt[j];
        int k;
        int m;
        if (i != 0)
        {
          k = localView.getLeft();
          m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        else
        {
          k = localView.getTop();
          m = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        }
        arrayOfInt1[0] = (k - m);
        arrayOfInt1 = arrayOfInt[j];
        if (i != 0)
        {
          k = localView.getRight();
          m = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        else
        {
          k = localView.getBottom();
          m = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        }
        arrayOfInt1[1] = (k + m);
        j += 1;
      }
      else
      {
        throw new IllegalStateException("null view contained in the view hierarchy");
      }
    }
    Arrays.sort(arrayOfInt, new a());
    int i = 1;
    while (i < n)
    {
      if (arrayOfInt[(i - 1)][1] != arrayOfInt[i][0]) {
        return false;
      }
      i += 1;
    }
    i = arrayOfInt[0][1];
    j = arrayOfInt[0][0];
    if (arrayOfInt[0][0] <= 0) {
      return arrayOfInt[(n - 1)][1] >= i - j;
    }
    return false;
  }
  
  private boolean b()
  {
    int j = this.a.J();
    int i = 0;
    while (i < j)
    {
      if (c(this.a.I(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      LayoutTransition localLayoutTransition = paramView.getLayoutTransition();
      if ((localLayoutTransition != null) && (localLayoutTransition.isChangingLayout())) {
        return true;
      }
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (c(paramView.getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  boolean d()
  {
    return ((!a()) || (this.a.J() <= 1)) && (b());
  }
  
  class a
    implements Comparator<int[]>
  {
    a() {}
    
    public int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      return paramArrayOfInt1[0] - paramArrayOfInt2[0];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.widget.a
 * JD-Core Version:    0.7.0.1
 */