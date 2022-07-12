package e5;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import d5.c;
import r5.b;
import u3.g0;
import u3.l;

public class a
  extends f<c>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public void M(c paramc, Message paramMessage)
  {
    paramMessage = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
    paramc.z.setText(ca.a.a(paramMessage.size));
    paramc.x.setText(l.U(paramMessage.name, this.e));
    paramc.y.setImageResource(g0.e(paramMessage.name));
  }
  
  public c N(ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427523, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.a
 * JD-Core Version:    0.7.0.1
 */