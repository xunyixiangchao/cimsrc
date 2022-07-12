package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.micro.entity.MicroServer;
import java.util.ArrayList;
import java.util.List;
import k3.h;
import s3.p;
import u3.b0;

public class c
  extends RecyclerView.h<h>
  implements View.OnClickListener
{
  private final List<MicroServer> d = new ArrayList();
  private p<MicroServer> e;
  
  public void I(List<MicroServer> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(h paramh, int paramInt)
  {
    MicroServer localMicroServer = (MicroServer)this.d.get(paramInt);
    paramh.u.setText(localMicroServer.name);
    paramh.v.p(b0.j(localMicroServer.id), 2131165602);
    paramh.a.setOnClickListener(this);
    paramh.a.setTag(localMicroServer);
  }
  
  public h K(ViewGroup paramViewGroup, int paramInt)
  {
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427480, paramViewGroup, false));
  }
  
  public void L(p<MicroServer> paramp)
  {
    this.e = paramp;
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
    this.e.C0((MicroServer)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s5.c
 * JD-Core Version:    0.7.0.1
 */