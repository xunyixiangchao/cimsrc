package s;

import androidx.camera.core.f1;
import androidx.camera.core.z0;
import java.util.concurrent.Executor;
import v.g;

public final class e1
  implements t2<z0>, j1, g
{
  public static final s0.a<Integer> B;
  public static final s0.a<Integer> C;
  public static final s0.a<m0> D;
  public static final s0.a<p0> E;
  public static final s0.a<Integer> F;
  public static final s0.a<Integer> G;
  public static final s0.a<f1> H;
  public static final s0.a<Boolean> I;
  public static final s0.a<Integer> J;
  public static final s0.a<Integer> K;
  private final y1 A;
  
  static
  {
    Class localClass = Integer.TYPE;
    B = s0.a.a("camerax.core.imageCapture.captureMode", localClass);
    C = s0.a.a("camerax.core.imageCapture.flashMode", localClass);
    D = s0.a.a("camerax.core.imageCapture.captureBundle", m0.class);
    E = s0.a.a("camerax.core.imageCapture.captureProcessor", p0.class);
    F = s0.a.a("camerax.core.imageCapture.bufferFormat", Integer.class);
    G = s0.a.a("camerax.core.imageCapture.maxCaptureStages", Integer.class);
    H = s0.a.a("camerax.core.imageCapture.imageReaderProxyProvider", f1.class);
    I = s0.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
    J = s0.a.a("camerax.core.imageCapture.flashType", localClass);
    K = s0.a.a("camerax.core.imageCapture.jpegCompressionQuality", localClass);
  }
  
  public e1(y1 paramy1)
  {
    this.A = paramy1;
  }
  
  public m0 I(m0 paramm0)
  {
    return (m0)e(D, paramm0);
  }
  
  public int J()
  {
    return ((Integer)a(B)).intValue();
  }
  
  public p0 K(p0 paramp0)
  {
    return (p0)e(E, paramp0);
  }
  
  public int L(int paramInt)
  {
    return ((Integer)e(C, Integer.valueOf(paramInt))).intValue();
  }
  
  public int M(int paramInt)
  {
    return ((Integer)e(J, Integer.valueOf(paramInt))).intValue();
  }
  
  public f1 N()
  {
    return (f1)e(H, null);
  }
  
  public Executor O(Executor paramExecutor)
  {
    return (Executor)e(g.v, paramExecutor);
  }
  
  public int P()
  {
    return ((Integer)a(K)).intValue();
  }
  
  public int Q(int paramInt)
  {
    return ((Integer)e(G, Integer.valueOf(paramInt))).intValue();
  }
  
  public boolean R()
  {
    return b(B);
  }
  
  public boolean S()
  {
    return ((Boolean)e(I, Boolean.FALSE)).booleanValue();
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
 * Qualified Name:     s.e1
 * JD-Core Version:    0.7.0.1
 */