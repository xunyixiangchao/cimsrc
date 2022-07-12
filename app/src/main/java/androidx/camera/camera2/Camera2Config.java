package androidx.camera.camera2;

import androidx.camera.core.a0;
import androidx.camera.core.a0.a;
import androidx.camera.core.a0.b;
import l.a;
import l.b;
import l.c;

public final class Camera2Config
{
  public static a0 c()
  {
    b localb = b.a;
    a locala = a.a;
    c localc = c.a;
    return new a0.a().c(localb).d(locala).g(localc).a();
  }
  
  public static final class DefaultProvider
    implements a0.b
  {
    public a0 getCameraXConfig()
    {
      return Camera2Config.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.Camera2Config
 * JD-Core Version:    0.7.0.1
 */