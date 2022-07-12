package b5;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.widget.BaseMicroServerFromView;
import com.farsunset.hoxin.micro.widget.MicroServerToTextView;
import java.util.List;
import java.util.Objects;
import u3.l;

public class h
  extends a<u5.a>
{
  public h(ChatSession paramChatSession)
  {
    super(paramChatSession);
  }
  
  public void Q(u5.a parama, long paramLong)
  {
    parama.w.setText(l.V(paramLong));
  }
  
  public void R(u5.a parama, Message paramMessage)
  {
    Object localObject = parama.u;
    if (localObject != null)
    {
      ((MicroServerToTextView)localObject).e(paramMessage, this.f);
      parama.u.setOnMessageOperationListener(this);
      return;
    }
    localObject = parama.v;
    if (localObject != null)
    {
      ((BaseMicroServerFromView)localObject).d(paramMessage, this.f);
      parama.v.setOnMessageOperationListener(this);
    }
  }
  
  public u5.a S(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new u5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427572, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new u5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427568, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new u5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427564, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new u5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427567, paramViewGroup, false));
    }
    return new u5.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427549, paramViewGroup, false));
  }
  
  public int f(int paramInt)
  {
    Object localObject = this.d.get(paramInt);
    if ((localObject instanceof Long)) {
      return -1;
    }
    localObject = (Message)localObject;
    boolean bool = Objects.equals(Byte.valueOf(((Message)localObject).direction), Byte.valueOf((byte)1));
    if ((!bool) && (((Message)localObject).isTextFormat())) {
      return 1;
    }
    if ((!bool) && (((Message)localObject).isLinkFormat())) {
      return 2;
    }
    if ((!bool) && (((Message)localObject).isLinkListFormat())) {
      return 3;
    }
    return 0;
  }
  
  public void l(Message paramMessage) {}
  
  public void n(Message paramMessage) {}
  
  public void o(Message paramMessage) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.h
 * JD-Core Version:    0.7.0.1
 */