package y;

import android.media.MediaCodec;
import androidx.camera.core.f3;
import androidx.camera.core.w1;
import java.util.Collections;
import java.util.List;
import s.g2.e;
import s.v0;
import x.a;
import x.f;

public class c
{
  private final boolean a;
  
  public c()
  {
    boolean bool;
    if (a.a(f.class) != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
  }
  
  private int b(v0 paramv0)
  {
    if ((paramv0.e() != MediaCodec.class) && (paramv0.e() != f3.class))
    {
      if (paramv0.e() == w1.class) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  public void d(List<g2.e> paramList)
  {
    if (!this.a) {
      return;
    }
    Collections.sort(paramList, new b(this));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y.c
 * JD-Core Version:    0.7.0.1
 */