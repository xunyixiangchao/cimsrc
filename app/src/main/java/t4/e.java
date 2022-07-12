package t4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.UserDetailedActivity;
import k3.h;
import u3.b0;
import u3.l;

public class e
  extends a<Friend, v4.a>
{
  public void M(v4.a parama, Friend paramFriend)
  {
    parama.v.p(b0.l(paramFriend.id), 2131165495);
    View localView = parama.w;
    int i = paramFriend.type;
    if ((i != 2) && (i != 1)) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    parama.u.setText(l.U(paramFriend.name, this.e));
    parama.x.setText(l.U(paramFriend.telephone, this.e));
  }
  
  public v4.a N(ViewGroup paramViewGroup, int paramInt)
  {
    return new v4.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427447, paramViewGroup, false));
  }
  
  public void O(Context paramContext, Friend paramFriend)
  {
    Intent localIntent = new Intent(paramContext, UserDetailedActivity.class);
    localIntent.putExtra(Friend.class.getName(), paramFriend);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.e
 * JD-Core Version:    0.7.0.1
 */