package b6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.widget.PersonalMomentView;
import java.util.List;

public class d
  extends g
{
  public void Q(Moment paramMoment)
  {
    int i = M(paramMoment.id);
    if (i < 0) {
      return;
    }
    this.i.remove(i);
    u(i);
  }
  
  public int d()
  {
    return this.i.size();
  }
  
  public int f(int paramInt)
  {
    paramInt = ((Moment)this.i.get(paramInt)).type;
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 2) {
      return 5;
    }
    if (paramInt == 3) {
      return 3;
    }
    if (paramInt == 0) {
      return 4;
    }
    return 1;
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if (paramInt < this.i.size())
    {
      Moment localMoment = (Moment)this.i.get(paramInt);
      ((c6.d)paramc0).u.a(localMoment);
    }
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new c6.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427514, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new c6.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427513, paramViewGroup, false));
    }
    if (paramInt == 4) {
      return new c6.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427515, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new c6.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427516, paramViewGroup, false));
    }
    return new c6.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427517, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.d
 * JD-Core Version:    0.7.0.1
 */