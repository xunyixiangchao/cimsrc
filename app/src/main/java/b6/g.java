package b6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.ui.FriendMomentActivity;
import com.farsunset.hoxin.moment.ui.MineMomentActivity;
import com.farsunset.hoxin.moment.widget.TimelineMomentView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  extends RecyclerView.h<RecyclerView.c0>
  implements View.OnClickListener
{
  final int d = 1;
  final int e = 2;
  final int f = 3;
  final int g = 4;
  final int h = 5;
  final List<Moment> i = new ArrayList();
  private j6.a j;
  private final User k = i3.e.g();
  
  private Moment L(int paramInt)
  {
    return (Moment)this.i.get(paramInt);
  }
  
  public void I(Moment paramMoment)
  {
    this.i.add(0, paramMoment);
    p(0);
  }
  
  public void J(List<Moment> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int m = this.i.size();
      if (this.i.addAll(paramList)) {
        s(m, paramList.size());
      }
    }
  }
  
  public void K()
  {
    this.i.clear();
    super.j();
  }
  
  protected int M(long paramLong)
  {
    Iterator localIterator = this.i.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      if (((Moment)localIterator.next()).id == paramLong) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  public boolean N()
  {
    return this.i.isEmpty();
  }
  
  public boolean O(List<Moment> paramList)
  {
    if (this.i.size() < paramList.size()) {
      return false;
    }
    return this.i.subList(0, paramList.size()).equals(paramList);
  }
  
  void P(RecyclerView.c0 paramc0, Moment paramMoment)
  {
    ((c6.e)paramc0).u.g(paramMoment, this.k, this.j);
  }
  
  public void Q(Moment paramMoment)
  {
    int m = M(paramMoment.id);
    if (m >= 0)
    {
      this.i.remove(m);
      u(m);
    }
  }
  
  public void R(List<Moment> paramList)
  {
    this.i.clear();
    this.i.addAll(paramList);
    super.j();
  }
  
  public void S(j6.a parama)
  {
    this.j = parama;
  }
  
  public void T(Moment paramMoment)
  {
    int m = M(paramMoment.id);
    if (m >= 0)
    {
      this.i.set(m, paramMoment);
      k(m);
    }
  }
  
  public int d()
  {
    return this.i.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public int f(int paramInt)
  {
    paramInt = L(paramInt).type;
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
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231053)
    {
      Intent localIntent = new Intent();
      long l = ((Long)paramView.getTag(2131231596)).longValue();
      if (this.k.id == l)
      {
        localIntent.setClass(paramView.getContext(), MineMomentActivity.class);
      }
      else
      {
        localIntent.setClass(paramView.getContext(), FriendMomentActivity.class);
        localIntent.putExtra(Friend.class.getName(), i4.a.l(l));
      }
      paramView.getContext().startActivity(localIntent);
    }
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    P(paramc0, L(paramInt));
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new c6.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427534, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new c6.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427533, paramViewGroup, false));
    }
    if (paramInt == 4) {
      return new c6.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427535, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new c6.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427536, paramViewGroup, false));
    }
    return new c6.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427537, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.g
 * JD-Core Version:    0.7.0.1
 */