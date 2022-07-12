package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s.k;
import s.l;

final class o1
{
  static CameraCaptureSession.CaptureCallback a(k paramk)
  {
    if (paramk == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    b(paramk, localArrayList);
    if (localArrayList.size() == 1) {
      return (CameraCaptureSession.CaptureCallback)localArrayList.get(0);
    }
    return k0.a(localArrayList);
  }
  
  static void b(k paramk, List<CameraCaptureSession.CaptureCallback> paramList)
  {
    if ((paramk instanceof l))
    {
      paramk = ((l)paramk).d().iterator();
      while (paramk.hasNext()) {
        b((k)paramk.next(), paramList);
      }
    }
    if ((paramk instanceof n1))
    {
      paramList.add(((n1)paramk).e());
      return;
    }
    paramList.add(new m1(paramk));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.o1
 * JD-Core Version:    0.7.0.1
 */