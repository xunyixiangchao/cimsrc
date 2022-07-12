package n;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class f
  extends Exception
{
  static final Set<Integer> c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })));
  static final Set<Integer> d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(10001), Integer.valueOf(10002) })));
  private final int a;
  private final CameraAccessException b;
  
  public f(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(a(paramInt, paramString), paramThrowable);
    this.a = paramInt;
    if (c.contains(Integer.valueOf(paramInt))) {
      paramString = new CameraAccessException(paramInt, paramString, paramThrowable);
    } else {
      paramString = null;
    }
    this.b = paramString;
  }
  
  public f(int paramInt, Throwable paramThrowable)
  {
    super(b(paramInt), paramThrowable);
    this.a = paramInt;
    boolean bool = c.contains(Integer.valueOf(paramInt));
    CameraAccessException localCameraAccessException = null;
    if (bool) {
      localCameraAccessException = new CameraAccessException(paramInt, null, paramThrowable);
    }
    this.b = localCameraAccessException;
  }
  
  private f(CameraAccessException paramCameraAccessException)
  {
    super(paramCameraAccessException.getMessage(), paramCameraAccessException.getCause());
    this.a = paramCameraAccessException.getReason();
    this.b = paramCameraAccessException;
  }
  
  private static String a(int paramInt, String paramString)
  {
    return String.format("%s (%d): %s", new Object[] { c(paramInt), Integer.valueOf(paramInt), paramString });
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 10001)
              {
                if (paramInt != 10002) {
                  return null;
                }
                return "Failed to create CameraCharacteristics.";
              }
              return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
            }
            return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
          }
          return "The camera device is in use already";
        }
        return "The camera device is currently in the error state; no further calls to it will succeed.";
      }
      return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
    }
    return "The camera is disabled due to a device policy, and cannot be opened.";
  }
  
  private static String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 1000)
              {
                if (paramInt != 10001)
                {
                  if (paramInt != 10002) {
                    return "<UNKNOWN ERROR>";
                  }
                  return "CAMERA_CHARACTERISTICS_CREATION_ERROR";
                }
                return "CAMERA_UNAVAILABLE_DO_NOT_DISTURB";
              }
              return "CAMERA_DEPRECATED_HAL";
            }
            return "MAX_CAMERAS_IN_USE";
          }
          return "CAMERA_IN_USE";
        }
        return "CAMERA_ERROR";
      }
      return "CAMERA_DISCONNECTED";
    }
    return "CAMERA_DISABLED";
  }
  
  public static f e(CameraAccessException paramCameraAccessException)
  {
    Objects.requireNonNull(paramCameraAccessException, "cameraAccessException should not be null");
    return new f(paramCameraAccessException);
  }
  
  public final int d()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.f
 * JD-Core Version:    0.7.0.1
 */