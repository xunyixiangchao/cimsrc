package g7;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import o7.b;

public class a
{
  public static int a(int paramInt1, int paramInt2)
  {
    return q0.a.o(paramInt1, Color.alpha(paramInt1) * paramInt2 / 255);
  }
  
  public static int b(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = b.a(paramContext, paramInt1);
    if (paramContext != null) {
      return paramContext.data;
    }
    return paramInt2;
  }
  
  public static int c(Context paramContext, int paramInt, String paramString)
  {
    return b.d(paramContext, paramInt, paramString);
  }
  
  public static int d(View paramView, int paramInt)
  {
    return b.e(paramView, paramInt);
  }
  
  public static int e(View paramView, int paramInt1, int paramInt2)
  {
    return b(paramView.getContext(), paramInt1, paramInt2);
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt != 0) && (q0.a.e(paramInt) > 0.5D);
  }
  
  public static int g(int paramInt1, int paramInt2)
  {
    return q0.a.j(paramInt2, paramInt1);
  }
  
  public static int h(int paramInt1, int paramInt2, float paramFloat)
  {
    return g(paramInt1, q0.a.o(paramInt2, Math.round(Color.alpha(paramInt2) * paramFloat)));
  }
  
  public static int i(View paramView, int paramInt1, int paramInt2, float paramFloat)
  {
    return h(d(paramView, paramInt1), d(paramView, paramInt2), paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g7.a
 * JD-Core Version:    0.7.0.1
 */