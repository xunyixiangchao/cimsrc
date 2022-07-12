package u3;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.core.content.b;
import com.google.android.material.badge.a;

public class o
{
  public static void c(View paramView)
  {
    if (paramView != null) {
      paramView.post(new m(paramView));
    }
  }
  
  public static void d(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.post(new n(paramView, paramInt));
    }
  }
  
  public static void e(a parama, View paramView)
  {
    f(parama, paramView, null);
  }
  
  public static void f(a parama, View paramView, FrameLayout paramFrameLayout)
  {
    k(parama, paramView, paramFrameLayout);
    if (parama.h() != null)
    {
      parama.h().setForeground(parama);
      return;
    }
    paramView.getOverlay().add(parama);
  }
  
  public static void g(View paramView)
  {
    a locala = (a)paramView.getTag(2131230820);
    if (locala != null)
    {
      h(locala, paramView);
      paramView.setTag(2131230820, null);
    }
  }
  
  public static void h(a parama, View paramView)
  {
    if (parama == null) {
      return;
    }
    if (parama.h() != null)
    {
      parama.h().setForeground(null);
      return;
    }
    paramView.getOverlay().remove(parama);
  }
  
  public static void k(a parama, View paramView, FrameLayout paramFrameLayout)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    parama.setBounds(localRect);
    parama.G(paramView, paramFrameLayout);
  }
  
  public static void l(View paramView)
  {
    if ((a)paramView.getTag(2131230820) != null) {
      g(paramView);
    }
    a locala = a.c(paramView.getContext());
    locala.x(b.b(paramView.getContext(), 17170454));
    e(locala, paramView);
    paramView.setTag(2131230820, locala);
  }
  
  public static void m(View paramView, int paramInt)
  {
    a locala = (a)paramView.getTag(2131230820);
    if ((paramInt > 0) && (locala == null))
    {
      locala = a.c(paramView.getContext());
      locala.x(b.b(paramView.getContext(), 17170454));
      locala.y(b.b(paramView.getContext(), 17170443));
      locala.z(3);
      locala.A(paramInt);
      e(locala, paramView);
      paramView.setTag(2131230820, locala);
      return;
    }
    if ((paramInt == 0) && (locala != null))
    {
      g(paramView);
      return;
    }
    if (paramInt > 0)
    {
      locala.D(true);
      locala.A(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.o
 * JD-Core Version:    0.7.0.1
 */