package s;

import android.util.Size;
import android.view.Surface;
import u.f;
import u7.a;

public final class m1
  extends v0
{
  private final Surface m;
  
  public m1(Surface paramSurface)
  {
    this.m = paramSurface;
  }
  
  public m1(Surface paramSurface, Size paramSize, int paramInt)
  {
    super(paramSize, paramInt);
    this.m = paramSurface;
  }
  
  public a<Surface> n()
  {
    return f.h(this.m);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.m1
 * JD-Core Version:    0.7.0.1
 */