package n;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics.Key;
import java.util.Collections;
import java.util.Set;

class y
  implements z.a
{
  protected final CameraCharacteristics a;
  
  y(CameraCharacteristics paramCameraCharacteristics)
  {
    this.a = paramCameraCharacteristics;
  }
  
  public CameraCharacteristics a()
  {
    return this.a;
  }
  
  public <T> T b(CameraCharacteristics.Key<T> paramKey)
  {
    return this.a.get(paramKey);
  }
  
  public Set<String> c()
  {
    return Collections.emptySet();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.y
 * JD-Core Version:    0.7.0.1
 */