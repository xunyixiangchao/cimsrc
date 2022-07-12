package s;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.e;
import java.util.List;

public abstract interface j1
  extends e2
{
  public static final s0.a<Integer> g = s0.a.a("camerax.core.imageOutput.targetAspectRatio", e.class);
  public static final s0.a<Integer> h;
  public static final s0.a<Integer> i;
  public static final s0.a<Size> j = s0.a.a("camerax.core.imageOutput.targetResolution", Size.class);
  public static final s0.a<Size> k = s0.a.a("camerax.core.imageOutput.defaultResolution", Size.class);
  public static final s0.a<Size> l = s0.a.a("camerax.core.imageOutput.maxResolution", Size.class);
  public static final s0.a<List<Pair<Integer, Size[]>>> m = s0.a.a("camerax.core.imageOutput.supportedResolutions", List.class);
  
  static
  {
    Class localClass = Integer.TYPE;
    h = s0.a.a("camerax.core.imageOutput.targetRotation", localClass);
    i = s0.a.a("camerax.core.imageOutput.appTargetRotation", localClass);
  }
  
  public abstract int A(int paramInt);
  
  public abstract int D(int paramInt);
  
  public abstract Size f(Size paramSize);
  
  public abstract List<Pair<Integer, Size[]>> l(List<Pair<Integer, Size[]>> paramList);
  
  public abstract boolean m();
  
  public abstract int o();
  
  public abstract Size u(Size paramSize);
  
  public abstract Size z(Size paramSize);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.j1
 * JD-Core Version:    0.7.0.1
 */