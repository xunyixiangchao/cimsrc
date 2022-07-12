package s;

import androidx.camera.core.w1;
import v.k;

public final class a2
  implements t2<w1>, j1, k
{
  public static final s0.a<f1> B = s0.a.a("camerax.core.preview.imageInfoProcessor", f1.class);
  public static final s0.a<p0> C = s0.a.a("camerax.core.preview.captureProcessor", p0.class);
  public static final s0.a<Boolean> D = s0.a.a("camerax.core.preview.isRgba8888SurfaceRequired", Boolean.class);
  private final y1 A;
  
  public a2(y1 paramy1)
  {
    this.A = paramy1;
  }
  
  public p0 I(p0 paramp0)
  {
    return (p0)e(C, paramp0);
  }
  
  public f1 J(f1 paramf1)
  {
    return (f1)e(B, paramf1);
  }
  
  public boolean K(boolean paramBoolean)
  {
    return ((Boolean)e(D, Boolean.valueOf(paramBoolean))).booleanValue();
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public int q()
  {
    return ((Integer)a(h1.f)).intValue();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.a2
 * JD-Core Version:    0.7.0.1
 */