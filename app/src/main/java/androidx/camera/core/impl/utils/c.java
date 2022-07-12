package androidx.camera.core.impl.utils;

import android.util.Size;
import java.util.Comparator;

public final class c
  implements Comparator<Size>
{
  private boolean a;
  
  public c()
  {
    this(false);
  }
  
  public c(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(Size paramSize1, Size paramSize2)
  {
    int j = Long.signum(paramSize1.getWidth() * paramSize1.getHeight() - paramSize2.getWidth() * paramSize2.getHeight());
    int i = j;
    if (this.a) {
      i = j * -1;
    }
    return i;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.c
 * JD-Core Version:    0.7.0.1
 */