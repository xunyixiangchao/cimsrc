package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import x0.h;

class e
  extends d
{
  e(int paramInt, Surface paramSurface)
  {
    this(new OutputConfiguration(paramInt, paramSurface));
  }
  
  e(Object paramObject)
  {
    super(paramObject);
  }
  
  static e i(OutputConfiguration paramOutputConfiguration)
  {
    return new e(paramOutputConfiguration);
  }
  
  public String a()
  {
    return null;
  }
  
  public Object d()
  {
    h.a(this.a instanceof OutputConfiguration);
    return this.a;
  }
  
  public void e(String paramString)
  {
    ((OutputConfiguration)d()).setPhysicalCameraId(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o.e
 * JD-Core Version:    0.7.0.1
 */