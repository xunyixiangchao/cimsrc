package e5;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import d5.g;
import i3.e;
import java.util.List;
import u3.b0;
import u3.l;

public abstract class f<T extends g>
  extends RecyclerView.h<T>
  implements View.OnClickListener
{
  protected List<Message> d;
  protected String e;
  private final r5.b f;
  
  public f(r5.b paramb)
  {
    this.f = paramb;
  }
  
  public void I(List<Message> paramList)
  {
    this.d = paramList;
  }
  
  public void J(List<Message> paramList, String paramString)
  {
    this.d = paramList;
    this.e = paramString;
  }
  
  public abstract void K(T paramT, Message paramMessage);
  
  public void L(T paramT, int paramInt)
  {
    Message localMessage = (Message)this.d.get(paramInt);
    if (localMessage.action.equals("0"))
    {
      paramT.v.p(b0.l(localMessage.sender.longValue()), 2131165495);
      paramT.w.setText(e.k(localMessage.sender.longValue()));
    }
    if ((localMessage.action.equals("3")) && (localMessage.direction == 0))
    {
      paramT.v.p(b0.m(localMessage.extra), 2131165495);
      paramT.w.setText(p4.b.l(localMessage.sender, Long.valueOf(Long.parseLong(localMessage.extra))));
    }
    if ((localMessage.action.equals("3")) && (localMessage.direction == 1))
    {
      paramT.v.p(b0.l(localMessage.sender.longValue()), 2131165495);
      paramT.w.setText(e.j());
    }
    paramT.u.setText(l.V(localMessage.createTime.longValue()));
    paramT.a.setOnClickListener(this);
    paramT.a.setTag(localMessage);
    K(paramT, localMessage);
  }
  
  public int d()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onClick(View paramView)
  {
    this.f.L((Message)paramView.getTag());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.f
 * JD-Core Version:    0.7.0.1
 */