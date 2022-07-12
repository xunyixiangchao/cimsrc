package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class j0
  extends b0
{
  private final WeakReference<Context> b;
  
  public j0(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.b = new WeakReference(paramContext);
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = a(paramInt);
    Context localContext = (Context)this.b.get();
    if ((localDrawable != null) && (localContext != null)) {
      a0.h().x(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.j0
 * JD-Core Version:    0.7.0.1
 */