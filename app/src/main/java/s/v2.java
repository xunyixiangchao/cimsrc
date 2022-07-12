package s;

import androidx.camera.core.f3;
import v.k;

public final class v2
  implements t2<f3>, j1, k
{
  public static final s0.a<Integer> B;
  public static final s0.a<Integer> C;
  public static final s0.a<Integer> D;
  public static final s0.a<Integer> E;
  public static final s0.a<Integer> F;
  public static final s0.a<Integer> G;
  public static final s0.a<Integer> H;
  private final y1 A;
  
  static
  {
    Class localClass = Integer.TYPE;
    B = s0.a.a("camerax.core.videoCapture.recordingFrameRate", localClass);
    C = s0.a.a("camerax.core.videoCapture.bitRate", localClass);
    D = s0.a.a("camerax.core.videoCapture.intraFrameInterval", localClass);
    E = s0.a.a("camerax.core.videoCapture.audioBitRate", localClass);
    F = s0.a.a("camerax.core.videoCapture.audioSampleRate", localClass);
    G = s0.a.a("camerax.core.videoCapture.audioChannelCount", localClass);
    H = s0.a.a("camerax.core.videoCapture.audioMinBufferSize", localClass);
  }
  
  public v2(y1 paramy1)
  {
    this.A = paramy1;
  }
  
  public int I()
  {
    return ((Integer)a(E)).intValue();
  }
  
  public int J()
  {
    return ((Integer)a(G)).intValue();
  }
  
  public int K()
  {
    return ((Integer)a(H)).intValue();
  }
  
  public int L()
  {
    return ((Integer)a(F)).intValue();
  }
  
  public int M()
  {
    return ((Integer)a(C)).intValue();
  }
  
  public int N()
  {
    return ((Integer)a(D)).intValue();
  }
  
  public int O()
  {
    return ((Integer)a(B)).intValue();
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public int q()
  {
    return 34;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.v2
 * JD-Core Version:    0.7.0.1
 */