package p;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import n.z;
import s.b2;

public class a
  implements b2
{
  private final Range<Integer> a = d((Range[])paramz.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
  
  public a(z paramz) {}
  
  private Range<Integer> a(Range<Integer> paramRange)
  {
    int i = ((Integer)paramRange.getUpper()).intValue();
    int j = ((Integer)paramRange.getLower()).intValue();
    if (((Integer)paramRange.getUpper()).intValue() >= 1000) {
      i = ((Integer)paramRange.getUpper()).intValue() / 1000;
    }
    if (((Integer)paramRange.getLower()).intValue() >= 1000) {
      j = ((Integer)paramRange.getLower()).intValue() / 1000;
    }
    return new Range(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  static boolean c(z paramz)
  {
    paramz = (Integer)paramz.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    return (paramz != null) && (paramz.intValue() == 2);
  }
  
  private Range<Integer> d(Range<Integer>[] paramArrayOfRange)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramArrayOfRange != null)
    {
      if (paramArrayOfRange.length == 0) {
        return null;
      }
      int j = paramArrayOfRange.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        Range localRange = a(paramArrayOfRange[i]);
        if (((Integer)localRange.getUpper()).intValue() != 30)
        {
          localObject2 = localObject1;
        }
        else if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((Integer)localRange.getLower()).intValue() >= ((Integer)localObject1.getLower()).intValue()) {}
        }
        else
        {
          localObject2 = localRange;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  public Range<Integer> b()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.a
 * JD-Core Version:    0.7.0.1
 */