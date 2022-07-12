package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

class h0
{
  private static Field a;
  private static boolean b;
  
  public void a(View paramView)
  {
    throw null;
  }
  
  public float b(View paramView)
  {
    throw null;
  }
  
  public void c(View paramView)
  {
    throw null;
  }
  
  public void d(View paramView, Matrix paramMatrix)
  {
    throw null;
  }
  
  public void e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw null;
  }
  
  public void f(View paramView, float paramFloat)
  {
    throw null;
  }
  
  public void g(View paramView, int paramInt)
  {
    if (!b) {}
    try
    {
      localField = View.class.getDeclaredField("mViewFlags");
      a = localField;
      localField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          Field localField;
          int i = localField.getInt(paramView);
          a.setInt(paramView, paramInt | i & 0xFFFFFFF3);
          return;
        }
        catch (IllegalAccessException paramView) {}
        localNoSuchFieldException = localNoSuchFieldException;
      }
    }
    Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
    b = true;
    localField = a;
    if (localField != null) {}
  }
  
  public void h(View paramView, Matrix paramMatrix)
  {
    throw null;
  }
  
  public void i(View paramView, Matrix paramMatrix)
  {
    throw null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.h0
 * JD-Core Version:    0.7.0.1
 */