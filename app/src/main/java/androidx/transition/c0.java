package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

class c0
  extends h0
{
  private static boolean c = true;
  
  public void a(View paramView) {}
  
  @SuppressLint({"NewApi"})
  public float b(View paramView)
  {
    if (c) {}
    try
    {
      float f = paramView.getTransitionAlpha();
      return f;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label13:
      break label13;
    }
    c = false;
    return paramView.getAlpha();
  }
  
  public void c(View paramView) {}
  
  @SuppressLint({"NewApi"})
  public void f(View paramView, float paramFloat)
  {
    if (c) {}
    try
    {
      paramView.setTransitionAlpha(paramFloat);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label12:
      break label12;
    }
    c = false;
    paramView.setAlpha(paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.c0
 * JD-Core Version:    0.7.0.1
 */