package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class f
  extends RecyclerView.o
{
  private static final int[] d = { 16843284 };
  private Drawable a;
  private int b;
  private final Rect c = new Rect();
  
  public f(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(d);
    Drawable localDrawable = paramContext.getDrawable(0);
    this.a = localDrawable;
    if (localDrawable == null) {
      Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    }
    paramContext.recycle();
    l(paramInt);
  }
  
  private void j(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      i = paramRecyclerView.getPaddingTop();
      j = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), i, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), j);
    }
    else
    {
      j = paramRecyclerView.getHeight();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.getLayoutManager().P(localView, this.c);
      int n = this.c.right + Math.round(localView.getTranslationX());
      int i1 = this.a.getIntrinsicWidth();
      this.a.setBounds(n - i1, i, n, j);
      this.a.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  private void k(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      i = paramRecyclerView.getPaddingLeft();
      j = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(i, paramRecyclerView.getPaddingTop(), j, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    }
    else
    {
      j = paramRecyclerView.getWidth();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.i0(localView, this.c);
      int n = this.c.bottom + Math.round(localView.getTranslationY());
      int i1 = this.a.getIntrinsicHeight();
      this.a.setBounds(i, n - i1, j, n);
      this.a.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    paramView = this.a;
    if (paramView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.b == 1)
    {
      paramRect.set(0, 0, 0, paramView.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, paramView.getIntrinsicWidth(), 0);
  }
  
  public void g(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    if (paramRecyclerView.getLayoutManager() != null)
    {
      if (this.a == null) {
        return;
      }
      if (this.b == 1)
      {
        k(paramCanvas, paramRecyclerView);
        return;
      }
      j(paramCanvas, paramRecyclerView);
    }
  }
  
  public void l(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
    this.b = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.f
 * JD-Core Version:    0.7.0.1
 */