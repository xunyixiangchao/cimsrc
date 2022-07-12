package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

class FragmentStateAdapter$5
  implements j
{
  public void d(l paraml, h.b paramb)
  {
    if (paramb == h.b.ON_DESTROY)
    {
      this.a.removeCallbacks(this.b);
      paraml.getLifecycle().c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.5
 * JD-Core Version:    0.7.0.1
 */