package x1;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class a
{
  public static void b(View paramView1, View paramView2, d paramd, c... paramVarArgs)
  {
    Activity localActivity = (Activity)paramView1.getContext();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      c(paramVarArgs[i], paramVarArgs, paramView2, paramView1, paramd);
      i += 1;
    }
    if (e(localActivity)) {
      paramView2.setOnTouchListener(new a(paramView1));
    }
  }
  
  private static void c(c paramc, final c[] paramArrayOfc, final View paramView1, View paramView2, final d paramd)
  {
    paramc.b.setOnClickListener(new b(paramView2, paramc.a, paramView1, paramArrayOfc, paramd));
  }
  
  public static void d(View paramView)
  {
    Activity localActivity = (Activity)paramView.getContext();
    View localView = localActivity.getCurrentFocus();
    if (localView != null)
    {
      c.h(localActivity.getCurrentFocus());
      localView.clearFocus();
    }
    paramView.setVisibility(8);
  }
  
  static boolean e(Activity paramActivity)
  {
    return f(e.b(paramActivity), e.c(paramActivity), e.a(paramActivity));
  }
  
  public static boolean f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean1) || ((paramBoolean2) && (!paramBoolean3));
  }
  
  private static void g(View paramView, c[] paramArrayOfc)
  {
    int j = paramArrayOfc.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramArrayOfc[i].a;
      if (localView != paramView) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    paramView.setVisibility(0);
  }
  
  public static void h(View paramView1, View paramView2)
  {
    Activity localActivity = (Activity)paramView1.getContext();
    c.j(paramView2);
    if (e(localActivity)) {
      paramView1.setVisibility(4);
    }
  }
  
  public static void i(View paramView)
  {
    Activity localActivity = (Activity)paramView.getContext();
    paramView.setVisibility(0);
    if (localActivity.getCurrentFocus() != null) {
      c.h(localActivity.getCurrentFocus());
    }
  }
  
  static final class a
    implements View.OnTouchListener
  {
    a(View paramView) {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.a.setVisibility(4);
      }
      return false;
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(View paramView1, View paramView2, View paramView3, a.c[] paramArrayOfc, a.d paramd) {}
    
    public void onClick(View paramView)
    {
      Boolean localBoolean;
      if (this.a.getVisibility() == 0)
      {
        if (this.b.getVisibility() == 0)
        {
          a.h(this.a, paramView1);
          localBoolean = Boolean.FALSE;
        }
        else
        {
          a.a(this.b, paramArrayOfc);
          localBoolean = null;
        }
      }
      else
      {
        a.i(this.a);
        localBoolean = Boolean.TRUE;
        a.a(this.b, paramArrayOfc);
      }
      a.d locald = paramd;
      if ((locald != null) && (localBoolean != null)) {
        locald.c(paramView, localBoolean.booleanValue());
      }
    }
  }
  
  public static class c
  {
    final View a;
    final View b;
    
    public c(View paramView1, View paramView2)
    {
      this.a = paramView1;
      this.b = paramView2;
    }
  }
  
  public static abstract interface d
  {
    public abstract void c(View paramView, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x1.a
 * JD-Core Version:    0.7.0.1
 */