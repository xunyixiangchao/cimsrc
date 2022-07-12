package r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics.Key;
import androidx.camera.camera2.internal.j0;
import androidx.camera.core.r;
import java.util.Map;
import n.z;

public final class h
{
  private final j0 a;
  
  public h(j0 paramj0)
  {
    this.a = paramj0;
  }
  
  public static CameraCharacteristics a(r paramr)
  {
    x0.h.j(paramr instanceof j0, "CameraInfo does not contain any Camera2 information.");
    return ((j0)paramr).i().d();
  }
  
  public static h b(r paramr)
  {
    x0.h.b(paramr instanceof j0, "CameraInfo doesn't contain Camera2 implementation.");
    return ((j0)paramr).h();
  }
  
  public <T> T c(CameraCharacteristics.Key<T> paramKey)
  {
    return this.a.i().a(paramKey);
  }
  
  public Map<String, CameraCharacteristics> d()
  {
    return this.a.j();
  }
  
  public String e()
  {
    return this.a.c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r.h
 * JD-Core Version:    0.7.0.1
 */