package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class b0
{
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      return paramBoolean;
    }
    catch (AbstractMethodError paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViewParent ");
      localStringBuilder.append(paramViewParent);
      localStringBuilder.append(" does not implement interface method onNestedFling");
      Log.e("ViewParentCompat", localStringBuilder.toString(), paramView);
    }
    return false;
  }
  
  public static boolean b(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    try
    {
      boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      return bool;
    }
    catch (AbstractMethodError paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViewParent ");
      localStringBuilder.append(paramViewParent);
      localStringBuilder.append(" does not implement interface method onNestedPreFling");
      Log.e("ViewParentCompat", localStringBuilder.toString(), paramView);
    }
    return false;
  }
  
  public static void c(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof o))
    {
      ((o)paramViewParent).j(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      return;
    }
    if (paramInt3 == 0) {
      try
      {
        paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("ViewParent ");
        paramArrayOfInt.append(paramViewParent);
        paramArrayOfInt.append(" does not implement interface method onNestedPreScroll");
        Log.e("ViewParentCompat", paramArrayOfInt.toString(), paramView);
      }
    }
  }
  
  public static void d(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).m(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt);
      return;
    }
    paramArrayOfInt[0] += paramInt3;
    paramArrayOfInt[1] += paramInt4;
    if ((paramViewParent instanceof o))
    {
      ((o)paramViewParent).n(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    if (paramInt5 == 0) {
      try
      {
        paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("ViewParent ");
        paramArrayOfInt.append(paramViewParent);
        paramArrayOfInt.append(" does not implement interface method onNestedScroll");
        Log.e("ViewParentCompat", paramArrayOfInt.toString(), paramView);
      }
    }
  }
  
  public static void e(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof o))
    {
      ((o)paramViewParent).c(paramView1, paramView2, paramInt1, paramInt2);
      return;
    }
    if (paramInt2 == 0) {
      try
      {
        paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
        return;
      }
      catch (AbstractMethodError paramView1)
      {
        paramView2 = new StringBuilder();
        paramView2.append("ViewParent ");
        paramView2.append(paramViewParent);
        paramView2.append(" does not implement interface method onNestedScrollAccepted");
        Log.e("ViewParentCompat", paramView2.toString(), paramView1);
      }
    }
  }
  
  public static boolean f(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof o)) {
      return ((o)paramViewParent).o(paramView1, paramView2, paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        paramView2 = new StringBuilder();
        paramView2.append("ViewParent ");
        paramView2.append(paramViewParent);
        paramView2.append(" does not implement interface method onStartNestedScroll");
        Log.e("ViewParentCompat", paramView2.toString(), paramView1);
      }
    }
    return false;
  }
  
  public static void g(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof o))
    {
      ((o)paramViewParent).i(paramView, paramInt);
      return;
    }
    if (paramInt == 0) {
      try
      {
        paramViewParent.onStopNestedScroll(paramView);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ViewParent ");
        localStringBuilder.append(paramViewParent);
        localStringBuilder.append(" does not implement interface method onStopNestedScroll");
        Log.e("ViewParentCompat", localStringBuilder.toString(), paramView);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.b0
 * JD-Core Version:    0.7.0.1
 */