package e4;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.FriendRequestActivity;
import com.farsunset.hoxin.message.entity.Message;
import f4.c;
import i4.a;
import java.util.ArrayList;
import java.util.List;
import u3.b0;
import u3.j0;
import u3.l;

public class b
  extends RecyclerView.h<c>
  implements View.OnClickListener, View.OnLongClickListener
{
  private final List<Message> d = new ArrayList();
  private Message e;
  
  public void I(Message paramMessage)
  {
    this.d.add(0, paramMessage);
    p(0);
  }
  
  public void J(List<Message> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public Message K()
  {
    return this.e;
  }
  
  public void L(Message paramMessage)
  {
    int i = this.d.indexOf(paramMessage);
    if (i < 0) {
      return;
    }
    this.d.remove(i);
    u(i);
  }
  
  public void M(c paramc, int paramInt)
  {
    Message localMessage = (Message)this.d.get(paramInt);
    paramc.u.setText(a.k(localMessage.sender.longValue()));
    paramc.v.p(b0.l(localMessage.sender.longValue()), 2131165495);
    if (TextUtils.isEmpty(localMessage.content))
    {
      String str = a.k(localMessage.sender.longValue());
      paramc.w.setText(l.J(2131689640, new Object[] { str }));
    }
    else
    {
      paramc.w.setText(localMessage.content);
    }
    paramc.x.setTag(localMessage);
    paramc.a.setTag(localMessage);
    paramc.a.setOnClickListener(this);
    paramc.a.setOnLongClickListener(this);
    paramc.x.setEnabled(false);
    if ((localMessage.state.byteValue() == 11) || (localMessage.state.byteValue() == 10))
    {
      paramc.x.setEnabled(true);
      paramc.x.setOnClickListener(this);
      paramc.x.setText(2131689535);
    }
    if (localMessage.state.byteValue() == 14) {
      paramc.x.setText(2131689536);
    }
  }
  
  public c N(ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427511, paramViewGroup, false));
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
    Object localObject = (Message)paramView.getTag();
    Friend localFriend = a.l(((Message)localObject).sender.longValue());
    if (localFriend != null)
    {
      int i = localFriend.type;
      if ((i != 0) && (i != 2))
      {
        localObject = new Intent(paramView.getContext(), FriendRequestActivity.class);
        ((Intent)localObject).putExtra(Message.class.getName(), (Message)paramView.getTag());
        ((Activity)paramView.getContext()).startActivityForResult((Intent)localObject, 0);
        return;
      }
    }
    j0.a(paramView.getContext(), ((Message)localObject).sender.longValue());
  }
  
  public boolean onLongClick(View paramView)
  {
    this.e = ((Message)paramView.getTag());
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e4.b
 * JD-Core Version:    0.7.0.1
 */