package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import androidx.core.view.x;

@SuppressLint({"ViewConstructor"})
class h
  extends ViewGroup
  implements e
{
  ViewGroup a;
  View b;
  final View c;
  int d;
  private Matrix e;
  private final ViewTreeObserver.OnPreDrawListener f = new a();
  
  h(View paramView)
  {
    super(paramView.getContext());
    this.c = paramView;
    setWillNotDraw(false);
    setLayerType(2, null);
  }
  
  static h b(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      f localf1 = f.b(paramViewGroup);
      h localh = e(paramView);
      int j = 0;
      Object localObject = localh;
      int i = j;
      if (localh != null)
      {
        f localf2 = (f)localh.getParent();
        localObject = localh;
        i = j;
        if (localf2 != localf1)
        {
          i = localh.d;
          localf2.removeView(localh);
          localObject = null;
        }
      }
      if (localObject == null)
      {
        localObject = paramMatrix;
        if (paramMatrix == null)
        {
          localObject = new Matrix();
          c(paramView, paramViewGroup, (Matrix)localObject);
        }
        paramMatrix = new h(paramView);
        paramMatrix.h((Matrix)localObject);
        if (localf1 == null)
        {
          paramView = new f(paramViewGroup);
        }
        else
        {
          localf1.g();
          paramView = localf1;
        }
        d(paramViewGroup, paramView);
        d(paramViewGroup, paramMatrix);
        paramView.a(paramMatrix);
        paramMatrix.d = i;
        paramView = paramMatrix;
      }
      else
      {
        paramView = (View)localObject;
        if (paramMatrix != null)
        {
          ((h)localObject).h(paramMatrix);
          paramView = (View)localObject;
        }
      }
      paramView.d += 1;
      return paramView;
    }
    throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
  }
  
  static void c(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramMatrix.reset();
    b0.j(paramView, paramMatrix);
    paramMatrix.preTranslate(-paramView.getScrollX(), -paramView.getScrollY());
    b0.k(paramViewGroup, paramMatrix);
  }
  
  static void d(View paramView1, View paramView2)
  {
    b0.g(paramView2, paramView2.getLeft(), paramView2.getTop(), paramView2.getLeft() + paramView1.getWidth(), paramView2.getTop() + paramView1.getHeight());
  }
  
  static h e(View paramView)
  {
    return (h)paramView.getTag(R.id.ghost_view);
  }
  
  static void f(View paramView)
  {
    paramView = e(paramView);
    if (paramView != null)
    {
      int i = paramView.d - 1;
      paramView.d = i;
      if (i <= 0) {
        ((f)paramView.getParent()).removeView(paramView);
      }
    }
  }
  
  static void g(View paramView, h paramh)
  {
    paramView.setTag(R.id.ghost_view, paramh);
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    this.a = paramViewGroup;
    this.b = paramView;
  }
  
  void h(Matrix paramMatrix)
  {
    this.e = paramMatrix;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g(this.c, this);
    this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
    b0.i(this.c, 4);
    if (this.c.getParent() != null) {
      ((View)this.c.getParent()).invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
    b0.i(this.c, 0);
    g(this.c, null);
    if (this.c.getParent() != null) {
      ((View)this.c.getParent()).invalidate();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b.a(paramCanvas, true);
    paramCanvas.setMatrix(this.e);
    b0.i(this.c, 0);
    this.c.invalidate();
    b0.i(this.c, 4);
    drawChild(paramCanvas, this.c, getDrawingTime());
    b.a(paramCanvas, false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (e(this.c) == this)
    {
      if (paramInt == 0) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      b0.i(this.c, paramInt);
    }
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      x.h0(h.this);
      Object localObject2 = h.this;
      Object localObject1 = ((h)localObject2).a;
      if (localObject1 != null)
      {
        localObject2 = ((h)localObject2).b;
        if (localObject2 != null)
        {
          ((ViewGroup)localObject1).endViewTransition((View)localObject2);
          x.h0(h.this.a);
          localObject1 = h.this;
          ((h)localObject1).a = null;
          ((h)localObject1).b = null;
        }
      }
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.h
 * JD-Core Version:    0.7.0.1
 */