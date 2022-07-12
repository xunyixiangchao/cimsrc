package t4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.h;
import k3.j;
import u3.l;

public class b
  extends RecyclerView.h<j>
{
  private int d;
  
  public void I(j paramj, int paramInt)
  {
    paramj.u.setText(l.J(2131689683, new Object[] { Integer.valueOf(this.d) }));
  }
  
  public j J(ViewGroup paramViewGroup, int paramInt)
  {
    return new j(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427498, paramViewGroup, false));
  }
  
  public void K(int paramInt)
  {
    this.d = paramInt;
    j();
  }
  
  public int d()
  {
    return 1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.b
 * JD-Core Version:    0.7.0.1
 */