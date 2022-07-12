package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.List;
import k3.j;
import s3.u;

public class d
  extends RecyclerView.h<j>
  implements View.OnClickListener
{
  private List<MicroServerMenu> d;
  private u<MicroServerMenu> e;
  
  public d(List<MicroServerMenu> paramList, u<MicroServerMenu> paramu)
  {
    this.d = paramList;
    this.e = paramu;
  }
  
  public void I(j paramj, int paramInt)
  {
    MicroServerMenu localMicroServerMenu = (MicroServerMenu)this.d.get(paramInt);
    paramj.u.setText(localMicroServerMenu.name);
    paramj.a.setOnClickListener(this);
    paramj.a.setTag(localMicroServerMenu);
  }
  
  public j J(ViewGroup paramViewGroup, int paramInt)
  {
    return new j(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427506, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    this.e.K((MicroServerMenu)paramView.getTag());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s5.d
 * JD-Core Version:    0.7.0.1
 */