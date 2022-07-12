package q0;

import android.graphics.Paint;
import android.graphics.Rect;
import x0.d;

public final class c
{
  private static final ThreadLocal<d<Rect, Rect>> a = new ThreadLocal();
  
  public static boolean a(Paint paramPaint, String paramString)
  {
    return paramPaint.hasGlyph(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.c
 * JD-Core Version:    0.7.0.1
 */