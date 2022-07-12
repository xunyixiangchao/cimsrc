package androidx.camera.camera2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s.f2;
import s.g2;
import s.i2;
import x0.h;

public class d1
  implements f2
{
  private final s1 a;
  private final List<i2> b;
  private volatile boolean c;
  private volatile g2 d;
  
  public d1(s1 params1, List<i2> paramList)
  {
    boolean bool = false;
    this.c = false;
    if (params1.l == s1.e.e) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureSession state must be OPENED. Current state:");
    localStringBuilder.append(params1.l);
    h.b(bool, localStringBuilder.toString());
    this.a = params1;
    this.b = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public void b(g2 paramg2)
  {
    this.d = paramg2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.d1
 * JD-Core Version:    0.7.0.1
 */