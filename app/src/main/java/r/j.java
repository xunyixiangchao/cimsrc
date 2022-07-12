package r;

import android.hardware.camera2.CaptureRequest.Key;
import androidx.camera.core.i0;
import m.b;
import s.e2;
import s.s0;
import s.t1;
import s.u1;
import s.y1;

public class j
  implements e2
{
  private final s0 A;
  
  public j(s0 params0)
  {
    this.A = params0;
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public static final class a
    implements i0<j>
  {
    private final u1 a = u1.M();
    
    public static a e(s0 params0)
    {
      a locala = new a();
      params0.i("camera2.captureRequest.option.", new i(locala, params0));
      return locala;
    }
    
    public t1 a()
    {
      return this.a;
    }
    
    public j d()
    {
      return new j(y1.K(this.a));
    }
    
    public <ValueT> a g(CaptureRequest.Key<ValueT> paramKey, ValueT paramValueT)
    {
      paramKey = b.I(paramKey);
      this.a.G(paramKey, paramValueT);
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r.j
 * JD-Core Version:    0.7.0.1
 */