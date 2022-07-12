package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

public final class e
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.e
 * JD-Core Version:    0.7.0.1
 */