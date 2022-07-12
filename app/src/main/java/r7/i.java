package r7;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.t;

public class i
{
  static d a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return b();
      }
      return new e();
    }
    return new l();
  }
  
  static d b()
  {
    return new l();
  }
  
  static f c()
  {
    return new f();
  }
  
  public static void d(View paramView, float paramFloat)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof h)) {
      ((h)paramView).a0(paramFloat);
    }
  }
  
  public static void e(View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable instanceof h)) {
      f(paramView, (h)localDrawable);
    }
  }
  
  public static void f(View paramView, h paramh)
  {
    if (paramh.S()) {
      paramh.f0(t.h(paramView));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.i
 * JD-Core Version:    0.7.0.1
 */