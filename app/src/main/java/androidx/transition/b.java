package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b
{
  private static Method a;
  private static Method b;
  private static boolean c;
  
  @SuppressLint({"SoonBlockedPrivateApi"})
  static void a(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      if (paramBoolean)
      {
        paramCanvas.enableZ();
        return;
      }
      paramCanvas.disableZ();
      return;
    }
    if ((i == 28) || (!c)) {}
    try
    {
      Method localMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
      a = localMethod;
      localMethod.setAccessible(true);
      localMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
      b = localMethod;
      localMethod.setAccessible(true);
      label78:
      c = true;
      if (paramBoolean) {}
      try
      {
        localMethod = a;
        if (localMethod != null) {
          localMethod.invoke(paramCanvas, new Object[0]);
        }
        if (paramBoolean) {
          break label142;
        }
        localMethod = b;
        if (localMethod == null) {
          break label142;
        }
        localMethod.invoke(paramCanvas, new Object[0]);
        return;
      }
      catch (IllegalAccessException paramCanvas)
      {
        return;
      }
      catch (InvocationTargetException paramCanvas)
      {
        label130:
        label142:
        break label130;
      }
      throw new RuntimeException(paramCanvas.getCause());
      return;
      throw new IllegalStateException("This method doesn't work on Pie!");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label78;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.b
 * JD-Core Version:    0.7.0.1
 */