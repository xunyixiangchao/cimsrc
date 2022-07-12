package androidx.camera.core.impl.utils;

import androidx.camera.core.n1;

public final class b
{
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = paramInt2 - paramInt1 + 360;
    } else {
      i = paramInt2 + paramInt1;
    }
    i %= 360;
    if (n1.f("CameraOrientationUtil")) {
      n1.a("CameraOrientationUtil", String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
    }
    return i;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return 270;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unsupported surface rotation: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return 180;
      }
      return 90;
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.b
 * JD-Core Version:    0.7.0.1
 */