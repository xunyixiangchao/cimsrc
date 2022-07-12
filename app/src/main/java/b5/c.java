package b5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.widget.BaseFromMessageView;
import com.farsunset.hoxin.message.widget.BaseToMessageView;
import com.farsunset.hoxin.message.widget.ChattingTipsMessageView;
import i5.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import u3.l;

public class c
  extends a<d5.a>
{
  private ViewGroup g;
  
  public c(ChatSession paramChatSession)
  {
    super(paramChatSession);
  }
  
  public List<Message> Q()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof Message))
      {
        localObject = (Message)localObject;
        if ((((Message)localObject).format == 1) && (((Message)localObject).state.byteValue() != 13) && (((Message)localObject).state.byteValue() != 6)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void R(d5.a parama, long paramLong)
  {
    parama.w.setText(l.V(paramLong));
  }
  
  public void S(d5.a parama, Message paramMessage)
  {
    Object localObject = parama.u;
    if (localObject != null)
    {
      ((BaseToMessageView)localObject).g(paramMessage, this.e.id, this.f);
      parama.u.setOnMessageOperationListener(this);
    }
    localObject = parama.v;
    if (localObject != null)
    {
      ((BaseFromMessageView)localObject).d(paramMessage, this.f);
      parama.v.setOnMessageOperationListener(this);
    }
    parama = parama.x;
    if (parama != null) {
      parama.k(paramMessage);
    }
  }
  
  public d5.a T(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.g == null) {
      this.g = paramViewGroup;
    }
    if (paramInt == -2) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427551, paramViewGroup, false));
    }
    if (paramInt == 0) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427475, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427471, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427477, paramViewGroup, false));
    }
    if (paramInt == 4) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427470, paramViewGroup, false));
    }
    if (paramInt == 5) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427473, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427476, paramViewGroup, false));
    }
    if ((paramInt != 14) && (paramInt != 18))
    {
      if (paramInt == 15) {
        return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427469, paramViewGroup, false));
      }
      if ((paramInt != 16) && (paramInt != 17))
      {
        if (paramInt == 6) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427472, paramViewGroup, false));
        }
        if (paramInt == 9999) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427465, paramViewGroup, false));
        }
        if (paramInt == 10000) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427461, paramViewGroup, false));
        }
        if (paramInt == 10001) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427467, paramViewGroup, false));
        }
        if (paramInt == 10003) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427460, paramViewGroup, false));
        }
        if (paramInt == 10004) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427463, paramViewGroup, false));
        }
        if (paramInt == 10002) {
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427466, paramViewGroup, false));
        }
        if ((paramInt != 10013) && (paramInt != 10017))
        {
          if (paramInt == 10014) {
            return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427459, paramViewGroup, false));
          }
          if ((paramInt != 10015) && (paramInt != 10016))
          {
            if (paramInt == 10005) {
              return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427462, paramViewGroup, false));
            }
            return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427549, paramViewGroup, false));
          }
          return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427458, paramViewGroup, false));
        }
        return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427464, paramViewGroup, false));
      }
      return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427468, paramViewGroup, false));
    }
    return new d5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427474, paramViewGroup, false));
  }
  
  public void U(long paramLong)
  {
    Message localMessage = new Message();
    localMessage.id = paramLong;
    int i = this.d.indexOf(localMessage);
    if (i >= 0) {
      localObject = this.d.get(i);
    } else {
      localObject = null;
    }
    if ((localObject instanceof Message)) {
      ((Message)localObject).state = Byte.valueOf((byte)5);
    }
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = (BaseToMessageView)((ViewGroup)localObject).findViewWithTag(localMessage);
    if (localObject != null) {
      ((BaseToMessageView)localObject).o();
    }
  }
  
  public int f(int paramInt)
  {
    Object localObject = this.d.get(paramInt);
    if ((localObject instanceof Long)) {
      return -1;
    }
    localObject = (Message)localObject;
    if ((!i5.c.a.contains(((Message)localObject).state)) && (!b.a.contains(Byte.valueOf(((Message)localObject).format))))
    {
      boolean bool = Objects.equals(Byte.valueOf(((Message)localObject).direction), Byte.valueOf((byte)1));
      paramInt = ((Message)localObject).format;
      if (bool) {
        return paramInt;
      }
      return paramInt + 9999;
    }
    return -2;
  }
  
  public void l(Message paramMessage)
  {
    Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_QUOTE_MESSAGE");
    localIntent.putExtra(Message.NAME, paramMessage);
    HoxinApplication.t(localIntent);
  }
  
  public void n(Message paramMessage)
  {
    int i = this.d.indexOf(paramMessage);
    if (i >= 0) {
      k(i);
    }
  }
  
  public void o(Message paramMessage) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.c
 * JD-Core Version:    0.7.0.1
 */