package p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import n.z;
import s.b2;

public class e
  implements b2
{
  private final List<Size> a;
  
  public e(z paramz)
  {
    paramz = (StreamConfigurationMap)paramz.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (paramz == null) {
      n1.c("CamcorderProfileResolutionQuirk", "StreamConfigurationMap is null");
    }
    if (paramz != null) {
      paramz = paramz.getOutputSizes(34);
    } else {
      paramz = null;
    }
    if (paramz != null) {
      paramz = Arrays.asList((Size[])paramz.clone());
    } else {
      paramz = Collections.emptyList();
    }
    this.a = paramz;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSupportedResolutions = ");
    localStringBuilder.append(paramz);
    n1.a("CamcorderProfileResolutionQuirk", localStringBuilder.toString());
  }
  
  static boolean b(z paramz)
  {
    paramz = (Integer)paramz.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    return (paramz != null) && (paramz.intValue() == 2);
  }
  
  public List<Size> a()
  {
    return new ArrayList(this.a);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.e
 * JD-Core Version:    0.7.0.1
 */