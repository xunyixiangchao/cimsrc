package q;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.core.n1;
import java.nio.BufferUnderflowException;
import n.z;
import p.l;
import p.q;

public final class f
{
  private static boolean a(z paramz)
  {
    paramz = (Boolean)paramz.a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
    if (paramz == null) {
      n1.k("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
    }
    if (paramz != null) {
      return paramz.booleanValue();
    }
    return false;
  }
  
  private static boolean b(z paramz)
  {
    try
    {
      boolean bool = a(paramz);
      return bool;
    }
    catch (BufferUnderflowException paramz)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  public static boolean c(z paramz)
  {
    if (l.a(q.class) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device has quirk ");
      localStringBuilder.append(q.class.getSimpleName());
      localStringBuilder.append(". Checking for flash availability safely...");
      n1.a("FlashAvailability", localStringBuilder.toString());
      return b(paramz);
    }
    return a(paramz);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.f
 * JD-Core Version:    0.7.0.1
 */