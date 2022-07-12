package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import androidx.core.view.x;

class b0
{
  private static final h0 a;
  static final Property<View, Float> b = new a(Float.class, "translationAlpha");
  static final Property<View, Rect> c = new b(Rect.class, "clipBounds");
  
  static
  {
    if (Build.VERSION.SDK_INT >= 29) {}
    for (Object localObject = new g0();; localObject = new f0())
    {
      a = (h0)localObject;
      break;
    }
  }
  
  static void a(View paramView)
  {
    a.a(paramView);
  }
  
  static a0 b(View paramView)
  {
    return new z(paramView);
  }
  
  static float c(View paramView)
  {
    return a.b(paramView);
  }
  
  static j0 d(View paramView)
  {
    return new i0(paramView);
  }
  
  static void e(View paramView)
  {
    a.c(paramView);
  }
  
  static void f(View paramView, Matrix paramMatrix)
  {
    a.d(paramView, paramMatrix);
  }
  
  static void g(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.e(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void h(View paramView, float paramFloat)
  {
    a.f(paramView, paramFloat);
  }
  
  static void i(View paramView, int paramInt)
  {
    a.g(paramView, paramInt);
  }
  
  static void j(View paramView, Matrix paramMatrix)
  {
    a.h(paramView, paramMatrix);
  }
  
  static void k(View paramView, Matrix paramMatrix)
  {
    a.i(paramView, paramMatrix);
  }
  
  static final class a
    extends Property<View, Float>
  {
    a(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Float a(View paramView)
    {
      return Float.valueOf(b0.c(paramView));
    }
    
    public void b(View paramView, Float paramFloat)
    {
      b0.h(paramView, paramFloat.floatValue());
    }
  }
  
  static final class b
    extends Property<View, Rect>
  {
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Rect a(View paramView)
    {
      return x.u(paramView);
    }
    
    public void b(View paramView, Rect paramRect)
    {
      x.x0(paramView, paramRect);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.b0
 * JD-Core Version:    0.7.0.1
 */