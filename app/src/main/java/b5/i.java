package b5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import java.util.ArrayList;
import java.util.List;
import k3.g;
import s3.p;
import u3.b0;
import u3.l;

public class i
  extends RecyclerView.h<g>
  implements View.OnClickListener
{
  private final List<ChatSession> d = new ArrayList();
  private p<ChatSession> e;
  
  public void I(ChatSession paramChatSession)
  {
    this.d.add(paramChatSession);
    p(this.d.size() - 1);
  }
  
  public void J(g paramg, int paramInt)
  {
    ChatSession localChatSession = (ChatSession)this.d.get(paramInt);
    paramg.a.setTag(localChatSession);
    paramg.a.setOnClickListener(this);
    paramInt = localChatSession.sourceType;
    paramg = paramg.u;
    if (paramInt == 2)
    {
      paramg.l(l.A(localChatSession.sourceId));
      return;
    }
    paramg.p(b0.l(localChatSession.sourceId), 2131165495);
  }
  
  public g K(ViewGroup paramViewGroup, int paramInt)
  {
    return new g(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427528, paramViewGroup, false));
  }
  
  public void L(ChatSession paramChatSession)
  {
    int i = this.d.indexOf(paramChatSession);
    if (i >= 0)
    {
      this.d.remove(i);
      u(i);
    }
  }
  
  public void M(p<ChatSession> paramp)
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
    this.e.C0((ChatSession)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.i
 * JD-Core Version:    0.7.0.1
 */