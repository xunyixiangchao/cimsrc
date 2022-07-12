package b5;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.widget.RecentSessionView;
import d5.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o3.c;

public class d
  extends RecyclerView.h<h>
  implements View.OnTouchListener, View.OnLongClickListener, View.OnClickListener
{
  private z4.a d;
  private final List<ChatSession> e = new ArrayList();
  
  public void I(List<ChatSession> paramList)
  {
    this.e.clear();
    this.e.addAll(paramList);
    super.j();
  }
  
  public boolean J()
  {
    return this.e.isEmpty();
  }
  
  public void K(ChatSession paramChatSession)
  {
    if (paramChatSession == null) {
      return;
    }
    if (paramChatSession.visible == c.b.a())
    {
      M(paramChatSession);
      return;
    }
    int i = this.e.indexOf(paramChatSession);
    List localList = this.e;
    if (i == -1) {
      localList.add(paramChatSession);
    } else {
      localList.set(i, paramChatSession);
    }
    Collections.sort(this.e, new u4.a());
    int j = this.e.indexOf(paramChatSession);
    if (i == -1)
    {
      p(j);
      return;
    }
    if (i == j)
    {
      k(i);
      return;
    }
    q(i, j);
    k(j);
  }
  
  public void L(ChatSession paramChatSession)
  {
    int i = this.e.indexOf(paramChatSession);
    if (i >= 0)
    {
      ((ChatSession)this.e.get(i)).name = paramChatSession.name;
      super.k(i);
    }
  }
  
  public void M(ChatSession paramChatSession)
  {
    int i = this.e.indexOf(paramChatSession);
    if (i >= 0)
    {
      this.e.remove(i);
      u(i);
    }
  }
  
  public void N(h paramh, int paramInt)
  {
    ChatSession localChatSession = (ChatSession)this.e.get(paramInt);
    paramh.u.setOnClickListener(this);
    paramh.u.setOnLongClickListener(this);
    paramh.u.setOnTouchListener(this);
    if (localChatSession.priority > 0L) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    RecentSessionView localRecentSessionView = paramh.u;
    if (paramInt != 0) {
      paramInt = 2131165324;
    } else {
      paramInt = 2131165278;
    }
    localRecentSessionView.setBackgroundResource(paramInt);
    paramh.u.a(localChatSession);
  }
  
  public h O(ViewGroup paramViewGroup, int paramInt)
  {
    if (1 == paramInt) {
      return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427519, paramViewGroup, false));
    }
    if (2 == paramInt) {
      return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427521, paramViewGroup, false));
    }
    if (3 == paramInt) {
      return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427518, paramViewGroup, false));
    }
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427520, paramViewGroup, false));
  }
  
  public void P(z4.a parama)
  {
    this.d = parama;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public long e(int paramInt)
  {
    return paramInt;
  }
  
  public int f(int paramInt)
  {
    paramInt = ((ChatSession)this.e.get(paramInt)).sourceType;
    if (paramInt == 2) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 4) {
      return 3;
    }
    return 4;
  }
  
  public void onClick(View paramView)
  {
    this.d.k((ChatSession)paramView.getTag());
  }
  
  public boolean onLongClick(View paramView)
  {
    this.d.d((ChatSession)paramView.getTag());
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.setTag(2131231638, Float.valueOf(paramMotionEvent.getX()));
    paramView.setTag(2131231641, Float.valueOf(paramMotionEvent.getY()));
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.d
 * JD-Core Version:    0.7.0.1
 */