package b5;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import java.util.ArrayList;
import java.util.List;
import s3.u;

public class b
  extends RecyclerView.h<d5.b>
  implements View.OnClickListener
{
  private u<Integer> d;
  private final List<MenuItem> e = new ArrayList();
  
  public void I(List<MenuItem> paramList)
  {
    this.e.clear();
    this.e.addAll(paramList);
    j();
  }
  
  public void J(d5.b paramb, int paramInt)
  {
    MenuItem localMenuItem = (MenuItem)this.e.get(paramInt);
    paramb.v.setImageDrawable(localMenuItem.getIcon());
    paramb.u.setText(localMenuItem.getTitle());
    paramb.a.setId(localMenuItem.getItemId());
    paramb.a.setOnClickListener(this);
  }
  
  public d5.b K(ViewGroup paramViewGroup, int paramInt)
  {
    return new d5.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427454, paramViewGroup, false));
  }
  
  public void L(u<Integer> paramu)
  {
    this.d = paramu;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    this.d.K(Integer.valueOf(paramView.getId()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.b
 * JD-Core Version:    0.7.0.1
 */