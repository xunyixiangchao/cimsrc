package s;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.n1;
import androidx.camera.core.t;

public final class l0
{
  public static void a(Context paramContext, h0 paramh0, t paramt)
  {
    Object localObject1;
    if (paramt != null) {
      try
      {
        localObject2 = paramt.d();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label38;
        }
        n1.k("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
        return;
      }
      catch (IllegalStateException paramContext)
      {
        n1.d("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", paramContext);
        return;
      }
    } else {
      localObject1 = null;
    }
    label38:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Verifying camera lens facing on ");
    ((StringBuilder)localObject2).append(Build.DEVICE);
    ((StringBuilder)localObject2).append(", lensFacingInteger: ");
    ((StringBuilder)localObject2).append(localObject1);
    n1.a("CameraValidator", ((StringBuilder)localObject2).toString());
    paramContext = paramContext.getPackageManager();
    try
    {
      if ((paramContext.hasSystemFeature("android.hardware.camera")) && ((paramt == null) || (localObject1.intValue() == 1))) {
        t.c.e(paramh0.a());
      }
      if ((paramContext.hasSystemFeature("android.hardware.camera.front")) && ((paramt == null) || (localObject1.intValue() == 0))) {
        t.b.e(paramh0.a());
      }
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramt = new StringBuilder();
      paramt.append("Camera LensFacing verification failed, existing cameras: ");
      paramt.append(paramh0.a());
      n1.c("CameraValidator", paramt.toString());
      throw new a("Expected camera missing from device.", paramContext);
    }
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.l0
 * JD-Core Version:    0.7.0.1
 */