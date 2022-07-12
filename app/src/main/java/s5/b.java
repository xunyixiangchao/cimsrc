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
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.micro.entity.MicroApp;
import com.farsunset.hoxin.micro.ui.MicroAppActivity;
import java.util.ArrayList;
import java.util.List;
import k3.h;
import u3.b0;

public class b
  extends RecyclerView.h<h>
  implements View.OnClickListener
{
  private final List<MicroApp> d = new ArrayList();
  
  public void I(List<MicroApp> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(h paramh, int paramInt)
  {
    MicroApp localMicroApp = (MicroApp)this.d.get(paramInt);
    paramh.u.setText(localMicroApp.name);
    paramh.v.p(b0.a(Long.valueOf(localMicroApp.id)), 2131165527);
    paramh.a.setTag(localMicroApp);
    paramh.a.setOnClickListener(this);
  }
  
  public h K(ViewGroup paramViewGroup, int paramInt)
  {
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427507, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public void onClick(View paramView)
  {
    MicroApp localMicroApp = (MicroApp)paramView.getTag();
    Intent localIntent = new Intent(paramView.getContext(), MicroAppActivity.class);
    localIntent.addFlags(524288);
    localIntent.addFlags(134217728);
    localIntent.putExtra(MicroApp.class.getSimpleName(), localMicroApp);
    paramView.getContext().startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s5.b
 * JD-Core Version:    0.7.0.1
 */