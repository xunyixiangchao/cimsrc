package t4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.farsunset.hoxin.micro.ui.MicroServerWindowActivity;
import u3.b0;
import u3.l;

public class h
  extends a<MicroServer, k3.h>
{
  public void M(k3.h paramh, MicroServer paramMicroServer)
  {
    paramh.v.p(b0.j(paramMicroServer.id), 2131165495);
    paramh.u.setText(l.U(paramMicroServer.name, this.e));
  }
  
  public k3.h N(ViewGroup paramViewGroup, int paramInt)
  {
    return new k3.h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427447, paramViewGroup, false));
  }
  
  public void O(Context paramContext, MicroServer paramMicroServer)
  {
    Intent localIntent = new Intent(paramContext, MicroServerWindowActivity.class);
    localIntent.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramMicroServer));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.h
 * JD-Core Version:    0.7.0.1
 */