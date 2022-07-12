package q;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import m.b.a;
import s.c2;

public class a
{
  private final Range<Integer> a;
  
  public a(c2 paramc2)
  {
    paramc2 = (p.a)paramc2.b(p.a.class);
    if (paramc2 == null) {
      paramc2 = null;
    } else {
      paramc2 = paramc2.b();
    }
    this.a = paramc2;
  }
  
  public void a(b.a parama)
  {
    Range localRange = this.a;
    if (localRange != null) {
      parama.e(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, localRange);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.a
 * JD-Core Version:    0.7.0.1
 */