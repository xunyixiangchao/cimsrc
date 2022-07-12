package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class q0
  extends b0
{
  private static boolean c = false;
  private final WeakReference<Context> b;
  
  public q0(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.b = new WeakReference(paramContext);
  }
  
  public static boolean b()
  {
    return c;
  }
  
  public static void c(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static boolean d()
  {
    b();
    return false;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.b.get();
    if (localContext != null) {
      return a0.h().t(localContext, this, paramInt);
    }
    return a(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.q0
 * JD-Core Version:    0.7.0.1
 */