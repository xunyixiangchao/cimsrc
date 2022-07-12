package a0;

import android.hardware.camera2.CaptureRequest.Key;
import android.util.Pair;
import androidx.camera.extensions.impl.CaptureStageImpl;
import java.util.Iterator;
import java.util.List;
import m.b.a;
import s.n0;
import s.n0.a;
import s.q0;

public final class b
  implements q0
{
  private final n0 a;
  private final int b;
  
  public b(CaptureStageImpl paramCaptureStageImpl)
  {
    this.b = paramCaptureStageImpl.getId();
    b.a locala = new b.a();
    paramCaptureStageImpl = paramCaptureStageImpl.getParameters().iterator();
    while (paramCaptureStageImpl.hasNext())
    {
      Pair localPair = (Pair)paramCaptureStageImpl.next();
      locala.e((CaptureRequest.Key)localPair.first, localPair.second);
    }
    paramCaptureStageImpl = new n0.a();
    paramCaptureStageImpl.e(locala.c());
    this.a = paramCaptureStageImpl.h();
  }
  
  public n0 a()
  {
    return this.a;
  }
  
  public int getId()
  {
    return this.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.b
 * JD-Core Version:    0.7.0.1
 */