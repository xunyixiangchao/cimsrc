package s;

import android.util.Range;
import androidx.camera.core.i0;
import androidx.camera.core.t;
import androidx.camera.core.v2;
import v.i;
import v.m;

public abstract interface t2<T extends v2>
  extends i<T>, m, h1
{
  public static final s0.a<g2> n = s0.a.a("camerax.core.useCase.defaultSessionConfig", g2.class);
  public static final s0.a<n0> o = s0.a.a("camerax.core.useCase.defaultCaptureConfig", n0.class);
  public static final s0.a<g2.d> p = s0.a.a("camerax.core.useCase.sessionConfigUnpacker", g2.d.class);
  public static final s0.a<n0.b> q = s0.a.a("camerax.core.useCase.captureConfigUnpacker", n0.b.class);
  public static final s0.a<Integer> r = s0.a.a("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);
  public static final s0.a<t> s = s0.a.a("camerax.core.useCase.cameraSelector", t.class);
  public static final s0.a<Range<Integer>> t = s0.a.a("camerax.core.useCase.targetFrameRate", t.class);
  public static final s0.a<Boolean> u = s0.a.a("camerax.core.useCase.zslDisabled", Boolean.TYPE);
  
  public abstract g2.d H(g2.d paramd);
  
  public abstract Range<Integer> j(Range<Integer> paramRange);
  
  public abstract g2 k(g2 paramg2);
  
  public abstract int n(int paramInt);
  
  public abstract n0.b r(n0.b paramb);
  
  public abstract boolean w(boolean paramBoolean);
  
  public abstract n0 x(n0 paramn0);
  
  public abstract t y(t paramt);
  
  public static abstract interface a<T extends v2, C extends t2<T>, B>
    extends i0<T>
  {
    public abstract C b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.t2
 * JD-Core Version:    0.7.0.1
 */