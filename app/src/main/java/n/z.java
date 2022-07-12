package n;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics.Key;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class z
{
  private final Map<CameraCharacteristics.Key<?>, Object> a = new HashMap();
  private final a b;
  
  private z(CameraCharacteristics paramCameraCharacteristics)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramCameraCharacteristics = new x(paramCameraCharacteristics);
    } else {
      paramCameraCharacteristics = new y(paramCameraCharacteristics);
    }
    this.b = paramCameraCharacteristics;
  }
  
  private boolean c(CameraCharacteristics.Key<?> paramKey)
  {
    return paramKey.equals(CameraCharacteristics.SENSOR_ORIENTATION);
  }
  
  public static z e(CameraCharacteristics paramCameraCharacteristics)
  {
    return new z(paramCameraCharacteristics);
  }
  
  public <T> T a(CameraCharacteristics.Key<T> paramKey)
  {
    if (c(paramKey)) {
      return this.b.b(paramKey);
    }
    try
    {
      Object localObject = this.a.get(paramKey);
      if (localObject != null) {
        return localObject;
      }
      localObject = this.b.b(paramKey);
      if (localObject != null) {
        this.a.put(paramKey, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public Set<String> b()
  {
    return this.b.c();
  }
  
  public CameraCharacteristics d()
  {
    return this.b.a();
  }
  
  public static abstract interface a
  {
    public abstract CameraCharacteristics a();
    
    public abstract <T> T b(CameraCharacteristics.Key<T> paramKey);
    
    public abstract Set<String> c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.z
 * JD-Core Version:    0.7.0.1
 */