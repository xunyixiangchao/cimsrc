package androidx.core.view;

import android.view.MotionEvent;

public final class l
{
  public static boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    return (paramMotionEvent.getSource() & paramInt) == paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.l
 * JD-Core Version:    0.7.0.1
 */