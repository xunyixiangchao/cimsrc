package p;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s.b2;

public class n
  implements b2
{
  private List<Size> b(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString.equals("0")) && ((paramInt == 34) || (paramInt == 35)))
    {
      localArrayList.add(new Size(720, 720));
      localArrayList.add(new Size(400, 400));
    }
    return localArrayList;
  }
  
  private List<Size> c(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString.equals("0")) && (paramInt == 256))
    {
      localArrayList.add(new Size(4160, 3120));
      localArrayList.add(new Size(4000, 3000));
    }
    return localArrayList;
  }
  
  private List<Size> d(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString.equals("0")) && (paramInt == 256))
    {
      localArrayList.add(new Size(4160, 3120));
      localArrayList.add(new Size(4000, 3000));
    }
    return localArrayList;
  }
  
  private static boolean e()
  {
    return ("HUAWEI".equalsIgnoreCase(Build.BRAND)) && ("HWANE".equalsIgnoreCase(Build.DEVICE));
  }
  
  private static boolean f()
  {
    return ("OnePlus".equalsIgnoreCase(Build.BRAND)) && ("OnePlus6".equalsIgnoreCase(Build.DEVICE));
  }
  
  private static boolean g()
  {
    return ("OnePlus".equalsIgnoreCase(Build.BRAND)) && ("OnePlus6T".equalsIgnoreCase(Build.DEVICE));
  }
  
  static boolean h()
  {
    return (f()) || (g()) || (e());
  }
  
  public List<Size> a(String paramString, int paramInt)
  {
    if (f()) {
      return c(paramString, paramInt);
    }
    if (g()) {
      return d(paramString, paramInt);
    }
    if (e()) {
      return b(paramString, paramInt);
    }
    n1.k("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
    return Collections.emptyList();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.n
 * JD-Core Version:    0.7.0.1
 */