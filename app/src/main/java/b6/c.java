package b6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.entity.Comment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s3.p;
import u3.b0;
import u3.l;

public class c
  extends RecyclerView.h<c6.c>
  implements View.OnClickListener, View.OnLongClickListener
{
  private final List<Message> d = new ArrayList();
  private p<Comment> e;
  private Message f;
  
  public void I(List<Message> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Message localMessage = (Message)paramList.next();
      if (g6.a.h(Long.parseLong(localMessage.content)) != null) {
        this.d.add(localMessage);
      }
    }
    super.j();
  }
  
  public Message J()
  {
    return this.f;
  }
  
  public void K(Message paramMessage)
  {
    int i = this.d.indexOf(paramMessage);
    if (i >= 0)
    {
      this.d.remove(i);
      u(i);
    }
  }
  
  public void L(c6.c paramc, int paramInt)
  {
    Message localMessage = (Message)this.d.get(paramInt);
    Comment localComment = g6.a.h(Long.parseLong(localMessage.content));
    paramc.x.p(b0.l(localComment.uid), 2131165495);
    paramc.w.setText(i4.a.k(localComment.uid));
    paramc.u.setText(l.V(localComment.createTime.longValue()));
    paramc.a.setOnClickListener(this);
    paramc.a.setOnLongClickListener(this);
    paramc.a.setTag(localComment);
    paramc.a.setTag(2131231522, localMessage);
    boolean bool = "2".equals(localComment.type);
    paramc = paramc.v;
    if (bool)
    {
      paramc.setText(2131690091);
      return;
    }
    paramc.setText(l.W(localComment.content));
  }
  
  public c6.c M(ViewGroup paramViewGroup, int paramInt)
  {
    return new c6.c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427509, paramViewGroup, false));
  }
  
  public void N(p<Comment> paramp)
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
    this.e.C0((Comment)paramView.getTag(), paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.f = ((Message)paramView.getTag(2131231522));
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.c
 * JD-Core Version:    0.7.0.1
 */