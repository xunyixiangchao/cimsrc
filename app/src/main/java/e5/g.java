package e5;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.message.entity.Message;
import d5.j;
import r5.b;
import u3.l;

public class g
  extends f<j>
{
  public g(b paramb)
  {
    super(paramb);
  }
  
  public void M(j paramj, Message paramMessage)
  {
    paramj.x.setText(l.U(paramMessage.content.replaceAll("\n", "").trim(), this.e));
  }
  
  public j N(ViewGroup paramViewGroup, int paramInt)
  {
    return new j(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427526, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.g
 * JD-Core Version:    0.7.0.1
 */