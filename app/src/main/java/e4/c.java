package e4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.entity.Group;
import java.util.ArrayList;
import java.util.List;
import k3.g;
import s3.p;
import u3.l;

public class c
  extends RecyclerView.h<g>
  implements View.OnClickListener
{
  private final List<MessageSource> d = new ArrayList();
  private p<MessageSource> e;
  
  public void I(MessageSource paramMessageSource)
  {
    this.d.add(paramMessageSource);
    p(this.d.size() - 1);
  }
  
  public void J(g paramg, int paramInt)
  {
    MessageSource localMessageSource = (MessageSource)this.d.get(paramInt);
    paramg.a.setTag(localMessageSource);
    paramg.a.setOnClickListener(this);
    boolean bool = localMessageSource instanceof Group;
    paramg = paramg.u;
    if (bool)
    {
      paramg.l(l.A(localMessageSource.getId().longValue()));
      return;
    }
    paramg.p(localMessageSource.getWebIcon(), 2131165495);
  }
  
  public g K(ViewGroup paramViewGroup, int paramInt)
  {
    return new g(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427528, paramViewGroup, false));
  }
  
  public void L(MessageSource paramMessageSource)
  {
    int i = this.d.indexOf(paramMessageSource);
    if (i >= 0)
    {
      this.d.remove(i);
      u(i);
    }
  }
  
  public void M(p<MessageSource> paramp)
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
    this.e.C0((MessageSource)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e4.c
 * JD-Core Version:    0.7.0.1
 */