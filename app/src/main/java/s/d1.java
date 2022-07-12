package s;

import androidx.camera.core.f1;
import androidx.camera.core.m0;
import androidx.camera.core.m0.a;
import androidx.camera.core.m0.d;
import v.k;

public final class d1
  implements t2<m0>, j1, k
{
  public static final s0.a<Integer> B = s0.a.a("camerax.core.imageAnalysis.backpressureStrategy", m0.a.class);
  public static final s0.a<Integer> C = s0.a.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
  public static final s0.a<f1> D = s0.a.a("camerax.core.imageAnalysis.imageReaderProxyProvider", f1.class);
  public static final s0.a<Integer> E = s0.a.a("camerax.core.imageAnalysis.outputImageFormat", m0.d.class);
  public static final s0.a<Boolean> F = s0.a.a("camerax.core.imageAnalysis.onePixelShiftEnabled", Boolean.class);
  public static final s0.a<Boolean> G = s0.a.a("camerax.core.imageAnalysis.outputImageRotationEnabled", Boolean.class);
  private final y1 A;
  
  public d1(y1 paramy1)
  {
    this.A = paramy1;
  }
  
  public int J(int paramInt)
  {
    return ((Integer)e(B, Integer.valueOf(paramInt))).intValue();
  }
  
  public int K(int paramInt)
  {
    return ((Integer)e(C, Integer.valueOf(paramInt))).intValue();
  }
  
  public f1 L()
  {
    return (f1)e(D, null);
  }
  
  public Boolean M(Boolean paramBoolean)
  {
    return (Boolean)e(F, paramBoolean);
  }
  
  public int N(int paramInt)
  {
    return ((Integer)e(E, Integer.valueOf(paramInt))).intValue();
  }
  
  public Boolean O(Boolean paramBoolean)
  {
    return (Boolean)e(G, paramBoolean);
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public int q()
  {
    return 35;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.d1
 * JD-Core Version:    0.7.0.1
 */