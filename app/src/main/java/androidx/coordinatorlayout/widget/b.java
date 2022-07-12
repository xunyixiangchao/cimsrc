package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class b
{
  private static final ThreadLocal<Matrix> a = new ThreadLocal();
  private static final ThreadLocal<RectF> b = new ThreadLocal();
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    c(paramViewGroup, paramView, paramRect);
  }
  
  private static void b(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if (((localObject instanceof View)) && (localObject != paramViewParent))
    {
      localObject = (View)localObject;
      b(paramViewParent, (View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity()) {
      paramMatrix.preConcat(paramView.getMatrix());
    }
  }
  
  static void c(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    ThreadLocal localThreadLocal = a;
    Matrix localMatrix = (Matrix)localThreadLocal.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      localThreadLocal.set(localMatrix);
    }
    else
    {
      localMatrix.reset();
    }
    b(paramViewGroup, paramView, localMatrix);
    localThreadLocal = b;
    paramView = (RectF)localThreadLocal.get();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new RectF();
      localThreadLocal.set(paramViewGroup);
    }
    paramViewGroup.set(paramRect);
    localMatrix.mapRect(paramViewGroup);
    paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.coordinatorlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */