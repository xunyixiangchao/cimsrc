package b6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.moment.widget.TimelineMomentHeaderView;
import i3.e;
import j5.b;
import u3.b0;

public class f
  extends RecyclerView.h<k3.f>
{
  private TimelineMomentHeaderView d;
  
  public void I(k3.f paramf, int paramInt)
  {
    this.d.c(b0.i(e.o().longValue()));
    this.d.b(b0.l(e.o().longValue()));
    this.d.d(b.t());
  }
  
  public k3.f J(ViewGroup paramViewGroup, int paramInt)
  {
    this.d = ((TimelineMomentHeaderView)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427580, paramViewGroup, false));
    return new k3.f(this.d);
  }
  
  public void K()
  {
    this.d.d(b.t());
  }
  
  public void L()
  {
    this.d.c(b0.i(e.o().longValue()));
  }
  
  public int d()
  {
    return 1;
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.f
 * JD-Core Version:    0.7.0.1
 */