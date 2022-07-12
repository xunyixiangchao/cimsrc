package f2;

import android.annotation.SuppressLint;
import b2.f;
import d2.v;

public class h
  extends x2.h<f, v<?>>
  implements i
{
  private i.a e;
  
  public h(long paramLong)
  {
    super(paramLong);
  }
  
  @SuppressLint({"InlinedApi"})
  public void b(int paramInt)
  {
    if (paramInt >= 40)
    {
      a();
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      m(h() / 2L);
    }
  }
  
  public void c(i.a parama)
  {
    this.e = parama;
  }
  
  protected int n(v<?> paramv)
  {
    if (paramv == null) {
      return super.i(null);
    }
    return paramv.c();
  }
  
  protected void o(f paramf, v<?> paramv)
  {
    paramf = this.e;
    if ((paramf != null) && (paramv != null)) {
      paramf.b(paramv);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.h
 * JD-Core Version:    0.7.0.1
 */