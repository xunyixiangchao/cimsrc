package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.core.m1;
import androidx.camera.core.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import n.f;
import n.m0;
import n.z;
import s.e0;

class j1
{
  private static String a(m0 paramm0, Integer paramInteger, List<String> paramList)
  {
    Object localObject2 = null;
    if (paramInteger == null) {
      return null;
    }
    Object localObject1 = localObject2;
    if (paramList.contains("0"))
    {
      if (!paramList.contains("1")) {
        return null;
      }
      if (paramInteger.intValue() == 1)
      {
        localObject1 = localObject2;
        if (((Integer)paramm0.c("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
          return "1";
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramInteger.intValue() == 0)
        {
          localObject1 = localObject2;
          if (((Integer)paramm0.c("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            localObject1 = "0";
          }
        }
      }
    }
    return localObject1;
  }
  
  static List<String> b(v paramv, t paramt)
  {
    try
    {
      localArrayList1 = new ArrayList();
      localObject2 = Arrays.asList(paramv.f().d());
      if (paramt == null)
      {
        paramv = ((List)localObject2).iterator();
        while (paramv.hasNext()) {
          localArrayList1.add((String)paramv.next());
        }
        return localArrayList1;
      }
    }
    catch (androidx.camera.core.v paramv)
    {
      ArrayList localArrayList1;
      Object localObject2;
      Object localObject1;
      ArrayList localArrayList2;
      throw new m1(paramv);
    }
    catch (f paramv)
    {
      label81:
      throw new m1(l1.a(paramv));
    }
    try
    {
      localObject1 = paramt.d();
      localObject1 = a(paramv.f(), (Integer)localObject1, (List)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label81;
    }
    localObject1 = null;
    localArrayList2 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (!str.equals(localObject1)) {
        localArrayList2.add(paramv.e(str));
      }
    }
    paramv = paramt.b(localArrayList2).iterator();
    while (paramv.hasNext()) {
      localArrayList1.add(((e0)paramv.next()).c());
    }
    return localArrayList1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.j1
 * JD-Core Version:    0.7.0.1
 */