package s5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.widget.ListFooterView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.farsunset.hoxin.micro.ui.MicroServerDetailedActivity;
import java.util.ArrayList;
import java.util.List;
import k3.e;
import k3.h;
import u3.b0;

public class a
  extends RecyclerView.h
  implements View.OnClickListener
{
  private final int d = 9999;
  private final int e = 1;
  private final List<MicroServer> f = new ArrayList();
  private final ListFooterView g;
  
  public a(Context paramContext)
  {
    this.g = ((ListFooterView)LayoutInflater.from(paramContext).inflate(2131427561, null));
  }
  
  public void I(List<MicroServer> paramList)
  {
    int i = this.f.size();
    this.f.addAll(paramList);
    s(i + 1, paramList.size());
  }
  
  public ListFooterView J()
  {
    return this.g;
  }
  
  public long K()
  {
    if (this.f.isEmpty()) {
      return 0L;
    }
    List localList = this.f;
    return ((MicroServer)localList.get(localList.size() - 1)).id;
  }
  
  public void L(List<MicroServer> paramList)
  {
    this.f.clear();
    this.f.addAll(paramList);
    j();
  }
  
  public int d()
  {
    return this.f.size() + 1;
  }
  
  public int f(int paramInt)
  {
    if (paramInt == d() - 1) {
      return 9999;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), MicroServerDetailedActivity.class);
    localIntent.putExtra(MessageSource.NAME, (MicroServer)paramView.getTag());
    paramView.getContext().startActivity(localIntent);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if ((paramc0 instanceof e)) {
      return;
    }
    MicroServer localMicroServer = (MicroServer)this.f.get(paramInt);
    paramc0 = (h)paramc0;
    paramc0.u.setText(localMicroServer.name);
    paramc0.v.p(b0.j(localMicroServer.id), 2131165602);
    paramc0.a.setOnClickListener(this);
    paramc0.a.setTag(localMicroServer);
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 9999) {
      return new e(this.g);
    }
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427480, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s5.a
 * JD-Core Version:    0.7.0.1
 */