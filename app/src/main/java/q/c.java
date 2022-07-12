package q;

import android.util.Size;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p.e;

public class c
{
  private final e a;
  private final Set<Size> b;
  
  public c(e parame)
  {
    this.a = parame;
    if (parame != null) {
      parame = new HashSet(parame.a());
    } else {
      parame = Collections.emptySet();
    }
    this.b = parame;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.c
 * JD-Core Version:    0.7.0.1
 */