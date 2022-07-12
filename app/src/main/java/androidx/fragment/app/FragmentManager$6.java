package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.Map;

class FragmentManager$6
  implements j
{
  public void d(l paraml, h.b paramb)
  {
    if (paramb == h.b.ON_START)
    {
      paraml = (Bundle)FragmentManager.a(this.d).get(this.a);
      if (paraml != null)
      {
        this.b.a(this.a, paraml);
        this.d.r(this.a);
      }
    }
    if (paramb == h.b.ON_DESTROY)
    {
      this.c.c(this);
      FragmentManager.b(this.d).remove(this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentManager.6
 * JD-Core Version:    0.7.0.1
 */