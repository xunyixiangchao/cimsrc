package v3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.z;
import u3.l;

public class g
  extends RecyclerView.o
{
  private static final int[] e = { 16843284 };
  private Paint a;
  private Drawable b;
  private int c = 1;
  private int d;
  
  public g(Context paramContext, int paramInt)
  {
    this.d = paramInt;
    paramContext = paramContext.obtainStyledAttributes(e);
    this.b = paramContext.getDrawable(0);
    paramContext.recycle();
  }
  
  private void j(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getMeasuredWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < m)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int n = ((View)localObject).getBottom() + localLayoutParams.bottomMargin;
      int i1 = this.c + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(j, n, k, i1);
        this.b.draw(paramCanvas);
      }
      localObject = this.a;
      if (localObject != null) {
        paramCanvas.drawRect(j, n, k, i1, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  private void k(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingTop();
    int k = paramRecyclerView.getMeasuredHeight() - paramRecyclerView.getPaddingBottom();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < m)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int n = ((View)localObject).getRight() + localLayoutParams.rightMargin;
      int i1 = this.c + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(n, j, i1, k);
        this.b.draw(paramCanvas);
      }
      localObject = this.a;
      if (localObject != null) {
        paramCanvas.drawRect(n, j, i1, k, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  public static g l(Context paramContext, float paramFloat)
  {
    paramContext = new g(paramContext, 0);
    paramContext.c = l.p(paramFloat);
    return paramContext;
  }
  
  public static g m(Context paramContext, float paramFloat)
  {
    paramContext = new g(paramContext, 1);
    paramContext.c = l.p(paramFloat);
    return paramContext;
  }
  
  public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    super.e(paramRect, paramView, paramRecyclerView, paramz);
    if (this.d == 1)
    {
      paramRect.set(0, 0, 0, this.c);
      return;
    }
    paramRect.set(0, 0, this.c, 0);
  }
  
  public void g(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    super.g(paramCanvas, paramRecyclerView, paramz);
    if (this.d == 1)
    {
      k(paramCanvas, paramRecyclerView);
      return;
    }
    j(paramCanvas, paramRecyclerView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v3.g
 * JD-Core Version:    0.7.0.1
 */