package androidx.core.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class v
{
  private Object a;
  
  private v(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public static v b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new v(PointerIcon.getSystemIcon(paramContext, paramInt));
    }
    return new v(null);
  }
  
  public Object a()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.v
 * JD-Core Version:    0.7.0.1
 */