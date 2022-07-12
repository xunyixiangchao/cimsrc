package t4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.ui.GroupMessageSearchActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.model.MessageSearchHit;
import com.farsunset.hoxin.message.ui.MessageSearchActivity;
import k3.h;
import u3.b0;
import u3.l;

public class g
  extends a<MessageSearchHit, v4.b>
{
  public void M(v4.b paramb, MessageSearchHit paramMessageSearchHit)
  {
    Object localObject = paramMessageSearchHit.session;
    if (((ChatSession)localObject).sourceType == 1)
    {
      paramb.u.setTextColor(androidx.core.content.b.b(paramb.a.getContext(), 2131034730));
      paramb.v.p(b0.l(((ChatSession)localObject).sourceId), 2131165495);
    }
    if (((ChatSession)localObject).sourceType == 2)
    {
      paramb.u.setTextColor(androidx.core.content.b.b(paramb.a.getContext(), 17170450));
      paramb.v.l(l.A(((ChatSession)localObject).sourceId));
    }
    if (((ChatSession)localObject).sourceType == 4)
    {
      paramb.u.setTextColor(androidx.core.content.b.b(paramb.a.getContext(), 2131034729));
      paramb.v.p(b0.j(((ChatSession)localObject).sourceId), 2131165495);
    }
    paramb.u.setText(paramMessageSearchHit.session.name);
    localObject = paramb.a.getResources().getString(2131689650, new Object[] { Long.valueOf(paramMessageSearchHit.count), this.e });
    paramb.x.setText(l.U((String)localObject, this.e));
    paramb.y.setText(l.V(paramMessageSearchHit.timestamp));
  }
  
  public v4.b N(ViewGroup paramViewGroup, int paramInt)
  {
    return new v4.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427449, paramViewGroup, false));
  }
  
  public void O(Context paramContext, MessageSearchHit paramMessageSearchHit)
  {
    if (paramMessageSearchHit.session.sourceType == 2) {
      localObject = GroupMessageSearchActivity.class;
    } else {
      localObject = MessageSearchActivity.class;
    }
    Object localObject = new Intent(paramContext, (Class)localObject);
    ((Intent)localObject).putExtra("ATTR_CHAT_SESSION", paramMessageSearchHit.session);
    ((Intent)localObject).putExtra("ATTR_KEYWORD", this.e);
    ((Intent)localObject).putExtra("ATTR_SOURCE", this.e);
    paramContext.startActivity((Intent)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.g
 * JD-Core Version:    0.7.0.1
 */