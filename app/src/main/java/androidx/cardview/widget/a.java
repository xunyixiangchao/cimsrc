package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class a
  implements c
{
  private d p(b paramb)
  {
    return (d)paramb.f();
  }
  
  public float a(b paramb)
  {
    return p(paramb).c();
  }
  
  public ColorStateList b(b paramb)
  {
    return p(paramb).b();
  }
  
  public void c(b paramb, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramb.c(new d(paramColorStateList, paramFloat1));
    paramContext = paramb.b();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    o(paramb, paramFloat3);
  }
  
  public void d(b paramb, float paramFloat)
  {
    p(paramb).h(paramFloat);
  }
  
  public float e(b paramb)
  {
    return paramb.b().getElevation();
  }
  
  public void f(b paramb)
  {
    if (!paramb.e())
    {
      paramb.a(0, 0, 0, 0);
      return;
    }
    float f1 = a(paramb);
    float f2 = h(paramb);
    int i = (int)Math.ceil(e.a(f1, f2, paramb.d()));
    int j = (int)Math.ceil(e.b(f1, f2, paramb.d()));
    paramb.a(i, j, i, j);
  }
  
  public void g() {}
  
  public float h(b paramb)
  {
    return p(paramb).d();
  }
  
  public float i(b paramb)
  {
    return h(paramb) * 2.0F;
  }
  
  public float j(b paramb)
  {
    return h(paramb) * 2.0F;
  }
  
  public void k(b paramb)
  {
    o(paramb, a(paramb));
  }
  
  public void l(b paramb, float paramFloat)
  {
    paramb.b().setElevation(paramFloat);
  }
  
  public void m(b paramb)
  {
    o(paramb, a(paramb));
  }
  
  public void n(b paramb, ColorStateList paramColorStateList)
  {
    p(paramb).f(paramColorStateList);
  }
  
  public void o(b paramb, float paramFloat)
  {
    p(paramb).g(paramFloat, paramb.e(), paramb.d());
    f(paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.cardview.widget.a
 * JD-Core Version:    0.7.0.1
 */