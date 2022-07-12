package androidx.core.widget;

import android.os.Build.VERSION;

public abstract interface b
{
  public static final boolean D;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    }
    D = bool;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.b
 * JD-Core Version:    0.7.0.1
 */