package q;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Key;
import m.b.a;
import p.l;
import p.u;

public class i
{
  @SuppressLint({"NewApi"})
  public void a(int paramInt, b.a parama)
  {
    if ((u)l.a(u.class) == null) {
      return;
    }
    CaptureRequest.Key localKey;
    Boolean localBoolean;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      localKey = CaptureRequest.CONTROL_ENABLE_ZSL;
      localBoolean = Boolean.FALSE;
    }
    else
    {
      localKey = CaptureRequest.CONTROL_ENABLE_ZSL;
      localBoolean = Boolean.TRUE;
    }
    parama.e(localKey, localBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.i
 * JD-Core Version:    0.7.0.1
 */