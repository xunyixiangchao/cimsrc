package l4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.widget.GroupLogoView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.ui.GroupChatActivity;
import i3.e;
import java.util.ArrayList;
import java.util.List;
import p4.b;
import u3.d;

public class a
  extends RecyclerView.h<m4.a>
  implements View.OnClickListener
{
  private final List<Group> d = new ArrayList();
  
  public void I(List<Group> paramList)
  {
    int i = this.d.size();
    this.d.addAll(paramList);
    s(i, paramList.size());
  }
  
  public void J()
  {
    t(0, this.d.size());
    this.d.clear();
  }
  
  public void K(m4.a parama, int paramInt)
  {
    Group localGroup = (Group)this.d.get(paramInt);
    parama.u.setText(localGroup.name);
    Object localObject = parama.v;
    long l = localGroup.id;
    ((GroupLogoView)localObject).e(l, b.n(l, 9));
    localObject = parama.w;
    if (e.o().longValue() == localGroup.uid) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((View)localObject).setVisibility(paramInt);
    parama.x.setVisibility(8);
    if (d.s(Long.valueOf(localGroup.id)))
    {
      parama.x.setImageResource(2131165429);
      parama.x.setVisibility(0);
    }
    if (p4.a.i(Long.valueOf(localGroup.id)))
    {
      parama.x.setImageResource(2131165547);
      parama.x.setVisibility(0);
    }
    parama.a.setOnClickListener(this);
    parama.a.setTag(localGroup);
  }
  
  public m4.a L(ViewGroup paramViewGroup, int paramInt)
  {
    return new m4.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427500, paramViewGroup, false));
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
    Intent localIntent = new Intent(paramView.getContext(), GroupChatActivity.class);
    localIntent.putExtra("ATTR_CHAT_SESSION", ChatSession.of((Group)paramView.getTag()));
    paramView.getContext().startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l4.a
 * JD-Core Version:    0.7.0.1
 */